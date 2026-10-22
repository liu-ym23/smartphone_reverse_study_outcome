package com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings;

import com.ss.android.lark.pb.improto.Command;
import com.ss.android.lark.pb.videochat.GetAdminSettingsRequest;
import com.ss.android.lark.pb.videochat.GetAdminSettingsResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.settings.MmAdminSettingsService$pullVCAdminSettings$1", f = "MmAdminSettingsService.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
final class MmAdminSettingsService$pullVCAdminSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ a this$0;

    public MmAdminSettingsService$pullVCAdminSettings$1(a r1, Continuation<? super MmAdminSettingsService$pullVCAdminSettings$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmAdminSettingsService$pullVCAdminSettings$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
        Object r7 = ((Result) r6).unbox-impl();
    L11:
        a r2 = this.this$0;
        if (Result.isSuccess-impl(r7) == false) goto L14;
        lvb.a.e(r2.b, "[pullVCAdminSettings] success");
        r2.e = (GetAdminSettingsResponse) r7;
    L14:
        a r3 = this.this$0;
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L18;
        lvb.a.b(r3.b, "[pullVCAdminSettings] failed, " + r8);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        com.ss.android.lark.officesdk.minutes.service.foundation.network.b r9 = (com.ss.android.lark.officesdk.minutes.service.foundation.network.b) this.this$0.c.getValue();
        Command r4 = Command.GET_ADMIN_SETTINGS;
        GetAdminSettingsRequest r5 = new GetAdminSettingsRequest.Builder().m3110build();
        this.label = 1;
        r7 = r9.a(r4, GetAdminSettingsResponse.class, r5, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
