package bf;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Scroller;
import b3.p;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.bytedance.ies.xelement.banner.LynxSwiperItemView;
import com.bytedance.ies.xelement.viewpager.LynxTabBarView;
import com.bytedance.ies.xelement.viewpager.viewpager.BaseLynxViewPager;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.a0;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import com.lynx.tasm.behavior.ui.view.UIView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import xe.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f910b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f909a = r10;
        this.f910b = r5;
    }

    private final void a(View r5) {
    }

    private final void b(View r5) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r5) {
        switch(this.f909a) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L25;
            case 3: goto L21;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L10;
            default: goto L4;
        };
    L4:
        if (r5 == null) goto L39;
        xe.e r10 = (xe.e) ((i) this.f910b).f23131x.get(r5);
        if (r10 == null) goto L40;
        r10.f23112b = true;
        return;
    L40:
        return;
    L39:
        return;
    L10:
        LynxTabBarView r11 = (LynxTabBarView) this.f910b;
        ze.a r12 = r11.f6514b;
        if (r12 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        r12 = null;
    L13:
        r12.post(new vn.h(r11, 3));
        return;
    L15:
        Intrinsics.checkNotNullParameter(r5, "v");
        return;
    L17:
        Intrinsics.checkNotNullParameter(r5, "v");
        WeakReference r13 = (WeakReference) this.f910b;
        Intrinsics.checkNotNull(r13);
        LynxSwiperItemView r14 = (LynxSwiperItemView) r13.get();
        if (r14 == null) goto L41;
        r14.i();
        return;
    L41:
        return;
    L21:
        XSwiperUI r15 = (XSwiperUI) this.f910b;
        r15.f10683u = true;
        if (r15.f10677n == false) goto L42;
        Handler r16 = r15.C;
        a0 r17 = r15.E;
        r16.removeCallbacks(r17);
        r16.postDelayed(r17, r15.f10680q);
        return;
    L42:
        return;
    L25:
        UIView r18 = (UIView) this.f910b;
        if (r5 == r18.getView()) goto L28;
        return;
    L28:
        if (UIView.access$000(r18) != null) goto L30;
        return;
    L30:
        if (UIView.access$100(r18).containsKey("attach") == false) goto L45;
        on.e r19 = new on.e(r18.getSign(), "attach");
        HashMap r20 = new HashMap();
        r20.put("impression_id", ((com.lynx.tasm.behavior.ui.view.b) r18.getView()).getImpressionId());
        r19.f20782h = LynxResourceModule.PARAMS_KEY;
        r19.f20783i = r20;
        if (r18.getLynxContext().g == null) goto L46;
        r18.getLynxContext().g.b(r19);
        return;
    L46:
        return;
    L45:
        return;
    L35:
        Intrinsics.checkNotNullParameter(r5, "v");
        return;
    L37:
        BaseLynxViewPager r21 = (BaseLynxViewPager) this.f910b;
        r21.j().post(new androidx.fragment.app.d(r21, 5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r5) {
        boolean r10 = false;
        Object r11 = this.f910b;
        switch(this.f909a) {
            case 0: goto L62;
            case 1: goto L51;
            case 2: goto L41;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L10;
            case 6: goto L54;
            default: goto L4;
        };
    L4:
        if (r5 == null) goto L55;
        xe.e r12 = (xe.e) ((i) r11).f23131x.get(r5);
        if (r12 == null) goto L56;
        r12.f23112b = false;
        return;
    L56:
        return;
    L55:
        return;
    L10:
        Intrinsics.checkNotNullParameter(r5, "v");
        fn.i r13 = (fn.i) r11;
        FrameLayout r14 = (FrameLayout) r13.d;
        if (r13.f16960c == false) goto L57;
        Object r15 = r14.getContext().getSystemService("window");     // Catch: Exception -> L15
        if (r15 == null) goto L18;
        ((WindowManager) r15).removeViewImmediate(r14);     // Catch: Exception -> L15
    L20:
        r13.f16960c = false;
        ViewGroup r16 = (ViewGroup) r13.e;
        if (r16 == null) goto L24;
        r16.removeOnAttachStateChangeListener((b) r13.f);
    L24:
        r13.e = null;
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ps.a.c("OFloatingWindowHelper", Intrinsics.stringPlus("Failed to remove view from WindowManager: ", e.getMessage()));
        goto L20
    L57:
        return;
    L26:
        Intrinsics.checkNotNullParameter(r5, "v");
        return;
    L28:
        XSwiperUI r17 = (XSwiperUI) r11;
        if (r17.f10687y == true) goto L31;
    L39:
        r17.f10683u = false;
        r17.C.removeCallbacks(r17.E);
        return;
    L31:
        if (((jn.b) XSwiperUI.b(r17)).f18363a.f18380j == false) goto L39;
        jn.f r18 = ((jn.b) XSwiperUI.l(r17)).f18363a;
        if (r18.f18378h0 == Integer.MIN_VALUE) goto L38;
        boolean r19 = r18.o();
        Scroller r20 = r18.f18379i;
        if (r19 == false) goto L37;
        r18.scrollTo(r20.getCurrX(), r18.f18378h0);
        goto L38
    L37:
        r18.scrollTo(r18.f18378h0, r20.getCurrY());
    L38:
        r18.f18378h0 = Integer.MIN_VALUE;
        goto L39
    L41:
        UIView r21 = (UIView) r11;
        if (r5 == r21.getView()) goto L44;
        return;
    L44:
        if (UIView.access$200(r21) != null) goto L46;
        return;
    L46:
        if (UIView.access$300(r21).containsKey("detach") == false) goto L60;
        on.e r22 = new on.e(r21.getSign(), "detach");
        HashMap r23 = new HashMap();
        r23.put("impression_id", ((com.lynx.tasm.behavior.ui.view.b) r21.getView()).getImpressionId());
        r22.f20782h = LynxResourceModule.PARAMS_KEY;
        r22.f20783i = r23;
        if (r21.getLynxContext().g == null) goto L61;
        r21.getLynxContext().g.b(r22);
        return;
    L61:
        return;
    L60:
        return;
    L51:
        Intrinsics.checkNotNullParameter(r5, "v");
        p r24 = b3.h.f841a;
        String r25 = ((AppletWidgetContainer) r11).v();
        Intrinsics.checkNotNullParameter(r25, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        b3.h.c(new b3.e(r10, r25));
        return;
    L54:
        return;
    }

    public b(LynxSwiperItemView r5) {
        this.f909a = 4;
        Intrinsics.checkNotNullParameter(r5, "ui");
        this.f910b = new WeakReference(r5);
    }
}
