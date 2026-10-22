package com.bytedance.ies.bullet.service.base;

import com.bytedance.ai.ex.widget.model.MiniAppWidgetAvailability;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/CacheItemStatus;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum CacheItemStatus extends Enum<CacheItemStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CacheItemStatus f5913a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CacheItemStatus f5914b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CacheItemStatus f5915c = null;
    public static final /* synthetic */ CacheItemStatus[] d = null;

    static {
        CacheItemStatus r5 = new CacheItemStatus("LOADING", 0);
        f5913a = r5;
        CacheItemStatus r10 = new CacheItemStatus("SUCCESS", 1);
        f5914b = r10;
        CacheItemStatus r11 = new CacheItemStatus(MiniAppWidgetAvailability.INSTALL_STATE_FAILED, 2);
        f5915c = r11;
        d = new CacheItemStatus[]{r5, r10, r11};
    }

    public CacheItemStatus(String r5, int r10) {
        super(r5, r10);
    }

    public static CacheItemStatus valueOf(String r5) {
        return (CacheItemStatus) Enum.valueOf(CacheItemStatus.class, r5);
    }

    public static CacheItemStatus[] values() {
        return (CacheItemStatus[]) d.clone();
    }
}
