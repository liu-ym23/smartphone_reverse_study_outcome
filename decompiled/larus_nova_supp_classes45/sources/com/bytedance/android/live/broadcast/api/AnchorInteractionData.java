package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J:\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/AnchorInteractionData;", "", "appId", "", "appType", "", "interactionType", "extra", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAppType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExtra", "getInteractionType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/android/live/broadcast/api/AnchorInteractionData;", "equals", "", "other", "hashCode", "", "toString", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInteractionData {

    @SerializedName(OpenPlatformBaseDebugger.APP_ID)
    private final String appId;

    @SerializedName("app_type")
    private final Long appType;

    @SerializedName("extra")
    private final String extra;

    @SerializedName("interaction_type")
    private final Long interactionType;

    public AnchorInteractionData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AnchorInteractionData copy$default(AnchorInteractionData r0, String r1, Long r2, Long r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.appId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.appType;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.interactionType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.extra;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.appId;
    }

    public final Long component2() {
        return this.appType;
    }

    public final Long component3() {
        return this.interactionType;
    }

    public final String component4() {
        return this.extra;
    }

    public final AnchorInteractionData copy(String r2, Long r3, Long r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r5, "extra");
        return new AnchorInteractionData(r2, r3, r4, r5);
    }

    public String toString() {
        return "AnchorInteractionData(appId=" + this.appId + ", appType=" + this.appType + ", interactionType=" + this.interactionType + ", extra=" + this.extra + ")";
    }

    public int hashCode() {
        return AnchorInteractionData.class.hashCode();
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Long getAppType() {
        return this.appType;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final Long getInteractionType() {
        return this.interactionType;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(AnchorInteractionData.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L24;
        AnchorInteractionData r6 = (AnchorInteractionData) r5;
        if ((!Intrinsics.areEqual(this.appType, r6.appType)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.appId, r6.appId)) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.interactionType, r6.interactionType)) == false) goto L22;
        return false;
    L22:
        return true;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.AnchorInteractionData");
    L8:
        r2 = null;
        goto L10
    }

    public AnchorInteractionData(String r2, Long r3, Long r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r5, "extra");
        this.appId = r2;
        this.appType = r3;
        this.interactionType = r4;
        this.extra = r5;
    }

    public /* synthetic */ AnchorInteractionData(String r3, Long r4, Long r5, String r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = "";
    L14:
        this(r3, r4, r5, r6);
    }
}
