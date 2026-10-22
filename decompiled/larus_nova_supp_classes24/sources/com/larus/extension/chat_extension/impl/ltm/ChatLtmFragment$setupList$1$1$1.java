package com.larus.extension.chat_extension.impl.ltm;

import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.extension.chat_extension.impl.databinding.LarusPageChatLtmShowBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmFragment$setupList$1$1$1", f = "ChatLtmFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatLtmFragment$setupList$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<r> $it;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatLtmFragment this$0;

    /* JADX INFO: renamed from: com.larus.extension.chat_extension.impl.ltm.ChatLtmFragment$setupList$1$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.extension.chat_extension.impl.ltm.ChatLtmFragment$setupList$1$1$1$1", f = "ChatLtmFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $matchIndex;
        int label;
        final /* synthetic */ ChatLtmFragment this$0;

        public AnonymousClass1(ChatLtmFragment r1, int r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$matchIndex = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$matchIndex, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L20;
            ResultKt.throwOnFailure(r5);
            ChatLtmFragment r6 = this.this$0;
            LarusPageChatLtmShowBinding r0 = r6.i;
            if (r0 == null) goto L7;
            final RecyclerView r1 = r0.d;
        L8:
            Integer r2 = Boxing.boxInt(this.$matchIndex);
            r6.getClass();
            if (r1 == null) goto L18;
            if (r2 == null) goto L13;
            final int r7 = r2.intValue();
        L14:
            if (r7 <= 0) goto L18;
            r1.postDelayed(new b(r1, r7), 200);
            goto L18
        L13:
            r7 = 0;
        L18:
            return Unit.INSTANCE;
        L7:
            r1 = null;
            goto L8
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatLtmFragment$setupList$1$1$1(ChatLtmFragment r1, List<r> r2, Continuation<? super ChatLtmFragment$setupList$1$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ChatLtmFragment$setupList$1$1$1 r0 = new ChatLtmFragment$setupList$1$1$1(this.this$0, this.$it, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        ChatLtmFragment r8 = this.this$0;
        int r1 = ChatLtmFragment.o;
        int r9 = r8.V90().findMemoryIndex(this.this$0.V90().getTargetMemoryContent(), this.$it);
        BuildersKt.launch$default(r0, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, r9, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
