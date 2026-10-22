package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.response.StartGameResponse;
import com.bytedance.android.live.openplatform.impl.minigameanchor.explaincard.AnchorExplainCardContextService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ LiveMgMountContextService a;
    public final /* synthetic */ Function0 b;

    public f(LiveMgMountContextService r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void accept(Object r4) {
        Response r5 = (Response) r4;
        int r0 = qo0.a.a;
        qo0.a.a("LiveMgMountContextService", "request game/start success: " + ((StartGameResponse) r5.data).toString());
        this.a.a = ((StartGameResponse) r5.data).c();
        this.a.b = ((StartGameResponse) r5.data).a();
        if (((StartGameResponse) r5.data).b() != StartGameResponse.CardSetStatus.Success.getStatus()) goto L5;
        qo0.a.a("LiveMgMountContextService", "request game/start set card status success");
        ((AnchorExplainCardContextService) this.a.getOpenPlatformContext().getService(AnchorExplainCardContextService.class)).b = true;
    L5:
        DataCenter r6 = this.a.getOpenPlatformContext().getDataCenter();
        if (r6 == null) goto L8;
        r6.put("cmd_live_toolbarmore_dialog_dismiss", 0);
    L8:
        Function0 r7 = this.b;
        if (r7 == null) goto L11;
        Unit r8 = (Unit) r7.invoke();
    L11:
        LiveMgMountContextService r9 = this.a;
        r9.getClass();
        Lazy r1 = LiveOpenPlatformMgClient.c;
        r9.autoDispose(((MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class)).getWebcastMetaMicroGameConfig(r9.getOpenPlatformContext().getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(a.a, b.a));
        this.a.m(new LiveMgMountContextService$mount$1$1(this), LiveMgMountContextService$mount$1$2.INSTANCE);
    }
}
