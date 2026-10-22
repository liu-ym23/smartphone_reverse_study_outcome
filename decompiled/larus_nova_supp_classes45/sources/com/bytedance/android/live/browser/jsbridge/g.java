package com.bytedance.android.live.browser.jsbridge;

import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface g {

    public static final class a {
        public static final a c = null;
        public final String a;
        public final String b;

        /* JADX INFO: renamed from: com.bytedance.android.live.browser.jsbridge.g$a$a, reason: collision with other inner class name */
        public static final class C0110a {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ChanneledConfig(channel=" + this.a + ", configString=" + this.b + ")";
        }

        static {
            c = new a("__invalid__", "");
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "configString");
            this.a = r2;
            this.b = r3;
        }
    }

    Observable<a> getConfig();
}
