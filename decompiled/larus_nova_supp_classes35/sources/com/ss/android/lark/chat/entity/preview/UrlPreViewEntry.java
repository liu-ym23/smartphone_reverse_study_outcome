package com.ss.android.lark.chat.entity.preview;

import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.a;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J3\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/preview/UrlPreViewEntry;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "offset", BuildConfig.FLAVOR, "length", "previewId", BuildConfig.FLAVOR, "previewEntity", "Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "<init>", "(IILjava/lang/String;Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;)V", "getOffset", "()I", "getLength", "getPreviewId", "()Ljava/lang/String;", "getPreviewEntity", "()Lcom/ss/android/lark/export/entity/preview/UrlInlinePreviewEntity;", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "equals", "other", BuildConfig.FLAVOR, "hashCode", "component1", "component2", "component3", "component4", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreViewEntry implements Serializable, b<UrlPreViewEntry> {
    private final int length;
    private final int offset;
    private final UrlInlinePreviewEntity previewEntity;
    private final String previewId;

    public static /* synthetic */ UrlPreViewEntry copy$default(UrlPreViewEntry r0, int r1, int r2, String r3, UrlInlinePreviewEntity r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.offset;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.length;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.previewId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.previewEntity;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.offset;
    }

    public final int component2() {
        return this.length;
    }

    public final String component3() {
        return this.previewId;
    }

    public final UrlInlinePreviewEntity component4() {
        return this.previewEntity;
    }

    public final UrlPreViewEntry copy(int r2, int r3, String r4, UrlInlinePreviewEntity r5) {
        Intrinsics.checkNotNullParameter(r4, "previewId");
        return new UrlPreViewEntry(r2, r3, r4, r5);
    }

    public String toString() {
        return "UrlPreViewEntry(offset=" + this.offset + ", length=" + this.length + ", previewId=" + this.previewId + ", previewEntity=" + this.previewEntity + ')';
    }

    public int hashCode() {
        int r0 = ((((this.offset * 31) + this.length) * 31) + this.previewId.hashCode()) * 31;
        UrlInlinePreviewEntity r1 = this.previewEntity;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final int getLength() {
        return this.length;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final UrlInlinePreviewEntity getPreviewEntity() {
        return this.previewEntity;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlPreViewEntry) == true) goto L8;
        return false;
    L8:
        UrlPreViewEntry r6 = (UrlPreViewEntry) r5;
        if (this.offset == r6.offset) goto L12;
        return false;
    L12:
        if (this.length == r6.length) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.previewId, r6.previewId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previewEntity, r6.previewEntity) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public boolean isContentSame(UrlPreViewEntry r3) {
        String r0 = this.previewId;
        if (r3 == null) goto L5;
        String r1 = r3.previewId;
    L7:
        if (Intrinsics.areEqual(r0, r1) == true) goto L10;
        return false;
    L10:
        if (a.c(this.previewEntity, r3.previewEntity) == true) goto L12;
        return false;
    L12:
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public boolean isItemSame(UrlPreViewEntry r2) {
        String r0 = this.previewId;
        if (r2 == null) goto L5;
        String r3 = r2.previewId;
    L7:
        if (Intrinsics.areEqual(r0, r3) == false) goto L10;
        return true;
    L10:
        return false;
    L5:
        r3 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((UrlPreViewEntry) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((UrlPreViewEntry) r1);
    }

    public UrlPreViewEntry(int r2, int r3, String r4, UrlInlinePreviewEntity r5) {
        Intrinsics.checkNotNullParameter(r4, "previewId");
        this.offset = r2;
        this.length = r3;
        this.previewId = r4;
        this.previewEntity = r5;
    }
}
