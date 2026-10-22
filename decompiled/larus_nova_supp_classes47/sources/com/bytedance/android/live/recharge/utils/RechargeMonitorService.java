package com.bytedance.android.live.recharge.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/recharge/utils/RechargeMonitorService;", "", "", "serviceName", "Ljava/lang/String;", "getServiceName", "()Ljava/lang/String;", "TTLIVE_CHARGE_CHARGE_PACKAGE_API", "TTLIVE_CHARGE_PAGE_CLICK", "TTLIVE_CHARGE_PAGE_SHOW", "TTLIVE_RECHARGE_PAGE_ENTRANCE_PARAMS_LACK", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum RechargeMonitorService extends Enum<RechargeMonitorService> {
    public static final RechargeMonitorService TTLIVE_CHARGE_CHARGE_PACKAGE_API = null;
    public static final RechargeMonitorService TTLIVE_CHARGE_PAGE_CLICK = null;
    public static final RechargeMonitorService TTLIVE_CHARGE_PAGE_SHOW = null;
    public static final RechargeMonitorService TTLIVE_RECHARGE_PAGE_ENTRANCE_PARAMS_LACK = null;
    public static final /* synthetic */ RechargeMonitorService[] a = null;
    private final String serviceName;

    static {
        RechargeMonitorService r1 = new RechargeMonitorService("TTLIVE_CHARGE_CHARGE_PACKAGE_API", 0, "ttlive_charge_package_list_api_all");
        TTLIVE_CHARGE_CHARGE_PACKAGE_API = r1;
        RechargeMonitorService r2 = new RechargeMonitorService("TTLIVE_CHARGE_PAGE_CLICK", 1, "ttlive_recharge_page_pay_click");
        TTLIVE_CHARGE_PAGE_CLICK = r2;
        RechargeMonitorService r3 = new RechargeMonitorService("TTLIVE_CHARGE_PAGE_SHOW", 2, "ttlive_charge_page_show");
        TTLIVE_CHARGE_PAGE_SHOW = r3;
        RechargeMonitorService r4 = new RechargeMonitorService("TTLIVE_RECHARGE_PAGE_ENTRANCE_PARAMS_LACK", 3, "ttlive_recharge_page_entrance_params_lack");
        TTLIVE_RECHARGE_PAGE_ENTRANCE_PARAMS_LACK = r4;
        a = new RechargeMonitorService[]{r1, r2, r3, r4};
    }

    public static RechargeMonitorService valueOf(String r1) {
        return (RechargeMonitorService) r27.a.a(RechargeMonitorService.class, r1);
    }

    public static RechargeMonitorService[] values() {
        return (RechargeMonitorService[]) a.clone();
    }

    public final String getServiceName() {
        return this.serviceName;
    }

    public RechargeMonitorService(String r1, int r2, String r3) {
        super(r1, r2);
        this.serviceName = r3;
    }
}
