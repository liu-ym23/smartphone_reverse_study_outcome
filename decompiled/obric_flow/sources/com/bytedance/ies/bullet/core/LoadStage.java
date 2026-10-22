package com.bytedance.ies.bullet.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/core/LoadStage;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum LoadStage extends Enum<LoadStage> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LoadStage f5267b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LoadStage f5268c = null;
    public static final LoadStage d = null;
    public static final LoadStage e = null;
    public static final LoadStage f = null;
    public static final /* synthetic */ LoadStage[] g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5269a;

    static {
        LoadStage r5 = new LoadStage("BEGIN", 0, "begin");
        f5267b = r5;
        LoadStage r10 = new LoadStage("START_LOAD", 1, "start_load");
        f5268c = r10;
        LoadStage r11 = new LoadStage("DOWNLOAD_TEMPLATE", 2, "download_template");
        d = r11;
        LoadStage r12 = new LoadStage("END", 3, "end");
        e = r12;
        LoadStage r13 = new LoadStage("UPDATE", 4, "update");
        f = r13;
        g = new LoadStage[]{r5, r10, r11, r12, r13};
    }

    public LoadStage(String r5, int r10, String r11) {
        super(r5, r10);
        this.f5269a = r11;
    }

    public static LoadStage valueOf(String r5) {
        return (LoadStage) Enum.valueOf(LoadStage.class, r5);
    }

    public static LoadStage[] values() {
        return (LoadStage[]) g.clone();
    }
}
