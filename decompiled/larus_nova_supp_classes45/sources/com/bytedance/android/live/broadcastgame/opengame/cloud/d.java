package com.bytedance.android.live.broadcastgame.opengame.cloud;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d {
    public static final /* synthetic */ int d = 0;
    public String a;
    public final int b;
    public final b c;

    public static final class a {
    }

    public static final class b {
        public static final /* synthetic */ int f = 0;
        public String a;
        public String b;
        public String c;
        public String d;
        public final boolean e;

        public static final class a {
        }

        static {
        }

        public final String toString() {
            return "isLogin = " + this.e + ", \ncode = " + this.a + ", anonymousCod = " + this.b + ", \ncloudCode = " + this.c + ", cloudACode = " + this.d;
        }

        public b(boolean r1) {
            this.e = r1;
            this.c = "";
            this.d = "";
        }
    }

    static {
    }

    public final String toString() {
        return "errNo: " + this.b + ", errMsg: " + this.a + ", \ndata: {" + this.c + '}';
    }

    public d(int r2, b r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        this.b = r2;
        this.c = r3;
    }
}
