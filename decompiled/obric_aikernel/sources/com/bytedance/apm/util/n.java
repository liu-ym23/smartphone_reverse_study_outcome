package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f1138a = null;

    static /* synthetic */ class a {
    }

    private static class b {
        private b() {
        }

        /* synthetic */ b(a r10) {
            this();
        }

        public boolean a(Object r10, Object r11) {
            if (r10 == r11) goto L8;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.equals(r11) == false) goto L7;
        L8:
            return true;
        }
    }

    static {
        f1138a = new b(null);
    }

    public static boolean a(Object r10, Object r11) {
        return f1138a.a(r10, r11);
    }
}
