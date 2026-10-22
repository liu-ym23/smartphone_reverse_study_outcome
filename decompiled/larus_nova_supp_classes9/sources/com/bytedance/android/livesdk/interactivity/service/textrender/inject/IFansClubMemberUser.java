package com.bytedance.android.livesdk.interactivity.service.textrender.inject;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.FansClubMemberUser")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/service/textrender/inject/IFansClubMemberUser;", "Lcom/bytedance/android/live/base/IService;", "canShowVipSingleBadge", BuildConfig.FLAVOR, "enableEcomFansClubReverse", "isShopFansClubUser", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFansClubMemberUser extends IService {
    boolean canShowVipSingleBadge();

    boolean enableEcomFansClubReverse();

    boolean isShopFansClubUser();
}
