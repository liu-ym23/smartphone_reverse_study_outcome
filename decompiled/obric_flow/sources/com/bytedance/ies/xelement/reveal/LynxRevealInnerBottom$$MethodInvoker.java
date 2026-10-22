package com.bytedance.ies.xelement.reveal;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;
import com.lynx.tasm.utils.e;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxRevealInnerBottom$$MethodInvoker implements a {
    public LynxRevealInnerBottom$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxRevealInnerBottom) r5, r10, r11, r12);
    }

    public void invoke(LynxRevealInnerBottom r5, String r10, ReadableMap r11, Callback r12) {
        int r13 = r10.hashCode();     // Catch: Exception -> L10
        if (r13 == (-357431021)) goto L13;
        if (r13 == 1908871954) goto L8;
    L15:
        byte r14 = -1;
    L16:
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L20;
        r12.invoke(new Object[]{3});     // Catch: Exception -> L10
        return;
    L20:
        r5.scrollIntoView(r11);     // Catch: Exception -> L10
        return;
    L22:
        r5.boundingClientRect(r11, r12);     // Catch: Exception -> L10
        return;
    L8:
        if (r10.equals("scrollIntoView") == false) goto L15;
        r14 = 1;
        goto L16
    L13:
        if (r10.equals("boundingClientRect") == false) goto L15;
        r14 = 0;
    L10:
        e = move-exception;
        e.printStackTrace();
        StringBuilder r15 = e.b("invokeMethod error: ", r10, "\n");
        r15.append(e.toString());
        throw new RuntimeException(r15.toString());
    }
}
