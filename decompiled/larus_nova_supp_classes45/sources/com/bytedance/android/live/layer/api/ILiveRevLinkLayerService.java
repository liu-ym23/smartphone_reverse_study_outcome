package com.bytedance.android.live.layer.api;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import dy0.c;
import io.reactivex.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\b\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006H&J4\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00100\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH'J\\\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00120\u00100\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\tH'¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/layer/api/ILiveRevLinkLayerService;", "Ldy0/c;", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "widgetManager", "", "loadAnchorLinkContextWidget", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getAnchorLinkWidget", "", "channelId", "", "content", "", "scene", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "", "Lcom/bytedance/android/live/base/model/Extra;", "sendSignalV3", "linkStatus", "offset", "count", "", "useLocalCache", "reqSrc", "roomId", "Lcom/bytedance/android/livesdk/link/model/r;", "getLinkAnchorList", "revenue-link-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILiveRevLinkLayerService extends c {
    Class<? extends Widget> getAnchorLinkWidget();

    @Deprecated(message = "api模块调用了网络接口，临时通过service转接给impl，后续调用端下沉后删除该接口，不要新增调用")
    Observable<ExtraResponse<r, Extra>> getLinkAnchorList(long r1, long r3, long r5, long r7, int r9, boolean r11, String r12, long r13);

    void loadAnchorLinkContextWidget(WidgetManager r1);

    @Deprecated(message = "api模块调用了网络接口，临时通过service转接给impl，后续调用端下沉后删除该接口，不要新增调用")
    Observable<ExtraResponse<Object, Extra>> sendSignalV3(long r1, String r3, int r4);
}
