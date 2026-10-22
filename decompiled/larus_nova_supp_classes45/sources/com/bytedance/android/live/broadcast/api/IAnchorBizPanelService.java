package com.bytedance.android.live.broadcast.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.broadcast.api.anchorbizpanel.OperateSource;
import com.bytedance.android.live.broadcast.api.anchorbizpanel.OperateType;
import h70.b;
import j70.h;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/IAnchorBizPanelService;", "Lcom/bytedance/android/live/base/IService;", "Lj70/h;", "Lh70/b;", "getAnchorBizPanelDescriptor", "Lcom/bytedance/android/live/broadcast/api/anchorbizpanel/OperateType;", "type", "Lcom/bytedance/android/live/broadcast/api/anchorbizpanel/OperateSource;", "enterFrom", "", "operatePanel", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAnchorBizPanelService extends IService {
    h<? extends b> getAnchorBizPanelDescriptor();

    void operatePanel(OperateType r1, OperateSource r2);
}
