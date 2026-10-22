package com.bytedance.android.live.room.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.room.IVisibilityControlBrickService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/room/api/IVisibilityControlBrickService;", "Lcom/bytedance/android/live/base/IService;", "provideVisibilityControlService", "Lcom/bytedance/android/live/room/api/IVisibilityControlService;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "releaseService", "", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IVisibilityControlBrickService extends IService {
    IVisibilityControlService provideVisibilityControlService(DataCenter r1);

    void releaseService(DataCenter r1);
}
