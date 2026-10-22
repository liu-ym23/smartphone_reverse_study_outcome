package com.bytedance.android.livesdk.interactivity.personalized;

import com.bytedance.android.livesdk.dynamicstrategy.api.IDynamicStrategyContext;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/IDynamicStrategyContext;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class PersonalizedChannelUplinkManager$init$1 extends Lambda implements Function1<IDynamicStrategyContext, Unit> {
    final /* synthetic */ PersonalizedChannelUplinkManager this$0;

    public PersonalizedChannelUplinkManager$init$1(PersonalizedChannelUplinkManager r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(IDynamicStrategyContext r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        PersonalizedChannelUplinkManager r0 = this.this$0;
        if (((Boolean) r0.f.isAnchor().getValue()).booleanValue() == false) goto L5;
        String r1 = "personalized_message_channel_strategy_anchor";
    L6:
        r0.a = r3.getStrategy(r1);
        this.this$0.f.getMessageManager().c(new AnonymousClass1(this));
        return;
    L5:
        r1 = "personalized_message_channel_strategy";
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IDynamicStrategyContext) r1);
        return Unit.INSTANCE;
    }
}
