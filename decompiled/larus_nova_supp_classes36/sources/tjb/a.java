package tjb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.guide.ui.common.popup.OverlayType;
import com.ss.android.lark.guide.ui.config.AnchorConfig;
import com.ss.android.lark.guide.ui.config.MaskConfig;
import com.ss.android.lark.guide.ui.view.BubbleLayout;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import rjb.f;
import rjb.g;
import rjb.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class a implements rjb.b, ujb.b {
    public static final Rect h = null;
    public final WeakReference<Activity> a;
    public final String b;
    public final String c;
    public final MaskConfig d;
    public final AnchorConfig e;
    public final ujb.a f;
    public BubbleLayout g;

    /* JADX INFO: renamed from: tjb.a$a, reason: collision with other inner class name */
    public static final class C0328a implements f {
        public final MaskConfig a;

        public C0328a(MaskConfig r2) {
            Intrinsics.checkNotNullParameter(r2, "maskConfig");
            this.a = r2;
        }

        @Override // rjb.f
        public final Rect a(Rect r7) {
            Intrinsics.checkNotNullParameter(r7, "anchorRect");
            MaskConfig r0 = this.a;
            Rect r1 = r0.d;
            if (r1 == null) goto L6;
            r7 = r1;
        L6:
            MaskConfig.ShapeType r2 = r0.c;
            if (r2 != MaskConfig.ShapeType.CIRCLE) goto L9;
        L23:
            int r3 = (int) r0.b;
            int r4 = Math.max(r7.width() + r3, r7.height() + r3);
            Size r5 = this.a.e;
            if (r5 == null) goto L26;
            r4 = Math.max(r4, Math.max(r5.getWidth(), this.a.e.getHeight()));
        L26:
            int r6 = r4 / 2;
            int r8 = r7.centerX();
            int r9 = r7.centerY();
            Rect r10 = new Rect(r7);
            r10.left = r8 - r6;
            r10.right = r8 + r6;
            r10.top = r9 - r6;
            r10.bottom = r9 + r6;
            return r10;
        L9:
            if (r2 == MaskConfig.ShapeType.SQUARE) goto L23;
            int r11 = (int) r0.b;
            Size r12 = r0.e;
            if (r12 == null) goto L21;
            int r13 = r12.getWidth();
            int r14 = this.a.e.getHeight();
            int r15 = r11 * 2;
            if ((r7.width() + r15) >= r13) goto L16;
            int r16 = (r13 - r7.width()) / 2;
        L18:
            if ((r7.height() + r15) >= r14) goto L20;
            r11 = (r14 - r7.height()) / 2;
        L20:
            int r17 = r11;
            r11 = r16;
            int r18 = r17;
        L22:
            Rect r19 = new Rect(r7);
            r19.left -= r11;
            r19.right += r11;
            r19.top -= r18;
            r19.bottom += r18;
            return r19;
        L16:
            r16 = r11;
            goto L18
        L21:
            r18 = r11;
            goto L22
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AnchorConfig.AnchorGravity.values().length];
            r0[AnchorConfig.AnchorGravity.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[AnchorConfig.AnchorGravity.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[AnchorConfig.AnchorGravity.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[AnchorConfig.AnchorGravity.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    @Override // rjb.b
    public final void f() {
    }

    public abstract void h();

    public abstract boolean i();

    public abstract ujb.f m(g r1);

    public abstract View n(Context r1, ujb.f r2);

    public View p(Context r2, BubbleLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "layout");
        return r3;
    }

    static {
        h = new Rect();
    }

    @Override // rjb.b
    public final int c() {
        AnchorConfig.AnchorGravity r0 = this.e.b;
        int r1 = c.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return 1;
    L5:
        if (r1 == 2) goto L15;
        if (r1 != 3) goto L8;
        return 2;
    L8:
        if (r1 != 4) goto L11;
        return 4;
    L11:
        throw new NoWhenBranchMatchedException();
    L15:
        return 3;
    }

    public final tjb.b o() {
        Activity r1 = this.a.get();
        boolean r2 = false;
        if (r1 != null) goto L5;
        Log.e("BaseBubbleComponent", "activityRef get is null");
    L8:
        rjb.e r6 = null;
    L17:
        if (r6 == null) goto L33;
        rjb.b r8 = r6.a;
        if (r8 == null) goto L30;
        View r9 = r6.b;
        if (r9 == null) goto L30;
        Boolean r10 = r6.c;
        Boolean r11 = r6.e;
        Activity r12 = r6.d;
        Integer r13 = r6.f;
        Integer r14 = r6.g;
        Boolean r4 = r6.h;
        if (r4 == null) goto L26;
        r2 = r4.booleanValue();
    L26:
        rjb.a r3 = new rjb.a(r8, r9, r10, r11, r12, r13, r14, Boolean.valueOf(r2), r6.i, r6.j, r6.k, r6.l, r6.m);
        if (r6.n != OverlayType.POPUP_WINDOW) goto L29;
        g r5 = new rjb.c(r3);
    L31:
        if (r5 == null) goto L33;
        r5.show();
        WeakReference r7 = new WeakReference(r5);
    L35:
        return new tjb.b(r7);
    L29:
        r5 = new i(r3);
    L30:
        r5 = null;
    L33:
        r7 = null;
        goto L35
    L5:
        View r15 = this.e.a.get();
        if (r15 != null) goto L9;
        Log.e("BaseBubbleComponent", "viewRef get is null");
        goto L8
    L9:
        boolean r16 = i();
        h();
        r6 = new rjb.e();
        Intrinsics.checkNotNullParameter(r15, "anchorView");
        r6.b = r15;
        Intrinsics.checkNotNullParameter(this, "component");
        r6.a = this;
        OverlayType r17 = this.f.c;
        Intrinsics.checkNotNullParameter(r17, "overlayType");
        r6.n = r17;
        r6.c = Boolean.valueOf(r16);
        Boolean r18 = Boolean.TRUE;
        r6.l = r18;
        r6.m = this;
        MaskConfig r19 = this.d;
        if (r19 == null) goto L17;
        Intrinsics.checkNotNullParameter(r1, "activity");
        r6.e = r18;
        r6.d = r1;
        r6.f = Integer.valueOf(r19.a);
        r6.g = Integer.valueOf(UIUtils.getColor(r1, 2131103451));
        r6.h = r18;
        if (r19.c != MaskConfig.ShapeType.CIRCLE) goto L15;
        r6.j = 0;
    L16:
        r6.i = Integer.valueOf(UIUtils.dp2px(r1, 4.0f));
        C0328a r20 = new C0328a(r19);
        Intrinsics.checkNotNullParameter(r20, "handler");
        r6.k = r20;
        goto L17
    L15:
        r6.j = 1;
        goto L16
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ujb.b r0 = this.f.b;
        if (r0 == null) goto L6;
        r0.onDismiss();
        return;
    }

    @Override // rjb.b
    public final Rect b() {
        return l();
    }

    public Rect l() {
        return h;
    }

    public int j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return UIUtils.getColor(r2, 2131105549);
    }

    public int k(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return UIUtils.dp2px(r2, 8.0f);
    }

    @Override // rjb.b
    public final void a(Context r17, LinearLayout r18, g r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "containerView");
        Intrinsics.checkNotNullParameter(r19, "guide");
        View r3 = n(r17, m(r19));
        BubbleLayout r4 = new BubbleLayout(r17);
        BubbleLayout.b r5 = r4.getConfigSetter();
        BubbleLayout.h(r5.a, this.e.b.getValue());
        MaskConfig r6 = this.d;
        if (r6 == null) goto L14;
        Integer r7 = Integer.valueOf(r6.f);
        if (r7.intValue() == 0) goto L7;
        boolean r9 = true;
    L9:
        if (Boolean.valueOf(r9).booleanValue() == true) goto L12;
        r7 = null;
    L12:
        if (r7 == null) goto L14;
        int r8 = r7.intValue();
    L15:
        BubbleLayout.f(r5.a, r8);
        BubbleLayout.c(r5.a, UIUtils.dp2px(r17, 24.0f) * 1.0f);
        BubbleLayout.d(r5.a, UIUtils.dp2px(r17, 9.0f) * 1.0f);
        BubbleLayout.b(r5.a, k(r17) * 1.0f);
        BubbleLayout.a(r5.a, !(this instanceof d));
        BubbleLayout.e(r5.a, r3);
        BubbleLayout r10 = r5.a;
        int r11 = (int) 0.0f;
        r10.b.setPadding(r11, r11, r11, r11);
        r10.b.setFillColor(r10.f);
        r10.b.setCornerRadius(r10.g);
        r10.c.setAnchorGravity(r10.e);
        r10.c.setFillColor(r10.h);
        float r12 = r10.b.getCornerRadius();
        float r13 = r10.i;
        if (r10.l == true) goto L18;
    L20:
        r12 = r13;
    L21:
        int r14 = r10.e;
        if (r14 == 3) goto L27;
        if (r14 == 5) goto L27;
        if (r14 == 8388611) goto L27;
        if (r14 == 8388613) goto L27;
        float r15 = r10.j;
        float r16 = r10.k;
        r10.d.setPadding((int) r12, 0, 0, 0);
    L28:
        ConstraintSet r20 = new ConstraintSet();
        r20.clone(r10.d);
        r20.constrainWidth(2131364888, (int) r15);
        r20.constrainHeight(2131364888, (int) r16);
        r20.applyTo(r10.d);
        ConstraintLayout r21 = r10.a;
        int r22 = r10.e;
        ConstraintSet r23 = new ConstraintSet();
        r23.clone(r21);
        if (r22 == 8388611) goto L42;
        if (r22 == 3) goto L42;
        if (r22 == 8388613) goto L41;
        if (r22 == 5) goto L41;
        if (r22 != 48) goto L39;
        r23.connect(2131364903, 3, 0, 3);
        r23.connect(2131364903, 4, 2131364889, 3);
        r23.connect(2131364903, 6, 0, 6);
        r23.connect(2131364889, 3, 2131364903, 4);
        r23.connect(2131364889, 6, 2131364903, 6);
    L43:
        r23.applyTo(r21);
        this.g = r4;
        r18.addView(p(r17, r4));
        return;
    L39:
        if (r22 != 80) goto L43;
        r23.connect(2131364889, 3, 0, 3);
        r23.connect(2131364889, 4, 2131364903, 3);
        r23.connect(2131364889, 6, 2131364903, 6);
        r23.connect(2131364903, 3, 2131364889, 4);
        r23.connect(2131364903, 6, 0, 6);
        r23.connect(2131364903, 7, 0, 7);
    L41:
        r23.connect(2131364889, 6, 0, 6);
        r23.connect(2131364889, 7, 2131364903, 6);
        r23.connect(2131364889, 3, 2131364903, 3);
        r23.connect(2131364903, 6, 2131364889, 7);
        r23.connect(2131364903, 3, 0, 3);
        r23.connect(2131364903, 4, 0, 4);
    L42:
        r23.connect(2131364903, 6, 0, 6);
        r23.connect(2131364903, 3, 0, 3);
        r23.connect(2131364903, 4, 0, 4);
        r23.connect(2131364903, 7, 2131364889, 6);
        r23.connect(2131364889, 6, 2131364903, 7);
        r23.connect(2131364889, 3, 2131364903, 3);
    L27:
        r15 = r10.k;
        r16 = r10.j;
        r10.d.setPadding(0, (int) r12, 0, 0);
        goto L28
    L18:
        if (r13 >= r12) goto L20;
    L7:
        r9 = false;
    L14:
        r8 = j(r17);
        goto L15
    }

    @Override // rjb.b
    public final void d(LinearLayout r5, Size r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "containerView");
        Intrinsics.checkNotNullParameter(r6, "containerWH");
        Rect r8 = l();
        int r0 = c.a[this.e.b.ordinal()];
        if (r0 == 1) goto L12;
        if (r0 == 2) goto L12;
        if (r0 != 3) goto L7;
    L11:
        int r9 = r6.getWidth() - r8.left;
        int r10 = r8.right;
    L13:
        float r11 = (r9 - r10) * 1.0f;
        BubbleLayout r1 = this.g;
        if (r1 == null) goto L16;
        float r2 = r1.getArrowMainLen();
    L17:
        float r12 = r11 - r2;
        float r3 = 2;
        float r4 = (-r12) / r3;
        float r13 = r12 / r3;
        float r14 = r7;
        float r15 = 1.0f * r14;
        if (r14 >= r4) goto L21;
        r13 = r4;
    L24:
        float r16 = Math.abs(r4) + r13;
        BubbleLayout r17 = this.g;
        if (r17 == null) goto L45;
        BubbleLayout.a r18 = r17.getArrowOffsetSetter();
        if (r18 == null) goto L46;
        BubbleLayout.g(r18.a, r16);
        BubbleLayout r19 = r18.a;
        float r20 = r19.b.getCornerRadius();
        float r21 = r19.i;
        if (r19.l == true) goto L31;
    L33:
        r20 = r21;
    L34:
        int r22 = r19.e;
        if (r22 != 3) goto L37;
    L43:
        r19.d.setPadding(0, (int) r20, 0, 0);
        return;
    L37:
        if (r22 == 5) goto L43;
        if (r22 == 8388611) goto L43;
        if (r22 == 8388613) goto L43;
        r19.d.setPadding((int) r20, 0, 0, 0);
        return;
    L31:
        if (r21 >= r20) goto L33;
    L46:
        return;
    L45:
        return;
    L21:
        if (r14 > r13) goto L24;
        r13 = r15;
        goto L24
    L16:
        r2 = 0.0f;
        goto L17
    L7:
        if (r0 == 4) goto L11;
        throw new NoWhenBranchMatchedException();
    L12:
        r9 = r6.getHeight() - r8.top;
        r10 = r8.bottom;
        goto L13
    }

    @Override // rjb.b
    public final int e(LinearLayout r4, Size r5, Rect r6) {
        Intrinsics.checkNotNullParameter(r4, "containerView");
        Intrinsics.checkNotNullParameter(r5, "containerWH");
        Intrinsics.checkNotNullParameter(r6, "anchorRect");
        Rect r7 = l();
        AnchorConfig r8 = this.e;
        AnchorConfig.AnchorGravity r9 = r8.b;
        int r1 = 0;
        if (r9 != AnchorConfig.AnchorGravity.TOP) goto L5;
    L6:
        r1 = (0 + r8.c.x) + ((r7.right - r7.left) / 2);
    L8:
        if (r9 == AnchorConfig.AnchorGravity.START) goto L12;
        if (r9 == AnchorConfig.AnchorGravity.END) goto L12;
        return r1;
    L12:
        return (r1 + r8.c.y) + ((r7.bottom - r7.top) / 2);
    L5:
        if (r9 != AnchorConfig.AnchorGravity.BOTTOM) goto L8;
        goto L6
    }

    @Override // rjb.b
    public final int g(LinearLayout r4, Size r5, Rect r6) {
        Intrinsics.checkNotNullParameter(r4, "containerView");
        Intrinsics.checkNotNullParameter(r5, "containerWH");
        Intrinsics.checkNotNullParameter(r6, "anchorRect");
        int r7 = UIUtils.dp2px(r4.getContext(), 8.0f);
        MaskConfig r8 = this.d;
        if (r8 == null) goto L20;
        Rect r9 = new C0328a(r8).a(r6);
        AnchorConfig.AnchorGravity r1 = this.e.b;
        if (r1 == AnchorConfig.AnchorGravity.TOP) goto L9;
        if (r1 == AnchorConfig.AnchorGravity.BOTTOM) goto L9;
    L12:
        AnchorConfig.AnchorGravity r2 = this.e.b;
        if (r2 == AnchorConfig.AnchorGravity.START) goto L17;
        if (r2 != AnchorConfig.AnchorGravity.END) goto L20;
    L17:
        if (r9.width() <= r6.width()) goto L19;
        r7 = r7 + ((r9.width() - r6.width()) / 2);
    L19:
        r7 = r7 + this.e.c.x;
    L9:
        if (r9.height() <= r6.height()) goto L11;
        r7 = r7 + ((r9.height() - r6.height()) / 2);
    L11:
        r7 = r7 + this.e.c.y;
    L20:
        Rect r10 = l();
        AnchorConfig.AnchorGravity r11 = this.e.b;
        int r12 = c.a[r11.ordinal()];
        if (r12 == 1) goto L32;
        if (r12 != 2) goto L24;
        int r13 = r10.left;
    L34:
        return r7 - r13;
    L24:
        if (r12 != 3) goto L26;
        r13 = r10.bottom;
        goto L34
    L26:
        if (r12 != 4) goto L29;
        r13 = r10.top;
        goto L34
    L29:
        throw new NoWhenBranchMatchedException();
    L32:
        r13 = r10.right;
        goto L34
    }

    public a(WeakReference<Activity> r2, String r3, String r4, MaskConfig r5, AnchorConfig r6, ujb.a r7) {
        Intrinsics.checkNotNullParameter(r2, "activityRef");
        Intrinsics.checkNotNullParameter(r4, "detail");
        Intrinsics.checkNotNullParameter(r6, "anchorConfig");
        Intrinsics.checkNotNullParameter(r7, "bubbleConfig");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
