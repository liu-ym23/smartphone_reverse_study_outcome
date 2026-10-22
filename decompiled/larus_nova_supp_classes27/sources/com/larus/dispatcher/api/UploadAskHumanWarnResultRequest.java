package com.larus.dispatcher.api;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J@\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/dispatcher/api/UploadAskHumanWarnResultRequest;", "", "callbackId", "", "scene", "", "params", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getCallbackId", "()Ljava/lang/String;", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getParams", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lcom/larus/dispatcher/api/UploadAskHumanWarnResultRequest;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadAskHumanWarnResultRequest {

    @SerializedName("callback_id")
    private final String callbackId;

    @SerializedName("params")
    private final Map<String, Object> params;

    @SerializedName("scene")
    private final Integer scene;

    public UploadAskHumanWarnResultRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UploadAskHumanWarnResultRequest copy$default(UploadAskHumanWarnResultRequest r0, String r1, Integer r2, Map r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.callbackId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.scene;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.params;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.callbackId;
    }

    public final Integer component2() {
        return this.scene;
    }

    public final Map<String, Object> component3() {
        return this.params;
    }

    public final UploadAskHumanWarnResultRequest copy(String r2, Integer r3, Map<String, ? extends Object> r4) {
        return new UploadAskHumanWarnResultRequest(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UploadAskHumanWarnResultRequest) == true) goto L8;
        return false;
    L8:
        UploadAskHumanWarnResultRequest r6 = (UploadAskHumanWarnResultRequest) r5;
        if (Intrinsics.areEqual(this.callbackId, r6.callbackId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.callbackId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.scene;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Map<String, Object> r7 = this.params;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "UploadAskHumanWarnResultRequest(callbackId=" + this.callbackId + ", scene=" + this.scene + ", params=" + this.params + ')';
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public UploadAskHumanWarnResultRequest(String r1, Integer r2, Map<String, ? extends Object> r3) {
        this.callbackId = r1;
        this.scene = r2;
        this.params = r3;
    }

    public /* synthetic */ UploadAskHumanWarnResultRequest(String r2, Integer r3, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
