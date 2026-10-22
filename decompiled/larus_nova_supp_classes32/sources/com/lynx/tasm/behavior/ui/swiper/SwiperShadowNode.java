package com.lynx.tasm.behavior.ui.swiper;

import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxShadowNode;
import com.lynx.tasm.behavior.shadow.CustomLayoutShadowNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.utils.n;
import y6a.g;
import y6a.j;
import y6a.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@LynxShadowNode(tagName = "swiper")
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.swiper")
public class SwiperShadowNode extends CustomLayoutShadowNode implements y6a.e {
    public float A;
    public boolean B;
    public String C;
    public int w;
    public int x;
    public int y;
    public float z;

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void e() {
        if (this.v == false) goto L5;
        h(this);
    L5:
        super.e();
    }

    public SwiperShadowNode() {
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = 1.0f;
        this.A = 1.0f;
        this.B = false;
        this.C = "normal";
    }

    @LynxProp(name = "max-x-scale")
    public void setMaxXScale(double r4) {
        if (r4 < 0.0d) goto L6;
        this.z = (float) r4;
    L6:
        if (this.v == false) goto L9;
        q();
        return;
    }

    @LynxProp(name = "max-y-scale")
    public void setMaxYScale(double r4) {
        if (r4 < 0.0d) goto L6;
        this.A = (float) r4;
    L6:
        if (this.v == false) goto L9;
        q();
        return;
    }

    @LynxProp(name = "mode")
    public void setMode(String r1) {
        this.C = r1;
        if (this.v == false) goto L6;
        q();
        return;
    }

    @LynxProp(name = "next-margin")
    public void setNextMargin(f6a.a r4) {
        if (r4.getType() == ReadableType.String) goto L5;
        return;
    L5:
        String r5 = r4.asString();
        if (r5.endsWith("px") == false) goto L8;
    L9:
        int r6 = (int) n.d(r5, 0.0f, -1.0f, this.m.getScreenMetrics());
        if (r6 >= 0) goto L13;
        r6 = -1;
    L13:
        this.x = r6;
    L15:
        if (this.v == false) goto L18;
        q();
        return;
    L18:
        return;
    L8:
        if (r5.endsWith("rpx") == false) goto L15;
        goto L9
    }

    @LynxProp(name = "page-margin")
    public void setPageMargin(f6a.a r3) {
        if (r3.getType() != ReadableType.String) goto L17;
        String r4 = r3.asString();
        if (r4.endsWith("px") == false) goto L7;
    L8:
        int r5 = (int) n.d(r4, 0.0f, 0.0f, this.m.getScreenMetrics());
        if (r5 > 0) goto L12;
        r5 = 0;
    L12:
        this.y = r5;
    L14:
        if (this.v == false) goto L18;
        q();
        return;
    L18:
        return;
    L7:
        if (r4.endsWith("rpx") == false) goto L14;
    }

    @LynxProp(name = "previous-margin")
    public void setPreviousMargin(f6a.a r4) {
        if (r4.getType() == ReadableType.String) goto L5;
        return;
    L5:
        String r5 = r4.asString();
        if (r5.endsWith("px") == false) goto L8;
    L9:
        int r6 = (int) n.d(r5, 0.0f, -1.0f, this.m.getScreenMetrics());
        if (r6 >= 0) goto L13;
        r6 = -1;
    L13:
        this.w = r6;
    L15:
        if (this.v == false) goto L18;
        q();
        return;
    L18:
        return;
    L8:
        if (r5.endsWith("rpx") == false) goto L15;
        goto L9
    }

    @LynxProp(defaultBoolean = false, name = "vertical")
    public void setVertical(boolean r1) {
        this.B = r1;
        if (this.v == false) goto L6;
        q();
        return;
    }

    @Override // y6a.e
    public final k b(j r10, g r11) {
        j r0 = null;
        int r1 = 0;
    L4:
        if (r1 >= l()) goto L44;
        ShadowNode r2 = k(r1);
        if ((r2 instanceof NativeLayoutNodeRef) == false) goto L42;
        NativeLayoutNodeRef r3 = (NativeLayoutNodeRef) r2;
        if (r0 == null) goto L10;
        r3.D(r11, r0);
        goto L42
    L10:
        r0 = new j();
        float r4 = 0.0f;
        if (this.C.equals("coverflow") == false) goto L13;
    L33:
        float r5 = (this.w + this.x) + (this.y * 2);
        float r6 = r10.a;
        boolean r7 = this.B;
        if (r7 == false) goto L36;
        float r8 = 0.0f;
    L37:
        float r9 = r6 - r8;
        MeasureMode r12 = r10.b;
        float r13 = r10.c;
        if (r7 == false) goto L40;
        r4 = r5;
    L40:
        MeasureMode r14 = r10.d;
        r0.a = r9;
        r0.b = r12;
        r0.c = r13 - r4;
        r0.d = r14;
    L41:
        r3.D(r11, r0);
        goto L42
    L36:
        r8 = r5;
        goto L37
    L13:
        if (this.C.equals("flat-coverflow") == true) goto L33;
        if (this.C.equals("carousel") == false) goto L23;
        if (this.B == false) goto L20;
        float r15 = (float) (((double) r10.c) * 0.8d);
        float r16 = r10.a;
    L21:
        MeasureMode r17 = r10.b;
        MeasureMode r18 = r10.d;
        r0.a = r16;
        r0.b = r17;
        r0.c = r15;
        r0.d = r18;
        goto L41
    L20:
        r15 = r10.c;
        r16 = (float) (((double) r10.a) * 0.8d);
        goto L21
    L23:
        if (this.C.equals("carry") == false) goto L32;
        float r19 = (this.w + this.x) + (this.y * 2);
        float r20 = r10.a;
        boolean r21 = this.B;
        if (r21 == false) goto L27;
        float r22 = 0.0f;
    L28:
        float r23 = (r20 - r22) * this.z;
        MeasureMode r24 = r10.b;
        float r25 = r10.c;
        if (r21 == false) goto L31;
        r4 = r19;
    L31:
        float r26 = (r25 - r4) * this.A;
        MeasureMode r27 = r10.d;
        r0.a = r23;
        r0.b = r24;
        r0.c = r26;
        r0.d = r27;
        goto L41
    L27:
        r22 = r19;
        goto L28
    L32:
        float r28 = r10.a;
        MeasureMode r29 = r10.b;
        float r30 = r10.c;
        MeasureMode r31 = r10.d;
        r0.a = r28;
        r0.b = r29;
        r0.c = r30;
        r0.d = r31;
    L42:
        r1 = r1 + 1;
        goto L4
    L44:
        return new k(r10.a, r10.c);
    }

    @Override // y6a.e
    public final void d(y6a.b r2, y6a.a r3) {
        int r4 = 0;
    L4:
        if (r4 >= l()) goto L9;
        ShadowNode r5 = k(r4);
        if ((r5 instanceof NativeLayoutNodeRef) == false) goto L8;
        NativeLayoutNodeRef r6 = (NativeLayoutNodeRef) r5;
        r6.C(new y6a.b());
    L8:
        r4 = r4 + 1;
        goto L4
    }
}
