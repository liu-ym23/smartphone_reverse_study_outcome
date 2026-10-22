package com.ss.android.lark.profile_office.userprofile;

import com.ss.android.lark.contact.export.ContactSource;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileScreenKt$OfficeProfileScreen$1$1", f = "OfficeProfileScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeProfileScreenKt$OfficeProfileScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ContactSource $source;
    final /* synthetic */ String $token;
    final /* synthetic */ String $userId;
    final /* synthetic */ OfficeProfileViewModel $viewModel;
    int label;

    public OfficeProfileScreenKt$OfficeProfileScreen$1$1(OfficeProfileViewModel r1, String r2, String r3, ContactSource r4, Continuation<? super OfficeProfileScreenKt$OfficeProfileScreen$1$1> r5) {
        this.$viewModel = r1;
        this.$userId = r2;
        this.$token = r3;
        this.$source = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new OfficeProfileScreenKt$OfficeProfileScreen$1$1(this.$viewModel, this.$userId, this.$token, this.$source, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        this.$viewModel.dispatch(new k.i(this.$userId, this.$token, this.$source));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
