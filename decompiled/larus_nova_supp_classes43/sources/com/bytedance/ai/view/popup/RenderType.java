package com.bytedance.ai.view.popup;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/view/popup/RenderType;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "WEB", "LYNX", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RenderType extends Enum<RenderType> {
    public static final RenderType LYNX = null;
    public static final RenderType UNKNOWN = null;
    public static final RenderType WEB = null;
    public static final /* synthetic */ RenderType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<RenderType> getEntries() {
        return b;
    }

    static {
        RenderType r0 = new RenderType("UNKNOWN", 0);
        UNKNOWN = r0;
        RenderType r1 = new RenderType("WEB", 1);
        WEB = r1;
        RenderType r10 = new RenderType("LYNX", 2);
        LYNX = r10;
        RenderType[] r11 = {r0, r1, r10};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static RenderType[] values() {
        return (RenderType[]) a.clone();
    }

    public static RenderType valueOf(String r1) {
        return (RenderType) r27.a.a(RenderType.class, r1);
    }

    public RenderType(String r1, int r10) {
        super(r1, r10);
    }
}
