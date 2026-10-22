package com.bytedance.applog.monitor.exception;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum ExceptionLevel extends Enum<ExceptionLevel> {
    public static final ExceptionLevel Fatal = null;
    public static final ExceptionLevel Notice = null;
    public static final /* synthetic */ ExceptionLevel[] a = null;

    static {
        ExceptionLevel r0 = new ExceptionLevel("Fatal", 0);
        Fatal = r0;
        ExceptionLevel r1 = new ExceptionLevel("Notice", 1);
        Notice = r1;
        a = new ExceptionLevel[]{r0, r1};
    }

    public static ExceptionLevel[] values() {
        return (ExceptionLevel[]) a.clone();
    }

    public static ExceptionLevel valueOf(String r1) {
        return (ExceptionLevel) a.a(ExceptionLevel.class, r1);
    }

    public ExceptionLevel(String r1, int r2) {
        super(r1, r2);
    }
}
