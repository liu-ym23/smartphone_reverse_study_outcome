package com.ss.android.lark.pb.guide;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum GuideScene extends Enum<GuideScene> implements WireEnum {
    private static final /* synthetic */ GuideScene[] $VALUES = null;
    public static final ProtoAdapter<GuideScene> ADAPTER = null;
    public static final GuideScene GUIDE_SCENE_CCM = null;
    public static final GuideScene GUIDE_SCENE_UNKNOWN = null;
    private final int value;

    static {
        GuideScene r0 = new GuideScene("GUIDE_SCENE_UNKNOWN", 0, 0);
        GUIDE_SCENE_UNKNOWN = r0;
        GuideScene r1 = new GuideScene("GUIDE_SCENE_CCM", 1, 1);
        GUIDE_SCENE_CCM = r1;
        $VALUES = new GuideScene[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(GuideScene.class);
    }

    public static GuideScene[] values() {
        return (GuideScene[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static GuideScene fromValue(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return null;
    L8:
        return GUIDE_SCENE_CCM;
    L10:
        return GUIDE_SCENE_UNKNOWN;
    }

    public static GuideScene valueOf(String r1) {
        return (GuideScene) a.a(GuideScene.class, r1);
    }

    private GuideScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
