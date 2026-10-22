package com.bytedance.android.live.openplatform.impl.minigameaudience.explaincard;

import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.minigamecommon.utils.MiniGameLiveJsBridgeUtils;
import com.bytedance.android.live.room.api.messagewindow.builder.card.c;
import com.bytedance.android.live.room.api.messagewindow.service.IMsgWindowService;
import com.bytedance.android.live.room.api.messagewindow.state.source.CardDataState;
import com.bytedance.android.livesdk.config.ny0;
import com.bytedance.android.livesdk.message.model.e3;
import com.bytedance.revenue.platform.api.core.rx.h;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import q71.d;
import r71.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/minigameaudience/explaincard/AudienceExplainCardContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceExplainCardContextService extends OpenPlatformContextService {
    public static final /* synthetic */ int c = 0;
    public c a;
    public boolean b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AudienceExplainCardContextService a;

        public b(AudienceExplainCardContextService r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            final f r8 = (f) r7;
            if (this.a.b == false) goto L14;
            int r0 = qo0.a.a;
            qo0.a.c("AudienceExplainCardContextService", "card has subscribed, candy showExplainCard directly. cardType: " + r8.a);
            if (((Boolean) ny0.a.getValue()).booleanValue() == true) goto L7;
            c r9 = this.a.a;
            if (r9 == null) goto L29;
            r9.c(null);
            return;
        L29:
            return;
        L7:
            if (r8.b != CardDataState.SHOW) goto L26;
            c r10 = this.a.a;
            if (r10 == null) goto L27;
            r10.c(null);
            return;
        L27:
            return;
        L26:
            return;
        L14:
            int r1 = qo0.a.a;
            qo0.a.c("AudienceExplainCardContextService", "card subscribe, cardType: " + r8.a);
            AudienceExplainCardContextService r2 = this.a;
            final c r3 = k.n(IMsgWindowService.class).commonCardBuilder().a(new AudienceExplainCardContextService$initExplainCard$1$1(r8)).b();
            AudienceExplainCardContextService r4 = this.a;
            int r5 = h.a;
            r4.autoDispose(h.a(new AudienceExplainCardContextService$initExplainCard$1$2$1(r3)));
            Unit r6 = Unit.INSTANCE;
            r2.a = r3;
            this.a.b = true;
            if (((Boolean) ny0.a.getValue()).booleanValue() == true) goto L17;
            c r11 = this.a.a;
            if (r11 == null) goto L24;
            r11.c(null);
        L24:
            qo0.a.c("AudienceExplainCardContextService", "candy showExplainCard");
            return;
        L17:
            if (r8.b != CardDataState.SHOW) goto L24;
            c r12 = this.a.a;
            if (r12 == null) goto L24;
            r12.c(null);
            goto L24
        }
    }

    static {
    }

    public final void f() {
        qo0.a.c("AudienceExplainCardContextService", "call initExplainCard");
        e3 r0 = new e3();
        r0.areaType = 1;
        r0.areaSubType = 9;
        d r1 = q71.a.a.a(k.n(IMsgWindowService.class).cardStateDispatcher(getOpenPlatformContext().getDataCenter()), r0);
        if (r1 == null) goto L9;
        Observable r2 = r1.a();
        if (r2 == null) goto L9;
        Disposable r3 = r2.subscribe(new b(this));
        if (r3 == null) goto L9;
        autoDispose(r3);
    L9:
        int r4 = MiniGameLiveJsBridgeUtils.a;
        autoDispose(MiniGameLiveJsBridgeUtils.a("loop_card_content", new AudienceExplainCardContextService$initExplainCard$2(this)));
        autoDispose(MiniGameLiveJsBridgeUtils.a("click_bottom_right_card", new AudienceExplainCardContextService$initExplainCard$3(this)));
        autoDispose(MiniGameLiveJsBridgeUtils.a("close_bottom_right_card", new AudienceExplainCardContextService$initExplainCard$4(this)));
    }

    public AudienceExplainCardContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }
}
