package com.larus.showcase.view;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.larus.network.bean.BizResponse;
import com.larus.platform.model.showcase.Case;
import com.larus.platform.model.showcase.CaseActionRequest;
import com.larus.platform.model.showcase.ListCaseResponse;
import com.larus.showcase.api.CaseApi;
import com.larus.showcase.api.ICaseService;
import com.larus.showcase.service.CaseRepo;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u0012H\u0002J\u0012\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/larus/showcase/view/CaseViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "currentCaseList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/larus/platform/model/showcase/Case;", "currentRecommendCaseList", "currentIndex", "", "loadMoreState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getLoadMoreState", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "caseListLiveData", "Lcom/larus/showcase/view/CaseListResponse;", "getCaseListLiveData", "needScrollToTop", "", "getNeedScrollToTop", "()Z", "setNeedScrollToTop", "(Z)V", "queryCaseList", "", "mergeCase", "", "hasMore", "containsById", "caseId", "", "requestMoreCase", "readCollection", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CaseViewModel extends ViewModel {
    public static final a Companion = null;
    public static final int FIRST_PAGE_INDEX = 1;
    public static final int PAGE_SIZE = 20;
    public static final String TAG = "CaseViewModel";
    private final MutableSharedFlow<g> caseListLiveData;
    private CopyOnWriteArrayList<Case> currentCaseList;
    private int currentIndex;
    private CopyOnWriteArrayList<Case> currentRecommendCaseList;
    private final MutableSharedFlow<Integer> loadMoreState;
    private boolean needScrollToTop;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.showcase.view.CaseViewModel$queryCaseList$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.showcase.view.CaseViewModel$queryCaseList$1", f = "CaseViewModel.kt", i = {0, 1, 2, 2, 3, 4, 4, 5, 5, 6, 7}, l = {47, 49, 58, 64, 69, 79, 82, 85, 94}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "cacheData", "$this$launch", "$this$launch", "caseResponse", "$this$launch", "caseResponse", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ CaseViewModel this$0;

        /* JADX INFO: renamed from: com.larus.showcase.view.CaseViewModel$queryCaseList$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.showcase.view.CaseViewModel$queryCaseList$1$2", f = "CaseViewModel.kt", i = {}, l = {TraceLevel.ABOVE_DEBUG}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Case> $cacheData;
            int label;

            public AnonymousClass2(List<Case> r1, Continuation<? super AnonymousClass2> r2) {
                this.$cacheData = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.$cacheData, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L19:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                ICaseService.Companion r7 = ICaseService.a;
                List<Case> r2 = this.$cacheData;
                ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
                Iterator<T> r4 = r2.iterator();
            L10:
                if (r4.hasNext() == false) goto L15;
                String r5 = ((Case) r4.next()).getCaseId();
                if (r5 != null) goto L14;
                r5 = "";
            L14:
                r3.add(r5);
                goto L10
            L15:
                this.label = 1;
                if (r7.h(r3, this) != r0) goto L19;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.larus.showcase.view.CaseViewModel$queryCaseList$1$5, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.showcase.view.CaseViewModel$queryCaseList$1$5", f = "CaseViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ CaseViewModel this$0;

            public AnonymousClass5(CaseViewModel r1, Continuation<? super AnonymousClass5> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass5(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L19:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                ICaseService.Companion r7 = ICaseService.a;
                CopyOnWriteArrayList r2 = CaseViewModel.access$getCurrentCaseList$p(this.this$0);
                ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
                Iterator r4 = r2.iterator();
            L10:
                if (r4.hasNext() == false) goto L15;
                String r5 = ((Case) r4.next()).getCaseId();
                if (r5 != null) goto L14;
                r5 = "";
            L14:
                r3.add(r5);
                goto L10
            L15:
                this.label = 1;
                if (r7.h(r3, this) != r0) goto L19;
                return r0;
            }
        }

        public AnonymousClass1(CaseViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r20) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L15;
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                case 9: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r20);
        L140:
            return Unit.INSTANCE;
        L7:
            CoroutineScope r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r20);
        L124:
            FLogger.a.i(CaseViewModel.TAG, "queryCollectList  loadMoreState END");
        L125:
            BuildersKt.launch$default(r2, null, null, new AnonymousClass5(this.this$0, null), 3, null);
            goto L140
        L8:
            r2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r20);
        L118:
            FLogger.a.i(CaseViewModel.TAG, "queryCollectList  loadMoreState HAS_MORE");
            goto L125
        L9:
            ListCaseResponse r3 = (ListCaseResponse) this.L$1;
            CoroutineScope r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r20);
        L110:
            if (r3 == null) goto L112;
            boolean r5 = Intrinsics.areEqual(r3.getHasMore(), Boxing.boxBoolean(true));
        L113:
            if (r5 == false) goto L120;
            MutableSharedFlow<Integer> r6 = this.this$0.getLoadMoreState();
            Integer r7 = Boxing.boxInt(0);
            this.L$0 = r4;
            this.L$1 = null;
            this.label = 7;
            if (r6.emit(r7, this) != r1) goto L117;
            return r1;
        L117:
            r2 = r4;
            goto L118
        L120:
            MutableSharedFlow<Integer> r8 = this.this$0.getLoadMoreState();
            Integer r9 = Boxing.boxInt(2);
            this.L$0 = r4;
            this.L$1 = null;
            this.label = 8;
            if (r8.emit(r9, this) != r1) goto L123;
            return r1;
        L123:
            r2 = r4;
            goto L124
        L112:
            r5 = false;
            goto L113
        L10:
            r3 = (ListCaseResponse) this.L$1;
            r4 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r20);
        L72:
            if (r3 == null) goto L76;
            List<Case> r11 = r3.getCaseList();
            if (r11 == null) goto L76;
            List r12 = CollectionsKt.filterNotNull(r11);
        L77:
            if (r12 == null) goto L88;
            Iterator r13 = r12.iterator();
        L80:
            if (r13.hasNext() == false) goto L88;
            Case r14 = (Case) r13.next();
            if (r3 == null) goto L86;
            Map<String, String> r15 = r3.getExtra();
            if (r15 == null) goto L86;
            String r16 = r15.get("request_id");
        L87:
            r14.setRequestId(r16);
        L86:
            r16 = null;
        L88:
            if (r12 == null) goto L97;
            CaseViewModel r17 = this.this$0;
            FLogger.a.i(CaseViewModel.TAG, "queryCaseList  case Size : " + r12.size());
            CopyOnWriteArrayList r10 = CaseViewModel.access$getCurrentCaseList$p(r17);
            if (r10 == null) goto L92;
            r10.clear();
        L92:
            CopyOnWriteArrayList r18 = CaseViewModel.access$getCurrentCaseList$p(r17);
            if (r18 == null) goto L95;
            Boolean r19 = Boxing.boxBoolean(r18.addAll(r12));
        L96:
            if (r19 == null) goto L97;
        L100:
            MutableSharedFlow<g> r21 = this.this$0.getCaseListLiveData();
            CaseViewModel r110 = this.this$0;
            if (r3 == null) goto L103;
            boolean r111 = Intrinsics.areEqual(r3.getHasMore(), Boxing.boxBoolean(true));
        L104:
            List r112 = CaseViewModel.access$mergeCase(r110, r111);
            if (r112 != null) goto L107;
            r112 = CollectionsKt.emptyList();
        L107:
            g r113 = new g(3, r112, true);
            this.L$0 = r4;
            this.L$1 = r3;
            this.label = 6;
            if (r21.emit(r113, this) != r1) goto L110;
            return r1;
        L103:
            r111 = false;
            goto L104
        L95:
            r19 = null;
        L97:
            CopyOnWriteArrayList r22 = CaseViewModel.access$getCurrentCaseList$p(this.this$0);
            if (r22 == null) goto L100;
            r22.clear();
            Unit r23 = Unit.INSTANCE;
        L76:
            r12 = null;
            goto L77
        L11:
            CoroutineScope r24 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r20);
            Object r25 = r20;
        L58:
            dm9.a.b r26 = (dm9.a) r25;
            if ((r26 instanceof dm9.a.b) == false) goto L127;
            dm9.a.b r114 = r26;
            if (r114.a.isSuccess() == false) goto L127;
            ListCaseResponse r27 = (ListCaseResponse) r114.a.getData();
            CaseRepo r115 = CaseRepo.a;
            if (r27 == null) goto L67;
            List<Case> r116 = r27.getCaseList();
            if (r116 == null) goto L67;
            List r117 = CollectionsKt.filterNotNull(r116);
        L68:
            this.L$0 = r24;
            this.L$1 = r27;
            this.label = 5;
            if (CaseRepo.k(r117, true, this) != r1) goto L71;
            return r1;
        L71:
            r4 = r24;
            r3 = r27;
        L67:
            r117 = null;
        L127:
            if ((r26 instanceof dm9.a.a) == false) goto L140;
            FLogger.a.i(CaseViewModel.TAG, "queryCollectList Fail");
            CopyOnWriteArrayList r28 = CaseViewModel.access$getCurrentCaseList$p(this.this$0);
            if (r28 != null) goto L131;
        L134:
            boolean r29 = true;
        L135:
            if (r29 == false) goto L140;
            MutableSharedFlow<g> r30 = this.this$0.getCaseListLiveData();
            g r31 = new g(1, CollectionsKt.emptyList(), false);
            this.L$0 = null;
            this.label = 9;
            if (r30.emit(r31, this) != r1) goto L140;
            return r1;
        L131:
            if (r28.isEmpty() == true) goto L134;
            r29 = false;
            goto L135
        L12:
            List r32 = (List) this.L$1;
            CoroutineScope r118 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r20);
            CoroutineScope r119 = r118;
        L54:
            BuildersKt.launch$default(r119, null, null, new AnonymousClass2(r32, null), 3, null);
            r24 = r119;
        L55:
            CaseViewModel.access$setCurrentIndex$p(this.this$0, 1);
            CaseApi.a r120 = CaseApi.a;
            CaseViewModel$queryCaseList$1$result$1 r121 = new CaseViewModel$queryCaseList$1$result$1(null);
            this.L$0 = r24;
            this.L$1 = null;
            this.label = 4;
            r120.getClass();
            r25 = CaseApi.a.a(r121, this);
            if (r25 != r1) goto L58;
            return r1;
        L13:
            r24 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r20);
            Object r122 = r20;
        L29:
            List r123 = (List) r122;
            List r124 = r123;
            if (r124 != null) goto L32;
        L35:
            boolean r125 = true;
        L36:
            if (r125 == true) goto L55;
            FLogger r126 = FLogger.a;
            r126.i(CaseViewModel.TAG, "queryCaseList cacheData is not null");
            if (r123 == null) goto L47;
            CaseViewModel r127 = this.this$0;
            r126.i(CaseViewModel.TAG, "queryCaseList  case Size : " + r123.size());
            CopyOnWriteArrayList r128 = CaseViewModel.access$getCurrentCaseList$p(r127);
            if (r128 == null) goto L42;
            r128.clear();
        L42:
            CopyOnWriteArrayList r129 = CaseViewModel.access$getCurrentCaseList$p(r127);
            if (r129 == null) goto L45;
            Boolean r130 = Boxing.boxBoolean(r129.addAll(r123));
        L46:
            if (r130 == null) goto L47;
        L50:
            MutableSharedFlow<g> r131 = this.this$0.getCaseListLiveData();
            g r132 = new g(3, CaseViewModel.access$mergeCase(this.this$0, true), true);
            this.L$0 = r24;
            this.L$1 = r123;
            this.label = 3;
            if (r131.emit(r132, this) != r1) goto L53;
            return r1;
        L53:
            r119 = r24;
            r32 = r123;
            goto L54
        L45:
            r130 = null;
        L47:
            CopyOnWriteArrayList r133 = CaseViewModel.access$getCurrentCaseList$p(this.this$0);
            if (r133 == null) goto L50;
            r133.clear();
            Unit r134 = Unit.INSTANCE;
            goto L50
        L32:
            if (r124.isEmpty() == true) goto L35;
            r125 = false;
            goto L36
        L14:
            r24 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r20);
        L26:
            CaseRepo r135 = CaseRepo.a;
            this.L$0 = r24;
            this.label = 2;
            r122 = CaseRepo.d(this);
            if (r122 != r1) goto L29;
            return r1;
        L15:
            ResultKt.throwOnFailure(r20);
            r24 = (CoroutineScope) this.L$0;
            CopyOnWriteArrayList r136 = CaseViewModel.access$getCurrentCaseList$p(this.this$0);
            if (r136 != null) goto L18;
        L21:
            boolean r137 = true;
        L22:
            if (r137 == false) goto L26;
            MutableSharedFlow<g> r138 = this.this$0.getCaseListLiveData();
            g r139 = new g(4, CollectionsKt.emptyList(), false);
            this.L$0 = r24;
            this.label = 1;
            if (r138.emit(r139, this) != r1) goto L26;
            return r1;
        L18:
            if (r136.isEmpty() == true) goto L21;
            r137 = false;
            goto L22
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.showcase.view.CaseViewModel$readCollection$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.showcase.view.CaseViewModel$readCollection$1", f = "CaseViewModel.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $caseId;
        int label;

        /* JADX INFO: renamed from: com.larus.showcase.view.CaseViewModel$readCollection$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/showcase/api/CaseApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.showcase.view.CaseViewModel$readCollection$1$1", f = "CaseViewModel.kt", i = {}, l = {170}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00311 extends SuspendLambda implements Function2<CaseApi, Continuation<? super BizResponse<Unit>>, Object> {
            final /* synthetic */ String $caseId;
            private /* synthetic */ Object L$0;
            int label;

            public C00311(String r1, Continuation<? super C00311> r2) {
                this.$caseId = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00311 r0 = new C00311(this.$caseId, r4);
                r0.L$0 = r3;
                return r0;
            }

            public final Object invoke(CaseApi r1, Continuation<? super BizResponse<Unit>> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CaseApi) r1, (Continuation) r2);
            }

            public final Object invokeSuspend(Object r6) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r6);
            L15:
                return r6;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r6);
                CaseApi r7 = (CaseApi) this.L$0;
                Long r3 = StringsKt.toLongOrNull(this.$caseId);
                if (r3 == null) goto L11;
                long r4 = r3.longValue();
            L12:
                CaseActionRequest r2 = new CaseActionRequest(Boxing.boxLong(r4), Boxing.boxInt(1));
                this.label = 1;
                r6 = r7.operatorCase(r2, this);
                if (r6 != r0) goto L15;
                return r0;
            L11:
                r4 = 0;
                goto L12
            }
        }

        public C01451(String r1, Continuation<? super C01451> r2) {
            this.$caseId = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01451(this.$caseId, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            CaseApi.a r7 = CaseApi.a;
            C00311 r2 = new C00311(this.$caseId, null);
            this.label = 1;
            r7.getClass();
            if (CaseApi.a.a(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.showcase.view.CaseViewModel$requestMoreCase$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.showcase.view.CaseViewModel$requestMoreCase$1", f = "CaseViewModel.kt", i = {1, 2}, l = {133, 145, 148, 151, 153, 158}, m = "invokeSuspend", n = {"caseResponse", "caseResponse"}, s = {"L$0", "L$0"})
    public static final class C01461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ CaseViewModel this$0;

        public C01461(CaseViewModel r1, Continuation<? super C01461> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01461(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(this.label) {
                case 0: goto L10;
                case 1: goto L9;
                case 2: goto L8;
                case 3: goto L7;
                case 4: goto L6;
                case 5: goto L6;
                case 6: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r12);
        L75:
            return Unit.INSTANCE;
        L7:
            ListCaseResponse r1 = (ListCaseResponse) this.L$0;
            ResultKt.throwOnFailure(r12);
        L56:
            if (r1 == null) goto L58;
            boolean r13 = Intrinsics.areEqual(r1.getHasMore(), Boxing.boxBoolean(true));
        L59:
            if (r13 == false) goto L63;
            MutableSharedFlow<Integer> r14 = this.this$0.getLoadMoreState();
            Integer r2 = Boxing.boxInt(0);
            this.L$0 = null;
            this.label = 4;
            if (r14.emit(r2, this) != r0) goto L75;
            return r0;
        L63:
            MutableSharedFlow<Integer> r15 = this.this$0.getLoadMoreState();
            Integer r3 = Boxing.boxInt(2);
            this.L$0 = null;
            this.label = 5;
            if (r15.emit(r3, this) != r0) goto L75;
            return r0;
        L58:
            r13 = false;
            goto L59
        L8:
            r1 = (ListCaseResponse) this.L$0;
            ResultKt.throwOnFailure(r12);
        L42:
            FLogger r16 = FLogger.a;
            StringBuilder r7 = new StringBuilder("requestMoreCase, current size =");
            CopyOnWriteArrayList r8 = CaseViewModel.access$getCurrentCaseList$p(this.this$0);
            if (r8 == null) goto L45;
            Integer r9 = Boxing.boxInt(r8.size());
        L46:
            r7.append(r9);
            r16.i(CaseViewModel.TAG, r7.toString());
            boolean r17 = this.this$0.getNeedScrollToTop();
            MutableSharedFlow<g> r4 = this.this$0.getCaseListLiveData();
            CaseViewModel r10 = this.this$0;
            if (r1 == null) goto L49;
            boolean r11 = Intrinsics.areEqual(r1.getHasMore(), Boxing.boxBoolean(true));
        L50:
            List r18 = CaseViewModel.access$mergeCase(r10, r11);
            if (r18 != null) goto L53;
            r18 = CollectionsKt.emptyList();
        L53:
            g r19 = new g(3, r18, r17);
            this.L$0 = r1;
            this.label = 3;
            if (r4.emit(r19, this) != r0) goto L56;
            return r0;
        L49:
            r11 = false;
            goto L50
        L45:
            r9 = null;
            goto L46
        L9:
            ResultKt.throwOnFailure(r12);
        L13:
            dm9.a.b r110 = (dm9.a) r12;
            boolean r5 = r110 instanceof dm9.a.b;
            if (r5 == false) goto L67;
            dm9.a.b r20 = r110;
            if (r20.a.isSuccess() == false) goto L67;
            ListCaseResponse r111 = (ListCaseResponse) r20.a.getData();
            if (r111 == null) goto L22;
            List<Case> r6 = r111.getCaseList();
            if (r6 == null) goto L22;
            List r21 = CollectionsKt.filterNotNull(r6);
        L23:
            if (r21 == null) goto L34;
            Iterator r22 = r21.iterator();
        L26:
            if (r22.hasNext() == false) goto L34;
            Case r23 = (Case) r22.next();
            if (r111 == null) goto L32;
            Map<String, String> r24 = r111.getExtra();
            if (r24 == null) goto L32;
            String r25 = r24.get("request_id");
        L33:
            r23.setRequestId(r25);
        L32:
            r25 = null;
        L34:
            if (r21 == null) goto L38;
            CopyOnWriteArrayList r26 = CaseViewModel.access$getCurrentCaseList$p(this.this$0);
            if (r26 == null) goto L38;
            Boxing.boxBoolean(r26.addAll(r21));
        L38:
            CaseRepo r27 = CaseRepo.a;
            CopyOnWriteArrayList r28 = CaseViewModel.access$getCurrentCaseList$p(this.this$0);
            this.L$0 = r111;
            this.label = 2;
            if (CaseRepo.k(r28, false, this) != r0) goto L41;
            return r0;
        L41:
            r1 = r111;
        L22:
            r21 = null;
        L67:
            if ((r110 instanceof dm9.a.a) == true) goto L71;
            if (r5 == false) goto L75;
            if (r110.a.isSuccess() == true) goto L75;
        L71:
            FLogger.a.i(CaseViewModel.TAG, "requestMoreCase, Fail");
            MutableSharedFlow<Integer> r112 = this.this$0.getLoadMoreState();
            Integer r29 = Boxing.boxInt(1);
            this.label = 6;
            if (r112.emit(r29, this) != r0) goto L75;
            return r0;
        L10:
            ResultKt.throwOnFailure(r12);
            CaseViewModel r113 = this.this$0;
            CaseViewModel.access$setCurrentIndex$p(r113, CaseViewModel.access$getCurrentIndex$p(r113) + 1);
            CaseApi.a r114 = CaseApi.a;
            CaseViewModel$requestMoreCase$1$result$1 r30 = new CaseViewModel$requestMoreCase$1$result$1(this.this$0, null);
            this.label = 1;
            r114.getClass();
            r12 = CaseApi.a.a(r30, this);
            if (r12 != r0) goto L13;
            return r0;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a();
    }

    public final void queryCaseList() {
        FLogger.a.i(TAG, "queryCaseList");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, null), 3, null);
    }

    public final void requestMoreCase() {
        FLogger.a.i(TAG, "requestMoreCase，currentIndex = " + this.currentIndex);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01461(this, null), 2, null);
    }

    public CaseViewModel() {
        this.currentCaseList = new CopyOnWriteArrayList();
        CaseRepo r1 = CaseRepo.a;
        this.currentRecommendCaseList = new CopyOnWriteArrayList(CaseRepo.f);
        this.currentIndex = 1;
        this.loadMoreState = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.caseListLiveData = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public final MutableSharedFlow<g> getCaseListLiveData() {
        return this.caseListLiveData;
    }

    public final MutableSharedFlow<Integer> getLoadMoreState() {
        return this.loadMoreState;
    }

    public final boolean getNeedScrollToTop() {
        return this.needScrollToTop;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getCurrentCaseList$p(CaseViewModel r0) {
        return r0.currentCaseList;
    }

    public static final /* synthetic */ int access$getCurrentIndex$p(CaseViewModel r0) {
        return r0.currentIndex;
    }

    private final boolean containsById(String r5) {
        if (r5 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        Iterator<T> r3 = this.currentRecommendCaseList.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((Case) r3.next()).getCaseId(), r5) == false) goto L13;
        return true;
    L17:
        return false;
    L5:
        if (r5.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private final List<Case> mergeCase(boolean r25) {
        ArrayList r1 = new ArrayList();
        CopyOnWriteArrayList<Case> r2 = this.currentRecommendCaseList;
        int r4 = 0;
        if (r2 == null) goto L21;
        Collection r6 = new ArrayList();
        Iterator<T> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L22;
        Object r7 = r3.next();
        Case r8 = (Case) r7;
        Integer r9 = r8.getStatus();
        if (r9 != null) goto L11;
    L12:
        Integer r10 = r8.getStatus();
        if (r10 != null) goto L16;
    L17:
        boolean r11 = true;
    L19:
        if (r11 == false) goto L6;
        r6.add(r7);
        goto L6
    L16:
        if (r10.intValue() != 2) goto L17;
    L18:
        r11 = false;
        goto L19
    L11:
        if (r9.intValue() == 1) goto L18;
    L22:
        r1.addAll(r6);
        CopyOnWriteArrayList<Case> r5 = this.currentCaseList;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r5.iterator();
    L24:
        if (r13.hasNext() == false) goto L41;
        Object r14 = r13.next();
        Case r15 = (Case) r14;
        if (containsById(r15.getCaseId()) == true) goto L38;
        Integer r16 = r15.getStatus();
        if (r16 != null) goto L31;
    L32:
        Integer r17 = r15.getStatus();
        if (r17 != null) goto L36;
    L37:
        boolean r18 = true;
    L39:
        if (r18 == false) goto L24;
        r12.add(r14);
        goto L24
    L36:
        if (r17.intValue() == 2) goto L38;
    L31:
        if (r16.intValue() != 1) goto L32;
    L38:
        r18 = false;
        goto L39
    L41:
        r1.addAll(r12);
        if (r25 == true) goto L71;
        CopyOnWriteArrayList<Case> r19 = this.currentRecommendCaseList;
        ArrayList r20 = new ArrayList();
        Iterator<T> r21 = r19.iterator();
    L45:
        if (r21.hasNext() == false) goto L55;
        Object r22 = r21.next();
        Integer r23 = ((Case) r22).getStatus();
        if (r23 != null) goto L50;
    L52:
        boolean r24 = false;
    L53:
        if (r24 == false) goto L45;
        r20.add(r22);
        goto L45
    L50:
        if (r23.intValue() != 1) goto L52;
        r24 = true;
        goto L53
    L55:
        r1.addAll(r20);
        CopyOnWriteArrayList<Case> r26 = this.currentCaseList;
        ArrayList r27 = new ArrayList();
        Iterator<T> r28 = r26.iterator();
    L57:
        if (r28.hasNext() == false) goto L69;
        Object r29 = r28.next();
        Case r30 = (Case) r29;
        if (containsById(r30.getCaseId()) == true) goto L66;
        Integer r31 = r30.getStatus();
        if (r31 == null) goto L66;
        if (r31.intValue() != 1) goto L66;
        boolean r32 = true;
    L67:
        if (r32 == false) goto L57;
        r27.add(r29);
    L66:
        r32 = false;
        goto L67
    L69:
        r1.addAll(r27);
    L71:
        if (r1.isEmpty() == true) goto L73;
        this.needScrollToTop = false;
    L77:
        return r1;
    L73:
        if (r4 >= 9) goto L75;
        r1.add(new Case(null, null, null, null, null, null, null, null, null, null, null, null, null, false, true, 16383, null));
        r4 = r4 + 1;
        goto L73
    L75:
        this.needScrollToTop = true;
        goto L77
    L21:
        r6 = CollectionsKt.emptyList();
        goto L22
    }

    public final void readCollection(String r8) {
        FLogger.a.i(TAG, "readCollection, caseId = " + r8);
        if (r8 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01451(r8, null), 2, null);
        return;
    L5:
        if (r8.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final void setNeedScrollToTop(boolean r1) {
        this.needScrollToTop = r1;
    }

    public static final /* synthetic */ List access$mergeCase(CaseViewModel r0, boolean r1) {
        return r0.mergeCase(r1);
    }

    public static final /* synthetic */ void access$setCurrentIndex$p(CaseViewModel r0, int r1) {
        r0.currentIndex = r1;
    }

    public static /* synthetic */ List mergeCase$default(CaseViewModel r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = true;
    L6:
        return r0.mergeCase(r1);
    }
}
