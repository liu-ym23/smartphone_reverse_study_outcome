package com.lynx.tasm.behavior.ui.swiper;

import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LayoutNodeManager;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.utils.k;
import pm.a;
import ym.e;
import ym.g;
import ym.i;
import ym.j;

/* JADX INFO: loaded from: classes2.dex */
public class SwiperShadowNode extends CustomLayoutShadowNode implements e {
    public float A;
    public boolean B;
    public String C;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10664w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10665x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10666y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f10667z;

    public SwiperShadowNode() {
        this.f10664w = -1;
        this.f10665x = -1;
        this.f10666y = -1;
        this.f10667z = 1.0f;
        this.A = 1.0f;
        this.B = false;
        this.C = "normal";
    }

    @Override // ym.e
    public final j a(g r10, i r11) {
        i r5 = null;
        int r12 = 0;
    L4:
        if (r12 >= j()) goto L44;
        ShadowNode r13 = e(r12);
        if ((r13 instanceof NativeLayoutNodeRef) == false) goto L42;
        NativeLayoutNodeRef r14 = (NativeLayoutNodeRef) r13;
        if (r5 == null) goto L10;
        r14.a(r10, r5);
        goto L42
    L10:
        r5 = new i();
        float r15 = 0.0f;
        if (this.C.equals("coverflow") == false) goto L13;
    L33:
        float r16 = (this.f10666y * 2) + (this.f10664w + this.f10665x);
        float r17 = r11.f23299a;
        boolean r18 = this.B;
        if (r18 == false) goto L36;
        float r19 = 0.0f;
    L37:
        float r20 = r17 - r19;
        MeasureMode r21 = r11.f23300b;
        float r22 = r11.f23301c;
        if (r18 == false) goto L40;
        r15 = r16;
    L40:
        MeasureMode r23 = r11.d;
        r5.f23299a = r20;
        r5.f23300b = r21;
        r5.f23301c = r22 - r15;
        r5.d = r23;
    L41:
        r14.a(r10, r5);
        goto L42
    L36:
        r19 = r16;
        goto L37
    L13:
        if (this.C.equals("flat-coverflow") == true) goto L33;
        if (this.C.equals("carousel") == false) goto L23;
        if (this.B == false) goto L20;
        float r24 = (float) (((double) r11.f23301c) * 0.8d);
        float r25 = r11.f23299a;
    L21:
        MeasureMode r26 = r11.f23300b;
        MeasureMode r27 = r11.d;
        r5.f23299a = r25;
        r5.f23300b = r26;
        r5.f23301c = r24;
        r5.d = r27;
        goto L41
    L20:
        r24 = r11.f23301c;
        r25 = (float) (((double) r11.f23299a) * 0.8d);
        goto L21
    L23:
        if (this.C.equals("carry") == false) goto L32;
        float r28 = (this.f10666y * 2) + (this.f10664w + this.f10665x);
        float r29 = r11.f23299a;
        boolean r30 = this.B;
        if (r30 == false) goto L27;
        float r31 = 0.0f;
    L28:
        float r32 = (r29 - r31) * this.f10667z;
        MeasureMode r33 = r11.f23300b;
        float r34 = r11.f23301c;
        if (r30 == false) goto L31;
        r15 = r28;
    L31:
        float r35 = (r34 - r15) * this.A;
        MeasureMode r36 = r11.d;
        r5.f23299a = r32;
        r5.f23300b = r33;
        r5.f23301c = r35;
        r5.d = r36;
        goto L41
    L27:
        r31 = r28;
        goto L28
    L32:
        float r37 = r11.f23299a;
        MeasureMode r38 = r11.f23300b;
        float r39 = r11.f23301c;
        MeasureMode r40 = r11.d;
        r5.f23299a = r37;
        r5.f23300b = r38;
        r5.f23301c = r39;
        r5.d = r40;
    L42:
        r12 = r12 + 1;
        goto L4
    L44:
        return new j(r11.f23299a, r11.f23301c);
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void c() {
        if (this.f10333v == false) goto L7;
        this.g = this;
        LayoutNodeManager r5 = this.f10334a;
        if (r5 == null) goto L7;
        this.d = true;
        r5.d(this.f10335b, this);
    L7:
        super.c();
    }

    @c0(name = "max-x-scale")
    public void setMaxXScale(double r5) {
        if (r5 < 0.0d) goto L6;
        this.f10667z = (float) r5;
    L6:
        if (this.f10333v == false) goto L9;
        n();
        return;
    }

    @c0(name = "max-y-scale")
    public void setMaxYScale(double r5) {
        if (r5 < 0.0d) goto L6;
        this.A = (float) r5;
    L6:
        if (this.f10333v == false) goto L9;
        n();
        return;
    }

    @c0(name = "mode")
    public void setMode(String r5) {
        this.C = r5;
        if (this.f10333v == false) goto L6;
        n();
        return;
    }

    @c0(name = "next-margin")
    public void setNextMargin(a r5) {
        if (r5.getType() != ReadableType.String) goto L19;
        String r10 = r5.asString();
        if (r10.endsWith("px") == false) goto L8;
    L9:
        int r11 = (int) k.d(r10, 0.0f, -1.0f, this.f10349m.f10152u);
        if (r11 >= 0) goto L13;
        r11 = -1;
    L13:
        this.f10665x = r11;
    L15:
        if (this.f10333v == false) goto L18;
        n();
        return;
    L18:
        return;
    L8:
        if (r10.endsWith("rpx") == false) goto L15;
    }

    @c0(name = "page-margin")
    public void setPageMargin(a r5) {
        if (r5.getType() != ReadableType.String) goto L17;
        String r10 = r5.asString();
        if (r10.endsWith("px") == false) goto L7;
    L8:
        int r11 = (int) k.d(r10, 0.0f, 0.0f, this.f10349m.f10152u);
        if (r11 > 0) goto L12;
        r11 = 0;
    L12:
        this.f10666y = r11;
    L14:
        if (this.f10333v == false) goto L18;
        n();
        return;
    L18:
        return;
    L7:
        if (r10.endsWith("rpx") == false) goto L14;
    }

    @c0(name = "previous-margin")
    public void setPreviousMargin(a r5) {
        if (r5.getType() != ReadableType.String) goto L19;
        String r10 = r5.asString();
        if (r10.endsWith("px") == false) goto L8;
    L9:
        int r11 = (int) k.d(r10, 0.0f, -1.0f, this.f10349m.f10152u);
        if (r11 >= 0) goto L13;
        r11 = -1;
    L13:
        this.f10664w = r11;
    L15:
        if (this.f10333v == false) goto L18;
        n();
        return;
    L18:
        return;
    L8:
        if (r10.endsWith("rpx") == false) goto L15;
    }

    @c0(defaultBoolean = false, name = "vertical")
    public void setVertical(boolean r5) {
        this.B = r5;
        if (this.f10333v == false) goto L6;
        n();
        return;
    }

    @Override // ym.e
    public final void a() {
        int r5 = 0;
    L4:
        if (r5 >= j()) goto L18;
        ShadowNode r10 = e(r5);
        if ((r10 instanceof NativeLayoutNodeRef) == false) goto L17;
        NativeLayoutNodeRef r11 = (NativeLayoutNodeRef) r10;
        if (r11.f10351o == false) goto L16;
        String r12 = r11.f10346j;
        if (r12 == null) goto L15;
        String r13 = "alignNativeNode for null, tag: ".concat(r12);
        if (r11.f10349m == null) goto L17;
        LynxError r14 = new LynxError(60401, r13, "", "error");
        r11.f10349m.b(r14);
        goto L17
    L15:
        throw new AssertionError();
    L16:
        r11.f10334a.c(0.0f, 0.0f, r11.f10335b);
    L17:
        r5 = r5 + 1;
        goto L4
    }
}
