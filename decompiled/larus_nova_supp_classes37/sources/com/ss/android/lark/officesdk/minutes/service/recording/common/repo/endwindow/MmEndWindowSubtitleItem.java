package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010#\u001a\u00020\u0003H\u0016J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010/\u001a\u00020\u0003HÆ\u0003J\u008c\u0001\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00067"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitleItem;", "Ljava/io/Serializable;", AppbrandHostConstants.Schema_Meta.NAME, "", "time", "", "sourceMsg", "avatarUrl", "avatarKey", "clusterId", "correctedTime", "deviceId", "speakerType", "", "identifyMethod", "userType", "uid", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getTime", "()J", "getSourceMsg", "getAvatarUrl", "getAvatarKey", "getClusterId", "getCorrectedTime", "getDeviceId", "getSpeakerType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIdentifyMethod", "getUserType", "getUid", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowSubtitleItem;", "equals", "", "other", "", "hashCode", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowSubtitleItem implements Serializable {
    private final String avatarKey;
    private final String avatarUrl;
    private final String clusterId;
    private final long correctedTime;
    private final String deviceId;
    private final String identifyMethod;
    private final String name;
    private final String sourceMsg;
    private final Integer speakerType;
    private final long time;
    private final String uid;
    private final Integer userType;

    public MmEndWindowSubtitleItem() {
        this(null, 0, null, null, null, null, 0, null, null, null, null, null, 4095, null);
    }

    public static /* synthetic */ MmEndWindowSubtitleItem copy$default(MmEndWindowSubtitleItem r15, String r16, long r17, String r19, String r20, String r21, String r22, long r23, String r25, Integer r26, String r27, Integer r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r2 = r15.name;
    L7:
        if ((r30 & 2) == 0) goto L9;
        long r3 = r15.time;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r5 = r15.sourceMsg;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r6 = r15.avatarUrl;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r7 = r15.avatarKey;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r8 = r15.clusterId;
    L27:
        if ((r30 & 64) == 0) goto L29;
        long r9 = r15.correctedTime;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r11 = r15.deviceId;
    L35:
        if ((r30 & 256) == 0) goto L37;
        Integer r12 = r15.speakerType;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r13 = r15.identifyMethod;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        Integer r14 = r15.userType;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r1 = r15.uid;
    L51:
        return r15.copy(r2, r3, r5, r6, r7, r8, r9, r11, r12, r13, r14, r1);
    L49:
        r1 = r29;
        goto L51
    L45:
        r14 = r28;
        goto L47
    L41:
        r13 = r27;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r11 = r25;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.identifyMethod;
    }

    public final Integer component11() {
        return this.userType;
    }

    public final String component12() {
        return this.uid;
    }

    public final long component2() {
        return this.time;
    }

    public final String component3() {
        return this.sourceMsg;
    }

    public final String component4() {
        return this.avatarUrl;
    }

    public final String component5() {
        return this.avatarKey;
    }

    public final String component6() {
        return this.clusterId;
    }

    public final long component7() {
        return this.correctedTime;
    }

    public final String component8() {
        return this.deviceId;
    }

    public final Integer component9() {
        return this.speakerType;
    }

    public final MmEndWindowSubtitleItem copy(String r17, long r18, String r20, String r21, String r22, String r23, long r24, String r26, Integer r27, String r28, Integer r29, String r30) {
        Intrinsics.checkNotNullParameter(r17, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r20, "sourceMsg");
        Intrinsics.checkNotNullParameter(r21, "avatarUrl");
        Intrinsics.checkNotNullParameter(r22, "avatarKey");
        Intrinsics.checkNotNullParameter(r23, "clusterId");
        Intrinsics.checkNotNullParameter(r28, "identifyMethod");
        Intrinsics.checkNotNullParameter(r30, "uid");
        return new MmEndWindowSubtitleItem(r17, r18, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MmEndWindowSubtitleItem) == true) goto L8;
        return false;
    L8:
        MmEndWindowSubtitleItem r9 = (MmEndWindowSubtitleItem) r8;
        if (Intrinsics.areEqual(this.name, r9.name) == true) goto L12;
        return false;
    L12:
        if (this.time == r9.time) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceMsg, r9.sourceMsg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatarUrl, r9.avatarUrl) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.avatarKey, r9.avatarKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.clusterId, r9.clusterId) == true) goto L27;
        return false;
    L27:
        if (this.correctedTime == r9.correctedTime) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.deviceId, r9.deviceId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.speakerType, r9.speakerType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.identifyMethod, r9.identifyMethod) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.userType, r9.userType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.uid, r9.uid) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        int r0 = this.name.hashCode() * 31;
        long r1 = this.time;
        int r2 = (((((((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.sourceMsg.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.avatarKey.hashCode()) * 31) + this.clusterId.hashCode()) * 31;
        long r3 = this.correctedTime;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        String r5 = this.deviceId;
        int r6 = 0;
        if (r5 != null) goto L5;
        int r7 = 0;
    L6:
        int r8 = (r4 + r7) * 31;
        Integer r9 = this.speakerType;
        if (r9 != null) goto L9;
        int r10 = 0;
    L10:
        int r11 = (((r8 + r10) * 31) + this.identifyMethod.hashCode()) * 31;
        Integer r12 = this.userType;
        if (r12 == null) goto L15;
        r6 = r12.hashCode();
    L15:
        return ((r11 + r6) * 31) + this.uid.hashCode();
    L9:
        r10 = r9.hashCode();
        goto L10
    L5:
        r7 = r5.hashCode();
        goto L6
    }

    public String toString() {
        return "SubtitleItem(name='" + this.name + "', time=" + this.time + ", avatarUrl='" + this.avatarUrl + "', avatarKey='" + this.avatarKey + "', clusterId='" + this.clusterId + "', correctedTime=" + this.correctedTime + ", deviceId=" + this.deviceId + ", speakerType=" + this.speakerType + ", identifyMethod='" + this.identifyMethod + "', userType=" + this.userType + ", uid='" + this.uid + "')";
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final String getClusterId() {
        return this.clusterId;
    }

    public final long getCorrectedTime() {
        return this.correctedTime;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getIdentifyMethod() {
        return this.identifyMethod;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSourceMsg() {
        return this.sourceMsg;
    }

    public final Integer getSpeakerType() {
        return this.speakerType;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getUid() {
        return this.uid;
    }

    public final Integer getUserType() {
        return this.userType;
    }

    public MmEndWindowSubtitleItem(String r2, long r3, String r5, String r6, String r7, String r8, long r9, String r11, Integer r12, String r13, Integer r14, String r15) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_Meta.NAME);
        Intrinsics.checkNotNullParameter(r5, "sourceMsg");
        Intrinsics.checkNotNullParameter(r6, "avatarUrl");
        Intrinsics.checkNotNullParameter(r7, "avatarKey");
        Intrinsics.checkNotNullParameter(r8, "clusterId");
        Intrinsics.checkNotNullParameter(r13, "identifyMethod");
        Intrinsics.checkNotNullParameter(r15, "uid");
        this.name = r2;
        this.time = r3;
        this.sourceMsg = r5;
        this.avatarUrl = r6;
        this.avatarKey = r7;
        this.clusterId = r8;
        this.correctedTime = r9;
        this.deviceId = r11;
        this.speakerType = r12;
        this.identifyMethod = r13;
        this.userType = r14;
        this.uid = r15;
    }

    public /* synthetic */ MmEndWindowSubtitleItem(String r17, long r18, String r20, String r21, String r22, String r23, long r24, String r26, Integer r27, String r28, Integer r29, String r30, int r31, DefaultConstructorMarker r32) {
        String r2 = "";
        if ((r31 & 1) == 0) goto L5;
        String r1 = "";
    L6:
        long r4 = 0;
        if ((r31 & 2) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r31 & 4) == 0) goto L13;
        String r3 = "";
    L15:
        if ((r31 & 8) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r31 & 16) == 0) goto L21;
        String r9 = "";
    L23:
        if ((r31 & 32) == 0) goto L25;
        String r10 = "";
    L27:
        if ((r31 & 64) != 0) goto L30;
        r4 = r24;
    L30:
        Integer r12 = null;
        if ((r31 & 128) == 0) goto L33;
        String r11 = null;
    L35:
        if ((r31 & 256) == 0) goto L37;
        Integer r13 = null;
    L39:
        if ((r31 & 512) == 0) goto L41;
        String r14 = "unknown";
    L43:
        if ((r31 & 1024) != 0) goto L47;
        r12 = r29;
    L47:
        if ((r31 & 2048) != 0) goto L50;
        r2 = r30;
    L50:
        this(r1, r6, r3, r8, r9, r10, r4, r11, r13, r14, r12, r2);
        return;
    L41:
        r14 = r28;
        goto L43
    L37:
        r13 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L25:
        r10 = r23;
        goto L27
    L21:
        r9 = r22;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r3 = r20;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L6
    }
}
