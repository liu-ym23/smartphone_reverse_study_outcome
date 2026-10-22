package com.bytedance.android.live.broadcastgame.opengame.cloud;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j {
    public static final /* synthetic */ int d = 0;
    public b a;
    public final int b;
    public final String c;

    public static final class a {
    }

    public static final class b {
        public static final /* synthetic */ int c = 0;
        public String a;
        public long b;

        public static final class a {
        }

        static {
        }

        public final String toString() {
            return "sid = " + this.a + ", expiredTime = " + this.b;
        }

        public b() {
            this.a = "";
            this.b = -1;
        }
    }

    static {
    }

    public final String toString() {
        return "code = " + this.b + ", message = " + this.c + ", \ndata = {" + this.a + '}';
    }

    public j(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        this.b = r2;
        this.c = r3;
    }
}
