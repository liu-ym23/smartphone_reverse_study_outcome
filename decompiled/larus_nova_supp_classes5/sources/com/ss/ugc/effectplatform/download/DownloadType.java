package com.ss.ugc.effectplatform.download;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/ugc/effectplatform/download/DownloadType;", "", "EFFECT", "ALGORITHM", "effect_base_release"}, k = 1, mv = {1, 4, 0})
public final enum DownloadType extends Enum<DownloadType> {
    public static final DownloadType ALGORITHM = null;
    public static final DownloadType EFFECT = null;
    public static final /* synthetic */ DownloadType[] a = null;

    static {
        DownloadType r1 = new DownloadType("EFFECT", 0);
        EFFECT = r1;
        DownloadType r2 = new DownloadType("ALGORITHM", 1);
        ALGORITHM = r2;
        a = new DownloadType[]{r1, r2};
    }

    public static DownloadType valueOf(String r1) {
        return (DownloadType) a.a(DownloadType.class, r1);
    }

    public static DownloadType[] values() {
        return (DownloadType[]) a.clone();
    }

    public DownloadType(String r1, int r2) {
        super(r1, r2);
    }
}
