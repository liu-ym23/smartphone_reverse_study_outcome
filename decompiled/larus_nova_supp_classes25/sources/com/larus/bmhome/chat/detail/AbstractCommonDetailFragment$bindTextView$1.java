package com.larus.bmhome.chat.detail;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
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
import lw8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.detail.AbstractCommonDetailFragment$bindTextView$1", f = "AbstractCommonDetailFragment.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
final class AbstractCommonDetailFragment$bindTextView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    int label;
    final /* synthetic */ AbstractCommonDetailFragment this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.detail.AbstractCommonDetailFragment$bindTextView$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.detail.AbstractCommonDetailFragment$bindTextView$1$1", f = "AbstractCommonDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ l $content;
        int label;
        final /* synthetic */ AbstractCommonDetailFragment this$0;

        public AnonymousClass1(AbstractCommonDetailFragment r1, l r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$content = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$content, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            CustomMarkdownTextView r4 = this.this$0.f;
            if (r4 == null) goto L8;
            r4.C(this.$content, null, null, null);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AbstractCommonDetailFragment$bindTextView$1(AbstractCommonDetailFragment r1, Context r2, Continuation<? super AbstractCommonDetailFragment$bindTextView$1> r3) {
        this.this$0 = r1;
        this.$ctx = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AbstractCommonDetailFragment$bindTextView$1(this.this$0, this.$ctx, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        AbstractCommonDetailFragment r8 = this.this$0;
        Context r2 = this.$ctx;
        int r3 = AbstractCommonDetailFragment.z;
        l r9 = r8.X90(r2);
        MainCoroutineDispatcher r4 = Dispatchers.getMain();
        AnonymousClass1 r5 = new AnonymousClass1(this.this$0, r9, null);
        this.label = 1;
        if (BuildersKt.withContext(r4, r5, this) != r0) goto L12;
        return r0;
    }
}
