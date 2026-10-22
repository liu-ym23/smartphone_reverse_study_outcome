package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ContentAlignType extends Enum<ContentAlignType> implements WireEnum {
    private static final /* synthetic */ ContentAlignType[] $VALUES = null;
    public static final ProtoAdapter<ContentAlignType> ADAPTER = null;
    public static final ContentAlignType ContentAlignType_BOTTOM = null;
    public static final ContentAlignType ContentAlignType_MIDDLE = null;
    public static final ContentAlignType ContentAlignType_TOP = null;
    private final int value;

    static {
        ContentAlignType r0 = new ContentAlignType("ContentAlignType_TOP", 0, 1);
        ContentAlignType_TOP = r0;
        ContentAlignType r1 = new ContentAlignType("ContentAlignType_MIDDLE", 1, 2);
        ContentAlignType_MIDDLE = r1;
        ContentAlignType r4 = new ContentAlignType("ContentAlignType_BOTTOM", 2, 3);
        ContentAlignType_BOTTOM = r4;
        $VALUES = new ContentAlignType[]{r0, r1, r4};
        ADAPTER = ProtoAdapter.newEnumAdapter(ContentAlignType.class);
    }

    public static ContentAlignType[] values() {
        return (ContentAlignType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ContentAlignType fromValue(int r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return null;
    L11:
        return ContentAlignType_BOTTOM;
    L13:
        return ContentAlignType_MIDDLE;
    L15:
        return ContentAlignType_TOP;
    }

    public static ContentAlignType valueOf(String r1) {
        return (ContentAlignType) a.a(ContentAlignType.class, r1);
    }

    private ContentAlignType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
