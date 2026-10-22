package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0017\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003Ja\u0010&\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010¨\u0006("}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponents;", "Ljava/io/Serializable;", "rootIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "elements", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponent;", "imageIds", "buttonIds", "richTextIds", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getRootIds", "()Ljava/util/List;", "setRootIds", "(Ljava/util/List;)V", "getElements", "()Ljava/util/Map;", "setElements", "(Ljava/util/Map;)V", "getImageIds", "setImageIds", "getButtonIds", "setButtonIds", "getRichTextIds", "setRichTextIds", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "component1", "component2", "component3", "component4", "component5", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewComponents implements Serializable {
    private List<String> buttonIds;
    private Map<String, UrlPreviewComponent> elements;
    private List<String> imageIds;
    private List<String> richTextIds;
    private List<String> rootIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UrlPreviewComponents copy$default(UrlPreviewComponents r3, List r4, Map r5, List r6, List r7, List r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.rootIds;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.elements;
    L8:
        Map r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.imageIds;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.buttonIds;
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.richTextIds;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<String> component1() {
        return this.rootIds;
    }

    public final Map<String, UrlPreviewComponent> component2() {
        return this.elements;
    }

    public final List<String> component3() {
        return this.imageIds;
    }

    public final List<String> component4() {
        return this.buttonIds;
    }

    public final List<String> component5() {
        return this.richTextIds;
    }

    public final UrlPreviewComponents copy(List<String> r8, Map<String, UrlPreviewComponent> r9, List<String> r10, List<String> r11, List<String> r12) {
        Intrinsics.checkNotNullParameter(r8, "rootIds");
        Intrinsics.checkNotNullParameter(r9, "elements");
        Intrinsics.checkNotNullParameter(r10, "imageIds");
        Intrinsics.checkNotNullParameter(r11, "buttonIds");
        Intrinsics.checkNotNullParameter(r12, "richTextIds");
        return new UrlPreviewComponents(r8, r9, r10, r11, r12);
    }

    public String toString() {
        return "UrlPreviewComponents(rootIds=" + this.rootIds + ", elements=" + this.elements + ", imageIds=" + this.imageIds + ", buttonIds=" + this.buttonIds + ", richTextIds=" + this.richTextIds + ')';
    }

    public int hashCode() {
        return (((((((this.rootIds.hashCode() * 31) + this.elements.hashCode()) * 31) + this.imageIds.hashCode()) * 31) + this.buttonIds.hashCode()) * 31) + this.richTextIds.hashCode();
    }

    public final List<String> getButtonIds() {
        return this.buttonIds;
    }

    public final Map<String, UrlPreviewComponent> getElements() {
        return this.elements;
    }

    public final List<String> getImageIds() {
        return this.imageIds;
    }

    public final List<String> getRichTextIds() {
        return this.richTextIds;
    }

    public final List<String> getRootIds() {
        return this.rootIds;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(UrlPreviewComponents.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.UrlPreviewComponents");
        UrlPreviewComponents r6 = (UrlPreviewComponents) r5;
        if (Intrinsics.areEqual(this.rootIds, r6.rootIds) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.elements, r6.elements) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.imageIds, r6.imageIds) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.buttonIds, r6.buttonIds) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.richTextIds, r6.richTextIds) == true) goto L27;
        return false;
    L27:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setButtonIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.buttonIds = r2;
    }

    public final void setElements(Map<String, UrlPreviewComponent> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.elements = r2;
    }

    public final void setImageIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.imageIds = r2;
    }

    public final void setRichTextIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.richTextIds = r2;
    }

    public final void setRootIds(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rootIds = r2;
    }

    public UrlPreviewComponents(List<String> r2, Map<String, UrlPreviewComponent> r3, List<String> r4, List<String> r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r2, "rootIds");
        Intrinsics.checkNotNullParameter(r3, "elements");
        Intrinsics.checkNotNullParameter(r4, "imageIds");
        Intrinsics.checkNotNullParameter(r5, "buttonIds");
        Intrinsics.checkNotNullParameter(r6, "richTextIds");
        this.rootIds = r2;
        this.elements = r3;
        this.imageIds = r4;
        this.buttonIds = r5;
        this.richTextIds = r6;
    }
}
