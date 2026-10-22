package com.bytedance.android.live.openplatform.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import is2.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.openplatform.impl.base.OpenPlatformAudienceServiceImpl")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0005H&J\b\u0010\u000e\u001a\u00020\u0005H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformAudienceService;", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformService;", "Lcom/bytedance/android/live/base/IService;", "", "isGuest", "", "reportAudienceLiveProjectionWatch", "", "duration", "reportAudienceLiveProjectionWatchDuration", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "source", "openMountedMiniApp", "hideMiniAppExplainCard", "showMiniAppExplainCard", "Lis2/b;", "getShelfInfoBackendHandler", "liveopenplatform-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.openplatform.api.OpenPlatformAudienceServiceDummy")
public interface IMiddlewareOpenPlatformAudienceService extends IMiddlewareOpenPlatformService, IService {
    b getShelfInfoBackendHandler();

    void hideMiniAppExplainCard();

    void openMountedMiniApp(MountedMiniAppSource r1);

    void reportAudienceLiveProjectionWatch(boolean r1);

    void reportAudienceLiveProjectionWatchDuration(long r1, boolean r3);

    void showMiniAppExplainCard();
}
