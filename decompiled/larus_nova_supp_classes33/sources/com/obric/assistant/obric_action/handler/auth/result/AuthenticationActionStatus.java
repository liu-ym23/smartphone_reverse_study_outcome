package com.obric.assistant.obric_action.handler.auth.result;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/obric_action/handler/auth/result/AuthenticationActionStatus;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "PASS", "NOT_AVAILABLE", "FAILED", "TIMEOUT", "CANCELLED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AuthenticationActionStatus extends Enum<AuthenticationActionStatus> {

    @SerializedName("cancelled")
    public static final AuthenticationActionStatus CANCELLED = null;
    public static final a Companion = null;

    @SerializedName("failed")
    public static final AuthenticationActionStatus FAILED = null;

    @SerializedName("not_available")
    public static final AuthenticationActionStatus NOT_AVAILABLE = null;

    @SerializedName("pass")
    public static final AuthenticationActionStatus PASS = null;

    @SerializedName("timeout")
    public static final AuthenticationActionStatus TIMEOUT = null;
    public static final /* synthetic */ AuthenticationActionStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<AuthenticationActionStatus> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.obric_action.handler.auth.result.AuthenticationActionStatus$a] */
    static {
        AuthenticationActionStatus r0 = new AuthenticationActionStatus("PASS", 0, "pass");
        PASS = r0;
        AuthenticationActionStatus r1 = new AuthenticationActionStatus("NOT_AVAILABLE", 1, "not_available");
        NOT_AVAILABLE = r1;
        AuthenticationActionStatus r3 = new AuthenticationActionStatus("FAILED", 2, "failed");
        FAILED = r3;
        AuthenticationActionStatus r5 = new AuthenticationActionStatus("TIMEOUT", 3, "timeout");
        TIMEOUT = r5;
        AuthenticationActionStatus r7 = new AuthenticationActionStatus("CANCELLED", 4, "cancelled");
        CANCELLED = r7;
        AuthenticationActionStatus[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
        Companion = new a();
    }

    public static AuthenticationActionStatus[] values() {
        return (AuthenticationActionStatus[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AuthenticationActionStatus valueOf(String r1) {
        return (AuthenticationActionStatus) r27.a.a(AuthenticationActionStatus.class, r1);
    }

    public AuthenticationActionStatus(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
