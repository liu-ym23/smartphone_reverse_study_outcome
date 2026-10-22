package dwb;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingNestedScrollMode;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class a {

    /* JADX INFO: renamed from: dwb.a$a, reason: collision with other inner class name */
    public static final class C0134a extends a {
        @Override // dwb.a
        public final MmRecordingNestedScrollMode a() {
            return null;
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0134a) == true) goto L8;
            return false;
        L8:
            ((C0134a) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "FragmentSlot(factory=null, nestedScrollMode=null)";
        }
    }

    public static final class b extends a {
        public final Function2<Context, com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.scope.d, View> a;
        public final MmRecordingNestedScrollMode b;

        public b() {
            throw null;
        }

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
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "ViewSlot(factory=" + this.a + ", nestedScrollMode=" + this.b + ')';
        }

        @Override // dwb.a
        public final MmRecordingNestedScrollMode a() {
            return this.b;
        }

        public b(Function2 r3) {
            MmRecordingNestedScrollMode r0 = MmRecordingNestedScrollMode.Disabled;
            Intrinsics.checkNotNullParameter(r3, "factory");
            Intrinsics.checkNotNullParameter(r0, "nestedScrollMode");
            super(r0);
            this.a = r3;
            this.b = r0;
        }
    }

    public abstract MmRecordingNestedScrollMode a();

    public a(MmRecordingNestedScrollMode r1) {
    }
}
