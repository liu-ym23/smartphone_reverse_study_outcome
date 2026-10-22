package com.larus.ugc.feed.impl.ability;

import com.larus.im.internal.delegate.c0;
import com.larus.ugc.feed.api.model.CommonCreationFeedDataKmp;
import com.larus.ugc.feed.api.model.CreationFeedCacheEntityKmp;
import com.larus.ugc.feed.api.model.CreationFeedInitParamsKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.random.RandomKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$requestFirstRecommendList$4", f = "CreationFeedAbilityImpl.kt", i = {0, 0, 0, 0}, l = {614, 658, 667}, m = "invokeSuspend", n = {"$this$launch", "resultData", "requestIndex", "requestRandomSeed"}, s = {"L$0", "L$1", "I$0", "J$0"})
final class CreationFeedAbilityImpl$requestFirstRecommendList$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isMainBottomEnter;
    final /* synthetic */ boolean $isRefresh;
    final /* synthetic */ boolean $isRetry;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CreationFeedAbilityImpl this$0;

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$requestFirstRecommendList$4$7, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl$requestFirstRecommendList$4$7", f = "CreationFeedAbilityImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CreationFeedAbilityImpl this$0;

        public AnonymousClass7(CreationFeedAbilityImpl r1, Continuation<? super AnonymousClass7> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass7(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CreationFeedAbilityImpl r3 = this.this$0;
            r3.l.remove(Boxing.boxInt(r3.g));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CreationFeedAbilityImpl$requestFirstRecommendList$4(CreationFeedAbilityImpl r1, boolean r2, boolean r3, boolean r4, Continuation<? super CreationFeedAbilityImpl$requestFirstRecommendList$4> r5) {
        this.this$0 = r1;
        this.$isMainBottomEnter = r2;
        this.$isRefresh = r3;
        this.$isRetry = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CreationFeedAbilityImpl$requestFirstRecommendList$4 r6 = new CreationFeedAbilityImpl$requestFirstRecommendList$4(this.this$0, this.$isMainBottomEnter, this.$isRefresh, this.$isRetry, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r37) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r10 = true;
        Unit r11 = null;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r37);
    L127:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CreationFeedAbilityImpl r2 = (CreationFeedAbilityImpl) this.L$0;
        ResultKt.throwOnFailure(r37);     // Catch: Throwable -> L13
    L109:
        r11 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L111:
        Object r3 = Result.constructor-impl(r11);     // Catch: Throwable -> L13
    L116:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L127;
        int r5 = CreationFeedAbilityImpl.o;
        r2.getClass();
        c0.b.e("CreationFeedAbilityImpl", "writeFirstCacheData failed: " + r4);
    L13:
        th = th;
        CreationFeedAbilityImpl r6 = r2;
    L115:
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        r2 = r6;
        goto L116
    L15:
        long r8 = this.J$0;
        int r9 = this.I$0;
        Ref.ObjectRef r12 = (Ref.ObjectRef) this.L$2;
        Ref.ObjectRef r13 = (Ref.ObjectRef) this.L$1;
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r37);
        long r15 = r8;
        Object r16 = r37;
    L33:
        Pair r17 = (Pair) r16;
        if (r17 == null) goto L36;
        CommonCreationFeedDataKmp r18 = (CommonCreationFeedDataKmp) r17.getFirst();
    L39:
        r12.element = r18;
        CreationFeedInitParamsKmp r19 = this.this$0.c;
        if (r19 == null) goto L42;
        boolean r20 = Intrinsics.areEqual(r19.getNeedAddReplicaEntrance(), Boxing.boxBoolean(true));
    L43:
        if (r20 == false) goto L59;
        CommonCreationFeedDataKmp r110 = (CommonCreationFeedDataKmp) r13.element;
        if (r110 == null) goto L57;
        this.this$0.getClass();
        List r21 = CollectionsKt.listOf(new UserCreationKmp(com.flow.kmp.common.util.i.a(), 0, 100, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131066, null));
        List<List<UserCreationKmp>> r22 = r110.getCreationGroupList();
        if (r22 != null) goto L49;
    L52:
        boolean r23 = true;
    L53:
        if (r23 == false) goto L55;
        List r24 = CollectionsKt.listOf(r21);
    L56:
        CommonCreationFeedDataKmp r25 = CommonCreationFeedDataKmp.copy$default(r110, false, null, null, r24, null, 23, null);
    L58:
        r13.element = r25;
        goto L59
    L55:
        List r26 = CollectionsKt.createListBuilder();
        r26.add(r21);
        r26.addAll(r22);
        r24 = CollectionsKt.build(r26);
        goto L56
    L49:
        if (r22.isEmpty() == true) goto L52;
        r23 = false;
        goto L53
    L57:
        r25 = null;
    L59:
        CreationFeedAbilityImpl.b(this.this$0, "end requestTemplateRecommendList:" + r13.element);
        Object r27 = r13.element;
        if (r27 == null) goto L120;
        CreationFeedAbilityImpl r28 = this.this$0;
        r28.g++;
        r28.f = r15;
        r28.h = ((CommonCreationFeedDataKmp) r27).getNextCursor();
        this.this$0.u(r9, (CommonCreationFeedDataKmp) r13.element, false, false);
        List<UserCreationKmp> r29 = ((CommonCreationFeedDataKmp) r13.element).getCreationList();
        if (r29 != null) goto L64;
    L67:
        boolean r30 = true;
    L68:
        if (r30 == false) goto L78;
        List<List<UserCreationKmp>> r31 = ((CommonCreationFeedDataKmp) r13.element).getCreationGroupList();
        if (r31 != null) goto L72;
    L75:
        boolean r32 = true;
    L76:
        if (r32 == false) goto L78;
        final boolean r33 = true;
    L80:
        if (this.$isRefresh == false) goto L82;
        this.this$0.b.update(new s(r33));
    L83:
        CreationFeedAbilityImpl r34 = this.this$0;
        StringBuilder r35 = new StringBuilder("creationList size:");
        List r36 = ((CommonCreationFeedDataKmp) r13.element).getCreationList();
        if (r36 != null) goto L88;
        r36 = ((CommonCreationFeedDataKmp) r13.element).getCreationGroupList();
        if (r36 != null) goto L88;
        int r38 = 0;
    L90:
        r35.append(r38);
        CreationFeedAbilityImpl.b(r34, r35.toString());
        CreationFeedInitParamsKmp r39 = this.this$0.c;
        if (r39 == null) goto L127;
        String r40 = r39.getCreationRecommendType();
        if (r40 == null) goto L127;
        if (r40.length() > 0) goto L98;
        r10 = false;
    L98:
        if (r10 == true) goto L101;
        r40 = null;
    L101:
        if (r40 == null) goto L127;
        r6 = this.this$0;
        CreationFeedCacheEntityKmp r41 = new CreationFeedCacheEntityKmp(r40, (CommonCreationFeedDataKmp) r13.element, Boxing.boxLong(r15), Boxing.boxLong(com.larus.im.internal.delegate.c.a.currentTimeMillis()));
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L114
        m0a.l r43 = r6.n();     // Catch: Throwable -> L114
        if (r43 == null) goto L110;
        this.L$0 = r6;     // Catch: Throwable -> L114
        this.L$1 = null;     // Catch: Throwable -> L114
        this.L$2 = null;     // Catch: Throwable -> L114
        this.label = 2;     // Catch: Throwable -> L114
        if (r43.c(r41, this) != r0) goto L108;
        return r0;
    L108:
        r2 = r6;
        goto L109
    L110:
        r2 = r6;
    L114:
        th = th;
    L88:
        r38 = r36.size();
        goto L90
    L82:
        this.this$0.b.update(new t(r33));
        goto L83
    L72:
        if (r31.isEmpty() == true) goto L75;
        r32 = false;
    L78:
        r33 = false;
        goto L80
    L64:
        if (r29.isEmpty() == true) goto L67;
        r30 = false;
        goto L68
    L120:
        if (this.$isRefresh == false) goto L122;
        this.this$0.b.update(new u());
    L123:
        MainCoroutineDispatcher r44 = Dispatchers.getMain();
        AnonymousClass7 r45 = new AnonymousClass7(this.this$0, null);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (BuildersKt.withContext(r44, r45, this) != r0) goto L127;
        return r0;
    L122:
        this.this$0.b.update(new v());
        goto L123
    L42:
        r20 = false;
        goto L43
    L36:
        int r111 = r9;
        Ref.ObjectRef r112 = r12;
    L38:
        r18 = null;
        r9 = r111;
        r12 = r112;
        goto L39
    L16:
        ResultKt.throwOnFailure(r37);
        CoroutineScope r46 = (CoroutineScope) this.L$0;
        CreationFeedAbilityImpl r47 = this.this$0;
        r111 = r47.g;
        r47.p("start requestFirstRecommendList:" + r111);
        r15 = RandomKt.Random(com.larus.im.internal.delegate.c.a.currentTimeMillis()).nextLong();
        if (this.$isMainBottomEnter == false) goto L21;
        String r48 = "enter_conversation_list";
    L19:
        String r49 = r48;
        r112 = new Ref.ObjectRef();
        m0a.l r50 = this.this$0.n();
        if (r50 == null) goto L37;
        String r51 = this.this$0.h;
        Long r52 = Boxing.boxLong(r15);
        this.L$0 = r46;
        this.L$1 = r112;
        this.L$2 = r112;
        this.I$0 = r111;
        this.J$0 = r15;
        this.label = 1;
        r16 = r50.a(r111, r51, r52, r49, this);
        if (r16 != r0) goto L32;
        return r0;
    L32:
        r9 = r111;
        r12 = r112;
        r13 = r12;
        goto L33
    L37:
        r13 = r112;
        goto L38
    L21:
        if (this.$isRefresh == false) goto L24;
        r48 = "refresh";
        goto L19
    L24:
        if (this.$isRetry == false) goto L26;
        r48 = "retry";
        goto L19
    L26:
        r48 = "enter_page";
        goto L19
    }
}
