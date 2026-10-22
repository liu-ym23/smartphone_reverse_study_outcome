package com.larus.bmhome.chat.list.cell.edu_continue_shot;

import com.larus.bmhome.chat.api.h0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.share.IChatMessageShareAbility;
import com.larus.bmhome.chat.layout.item.v;
import com.larus.bmhome.chat.layout.item.w;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.e1;
import com.larus.utils.o0;
import ic8.n;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.edu_continue_shot.EduContinueShotCell$onBindView$1", f = "EduContinueShotCell.kt", i = {}, l = {67, 72}, m = "invokeSuspend", n = {}, s = {})
final class EduContinueShotCell$onBindView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<BotModel> $bot;
    final /* synthetic */ Message $data;
    int label;
    final /* synthetic */ EduContinueShotCell this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.edu_continue_shot.EduContinueShotCell$onBindView$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.list.cell.edu_continue_shot.EduContinueShotCell$onBindView$1$1", f = "EduContinueShotCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $data;
        int label;
        final /* synthetic */ EduContinueShotCell this$0;

        public AnonymousClass1(EduContinueShotCell r1, Message r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$data = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$data, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r5);
            EduContinueShotCell r6 = this.this$0;
            w r0 = r6.e;
            if (r0 == null) goto L14;
            final Message r1 = this.$data;
            final q0 r7 = lf8.a.b(r6);
            IChatMessageShareAbility r2 = (IChatMessageShareAbility) this.this$0.f.getValue();
            if (r2 == null) goto L11;
            final boolean r3 = true;
            if (r2.H1() != true) goto L11;
        L12:
            Intrinsics.checkNotNullParameter(r1, "message");
            e1.d(r0.p.b, new v(r3, r7, r1));
        L11:
            r3 = false;
        L14:
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public EduContinueShotCell$onBindView$1(Ref.ObjectRef<BotModel> r1, EduContinueShotCell r2, Message r3, Continuation<? super EduContinueShotCell$onBindView$1> r4) {
        this.$bot = r1;
        this.this$0 = r2;
        this.$data = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new EduContinueShotCell$onBindView$1(this.$bot, this.this$0, this.$data, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r75) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r75);
    L35:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r75);
        Object r3 = r75;
    L22:
        List r4 = (List) r3;
        if (r4 == null) goto L25;
        String r5 = (String) CollectionsKt.firstOrNull(r4);
    L26:
        if (r5 != null) goto L28;
        r5 = "";
    L28:
        String r7 = r5;
        if (o0.d(r7) == false) goto L31;
        Ref.ObjectRef<BotModel> r6 = this.$bot;
        r6.element = BotModel.copy$default((BotModel) r6.element, r7, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, Integer.MAX_VALUE, null);
    L31:
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass1 r9 = new AnonymousClass1(this.this$0, this.$data, null);
        this.label = 2;
        if (BuildersKt.withContext(r8, r9, this) != r1) goto L35;
        return r1;
    L25:
        r5 = null;
        goto L26
    L10:
        ResultKt.throwOnFailure(r75);
        if (Intrinsics.areEqual(((BotModel) this.$bot.element).getBotId(), "unknown") == false) goto L31;
        q0 r10 = lf8.a.b(this.this$0);
        if (r10 == null) goto L17;
        h0 r11 = r10.A7();
        if (r11 == null) goto L17;
        wc9.e r12 = (wc9.e) r11.invoke();
    L18:
        if (r12 == null) goto L25;
        this.label = 1;
        r3 = n.c(r12, this);
        if (r3 != r1) goto L22;
        return r1;
    L17:
        r12 = null;
        goto L18
    }
}
