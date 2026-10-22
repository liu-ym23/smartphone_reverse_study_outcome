package com.larus.dora.impl.onboarding2;

import com.larus.common_ui.widget.CircleSimpleDraweeView;
import com.larus.dora.impl.databinding.LarusDoraOnboardingV2KeepAliveScrollableBinding;
import com.larus.image.loader.b0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding2.DoraOnboardingNotificationGuideFragment$setupAvatar$2", f = "DoraOnboardingNotificationGuideFragment.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
final class DoraOnboardingNotificationGuideFragment$setupAvatar$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraOnboardingNotificationGuideFragment this$0;

    public DoraOnboardingNotificationGuideFragment$setupAvatar$2(DoraOnboardingNotificationGuideFragment r1, Continuation<? super DoraOnboardingNotificationGuideFragment$setupAvatar$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraOnboardingNotificationGuideFragment$setupAvatar$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        String r11 = (String) r10;
        if (r11 != null) goto L14;
    L17:
        if (r2 == true) goto L24;
        LarusDoraOnboardingV2KeepAliveScrollableBinding r3 = this.this$0.m;
        if (r3 == null) goto L24;
        CircleSimpleDraweeView r4 = r3.c;
        if (r4 == null) goto L24;
        CircleSimpleDraweeView.f(r4, b0.a(r11, "chat.user_avatar", false, false, 6), null, null, 0, 0, 62);
    L24:
        return Unit.INSTANCE;
    L14:
        if (r11.length() == 0) goto L17;
        r2 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r12 = Dispatchers.getIO();
        DoraOnboardingNotificationGuideFragment$setupAvatar$2$avatarUrl$1 r5 = new DoraOnboardingNotificationGuideFragment$setupAvatar$2$avatarUrl$1(null);
        this.label = 1;
        r10 = BuildersKt.withContext(r12, r5, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
