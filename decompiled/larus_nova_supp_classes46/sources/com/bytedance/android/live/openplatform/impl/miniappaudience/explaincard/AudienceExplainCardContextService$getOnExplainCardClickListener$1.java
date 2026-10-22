package com.bytedance.android.live.openplatform.impl.miniappaudience.explaincard;

import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.impl.miniappaudience.applog.AudienceMiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextService;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.AudienceShelfInfoService;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class AudienceExplainCardContextService$getOnExplainCardClickListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isHighIntentionTrigger;
    final /* synthetic */ MountedMiniAppSource $source;
    final /* synthetic */ AudienceExplainCardContextService this$0;

    public AudienceExplainCardContextService$getOnExplainCardClickListener$1(AudienceExplainCardContextService r1, MountedMiniAppSource r2, boolean r3) {
        this.this$0 = r1;
        this.$source = r2;
        this.$isHighIntentionTrigger = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m727invoke() {
        qo0.a.c("AudienceExplainCardContextService", "click explain card");
        AudienceExplainCardContextService r0 = this.this$0;
        int r1 = AudienceExplainCardContextService.h;
        AudienceMiniAppAppLogContextService r2 = (AudienceMiniAppAppLogContextService) r0.getOpenPlatformContext().getService(AudienceMiniAppAppLogContextService.class);
        MountedMiniAppSource r3 = this.$source;
        String r4 = "1";
        if (this.$isHighIntentionTrigger == false) goto L5;
        Object r5 = "1";
    L6:
        r2.reportMpLivePopupCardClick(r3, MapsKt.mapOf(TuplesKt.to("if_high_intention_trigger", r5)));
        AudienceLaunchContextService r6 = (AudienceLaunchContextService) this.this$0.getOpenPlatformContext().getService(AudienceLaunchContextService.class);
        MountedMiniAppSource r7 = this.$source;
        if (this.$isHighIntentionTrigger == true) goto L10;
        r4 = "0";
    L10:
        r6.openMiniApp(r7, MapsKt.mapOf(TuplesKt.to("if_high_intention_trigger", r4)));
        AudienceShelfInfoService r8 = (AudienceShelfInfoService) this.this$0.getOpenPlatformContext().getService(AudienceShelfInfoService.class);
        MiniAppDataContext.Companion.getClass();
        ShelfInfo r9 = MiniAppDataContext.a.b();
        if (r9 == null) goto L15;
        ShelfCardInfo r10 = com.bytedance.android.live.openplatform.api.model.shelf.g.a(r9);
        if (r10 == null) goto L15;
        long r11 = r10.getCardId();
    L16:
        r8.m(1, r11);
        return;
    L15:
        r11 = 0;
        goto L16
    L5:
        r5 = "0";
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m727invoke();
        return Unit.INSTANCE;
    }
}
