package com.larus.bmhome.rc;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/bmhome/rc/CreateVideoFrameTaskRequest;", "", "uri", "", "configId", "", "<init>", "(Ljava/lang/String;I)V", "getUri", "()Ljava/lang/String;", "getConfigId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateVideoFrameTaskRequest {

    @SerializedName("config_id")
    private final int configId;

    @SerializedName("uri")
    private final String uri;

    public CreateVideoFrameTaskRequest() {
        String r2 = null;
        this(r2, 0, 3, r2);
    }

    public static /* synthetic */ CreateVideoFrameTaskRequest copy$default(CreateVideoFrameTaskRequest r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.uri;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.configId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.uri;
    }

    public final int component2() {
        return this.configId;
    }

    public final CreateVideoFrameTaskRequest copy(String r2, int r3) {
        return new CreateVideoFrameTaskRequest(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreateVideoFrameTaskRequest) == true) goto L8;
        return false;
    L8:
        CreateVideoFrameTaskRequest r6 = (CreateVideoFrameTaskRequest) r5;
        if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L12;
        return false;
    L12:
        if (this.configId == r6.configId) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.uri;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.configId;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "CreateVideoFrameTaskRequest(uri=" + this.uri + ", configId=" + this.configId + ')';
    }

    public final int getConfigId() {
        return this.configId;
    }

    public final String getUri() {
        return this.uri;
    }

    public CreateVideoFrameTaskRequest(String r1, int r2) {
        this.uri = r1;
        this.configId = r2;
    }

    public /* synthetic */ CreateVideoFrameTaskRequest(String r1, int r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 0;
    L8:
        this(r1, r2);
    }
}
