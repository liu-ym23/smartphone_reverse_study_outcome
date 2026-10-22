package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$awaitReadyUserApi$3", f = "UserManagerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserManagerImpl$awaitReadyUserApi$3 extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $version;
    /* synthetic */ int I$0;
    int label;

    public UserManagerImpl$awaitReadyUserApi$3(int r1, Continuation<? super UserManagerImpl$awaitReadyUserApi$3> r2) {
        this.$version = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        UserManagerImpl$awaitReadyUserApi$3 r0 = new UserManagerImpl$awaitReadyUserApi$3(this.$version, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Boolean> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        if (this.I$0 == this.$version) goto L7;
        boolean r3 = true;
    L9:
        return Boxing.boxBoolean(r3);
    L7:
        r3 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
