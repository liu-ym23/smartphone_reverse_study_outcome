package com.bytedance.android.ec.core.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012@\b\u0002\u0010\u0002\u001a:\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010JA\u0010 \u001a:\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u0007HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u008c\u0001\u0010%\u001a\u00020\u00002@\b\u0002\u0010\u0002\u001a:\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0004HÖ\u0001R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bRV\u0010\u0002\u001a:\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0003j\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/core/data/EntranceInfoWriteConfig;", "Ljava/io/Serializable;", "ruleList", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/android/ec/core/data/ParamsWriteConfig;", "Lkotlin/collections/HashMap;", "checkKeysList", "", "enable", "", "passFiltered", "", "forceRuleList", "Lcom/bytedance/android/ec/core/data/ParamsForceRule;", "(Ljava/util/HashMap;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/List;Lcom/bytedance/android/ec/core/data/ParamsForceRule;)V", "getCheckKeysList", "()Ljava/util/Set;", "setCheckKeysList", "(Ljava/util/Set;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getForceRuleList", "()Lcom/bytedance/android/ec/core/data/ParamsForceRule;", "getPassFiltered", "()Ljava/util/List;", "getRuleList", "()Ljava/util/HashMap;", "setRuleList", "(Ljava/util/HashMap;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/util/HashMap;Ljava/util/Set;Ljava/lang/Boolean;Ljava/util/List;Lcom/bytedance/android/ec/core/data/ParamsForceRule;)Lcom/bytedance/android/ec/core/data/EntranceInfoWriteConfig;", "equals", "other", "", "hashCode", "", "toString", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EntranceInfoWriteConfig implements Serializable {

    @SerializedName("check_keys")
    private Set<String> checkKeysList;

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("force_rule")
    private final ParamsForceRule forceRuleList;

    @SerializedName("pass_filtered")
    private final List<String> passFiltered;

    @SerializedName("rule_list")
    private HashMap<String, Map<String, ParamsWriteConfig>> ruleList;

    public EntranceInfoWriteConfig() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EntranceInfoWriteConfig copy$default(EntranceInfoWriteConfig r10, HashMap r11, Set r12, Boolean r13, List r14, ParamsForceRule r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L6;
        r11 = r10.ruleList;
    L6:
        if ((r16 & 2) == 0) goto L8;
        r12 = r10.checkKeysList;
    L8:
        Set r18 = r12;
        if ((r16 & 4) == 0) goto L11;
        r13 = r10.enable;
    L11:
        Boolean r0 = r13;
        if ((r16 & 8) == 0) goto L14;
        r14 = r10.passFiltered;
    L14:
        List r1 = r14;
        if ((r16 & 16) == 0) goto L17;
        r15 = r10.forceRuleList;
    L17:
        HashMap r19 = r11;
        return r10.copy(r19, r18, r0, r1, r15);
    }

    public final HashMap<String, Map<String, ParamsWriteConfig>> component1() {
        return this.ruleList;
    }

    public final Set<String> component2() {
        return this.checkKeysList;
    }

    public final Boolean component3() {
        return this.enable;
    }

    public final List<String> component4() {
        return this.passFiltered;
    }

    public final ParamsForceRule component5() {
        return this.forceRuleList;
    }

    public final EntranceInfoWriteConfig copy(HashMap<String, Map<String, ParamsWriteConfig>> r10, Set<String> r11, Boolean r12, List<String> r13, ParamsForceRule r14) {
        return new EntranceInfoWriteConfig(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof EntranceInfoWriteConfig) == false) goto L16;
        EntranceInfoWriteConfig r11 = (EntranceInfoWriteConfig) r10;
        if (Intrinsics.areEqual(this.ruleList, r11.ruleList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.checkKeysList, r11.checkKeysList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enable, r11.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.passFiltered, r11.passFiltered) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.forceRuleList, r11.forceRuleList) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        HashMap<String, Map<String, ParamsWriteConfig>> r0 = this.ruleList;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Set<String> r12 = this.checkKeysList;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        Boolean r15 = this.enable;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        List<String> r18 = this.passFiltered;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        ParamsForceRule r21 = this.forceRuleList;
        if (r21 == null) goto L22;
        r1 = r21.hashCode();
    L22:
        return r20 + r1;
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "EntranceInfoWriteConfig(ruleList=" + this.ruleList + ", checkKeysList=" + this.checkKeysList + ", enable=" + this.enable + ", passFiltered=" + this.passFiltered + ", forceRuleList=" + this.forceRuleList + ")";
    }

    public final Set<String> getCheckKeysList() {
        return this.checkKeysList;
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final ParamsForceRule getForceRuleList() {
        return this.forceRuleList;
    }

    public final List<String> getPassFiltered() {
        return this.passFiltered;
    }

    public final HashMap<String, Map<String, ParamsWriteConfig>> getRuleList() {
        return this.ruleList;
    }

    public final void setCheckKeysList(Set<String> r1) {
        this.checkKeysList = r1;
    }

    public final void setRuleList(HashMap<String, Map<String, ParamsWriteConfig>> r1) {
        this.ruleList = r1;
    }

    public EntranceInfoWriteConfig(HashMap<String, Map<String, ParamsWriteConfig>> r1, Set<String> r10, Boolean r11, List<String> r12, ParamsForceRule r13) {
        this.ruleList = r1;
        this.checkKeysList = r10;
        this.enable = r11;
        this.passFiltered = r12;
        this.forceRuleList = r13;
    }

    public /* synthetic */ EntranceInfoWriteConfig(HashMap r10, Set r11, Boolean r12, List r13, ParamsForceRule r14, int r15, DefaultConstructorMarker r16) {
        if ((r15 & 1) == 0) goto L5;
        HashMap r17 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        Set r1 = null;
    L11:
        if ((r15 & 4) == 0) goto L13;
        r12 = Boolean.FALSE;
    L13:
        Boolean r18 = r12;
        if ((r15 & 8) == 0) goto L16;
        List r19 = null;
    L18:
        if ((r15 & 16) == 0) goto L20;
        ParamsForceRule r110 = null;
    L21:
        this(r17, r1, r18, r19, r110);
        return;
    L20:
        r110 = r14;
        goto L21
    L16:
        r19 = r13;
        goto L18
    L9:
        r1 = r11;
        goto L11
    L5:
        r17 = r10;
        goto L7
    }
}
