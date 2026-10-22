package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T, R> implements Function {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object apply(Object r2) {
        b r3 = (b) r2;
        Intrinsics.checkNotNullParameter(r3, "event");
        o r4 = r3.a;
        if (r4 != null) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r5 = SimpleSettingManager.a;
        return SimpleSettingManager.b();
    L6:
        return r4;
    }
}
