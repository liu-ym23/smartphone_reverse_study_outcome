package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    public static int a(int r1) {
        return 1 << (32 - Integer.numberOfLeadingZeros(r1 - 1));
    }
}
