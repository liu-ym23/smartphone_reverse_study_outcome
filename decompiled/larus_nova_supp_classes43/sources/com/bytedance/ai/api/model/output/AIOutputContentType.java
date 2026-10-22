package com.bytedance.ai.api.model.output;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/api/model/output/AIOutputContentType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "WIDGET", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIOutputContentType extends Enum<AIOutputContentType> {
    public static final AIOutputContentType TEXT = null;
    public static final AIOutputContentType WIDGET = null;
    public static final /* synthetic */ AIOutputContentType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AIOutputContentType> getEntries() {
        return b;
    }

    static {
        AIOutputContentType r0 = new AIOutputContentType("TEXT", 0);
        TEXT = r0;
        AIOutputContentType r1 = new AIOutputContentType("WIDGET", 1);
        WIDGET = r1;
        AIOutputContentType[] r10 = {r0, r1};
        a = r10;
        b = EnumEntriesKt.enumEntries(r10);
    }

    public static AIOutputContentType[] values() {
        return (AIOutputContentType[]) a.clone();
    }

    public static AIOutputContentType valueOf(String r1) {
        return (AIOutputContentType) a.a(AIOutputContentType.class, r1);
    }

    public AIOutputContentType(String r1, int r10) {
        super(r1, r10);
    }
}
