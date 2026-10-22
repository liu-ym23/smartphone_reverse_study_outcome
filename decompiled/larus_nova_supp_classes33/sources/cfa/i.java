package cfa;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0017\u001a\u00020\u0005J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015JX\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\n\u0010\u0015¨\u0006&"}, d2 = {"Lcom/obric/assistant/obric_action/handler/chat_page/OpenWindowActionParams;", "", "activateClickTalk", "", "assistantRequestFrom", "", "checkScreenLock", "interruptMovingBackground", "forceUseDefaultDisplay", "forceOpenActivity", "isMicInUse", "<init>", "(ZLjava/lang/String;ZZZZLjava/lang/Boolean;)V", "getActivateClickTalk", "()Z", "getAssistantRequestFrom", "()Ljava/lang/String;", "getCheckScreenLock", "getInterruptMovingBackground", "getForceUseDefaultDisplay", "getForceOpenActivity", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "assistantRequestFromOrDefault", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZLjava/lang/String;ZZZZLjava/lang/Boolean;)Lcom/obric/assistant/obric_action/handler/chat_page/OpenWindowActionParams;", "equals", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class i {

    @SerializedName("activateClickTalk")
    private final boolean activateClickTalk;

    @SerializedName("assistantRequestFrom")
    private final String assistantRequestFrom;

    @SerializedName("checkScreenLock")
    private final boolean checkScreenLock;

    @SerializedName("forceOpenActivity")
    private final boolean forceOpenActivity;

    @SerializedName("forceUseDefaultDisplay")
    private final boolean forceUseDefaultDisplay;

    @SerializedName("interruptMovingBackground")
    private final boolean interruptMovingBackground;

    @SerializedName("isMicInUse")
    private final Boolean isMicInUse;

    public i() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (this.activateClickTalk == r6.activateClickTalk) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.assistantRequestFrom, r6.assistantRequestFrom) == true) goto L15;
        return false;
    L15:
        if (this.checkScreenLock == r6.checkScreenLock) goto L18;
        return false;
    L18:
        if (this.interruptMovingBackground == r6.interruptMovingBackground) goto L21;
        return false;
    L21:
        if (this.forceUseDefaultDisplay == r6.forceUseDefaultDisplay) goto L24;
        return false;
    L24:
        if (this.forceOpenActivity == r6.forceOpenActivity) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isMicInUse, r6.isMicInUse) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.activateClickTalk == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        String r3 = this.assistantRequestFrom;
        int r4 = 0;
        if (r3 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r2 + r5) * 31;
        if (this.checkScreenLock == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.interruptMovingBackground == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.forceUseDefaultDisplay == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.forceOpenActivity == true) goto L26;
        r1 = 1237;
    L26:
        int r13 = (r12 + r1) * 31;
        Boolean r14 = this.isMicInUse;
        if (r14 == null) goto L31;
        r4 = r14.hashCode();
    L31:
        return r13 + r4;
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "OpenWindowActionParams(activateClickTalk=" + this.activateClickTalk + ", assistantRequestFrom=" + this.assistantRequestFrom + ", checkScreenLock=" + this.checkScreenLock + ", interruptMovingBackground=" + this.interruptMovingBackground + ", forceUseDefaultDisplay=" + this.forceUseDefaultDisplay + ", forceOpenActivity=" + this.forceOpenActivity + ", isMicInUse=" + this.isMicInUse + ')';
    }

    public final String a() {
        String r0 = this.assistantRequestFrom;
        if (r0 == null) goto L5;
        String r1 = StringsKt.trim(r0).toString();
    L6:
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        if (r1.length() != 0) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        return "obric_action_open_window";
    L15:
        return r1;
    L11:
        r2 = false;
        goto L12
    L5:
        r1 = null;
        goto L6
    }

    public final boolean b() {
        return this.activateClickTalk;
    }

    public final boolean c() {
        return this.checkScreenLock;
    }

    public final boolean d() {
        return this.forceOpenActivity;
    }

    public final boolean e() {
        return this.forceUseDefaultDisplay;
    }

    public final boolean f() {
        return this.interruptMovingBackground;
    }

    public final Boolean g() {
        return this.isMicInUse;
    }

    public i(int r3) {
        this.activateClickTalk = false;
        this.assistantRequestFrom = null;
        this.checkScreenLock = true;
        this.interruptMovingBackground = true;
        this.forceUseDefaultDisplay = false;
        this.forceOpenActivity = false;
        this.isMicInUse = null;
    }
}
