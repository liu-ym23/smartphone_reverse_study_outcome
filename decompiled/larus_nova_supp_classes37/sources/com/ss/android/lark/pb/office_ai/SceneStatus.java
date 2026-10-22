package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum SceneStatus extends Enum<SceneStatus> implements WireEnum {
    private static final /* synthetic */ SceneStatus[] $VALUES = null;
    public static final ProtoAdapter<SceneStatus> ADAPTER = null;
    public static final SceneStatus SceneStatus_DELETE = null;
    public static final SceneStatus SceneStatus_STOP = null;
    public static final SceneStatus SceneStatus_VALID = null;
    private final int value;

    static {
        SceneStatus r0 = new SceneStatus("SceneStatus_VALID", 0, 0);
        SceneStatus_VALID = r0;
        SceneStatus r1 = new SceneStatus("SceneStatus_STOP", 1, 1);
        SceneStatus_STOP = r1;
        SceneStatus r3 = new SceneStatus("SceneStatus_DELETE", 2, 2);
        SceneStatus_DELETE = r3;
        $VALUES = new SceneStatus[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(SceneStatus.class);
    }

    public static SceneStatus[] values() {
        return (SceneStatus[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SceneStatus fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return SceneStatus_DELETE;
    L12:
        return SceneStatus_STOP;
    L14:
        return SceneStatus_VALID;
    }

    public static SceneStatus valueOf(String r1) {
        return (SceneStatus) a.a(SceneStatus.class, r1);
    }

    private SceneStatus(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
