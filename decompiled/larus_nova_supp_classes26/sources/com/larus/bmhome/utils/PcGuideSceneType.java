package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/utils/PcGuideSceneType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "WRITING", "CODE", "PPT", "DEEP_RESEARCH", "READING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcGuideSceneType extends Enum<PcGuideSceneType> {
    public static final PcGuideSceneType CODE = null;
    public static final PcGuideSceneType DEEP_RESEARCH = null;
    public static final PcGuideSceneType PPT = null;
    public static final PcGuideSceneType READING = null;
    public static final PcGuideSceneType WRITING = null;
    public static final /* synthetic */ PcGuideSceneType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String value;

    public static EnumEntries<PcGuideSceneType> getEntries() {
        return b;
    }

    static {
        PcGuideSceneType r0 = new PcGuideSceneType("WRITING", 0, "writing");
        WRITING = r0;
        PcGuideSceneType r1 = new PcGuideSceneType("CODE", 1, "code");
        CODE = r1;
        PcGuideSceneType r2 = new PcGuideSceneType("PPT", 2, "ppt");
        PPT = r2;
        PcGuideSceneType r4 = new PcGuideSceneType("DEEP_RESEARCH", 3, "deep_research");
        DEEP_RESEARCH = r4;
        PcGuideSceneType r6 = new PcGuideSceneType("READING", 4, "reading");
        READING = r6;
        PcGuideSceneType[] r8 = {r0, r1, r2, r4, r6};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static PcGuideSceneType[] values() {
        return (PcGuideSceneType[]) a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static PcGuideSceneType valueOf(String r1) {
        return (PcGuideSceneType) r27.a.a(PcGuideSceneType.class, r1);
    }

    public PcGuideSceneType(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
