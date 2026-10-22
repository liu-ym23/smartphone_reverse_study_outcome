package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    public final int a;
    public final List<Integer> b;
    public final int c;
    public final boolean d;
    public ClientUIInfo e;
    public final boolean f;

    public j() {
        throw null;
    }

    public j(int r9, List<Integer> r10, int r11) {
        this(r9, r10, r11, false, null, false, 56);
    }

    public j(int r9, List<Integer> r10, int r11, boolean r12, ClientUIInfo r13) {
        this(r9, r10, r11, r12, r13, false, 32);
    }

    public final String toString() {
        return "SwitchSceneWithPlayModeEvent(scene=" + this.a + ", playMode=" + this.b + ", uiLayout=" + this.c + ", isFromBroadcast=" + this.d + ')';
    }

    public j(int r3, List r4, int r5, boolean r6, ClientUIInfo r7, boolean r8, int r9) {
        if ((r9 & 4) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r9 & 8) == 0) goto L9;
        r6 = false;
    L9:
        if ((r9 & 16) == 0) goto L12;
        r7 = null;
    L12:
        if ((r9 & 32) == 0) goto L14;
        r8 = false;
    L14:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
    }
}
