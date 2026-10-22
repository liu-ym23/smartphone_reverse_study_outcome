package com.bytedance.applog;

import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class b {

    static class a implements c {
        a() {
        }

        @Override // com.bytedance.applog.b.c
        public boolean a(com.bytedance.applog.c r10) {
            if (r10.K() != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.K().Q() == false) goto L7;
            return true;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.applog.b$b, reason: collision with other inner class name */
    static class C0043b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1161a;

        C0043b(String r10) {
            this.f1161a = r10;
        }

        @Override // com.bytedance.applog.b.c
        public boolean a(com.bytedance.applog.c r10) {
            return this.f1161a.equals(r10.getAppId());
        }
    }

    public interface c {
        boolean a(com.bytedance.applog.c r10);
    }

    static {
        new a();
    }

    public static com.bytedance.applog.c a(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return null;
    L5:
        Iterator<com.bytedance.applog.c> r11 = com.bytedance.applog.c.q().iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        com.bytedance.applog.c r12 = r11.next();
        if (r10.equals(r12.getAppId()) == false) goto L7;
        return r12;
    L11:
        return null;
    }

    public static String b(g r10, String r11) {
        if (d(r10) == false) goto L6;
        return r11;
    L6:
        return r11 + "_" + r10.getAppId();
    }

    public static boolean c(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L7:
        return false;
    L5:
        if (e(new C0043b(r10)) == false) goto L7;
        return true;
    }

    public static boolean d(g r10) {
        if (com.bytedance.applog.a.f() != r10) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e(c r10) {
        Iterator<com.bytedance.applog.c> r11 = com.bytedance.applog.c.q().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (r10.a(r11.next()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static void f(String[] r10) {
        Iterator<com.bytedance.applog.c> r11 = com.bytedance.applog.c.q().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().q0((String[]) r10.clone());
        goto L4
    }
}
