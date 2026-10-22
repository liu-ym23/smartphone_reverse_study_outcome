package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum UserGroupSceneType extends Enum<UserGroupSceneType> implements WireEnum {
    private static final /* synthetic */ UserGroupSceneType[] $VALUES = null;
    public static final ProtoAdapter<UserGroupSceneType> ADAPTER = null;
    public static final UserGroupSceneType SceneType_APPROVAL = null;
    public static final UserGroupSceneType SceneType_APP_CENTER = null;
    public static final UserGroupSceneType SceneType_CALENDAR = null;
    public static final UserGroupSceneType SceneType_CCM = null;
    public static final UserGroupSceneType SceneType_DICTIONARY = null;
    public static final UserGroupSceneType SceneType_HELP_DESK = null;
    public static final UserGroupSceneType SceneType_OKR = null;
    public static final UserGroupSceneType SceneType_OPEN_PLATFORM = null;
    public static final UserGroupSceneType SceneType_SUBSCRIPTIONS = null;
    public static final UserGroupSceneType SceneType_UNKNOWN = null;
    private final int value;

    static {
        UserGroupSceneType r0 = new UserGroupSceneType("SceneType_UNKNOWN", 0, 0);
        SceneType_UNKNOWN = r0;
        UserGroupSceneType r1 = new UserGroupSceneType("SceneType_CCM", 1, 1);
        SceneType_CCM = r1;
        UserGroupSceneType r3 = new UserGroupSceneType("SceneType_CALENDAR", 2, 2);
        SceneType_CALENDAR = r3;
        UserGroupSceneType r5 = new UserGroupSceneType("SceneType_HELP_DESK", 3, 3);
        SceneType_HELP_DESK = r5;
        UserGroupSceneType r7 = new UserGroupSceneType("SceneType_APPROVAL", 4, 4);
        SceneType_APPROVAL = r7;
        UserGroupSceneType r9 = new UserGroupSceneType("SceneType_SUBSCRIPTIONS", 5, 5);
        SceneType_SUBSCRIPTIONS = r9;
        UserGroupSceneType r11 = new UserGroupSceneType("SceneType_OKR", 6, 6);
        SceneType_OKR = r11;
        UserGroupSceneType r13 = new UserGroupSceneType("SceneType_OPEN_PLATFORM", 7, 7);
        SceneType_OPEN_PLATFORM = r13;
        UserGroupSceneType r15 = new UserGroupSceneType("SceneType_DICTIONARY", 8, 8);
        SceneType_DICTIONARY = r15;
        UserGroupSceneType r14 = new UserGroupSceneType("SceneType_APP_CENTER", 9, 9);
        SceneType_APP_CENTER = r14;
        $VALUES = new UserGroupSceneType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        ADAPTER = ProtoAdapter.newEnumAdapter(UserGroupSceneType.class);
    }

    public static UserGroupSceneType[] values() {
        return (UserGroupSceneType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserGroupSceneType fromValue(int r0) {
        switch(r0) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return SceneType_APP_CENTER;
    L8:
        return SceneType_DICTIONARY;
    L10:
        return SceneType_OPEN_PLATFORM;
    L12:
        return SceneType_OKR;
    L14:
        return SceneType_SUBSCRIPTIONS;
    L16:
        return SceneType_APPROVAL;
    L18:
        return SceneType_HELP_DESK;
    L20:
        return SceneType_CALENDAR;
    L22:
        return SceneType_CCM;
    L24:
        return SceneType_UNKNOWN;
    }

    public static UserGroupSceneType valueOf(String r1) {
        return (UserGroupSceneType) a.a(UserGroupSceneType.class, r1);
    }

    private UserGroupSceneType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
