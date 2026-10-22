package com.larus.agents.impl.network;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larus.agents.impl.experience.KevaWorkExperienceCache;
import com.larus.agents.impl.experience.WorkExperienceMutationResult;
import com.larus.agents.impl.experience.p;
import com.larus.agents.impl.experience.s;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class CachedWorkExperienceRepository implements m {
    public static final /* synthetic */ int d = 0;
    public final m a;
    public final com.larus.agents.impl.experience.m b;
    public final Function0<String> c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0, 0, 1, 1, 1, 2}, l = {419, 422, 423}, m = "delete", n = {"experienceId", "accountId", "experienceId", "accountId", "result", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public AnonymousClass1(CachedWorkExperienceRepository r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return this.this$0.delete(null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$2", f = "WorkExperienceApi.kt", i = {}, l = {422}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        int label;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public AnonymousClass2(CachedWorkExperienceRepository r1, String r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$accountId = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$accountId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            com.larus.agents.impl.experience.m r5 = this.this$0.b;
            String r2 = this.$accountId;
            this.label = 1;
            if (r5.j(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$delete$3", f = "WorkExperienceApi.kt", i = {}, l = {424}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        final /* synthetic */ String $experienceId;
        int label;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public AnonymousClass3(CachedWorkExperienceRepository r1, String r2, String r3, Continuation<? super AnonymousClass3> r4) {
            this.this$0 = r1;
            this.$accountId = r2;
            this.$experienceId = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new AnonymousClass3(this.this$0, this.$accountId, this.$experienceId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            com.larus.agents.impl.experience.m r6 = this.this$0.b;
            String r2 = this.$accountId;
            String r3 = this.$experienceId;
            this.label = 1;
            if (r6.a(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$update$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0, 0, 1, 1, 1, 2}, l = {405, 408, 410}, m = "update", n = {"experienceId", "accountId", "experienceId", "accountId", "result", "result"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0"})
    public static final class C02491 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public C02491(CachedWorkExperienceRepository r1, Continuation<? super C02491> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return this.this$0.update(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$update$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$update$2", f = "WorkExperienceApi.kt", i = {}, l = {408}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02502 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        int label;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public C02502(CachedWorkExperienceRepository r1, String r2, Continuation<? super C02502> r3) {
            this.this$0 = r1;
            this.$accountId = r2;
            super(1, r3);
        }

        public final Continuation<Unit> create(Continuation<?> r4) {
            return new C02502(this.this$0, this.$accountId, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            com.larus.agents.impl.experience.m r5 = this.this$0.b;
            String r2 = this.$accountId;
            this.label = 1;
            if (r5.j(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.agents.impl.network.CachedWorkExperienceRepository$update$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$update$3", f = "WorkExperienceApi.kt", i = {}, l = {411}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02513 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        final /* synthetic */ String $experienceId;
        int label;
        final /* synthetic */ CachedWorkExperienceRepository this$0;

        public C02513(CachedWorkExperienceRepository r1, String r2, String r3, Continuation<? super C02513> r4) {
            this.this$0 = r1;
            this.$accountId = r2;
            this.$experienceId = r3;
            super(1, r4);
        }

        public final Continuation<Unit> create(Continuation<?> r5) {
            return new C02513(this.this$0, this.$accountId, this.$experienceId, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            com.larus.agents.impl.experience.m r6 = this.this$0.b;
            String r2 = this.$accountId;
            String r3 = this.$experienceId;
            this.label = 1;
            if (r6.a(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    static {
    }

    public static Object f() {
        Result.Companion r0 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("account changed during work experience request")));
    }

    public static Object g() {
        Result.Companion r0 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalStateException("work experience cache changed during refresh")));
    }

    public final String j() {
        String r0 = (String) this.c.invoke();
        if (r0 == null) goto L8;
        if ((!StringsKt.isBlank(r0)) == false) goto L8;
        return r0;
    L8:
        return null;
    }

    public CachedWorkExperienceRepository(Object r4) {
        NetworkWorkExperienceRepository r5 = new NetworkWorkExperienceRepository();
        KevaWorkExperienceCache r0 = new KevaWorkExperienceCache();
        Function0<String> r1 = new com.larus.agents.impl.network.a();
        Intrinsics.checkNotNullParameter(r5, "remote");
        Intrinsics.checkNotNullParameter(r0, "local");
        Intrinsics.checkNotNullParameter(r1, "accountIdProvider");
        this.a = r5;
        this.b = r0;
        this.c = r1;
    }

    @Override // com.larus.agents.impl.network.m
    public final Object e(Continuation<? super Result<Boolean>> r15) {
        if ((r15 instanceof CachedWorkExperienceRepository$getEnabled$1) == false) goto L7;
        CachedWorkExperienceRepository$getEnabled$1 r0 = (CachedWorkExperienceRepository$getEnabled$1) r15;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        Object r4 = r0.L$0;
        ResultKt.throwOnFailure(r16);
    L47:
        if (Intrinsics.areEqual((Boolean) r16, Boxing.boxBoolean(false)) == false) goto L51;
        return g();
    L51:
        return r4;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Long r5 = (Long) r0.L$1;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
        Object r17 = ((Result) r16).unbox-impl();
        Long r11 = r5;
        String r9 = r6;
    L30:
        if (n(r9) == true) goto L34;
        return f();
    L34:
        if (Result.isFailure-impl(r17) == false) goto L36;
        Object r7 = null;
    L37:
        Boolean r10 = (Boolean) r7;
        if (r10 != null) goto L40;
        return r17;
    L40:
        if (r9 == null) goto L52;
        if (r11 == null) goto L53;
        CachedWorkExperienceRepository$getEnabled$stored$1 r8 = new CachedWorkExperienceRepository$getEnabled$stored$1(this, r9, r10, r11, null);
        r0.L$0 = r17;
        r0.L$1 = null;
        r0.label = 3;
        Object r12 = h("settings refresh", r8, r0);
        if (r12 != r2) goto L45;
        return r2;
    L45:
        r4 = r17;
        r16 = r12;
        goto L47
    L53:
        return r17;
    L52:
        return r17;
    L36:
        r7 = r17;
        goto L37
    L17:
        String r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L23:
        String r14 = r13;
        Long r19 = (Long) r16;
        String r110 = r14;
    L25:
        m r20 = this.a;
        r0.L$0 = r110;
        r0.L$1 = r19;
        r0.label = 2;
        Object r21 = r20.e(r0);
        if (r21 != r2) goto L28;
        return r2;
    L28:
        r9 = r110;
        r11 = r19;
        r17 = r21;
        goto L30
    L18:
        ResultKt.throwOnFailure(r16);
        r13 = j();
        if (r13 == null) goto L24;
        CachedWorkExperienceRepository$getEnabled$revision$1$1 r111 = new CachedWorkExperienceRepository$getEnabled$revision$1$1(this, r13, null);
        r0.L$0 = r13;
        r0.label = 1;
        r16 = h("settings revision", r111, r0);
        if (r16 != r2) goto L23;
        return r2;
    L24:
        r110 = r13;
        r19 = null;
    L7:
        r0 = new CachedWorkExperienceRepository$getEnabled$1(this, r15);
        goto L8
    }

    public final Object l(Continuation<? super Boolean> r7) {
        if ((r7 instanceof CachedWorkExperienceRepository$getCachedEnabled$1) == false) goto L7;
        CachedWorkExperienceRepository$getCachedEnabled$1 r0 = (CachedWorkExperienceRepository$getCachedEnabled$1) r7;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        Boolean r9 = (Boolean) r8;
        if (n(r4) == true) goto L24;
        return null;
    L24:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        String r10 = j();
        if (r10 != null) goto L17;
        return null;
    L17:
        r0.L$0 = r10;
        r0.label = 1;
        Object r5 = h("settings read", new CachedWorkExperienceRepository$cachedEnabled$2(this, r10, null), r0);
        if (r5 != r2) goto L20;
        return r2;
    L20:
        r4 = r10;
        r8 = r5;
    L7:
        r0 = new CachedWorkExperienceRepository$getCachedEnabled$1(this, r7);
        goto L8
    }

    public final Object m(Continuation<? super s> r7) {
        if ((r7 instanceof CachedWorkExperienceRepository$getCachedFirstPage$1) == false) goto L7;
        CachedWorkExperienceRepository$getCachedFirstPage$1 r0 = (CachedWorkExperienceRepository$getCachedFirstPage$1) r7;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L21:
        s r9 = (s) r8;
        if (n(r4) == true) goto L24;
        return null;
    L24:
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        String r10 = j();
        if (r10 != null) goto L17;
        return null;
    L17:
        r0.L$0 = r10;
        r0.label = 1;
        Object r5 = h("list read", new CachedWorkExperienceRepository$cachedFirstPage$2(this, r10, null), r0);
        if (r5 != r2) goto L20;
        return r2;
    L20:
        r4 = r10;
        r8 = r5;
    L7:
        r0 = new CachedWorkExperienceRepository$getCachedFirstPage$1(this, r7);
        goto L8
    }

    public final boolean n(String r2) {
        return Intrinsics.areEqual(j(), r2);
    }

    @Override // com.larus.agents.impl.network.m
    public final Object a(p r7, Continuation<? super WorkExperienceMutationResult> r8) {
        if ((r8 instanceof CachedWorkExperienceRepository$create$1) == false) goto L7;
        CachedWorkExperienceRepository$create$1 r0 = (CachedWorkExperienceRepository$create$1) r8;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        WorkExperienceMutationResult r10 = (WorkExperienceMutationResult) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L32:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L20:
        WorkExperienceMutationResult r12 = (WorkExperienceMutationResult) r9;
        if (n(r11) == true) goto L25;
        return WorkExperienceMutationResult.FAILURE;
    L25:
        if (r12 != WorkExperienceMutationResult.SUCCESS) goto L33;
        if (r11 == null) goto L34;
        CachedWorkExperienceRepository$create$2 r4 = new CachedWorkExperienceRepository$create$2(this, r11, null);
        r0.L$0 = r12;
        r0.label = 2;
        if (i("create mutation", r4, r0) != r2) goto L30;
        return r2;
    L30:
        r10 = r12;
        goto L32
    L34:
        return r12;
    L33:
        return r12;
    L16:
        ResultKt.throwOnFailure(r9);
        String r13 = j();
        m r5 = this.a;
        r0.L$0 = r13;
        r0.label = 1;
        Object r14 = r5.a(r7, r0);
        if (r14 != r2) goto L19;
        return r2;
    L19:
        r9 = r14;
        r11 = r13;
    L7:
        r0 = new CachedWorkExperienceRepository$create$1(this, r8);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public final Object b(boolean r7, Continuation<? super WorkExperienceMutationResult> r8) {
        if ((r8 instanceof CachedWorkExperienceRepository$updateEnabled$1) == false) goto L7;
        CachedWorkExperienceRepository$updateEnabled$1 r0 = (CachedWorkExperienceRepository$updateEnabled$1) r8;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        WorkExperienceMutationResult r10 = (WorkExperienceMutationResult) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L31:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = r0.Z$0;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L19:
        WorkExperienceMutationResult r11 = (WorkExperienceMutationResult) r9;
        if (n(r4) == true) goto L24;
        return WorkExperienceMutationResult.FAILURE;
    L24:
        if (r11 != WorkExperienceMutationResult.SUCCESS) goto L32;
        if (r4 == null) goto L33;
        CachedWorkExperienceRepository$updateEnabled$2 r5 = new CachedWorkExperienceRepository$updateEnabled$2(this, r4, r7, null);
        r0.L$0 = r11;
        r0.label = 2;
        if (i("settings mutation", r5, r0) != r2) goto L29;
        return r2;
    L29:
        r10 = r11;
        goto L31
    L33:
        return r11;
    L32:
        return r11;
    L16:
        ResultKt.throwOnFailure(r9);
        r4 = j();
        m r12 = this.a;
        r0.L$0 = r4;
        r0.Z$0 = r7;
        r0.label = 1;
        r9 = r12.b(r7, r0);
        if (r9 != r2) goto L19;
        return r2;
    L7:
        r0 = new CachedWorkExperienceRepository$updateEnabled$1(this, r8);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public final Object c(String r15, Continuation<? super Result<com.larus.agents.impl.experience.n>> r16) {
        String r0 = r15;
        if ((r16 instanceof CachedWorkExperienceRepository$getDetail$1) == false) goto L7;
        CachedWorkExperienceRepository$getDetail$1 r2 = (CachedWorkExperienceRepository$getDetail$1) r16;
        int r3 = r2.label;
        if ((r3 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r2.label = r3 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        CachedWorkExperienceRepository$getDetail$1 r7 = r2;
        Object r1 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r7.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        Object r5 = r7.L$0;
        ResultKt.throwOnFailure(r1);
    L47:
        if (Intrinsics.areEqual((Boolean) r1, Boxing.boxBoolean(false)) == false) goto L51;
        return g();
    L51:
        return r5;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Long r6 = (Long) r7.L$1;
        String r9 = (String) r7.L$0;
        ResultKt.throwOnFailure(r1);
        Long r10 = r6;
        Object r11 = ((Result) r1).unbox-impl();
    L30:
        if (n(r9) == true) goto L34;
        return f();
    L34:
        if (Result.isFailure-impl(r11) == false) goto L36;
        Object r12 = null;
    L37:
        com.larus.agents.impl.experience.n r13 = (com.larus.agents.impl.experience.n) r12;
        if (r13 != null) goto L40;
        return r11;
    L40:
        if (r9 == null) goto L52;
        if (r10 == null) goto L53;
        CachedWorkExperienceRepository$getDetail$stored$1 r14 = new CachedWorkExperienceRepository$getDetail$stored$1(this, r9, r13, r10, null);
        r7.L$0 = r11;
        r7.L$1 = null;
        r7.label = 3;
        r1 = h("detail refresh", r14, r7);
        if (r1 != r8) goto L45;
        return r8;
    L45:
        r5 = r11;
        goto L47
    L53:
        return r11;
    L52:
        return r11;
    L36:
        r12 = r11;
        goto L37
    L17:
        String r17 = (String) r7.L$1;
        String r19 = (String) r7.L$0;
        ResultKt.throwOnFailure(r1);
        String r20 = r17;
        r0 = r19;
        Object r21 = r1;
    L23:
        Long r22 = (Long) r21;
    L25:
        m r23 = this.a;
        r7.L$0 = r20;
        r7.L$1 = r22;
        r7.label = 2;
        Object r24 = r23.c(r0, r7);
        if (r24 != r8) goto L28;
        return r8;
    L28:
        r11 = r24;
        r10 = r22;
        r9 = r20;
        goto L30
    L18:
        ResultKt.throwOnFailure(r1);
        r20 = j();
        if (r20 == null) goto L24;
        CachedWorkExperienceRepository$getDetail$revision$1$1 r25 = new CachedWorkExperienceRepository$getDetail$revision$1$1(this, r20, r15, null);
        r7.L$0 = r0;
        r7.L$1 = r20;
        r7.label = 1;
        r21 = h("detail revision", r25, r7);
        if (r21 != r8) goto L23;
        return r8;
    L24:
        r22 = null;
    L7:
        r2 = new CachedWorkExperienceRepository$getDetail$1(this, r16);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public Object delete(String r9, Continuation<? super WorkExperienceMutationResult> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        WorkExperienceMutationResult r12 = (WorkExperienceMutationResult) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L37:
        return r12;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r12 = (WorkExperienceMutationResult) r0.L$2;
        String r4 = (String) r0.L$1;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L33:
        AnonymousClass3 r13 = new AnonymousClass3(this, r4, r5, null);
        r0.L$0 = r12;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 3;
        if (i("delete detail mutation", r13, r0) != r2) goto L37;
        return r2;
    L17:
        String r14 = (String) r0.L$1;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r11);
        r4 = r14;
        r9 = r6;
    L22:
        WorkExperienceMutationResult r15 = (WorkExperienceMutationResult) r11;
        if (n(r4) == true) goto L27;
        return WorkExperienceMutationResult.FAILURE;
    L27:
        if (r15 != WorkExperienceMutationResult.SUCCESS) goto L38;
        if (r4 == null) goto L39;
        AnonymousClass2 r7 = new AnonymousClass2(this, r4, null);
        r0.L$0 = r9;
        r0.L$1 = r4;
        r0.L$2 = r15;
        r0.label = 2;
        if (i("delete list mutation", r7, r0) != r2) goto L32;
        return r2;
    L32:
        r5 = r9;
        r12 = r15;
        goto L33
    L39:
        return r15;
    L38:
        return r15;
    L18:
        ResultKt.throwOnFailure(r11);
        String r16 = j();
        m r8 = this.a;
        r0.L$0 = r9;
        r0.L$1 = r16;
        r0.label = 1;
        Object r17 = r8.delete(r9, r0);
        if (r17 != r2) goto L21;
        return r2;
    L21:
        r4 = r16;
        r11 = r17;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }

    public final Object k(String r7, Continuation<? super com.larus.agents.impl.experience.n> r8) {
        if ((r8 instanceof CachedWorkExperienceRepository$getCachedDetail$1) == false) goto L7;
        CachedWorkExperienceRepository$getCachedDetail$1 r0 = (CachedWorkExperienceRepository$getCachedDetail$1) r8;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        String r10 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L21:
        com.larus.agents.impl.experience.n r11 = (com.larus.agents.impl.experience.n) r9;
        if (n(r10) == true) goto L24;
        return null;
    L24:
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        String r12 = j();
        if (r12 != null) goto L17;
        return null;
    L17:
        r0.L$0 = r12;
        r0.label = 1;
        Object r13 = h("detail read", new CachedWorkExperienceRepository$cachedDetail$2(this, r12, r7, null), r0);
        if (r13 != r2) goto L20;
        return r2;
    L20:
        r9 = r13;
        r10 = r12;
    L7:
        r0 = new CachedWorkExperienceRepository$getCachedDetail$1(this, r8);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public final Object d(int r15, String r16, Continuation<? super Result<s>> r17) {
        int r0 = r15;
        if ((r17 instanceof CachedWorkExperienceRepository$list$1) == false) goto L7;
        CachedWorkExperienceRepository$list$1 r3 = (CachedWorkExperienceRepository$list$1) r17;
        int r4 = r3.label;
        if ((r4 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r3.label = r4 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        CachedWorkExperienceRepository$list$1 r7 = r3;
        Object r2 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r7.label;
        if (r5 == 0) goto L21;
        if (r5 == 1) goto L20;
        if (r5 == 2) goto L19;
        if (r5 == 3) goto L17;
        if (r5 != 4) goto L16;
        Object r1 = r7.L$0;
        ResultKt.throwOnFailure(r2);
    L67:
        if (Intrinsics.areEqual((Boolean) r2, Boxing.boxBoolean(false)) == false) goto L71;
        return g();
    L71:
        return r1;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Long r6 = (Long) r7.L$1;
        String r9 = (String) r7.L$0;
        ResultKt.throwOnFailure(r2);
        Long r10 = r6;
        Object r11 = ((Result) r2).unbox-impl();
    L18:
        String r12 = r9;
        if (n(r12) == true) goto L54;
        return f();
    L54:
        if (Result.isFailure-impl(r11) == false) goto L56;
        Object r13 = null;
    L57:
        s r14 = (s) r13;
        if (r14 != null) goto L60;
        return r11;
    L60:
        if (r12 == null) goto L73;
        if (r10 == null) goto L74;
        CachedWorkExperienceRepository$list$stored$1 r19 = new CachedWorkExperienceRepository$list$stored$1(this, r12, r14, r10, null);
        r7.L$0 = r11;
        r7.L$1 = null;
        r7.label = 4;
        r2 = h("list refresh", r19, r7);
        if (r2 != r8) goto L65;
        return r8;
    L65:
        r1 = r11;
        goto L67
    L74:
        return r11;
    L73:
        return r11;
    L56:
        r13 = r11;
        goto L57
    L19:
        r0 = r7.I$0;
        r9 = (String) r7.L$0;
        ResultKt.throwOnFailure(r2);
    L43:
        Long r20 = (Long) r2;
    L45:
        m r21 = this.a;
        r7.L$0 = r9;
        r7.L$1 = r20;
        r7.label = 3;
        Object r22 = r21.d(r0, null, r7);
        if (r22 != r8) goto L48;
        return r8;
    L48:
        r11 = r22;
        r10 = r20;
        goto L18
    L20:
        String r23 = (String) r7.L$0;
        ResultKt.throwOnFailure(r2);
        Object r24 = ((Result) r2).unbox-impl();
    L34:
        if (n(r23) == false) goto L37;
        return r24;
    L37:
        return f();
    L21:
        ResultKt.throwOnFailure(r2);
        if (r16 != null) goto L24;
    L27:
        boolean r25 = true;
    L28:
        if (r25 == true) goto L38;
        String r26 = j();
        m r27 = this.a;
        r7.L$0 = r26;
        r7.label = 1;
        r24 = r27.d(r15, r16, r7);
        if (r24 != r8) goto L32;
        return r8;
    L32:
        r23 = r26;
        goto L34
    L38:
        r9 = j();
        if (r9 == null) goto L44;
        CachedWorkExperienceRepository$list$revision$1$1 r29 = new CachedWorkExperienceRepository$list$revision$1$1(this, r9, null);
        r7.L$0 = r9;
        r7.I$0 = r0;
        r7.label = 2;
        r2 = h("list revision", r29, r7);
        if (r2 != r8) goto L43;
        return r8;
    L44:
        r20 = null;
        goto L45
    L24:
        if (StringsKt.isBlank(r16) == true) goto L27;
        r25 = false;
    L7:
        r3 = new CachedWorkExperienceRepository$list$1(this, r17);
        goto L8
    }

    public final <T> Object h(String r5, Function1<? super Continuation<? super T>, ? extends Object> r6, Continuation<? super T> r7) {
        if ((r7 instanceof CachedWorkExperienceRepository$cacheRead$1) == false) goto L7;
        CachedWorkExperienceRepository$cacheRead$1 r0 = (CachedWorkExperienceRepository$cacheRead$1) r7;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22
    L20:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L22
    L25:
        if (Result.exceptionOrNull-impl(r9) == null) goto L31;
        FLogger.a.w("CachedWorkExperienceRepo", r5 + " cache operation failed");
        return null;
    L31:
        return r9;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L22
        r0.L$0 = r5;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        r8 = r6.invoke(r0);     // Catch: Throwable -> L22
        if (r8 != r2) goto L20;
        return r2;
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new CachedWorkExperienceRepository$cacheRead$1(this, r7);
        goto L8
    }

    public final Object i(String r5, Function1<? super Continuation<? super Unit>, ? extends Object> r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof CachedWorkExperienceRepository$cacheWrite$1) == false) goto L7;
        CachedWorkExperienceRepository$cacheWrite$1 r0 = (CachedWorkExperienceRepository$cacheWrite$1) r7;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L22
    L20:
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L25:
        if (Result.exceptionOrNull-impl(r9) == null) goto L28;
        FLogger.a.w("CachedWorkExperienceRepo", r5 + " cache operation failed");
    L28:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L22
        r0.L$0 = r5;     // Catch: Throwable -> L22
        r0.label = 1;     // Catch: Throwable -> L22
        if (r6.invoke(r0) != r2) goto L20;
        return r2;
    L22:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new CachedWorkExperienceRepository$cacheWrite$1(this, r7);
        goto L8
    }

    @Override // com.larus.agents.impl.network.m
    public Object update(String r9, p r10, Continuation<? super WorkExperienceMutationResult> r11) {
        if ((r11 instanceof C02491) == false) goto L7;
        C02491 r0 = (C02491) r11;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        WorkExperienceMutationResult r13 = (WorkExperienceMutationResult) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L37:
        return r13;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r13 = (WorkExperienceMutationResult) r0.L$2;
        String r14 = (String) r0.L$1;
        String r4 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L33:
        C02513 r15 = new C02513(this, r14, r4, null);
        r0.L$0 = r13;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 3;
        if (i("update detail mutation", r15, r0) != r2) goto L37;
        return r2;
    L17:
        String r16 = (String) r0.L$1;
        String r17 = (String) r0.L$0;
        ResultKt.throwOnFailure(r12);
        r14 = r16;
        r9 = r17;
    L22:
        WorkExperienceMutationResult r19 = (WorkExperienceMutationResult) r12;
        if (n(r14) == true) goto L27;
        return WorkExperienceMutationResult.FAILURE;
    L27:
        if (r19 != WorkExperienceMutationResult.SUCCESS) goto L38;
        if (r14 == null) goto L39;
        C02502 r5 = new C02502(this, r14, null);
        r0.L$0 = r9;
        r0.L$1 = r14;
        r0.L$2 = r19;
        r0.label = 2;
        if (i("update list mutation", r5, r0) != r2) goto L32;
        return r2;
    L32:
        r4 = r9;
        r13 = r19;
        goto L33
    L39:
        return r19;
    L38:
        return r19;
    L18:
        ResultKt.throwOnFailure(r12);
        String r110 = j();
        m r6 = this.a;
        r0.L$0 = r9;
        r0.L$1 = r110;
        r0.label = 1;
        Object r111 = r6.update(r9, r10, r0);
        if (r111 != r2) goto L21;
        return r2;
    L21:
        r12 = r111;
        r14 = r110;
    L7:
        r0 = new C02491(this, r11);
        goto L8
    }
}
