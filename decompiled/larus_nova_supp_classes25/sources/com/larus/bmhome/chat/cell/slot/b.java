package com.larus.bmhome.chat.cell.slot;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/chat/cell/slot/MessageBottomExtAction;", "", "type", "", "enable", "", "displayText", "", "lightIcon", "darkIcon", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getEnable", "()Z", "getDisplayText", "()Ljava/lang/String;", "getLightIcon", "getDarkIcon", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class b {

    @SerializedName("dark_icon")
    private final String darkIcon;

    @SerializedName("display_text")
    private final String displayText;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("light_icon")
    private final String lightIcon;

    @SerializedName("type")
    private final int type;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (this.enable == r6.enable) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displayText, r6.displayText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lightIcon, r6.lightIcon) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.darkIcon, r6.darkIcon) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.type * 31;
        if (this.enable == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        String r3 = this.displayText;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        String r7 = this.lightIcon;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.darkIcon;
        if (r10 == null) goto L19;
        r4 = r10.hashCode();
    L19:
        return r9 + r4;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MessageBottomExtAction(type=" + this.type + ", enable=" + this.enable + ", displayText=" + this.displayText + ", lightIcon=" + this.lightIcon + ", darkIcon=" + this.darkIcon + ')';
    }

    public b() {
        this.type = -1;
        this.enable = false;
        this.displayText = null;
        this.lightIcon = null;
        this.darkIcon = null;
    }

    public final String a() {
        return this.darkIcon;
    }

    public final String b() {
        return this.displayText;
    }

    public final boolean c() {
        return this.enable;
    }

    public final String d() {
        return this.lightIcon;
    }

    public final int getType() {
        return this.type;
    }
}
