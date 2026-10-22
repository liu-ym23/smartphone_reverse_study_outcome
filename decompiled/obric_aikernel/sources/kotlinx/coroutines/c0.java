package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final Object f10248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final Function1<Throwable, Unit> f10249b;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(Object r10, Function1<? super Throwable, Unit> r11) {
        this.f10248a = r10;
        this.f10249b = r11;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c0) == true) goto L8;
        return false;
    L8:
        c0 r11 = (c0) r10;
        if (Intrinsics.areEqual(this.f10248a, r11.f10248a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10249b, r11.f10249b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Object r10 = this.f10248a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return (r11 * 31) + this.f10249b.hashCode();
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f10248a + ", onCancellation=" + this.f10249b + ')';
    }
}
