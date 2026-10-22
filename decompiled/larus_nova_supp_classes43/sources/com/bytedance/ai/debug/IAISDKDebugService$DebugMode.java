package com.bytedance.ai.debug;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/debug/IAISDKDebugService$DebugMode;", "", com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NORMAL", "LEGACY_SCAN_PREVIEW", "LOCAL_DEBUG", "SCAN_PREVIEW", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IAISDKDebugService$DebugMode extends Enum<IAISDKDebugService$DebugMode> {
    public static final IAISDKDebugService$DebugMode LEGACY_SCAN_PREVIEW = null;
    public static final IAISDKDebugService$DebugMode LOCAL_DEBUG = null;
    public static final IAISDKDebugService$DebugMode NORMAL = null;
    public static final IAISDKDebugService$DebugMode SCAN_PREVIEW = null;
    public static final /* synthetic */ IAISDKDebugService$DebugMode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<IAISDKDebugService$DebugMode> getEntries() {
        return b;
    }

    static {
        IAISDKDebugService$DebugMode r0 = new IAISDKDebugService$DebugMode("NORMAL", 0, 0);
        NORMAL = r0;
        IAISDKDebugService$DebugMode r1 = new IAISDKDebugService$DebugMode("LEGACY_SCAN_PREVIEW", 1, 1);
        LEGACY_SCAN_PREVIEW = r1;
        IAISDKDebugService$DebugMode r10 = new IAISDKDebugService$DebugMode("LOCAL_DEBUG", 2, 2);
        LOCAL_DEBUG = r10;
        IAISDKDebugService$DebugMode r11 = new IAISDKDebugService$DebugMode("SCAN_PREVIEW", 3, 3);
        SCAN_PREVIEW = r11;
        IAISDKDebugService$DebugMode[] r12 = {r0, r1, r10, r11};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
    }

    public static IAISDKDebugService$DebugMode[] values() {
        return (IAISDKDebugService$DebugMode[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static IAISDKDebugService$DebugMode valueOf(String r1) {
        return (IAISDKDebugService$DebugMode) r27.a.a(IAISDKDebugService$DebugMode.class, r1);
    }

    public IAISDKDebugService$DebugMode(String r1, int r10, int r11) {
        super(r1, r10);
        this.value = r11;
    }
}
