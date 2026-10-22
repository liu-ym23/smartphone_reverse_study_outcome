package org.apache.poi.ss.util;

/* JADX INFO: loaded from: classes7.dex */
final class IEEEDouble {
    public static int getBiasedExponent(long r2) {
        return Math.toIntExact((r2 & 9218868437227405312L) >> 52);
    }
}
