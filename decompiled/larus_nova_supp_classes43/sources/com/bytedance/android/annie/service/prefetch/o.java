package com.bytedance.android.annie.service.prefetch;

import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface o {

    public static final class a {
        public static final a c = null;
        public final String a;
        public final String b;

        /* JADX INFO: renamed from: com.bytedance.android.annie.service.prefetch.o$a$a, reason: collision with other inner class name */
        public static final class C0084a {
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public final String toString() {
            return "ChanneledConfig(channel=" + this.a + ", configString=" + this.b + ')';
        }

        static {
            c = new a("__invalid__", "");
        }

        public a(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, "configString");
            this.a = r10;
            this.b = r11;
        }
    }

    Observable<a> getConfig();
}
