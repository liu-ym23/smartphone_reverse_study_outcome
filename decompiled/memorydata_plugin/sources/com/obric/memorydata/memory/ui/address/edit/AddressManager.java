package com.obric.memorydata.memory.ui.address.edit;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.address.HomeCompanyAddressCache;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.database.dao.UserProfileDao;
import com.obric.memorydata.database.entity.ProfileKey;
import com.obric.memorydata.database.entity.hn;
import com.obric.memorydata.database.entity.je;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.intelligence.api.ProfileLabel;
import com.obric.memorydata.memory.api.ICommonAddressManager;
import com.obric.memorydata.memory.api.model.AddressInfo;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.utils.r;
import com.obric.memorydata.utils.u;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ai;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0000H\u0007J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u001e\u0010 \u001a\u00020\u001c2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u001a\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001e\u0010$\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0&H\u0002J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u001a\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J&\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u001c\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J0\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0016J0\u0010:\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0002J$\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010=\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006>"}, d2 = {"Lcom/obric/memorydata/memory/ui/address/edit/AddressManager;", "Lcom/obric/memorydata/memory/api/ICommonAddressManager;", "<init>", "()V", "TAG", "", "ADDRESS_TYPE_HOME", "ADDRESS_TYPE_COMPANY", "scope", "Lkotlinx/coroutines/CoroutineScope;", "homeAddressSyncMutex", "Lkotlinx/coroutines/sync/Mutex;", "companyAddressSyncMutex", "homeAddressSyncVersion", "Ljava/util/concurrent/atomic/AtomicLong;", "companyAddressSyncVersion", "_addressChangedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "addressChangedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getAddressChangedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "getInst", "getAddressList", "", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "addressType", "clearAll", "", "sureOnlyOneAddressSelect", Constants.KEY_LIST, "getAutoLearnAddress", "updateUserSetAddress", "addressInfoList", "syncUserSetHomeCompanyToDb", "addressInfo", "launchAddressSync", "block", "Lkotlin/Function0;", "getAddressSyncMutex", "getAddressSyncVersion", "syncGpsProfile", "profileLabel", "Lcom/obric/memorydata/intelligence/api/ProfileLabel;", "reOrganizeAddress", "setAutoLearnState", "", "enabled", "onStateChanged", "Lkotlin/Function1;", "restoreAutoLearnAddress", "setLocation", "locationType", "longitude", "", "latitude", ActivityLifecycle.NAME, MemoryListActivity.JUMP_FROM_DETAIL, "setUserSelectedAddress", "selectAddress", "addressList", "selectedAddress", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AddressManager implements ICommonAddressManager {
    private static final String ADDRESS_TYPE_COMPANY = "公司";
    private static final String ADDRESS_TYPE_HOME = "家";
    public static final AddressManager INSTANCE = null;
    private static final String TAG = "AddressManager";
    private static final ad<String> _addressChangedFlow = null;
    private static final ai<String> addressChangedFlow = null;
    private static final kotlinx.coroutines.sync.a companyAddressSyncMutex = null;
    private static final AtomicLong companyAddressSyncVersion = null;
    private static final kotlinx.coroutines.sync.a homeAddressSyncMutex = null;
    private static final AtomicLong homeAddressSyncVersion = null;
    private static final al scope = null;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends AddressInfo>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/address/edit/AddressManager$setAutoLearnState$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f10576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f10577b;

        b(boolean r3, Function1<? super Boolean, Unit> r4) {
            Function1<Boolean, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            this.f10576a = r3;
            this.f10577b = r5;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "taskInfo");
            if (r3.c() != TaskInfo.State.ENQUEUED) goto L8;
            if (this.f10576a == true) goto L8;
            AddressManager.INSTANCE.reOrganizeAddress("家");
            AddressManager.INSTANCE.reOrganizeAddress("公司");
        L8:
            if (r3.c() != TaskInfo.State.SUCCEEDED) goto L13;
            Function1<Boolean, Unit> r4 = this.f10577b;
            if (r4 == null) goto L14;
            r4.invoke(Boolean.valueOf(this.f10576a));
            return;
        L14:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.address.edit.AddressManager$launchAddressSync$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.address.edit.AddressManager$launchAddressSync$1", f = "AddressManager.kt", i = {0}, l = {408}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $addressType;
        final /* synthetic */ Function0<Unit> $block;
        final /* synthetic */ long $syncVersion;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        AnonymousClass1(String r3, long r4, Function0<Unit> r6, Continuation<? super AnonymousClass1> r7) {
            Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$addressType = r3;
            this.$syncVersion = r4;
            this.$block = r8;
            super(2, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$addressType, this.$syncVersion, this.$block, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            long r2 = this.J$0;
            Function0<Unit> r3 = (Function0) ZeusTransformUtils.preCheckCast(this.L$2, Function0.class, "com.obric.memorydata.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
            kotlinx.coroutines.sync.a r14 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r15);
        L22:
        L19:
            th = move-exception;
            r14.b(null);
            throw th;
        L13:
            if (r2 == AddressManager.access$getAddressSyncVersion(AddressManager.INSTANCE, r5).get()) goto L15;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AddressManager.TAG, "skip outdated address sync: " + r5, false, 4, null);     // Catch: Throwable -> L19
        L16:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L19
            r14.b(null);
            return Unit.INSTANCE;
        L15:
            r3.invoke();     // Catch: Throwable -> L19
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            kotlinx.coroutines.sync.a r17 = AddressManager.access$getAddressSyncMutex(AddressManager.INSTANCE, this.$addressType);
            long r6 = this.$syncVersion;
            String r4 = this.$addressType;
            Function0<Unit> r7 = this.$block;
            Continuation<? super Unit> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r17;
            this.L$1 = r4;
            this.L$2 = r7;
            this.J$0 = r6;
            this.label = 1;
            if (r17.a(null, r8) != r0) goto L11;
            return r0;
        L11:
            r14 = r17;
            r3 = r7;
            r5 = r4;
            r2 = r6;
            goto L22
        }
    }

    static {
        INSTANCE = new AddressManager();
        scope = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"));
        homeAddressSyncMutex = kotlinx.coroutines.sync.c.a(false, 1, null);
        companyAddressSyncMutex = kotlinx.coroutines.sync.c.a(false, 1, null);
        homeAddressSyncVersion = new AtomicLong();
        companyAddressSyncVersion = new AtomicLong();
        ad<String> r0 = ak.a(0, 1, BufferOverflow.DROP_OLDEST, 1, null);
        _addressChangedFlow = r0;
        addressChangedFlow = k.a(r0);
    }

    private AddressManager() {
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getAddressSyncMutex(AddressManager r0, String r1) {
        return r0.getAddressSyncMutex(r1);
    }

    public static final /* synthetic */ AtomicLong access$getAddressSyncVersion(AddressManager r0, String r1) {
        return r0.getAddressSyncVersion(r1);
    }

    private final kotlinx.coroutines.sync.a getAddressSyncMutex(String r1) {
        if (Intrinsics.areEqual(r1, "家") == false) goto L6;
        return homeAddressSyncMutex;
    L6:
        return companyAddressSyncMutex;
    }

    private final AtomicLong getAddressSyncVersion(String r1) {
        if (Intrinsics.areEqual(r1, "家") == false) goto L6;
        return homeAddressSyncVersion;
    L6:
        return companyAddressSyncVersion;
    }

    @JvmStatic
    public static final AddressManager getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ void lambda$Em0EjZoo2zvTo863JbGHwUpZ1CU(UserProfileDao r0, String r1, AddressInfo r2) {
        syncGpsProfile$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$o0wnRewtO0LLF5fKw_GSUhtDCB0(String r0, AddressInfo r1) {
        return syncUserSetHomeCompanyToDb$lambda$6(r0, r1);
    }

    public static /* synthetic */ Unit lambda$pK6fpPCX6_WKVoNRDEl3mO7PKY4(Exception r0) {
        return syncUserSetHomeCompanyToDb$lambda$6$lambda$2(r0);
    }

    public static /* synthetic */ Unit lambda$trQDLK37pBfBHuFjEvWVOOvmdwg(String r0, AddressInfo r1) {
        return syncUserSetHomeCompanyToDb$lambda$6$lambda$5(r0, r1);
    }

    private final void launchAddressSync(String r14, Function0<Unit> r15) {
        Function0 r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r15, Function0.class, "com.obric.memorydata.plugin");
        long r4 = getAddressSyncVersion(r14).incrementAndGet();
        i.a(scope, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r14, r4, r6, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void restoreAutoLearnAddress(String r3) {
        AddressInfo r0 = getAutoLearnAddress(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        if (com.obric.memorydata.memory.api.model.a.a(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        syncUserSetHomeCompanyToDb(r0, r3);
        return;
    }

    private final List<AddressInfo> selectAddress(List<AddressInfo> r17, AddressInfo r18) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
        boolean r3 = false;
    L4:
        if (r1.hasNext() == false) goto L16;
        AddressInfo r5 = (AddressInfo) ZeusTransformUtils.preCheckCast(r1.next(), AddressInfo.class, "com.obric.memorydata.plugin");
        if (Math.abs(r5.getLongitude() - r18.getLongitude()) <= 1.0E-4d) goto L8;
    L14:
        String r6 = null;
        String r7 = null;
        double r8 = 0.0d;
        double r10 = 0.0d;
        boolean r12 = false;
    L15:
        r2.add(AddressInfo.copy$default(r5, r6, r7, r8, r10, r12, false, 47, null));
        goto L4
    L8:
        if (Math.abs(r5.getLatitude() - r18.getLatitude()) > 1.0E-4d) goto L14;
        if (Intrinsics.areEqual(r5.getName(), r18.getName()) == false) goto L14;
        if (Intrinsics.areEqual(r5.getDetail(), r18.getDetail()) == false) goto L14;
        r3 = true;
        r6 = null;
        r7 = null;
        r8 = 0.0d;
        r10 = 0.0d;
        r12 = true;
        goto L15
    L16:
        List<AddressInfo> r4 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        if (r3 == true) goto L19;
        r4.add(r18);
    L19:
        return r4;
    }

    private final void setUserSelectedAddress(String r12, double r13, double r15, String r17, String r18) {
        AddressInfo r10 = new AddressInfo(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).toString(), StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r13, r15, true, false);
        updateUserSetAddress(selectAddress(getAddressList(r12), r10), r12);
    }

    private final void syncGpsProfile(ProfileLabel r3, final AddressInfo r4) {
        final UserProfileDao r2 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao();
        final String r5 = r3.toString();
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().runInTransaction(new $$Lambda$AddressManager$Em0EjZoo2zvTo863JbGHwUpZ1CU(r2, r5, r4));
    }

    private static final void syncGpsProfile$lambda$8(UserProfileDao r10, String r11, AddressInfo r12) {
        UserProfileDao r13 = (UserProfileDao) ZeusTransformUtils.wrapperContextForParams(r10, UserProfileDao.class, "com.obric.memorydata.plugin");
        r13.deleteByUriKey(r11);
        if (r12 == null) goto L6;
        r13.insert(new je(r11, "{\"" + r11 + "\": [{\"value\": [\"" + r12.getLongitude() + "\", \"" + r12.getLatitude() + "\"], \"confidence\": 1.0}]}", r.a(System.currentTimeMillis()), 0, 8, null));
        return;
    }

    private final void syncUserSetHomeCompanyToDb(final AddressInfo r2, final String r3) {
        launchAddressSync(r3, new $$Lambda$AddressManager$o0wnRewtO0LLF5fKw_GSUhtDCB0(r3, r2));
    }

    private static final Unit syncUserSetHomeCompanyToDb$lambda$6(final String r11, final AddressInfo r12) {
        if (Intrinsics.areEqual(r11, "家") == false) goto L13;
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().deleteByUriKey(ProfileLabel.HOME_BSS_ID.toString());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().deleteByUriKey(ProfileLabel.HOME_CELL_ID.toString());
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("clear HOME_GPS_FENCE_LIST for user set home, hasHome=");
        if (r12 == null) goto L7;
        boolean r6 = true;
    L8:
        IRunLog.a.a(r5, TAG, r0.append(r6).toString(), false, 4, null);
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().deleteByUriKey(ProfileLabel.HOME_GPS_FENCE_LIST.toString());
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "HOME_GPS_FENCE_LIST", null, null, 4, null);
        INSTANCE.syncGpsProfile(ProfileLabel.HOME_GPS, r12);
        if (r12 == null) goto L11;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "location_home_gps", CollectionsKt.listOf(new Double[]{Double.valueOf(r12.getLongitude()), Double.valueOf(r12.getLatitude())}), null, 4, null);
    L11:
        if (r12 != null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "user remove home gps info", false, 4, null);
        com.obric.memorydata.awareness.api.b r1 = (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin");
        Object r3 = null;
        Map r4 = null;
        int r7 = 4;
        Object r8 = null;
        String r2 = "location_home_gps";
    L18:
        com.obric.memorydata.awareness.api.b.a.a(r1, r2, r3, r4, r7, r8);
    L19:
        y.a($$Lambda$AddressManager$pK6fpPCX6_WKVoNRDEl3mO7PKY4.INSTANCE, new $$Lambda$AddressManager$trQDLK37pBfBHuFjEvWVOOvmdwg(r11, r12));
        return Unit.INSTANCE;
    L7:
        r6 = false;
        goto L8
    L13:
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().deleteByUriKey(ProfileLabel.COMPANY_BSS_ID.toString());
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileDao().deleteByUriKey(ProfileLabel.COMPANY_CELL_ID.toString());
        INSTANCE.syncGpsProfile(ProfileLabel.COMPANY_GPS, r12);
        if (r12 == null) goto L16;
        com.obric.memorydata.awareness.api.b.a.a((com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin"), "location_company_gps", CollectionsKt.listOf(new Double[]{Double.valueOf(r12.getLongitude()), Double.valueOf(r12.getLatitude())}), null, 4, null);
    L16:
        if (r12 != null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "user remove company gps info", false, 4, null);
        r1 = (com.obric.memorydata.awareness.api.b) ZeusTransformUtils.preCheckCast(FeatureManager.INSTANCE, com.obric.memorydata.awareness.api.b.class, "com.obric.memorydata.plugin");
        r3 = null;
        r4 = null;
        r7 = 4;
        r8 = null;
        r2 = "location_company_gps";
        goto L18
    }

    private static final Unit syncUserSetHomeCompanyToDb$lambda$6$lambda$2(Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Failed to sync to CommonAddressEntity: " + r7.getMessage(), null, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit syncUserSetHomeCompanyToDb$lambda$6$lambda$5(String r6, AddressInfo r7) {
        if (Intrinsics.areEqual(r6, "家") == false) goto L5;
        ProfileKey r8 = ProfileKey.ADDRESS_HOME;
    L6:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUserProfileRawDbDao().queryByProfileKey(r8.name()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ((hn) ZeusTransformUtils.preCheckCast(r0.next(), hn.class, "com.obric.memorydata.plugin")).delete();
        goto L8
    L10:
        if (r7 == null) goto L12;
        hn.f9187a.a(r8, r7.getDetail() + r7.getName(), r7.isFromAutoLearn());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Successfully synced " + r8.name() + " to UserProfileEntity", false, 4, null);
        return Unit.INSTANCE;
    L12:
        return null;
    L5:
        r8 = ProfileKey.ADDRESS_COMPANY;
        goto L6
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void clearAll() {
        HomeCompanyAddressCache.f8425a.a(new HomeCompanyAddressCache.CacheType[]{HomeCompanyAddressCache.CacheType.USER_SET, HomeCompanyAddressCache.CacheType.AUTO_LEARN});
        syncUserSetHomeCompanyToDb(null, "家");
        syncUserSetHomeCompanyToDb(null, "公司");
    }

    public final ai<String> getAddressChangedFlow() {
        return addressChangedFlow;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public List<AddressInfo> getAddressList(String r15) {
        Intrinsics.checkNotNullParameter(r15, "addressType");
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getUserId(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L8;
        List<AddressInfo> r7 = null;
        String r16 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("user_set_address_" + r15 + '_' + AppContext.INSTANCE.getUserId(), IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("user_set_address_" + r15, ""));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r16, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L31;
        r2 = false;
    L31:
        if (r2 == true) goto L15;
        r7 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r16, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18 JsonParseException -> L20 JsonSyntaxException -> L23
    L25:
        if (r7 != null) goto L27;
        r7 = CollectionsKt.emptyList();     // Catch: Exception -> L18
    L27:
        return sureOnlyOneAddressSelect(r7);
    L23:
        e = move-exception;
        IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        String r9 = "GsonExt";
        String r10 = "toListObj error : " + e;     // Catch: Exception -> L18
    L22:
        IRunLog.a.b(r8, r9, r10, null, 4, null);     // Catch: Exception -> L18
    L20:
        e = move-exception;
        r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
        r9 = "GsonExt";
        r10 = "toListObj error : " + e;     // Catch: Exception -> L18
        goto L22
    L15:
        return CollectionsKt.emptyList();
    L18:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getAddressList error: " + e.getMessage(), null, 4, null);
        return CollectionsKt.emptyList();
    L8:
        return CollectionsKt.emptyList();
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public AddressInfo getAutoLearnAddress(String r12) {
        Intrinsics.checkNotNullParameter(r12, "addressType");
        boolean r2 = false;
        if (Intrinsics.areEqual(r12, "家") == false) goto L5;
        String r11 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("home_address", "");
        IStore r13 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        StringBuilder r0 = new StringBuilder();
        String r1 = "home_address_";
    L6:
        String r14 = r13.getString(r0.append(r1).append(AppContext.INSTANCE.getUserId()).toString(), r11);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L21;
        r2 = true;
    L21:
        if (r2 == false) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "Address Have Not Learn", null, 4, null);
        return null;
    L23:
        Object r15 = u.a().fromJson(r14, AddressInfo.class);     // Catch: Exception -> L14
    L16:
        return (AddressInfo) ZeusTransformUtils.preCheckCast(r15, AddressInfo.class, "com.obric.memorydata.plugin");
    L14:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GsonExt", "convert content: " + r14 + " toObj error : " + e, null, 4, null);     // Catch: Exception -> L18
        r15 = null;
    L18:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getAutoLearnAddress error: " + e.getMessage(), null, 4, null);
        return null;
    L5:
        r11 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString("company_address", "");
        r13 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        r0 = new StringBuilder();
        r1 = "company_address_";
        goto L6
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void reOrganizeAddress(String r14) {
        Intrinsics.checkNotNullParameter(r14, "addressType");
        RunLog.INSTANCE.debug(TAG, "reOrganizeAddress " + r14);
        AddressInfo r0 = getAutoLearnAddress(r14);
        List<AddressInfo> r1 = getAddressList(r14);
        if (r0 != null) goto L6;
        updateUserSetAddress(sureOnlyOneAddressSelect(r1), r14);
        return;
    L6:
        boolean r2 = false;
        Iterator<AddressInfo> r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L19;
        AddressInfo r4 = (AddressInfo) ZeusTransformUtils.preCheckCast(r3.next(), AddressInfo.class, "com.obric.memorydata.plugin");
        if (Math.abs(r4.getLongitude() - r0.getLongitude()) > 1.0E-6d) goto L15;
        if (Math.abs(r4.getLatitude() - r0.getLatitude()) > 1.0E-6d) goto L15;
    L13:
        r2 = true;
    L15:
        if (Intrinsics.areEqual(r4.getName(), r0.getName()) == false) goto L8;
        if (Intrinsics.areEqual(r4.getDetail(), r0.getDetail()) == false) goto L8;
    L19:
        if (r2 == false) goto L21;
        List<AddressInfo> r5 = sureOnlyOneAddressSelect(r1);
    L22:
        updateUserSetAddress(r5, r14);
        return;
    L21:
        r5 = sureOnlyOneAddressSelect(CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin"), r0));
        goto L22
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public synchronized boolean setAutoLearnState(boolean r6, Function1<? super Boolean, Unit> r7) {
        monitor-enter(this);
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);     // Catch: Throwable -> L14
        if (r6 != r0.getBoolean("auto_learn_common_address", false)) goto L7;
        monitor-exit(this);
        return false;
    L7:
        r0.save("auto_learn_common_address", r6);     // Catch: Throwable -> L14
        if (r6 == false) goto L10;
        restoreAutoLearnAddress("家");     // Catch: Throwable -> L14
        restoreAutoLearnAddress("公司");     // Catch: Throwable -> L14
    L10:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("DeleteHomeCompanyProfileTask").setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r6, r8), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();     // Catch: Throwable -> L14
        monitor-exit(this);
        return true;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public synchronized boolean setLocation(String r12, double r13, double r15, String r17, String r18) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "locationType");     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter(r17, ActivityLifecycle.NAME);     // Catch: Throwable -> L35
        Intrinsics.checkNotNullParameter(r18, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L35
        boolean r2 = false;
        if (Intrinsics.areEqual(r12, "home") == false) goto L8;
        String r0 = "家";
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getUserId(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "user id is empty, skip set location", null, 4, null);     // Catch: Throwable -> L35
        monitor-exit(this);
        return false;
    L19:
        if (com.obric.memorydata.address.a.f8427a.a() == false) goto L30;
        AddressInfo r3 = getAutoLearnAddress(r0);     // Catch: Throwable -> L35
        if (r3 != null) goto L23;
    L25:
        if (r2 == false) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "ignore setLocation because " + r0 + " has been learned", false, 4, null);     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L23:
        if (com.obric.memorydata.memory.api.model.a.a(r3) != true) goto L25;
        r2 = true;
    L30:
        setUserSelectedAddress(r0, r13, r15, r17, r18);     // Catch: Throwable -> L35
        _addressChangedFlow.a(r0);     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L13:
        r1 = false;
        goto L14
    L8:
        if (Intrinsics.areEqual(r12, "company") == false) goto L33;
        r0 = "公司";
        goto L11
    L33:
        monitor-exit(this);
        return false;
    L35:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public List<AddressInfo> sureOnlyOneAddressSelect(List<AddressInfo> r6) {
        List<AddressInfo> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, Constants.KEY_LIST);
        Iterator<AddressInfo> r7 = r5.iterator();
        int r2 = 0;
    L4:
        if (r7.hasNext() == false) goto L10;
        AddressInfo r3 = (AddressInfo) ZeusTransformUtils.preCheckCast(r7.next(), AddressInfo.class, "com.obric.memorydata.plugin");
        if (r3.isSelect() == false) goto L4;
        if (r2 == 0) goto L8;
        r3.setSelect(false);
        goto L4
    L8:
        r2 = r2 + 1;
        goto L4
    L10:
        if (r2 != 0) goto L14;
        AddressInfo r8 = (AddressInfo) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r5), AddressInfo.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L14;
        r8.setSelect(true);
    L14:
        return r5;
    }

    @Override // com.obric.memorydata.memory.api.ICommonAddressManager
    public void updateUserSetAddress(List<AddressInfo> r10, String r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "addressInfoList");
        Intrinsics.checkNotNullParameter(r11, "addressType");
        RunLog.INSTANCE.debug(TAG, "更新用户设置地址，类型=" + r11 + "，数量=" + r12.size());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getUserId(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{"user_set_address_" + r11});
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("user_set_address_" + r11 + '_' + AppContext.INSTANCE.getUserId(), u.a(r12));
        Iterator r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L15;
        AddressInfo r1 = (AddressInfo) ZeusTransformUtils.preCheckCast(r13.next(), AddressInfo.class, "com.obric.memorydata.plugin");
        if (r1.isSelect() == false) goto L10;
        syncUserSetHomeCompanyToDb(r1, r11);
        return;
    L15:
        syncUserSetHomeCompanyToDb(null, r11);
        return;
    L5:
        r0 = false;
        goto L6
    }
}
