package com.obric.common.oea.style.scene.transition;

import android.app.Activity;
import android.view.WindowManager;
import com.obric.common.oea.foundation.a.c;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/common/oea/style/scene/transition/TransitionAnimHelper;", "", "()V", "TAG", "", "sdkInit", "Lcom/obric/common/oea/foundation/util/SdkInit;", "enableModalTransition", "", "layoutParams", "Landroid/view/WindowManager$LayoutParams;", "enable", "", "enableSearchTransition", "overrideEnterAnim", "activity", "Landroid/app/Activity;", "animStyle", "Lcom/obric/common/oea/style/scene/transition/TransitionAnimStyle;", "overrideExitAnim", "setOUICustomAnimations", "Landroidx/fragment/app/FragmentTransaction;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7844a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f7845b = null;

    static {
        f7844a = new a();
        f7845b = new c();
    }

    private a() {
    }

    @JvmStatic
    public static final void a(Activity r12, TransitionAnimStyle r13) {
        Activity r14 = (Activity) ZeusTransformUtils.wrapperContextForParams(r12, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "activity");
        Intrinsics.checkNotNullParameter(r13, "animStyle");
        int r0 = b.f7846a[r13.ordinal()];
        if (r0 == 1) goto L7;
        if (r0 == 2) goto L6;
        TransitionAnimStyle r1 = r13;
    L8:
        String r3 = r14.getClass().getSimpleName();
        com.obric.common.oea.foundation.a.b r6 = com.obric.common.oea.foundation.a.b.f7661a;
        if (r13 == r1) goto L11;
        StringBuilder r7 = new StringBuilder();
        com.obric.common.oea.foundation.a.b.a(r6, "TransitionAnimHelper", r7.append("overrideEnterAnim, ").append(r13).append(" is deprecated: , use ").append(r1).append(" instead, activity: ").append(r3).toString(), null, 4, null);
    L12:
        int r2 = b.f7847b[r1.ordinal()];
        if (r2 == 1) goto L20;
        if (r2 != 2) goto L16;
        int r15 = ZeusTransformUtils.mapRes(R.anim.oui_modal_open_enter, "anim", "oui_modal_open_enter");
        int r4 = R.anim.oui_modal_open_exit;
        String r5 = "oui_modal_open_exit";
    L21:
        r14.overridePendingTransition(r15, ZeusTransformUtils.mapRes(r4, "anim", r5));
        return;
    L16:
        if (r2 == 3) goto L18;
        com.obric.common.oea.foundation.a.b.f7661a.d("TransitionAnimHelper", "overrideEnterAnim, unsupported anim style: " + r13 + "，activity: " + r3);
        return;
    L18:
        r15 = ZeusTransformUtils.mapRes(R.anim.oui_search_open_enter, "anim", "oui_search_open_enter");
        r4 = R.anim.oui_search_open_exit;
        r5 = "oui_search_open_exit";
        goto L21
    L20:
        r15 = ZeusTransformUtils.mapRes(R.anim.oui_activity_open_enter, "anim", "oui_activity_open_enter");
        r4 = R.anim.oui_activity_open_exit;
        r5 = "oui_activity_open_exit";
        goto L21
    L11:
        r7 = new StringBuilder();
        r6.e("TransitionAnimHelper", r7.append("overrideEnterAnim, animStyle: ").append(r13).append("，activity: ").append(r3).toString());
        goto L12
    L6:
        r1 = TransitionAnimStyle.Modal;
        goto L8
    L7:
        r1 = TransitionAnimStyle.Standard;
        goto L8
    }

    @JvmStatic
    public static final void a(WindowManager.LayoutParams r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "layoutParams");
        com.obric.common.oea.foundation.a.b.f7661a.e("TransitionAnimHelper", "enableModalTransition, enable: " + r8);
        Class r0 = ZeusTransformUtils.forName("android.view.WindowManagerExt", "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "Class.forName(\"android.view.WindowManagerExt\")");     // Catch: Exception -> L5
        Method r1 = r0.getMethod("enableModelTransition", new Class[]{WindowManager.LayoutParams.class, Boolean.TYPE});     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r1, "windowManagerExtClass.ge…imitiveType\n            )");     // Catch: Exception -> L5
        r1.invoke(null, new Object[]{r7, Boolean.valueOf(r8)});     // Catch: Exception -> L5
        return;
    }

    public static /* synthetic */ void a(WindowManager.LayoutParams r0, boolean r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L5;
        r1 = true;
    L5:
        a(r0, r1);
    }

    @JvmStatic
    public static final void b(Activity r12, TransitionAnimStyle r13) {
        Activity r14 = (Activity) ZeusTransformUtils.wrapperContextForParams(r12, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "activity");
        Intrinsics.checkNotNullParameter(r13, "animStyle");
        String r0 = r14.getClass().getSimpleName();
        int r1 = b.c[r13.ordinal()];
        if (r1 == 1) goto L7;
        if (r1 == 2) goto L6;
        TransitionAnimStyle r2 = r13;
    L8:
        com.obric.common.oea.foundation.a.b r6 = com.obric.common.oea.foundation.a.b.f7661a;
        if (r13 == r2) goto L11;
        StringBuilder r7 = new StringBuilder();
        com.obric.common.oea.foundation.a.b.a(r6, "TransitionAnimHelper", r7.append("overrideExitAnim, ").append(r13).append(" is deprecated, use ").append(r2).append(" instead，activity: ").append(r0).toString(), null, 4, null);
    L12:
        int r3 = b.d[r2.ordinal()];
        if (r3 == 1) goto L20;
        if (r3 != 2) goto L16;
        int r15 = ZeusTransformUtils.mapRes(R.anim.oui_modal_close_enter, "anim", "oui_modal_close_enter");
        int r4 = R.anim.oui_modal_close_exit;
        String r5 = "oui_modal_close_exit";
    L21:
        r14.overridePendingTransition(r15, ZeusTransformUtils.mapRes(r4, "anim", r5));
        return;
    L16:
        if (r3 == 3) goto L18;
        com.obric.common.oea.foundation.a.b.f7661a.d("TransitionAnimHelper", "overrideExitAnim, unsupported anim style: " + r13 + "，activity: " + r0);
        return;
    L18:
        r15 = ZeusTransformUtils.mapRes(R.anim.oui_search_close_enter, "anim", "oui_search_close_enter");
        r4 = R.anim.oui_search_close_exit;
        r5 = "oui_search_close_exit";
        goto L21
    L20:
        r15 = ZeusTransformUtils.mapRes(R.anim.oui_activity_close_enter, "anim", "oui_activity_close_enter");
        r4 = R.anim.oui_activity_close_exit;
        r5 = "oui_activity_close_exit";
        goto L21
    L11:
        r7 = new StringBuilder();
        r6.e("TransitionAnimHelper", r7.append("overrideExitAnim, animStyle: ").append(r13).append("，activity: ").append(r0).toString());
        goto L12
    L6:
        r2 = TransitionAnimStyle.Modal;
        goto L8
    L7:
        r2 = TransitionAnimStyle.Standard;
        goto L8
    }
}
