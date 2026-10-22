package com.obric.aiproactive.impl.runtime;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiproactive.api.IProactiveRecommendationEnabledStore;
import com.obric.aiproactive.api.ae;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r*\u0002\u0018\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0000H\u0007J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0016J\u0006\u0010!\u001a\u00020\u001eJ\b\u0010\"\u001a\u00020\u0016H\u0016J\u0006\u0010#\u001a\u00020\u0016J\u0018\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0016H\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0013H\u0016J\u001c\u0010(\u001a\u00020\u001e2\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006+"}, d2 = {"Lcom/obric/aiproactive/impl/runtime/ProactiveRecommendationEnabledStoreImpl;", "Lcom/obric/aiproactive/api/IProactiveRecommendationEnabledStore;", "<init>", "()V", "TAG", "", "KEY_PROACTIVE_RECOMMENDATION_ENABLED", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "getStore", "()Lcom/obric/memorydata/middleware/api/store/IStore;", "store$delegate", "Lkotlin/Lazy;", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "currentEnabled", "currentDbPreparationEligible", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", "getInst", "proactiveAgentEnabled", "", "agreePrivacyListener", "com/obric/aiproactive/impl/runtime/ProactiveRecommendationEnabledStoreImpl$agreePrivacyListener$1", "Lcom/obric/aiproactive/impl/runtime/ProactiveRecommendationEnabledStoreImpl$agreePrivacyListener$1;", "loginStateListener", "com/obric/aiproactive/impl/runtime/ProactiveRecommendationEnabledStoreImpl$loginStateListener$1", "Lcom/obric/aiproactive/impl/runtime/ProactiveRecommendationEnabledStoreImpl$loginStateListener$1;", CommonConsts.APM_INNER_EVENT_COST_START, "", "updateProactiveAgentEnabled", "enabled", "onWakeUpPreferenceChanged", "isEnabled", "isDbPreparationEligible", "registerListener", "listener", "emitCurrent", "unregisterListener", "syncEnabledState", "forcePersist", "forceNotify", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveRecommendationEnabledStoreImpl implements IProactiveRecommendationEnabledStore {
    public static final ProactiveRecommendationEnabledStoreImpl INSTANCE = null;
    private static final String KEY_PROACTIVE_RECOMMENDATION_ENABLED = "proactiveRecommendationEnabled";
    private static final String TAG = "ProactiveRecommendStore";
    private static final a agreePrivacyListener = null;
    private static final AtomicBoolean currentDbPreparationEligible = null;
    private static final AtomicBoolean currentEnabled = null;
    private static final CopyOnWriteArraySet<ae> listeners = null;
    private static final b loginStateListener = null;
    private static volatile boolean proactiveAgentEnabled;
    private static final AtomicBoolean started = null;
    private static final Lazy store$delegate = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/aiproactive/impl/runtime/ProactiveRecommendationEnabledStoreImpl$agreePrivacyListener$1", "Lcom/obric/memorydata/middleware/api/app/AgreePrivacyListener;", "onAgree", "", "onDisagree", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.middleware.api.app.a {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void a() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveRecommendationEnabledStoreImpl.TAG, "agreePrivacyListener onAgree", false, 4, null);
            ProactiveRecommendationEnabledStoreImpl.syncEnabledState$default(ProactiveRecommendationEnabledStoreImpl.INSTANCE, false, false, 3, null);
        }

        @Override // com.obric.memorydata.middleware.api.app.a
        public void b() {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveRecommendationEnabledStoreImpl.TAG, "agreePrivacyListener onDisagree", false, 4, null);
            ProactiveRecommendationEnabledStoreImpl.syncEnabledState$default(ProactiveRecommendationEnabledStoreImpl.INSTANCE, false, false, 3, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/aiproactive/impl/runtime/ProactiveRecommendationEnabledStoreImpl$loginStateListener$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.middleware.api.app.d {
        b() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r7) {
            Intrinsics.checkNotNullParameter(r7, "userId");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveRecommendationEnabledStoreImpl.TAG, "loginStateListener onLogin userId=" + r7, false, 4, null);
            ProactiveRecommendationEnabledStoreImpl.syncEnabledState$default(ProactiveRecommendationEnabledStoreImpl.INSTANCE, false, false, 3, null);
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r7) {
            Intrinsics.checkNotNullParameter(r7, "lastUserId");
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ProactiveRecommendationEnabledStoreImpl.TAG, "loginStateListener onLogout lastUserId=" + r7, false, 4, null);
            ProactiveRecommendationEnabledStoreImpl.syncEnabledState$default(ProactiveRecommendationEnabledStoreImpl.INSTANCE, false, false, 3, null);
        }
    }

    static {
        INSTANCE = new ProactiveRecommendationEnabledStoreImpl();
        store$delegate = LazyKt.lazy($$Lambda$ProactiveRecommendationEnabledStoreImpl$GFW8F_uM1QScacUZJpZYDSlyWs8.INSTANCE);
        started = new AtomicBoolean(false);
        currentEnabled = new AtomicBoolean(false);
        currentDbPreparationEligible = new AtomicBoolean(false);
        listeners = new CopyOnWriteArraySet();
        agreePrivacyListener = new a();
        loginStateListener = new b();
    }

    private ProactiveRecommendationEnabledStoreImpl() {
    }

    @JvmStatic
    public static final ProactiveRecommendationEnabledStoreImpl getInst() {
        ProactiveRecommendationEnabledStoreImpl r0 = INSTANCE;
        r0.start();
        return r0;
    }

    private final IStore getStore() {
        return (IStore) ZeusTransformUtils.preCheckCast(store$delegate.getValue(), IStore.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ IStore lambda$GFW8F_uM1QScacUZJpZYDSlyWs8() {
        return store_delegate$lambda$0();
    }

    private static final IStore store_delegate$lambda$0() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
    }

    private final void syncEnabledState(boolean r18, boolean r19) {
        boolean r2 = UserSettings.INSTANCE.hasAgreePrivacyAndLogin();
        boolean r3 = com.obric.aiproactive.impl.runtime.a.f6507a.a();
        boolean r4 = e.a(r2, proactiveAgentEnabled);
        boolean r5 = e.a(r2, proactiveAgentEnabled, r3);
        boolean r6 = currentDbPreparationEligible.getAndSet(r4);
        boolean r7 = currentEnabled.getAndSet(r5);
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append("syncEnabledState ready=").append(r2).append(" proactiveAgentEnabled=").append(proactiveAgentEnabled).append(" wakeUpPreferenceEnabled=").append(r3).append(" old=").append(r7).append(" new=").append(r5).append(" forcePersist=").append(r18).append(" forceNotify=").append(r19).append(" listenerSize=");
        CopyOnWriteArraySet<ae> r9 = listeners;
        IRunLog.a.a(r11, TAG, r8.append(r9.size()).toString(), false, 4, null);
        if (r18 == true) goto L5;
        if (r7 != r5) goto L5;
    L7:
        if (e.a(r19, r7, r5, r6, r4) == false) goto L12;
        RunLog.INSTANCE.debug(TAG, "syncEnabledState notifyListeners size=" + r9.size());
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r0.hasNext() == false) goto L14;
        ((ae) ZeusTransformUtils.preCheckCast(r0.next(), ae.class, "com.obric.memorydata.plugin")).onChanged(r5);
        goto L10
    L14:
        return;
    L12:
        return;
    L5:
        getStore().save(KEY_PROACTIVE_RECOMMENDATION_ENABLED, r5);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "sync enabled state: " + r7 + " -> " + r5, false, 4, null);
        goto L7
    }

    static /* synthetic */ void syncEnabledState$default(ProactiveRecommendationEnabledStoreImpl r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        r1.syncEnabledState(r2, r3);
    }

    public final boolean isDbPreparationEligible() {
        return currentDbPreparationEligible.get();
    }

    @Override // com.obric.aiproactive.api.IProactiveRecommendationEnabledStore
    public boolean isEnabled() {
        return currentEnabled.get();
    }

    public final void onWakeUpPreferenceChanged() {
        start();
        syncEnabledState$default(this, false, false, 3, null);
    }

    @Override // com.obric.aiproactive.api.IProactiveRecommendationEnabledStore
    public void registerListener(ae r8, boolean r9) {
        ae r7 = (ae) ZeusTransformUtils.wrapperContextForParams(r8, ae.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "listener");
        CopyOnWriteArraySet<ae> r10 = listeners;
        r10.add(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "registerListener size=" + r10.size() + " emitCurrent=" + r9, false, 4, null);
        if (r9 == false) goto L6;
        r7.onChanged(currentEnabled.get());
        return;
    }

    public final void start() {
        if (started.compareAndSet(false, true) == true) goto L6;
        RunLog.INSTANCE.debug(TAG, "start ignored alreadyStarted=true");
        return;
    L6:
        boolean r0 = getStore().getBoolean(KEY_PROACTIVE_RECOMMENDATION_ENABLED, false);
        currentEnabled.set(r0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "start restore persisted=" + r0, false, 4, null);
        UserSettings.INSTANCE.registerAgreePrivacyListener((com.obric.memorydata.middleware.api.app.a) ZeusTransformUtils.preCheckCast(agreePrivacyListener, com.obric.memorydata.middleware.api.app.a.class, "com.obric.memorydata.plugin"));
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(loginStateListener, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "start registeredListeners", false, 4, null);
        syncEnabledState(true, true);
    }

    @Override // com.obric.aiproactive.api.IProactiveRecommendationEnabledStore
    public void unregisterListener(ae r7) {
        ae r6 = (ae) ZeusTransformUtils.wrapperContextForParams(r7, ae.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "listener");
        CopyOnWriteArraySet<ae> r8 = listeners;
        r8.remove(r6);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "unregisterListener size=" + r8.size(), false, 4, null);
    }

    public final void updateProactiveAgentEnabled(boolean r9) {
        boolean r0 = proactiveAgentEnabled;
        proactiveAgentEnabled = r9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "updateProactiveAgentEnabled old=" + r0 + " new=" + r9, false, 4, null);
        syncEnabledState$default(this, true, false, 2, null);
    }
}
