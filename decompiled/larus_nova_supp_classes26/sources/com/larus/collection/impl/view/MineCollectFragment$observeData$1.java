package com.larus.collection.impl.view;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.utils.LoadMoreManager;
import com.larus.profile.impl.databinding.LarusFragmentMineCollectListBinding;
import com.larus.profile.impl.databinding.LarusPageCollectErrorBinding;
import com.larus.profile.impl.databinding.LarusPageCollectListEmptyBinding;
import com.larus.profile.impl.databinding.LarusPageCollectLoadingSkeletonBinding;
import com.larus.utils.SafeExtKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.collection.impl.view.MineCollectFragment$observeData$1", f = "MineCollectFragment.kt", i = {}, l = {425}, m = "invokeSuspend", n = {}, s = {})
final class MineCollectFragment$observeData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MineCollectFragment this$0;

    /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectFragment$observeData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.collection.impl.view.MineCollectFragment$observeData$1$1", f = "MineCollectFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MineCollectFragment this$0;

        /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectFragment$observeData$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.collection.impl.view.MineCollectFragment$observeData$1$1$1", f = "MineCollectFragment.kt", i = {}, l = {427}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MineCollectFragment this$0;

            /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectFragment$observeData$1$1$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ MineCollectFragment a;

                public a(MineCollectFragment r1) {
                    this.a = r1;
                }

                public final Object emit(Object r7, Continuation r8) {
                    final b r9 = (b) r7;
                    int r10 = r9.a;
                    com.larus.voice_setting.voice.base.a r1 = null;
                    if (r10 != 1) goto L5;
                    FLogger.a.i(this.a.j, "[observeData], query list FAIL");
                    LarusFragmentMineCollectListBinding r11 = this.a.n;
                    if (r11 == null) goto L101;
                    LarusPageCollectLoadingSkeletonBinding r12 = r11.e;
                    if (r12 == null) goto L101;
                    ConstraintLayout r13 = r12.a;
                    if (r13 == null) goto L101;
                    e1.o(r13);
                L101:
                    LarusFragmentMineCollectListBinding r14 = this.a.n;
                    if (r14 == null) goto L108;
                    LarusPageCollectListEmptyBinding r15 = r14.b;
                    if (r15 == null) goto L108;
                    ConstraintLayout r16 = r15.a;
                    if (r16 == null) goto L108;
                    e1.o(r16);
                L108:
                    LarusFragmentMineCollectListBinding r17 = this.a.n;
                    if (r17 == null) goto L113;
                    RecyclerView r18 = r17.d;
                    if (r18 == null) goto L113;
                    e1.o(r18);
                L113:
                    LarusFragmentMineCollectListBinding r19 = this.a.n;
                    if (r19 == null) goto L120;
                    LarusPageCollectErrorBinding r20 = r19.c;
                    if (r20 == null) goto L120;
                    ConstraintLayout r21 = r20.a;
                    if (r21 == null) goto L120;
                    e1.x(r21);
                L120:
                    final MineCollectFragment r22 = this.a;
                    LarusFragmentMineCollectListBinding r23 = r22.n;
                    if (r23 == null) goto L127;
                    LarusPageCollectErrorBinding r24 = r23.c;
                    if (r24 == null) goto L127;
                    ConstraintLayout r25 = r24.a;
                    if (r25 == null) goto L127;
                    r25.setOnClickListener(new h(r22));
                L127:
                    Fragment r26 = this.a.getParentFragment();
                    if ((r26 instanceof com.larus.voice_setting.voice.base.a) == false) goto L130;
                    r1 = (com.larus.voice_setting.voice.base.a) r26;
                L130:
                    if (r1 == null) goto L133;
                    r1.Ym("MineCollectFragment#" + this.a.k, true);
                L133:
                    return Unit.INSTANCE;
                L5:
                    if (r10 != 3) goto L7;
                    FLogger r27 = FLogger.a;
                    r27.i(this.a.j, "[observeData], query list SUCCESS");
                    MineCollectFragment r3 = this.a;
                    r3.getClass();
                    r27.i(r3.j, "resetReloadStatue");
                    r3.s = false;
                    LarusFragmentMineCollectListBinding r4 = this.a.n;
                    if (r4 == null) goto L44;
                    LarusPageCollectLoadingSkeletonBinding r5 = r4.e;
                    if (r5 == null) goto L44;
                    ConstraintLayout r6 = r5.a;
                    if (r6 == null) goto L44;
                    e1.o(r6);
                L44:
                    LarusFragmentMineCollectListBinding r28 = this.a.n;
                    if (r28 == null) goto L52;
                    LarusPageCollectErrorBinding r29 = r28.c;
                    if (r29 == null) goto L52;
                    ConstraintLayout r30 = r29.a;
                    if (r30 == null) goto L52;
                    e1.o(r30);
                L52:
                    if (r9.b.isEmpty() == false) goto L73;
                    r27.i(this.a.j, "[observeData], collection list is empty");
                    CollectionListAdapter r31 = this.a.Z90();
                    if (r31 == null) goto L56;
                    r31.submitList(CollectionsKt.emptyList());
                L56:
                    LarusFragmentMineCollectListBinding r32 = this.a.n;
                    if (r32 == null) goto L61;
                    RecyclerView r33 = r32.d;
                    if (r33 == null) goto L61;
                    e1.o(r33);
                L61:
                    LarusFragmentMineCollectListBinding r34 = this.a.n;
                    if (r34 == null) goto L68;
                    LarusPageCollectListEmptyBinding r35 = r34.b;
                    if (r35 == null) goto L68;
                    ConstraintLayout r36 = r35.a;
                    if (r36 == null) goto L68;
                    e1.x(r36);
                L68:
                    Fragment r37 = this.a.getParentFragment();
                    if ((r37 instanceof com.larus.voice_setting.voice.base.a) == false) goto L71;
                    r1 = (com.larus.voice_setting.voice.base.a) r37;
                L71:
                    if (r1 == null) goto L133;
                    r1.Ym("MineCollectFragment#" + this.a.k, true);
                    goto L133
                L73:
                    LarusFragmentMineCollectListBinding r2 = this.a.n;
                    if (r2 == null) goto L80;
                    LarusPageCollectListEmptyBinding r38 = r2.b;
                    if (r38 == null) goto L80;
                    ConstraintLayout r39 = r38.a;
                    if (r39 == null) goto L80;
                    e1.o(r39);
                L80:
                    LarusFragmentMineCollectListBinding r40 = this.a.n;
                    if (r40 == null) goto L85;
                    RecyclerView r41 = r40.d;
                    if (r41 == null) goto L85;
                    e1.x(r41);
                L85:
                    r27.i(this.a.j, "[observeData], collection list size is " + r9.b.size());
                    CollectionListAdapter r42 = this.a.Z90();
                    if (r42 == null) goto L88;
                    r42.submitList(CollectionsKt.toMutableList(r9.b));
                L88:
                    Fragment r43 = this.a.getParentFragment();
                    if ((r43 instanceof com.larus.voice_setting.voice.base.a) == false) goto L91;
                    r1 = (com.larus.voice_setting.voice.base.a) r43;
                L91:
                    if (r1 == null) goto L93;
                    r1.Ym("MineCollectFragment#" + this.a.k, false);
                L93:
                    final MineCollectFragment r44 = this.a;
                    SafeExtKt.c(r44, new i(r44, r9), 200);
                    goto L133
                L7:
                    if (r10 != 4) goto L9;
                    FLogger.a.i(this.a.j, "[observeData], query list LOADING");
                    LarusFragmentMineCollectListBinding r45 = this.a.n;
                    if (r45 == null) goto L23;
                    LarusPageCollectLoadingSkeletonBinding r46 = r45.e;
                    if (r46 == null) goto L23;
                    ConstraintLayout r47 = r46.a;
                    if (r47 == null) goto L23;
                    e1.x(r47);
                L23:
                    LarusFragmentMineCollectListBinding r48 = this.a.n;
                    if (r48 == null) goto L30;
                    LarusPageCollectListEmptyBinding r49 = r48.b;
                    if (r49 == null) goto L30;
                    ConstraintLayout r50 = r49.a;
                    if (r50 == null) goto L30;
                    e1.o(r50);
                L30:
                    LarusFragmentMineCollectListBinding r51 = this.a.n;
                    if (r51 == null) goto L133;
                    LarusPageCollectErrorBinding r52 = r51.c;
                    if (r52 == null) goto L133;
                    ConstraintLayout r53 = r52.a;
                    if (r53 == null) goto L133;
                    e1.o(r53);
                    goto L133
                L9:
                    if (r10 != 5) goto L133;
                    FLogger.a.i(this.a.j, "[observeData], query list DOWNGRADE");
                    Fragment r54 = this.a.getParentFragment();
                    if ((r54 instanceof com.larus.voice_setting.voice.base.a) == false) goto L14;
                    r1 = (com.larus.voice_setting.voice.base.a) r54;
                L14:
                    if (r1 == null) goto L133;
                    r1.Ym("MineCollectFragment#" + this.a.k, true);
                    goto L133
                }
            }

            public C00991(MineCollectFragment r1, Continuation<? super C00991> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00991(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                MineCollectFragment r6 = this.this$0;
                Integer r2 = MineCollectFragment.x;
                MutableSharedFlow<b> r7 = r6.aa0().getCollectionListLiveData();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectFragment$observeData$1$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.collection.impl.view.MineCollectFragment$observeData$1$1$2", f = "MineCollectFragment.kt", i = {}, l = {493}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MineCollectFragment this$0;

            /* JADX INFO: renamed from: com.larus.collection.impl.view.MineCollectFragment$observeData$1$1$2$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ MineCollectFragment a;

                public a(MineCollectFragment r1) {
                    this.a = r1;
                }

                public final Object emit(Object r2, Continuation r3) {
                    int r4 = ((Number) r2).intValue();
                    MineCollectFragment r5 = this.a;
                    r5.t = false;
                    if (r4 != 0) goto L5;
                    FLogger.a.i(r5.j, "[observeData], loadMoreState=HAS_MORE");
                    LoadMoreManager r6 = this.a.o;
                    if (r6 == null) goto L19;
                    r6.c();
                L19:
                    return Unit.INSTANCE;
                L5:
                    if (r4 != 1) goto L7;
                    FLogger.a.i(r5.j, "[observeData], loadMoreState=FAIL");
                    LoadMoreManager r7 = this.a.o;
                    if (r7 == null) goto L19;
                    r7.b();
                    goto L19
                L7:
                    if (r4 != 2) goto L19;
                    FLogger.a.i(r5.j, "[observeData], loadMoreState=END");
                    LoadMoreManager r8 = this.a.o;
                    if (r8 == null) goto L19;
                    r8.a();
                    goto L19
                }
            }

            public AnonymousClass2(MineCollectFragment r1, Continuation<? super AnonymousClass2> r2) {
                this.this$0 = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass2(this.this$0, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r5) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                ResultKt.throwOnFailure(r5);
            L12:
                throw new KotlinNothingValueException();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r5);
                MineCollectFragment r6 = this.this$0;
                Integer r2 = MineCollectFragment.x;
                MutableSharedFlow<Integer> r7 = r6.aa0().getLoadMoreState();
                a r3 = new a(this.this$0);
                this.label = 1;
                if (r7.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(MineCollectFragment r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            CoroutineScope r9 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r9, null, null, new C00991(this.this$0, null), 3, null);
            BuildersKt.launch$default(r9, null, null, new AnonymousClass2(this.this$0, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MineCollectFragment$observeData$1(MineCollectFragment r1, Continuation<? super MineCollectFragment$observeData$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MineCollectFragment$observeData$1(this.this$0, r3);
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
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        LifecycleOwner r8 = this.this$0.getViewLifecycleOwner();
        Lifecycle.State r2 = Lifecycle.State.STARTED;
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (RepeatOnLifecycleKt.repeatOnLifecycle(r8, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
