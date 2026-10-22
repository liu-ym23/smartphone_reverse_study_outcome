package com.obric.assistant.chat.menu;

import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.obric.aivoice.core.data.NameKeys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.menu.UserAsrFeedbackUtils$asrUserFeedback$1$ret$1", f = "UserAsrFeedbackUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAsrFeedbackUtils$asrUserFeedback$1$ret$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ SAMICoreProperty $samiCoreProperty;
    int label;

    public UserAsrFeedbackUtils$asrUserFeedback$1$ret$1(SAMICoreProperty r1, Continuation<? super UserAsrFeedbackUtils$asrUserFeedback$1$ret$1> r2) {
        this.$samiCoreProperty = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UserAsrFeedbackUtils$asrUserFeedback$1$ret$1(this.$samiCoreProperty, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        return Boxing.boxInt(((SAMICore) e.a.getValue()).SAMICoreSetProperty(SAMICorePropertyId.SAMICorePropertyId_Http_Common_Request_Flow_Mark_Query_Type, this.$samiCoreProperty));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
