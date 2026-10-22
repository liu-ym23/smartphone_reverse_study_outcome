package com.larus.account.saas.jsb.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class FlowAccountLogoutCore {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/account/saas/jsb/core/FlowAccountLogoutCore$Error;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "LOGOUT_FAILED", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error LOGOUT_FAILED = null;
        public static final /* synthetic */ Error[] a = null;
        private final int code;
        private final String message;

        public static Error valueOf(String r1) {
            return (Error) r27.a.a(Error.class, r1);
        }

        public static Error[] values() {
            return (Error[]) a.clone();
        }

        static {
            Error r0 = new Error();
            LOGOUT_FAILED = r0;
            a = new Error[]{r0};
        }

        public Error() {
            super("LOGOUT_FAILED", 0);
            this.code = 1;
            this.message = "Network Error";
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    static {
    }
}
