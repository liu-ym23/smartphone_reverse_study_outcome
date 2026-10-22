package com.lynx.tasm.ui.image;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FrescoInlineImageShadowNode$$PropsSetter extends AbsInlineImageShadowNode$$PropsSetter {
    public FrescoInlineImageShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode$$PropsSetter, com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public void a(ShadowNode r4, String r5, x0 r6) {
        FrescoInlineImageShadowNode r0 = (FrescoInlineImageShadowNode) r4;
        r5.getClass();
        if (r5.equals("skip-redirection") == false) goto L5;
        r0.setSkipRedirection(r6.b(r5, false));
        return;
    L5:
        if (r5.equals("loop-count") == true) goto L8;
        super.a(r4, r5, r6);
        return;
    L8:
        r0.setLoopCount(r6.f(r5, 0));
    }
}
