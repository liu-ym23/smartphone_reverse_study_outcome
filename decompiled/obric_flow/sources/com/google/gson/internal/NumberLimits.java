package com.google.gson.internal;

import ai.j0;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class NumberLimits {
    private static final int MAX_NUMBER_STRING_LENGTH = 10000;

    private NumberLimits() {
    }

    private static void checkNumberStringLength(String r5) {
        if (r5.length() > 10000) goto L6;
        return;
    L6:
        throw new NumberFormatException("Number string too large: " + r5.substring(0, 30) + "...");
    }

    public static BigDecimal parseBigDecimal(String r5) throws NumberFormatException {
        checkNumberStringLength(r5);
        BigDecimal r10 = new BigDecimal(r5);
        if (Math.abs(r10.scale()) >= 10000) goto L6;
        return r10;
    L6:
        throw new NumberFormatException(j0.C("Number has unsupported scale: ", r5));
    }

    public static BigInteger parseBigInteger(String r5) throws NumberFormatException {
        checkNumberStringLength(r5);
        return new BigInteger(r5);
    }
}
