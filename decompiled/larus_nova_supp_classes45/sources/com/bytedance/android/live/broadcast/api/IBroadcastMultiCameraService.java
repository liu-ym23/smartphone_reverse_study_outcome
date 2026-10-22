package com.bytedance.android.live.broadcast.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.broadcast.api.model.multicamera.RTCInfo;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.ies.sdk.widgets.DataCenter;
import h70.b;
import j70.h;
import java.util.Map;
import kotlin.Metadata;
import nz.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.BroadcastMultiCameraService")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H&J5\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015H&J\u0010\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015H&J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/IBroadcastMultiCameraService;", "Lcom/bytedance/android/live/base/IService;", "Landroid/content/Context;", "context", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "", "", "params", "", "showConnectSubDevicePanel", "Lnz/k;", "shellFragment", "Lcom/bytedance/android/live/broadcast/api/model/multicamera/RTCInfo;", "rtcInfo", "", "viewId", "roomId", "Landroidx/fragment/app/Fragment;", "getSubInteractionFragment", "(Lnz/k;Lcom/bytedance/android/live/broadcast/api/model/multicamera/RTCInfo;Ljava/lang/Long;Ljava/lang/Long;)Landroidx/fragment/app/Fragment;", "Lj70/h;", "Lh70/b;", "getLiveMultiCameraServiceWidgetDescriptor", "getLiveMultiCameraStatusWidgetDescriptor", "switchToLocalCameraView", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBroadcastMultiCameraService extends IService {
    h<? extends b> getLiveMultiCameraServiceWidgetDescriptor();

    h<? extends b> getLiveMultiCameraStatusWidgetDescriptor();

    Fragment getSubInteractionFragment(k r1, RTCInfo r2, Long r3, Long r4);

    void showConnectSubDevicePanel(Context r1, DataCenter r2, Map<String, String> r3);

    void switchToLocalCameraView(DataCenter r1);
}
