package com.larus.dora.impl.wlan.wifi;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface k {

    public static final class a implements k {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements k {
        public final List<DoraWifiEntity> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Success(apList=" + this.a + ')';
        }

        public b(List<DoraWifiEntity> r2) {
            Intrinsics.checkNotNullParameter(r2, "apList");
            this.a = r2;
        }
    }
}
