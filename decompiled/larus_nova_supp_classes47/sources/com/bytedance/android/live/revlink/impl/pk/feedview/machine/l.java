package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class l {
    public final String a;
    public final int b;

    public static final class a extends l {
        public final p c;

        public a(p r3) {
            Intrinsics.checkNotNullParameter(r3, "linkInfo");
            super("LINK", 3);
            this.c = r3;
        }
    }

    public static final class b extends l {
        public final s c;

        public b(s r3) {
            Intrinsics.checkNotNullParameter(r3, "penalInfo");
            super("PENAL", 2);
            this.c = r3;
        }
    }

    public static final class c extends l {
        public final v c;

        public c(v r3) {
            Intrinsics.checkNotNullParameter(r3, "pkInfo");
            super("PK", 1);
            this.c = r3;
        }
    }

    public static final class d extends l {
        public d() {
            super("UNKNOWN", 0);
        }
    }

    public l(String r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
