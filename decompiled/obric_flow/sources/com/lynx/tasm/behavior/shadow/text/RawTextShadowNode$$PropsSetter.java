package com.lynx.tasm.behavior.shadow.text;

import com.bytedance.ai.event.MessageIndication;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter;
import com.lynx.tasm.behavior.y0;

/* JADX INFO: loaded from: classes2.dex */
public class RawTextShadowNode$$PropsSetter extends ShadowNode$$PropsSetter {
    public RawTextShadowNode$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode$$PropsSetter, com.lynx.tasm.behavior.utils.ShadowNodeSetter
    public final void b(ShadowNode r5, String r10, y0 r11) {
        RawTextShadowNode r12 = (RawTextShadowNode) r5;
        r10.getClass();
        if (r10.equals("pseudo") == false) goto L5;
        r12.setPsuedo(r11.e(r10, false));
        return;
    L5:
        if (r10.equals(MessageIndication.CONTENT_TYPE_TEXT) == true) goto L8;
        super.b(r5, r10, r11);
        return;
    L8:
        r12.setText(r11.f10815a.getDynamic(r10));
    }
}
