package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum DefDisplaySetting extends Enum<DefDisplaySetting> implements WireEnum {
    private static final /* synthetic */ DefDisplaySetting[] $VALUES = null;
    public static final ProtoAdapter<DefDisplaySetting> ADAPTER = null;
    public static final DefDisplaySetting CHAT_MENU = null;
    public static final DefDisplaySetting INPUT_BOX = null;
    public static final DefDisplaySetting UNKNOWN_DEF_DISPLAY_SETTING = null;
    private final int value;

    static {
        DefDisplaySetting r0 = new DefDisplaySetting("UNKNOWN_DEF_DISPLAY_SETTING", 0, 0);
        UNKNOWN_DEF_DISPLAY_SETTING = r0;
        DefDisplaySetting r1 = new DefDisplaySetting("INPUT_BOX", 1, 1);
        INPUT_BOX = r1;
        DefDisplaySetting r3 = new DefDisplaySetting("CHAT_MENU", 2, 2);
        CHAT_MENU = r3;
        $VALUES = new DefDisplaySetting[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(DefDisplaySetting.class);
    }

    public static DefDisplaySetting[] values() {
        return (DefDisplaySetting[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DefDisplaySetting fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return CHAT_MENU;
    L12:
        return INPUT_BOX;
    L14:
        return UNKNOWN_DEF_DISPLAY_SETTING;
    }

    public static DefDisplaySetting valueOf(String r1) {
        return (DefDisplaySetting) a.a(DefDisplaySetting.class, r1);
    }

    private DefDisplaySetting(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
