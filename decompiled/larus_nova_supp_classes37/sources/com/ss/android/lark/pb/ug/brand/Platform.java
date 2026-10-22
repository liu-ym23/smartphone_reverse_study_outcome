package com.ss.android.lark.pb.ug.brand;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum Platform extends Enum<Platform> implements WireEnum {
    private static final /* synthetic */ Platform[] $VALUES = null;
    public static final ProtoAdapter<Platform> ADAPTER = null;
    public static final Platform Platform_Android = null;
    public static final Platform Platform_Harmony = null;
    public static final Platform Platform_IOS = null;
    public static final Platform Platform_Linux = null;
    public static final Platform Platform_Mac = null;
    public static final Platform Platform_Windows = null;
    private final int value;

    static {
        Platform r0 = new Platform("Platform_Android", 0, 1);
        Platform_Android = r0;
        Platform r1 = new Platform("Platform_IOS", 1, 2);
        Platform_IOS = r1;
        Platform r4 = new Platform("Platform_Windows", 2, 3);
        Platform_Windows = r4;
        Platform r6 = new Platform("Platform_Mac", 3, 4);
        Platform_Mac = r6;
        Platform r8 = new Platform("Platform_Linux", 4, 5);
        Platform_Linux = r8;
        Platform r10 = new Platform("Platform_Harmony", 5, 10);
        Platform_Harmony = r10;
        $VALUES = new Platform[]{r0, r1, r4, r6, r8, r10};
        ADAPTER = ProtoAdapter.newEnumAdapter(Platform.class);
    }

    public static Platform[] values() {
        return (Platform[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Platform fromValue(int r1) {
        if (r1 == 1) goto L27;
        if (r1 == 2) goto L25;
        if (r1 == 3) goto L23;
        if (r1 == 4) goto L21;
        if (r1 == 5) goto L19;
        if (r1 == 10) goto L17;
        return null;
    L17:
        return Platform_Harmony;
    L19:
        return Platform_Linux;
    L21:
        return Platform_Mac;
    L23:
        return Platform_Windows;
    L25:
        return Platform_IOS;
    L27:
        return Platform_Android;
    }

    public static Platform valueOf(String r1) {
        return (Platform) a.a(Platform.class, r1);
    }

    private Platform(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
