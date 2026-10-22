package com.ss.android.lark.feed.shared.fg;

import com.ss.android.lark.biz.im.api.b0;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static boolean a = false;
    public static boolean b = true;
    public static boolean c = true;
    public static final Object d = null;
    public static final Map<String, Boolean> e = null;

    /* JADX INFO: renamed from: com.ss.android.lark.feed.shared.fg.a$a, reason: collision with other inner class name */
    public class C0203a implements b0 {
        public C0203a() {
        }
    }

    static {
        d = new Object();
        new C0203a();
        HashMap r0 = new HashMap();
        e = r0;
        Boolean r1 = Boolean.TRUE;
        r0.put("feed.shortcut", r1);
        r0.put("urgent.urgentList", r1);
        r0.put("secretChat", r1);
        r0.put("label", r1);
    }

    public static void a() {
        if (a == false) goto L5;
        return;
    L5:
        Object r0 = d;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (a == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L11:
        peb.b.InterfaceC0277b r1 = heb.a.a.getAppConfigDependency();     // Catch: Throwable -> L14
        r1.c();     // Catch: Throwable -> L14
        r1.a();     // Catch: Throwable -> L14
        b = false;     // Catch: Throwable -> L14
        r1.a();     // Catch: Throwable -> L14
        r1.a();     // Catch: Throwable -> L14
        r1.a();     // Catch: Throwable -> L14
        c = false;     // Catch: Throwable -> L14
        a = true;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
    }
}
