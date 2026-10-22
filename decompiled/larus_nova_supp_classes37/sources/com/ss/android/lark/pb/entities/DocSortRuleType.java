package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum DocSortRuleType extends Enum<DocSortRuleType> implements WireEnum {
    private static final /* synthetic */ DocSortRuleType[] $VALUES = null;
    public static final ProtoAdapter<DocSortRuleType> ADAPTER = null;
    public static final DocSortRuleType CREATE_TIME = null;
    public static final DocSortRuleType CREATE_TIME_ASC = null;
    public static final DocSortRuleType DEFAULT_TYPE = null;
    public static final DocSortRuleType EDIT_TIME = null;
    public static final DocSortRuleType EDIT_TIME_ASC = null;
    public static final DocSortRuleType ENTITY_CREATE_TIME_ASC = null;
    public static final DocSortRuleType ENTITY_CREATE_TIME_DESC = null;
    public static final DocSortRuleType FILE_SIZE_ASC = null;
    public static final DocSortRuleType FILE_SIZE_DESC = null;
    public static final DocSortRuleType FILTER_EDIT = null;
    public static final DocSortRuleType FILTER_OPEN = null;
    public static final DocSortRuleType MSG_CREATE_TIME = null;
    public static final DocSortRuleType OPEN_TIME = null;
    public static final DocSortRuleType TAG_TIME_ASC = null;
    public static final DocSortRuleType TAG_TIME_DESC = null;
    private final int value;

    static {
        DocSortRuleType r0 = new DocSortRuleType("DEFAULT_TYPE", 0, 1);
        DEFAULT_TYPE = r0;
        DocSortRuleType r1 = new DocSortRuleType("OPEN_TIME", 1, 2);
        OPEN_TIME = r1;
        DocSortRuleType r4 = new DocSortRuleType("EDIT_TIME", 2, 4);
        EDIT_TIME = r4;
        DocSortRuleType r6 = new DocSortRuleType("EDIT_TIME_ASC", 3, 5);
        EDIT_TIME_ASC = r6;
        DocSortRuleType r8 = new DocSortRuleType("FILTER_OPEN", 4, 8);
        FILTER_OPEN = r8;
        DocSortRuleType r11 = new DocSortRuleType("FILTER_EDIT", 5, 16);
        FILTER_EDIT = r11;
        DocSortRuleType r13 = new DocSortRuleType("MSG_CREATE_TIME", 6, 32);
        MSG_CREATE_TIME = r13;
        DocSortRuleType r14 = new DocSortRuleType("ENTITY_CREATE_TIME_ASC", 7, 64);
        ENTITY_CREATE_TIME_ASC = r14;
        DocSortRuleType r10 = new DocSortRuleType("ENTITY_CREATE_TIME_DESC", 8, 65);
        ENTITY_CREATE_TIME_DESC = r10;
        DocSortRuleType r7 = new DocSortRuleType("TAG_TIME_ASC", 9, 128);
        TAG_TIME_ASC = r7;
        DocSortRuleType r12 = new DocSortRuleType("TAG_TIME_DESC", 10, 129);
        TAG_TIME_DESC = r12;
        DocSortRuleType r9 = new DocSortRuleType("CREATE_TIME", 11, 256);
        CREATE_TIME = r9;
        DocSortRuleType r5 = new DocSortRuleType("CREATE_TIME_ASC", 12, 257);
        CREATE_TIME_ASC = r5;
        DocSortRuleType r3 = new DocSortRuleType("FILE_SIZE_ASC", 13, 512);
        FILE_SIZE_ASC = r3;
        DocSortRuleType r2 = new DocSortRuleType("FILE_SIZE_DESC", 14, 513);
        FILE_SIZE_DESC = r2;
        $VALUES = new DocSortRuleType[]{r0, r1, r4, r6, r8, r11, r13, r14, r10, r7, r12, r9, r5, r3, r2};
        ADAPTER = ProtoAdapter.newEnumAdapter(DocSortRuleType.class);
    }

    public static DocSortRuleType[] values() {
        return (DocSortRuleType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DocSortRuleType fromValue(int r1) {
        if (r1 == 1) goto L63;
        if (r1 == 2) goto L61;
        if (r1 == 4) goto L59;
        if (r1 == 5) goto L57;
        if (r1 == 8) goto L55;
        if (r1 == 16) goto L53;
        if (r1 == 32) goto L51;
        if (r1 == 64) goto L49;
        if (r1 == 65) goto L47;
        if (r1 == 128) goto L45;
        if (r1 == 129) goto L43;
        if (r1 == 256) goto L41;
        if (r1 == 257) goto L39;
        if (r1 == 512) goto L37;
        if (r1 == 513) goto L35;
        return null;
    L35:
        return FILE_SIZE_DESC;
    L37:
        return FILE_SIZE_ASC;
    L39:
        return CREATE_TIME_ASC;
    L41:
        return CREATE_TIME;
    L43:
        return TAG_TIME_DESC;
    L45:
        return TAG_TIME_ASC;
    L47:
        return ENTITY_CREATE_TIME_DESC;
    L49:
        return ENTITY_CREATE_TIME_ASC;
    L51:
        return MSG_CREATE_TIME;
    L53:
        return FILTER_EDIT;
    L55:
        return FILTER_OPEN;
    L57:
        return EDIT_TIME_ASC;
    L59:
        return EDIT_TIME;
    L61:
        return OPEN_TIME;
    L63:
        return DEFAULT_TYPE;
    }

    public static DocSortRuleType valueOf(String r1) {
        return (DocSortRuleType) a.a(DocSortRuleType.class, r1);
    }

    private DocSortRuleType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
