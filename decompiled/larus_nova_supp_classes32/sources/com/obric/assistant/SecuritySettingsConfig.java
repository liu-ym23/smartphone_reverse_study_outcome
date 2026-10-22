package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/SecuritySettingsConfig;", NameKeys.UnloadStrategy_No_Strategy, "enableOSecurity", NameKeys.UnloadStrategy_No_Strategy, "enableOBlockDeeplinkQuery", "enableOBlockShareInDoubao", "enableOBlockDebugRouter", "oChatInputMaxLength", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(ZZZZI)V", "getEnableOSecurity", "()Z", "getEnableOBlockDeeplinkQuery", "getEnableOBlockShareInDoubao", "getEnableOBlockDebugRouter", "getOChatInputMaxLength", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SecuritySettingsConfig {

    @SerializedName("enable_o_block_debug_router")
    private final boolean enableOBlockDebugRouter;

    @SerializedName("enable_o_block_deeplink_query")
    private final boolean enableOBlockDeeplinkQuery;

    @SerializedName("enable_o_block_share_in_doubao")
    private final boolean enableOBlockShareInDoubao;

    @SerializedName("enable_o_security")
    private final boolean enableOSecurity;

    @SerializedName("o_chat_input_max_length")
    private final int oChatInputMaxLength;

    public SecuritySettingsConfig() {
        this(false, false, false, false, 0, 31, null);
    }

    public static /* synthetic */ SecuritySettingsConfig copy$default(SecuritySettingsConfig r3, boolean r4, boolean r5, boolean r6, boolean r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.enableOSecurity;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.enableOBlockDeeplinkQuery;
    L8:
        boolean r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.enableOBlockShareInDoubao;
    L11:
        boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.enableOBlockDebugRouter;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.oChatInputMaxLength;
    L17:
        boolean r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final boolean component1() {
        return this.enableOSecurity;
    }

    public final boolean component2() {
        return this.enableOBlockDeeplinkQuery;
    }

    public final boolean component3() {
        return this.enableOBlockShareInDoubao;
    }

    public final boolean component4() {
        return this.enableOBlockDebugRouter;
    }

    public final int component5() {
        return this.oChatInputMaxLength;
    }

    public final SecuritySettingsConfig copy(boolean r8, boolean r9, boolean r10, boolean r11, int r12) {
        return new SecuritySettingsConfig(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SecuritySettingsConfig) == true) goto L8;
        return false;
    L8:
        SecuritySettingsConfig r6 = (SecuritySettingsConfig) r5;
        if (this.enableOSecurity == r6.enableOSecurity) goto L12;
        return false;
    L12:
        if (this.enableOBlockDeeplinkQuery == r6.enableOBlockDeeplinkQuery) goto L15;
        return false;
    L15:
        if (this.enableOBlockShareInDoubao == r6.enableOBlockShareInDoubao) goto L18;
        return false;
    L18:
        if (this.enableOBlockDebugRouter == r6.enableOBlockDebugRouter) goto L21;
        return false;
    L21:
        if (this.oChatInputMaxLength == r6.oChatInputMaxLength) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enableOSecurity == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableOBlockDeeplinkQuery == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (r2 + r3) * 31;
        if (this.enableOBlockShareInDoubao == false) goto L13;
        int r5 = 1231;
    L14:
        int r6 = (r4 + r5) * 31;
        if (this.enableOBlockDebugRouter == true) goto L19;
        r1 = 1237;
    L19:
        return ((r6 + r1) * 31) + this.oChatInputMaxLength;
    L13:
        r5 = 1237;
        goto L14
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "SecuritySettingsConfig(enableOSecurity=" + this.enableOSecurity + ", enableOBlockDeeplinkQuery=" + this.enableOBlockDeeplinkQuery + ", enableOBlockShareInDoubao=" + this.enableOBlockShareInDoubao + ", enableOBlockDebugRouter=" + this.enableOBlockDebugRouter + ", oChatInputMaxLength=" + this.oChatInputMaxLength + ')';
    }

    public final boolean getEnableOBlockDebugRouter() {
        return this.enableOBlockDebugRouter;
    }

    public final boolean getEnableOBlockDeeplinkQuery() {
        return this.enableOBlockDeeplinkQuery;
    }

    public final boolean getEnableOBlockShareInDoubao() {
        return this.enableOBlockShareInDoubao;
    }

    public final boolean getEnableOSecurity() {
        return this.enableOSecurity;
    }

    public final int getOChatInputMaxLength() {
        return this.oChatInputMaxLength;
    }

    public SecuritySettingsConfig(boolean r1, boolean r2, boolean r3, boolean r4, int r5) {
        this.enableOSecurity = r1;
        this.enableOBlockDeeplinkQuery = r2;
        this.enableOBlockShareInDoubao = r3;
        this.enableOBlockDebugRouter = r4;
        this.oChatInputMaxLength = r5;
    }

    public /* synthetic */ SecuritySettingsConfig(boolean r4, boolean r5, boolean r6, boolean r7, int r8, int r9, DefaultConstructorMarker r10) {
        boolean r0 = true;
        if ((r9 & 1) == 0) goto L5;
        boolean r11 = true;
    L7:
        if ((r9 & 2) == 0) goto L9;
        boolean r1 = true;
    L11:
        if ((r9 & 4) == 0) goto L13;
        boolean r2 = true;
    L15:
        if ((r9 & 8) != 0) goto L19;
        r0 = r7;
    L19:
        if ((r9 & 16) == 0) goto L21;
        int r12 = 10000;
    L22:
        this(r11, r1, r2, r0, r12);
        return;
    L21:
        r12 = r8;
        goto L22
    L13:
        r2 = r6;
        goto L15
    L9:
        r1 = r5;
        goto L11
    L5:
        r11 = r4;
        goto L7
    }
}
