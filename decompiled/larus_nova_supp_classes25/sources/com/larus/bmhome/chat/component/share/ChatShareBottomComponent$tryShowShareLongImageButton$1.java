package com.larus.bmhome.chat.component.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.MessageShareViewModel;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.im.bean.message.Message;
import com.larus.network.bean.BizResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$tryShowShareLongImageButton$1", f = "ChatShareBottomComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatShareBottomComponent$tryShowShareLongImageButton$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatShareBottomComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.share.ChatShareBottomComponent$tryShowShareLongImageButton$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$tryShowShareLongImageButton$1$1", f = "ChatShareBottomComponent.kt", i = {}, l = {1694}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BizResponse<SaveMessageShareInfo>>, Object> {
        int label;
        final /* synthetic */ ChatShareBottomComponent this$0;

        public AnonymousClass1(ChatShareBottomComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super BizResponse<SaveMessageShareInfo>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            ChatShareBottomComponent r5 = this.this$0;
            int r2 = ChatShareBottomComponent.R;
            MessageShareViewModel r6 = r5.e4();
            List<Message> r3 = this.this$0.e4().getShareLongImageButtonMsgIdList();
            this.label = 1;
            r4 = r6.doRequestMessageShareApi(r3, this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.share.ChatShareBottomComponent$tryShowShareLongImageButton$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.share.ChatShareBottomComponent$tryShowShareLongImageButton$1$2", f = "ChatShareBottomComponent.kt", i = {}, l = {1697}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Bitmap, ? extends Integer>>, Object> {
        int label;
        final /* synthetic */ ChatShareBottomComponent this$0;

        public AnonymousClass2(ChatShareBottomComponent r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Bitmap, Integer>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            Pair r11 = (Pair) r10;
            Handler r2 = com.larus.utils.t0.a;
            final ChatShareBottomComponent r3 = this.this$0;
            r2.post(new r0(r3));
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            ChatShareBottomComponent r12 = this.this$0;
            int r4 = ChatShareBottomComponent.R;
            MessageShareViewModel r5 = r12.e4();
            Context r6 = this.this$0.getContext();
            String r7 = ChatShareBottomComponent.p3(this.this$0);
            e r8 = this.this$0.h();
            MessageShareViewModel.b r9 = this.this$0.W3();
            this.label = 1;
            r10 = r5.shareLongImage(r6, r7, r8, r9, this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    public ChatShareBottomComponent$tryShowShareLongImageButton$1(ChatShareBottomComponent r1, Continuation<? super ChatShareBottomComponent$tryShowShareLongImageButton$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatShareBottomComponent$tryShowShareLongImageButton$1 r0 = new ChatShareBottomComponent$tryShowShareLongImageButton$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        ChatShareBottomComponent r6 = this.this$0;
        r6.M = BuildersKt.async$default(r10, Dispatchers.getIO(), null, new AnonymousClass1(this.this$0, null), 2, null);
        ChatShareBottomComponent r7 = this.this$0;
        r7.N = BuildersKt.async$default(r10, Dispatchers.getMain(), null, new AnonymousClass2(this.this$0, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
