package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/chat/ObricWindowMessageBubbleConfig;", "", "enable", "", "lightMode", "Lcom/larus/platform/model/chat/ObricWindowMessageBubbleStyleConfig;", "darkMode", "<init>", "(ZLcom/larus/platform/model/chat/ObricWindowMessageBubbleStyleConfig;Lcom/larus/platform/model/chat/ObricWindowMessageBubbleStyleConfig;)V", "getEnable", "()Z", "getLightMode", "()Lcom/larus/platform/model/chat/ObricWindowMessageBubbleStyleConfig;", "getDarkMode", "getStyleConfig", "isDarkMode", "getColorToken", "", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ObricWindowMessageBubbleConfig {

    @SerializedName("dark_mode")
    private final ObricWindowMessageBubbleStyleConfig darkMode;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("light_mode")
    private final ObricWindowMessageBubbleStyleConfig lightMode;

    public ObricWindowMessageBubbleConfig() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ ObricWindowMessageBubbleConfig copy$default(ObricWindowMessageBubbleConfig r0, boolean r1, ObricWindowMessageBubbleStyleConfig r2, ObricWindowMessageBubbleStyleConfig r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enable;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.lightMode;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.darkMode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enable;
    }

    public final ObricWindowMessageBubbleStyleConfig component2() {
        return this.lightMode;
    }

    public final ObricWindowMessageBubbleStyleConfig component3() {
        return this.darkMode;
    }

    public final ObricWindowMessageBubbleConfig copy(boolean r2, ObricWindowMessageBubbleStyleConfig r3, ObricWindowMessageBubbleStyleConfig r4) {
        return new ObricWindowMessageBubbleConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricWindowMessageBubbleConfig) == true) goto L8;
        return false;
    L8:
        ObricWindowMessageBubbleConfig r6 = (ObricWindowMessageBubbleConfig) r5;
        if (this.enable == r6.enable) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lightMode, r6.lightMode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.darkMode, r6.darkMode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        ObricWindowMessageBubbleStyleConfig r2 = this.lightMode;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        ObricWindowMessageBubbleStyleConfig r6 = this.darkMode;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricWindowMessageBubbleConfig(enable=" + this.enable + ", lightMode=" + this.lightMode + ", darkMode=" + this.darkMode + ')';
    }

    public final ObricWindowMessageBubbleStyleConfig getDarkMode() {
        return this.darkMode;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final ObricWindowMessageBubbleStyleConfig getLightMode() {
        return this.lightMode;
    }

    public final String getColorToken(boolean r2) {
        if (r2 == false) goto L4;
        String r0 = "#1AFFFFFF";
    L5:
        String r3 = getStyleConfig(r2).getColorToken();
        if (r3 != null) goto L9;
        return r0;
    L9:
        return r3;
    L4:
        r0 = "#99FFFFFF";
        goto L5
    }

    public final ObricWindowMessageBubbleStyleConfig getStyleConfig(boolean r2) {
        if (r2 == false) goto L6;
        ObricWindowMessageBubbleStyleConfig r3 = this.darkMode;
        if (r3 == null) goto L11;
        return r3;
    L11:
        return new ObricWindowMessageBubbleStyleConfig("#1AFFFFFF");
    L6:
        ObricWindowMessageBubbleStyleConfig r4 = this.lightMode;
        if (r4 == null) goto L9;
        return r4;
    L9:
        return new ObricWindowMessageBubbleStyleConfig("#99FFFFFF");
    }

    public ObricWindowMessageBubbleConfig(boolean r1, ObricWindowMessageBubbleStyleConfig r2, ObricWindowMessageBubbleStyleConfig r3) {
        this.enable = r1;
        this.lightMode = r2;
        this.darkMode = r3;
    }

    public /* synthetic */ ObricWindowMessageBubbleConfig(boolean r1, ObricWindowMessageBubbleStyleConfig r2, ObricWindowMessageBubbleStyleConfig r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = new ObricWindowMessageBubbleStyleConfig("#99FFFFFF");
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = new ObricWindowMessageBubbleStyleConfig("#1AFFFFFF");
    L11:
        this(r1, r2, r3);
    }
}
