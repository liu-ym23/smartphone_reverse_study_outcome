package com.obric.assistant.security.provision.check.bean;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0012\u001a\u00020\u0007H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/security/provision/check/bean/ProvisionResult;", "", ProvisionResult.KEY_CODE, "", ProvisionResult.KEY_DATA, "Lcom/obric/assistant/security/provision/check/bean/Data;", ProvisionResult.KEY_MSG, "", "clientCode", "<init>", "(ILcom/obric/assistant/security/provision/check/bean/Data;Ljava/lang/String;I)V", "getCode", "()I", "getData", "()Lcom/obric/assistant/security/provision/check/bean/Data;", "getMsg", "()Ljava/lang/String;", "getClientCode", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProvisionResult {
    public static final int CODE_CLIENT_BIND_ERROR = 1002;
    public static final int CODE_CLIENT_CALL_API_EXCEPTION = 1003;
    public static final int CODE_CLIENT_PARSE_ERROR = 1001;
    public static final int CODE_DEFAULT = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final a Companion = null;
    private static final String KEY_CODE = "code";
    private static final String KEY_DATA = "data";
    private static final String KEY_LOG_ID = "log_id";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_MSG = "msg";
    private static final String TAG = "ProvisionResult";
    private final int clientCode;
    private final int code;
    private final Data data;
    private final String msg;

    public static final class a {
        public a() {
        }

        public static ProvisionResult a(Bundle r13) {
            String r0 = "";
            Intrinsics.checkNotNullParameter(r13, "bundle");
            Bundle r2 = r13.getBundle(ProvisionResult.KEY_DATA);     // Catch: Exception -> L20
            if (r2 == null) goto L13;
            int r6 = r2.getInt(ProvisionResult.KEY_CODE, ProvisionResult.CODE_DEFAULT);     // Catch: Exception -> L20
            String r7 = r2.getString(ProvisionResult.KEY_LOG_ID);     // Catch: Exception -> L20
            if (r7 != null) goto L9;
            r7 = "";
        L9:
            String r3 = r2.getString(ProvisionResult.KEY_MESSAGE);     // Catch: Exception -> L20
            if (r3 != null) goto L12;
            r3 = "";
        L12:
            Data r5 = new Data(r6, r7, r3);     // Catch: Exception -> L20
        L14:
            Data r8 = r5;
            int r9 = r13.getInt(ProvisionResult.KEY_CODE, ProvisionResult.CODE_DEFAULT);     // Catch: Exception -> L20
            String r4 = r13.getString(ProvisionResult.KEY_MSG);     // Catch: Exception -> L20
            if (r4 != null) goto L17;
            String r10 = "";
        L18:
            return new ProvisionResult(r9, r8, r10, 0, 8, null);
        L17:
            r10 = r4;
            goto L18
        L13:
            r5 = null;
        L20:
            e = move-exception;
            FLogger r11 = FLogger.a;
            StringBuilder r12 = new StringBuilder("fromBundle() bundle=");
            int r14 = xfa.a.a;
            Intrinsics.checkNotNullParameter(r13, "bundle");
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L24
            r0 = xfa.a.b(r13, 0);     // Catch: Throwable -> L24
        L26:
            r12.append(r0);
            r12.append(", e.msg=");
            r12.append(e.getMessage());
            r11.e(ProvisionResult.TAG, r12.toString(), e);
            return new ProvisionResult(0, null, "parse bundle exception", 1001, 3, null);
        L24:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L26
        }
    }

    static {
        Companion = new a();
    }

    public ProvisionResult() {
        this(0, null, null, 0, 15, null);
    }

    public static /* synthetic */ ProvisionResult copy$default(ProvisionResult r0, int r1, Data r2, String r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.data;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.msg;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.clientCode;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.code;
    }

    public final Data component2() {
        return this.data;
    }

    public final String component3() {
        return this.msg;
    }

    public final int component4() {
        return this.clientCode;
    }

    public final ProvisionResult copy(int r2, Data r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, KEY_MSG);
        return new ProvisionResult(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ProvisionResult) == true) goto L8;
        return false;
    L8:
        ProvisionResult r6 = (ProvisionResult) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.msg, r6.msg) == true) goto L18;
        return false;
    L18:
        if (this.clientCode == r6.clientCode) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = this.code * 31;
        Data r1 = this.data;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.msg.hashCode()) * 31) + this.clientCode;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "{code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", clientCode=" + this.clientCode + '}';
    }

    public final int getClientCode() {
        return this.clientCode;
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public ProvisionResult(int r2, Data r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, KEY_MSG);
        this.code = r2;
        this.data = r3;
        this.msg = r4;
        this.clientCode = r5;
    }

    public /* synthetic */ ProvisionResult(int r2, Data r3, String r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = CODE_DEFAULT;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = CODE_DEFAULT;
    L14:
        this(r2, r3, r4, r5);
    }
}
