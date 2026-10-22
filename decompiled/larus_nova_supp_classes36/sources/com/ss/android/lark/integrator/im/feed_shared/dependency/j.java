package com.ss.android.lark.integrator.im.feed_shared.dependency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements peb.b.i {
    public final Map<peb.c, com.ss.android.lark.usersetting.service.badgestyle.c> a;
    public final Map<peb.c, com.ss.android.lark.usersetting.service.badgestyle.d> b;

    public final void a() {
    }

    public j() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public final void b(final afb.b.a r5) {
        com.ss.android.lark.usersetting.service.badgestyle.c r0 = new h(r5);
        com.ss.android.lark.usersetting.service.badgestyle.d r1 = new i(r5);
        ((ConcurrentHashMap) this.a).put(r5, r0);
        ((ConcurrentHashMap) this.b).put(r5, r1);
        com.ss.android.lark.usersetting.service.e.a.a.getClass();
        Object r6 = com.ss.android.lark.usersetting.service.badgestyle.a.c;
        com.ss.android.lark.usersetting.service.badgestyle.a r7 = com.ss.android.lark.usersetting.service.badgestyle.a.b.a;
        Map r2 = r7.a;
        Object r3 = com.ss.android.lark.usersetting.service.badgestyle.a.c;
        ((ConcurrentHashMap) r2).put(r0, r3);
        ((ConcurrentHashMap) r7.b).put(r1, r3);
    }
}
