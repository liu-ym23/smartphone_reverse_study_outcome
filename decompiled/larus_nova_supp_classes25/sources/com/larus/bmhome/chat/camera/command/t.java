package com.larus.bmhome.chat.camera.command;

import android.os.Bundle;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.platform.model.action.SuggestedAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public abstract class t {
    public final long a;

    public static final class a extends t {
        public final CameraOutputContext b;
        public final SuggestedAction c;
        public final long d;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.c, r9.c) == true) goto L15;
            return false;
        L15:
            if (this.d == r9.d) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            SuggestedAction r1 = this.c;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            long r4 = this.d;
            return r3 + ((int) (r4 ^ (r4 >>> 32)));
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "CameraOutput(outputContext=" + this.b + ", selectedSuggestedAction=" + this.c + ", createTimeMs=" + this.d + ')';
        }

        @Override // com.larus.bmhome.chat.camera.command.t
        public final long a() {
            return this.d;
        }

        public a(CameraOutputContext r2, SuggestedAction r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "outputContext");
            super(r4);
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b extends t {
        public final Bundle b;
        public final long c;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r9 = (b) r8;
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L12;
            return false;
        L12:
            if (this.c == r9.c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.b.hashCode() * 31;
            long r1 = this.c;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "CreationPageReturn(resultBundle=" + this.b + ", createTimeMs=" + this.c + ')';
        }

        @Override // com.larus.bmhome.chat.camera.command.t
        public final long a() {
            return this.c;
        }

        public b(Bundle r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "resultBundle");
            super(r3);
            this.b = r2;
            this.c = r3;
        }
    }

    public long a() {
        return this.a;
    }

    public t(long r1) {
        this.a = r1;
    }
}
