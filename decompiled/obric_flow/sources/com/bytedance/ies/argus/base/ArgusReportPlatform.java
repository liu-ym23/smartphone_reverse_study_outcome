package com.bytedance.ies.argus.base;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/argus/base/ArgusReportPlatform;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum ArgusReportPlatform extends Enum<ArgusReportPlatform> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArgusReportPlatform f5009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArgusReportPlatform f5010b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArgusReportPlatform f5011c = null;
    public static final ArgusReportPlatform d = null;
    public static final /* synthetic */ ArgusReportPlatform[] e = null;

    static {
        ArgusReportPlatform r5 = new ArgusReportPlatform("ONLY_SLARDAR", 0);
        f5009a = r5;
        ArgusReportPlatform r10 = new ArgusReportPlatform("ONLY_TEA", 1);
        f5010b = r10;
        ArgusReportPlatform r11 = new ArgusReportPlatform("ALL", 2);
        f5011c = r11;
        ArgusReportPlatform r12 = new ArgusReportPlatform("NONE", 3);
        d = r12;
        e = new ArgusReportPlatform[]{r5, r10, r11, r12};
    }

    public ArgusReportPlatform(String r5, int r10) {
        super(r5, r10);
    }

    public static ArgusReportPlatform valueOf(String r5) {
        return (ArgusReportPlatform) Enum.valueOf(ArgusReportPlatform.class, r5);
    }

    public static ArgusReportPlatform[] values() {
        return (ArgusReportPlatform[]) e.clone();
    }
}
