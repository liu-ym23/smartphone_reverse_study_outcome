package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f1493a = null;

    /* JADX INFO: renamed from: com.bytedance.apm.util.l$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        public boolean a(Object r1, Object r2) {
            if (r1 == r2) goto L8;
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (r1.equals(r2) == false) goto L7;
        L8:
            return true;
        }
    }

    static {
        f1493a = new a(null);
    }

    public static boolean a(Object r1, Object r2) {
        return f1493a.a(r1, r2);
    }
}
