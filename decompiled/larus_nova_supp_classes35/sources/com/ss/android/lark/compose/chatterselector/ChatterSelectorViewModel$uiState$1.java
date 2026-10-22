package com.ss.android.lark.compose.chatterselector;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/compose/chatterselector/ChatterSelectorUiState;", "membersState", "Lcom/ss/android/lark/compose/chat_member_list/ChatMembersUiState;", "selectedIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatterselector.ChatterSelectorViewModel$uiState$1", f = "ChatterSelectorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatterSelectorViewModel$uiState$1 extends SuspendLambda implements Function3<com.ss.android.lark.compose.chat_member_list.d, Set<? extends String>, Continuation<? super b>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public ChatterSelectorViewModel$uiState$1(Continuation<? super ChatterSelectorViewModel$uiState$1> r2) {
        super(3, r2);
    }

    public final Object invoke(com.ss.android.lark.compose.chat_member_list.d r2, Set<String> r3, Continuation<? super b> r4) {
        ChatterSelectorViewModel$uiState$1 r0 = new ChatterSelectorViewModel$uiState$1(r4);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((com.ss.android.lark.compose.chat_member_list.d) r1, (Set) r2, (Continuation) r3);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        com.ss.android.lark.compose.chat_member_list.d r11 = (com.ss.android.lark.compose.chat_member_list.d) this.L$0;
        Set r4 = (Set) this.L$1;
        return new b(r11.a, r11.b, r4, r11.c, r11.d, r11.e, r11.f);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
