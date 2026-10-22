package com.obric.memorydata.recommend.memory;

import android.content.Context;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ew;
import com.obric.memorydata.database.entity.gd;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryBuildOuter;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.GsonUtil;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/recommend/memory/ScreenObservationMemoryHandler;", "", "produceResult", "", "<init>", "(Ljava/lang/String;)V", "handle", "", "startBuildProfile", "startBuildEpisodicTopicMemory", "constructShortMemoryEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "scrObMemoryEntity", "Lcom/obric/memorydata/recommend/memory/ScrObMemoryEntity;", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0674a f12530a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12531b;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.memory.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/memory/ScreenObservationMemoryHandler$Companion;", "", "<init>", "()V", "TAG", "", "BUILD_PROFILE_TASK_NAME", "BUILD_EPISODIC_TOPIC_MEMORY_TASK_NAME", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0674a {
        private C0674a() {
        }

        public /* synthetic */ C0674a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    static {
        f12530a = new C0674a(null);
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "produceResult");
        this.f12531b = r2;
    }

    private final EpisodicMemoryEntity a(ScrObMemoryEntity r55) {
        String r0 = r55.getEntityId();
        boolean r1 = false;
        boolean r28 = false;
        if (r0 == null) goto L13;
        String r2 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (r2 == null) goto L13;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L9;
        r1 = true;
    L9:
        if (r1 == true) goto L12;
        r2 = null;
    L12:
        if (r2 == null) goto L13;
    L14:
        String r29 = r2;
        long r5 = r55.getCreateTimestamp();
        String r3 = r55.getTitle();
        if (r3 != null) goto L17;
        String r9 = "";
    L18:
        String r10 = r55.getContent();
        String r13 = r55.getObservation();
        ScrObMemoryExtra r4 = r55.getExtra();
        if (r4 == null) goto L24;
        String r6 = r4.getLocation();
        if (r6 == null) goto L24;
        String r14 = r6;
    L25:
        int r7 = r55.getCategory();
        long r24 = r55.getStartTimestamp();
        long r26 = r55.getEndTimestamp();
        long r30 = r55.getCreateTimestamp();
        long r32 = r55.getModifyTimestamp();
        long r35 = System.currentTimeMillis();
        String r20 = r55.getLogId();
        boolean r8 = r55.getUseLocation();
        String r12 = "";
        String r15 = "";
        String r37 = BuildConfig.LIBRARY_PACKAGE_NAME;
        return new EpisodicMemoryEntity(0, r5, 0, r9, r10, null, r12, r13, r14, r15, Integer.valueOf(r7), null, null, null, r20, r28, Boolean.valueOf(r8), false, r24, r26, r28, r29, r30, r32, -306, r35, r37, 0, null, null, 1001, null, null, null, null, null, null, null, null, -1342046207, 127, null);
    L24:
        r14 = "";
        goto L25
    L17:
        r9 = r3;
    L13:
        r2 = gd.f9146a.a();
        goto L14
    }

    private final void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationMemoryHandler", "startBuildEpisodicTopicMemory", false, 4, null);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("episodic_topic_memory").setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON_OR_CHARGE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public final void a() {
        if (EvaluationService.INSTANCE.isCqcEvaluationMode() == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationMemoryHandler", "handle ignored, cqc evaluation mode is enabled", null, 4, null);
        return;
    L6:
        GsonUtil r0 = GsonUtil.INSTANCE;
        Object r1 = r0.getGSON().fromJson(this.f12531b, ScrObMemoryProduceResult.class);     // Catch: Exception -> L9
    L11:
        ScrObMemoryProduceResult r2 = (ScrObMemoryProduceResult) ZeusTransformUtils.preCheckCast(r1, ScrObMemoryProduceResult.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L15;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationMemoryHandler", "handle error, memoryResult is null", null, 4, null);
        return;
    L15:
        int r4 = r2.getCode();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationMemoryHandler", "start handle, code = " + r4 + ", msg = " + r2.getMsg(), false, 4, null);
        int r6 = 1;
        boolean r7 = false;
        if (r4 != 0) goto L53;
        List<ScrObMemoryEntity> r5 = r2.getMemoryList();
        if (r5 == null) goto L20;
        boolean r8 = !((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
    L21:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationMemoryHandler", "handle hasNewMemory " + r8, false, 4, null);
        List<ScrObMemoryEntity> r3 = r2.getMemoryList();
        if (r3 == null) goto L50;
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        String r10 = "";
    L25:
        if (r9.hasNext() == false) goto L50;
        ScrObMemoryEntity r11 = (ScrObMemoryEntity) ZeusTransformUtils.preCheckCast(r9.next(), ScrObMemoryEntity.class, "com.obric.memorydata.plugin");
        EpisodicMemoryEntity r12 = a(r11);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L29;
        int r13 = r6;
    L30:
        if (r13 != 0) goto L32;
    L34:
        EpisodicMemoryEntity r14 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r12.getEntityId());
        if (com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r12, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, r6, null) == false) goto L49;
        ew r15 = (ew) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().queryByTypeAndEntityId(r6, r12.getEntityId())), ew.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L39;
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().insert(new ew(0, System.currentTimeMillis(), 1, r12.getEntityId(), 0, 17, null));
    L40:
        EpisodicMemoryEntity r16 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r12.getEntityId());
        if (r16 == null) goto L49;
        AppEntity r17 = r16.convertToAppEntity();
        if (r17 == null) goto L49;
        MemoryBuildOuter r18 = MemoryBuildOuter.INSTANCE;
        if (r14 == null) goto L47;
        String r19 = BuildConfig.CHANNEL;
    L48:
        r18.trackAppEntityIndex(r17, r19, false);
        goto L49
    L47:
        r19 = "add_new";
        goto L48
    L39:
        r15.a(0);
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveMemorySyncPendingDao().update(r15);
    L49:
        r6 = 1;
        goto L25
    L32:
        if (at.a(r11.getLogId()) == false) goto L34;
        r10 = r11.getLogId();
        goto L34
    L29:
        r13 = 0;
    L50:
        if (r8 == false) goto L53;
        EntityManager.INSTANCE.launchIndexTask();
        b();
        goto L53
    L20:
        r8 = false;
    L53:
        if (AppContext.INSTANCE.isDebug() == true) goto L55;
        return;
    L55:
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("is_screen_observation_evaluation_enable", false) == false) goto L89;
        String r20 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir().getAbsolutePath() + "/extract_process.txt";
        if (new File(r20).exists() == true) goto L59;
        new File(r20).createNewFile();
    L59:
        String r21 = FilesKt.readText$default(new File(r20), null, 1, null);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L62;
        r7 = true;
    L62:
        if (r7 == false) goto L81;
        List r22 = CollectionsKt.listOf(this.f12531b);
    L77:
        FilesKt.writeText$default(new File(r20), u.a(r22), null, 2, null);
        return;
    L81:
        List r23 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r21, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L67 JsonSyntaxException -> L69
    L72:
        if (r23 != null) goto L74;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationMemoryHandler", "extract_process history parse failed, fileLength=" + r21.length() + ", fileHash=" + r21.hashCode() + ", preview=" + StringsKt.take(r21, 500), null, 4, null);
    L74:
        if (r23 != null) goto L76;
        r23 = CollectionsKt.emptyList();
    L76:
        r22 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"), this.f12531b);
        goto L77
    L69:
        e = e;
        IRunLog r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r24 = new StringBuilder();
    L71:
        IRunLog.a.b(r110, "GsonExt", r24.append("toListObj error : ").append(e).toString(), null, 4, null);
        r23 = null;
    L67:
        e = e;
        r110 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r24 = new StringBuilder();
        goto L71
    L89:
        return;
    L9:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), GsonUtil.TAG, "json error ：" + e, null, 4, null);
        r1 = null;
        goto L11
    }
}
