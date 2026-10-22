package com.larus.account.saas.runtime.depend;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/account/saas/runtime/depend/ToastType;", "", "INFO", "SUCCESS", "WARNING", "FAILURE", "LOADING", "account-saas-runtime_release"}, k = 1, mv = {1, 7, 1})
public final enum ToastType extends Enum<ToastType> {
    public static final ToastType FAILURE = null;
    public static final ToastType INFO = null;
    public static final ToastType LOADING = null;
    public static final ToastType SUCCESS = null;
    public static final ToastType WARNING = null;
    public static final /* synthetic */ ToastType[] a = null;

    public static ToastType valueOf(String r1) {
        return (ToastType) a.a(ToastType.class, r1);
    }

    public static ToastType[] values() {
        return (ToastType[]) a.clone();
    }

    static {
        ToastType r0 = new ToastType("INFO", 0);
        INFO = r0;
        ToastType r1 = new ToastType("SUCCESS", 1);
        SUCCESS = r1;
        ToastType r3 = new ToastType("WARNING", 2);
        WARNING = r3;
        ToastType r5 = new ToastType("FAILURE", 3);
        FAILURE = r5;
        ToastType r7 = new ToastType("LOADING", 4);
        LOADING = r7;
        a = new ToastType[]{r0, r1, r3, r5, r7};
    }

    public ToastType(String r1, int r2) {
        super(r1, r2);
    }
}
