package com.bytedance.android.livesdk.interactivity.api;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ServiceLookup("com.bytedance.android.livesdk.interactivity.api.MultiCameraService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/IMultiCameraService;", "Lcom/bytedance/android/live/base/IService;", "getMultiCameraServiceWidget", "Ljava/lang/Class;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMultiCameraService extends IService {
    Class<? extends LiveRecyclableWidget> getMultiCameraServiceWidget();
}
