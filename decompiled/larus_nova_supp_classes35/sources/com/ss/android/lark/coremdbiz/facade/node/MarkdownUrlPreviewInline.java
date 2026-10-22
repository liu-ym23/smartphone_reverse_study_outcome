package com.ss.android.lark.coremdbiz.facade.node;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006 "}, d2 = {"Lcom/ss/android/lark/coremdbiz/facade/node/MarkdownUrlPreviewInline;", "Ljava/io/Serializable;", "previewId", BuildConfig.FLAVOR, "originUrl", "clickUrl", "title", "iconKey", "iconType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPreviewId", "()Ljava/lang/String;", "getOriginUrl", "getClickUrl", "getTitle", "getIconKey", "getIconType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownUrlPreviewInline implements Serializable {
    private final String clickUrl;
    private final String iconKey;
    private final String iconType;
    private final String originUrl;
    private final String previewId;
    private final String title;

    public static /* synthetic */ MarkdownUrlPreviewInline copy$default(MarkdownUrlPreviewInline r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.previewId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.originUrl;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.clickUrl;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.title;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.iconKey;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.iconType;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.previewId;
    }

    public final String component2() {
        return this.originUrl;
    }

    public final String component3() {
        return this.clickUrl;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.iconKey;
    }

    public final String component6() {
        return this.iconType;
    }

    public final MarkdownUrlPreviewInline copy(String r9, String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "previewId");
        Intrinsics.checkNotNullParameter(r10, "originUrl");
        Intrinsics.checkNotNullParameter(r11, "clickUrl");
        Intrinsics.checkNotNullParameter(r12, "title");
        return new MarkdownUrlPreviewInline(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MarkdownUrlPreviewInline) == true) goto L8;
        return false;
    L8:
        MarkdownUrlPreviewInline r6 = (MarkdownUrlPreviewInline) r5;
        if (Intrinsics.areEqual(this.previewId, r6.previewId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.originUrl, r6.originUrl) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.clickUrl, r6.clickUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.iconKey, r6.iconKey) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconType, r6.iconType) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((this.previewId.hashCode() * 31) + this.originUrl.hashCode()) * 31) + this.clickUrl.hashCode()) * 31) + this.title.hashCode()) * 31;
        String r1 = this.iconKey;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.iconType;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "MarkdownUrlPreviewInline(previewId=" + this.previewId + ", originUrl=" + this.originUrl + ", clickUrl=" + this.clickUrl + ", title=" + this.title + ", iconKey=" + this.iconKey + ", iconType=" + this.iconType + ')';
    }

    public final String getClickUrl() {
        return this.clickUrl;
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final String getIconType() {
        return this.iconType;
    }

    public final String getOriginUrl() {
        return this.originUrl;
    }

    public final String getPreviewId() {
        return this.previewId;
    }

    public final String getTitle() {
        return this.title;
    }

    public MarkdownUrlPreviewInline(String r2, String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r2, "previewId");
        Intrinsics.checkNotNullParameter(r3, "originUrl");
        Intrinsics.checkNotNullParameter(r4, "clickUrl");
        Intrinsics.checkNotNullParameter(r5, "title");
        this.previewId = r2;
        this.originUrl = r3;
        this.clickUrl = r4;
        this.title = r5;
        this.iconKey = r6;
        this.iconType = r7;
    }

    public /* synthetic */ MarkdownUrlPreviewInline(String r10, String r11, String r12, String r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r16 & 32) == 0) goto L9;
        String r8 = null;
    L10:
        this(r10, r11, r12, r13, r7, r8);
        return;
    L9:
        r8 = r15;
        goto L10
    L5:
        r7 = r14;
        goto L7
    }
}
