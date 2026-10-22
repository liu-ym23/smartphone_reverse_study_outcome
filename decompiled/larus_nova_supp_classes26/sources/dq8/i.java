package dq8;

import cq8.z0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class i {
    public final String a;

    public static final class a extends i {
        public final String b;
        public final com.larus.bmhome.actionbar.model.c c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.b.hashCode() * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "GaokaoPreference(widgetId=" + this.b + ", commandOption=" + this.c + ')';
        }

        public a(String r2, com.larus.bmhome.actionbar.model.c r3) {
            Intrinsics.checkNotNullParameter(r2, "widgetId");
            Intrinsics.checkNotNullParameter(r3, "commandOption");
            super("GaokaoPreference");
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b extends i {
        public static final b b = null;

        static {
            b = new b();
        }

        public b() {
            super("PasteUrl");
        }
    }

    public static final class c extends i {
        public final com.larus.bmhome.actionbar.model.c b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((c) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "SendUserMessage(commandOption=" + this.b + ')';
        }

        public c(com.larus.bmhome.actionbar.model.c r2) {
            Intrinsics.checkNotNullParameter(r2, "commandOption");
            super("SendUserMessage");
            this.b = r2;
        }
    }

    public static final class d extends i {
        public final com.larus.bmhome.actionbar.model.c b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((d) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "SingleFile(commandOption=" + this.b + ')';
        }

        public d(com.larus.bmhome.actionbar.model.c r2) {
            Intrinsics.checkNotNullParameter(r2, "commandOption");
            super("SingleFile");
            this.b = r2;
        }
    }

    public static final class e extends i {
        public static final e b = null;

        static {
            b = new e();
        }

        public e() {
            super("SyncCalendar");
        }
    }

    public static final class f extends i {
        public final String b;
        public final com.larus.bmhome.actionbar.model.c c;
        public final z0 d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "UniversalCamera(widgetId=" + this.b + ", commandOption=" + this.c + ", trackingContext=" + this.d + ')';
        }

        public f(String r2, com.larus.bmhome.actionbar.model.c r3, z0 r4) {
            Intrinsics.checkNotNullParameter(r2, "widgetId");
            Intrinsics.checkNotNullParameter(r3, "commandOption");
            Intrinsics.checkNotNullParameter(r4, "trackingContext");
            super("UniversalCamera");
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public i(String r1) {
        this.a = r1;
    }
}
