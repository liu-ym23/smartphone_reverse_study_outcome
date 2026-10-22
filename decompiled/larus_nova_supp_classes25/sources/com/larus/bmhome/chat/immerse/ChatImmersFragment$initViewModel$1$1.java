package com.larus.bmhome.chat.immerse;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusPageChatImmersiveBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.immerse.ChatImmersFragment$initViewModel$1$1", f = "ChatImmersFragment.kt", i = {}, l = {718}, m = "invokeSuspend", n = {}, s = {})
final class ChatImmersFragment$initViewModel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RecommendBot> $it;
    int label;
    final /* synthetic */ ChatImmersFragment this$0;

    public ChatImmersFragment$initViewModel$1$1(ChatImmersFragment r1, List<RecommendBot> r2, Continuation<? super ChatImmersFragment$initViewModel$1$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatImmersFragment$initViewModel$1$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.larus.bmhome.chat.immerse.p, java.lang.Object] */
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        final List r7 = (List) r6;
        ChatImmersFragment r2 = this.this$0;
        int r3 = ChatImmersFragment.I;
        r2.da0();
        final ChatImmersFragment r4 = this.this$0;
        final ?? r5 = new p(r4, r7);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "action");
        LarusPageChatImmersiveBinding r8 = r4.j;
        RecyclerView r9 = null;
        if (r8 == null) goto L16;
        ViewPager2 r10 = r8.c;
        if (r10 == null) goto L16;
        View r11 = r10.getChildAt(0);
    L18:
        if ((r11 instanceof RecyclerView) == false) goto L20;
        r9 = (RecyclerView) r11;
    L20:
        bh8.d.a(r9, new c(r4, r5));
        ChatImmersViewModel r12 = this.this$0.ba0();
        if (r12 == null) goto L23;
        r12.setRefresh(false);
    L23:
        Function0<Unit> r13 = this.this$0.y;
        if (r13 == null) goto L26;
        r13.invoke();
    L26:
        final ChatImmersFragment r14 = this.this$0;
        LarusPageChatImmersiveBinding r15 = r14.j;
        if (r15 == null) goto L31;
        ConstraintLayout r16 = r15.f;
        if (r16 == null) goto L31;
        Boxing.boxBoolean(r16.postDelayed(new q(r14), 300));
    L31:
        final ChatImmersFragment r17 = this.this$0;
        LarusPageChatImmersiveBinding r18 = r17.j;
        if (r18 == null) goto L37;
        ViewPager2 r19 = r18.c;
        if (r19 == null) goto L37;
        Boxing.boxBoolean(r19.postDelayed(new r(r17), 1000));
    L37:
        return Unit.INSTANCE;
    L16:
        r11 = null;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        ChatImmersFragment r20 = this.this$0;
        List<RecommendBot> r21 = this.$it;
        Intrinsics.checkNotNull(r21);
        this.label = 1;
        r6 = ChatImmersFragment.Y90(r20, r21, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
