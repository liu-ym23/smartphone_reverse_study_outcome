package com.obric.assistant.cocreationreview;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationTaskFilter;", NameKeys.UnloadStrategy_No_Strategy, "label", NameKeys.UnloadStrategy_No_Strategy, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "ALL", "PENDING", "RUN", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CocreationTaskFilter extends Enum<CocreationTaskFilter> {
    public static final CocreationTaskFilter ALL = null;
    public static final CocreationTaskFilter PENDING = null;
    public static final CocreationTaskFilter RUN = null;
    public static final /* synthetic */ CocreationTaskFilter[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String label;

    public static EnumEntries<CocreationTaskFilter> getEntries() {
        return b;
    }

    static {
        CocreationTaskFilter r0 = new CocreationTaskFilter("ALL", 0, "任务总量");
        ALL = r0;
        CocreationTaskFilter r1 = new CocreationTaskFilter("PENDING", 1, "未运行");
        PENDING = r1;
        CocreationTaskFilter r2 = new CocreationTaskFilter("RUN", 2, "已运行");
        RUN = r2;
        CocreationTaskFilter[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static CocreationTaskFilter[] values() {
        return (CocreationTaskFilter[]) a.clone();
    }

    public final String getLabel() {
        return this.label;
    }

    public static CocreationTaskFilter valueOf(String r1) {
        return (CocreationTaskFilter) r27.a.a(CocreationTaskFilter.class, r1);
    }

    public CocreationTaskFilter(String r1, int r2, String r3) {
        super(r1, r2);
        this.label = r3;
    }
}
