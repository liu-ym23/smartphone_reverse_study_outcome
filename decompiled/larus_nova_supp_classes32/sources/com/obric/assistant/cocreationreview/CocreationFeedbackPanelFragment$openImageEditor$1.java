package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.widget.Toast;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationFeedbackPanelFragment$openImageEditor$1", f = "CocreationFeedbackPanelFragment.kt", i = {}, l = {760}, m = "invokeSuspend", n = {}, s = {})
final class CocreationFeedbackPanelFragment$openImageEditor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ b5 $current;
    int label;
    final /* synthetic */ CocreationFeedbackPanelFragment this$0;

    public CocreationFeedbackPanelFragment$openImageEditor$1(CocreationFeedbackPanelFragment r1, b5 r2, Context r3, Continuation<? super CocreationFeedbackPanelFragment$openImageEditor$1> r4) {
        this.this$0 = r1;
        this.$current = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CocreationFeedbackPanelFragment$openImageEditor$1(this.this$0, this.$current, this.$context, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        String r6 = (String) r13;
        if (this.this$0.isAdded() == false) goto L28;
        if (Intrinsics.areEqual(this.this$0.r, this.$current.a) == false) goto L28;
        if (r6 != null) goto L19;
    L22:
        if (r3 == false) goto L25;
        CocreationFeedbackPanelFragment r2 = this.this$0;
        r2.r = null;
        Toast.makeText(r2.requireContext(), "图片读取失败，请重新选择", 0).show();
        return Unit.INSTANCE;
    L25:
        CocreationFeedbackPanelFragment r5 = this.this$0;
        LocalTakePictureImpl r4 = r5.t;
        String r7 = this.$current.a;
        int r14 = LocalTakePictureImpl.h;
        r4.b(r5, r6, r7, true, null, false, false);
        return Unit.INSTANCE;
    L19:
        if (StringsKt.isBlank(r6) == true) goto L22;
        r3 = false;
    L28:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        CocreationFeedbackPanelFragment$openImageEditor$1$imagePath$1 r8 = new CocreationFeedbackPanelFragment$openImageEditor$1$imagePath$1(this.this$0, this.$context, this.$current, null);
        this.label = 1;
        r13 = BuildersKt.withContext(r15, r8, this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
