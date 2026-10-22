package com.bytedance.android.live.broadcastgame.api.xplay.basic;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceDummyLookup;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.xplay.basic.XplayBasicService")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/xplay/basic/IMiddlewareXplayBasicGlobalService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/broadcastgame/api/xplay/basic/a;", "getXplayGlobalService", "livebroadcastgame-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
@ServiceDummyLookup("com.bytedance.android.live.xplay.basic.XplayBasicServiceDummy")
public interface IMiddlewareXplayBasicGlobalService extends IService {
    a getXplayGlobalService();
}
