package fn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ies.xelement.viewpager.childitem.AndroidNestedScrollView;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.behavior.ui.list.container.ListContainerView;
import com.lynx.tasm.behavior.ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f16932b;

    public /* synthetic */ a(FrameLayout r5, Context r10, int r11) {
        this.f16931a = r11;
        this.f16932b = r5;
        super(r10);
    }

    private final void a(int r5, int r10, int r11, int r12, boolean r13) {
    }

    private final void b(int r5, int r10, int r11, int r12, boolean r13) {
    }

    private final void c(int r5, int r10, int r11, int r12, boolean r13) {
    }

    private final void d(int r5, int r10, int r11, int r12, boolean r13) {
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int r5) {
        switch(this.f16931a) {
            case 1: goto L6;
            default: goto L5;
        };
    L6:
        AndroidScrollView r10 = (AndroidScrollView) this.f16932b;
        if (r10.f10598m.isEnableNewGesture() == false) goto L10;
        return super.canScrollHorizontally(r5);
    L10:
        if (r10.J == false) goto L14;
        if (r10.s == false) goto L14;
    L15:
        return true;
    L14:
        if (super.canScrollHorizontally(r5) == true) goto L15;
        return false;
    L5:
        return super.canScrollHorizontally(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        switch(this.f16931a) {
            case 0: goto L25;
            case 1: goto L18;
            case 2: goto L11;
            default: goto L4;
        };
    L4:
        AndroidNestedScrollView r10 = (AndroidNestedScrollView) this.f16932b;
        com.lynx.tasm.behavior.ui.b r11 = r10.f6532l;
        if (r11 == null) goto L7;
        r11.beforeDispatchDraw(r5);
    L7:
        super.dispatchDraw(r5);
        com.lynx.tasm.behavior.ui.b r12 = r10.f6532l;
        if (r12 == null) goto L32;
        r12.afterDispatchDraw(r5);
        return;
    L32:
        return;
    L11:
        com.bytedance.ies.xelement.AndroidNestedScrollView r13 = (com.bytedance.ies.xelement.AndroidNestedScrollView) this.f16932b;
        com.lynx.tasm.behavior.ui.b r14 = r13.f6341l;
        if (r14 == null) goto L14;
        r14.beforeDispatchDraw(r5);
    L14:
        super.dispatchDraw(r5);
        com.lynx.tasm.behavior.ui.b r15 = r13.f6341l;
        if (r15 == null) goto L33;
        r15.afterDispatchDraw(r5);
        return;
    L33:
        return;
    L18:
        AndroidScrollView r16 = (AndroidScrollView) this.f16932b;
        com.lynx.tasm.behavior.ui.b r17 = r16.f10608x;
        if (r17 == null) goto L21;
        r17.beforeDispatchDraw(r5);
    L21:
        super.dispatchDraw(r5);
        com.lynx.tasm.behavior.ui.b r18 = r16.f10608x;
        if (r18 == null) goto L34;
        r18.afterDispatchDraw(r5);
        return;
    L34:
        return;
    L25:
        ListContainerView r19 = (ListContainerView) this.f16932b;
        com.lynx.tasm.behavior.ui.b r20 = r19.E;
        if (r20 == null) goto L28;
        r20.beforeDispatchDraw(r5);
    L28:
        super.dispatchDraw(r5);
        com.lynx.tasm.behavior.ui.b r21 = r19.E;
        if (r21 == null) goto L35;
        r21.afterDispatchDraw(r5);
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas r5, View r10, long r11) {
        switch(this.f16931a) {
            case 0: goto L29;
            case 1: goto L18;
            case 2: goto L11;
            default: goto L4;
        };
    L4:
        AndroidNestedScrollView r12 = (AndroidNestedScrollView) this.f16932b;
        com.lynx.tasm.behavior.ui.b r13 = r12.f6532l;
        if (r13 == null) goto L7;
        r13.beforeDrawChild(r5, r10, r11);
    L7:
        boolean r14 = super.drawChild(r5, r10, r11);
        com.lynx.tasm.behavior.ui.b r15 = r12.f6532l;
        if (r15 == null) goto L10;
        r15.afterDrawChild(r5, r10, r11);
    L10:
        return r14;
    L11:
        com.bytedance.ies.xelement.AndroidNestedScrollView r16 = (com.bytedance.ies.xelement.AndroidNestedScrollView) this.f16932b;
        com.lynx.tasm.behavior.ui.b r17 = r16.f6341l;
        if (r17 == null) goto L14;
        r17.beforeDrawChild(r5, r10, r11);
    L14:
        boolean r18 = super.drawChild(r5, r10, r11);
        com.lynx.tasm.behavior.ui.b r19 = r16.f6341l;
        if (r19 == null) goto L17;
        r19.afterDrawChild(r5, r10, r11);
    L17:
        return r18;
    L18:
        AndroidScrollView r20 = (AndroidScrollView) this.f16932b;
        com.lynx.tasm.behavior.ui.b r21 = r20.f10608x;
        if (r21 == null) goto L21;
        Rect r22 = r21.beforeDrawChild(r5, r10, r11);
    L22:
        if (r22 == null) goto L24;
        r5.save();
        r5.clipRect(r22);
        boolean r23 = super.drawChild(r5, r10, r11);
        r5.restore();
    L25:
        com.lynx.tasm.behavior.ui.b r24 = r20.f10608x;
        if (r24 == null) goto L28;
        r24.afterDrawChild(r5, r10, r11);
    L28:
        return r23;
    L24:
        r23 = super.drawChild(r5, r10, r11);
        goto L25
    L21:
        r22 = null;
        goto L22
    L29:
        ListContainerView r25 = (ListContainerView) this.f16932b;
        com.lynx.tasm.behavior.ui.b r26 = r25.E;
        if (r26 == null) goto L32;
        Rect r27 = r26.beforeDrawChild(r5, r10, r11);
    L33:
        if (r27 == null) goto L35;
        r5.save();
        r5.clipRect(r27);
        boolean r28 = super.drawChild(r5, r10, r11);
        r5.restore();
    L36:
        com.lynx.tasm.behavior.ui.b r29 = r25.E;
        if (r29 == null) goto L39;
        r29.afterDrawChild(r5, r10, r11);
    L39:
        return r28;
    L35:
        r28 = super.drawChild(r5, r10, r11);
        goto L36
    L32:
        r27 = null;
        goto L33
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = this.f16931a;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        switch(this.f16931a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        AndroidNestedScrollView r11 = (AndroidNestedScrollView) this.f16932b;
        setMeasuredDimension(r11.g, r11.f6528h);
        return;
    L6:
        com.bytedance.ies.xelement.AndroidNestedScrollView r12 = (com.bytedance.ies.xelement.AndroidNestedScrollView) this.f16932b;
        setMeasuredDimension(r12.g, r12.f6337h);
        return;
    L8:
        AndroidScrollView r13 = (AndroidScrollView) this.f16932b;
        setMeasuredDimension(r13.f10605u, r13.f10606v);
        return;
    L10:
        ListContainerView r14 = (ListContainerView) this.f16932b;
        UIListContainer r15 = r14.f10546z;
        if (r15 != null) goto L13;
        LynxLog.b(4, "ListContainerView", "CustomLinearLayout$$onMeasure: mUiListContainer is null: " + this + ", " + r14);
        setMeasuredDimension(0, 0);
        return;
    L13:
        int r16 = r14.G;
        if (r16 > 0) goto L17;
        r16 = r15.getWidth();
    L17:
        int r17 = r14.H;
        if (r17 > 0) goto L21;
        r17 = r14.f10546z.getHeight();
    L21:
        setMeasuredDimension(r16, r17);
    }
}
