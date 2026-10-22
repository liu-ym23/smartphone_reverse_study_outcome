package com.larus.community.impl.publish.viewmodel;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.community.impl.api.CreationRecommendApi;
import com.larus.im.bean.message.Message;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.e0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import t19.s;
import tx9.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$J\u0016\u0010%\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010&R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00140\u00140\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00140\u00140\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006'"}, d2 = {"Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_publisherCreationFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/community/impl/publish/viewmodel/PublishCreationState;", "publisherCreationFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getPublisherCreationFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_publishLoadingFlow", "Lcom/larus/community/impl/publish/viewmodel/PublishLoadingState;", "publishLoadingFlow", "getPublishLoadingFlow", "_successUserCreationFlow", "Lcom/larus/platform/api/creation/UserCreation;", "successUserCreationFlow", "getSuccessUserCreationFlow", "_finishActivityEventFlow", "", "finishActivityEventFlow", "getFinishActivityEventFlow", "initialize", "", "publisherCreation", "Lcom/larus/platform/api/creation/PublisherCreation;", "_publishLiveState", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "publishLiveState", "getPublishLiveState", "()Landroidx/lifecycle/MutableLiveData;", "publish", "isPublic", "caption", "", "addCreation", "(Lcom/larus/platform/api/creation/PublisherCreation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishViewModel extends ViewModel {
    private final z0<Boolean> _finishActivityEventFlow;
    private final MutableLiveData<Boolean> _publishLiveState;
    private final z0<i> _publishLoadingFlow;
    private final z0<h> _publisherCreationFlow;
    private final z0<UserCreation> _successUserCreationFlow;
    private final i1<Boolean> finishActivityEventFlow;
    private final MutableLiveData<Boolean> publishLiveState;
    private final i1<i> publishLoadingFlow;
    private final i1<h> publisherCreationFlow;
    private final i1<UserCreation> successUserCreationFlow;

    /* JADX INFO: renamed from: com.larus.community.impl.publish.viewmodel.CreationPublishViewModel$addCreation$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.viewmodel.CreationPublishViewModel", f = "CreationPublishViewModel.kt", i = {0, 0, 0, 0, 1, 3, 3, 3, 4, 4, 5, 6}, l = {150, 157, 171, 177, 179, 189, 197}, m = "addCreation", n = {"publisherCreation", "canvasSubId", "canvasId", "taskId", "canvasSubId", "publisherCreation", "type", "messageId", "publisherCreation", "messageId", "messageId", "messageId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CreationPublishViewModel this$0;

        public AnonymousClass1(CreationPublishViewModel r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return CreationPublishViewModel.access$addCreation(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.publish.viewmodel.CreationPublishViewModel$initialize$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.viewmodel.CreationPublishViewModel$initialize$1", f = "CreationPublishViewModel.kt", i = {}, l = {74, 75, 76, 78, 79}, m = "invokeSuspend", n = {}, s = {})
    public static final class C01611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PublisherCreation $publisherCreation;
        int label;
        final /* synthetic */ CreationPublishViewModel this$0;

        public C01611(PublisherCreation r1, CreationPublishViewModel r2, Continuation<? super C01611> r3) {
            this.$publisherCreation = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new C01611(this.$publisherCreation, this.this$0, r4);
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
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L13;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r8);
        L30:
            z0 r9 = CreationPublishViewModel.access$get_publisherCreationFlow$p(this.this$0);
            h r2 = new h(this.$publisherCreation, true);
            this.label = 5;
            if (r9.emit(r2, this) != r0) goto L34;
            return r0;
        L34:
            return Unit.INSTANCE;
        L13:
            ResultKt.throwOnFailure(r8);
            goto L34
        L14:
            ResultKt.throwOnFailure(r8);
        L24:
            CreationPublishViewModel r10 = this.this$0;
            PublisherCreation r3 = this.$publisherCreation;
            this.label = 3;
            if (CreationPublishViewModel.access$addCreation(r10, r3, this) != r0) goto L34;
            return r0;
        L15:
            ResultKt.throwOnFailure(r8);
        L21:
            z0 r11 = CreationPublishViewModel.access$get_publishLoadingFlow$p(this.this$0);
            i.b r4 = i.b.a;
            this.label = 2;
            if (r11.emit(r4, this) != r0) goto L24;
            return r0;
        L16:
            ResultKt.throwOnFailure(r8);
            if (this.$publisherCreation.isInfoNotEnough() == false) goto L27;
            z0 r12 = CreationPublishViewModel.access$get_publisherCreationFlow$p(this.this$0);
            h r5 = new h(this.$publisherCreation, false);
            this.label = 1;
            if (r12.emit(r5, this) != r0) goto L21;
            return r0;
        L27:
            z0 r13 = CreationPublishViewModel.access$get_publishLoadingFlow$p(this.this$0);
            i.a r6 = i.a.a;
            this.label = 4;
            if (r13.emit(r6, this) != r0) goto L30;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.community.impl.publish.viewmodel.CreationPublishViewModel$publish$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.community.impl.publish.viewmodel.CreationPublishViewModel$publish$1", f = "CreationPublishViewModel.kt", i = {0, 1}, l = {98, 99, 112, 136}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    public static final class C01621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $caption;
        final /* synthetic */ PublisherCreation $finalPublishCreation;
        final /* synthetic */ boolean $isPublic;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CreationPublishViewModel this$0;

        public C01621(CreationPublishViewModel r1, PublisherCreation r2, boolean r3, String r4, Continuation<? super C01621> r5) {
            this.this$0 = r1;
            this.$finalPublishCreation = r2;
            this.$isPublic = r3;
            this.$caption = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C01621 r6 = new C01621(this.this$0, this.$finalPublishCreation, this.$isPublic, this.$caption, r9);
            r6.L$0 = r8;
            return r6;
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
            boolean r6 = true;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 != 4) goto L10;
            ResultKt.throwOnFailure(r13);
        L54:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r13);
        L31:
            FLogger.a.i("CreationPublishViewModel", "success in publish");
        L50:
            z0 r14 = CreationPublishViewModel.access$get_publishLoadingFlow$p(this.this$0);
            i.a r2 = i.a.a;
            this.L$0 = null;
            this.label = 4;
            if (r14.emit(r2, this) != r0) goto L54;
            return r0;
        L12:
            CoroutineScope r3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L20:
            dm9.a.b r15 = (dm9.a) r13;
            if ((r15 instanceof dm9.a.b) == false) goto L49;
            dm9.a.b r16 = r15;
            if (r16.a.isSuccess() == false) goto L32;
            z0 r4 = CreationPublishViewModel.access$get_successUserCreationFlow$p(this.this$0);
            com.larus.community.impl.api.i r17 = (com.larus.community.impl.api.i) r16.a.getData();
            if (r17 == null) goto L27;
            UserCreation r18 = r17.a();
        L28:
            this.L$0 = null;
            this.label = 3;
            if (r4.emit(r18, this) != r0) goto L31;
            return r0;
        L27:
            r18 = null;
            goto L28
        L32:
            FLogger.a.e("CreationPublishViewModel", "error:" + r16.a.getMsg());
            String r5 = r16.a.getMsg();
            if (r5 != null) goto L35;
        L48:
            s r110 = s.a;
            Application r7 = AppHost.a.getApplication();
            r110.getClass();
            s.s(r7, 2131908624);
            goto L50
        L35:
            if (r5.length() <= 0) goto L37;
            boolean r8 = true;
        L38:
            if (r8 == true) goto L40;
        L42:
            r6 = false;
        L43:
            if (r6 == true) goto L46;
            r5 = null;
        L46:
            if (r5 == null) goto L48;
            s r111 = s.a;
            Application r9 = AppHost.a.getApplication();
            r111.getClass();
            s.t(r9, r5);
            goto L50
        L40:
            if (r16.a.getCode() < 710082017) goto L42;
        L37:
            r8 = false;
            goto L38
        L49:
            FLogger.a.e("CreationPublishViewModel", "error:" + r15);
            s r112 = s.a;
            Application r10 = AppHost.a.getApplication();
            r112.getClass();
            s.s(r10, 2131908080);
            goto L50
        L13:
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r13);
        L17:
            CreationRecommendApi.a r113 = CreationRecommendApi.a;
            CreationPublishViewModel$publish$1$result$1 r12 = new CreationPublishViewModel$publish$1$result$1(this.$finalPublishCreation, this.$isPublic, this.$caption, null);
            this.L$0 = r11;
            this.label = 2;
            r113.getClass();
            r13 = CreationRecommendApi.a.c(r12, this);
            if (r13 != r0) goto L20;
            return r0;
        L14:
            ResultKt.throwOnFailure(r13);
            r11 = (CoroutineScope) this.L$0;
            z0 r114 = CreationPublishViewModel.access$get_publishLoadingFlow$p(this.this$0);
            i.c r20 = i.c.a;
            this.L$0 = r11;
            this.label = 1;
            if (r114.emit(r20, this) != r0) goto L17;
            return r0;
        }
    }

    public static /* synthetic */ String yo(PublisherCreation r0) {
        return addCreation$lambda$0(r0);
    }

    public CreationPublishViewModel() {
        StateFlowImpl r1 = j1.a(null);
        this._publisherCreationFlow = r1;
        this.publisherCreationFlow = r1;
        StateFlowImpl r2 = j1.a(i.a.a);
        this._publishLoadingFlow = r2;
        this.publishLoadingFlow = r2;
        StateFlowImpl r0 = j1.a(null);
        this._successUserCreationFlow = r0;
        this.successUserCreationFlow = r0;
        Boolean r3 = Boolean.FALSE;
        StateFlowImpl r4 = j1.a(r3);
        this._finishActivityEventFlow = r4;
        this.finishActivityEventFlow = r4;
        MutableLiveData<Boolean> r5 = new MutableLiveData(r3);
        this._publishLiveState = r5;
        this.publishLiveState = r5;
    }

    public final i1<Boolean> getFinishActivityEventFlow() {
        return this.finishActivityEventFlow;
    }

    public final MutableLiveData<Boolean> getPublishLiveState() {
        return this.publishLiveState;
    }

    public final i1<i> getPublishLoadingFlow() {
        return this.publishLoadingFlow;
    }

    public final i1<h> getPublisherCreationFlow() {
        return this.publisherCreationFlow;
    }

    public final i1<UserCreation> getSuccessUserCreationFlow() {
        return this.successUserCreationFlow;
    }

    public static final /* synthetic */ z0 access$get_publishLoadingFlow$p(CreationPublishViewModel r0) {
        return r0._publishLoadingFlow;
    }

    public static final /* synthetic */ z0 access$get_publisherCreationFlow$p(CreationPublishViewModel r0) {
        return r0._publisherCreationFlow;
    }

    public static final /* synthetic */ z0 access$get_successUserCreationFlow$p(CreationPublishViewModel r0) {
        return r0._successUserCreationFlow;
    }

    private static final String addCreation$lambda$0(PublisherCreation r2) {
        return "addCreation " + HttpExtKt.p(r2);
    }

    public final void initialize(PublisherCreation r8) {
        Intrinsics.checkNotNullParameter(r8, "publisherCreation");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C01611(r8, this, null), 3, null);
    }

    /* JADX WARN: Failed to calculate best type for var: r11v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v2 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v2 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v2 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v2 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v3 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v3 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v3 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v3 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v4 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v4 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v4 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v4 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v5 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r11v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v5 ??, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r11v2 com.larus.platform.api.creation.PublisherCreation, new type: com.larus.platform.api.creation.PublisherCreation
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 5 more
     */
    private final Object addCreation(PublisherCreation r36, Continuation<? super Unit> r37) {
        final PublisherCreation r1 = r36;
        if ((r37 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r3 = (AnonymousClass1) r37;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r3.label) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L12;
            default: goto L11;
        };
    L12:
        String r5 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L94:
        m0.a(r5, null, null, null, null, false, null, null, null, 2046);
    L97:
        return Unit.INSTANCE;
    L14:
        r5 = (String) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L91:
        z0<i> r6 = this._publishLoadingFlow;
        i.a r7 = i.a.a;
        r3.L$0 = r5;
        r3.label = 7;
        if (r6.emit(r7, r3) != r13) goto L94;
        return r13;
    L15:
        r5 = (String) r3.L$1;
        PublisherCreation r8 = (PublisherCreation) r3.L$0;
        ResultKt.throwOnFailure(r2);
        boolean r14 = true;
    L77:
        zp9.a r9 = (zp9.a) r2;
        if (r9 != null) goto L80;
    L82:
        boolean r10 = false;
    L83:
        if (r10 == false) goto L95;
        z0<h> r11 = this._publisherCreationFlow;
        UserCreation r12 = r9.b;
        if (r12 == null) goto L87;
        PublisherCreation r15 = PublisherCreation.copy$default(zp9.d.g(r12, r8.getTaskId()), null, null, null, r5, null, null, null, null, null, false, null, null, null, null, 16375, null);
    L88:
        h r16 = new h(r15, r14);
        r3.L$0 = r5;
        r3.L$1 = 0;
        r3.label = 6;
        if (r11.emit(r16, r3) != r13) goto L91;
        return r13;
    L87:
        r15 = r11;
        goto L88
    L95:
        s r17 = s.a;
        Application r18 = AppHost.a.getApplication();
        r17.getClass();
        s.s(r18, 2131908080);
        goto L97
    L80:
        if (r9.a != r14) goto L82;
        r10 = true;
        goto L83
    L16:
        String r20 = (String) r3.L$2;
        Integer r21 = (Integer) r3.L$1;
        PublisherCreation r22 = (PublisherCreation) r3.L$0;
        ResultKt.throwOnFailure(r2);
        String r23 = r20;
        r1 = r22;
        Object r24 = r2;
    L62:
        Message r25 = (Message) r24;
        if (r21 == null) goto L99;
        int r26 = r21.intValue();
        e0 r27 = e0.a;
        String r28 = String.valueOf(r1.getIndex());
        String r30 = r1.getTaskId();
        if (r25 != null) goto L67;
    L69:
        boolean r31 = false;
    L70:
        if (r31 == false) goto L72;
        int r110 = 4;
    L73:
        String r111 = r1.getMaterialId();
        r3.L$0 = r1;
        r3.L$1 = r23;
        r3.L$2 = null;
        r3.label = 5;
        r14 = true;
        Object r32 = r27.l(r23, r26, r28, 2, r30, r110, r111, r3);
        if (r32 != r13) goto L76;
        return r13;
    L76:
        r8 = r1;
        r5 = r23;
        r2 = r32;
        goto L77
    L72:
        r110 = 1;
        goto L73
    L67:
        if (com.larus.bmhome.chat.bean.d.k(r25) != true) goto L69;
        r31 = true;
        goto L70
    L99:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r2);
    L52:
        return Unit.INSTANCE;
    L18:
        Long r33 = (Long) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L48:
        m0.a(r33.toString(), null, null, null, null, false, null, null, null, 2046);
        z0<i> r34 = this._publishLoadingFlow;
        i.a r35 = i.a.a;
        r3.L$0 = null;
        r3.label = 3;
        if (r34.emit(r35, r3) != r13) goto L52;
        return r13;
    L19:
        String r38 = (String) r3.L$3;
        Long r40 = (Long) r3.L$2;
        Long r41 = (Long) r3.L$1;
        PublisherCreation r42 = (PublisherCreation) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Long r210 = r40;
        Object r43 = r2;
        String r44 = r38;
        r1 = r42;
    L33:
        zp9.a r45 = (zp9.a) r43;
        if (r45 != null) goto L36;
    L38:
        boolean r112 = false;
    L39:
        if (r112 == false) goto L53;
        z0<h> r46 = this._publisherCreationFlow;
        UserCreation r47 = r45.b;
        if (r47 == null) goto L43;
        PublisherCreation r48 = PublisherCreation.copy$default(zp9.d.g(r47, r44), null, null, null, null, null, null, null, null, r44, false, null, r210, r41, r1.getCanvasMode(), 1791, null);
    L44:
        h r50 = new h(r48, true);
        r3.L$0 = r41;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.label = 2;
        if (r46.emit(r50, r3) != r13) goto L47;
        return r13;
    L47:
        r33 = r41;
        goto L48
    L43:
        r48 = null;
        goto L44
    L53:
        s r51 = s.a;
        Application r52 = AppHost.a.getApplication();
        r51.getClass();
        s.s(r52, 2131908080);
        goto L97
    L36:
        if (r45.a != true) goto L38;
        r112 = true;
        goto L39
    L20:
        ResultKt.throwOnFailure(r2);
        m29.a.a("CreationPublishViewModel", new g(r1));
        Integer r53 = r36.getCreationType();
        if (r53 != null) goto L23;
        r53 = r36.getFromIMCreationType();
    L23:
        m29.a.c("CreationPublishViewModel", "messageId:" + r36.getMessageId() + ",creationType:" + r36.getCreationType() + ",fromIMCreationType:" + r36.getFromIMCreationType());
        Long r54 = r36.getCanvasSubId();
        if (r54 == null) goto L54;
        Long r55 = r36.getCanvasId();
        String r56 = r36.getTaskId();
        if (r56 == null) goto L28;
        e0 r57 = e0.a;
        Integer r113 = Boxing.boxInt(2);
        r3.L$0 = r1;
        r3.L$1 = r54;
        r3.L$2 = r55;
        r3.L$3 = r56;
        r3.label = 1;
        r43 = r57.c(r55, r54, r56, r113, r3);
        if (r43 != r13) goto L32;
        return r13;
    L32:
        r210 = r55;
        r41 = r54;
        r44 = r56;
        goto L33
    L28:
        return Unit.INSTANCE;
    L54:
        String r58 = r36.getMessageId();
        if (r58 == null) goto L57;
        IChatRepoService r60 = RepoDispatcherDelegate.b.e();
        r3.L$0 = r1;
        r3.L$1 = r53;
        r3.L$2 = r58;
        r3.label = 4;
        r24 = r60.E1(r58, r3);
        if (r24 != r13) goto L61;
        return r13;
    L61:
        r21 = r53;
        r23 = r58;
        goto L62
    L57:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r3 = new AnonymousClass1(this, r37);
        goto L8
    }

    public final void publish(boolean r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "caption");
        FLogger.a.i("CreationPublishViewModel", "publishLoading State idle " + this._publishLoadingFlow.getValue());
        h r0 = (h) this.publisherCreationFlow.getValue();
        if (r0 == null) goto L5;
        PublisherCreation r1 = r0.a;
    L6:
        PublisherCreation r3 = r1;
        if (Intrinsics.areEqual(this._publishLoadingFlow.getValue(), i.a.a) == true) goto L9;
        return;
    L9:
        AppHost.Companion r2 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r2.getApplication()) == true) goto L13;
        s r14 = s.a;
        Application r15 = r2.getApplication();
        r14.getClass();
        s.s(r15, 2131908080);
        return;
    L13:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C01621(this, r3, r12, r13, null), 2, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ Object access$addCreation(CreationPublishViewModel r0, PublisherCreation r1, Continuation r2) {
        return r0.addCreation(r1, r2);
    }
}
