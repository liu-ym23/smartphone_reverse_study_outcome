package com.suite.lark.platform.feature.forward.doubao.assembly;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.forwardv3.configuration.targetconfig.IncludeConfig;
import com.ss.android.lark.forwardv3.data.services.ForwardGetServicesV2;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.suite.lark.platform.feature.forward.doubao.api.entity.ForwardScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.ForwardDoubaoApiImpl$getRecentForwardList$1", f = "ForwardDoubaoApiImpl.kt", i = {}, l = {75, 82, 92}, m = "invokeSuspend", n = {}, s = {})
public final class ForwardDoubaoApiImpl$getRecentForwardList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $activityStartTime;
    final /* synthetic */ mpc.g $callback;
    final /* synthetic */ IncludeConfig $includeConfig;
    final /* synthetic */ boolean $requestCacheData;
    final /* synthetic */ ForwardScene $scene;
    int label;
    final /* synthetic */ ForwardDoubaoApiImpl this$0;

    /* JADX INFO: renamed from: com.suite.lark.platform.feature.forward.doubao.assembly.ForwardDoubaoApiImpl$getRecentForwardList$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.ForwardDoubaoApiImpl$getRecentForwardList$1$1", f = "ForwardDoubaoApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ mpc.g $callback;
        final /* synthetic */ List<npc.c> $result;
        int label;

        public AnonymousClass1(mpc.g r1, List<npc.c> r2, Continuation<? super AnonymousClass1> r3) {
            this.$callback = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$callback, this.$result, r4);
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
            this.$callback.onSuccess(this.$result);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.suite.lark.platform.feature.forward.doubao.assembly.ForwardDoubaoApiImpl$getRecentForwardList$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
    @DebugMetadata(c = "com.suite.lark.platform.feature.forward.doubao.assembly.ForwardDoubaoApiImpl$getRecentForwardList$1$2", f = "ForwardDoubaoApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ mpc.g $callback;
        final /* synthetic */ int $errorCode;
        final /* synthetic */ String $errorMessage;
        int label;

        public AnonymousClass2(mpc.g r1, int r2, String r3, Continuation<? super AnonymousClass2> r4) {
            this.$callback = r1;
            this.$errorCode = r2;
            this.$errorMessage = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass2(this.$callback, this.$errorCode, this.$errorMessage, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            this.$callback.onFailure(this.$errorCode, this.$errorMessage);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ForwardDoubaoApiImpl$getRecentForwardList$1(long r1, IncludeConfig r3, boolean r4, ForwardScene r5, ForwardDoubaoApiImpl r6, mpc.g r7, Continuation<? super ForwardDoubaoApiImpl$getRecentForwardList$1> r8) {
        this.$activityStartTime = r1;
        this.$includeConfig = r3;
        this.$requestCacheData = r4;
        this.$scene = r5;
        this.this$0 = r6;
        this.$callback = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ForwardDoubaoApiImpl$getRecentForwardList$1(this.$activityStartTime, this.$includeConfig, this.$requestCacheData, this.$scene, this.this$0, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r13);
    L36:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L24
        goto L36
    L11:
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L24
    L17:
        List r14 = (List) r13;     // Catch: Throwable -> L24
        ForwardDoubaoApiImpl r2 = this.this$0;     // Catch: Throwable -> L24
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));     // Catch: Throwable -> L24
        Iterator r15 = r14.iterator();     // Catch: Throwable -> L24
    L19:
        if (r15.hasNext() == false) goto L21;
        r5.add(ForwardDoubaoApiImpl.a(r2, (SearchBaseInfo) r15.next()));     // Catch: Throwable -> L24
        goto L19
    L21:
        MainCoroutineDispatcher r16 = Dispatchers.getMain();     // Catch: Throwable -> L24
        AnonymousClass1 r3 = new AnonymousClass1(this.$callback, r5, null);     // Catch: Throwable -> L24
        this.label = 2;     // Catch: Throwable -> L24
        if (BuildersKt.withContext(r16, r3, this) != r0) goto L36;
        return r0;
    L13:
        ResultKt.throwOnFailure(r13);
        int r17 = ForwardGetServicesV2.a;     // Catch: Throwable -> L24
        long r6 = this.$activityStartTime;     // Catch: Throwable -> L24
        IncludeConfig r8 = this.$includeConfig;     // Catch: Throwable -> L24
        boolean r9 = this.$requestCacheData;     // Catch: Throwable -> L24
        final ForwardDoubaoApiImpl r18 = this.this$0;     // Catch: Throwable -> L24
        Function1<SearchBaseInfo, Boolean> r10 = new ForwardDoubaoApiImpl$getRecentForwardList$1$data$1(r18);     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r13 = ForwardGetServicesV2.b(r6, r8, r9, r10, this);     // Catch: Throwable -> L24
        if (r13 != r0) goto L17;
        return r0;
    L24:
        th = move-exception;
        if ((th instanceof ErrorResult) == false) goto L31;
        ErrorResult r4 = th;
        Integer r7 = Boxing.boxInt(r4.getCode());
        String r11 = r4.getMessage();
        if (r11 != null) goto L30;
        r11 = "";
    L30:
        Pair r12 = TuplesKt.to(r7, r11);
    L32:
        int r19 = ((Number) r12.component1()).intValue();
        String r20 = (String) r12.component2();
        Log.e("ForwardDoubaoApiImpl", "getRecentForwardList failed, scene=" + this.$scene + ", requestCacheData=" + this.$requestCacheData, th);
        MainCoroutineDispatcher r110 = Dispatchers.getMain();
        AnonymousClass2 r21 = new AnonymousClass2(this.$callback, r19, r20, null);
        this.label = 3;
        if (BuildersKt.withContext(r110, r21, this) != r0) goto L36;
        return r0;
    L31:
        r12 = TuplesKt.to(Boxing.boxInt(-1), "getRecentForwardList error");
        goto L32
    }
}
