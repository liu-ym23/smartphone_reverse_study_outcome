package com.larus.bmhome.chat.component.feedback;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/component/feedback/BotFavorWindowResponse;", "", "windowText", "", "enableWindow", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getWindowText", "()Ljava/lang/String;", "getEnableWindow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/component/feedback/BotFavorWindowResponse;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotFavorWindowResponse {

    @SerializedName("enable_window")
    private final Boolean enableWindow;

    @SerializedName("window_text")
    private final String windowText;

    /* JADX WARN: Multi-variable type inference failed */
    public BotFavorWindowResponse() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BotFavorWindowResponse copy$default(BotFavorWindowResponse r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.windowText;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.enableWindow;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.windowText;
    }

    public final Boolean component2() {
        return this.enableWindow;
    }

    public final BotFavorWindowResponse copy(String r2, Boolean r3) {
        return new BotFavorWindowResponse(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BotFavorWindowResponse) == true) goto L8;
        return false;
    L8:
        BotFavorWindowResponse r6 = (BotFavorWindowResponse) r5;
        if (Intrinsics.areEqual(this.windowText, r6.windowText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableWindow, r6.enableWindow) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.windowText;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enableWindow;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BotFavorWindowResponse(windowText=" + this.windowText + ", enableWindow=" + this.enableWindow + ')';
    }

    public final Boolean getEnableWindow() {
        return this.enableWindow;
    }

    public final String getWindowText() {
        return this.windowText;
    }

    public BotFavorWindowResponse(String r1, Boolean r2) {
        this.windowText = r1;
        this.enableWindow = r2;
    }

    public /* synthetic */ BotFavorWindowResponse(String r1, Boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = Boolean.FALSE;
    L8:
        this(r1, r2);
    }
}
