package com.bytedance.ies.xelement.reveal;

import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.view.UISimpleView$$PropsSetter;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.utils.e;

/* JADX INFO: loaded from: classes2.dex */
public class LynxRevealView$$PropsSetter extends UISimpleView$$PropsSetter {
    public LynxRevealView$$PropsSetter() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public final void a(LynxBaseUI r5, String r10, y0 r11) {
        LynxRevealView r12 = (LynxRevealView) r5;
    L10:
        e = move-exception;
        e.printStackTrace();
        StringBuilder r13 = e.b("setProperty error: ", r10, "\n");
        r13.append(e.toString());
        throw new RuntimeException(r13.toString());
    L4:
        if (r10.hashCode() == 3357091) goto L7;
    L12:
        super.a(r5, r10, r11);     // Catch: Exception -> L10
        return;
    L7:
        if (r10.equals("mode") == false) goto L12;
        r12.setRevealLayoutMode(r11.f10815a.getString(r10));     // Catch: Exception -> L10
    }
}
