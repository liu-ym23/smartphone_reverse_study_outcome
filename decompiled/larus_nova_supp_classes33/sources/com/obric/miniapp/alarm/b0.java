package com.obric.miniapp.alarm;

import com.larus.common.apphost.AppHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public interface b0 {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static b0 a() {
            if (yka.a.b.e(AppHost.a.getApplication()) == false) goto L6;
            return a0.b;
        L6:
            return d0.b;
        }
    }

    static {
        a = a.a;
    }

    void a(com.obric.miniapp.alarm.a r1);

    void b(String r1);

    void c();
}
