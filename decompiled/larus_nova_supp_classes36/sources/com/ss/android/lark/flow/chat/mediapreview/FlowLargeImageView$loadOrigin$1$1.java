package com.ss.android.lark.flow.chat.mediapreview;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kza.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView$loadOrigin$1$1", f = "FlowLargeImageView.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
final class FlowLargeImageView$loadOrigin$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $it;
    final /* synthetic */ j $listener;
    int label;
    final /* synthetic */ FlowLargeImageView this$0;

    public static final class a implements FlowLargeImageView.b {
        public final /* synthetic */ j a;
        public final /* synthetic */ Object b;

        @Override // com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView.b
        public final void onLoadFailed() {
            Log.e("FlowPreviewImageView", "loadOrigin, onLoadFailed");
            j r0 = this.a;
            if (r0 == null) goto L6;
            r0.a("");
            return;
        }

        @Override // com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView.b
        public final void onLoadSuccess() {
            Log.e("FlowPreviewImageView", "loadOrigin, onLoadSuccess, messageId: " + ((PhotoItem) this.b).getMessageId());
            j r0 = this.a;
            if (r0 == null) goto L6;
            r0.onLoadSuccess();
            return;
        }

        public a(j r1, Object r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public FlowLargeImageView$loadOrigin$1$1(FlowLargeImageView r1, Object r2, j r3, Continuation<? super FlowLargeImageView$loadOrigin$1$1> r4) {
        this.this$0 = r1;
        this.$it = r2;
        this.$listener = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowLargeImageView$loadOrigin$1$1(this.this$0, this.$it, this.$listener, r5);
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
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FlowLargeImageLoadController r8 = this.this$0.h;
        if (r8 == null) goto L14;
        Object r2 = this.$it;
        a r4 = new a(this.$listener, r2);
        this.label = 1;
        if (r8.c((PhotoItem) r2, r4, this) != r0) goto L14;
        return r0;
    }
}
