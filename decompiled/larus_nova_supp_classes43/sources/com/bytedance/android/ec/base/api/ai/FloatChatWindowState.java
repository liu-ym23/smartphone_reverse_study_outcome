package com.bytedance.android.ec.base.api.ai;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/FloatChatWindowState;", "", "(Ljava/lang/String;I)V", "COLLAPSED", "PREVIEW", "EXPANDED", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final enum FloatChatWindowState extends Enum<FloatChatWindowState> {
    private static final /* synthetic */ FloatChatWindowState[] $VALUES = null;
    public static final FloatChatWindowState COLLAPSED = null;
    public static final FloatChatWindowState EXPANDED = null;
    public static final FloatChatWindowState PREVIEW = null;

    static {
        FloatChatWindowState r1 = new FloatChatWindowState("COLLAPSED", 0);
        COLLAPSED = r1;
        FloatChatWindowState r10 = new FloatChatWindowState("PREVIEW", 1);
        PREVIEW = r10;
        FloatChatWindowState r11 = new FloatChatWindowState("EXPANDED", 2);
        EXPANDED = r11;
        $VALUES = new FloatChatWindowState[]{r1, r10, r11};
    }

    public static FloatChatWindowState valueOf(String r1) {
        return (FloatChatWindowState) a.a(FloatChatWindowState.class, r1);
    }

    public static FloatChatWindowState[] values() {
        return (FloatChatWindowState[]) $VALUES.clone();
    }

    private FloatChatWindowState(String r1, int r10) {
        super(r1, r10);
    }
}
