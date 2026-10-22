package com.larus.dora.impl.onboarding.othersmart;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.a$a, reason: collision with other inner class name */
    public static final class C0089a implements a {
        public final DoraDevice a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0089a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0089a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Connected(device=" + this.a + ')';
        }

        public C0089a(DoraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }

    public static final class b implements a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }
}
