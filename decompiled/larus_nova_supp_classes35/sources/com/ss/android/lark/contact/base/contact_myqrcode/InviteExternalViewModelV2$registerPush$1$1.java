package com.ss.android.lark.contact.base.contact_myqrcode;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.contact.base.contact_myqrcode.InviteExternalViewModelV2$registerPush$1$1", f = "InviteExternalViewModelV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InviteExternalViewModelV2$registerPush$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Boolean $contactTokenSetting;
    int label;
    final /* synthetic */ InviteExternalViewModelV2 this$0;

    public InviteExternalViewModelV2$registerPush$1$1(InviteExternalViewModelV2 r1, Boolean r2, Continuation<? super InviteExternalViewModelV2$registerPush$1$1> r3) {
        this.this$0 = r1;
        this.$contactTokenSetting = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InviteExternalViewModelV2$registerPush$1$1(this.this$0, this.$contactTokenSetting, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        MutableLiveData r3 = InviteExternalViewModelV2.access$get_canAddWithToken$p(this.this$0);
        Boolean r0 = this.$contactTokenSetting;
        if (r0 != null) goto L7;
        r0 = Boxing.boxBoolean(true);
    L7:
        r3.setValue(r0);
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
