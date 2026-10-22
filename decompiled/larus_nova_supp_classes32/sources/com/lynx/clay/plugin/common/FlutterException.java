package com.lynx.clay.plugin.common;

import c5a.a;
import c5a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class FlutterException extends RuntimeException {
    public final String code;
    public final Object details;

    public FlutterException(String r3, String r4, Object r5) {
        super(r4);
        if (a.a.booleanValue() == false) goto L6;
        if (r3 != null) goto L6;
        c.d(6, "FlutterException#", "Parameter code must not be null.");
    L6:
        this.code = r3;
        this.details = r5;
    }
}
