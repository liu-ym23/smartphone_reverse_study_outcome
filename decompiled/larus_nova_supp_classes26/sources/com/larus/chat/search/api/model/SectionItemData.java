package com.larus.chat.search.api.model;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.share.panel.ShareType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\tHÂ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\u0011\u00105\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0089\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\t2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001J\u0013\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001J\t\u0010:\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010&8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006;"}, d2 = {"Lcom/larus/chat/search/api/model/SectionItemData;", "", "createTime", "", "sectionId", "", "conversationId", "sectionName", "_viewType", "", "localIndex", "messageId", "isSectionName", "", ShareType.URL, "unreadCount", "urlJumpCallback", "Lkotlin/Function0;", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;ZLjava/lang/String;ILkotlin/jvm/functions/Function0;)V", "getCreateTime", "()J", "getSectionId", "()Ljava/lang/String;", "getConversationId", "getSectionName", "getLocalIndex", "getMessageId", "()Z", "getUrl", "getUnreadCount", "()I", "getUrlJumpCallback", "()Lkotlin/jvm/functions/Function0;", "setUrlJumpCallback", "(Lkotlin/jvm/functions/Function0;)V", "viewType", "Lcom/larus/chat/search/api/model/SectionViewType;", "getViewType", "()Lcom/larus/chat/search/api/model/SectionViewType;", "setViewType", "(Lcom/larus/chat/search/api/model/SectionViewType;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SectionItemData {

    @SerializedName("view_type")
    private final int _viewType;

    @SerializedName(MusicAppletPage.KEY_CONVERSATION_ID)
    private final String conversationId;

    @SerializedName("create_time")
    private final long createTime;

    @SerializedName("is_section_name")
    private final boolean isSectionName;

    @SerializedName("local_index")
    private final long localIndex;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("section_name")
    private final String sectionName;

    @SerializedName("unread_count")
    private final int unreadCount;

    @SerializedName(ShareType.URL)
    private final String url;
    private transient Function0<Unit> urlJumpCallback;
    private SectionViewType viewType;

    public SectionItemData() {
        this(0, null, null, null, 0, 0, null, false, null, 0, null, 2047, null);
    }

    private final int component5() {
        return this._viewType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SectionItemData copy$default(SectionItemData r14, long r15, String r17, String r18, String r19, int r20, long r21, String r23, boolean r24, String r25, int r26, Function0 r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        long r2 = r14.createTime;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r4 = r14.sectionId;
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r5 = r14.conversationId;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r6 = r14.sectionName;
    L19:
        if ((r28 & 16) == 0) goto L21;
        int r7 = r14._viewType;
    L23:
        if ((r28 & 32) == 0) goto L25;
        long r8 = r14.localIndex;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r10 = r14.messageId;
    L31:
        if ((r28 & 128) == 0) goto L33;
        boolean r11 = r14.isSectionName;
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r12 = r14.url;
    L39:
        if ((r28 & 512) == 0) goto L41;
        int r13 = r14.unreadCount;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        Function0 r1 = r14.urlJumpCallback;
    L47:
        return r14.copy(r2, r4, r5, r6, r7, r8, r10, r11, r12, r13, r1);
    L45:
        r1 = r27;
        goto L47
    L41:
        r13 = r26;
        goto L43
    L37:
        r12 = r25;
        goto L39
    L33:
        r11 = r24;
        goto L35
    L29:
        r10 = r23;
        goto L31
    L25:
        r8 = r21;
        goto L27
    L21:
        r7 = r20;
        goto L23
    L17:
        r6 = r19;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final long component1() {
        return this.createTime;
    }

    public final int component10() {
        return this.unreadCount;
    }

    public final Function0<Unit> component11() {
        return this.urlJumpCallback;
    }

    public final String component2() {
        return this.sectionId;
    }

    public final String component3() {
        return this.conversationId;
    }

    public final String component4() {
        return this.sectionName;
    }

    public final long component6() {
        return this.localIndex;
    }

    public final String component7() {
        return this.messageId;
    }

    public final boolean component8() {
        return this.isSectionName;
    }

    public final String component9() {
        return this.url;
    }

    public final SectionItemData copy(long r16, String r18, String r19, String r20, int r21, long r22, String r24, boolean r25, String r26, int r27, Function0<Unit> r28) {
        return new SectionItemData(r16, r18, r19, r20, r21, r22, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SectionItemData) == true) goto L8;
        return false;
    L8:
        SectionItemData r9 = (SectionItemData) r8;
        if (this.createTime == r9.createTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sectionId, r9.sectionId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationId, r9.conversationId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sectionName, r9.sectionName) == true) goto L21;
        return false;
    L21:
        if (this._viewType == r9._viewType) goto L24;
        return false;
    L24:
        if (this.localIndex == r9.localIndex) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.messageId, r9.messageId) == true) goto L30;
        return false;
    L30:
        if (this.isSectionName == r9.isSectionName) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.url, r9.url) == true) goto L36;
        return false;
    L36:
        if (this.unreadCount == r9.unreadCount) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.urlJumpCallback, r9.urlJumpCallback) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        long r0 = this.createTime;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        String r2 = this.sectionId;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        String r6 = this.conversationId;
        if (r6 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r5 + r7) * 31;
        String r9 = this.sectionName;
        if (r9 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (((r8 + r10) * 31) + this._viewType) * 31;
        long r12 = this.localIndex;
        int r13 = (r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31;
        String r14 = this.messageId;
        if (r14 != null) goto L17;
        int r15 = 0;
    L18:
        int r16 = (r13 + r15) * 31;
        if (this.isSectionName == false) goto L21;
        int r17 = 1231;
    L22:
        int r18 = (r16 + r17) * 31;
        String r19 = this.url;
        if (r19 != null) goto L25;
        int r20 = 0;
    L26:
        int r21 = (((r18 + r20) * 31) + this.unreadCount) * 31;
        Function0<Unit> r22 = this.urlJumpCallback;
        if (r22 == null) goto L31;
        r3 = r22.hashCode();
    L31:
        return r21 + r3;
    L25:
        r20 = r19.hashCode();
        goto L26
    L21:
        r17 = 1237;
        goto L22
    L17:
        r15 = r14.hashCode();
        goto L18
    L13:
        r10 = r9.hashCode();
        goto L14
    L9:
        r7 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public String toString() {
        return "SectionItemData(createTime=" + this.createTime + ", sectionId=" + this.sectionId + ", conversationId=" + this.conversationId + ", sectionName=" + this.sectionName + ", _viewType=" + this._viewType + ", localIndex=" + this.localIndex + ", messageId=" + this.messageId + ", isSectionName=" + this.isSectionName + ", url=" + this.url + ", unreadCount=" + this.unreadCount + ", urlJumpCallback=" + this.urlJumpCallback + ')';
    }

    public final SectionViewType getViewType() {
        SectionViewType.a r0 = SectionViewType.Companion;
        int r1 = this._viewType;
        r0.getClass();
        return SectionViewType.a.a(r1);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getLocalIndex() {
        return this.localIndex;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getSectionId() {
        return this.sectionId;
    }

    public final String getSectionName() {
        return this.sectionName;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Function0<Unit> getUrlJumpCallback() {
        return this.urlJumpCallback;
    }

    public final boolean isSectionName() {
        return this.isSectionName;
    }

    public final void setUrlJumpCallback(Function0<Unit> r1) {
        this.urlJumpCallback = r1;
    }

    public final void setViewType(SectionViewType r1) {
        this.viewType = r1;
    }

    public SectionItemData(long r1, String r3, String r4, String r5, int r6, long r7, String r9, boolean r10, String r11, int r12, Function0<Unit> r13) {
        this.createTime = r1;
        this.sectionId = r3;
        this.conversationId = r4;
        this.sectionName = r5;
        this._viewType = r6;
        this.localIndex = r7;
        this.messageId = r9;
        this.isSectionName = r10;
        this.url = r11;
        this.unreadCount = r12;
        this.urlJumpCallback = r13;
        this.viewType = SectionViewType.EMPTY;
    }

    public /* synthetic */ SectionItemData(long r15, String r17, String r18, String r19, int r20, long r21, String r23, boolean r24, String r25, int r26, Function0 r27, int r28, DefaultConstructorMarker r29) {
        long r2 = -1;
        if ((r28 & 1) == 0) goto L5;
        long r4 = -1;
    L6:
        String r6 = "";
        if ((r28 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r28 & 16) == 0) goto L21;
        int r9 = -1;
    L23:
        if ((r28 & 32) != 0) goto L27;
        r2 = r21;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r10 = "";
    L30:
        int r12 = 0;
        if ((r28 & 128) == 0) goto L33;
        boolean r11 = false;
    L35:
        if ((r28 & 256) != 0) goto L39;
        r6 = r25;
    L39:
        if ((r28 & 512) != 0) goto L43;
        r12 = r26;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        Function0 r0 = null;
    L46:
        this(r4, r1, r7, r8, r9, r2, r10, r11, r6, r12, r0);
        return;
    L45:
        r0 = r27;
        goto L46
    L33:
        r11 = r24;
        goto L35
    L29:
        r10 = r23;
        goto L30
    L21:
        r9 = r20;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r7 = r18;
        goto L15
    L9:
        r1 = r17;
        goto L11
    L5:
        r4 = r15;
        goto L6
    }
}
