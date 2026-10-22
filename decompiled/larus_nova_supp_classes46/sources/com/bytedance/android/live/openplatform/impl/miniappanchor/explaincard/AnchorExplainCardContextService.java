package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincard;

import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.base.utils.LiveOpenPlatformClient;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.ShelfApi;
import com.bytedance.android.live.openplatform.impl.miniappanchor.api.response.o;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import com.bytedance.android.livesdk.message.model.e3;
import com.bytedance.live.datacontext.n;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import r71.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/explaincard/AnchorExplainCardContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorExplainCardContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int c = 0;
    public boolean a;
    public com.bytedance.android.live.room.api.messagewindow.builder.card.c b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AnchorExplainCardContextService a;

        public b(AnchorExplainCardContextService r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            final f r6 = (f) r5;
            if (this.a.b != null) goto L6;
            qo0.a.c("AnchorExplainCardContextService", "explain card is not initialized, create card");
            AnchorExplainCardContextService r0 = this.a;
            r0.getClass();
            r0.b = k.n(IMsgWindowService.class).commonCardBuilder().a(new AnchorExplainCardContextService$createExplainCard$1(r6)).b();
        L6:
            if (r6.b != CardDataState.SHOW) goto L10;
            qo0.a.c("AnchorExplainCardContextService", "show explain card");
            com.bytedance.android.live.room.api.messagewindow.builder.card.c r7 = this.a.b;
            if (r7 == null) goto L12;
            r7.c(null);
            return;
        L12:
            return;
        L10:
            int r1 = qo0.a.a;
            qo0.a.c("AnchorExplainCardContextService", "explain card state is changed, state: " + r6.b);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void accept(Object r2) {
            e r3 = (e) r2;
            AnchorMiniAppDataContext.Companion.getClass();
            AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
            if (r0 == null) goto L7;
            n<ShelfInfo> r1 = r0.m618getShelfInfo();
            if (r1 == null) goto L7;
            r1.setValue(((o) r3.data).a());
        L7:
            this.a.invoke();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public d(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Function1 r0 = this.a;
            r0.invoke((Throwable) r2);
        }
    }

    static {
    }

    public final void f() {
        q71.a r0 = k.n(IMsgWindowService.class).cardStateDispatcher(getOpenPlatformContext().getDataCenter());
        e3 r1 = new e3();
        r1.areaType = 1;
        r1.areaSubType = 3;
        Unit r2 = Unit.INSTANCE;
        q71.d r3 = q71.a.a.a(r0, r1);
        if (r3 == null) goto L9;
        Observable r4 = r3.a();
        if (r4 == null) goto L9;
        Disposable r5 = r4.subscribe(new b(this));
        if (r5 == null) goto L9;
        autoDispose(r5);
    L9:
        final AnchorExplainCardContextService$initExplainCard$3 r6 = AnchorExplainCardContextService$initExplainCard$3.INSTANCE;
        final String r7 = "click_anchor_microapp_card";
        autoDispose(RxUtilKt.n(k.n(IBrowserService.class).registerJsEventSubscriber("click_anchor_microapp_card").observeOn(AndroidSchedulers.mainThread()), new AnchorExplainCardContextService$addPublishEventJsbListener$1(r7, r6)));
    }

    public AnchorExplainCardContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r3 = AnchorMiniAppDataContext.a.a();
        if (r3 == null) goto L8;
        n<ShelfInfo> r4 = r3.m618getShelfInfo();
        if (r4 == null) goto L9;
        i80.a.b(r4, new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public final void g(long r9, long r11, Function0<Unit> r13, Function1<? super Throwable, Unit> r14) {
        Lazy r0 = LiveOpenPlatformClient.c;
        autoDispose(((ShelfApi) LiveOpenPlatformClient.a.a().a(ShelfApi.class)).updateShelfCardStatus(getOpenPlatformContext().getRoomId(), r9, r11).compose(RxUtil.rxSchedulerHelper()).doOnError(new com.bytedance.android.live.openplatform.impl.base.utils.o(new AnchorExplainCardContextService$updateCardStatus$1(this))).subscribe(new c(r13), new d(r14)));
    }
}
