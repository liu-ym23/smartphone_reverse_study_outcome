package com.larksuite.component.card.cardcontainer.render;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/larksuite/component/card/cardcontainer/render/CardRenderByBizImpl$render$3", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/larksuite/component/card/datachannel/GetCardEntityResponse;", "onSuccess", "", "response", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardRenderByBizImpl$render$3 implements IGetDataCallback<com.larksuite.component.card.datachannel.a> {
    final /* synthetic */ CardConfig $cardConfig;
    final /* synthetic */ CardContext $cardContext;
    final /* synthetic */ bz7.c $lifecycle;
    final /* synthetic */ long $startLoadTime;
    final /* synthetic */ com.larksuite.component.card.cardcontainer.render.b this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ com.larksuite.component.card.cardcontainer.render.b a;

        public a(com.larksuite.component.card.cardcontainer.render.b r1, CardContext r2, CardConfig r3) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ com.larksuite.component.card.datachannel.a a;
        public final /* synthetic */ com.larksuite.component.card.cardcontainer.render.b b;
        public final /* synthetic */ CardContext c;
        public final /* synthetic */ CardConfig d;

        public b(com.larksuite.component.card.datachannel.a r1, com.larksuite.component.card.cardcontainer.render.b r2, CardContext r3, CardConfig r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CardDataUtils r0 = CardDataUtils.a;     // Catch: Throwable -> L4
            UniversalCardEntity r1 = this.a.a;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            CardData r2 = CardDataUtils.b(r1);     // Catch: Throwable -> L4
            this.b.b(r2, this.c, this.d);     // Catch: Throwable -> L4
            this.b.getClass();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r6) {
        Intrinsics.checkNotNullParameter(r6, "err");
        ThreadUtils.runOnUIThread(new a(this.this$0, this.$cardContext, this.$cardConfig));
        int r0 = UniversalCardMonitorUtils.a;
        String r1 = this.this$0.b;
        String r2 = r6.getDebugMsg();
        int r7 = r6.getCode();
        OPTrace r3 = this.$cardContext.getRenderTrace();
        Intrinsics.checkNotNullParameter(r1, "bizId");
        Intrinsics.checkNotNullParameter(r3, "trace");
        fyb.e r4 = com.larksuite.component.card.monitor.b.a;
        com.larksuite.component.card.monitor.b.c.a(ncb.c.r).addCategoryValue("biz_id", r1).addCategoryValue("error_code", Integer.valueOf(r7)).addCategoryValue("error_msg", r2).tracing(r3).flush();
    }

    public void onSuccess(com.larksuite.component.card.datachannel.a r8) {
        Intrinsics.checkNotNullParameter(r8, "response");
        int r0 = UniversalCardMonitorUtils.a;
        String r1 = this.this$0.b;
        long r2 = this.$startLoadTime;
        boolean r3 = r8.b;
        OPTrace r4 = this.$cardContext.getRenderTrace();
        Intrinsics.checkNotNullParameter(r1, "bizId");
        Intrinsics.checkNotNullParameter(r4, "trace");
        fyb.e r5 = com.larksuite.component.card.monitor.b.a;
        com.larksuite.component.card.monitor.b.c.a(ncb.c.q).addCategoryValue("biz_id", r1).addCategoryValue("is_from_cache", Boolean.valueOf(r3)).setDuration(System.currentTimeMillis() - r2).tracing(r4).flush();
        ThreadUtils.runOnUIThread(new b(r8, this.this$0, this.$cardContext, this.$cardConfig));
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r1) {
        onError(r1);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
        onSuccess((com.larksuite.component.card.datachannel.a) r1);
    }

    public CardRenderByBizImpl$render$3(com.larksuite.component.card.cardcontainer.render.b r1, long r2, CardContext r4, bz7.c r5, CardConfig r6) {
        this.this$0 = r1;
        this.$startLoadTime = r2;
        this.$cardContext = r4;
        this.$cardConfig = r6;
    }
}
