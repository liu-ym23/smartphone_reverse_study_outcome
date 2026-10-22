package fn;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.list.container.ListContainerView;
import com.lynx.tasm.behavior.ui.list.container.NestedScrollContainerView;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import ym.o;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f16954c;
    public int d;
    public final c e;
    public e f;
    public final /* synthetic */ ListContainerView g;

    public g(ListContainerView r5) {
        this.g = r5;
        this.e = new c(r5.getContext(), NestedScrollContainerView.f10547y);
    }

    public final float a(boolean r10) {
        ListContainerView r11 = this.g;
        boolean r5 = r11.f10549b;
        float r12 = Float.MAX_VALUE;
        float r13 = Float.MIN_VALUE;
        if (r11.getChildCount() <= 0) goto L33;
        int r14 = 0;
        if ((r11.getChildAt(0) instanceof ViewGroup) == false) goto L33;
        ViewGroup r15 = (ViewGroup) r11.getChildAt(0);
        if (r10 == false) goto L24;
    L9:
        if (r14 >= r15.getChildCount()) goto L19;
        View r16 = r15.getChildAt(r14);
        if (r5 == false) goto L14;
        float r17 = r16.getY();
        int r18 = r16.getHeight();
    L13:
        float r19 = r17 + r18;
        if (r13 >= r19) goto L18;
        r13 = r19;
    L18:
        r14 = r14 + 1;
        goto L9
    L14:
        r17 = r16.getX();
        r18 = r16.getWidth();
        goto L13
    L19:
        if (r5 == false) goto L21;
        int r20 = r11.getHeight();
    L22:
        r13 = r13 - r20;
        goto L33
    L21:
        r20 = r11.getWidth();
    L24:
        if (r14 >= r15.getChildCount()) goto L33;
        View r21 = r15.getChildAt(r14);
        if (r5 == false) goto L28;
        float r22 = r21.getY();
    L30:
        if (r12 <= r22) goto L32;
        r12 = r22;
    L32:
        r14 = r14 + 1;
        goto L24
    L28:
        r22 = r21.getX();
    L33:
        if (r10 == false) goto L35;
        return r13;
    L35:
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(int r22, int r23) {
        ListContainerView r5 = this.g;
        en.h r10 = r5.f10548a;
        boolean r11 = r5.f10549b;
        UIListContainer r12 = r5.f10546z;
        if (r12 != null) goto L5;
        boolean r13 = false;
    L6:
        r10.f16844b = r11;
        r10.f16845c = r13;
        int[] r14 = {0, 0};
        if (r11 == false) goto L10;
        if (r23 != 0) goto L11;
    L12:
        boolean r15 = false;
    L13:
        o r16 = r10.f16843a;
        int r17 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getLinearLayout().getChildCount();
        int r18 = Integer.MIN_VALUE;
        int r19 = Integer.MAX_VALUE;
        int r110 = 0;
        View r111 = null;
        View r112 = null;
    L14:
        int r113 = r10.e;
        double r20 = r10.d;
        if (r110 >= r17) goto L39;
        View r21 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getLinearLayout().getChildAt(r110);
        if (r21 != null) goto L19;
        r5 = r5;
        int r114 = r17;
    L36:
        r110 = r110 + 1;
        r17 = r114;
        r5 = r5;
        goto L14
    L19:
        r114 = r17;
        if ((r21 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L38;
        com.lynx.tasm.behavior.ui.view.b r24 = (com.lynx.tasm.behavior.ui.view.b) r21;
        if ((r24.getDrawChildHook() instanceof LynxBaseUI) == false) goto L38;
        LynxBaseUI r25 = (LynxBaseUI) r24.getDrawChildHook();
        if (r10.f16844b == false) goto L27;
        int r26 = (int) (((((double) r25.getHeight()) * r20) + ((double) r25.getTop())) + ((double) r113));
        double r27 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getScrollY();
        int r28 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getHeight();
    L26:
        int r29 = r26 - ((int) (((((double) r28) * r20) + r27) + ((double) r113)));
        if (r29 > 0) goto L31;
        if (r29 <= r18) goto L31;
        r18 = r29;
        r112 = r21;
    L32:
        if (r29 < 0) goto L35;
        if (r29 >= r19) goto L35;
        r19 = r29;
        r111 = r21;
    L35:
        r111 = r111;
    L31:
        r112 = r112;
        goto L32
    L27:
        r26 = (int) (((((double) r25.getWidth()) * r20) + ((double) r25.getLeft())) + ((double) r113));
        r27 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getScrollX();
        r28 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getWidth();
    L38:
        throw new RuntimeException("A list-item is not an AndroidView, some thing went wrong");
    L39:
        ListContainerView r115 = r5;
        View r116 = r111;
        View r210 = r112;
        if (r10.f16844b == false) goto L43;
        if (r23 >= 0) goto L44;
    L45:
        boolean r30 = false;
    L47:
        if (r15 == true) goto L59;
        if (r116 == null) goto L54;
        if (r210 == null) goto L54;
        if (Math.abs(r19) >= Math.abs(r18)) goto L53;
        View r117 = r116;
        int r31 = r16.c(r117);
        View r118 = r210;
    L67:
        if (r31 != (-1)) goto L86;
        if (r30 == false) goto L71;
        r117 = r118;
    L71:
        if (r117 != null) goto L73;
        r31 = -1;
        goto L86
    L73:
        int r32 = r16.c(r117);
        if (r10.f16844b == false) goto L77;
    L81:
        if (r30 == true) goto L83;
        int r33 = -1;
    L84:
        r31 = r32 + r33;
        goto L86
    L83:
        r33 = 1;
        goto L84
    L77:
        if (r10.f16845c == false) goto L81;
        if (r30 == true) goto L80;
        r30 = true;
        goto L81
    L80:
        r30 = false;
    L86:
        if (r10.f16844b == false) goto L88;
        int r34 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getScrollY();
    L89:
        if (r31 == (-1)) goto L109;
        r31 = Math.min(Math.max(r31, 0), ((UIListContainer) r16.f23310b).f10569c.size() - 1);
        if (r31 == (-1)) goto L109;
        String r35 = (String) ((UIListContainer) r16.f23310b).f10569c.get(r31);
        int r36 = 0;
    L93:
        UIListContainer r119 = (UIListContainer) r16.f23310b;
        if (r36 >= ((ListContainerView) UIListContainer.s(r119)).getLinearLayout().getChildCount()) goto L99;
        View r120 = ((ListContainerView) UIListContainer.v(r119)).getLinearLayout().getChildAt(r36);
        if (r35.equals(((UIComponent) ((com.lynx.tasm.behavior.ui.view.c) r120).getDrawChildHook()).f10770b) == true) goto L97;
        r36 = r36 + 1;
        goto L93
    L97:
        View r37 = r120;
    L100:
        if (r37 != null) goto L102;
        int r38 = -1;
    L115:
        if (r10.f16844b == false) goto L117;
        r14[1] = r34;
    L118:
        ((UIListContainer) r16.f23310b).m(r38, ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getScrollX(), ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getScrollY(), r14[0], r14[1]);
        int r39 = r14[0] - this.f16952a;
        int r40 = r14[1] - this.f16953b;
        if (r115.f10549b == false) goto L121;
        int r41 = r40;
    L122:
        int r42 = (int) (Math.ceil(Math.ceil(((double) Math.abs(r41)) * r115.f10548a.f)) / 0.3356d);
        if (r42 >= 100) goto L125;
        int r121 = 100;
    L126:
        this.e.b(this.f16952a, this.f16953b, r39, r40, r121);
        return;
    L125:
        r121 = r42;
        goto L126
    L121:
        r41 = r39;
        goto L122
    L117:
        r14[0] = r34;
        goto L118
    L102:
        if ((r37 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L112;
        com.lynx.tasm.behavior.ui.view.b r43 = (com.lynx.tasm.behavior.ui.view.b) r37;
        if ((r43.getDrawChildHook() instanceof LynxBaseUI) == false) goto L112;
        LynxBaseUI r44 = (LynxBaseUI) r43.getDrawChildHook();
        if (r10.f16844b == false) goto L110;
        double r45 = r44.getTop();
        int r46 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getHeight();
        int r47 = r44.getHeight();
    L108:
        r34 = (int) ((r45 - (((double) (r46 - r47)) * r20)) + ((double) r113));
        goto L109
    L110:
        r45 = r44.getLeft();
        r46 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getWidth();
        r47 = r44.getWidth();
    L112:
        throw new RuntimeException("The target list-item is not an AndroidView, some thing went wrong");
    L99:
        r37 = null;
    L109:
        r38 = r31;
        goto L115
    L88:
        r34 = ((ListContainerView) ((UIListContainer) r16.f23310b).getView()).getScrollX();
        goto L89
    L53:
        r117 = r116;
        r118 = r210;
        r31 = r16.c(r118);
    L54:
        r117 = r116;
        r118 = r210;
        if (r117 == null) goto L57;
        r31 = r16.c(r117);
        goto L67
    L57:
        if (r118 == null) goto L66;
        r31 = r16.c(r118);
    L66:
        r31 = -1;
        goto L67
    L59:
        r117 = r116;
        r118 = r210;
        if (r30 == false) goto L63;
        if (r117 == null) goto L63;
        r31 = r16.c(r117);
    L63:
        if (r30 == true) goto L66;
        if (r118 == null) goto L66;
        r31 = r16.c(r118);
    L44:
        r30 = true;
        goto L47
    L43:
        if (r22 < 0) goto L45;
    L11:
        r15 = true;
        goto L13
    L10:
        if (r22 == 0) goto L12;
    L5:
        r13 = r12.isRtl();
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        c r5 = this.e;
        boolean r10 = r5.e();
        boolean r11 = false;
        ListContainerView r12 = this.g;
        if (r10 == false) goto L51;
        int[] r13 = r12.f10556m;
        int r14 = ((b) r5.f16948b).f16936b;
        int r15 = ((b) r5.f16949c).f16936b;
        e r16 = this.f;
        if (r16 == null) goto L29;
        h r17 = (h) r16;
        UIListContainer r18 = r17.f16957c;
        boolean r19 = r18.f10567a;
        if (r19 == true) goto L9;
        int r20 = r14;
    L10:
        int r110 = r17.f16955a;
        if (r110 == 0) goto L13;
        r20 = (int) (((r18.C * 1.0f) / r110) * r20);
    L13:
        int r21 = r18.C;
        if (r21 <= 0) goto L21;
        boolean r22 = r17.f16956b;
        if (r22 == false) goto L18;
        if (r20 <= r21) goto L18;
    L20:
        r20 = r21;
    L18:
        if (r22 == true) goto L21;
        if (r20 < r21) goto L20;
    L21:
        if (r19 == true) goto L24;
        r14 = r20;
    L24:
        int[] r23 = r12.f10559p;
        r23[0] = r14;
        if (r19 == false) goto L27;
        r15 = r20;
    L27:
        r23[1] = r15;
    L28:
        int r111 = r14;
        int r112 = r111 - this.f16952a;
        int r113 = r15 - this.f16953b;
        if (r12.dispatchNestedPreScroll(r112, r113, r13, null, 1) == false) goto L33;
        r112 = r112 - r13[0];
        r113 = r113 - r13[1];
    L33:
        int[] r24 = r12.f10558o;
        r24[0] = 0;
        r24[1] = 0;
        r12.a(r112, r113, r24);
        int[] r25 = r12.f10558o;
        int r114 = r25[0];
        int r115 = r25[1];
        int r26 = r112 - r114;
        int r27 = r113 - r115;
        r12.f10564v.dispatchNestedScroll(r114, r115, r26, r27, null, 1);
        boolean r28 = r12.f10549b;
        if (r28 == false) goto L39;
        if (r113 == 0) goto L38;
        if (r113 == 0) goto L39;
        if (r27 != 0) goto L39;
    L38:
        r11 = true;
    L39:
        if (r28 == true) goto L44;
        if (r112 == 0) goto L49;
        if (r112 == 0) goto L44;
        if (r26 != 0) goto L44;
    L49:
        this.f16952a = r12.getScrollX();
        int r29 = r12.getScrollY();
        this.f16953b = r29;
        this.f16954c = (r111 - this.f16952a) + this.f16954c;
        this.d = (r15 - r29) + this.d;
        r12.removeCallbacks(this);
        ViewCompat.postOnAnimation(r12, this);
        return;
    L44:
        if (r11 == true) goto L49;
        if (r12.f10564v.hasNestedScrollingParent(1) == true) goto L49;
        r12.setScrollState(1);
        goto L49
    L9:
        r20 = r15;
        goto L10
    L29:
        r14 = r14 - this.f16954c;
        r15 = r15 - this.d;
        goto L28
    L51:
        r12.setScrollState(1);
        if (r12.f10564v.hasNestedScrollingParent(1) == false) goto L54;
        r12.f10564v.stopNestedScroll(1);
    L54:
        this.f16952a = 0;
        this.f16953b = 0;
        this.f16954c = 0;
        this.d = 0;
        e r30 = this.f;
        if (r30 == null) goto L64;
        UIListContainer r31 = ((h) r30).f16957c;
        LynxContext r32 = r31.getLynxContext();
        if (r32 != null) goto L59;
        return;
    L59:
        if (r32.f10141i == null) goto L66;
        com.lynx.tasm.i r33 = r31.getLynxContext().f10141i;
        int r34 = r31.getSign();
        LynxTemplateRender r35 = (LynxTemplateRender) r33.f10879a;
        if (r35 == null) goto L67;
        r35.b0(r34);
        return;
    L67:
        return;
    L66:
        return;
    }
}
