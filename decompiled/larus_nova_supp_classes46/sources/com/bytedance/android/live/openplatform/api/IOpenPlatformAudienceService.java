package com.bytedance.android.live.openplatform.api;

import android.content.Context;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.a0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h70.b;
import j70.h;
import kotlin.Metadata;
import mo0.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.openplatform.impl.base.OpenPlatformAudienceServiceImpl")
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\bH&J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\bH&J\b\u0010\u0014\u001a\u00020\bH&J\b\u0010\u0015\u001a\u00020\u0010H&J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH&J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0010H&J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0010H&J\b\u0010\u001d\u001a\u00020\bH&J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\nH&J\b\u0010 \u001a\u00020\bH&J\u0018\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H&J\b\u0010&\u001a\u00020\bH&J\n\u0010(\u001a\u0004\u0018\u00010'H&J\u001a\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H&¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/IOpenPlatformAudienceService;", "Lcom/bytedance/android/live/openplatform/api/IOpenPlatformService;", "Lcom/bytedance/android/live/openplatform/api/IMiddlewareOpenPlatformAudienceService;", "Lj70/h;", "Lh70/b;", "getAudienceMiniAppWidgetDescriptor", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniAppSource;", "source", "", "openMountedMiniApp", "", "location", "openSnowFlake", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/s;", "button", "onSnowFlakeShow", "", "isFromMsg", "onSnowFlakeHide", "reportMpLiveLinkShow", "reportMpLiveLinkClick", "isMiniAppExplainCardShowing", "sei", "onSei", "isGuest", "reportAudienceLiveProjectionWatch", "", "duration", "reportAudienceLiveProjectionWatchDuration", "recordSnowFlakeShown", "showType", "reportExplainCardShown", "deleteMiniAppMountInfo", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "preloadMiniAppContext", "reportSnowFlakeAnimShow", "Lmo0/a;", "getOpenPlatformImageLoader", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/dynamic/a0;", "createToolbarComponentConfig", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.openplatform.api.OpenPlatformAudienceServiceDummy")
public interface IOpenPlatformAudienceService extends IOpenPlatformService, IMiddlewareOpenPlatformAudienceService {
    a0 createToolbarComponentConfig(DataCenter r1, Context r2);

    void deleteMiniAppMountInfo();

    h<? extends b> getAudienceMiniAppWidgetDescriptor();

    a getOpenPlatformImageLoader();

    boolean isMiniAppExplainCardShowing();

    void onSei(String r1);

    void onSnowFlakeHide(boolean r1);

    void onSnowFlakeShow(s r1);

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    void openMountedMiniApp(MountedMiniAppSource r1);

    void openMountedMiniApp(String r1);

    void openSnowFlake();

    void preloadMiniAppContext(Context r1, DataCenter r2);

    void recordSnowFlakeShown();

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    void reportAudienceLiveProjectionWatch(boolean r1);

    @Override // com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService
    void reportAudienceLiveProjectionWatchDuration(long r1, boolean r3);

    void reportExplainCardShown(String r1);

    void reportMpLiveLinkClick();

    void reportMpLiveLinkShow();

    void reportSnowFlakeAnimShow();
}
