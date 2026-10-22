package com.bytedance.android.live.openplatform.api.minigame;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniGameSource;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livesdk.log.filter.v;
import h70.b;
import j70.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ServiceLookup("com.bytedance.android.live.openplatform.impl.base.OpenPlatformMgAudienceServiceImpl")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002H&J\u001c\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH&J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\fH&J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H&J\u001c\u0010\u0018\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0016H&¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/minigame/IOpenPlatformMgAudienceService;", "Lcom/bytedance/android/live/openplatform/api/minigame/IOpenPlatformMgService;", "Lj70/h;", "Lh70/b;", "getAudienceMiniGameWidgetDescriptor", "Lcom/bytedance/android/live/openplatform/api/constant/MountedMiniGameSource;", "source", "", "uri", "", "openMountedMiniGame", "reportMpClick", "", "isBackground", "notifyRoomOnBackground", "getMicroGameInfo", "reportMpShow", "status", "setMountStatus", "Lkotlin/Pair;", "Lcom/bytedance/android/livesdk/log/filter/v;", "provideMgParams2LogInjector", "", "params", "injectMgParams", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.openplatform.api.minigame.OpenPlatformMgAudienceServiceDummy")
public interface IOpenPlatformMgAudienceService extends IOpenPlatformMgService {
    h<? extends b> getAudienceMiniGameWidgetDescriptor();

    String getMicroGameInfo();

    void injectMgParams(Map<String, String> r1);

    void notifyRoomOnBackground(boolean r1);

    void openMountedMiniGame(MountedMiniGameSource r1, String r2);

    Pair<String, v> provideMgParams2LogInjector();

    void reportMpClick(MountedMiniGameSource r1);

    void reportMpShow();

    void setMountStatus(boolean r1);
}
