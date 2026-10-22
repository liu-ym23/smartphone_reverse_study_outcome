package com.larus.avlink.env.diary.detail;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailFragment$onViewCreated$5$1", f = "DoraEnvObserveDiaryDetailFragment.kt", i = {}, l = {DoraCallStateCode.DOUBAO_CMD_13}, m = "invokeSuspend", n = {}, s = {})
public final class DoraEnvObserveDiaryDetailFragment$onViewCreated$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i98.a $it;
    int label;
    final /* synthetic */ DoraEnvObserveDiaryDetailFragment this$0;

    public DoraEnvObserveDiaryDetailFragment$onViewCreated$5$1(DoraEnvObserveDiaryDetailFragment r1, i98.a r2, Continuation<? super DoraEnvObserveDiaryDetailFragment$onViewCreated$5$1> r3) {
        this.this$0 = r1;
        this.$it = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraEnvObserveDiaryDetailFragment$onViewCreated$5$1(this.this$0, this.$it, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
    L73:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        DoraEnvObserveDiaryDetailFragment r4 = this.this$0;
        i98.a r5 = this.$it;
        Intrinsics.checkNotNull(r5);
        this.label = 1;
        int r6 = DoraEnvObserveDiaryDetailFragment.k;
        r4.getClass();
        ArrayList r7 = new ArrayList();
        String r8 = r5.e();
        if (r8 == null) goto L13;
        Long r9 = StringsKt.toLongOrNull(r8);
        if (r9 == null) goto L13;
        long r10 = r9.longValue();
    L15:
        if (r10 <= 0) goto L25;
        String r13 = ia8.d.a(r10);
        String r14 = ia8.d.e(r10);
        String r15 = ia8.d.d(r10);
        l98.b r11 = r5.g();
        if (r11 == null) goto L19;
        String r16 = r11.b();
    L20:
        l98.b r12 = r5.g();
        if (r12 == null) goto L23;
        String r17 = r12.a();
    L24:
        r7.add(new g.b(r13, r14, r15, r16, r17));
        goto L25
    L23:
        r17 = null;
        goto L24
    L19:
        r16 = null;
    L25:
        String r18 = r5.m();
        int r110 = 0;
        if (r18 != null) goto L28;
    L31:
        boolean r20 = true;
    L32:
        if (r20 == true) goto L34;
        r7.add(new g.e(r5.m()));
    L34:
        int r21 = ia8.d.a;
        boolean r22 = ia8.d.f(r5.e());
        boolean r111 = r4.U90().isEnvObserveEnable();
        if (r22 == false) goto L54;
        if (r111 == false) goto L54;
        boolean r23 = r4.U90().inEnvObserveScene();
        String r112 = r5.j();
        if (r112 == null) goto L42;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L42;
        long r114 = r113.longValue();
    L44:
        if (r23 == true) goto L46;
    L48:
        r3 = false;
    L50:
        if (r114 <= 0) goto L52;
        String r24 = ia8.d.c(r114);
    L53:
        r7.add(new g.d(r3, r24));
        goto L54
    L52:
        r24 = null;
        goto L53
    L46:
        if (r114 <= 0) goto L48;
    L42:
        r114 = 0;
    L54:
        List<Block> r25 = r5.c();
        if (r25 == null) goto L60;
        Iterator<T> r26 = r25.iterator();
    L58:
        if (r26.hasNext() == false) goto L60;
        r7.add(new g.a((Block) r26.next()));
    L60:
        String r27 = r5.i();
        if (r27 != null) goto L63;
        r27 = "";
    L63:
        DoraEnvObserveDiaryDetailViewModel r28 = r4.U90();
        Integer r29 = r5.b();
        if (r29 == null) goto L66;
        r110 = r29.intValue();
    L66:
        r7.add(new g.c(r27, new j98.c(r28.getDisplayedFeedbackActionType(r110), 7)));
        Object r30 = BuildersKt.withContext(Dispatchers.getMain(), new DoraEnvObserveDiaryDetailFragment$updateRecyclerViewData$3(r4, r7, null), this);
        if (r30 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L70;
        r30 = Unit.INSTANCE;
    L70:
        if (r30 != r1) goto L73;
        return r1;
    L28:
        if (r18.length() == 0) goto L31;
        r20 = false;
    L13:
        r10 = 0;
        goto L15
    }
}
