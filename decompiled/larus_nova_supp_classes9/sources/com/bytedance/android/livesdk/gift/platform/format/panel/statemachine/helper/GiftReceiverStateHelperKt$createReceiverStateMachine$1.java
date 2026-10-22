package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import vh7.f;
import yz0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;", "Lcom/bytedance/android/livesdk/gift/platform/format/panel/statemachine/helper/a;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/GiftStateMachineConfig$Event;", "Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/viewmodel/GiftStateMachineConfig$f;", BuildConfig.FLAVOR, "invoke", "(Lcom/bytedance/android/live/core/utils/StateMachine$GraphBuilder;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class GiftReceiverStateHelperKt$createReceiverStateMachine$1 extends Lambda implements Function1<StateMachine.GraphBuilder<a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f>, Unit> {
    final /* synthetic */ Function1 $listener;
    final /* synthetic */ k $roomDataService;

    public GiftReceiverStateHelperKt$createReceiverStateMachine$1(k r1, Function1 r2) {
        this.$roomDataService = r1;
        this.$listener = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((StateMachine.GraphBuilder) r1);
        return Unit.INSTANCE;
    }

    public final void invoke(StateMachine.GraphBuilder<a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f> r3) {
        Intrinsics.checkNotNullParameter(r3, "$receiver");
        k r1 = this.$roomDataService;
        if (r1 == null) goto L8;
        IRoom r2 = r1.getRoom();
        if (r2 == null) goto L8;
        IBaseUser r4 = r2.getOwner();
        if (r4 == null) goto L8;
    L9:
        a.b r0 = new a.b(r4);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r0, "initialState");
        r3.a = r0;
        Function1<StateMachine.GraphBuilder<a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f>.StateDefinitionBuilder<a.b>, Unit> r5 = new AnonymousClass1(this);
        int r6 = StateMachine.Matcher.c;
        r3.c(StateMachine.Matcher.a.a(a.b.class), r5);
        Function1<StateMachine.GraphBuilder<a, GiftStateMachineConfig.Event, GiftStateMachineConfig.f>.StateDefinitionBuilder<a.c>, Unit> r7 = new AnonymousClass2(this);
        r3.c(StateMachine.Matcher.a.a(a.c.class), r7);
        r3.b(this.$listener);
        return;
    L8:
        r4 = f.c(IBaseUser.class);
        goto L9
    }
}
