package com.bytedance.rpc.model.kotlin;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/bytedance/rpc/model/kotlin/UserCommonParam;", "Ljava/io/Serializable;", "geoLocation", "Lcom/bytedance/rpc/model/kotlin/GEOLocation;", "(Lcom/bytedance/rpc/model/kotlin/GEOLocation;)V", "getGeoLocation", "()Lcom/bytedance/rpc/model/kotlin/GEOLocation;", "setGeoLocation", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
public final class UserCommonParam implements Serializable {

    @SerializedName("geo_location")
    private GEOLocation geoLocation;

    /* JADX WARN: Multi-variable type inference failed */
    public UserCommonParam() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public UserCommonParam(GEOLocation r1) {
        this.geoLocation = r1;
    }

    public /* synthetic */ UserCommonParam(GEOLocation r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = (GEOLocation) ZeusTransformUtils.preCheckCast(null, GEOLocation.class, "com.obric.memorydata.plugin");
    L5:
        this(r1);
    }

    public static /* synthetic */ UserCommonParam copy$default(UserCommonParam r0, GEOLocation r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.geoLocation;
    L6:
        return r0.copy(r1);
    }

    public final GEOLocation component1() {
        return this.geoLocation;
    }

    public final UserCommonParam copy(GEOLocation r1) {
        return new UserCommonParam(r1);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, UserCommonParam.class) == false) goto L9;
        UserCommonParam r4 = (UserCommonParam) ZeusTransformUtils.preCheckCast(r3, UserCommonParam.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.geoLocation, r4.geoLocation) == true) goto L14;
        return false;
    L14:
        return true;
    L9:
        return false;
    }

    public final GEOLocation getGeoLocation() {
        return this.geoLocation;
    }

    public int hashCode() {
        GEOLocation r0 = this.geoLocation;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final void setGeoLocation(GEOLocation r1) {
        this.geoLocation = r1;
    }

    public String toString() {
        return "UserCommonParam(geoLocation=" + this.geoLocation + ")";
    }
}
