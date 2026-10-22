package com.lynx.tasm.image;

import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class AutoSizeImage$$PropsSetter extends ShadowNode$$PropsSetter {
    public AutoSizeImage$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r3, String r4, x0 r5) {
        AutoSizeImage r0 = (AutoSizeImage) r3;
        r4.getClass();
        if (r4.equals(LynxError.LYNX_ERROR_KEY_RESOURCE_URL) == true) goto L6;
        super.a(r3, r4, r5);
        return;
    L6:
        r0.setSrc(r5.h(r4));
    }
}
