package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.view.View;
import android.widget.CheckBox;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ LiveMgMountContextService a;
    public final /* synthetic */ CheckBox b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$5 d;
    public final /* synthetic */ LiveMgMountContextService$showStarAtlasAgreementDialog$1 e;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ n a;

        public a(n r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Response r2 = (Response) r1;
            this.a.d.m784invoke();
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            qo0.a.b("LiveMgMountContextService", "request starAuthorRegister fail", r4);
            String r5 = com.bytedance.android.live.broadcastgame.api.openplatform.h.b(r4);
            if (r5 != null) goto L5;
            r5 = s1.B(2131921004);
        L5:
            f2.c(r5, 0);
        }
    }

    public n(LiveMgMountContextService r1, CheckBox r2, boolean r3, LiveMgMountContextService$showStarAtlasAgreementDialog$5 r4, LiveMgMountContextService$showStarAtlasAgreementDialog$1 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.b.isChecked() == true) goto L5;
        f2.b(2131923041, 0);
        return;
    L5:
        if (this.c == false) goto L7;
        this.d.m784invoke();
    L8:
        this.e.invoke("confirm");
        return;
    L7:
        LiveMgMountContextService r5 = this.a;
        Lazy r0 = LiveOpenPlatformMgClient.c;
        r5.autoDispose(((MiniGameAnchorApi) ((LiveOpenPlatformMgClient) LiveOpenPlatformMgClient.e.getValue()).a(MiniGameAnchorApi.class)).starAuthorRegister(7).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this), b.a));
        goto L8
    }
}
