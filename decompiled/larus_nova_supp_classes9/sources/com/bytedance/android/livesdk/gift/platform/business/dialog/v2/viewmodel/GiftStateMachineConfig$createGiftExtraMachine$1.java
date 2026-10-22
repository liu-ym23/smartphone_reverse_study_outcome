package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/GiftStateMachineConfig$b;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/GiftStateMachineConfig$Event;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/GiftStateMachineConfig$f;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class GiftStateMachineConfig$createGiftExtraMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<GiftStateMachineConfig.b, GiftStateMachineConfig.Event, GiftStateMachineConfig.f>, Unit> {
    final /* synthetic */ Function1 $listener;

    public GiftStateMachineConfig$createGiftExtraMachine$1(Function1 r1) {
        this.$listener = r1;
        super(1);
    }

    public final void invoke(StateMachine.GraphBuilder<GiftStateMachineConfig.b, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        GiftStateMachineConfig.b.a r0 = new GiftStateMachineConfig.b.a();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "initialState");
        r3.a = r0;
        AnonymousClass1 r1 = AnonymousClass1.INSTANCE;
        int r2 = StateMachine.Matcher.c;
        r3.c(StateMachine.Matcher.a.a(GiftStateMachineConfig.b.a.class), r1);
        AnonymousClass2 r4 = AnonymousClass2.INSTANCE;
        r3.c(StateMachine.Matcher.a.a(GiftStateMachineConfig.b.C0023b.class), r4);
        r3.b(this.$listener);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }
}
