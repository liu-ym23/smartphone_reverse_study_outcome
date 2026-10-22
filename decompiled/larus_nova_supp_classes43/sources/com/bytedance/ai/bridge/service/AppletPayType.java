package com.bytedance.ai.bridge.service;

import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/service/AppletPayType;", "", a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SIGN", "PAY", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppletPayType extends Enum<AppletPayType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AppletPayType[] $VALUES = null;
    public static final AppletPayType PAY = null;
    public static final AppletPayType SIGN = null;
    private final int value;

    private static final /* synthetic */ AppletPayType[] $values() {
        return new AppletPayType[]{SIGN, PAY};
    }

    public static EnumEntries<AppletPayType> getEntries() {
        return $ENTRIES;
    }

    static {
        SIGN = new AppletPayType("SIGN", 0, 98);
        PAY = new AppletPayType("PAY", 1, 20);
        AppletPayType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static AppletPayType[] values() {
        return (AppletPayType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppletPayType valueOf(String r1) {
        return (AppletPayType) r27.a.a(AppletPayType.class, r1);
    }

    private AppletPayType(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
