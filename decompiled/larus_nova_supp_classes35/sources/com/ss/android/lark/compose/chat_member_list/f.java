package com.ss.android.lark.compose.chat_member_list;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final Object a(Flow r2, Function2 r3, Function2 r4, Continuation r5) {
        Object r6 = new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(r2, new ChatMembersViewModelKt$collectDataOrError$2(r4, null)).collect(new e(r3), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }
}
