package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum GroupSortRuleType extends Enum<GroupSortRuleType> implements WireEnum {
    private static final /* synthetic */ GroupSortRuleType[] $VALUES = null;
    public static final ProtoAdapter<GroupSortRuleType> ADAPTER = null;
    public static final GroupSortRuleType GROUP_CREATE_TIME = null;
    public static final GroupSortRuleType GROUP_DEFAULT_SORT = null;
    public static final GroupSortRuleType GROUP_NUM_MEMBERS = null;
    public static final GroupSortRuleType GROUP_UPDATE_TIME = null;
    private final int value;

    static {
        GroupSortRuleType r0 = new GroupSortRuleType("GROUP_DEFAULT_SORT", 0, 1);
        GROUP_DEFAULT_SORT = r0;
        GroupSortRuleType r1 = new GroupSortRuleType("GROUP_UPDATE_TIME", 1, 2);
        GROUP_UPDATE_TIME = r1;
        GroupSortRuleType r4 = new GroupSortRuleType("GROUP_CREATE_TIME", 2, 3);
        GROUP_CREATE_TIME = r4;
        GroupSortRuleType r6 = new GroupSortRuleType("GROUP_NUM_MEMBERS", 3, 4);
        GROUP_NUM_MEMBERS = r6;
        $VALUES = new GroupSortRuleType[]{r0, r1, r4, r6};
        ADAPTER = ProtoAdapter.newEnumAdapter(GroupSortRuleType.class);
    }

    public static GroupSortRuleType[] values() {
        return (GroupSortRuleType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GroupSortRuleType fromValue(int r1) {
        if (r1 == 1) goto L19;
        if (r1 == 2) goto L17;
        if (r1 == 3) goto L15;
        if (r1 == 4) goto L13;
        return null;
    L13:
        return GROUP_NUM_MEMBERS;
    L15:
        return GROUP_CREATE_TIME;
    L17:
        return GROUP_UPDATE_TIME;
    L19:
        return GROUP_DEFAULT_SORT;
    }

    public static GroupSortRuleType valueOf(String r1) {
        return (GroupSortRuleType) a.a(GroupSortRuleType.class, r1);
    }

    private GroupSortRuleType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
