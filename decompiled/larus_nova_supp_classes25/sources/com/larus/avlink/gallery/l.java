package com.larus.avlink.gallery;

import androidx.lifecycle.MutableLiveData;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l {
    public static final AtomicReference<a> a = null;
    public static final MutableLiveData<a> b = null;

    public static final class a {
        public final int a;
        public final int b;
        public final List<Long> c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "SyncRequest(photoCnt=" + this.a + ", videoCnt=" + this.b + ", selectedUuids=" + this.c + ')';
        }

        public a(int r2, List r3) {
            Intrinsics.checkNotNullParameter(r3, "selectedUuids");
            this.a = r2;
            this.b = 0;
            this.c = r3;
        }
    }

    static {
        a = new AtomicReference(null);
        b = new MutableLiveData();
    }
}
