package com.obric.aiagent.authentication.license;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/aiagent/authentication/license/License;", "", "version", "", Params.CONTENT, "Lcom/google/gson/JsonObject;", "signature", "", "<init>", "(ILcom/google/gson/JsonObject;Ljava/lang/String;)V", "getVersion", "()I", "getContent", "()Lcom/google/gson/JsonObject;", "getSignature", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class License {

    @SerializedName(Params.CONTENT)
    private final JsonObject content;

    @SerializedName("signature")
    private final String signature;

    @SerializedName("version")
    private final int version;

    public License(int r2, JsonObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r4, "signature");
        this.version = r2;
        this.content = r3;
        this.signature = r4;
    }

    public static /* synthetic */ License copy$default(License r0, int r1, JsonObject r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.version;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.signature;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.version;
    }

    public final JsonObject component2() {
        return this.content;
    }

    public final String component3() {
        return this.signature;
    }

    public final License copy(int r1, JsonObject r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r3, "signature");
        return new License(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, License.class) == true) goto L8;
        return false;
    L8:
        License r6 = (License) ZeusTransformUtils.preCheckCast(r5, License.class, "com.obric.memorydata.plugin");
        if (this.version == r6.version) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.signature, r6.signature) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final JsonObject getContent() {
        return this.content;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.version) * 31) + this.content.hashCode()) * 31) + this.signature.hashCode();
    }

    public String toString() {
        return "License(version=" + this.version + ", content=" + this.content + ", signature=" + this.signature + ')';
    }
}
