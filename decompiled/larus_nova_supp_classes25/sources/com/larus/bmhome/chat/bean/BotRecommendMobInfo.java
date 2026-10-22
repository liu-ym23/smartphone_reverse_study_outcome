package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u001bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010$\u001a\u00020%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000f¨\u00061"}, d2 = {"Lcom/larus/bmhome/chat/bean/BotRecommendMobInfo;", "Landroid/os/Parcelable;", "botId", "", "isCertificationLabel", "certificationLabelType", "labelList", "isCapabilityLabel", "capabilityLabelCnt", "discoverPageTabId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBotId", "()Ljava/lang/String;", "setBotId", "(Ljava/lang/String;)V", "getCertificationLabelType", "getLabelList", "setCapabilityLabel", "getCapabilityLabelCnt", "setCapabilityLabelCnt", "getDiscoverPageTabId", "setDiscoverPageTabId", "fillParams", "Lorg/json/JSONObject;", "src", "fillTrackParams", "Lcom/ixigua/lib/track/TrackParams;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotRecommendMobInfo implements Parcelable {
    public static final Parcelable.Creator<BotRecommendMobInfo> CREATOR = null;

    @SerializedName("bot_id")
    private String botId;

    @SerializedName("capability_label_cnt")
    private String capabilityLabelCnt;

    @SerializedName("certification_label_type")
    private final String certificationLabelType;

    @SerializedName("discover_page_tab_id")
    private String discoverPageTabId;

    @SerializedName("is_capability_label")
    private String isCapabilityLabel;

    @SerializedName("is_certification_label")
    private final String isCertificationLabel;

    @SerializedName("label_list")
    private final String labelList;

    public static final class a implements Parcelable.Creator<BotRecommendMobInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotRecommendMobInfo createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new BotRecommendMobInfo(r10.readString(), r10.readString(), r10.readString(), r10.readString(), r10.readString(), r10.readString(), r10.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final BotRecommendMobInfo[] newArray(int r1) {
            return new BotRecommendMobInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotRecommendMobInfo() {
        this(null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotRecommendMobInfo) == true) goto L8;
        return false;
    L8:
        BotRecommendMobInfo r6 = (BotRecommendMobInfo) r5;
        if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isCertificationLabel, r6.isCertificationLabel) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.certificationLabelType, r6.certificationLabelType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.labelList, r6.labelList) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isCapabilityLabel, r6.isCapabilityLabel) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.capabilityLabelCnt, r6.capabilityLabelCnt) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.discoverPageTabId, r6.discoverPageTabId) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.botId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.isCertificationLabel;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.certificationLabelType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.labelList;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.isCapabilityLabel;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.capabilityLabelCnt;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.discoverPageTabId;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotRecommendMobInfo(botId=" + this.botId + ", isCertificationLabel=" + this.isCertificationLabel + ", certificationLabelType=" + this.certificationLabelType + ", labelList=" + this.labelList + ", isCapabilityLabel=" + this.isCapabilityLabel + ", capabilityLabelCnt=" + this.capabilityLabelCnt + ", discoverPageTabId=" + this.discoverPageTabId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.botId);
        r1.writeString(this.isCertificationLabel);
        r1.writeString(this.certificationLabelType);
        r1.writeString(this.labelList);
        r1.writeString(this.isCapabilityLabel);
        r1.writeString(this.capabilityLabelCnt);
        r1.writeString(this.discoverPageTabId);
    }

    public final JSONObject a(JSONObject r3) {
        if (r3 != null) goto L4;
        r3 = new JSONObject();
    L4:
        r3.put("bot_id", this.botId);
        r3.put("is_certification_label", this.isCertificationLabel);
        r3.put("certification_label_type", this.certificationLabelType);
        r3.put("label_list", this.labelList);
        r3.put("is_capability_label", this.isCapabilityLabel);
        r3.put("capability_label_cnt", this.capabilityLabelCnt);
        r3.put("discover_page_tab_id", this.discoverPageTabId);
        return r3;
    }

    public final void b(TrackParams r3) {
        Intrinsics.checkNotNullParameter(r3, "src");
        r3.put("bot_id", this.botId);
        r3.put("is_certification_label", this.isCertificationLabel);
        r3.put("certification_label_type", this.certificationLabelType);
        r3.put("label_list", this.labelList);
        r3.put("is_capability_label", this.isCapabilityLabel);
        r3.put("capability_label_cnt", this.capabilityLabelCnt);
        r3.put("discover_page_tab_id", this.discoverPageTabId);
    }

    public BotRecommendMobInfo(String r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        this.botId = r1;
        this.isCertificationLabel = r2;
        this.certificationLabelType = r3;
        this.labelList = r4;
        this.isCapabilityLabel = r5;
        this.capabilityLabelCnt = r6;
        this.discoverPageTabId = r7;
    }
}
