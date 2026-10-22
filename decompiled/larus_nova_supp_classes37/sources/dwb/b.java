package dwb;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.slot.model.MmRecordingSlotKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public final dwb.a a;
    public final dwb.a b;
    public final dwb.a c;
    public final dwb.a d;
    public final c e;
    public final d f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRecordingSlotKey.values().length];
            r0[MmRecordingSlotKey.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MmRecordingSlotKey.TITLE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MmRecordingSlotKey.MIDDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MmRecordingSlotKey.TOOLBAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public b() {
        this(null, null, null, null, 63);
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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        dwb.a r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        dwb.a r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        dwb.a r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        dwb.a r10 = this.d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return ((((r9 + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmRecordingSlotsConfig(top=" + this.a + ", title=" + this.b + ", middle=" + this.c + ", toolbar=" + this.d + ", contentPolicy=" + this.e + ", layoutPolicy=" + this.f + ')';
    }

    public b(dwb.a.b r4, dwb.a.b r5, dwb.a.b r6, c r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r8 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r8 & 16) == 0) goto L15;
        r7 = new c(false);
    L15:
        if ((r8 & 32) == 0) goto L17;
        d r9 = new d(0);
    L18:
        Intrinsics.checkNotNullParameter(r7, "contentPolicy");
        Intrinsics.checkNotNullParameter(r9, "layoutPolicy");
        this.a = r4;
        this.b = r5;
        this.c = null;
        this.d = r6;
        this.e = r7;
        this.f = r9;
        return;
    L17:
        r9 = null;
        goto L18
    }
}
