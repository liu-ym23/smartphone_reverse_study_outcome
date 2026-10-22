package com.bytedance.ies.xelement.reveal;

import androidx.annotation.Keep;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.utils.a;
import com.lynx.tasm.utils.e;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class LynxRevealView$$MethodInvoker implements a {
    public LynxRevealView$$MethodInvoker() {
    }

    @Override // com.lynx.tasm.behavior.utils.a
    public /* bridge */ /* synthetic */ void invoke(LynxBaseUI r5, String r10, ReadableMap r11, Callback r12) {
        invoke((LynxRevealView) r5, r10, r11, r12);
    }

    public void invoke(LynxRevealView r5, String r10, ReadableMap r11, Callback r12) {
        int r13 = r10.hashCode();     // Catch: Exception -> L12
        if (r13 == (-357431021)) goto L18;
        if (r13 == 589715322) goto L15;
        if (r13 == 1908871954) goto L10;
    L20:
        byte r14 = -1;
    L21:
        if (r14 == 0) goto L30;
        if (r14 == 1) goto L28;
        if (r14 == 2) goto L26;
        r12.invoke(new Object[]{3});     // Catch: Exception -> L12
        return;
    L26:
        r5.scrollIntoView(r11);     // Catch: Exception -> L12
        return;
    L28:
        r5.boundingClientRect(r11, r12);     // Catch: Exception -> L12
        return;
    L30:
        r5.toggleActive(r11);     // Catch: Exception -> L12
        return;
    L10:
        if (r10.equals("scrollIntoView") == false) goto L20;
        r14 = 2;
        goto L21
    L15:
        if (r10.equals("toggleActive") == false) goto L20;
        r14 = 0;
        goto L21
    L18:
        if (r10.equals("boundingClientRect") == false) goto L20;
        r14 = 1;
    L12:
        e = move-exception;
        e.printStackTrace();
        StringBuilder r15 = e.b("invokeMethod error: ", r10, "\n");
        r15.append(e.toString());
        throw new RuntimeException(r15.toString());
    }
}
