package com.ss.android.lark.pb.authorization;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ThridPartySDKAuthEffectType extends Enum<ThridPartySDKAuthEffectType> implements WireEnum {
    private static final /* synthetic */ ThridPartySDKAuthEffectType[] $VALUES = null;
    public static final ProtoAdapter<ThridPartySDKAuthEffectType> ADAPTER = null;
    public static final ThridPartySDKAuthEffectType AMapSDK = null;
    public static final ThridPartySDKAuthEffectType FeelGood = null;
    public static final ThridPartySDKAuthEffectType PaySDK = null;
    public static final ThridPartySDKAuthEffectType QQSDK = null;
    public static final ThridPartySDKAuthEffectType Unknown = null;
    public static final ThridPartySDKAuthEffectType WeChatSDK = null;
    public static final ThridPartySDKAuthEffectType WeiBoSDK = null;
    private final int value;

    static {
        ThridPartySDKAuthEffectType r0 = new ThridPartySDKAuthEffectType("Unknown", 0, -1);
        Unknown = r0;
        ThridPartySDKAuthEffectType r1 = new ThridPartySDKAuthEffectType("WeChatSDK", 1, 1);
        WeChatSDK = r1;
        ThridPartySDKAuthEffectType r2 = new ThridPartySDKAuthEffectType("QQSDK", 2, 2);
        QQSDK = r2;
        ThridPartySDKAuthEffectType r5 = new ThridPartySDKAuthEffectType("WeiBoSDK", 3, 3);
        WeiBoSDK = r5;
        ThridPartySDKAuthEffectType r7 = new ThridPartySDKAuthEffectType("PaySDK", 4, 4);
        PaySDK = r7;
        ThridPartySDKAuthEffectType r9 = new ThridPartySDKAuthEffectType("FeelGood", 5, 5);
        FeelGood = r9;
        ThridPartySDKAuthEffectType r11 = new ThridPartySDKAuthEffectType("AMapSDK", 6, 6);
        AMapSDK = r11;
        $VALUES = new ThridPartySDKAuthEffectType[]{r0, r1, r2, r5, r7, r9, r11};
        ADAPTER = ProtoAdapter.newEnumAdapter(ThridPartySDKAuthEffectType.class);
    }

    public static ThridPartySDKAuthEffectType[] values() {
        return (ThridPartySDKAuthEffectType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ThridPartySDKAuthEffectType fromValue(int r0) {
        switch(r0) {
            case -1: goto L18;
            case 0: goto L3;
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return AMapSDK;
    L8:
        return FeelGood;
    L10:
        return PaySDK;
    L12:
        return WeiBoSDK;
    L14:
        return QQSDK;
    L16:
        return WeChatSDK;
    L18:
        return Unknown;
    }

    public static ThridPartySDKAuthEffectType valueOf(String r1) {
        return (ThridPartySDKAuthEffectType) a.a(ThridPartySDKAuthEffectType.class, r1);
    }

    private ThridPartySDKAuthEffectType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
