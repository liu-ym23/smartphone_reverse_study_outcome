package com.obric.assistant.special_input.instruction;

import com.google.gson.Gson;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import com.obric.aiagent.assistant.idl.bean.ShortcutRecommendItem;
import com.obric.aiagent.assistant.idl.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/special_input/instruction/PanelInstructionItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadShortcutItems$2", f = "PanelInstructionLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PanelInstructionLoader$loadShortcutItems$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PanelInstructionItem>>, Object> {
    final /* synthetic */ int $limit;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PanelInstructionLoader this$0;

    public PanelInstructionLoader$loadShortcutItems$2(int r1, PanelInstructionLoader r2, Continuation<? super PanelInstructionLoader$loadShortcutItems$2> r3) {
        this.$limit = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        PanelInstructionLoader$loadShortcutItems$2 r0 = new PanelInstructionLoader$loadShortcutItems$2(this.$limit, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<PanelInstructionItem>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L46;
        ResultKt.throwOnFailure(r21);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        int r1 = this.$limit;
        PanelInstructionLoader r2 = this.this$0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L36
        IAgentTaskAppIDL r4 = s.a(Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class));     // Catch: Throwable -> L36
        if (r4 == null) goto L8;
        List r5 = r4.getShortcutRecommendItems(r1);     // Catch: Throwable -> L36
    L9:
        if (r5 != null) goto L11;
        r5 = CollectionsKt.emptyList();     // Catch: Throwable -> L36
    L11:
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L36
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L36
    L13:
        if (r7.hasNext() == false) goto L34;
        ShortcutRecommendItem r8 = (ShortcutRecommendItem) r7.next();     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L36
        Lazy<Gson> r9 = PanelInstructionLoader.i;     // Catch: Throwable -> L36
        r2.getClass();     // Catch: Throwable -> L36
        String r10 = r8.getDisplayText();     // Catch: Throwable -> L36
        boolean r11 = true;
        if ((!StringsKt.isBlank(r10)) == false) goto L17;
        String r12 = r10;
    L18:
        if (r12 != null) goto L21;
        PanelInstructionItem r13 = null;
    L32:
        if (r13 == null) goto L13;
        r6.add(r13);     // Catch: Throwable -> L36
        goto L13
    L21:
        if (r8.isShortInstructEnable() == false) goto L30;
        String r14 = r8.getShortQuery();     // Catch: Throwable -> L36
        if (r14 != null) goto L25;
    L28:
        if (r11 == true) goto L30;
        PanelInstructionType r15 = PanelInstructionType.SHORTCUT_SHORT;     // Catch: Throwable -> L36
    L31:
        r13 = new PanelInstructionItem(r8.getTaskId(), r12, r12, r15, null, null, r8.getCreateTime(), 48, null);     // Catch: Throwable -> L36
        goto L32
    L25:
        if (StringsKt.isBlank(r14) == true) goto L28;
        r11 = false;
    L30:
        r15 = PanelInstructionType.SHORTCUT;     // Catch: Throwable -> L36
        goto L31
    L17:
        r12 = null;
        goto L18
    L34:
        Object r16 = Result.constructor-impl(r6);     // Catch: Throwable -> L36
    L38:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L41;
        FLogger.a.e("PanelInstructionLoader", "loadShortcutItems failed: " + r17.getMessage());
    L41:
        List r18 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r16) == true) goto L44;
        return r16;
    L44:
        return r18;
    L8:
        r5 = null;
    L36:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L46:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
