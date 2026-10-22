package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/ui/settings/contextawareness/ContextAwarenessSourceDefaultsMigration;", "", "<init>", "()V", "TAG", "", "MIGRATION_DONE_KEY", "MIGRATION_DECISION_KEY", "DECISION_UNSET", "", "DECISION_KEEP_DEFAULTS_OFF", "DECISION_ENABLE_WITHOUT_LOCATION", "DECISION_ENABLE_WITH_LOCATION", "migrateIfNeeded", "", "migrateIfNeededInternal", "getOrCreateDecision", "settingsStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "hasPersistedScreenObservationEnabled", "", "saveEnabledDefaults", "keys", "", "markMigrationDone", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f11460a = null;

    static {
        f11460a = new k();
    }

    private k() {
    }

    private final int a(IStore r10) {
        IStore r11 = (IStore) ZeusTransformUtils.wrapperContextForParams(r10, IStore.class, "com.obric.memorydata.plugin");
        int r3 = r11.getInt("context_awareness_source_defaults_decision_v1", 0);
        int r4 = 1;
        if (1 <= r3) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L11;
        return r3;
    L11:
        if (c() == true) goto L14;
    L17:
        r11.save("context_awareness_source_defaults_decision_v1", r4);
        if (r11.getInt("context_awareness_source_defaults_decision_v1", 0) == r4) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContextSourceDefaultsMigration", "code=CA_SOURCE_DEFAULT_DECISION_WRITE_FAILED; retry next startup", null, 4, null);
        return 0;
    L21:
        return r4;
    L14:
        if (com.obric.memorydata.memory.permission.b.f10340a.a() == false) goto L16;
        r4 = 3;
        goto L17
    L16:
        r4 = 2;
        goto L17
    L5:
        if (r3 >= 4) goto L7;
        r5 = true;
        goto L8
    }

    private final boolean a(IStore r5, List<String> r6) {
        IStore r4 = (IStore) ZeusTransformUtils.wrapperContextForParams(r5, IStore.class, "com.obric.memorydata.plugin");
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L12;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        r4.save(r9, true);
        if (r4.getBoolean(r9, false) == true) goto L9;
        return false;
    L12:
        return true;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final void b() {
        boolean r3 = false;
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        if (r0.getBoolean("context_awareness_source_defaults_migrated_v1", false) == false) goto L6;
        r0.remove(new String[]{"context_awareness_source_defaults_decision_v1"});
        return;
    L6:
        int r1 = a(r0);
        if (r1 != 0) goto L10;
        return;
    L10:
        if (r1 == 1) goto L12;
        boolean r6 = true;
    L14:
        if (r1 == 3) goto L16;
    L18:
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(l.a(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r2.iterator();
    L20:
        if (r4.hasNext() == false) goto L24;
        Object r7 = r4.next();
        if (r0.contains((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin")) == false) goto L20;
        r5.add(r7);
        goto L20
    L24:
        List<String> r8 = m.f11461a.a(r6, r3, (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin"));
        if (a(r0, r8) == true) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContextSourceDefaultsMigration", "code=CA_SOURCE_DEFAULT_WRITE_FAILED; retry next startup", null, 4, null);
        return;
    L29:
        if (b(r0) == true) goto L31;
        return;
    L31:
        r0.remove(new String[]{"context_awareness_source_defaults_decision_v1"});
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContextSourceDefaultsMigration", "code=CA_SOURCE_DEFAULT_MIGRATION_FINISHED; screenEnabled=" + r6 + ", enabledCount=" + r8.size() + ", locationEnabled=" + r8.contains("context_awareness_location_enabled"), false, 4, null);
        return;
    L16:
        if (com.obric.memorydata.memory.permission.b.f10340a.a() == false) goto L18;
        r3 = true;
        goto L18
    L12:
        r6 = false;
        goto L14
    }

    private final boolean b(IStore r10) {
        IStore r9 = (IStore) ZeusTransformUtils.wrapperContextForParams(r10, IStore.class, "com.obric.memorydata.plugin");
        r9.save("context_awareness_source_defaults_migrated_v1", true);
        if (r9.getBoolean("context_awareness_source_defaults_migrated_v1", false) == false) goto L5;
        return true;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContextSourceDefaultsMigration", "code=CA_SOURCE_DEFAULT_MARKER_WRITE_FAILED; retry next startup", null, 4, null);
        return false;
    }

    private final boolean c() {
        IStore r4 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "recommend_store", 0, 2, null);
        if (r4.contains("recommend_enabled") == true) goto L5;
        return false;
    L5:
        if (r4.getBoolean("recommend_enabled", false) == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final synchronized void a() {
        monitor-enter(this);
        b();     // Catch: Throwable -> L5 Exception -> L7
    L9:
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContextSourceDefaultsMigration", "code=CA_SOURCE_DEFAULT_MIGRATION_FAILED; errorType=" + e.getClass().getSimpleName() + "; retry next startup", null, 4, null);     // Catch: Throwable -> L5
        goto L9
    }
}
