package com.larus.bmhome.rc;

import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final Function1<l, Unit> a;
    public final Function1<k, Unit> b;
    public final Function1<ResourceUploadError, Unit> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "BizResourceUploadCallback(notifySuccess=" + this.a + ", notifyProgress=" + this.b + ", notifyFailed=" + this.c + ')';
    }

    public a(Function1<? super l, Unit> r2, Function1<? super k, Unit> r3, Function1<? super ResourceUploadError, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "notifySuccess");
        Intrinsics.checkNotNullParameter(r3, "notifyProgress");
        Intrinsics.checkNotNullParameter(r4, "notifyFailed");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
