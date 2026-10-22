package com.bytedance.awemeopen.servicesapi.toast;

import android.content.Context;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/servicesapi/toast/AoToastService;", "Lcom/bytedance/bdp/bdpbase/service/IBdpService;", "ao_basic_service_api_release"}, k = 1, mv = {1, 7, 1})
public interface AoToastService extends IBdpService {
    void G1(Context r1, String r2, int r3, int r4);

    void showToast(Context r1, String r2, int r3);
}
