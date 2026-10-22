package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u0000J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006 "}, d2 = {"Lcom/ss/android/lark/export/entity/preview/UrlPreviewTemplate;", "Ljava/io/Serializable;", "rootComponentId", BuildConfig.FLAVOR, "elements", BuildConfig.FLAVOR, "Lcom/ss/android/lark/export/entity/preview/UrlPreviewComponent;", "imageIds", BuildConfig.FLAVOR, "atIds", "buttonIds", "richTextIds", "templateId", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getRootComponentId", "()Ljava/lang/String;", "getElements", "()Ljava/util/Map;", "getImageIds", "()Ljava/util/List;", "getAtIds", "getButtonIds", "getRichTextIds", "getTemplateId", "clone", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlPreviewTemplate implements Serializable {
    private final List<String> atIds;
    private final List<String> buttonIds;
    private final Map<String, UrlPreviewComponent> elements;
    private final List<String> imageIds;
    private final List<String> richTextIds;
    private final String rootComponentId;
    private final String templateId;

    public final UrlPreviewTemplate clone() {
        return new UrlPreviewTemplate(this.rootComponentId, this.elements, this.imageIds, this.atIds, this.buttonIds, this.richTextIds, this.templateId);
    }

    public int hashCode() {
        String r0 = this.rootComponentId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Map<String, UrlPreviewComponent> r4 = this.elements;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.imageIds;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<String> r10 = this.atIds;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.buttonIds;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.richTextIds;
        if (r16 == null) goto L26;
        r1 = r16.hashCode();
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
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

    public final List<String> getAtIds() {
        return this.atIds;
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

    public final String getRootComponentId() {
        return this.rootComponentId;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlPreviewTemplate) == true) goto L8;
        return false;
    L8:
        UrlPreviewTemplate r6 = (UrlPreviewTemplate) r5;
        if (Intrinsics.areEqual(this.rootComponentId, r6.rootComponentId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.elements, r6.elements) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageIds, r6.imageIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.atIds, r6.atIds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.buttonIds, r6.buttonIds) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.richTextIds, r6.richTextIds) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public UrlPreviewTemplate(String r1, Map<String, UrlPreviewComponent> r2, List<String> r3, List<String> r4, List<String> r5, List<String> r6, String r7) {
        this.rootComponentId = r1;
        this.elements = r2;
        this.imageIds = r3;
        this.atIds = r4;
        this.buttonIds = r5;
        this.richTextIds = r6;
        this.templateId = r7;
    }
}
