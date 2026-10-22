package com.larksuite.component.card.component.image;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UniversalCardImageShadowNode$$PropsSetter extends ShadowNode$.PropsSetter {
    public UniversalCardImageShadowNode$$PropsSetter() {
    }

    public final void a(ShadowNode r3, String r4, x0 r5) {
        UniversalCardImageShadowNode r0 = (UniversalCardImageShadowNode) r3;
        r4.getClass();
        if (r4.equals("props") == true) goto L6;
        super.a(r3, r4, r5);
        return;
    L6:
        r0.setContent(r5.g(r4));
    }
}
