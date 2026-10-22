package com.obric.aiproactive.ui.detail;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/aiproactive/ui/detail/RecommendationDetailMode;", "", "<init>", "(Ljava/lang/String;I)V", "EXECUTABLE_PENDING", "EXECUTABLE_DONE", "NOTICE_PENDING", "NOTICE_KNOWN", "NOTICE_IGNORED", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum RecommendationDetailMode extends Enum<RecommendationDetailMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RecommendationDetailMode[] $VALUES = null;
    public static final RecommendationDetailMode EXECUTABLE_DONE = null;
    public static final RecommendationDetailMode EXECUTABLE_PENDING = null;
    public static final RecommendationDetailMode NOTICE_IGNORED = null;
    public static final RecommendationDetailMode NOTICE_KNOWN = null;
    public static final RecommendationDetailMode NOTICE_PENDING = null;

    private static final /* synthetic */ RecommendationDetailMode[] $values() {
        return new RecommendationDetailMode[]{EXECUTABLE_PENDING, EXECUTABLE_DONE, NOTICE_PENDING, NOTICE_KNOWN, NOTICE_IGNORED};
    }

    static {
        EXECUTABLE_PENDING = new RecommendationDetailMode("EXECUTABLE_PENDING", 0);
        EXECUTABLE_DONE = new RecommendationDetailMode("EXECUTABLE_DONE", 1);
        NOTICE_PENDING = new RecommendationDetailMode("NOTICE_PENDING", 2);
        NOTICE_KNOWN = new RecommendationDetailMode("NOTICE_KNOWN", 3);
        NOTICE_IGNORED = new RecommendationDetailMode("NOTICE_IGNORED", 4);
        RecommendationDetailMode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private RecommendationDetailMode(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<RecommendationDetailMode> getEntries() {
        return $ENTRIES;
    }

    public static RecommendationDetailMode valueOf(String r2) {
        return (RecommendationDetailMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(RecommendationDetailMode.class, r2), RecommendationDetailMode.class, "com.obric.memorydata.plugin");
    }

    public static RecommendationDetailMode[] values() {
        return (RecommendationDetailMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RecommendationDetailMode[].class, "com.obric.memorydata.plugin");
    }
}
