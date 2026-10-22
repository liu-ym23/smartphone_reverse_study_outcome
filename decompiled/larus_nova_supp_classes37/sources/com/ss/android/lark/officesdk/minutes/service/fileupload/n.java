package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadTaskState;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.fileupload.n$a$a, reason: collision with other inner class name */
        public static final class C0014a extends a {
            public final MmMinutesFileUploadTaskState a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0014a) == true) goto L9;
                return false;
            L9:
                if (this.a == ((C0014a) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "EnterState(state=" + this.a + ')';
            }

            public C0014a(MmMinutesFileUploadTaskState r2) {
                Intrinsics.checkNotNullParameter(r2, "state");
                this.a = r2;
            }
        }

        public static final class b extends a {
            public final eub.b a;

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
                return "Interrupt(error=" + this.a + ')';
            }

            public b(eub.b r2) {
                Intrinsics.checkNotNullParameter(r2, "error");
                this.a = r2;
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmMinutesFileUploadTaskState.values().length];
            r0[MmMinutesFileUploadTaskState.Interrupted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[MmMinutesFileUploadTaskState.Idle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[MmMinutesFileUploadTaskState.Init.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public static eub.g a(eub.g r12, a r13) {
        Intrinsics.checkNotNullParameter(r12, "current");
        Intrinsics.checkNotNullParameter(r13, "event");
        if ((r13 instanceof a.C0014a) == true) goto L22;
        MmMinutesFileUploadTaskState r1 = null;
        if ((r13 instanceof a.b) == false) goto L17;
        MmMinutesFileUploadTaskState r3 = MmMinutesFileUploadTaskState.Interrupted;
        eub.b r9 = ((a.b) r13).a;
        MmMinutesFileUploadTaskState r14 = r12.a;
        int r15 = b.a[r14.ordinal()];
        if (r15 != 1) goto L10;
    L14:
        r1 = r12.h;
    L23:
        return eub.g.a(r12, r3, 0, 0, null, null, null, r9, r1, 62);
    L10:
        if (r15 == 2) goto L14;
        if (r15 == 3) goto L23;
        r1 = r12.a;
        goto L23
    L17:
        if (Intrinsics.areEqual(r13, a.c.a) == false) goto L21;
        return new eub.g(MmMinutesFileUploadTaskState.Init, null, 254);
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        return eub.g.a(r12, ((a.C0014a) r13).a, 0, 0, null, null, null, null, null, 62);
    }
}
