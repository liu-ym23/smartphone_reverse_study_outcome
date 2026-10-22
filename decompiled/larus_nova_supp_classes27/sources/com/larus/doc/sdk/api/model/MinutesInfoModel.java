package com.larus.doc.sdk.api.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/doc/sdk/api/model/MinutesInfoModel;", "Ljava/io/Serializable;", "mmToken", "", "hasAudio", "", "objType", "", "<init>", "(Ljava/lang/String;ZI)V", "getMmToken", "()Ljava/lang/String;", "getHasAudio", "()Z", "getObjType", "()I", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinutesInfoModel implements Serializable {
    private final boolean hasAudio;
    private final String mmToken;
    private final int objType;

    public MinutesInfoModel() {
        this(null, false, 0, 7, null);
    }

    public static /* synthetic */ MinutesInfoModel copy$default(MinutesInfoModel r0, String r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.mmToken;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.hasAudio;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.objType;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.mmToken;
    }

    public final boolean component2() {
        return this.hasAudio;
    }

    public final int component3() {
        return this.objType;
    }

    public final MinutesInfoModel copy(@JSONField(name = "mmToken") String r2, @JSONField(name = "hasAudio") boolean r3, @JSONField(name = "objType") int r4) {
        Intrinsics.checkNotNullParameter(r2, "mmToken");
        return new MinutesInfoModel(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MinutesInfoModel) == true) goto L8;
        return false;
    L8:
        MinutesInfoModel r6 = (MinutesInfoModel) r5;
        if (Intrinsics.areEqual(this.mmToken, r6.mmToken) == true) goto L12;
        return false;
    L12:
        if (this.hasAudio == r6.hasAudio) goto L15;
        return false;
    L15:
        if (this.objType == r6.objType) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.mmToken.hashCode() * 31;
        if (this.hasAudio == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.objType;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "MinutesInfoModel(mmToken=" + this.mmToken + ", hasAudio=" + this.hasAudio + ", objType=" + this.objType + ')';
    }

    public final boolean getHasAudio() {
        return this.hasAudio;
    }

    public final String getMmToken() {
        return this.mmToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public MinutesInfoModel(@JSONField(name = "mmToken") String r2, @JSONField(name = "hasAudio") boolean r3, @JSONField(name = "objType") int r4) {
        Intrinsics.checkNotNullParameter(r2, "mmToken");
        this.mmToken = r2;
        this.hasAudio = r3;
        this.objType = r4;
    }

    public /* synthetic */ MinutesInfoModel(String r2, boolean r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
