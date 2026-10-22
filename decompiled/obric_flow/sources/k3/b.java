package k3;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.view.popup.anim.AnimController$AnimProcessType;
import com.bytedance.ai.view.popup.anim.AnimationStyle;
import com.bytedance.ai.view.popup.params.AppletPopupSchemaParam;
import com.bytedance.android.anniex.base.service.f;
import com.lynx.jsbridge.LynxResourceModule;
import java.lang.ref.WeakReference;
import ko.r;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import v0.e;
import ym.k;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements j3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppletPopupSchemaParam f18589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f18590c;
    public final Object d;

    public b(AppletPopupSchemaParam r5, View r10, h3.b r11) {
        this.f18588a = 1;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "view");
        this.f18589b = r5;
        this.f18590c = r10;
        this.d = r11;
    }

    public String a(boolean r5) {
        LinearLayout r10 = (LinearLayout) this.f18590c;
        Context r11 = r10.getContext();
        AppletPopupSchemaParam r12 = this.f18589b;
        if (r5 == false) goto L5;
        String r13 = r12.f2892j;
    L7:
        if (AppletPopupSchemaParam.b(r11) == true) goto L9;
    L11:
        AnimationStyle[] r14 = AnimationStyle.f2882a;
        if (Intrinsics.areEqual(r13, "start") == false) goto L18;
        if (k.c(r10.getContext()) == false) goto L16;
        return "right";
    L16:
        return OpenPageMethod.ALIGN_LEFT;
    L18:
        if (Intrinsics.areEqual(r13, "end") == true) goto L20;
        return r13;
    L20:
        if (k.c(r10.getContext()) == false) goto L22;
        return OpenPageMethod.ALIGN_LEFT;
    L22:
        return "right";
    L9:
        if (r12.f2895m.length() <= 0) goto L11;
        r13 = r12.f2895m;
        goto L11
    L5:
        r13 = r12.f2893k;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object, java.lang.String] */
    public void b(h3.c r11, int r12, Function0 r13) {
        r r5 = (r) this.d;
        if (((AnimController$AnimProcessType) r5.f18728b) == AnimController$AnimProcessType.f2879a) goto L5;
        return;
    L5:
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        ?? r14 = a(true);
        r10.element = r14;
        AnimationStyle[] r15 = AnimationStyle.f2882a;
        boolean r16 = Intrinsics.areEqual(r14, "zoom");
        AppletPopupSchemaParam r17 = this.f18589b;
        LinearLayout r18 = (LinearLayout) this.f18590c;
        if (r16 == false) goto L22;
        int r19 = i3.a.f17500a;
        String r20 = r17.f2894l;
        Intrinsics.checkNotNullParameter(r18, "transitionView");
        Intrinsics.checkNotNullParameter(r20, "floatingPageName");
        Intrinsics.checkNotNullParameter(r5, "animController");
        Lazy r21 = e.f;
        f.g().getClass();
        w0.k r22 = e.n();
        if (r22 != null) goto L11;
    L21:
        r10.element = "slide";
        goto L22
    L11:
        if (Intrinsics.areEqual(((com.bytedance.ai.model.widgets.a) r22).f2330b.getPageName(), r20) == false) goto L21;
        f.g().getClass();
        Lazy r23 = v0.d.f22502n;
        v0.d r24 = cl.a.h();
        WeakReference r25 = r24.f22504i;
        if (r25 == null) goto L21;
        FrameLayout r26 = (FrameLayout) r25.get();
        if (r26 == null) goto L21;
        v0.a r27 = r24.f;
        if (r27 == null) goto L21;
        if (r26.indexOfChild(r27) == (-1)) goto L21;
        f.g().getClass();
    L22:
        a r28 = new a(this, r10, r13, 1);
        String r110 = (String) r10.element;
        if (Intrinsics.areEqual(r110, "slide") == false) goto L26;
        r18.setVisibility(4);
        r18.setTranslationY(r12);
        r18.animate().translationY(0.0f).setDuration(r17.f2907z).setListener(r28);
    L51:
        if (r11 == null) goto L53;
        ViewPropertyAnimator r111 = r18.animate();
        Intrinsics.checkNotNullParameter(r111, "animator");
        r111.setInterpolator(new LinearInterpolator());
        r111.setDuration(300);
    L53:
        r18.animate().start();
        return;
    L26:
        if (Intrinsics.areEqual(r110, OpenPageMethod.ALIGN_LEFT) == false) goto L37;
        r18.setVisibility(4);
        DisplayMetrics r112 = new DisplayMetrics();
        if ((r18.getContext() instanceof Activity) == false) goto L30;
        Context r113 = r18.getContext();
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r114 = ((Activity) r113).getWindowManager();
    L31:
        if (r114 == null) goto L35;
        Display r115 = r114.getDefaultDisplay();
        if (r115 == null) goto L35;
        r115.getMetrics(r112);
    L35:
        r18.setTranslationX(-r112.widthPixels);
        r18.animate().translationX(0.0f).setDuration(r17.f2907z).setListener(r28);
        goto L51
    L30:
        Object r116 = r18.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type android.view.WindowManager");
        r114 = (WindowManager) r116;
        goto L31
    L37:
        if (Intrinsics.areEqual(r110, "right") == false) goto L48;
        r18.setVisibility(4);
        DisplayMetrics r117 = new DisplayMetrics();
        if ((r18.getContext() instanceof Activity) == false) goto L41;
        Context r118 = r18.getContext();
        Intrinsics.checkNotNull(r118, "null cannot be cast to non-null type android.app.Activity");
        WindowManager r119 = ((Activity) r118).getWindowManager();
    L42:
        if (r119 == null) goto L46;
        Display r120 = r119.getDefaultDisplay();
        if (r120 == null) goto L46;
        r120.getMetrics(r117);
    L46:
        r18.setTranslationX(r117.widthPixels);
        r18.animate().translationX(0.0f).setDuration(r17.f2907z).setListener(r28);
        goto L51
    L41:
        Object r121 = r18.getContext().getSystemService("window");
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.view.WindowManager");
        r119 = (WindowManager) r121;
        goto L42
    L48:
        if (Intrinsics.areEqual(r110, "auto") == false) goto L50;
        r18.setVisibility(4);
        r18.setAlpha(0.0f);
        r18.animate().alpha(1.0f).setDuration(r17.f2907z).setListener(r28);
        goto L51
    L50:
        r5.m(true);
        r13.invoke();
        Unit r122 = Unit.INSTANCE;
        goto L51
    }

    @Override // j3.a
    public final void invoke() {
        switch(this.f18588a) {
            case 0: goto L10;
            case 1: goto L7;
            default: goto L4;
        };
    L4:
        Integer[] r5 = (Integer[]) this.d;
        AppletPopupSchemaParam r10 = this.f18589b;
        LinearLayout r11 = (LinearLayout) this.f18590c;
        kk.a.g(r11, kk.a.a(r10, r11, r5));
        return;
    L10:
        Context r12 = ((LinearLayout) this.f18590c).getContext();
        AppletPopupSchemaParam r13 = this.f18589b;
        String r14 = r13.f2892j;
        if (AppletPopupSchemaParam.b(r12) == false) goto L15;
        r13.f2895m.getClass();
        return;
    L15:
        return;
    L7:
        if (this.f18589b.f2890h == true) goto L14;
        ar.a r15 = new ar.a(this, 21);
        this.f18590c.setOnClickListener(r15);
        return;
    }

    public b(AppletPopupSchemaParam r5, LinearLayout r10, r r11) {
        this.f18588a = 0;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "animController");
        this.f18589b = r5;
        this.f18590c = r10;
        this.d = r11;
    }

    public b(AppletPopupSchemaParam r5, LinearLayout r10, Integer[] r11) {
        this.f18588a = 2;
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "margin");
        this.f18589b = r5;
        this.f18590c = r10;
        this.d = r11;
    }
}
