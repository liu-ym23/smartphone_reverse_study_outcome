package com.bytedance.applog.a;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1510a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f1511b;
    private static final String c = null;
    private static volatile int d;
    private static volatile boolean e;
    private static volatile boolean f;
    private static volatile boolean g;

    static {
        f1510a = Collections.singletonList("OldAppLogDataMigrator");
        f1511b = 10;
        c = "select _id from queue order by _id asc limit " + f1511b;
        d = 1000;
        e = false;
        f = false;
        g = false;
    }

    static /* synthetic */ String a(boolean r0) {
        return b(r0);
    }

    static /* synthetic */ List a() {
        return f1510a;
    }

    public static void a(final com.bytedance.applog.b r4, final com.bytedance.applog.n.b r5) {
        if (f == true) goto L5;
        return;
    L5:
        if (r4.aC() == false) goto L10;
        r4.aA().a(f1510a, "Start to migrate stay duration data with pages...", new Object[0]);
        com.bytedance.applog.d.a.b().submit(new AnonymousClass1(r4, r5));
        return;
    }

    static /* synthetic */ int b() {
        return d;
    }

    private static String b(boolean r2) {
        StringBuilder r0 = new StringBuilder().append("SELECT event._id as _id, category, tag, label, event.value, ext_value, ext_json, user_id, event.timestamp, event.event_index as event_index, user_type, user_is_login, user_is_auth, uid, s.value as session_id ");
        if (r2 == false) goto L5;
        String r3 = ", disable_personalization";
    L7:
        return r0.append(r3).append(" FROM event left join session s on event.session_id  = s._id order by event._id asc limit ?").toString();
    L5:
        r3 = "";
        goto L7
    }

    public static void b(final com.bytedance.applog.b r4, final com.bytedance.applog.n.b r5) {
        if (e == true) goto L5;
        return;
    L5:
        if (r4.aC() == false) goto L10;
        r4.aA().a(f1510a, "Start to migrate events...", new Object[0]);
        com.bytedance.applog.d.a.b().submit(new AnonymousClass2(r4, r5));
        return;
    }

    static /* synthetic */ String c() {
        return c;
    }

    public static void c(final com.bytedance.applog.b r4, final com.bytedance.applog.n.b r5) {
        if (g == true) goto L5;
        return;
    L5:
        if (r4.aC() == false) goto L10;
        r4.aA().a(f1510a, "Start to migrate packed logs data...", new Object[0]);
        com.bytedance.applog.d.a.b().submit(new AnonymousClass3(r4, r5));
        return;
    }

    static /* synthetic */ int d() {
        return f1511b;
    }
}
