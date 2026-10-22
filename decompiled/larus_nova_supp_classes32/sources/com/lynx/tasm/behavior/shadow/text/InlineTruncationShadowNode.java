package com.lynx.tasm.behavior.shadow.text;

import android.text.SpannableStringBuilder;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class InlineTruncationShadowNode extends BaseTextShadowNode {
    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean p() {
        return true;
    }

    public InlineTruncationShadowNode() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void G(SpannableStringBuilder r4, List<BaseTextShadowNode.a> r5) {
        super.G(r4, r5);
        if (r() == false) goto L6;
        r4.setSpan(A(), 0, r4.length(), 18);
        return;
    }
}
