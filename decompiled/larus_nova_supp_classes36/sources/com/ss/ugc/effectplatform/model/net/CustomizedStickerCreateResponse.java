package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.ss.ugc.effectplatform.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\b\u0010\u0002\u001a\u00020\u0000H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J2\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003R$\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u001aR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/CustomizedStickerCreateResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "component1", "()Ljava/lang/Long;", "component2", "component3", "sticker_id", "status_msg", "status_code", "copy", "(Ljava/lang/Long;Ljava/lang/String;I)Lcom/ss/ugc/effectplatform/model/net/CustomizedStickerCreateResponse;", "toString", "hashCode", "", INotificationHitPoint.NoticeType.OTHER, "", "equals", "Ljava/lang/Long;", "getSticker_id", "setSticker_id", "(Ljava/lang/Long;)V", "Ljava/lang/String;", "getStatus_msg", "()Ljava/lang/String;", "setStatus_msg", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Ljava/lang/Long;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class CustomizedStickerCreateResponse extends e<CustomizedStickerCreateResponse> {
    private int status_code;
    private String status_msg;
    private Long sticker_id;

    public CustomizedStickerCreateResponse() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ CustomizedStickerCreateResponse copy$default(CustomizedStickerCreateResponse r0, Long r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.sticker_id;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.status_msg;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.status_code;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Long component1() {
        return this.sticker_id;
    }

    public final String component2() {
        return this.status_msg;
    }

    public final int component3() {
        return this.status_code;
    }

    public final CustomizedStickerCreateResponse copy(Long r2, String r3, int r4) {
        return new CustomizedStickerCreateResponse(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CustomizedStickerCreateResponse) == false) goto L12;
        CustomizedStickerCreateResponse r4 = (CustomizedStickerCreateResponse) r3;
        if (Intrinsics.areEqual(this.sticker_id, r4.sticker_id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.status_msg, r4.status_msg) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r4.status_code) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public CustomizedStickerCreateResponse getResponseData() {
        return this;
    }

    public int hashCode() {
        Long r0 = this.sticker_id;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.status_msg;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + this.status_code;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CustomizedStickerCreateResponse(sticker_id=" + this.sticker_id + ", status_msg=" + this.status_msg + ", status_code=" + this.status_code + ")";
    }

    /* JADX INFO: renamed from: getResponseData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1532getResponseData() {
        return getResponseData();
    }

    public String getResponseMessage() {
        return this.status_msg;
    }

    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public final String getStatus_msg() {
        return this.status_msg;
    }

    public final Long getSticker_id() {
        return this.sticker_id;
    }

    public final void setStatus_code(int r1) {
        this.status_code = r1;
    }

    public final void setStatus_msg(String r1) {
        this.status_msg = r1;
    }

    public final void setSticker_id(Long r1) {
        this.sticker_id = r1;
    }

    public CustomizedStickerCreateResponse(Long r1, String r2, int r3) {
        this.sticker_id = r1;
        this.status_msg = r2;
        this.status_code = r3;
    }

    public /* synthetic */ CustomizedStickerCreateResponse(Long r2, String r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0;
    L11:
        this(r2, r3, r4);
    }
}
