package com.larus.doc.impl.offline;

import com.larus.doc.impl.operation.DocOpManager;
import com.larus.network.bean.BizResponse;
import com.larus.office.OfflineDocReportGate;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tx9.u0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.offline.OfflineDocCreateComponent$executeCreateDocByMessage$1", f = "OfflineDocCreateComponent.kt", i = {1, 1, 1}, l = {421, 446}, m = "invokeSuspend", n = {"result", "resourceId", "resultResourceType"}, s = {"L$0", "L$1", "I$0"})
final class OfflineDocCreateComponent$executeCreateDocByMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $createDocByMessageState;
    final /* synthetic */ String $failReason;
    final /* synthetic */ a $snapshot;
    final /* synthetic */ String $trigger;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OfflineDocCreateComponent this$0;

    /* JADX INFO: renamed from: com.larus.doc.impl.offline.OfflineDocCreateComponent$executeCreateDocByMessage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.doc.impl.offline.OfflineDocCreateComponent$executeCreateDocByMessage$1$1", f = "OfflineDocCreateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $docCardMessageId;
        final /* synthetic */ int $resultResourceType;
        final /* synthetic */ a $snapshot;
        int label;
        final /* synthetic */ OfflineDocCreateComponent this$0;

        public AnonymousClass1(OfflineDocCreateComponent r1, int r2, String r3, a r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$resultResourceType = r2;
            this.$docCardMessageId = r3;
            this.$snapshot = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$resultResourceType, this.$docCardMessageId, this.$snapshot, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L17;
            ResultKt.throwOnFailure(r4);
            d r5 = this.this$0.r;
            if (r5 != null) goto L7;
            return null;
        L7:
            if (r5.PM() == true) goto L10;
            r5 = null;
        L10:
            if (r5 == null) goto L19;
            int r0 = this.$resultResourceType;
            String r1 = this.$docCardMessageId;
            if (r1 != null) goto L14;
            r1 = String.valueOf(this.$snapshot.b);
        L14:
            r5.gH(r0, r1);
            return Unit.INSTANCE;
        L19:
            return null;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public OfflineDocCreateComponent$executeCreateDocByMessage$1(a r1, String r2, OfflineDocCreateComponent r3, b r4, String r5, Continuation<? super OfflineDocCreateComponent$executeCreateDocByMessage$1> r6) {
        this.$snapshot = r1;
        this.$trigger = r2;
        this.this$0 = r3;
        this.$createDocByMessageState = r4;
        this.$failReason = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new OfflineDocCreateComponent$executeCreateDocByMessage$1(this.$snapshot, this.$trigger, this.this$0, this.$createDocByMessageState, this.$failReason, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r13 = false;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        int r1 = this.I$0;
        String r2 = (String) this.L$1;
        dm9.a r3 = (dm9.a) this.L$0;
        ResultKt.throwOnFailure(r22);
    L64:
        OfflineDocCreateComponent r4 = this.this$0;
        a r5 = this.$snapshot;
        b r6 = this.$createDocByMessageState;
        int r7 = OfflineDocCreateComponent.v;
        r4.getClass();
        if (r6.a == CreateDocByMessageActionType.COMPENSATE) goto L67;
    L71:
        boolean r8 = false;
    L73:
        if (r2.length() <= 0) goto L75;
        boolean r10 = true;
    L76:
        if (r10 == false) goto L80;
        if (r8 == true) goto L80;
        DocOpManager r11 = DocOpManager.a;
        DocOpManager.l(r2, this.$snapshot.e, r1);
    L84:
        dm9.a.b r12 = (dm9.a.b) r3;
        if (r12.a.getCode() == 0) goto L92;
        u0.b("create_doc_failed_" + r12.a.getCode(), null, 6);
    L92:
        return Unit.INSTANCE;
    L80:
        if (r2.length() <= 0) goto L82;
        r13 = true;
    L82:
        if (r13 == false) goto L84;
        FLogger.a.i("OfflineDocCreateComponent", "[updateDocumentBrief] skip after compensate create with realToken and useMessageContent=false");
        goto L84
    L75:
        r10 = false;
        goto L76
    L67:
        if (r6.b == false) goto L71;
        if (Intrinsics.areEqual(r5.g, Boolean.FALSE) == false) goto L71;
        r8 = true;
        goto L73
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r22);
        Object r14 = r22;
    L13:
        r3 = (dm9.a) r14;
        int r15 = m39.b.a;
        String r16 = this.$trigger;
        Intrinsics.checkNotNullParameter(r16, "trigger");
        m39.b.a("创建消息卡片完成, 当前阶段:" + r16 + ", 结果:" + r3);
        boolean r17 = r3 instanceof dm9.a.b;
        if (r17 == false) goto L16;
        dm9.a.b r18 = (dm9.a.b) r3;
    L17:
        if (r18 == null) goto L21;
        BizResponse r20 = r18.a;
        if (r20 == null) goto L21;
        Long r21 = Boxing.boxLong(r20.getCode());
    L22:
        if (r18 == null) goto L28;
        BizResponse r23 = r18.a;
        if (r23 == null) goto L28;
        com.larus.office.card.doc.create.b r24 = (com.larus.office.card.doc.create.b) r23.getData();
        if (r24 == null) goto L28;
        String r25 = r24.a();
    L29:
        OfflineDocReportGate r26 = OfflineDocReportGate.a;
        f r110 = this.this$0.n;
        if (r110 == null) goto L32;
        String r111 = r110.a;
    L33:
        if (r18 == null) goto L35;
        boolean r27 = true;
    L36:
        r26.getClass();
        OfflineDocReportGate.a(r111, r27, r21, r25);
        if (r17 == false) goto L87;
        dm9.a.b r28 = (dm9.a.b) r3;
        com.larus.office.card.doc.create.b r30 = (com.larus.office.card.doc.create.b) r28.a.getData();
        if (r30 == null) goto L49;
        Integer r31 = Boxing.boxInt(r30.c());
        if (r31.intValue() == 0) goto L43;
        boolean r32 = true;
    L44:
        if (r32 == true) goto L47;
        r31 = null;
    L47:
        if (r31 == null) goto L49;
        int r33 = r31.intValue();
    L50:
        com.larus.office.card.doc.create.b r34 = (com.larus.office.card.doc.create.b) r28.a.getData();
        if (r34 == null) goto L53;
        String r35 = r34.b();
    L54:
        if (r35 != null) goto L56;
        r35 = "";
    L56:
        com.larus.office.card.doc.create.b r36 = (com.larus.office.card.doc.create.b) r28.a.getData();
        if (r36 == null) goto L59;
        String r112 = r36.a();
    L60:
        MainCoroutineDispatcher r37 = Dispatchers.getMain();
        AnonymousClass1 r38 = new AnonymousClass1(this.this$0, r33, r112, this.$snapshot, null);
        this.L$0 = r3;
        this.L$1 = r35;
        this.I$0 = r33;
        this.label = 2;
        if (BuildersKt.withContext(r37, r38, this) != r9) goto L63;
        return r9;
    L63:
        r1 = r33;
        r2 = r35;
        goto L64
    L59:
        r112 = null;
        goto L60
    L53:
        r35 = null;
        goto L54
    L43:
        r32 = false;
    L49:
        r33 = this.$snapshot.c;
        goto L50
    L87:
        String r40 = this.$trigger;
        Intrinsics.checkNotNullParameter(r40, "trigger");
        m39.b.a("创建消息卡片异常, 当前阶段:" + r40 + ", 结果:" + r3);
        String r41 = this.$failReason;
        if (r41 != null) goto L90;
        r41 = "create_doc_failed";
    L90:
        u0.b(r41, null, 6);
        goto L92
    L35:
        r27 = false;
        goto L36
    L32:
        r111 = null;
    L28:
        r25 = null;
    L21:
        r21 = null;
        goto L22
    L16:
        r18 = null;
        goto L17
    L10:
        ResultKt.throwOnFailure(r22);
        int r42 = com.larus.office.card.doc.create.c.a;
        a r43 = this.$snapshot;
        String r44 = r43.a;
        long r45 = r43.b;
        int r46 = r43.c;
        int r47 = r43.d;
        String r48 = r43.f;
        Boolean r50 = r43.g;
        this.label = 1;
        r14 = com.larus.office.card.doc.create.c.a(r44, r45, r46, r47, r48, r50, this);
        if (r14 != r9) goto L13;
        return r9;
    }
}
