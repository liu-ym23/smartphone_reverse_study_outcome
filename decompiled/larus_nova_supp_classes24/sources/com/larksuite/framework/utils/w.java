package com.larksuite.framework.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class w {
    public static String a(Object r2) {
        return r2.getClass().getCanonicalName() + "@" + Integer.toHexString(System.identityHashCode(r2));
    }
}
