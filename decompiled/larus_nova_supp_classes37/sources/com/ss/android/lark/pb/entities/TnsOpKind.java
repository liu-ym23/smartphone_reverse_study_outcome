package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TnsOpKind extends Enum<TnsOpKind> implements WireEnum {
    private static final /* synthetic */ TnsOpKind[] $VALUES = null;
    public static final ProtoAdapter<TnsOpKind> ADAPTER = null;
    public static final TnsOpKind TNS_OP_BANNED = null;
    public static final TnsOpKind TNS_OP_DISSOLVED = null;
    public static final TnsOpKind TNS_OP_NONE = null;
    private final int value;

    static {
        TnsOpKind r0 = new TnsOpKind("TNS_OP_NONE", 0, 0);
        TNS_OP_NONE = r0;
        TnsOpKind r1 = new TnsOpKind("TNS_OP_BANNED", 1, 1);
        TNS_OP_BANNED = r1;
        TnsOpKind r3 = new TnsOpKind("TNS_OP_DISSOLVED", 2, 2);
        TNS_OP_DISSOLVED = r3;
        $VALUES = new TnsOpKind[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(TnsOpKind.class);
    }

    public static TnsOpKind[] values() {
        return (TnsOpKind[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TnsOpKind fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return TNS_OP_DISSOLVED;
    L12:
        return TNS_OP_BANNED;
    L14:
        return TNS_OP_NONE;
    }

    public static TnsOpKind valueOf(String r1) {
        return (TnsOpKind) a.a(TnsOpKind.class, r1);
    }

    private TnsOpKind(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
