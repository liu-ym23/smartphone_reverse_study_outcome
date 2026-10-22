package com.larus.uaigc.bean.createpage.component.sendmessage;

import com.tencent.open.log.TraceLevel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b1\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J£\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u0006HÆ\u0001J\u0013\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u000108HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019¨\u0006<"}, d2 = {"Lcom/larus/uaigc/bean/createpage/component/sendmessage/CreationSendUiEvent;", "Ljava/io/Serializable;", "cvsId", "", "requestId", "closeCreationPager", "", "closeGalleryDialog", "switchToChatTab", "closeAttachmentPanel", "scrollToLatest", "setLastReadRestore", "endModify", "markChatListBottomReached", "notifyCoreInputEvent", "cacheMemorizedOptions", "closeBottomAlbumBeforeSend", "clearInputContentAfterSend", "hasAttachment", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZZZZZZZZZZZ)V", "getCvsId", "()Ljava/lang/String;", "getRequestId", "getCloseCreationPager", "()Z", "getCloseGalleryDialog", "getSwitchToChatTab", "getCloseAttachmentPanel", "getScrollToLatest", "getSetLastReadRestore", "getEndModify", "getMarkChatListBottomReached", "getNotifyCoreInputEvent", "getCacheMemorizedOptions", "getCloseBottomAlbumBeforeSend", "getClearInputContentAfterSend", "getHasAttachment", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationSendUiEvent implements Serializable {
    private final boolean cacheMemorizedOptions;
    private final boolean clearInputContentAfterSend;
    private final boolean closeAttachmentPanel;
    private final boolean closeBottomAlbumBeforeSend;
    private final boolean closeCreationPager;
    private final boolean closeGalleryDialog;
    private final String cvsId;
    private final boolean endModify;
    private final boolean hasAttachment;
    private final boolean markChatListBottomReached;
    private final boolean notifyCoreInputEvent;
    private final String requestId;
    private final boolean scrollToLatest;
    private final boolean setLastReadRestore;
    private final boolean switchToChatTab;

    public CreationSendUiEvent() {
        this(null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, 32767, null);
    }

    public static /* synthetic */ CreationSendUiEvent copy$default(CreationSendUiEvent r16, String r17, String r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        String r2 = r16.cvsId;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r3 = r16.requestId;
    L11:
        if ((r32 & 4) == 0) goto L13;
        boolean r4 = r16.closeCreationPager;
    L15:
        if ((r32 & 8) == 0) goto L17;
        boolean r5 = r16.closeGalleryDialog;
    L19:
        if ((r32 & 16) == 0) goto L21;
        boolean r6 = r16.switchToChatTab;
    L23:
        if ((r32 & 32) == 0) goto L25;
        boolean r7 = r16.closeAttachmentPanel;
    L27:
        if ((r32 & 64) == 0) goto L29;
        boolean r8 = r16.scrollToLatest;
    L31:
        if ((r32 & 128) == 0) goto L33;
        boolean r9 = r16.setLastReadRestore;
    L35:
        if ((r32 & 256) == 0) goto L37;
        boolean r10 = r16.endModify;
    L39:
        if ((r32 & 512) == 0) goto L41;
        boolean r11 = r16.markChatListBottomReached;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        boolean r12 = r16.notifyCoreInputEvent;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        boolean r13 = r16.cacheMemorizedOptions;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        boolean r14 = r16.closeBottomAlbumBeforeSend;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        boolean r15 = r16.clearInputContentAfterSend;
    L59:
        if ((r32 & 16384) == 0) goto L61;
        boolean r1 = r16.hasAttachment;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L61:
        r1 = r31;
        goto L63
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final String component1() {
        return this.cvsId;
    }

    public final boolean component10() {
        return this.markChatListBottomReached;
    }

    public final boolean component11() {
        return this.notifyCoreInputEvent;
    }

    public final boolean component12() {
        return this.cacheMemorizedOptions;
    }

    public final boolean component13() {
        return this.closeBottomAlbumBeforeSend;
    }

    public final boolean component14() {
        return this.clearInputContentAfterSend;
    }

    public final boolean component15() {
        return this.hasAttachment;
    }

    public final String component2() {
        return this.requestId;
    }

    public final boolean component3() {
        return this.closeCreationPager;
    }

    public final boolean component4() {
        return this.closeGalleryDialog;
    }

    public final boolean component5() {
        return this.switchToChatTab;
    }

    public final boolean component6() {
        return this.closeAttachmentPanel;
    }

    public final boolean component7() {
        return this.scrollToLatest;
    }

    public final boolean component8() {
        return this.setLastReadRestore;
    }

    public final boolean component9() {
        return this.endModify;
    }

    public final CreationSendUiEvent copy(String r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, boolean r32) {
        return new CreationSendUiEvent(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CreationSendUiEvent) == true) goto L8;
        return false;
    L8:
        CreationSendUiEvent r6 = (CreationSendUiEvent) r5;
        if (Intrinsics.areEqual(this.cvsId, r6.cvsId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L15;
        return false;
    L15:
        if (this.closeCreationPager == r6.closeCreationPager) goto L18;
        return false;
    L18:
        if (this.closeGalleryDialog == r6.closeGalleryDialog) goto L21;
        return false;
    L21:
        if (this.switchToChatTab == r6.switchToChatTab) goto L24;
        return false;
    L24:
        if (this.closeAttachmentPanel == r6.closeAttachmentPanel) goto L27;
        return false;
    L27:
        if (this.scrollToLatest == r6.scrollToLatest) goto L30;
        return false;
    L30:
        if (this.setLastReadRestore == r6.setLastReadRestore) goto L33;
        return false;
    L33:
        if (this.endModify == r6.endModify) goto L36;
        return false;
    L36:
        if (this.markChatListBottomReached == r6.markChatListBottomReached) goto L39;
        return false;
    L39:
        if (this.notifyCoreInputEvent == r6.notifyCoreInputEvent) goto L42;
        return false;
    L42:
        if (this.cacheMemorizedOptions == r6.cacheMemorizedOptions) goto L45;
        return false;
    L45:
        if (this.closeBottomAlbumBeforeSend == r6.closeBottomAlbumBeforeSend) goto L48;
        return false;
    L48:
        if (this.clearInputContentAfterSend == r6.clearInputContentAfterSend) goto L51;
        return false;
    L51:
        if (this.hasAttachment == r6.hasAttachment) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        String r0 = this.cvsId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.requestId;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        int r6 = 1231;
        if (this.closeCreationPager == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r5 + r7) * 31;
        if (this.closeGalleryDialog == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.switchToChatTab == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.closeAttachmentPanel == false) goto L25;
        int r13 = 1231;
    L26:
        int r14 = (r12 + r13) * 31;
        if (this.scrollToLatest == false) goto L29;
        int r15 = 1231;
    L30:
        int r16 = (r14 + r15) * 31;
        if (this.setLastReadRestore == false) goto L33;
        int r17 = 1231;
    L34:
        int r18 = (r16 + r17) * 31;
        if (this.endModify == false) goto L37;
        int r19 = 1231;
    L38:
        int r20 = (r18 + r19) * 31;
        if (this.markChatListBottomReached == false) goto L41;
        int r21 = 1231;
    L42:
        int r22 = (r20 + r21) * 31;
        if (this.notifyCoreInputEvent == false) goto L45;
        int r23 = 1231;
    L46:
        int r24 = (r22 + r23) * 31;
        if (this.cacheMemorizedOptions == false) goto L49;
        int r25 = 1231;
    L50:
        int r26 = (r24 + r25) * 31;
        if (this.closeBottomAlbumBeforeSend == false) goto L53;
        int r27 = 1231;
    L54:
        int r28 = (r26 + r27) * 31;
        if (this.clearInputContentAfterSend == false) goto L57;
        int r29 = 1231;
    L58:
        int r30 = (r28 + r29) * 31;
        if (this.hasAttachment == true) goto L63;
        r6 = 1237;
    L63:
        return r30 + r6;
    L57:
        r29 = 1237;
        goto L58
    L53:
        r27 = 1237;
        goto L54
    L49:
        r25 = 1237;
        goto L50
    L45:
        r23 = 1237;
        goto L46
    L41:
        r21 = 1237;
        goto L42
    L37:
        r19 = 1237;
        goto L38
    L33:
        r17 = 1237;
        goto L34
    L29:
        r15 = 1237;
        goto L30
    L25:
        r13 = 1237;
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationSendUiEvent(cvsId=" + this.cvsId + ", requestId=" + this.requestId + ", closeCreationPager=" + this.closeCreationPager + ", closeGalleryDialog=" + this.closeGalleryDialog + ", switchToChatTab=" + this.switchToChatTab + ", closeAttachmentPanel=" + this.closeAttachmentPanel + ", scrollToLatest=" + this.scrollToLatest + ", setLastReadRestore=" + this.setLastReadRestore + ", endModify=" + this.endModify + ", markChatListBottomReached=" + this.markChatListBottomReached + ", notifyCoreInputEvent=" + this.notifyCoreInputEvent + ", cacheMemorizedOptions=" + this.cacheMemorizedOptions + ", closeBottomAlbumBeforeSend=" + this.closeBottomAlbumBeforeSend + ", clearInputContentAfterSend=" + this.clearInputContentAfterSend + ", hasAttachment=" + this.hasAttachment + ')';
    }

    public final boolean getCacheMemorizedOptions() {
        return this.cacheMemorizedOptions;
    }

    public final boolean getClearInputContentAfterSend() {
        return this.clearInputContentAfterSend;
    }

    public final boolean getCloseAttachmentPanel() {
        return this.closeAttachmentPanel;
    }

    public final boolean getCloseBottomAlbumBeforeSend() {
        return this.closeBottomAlbumBeforeSend;
    }

    public final boolean getCloseCreationPager() {
        return this.closeCreationPager;
    }

    public final boolean getCloseGalleryDialog() {
        return this.closeGalleryDialog;
    }

    public final String getCvsId() {
        return this.cvsId;
    }

    public final boolean getEndModify() {
        return this.endModify;
    }

    public final boolean getHasAttachment() {
        return this.hasAttachment;
    }

    public final boolean getMarkChatListBottomReached() {
        return this.markChatListBottomReached;
    }

    public final boolean getNotifyCoreInputEvent() {
        return this.notifyCoreInputEvent;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final boolean getScrollToLatest() {
        return this.scrollToLatest;
    }

    public final boolean getSetLastReadRestore() {
        return this.setLastReadRestore;
    }

    public final boolean getSwitchToChatTab() {
        return this.switchToChatTab;
    }

    public CreationSendUiEvent(String r1, String r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        this.cvsId = r1;
        this.requestId = r2;
        this.closeCreationPager = r3;
        this.closeGalleryDialog = r4;
        this.switchToChatTab = r5;
        this.closeAttachmentPanel = r6;
        this.scrollToLatest = r7;
        this.setLastReadRestore = r8;
        this.endModify = r9;
        this.markChatListBottomReached = r10;
        this.notifyCoreInputEvent = r11;
        this.cacheMemorizedOptions = r12;
        this.closeBottomAlbumBeforeSend = r13;
        this.clearInputContentAfterSend = r14;
        this.hasAttachment = r15;
    }

    public /* synthetic */ CreationSendUiEvent(String r17, String r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, int r32, DefaultConstructorMarker r33) {
        String r2 = null;
        if ((r32 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r32 & 2) != 0) goto L10;
        r2 = r18;
    L10:
        boolean r4 = false;
        if ((r32 & 4) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r32 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r32 & 16) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r32 & 32) == 0) goto L25;
        boolean r7 = false;
    L27:
        if ((r32 & 64) == 0) goto L29;
        boolean r8 = false;
    L31:
        if ((r32 & 128) == 0) goto L33;
        boolean r9 = false;
    L35:
        if ((r32 & 256) == 0) goto L37;
        boolean r10 = false;
    L39:
        if ((r32 & 512) == 0) goto L41;
        boolean r11 = false;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        boolean r12 = false;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        boolean r13 = false;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        boolean r14 = false;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        boolean r15 = false;
    L59:
        if ((r32 & 16384) != 0) goto L62;
        r4 = r31;
    L62:
        this(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r4);
        return;
    L57:
        r15 = r30;
        goto L59
    L53:
        r14 = r29;
        goto L55
    L49:
        r13 = r28;
        goto L51
    L45:
        r12 = r27;
        goto L47
    L41:
        r11 = r26;
        goto L43
    L37:
        r10 = r25;
        goto L39
    L33:
        r9 = r24;
        goto L35
    L29:
        r8 = r23;
        goto L31
    L25:
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r3 = r19;
        goto L15
    L5:
        r1 = r17;
        goto L7
    }
}
