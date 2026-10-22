package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b {
    public final o a;

    public b() {
        this(null);
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.a, ((b) r2).a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        o r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "SimpleDanmakuSettingChangeEvent(setting=" + this.a + ")";
    }

    public b(o r1) {
        this.a = r1;
    }
}
