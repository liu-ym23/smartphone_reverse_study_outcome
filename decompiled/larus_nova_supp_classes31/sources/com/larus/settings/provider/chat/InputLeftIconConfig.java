package com.larus.settings.provider.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/settings/provider/chat/InputLeftIconConfig;", "", "isMainBotColorIconEnable", "", "isOtherBotColorIconEnable", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class InputLeftIconConfig {

    @SerializedName("is_main_bot_color_icon_enable")
    private final boolean isMainBotColorIconEnable;

    @SerializedName("is_other_bot_color_icon_enable")
    private final boolean isOtherBotColorIconEnable;

    public InputLeftIconConfig() {
        boolean r2 = false;
        this(r2, r2, 3, null);
    }

    public static /* synthetic */ InputLeftIconConfig copy$default(InputLeftIconConfig r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isMainBotColorIconEnable;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isOtherBotColorIconEnable;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isMainBotColorIconEnable;
    }

    public final boolean component2() {
        return this.isOtherBotColorIconEnable;
    }

    public final InputLeftIconConfig copy(boolean r2, boolean r3) {
        return new InputLeftIconConfig(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InputLeftIconConfig) == true) goto L8;
        return false;
    L8:
        InputLeftIconConfig r6 = (InputLeftIconConfig) r5;
        if (this.isMainBotColorIconEnable == r6.isMainBotColorIconEnable) goto L12;
        return false;
    L12:
        if (this.isOtherBotColorIconEnable == r6.isOtherBotColorIconEnable) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isMainBotColorIconEnable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isOtherBotColorIconEnable == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "InputLeftIconConfig(isMainBotColorIconEnable=" + this.isMainBotColorIconEnable + ", isOtherBotColorIconEnable=" + this.isOtherBotColorIconEnable + ')';
    }

    public final boolean isMainBotColorIconEnable() {
        return this.isMainBotColorIconEnable;
    }

    public final boolean isOtherBotColorIconEnable() {
        return this.isOtherBotColorIconEnable;
    }

    public InputLeftIconConfig(boolean r1, boolean r2) {
        this.isMainBotColorIconEnable = r1;
        this.isOtherBotColorIconEnable = r2;
    }

    public /* synthetic */ InputLeftIconConfig(boolean r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r2, r3);
    }
}
