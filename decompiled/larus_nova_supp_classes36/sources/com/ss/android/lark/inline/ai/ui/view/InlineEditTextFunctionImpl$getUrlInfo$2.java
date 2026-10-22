package com.ss.android.lark.inline.ai.ui.view;

import android.text.TextUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.InlineEditTextFunctionImpl$getUrlInfo$2", f = "InlineEditTextFunctionImpl.kt", i = {}, l = {360}, m = "invokeSuspend", n = {}, s = {})
final class InlineEditTextFunctionImpl$getUrlInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Triple<? extends String, ? extends String, ? extends String>>, Object> {
    final /* synthetic */ String $defaultTitle;
    final /* synthetic */ String $url;
    Object L$0;
    Object L$1;
    int label;

    public InlineEditTextFunctionImpl$getUrlInfo$2(String r1, String r2, Continuation<? super InlineEditTextFunctionImpl$getUrlInfo$2> r3) {
        this.$url = r1;
        this.$defaultTitle = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new InlineEditTextFunctionImpl$getUrlInfo$2(this.$url, this.$defaultTitle, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Triple<String, String, String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r6);
    L16:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final String r7 = this.$url;
        final String r4 = this.$defaultTitle;
        this.L$0 = r7;
        this.L$1 = r4;
        this.label = 1;
        final SafeContinuation r5 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        if (TextUtils.isEmpty(r7) == false) goto L11;
        Result.Companion r8 = Result.Companion;
        r5.resumeWith(Result.constructor-impl(new Triple("", "", "")));
    L11:
        URLRecognition.a(r7, new InlineEditTextFunctionImpl$getUrlInfo$2$1$1(r5, r7, r4));
        r6 = r5.getOrThrow();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(this);
    L14:
        if (r6 != r0) goto L16;
        return r0;
    }
}
