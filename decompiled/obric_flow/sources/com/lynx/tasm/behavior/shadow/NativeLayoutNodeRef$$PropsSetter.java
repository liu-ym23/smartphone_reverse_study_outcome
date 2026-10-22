package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class NativeLayoutNodeRef$$PropsSetter extends ShadowNode$$PropsSetter {
    public NativeLayoutNodeRef$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void b(ShadowNode r5, String r10, y0 r11) {
        NativeLayoutNodeRef r12 = (NativeLayoutNodeRef) r5;
        r10.getClass();
        boolean r13 = r10.equals("vertical-align");
        ReadableMap r14 = r11.f10815a;
        if (r13 == false) goto L5;
        r12.setVerticalAlign(r14.getArray(r10));
        return;
    L5:
        if (r10.equals("idSelector") == true) goto L8;
        super.b(r5, r10, r11);
        return;
    L8:
        r12.setIdSelector(r14.getString(r10));
    }
}
