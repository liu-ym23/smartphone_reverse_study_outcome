package com.larus.dora.impl.device.manage.viewmodel;

import com.bytedance.dora.device.DoraDevice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.manage.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C0038a implements a {
        public final DoraDevice a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0038a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0038a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "NeedUnbind(device=" + this.a + ')';
        }

        public C0038a(DoraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }

    public static final class b implements a {
        public final DoraDevice a;

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
            return "ShowDisconnectFailedDialog(device=" + this.a + ')';
        }

        public b(DoraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }

    public static final class c implements a {
        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ShowFailureToast(text=null)";
        }
    }

    public static final class d implements a {
        public final DoraDevice a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "SwitchToDynamicPage(device=" + this.a + ')';
        }

        public d(DoraDevice r2) {
            Intrinsics.checkNotNullParameter(r2, "device");
            this.a = r2;
        }
    }
}
