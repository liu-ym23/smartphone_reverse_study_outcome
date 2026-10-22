package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static int a(int r10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(r10 - 1));
    }
}
