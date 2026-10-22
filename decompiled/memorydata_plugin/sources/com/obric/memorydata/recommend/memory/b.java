package com.obric.memorydata.recommend.memory;

import com.google.gson.reflect.TypeToken;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.bp;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/memory/ScreenObservationTopicHandler;", "", "data", "", "logId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "handle", "", "addTopic", "item", "Lcom/obric/memorydata/recommend/memory/EpisodicTopicData;", "index", "", "updateTopic", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12532a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12533b;
    private final String c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/recommend/memory/ScreenObservationTopicHandler$Companion;", "", "<init>", "()V", "TAG", "", "OP_ADD", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.memory.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonByType$1", "Lcom/google/gson/reflect/TypeToken;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0675b extends TypeToken<List<? extends EpisodicTopicData>> {
        public C0675b() {
        }
    }

    static {
        f12532a = new a(null);
    }

    public b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.f12533b = r2;
        this.c = r3;
    }

    private final void a(EpisodicTopicData r26) {
        Long r0 = r26.getTopicId();
        if (r0 != null) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTopicHandler", "update error: topic_id is null in " + r26, null, 4, null);
        return;
    L6:
        bp r3 = (bp) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicTopicMemoryDao().queryById(r0.longValue()), bp.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTopicHandler", "update error: entity not found for topic_id=" + r0, null, 4, null);
        return;
    L10:
        long r20 = System.currentTimeMillis();
        String r12 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r26.getRelatedMemoryIds(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        long r9 = r3.getId();
        String r11 = r26.getSummary();
        String r2 = this.c;
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new bp(r9, r11, r12, r2, r3.getEntityId(), r3.getCreateTime(), r20, r3.getType(), r20, r3.getPackageName(), r3.getHashCodeValue(), r3.getUuid()), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    }

    private final void a(EpisodicTopicData r23, int r24) {
        long r9 = System.currentTimeMillis();
        String r6 = "episodic_topic_memory_" + r9 + '_' + r24;
        String r4 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r23.getRelatedMemoryIds(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
        String r3 = r23.getSummary();
        String r0 = this.c;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new bp(0, r3, r4, r0, r6, r9, r9, -314, System.currentTimeMillis(), BuildConfig.LIBRARY_PACKAGE_NAME, 0, null, 2049, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    }

    public final void a() {
        GsonUtil r2 = GsonUtil.INSTANCE;     // Catch: Exception -> L21
        List r3 = (List) ZeusTransformUtils.preCheckCast(r2.getGSON().fromJson(this.f12533b, new C0675b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L21
        RunLog.INSTANCE.debug("ScreenObservationTopicHandler", "handle data: " + r3);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTopicHandler", "handle logId: " + this.c, false, 4, null);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r4 = false;
        int r5 = 0;
    L6:
        if (r0.hasNext() == false) goto L18;
        Object r6 = r0.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        EpisodicTopicData r8 = (EpisodicTopicData) ZeusTransformUtils.preCheckCast(r6, EpisodicTopicData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r8.getOp(), "add") == false) goto L15;
        a(r8, r5);
    L13:
        r4 = true;
    L17:
        r5 = r7;
        goto L6
    L15:
        if (Intrinsics.areEqual(r8.getOp(), BuildConfig.CHANNEL) == false) goto L17;
        a(r8);
        goto L13
    L18:
        if (r4 == false) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenObservationTopicHandler", "handle changed launchIndexTask", false, 4, null);
        EntityManager.INSTANCE.launchIndexTask();
        return;
    L29:
        return;
    L21:
        e = move-exception;
        RunLog.INSTANCE.error("ScreenObservationTopicHandler", "gson error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
