package com.larksuite.framework.http.v2;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface c {

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final OkHttpClient.Builder a;
        public d b;
        public boolean c;
        public boolean d;
        public boolean e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            int r2 = 1231;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (r0 + r1) * 31;
            if (this.d == false) goto L9;
            int r4 = 1231;
        L10:
            int r5 = (r3 + r4) * 31;
            if (this.e == true) goto L15;
            r2 = 1237;
        L15:
            return r5 + r2;
        L9:
            r4 = 1237;
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "ClientSpec(builder=" + this.a + ", userCookieStrategy=" + this.b + ", enableUserAgent=" + this.c + ", noneSuccess2Exception=" + this.d + ", enableLog=" + this.e + ')';
        }

        public b(OkHttpClient.Builder r3) {
            d.b r0 = d.b.a;
            Intrinsics.checkNotNullParameter(r3, "builder");
            Intrinsics.checkNotNullParameter(r0, "userCookieStrategy");
            this.a = r3;
            this.b = r0;
            this.c = false;
            this.d = false;
            this.e = false;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.framework.http.v2.c$c, reason: collision with other inner class name */
    public static final class C0046c {
        public static /* synthetic */ Call a(c r1, Request r2) {
            return r1.a(r2, LarkHttpClient$newCall$1.INSTANCE);
        }
    }

    com.larksuite.framework.http.v2.internal.main.a a(Request r1, Function1 r2);

    OkHttpClient getOriginal();
}
