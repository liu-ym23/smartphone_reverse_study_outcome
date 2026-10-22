package com.bytedance.apm.agent.v2.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentTimeAgent {
    private static final String TAG = "FragmentTimeAgent";
    private static long sCheckVisibilityStartTime = 0;
    private static String sFragmentName = null;
    private static long sMaxWaitTime = 60000;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static long sOnCreateStart;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static boolean sReported;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r10 = FragmentTimeAgent.access$100().contains(FragmentTimeAgent.access$000());
            FragmentTimeAgent.access$100().add(FragmentTimeAgent.access$000());
            FragmentTimeAgent.access$200(r10, null, 0, 0);
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f736c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f737g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f738h;

        b(String r10, long r11, long r12) {
            this.f736c = r10;
            this.f737g = r11;
            this.f738h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r10 = FragmentTimeAgent.access$100().contains(FragmentTimeAgent.access$000());
            FragmentTimeAgent.access$100().add(FragmentTimeAgent.access$000());
            FragmentTimeAgent.access$200(r10, this.f736c, this.f737g, this.f738h);
        }
    }

    static class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Integer f739c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f740g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f741h;

        c(Integer r10, long r11, String r12) {
            this.f739c = r10;
            this.f740g = r11;
            this.f741h = r12;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (FragmentTimeAgent.access$300() != null) goto L5;
            return;
        L5:
            if (FragmentTimeAgent.access$300().get() == null) goto L33;
            View r10 = ((View) FragmentTimeAgent.access$300().get()).findViewById(this.f739c.intValue());     // Catch: Exception -> L29
            if (FragmentTimeAgent.access$400() != 0) goto L10;
            FragmentTimeAgent.access$402(System.currentTimeMillis());     // Catch: Exception -> L29
        L10:
            if (r10 != null) goto L12;
            return;
        L12:
            if (r10.getVisibility() == 0) goto L14;
            return;
        L14:
            if (r10.getWidth() <= 0) goto L36;
            long r11 = System.currentTimeMillis();     // Catch: Exception -> L29
            if (((View) FragmentTimeAgent.access$300().get()).getViewTreeObserver().isAlive() == true) goto L18;
        L20:
            FragmentTimeAgent.access$502(null);     // Catch: Exception -> L29
            FragmentTimeAgent.access$302(null);     // Catch: Exception -> L29
            if (FragmentTimeAgent.access$600() == null) goto L23;
            q0.a.a().removeCallbacks(FragmentTimeAgent.access$600());     // Catch: Exception -> L29
        L23:
            long r12 = r11 - this.f740g;     // Catch: Exception -> L29
            if ((r11 - FragmentTimeAgent.access$400()) > 1) goto L26;
            return;
        L26:
            if (r12 >= FragmentTimeAgent.access$700()) goto L38;
            FragmentTimeAgent.access$800(FragmentTimeAgent.access$000(), this.f741h, this.f740g, r11);     // Catch: Exception -> L29
            return;
        L38:
            return;
        L18:
            if (FragmentTimeAgent.access$500() == null) goto L20;
            ((View) FragmentTimeAgent.access$300().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentTimeAgent.access$500());     // Catch: Exception -> L29
            goto L20
        L36:
            return;
        L33:
            return;
        }
    }

    static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (FragmentTimeAgent.access$500() != null) goto L5;
            return;
        L5:
            if (FragmentTimeAgent.access$300() != null) goto L7;
            return;
        L7:
            if (FragmentTimeAgent.access$300().get() == null) goto L15;
            ((View) FragmentTimeAgent.access$300().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentTimeAgent.access$500());     // Catch: Exception -> L10
            return;
        L15:
            return;
        }
    }

    static {
        sMethodSet = new HashSet(32);
    }

    public FragmentTimeAgent() {
    }

    static /* synthetic */ String access$000() {
        return sFragmentName;
    }

    static /* synthetic */ HashSet access$100() {
        return sMethodSet;
    }

    static /* synthetic */ void access$200(boolean r10, String r11, long r12, long r13) {
        reportStats(r10, r11, r12, r13);
    }

    static /* synthetic */ WeakReference access$300() {
        return sRootViewRef;
    }

    static /* synthetic */ WeakReference access$302(WeakReference r10) {
        sRootViewRef = r10;
        return r10;
    }

    static /* synthetic */ long access$400() {
        return sCheckVisibilityStartTime;
    }

    static /* synthetic */ long access$402(long r10) {
        sCheckVisibilityStartTime = r10;
        return r10;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$500() {
        return sOnGlobalLayoutListener;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$502(ViewTreeObserver.OnGlobalLayoutListener r10) {
        sOnGlobalLayoutListener = r10;
        return r10;
    }

    static /* synthetic */ Runnable access$600() {
        return sWaitViewTimeoutRunnable;
    }

    static /* synthetic */ long access$700() {
        return sMaxWaitTime;
    }

    static /* synthetic */ void access$800(String r10, String r11, long r12, long r13) {
        reportTraceTime(r10, r11, r12, r13);
    }

    private static boolean isValid(String r10) {
        if (sReported == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r10, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onHiddenChanged(Fragment r10, boolean r11) {
        if (r11 == false) goto L12;
        return;
    L12:
        String r12 = r10.getClass().getCanonicalName();     // Catch: Exception -> L11
        Integer r13 = t0.a.c(r12);     // Catch: Exception -> L11
        if (r13 != null) goto L7;
        return;
    L7:
        if (r13.intValue() <= 0) goto L15;
        registerOnGlobalLayoutListener(r12, r10.getView(), r13, System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    public static void onResumeShow(Fragment r10, String r11) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L20;
        Integer r12 = t0.a.c(r11);     // Catch: Exception -> L14
        if (r12 != null) goto L10;
        return;
    L10:
        if (r12.intValue() <= 0) goto L19;
        registerOnGlobalLayoutListener(r11, r10.getView(), r12, sOnCreateStart, "fragmentOnCreateToViewShow");     // Catch: Exception -> L14
        return;
    L19:
        return;
    L21:
        return;
    }

    @Keep
    public static void onTrace(Fragment r10, String r11, String r12, boolean r13) {
        if (TextUtils.equals("onCreate", r12) == false) goto L13;
        if (r13 == false) goto L10;
        sFragmentName = r11;
        sOnCreateStart = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L8;
        sMaxWaitTime = ApmDelegate.j().h().i();
    L8:
        sReported = false;
        return;
    L10:
        if (isValid(r11) == false) goto L54;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L54:
        return;
    L13:
        if (TextUtils.equals("onViewCreated", r12) == false) goto L23;
        if (isValid(r11) == false) goto L23;
        long r14 = sOnCreateStart;
        if (r13 == false) goto L20;
        if (r14 <= 0) goto L56;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L56:
        return;
    L20:
        if (r14 <= 0) goto L58;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L58:
        return;
    L23:
        if (TextUtils.equals("onActivityCreated", r12) == false) goto L33;
        if (isValid(r11) == false) goto L33;
        long r15 = sOnCreateStart;
        if (r13 == false) goto L30;
        if (r15 <= 0) goto L60;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L60:
        return;
    L30:
        if (r15 <= 0) goto L62;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L62:
        return;
    L33:
        if (TextUtils.equals("onResume", r12) == true) goto L35;
        return;
    L35:
        if (isValid(r11) == false) goto L65;
        if (r13 == false) goto L41;
        if (sOnCreateStart <= 0) goto L66;
        sOnResumeStart = System.currentTimeMillis();
        onResumeShow(r10, r11);
        return;
    L66:
        return;
    L41:
        if (sOnCreateStart <= 0) goto L68;
        sOnResumeEnd = System.currentTimeMillis();
        Integer r16 = t0.a.c(r11);     // Catch: Exception -> L50
        if (r16 != null) goto L46;
    L47:
        q0.b.f().i(new a());     // Catch: Exception -> L50
        goto L48
    L46:
        if (r16.intValue() <= 0) goto L47;
    L48:
        sReported = true;
        sFragmentName = null;
        return;
    L68:
        return;
    }

    @TargetApi(16)
    private static void registerOnGlobalLayoutListener(String r10, View r11, Integer r12, long r13, String r14) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.intValue() <= 0) goto L21;
        sFragmentName = r10;
        WeakReference<View> r15 = sRootViewRef;
        if (r15 != null) goto L9;
    L18:
        sRootViewRef = new WeakReference(r11);
        sCheckVisibilityStartTime = 0;
        sOnGlobalLayoutListener = new c(r12, r13, r14);
        r11.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new d();
        q0.a.a().postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
        return;
    L9:
        if (r15.get() == r11) goto L18;
        ViewTreeObserver r16 = sRootViewRef.get().getViewTreeObserver();
        if (r16.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r17 = sOnGlobalLayoutListener;
        if (r17 == null) goto L16;
        r16.removeOnGlobalLayoutListener(r17);
    L16:
        if (sWaitViewTimeoutRunnable == null) goto L18;
        q0.a.a().removeCallbacks(sWaitViewTimeoutRunnable);
        goto L18
    }

    private static void reportStats(boolean r10, String r11, long r12, long r13) {
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L12
        r14.put(ActivityLifecycle.NAME, "onCreate");     // Catch: Exception -> L12
        r14.put(CommonConsts.APM_INNER_EVENT_COST_START, sOnCreateStart);     // Catch: Exception -> L12
        r14.put("end", sOnCreateEnd);     // Catch: Exception -> L12
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L12
        r15.put(ActivityLifecycle.NAME, "onViewCreated");     // Catch: Exception -> L12
        r15.put(CommonConsts.APM_INNER_EVENT_COST_START, sOnViewCreatedStart);     // Catch: Exception -> L12
        r15.put("end", sOnViewCreatedEnd);     // Catch: Exception -> L12
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L12
        r16.put(ActivityLifecycle.NAME, "onActivityCreated");     // Catch: Exception -> L12
        r16.put(CommonConsts.APM_INNER_EVENT_COST_START, sOnActivityCreatedStart);     // Catch: Exception -> L12
        r16.put("end", sOnActivityCreatedEnd);     // Catch: Exception -> L12
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L12
        r17.put(ActivityLifecycle.NAME, "onResume");     // Catch: Exception -> L12
        r17.put(CommonConsts.APM_INNER_EVENT_COST_START, sOnResumeStart);     // Catch: Exception -> L12
        r17.put("end", sOnResumeEnd);     // Catch: Exception -> L12
        JSONArray r18 = new JSONArray();     // Catch: Exception -> L12
        r18.put(r14);     // Catch: Exception -> L12
        r18.put(r15);     // Catch: Exception -> L12
        r18.put(r16);     // Catch: Exception -> L12
        r18.put(r17);     // Catch: Exception -> L12
        if (r11 == null) goto L6;
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L12
        r19.put(ActivityLifecycle.NAME, r11);     // Catch: Exception -> L12
        r19.put(CommonConsts.APM_INNER_EVENT_COST_START, r12);     // Catch: Exception -> L12
        r19.put("end", r13);     // Catch: Exception -> L12
        r18.put(r19);     // Catch: Exception -> L12
    L6:
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L12
        r110.put(ActivityLifecycle.NAME, "page_load_stats");     // Catch: Exception -> L12
        r110.put("page_type", "fragment");     // Catch: Exception -> L12
        r110.put(CommonConsts.APM_INNER_EVENT_COST_START, sOnCreateStart);     // Catch: Exception -> L12
        r110.put("spans", r18);     // Catch: Exception -> L12
        if (r10 == false) goto L9;
        int r20 = 2;
    L10:
        r110.put(CrashBody.LAUNCH_MODE, r20);     // Catch: Exception -> L12
        r110.put("collect_from", 1);     // Catch: Exception -> L12
        r110.put("page_name", sFragmentName);     // Catch: Exception -> L12
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L12
        r21.put("trace", r110);     // Catch: Exception -> L12
        f.a.a("page_load_trace", null, null, r21);     // Catch: Exception -> L12
        return;
    L9:
        r20 = 1;
    L12:
        e = move-exception;
        if (com.bytedance.apm.d.D() == false) goto L19;
        e.printStackTrace();
        return;
    }

    private static void reportTraceTime(String r10, String r11, long r12, long r13) {
        q0.b.f().i(new b(r11, r12, r13));
    }

    @Keep
    public static void setUserVisibleHint(Fragment r10, boolean r11) {
        if (r11 == true) goto L4;
        return;
    L4:
        if (r10.isResumed() == true) goto L6;
        return;
    L6:
        if (r10.isHidden() == true) goto L22;
        String r12 = r10.getClass().getCanonicalName();     // Catch: Exception -> L15
        Integer r13 = t0.a.c(r12);     // Catch: Exception -> L15
        if (r13 != null) goto L11;
        return;
    L11:
        if (r13.intValue() <= 0) goto L21;
        registerOnGlobalLayoutListener(r12, r10.getView(), r13, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L15
        return;
    L21:
        return;
    L23:
        return;
    }
}
