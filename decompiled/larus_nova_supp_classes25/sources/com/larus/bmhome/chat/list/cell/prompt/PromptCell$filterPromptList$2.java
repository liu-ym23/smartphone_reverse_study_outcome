package com.larus.bmhome.chat.list.cell.prompt;

import android.view.View;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.RuleRequestParamRequest;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.item.PromptSpan;
import com.larus.bmhome.chat.model.prompt.PromptRulesRepo;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell$filterPromptList$2", f = "PromptCell.kt", i = {1, 1, 1}, l = {1210, 1233}, m = "invokeSuspend", n = {"hitIdSet", "hitContentSet", "isFilterApplied"}, s = {"L$0", "L$1", "L$2"})
final class PromptCell$filterPromptList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ int $promptType;
    final /* synthetic */ List<String> $requestItemIds;
    final /* synthetic */ List<RuleRequestParamRequest> $requestParamList;
    final /* synthetic */ List<Pair<View, PromptSpan.a.C0062a>> $viewListToFilter;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ PromptCell this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.list.cell.prompt.PromptCell$filterPromptList$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell$filterPromptList$2$3", f = "PromptCell.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $data;
        final /* synthetic */ Set<String> $hitIdSet;
        final /* synthetic */ Set<View> $hitViews;
        final /* synthetic */ Ref.BooleanRef $isFilterApplied;
        final /* synthetic */ List<String> $requestItemIds;
        int label;
        final /* synthetic */ PromptCell this$0;

        public AnonymousClass3(PromptCell r1, Message r2, List<String> r3, Set<View> r4, Set<String> r5, Ref.BooleanRef r6, Continuation<? super AnonymousClass3> r7) {
            this.this$0 = r1;
            this.$data = r2;
            this.$requestItemIds = r3;
            this.$hitViews = r4;
            this.$hitIdSet = r5;
            this.$isFilterApplied = r6;
            super(2, r7);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass3(this.this$0, this.$data, this.$requestItemIds, this.$hitViews, this.$hitIdSet, this.$isFilterApplied, r10);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r5);
            if (Intrinsics.areEqual(this.this$0.I, this.$data.getMessageId()) == false) goto L31;
            PromptSpan r6 = this.this$0.e;
            PromptSpan r1 = null;
            if (r6 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("span");
            r6 = null;
        L9:
            ArrayList<Pair<View, PromptSpan.a.C0062a>> r7 = r6.getSuggestViewList();
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r8 = r7.iterator();
        L11:
            if (r8.hasNext() == false) goto L20;
            PromptSpan.a.C0062a r3 = (PromptSpan.a.C0062a) ((Pair) r8.next()).getSecond();
            if (r3 == null) goto L15;
            String r4 = r3.b;
        L16:
            if (r4 != null) goto L18;
            r4 = "";
        L18:
            r2.add(r4);
            goto L11
        L15:
            r4 = null;
            goto L16
        L20:
            if (Intrinsics.areEqual(r2, this.$requestItemIds) == false) goto L31;
            Iterator<T> r9 = this.$hitViews.iterator();
        L23:
            if (r9.hasNext() == false) goto L25;
            com.larus.utils.e1.o((View) r9.next());
            goto L23
        L25:
            PromptSpan r10 = this.this$0.e;
            if (r10 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("span");
        L29:
            r1.r.addAll(this.$hitIdSet);
            this.$isFilterApplied.element = true;
            goto L31
        L28:
            r1 = r10;
        L31:
            return Unit.INSTANCE;
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public PromptCell$filterPromptList$2(List<RuleRequestParamRequest> r1, int r2, Message r3, PromptCell r4, List<Pair<View, PromptSpan.a.C0062a>> r5, List<String> r6, Continuation<? super PromptCell$filterPromptList$2> r7) {
        this.$requestParamList = r1;
        this.$promptType = r2;
        this.$data = r3;
        this.this$0 = r4;
        this.$viewListToFilter = r5;
        this.$requestItemIds = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new PromptCell$filterPromptList$2(this.$requestParamList, this.$promptType, this.$data, this.this$0, this.$viewListToFilter, this.$requestItemIds, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$2;
        Set r3 = (Set) this.L$1;
        Set r4 = (Set) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L71
    L66:
        if (r4.size() <= 0) goto L74;
        if (r2.element == false) goto L74;
        int r16 = gx9.o.a;     // Catch: Exception -> L71
        String r5 = this.$data.getMessageId();     // Catch: Exception -> L71
        String r6 = this.$data.getSenderId();     // Catch: Exception -> L71
        String r7 = com.larus.bmhome.chat.bean.d.Z0(this.$data);     // Catch: Exception -> L71
        Integer r8 = Boxing.boxInt(r4.size());     // Catch: Exception -> L71
        String r9 = r4.toString();     // Catch: Exception -> L71
        String r10 = r3.toString();     // Catch: Exception -> L71
        PromptCell r17 = this.this$0;     // Catch: Exception -> L71
        Keva r11 = PromptCell.Y;     // Catch: Exception -> L71
        gx9.o.i(de8.d.a(r17.y()), "onDevHideOnBoardingSuggest", new gx9.f(r6, r5, r7, r8, r9, r10));     // Catch: Exception -> L71
    L74:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r15);
    L15:
        List r18 = (List) r15;
        List r12 = r18;
        if (r12 != null) goto L18;
    L21:
        boolean r13 = true;
    L22:
        if (r13 == true) goto L24;
        LinkedHashSet r14 = new LinkedHashSet();     // Catch: Exception -> L71
        LinkedHashSet r19 = new LinkedHashSet();     // Catch: Exception -> L71
        LinkedHashSet r20 = new LinkedHashSet();     // Catch: Exception -> L71
        Ref.BooleanRef r110 = new Ref.BooleanRef();     // Catch: Exception -> L71
        ArrayList r21 = new ArrayList();     // Catch: Exception -> L71
        Iterator r111 = r18.iterator();     // Catch: Exception -> L71
    L27:
        if (r111.hasNext() == false) goto L31;
        Object r22 = r111.next();     // Catch: Exception -> L71
        if (Intrinsics.areEqual(((ic8.r0) r22).c(), Boxing.boxBoolean(true)) == false) goto L27;
        r21.add(r22);     // Catch: Exception -> L71
        goto L27
    L31:
        List<Pair<View, PromptSpan.a.C0062a>> r112 = this.$viewListToFilter;     // Catch: Exception -> L71
        Iterator r23 = r21.iterator();     // Catch: Exception -> L71
    L33:
        if (r23.hasNext() == false) goto L61;
        ic8.r0 r24 = (ic8.r0) r23.next();     // Catch: Exception -> L71
        Iterator<T> r25 = r112.iterator();     // Catch: Exception -> L71
    L36:
        if (r25.hasNext() == false) goto L33;
        Pair r26 = (Pair) r25.next();     // Catch: Exception -> L71
        PromptSpan.a.C0062a r27 = (PromptSpan.a.C0062a) r26.getSecond();     // Catch: Exception -> L71
        String r28 = r24.a();     // Catch: Exception -> L71
        String r113 = null;
        if (r27 == null) goto L40;
        String r114 = r27.b;     // Catch: Exception -> L71
    L42:
        if (Intrinsics.areEqual(r28, r114) == true) goto L44;
    L45:
        String r29 = r24.b();     // Catch: Exception -> L71
        if (r27 == null) goto L49;
        r113 = r27.a;     // Catch: Exception -> L71
    L49:
        if (Intrinsics.areEqual(r29, r113) == false) goto L36;
        if (com.larus.utils.o0.d(r24.b()) == false) goto L36;
    L52:
        if (r27 == null) goto L56;
        String r30 = r27.b;     // Catch: Exception -> L71
        if (r30 == null) goto L56;
        Boxing.boxBoolean(r14.add(r30));     // Catch: Exception -> L71
    L56:
        if (r27 == null) goto L60;
        String r31 = r27.a;     // Catch: Exception -> L71
        if (r31 == null) goto L60;
        Boxing.boxBoolean(r19.add(r31));     // Catch: Exception -> L71
    L60:
        r20.add(r26.getFirst());     // Catch: Exception -> L71
        goto L36
    L44:
        if (com.larus.utils.o0.d(r24.a()) == true) goto L52;
    L40:
        r114 = null;
        goto L42
    L61:
        MainCoroutineDispatcher r115 = Dispatchers.getMain();     // Catch: Exception -> L71
        AnonymousClass3 r116 = new AnonymousClass3(this.this$0, this.$data, this.$requestItemIds, r20, r14, r110, null);     // Catch: Exception -> L71
        this.L$0 = r14;     // Catch: Exception -> L71
        this.L$1 = r19;     // Catch: Exception -> L71
        this.L$2 = r110;     // Catch: Exception -> L71
        this.label = 2;     // Catch: Exception -> L71
        if (BuildersKt.withContext(r115, r116, this) != r0) goto L64;
        return r0;
    L64:
        r4 = r14;
        r3 = r19;
        r2 = r110;
        goto L66
    L24:
        return Unit.INSTANCE;
    L18:
        if (r12.isEmpty() == true) goto L21;
        r13 = false;
        goto L22
    L12:
        ResultKt.throwOnFailure(r15);
        PromptRulesRepo r117 = PromptRulesRepo.a;
        List<RuleRequestParamRequest> r32 = this.$requestParamList;
        int r33 = this.$promptType;
        this.label = 1;
        r15 = r117.a(r32, r33, this);
        if (r15 != r0) goto L15;
        return r0;
    L71:
        e = move-exception;
        FLogger.a.e("WcbSugPromptCell", "filterPromptList failed, e: " + e.getMessage());
        goto L74
    }
}
