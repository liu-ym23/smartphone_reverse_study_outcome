package com.bytedance.android.live.profit.redpacket;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class h1 {

    public static final class a extends h1 {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends h1 {
        public final boolean a;
        public final String b;
        public final String c;

        public b(boolean r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "luckyBoxShowTouchInitData");
            Intrinsics.checkNotNullParameter(r4, "luckyBoxAniViewInitData");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public h1() {
    }
}
