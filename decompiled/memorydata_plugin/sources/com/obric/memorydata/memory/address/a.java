package com.obric.memorydata.memory.address;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.StateChangeListener;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.obric.memorydata.memory.api.ICommonAddressManager;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.ui.address.edit.AddressManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.app.d;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.sdk.awareness.HomeCompanyAddressLearningSharedState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;
import kotlinx.coroutines.sync.c;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0002\u0016\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001e\u001a\u00020\u0010J\u000e\u0010\u001f\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010 J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\u0010H\u0002J\u0018\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/address/HomeCompanyAddressSharedStateSync;", "", "<init>", "()V", "TAG", "", "ADDRESS_TYPE_HOME", "ADDRESS_TYPE_COMPANY", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateSyncMutex", "Lkotlinx/coroutines/sync/Mutex;", "_stateChangedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "stateChangedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getStateChangedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "storeChangeListener", "com/obric/memorydata/memory/address/HomeCompanyAddressSharedStateSync$storeChangeListener$1", "Lcom/obric/memorydata/memory/address/HomeCompanyAddressSharedStateSync$storeChangeListener$1;", "sharedStateChangeListener", "Lcom/obric/aiagent/sharedstate/StateChangeListener;", "loginStateListener", "com/obric/memorydata/memory/address/HomeCompanyAddressSharedStateSync$loginStateListener$1", "Lcom/obric/memorydata/memory/address/HomeCompanyAddressSharedStateSync$loginStateListener$1;", CommonConsts.APM_INNER_EVENT_COST_INIT, "refreshForCurrentUser", "reconcileInitialState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "synchronizeFromSharedState", "applySharedAutoLearnState", "state", "", "publishAutoLearnState", "publishLearningStatuses", "getLearningStatus", "enabled", "", "addressType", "isAutoLearnAddressKey", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10048a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10049b = null;
    private static final al c = null;
    private static final kotlinx.coroutines.sync.a d = null;
    private static final ad<Unit> e = null;
    private static final ai<Unit> f = null;
    private static final b g = null;
    private static final StateChangeListener h = null;
    private static final C0489a i = null;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.address.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/address/HomeCompanyAddressSharedStateSync$loginStateListener$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0489a implements d {
        C0489a() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "userId");
            a.f10048a.c();
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "lastUserId");
            a.f10048a.c();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/obric/memorydata/memory/address/HomeCompanyAddressSharedStateSync$storeChangeListener$1", "Lcom/obric/memorydata/middleware/api/store/StoreChangeListener;", "onKeyChanged", "", "repoName", "", "key", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.middleware.api.store.b {
        b() {
        }

        @Override // com.obric.memorydata.middleware.api.store.b
        public void onKeyChanged(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "repoName");
            Intrinsics.checkNotNullParameter(r9, "key");
            if (Intrinsics.areEqual(r9, "auto_learn_common_address") == false) goto L7;
            al r1 = a.f();
            CoroutineContext r2 = null;
            CoroutineStart r3 = null;
            Object r7 = new HomeCompanyAddressSharedStateSync$storeChangeListener$1$onKeyChanged$1(null);
        L5:
            i.a(r1, r2, r3, (Function2) ZeusTransformUtils.preCheckCast(r7, Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return;
        L7:
            if (a.a(a.f10048a, r9) == false) goto L10;
            r1 = a.f();
            r2 = null;
            r3 = null;
            r7 = new HomeCompanyAddressSharedStateSync$storeChangeListener$1$onKeyChanged$2(null);
            goto L5
        L10:
            if (StringsKt.startsWith$default(r9, "user_set_address_", false, 2, null) == false) goto L14;
            a.e().a(Unit.INSTANCE);
            return;
        }
    }

    static {
        f10048a = new a();
        f10049b = new AtomicBoolean(false);
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        d = c.a(false, 1, null);
        ad<Unit> r0 = ak.a(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
        e = r0;
        f = k.a(r0);
        g = new b();
        h = $$Lambda$a$kObPO8JNMEa2OZhWhP6VLsBBRSA.INSTANCE;
        i = new C0489a();
    }

    private a() {
    }

    private final int a(boolean r1, String r2) {
        boolean r0 = false;
        if (r1 == true) goto L5;
        return 0;
    L5:
        AddressInfo r3 = AddressManager.INSTANCE.getAutoLearnAddress(r2);
        if (r3 != null) goto L8;
    L10:
        if (r0 == false) goto L13;
        return 2;
    L13:
        return 1;
    L8:
        if (com.obric.memorydata.memory.api.model.a.a(r3) != true) goto L10;
        r0 = true;
        goto L10
    }

    public static final /* synthetic */ Object a(a r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r3) {
        Object r2 = b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    private final void a(int r11) {
        boolean r1 = true;
        if (r11 == 0) goto L6;
        if (r11 == 1) goto L8;
        return;
    L8:
        if (r1 == true) goto L10;
    L14:
        ICommonAddressManager.a.a((ICommonAddressManager) ZeusTransformUtils.preCheckCast(AddressManager.INSTANCE, ICommonAddressManager.class, "com.obric.memorydata.plugin"), r1, null, 2, null);
    L12:
        h();
        e.a(Unit.INSTANCE);
        return;
    L10:
        if (com.obric.memorydata.address.a.f8427a.b() == true) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "HomeCompanyAddressStateSync", "ignore shared auto learn enable because location permission is missing", null, 4, null);
        ICommonAddressManager.a.a((ICommonAddressManager) ZeusTransformUtils.preCheckCast(AddressManager.INSTANCE, ICommonAddressManager.class, "com.obric.memorydata.plugin"), false, null, 2, null);
        g();
        goto L12
    L6:
        r1 = false;
        goto L8
    }

    public static final /* synthetic */ void a(a r0) {
        r0.h();
    }

    private static final void a(String r8, SharedValue r9) {
        SharedValue r10 = (SharedValue) ZeusTransformUtils.wrapperContextForParams(r9, SharedValue.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r10, "<unused var>");
        if (Intrinsics.areEqual(r8, HomeCompanyAddressLearningSharedState.KEY_AUTO_LEARN_STATE) == true) goto L5;
        return;
    L5:
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new HomeCompanyAddressSharedStateSync$sharedStateChangeListener$1$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public static final /* synthetic */ boolean a(a r0, String r1) {
        return r0.a(r1);
    }

    private final boolean a(String r4) {
        if (Intrinsics.areEqual(r4, "home_address") == false) goto L5;
    L10:
        return true;
    L5:
        if (StringsKt.startsWith$default(r4, "home_address_", false, 2, null) == true) goto L10;
        if (Intrinsics.areEqual(r4, "company_address") == true) goto L10;
        if (StringsKt.startsWith$default(r4, "company_address_", false, 2, null) == true) goto L10;
        return false;
    }

    public static final /* synthetic */ Object b(a r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, HomeCompanyAddressSharedStateSync$synchronizeFromSharedState$1.class) == false) goto L7;
        HomeCompanyAddressSharedStateSync$synchronizeFromSharedState$1 r0 = (HomeCompanyAddressSharedStateSync$synchronizeFromSharedState$1) ZeusTransformUtils.preCheckCast(r7, HomeCompanyAddressSharedStateSync$synchronizeFromSharedState$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r0.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
    L33:
        int r10 = SharedState.INSTANCE.getInt(HomeCompanyAddressLearningSharedState.KEY_AUTO_LEARN_STATE, -1);     // Catch: Throwable -> L30
        if (r10 == (-1)) goto L21;
        f10048a.a(r10);     // Catch: Throwable -> L30
    L27:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L30
        r9.b(null);
        return r11;
    L21:
        if (com.obric.memorydata.address.a.f8427a.a() == true) goto L23;
    L25:
        a r12 = f10048a;     // Catch: Throwable -> L30
        r12.g();     // Catch: Throwable -> L30
        r12.h();     // Catch: Throwable -> L30
        goto L27
    L23:
        if (com.obric.memorydata.address.a.f8427a.b() == true) goto L25;
        ICommonAddressManager.a.a((ICommonAddressManager) ZeusTransformUtils.preCheckCast(AddressManager.INSTANCE, ICommonAddressManager.class, "com.obric.memorydata.plugin"), false, null, 2, null);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        r9.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.sync.a r13 = d;
        r0.L$0 = r13;
        r0.label = 1;
        if (r13.a(null, r0) != r8) goto L17;
        return r8;
    L17:
        r9 = r13;
    L7:
        r0 = new HomeCompanyAddressSharedStateSync$synchronizeFromSharedState$1(this, r7);
        goto L8
    }

    public static final /* synthetic */ void b(a r0) {
        r0.g();
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a d() {
        return d;
    }

    public static final /* synthetic */ ad e() {
        return e;
    }

    public static final /* synthetic */ al f() {
        return c;
    }

    private final void g() {
        boolean r2 = com.obric.memorydata.address.a.f8427a.a();
        SharedState.INSTANCE.putInt(HomeCompanyAddressLearningSharedState.KEY_AUTO_LEARN_STATE, r2 ? 1 : 0);
    }

    private final void h() {
        boolean r0 = com.obric.memorydata.address.a.f8427a.a();
        SharedState.INSTANCE.putInt(HomeCompanyAddressLearningSharedState.KEY_HOME_LEARNING_STATUS, a(r0, "家"));
        SharedState.INSTANCE.putInt(HomeCompanyAddressLearningSharedState.KEY_COMPANY_LEARNING_STATUS, a(r0, "公司"));
    }

    public static /* synthetic */ void lambda$kObPO8JNMEa2OZhWhP6VLsBBRSA(String r0, SharedValue r1) {
        a(r0, r1);
    }

    public final ai<Unit> a() {
        return f;
    }

    public final void b() {
        if (f10049b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).registerChangeListener((com.obric.memorydata.middleware.api.store.b) ZeusTransformUtils.preCheckCast(g, com.obric.memorydata.middleware.api.store.b.class, "com.obric.memorydata.plugin"));
        SharedState.INSTANCE.registerObserver(CollectionsKt.listOf(HomeCompanyAddressLearningSharedState.KEY_AUTO_LEARN_STATE), h);
        UserSettings.INSTANCE.registerLoginStateListener((d) ZeusTransformUtils.preCheckCast(i, d.class, "com.obric.memorydata.plugin"));
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new HomeCompanyAddressSharedStateSync$init$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void c() {
        i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new HomeCompanyAddressSharedStateSync$refreshForCurrentUser$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
