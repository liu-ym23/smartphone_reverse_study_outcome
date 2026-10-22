package com.bytedance.apm.agent.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.internal.ApmDelegate;
import e2.d;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class FragmentInstrumentation {
    private static final String TAG = "FragmentInstrumentation";
    private static long sCheckVisibilityStartTime;
    private static String sFragmentName;
    private static long sMaxWaitTime;
    private static HashSet<String> sMethodSet;
    private static long sOnActivityCreatedEnd;
    private static long sOnActivityCreatedStart;
    private static long sOnCreateEnd;
    private static String sOnCreateFragmentName;
    private static long sOnCreateStart;
    private static long sOnCreateTime;
    private static ViewTreeObserver.OnGlobalLayoutListener sOnGlobalLayoutListener;
    private static long sOnResumeEnd;
    private static long sOnResumeStart;
    private static long sOnViewCreatedEnd;
    private static long sOnViewCreatedStart;
    private static WeakReference<View> sRootViewRef;
    private static Runnable sWaitViewTimeoutRunnable;

    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Integer f3727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f3728b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f3729m;

        public a(Integer r8, long r10, String r11) {
            this.f3727a = r8;
            this.f3728b = r10;
            this.f3729m = r11;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (FragmentInstrumentation.access$000() != null) goto L5;
            return;
        L5:
            if (FragmentInstrumentation.access$000().get() == null) goto L33;
            View r8 = ((View) FragmentInstrumentation.access$000().get()).findViewById(this.f3727a.intValue());     // Catch: Exception -> L29
            if (FragmentInstrumentation.access$100() != 0) goto L10;
            FragmentInstrumentation.access$102(System.currentTimeMillis());     // Catch: Exception -> L29
        L10:
            if (r8 != null) goto L12;
            return;
        L12:
            if (r8.getVisibility() == 0) goto L14;
            return;
        L14:
            if (r8.getWidth() <= 0) goto L36;
            long r10 = System.currentTimeMillis();     // Catch: Exception -> L29
            if (((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().isAlive() == true) goto L18;
        L20:
            FragmentInstrumentation.access$202(null);     // Catch: Exception -> L29
            FragmentInstrumentation.access$002(null);     // Catch: Exception -> L29
            if (FragmentInstrumentation.access$300() == null) goto L23;
            b3.a.f3032a.removeCallbacks(FragmentInstrumentation.access$300());     // Catch: Exception -> L29
        L23:
            long r11 = r10 - this.f3728b;     // Catch: Exception -> L29
            if ((r10 - FragmentInstrumentation.access$100()) > 1) goto L26;
            return;
        L26:
            if (r11 >= FragmentInstrumentation.access$400()) goto L38;
            String r12 = FragmentInstrumentation.access$500();     // Catch: Exception -> L29
            String r13 = this.f3729m;     // Catch: Exception -> L29
            b3.b.C0032b.f3038a.c(new d(r11, r13, r12));     // Catch: Exception -> L29
            return;
        L38:
            return;
        L18:
            if (FragmentInstrumentation.access$200() == null) goto L20;
            ((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentInstrumentation.access$200());     // Catch: Exception -> L29
            goto L20
        L36:
            return;
        L33:
            return;
        }
    }

    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            if (FragmentInstrumentation.access$200() != null) goto L5;
            return;
        L5:
            if (FragmentInstrumentation.access$000() != null) goto L7;
            return;
        L7:
            if (FragmentInstrumentation.access$000().get() == null) goto L15;
            ((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().removeOnGlobalLayoutListener(FragmentInstrumentation.access$200());     // Catch: Exception -> L10
            return;
        L15:
            return;
        }
    }

    static {
        sMethodSet = new HashSet(32);
    }

    public FragmentInstrumentation() {
    }

    public static /* synthetic */ WeakReference access$000() {
        return sRootViewRef;
    }

    public static /* synthetic */ WeakReference access$002(WeakReference r8) {
        sRootViewRef = r8;
        return r8;
    }

    public static /* synthetic */ long access$100() {
        return sCheckVisibilityStartTime;
    }

    public static /* synthetic */ long access$102(long r8) {
        sCheckVisibilityStartTime = r8;
        return r8;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$200() {
        return sOnGlobalLayoutListener;
    }

    public static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$202(ViewTreeObserver.OnGlobalLayoutListener r8) {
        sOnGlobalLayoutListener = r8;
        return r8;
    }

    public static /* synthetic */ Runnable access$300() {
        return sWaitViewTimeoutRunnable;
    }

    public static /* synthetic */ long access$400() {
        return sMaxWaitTime;
    }

    public static /* synthetic */ String access$500() {
        return sFragmentName;
    }

    public static boolean isValid(String r8) {
        if (TextUtils.isEmpty(sFragmentName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r8, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onCreate(String r8) {
        sOnCreateFragmentName = r8;
        sOnCreateTime = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L6;
        ApmDelegate.a.f3770a.getClass();
        new j2.a(new j2.a.C0096a());
        sMaxWaitTime = 20000;
        return;
    }

    @Keep
    public static void onHiddenChanged(Fragment r8, boolean r10) {
        t2.b.L(r8, !r10);
        if (r10 == true) goto L9;
        String r11 = r8.getClass().getCanonicalName();     // Catch: Exception -> L6
        registerOnGlobalLayoutListener(r11, r8.getView(), e3.a.a(r11), System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Keep
    public static void onPause(Fragment r8) {
        if (r8.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r8.isHidden() == true) goto L9;
        t2.b.L(r8, false);
        return;
    }

    @Keep
    public static void onResume(Fragment r8) {
        if (r8.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r8.isHidden() == true) goto L16;
        String r10 = r8.getClass().getCanonicalName();
        t2.b.L(r8, true);     // Catch: Exception -> L12
        if (TextUtils.equals(r10, sOnCreateFragmentName) == true) goto L10;
        return;
    L10:
        Integer r11 = e3.a.a(r10);     // Catch: Exception -> L12
        registerOnGlobalLayoutListener(r10, r8.getView(), r11, sOnCreateTime, "fragmentOnCreateToViewShow");     // Catch: Exception -> L12
        return;
    L17:
        return;
    }

    @Keep
    public static void onTrace(Fragment r11, String r12, String r13, boolean r14) {
        if (TextUtils.equals("onCreate", r13) == false) goto L10;
        if (r14 == false) goto L7;
        sFragmentName = r12;
        sOnCreateStart = System.currentTimeMillis();
        return;
    L7:
        if (isValid(r12) == false) goto L57;
        sOnCreateEnd = System.currentTimeMillis();
        return;
    L57:
        return;
    L10:
        if (TextUtils.equals("onViewCreated", r13) == false) goto L20;
        if (isValid(r12) == false) goto L20;
        long r15 = sOnCreateStart;
        if (r14 == false) goto L17;
        if (r15 <= 0) goto L59;
        sOnViewCreatedStart = System.currentTimeMillis();
        return;
    L59:
        return;
    L17:
        if (r15 <= 0) goto L61;
        sOnViewCreatedEnd = System.currentTimeMillis();
        return;
    L61:
        return;
    L20:
        if (TextUtils.equals("onActivityCreated", r13) == false) goto L30;
        if (isValid(r12) == false) goto L30;
        long r16 = sOnCreateStart;
        if (r14 == false) goto L27;
        if (r16 <= 0) goto L63;
        sOnActivityCreatedStart = System.currentTimeMillis();
        return;
    L63:
        return;
    L27:
        if (r16 <= 0) goto L65;
        sOnActivityCreatedEnd = System.currentTimeMillis();
        return;
    L65:
        return;
    L30:
        if (TextUtils.equals("onResume", r13) == true) goto L32;
        return;
    L32:
        if (isValid(r12) == false) goto L68;
        if (r14 == false) goto L38;
        if (sOnCreateStart <= 0) goto L69;
        sOnResumeStart = System.currentTimeMillis();
        return;
    L69:
        return;
    L38:
        if (sOnCreateStart <= 0) goto L71;
        long r8 = System.currentTimeMillis();
        sOnResumeEnd = r8;
        if ((r8 - sOnCreateStart) < 5000) goto L54;
    L51:
        sOnCreateStart = 0;
        sFragmentName = null;
        return;
    L54:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L53
        r17.put("begin_time", sOnCreateStart);     // Catch: Exception -> L53
        r17.put("end_time", sOnResumeEnd);     // Catch: Exception -> L53
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L53
        r10.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L53
        r10.put("onViewCreated", sOnViewCreatedEnd - sOnViewCreatedStart);     // Catch: Exception -> L53
        r10.put("onActivityCreated", sOnActivityCreatedEnd - sOnActivityCreatedStart);     // Catch: Exception -> L53
        r10.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L53
        r10.put("fragment_create_to_resume", sOnResumeEnd - sOnCreateStart);     // Catch: Exception -> L53
        if (r11 != null) goto L44;
    L46:
        r17.put("page_type", "fragment");     // Catch: Exception -> L53
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L53
        if (sMethodSet.contains(sFragmentName + r13) == true) goto L49;
        boolean r19 = true;
    L50:
        r18.put("is_first", r19);     // Catch: Exception -> L53
        r18.put("scene", r12);     // Catch: Exception -> L53
        sMethodSet.add(sFragmentName + r13);     // Catch: Exception -> L53
        b3.b.C0032b.f3038a.c(new e2.b("page_load", r10, r18, r17));     // Catch: Exception -> L53
        goto L51
    L49:
        r19 = false;
        goto L50
    L44:
        if (r11.getActivity() == null) goto L46;
        r17.put("attached_activity", r11.getActivity().getClass().getName());     // Catch: Exception -> L53
        goto L46
    L71:
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
        sOnGlobalLayoutListener = new a(r11, r12, r13);
        r10.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new b();
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

    @Keep
    public static void setUserVisibleHint(Fragment r8, boolean r10) {
        if (r8.isResumed() == true) goto L5;
        return;
    L5:
        if (r8.isHidden() == true) goto L14;
        t2.b.L(r8, r10);
        if (r10 == false) goto L15;
        String r11 = r8.getClass().getCanonicalName();     // Catch: Exception -> L10
        Integer r12 = e3.a.a(r11);     // Catch: Exception -> L10
        registerOnGlobalLayoutListener(r11, r8.getView(), r12, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    }
}
