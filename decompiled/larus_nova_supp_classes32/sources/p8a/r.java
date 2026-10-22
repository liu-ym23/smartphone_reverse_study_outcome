package p8a;

import com.lynx.markdown.IMarkdownViewHandle;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.xelement.markdown.LynxUIMarkdownShadowNode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r implements IMarkdownViewHandle {
    public final NativeLayoutNodeRef a;
    public final s b;
    public LynxBaseUI c;
    public int d;
    public int e;
    public int f;
    public int g;

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final void requestAlign() {
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final void requestDraw() {
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final void requestMeasure() {
    }

    public final LynxBaseUI a() {
        LynxContext r0 = ((LynxUIMarkdownShadowNode) this.b).m;
        if (this.c != null) goto L9;
        if (r0 == null) goto L9;
        if (r0.getLynxUIOwner() == null) goto L9;
        this.c = r0.getLynxUIOwner().findLynxUIBySign(this.a.b);
    L9:
        return this.c;
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final int getVerticalAlign() {
        y6a.n r0 = this.a.n;
        if (r0 != null) goto L5;
        return 2;
    L5:
        int r1 = r0.a;
        if (r1 != 4) goto L8;
        return 0;
    L8:
        if (r1 != 5) goto L11;
        return 0;
    L11:
        if (r1 != 11) goto L13;
        return 1;
    L13:
        if (r1 != 6) goto L16;
        return 1;
    L16:
        if (r1 != 7) goto L18;
        return 3;
    L18:
        if (r1 == 8) goto L27;
        return 2;
    L27:
        return 3;
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final long getPosition() {
        LynxBaseUI r0 = a();
        if (r0 == null) goto L7;
        return com.lynx.markdown.i.a(r0.getLeft(), r0.getTop());
    L7:
        return com.lynx.markdown.i.a(this.f, this.g);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final long getSize() {
        LynxBaseUI r0 = a();
        if (r0 == null) goto L7;
        return com.lynx.markdown.i.a(r0.getWidth(), r0.getHeight());
    L7:
        return com.lynx.markdown.i.a(this.d, this.e);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final void setVisibility(boolean r3) {
        LynxBaseUI r0 = a();
        if ((r0 instanceof LynxUI) == false) goto L10;
        LynxUI r1 = (LynxUI) r0;
        if (r3 == false) goto L7;
        int r4 = 0;
    L8:
        r1.setVisibilityForView(r4);
        return;
    L7:
        r4 = 4;
        goto L8
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final void align(int r2, int r3) {
        if (this.a.o == false) goto L5;
        return;
    L5:
        this.f = r2;
        this.g = r3;
        y6a.b r0 = new y6a.b();
        r0.a = r2;
        r0.b = r3;
        if (((LynxUIMarkdownShadowNode) this.b).A != null) goto L8;
        new y6a.a();
    L8:
        this.a.C(r0);
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final void setPosition(int r2, int r3) {
        this.f = r2;
        this.g = r3;
        LynxBaseUI r0 = a();
        if (r0 == null) goto L6;
        r0.setLeft(r2);
        r0.setTop(r3);
        return;
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final void setSize(int r2, int r3) {
        this.d = r2;
        this.e = r3;
        LynxBaseUI r0 = a();
        if (r0 == null) goto L6;
        r0.setWidth(r2);
        r0.setHeight(r3);
        return;
    }

    public r(NativeLayoutNodeRef r2, LynxBaseUI r3, s r4) {
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.a = r2;
        this.c = r3;
        this.b = r4;
    }

    @Override // com.lynx.markdown.IMarkdownViewHandle
    public final long measure(int r4, int r5, int r6, int r7) {
        y6a.g r0 = ((LynxUIMarkdownShadowNode) this.b).z;
        if (this.a.o == true) goto L9;
        if (r0 == null) goto L9;
        y6a.j r1 = new y6a.j();
        r1.a = r4;
        r1.c = r6;
        r1.b = MeasureMode.fromInt(r5);
        r1.d = MeasureMode.fromInt(r7);
        float[] r8 = this.a.E(r0, r1).a;
        int r9 = (int) r8[0];
        this.d = r9;
        int r10 = (int) r8[1];
        this.e = r10;
        return com.lynx.markdown.i.b(r9, r10, (int) r8[2]);
    L9:
        return com.lynx.markdown.i.b(0, 0, 0);
    }
}
