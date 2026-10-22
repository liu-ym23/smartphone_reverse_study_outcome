package com.lynx.tasm.behavior.ui.image;

import android.text.TextUtils;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.behavior.ui.text.a;
import com.lynx.tasm.ui.image.h;
import com.lynx.tasm.utils.j;
import dn.b;
import dn.c;

/* JADX INFO: loaded from: classes2.dex */
public class InlineImageShadowNode extends AbsInlineImageShadowNode {
    public b O;

    public InlineImageShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final a E() {
        ShadowNode r5 = (ShadowNode) this.f10337h.f23310b;
        float r10 = r5.f10334a.g(r5.f10335b);
        ShadowNode r11 = (ShadowNode) this.f10337h.f23310b;
        float r12 = r11.f10334a.a(r11.f10335b);
        ShadowNode r13 = (ShadowNode) this.f10337h.f23310b;
        return new c((int) Math.ceil(r10), (int) Math.ceil(r12), r13.f10334a.e(r13.f10335b), this.O);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void h(b0 r5) {
        super.h(r5);
        this.O = new b(this, this.f10349m);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void p() {
        this.O.r();
        n();
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void q() {
        j.f(new h(this, 9));
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setMode(String r5) {
        this.O.i(r5);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode
    public final void setSource(String r5) {
        b r10 = this.O;
        if (TextUtils.equals(r5, r10.d) == true) goto L6;
        r10.d = r5;
        r10.f16675a |= 2;
        return;
    }
}
