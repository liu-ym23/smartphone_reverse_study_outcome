package com.larus.ugc.feed.impl.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.platform.api.creation.DisplayExtra;
import com.larus.platform.api.creation.TabItemInfo;
import com.larus.ugc.feed.api.model.DisplayExtraKmp;
import com.larus.ugc.feed.api.model.FabVisibilityStateKmp;
import com.larus.ugc.feed.api.model.TabItemInfoKmp;
import com.larus.ugc.feed.api.model.UserCreationKmp;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020#0\u0007H\u0002J\u000e\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020!R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\n8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\n8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\fR\u000e\u0010\u001d\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/ugc/feed/impl/home/CommunityCreateLegacyBridgeViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/ugc/feed/impl/home/CommunityCreateBridgeEmptyState;", "<init>", "()V", "_tabListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/larus/platform/api/creation/TabItemInfo;", "tabListLiveData", "Landroidx/lifecycle/LiveData;", "getTabListLiveData", "()Landroidx/lifecycle/LiveData;", "_currentTabIndexLiveData", "", "currentTabIndexLiveData", "getCurrentTabIndexLiveData", "_fabVisibilityLiveData", "Lcom/larus/ugc/feed/api/model/FabVisibilityStateKmp;", "fabVisibilityLiveData", "getFabVisibilityLiveData", "_showAvatarLiveData", "", "showAvatarLiveData", "getShowAvatarLiveData", "_pendingPublishedCreationLiveData", "Lcom/larus/ugc/feed/api/model/UserCreationKmp;", "pendingPublishedCreationLiveData", "getPendingPublishedCreationLiveData", "bound", "bind", "", "ability", "Lcom/larus/ugc/feed/api/ability/IKMPCommunityCreateAbility;", "toPlatformList", "Lcom/larus/ugc/feed/api/model/TabItemInfoKmp;", "currentSnapshot", "Lcom/larus/ugc/feed/api/model/CommunityCreateUiStateKmp;", "Companion", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommunityCreateLegacyBridgeViewModel extends ComponentViewModel<CommunityCreateBridgeEmptyState> {
    public static final int $stable = 0;
    private static final a Companion = null;
    private static final String TAG = "CommunityCreateLegacyBridgeViewModel";
    private final MutableLiveData<Integer> _currentTabIndexLiveData;
    private final MutableLiveData<FabVisibilityStateKmp> _fabVisibilityLiveData;
    private final MutableLiveData<UserCreationKmp> _pendingPublishedCreationLiveData;
    private final MutableLiveData<Boolean> _showAvatarLiveData;
    private final MutableLiveData<List<TabItemInfo>> _tabListLiveData;
    private volatile boolean bound;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$2", f = "CommunityCreateLegacyBridgeViewModel.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i1<m0a.f> $flow;
        int label;
        final /* synthetic */ CommunityCreateLegacyBridgeViewModel this$0;

        /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$2$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CommunityCreateLegacyBridgeViewModel a;

            public a(CommunityCreateLegacyBridgeViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                MutableLiveData r4 = CommunityCreateLegacyBridgeViewModel.access$get_tabListLiveData$p(this.a);
                CommunityCreateLegacyBridgeViewModel r0 = this.a;
                r4.postValue(CommunityCreateLegacyBridgeViewModel.access$toPlatformList(r0, (List) r2));
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass2(i1<m0a.f> r1, CommunityCreateLegacyBridgeViewModel r2, Continuation<? super AnonymousClass2> r3) {
            this.$flow = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.$flow, this.this$0, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            final i1<m0a.f> r6 = this.$flow;
            Flow r7 = kotlinx.coroutines.flow.e.n(new CommunityCreateLegacyBridgeViewModel$bind$2$invokeSuspend$$inlined$map$1(r6));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$3", f = "CommunityCreateLegacyBridgeViewModel.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i1<m0a.f> $flow;
        int label;
        final /* synthetic */ CommunityCreateLegacyBridgeViewModel this$0;

        /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$3$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CommunityCreateLegacyBridgeViewModel a;

            public a(CommunityCreateLegacyBridgeViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                int r3 = ((Number) r1).intValue();
                CommunityCreateLegacyBridgeViewModel.access$get_currentTabIndexLiveData$p(this.a).postValue(Boxing.boxInt(r3));
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(i1<m0a.f> r1, CommunityCreateLegacyBridgeViewModel r2, Continuation<? super AnonymousClass3> r3) {
            this.$flow = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass3(this.$flow, this.this$0, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            final i1<m0a.f> r6 = this.$flow;
            Flow r7 = kotlinx.coroutines.flow.e.n(new CommunityCreateLegacyBridgeViewModel$bind$3$invokeSuspend$$inlined$map$1(r6));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$4", f = "CommunityCreateLegacyBridgeViewModel.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i1<m0a.f> $flow;
        int label;
        final /* synthetic */ CommunityCreateLegacyBridgeViewModel this$0;

        /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$4$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CommunityCreateLegacyBridgeViewModel a;

            public a(CommunityCreateLegacyBridgeViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                MutableLiveData r3 = CommunityCreateLegacyBridgeViewModel.access$get_fabVisibilityLiveData$p(this.a);
                r3.postValue((FabVisibilityStateKmp) r1);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass4(i1<m0a.f> r1, CommunityCreateLegacyBridgeViewModel r2, Continuation<? super AnonymousClass4> r3) {
            this.$flow = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass4(this.$flow, this.this$0, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            final i1<m0a.f> r6 = this.$flow;
            Flow r7 = kotlinx.coroutines.flow.e.n(new CommunityCreateLegacyBridgeViewModel$bind$4$invokeSuspend$$inlined$map$1(r6));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$5", f = "CommunityCreateLegacyBridgeViewModel.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i1<m0a.f> $flow;
        int label;
        final /* synthetic */ CommunityCreateLegacyBridgeViewModel this$0;

        /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$5$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CommunityCreateLegacyBridgeViewModel a;

            public a(CommunityCreateLegacyBridgeViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                boolean r3 = ((Boolean) r1).booleanValue();
                CommunityCreateLegacyBridgeViewModel.access$get_showAvatarLiveData$p(this.a).postValue(Boxing.boxBoolean(r3));
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass5(i1<m0a.f> r1, CommunityCreateLegacyBridgeViewModel r2, Continuation<? super AnonymousClass5> r3) {
            this.$flow = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass5(this.$flow, this.this$0, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            final i1<m0a.f> r6 = this.$flow;
            Flow r7 = kotlinx.coroutines.flow.e.n(new CommunityCreateLegacyBridgeViewModel$bind$5$invokeSuspend$$inlined$map$1(r6));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$6", f = "CommunityCreateLegacyBridgeViewModel.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ i1<m0a.f> $flow;
        int label;
        final /* synthetic */ CommunityCreateLegacyBridgeViewModel this$0;

        /* JADX INFO: renamed from: com.larus.ugc.feed.impl.home.CommunityCreateLegacyBridgeViewModel$bind$6$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ CommunityCreateLegacyBridgeViewModel a;

            public a(CommunityCreateLegacyBridgeViewModel r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                MutableLiveData r3 = CommunityCreateLegacyBridgeViewModel.access$get_pendingPublishedCreationLiveData$p(this.a);
                r3.postValue((UserCreationKmp) r1);
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass6(i1<m0a.f> r1, CommunityCreateLegacyBridgeViewModel r2, Continuation<? super AnonymousClass6> r3) {
            this.$flow = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass6(this.$flow, this.this$0, r4);
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
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            final i1<m0a.f> r6 = this.$flow;
            Flow r7 = kotlinx.coroutines.flow.e.n(new CommunityCreateLegacyBridgeViewModel$bind$6$invokeSuspend$$inlined$map$1(r6));
            a r2 = new a(this.this$0);
            this.label = 1;
            if (r7.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a();
        $stable = 8;
    }

    public static /* synthetic */ String No() {
        return bind$lambda$0();
    }

    private static final String bind$lambda$0() {
        return "bind already, skip";
    }

    public CommunityCreateLegacyBridgeViewModel() {
        this._tabListLiveData = new MutableLiveData(CollectionsKt.emptyList());
        this._currentTabIndexLiveData = new MutableLiveData(0);
        this._fabVisibilityLiveData = new MutableLiveData(FabVisibilityStateKmp.VISIBLE);
        this._showAvatarLiveData = new MutableLiveData(Boolean.FALSE);
        this._pendingPublishedCreationLiveData = new MutableLiveData(null);
    }

    public final LiveData<Integer> getCurrentTabIndexLiveData() {
        return this._currentTabIndexLiveData;
    }

    public final LiveData<FabVisibilityStateKmp> getFabVisibilityLiveData() {
        return this._fabVisibilityLiveData;
    }

    public final LiveData<UserCreationKmp> getPendingPublishedCreationLiveData() {
        return this._pendingPublishedCreationLiveData;
    }

    public final LiveData<Boolean> getShowAvatarLiveData() {
        return this._showAvatarLiveData;
    }

    public final LiveData<List<TabItemInfo>> getTabListLiveData() {
        return this._tabListLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_currentTabIndexLiveData$p(CommunityCreateLegacyBridgeViewModel r0) {
        return r0._currentTabIndexLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_fabVisibilityLiveData$p(CommunityCreateLegacyBridgeViewModel r0) {
        return r0._fabVisibilityLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_pendingPublishedCreationLiveData$p(CommunityCreateLegacyBridgeViewModel r0) {
        return r0._pendingPublishedCreationLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_showAvatarLiveData$p(CommunityCreateLegacyBridgeViewModel r0) {
        return r0._showAvatarLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$get_tabListLiveData$p(CommunityCreateLegacyBridgeViewModel r0) {
        return r0._tabListLiveData;
    }

    private final List<TabItemInfo> toPlatformList(List<TabItemInfoKmp> r12) {
        List<TabItemInfoKmp> r13 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator<T> r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        TabItemInfoKmp r1 = (TabItemInfoKmp) r14.next();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r4 = r1.getId();
        String r5 = r1.getStarlingKey();
        String r6 = r1.getName();
        Boolean r7 = r1.getSupportTextReplace();
        DisplayExtraKmp r2 = r1.getDisplayExtra();
        if (r2 == null) goto L8;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        DisplayExtra r8 = new DisplayExtra(r2.getTextColor(), r2.getDarkTextColor(), r2.getIconUrl(), r2.getDarkIconUrl());
    L9:
        r0.add(new TabItemInfo(r4, r5, r6, r7, r8));
        goto L4
    L8:
        r8 = null;
        goto L9
    L10:
        return r0;
    }

    public final void bind(g0a.f r26) {
        Intrinsics.checkNotNullParameter(r26, "ability");
        if (this.bound == false) goto L6;
        w0a.a.a(TAG, new n());
        return;
    L6:
        this.bound = true;
        w0a.a.c(TAG, "bind");
        i1<m0a.f> r1 = r26.getUiState();
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass2(r1, this, null), 3, null);
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass3(r1, this, null), 3, null);
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass4(r1, this, null), 3, null);
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass5(r1, this, null), 3, null);
        BuildersKt.launch$default(getViewModelScope(), null, null, new AnonymousClass6(r1, this, null), 3, null);
    }

    public final m0a.f currentSnapshot(g0a.f r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        return (m0a.f) r2.getUiState().getValue();
    }

    public static final /* synthetic */ List access$toPlatformList(CommunityCreateLegacyBridgeViewModel r0, List r1) {
        return r0.toPlatformList(r1);
    }
}
