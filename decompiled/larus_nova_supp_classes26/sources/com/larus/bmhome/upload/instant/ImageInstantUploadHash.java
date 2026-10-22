package com.larus.bmhome.upload.instant;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ImageInstantUploadHash {
    public static final ImageInstantUploadHash a = null;

    public static final class a {
        public final String a;
        public final long b;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r9 = (a) r8;
            if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            long r1 = this.b;
            return r0 + ((int) (r1 ^ (r1 >>> 32)));
        }

        public final String toString() {
            return "SourceDigest(hash=" + this.a + ", fileSize=" + this.b + ')';
        }

        public final long a() {
            return this.b;
        }

        public a(String r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "hash");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new ImageInstantUploadHash();
    }

    public ImageInstantUploadHash() {
    }

    public static String a(j r2) {
        String r0 = r2.p;
        if (r0 == null) goto L10;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        return r0;
    L10:
        return r2.a;
    }

    public static PolarisFileInputStreamWrapper b(String r2) {
        File r0 = new PolarisFileWrapper(r2);
        if (r0.exists() == true) goto L5;
    L9:
        boolean r3 = false;
    L11:
        if (r3 == true) goto L14;
        r0 = null;
    L14:
        if (r0 != null) goto L17;
        return null;
    L17:
        return new PolarisFileInputStreamWrapper(r0);
    L5:
        if (r0.isFile() == false) goto L9;
        if (r0.canRead() == false) goto L9;
        r3 = true;
        goto L11
    }

    public static Object c(j r3, long r4, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ImageInstantUploadHash$sha256OfSource$2(r3, r4, null), r6);
    }
}
