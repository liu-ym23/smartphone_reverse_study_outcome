package com.ss.android.lark.chat.preview.entity.component.property;

import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.ss.android.lark.tangram.base.props.Props;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0001'B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J-\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", BuildConfig.FLAVOR, "background", "Lcom/ss/android/lark/export/entity/preview/ImageSet;", "actionId", BuildConfig.FLAVOR, "contentMode", "Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;Ljava/lang/String;Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;)V", "getBackground", "()Lcom/ss/android/lark/export/entity/preview/ImageSet;", "setBackground", "(Lcom/ss/android/lark/export/entity/preview/ImageSet;)V", "getActionId", "()Ljava/lang/String;", "setActionId", "(Ljava/lang/String;)V", "getContentMode", "()Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;", "setContentMode", "(Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "clone", "component1", "component2", "component3", "copy", "toString", "ContentMode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageContainerProperty extends BaseProperty implements Cloneable {
    private String actionId;
    private ImageSet background;
    private ContentMode contentMode;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/ImageContainerProperty$ContentMode;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SCALE_TO_FILL", "SCALE_ASPECT_FIT", "SCALE_ASPECT_FILL", "CENTER", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ContentMode extends Enum<ContentMode> {
        public static final ContentMode CENTER = null;
        public static final ContentMode SCALE_ASPECT_FILL = null;
        public static final ContentMode SCALE_ASPECT_FIT = null;
        public static final ContentMode SCALE_TO_FILL = null;
        public static final /* synthetic */ ContentMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<ContentMode> getEntries() {
            return b;
        }

        static {
            ContentMode r0 = new ContentMode("SCALE_TO_FILL", 0, 0);
            SCALE_TO_FILL = r0;
            ContentMode r1 = new ContentMode("SCALE_ASPECT_FIT", 1, 1);
            SCALE_ASPECT_FIT = r1;
            ContentMode r3 = new ContentMode("SCALE_ASPECT_FILL", 2, 2);
            SCALE_ASPECT_FILL = r3;
            ContentMode r5 = new ContentMode("CENTER", 3, 3);
            CENTER = r5;
            ContentMode[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static ContentMode[] values() {
            return (ContentMode[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ContentMode valueOf(String r1) {
            return (ContentMode) a.a(ContentMode.class, r1);
        }

        public ContentMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static /* synthetic */ ImageContainerProperty copy$default(ImageContainerProperty r0, ImageSet r1, String r2, ContentMode r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.background;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.actionId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.contentMode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final ImageSet component1() {
        return this.background;
    }

    public final String component2() {
        return this.actionId;
    }

    public final ContentMode component3() {
        return this.contentMode;
    }

    public final ImageContainerProperty copy(ImageSet r2, String r3, ContentMode r4) {
        return new ImageContainerProperty(r2, r3, r4);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r1) {
    }

    public String toString() {
        return "ImageContainerProperty(background=" + this.background + ", actionId=" + this.actionId + ", contentMode=" + this.contentMode + ')';
    }

    public ImageContainerProperty clone() {
        return new ImageContainerProperty(this.background, this.actionId, this.contentMode);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        ImageSet r1 = this.background;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.actionId;
        if (r5 == null) goto L9;
        int r6 = r5.hashCode();
    L10:
        int r7 = (r4 + r6) * 31;
        ContentMode r8 = this.contentMode;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        return r7 + r2;
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final ImageSet getBackground() {
        return this.background;
    }

    public final ContentMode getContentMode() {
        return this.contentMode;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Props m661clone() {
        return clone();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m662clone() {
        return clone();
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r3) {
        if (super.equals(r3) == true) goto L5;
    L13:
        return false;
    L5:
        if ((r3 instanceof ImageContainerProperty) == false) goto L13;
        ImageContainerProperty r4 = (ImageContainerProperty) r3;
        if (Intrinsics.areEqual(this.background, r4.background) == false) goto L13;
        if (Intrinsics.areEqual(this.actionId, r4.actionId) == false) goto L13;
        if (this.contentMode != r4.contentMode) goto L13;
        return true;
    }

    public final void setActionId(String r1) {
        this.actionId = r1;
    }

    public final void setBackground(ImageSet r1) {
        this.background = r1;
    }

    public final void setContentMode(ContentMode r1) {
        this.contentMode = r1;
    }

    public ImageContainerProperty(ImageSet r2, String r3, ContentMode r4) {
        super(Type.IMAGE_CONTAINER);
        this.background = r2;
        this.actionId = r3;
        this.contentMode = r4;
    }
}
