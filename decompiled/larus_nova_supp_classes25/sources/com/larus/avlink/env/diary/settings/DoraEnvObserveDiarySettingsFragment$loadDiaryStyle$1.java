package com.larus.avlink.env.diary.settings;

import com.larus.avlink.impl.databinding.LarusFragmentDoraEnvObserveDiarySettingsBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.env.diary.settings.DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1", f = "DoraEnvObserveDiarySettingsFragment.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
final class DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraEnvObserveDiarySettingsFragment this$0;

    public DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1(DoraEnvObserveDiarySettingsFragment r1, Continuation<? super DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1(this.this$0, r3);
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
    L11:
        dm9.a.b r8 = (dm9.a) r7;
        String r2 = "";
        if ((r8 instanceof dm9.a.b) == false) goto L42;
        m98.c r9 = (m98.c) r8.a.getData();
        if (r9 == null) goto L29;
        List<m98.b> r10 = r9.b();
        if (r10 == null) goto L29;
        List r11 = CollectionsKt.filterNotNull(r10);
        if (r11 == null) goto L29;
        Iterator r12 = r11.iterator();
    L21:
        if (r12.hasNext() == false) goto L25;
        Object r3 = r12.next();
        if (Intrinsics.areEqual(((m98.b) r3).f(), Boxing.boxBoolean(true)) == false) goto L21;
    L26:
        m98.b r4 = (m98.b) r3;
        if (r4 == null) goto L29;
        String r13 = r4.d();
    L30:
        if (r13 == null) goto L34;
        r2 = r13;
    L34:
        if (r2.length() <= 8) goto L36;
        r2 = r2.substring(0, 8) + "...";
    L36:
        LarusFragmentDoraEnvObserveDiarySettingsBinding r14 = this.this$0.e;
        if (r14 == null) goto L49;
        ItemTextArrow r15 = r14.c;
        if (r15 == null) goto L49;
        int r5 = ItemTextArrow.k;
        r15.Z5(r2, null);
    L49:
        return Unit.INSTANCE;
    L25:
        r3 = null;
    L29:
        r13 = null;
        goto L30
    L42:
        if ((r8 instanceof dm9.a.a) == false) goto L51;
        FLogger.a.e(this.this$0.g, "loadDiaryStyle failed: " + ((dm9.a.a) r8).b);
        LarusFragmentDoraEnvObserveDiarySettingsBinding r16 = this.this$0.e;
        if (r16 == null) goto L49;
        ItemTextArrow r17 = r16.c;
        if (r17 == null) goto L49;
        int r6 = ItemTextArrow.k;
        r17.Z5("", null);
        goto L49
    L51:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r18 = Dispatchers.getIO();
        DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1 r19 = new DoraEnvObserveDiarySettingsFragment$loadDiaryStyle$1$result$1(this.this$0, null);
        this.label = 1;
        r7 = BuildersKt.withContext(r18, r19, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
