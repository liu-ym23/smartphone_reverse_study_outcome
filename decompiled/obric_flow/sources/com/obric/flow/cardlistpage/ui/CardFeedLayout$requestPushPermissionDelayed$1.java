package com.obric.flow.cardlistpage.ui;

import android.content.Intent;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.ControllerState;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.CardFeedLayout$requestPushPermissionDelayed$1", f = "CardFeedLayout.kt", i = {}, l = {1060}, m = "invokeSuspend", n = {}, s = {})
final class CardFeedLayout$requestPushPermissionDelayed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CardFeedLayout this$0;

    public CardFeedLayout$requestPushPermissionDelayed$1(CardFeedLayout r5, Continuation<? super CardFeedLayout$requestPushPermissionDelayed$1> r10) {
        this.this$0 = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new CardFeedLayout$requestPushPermissionDelayed$1(this.this$0, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        CardFeedLayout r12 = this.this$0;
        if (Build.VERSION.SDK_INT >= 33) goto L14;
        int r13 = CardFeedLayout.f11536c0;
        r12.getClass();
    L39:
        return Unit.INSTANCE;
    L14:
        p r14 = r12.G;
        if (r14 == null) goto L17;
        ControllerState r15 = r14.f11694n;
    L19:
        if (r15 != ControllerState.OPENED) goto L39;
        if (ContextCompat.checkSelfPermission(r12.getContext(), "android.permission.POST_NOTIFICATIONS") == 0) goto L39;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L26
        r12.getContext().startActivity(new Intent(r12.getContext(), TransparentDialogActivity.class).addFlags(268435456).putExtra("extra_action", "extra_action_request_push_permission"));     // Catch: Throwable -> L26
        Object r17 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L36;
        String r19 = "requestPushPermissionIfNeeded start TransparentDialogActivity failed: " + r18;
        Intrinsics.checkNotNullParameter("CardFeedLayout", "tag");
        Intrinsics.checkNotNullParameter(r19, "msg");
        org.koin.core.a r20 = su.a.f22013b;
        if (r20 == null) goto L34;
        ((ju.b) r20.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("CardFeedLayout", r19);
        goto L36
    L34:
        throw new IllegalStateException("KoinApplication has not been started");
    L36:
        if (Result.m131isSuccessimpl(r17) == false) goto L39;
        r12.getContext().getApplicationContext().getSharedPreferences("card_feed_prefs", 0).edit().putBoolean("push_permission_requested_once", true).apply();
    L26:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L28
    L17:
        r15 = null;
        goto L19
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.delay(2000, this) != r5) goto L11;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((CardFeedLayout$requestPushPermissionDelayed$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
