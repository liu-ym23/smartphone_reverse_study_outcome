package rea;

import android.content.Intent;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class a {

    /* JADX INFO: renamed from: rea.a$a, reason: collision with other inner class name */
    public static final class C0069a extends a {
        public final Intent a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0069a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((C0069a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "CloseRealtimeCall(intent=" + this.a + ')';
        }

        public C0069a(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public static final class b extends a {
        public final Intent a;

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
            return "CloseTTS(intent=" + this.a + ')';
        }

        public b(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public static final class c extends a {
        public final Intent a;

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
            return "EnterDialogue(intent=" + this.a + ')';
        }

        public c(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public static final class d extends a {
        public final Intent a;

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
            return "JumpToChatPage(intent=" + this.a + ')';
        }

        public d(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public static final class e extends a {
        public final Intent a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((e) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "MuteRealtimeCall(intent=" + this.a + ')';
        }

        public e(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public static final class f extends a {
        public final Intent a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((f) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "NA(intent=" + this.a + ')';
        }

        public f(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public static final class g extends a {
        public final Intent a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((g) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "OpenSpecialInput(intent=" + this.a + ')';
        }

        public g(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public static final class h extends a {
        public final Intent a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((h) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "ReplayCallForMe(intent=" + this.a + ')';
        }

        public h(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public static final class i extends a {
        public final Intent a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((i) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "UnMuteRealtimeCall(intent=" + this.a + ')';
        }

        public i(Intent r2) {
            Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
            this.a = r2;
        }
    }

    public a() {
    }
}
