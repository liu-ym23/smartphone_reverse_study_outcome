package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum FollowUpFrom extends Enum<FollowUpFrom> implements WireEnum {
    private static final /* synthetic */ FollowUpFrom[] $VALUES = null;
    public static final ProtoAdapter<FollowUpFrom> ADAPTER = null;
    public static final FollowUpFrom OneParty = null;
    public static final FollowUpFrom Tripartite = null;
    private final int value;

    static {
        FollowUpFrom r0 = new FollowUpFrom("OneParty", 0, 1);
        OneParty = r0;
        FollowUpFrom r1 = new FollowUpFrom("Tripartite", 1, 3);
        Tripartite = r1;
        $VALUES = new FollowUpFrom[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(FollowUpFrom.class);
    }

    public static FollowUpFrom[] values() {
        return (FollowUpFrom[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FollowUpFrom fromValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 3) goto L9;
        return null;
    L9:
        return Tripartite;
    L11:
        return OneParty;
    }

    public static FollowUpFrom valueOf(String r1) {
        return (FollowUpFrom) a.a(FollowUpFrom.class, r1);
    }

    private FollowUpFrom(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
