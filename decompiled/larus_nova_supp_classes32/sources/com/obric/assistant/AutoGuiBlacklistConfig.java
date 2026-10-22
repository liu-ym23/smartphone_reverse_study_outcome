package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/obric/assistant/AutoGuiBlacklistConfig;", NameKeys.UnloadStrategy_No_Strategy, "obricAutoGuiAvailableHint", NameKeys.UnloadStrategy_No_Strategy, "obricAutoGuiBlacklistHint", "obricAutoGuiAppBlockedByThirdPartyHintEnable", NameKeys.UnloadStrategy_No_Strategy, "obricAutoGuiAppBlockedByThirdPartyHint", "obricAutoGuiAppBlockedByObricHintEnable", "obricAutoGuiAppBlockedByObricHint", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getObricAutoGuiAvailableHint", "()Ljava/lang/String;", "getObricAutoGuiBlacklistHint", "getObricAutoGuiAppBlockedByThirdPartyHintEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getObricAutoGuiAppBlockedByThirdPartyHint", "getObricAutoGuiAppBlockedByObricHintEnable", "getObricAutoGuiAppBlockedByObricHint", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/obric/assistant/AutoGuiBlacklistConfig;", "equals", "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoGuiBlacklistConfig {

    @SerializedName("obric_auto_gui_app_blocked_by_obric_hint")
    private final String obricAutoGuiAppBlockedByObricHint;

    @SerializedName("obric_auto_gui_app_blocked_by_obric_hint_enable")
    private final Boolean obricAutoGuiAppBlockedByObricHintEnable;

    @SerializedName("obric_auto_gui_app_blocked_by_third_party_hint")
    private final String obricAutoGuiAppBlockedByThirdPartyHint;

    @SerializedName("obric_auto_gui_app_blocked_by_third_party_hint_enable")
    private final Boolean obricAutoGuiAppBlockedByThirdPartyHintEnable;

    @SerializedName("obric_auto_gui_available_hint")
    private final String obricAutoGuiAvailableHint;

    @SerializedName("obric_auto_gui_blacklist_hint")
    private final String obricAutoGuiBlacklistHint;

    public AutoGuiBlacklistConfig() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ AutoGuiBlacklistConfig copy$default(AutoGuiBlacklistConfig r4, String r5, String r6, Boolean r7, String r8, Boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.obricAutoGuiAvailableHint;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.obricAutoGuiBlacklistHint;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.obricAutoGuiAppBlockedByThirdPartyHintEnable;
    L11:
        Boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.obricAutoGuiAppBlockedByThirdPartyHint;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.obricAutoGuiAppBlockedByObricHintEnable;
    L17:
        Boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.obricAutoGuiAppBlockedByObricHint;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.obricAutoGuiAvailableHint;
    }

    public final String component2() {
        return this.obricAutoGuiBlacklistHint;
    }

    public final Boolean component3() {
        return this.obricAutoGuiAppBlockedByThirdPartyHintEnable;
    }

    public final String component4() {
        return this.obricAutoGuiAppBlockedByThirdPartyHint;
    }

    public final Boolean component5() {
        return this.obricAutoGuiAppBlockedByObricHintEnable;
    }

    public final String component6() {
        return this.obricAutoGuiAppBlockedByObricHint;
    }

    public final AutoGuiBlacklistConfig copy(String r9, String r10, Boolean r11, String r12, Boolean r13, String r14) {
        return new AutoGuiBlacklistConfig(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AutoGuiBlacklistConfig) == true) goto L8;
        return false;
    L8:
        AutoGuiBlacklistConfig r6 = (AutoGuiBlacklistConfig) r5;
        if (Intrinsics.areEqual(this.obricAutoGuiAvailableHint, r6.obricAutoGuiAvailableHint) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.obricAutoGuiBlacklistHint, r6.obricAutoGuiBlacklistHint) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.obricAutoGuiAppBlockedByThirdPartyHintEnable, r6.obricAutoGuiAppBlockedByThirdPartyHintEnable) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.obricAutoGuiAppBlockedByThirdPartyHint, r6.obricAutoGuiAppBlockedByThirdPartyHint) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.obricAutoGuiAppBlockedByObricHintEnable, r6.obricAutoGuiAppBlockedByObricHintEnable) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.obricAutoGuiAppBlockedByObricHint, r6.obricAutoGuiAppBlockedByObricHint) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.obricAutoGuiAvailableHint;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.obricAutoGuiBlacklistHint;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.obricAutoGuiAppBlockedByThirdPartyHintEnable;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.obricAutoGuiAppBlockedByThirdPartyHint;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.obricAutoGuiAppBlockedByObricHintEnable;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.obricAutoGuiAppBlockedByObricHint;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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

    public String toString() {
        return "AutoGuiBlacklistConfig(obricAutoGuiAvailableHint=" + this.obricAutoGuiAvailableHint + ", obricAutoGuiBlacklistHint=" + this.obricAutoGuiBlacklistHint + ", obricAutoGuiAppBlockedByThirdPartyHintEnable=" + this.obricAutoGuiAppBlockedByThirdPartyHintEnable + ", obricAutoGuiAppBlockedByThirdPartyHint=" + this.obricAutoGuiAppBlockedByThirdPartyHint + ", obricAutoGuiAppBlockedByObricHintEnable=" + this.obricAutoGuiAppBlockedByObricHintEnable + ", obricAutoGuiAppBlockedByObricHint=" + this.obricAutoGuiAppBlockedByObricHint + ')';
    }

    public final String getObricAutoGuiAppBlockedByObricHint() {
        return this.obricAutoGuiAppBlockedByObricHint;
    }

    public final Boolean getObricAutoGuiAppBlockedByObricHintEnable() {
        return this.obricAutoGuiAppBlockedByObricHintEnable;
    }

    public final String getObricAutoGuiAppBlockedByThirdPartyHint() {
        return this.obricAutoGuiAppBlockedByThirdPartyHint;
    }

    public final Boolean getObricAutoGuiAppBlockedByThirdPartyHintEnable() {
        return this.obricAutoGuiAppBlockedByThirdPartyHintEnable;
    }

    public final String getObricAutoGuiAvailableHint() {
        return this.obricAutoGuiAvailableHint;
    }

    public final String getObricAutoGuiBlacklistHint() {
        return this.obricAutoGuiBlacklistHint;
    }

    public AutoGuiBlacklistConfig(String r1, String r2, Boolean r3, String r4, Boolean r5, String r6) {
        this.obricAutoGuiAvailableHint = r1;
        this.obricAutoGuiBlacklistHint = r2;
        this.obricAutoGuiAppBlockedByThirdPartyHintEnable = r3;
        this.obricAutoGuiAppBlockedByThirdPartyHint = r4;
        this.obricAutoGuiAppBlockedByObricHintEnable = r5;
        this.obricAutoGuiAppBlockedByObricHint = r6;
    }

    public /* synthetic */ AutoGuiBlacklistConfig(String r5, String r6, Boolean r7, String r8, Boolean r9, String r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = "界面操作可用范围";
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = "暂不支持以下应用";
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = Boolean.TRUE;
    L11:
        Boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = "受该应用平台政策限制，无法操作";
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = Boolean.FALSE;
    L17:
        Boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = NameKeys.UnloadStrategy_No_Strategy;
    L20:
        String r14 = r5;
        this(r14, r13, r0, r1, r2, r10);
    }
}
