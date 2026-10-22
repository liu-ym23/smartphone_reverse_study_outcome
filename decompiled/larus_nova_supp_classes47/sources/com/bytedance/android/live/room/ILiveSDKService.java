package com.bytedance.android.live.room;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.android.livehostapi.business.depend.IStartLiveVerifyCallback;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.livesdk.module.LiveSDKService")
public interface ILiveSDKService extends IService, IMiddlewareLiveSDKService {

    /* JADX INFO: renamed from: com.bytedance.android.live.room.ILiveSDKService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ o $default$getLottiePlayService(ILiveSDKService r0) {
            return r0.getLottiePlayService();
        }
    }

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    g createImagePicker(Activity r1, Fragment r2, String r3, DataCenter r4, int r5, int r6, int r7, int r8, g.b r9, IEntranceContext r10, String r12);

    i createLiveBroadcastEndFragment();

    e dnsOptimizer();

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    m getLottiePlayService();

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    /* bridge */ /* synthetic */ o getLottiePlayService();

    vlc.d getMessageManager(long r1, boolean r3, Context r4);

    v getXTSDKService();

    void handleRealNameConflict(Activity r1, int r2, com.bytedance.android.live.base.model.verify.c r3, Bundle r4);

    @Override // com.bytedance.android.live.room.IMiddlewareLiveSDKService
    void handleRealNameConflict(Activity r1, int r2, com.bytedance.android.live.base.model.verify.c r3, Bundle r4, String r5, IStartLiveVerifyCallback r6);

    void handleRealNameConflictWithoutDialog(Activity r1, int r2, com.bytedance.android.live.base.model.verify.c r3, Bundle r4);

    void handleRealNameConflictWithoutDialog(Activity r1, int r2, com.bytedance.android.live.base.model.verify.c r3, Bundle r4, IStartLiveVerifyCallback r5);

    t hostStickerViewService();

    j liveCommerceService();
}
