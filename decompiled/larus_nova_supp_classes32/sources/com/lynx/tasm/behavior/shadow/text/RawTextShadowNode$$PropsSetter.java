package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class RawTextShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public RawTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r3, String r4, x0 r5) {
        RawTextShadowNode r0 = (RawTextShadowNode) r3;
        r4.getClass();
        if (r4.equals("pseudo") == false) goto L5;
        r0.setPsuedo(r5.b(r4, false));
        return;
    L5:
        if (r4.equals("text") == true) goto L8;
        super.a(r3, r4, r5);
        return;
    L8:
        r0.setText(r5.d(r4));
    }
}
