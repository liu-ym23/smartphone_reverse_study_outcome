package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.URLPreviewComponent;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/RichTextProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "richText", "Lcom/ss/android/lark/widget/richtext/RichText;", "numberOfLines", BuildConfig.FLAVOR, "theme", "Lcom/bytedance/lark/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;", "<init>", "(Lcom/ss/android/lark/widget/richtext/RichText;ILcom/bytedance/lark/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;)V", "getRichText", "()Lcom/ss/android/lark/widget/richtext/RichText;", "setRichText", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "getNumberOfLines", "()I", "getTheme", "()Lcom/bytedance/lark/pb/basic/v1/URLPreviewComponent$RichTextProperty$RichTextTheme;", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichTextProperty extends BaseProperty {
    public static final a Companion = null;
    public static final int UNLIMITED_NUMBER_OF_LINES = 0;
    private final int numberOfLines;
    private RichText richText;
    private final URLPreviewComponent.RichTextProperty.RichTextTheme theme;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        RichText r1 = this.richText;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((r0 + r3) * 31) + this.numberOfLines) * 31;
        URLPreviewComponent.RichTextProperty.RichTextTheme r5 = this.theme;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    public final RichText getRichText() {
        return this.richText;
    }

    public final URLPreviewComponent.RichTextProperty.RichTextTheme getTheme() {
        return this.theme;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RichTextProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r5) == true) goto L11;
        return false;
    L11:
        RichTextProperty r6 = (RichTextProperty) r5;
        if (Intrinsics.areEqual(this.richText, r6.richText) == true) goto L14;
    L18:
        return false;
    L14:
        if (this.numberOfLines != r6.numberOfLines) goto L18;
        if (this.theme != r6.theme) goto L18;
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.richText = r1.getRichText();
    }

    public final void setRichText(RichText r1) {
        this.richText = r1;
    }

    public RichTextProperty(RichText r2, int r3, URLPreviewComponent.RichTextProperty.RichTextTheme r4) {
        super(Type.RICHTEXT);
        this.richText = r2;
        this.numberOfLines = r3;
        this.theme = r4;
    }

    public /* synthetic */ RichTextProperty(RichText r1, int r2, URLPreviewComponent.RichTextProperty.RichTextTheme r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
    L8:
        this(r1, r2, r3);
    }
}
