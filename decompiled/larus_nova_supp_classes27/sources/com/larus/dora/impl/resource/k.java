package com.larus.dora.impl.resource;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public abstract class k {

    public static final class a extends k {
        public final int a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a;
        }

        public final String toString() {
            return "Apk(resourceId=" + this.a + ')';
        }

        public a(int r1) {
            this.a = r1;
            DoraResourceSource r2 = DoraResourceSource.APK;
        }
    }

    public static final class b extends k {
        public final File a;
        public final DoraResourceSource b;

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
            return "FileResource(file=" + this.a + ", source=" + this.b + ')';
        }

        public b(File r2, DoraResourceSource r3) {
            Intrinsics.checkNotNullParameter(r2, "file");
            Intrinsics.checkNotNullParameter(r3, "source");
            this.a = r2;
            this.b = r3;
            if (r3 == DoraResourceSource.APK) goto L5;
            boolean r4 = true;
        L6:
            if (r4 == false) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r4 = false;
            goto L6
        }
    }

    public k() {
    }
}
