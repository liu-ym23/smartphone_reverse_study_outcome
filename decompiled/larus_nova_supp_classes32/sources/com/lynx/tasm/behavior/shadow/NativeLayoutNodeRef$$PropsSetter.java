package com.lynx.tasm.behavior.shadow;

import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NativeLayoutNodeRef$$PropsSetter extends ShadowNode$$PropsSetter {
    public NativeLayoutNodeRef$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void a(ShadowNode r3, String r4, x0 r5) {
        NativeLayoutNodeRef r0 = (NativeLayoutNodeRef) r3;
        r4.getClass();
        if (r4.equals("vertical-align") == false) goto L5;
        r0.setVerticalAlign(r5.a(r4));
        return;
    L5:
        if (r4.equals("idSelector") == true) goto L8;
        super.a(r3, r4, r5);
        return;
    L8:
        r0.setIdSelector(r5.h(r4));
    }
}
