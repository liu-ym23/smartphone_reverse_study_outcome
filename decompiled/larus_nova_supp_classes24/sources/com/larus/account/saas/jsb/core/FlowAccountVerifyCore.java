package com.larus.account.saas.jsb.core;

import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class FlowAccountVerifyCore {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/account/saas/jsb/core/FlowAccountVerifyCore$Error;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "DECISION_NOT_FOUND", "DECISION_PARSE_FAILED", "INVALID_STATUS", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error DECISION_NOT_FOUND = null;
        public static final Error DECISION_PARSE_FAILED = null;
        public static final Error INVALID_STATUS = null;
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
            Error r0 = new Error("DECISION_NOT_FOUND", 0, 1, "decision is null, or not in twice verify flow");
            DECISION_NOT_FOUND = r0;
            Error r1 = new Error("DECISION_PARSE_FAILED", 1, 2, "catch exception while parsing decisions");
            DECISION_PARSE_FAILED = r1;
            Error r2 = new Error("INVALID_STATUS", 2, 3, "status error");
            INVALID_STATUS = r2;
            a = new Error[]{r0, r1, r2};
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public Error(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.code = r3;
            this.message = r4;
        }
    }

    static {
    }

    public static void a(int r4, String r5, int r6) {
        SaasTracking r0 = SaasTracking.a;
        JSONObject r1 = new JSONObject();
        r1.put("flow_scene", "mfa_explicit_jsb_get_decision");
        r1.put("afid", String.valueOf(r4));
        r1.put("verify_scene", r5);
        r1.put("hit_cache", r6);
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("doubao_account_mfa_explicit_flow", r1);
    }
}
