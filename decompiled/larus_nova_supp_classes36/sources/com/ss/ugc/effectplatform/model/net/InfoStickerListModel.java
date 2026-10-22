package com.ss.ugc.effectplatform.model.net;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003JP\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015¨\u0006,"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/InfoStickerListModel;", "", "subtitle", "", "cursor", "", "has_more", "", "sticker_list", "", "Lcom/ss/ugc/effectplatform/model/net/InfoStickerEffect;", "extra", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)V", "getCursor", "()Ljava/lang/Integer;", "setCursor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "getHas_more", "()Ljava/lang/Boolean;", "setHas_more", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSticker_list", "()Ljava/util/List;", "setSticker_list", "(Ljava/util/List;)V", "getSubtitle", "setSubtitle", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)Lcom/ss/ugc/effectplatform/model/net/InfoStickerListModel;", "equals", INotificationHitPoint.NoticeType.OTHER, "hashCode", "toString", "effectplatform_release"}, k = 1, mv = {1, 1, 16})
public final class InfoStickerListModel {
    private Integer cursor;
    private String extra;
    private Boolean has_more;
    private List<InfoStickerEffect> sticker_list;
    private String subtitle;

    public InfoStickerListModel() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InfoStickerListModel copy$default(InfoStickerListModel r3, String r4, Integer r5, Boolean r6, List r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.subtitle;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.cursor;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.has_more;
    L11:
        Boolean r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.sticker_list;
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.extra;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.subtitle;
    }

    public final Integer component2() {
        return this.cursor;
    }

    public final Boolean component3() {
        return this.has_more;
    }

    public final List<InfoStickerEffect> component4() {
        return this.sticker_list;
    }

    public final String component5() {
        return this.extra;
    }

    public final InfoStickerListModel copy(String r8, Integer r9, Boolean r10, List<InfoStickerEffect> r11, String r12) {
        return new InfoStickerListModel(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof InfoStickerListModel) == false) goto L16;
        InfoStickerListModel r4 = (InfoStickerListModel) r3;
        if (Intrinsics.areEqual(this.subtitle, r4.subtitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.cursor, r4.cursor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.has_more, r4.has_more) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sticker_list, r4.sticker_list) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.subtitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.cursor;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.has_more;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<InfoStickerEffect> r10 = this.sticker_list;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.extra;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "InfoStickerListModel(subtitle=" + this.subtitle + ", cursor=" + this.cursor + ", has_more=" + this.has_more + ", sticker_list=" + this.sticker_list + ", extra=" + this.extra + ")";
    }

    public final Integer getCursor() {
        return this.cursor;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final Boolean getHas_more() {
        return this.has_more;
    }

    public final List<InfoStickerEffect> getSticker_list() {
        return this.sticker_list;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final void setCursor(Integer r1) {
        this.cursor = r1;
    }

    public final void setExtra(String r1) {
        this.extra = r1;
    }

    public final void setHas_more(Boolean r1) {
        this.has_more = r1;
    }

    public final void setSticker_list(List<InfoStickerEffect> r1) {
        this.sticker_list = r1;
    }

    public final void setSubtitle(String r1) {
        this.subtitle = r1;
    }

    public InfoStickerListModel(String r1, Integer r2, Boolean r3, List<InfoStickerEffect> r4, String r5) {
        this.subtitle = r1;
        this.cursor = r2;
        this.has_more = r3;
        this.sticker_list = r4;
        this.extra = r5;
    }

    public /* synthetic */ InfoStickerListModel(String r5, Integer r6, Boolean r7, List r8, String r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        Integer r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        Boolean r2 = null;
    L15:
        if ((r10 & 8) == 0) goto L17;
        List r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        String r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
