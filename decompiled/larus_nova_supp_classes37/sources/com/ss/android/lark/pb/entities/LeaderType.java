package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum LeaderType extends Enum<LeaderType> implements WireEnum {
    private static final /* synthetic */ LeaderType[] $VALUES = null;
    public static final ProtoAdapter<LeaderType> ADAPTER = null;
    public static final LeaderType MainLeader = null;
    public static final LeaderType SubLeader = null;
    private final int value;

    static {
        LeaderType r0 = new LeaderType("MainLeader", 0, 1);
        MainLeader = r0;
        LeaderType r1 = new LeaderType("SubLeader", 1, 2);
        SubLeader = r1;
        $VALUES = new LeaderType[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(LeaderType.class);
    }

    public static LeaderType[] values() {
        return (LeaderType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static LeaderType fromValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return SubLeader;
    L11:
        return MainLeader;
    }

    public static LeaderType valueOf(String r1) {
        return (LeaderType) a.a(LeaderType.class, r1);
    }

    private LeaderType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
