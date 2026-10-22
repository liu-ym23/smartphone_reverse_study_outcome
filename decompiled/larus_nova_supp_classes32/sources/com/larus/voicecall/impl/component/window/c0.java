package com.larus.voicecall.impl.component.window;

import com.larus.common_ui.dialog.p0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c0 implements p0 {
    public final /* synthetic */ RealtimeWindowComponent a;

    public final void confirm() {
        j3a.a r0 = (j3a.a) this.a.y.getValue();
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L16;
        com.larus.voicecall.impl.component.scene.a r3 = this.a.C3();
        if (r3 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == true) goto L16;
    L19:
        ((h88.b) this.a.B3()).o = "in_app";
        this.a.zg();
        return;
    L12:
        if (r3.wm() != true) goto L14;
    L16:
        com.larus.voicecall.impl.component.scene.a r4 = this.a.C3();
        if (r4 == null) goto L19;
        r4.bQ();
        goto L19
    L5:
        if (r0.su() != true) goto L7;
        r2 = true;
        goto L8
    }

    public c0(RealtimeWindowComponent r1) {
        this.a = r1;
    }
}
