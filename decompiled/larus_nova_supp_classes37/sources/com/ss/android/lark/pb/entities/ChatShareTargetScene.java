package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ChatShareTargetScene extends Enum<ChatShareTargetScene> implements WireEnum {
    private static final /* synthetic */ ChatShareTargetScene[] $VALUES = null;
    public static final ProtoAdapter<ChatShareTargetScene> ADAPTER = null;
    public static final ChatShareTargetScene SCENE_BITABLE = null;
    public static final ChatShareTargetScene UNKNOWN_SCENE = null;
    private final int value;

    static {
        ChatShareTargetScene r0 = new ChatShareTargetScene("UNKNOWN_SCENE", 0, 1);
        UNKNOWN_SCENE = r0;
        ChatShareTargetScene r1 = new ChatShareTargetScene("SCENE_BITABLE", 1, 2);
        SCENE_BITABLE = r1;
        $VALUES = new ChatShareTargetScene[]{r0, r1};
        ADAPTER = ProtoAdapter.newEnumAdapter(ChatShareTargetScene.class);
    }

    public static ChatShareTargetScene[] values() {
        return (ChatShareTargetScene[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ChatShareTargetScene fromValue(int r1) {
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L9;
        return null;
    L9:
        return SCENE_BITABLE;
    L11:
        return UNKNOWN_SCENE;
    }

    public static ChatShareTargetScene valueOf(String r1) {
        return (ChatShareTargetScene) a.a(ChatShareTargetScene.class, r1);
    }

    private ChatShareTargetScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
