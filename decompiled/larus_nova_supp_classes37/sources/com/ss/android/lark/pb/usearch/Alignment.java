package com.ss.android.lark.pb.usearch;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum Alignment extends Enum<Alignment> implements WireEnum {
    private static final /* synthetic */ Alignment[] $VALUES = null;
    public static final ProtoAdapter<Alignment> ADAPTER = null;
    public static final Alignment Center = null;
    public static final Alignment Left = null;
    public static final Alignment Right = null;
    private final int value;

    static {
        Alignment r0 = new Alignment("Left", 0, 0);
        Left = r0;
        Alignment r1 = new Alignment("Right", 1, 1);
        Right = r1;
        Alignment r3 = new Alignment("Center", 2, 2);
        Center = r3;
        $VALUES = new Alignment[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(Alignment.class);
    }

    public static Alignment[] values() {
        return (Alignment[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Alignment fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return Center;
    L12:
        return Right;
    L14:
        return Left;
    }

    public static Alignment valueOf(String r1) {
        return (Alignment) a.a(Alignment.class, r1);
    }

    private Alignment(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
