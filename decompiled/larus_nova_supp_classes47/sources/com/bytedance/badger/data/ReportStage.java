package com.bytedance.badger.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/badger/data/ReportStage;", "", "PARTIAL", "FINAL", "badger-api_release"}, k = 1, mv = {1, 4, 0})
public final enum ReportStage extends Enum<ReportStage> {
    public static final ReportStage FINAL = null;
    public static final ReportStage PARTIAL = null;
    public static final /* synthetic */ ReportStage[] a = null;

    static {
        ReportStage r1 = new ReportStage("PARTIAL", 0);
        PARTIAL = r1;
        ReportStage r2 = new ReportStage("FINAL", 1);
        FINAL = r2;
        a = new ReportStage[]{r1, r2};
    }

    public static ReportStage valueOf(String r1) {
        return (ReportStage) a.a(ReportStage.class, r1);
    }

    public static ReportStage[] values() {
        return (ReportStage[]) a.clone();
    }

    public ReportStage(String r1, int r2) {
        super(r1, r2);
    }
}
