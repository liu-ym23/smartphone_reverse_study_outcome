package com.bytedance.android.live.openplatform.api.utils;

import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class OpenPlatformHostInfoPresenter {
    public static boolean a() {
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        r0.element = true;
        kjc.c r2 = new kjc.c();
        f.a(r2, new OpenPlatformHostInfoPresenter$isDouyin$$inlined$call$lambda$1(r0));
        if (1 != kjc.a.a()) goto L6;
        kjc.b r3 = r2.a;
        r0.element = true;
        r3.a = Unit.INSTANCE;
        r2.b = true;
    L6:
        if (r2.b == true) goto L8;
        kjc.b r4 = r2.a;
        r0.element = true;
        r4.a = Unit.INSTANCE;
    L8:
        Object r1 = r2.a.a;
        return r0.element;
    }

    static {
    }
}
