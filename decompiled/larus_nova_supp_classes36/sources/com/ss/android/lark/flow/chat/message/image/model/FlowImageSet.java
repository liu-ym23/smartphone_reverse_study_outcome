package com.ss.android.lark.flow.chat.message.image.model;

import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kza.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/flow/chat/message/image/model/FlowImageSet;", "Lcom/ss/android/lark/chat/entity/image/ImageSet;", "mediaMessageType", "Lcom/ss/android/lark/flow/chat/message/image/model/FlowMediaMessageType;", "previewItem", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPreviewItem;", "<init>", "(Lcom/ss/android/lark/flow/chat/message/image/model/FlowMediaMessageType;Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPreviewItem;)V", "getMediaMessageType", "()Lcom/ss/android/lark/flow/chat/message/image/model/FlowMediaMessageType;", "getPreviewItem", "()Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryPreviewItem;", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowImageSet extends ImageSet {
    public static final int $stable = 8;
    private final FlowMediaMessageType mediaMessageType;
    private final m previewItem;

    public FlowImageSet() {
        FlowMediaMessageType r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ FlowImageSet copy$default(FlowImageSet r0, FlowMediaMessageType r1, m r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.mediaMessageType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.previewItem;
    L9:
        return r0.copy(r1, r2);
    }

    public final FlowMediaMessageType component1() {
        return this.mediaMessageType;
    }

    public final m component2() {
        return this.previewItem;
    }

    public final FlowImageSet copy(FlowMediaMessageType r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "mediaMessageType");
        return new FlowImageSet(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowImageSet) == true) goto L8;
        return false;
    L8:
        FlowImageSet r6 = (FlowImageSet) r5;
        if (this.mediaMessageType == r6.mediaMessageType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.previewItem, r6.previewItem) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.mediaMessageType.hashCode() * 31;
        m r1 = this.previewItem;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "FlowImageSet(mediaMessageType=" + this.mediaMessageType + ", previewItem=" + this.previewItem + ')';
    }

    public final FlowMediaMessageType getMediaMessageType() {
        return this.mediaMessageType;
    }

    public final m getPreviewItem() {
        return this.previewItem;
    }

    public FlowImageSet(FlowMediaMessageType r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "mediaMessageType");
        this.mediaMessageType = r2;
        this.previewItem = r3;
    }

    public /* synthetic */ FlowImageSet(FlowMediaMessageType r1, m r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = FlowMediaMessageType.Doubao;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }
}
