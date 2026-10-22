package com.larus.community.impl.publish;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larus.community.impl.databinding.LarusCommunityCreationPublishOpsLayoutBinding;
import com.larus.community.impl.publish.viewmodel.CreationPublishViewModel;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishOpsComponent$initView$2", f = "CreationPublishOpsComponent.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
final class CreationPublishOpsComponent$initView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationPublishOpsComponent this$0;

    /* JADX INFO: renamed from: com.larus.community.impl.publish.CreationPublishOpsComponent$initView$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/community/impl/publish/viewmodel/PublishLoadingState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishOpsComponent$initView$2$1", f = "CreationPublishOpsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<com.larus.community.impl.publish.viewmodel.i, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationPublishOpsComponent this$0;

        public AnonymousClass1(CreationPublishOpsComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(com.larus.community.impl.publish.viewmodel.i r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((com.larus.community.impl.publish.viewmodel.i) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L85;
            ResultKt.throwOnFailure(r5);
            com.larus.community.impl.publish.viewmodel.i r6 = (com.larus.community.impl.publish.viewmodel.i) this.L$0;
            if ((r6 instanceof com.larus.community.impl.publish.viewmodel.i.a) == false) goto L32;
            CreationPublishOpsComponent r7 = this.this$0;
            LarusCommunityCreationPublishOpsLayoutBinding r0 = r7.n;
            if (r0 == null) goto L11;
            TextView r1 = r0.b;
            if (r1 == null) goto L11;
            r1.setTextColor(ContextCompat.getColor(r7.getContext(), 2131103298));
        L11:
            this.this$0.F2().setEnabled(true);
            CreationPublishOpsComponent r8 = this.this$0;
            LarusCommunityCreationPublishOpsLayoutBinding r2 = r8.n;
            if (r2 == null) goto L16;
            TextView r3 = r2.b;
            if (r3 == null) goto L16;
            r3.setText(r8.getContext().getString(2131900629));
        L16:
            LarusCommunityCreationPublishOpsLayoutBinding r9 = this.this$0.n;
            if (r9 == null) goto L21;
            ImageView r10 = r9.c;
            if (r10 == null) goto L21;
            e1.x(r10);
        L21:
            LarusCommunityCreationPublishOpsLayoutBinding r11 = this.this$0.n;
            if (r11 == null) goto L26;
            ImageView r12 = r11.c;
            if (r12 == null) goto L26;
            r12.setImageResource(2131240121);
        L26:
            LarusCommunityCreationPublishOpsLayoutBinding r13 = this.this$0.n;
            if (r13 == null) goto L81;
            ProgressBar r14 = r13.d;
            if (r14 == null) goto L81;
            e1.o(r14);
        L81:
            return Unit.INSTANCE;
        L32:
            if ((r6 instanceof com.larus.community.impl.publish.viewmodel.i.b) == false) goto L59;
            this.this$0.F2().setEnabled(false);
            CreationPublishOpsComponent r15 = this.this$0;
            LarusCommunityCreationPublishOpsLayoutBinding r4 = r15.n;
            if (r4 == null) goto L38;
            TextView r16 = r4.b;
            if (r16 == null) goto L38;
            r16.setText(r15.getContext().getString(2131900629));
        L38:
            CreationPublishOpsComponent r17 = this.this$0;
            LarusCommunityCreationPublishOpsLayoutBinding r18 = r17.n;
            if (r18 == null) goto L43;
            TextView r20 = r18.b;
            if (r20 == null) goto L43;
            r20.setTextColor(ContextCompat.getColor(r17.getContext(), 2131103143));
        L43:
            LarusCommunityCreationPublishOpsLayoutBinding r21 = this.this$0.n;
            if (r21 == null) goto L48;
            ImageView r22 = r21.c;
            if (r22 == null) goto L48;
            e1.x(r22);
        L48:
            LarusCommunityCreationPublishOpsLayoutBinding r23 = this.this$0.n;
            if (r23 == null) goto L53;
            ImageView r24 = r23.c;
            if (r24 == null) goto L53;
            r24.setImageResource(2131240122);
        L53:
            LarusCommunityCreationPublishOpsLayoutBinding r25 = this.this$0.n;
            if (r25 == null) goto L81;
            ProgressBar r26 = r25.d;
            if (r26 == null) goto L81;
            e1.o(r26);
            goto L81
        L59:
            if ((r6 instanceof com.larus.community.impl.publish.viewmodel.i.c) == false) goto L83;
            this.this$0.F2().setEnabled(false);
            CreationPublishOpsComponent r27 = this.this$0;
            LarusCommunityCreationPublishOpsLayoutBinding r28 = r27.n;
            if (r28 == null) goto L65;
            TextView r30 = r28.b;
            if (r30 == null) goto L65;
            r30.setText(r27.getContext().getString(2131906328));
        L65:
            CreationPublishOpsComponent r31 = this.this$0;
            LarusCommunityCreationPublishOpsLayoutBinding r32 = r31.n;
            if (r32 == null) goto L70;
            TextView r33 = r32.b;
            if (r33 == null) goto L70;
            r33.setTextColor(ContextCompat.getColor(r31.getContext(), 2131103143));
        L70:
            LarusCommunityCreationPublishOpsLayoutBinding r34 = this.this$0.n;
            if (r34 == null) goto L75;
            ProgressBar r35 = r34.d;
            if (r35 == null) goto L75;
            e1.x(r35);
        L75:
            LarusCommunityCreationPublishOpsLayoutBinding r36 = this.this$0.n;
            if (r36 == null) goto L81;
            ImageView r37 = r36.c;
            if (r37 == null) goto L81;
            e1.o(r37);
            goto L81
        L83:
            throw new NoWhenBranchMatchedException();
        L85:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationPublishOpsComponent$initView$2(CreationPublishOpsComponent r1, Continuation<? super CreationPublishOpsComponent$initView$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationPublishOpsComponent$initView$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        i1<com.larus.community.impl.publish.viewmodel.i> r7 = ((CreationPublishViewModel) this.this$0.m.getValue()).getPublishLoadingFlow();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
