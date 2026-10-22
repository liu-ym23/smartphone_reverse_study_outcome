package com.bytedance.android.live.profit.format.voicechat.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class f {

    public static final class a extends f {
        public final boolean a;
        public final CloseReason b;
        public final long c;

        public a(boolean r2, CloseReason r3, long r4) {
            Intrinsics.checkNotNullParameter(r3, "closeReason");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b extends f {
        public final e a;

        public b(e r2) {
            Intrinsics.checkNotNullParameter(r2, "sessionInfo");
            this.a = r2;
        }
    }

    public f() {
    }
}
