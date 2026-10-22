package com.bytedance.bmmt.base;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class ExceptionUtils {
    public ExceptionUtils() {
    }

    public static String stackTrace(Throwable r2) {
        r2.printStackTrace(new PrintWriter(new StringWriter()));
        return r2.toString();
    }
}
