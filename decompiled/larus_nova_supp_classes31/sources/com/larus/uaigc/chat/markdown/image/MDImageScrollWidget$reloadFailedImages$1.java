package com.larus.uaigc.chat.markdown.image;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationImageScrollBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.image.MDImageScrollWidget$reloadFailedImages$1", f = "MDImageScrollWidget.kt", i = {0}, l = {510}, m = "invokeSuspend", n = {"index"}, s = {"I$0"})
final class MDImageScrollWidget$reloadFailedImages$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ MDImageScrollWidget this$0;

    public MDImageScrollWidget$reloadFailedImages$1(MDImageScrollWidget r1, Continuation<? super MDImageScrollWidget$reloadFailedImages$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MDImageScrollWidget$reloadFailedImages$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0039 -> B:31:0x0075). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0072 -> B:31:0x0075). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$1;
        int r4 = this.I$0;
        ResultKt.throwOnFailure(r10);
        MDImageScrollWidget$reloadFailedImages$1 r11 = this;
    L31:
        r4 = r4 + 1;
    L9:
        if (r4 >= r2) goto L33;
        View r5 = MDImageScrollWidget.f(r11.this$0).getChildAt(r4);
        if (r5 == null) goto L31;
        MDImageScrollWidget r6 = r11.this$0;
        LarusWidgetMarkdownCreationImageScrollBinding r7 = r6.d;
        if (r7 == null) goto L17;
        RecyclerView r8 = r7.b;
        if (r8 == null) goto L17;
        RecyclerView.ViewHolder r9 = r8.getChildViewHolder(r5);
    L19:
        if ((r9 instanceof MDImageScrollAdapter.MDImageScrollViewHolder) == false) goto L21;
        MDImageScrollAdapter.MDImageScrollViewHolder r12 = (MDImageScrollAdapter.MDImageScrollViewHolder) r9;
    L22:
        if (r12 == null) goto L34;
        if (r12.o != true) goto L34;
        if (1 == 0) goto L31;
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        MDImageScrollWidget$reloadFailedImages$1$1$1 r14 = new MDImageScrollWidget$reloadFailedImages$1$1$1(r4, r6, null);
        r11.I$0 = r4;
        r11.I$1 = r2;
        r11.label = 1;
        if (BuildersKt.withContext(r13, r14, r11) != r0) goto L31;
        return r0;
    L34:
        if (0 == 0) goto L31;
        goto L31
    L21:
        r12 = null;
    L17:
        r9 = null;
        goto L19
    L33:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r2 = MDImageScrollWidget.f(this.this$0).getChildCount();
        r4 = 0;
        r11 = this;
        goto L9
    }
}
