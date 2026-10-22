package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p4 implements Function1<Boolean, Unit> {
    public final /* synthetic */ boolean a;

    public p4(boolean r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        boolean r6 = ((Boolean) r5).booleanValue();
        boolean r0 = this.a;
        if (r6 == true) goto L5;
        o4.a("live_follow_desktop", "follow_leave_living_room", "", "normal", new q4(r0));
        return null;
    L5:
        o4.b(r0);
        return null;
    }
}
