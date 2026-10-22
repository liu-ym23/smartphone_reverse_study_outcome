package l12;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001a¨\u0006'"}, d2 = {"Ll12/d;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "resultType", "Ljava/lang/Integer;", "getResultType", "()Ljava/lang/Integer;", "Lcom/google/gson/JsonObject;", "features", "Lcom/google/gson/JsonObject;", "getFeatures", "()Lcom/google/gson/JsonObject;", BuildConfig.FLAVOR, "scene", "Ljava/lang/String;", "getScene", "()Ljava/lang/String;", "sceneExtra", "getSceneExtra", "clientFeature", "getClientFeature", BuildConfig.FLAVOR, "Ll12/c;", "giftListChangeRule", "Ljava/util/List;", "getGiftListChangeRule", "()Ljava/util/List;", "Lcom/google/gson/JsonElement;", "strategyInfo", "getStrategyInfo", "roomLiveScene", "getRoomLiveScene", "Ll12/a;", "eventTrack", "Ll12/a;", "getEventTrack", "()Ll12/a;", "receiverType", "getReceiverType", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("client_feature")
    private final String clientFeature;

    @SerializedName("event_track")
    private final a eventTrack;

    @SerializedName("features")
    private final JsonObject features;

    @SerializedName("gift_list_change_rule")
    private final List<c> giftListChangeRule;

    @SerializedName("receiver_type")
    private final List<Integer> receiverType;

    @SerializedName("result_type")
    private final Integer resultType;

    @SerializedName("room_live_scene")
    private final String roomLiveScene;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("scene_extra")
    private final String sceneExtra;

    @SerializedName("strategy_info")
    private final List<JsonElement> strategyInfo;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L26;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.resultType, r4.resultType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.features, r4.features) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.scene, r4.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sceneExtra, r4.sceneExtra) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.clientFeature, r4.clientFeature) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.giftListChangeRule, r4.giftListChangeRule) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.strategyInfo, r4.strategyInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.roomLiveScene, r4.roomLiveScene) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.eventTrack, r4.eventTrack) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.receiverType, r4.receiverType) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.resultType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        JsonObject r4 = this.features;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.scene;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.sceneExtra;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r13 = (r9 + r11) * 31;
        String r14 = this.clientFeature;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        List<c> r17 = this.giftListChangeRule;
        if (r17 == null) goto L25;
        int r18 = r17.hashCode();
    L26:
        int r19 = (r16 + r18) * 31;
        List<JsonElement> r20 = this.strategyInfo;
        if (r20 == null) goto L29;
        int r21 = r20.hashCode();
    L30:
        int r23 = (r19 + r21) * 31;
        String r24 = this.roomLiveScene;
        if (r24 == null) goto L33;
        int r25 = r24.hashCode();
    L34:
        int r26 = (r23 + r25) * 31;
        a r27 = this.eventTrack;
        if (r27 == null) goto L37;
        int r28 = r27.hashCode();
    L38:
        int r29 = (r26 + r28) * 31;
        List<Integer> r30 = this.receiverType;
        if (r30 == null) goto L42;
        r1 = r30.hashCode();
    L42:
        return r29 + r1;
    L37:
        r28 = 0;
        goto L38
    L33:
        r25 = 0;
        goto L34
    L29:
        r21 = 0;
        goto L30
    L25:
        r18 = 0;
        goto L26
    L21:
        r15 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftSortMessageModel(resultType=" + this.resultType + ", features=" + this.features + ", scene=" + this.scene + ", sceneExtra=" + this.sceneExtra + ", clientFeature=" + this.clientFeature + ", giftListChangeRule=" + this.giftListChangeRule + ", strategyInfo=" + this.strategyInfo + ", roomLiveScene=" + this.roomLiveScene + ", eventTrack=" + this.eventTrack + ", receiverType=" + this.receiverType + ")";
    }

    public d() {
        this.resultType = null;
        this.features = null;
        this.scene = null;
        this.sceneExtra = null;
        this.clientFeature = null;
        this.giftListChangeRule = null;
        this.strategyInfo = null;
        this.roomLiveScene = null;
        this.eventTrack = null;
        this.receiverType = null;
    }
}
