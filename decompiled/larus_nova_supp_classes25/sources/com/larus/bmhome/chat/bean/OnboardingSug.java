package com.larus.bmhome.chat.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.video.Content;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/bean/OnboardingSug;", "", "itemId", "", "itemType", "", "actionType", "displayType", "richMediaDisplayContent", "Lcom/larus/bmhome/video/Content;", "<init>", "(JIIILcom/larus/bmhome/video/Content;)V", "getItemId", "()J", "setItemId", "(J)V", "getItemType", "()I", "setItemType", "(I)V", "getActionType", "setActionType", "getDisplayType", "setDisplayType", "getRichMediaDisplayContent", "()Lcom/larus/bmhome/video/Content;", "setRichMediaDisplayContent", "(Lcom/larus/bmhome/video/Content;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class OnboardingSug {

    @SerializedName("action_type")
    private int actionType;

    @SerializedName("display_type")
    private int displayType;

    @SerializedName("item_id")
    private long itemId;

    @SerializedName("item_type")
    private int itemType;

    @SerializedName("rich_media_display_content")
    private Content richMediaDisplayContent;

    public OnboardingSug() {
        this(0, 0, 0, 0, null, 31, null);
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final int getDisplayType() {
        return this.displayType;
    }

    public final long getItemId() {
        return this.itemId;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final Content getRichMediaDisplayContent() {
        return this.richMediaDisplayContent;
    }

    public final void setActionType(int r1) {
        this.actionType = r1;
    }

    public final void setDisplayType(int r1) {
        this.displayType = r1;
    }

    public final void setItemId(long r1) {
        this.itemId = r1;
    }

    public final void setItemType(int r1) {
        this.itemType = r1;
    }

    public final void setRichMediaDisplayContent(Content r1) {
        this.richMediaDisplayContent = r1;
    }

    public OnboardingSug(long r1, int r3, int r4, int r5, Content r6) {
        this.itemId = r1;
        this.itemType = r3;
        this.actionType = r4;
        this.displayType = r5;
        this.richMediaDisplayContent = r6;
    }

    public /* synthetic */ OnboardingSug(long r8, int r10, int r11, int r12, Content r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = 0;
    L5:
        long r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        int r3 = 0;
    L10:
        if ((r14 & 4) == 0) goto L12;
        int r4 = 0;
    L14:
        if ((r14 & 8) == 0) goto L16;
        int r5 = 0;
    L18:
        if ((r14 & 16) == 0) goto L20;
        r13 = null;
    L20:
        this(r1, r3, r4, r5, r13);
        return;
    L16:
        r5 = r12;
        goto L18
    L12:
        r4 = r11;
        goto L14
    L8:
        r3 = r10;
        goto L10
    }
}
