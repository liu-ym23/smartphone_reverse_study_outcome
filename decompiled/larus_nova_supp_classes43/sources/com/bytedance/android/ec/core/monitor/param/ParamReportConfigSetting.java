package com.bytedance.android.ec.core.monitor.param;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012&\b\u0002\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000fJ'\u0010\u001c\u001a \u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0003Jz\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062&\b\u0002\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R4\u0010\u0007\u001a \u0012\u0004\u0012\u00020\t\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bytedance/android/ec/core/monitor/param/ParamReportConfigSetting;", "Ljava/io/Serializable;", "enable", "", "enableSchemaDiff", "defaultSample", "", "sampleConfigMap", "", "", "tradeBtmList", "", "filterKeys", "(ZZLjava/lang/Float;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)V", "getDefaultSample", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getEnable", "()Z", "getEnableSchemaDiff", "getFilterKeys", "()Ljava/util/List;", "getSampleConfigMap", "()Ljava/util/Map;", "getTradeBtmList", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ZZLjava/lang/Float;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)Lcom/bytedance/android/ec/core/monitor/param/ParamReportConfigSetting;", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParamReportConfigSetting implements Serializable {

    @SerializedName("default_sample")
    private final Float defaultSample;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_schema_diff")
    private final boolean enableSchemaDiff;

    @SerializedName("filter_keys")
    private final List<String> filterKeys;

    @SerializedName("sample_config_map")
    private final Map<String, Map<String, Float>> sampleConfigMap;

    @SerializedName("trade_btm_list")
    private final List<String> tradeBtmList;

    public ParamReportConfigSetting() {
        this(false, false, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ParamReportConfigSetting copy$default(ParamReportConfigSetting r10, boolean r11, boolean r12, Float r13, Map r14, List r15, List r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.enable;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.enableSchemaDiff;
    L8:
        boolean r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.defaultSample;
    L11:
        Float r0 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.sampleConfigMap;
    L14:
        Map r1 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.tradeBtmList;
    L17:
        List r20 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.filterKeys;
    L20:
        boolean r21 = r11;
        return r10.copy(r21, r19, r0, r1, r20, r16);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final boolean component2() {
        return this.enableSchemaDiff;
    }

    public final Float component3() {
        return this.defaultSample;
    }

    public final Map<String, Map<String, Float>> component4() {
        return this.sampleConfigMap;
    }

    public final List<String> component5() {
        return this.tradeBtmList;
    }

    public final List<String> component6() {
        return this.filterKeys;
    }

    public final ParamReportConfigSetting copy(boolean r10, boolean r11, Float r12, Map<String, ? extends Map<String, Float>> r13, List<String> r14, List<String> r15) {
        return new ParamReportConfigSetting(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ParamReportConfigSetting) == false) goto L18;
        ParamReportConfigSetting r11 = (ParamReportConfigSetting) r10;
        if (this.enable == r11.enable) goto L8;
        return false;
    L8:
        if (this.enableSchemaDiff == r11.enableSchemaDiff) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.defaultSample, r11.defaultSample) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sampleConfigMap, r11.sampleConfigMap) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.tradeBtmList, r11.tradeBtmList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.filterKeys, r11.filterKeys) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = 1;
        ?? r10 = r0;
        if (r0 == false) goto L5;
        r10 = 1;
    L5:
        int r11 = r10 * 31;
        boolean r12 = this.enableSchemaDiff;
        if (r12 == true) goto L9;
        r1 = r12;
    L9:
        int r13 = (r11 + r1) * 31;
        Float r14 = this.defaultSample;
        int r15 = 0;
        if (r14 == null) goto L12;
        int r16 = r14.hashCode();
    L13:
        int r17 = (r13 + r16) * 31;
        Map<String, Map<String, Float>> r18 = this.sampleConfigMap;
        if (r18 == null) goto L16;
        int r19 = r18.hashCode();
    L17:
        int r20 = (r17 + r19) * 31;
        List<String> r21 = this.tradeBtmList;
        if (r21 == null) goto L20;
        int r22 = r21.hashCode();
    L21:
        int r23 = (r20 + r22) * 31;
        List<String> r24 = this.filterKeys;
        if (r24 == null) goto L25;
        r15 = r24.hashCode();
    L25:
        return r23 + r15;
    L20:
        r22 = 0;
        goto L21
    L16:
        r19 = 0;
        goto L17
    L12:
        r16 = 0;
        goto L13
    }

    public String toString() {
        return "ParamReportConfigSetting(enable=" + this.enable + ", enableSchemaDiff=" + this.enableSchemaDiff + ", defaultSample=" + this.defaultSample + ", sampleConfigMap=" + this.sampleConfigMap + ", tradeBtmList=" + this.tradeBtmList + ", filterKeys=" + this.filterKeys + ")";
    }

    public final Float getDefaultSample() {
        return this.defaultSample;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableSchemaDiff() {
        return this.enableSchemaDiff;
    }

    public final List<String> getFilterKeys() {
        return this.filterKeys;
    }

    public final Map<String, Map<String, Float>> getSampleConfigMap() {
        return this.sampleConfigMap;
    }

    public final List<String> getTradeBtmList() {
        return this.tradeBtmList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ParamReportConfigSetting(boolean r1, boolean r10, Float r11, Map<String, ? extends Map<String, Float>> r12, List<String> r13, List<String> r14) {
        this.enable = r1;
        this.enableSchemaDiff = r10;
        this.defaultSample = r11;
        this.sampleConfigMap = r12;
        this.tradeBtmList = r13;
        this.filterKeys = r14;
    }

    public /* synthetic */ ParamReportConfigSetting(boolean r10, boolean r11, Float r12, Map r13, List r14, List r15, int r16, DefaultConstructorMarker r17) {
        boolean r0 = true;
        if ((r16 & 1) == 0) goto L5;
        boolean r18 = true;
    L7:
        if ((r16 & 2) != 0) goto L11;
        r0 = r11;
    L11:
        if ((r16 & 4) == 0) goto L13;
        r12 = Float.valueOf(1.0f);
    L13:
        Float r1 = r12;
        if ((r16 & 8) == 0) goto L16;
        Map r19 = null;
    L18:
        if ((r16 & 16) == 0) goto L20;
        List r20 = null;
    L22:
        if ((r16 & 32) == 0) goto L24;
        r15 = CollectionsKt.listOf(new String[]{"track_client", "track_client_entrance_info", "client_native_params_event_additions"});
    L24:
        this(r18, r0, r1, r19, r20, r15);
        return;
    L20:
        r20 = r14;
        goto L22
    L16:
        r19 = r13;
        goto L18
    L5:
        r18 = r10;
        goto L7
    }
}
