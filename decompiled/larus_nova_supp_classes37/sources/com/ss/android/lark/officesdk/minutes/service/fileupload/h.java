package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    public static abstract class a {

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.fileupload.h$a$a, reason: collision with other inner class name */
        public static final class C0013a extends a {
            public final MmMinutesFileUploadErrorCode a;
            public final String b;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0013a) == true) goto L8;
                return false;
            L8:
                C0013a r6 = (C0013a) r5;
                if (this.a == r6.a) goto L12;
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
                return "Failure(code=" + this.a + ", message=" + this.b + ')';
            }

            public C0013a(MmMinutesFileUploadErrorCode r2, String r3) {
                Intrinsics.checkNotNullParameter(r2, "code");
                Intrinsics.checkNotNullParameter(r3, "message");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class b extends a {
            public final File a;

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
                return "Success(oggFile=" + this.a + ')';
            }

            public b(VFSFile r2) {
                Intrinsics.checkNotNullParameter(r2, "oggFile");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    static {
    }
}
