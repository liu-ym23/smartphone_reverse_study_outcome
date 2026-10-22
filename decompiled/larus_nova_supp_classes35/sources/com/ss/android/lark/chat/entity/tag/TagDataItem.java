package com.ss.android.lark.chat.entity.tag;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0013J:\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/tag/TagDataItem;", "Ljava/io/Serializable;", "text", BuildConfig.FLAVOR, "tagType", "Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;", "relationTagType", "Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;", "priority", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;Ljava/lang/Integer;)V", "getText", "()Ljava/lang/String;", "getTagType", "()Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;", "getRelationTagType", "()Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;", "getPriority", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/tag/TagTypeEnum;Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;Ljava/lang/Integer;)Lcom/ss/android/lark/chat/entity/tag/TagDataItem;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagDataItem implements Serializable {
    private final Integer priority;
    private final TagRelationTypeEnum relationTagType;
    private final TagTypeEnum tagType;
    private final String text;

    public static /* synthetic */ TagDataItem copy$default(TagDataItem r0, String r1, TagTypeEnum r2, TagRelationTypeEnum r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.tagType;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.relationTagType;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.priority;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.text;
    }

    public final TagTypeEnum component2() {
        return this.tagType;
    }

    public final TagRelationTypeEnum component3() {
        return this.relationTagType;
    }

    public final Integer component4() {
        return this.priority;
    }

    public final TagDataItem copy(String r2, TagTypeEnum r3, TagRelationTypeEnum r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "tagType");
        Intrinsics.checkNotNullParameter(r4, "relationTagType");
        return new TagDataItem(r2, r3, r4, r5);
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((((r2 * 31) + this.tagType.hashCode()) * 31) + this.relationTagType.hashCode()) * 31;
        Integer r4 = this.priority;
        if (r4 == null) goto L10;
        r1 = r4.intValue();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "TagDataItem(tagType=" + this.tagType + ", tagSubType = " + this.relationTagType + ", priority=" + this.priority + ')';
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final TagRelationTypeEnum getRelationTagType() {
        return this.relationTagType;
    }

    public final TagTypeEnum getTagType() {
        return this.tagType;
    }

    public final String getText() {
        return this.text;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(TagDataItem.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.tag.TagDataItem");
        TagDataItem r6 = (TagDataItem) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L16;
        return false;
    L16:
        if (this.tagType == r6.tagType) goto L19;
        return false;
    L19:
        if (this.relationTagType == r6.relationTagType) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.priority, r6.priority) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public TagDataItem(String r2, TagTypeEnum r3, TagRelationTypeEnum r4, Integer r5) {
        Intrinsics.checkNotNullParameter(r3, "tagType");
        Intrinsics.checkNotNullParameter(r4, "relationTagType");
        this.text = r2;
        this.tagType = r3;
        this.relationTagType = r4;
        this.priority = r5;
    }

    public /* synthetic */ TagDataItem(String r1, TagTypeEnum r2, TagRelationTypeEnum r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = -1;
    L5:
        this(r1, r2, r3, r4);
    }
}
