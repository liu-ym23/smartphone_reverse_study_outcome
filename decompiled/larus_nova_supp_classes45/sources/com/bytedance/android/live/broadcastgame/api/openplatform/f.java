package com.bytedance.android.live.broadcastgame.api.openplatform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public a a;
    public final String b;

    public static final class a {
        public final long a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final int f;
        public final boolean g;
        public final String h;
        public final String i;

        public a(long r2, String r4, String r5, String r6, String r7, int r8, boolean r9, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r4, "appVersion");
            Intrinsics.checkNotNullParameter(r5, "appdId");
            Intrinsics.checkNotNullParameter(r6, "schema");
            Intrinsics.checkNotNullParameter(r7, "name");
            Intrinsics.checkNotNullParameter(r11, "sourceType");
            Intrinsics.checkNotNullParameter(r12, "iconUrl");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r11;
            this.i = r12;
        }

        public /* synthetic */ a(long r12, String r14, String r15, String r16, String r17, int r18, boolean r19, String r21, String r22, int r23) {
            if ((r23 & 1) == 0) goto L5;
            long r1 = 0;
        L6:
            String r4 = "";
            if ((r23 & 2) == 0) goto L9;
            String r3 = "";
        L11:
            if ((r23 & 4) == 0) goto L13;
            String r5 = "";
        L15:
            if ((r23 & 8) == 0) goto L17;
            String r6 = "";
        L19:
            if ((r23 & 16) == 0) goto L21;
            String r7 = "";
        L22:
            boolean r9 = false;
            if ((r23 & 32) == 0) goto L25;
            int r8 = 0;
        L27:
            if ((r23 & 64) != 0) goto L31;
            r9 = r19;
        L31:
            if ((r23 & 128) == 0) goto L33;
            String r11 = "collection";
        L35:
            if ((r23 & 256) != 0) goto L38;
            r4 = r22;
        L38:
            this(r1, r3, r5, r6, r7, r8, r9, r11, r4);
            return;
        L33:
            r11 = r21;
            goto L35
        L25:
            r8 = r18;
            goto L27
        L21:
            r7 = r17;
            goto L22
        L17:
            r6 = r16;
            goto L19
        L13:
            r5 = r15;
            goto L15
        L9:
            r3 = r14;
            goto L11
        L5:
            r1 = r12;
            goto L6
        }
    }

    public f() {
        this(0);
    }

    public f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "trackSource");
        this.b = r2;
    }

    public /* synthetic */ f(int r1) {
        this("other");
    }
}
