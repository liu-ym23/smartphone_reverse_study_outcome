package com.bytedance.android.live.revlink.impl.monitor;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/monitor/SeiType;", "", "FirstSei", "NormalSei", "BeforeCreate", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SeiType extends Enum<SeiType> {
    public static final SeiType BeforeCreate = null;
    public static final SeiType FirstSei = null;
    public static final SeiType NormalSei = null;
    public static final /* synthetic */ SeiType[] a = null;

    static {
        SeiType r1 = new SeiType("FirstSei", 0);
        FirstSei = r1;
        SeiType r2 = new SeiType("NormalSei", 1);
        NormalSei = r2;
        SeiType r3 = new SeiType("BeforeCreate", 2);
        BeforeCreate = r3;
        a = new SeiType[]{r1, r2, r3};
    }

    public static SeiType valueOf(String r1) {
        return (SeiType) r27.a.a(SeiType.class, r1);
    }

    public static SeiType[] values() {
        return (SeiType[]) a.clone();
    }

    public SeiType(String r1, int r2) {
        super(r1, r2);
    }
}
