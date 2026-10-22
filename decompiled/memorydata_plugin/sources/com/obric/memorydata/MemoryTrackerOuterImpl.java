package com.obric.memorydata;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.memoryindex.m;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryTrackerOuterApi;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0000H\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/MemoryTrackerOuterImpl;", "Lcom/obric/memorydata/memory/api/MemoryTrackerOuterApi;", "<init>", "()V", "TAG", "", "KEY_TRACK_FINISHED_VERSION_1", "KEY_TRACK_FINISHED_VERSION_2", "KEY_TRACK_TIMESTAMP", "BATCH_SIZE", "", "getInst", "batchUploadOnce", "", "trackScreenMemorySwitch", "enabled", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryTrackerOuterImpl implements MemoryTrackerOuterApi {
    private static final int BATCH_SIZE = 500;
    public static final MemoryTrackerOuterImpl INSTANCE = null;
    private static final String KEY_TRACK_FINISHED_VERSION_1 = "history_memory_entity_track_finished_1";
    private static final String KEY_TRACK_FINISHED_VERSION_2 = "history_memory_entity_track_finished_2";
    private static final String KEY_TRACK_TIMESTAMP = "history_memory_entity_track_last_timestamp";
    private static final String TAG = "MemoryTrackerOuterImpl";

    static {
        INSTANCE = new MemoryTrackerOuterImpl();
    }

    private MemoryTrackerOuterImpl() {
    }

    private static final void batchUploadOnce$lambda$10() {
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean(KEY_TRACK_FINISHED_VERSION_2, false) == true) goto L6;
        y.a($$Lambda$MemoryTrackerOuterImpl$Syje9DwsHzvk1LBKQ4b9V3DpPa0.INSTANCE, $$Lambda$MemoryTrackerOuterImpl$P679rRUcDLTqz2sbd9IvRzgNSRg.INSTANCE);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run finished", false, 4, null);
        return;
    }

    private static final Unit batchUploadOnce$lambda$10$lambda$0(Exception r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        RunLog.INSTANCE.warn(TAG, "run failed", (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit batchUploadOnce$lambda$10$lambda$9() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run really", false, 4, null);
        long r0 = System.currentTimeMillis();
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        List r5 = (List) ZeusTransformUtils.preCheckCast(r3.next(), List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run, rawMemoryEntity size: " + r5.size(), false, 4, null);
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        RawMemoryEntity r9 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(r6.next(), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        MemoryEntity r8 = m.a().toMemoryEntity(r9);
        if (r8 == null) goto L7;
        MemoryEventTracker.a(MemoryEventTracker.f10515a, r8, r9, MemoryEventTracker.GenerateMethod.ADD_NEW.getValue(), true, null, 16, null);
        goto L7
    L11:
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L13:
        if (r4.hasNext() == false) goto L20;
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4.next(), List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run, auditoryRecording size: " + r7.size(), false, 4, null);
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r10.hasNext() == false) goto L13;
        AppEntity r11 = ((fj) ZeusTransformUtils.preCheckCast(r10.next(), fj.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r11 == null) goto L16;
        MemoryEventTracker.f10515a.a(r11, MemoryEventTracker.GenerateMethod.ADD_NEW.getValue(), true);
        goto L16
    L20:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryAll(), Iterable.class, "com.obric.memorydata.plugin"), 500), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L22:
        if (r12.hasNext() == false) goto L29;
        List r13 = (List) ZeusTransformUtils.preCheckCast(r12.next(), List.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run, shortMemory size: " + r13.size(), false, 4, null);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r14.hasNext() == false) goto L22;
        AppEntity r15 = ((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r14.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r15 == null) goto L25;
        MemoryEventTracker.f10515a.a(r15, MemoryEventTracker.GenerateMethod.ADD_NEW.getValue(), true);
        goto L25
    L29:
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(KEY_TRACK_FINISHED_VERSION_2, true);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(KEY_TRACK_TIMESTAMP, r0);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final MemoryTrackerOuterImpl getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ Unit lambda$P679rRUcDLTqz2sbd9IvRzgNSRg() {
        return batchUploadOnce$lambda$10$lambda$9();
    }

    public static /* synthetic */ Unit lambda$Syje9DwsHzvk1LBKQ4b9V3DpPa0(Exception r0) {
        return batchUploadOnce$lambda$10$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$kYvTPtBMAdCkO9HcfO4kX4gW66c() {
        batchUploadOnce$lambda$10();
    }

    @Override // com.obric.memorydata.memory.api.MemoryTrackerOuterApi
    public void batchUploadOnce() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run", false, 4, null);
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$MemoryTrackerOuterImpl$kYvTPtBMAdCkO9HcfO4kX4gW66c.INSTANCE);
    }

    @Override // com.obric.memorydata.memory.api.MemoryTrackerOuterApi
    public void trackScreenMemorySwitch(boolean r7) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "trackScreenMemorySwitch: enabled=" + r7, false, 4, null);
        com.obric.memorydata.memory.tracker.f.f10542a.a();
    }
}
