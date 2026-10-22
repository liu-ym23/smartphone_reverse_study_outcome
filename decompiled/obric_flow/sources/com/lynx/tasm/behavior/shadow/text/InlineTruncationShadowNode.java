package com.lynx.tasm.behavior.shadow.text;

import android.text.SpannableStringBuilder;
import java.util.ArrayList;
import zm.h;

/* JADX INFO: loaded from: classes2.dex */
public class InlineTruncationShadowNode extends BaseTextShadowNode {
    public InlineTruncationShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean m() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void w(SpannableStringBuilder r10, ArrayList r11) {
        super.w(r10, r11);
        if (o() == false) goto L6;
        r10.setSpan(new h(this.f10335b, this.f10352p, this.f10353q, this.f10356u, this.f10354r, this.s, this.f10355t), 0, r10.length(), 18);
        return;
    }
}
