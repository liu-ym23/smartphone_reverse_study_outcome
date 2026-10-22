package com.larus.dora.impl.wlan.wifi.add;

import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface g {

    public static final class a implements g {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b implements g {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c implements g {
        public final List<DoraWifiEntity> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ScanResult(wifiList=" + this.a + ')';
        }

        public c(List<DoraWifiEntity> r2) {
            Intrinsics.checkNotNullParameter(r2, "wifiList");
            this.a = r2;
        }
    }

    public static final class d implements g {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }
}
