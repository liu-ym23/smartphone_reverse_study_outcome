package com.bytedance.android.live.room.api.screenrotation.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.room.api.screenrotation.rotate.e;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.screenrotate.ScreenRotateService")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/api/screenrotation/api/IMiddlewareScreenRotateService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/android/live/room/api/screenrotation/rotate/e;", "rotation", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareScreenRotateService extends IService {
    e rotation();
}
