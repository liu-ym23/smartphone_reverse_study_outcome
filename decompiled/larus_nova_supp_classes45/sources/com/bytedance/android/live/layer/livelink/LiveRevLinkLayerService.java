package com.bytedance.android.live.layer.livelink;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.layer.api.ILiveRevLinkLayerService;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenuelink.AnchorLinkLoadWidget;
import com.bytedance.android.livesdk.link.model.r;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import dy0.c;
import e11.b;
import io.reactivex.Observable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\n\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016J4\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00120\u00112\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\\\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00140\u00120\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016¨\u0006!"}, d2 = {"Lcom/bytedance/android/live/layer/livelink/LiveRevLinkLayerService;", "Lcom/bytedance/android/live/layer/api/ILiveRevLinkLayerService;", "Ldy0/c;", "Lcom/bytedance/android/scope/o;", "Lcom/bytedance/ies/sdk/widgets/WidgetManager;", "widgetManager", "", "loadAnchorLinkContextWidget", "Ljava/lang/Class;", "Lcom/bytedance/ies/sdk/widgets/Widget;", "getAnchorLinkWidget", "", "channelId", "", "content", "", "scene", "Lio/reactivex/Observable;", "Lcom/bytedance/android/live/network/response/ExtraResponse;", "", "Lcom/bytedance/android/live/base/model/Extra;", "sendSignalV3", "linkStatus", "offset", "count", "", "useLocalCache", "reqSrc", "roomId", "Lcom/bytedance/android/livesdk/link/model/r;", "getLinkAnchorList", "<init>", "()V", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class LiveRevLinkLayerService implements ILiveRevLinkLayerService, c, o {
    public void onStart() {
    }

    public void onStop() {
    }

    public LiveRevLinkLayerService() {
    }

    @Override // com.bytedance.android.live.layer.api.ILiveRevLinkLayerService
    public Class<? extends Widget> getAnchorLinkWidget() {
        return AnchorLinkLoadWidget.class;
    }

    @Override // com.bytedance.android.live.layer.api.ILiveRevLinkLayerService
    public void loadAnchorLinkContextWidget(WidgetManager r2) {
        if (r2 == null) goto L5;
        r2.load(new AnchorLinkLoadWidget());
        return;
    }

    @Override // com.bytedance.android.live.layer.api.ILiveRevLinkLayerService
    public Observable<ExtraResponse<Object, Extra>> sendSignalV3(long r2, String r4, int r5) {
        return e11.c.a(b.a).sendSignalV3(r2, r4, r5);
    }

    @Override // com.bytedance.android.live.layer.api.ILiveRevLinkLayerService
    public Observable<ExtraResponse<r, Extra>> getLinkAnchorList(long r16, long r18, long r21, long r22, int r24, boolean r25, String r26, long r27) {
        return e11.c.a(b.a).getLinkAnchorList(r16, r18, r21, r22, r24, r25, r26, r27);
    }
}
