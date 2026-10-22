package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q4 implements Function2<Boolean, String, Unit> {
    public final /* synthetic */ boolean a;

    public q4(boolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r1, Object r2) {
        Boolean r3 = (Boolean) r1;
        String r4 = (String) r2;
        o4.f = r3.booleanValue();
        if (r3.booleanValue() == true) goto L7;
        o4.b(this.a);
        return null;
    L7:
        return null;
    }
}
