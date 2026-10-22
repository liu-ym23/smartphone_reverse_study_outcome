package com.bytedance.android.livesdk.chatroom.viewmodel;

import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class i {
    public final int a;
    public final int b;
    public List<Integer> c;
    public final boolean d;
    public final boolean e;
    public ClientUIInfo f;

    public final String toString() {
        return "SwitchSceneEvent(scene=" + this.a + ", uiLayout=" + this.b + ", playModes=" + this.c + ", isFromBroadcast=" + this.d + ')';
    }

    public ClientUIInfo a() {
        return this.f;
    }

    public void b(ClientUIInfo r1) {
        this.f = r1;
    }

    public i(int r1, int r2, List<Integer> r3, boolean r4, boolean r5, ClientUIInfo r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ i(int r10, int r11, List r12, boolean r13, boolean r14, ClientUIInfo r15, int r16) {
        if ((r16 & 2) == 0) goto L5;
        int r4 = 0;
    L7:
        if ((r16 & 4) == 0) goto L9;
        List r5 = CollectionsKt.emptyList();
    L11:
        if ((r16 & 8) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r16 & 16) == 0) goto L17;
        boolean r7 = false;
    L19:
        if ((r16 & 32) == 0) goto L21;
        ClientUIInfo r8 = null;
    L22:
        this(r10, r4, r5, r6, r7, r8);
        return;
    L21:
        r8 = r15;
        goto L22
    L17:
        r7 = r14;
        goto L19
    L13:
        r6 = r13;
        goto L15
    L9:
        r5 = r12;
        goto L11
    L5:
        r4 = r11;
        goto L7
    }
}
