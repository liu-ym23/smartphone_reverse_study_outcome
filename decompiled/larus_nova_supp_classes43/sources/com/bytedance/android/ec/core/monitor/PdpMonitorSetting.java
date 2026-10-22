package com.bytedance.android.ec.core.monitor;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0003J\u0088\u0001\u0010(\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\tHÖ\u0001J\t\u0010.\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/PdpMonitorSetting;", "Ljava/io/Serializable;", "actionALogBlockList", "", "", "aLogSwitch", "", "uploadSwitch", "invalidMinute", "", "uploadSample", "", "aptActionMonitorIdList", "aptBtmWhiteList", "sampleConfigMap", "", "(Ljava/util/List;ZZLjava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "getALogSwitch", "()Z", "getActionALogBlockList", "()Ljava/util/List;", "getAptActionMonitorIdList", "getAptBtmWhiteList", "getInvalidMinute", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSampleConfigMap", "()Ljava/util/Map;", "getUploadSample", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getUploadSwitch", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/List;ZZLjava/lang/Integer;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)Lcom/bytedance/android/ec/core/monitor/PdpMonitorSetting;", "equals", "other", "", "hashCode", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpMonitorSetting implements Serializable {

    @SerializedName("alog_switch")
    private final boolean aLogSwitch;

    @SerializedName("action_alog_block_list")
    private final List<String> actionALogBlockList;

    @SerializedName("apt_action_monitor_id_list")
    private final List<String> aptActionMonitorIdList;

    @SerializedName("apt_btm_white_list")
    private final List<String> aptBtmWhiteList;

    @SerializedName("apt_invalid_time")
    private final Integer invalidMinute;

    @SerializedName("sample_config_map")
    private final Map<String, Integer> sampleConfigMap;

    @SerializedName("upload_sample")
    private final Float uploadSample;

    @SerializedName("upload_switch")
    private final boolean uploadSwitch;

    public PdpMonitorSetting() {
        this(null, false, false, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PdpMonitorSetting copy$default(PdpMonitorSetting r10, List r11, boolean r12, boolean r13, Integer r14, Float r15, List r16, List r17, Map r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        List r20 = r10.actionALogBlockList;
    L7:
        if ((r19 & 2) == 0) goto L9;
        boolean r21 = r10.aLogSwitch;
    L11:
        if ((r19 & 4) == 0) goto L13;
        boolean r22 = r10.uploadSwitch;
    L15:
        if ((r19 & 8) == 0) goto L17;
        Integer r23 = r10.invalidMinute;
    L19:
        if ((r19 & 16) == 0) goto L21;
        Float r24 = r10.uploadSample;
    L23:
        if ((r19 & 32) == 0) goto L25;
        List r25 = r10.aptActionMonitorIdList;
    L27:
        if ((r19 & 64) == 0) goto L29;
        List r26 = r10.aptBtmWhiteList;
    L31:
        if ((r19 & 128) == 0) goto L33;
        Map r1 = r10.sampleConfigMap;
    L35:
        return r10.copy(r20, r21, r22, r23, r24, r25, r26, r1);
    L33:
        r1 = r18;
        goto L35
    L29:
        r26 = r17;
        goto L31
    L25:
        r25 = r16;
        goto L27
    L21:
        r24 = r15;
        goto L23
    L17:
        r23 = r14;
        goto L19
    L13:
        r22 = r13;
        goto L15
    L9:
        r21 = r12;
        goto L11
    L5:
        r20 = r11;
        goto L7
    }

    public final List<String> component1() {
        return this.actionALogBlockList;
    }

    public final boolean component2() {
        return this.aLogSwitch;
    }

    public final boolean component3() {
        return this.uploadSwitch;
    }

    public final Integer component4() {
        return this.invalidMinute;
    }

    public final Float component5() {
        return this.uploadSample;
    }

    public final List<String> component6() {
        return this.aptActionMonitorIdList;
    }

    public final List<String> component7() {
        return this.aptBtmWhiteList;
    }

    public final Map<String, Integer> component8() {
        return this.sampleConfigMap;
    }

    public final PdpMonitorSetting copy(List<String> r11, boolean r12, boolean r13, Integer r14, Float r15, List<String> r16, List<String> r17, Map<String, Integer> r18) {
        return new PdpMonitorSetting(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof PdpMonitorSetting) == false) goto L22;
        PdpMonitorSetting r11 = (PdpMonitorSetting) r10;
        if (Intrinsics.areEqual(this.actionALogBlockList, r11.actionALogBlockList) == true) goto L8;
        return false;
    L8:
        if (this.aLogSwitch == r11.aLogSwitch) goto L10;
        return false;
    L10:
        if (this.uploadSwitch == r11.uploadSwitch) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.invalidMinute, r11.invalidMinute) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.uploadSample, r11.uploadSample) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.aptActionMonitorIdList, r11.aptActionMonitorIdList) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.aptBtmWhiteList, r11.aptBtmWhiteList) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.sampleConfigMap, r11.sampleConfigMap) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        List<String> r0 = this.actionALogBlockList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        boolean r12 = this.aLogSwitch;
        ?? r13 = 1;
        ?? r14 = r12;
        if (r12 == false) goto L9;
        r14 = 1;
    L9:
        int r15 = (r11 + r14) * 31;
        boolean r16 = this.uploadSwitch;
        if (r16 == true) goto L13;
        r13 = r16;
    L13:
        int r17 = (r15 + r13) * 31;
        Integer r18 = this.invalidMinute;
        if (r18 == null) goto L16;
        int r19 = r18.hashCode();
    L17:
        int r20 = (r17 + r19) * 31;
        Float r21 = this.uploadSample;
        if (r21 == null) goto L20;
        int r22 = r21.hashCode();
    L21:
        int r23 = (r20 + r22) * 31;
        List<String> r24 = this.aptActionMonitorIdList;
        if (r24 == null) goto L24;
        int r25 = r24.hashCode();
    L25:
        int r26 = (r23 + r25) * 31;
        List<String> r27 = this.aptBtmWhiteList;
        if (r27 == null) goto L28;
        int r28 = r27.hashCode();
    L29:
        int r29 = (r26 + r28) * 31;
        Map<String, Integer> r30 = this.sampleConfigMap;
        if (r30 == null) goto L33;
        r1 = r30.hashCode();
    L33:
        return r29 + r1;
    L28:
        r28 = 0;
        goto L29
    L24:
        r25 = 0;
        goto L25
    L20:
        r22 = 0;
        goto L21
    L16:
        r19 = 0;
        goto L17
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "PdpMonitorSetting(actionALogBlockList=" + this.actionALogBlockList + ", aLogSwitch=" + this.aLogSwitch + ", uploadSwitch=" + this.uploadSwitch + ", invalidMinute=" + this.invalidMinute + ", uploadSample=" + this.uploadSample + ", aptActionMonitorIdList=" + this.aptActionMonitorIdList + ", aptBtmWhiteList=" + this.aptBtmWhiteList + ", sampleConfigMap=" + this.sampleConfigMap + ")";
    }

    public final boolean getALogSwitch() {
        return this.aLogSwitch;
    }

    public final List<String> getActionALogBlockList() {
        return this.actionALogBlockList;
    }

    public final List<String> getAptActionMonitorIdList() {
        return this.aptActionMonitorIdList;
    }

    public final List<String> getAptBtmWhiteList() {
        return this.aptBtmWhiteList;
    }

    public final Integer getInvalidMinute() {
        return this.invalidMinute;
    }

    public final Map<String, Integer> getSampleConfigMap() {
        return this.sampleConfigMap;
    }

    public final Float getUploadSample() {
        return this.uploadSample;
    }

    public final boolean getUploadSwitch() {
        return this.uploadSwitch;
    }

    public PdpMonitorSetting(List<String> r1, boolean r10, boolean r11, Integer r12, Float r13, List<String> r14, List<String> r15, Map<String, Integer> r16) {
        this.actionALogBlockList = r1;
        this.aLogSwitch = r10;
        this.uploadSwitch = r11;
        this.invalidMinute = r12;
        this.uploadSample = r13;
        this.aptActionMonitorIdList = r14;
        this.aptBtmWhiteList = r15;
        this.sampleConfigMap = r16;
    }

    public /* synthetic */ PdpMonitorSetting(List r10, boolean r11, boolean r12, Integer r13, Float r14, List r15, List r16, Map r17, int r18, DefaultConstructorMarker r19) {
        Map r20 = null;
        if ((r18 & 1) == 0) goto L5;
        List r1 = null;
    L6:
        boolean r21 = false;
        if ((r18 & 2) == 0) goto L9;
        boolean r22 = false;
    L11:
        if ((r18 & 4) != 0) goto L15;
        r21 = r12;
    L15:
        if ((r18 & 8) == 0) goto L17;
        Integer r23 = null;
    L19:
        if ((r18 & 16) == 0) goto L21;
        Float r24 = Float.valueOf(0.0f);
    L23:
        if ((r18 & 32) == 0) goto L25;
        List r25 = null;
    L27:
        if ((r18 & 64) == 0) goto L29;
        List r26 = null;
    L31:
        if ((r18 & 128) != 0) goto L34;
        r20 = r17;
    L34:
        this(r1, r22, r21, r23, r24, r25, r26, r20);
        return;
    L29:
        r26 = r16;
        goto L31
    L25:
        r25 = r15;
        goto L27
    L21:
        r24 = r14;
        goto L23
    L17:
        r23 = r13;
        goto L19
    L9:
        r22 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L6
    }
}
