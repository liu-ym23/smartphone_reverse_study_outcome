package com.ss.android.lark.profile_office.userprofile;

import com.google.gson.Gson;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.e0;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.profile_office.userprofile.OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1", f = "OfficeProfileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ v1c.a $doubaoData;
    int label;

    public OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1(v1c.a r1, Continuation<? super OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1> r2) {
        this.$doubaoData = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OfficeProfileViewModel$loadDoubaoUserInfo$1$content$1(this.$doubaoData, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L9;
        ResultKt.throwOnFailure(r2);
        Gson r3 = e0.a;
        String r4 = e0.c(this.$doubaoData);
        if (r4 != null) goto L10;
        return "";
    L10:
        return r4;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
