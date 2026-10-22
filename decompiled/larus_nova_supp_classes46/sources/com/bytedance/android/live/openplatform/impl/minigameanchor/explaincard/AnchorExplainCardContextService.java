package com.bytedance.android.live.openplatform.impl.minigameanchor.explaincard;

import com.bytedance.android.live.broadcastgame.api.openplatform.h;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformMgClient;
import com.bytedance.android.live.openplatform.impl.minigameanchor.api.MiniGameAnchorApi;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yq0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameanchor/explaincard/AnchorExplainCardContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorExplainCardContextService extends OpenPlatformContextService {
    public final String a;
    public volatile boolean b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ AnchorExplainCardContextService a;
        public final /* synthetic */ Function1 b;

        public a(AnchorExplainCardContextService r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            int r0 = qo0.a.a;
            qo0.a.c(this.a.a, "request live/card/delete success, " + ((yq0.b) ((Response) r4).data));
            this.a.b = false;
            this.b.invoke(Boolean.TRUE);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorExplainCardContextService a;
        public final /* synthetic */ Function1 b;

        public b(AnchorExplainCardContextService r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            int r0 = qo0.a.a;
            String r1 = this.a.a;
            qo0.a.b(r1, "request live/card/delete fail", (Throwable) r3);
            this.b.invoke(Boolean.FALSE);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorExplainCardContextService a;
        public final /* synthetic */ Function1 b;

        public c(AnchorExplainCardContextService r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            int r0 = qo0.a.a;
            qo0.a.c(this.a.a, "request live/card/set success, " + ((g) ((Response) r4).data));
            this.a.b = true;
            this.b.invoke(Boolean.TRUE);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AnchorExplainCardContextService a;
        public final /* synthetic */ Function1 b;

        public d(AnchorExplainCardContextService r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            int r0 = qo0.a.a;
            qo0.a.b(this.a.a, "request live/card/set fail", r5);
            this.b.invoke(Boolean.FALSE);
            if (r5 == null) goto L12;
            String r1 = h.b(r5);
            if (r1 == null) goto L12;
            if (r1.length() <= 0) goto L9;
            boolean r2 = true;
        L10:
            if (r2 != true) goto L12;
            f2.c(h.b(r5), 0);
            return;
        L9:
            r2 = false;
        L12:
            f2.b(2131920997, 0);
        }
    }

    public AnchorExplainCardContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        this.a = "AnchorExplainCardContextService";
    }

    public final void f(Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "onCallback");
        if (this.b == false) goto L6;
        int r0 = qo0.a.a;
        qo0.a.c(this.a, "start request live/card/delete");
        Lazy r1 = LiveOpenPlatformMgClient.c;
        autoDispose(((MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class)).deleteExplainCard(getOpenPlatformContext().getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(this, r4), new b(this, r4)));
        return;
    }

    public final void g(String r4, Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "onCallback");
        if (this.b == true) goto L6;
        int r0 = qo0.a.a;
        qo0.a.c(this.a, "start request live/card/set");
        Lazy r1 = LiveOpenPlatformMgClient.c;
        autoDispose(((MiniGameAnchorApi) LiveOpenPlatformMgClient.a.a().a(MiniGameAnchorApi.class)).setExplainCard(getOpenPlatformContext().getRoomId(), r4).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r5), new d(this, r5)));
        return;
    }
}
