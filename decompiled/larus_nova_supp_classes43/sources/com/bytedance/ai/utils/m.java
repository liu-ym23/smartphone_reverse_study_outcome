package com.bytedance.ai.utils;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public abstract class m {

    public static final class a extends m {
        public final byte[] a;

        public final String toString() {
            return "BinaryResponse(data=" + Arrays.toString(this.a) + ')';
        }

        public final int hashCode() {
            return Arrays.hashCode(this.a);
        }

        public a(byte[] r1) {
            this.a = r1;
        }

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 == null) goto L8;
            Class<?> r1 = r10.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r1) == true) goto L13;
            return false;
        L13:
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.bytedance.ai.utils.ResponseData.BinaryResponse");
            return Arrays.equals(this.a, ((a) r10).a);
        L8:
            r1 = null;
            goto L10
        }
    }

    public static final class b extends m {
        public final String a;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r10).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "StringResponse(data=" + this.a + ')';
        }

        public b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "data");
            this.a = r10;
        }
    }

    public m() {
    }
}
