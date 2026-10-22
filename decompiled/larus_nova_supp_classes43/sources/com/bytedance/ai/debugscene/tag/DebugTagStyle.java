package com.bytedance.ai.debugscene.tag;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/debugscene/tag/DebugTagStyle;", "", "<init>", "(Ljava/lang/String;I)V", "LEGACY_PREVIEW", "MODERN_DEBUG", "ai-sdk-debug-scene_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DebugTagStyle extends Enum<DebugTagStyle> {
    public static final DebugTagStyle LEGACY_PREVIEW = null;
    public static final DebugTagStyle MODERN_DEBUG = null;
    public static final /* synthetic */ DebugTagStyle[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DebugTagStyle> getEntries() {
        return b;
    }

    static {
        DebugTagStyle r0 = new DebugTagStyle("LEGACY_PREVIEW", 0);
        LEGACY_PREVIEW = r0;
        DebugTagStyle r1 = new DebugTagStyle("MODERN_DEBUG", 1);
        MODERN_DEBUG = r1;
        DebugTagStyle[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static DebugTagStyle[] values() {
        return (DebugTagStyle[]) a.clone();
    }

    public static DebugTagStyle valueOf(String r1) {
        return (DebugTagStyle) a.a(DebugTagStyle.class, r1);
    }

    public DebugTagStyle(String r1, int r10) {
        super(r1, r10);
    }
}
