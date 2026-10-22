package com.obric.memorydata.init.tasks;

import android.content.Context;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityCollectorService;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
import com.obric.memorydata.personalcontext.api.PersonalContextAPI;
import com.obric.memorydata.personalcontext.collector.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/EntityInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9891a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/EntityInitTask$Companion;", "", "<init>", "()V", "TAG", "", "KEY_OF_SELF_COLLECTION_NEED_SYNC_ON_RESTART", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9891a = new a(null);
    }

    public EntityInitTask() {
    }

    @Override // java.lang.Runnable
    public void run() {
        RunLog.INSTANCE.debug("EntityInitTask", "EntityInitTask init");
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("SEARCH_GLOBAL_RECORD_STORE_KEY", SetsKt.emptySet());
        IEntityCollectorService.b.a((IEntityCollectorService) ZeusTransformUtils.preCheckCast(EntityCollectorService.INSTANCE, IEntityCollectorService.class, "com.obric.memorydata.plugin"), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), false, 2, null);
        IStore r8 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        boolean r2 = r8.getBoolean("device_info_selfCollectionNeedSyncOnRestart", false);
        boolean r4 = EntityManager.INSTANCE.isAllEntityDonated();
        RunLog.INSTANCE.debug("EntityInitTask", "self collection config changed: needSyncDonate=" + r2 + ",allEntityDonated=" + r4);
        r8.save("device_info_selfCollectionNeedSyncOnRestart", false);
        if (r2 == false) goto L6;
        if (r4 == false) goto L6;
        PersonalContextAPI.INSTANCE.triggerEntityConsistencyCheckTask(true, true, false);
    L6:
        l.f12076a.a(true ^ r2);
    }
}
