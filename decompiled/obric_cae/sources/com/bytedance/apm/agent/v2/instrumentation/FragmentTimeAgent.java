package com.bytedance.apm.agent.v2.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import c2.k;
import com.bytedance.apm.internal.ApmDelegate;
import com.qualcomm.qti.qesdk.QesdkUtils;
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

    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            boolean r8 = FragmentTimeAgent.access$100().contains(FragmentTimeAgent.access$000());
            FragmentTimeAgent.access$100().add(FragmentTimeAgent.access$000());
            FragmentTimeAgent.access$200(r8, null, 0, 0);
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f3745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f3746b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ long f3747m;

        public b(String r8, long r10, long r11) {
            this.f3745a = r8;
            this.f3746b = r10;
            this.f3747m = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean r8 = FragmentTimeAgent.access$100().contains(FragmentTimeAgent.access$000());
            FragmentTimeAgent.access$100().add(FragmentTimeAgent.access$000());
            FragmentTimeAgent.access$200(r8, this.f3745a, this.f3746b, this.f3747m);
        }
    }

    public static class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Integer f3748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f3749b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f3750m;

        public c(Integer r8, long r10, String r11) {
            this.f3748a = r8;
            this.f3749b = r10;
            this.f3750m = r11;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (FragmentTimeAgent.access$300() != null) goto L5;
            return;
        L5:
            if (FragmentTimeAgent.access$300().get() == null) goto L33;
            View r8 = ((View) FragmentTimeAgent.access$300().get()).findViewById(this.f3748a.intValue());     // Catch: Exception -> L29
            if (FragmentTimeAgent.access$400() != 0) goto L10;
            FragmentTimeAgent.access$402(System.currentTimeMillis());     // Catch: Exception -> L29
        L10:
            if (r8 != null) goto L12;
            return;
        L12:
            if (r8.getVisibility() == 0) goto L14;
            return;
        L14:
            if (r8.getWidth() <= 0) goto L36;
            long r10 = System.currentTimeMillis();     // Catch: Exception -> L29
            if (((View) FragmentTimeAgent.access$300().get()).getViewTreeObserver().isAlive() == true) goto L18;
        L20:
            FragmentTimeAgent.access$502(null);     // Catch: Exception -> L29
            FragmentTimeAgent.access$302(null);     // Catch: Exception -> L29
            if (FragmentTimeAgent.access$600() == null) goto L23;
            b3.a.f3032a.removeCallbacks(FragmentTimeAgent.access$600());     // Catch: Exception -> L29
        L23:
            long r11 = r10 - this.f3749b;     // Catch: Exception -> L29
            if ((r10 - FragmentTimeAgent.access$400()) > 1) goto L26;
            return;
        L26:
            if (r11 >= FragmentTimeAgent.access$700()) goto L38;
            FragmentTimeAgent.access$800(FragmentTimeAgent.access$000(), this.f3750m, this.f3749b, r10);     // Catch: Exception -> L29
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

    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
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

    public static /* synthetic */ String access$000() {
        return sFragmentName;
    }

    public static /* synthetic */ HashSet access$100() {
        return sMethodSet;
    }

    public static /* synthetic */ void access$200(boolean r8, String r10, long r11, long r12) {
        reportStats(r8, r10, r11, r12);
    }

    public static /* synthetic */ WeakReference access$300() {
        return sRootViewRef;
    }

    public static /* synthetic */ WeakReference access$302(WeakReference r8) {
        sRootViewRef = r8;
        return r8;
    }

    public static /* synthetic */ long access$400() {
        return sCheckVisibilityStartTime;
    }

    public static /* synthetic */ long access$402(long r8) {
        sCheckVisibilityStartTime = r8;
        return r8;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$500() {
        return sOnGlobalLayoutListener;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$502(ViewTreeObserver.OnGlobalLayoutListener r8) {
        sOnGlobalLayoutListener = r8;
        return r8;
    }

    public static /* synthetic */ Runnable access$600() {
        return sWaitViewTimeoutRunnable;
    }

    public static /* synthetic */ long access$700() {
        return sMaxWaitTime;
    }

    public static /* synthetic */ void access$800(String r8, String r10, long r11, long r12) {
        reportTraceTime(r8, r10, r11, r12);
    }

    private static boolean isValid(String r8) {
        if (sReported == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r8, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onHiddenChanged(Fragment r8, boolean r10) {
        if (r10 == false) goto L12;
        return;
    L12:
        String r11 = r8.getClass().getCanonicalName();     // Catch: Exception -> L11
        Integer r12 = e3.a.a(r11);     // Catch: Exception -> L11
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.intValue() <= 0) goto L15;
        registerOnGlobalLayoutListener(r11, r8.getView(), r12, System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L11
        return;
    L15:
        return;
    }

    public static void onResumeShow(Fragment r8, String r10) {
        if (r8.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r8.isHidden() == true) goto L20;
        Integer r11 = e3.a.a(r10);     // Catch: Exception -> L14
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.intValue() <= 0) goto L19;
        registerOnGlobalLayoutListener(r10, r8.getView(), r11, sOnCreateStart, "fragmentOnCreateToViewShow");     // Catch: Exception -> L14
        return;
    L19:
        return;
    L21:
        return;
    }

    @Keep
    public static void onTrace(Fragment r8, String r10, String r11, boolean r12) {
        if (TextUtils.equals("onCreate", r11) == false) goto L13;
        if (r12 == false) goto L10;
        sFragmentName = r10;
        sOnCreateStart = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L8;
        ApmDelegate.a.f3770a.getClass();
        new j2.a(new j2.a.C0096a());
        sMaxWaitTime = 20000;
    L8:
        sReported = false;
        return;
    L10:
        if (isValid(r10) == false) goto L54;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L54:
        return;
    L13:
        if (TextUtils.equals("onViewCreated", r11) == false) goto L23;
        if (isValid(r10) == false) goto L23;
        long r13 = sOnCreateStart;
        if (r12 == false) goto L20;
        if (r13 <= 0) goto L56;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L56:
        return;
    L20:
        if (r13 <= 0) goto L58;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L58:
        return;
    L23:
        if (TextUtils.equals("onActivityCreated", r11) == false) goto L33;
        if (isValid(r10) == false) goto L33;
        long r14 = sOnCreateStart;
        if (r12 == false) goto L30;
        if (r14 <= 0) goto L60;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L60:
        return;
    L30:
        if (r14 <= 0) goto L62;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L62:
        return;
    L33:
        if (TextUtils.equals("onResume", r11) == true) goto L35;
        return;
    L35:
        if (isValid(r10) == false) goto L65;
        if (r12 == false) goto L41;
        if (sOnCreateStart <= 0) goto L66;
        sOnResumeStart = System.currentTimeMillis();
        onResumeShow(r8, r10);
        return;
    L66:
        return;
    L41:
        if (sOnCreateStart <= 0) goto L68;
        sOnResumeEnd = System.currentTimeMillis();
        Integer r15 = e3.a.a(r10);     // Catch: Exception -> L50
        if (r15 != null) goto L46;
    L47:
        b3.b.C0032b.f3038a.c(new a());     // Catch: Exception -> L50
        goto L48
    L46:
        if (r15.intValue() <= 0) goto L47;
    L48:
        sReported = true;
        sFragmentName = null;
        return;
    L68:
        return;
    }

    @TargetApi(16)
    private static void registerOnGlobalLayoutListener(String r8, View r10, Integer r11, long r12, String r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.intValue() <= 0) goto L21;
        sFragmentName = r8;
        WeakReference<View> r14 = sRootViewRef;
        if (r14 != null) goto L9;
    L18:
        sRootViewRef = new WeakReference(r10);
        sCheckVisibilityStartTime = 0;
        sOnGlobalLayoutListener = new c(r11, r12, r13);
        r10.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new d();
        b3.a.f3032a.postDelayed(sWaitViewTimeoutRunnable, sMaxWaitTime);
        return;
    L9:
        if (r14.get() == r10) goto L18;
        ViewTreeObserver r15 = sRootViewRef.get().getViewTreeObserver();
        if (r15.isAlive() == false) goto L16;
        ViewTreeObserver.OnGlobalLayoutListener r16 = sOnGlobalLayoutListener;
        if (r16 == null) goto L16;
        r15.removeOnGlobalLayoutListener(r16);
    L16:
        if (sWaitViewTimeoutRunnable == null) goto L18;
        b3.a.f3032a.removeCallbacks(sWaitViewTimeoutRunnable);
        goto L18
    }

    private static void reportStats(boolean r10, String r11, long r12, long r13) {
        JSONObject r8 = new JSONObject();     // Catch: Exception -> L12
        r8.put(QesdkUtils.TAGS.JSON_TAG_NAME, "onCreate");     // Catch: Exception -> L12
        r8.put("start", sOnCreateStart);     // Catch: Exception -> L12
        r8.put("end", sOnCreateEnd);     // Catch: Exception -> L12
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L12
        r14.put(QesdkUtils.TAGS.JSON_TAG_NAME, "onViewCreated");     // Catch: Exception -> L12
        r14.put("start", sOnViewCreatedStart);     // Catch: Exception -> L12
        r14.put("end", sOnViewCreatedEnd);     // Catch: Exception -> L12
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L12
        r15.put(QesdkUtils.TAGS.JSON_TAG_NAME, "onActivityCreated");     // Catch: Exception -> L12
        r15.put("start", sOnActivityCreatedStart);     // Catch: Exception -> L12
        r15.put("end", sOnActivityCreatedEnd);     // Catch: Exception -> L12
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L12
        r16.put(QesdkUtils.TAGS.JSON_TAG_NAME, "onResume");     // Catch: Exception -> L12
        r16.put("start", sOnResumeStart);     // Catch: Exception -> L12
        r16.put("end", sOnResumeEnd);     // Catch: Exception -> L12
        JSONArray r17 = new JSONArray();     // Catch: Exception -> L12
        r17.put(r8);     // Catch: Exception -> L12
        r17.put(r14);     // Catch: Exception -> L12
        r17.put(r15);     // Catch: Exception -> L12
        r17.put(r16);     // Catch: Exception -> L12
        if (r11 == null) goto L6;
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L12
        r18.put(QesdkUtils.TAGS.JSON_TAG_NAME, r11);     // Catch: Exception -> L12
        r18.put("start", r12);     // Catch: Exception -> L12
        r18.put("end", r13);     // Catch: Exception -> L12
        r17.put(r18);     // Catch: Exception -> L12
    L6:
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L12
        r19.put(QesdkUtils.TAGS.JSON_TAG_NAME, "page_load_stats");     // Catch: Exception -> L12
        r19.put("page_type", "fragment");     // Catch: Exception -> L12
        r19.put("start", sOnCreateStart);     // Catch: Exception -> L12
        r19.put("spans", r17);     // Catch: Exception -> L12
        if (r10 == false) goto L9;
        int r20 = 2;
    L10:
        r19.put("launch_mode", r20);     // Catch: Exception -> L12
        r19.put("collect_from", 1);     // Catch: Exception -> L12
        r19.put("page_name", sFragmentName);     // Catch: Exception -> L12
        JSONObject r21 = new JSONObject();     // Catch: Exception -> L12
        r21.put("trace", r19);     // Catch: Exception -> L12
        b3.b.C0032b.f3038a.c(new e2.b("page_load_trace", null, null, r21));     // Catch: Exception -> L12
        return;
    L9:
        r20 = 1;
    L12:
        e = move-exception;
        if (k.d() == false) goto L19;
        e.printStackTrace();
        return;
    }

    private static void reportTraceTime(String r8, String r10, long r11, long r12) {
        b3.b.C0032b.f3038a.c(new b(r10, r11, r12));
    }

    @Keep
    public static void setUserVisibleHint(Fragment r8, boolean r10) {
        if (r10 == true) goto L4;
        return;
    L4:
        if (r8.isResumed() == true) goto L6;
        return;
    L6:
        if (r8.isHidden() == true) goto L22;
        String r11 = r8.getClass().getCanonicalName();     // Catch: Exception -> L15
        Integer r12 = e3.a.a(r11);     // Catch: Exception -> L15
        if (r12 != null) goto L11;
        return;
    L11:
        if (r12.intValue() <= 0) goto L21;
        registerOnGlobalLayoutListener(r11, r8.getView(), r12, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L15
        return;
    L21:
        return;
    L23:
        return;
    }
}
