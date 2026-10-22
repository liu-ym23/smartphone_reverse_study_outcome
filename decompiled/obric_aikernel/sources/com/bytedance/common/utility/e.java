package com.bytedance.common.utility;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f1269a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1270a;

        public a() {
        }
    }

    static {
        f1269a = new b();
    }

    public e() {
    }

    public static e b() {
        return f1269a;
    }

    public static void g(e r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10 == f1269a) goto L8;
        f1269a = r10;
        return;
    }

    public abstract String a(String r10, Map<String, String> r11, a r12);

    public String c(String r10, List<Pair<String, String>> r11) {
        a r12 = new a();
        r12.f1270a = true;
        return d(r10, r11, null, r12);
    }

    public abstract String d(String r10, List<Pair<String, String>> r11, Map<String, String> r12, a r13);

    public abstract String e(String r10, byte[] r11, Map<String, String> r12, a r13);

    public byte[] f(String r10, byte[] r11, Map<String, String> r12, a r13) {
        return null;
    }
}
