package com.larksuite.component.card.component.text;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class UniversalCardTextShadowNode$$PropsSetter extends ShadowNode$.PropsSetter {
    public UniversalCardTextShadowNode$$PropsSetter() {
    }

    public final void a(ShadowNode r3, String r4, x0 r5) {
        UniversalCardTextShadowNode r0 = (UniversalCardTextShadowNode) r3;
        r4.getClass();
        if (r4.equals("props") == true) goto L6;
        super.a(r3, r4, r5);
        return;
    L6:
        r0.setContent(r5.g(r4));
    }
}
