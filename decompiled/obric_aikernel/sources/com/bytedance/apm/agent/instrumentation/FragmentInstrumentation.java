package com.bytedance.apm.agent.instrumentation;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.internal.ApmDelegate;
import e.c;
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

    static class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Integer f717c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f718g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f719h;

        a(Integer r10, long r11, String r12) {
            this.f717c = r10;
            this.f718g = r11;
            this.f719h = r12;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (FragmentInstrumentation.access$000() != null) goto L5;
            return;
        L5:
            if (FragmentInstrumentation.access$000().get() == null) goto L33;
            View r10 = ((View) FragmentInstrumentation.access$000().get()).findViewById(this.f717c.intValue());     // Catch: Exception -> L29
            if (FragmentInstrumentation.access$100() != 0) goto L10;
            FragmentInstrumentation.access$102(System.currentTimeMillis());     // Catch: Exception -> L29
        L10:
            if (r10 != null) goto L12;
            return;
        L12:
            if (r10.getVisibility() == 0) goto L14;
            return;
        L14:
            if (r10.getWidth() <= 0) goto L36;
            long r11 = System.currentTimeMillis();     // Catch: Exception -> L29
            if (((View) FragmentInstrumentation.access$000().get()).getViewTreeObserver().isAlive() == true) goto L18;
        L20:
            FragmentInstrumentation.access$202(null);     // Catch: Exception -> L29
            FragmentInstrumentation.access$002(null);     // Catch: Exception -> L29
            if (FragmentInstrumentation.access$300() == null) goto L23;
            q0.a.a().removeCallbacks(FragmentInstrumentation.access$300());     // Catch: Exception -> L29
        L23:
            long r12 = r11 - this.f718g;     // Catch: Exception -> L29
            if ((r11 - FragmentInstrumentation.access$100()) > 1) goto L26;
            return;
        L26:
            if (r12 >= FragmentInstrumentation.access$400()) goto L38;
            f.a.d(FragmentInstrumentation.access$500(), this.f719h, r12);     // Catch: Exception -> L29
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

    static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
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

    static /* synthetic */ WeakReference access$000() {
        return sRootViewRef;
    }

    static /* synthetic */ WeakReference access$002(WeakReference r10) {
        sRootViewRef = r10;
        return r10;
    }

    static /* synthetic */ long access$100() {
        return sCheckVisibilityStartTime;
    }

    static /* synthetic */ long access$102(long r10) {
        sCheckVisibilityStartTime = r10;
        return r10;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$200() {
        return sOnGlobalLayoutListener;
    }

    static /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener access$202(ViewTreeObserver.OnGlobalLayoutListener r10) {
        sOnGlobalLayoutListener = r10;
        return r10;
    }

    static /* synthetic */ Runnable access$300() {
        return sWaitViewTimeoutRunnable;
    }

    static /* synthetic */ long access$400() {
        return sMaxWaitTime;
    }

    static /* synthetic */ String access$500() {
        return sFragmentName;
    }

    static boolean isValid(String r10) {
        if (TextUtils.isEmpty(sFragmentName) == false) goto L5;
        return false;
    L5:
        if (TextUtils.equals(r10, sFragmentName) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Keep
    public static void onCreate(String r10) {
        sOnCreateFragmentName = r10;
        sOnCreateTime = System.currentTimeMillis();
        if (sMaxWaitTime != 0) goto L6;
        sMaxWaitTime = ApmDelegate.j().h().i();
        return;
    }

    @Keep
    public static void onHiddenChanged(Fragment r10, boolean r11) {
        c.a(r10, !r11);
        if (r11 == true) goto L9;
        String r12 = r10.getClass().getCanonicalName();     // Catch: Exception -> L6
        registerOnGlobalLayoutListener(r12, r10.getView(), t0.a.c(r12), System.currentTimeMillis(), "fragmentOnHiddenChangedToViewShow");     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Keep
    public static void onPause(Fragment r10) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L9;
        c.a(r10, false);
        return;
    }

    @Keep
    public static void onResume(Fragment r10) {
        if (r10.getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L16;
        String r11 = r10.getClass().getCanonicalName();
        c.a(r10, true);     // Catch: Exception -> L12
        if (TextUtils.equals(r11, sOnCreateFragmentName) == true) goto L10;
        return;
    L10:
        Integer r12 = t0.a.c(r11);     // Catch: Exception -> L12
        registerOnGlobalLayoutListener(r11, r10.getView(), r12, sOnCreateTime, "fragmentOnCreateToViewShow");     // Catch: Exception -> L12
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
        long r10 = System.currentTimeMillis();
        sOnResumeEnd = r10;
        if ((r10 - sOnCreateStart) < 5000) goto L54;
    L51:
        sOnCreateStart = 0;
        sFragmentName = null;
        return;
    L54:
        JSONObject r17 = new JSONObject();     // Catch: Exception -> L53
        r17.put("begin_time", sOnCreateStart);     // Catch: Exception -> L53
        r17.put("end_time", sOnResumeEnd);     // Catch: Exception -> L53
        JSONObject r18 = new JSONObject();     // Catch: Exception -> L53
        r18.put("onCreate", sOnCreateEnd - sOnCreateStart);     // Catch: Exception -> L53
        r18.put("onViewCreated", sOnViewCreatedEnd - sOnViewCreatedStart);     // Catch: Exception -> L53
        r18.put("onActivityCreated", sOnActivityCreatedEnd - sOnActivityCreatedStart);     // Catch: Exception -> L53
        r18.put("onResume", sOnResumeEnd - sOnResumeStart);     // Catch: Exception -> L53
        r18.put("fragment_create_to_resume", sOnResumeEnd - sOnCreateStart);     // Catch: Exception -> L53
        if (r11 != null) goto L44;
    L46:
        r17.put("page_type", "fragment");     // Catch: Exception -> L53
        JSONObject r19 = new JSONObject();     // Catch: Exception -> L53
        if (sMethodSet.contains(sFragmentName + r13) == true) goto L49;
        boolean r20 = true;
    L50:
        r19.put("is_first", r20);     // Catch: Exception -> L53
        r19.put("scene", r12);     // Catch: Exception -> L53
        sMethodSet.add(sFragmentName + r13);     // Catch: Exception -> L53
        f.a.a("page_load", r18, r19, r17);     // Catch: Exception -> L53
        goto L51
    L49:
        r20 = false;
        goto L50
    L44:
        if (r11.getActivity() == null) goto L46;
        r17.put("attached_activity", r11.getActivity().getClass().getName());     // Catch: Exception -> L53
        goto L46
    L71:
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
        sOnGlobalLayoutListener = new a(r12, r13, r14);
        r11.getViewTreeObserver().addOnGlobalLayoutListener(sOnGlobalLayoutListener);
        sWaitViewTimeoutRunnable = new b();
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

    @Keep
    public static void setUserVisibleHint(Fragment r10, boolean r11) {
        if (r10.isResumed() == true) goto L5;
        return;
    L5:
        if (r10.isHidden() == true) goto L14;
        c.a(r10, r11);
        if (r11 == false) goto L15;
        String r12 = r10.getClass().getCanonicalName();     // Catch: Exception -> L10
        Integer r13 = t0.a.c(r12);     // Catch: Exception -> L10
        registerOnGlobalLayoutListener(r12, r10.getView(), r13, System.currentTimeMillis(), "fragmentUserVisibleToViewShow");     // Catch: Exception -> L10
        return;
    L16:
        return;
    L15:
        return;
    }
}
