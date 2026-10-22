package com.ss.android.lark.chat.entity.tag;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chat/entity/tag/TagRelationTypeEnum;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "RELATION_TAG_UNSET", "RELATION_TAG_EXTERNAL", "RELATION_TAG_PARTNER", "RELATION_TAG_TENANT_NAME", "toString", BuildConfig.FLAVOR, "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TagRelationTypeEnum extends Enum<TagRelationTypeEnum> implements Serializable {
    public static final a Companion = null;
    public static final TagRelationTypeEnum RELATION_TAG_EXTERNAL = null;
    public static final TagRelationTypeEnum RELATION_TAG_PARTNER = null;
    public static final TagRelationTypeEnum RELATION_TAG_TENANT_NAME = null;
    public static final TagRelationTypeEnum RELATION_TAG_UNSET = null;
    public static final /* synthetic */ TagRelationTypeEnum[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TagRelationTypeEnum a(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L18;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L16;
            return TagRelationTypeEnum.RELATION_TAG_UNSET;
        L16:
            return TagRelationTypeEnum.RELATION_TAG_TENANT_NAME;
        L17:
            return TagRelationTypeEnum.RELATION_TAG_PARTNER;
        L18:
            return TagRelationTypeEnum.RELATION_TAG_EXTERNAL;
        L14:
            return TagRelationTypeEnum.RELATION_TAG_UNSET;
        }
    }

    @JvmStatic
    public static final TagRelationTypeEnum forName(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static EnumEntries<TagRelationTypeEnum> getEntries() {
        return b;
    }

    static {
        TagRelationTypeEnum r0 = new TagRelationTypeEnum("RELATION_TAG_UNSET", 0, 0);
        RELATION_TAG_UNSET = r0;
        TagRelationTypeEnum r1 = new TagRelationTypeEnum("RELATION_TAG_EXTERNAL", 1, 1);
        RELATION_TAG_EXTERNAL = r1;
        TagRelationTypeEnum r3 = new TagRelationTypeEnum("RELATION_TAG_PARTNER", 2, 2);
        RELATION_TAG_PARTNER = r3;
        TagRelationTypeEnum r5 = new TagRelationTypeEnum("RELATION_TAG_TENANT_NAME", 3, 3);
        RELATION_TAG_TENANT_NAME = r5;
        TagRelationTypeEnum[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
        Companion = new a();
    }

    public static TagRelationTypeEnum[] values() {
        return (TagRelationTypeEnum[]) a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder r0 = new StringBuilder("TagSubTypeEnum(");
        Companion.getClass();
        int r1 = getValue();
        if (r1 != 0) goto L5;
    L14:
        String r2 = "TAG_UNSET";
    L15:
        r0.append(r2);
        r0.append(')');
        return r0.toString();
    L5:
        if (r1 != 1) goto L7;
        r2 = "TAG_EXTERNAL";
        goto L15
    L7:
        if (r1 != 2) goto L9;
        r2 = "TAG_PARTNER";
        goto L15
    L9:
        if (r1 != 3) goto L14;
        r2 = "TAG_TENANT_NAME";
        goto L15
    }

    public final int getValue() {
        return this.value;
    }

    public static TagRelationTypeEnum valueOf(String r1) {
        return (TagRelationTypeEnum) r27.a.a(TagRelationTypeEnum.class, r1);
    }

    public TagRelationTypeEnum(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
