package com.larus.dora.impl.ota.g;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/ota/g/CheckRemoteResponse;", "", "status", "", "message", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/dora/impl/ota/g/CheckRemoteResponse;", "equals", "", "other", "hashCode", "toString", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckRemoteResponse {
    public static final a Companion = null;
    public static final int ERROR_OK = 0;
    public static final int OTA_ERROR_NO_ENOUGH_POWER = 3;
    public static final int OTA_ERROR_NO_SPACE = 2;
    public static final int OTA_ERROR_NO_SPACE_AND_ENOUGH_POWER = 4;
    public static final int OTA_ERROR_PARSE_PARAM_FAILED = 1;
    public static final int OTA_WARNING_OTA_UPDATING = 100;
    public static final int OTA_WARNING_UPLOADED = 101;

    @SerializedName("message")
    private final String message;

    @SerializedName("status")
    private final Integer status;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CheckRemoteResponse() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CheckRemoteResponse copy$default(CheckRemoteResponse r0, Integer r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.status;
    }

    public final String component2() {
        return this.message;
    }

    public final CheckRemoteResponse copy(Integer r2, String r3) {
        return new CheckRemoteResponse(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CheckRemoteResponse) == true) goto L8;
        return false;
    L8:
        CheckRemoteResponse r6 = (CheckRemoteResponse) r5;
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.status;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.message;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CheckRemoteResponse(status=" + this.status + ", message=" + this.message + ')';
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public CheckRemoteResponse(Integer r1, String r2) {
        this.status = r1;
        this.message = r2;
    }

    public /* synthetic */ CheckRemoteResponse(Integer r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = "";
    L8:
        this(r1, r2);
    }
}
