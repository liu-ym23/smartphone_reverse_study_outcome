package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.DeviceUtils;
import java.util.ArrayList;
import java.util.List;
import z6a.i;
import z6a.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class InlineTextShadowNode extends BaseTextShadowNode {
    public int M;
    public com.lynx.tasm.behavior.ui.utils.e N;
    public boolean O;

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean p() {
        return true;
    }

    public InlineTextShadowNode() {
        this.M = 0;
        this.O = false;
    }

    @LynxProp(defaultInt = 0, name = "background-color")
    public void setBackgroundColor(int r2) {
        if (this.M == r2) goto L6;
        this.M = r2;
        q();
        return;
    }

    @LynxProp(name = "background-image")
    public void setBackgroundImage(ReadableArray r3) {
        q();
        if (r3 != null) goto L6;
        this.O = false;
        return;
    L6:
        this.N.b().e.d(r3, null);
        this.O = true;
    }

    @LynxProp(name = "background-position")
    public void setBackgroundPosition(ReadableArray r2) {
        this.N.i(r2);
        q();
    }

    @LynxProp(name = "background-repeat")
    public void setBackgroundRepeat(ReadableArray r2) {
        this.N.j(r2);
        q();
    }

    @LynxProp(name = "background-size")
    public void setBackgroundSize(ReadableArray r2) {
        this.N.k(r2);
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void setTextAlign(int r2) {
        super.setTextAlign(r2);
        if (this.A == false) goto L6;
        LLog.e("InlineTextShadowNode", "inline-text will no longer support text-align in future, set on root text instead");
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @LynxProp(name = "vertical-align")
    public void setVerticalAlign(ReadableArray r1) {
        y(r1);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r2) {
        super.w(r2);
        this.N = new com.lynx.tasm.behavior.ui.utils.e(r2);
    }

    @LynxPropGroup(names = {"border-radius", "border-top-left-radius", "border-top-right-radius", "border-bottom-right-radius", "border-bottom-left-radius"})
    public void setBorderRadius(int r2, ReadableArray r3) {
        this.N.q(r2, r3);
        q();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void F(int r6, int r7, List<BaseTextShadowNode.a> r8) {
        super.F(r6, r7, r8);
        if (r() == false) goto L6;
        BaseTextShadowNode.a r0 = new BaseTextShadowNode.a(r6, r7, A());
        ((ArrayList) r8).add(r0);
    L6:
        if (this.M == 0) goto L9;
        BaseTextShadowNode.a r1 = new BaseTextShadowNode.a(r6, r7, new BackgroundColorSpan(this.M));
        ((ArrayList) r8).add(r1);
    L9:
        if (this.O == false) goto L12;
        BaseTextShadowNode.a r2 = new BaseTextShadowNode.a(r6, r7, new l(r6, r7, this.N));
        ((ArrayList) r8).add(r2);
    L12:
        if (y6a.l.a(this.v.n) == true) goto L15;
        BaseTextShadowNode.a r3 = new BaseTextShadowNode.a(r6, r7, new AbsoluteSizeSpan(Math.round(this.v.n)));
        ((ArrayList) r8).add(r3);
    L15:
        if (TextUtils.isEmpty(this.v.u) == true) goto L22;
        a r4 = this.v;
        String r5 = r4.u;
        int r9 = r4.e();
        Typeface r10 = g.d(getContext(), r5, r9);
        if (r10 != null) goto L19;
        FontFaceManager.g.a.g(getContext(), r5, r9, new TextShadowNode.a(this));
        r10 = DeviceUtils.b();
    L20:
        ArrayList r11 = (ArrayList) r8;
        r11.add(new BaseTextShadowNode.a(r6, r7, new i(r10)));
        return;
    L19:
        this.v.B = true;
        goto L20
    }
}
