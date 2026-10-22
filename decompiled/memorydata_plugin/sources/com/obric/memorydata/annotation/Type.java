package com.obric.memorydata.annotation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/annotation/Type;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "FILE_ENTITY", "OCR", "CAPTION", "EXTRACT", "VIDEO_FRAME", "FULL_CONTENT", "FILE_CONTENT_TEXT", "entityAnnotation_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum Type extends Enum<Type> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Type[] $VALUES = null;
    public static final Type CAPTION = null;
    public static final Type EXTRACT = null;
    public static final Type FILE_CONTENT_TEXT = null;
    public static final Type FILE_ENTITY = null;
    public static final Type FULL_CONTENT = null;
    public static final Type OCR = null;
    public static final Type TEXT = null;
    public static final Type VIDEO_FRAME = null;

    private static final /* synthetic */ Type[] $values() {
        return new Type[]{TEXT, FILE_ENTITY, OCR, CAPTION, EXTRACT, VIDEO_FRAME, FULL_CONTENT, FILE_CONTENT_TEXT};
    }

    static {
        TEXT = new Type("TEXT", 0);
        FILE_ENTITY = new Type("FILE_ENTITY", 1);
        OCR = new Type("OCR", 2);
        CAPTION = new Type("CAPTION", 3);
        EXTRACT = new Type("EXTRACT", 4);
        VIDEO_FRAME = new Type("VIDEO_FRAME", 5);
        FULL_CONTENT = new Type("FULL_CONTENT", 6);
        FILE_CONTENT_TEXT = new Type("FILE_CONTENT_TEXT", 7);
        Type[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private Type(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<Type> getEntries() {
        return $ENTRIES;
    }

    public static Type valueOf(String r2) {
        return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
    }

    public static Type[] values() {
        return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
    }
}
