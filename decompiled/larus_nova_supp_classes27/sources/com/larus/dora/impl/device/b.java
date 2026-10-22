package com.larus.dora.impl.device;

import com.larus.dora.impl.settings.DoraPushSummaryConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface b {

    public static final class a implements b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.b$b, reason: collision with other inner class name */
    public static final class C0033b implements b {
        public final sk4.e a;
        public final DoraPushSummaryConfig b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0033b) == true) goto L8;
            return false;
        L8:
            C0033b r6 = (C0033b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Success(protocolInfo=" + this.a + ", proactiveSettings=" + this.b + ')';
        }

        public C0033b(sk4.e r2, DoraPushSummaryConfig r3) {
            Intrinsics.checkNotNullParameter(r2, "protocolInfo");
            Intrinsics.checkNotNullParameter(r3, "proactiveSettings");
            this.a = r2;
            this.b = r3;
        }
    }
}
