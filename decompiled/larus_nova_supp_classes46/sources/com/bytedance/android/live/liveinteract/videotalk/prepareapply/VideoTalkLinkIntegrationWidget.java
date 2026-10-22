package com.bytedance.android.live.liveinteract.videotalk.prepareapply;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.k6;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/prepareapply/VideoTalkLinkIntegrationWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkLinkIntegrationWidget extends PlatformMultiLinkWidget {
    public ChatMatchWidget a;
    public final CompositeDisposable b;
    public final IRoom c;

    public static final class a {
    }

    static {
    }

    public final void wq() {
        ALogger.d("VideoTalkLinkIntegrationWidget", "loadMatchWidget");
        if (this.a != null) goto L5;
        this.a = new ChatMatchWidget(false, this);
    L5:
        WidgetManager r0 = ((Widget) this).subWidgetManager;
        if (r0 == null) goto L9;
        r0.load(this.a);
        return;
    }

    public final void xq() {
        ALogger.d("VideoTalkLinkIntegrationWidget", "unloadMatchWidget");
        WidgetManager r0 = ((Widget) this).subWidgetManager;
        if (r0 == null) goto L6;
        r0.unload(this.a);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        enableSubWidgetManager();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        xq();
        this.b.dispose();
        if (((Boolean) k6.a.getValue()).booleanValue() == false) goto L6;
        ((Widget) this).widgetCallback = null;
        return;
    }

    public VideoTalkLinkIntegrationWidget(IRoom r2) {
        Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
        this.c = r2;
        this.b = new CompositeDisposable();
    }
}
