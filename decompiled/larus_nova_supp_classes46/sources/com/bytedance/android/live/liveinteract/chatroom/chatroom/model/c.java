package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public final int a;
    public final int b;
    public final List<Integer> c;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L12;
        c r4 = (c) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        List<Integer> r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "SwitchSceneEventForBackUpWidget(scene=" + this.a + ", uiLayout=" + this.b + ", playMode=" + this.c + ")";
    }

    public c(int r1, int r2, List<Integer> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
