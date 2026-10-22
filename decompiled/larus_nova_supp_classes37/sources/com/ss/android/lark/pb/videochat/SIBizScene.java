package com.ss.android.lark.pb.videochat;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SIBizScene extends Enum<SIBizScene> implements WireEnum {
    private static final /* synthetic */ SIBizScene[] $VALUES = null;
    public static final ProtoAdapter<SIBizScene> ADAPTER = null;
    public static final SIBizScene INDEPENDENT = null;
    public static final SIBizScene MEETING = null;
    public static final SIBizScene MINUTES = null;
    private final int value;

    static {
        SIBizScene r0 = new SIBizScene("MEETING", 0, 0);
        MEETING = r0;
        SIBizScene r1 = new SIBizScene("MINUTES", 1, 1);
        MINUTES = r1;
        SIBizScene r3 = new SIBizScene("INDEPENDENT", 2, 2);
        INDEPENDENT = r3;
        $VALUES = new SIBizScene[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(SIBizScene.class);
    }

    public static SIBizScene[] values() {
        return (SIBizScene[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SIBizScene fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return INDEPENDENT;
    L12:
        return MINUTES;
    L14:
        return MEETING;
    }

    public static SIBizScene valueOf(String r1) {
        return (SIBizScene) a.a(SIBizScene.class, r1);
    }

    private SIBizScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
