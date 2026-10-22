package com.larus.share.impl.panel;

import androidx.recyclerview.widget.RecyclerView;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.panel.SharePanelAdapter$onBindViewHolder$2$2$1", f = "SharePanelAdapter.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
final class SharePanelAdapter$onBindViewHolder$2$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SharePanelViewHolder $holder;
    final /* synthetic */ jr9.a $itemData;
    int label;
    final /* synthetic */ SharePanelAdapter this$0;

    /* JADX INFO: renamed from: com.larus.share.impl.panel.SharePanelAdapter$onBindViewHolder$2$2$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.share.impl.panel.SharePanelAdapter$onBindViewHolder$2$2$1$1", f = "SharePanelAdapter.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SharePanelAdapter this$0;

        public AnonymousClass1(SharePanelAdapter r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            com.larus.bmhome.share.panel.b r5 = this.this$0.d;
            if (r5 == null) goto L16;
            Job r6 = r5.t;
            if (r6 == null) goto L16;
            this.label = 1;
            if (r6.join(this) != r0) goto L18;
            return r0;
        L16:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.larus.share.impl.panel.SharePanelAdapter$onBindViewHolder$2$2$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.share.impl.panel.SharePanelAdapter$onBindViewHolder$2$2$1$2", f = "SharePanelAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SharePanelViewHolder $holder;
        final /* synthetic */ jr9.a $itemData;
        int label;
        final /* synthetic */ SharePanelAdapter this$0;

        public AnonymousClass2(jr9.a r1, SharePanelAdapter r2, SharePanelViewHolder r3, Continuation<? super AnonymousClass2> r4) {
            this.$itemData = r1;
            this.this$0 = r2;
            this.$holder = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$itemData, this.this$0, this.$holder, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r4);
            jr9.a r5 = this.$itemData;
            jr9.b r0 = r5.a;
            if (r0 == null) goto L7;
            jr9.b r1 = jr9.b.a(r0, false, false, 127);
        L8:
            r5.a = r1;
            this.this$0.notifyDataSetChanged();
            if (((RecyclerView.ViewHolder) this.$holder).itemView.isAttachedToWindow() == false) goto L12;
            this.$holder.a.a.performClick();
        L12:
            return Unit.INSTANCE;
        L7:
            r1 = null;
            goto L8
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public SharePanelAdapter$onBindViewHolder$2$2$1(SharePanelAdapter r1, jr9.a r2, SharePanelViewHolder r3, Continuation<? super SharePanelAdapter$onBindViewHolder$2$2$1> r4) {
        this.this$0 = r1;
        this.$itemData = r2;
        this.$holder = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SharePanelAdapter$onBindViewHolder$2$2$1(this.this$0, this.$itemData, this.$holder, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        BuildersKt.launch$default(this.this$0.l, Dispatchers.getMain(), null, new AnonymousClass2(this.$itemData, this.this$0, this.$holder, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AnonymousClass1 r11 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (TimeoutKt.c(2000, r11, this) != r0) goto L11;
        return r0;
    }
}
