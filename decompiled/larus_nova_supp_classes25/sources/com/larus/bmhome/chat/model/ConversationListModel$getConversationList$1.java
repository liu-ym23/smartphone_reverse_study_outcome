package com.larus.bmhome.chat.model;

import android.os.SystemClock;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$getConversationList$1", f = "ConversationListModel.kt", i = {0, 0, 0, 1, 1, 2}, l = {724, 735, 741}, m = "invokeSuspend", n = {"preLoadConvList", "awaitConvListDuration", "startTime", "preLoadConvList", "startTime", "preLoadConvList"}, s = {"L$0", "L$1", "J$0", "L$0", "J$0", "L$0"})
public final class ConversationListModel$getConversationList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $source;
    long J$0;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.ConversationListModel$getConversationList$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$getConversationList$1$1", f = "ConversationListModel.kt", i = {}, l = {725}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.LongRef $awaitConvListDuration;
        final /* synthetic */ Ref.ObjectRef<List<wc9.l>> $preLoadConvList;
        final /* synthetic */ long $startTime;
        Object L$0;
        int label;

        public AnonymousClass1(Ref.ObjectRef<List<wc9.l>> r1, Ref.LongRef r2, long r3, Continuation<? super AnonymousClass1> r5) {
            this.$preLoadConvList = r1;
            this.$awaitConvListDuration = r2;
            this.$startTime = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$preLoadConvList, this.$awaitConvListDuration, this.$startTime, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            Integer r3 = null;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Ref.ObjectRef<List<wc9.l>> r2 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r8);
        L14:
            Ref.ObjectRef<List<wc9.l>> r6 = r2;
            List r4 = (List) r8;
            Ref.ObjectRef<List<wc9.l>> r9 = r6;
        L16:
            r9.element = r4;
            this.$awaitConvListDuration.element = SystemClock.elapsedRealtime() - this.$startTime;
            CompletableDeferred r10 = wr8.b.a;
            wr8.b.a = null;
            FLogger r11 = FLogger.a;
            StringBuilder r5 = new StringBuilder("preload cvs list size=");
            List r7 = (List) this.$preLoadConvList.element;
            if (r7 == null) goto L19;
            r3 = Boxing.boxInt(r7.size());
        L19:
            r5.append(r3);
            r5.append(", awaitConvListDuration=");
            r5.append(this.$awaitConvListDuration.element);
            r5.append(" ms");
            r11.i("ConversationListModel", r5.toString());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            r9 = this.$preLoadConvList;
            CompletableDeferred r12 = wr8.b.a;
            CompletableDeferred r13 = wr8.b.a;
            if (r13 == null) goto L15;
            this.L$0 = r9;
            this.label = 1;
            Object r14 = r13.await(this);
            if (r14 != r0) goto L13;
            return r0;
        L13:
            r2 = r9;
            r8 = r14;
            goto L14
        L15:
            r4 = null;
            goto L16
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            ConversationListModel r0 = ConversationListModel.a;
            String r1 = this.a;
            r0.getClass();
            Object r6 = ConversationListModel.i(r0, (List) r4, false, ConversationListModel.k(r1, "collectPreload"), r5);
            if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r6;
        L6:
            return Unit.INSTANCE;
        }
    }

    public ConversationListModel$getConversationList$1(String r1, Continuation<? super ConversationListModel$getConversationList$1> r2) {
        this.$source = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ConversationListModel$getConversationList$1(this.$source, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v6, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Object, kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    public final Object invokeSuspend(Object r32) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = this.label;
        String r5 = "ConversationListModel";
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L14;
        if (r3 != 3) goto L8;
        ?? r4 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r32);     // Catch: Throwable -> L12
        r4 = r4;
    L50:
        throw new KotlinNothingValueException();     // Catch: Throwable -> L12
    L12:
        th = th;
        ?? r12 = r4;
    L91:
        ConversationListModel r19 = ConversationListModel.a;
        List r6 = (List) ((Ref.ObjectRef) r12).element;
        if (r6 == null) goto L94;
        int r23 = r6.size();
    L95:
        List r7 = (List) ((Ref.ObjectRef) r12).element;
        if (r7 == null) goto L122;
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L99:
        if (r9.hasNext() == false) goto L121;
        Object r10 = r9.next();
        wc9.l r11 = (wc9.l) r10;
        wc9.e r13 = r11.a;
        if (r13 != null) goto L103;
    L118:
        boolean r14 = true;
    L119:
        if (r14 == true) goto L99;
        r8.add(r10);
        goto L99
    L103:
        if (ic8.n.r(r13) == true) goto L118;
        if (ic8.n.d(r11.a) == true) goto L118;
        wc9.e r15 = r11.a;
        if (r15 == null) goto L114;
        Integer r16 = r15.t;
        if (r16 == null) goto L114;
        if (r16.intValue() != 2) goto L114;
        boolean r17 = true;
    L115:
        if (r17 == true) goto L118;
        r14 = false;
    L114:
        r17 = false;
        goto L115
    L121:
        int r24 = r8.size();
    L123:
        ConversationListModel.w(r19, false, 0, r23, r24, 0, "pre load cov list err. msg=" + th.getMessage(), 18);
        wr8.b.a = null;
        FLogger.a.e(r5, "preload cvs list err=" + th);
        ConversationListModel r0 = ConversationListModel.a;
        String r18 = this.$source;
        r0.getClass();
        ConversationListModel.A(ConversationListModel.k(r18, "preloadError"));
    L125:
        return Unit.INSTANCE;
    L122:
        r24 = 0;
        goto L123
    L94:
        r23 = 0;
        goto L95
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        long r110 = this.J$0;
        Ref.ObjectRef r20 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r32);     // Catch: Throwable -> L89
        String r111 = "ConversationListModel";
        r3 = r20;
    L40:
        CompletableDeferred<Boolean> r21 = ConversationListModel.f;     // Catch: Throwable -> L87
        if (r21 == null) goto L43;
        Boxing.boxBoolean(r21.complete(Boxing.boxBoolean(true)));     // Catch: Throwable -> L87
    L43:
        r5 = r111;
        FLogger.a.i(r5, "conv list total await duration = " + (SystemClock.elapsedRealtime() - r110));     // Catch: Throwable -> L89
        kotlinx.coroutines.flow.a1 r1 = wr8.b.d;     // Catch: Throwable -> L89
        a r22 = new a(this.$source);     // Catch: Throwable -> L89
        this.L$0 = r3;     // Catch: Throwable -> L89
        this.label = 3;     // Catch: Throwable -> L89
        if (r1.collect(r22, this) != r2) goto L48;
        return r2;
    L48:
        r4 = r3;
    L87:
        th = th;
        r5 = r111;
    L90:
        r12 = r3;
        goto L91
    L17:
        long r112 = this.J$0;
        Ref.LongRef r25 = (Ref.LongRef) this.L$1;
        r12 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r32);     // Catch: Throwable -> L20
        r111 = "ConversationListModel";
        Ref.LongRef r113 = r25;
        ?? r26 = r12;
        long r114 = r112;
    L28:
        Collection r27 = (Collection) ((Ref.ObjectRef) r26).element;     // Catch: Throwable -> L87
        if (r27 != null) goto L31;
    L34:
        boolean r28 = true;
    L35:
        if (r28 == true) goto L53;
        ConversationListModel r29 = ConversationListModel.a;     // Catch: Throwable -> L87
        ConversationListModel.v = wr8.b.b;     // Catch: Throwable -> L87
        ConversationListModel r30 = ConversationListModel.a;     // Catch: Throwable -> L87
        List r31 = (List) ((Ref.ObjectRef) r26).element;     // Catch: Throwable -> L87
        String r115 = this.$source;     // Catch: Throwable -> L87
        r30.getClass();     // Catch: Throwable -> L87
        String r116 = ConversationListModel.k(r115, "usePreload");     // Catch: Throwable -> L87
        this.L$0 = r26;     // Catch: Throwable -> L87
        this.L$1 = null;     // Catch: Throwable -> L87
        this.J$0 = r114;     // Catch: Throwable -> L87
        this.label = 2;     // Catch: Throwable -> L87
        if (ConversationListModel.i(r30, r31, true, r116, this) != r2) goto L39;
        return r2;
    L39:
        r110 = r114;
        r3 = r26;
        goto L40
    L53:
        ConversationListModel r117 = ConversationListModel.a;     // Catch: Throwable -> L89
        String r33 = this.$source;     // Catch: Throwable -> L89
        r117.getClass();     // Catch: Throwable -> L89
        ConversationListModel.A(ConversationListModel.k(r33, "preloadEmpty"));     // Catch: Throwable -> L89
        long r118 = r113.element;     // Catch: Throwable -> L89
        List r34 = (List) ((Ref.ObjectRef) r26).element;     // Catch: Throwable -> L89
        if (r34 == null) goto L56;
        int r210 = r34.size();     // Catch: Throwable -> L89
    L57:
        List r35 = (List) ((Ref.ObjectRef) r26).element;     // Catch: Throwable -> L89
        if (r35 == null) goto L84;
        ArrayList r36 = new ArrayList();     // Catch: Throwable -> L89
        Iterator r37 = r35.iterator();     // Catch: Throwable -> L89
    L61:
        if (r37.hasNext() == false) goto L83;
        Object r38 = r37.next();     // Catch: Throwable -> L89
        wc9.l r39 = (wc9.l) r38;     // Catch: Throwable -> L89
        wc9.e r119 = r39.a;     // Catch: Throwable -> L89
        if (r119 != null) goto L65;
    L80:
        boolean r40 = true;
    L81:
        if (r40 == true) goto L61;
        r36.add(r38);     // Catch: Throwable -> L89
        goto L61
    L65:
        if (ic8.n.r(r119) == true) goto L80;
        if (ic8.n.d(r39.a) == true) goto L80;
        wc9.e r41 = r39.a;     // Catch: Throwable -> L89
        if (r41 == null) goto L76;
        Integer r42 = r41.t;     // Catch: Throwable -> L89
        if (r42 == null) goto L76;
        if (r42.intValue() != 2) goto L76;
        boolean r43 = true;
    L77:
        if (r43 == true) goto L80;
        r40 = false;
    L76:
        r43 = false;
        goto L77
    L83:
        int r211 = r36.size();     // Catch: Throwable -> L89
    L85:
        ConversationListModel.w(r117, true, r118, r210, r211, SystemClock.elapsedRealtime() - r114, null, 32);     // Catch: Throwable -> L89
        goto L125
    L84:
        r211 = 0;
        goto L85
    L56:
        r210 = 0;
        goto L57
    L31:
        if (r27.isEmpty() == true) goto L34;
        r28 = false;
    L20:
        th = th;
        goto L91
    L22:
        ResultKt.throwOnFailure(r32);
        r3 = new Ref.ObjectRef();
        r113 = new Ref.LongRef();     // Catch: Throwable -> L89
        r114 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L89
        long r120 = z2.a.getAppLaunchFeedOptConfig().b;     // Catch: Throwable -> L89
        r111 = "ConversationListModel";
        AnonymousClass1 r121 = new AnonymousClass1(r3, r113, r114, null);     // Catch: Throwable -> L87
        this.L$0 = r3;     // Catch: Throwable -> L87
        this.L$1 = r113;     // Catch: Throwable -> L87
        this.J$0 = r114;     // Catch: Throwable -> L87
        this.label = 1;     // Catch: Throwable -> L87
        r26 = r3;
        if (TimeoutKt.b(r120, r121, this) != r2) goto L28;
        return r2;
    L89:
        th = th;
        goto L90
    }
}
