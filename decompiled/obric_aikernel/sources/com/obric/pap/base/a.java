package com.obric.pap.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.pap.base.a$a, reason: collision with other inner class name */
    public static final class C0137a {
        public static void a(a r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "content");
            r10.log(3, r11, r12);
        }

        public static void b(a r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "content");
            r10.log(6, r11, r12);
        }

        public static void c(a r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "content");
            r10.log(4, r11, r12);
        }

        public static void d(a r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "content");
            r10.log(2, r11, r12);
        }

        public static void e(a r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "tag");
            Intrinsics.checkNotNullParameter(r12, "content");
            r10.log(5, r11, r12);
        }
    }

    void log(int r10, String r11, String r12);

    void logD(String r10, String r11);

    void logE(String r10, String r11);

    void logI(String r10, String r11);

    void logW(String r10, String r11);
}
