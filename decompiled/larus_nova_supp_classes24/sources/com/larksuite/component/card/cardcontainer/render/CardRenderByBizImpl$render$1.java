package com.larksuite.component.card.cardcontainer.render;

import com.bytedance.lark.pb.basic.v1.UniversalCardEntity;
import com.larksuite.component.card.datachannel.UniversalCardDataObserver;
import com.larksuite.component.card.monitor.UniversalCardMonitorUtils;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.utils.CardDataUtils;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.thread.ThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/larksuite/component/card/cardcontainer/render/CardRenderByBizImpl$render$1", "Lcom/larksuite/component/card/datachannel/UniversalCardDataObserver;", "notify", "", "bizId", "", "cardEntity", "Lcom/bytedance/lark/pb/basic/v1/UniversalCardEntity;", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardRenderByBizImpl$render$1 implements UniversalCardDataObserver {
    final /* synthetic */ CardConfig $cardConfig;
    final /* synthetic */ CardContext $cardContext;
    final /* synthetic */ bz7.c $lifecycle;
    final /* synthetic */ b this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ CardData b;
        public final /* synthetic */ CardContext c;
        public final /* synthetic */ CardConfig d;

        public a(b r1, CardData r2, CardContext r3, CardConfig r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.b(this.b, this.c, this.d);     // Catch: Throwable -> L4
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

    @Override // com.larksuite.component.card.datachannel.UniversalCardDataObserver
    public void notify(String r7, UniversalCardEntity r8) {
        Intrinsics.checkNotNullParameter(r7, "bizId");
        Intrinsics.checkNotNullParameter(r8, "cardEntity");
        if (Intrinsics.areEqual(r7, this.this$0.b) == true) goto L5;
        return;
    L5:
        CardDataUtils.a.getClass();
        CardData r9 = CardDataUtils.b(r8);
        CardContext r1 = this.$cardContext;
        r1.setRenderTrace(r1.getRenderTrace().subTrace());
        int r2 = UniversalCardMonitorUtils.a;
        String r3 = this.$cardContext.getMonitorData().getBusinessType();
        String r4 = this.$cardContext.getMonitorData().getScene();
        Map<String, Object> r5 = this.$cardContext.getMonitorData().getMonitorCategoryMap();
        OPTrace r6 = this.$cardContext.getRenderTrace();
        String r10 = r9.getCardID();
        Intrinsics.checkNotNullParameter(r7, "bizId");
        Intrinsics.checkNotNullParameter(r5, "categoryMap");
        Intrinsics.checkNotNullParameter(r6, "trace");
        Intrinsics.checkNotNullParameter(r10, "cardId");
        fyb.e r0 = com.larksuite.component.card.monitor.b.a;
        OPMonitor r11 = com.larksuite.component.card.monitor.b.c.a(ncb.c.h).addCategoryValue("biz_id", r7).addCategoryValue("render_business_type", r3).addCategoryValue("scene", r4);
        Boolean r12 = Boolean.TRUE;
        r11.addCategoryValue("is_universal_card", r12).addCategoryValue("is_independent_data", r12).addCategoryValue("is_update_render", r12).addMap(r5).tracing(r6).flush();
        ThreadUtils.runOnUIThread(new a(this.this$0, r9, this.$cardContext, this.$cardConfig));
    }

    public CardRenderByBizImpl$render$1(b r1, CardContext r2, CardConfig r3, bz7.c r4) {
        this.this$0 = r1;
        this.$cardContext = r2;
        this.$cardConfig = r3;
    }
}
