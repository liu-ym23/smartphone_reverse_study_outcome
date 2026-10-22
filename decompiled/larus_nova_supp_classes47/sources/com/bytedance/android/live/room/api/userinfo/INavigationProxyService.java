package com.bytedance.android.live.room.api.userinfo;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;
import l81.a;
import l81.b;
import l81.c;
import l81.d;
import l81.e;
import l81.f;
import l81.g;
import l81.h;
import l81.i;
import l81.j;
import l81.k;
import l81.l;
import l81.m;
import l81.n;
import l81.o;
import l81.p;
import l81.q;
import l81.r;
import l81.s;
import l81.t;
import l81.u;
import l81.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.NavigationProxyService")
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0014H&J\b\u0010\u0017\u001a\u00020\u0016H&J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001d\u001a\u00020\u001cH&J\b\u0010\u001f\u001a\u00020\u001eH&J\b\u0010!\u001a\u00020 H&J\b\u0010#\u001a\u00020\"H&J\b\u0010%\u001a\u00020$H&J\b\u0010'\u001a\u00020&H&J\b\u0010)\u001a\u00020(H&J\b\u0010+\u001a\u00020*H&J\b\u0010-\u001a\u00020,H&J\b\u0010/\u001a\u00020.H&¨\u00060"}, d2 = {"Lcom/bytedance/android/live/room/api/userinfo/INavigationProxyService;", "Lcom/bytedance/android/live/base/IService;", "Ll81/t;", "getToolbarConfig", "Ll81/k;", "getLivePlatformPlayerManager", "Ll81/i;", "getLiveLayerContextExt", "Ll81/e;", "getDrawCleanScreenViewModel", "Ll81/n;", "getILiveSdkProjectModeService", "Ll81/o;", "getMicRoomService", "Ll81/g;", "getLinkPlayerState", "Ll81/v;", "getVSMediaUIConfigHelper", "Ll81/j;", "getLiveLogger", "Ll81/s;", "getScreenRotateService", "Ll81/c;", "getDataCenterExtProxy", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Ll81/d;", "getDiggContext", "Ll81/u;", "getUserService", "Ll81/q;", "getRechargeServiceExternal", "Ll81/r;", "getRoomMessageHelper", "Ll81/p;", "getPromotionAdLogger", "Ll81/m;", "getLiveRoomEventParamUtils", "Ll81/f;", "getHsLiveAdMocService", "Ll81/a;", "getAudienceGameContext", "Ll81/h;", "getLinkServiceExternal", "Ll81/l;", "getLivePushPermissionHelper", "Ll81/b;", "getBroadcastService", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface INavigationProxyService extends IService {
    a getAudienceGameContext();

    b getBroadcastService();

    c getDataCenterExtProxy();

    d getDiggContext(DataCenter r1);

    e getDrawCleanScreenViewModel();

    f getHsLiveAdMocService();

    n getILiveSdkProjectModeService();

    g getLinkPlayerState();

    h getLinkServiceExternal();

    i getLiveLayerContextExt();

    j getLiveLogger();

    k getLivePlatformPlayerManager();

    l getLivePushPermissionHelper();

    m getLiveRoomEventParamUtils();

    o getMicRoomService();

    p getPromotionAdLogger();

    q getRechargeServiceExternal();

    r getRoomMessageHelper();

    s getScreenRotateService();

    t getToolbarConfig();

    u getUserService();

    v getVSMediaUIConfigHelper();
}
