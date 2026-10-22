package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.KeyTag;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.StringList;
import com.ss.android.lark.export.entity.preview.TagList;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\bH\u0016R$\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TagListProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "tagString", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "mixedTags", "Lcom/ss/android/lark/export/entity/preview/KeyTag;", "numberOfLines", BuildConfig.FLAVOR, "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "getTagString", "()Ljava/util/List;", "setTagString", "(Ljava/util/List;)V", "getMixedTags", "setMixedTags", "getNumberOfLines", "()I", "setNumberOfLines", "(I)V", "patchData", BuildConfig.FLAVOR, "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagListProperty extends BaseProperty {
    private List<KeyTag> mixedTags;
    private int numberOfLines;
    private List<String> tagString;

    public TagListProperty() {
        this(null, null, 0, 7, null);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public int hashCode() {
        int r0 = super.hashCode() * 31;
        List<String> r1 = this.tagString;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final List<KeyTag> getMixedTags() {
        return this.mixedTags;
    }

    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    public final List<String> getTagString() {
        return this.tagString;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof TagListProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r4) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tagString, ((TagListProperty) r4).tagString) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r6 = r5.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L32;
        Map.Entry<Integer, PreviewData> r0 = r6.next();
        int r1 = r0.getKey().intValue();
        List<String> r3 = null;
        List<KeyTag> r4 = null;
        r4 = null;
        r3 = null;
        if (r1 == ComponentAttribute.tags.getValue()) goto L9;
        if (r1 == ComponentAttribute.mixed_tags.getValue()) goto L17;
        if (r1 != ComponentAttribute.number_of_lines.getValue()) goto L6;
        PreviewData r2 = r0.getValue();
        if (r2 == null) goto L30;
        Integer r7 = r2.getInt();
        if (r7 == null) goto L30;
        int r8 = r7.intValue();
    L31:
        this.numberOfLines = r8;
    L30:
        r8 = 1;
        goto L31
    L17:
        PreviewData r9 = r0.getValue();
        if (r9 == null) goto L22;
        TagList r10 = r9.getTagList();
        if (r10 == null) goto L22;
        r4 = r10.getMixedTags();
    L22:
        this.mixedTags = r4;
        goto L6
    L9:
        PreviewData r11 = r0.getValue();
        if (r11 == null) goto L14;
        StringList r12 = r11.getStringList();
        if (r12 == null) goto L14;
        r3 = r12.getStringList();
    L14:
        this.tagString = r3;
        goto L6
    }

    public final void setMixedTags(List<KeyTag> r1) {
        this.mixedTags = r1;
    }

    public final void setNumberOfLines(int r1) {
        this.numberOfLines = r1;
    }

    public final void setTagString(List<String> r1) {
        this.tagString = r1;
    }

    public TagListProperty(List<String> r2, List<KeyTag> r3, int r4) {
        super(Type.TAG_LIST);
        this.tagString = r2;
        this.mixedTags = r3;
        this.numberOfLines = r4;
    }

    public /* synthetic */ TagListProperty(List r2, List r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 1;
    L11:
        this(r2, r3, r4);
    }
}
