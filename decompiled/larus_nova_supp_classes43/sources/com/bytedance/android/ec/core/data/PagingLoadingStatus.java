package com.bytedance.android.ec.core.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/core/data/PagingLoadingStatus;", "", "SUCCESS", "ERROR", "LOADING", "END", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PagingLoadingStatus extends Enum<PagingLoadingStatus> {
    public static final PagingLoadingStatus END = null;
    public static final PagingLoadingStatus ERROR = null;
    public static final PagingLoadingStatus LOADING = null;
    public static final PagingLoadingStatus SUCCESS = null;
    public static final /* synthetic */ PagingLoadingStatus[] a = null;

    static {
        PagingLoadingStatus r1 = new PagingLoadingStatus("SUCCESS", 0);
        SUCCESS = r1;
        PagingLoadingStatus r10 = new PagingLoadingStatus("ERROR", 1);
        ERROR = r10;
        PagingLoadingStatus r11 = new PagingLoadingStatus("LOADING", 2);
        LOADING = r11;
        PagingLoadingStatus r12 = new PagingLoadingStatus("END", 3);
        END = r12;
        a = new PagingLoadingStatus[]{r1, r10, r11, r12};
    }

    public static PagingLoadingStatus valueOf(String r1) {
        return (PagingLoadingStatus) a.a(PagingLoadingStatus.class, r1);
    }

    public static PagingLoadingStatus[] values() {
        return (PagingLoadingStatus[]) a.clone();
    }

    public PagingLoadingStatus(String r1, int r10) {
        super(r1, r10);
    }
}
