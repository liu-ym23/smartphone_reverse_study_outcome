package com.obric.memorydata.memory.tracker;

import androidx.core.app.NotificationCompat;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.ba;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004#$%&B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0004\b\u000e\u0010\fJ\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\nH\u0002J\u0015\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/memorydata/memory/tracker/PersonalContextCountTracker;", "", "<init>", "()V", "TAG", "", "EVENT_PERSONAL_CONTEXT_COUNT", "EVENT_MEMORY_COUNT_AND_CHAR", "reportPersonalContextCount", "Lkotlin/Result;", "", "reportPersonalContextCount-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportMemoryCountAndChar", "reportMemoryCountAndChar-IoAF18A", "reportContactCount", "reportCallHistoryCount", "reportMessageCount", "reportNoteCount", "reportAlbumCount", "reportAlarmCount", "reportFileCount", "reportRecordingCount", "reportScheduleCount", "getTotalCount", "", "tableName", "reportCountEvent", "type", CommonConsts.COUNT_TYPE, "reportMemoryCountForPersonalContext", "reportMemoryCountAndCharInternal", "mapMemorySourceAgg", "productType", "mapMemorySourceAgg$memory_obricRelease", "DataType", "MemoryCountAndCharType", "MemorySourceAgg", "CountCharStat", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f10547a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/memory/tracker/PersonalContextCountTracker$CountCharStat;", "", CommonConsts.COUNT_TYPE, "", "totalChar", "<init>", "(II)V", "getCount", "()I", "setCount", "(I)V", "getTotalChar", "setTotalChar", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10548a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10549b;

        public a() {
            int r0 = 0;
            this(r0, r0, 3, null);
        }

        public a(int r1, int r2) {
            this.f10548a = r1;
            this.f10549b = r2;
        }

        public /* synthetic */ a(int r2, int r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = 0;
        L8:
            this(r2, r3);
        }

        public final int a() {
            return this.f10548a;
        }

        public final void a(int r1) {
            this.f10548a = r1;
        }

        public final int b() {
            return this.f10549b;
        }

        public final void b(int r1) {
            this.f10549b = r1;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f10548a == r6.f10548a) goto L12;
            return false;
        L12:
            if (this.f10549b == r6.f10549b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f10548a) * 31) + Integer.hashCode(this.f10549b);
        }

        public String toString() {
            return "CountCharStat(count=" + this.f10548a + ", totalChar=" + this.f10549b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/tracker/PersonalContextCountTracker$MemoryCountAndCharType;", "", "<init>", "()V", "EPISODIC", "", "SEMANTIC_USERINFO", "SEMANTIC_PREFERENCE", "SEMANTIC_RELATIONSHIP", "SEMANTIC_INTERESTS", "AUDITORY_MEMORY", "AUTO_PRO", "fromSemanticType", "semanticType", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f10550a = null;

        static {
            f10550a = new b();
        }

        private b() {
        }

        public final String a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "semanticType");
            String r1 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(r1, "toLowerCase(...)");
            switch(r1.hashCode()) {
                case -1459831589: goto L17;
                case -265850119: goto L14;
                case -261851592: goto L10;
                case 502611593: goto L6;
                default: goto L20;
            };
        L20:
            return null;
        L6:
            if (r1.equals("interests") == false) goto L20;
            return "semantic_interests";
        L10:
            if (r1.equals("relationship") == false) goto L20;
            return "semantic_relationship";
        L14:
            if (r1.equals("userinfo") == false) goto L20;
            return "semantic_userinfo";
        L17:
            if (r1.equals("preference") == false) goto L20;
            return "semantic_preference";
        }
    }

    static {
        f10547a = new h();
    }

    private h() {
    }

    private final int a(String r5) {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().getCount((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT COUNT(*) FROM " + r5), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("PersonalContextCountTracker", "getTotalCount failed for table: " + r5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return 0;
    }

    private final void a() {
        a("contact", a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void a(h r0) {
        r0.a();
    }

    private final void a(String r3, int r4) {
        JSONObject r2 = new JSONObject();
        r2.put("type", r3);
        r2.put("total_count", r4);
        Tracker.INSTANCE.reportEvent("personal_context_count", r2);
        RunLog.INSTANCE.debug("PersonalContextCountTracker", "reportCountEvent: type=" + r3 + ", count=" + r4);
    }

    private final void b() {
        a("callHistory", a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void b(h r0) {
        r0.b();
    }

    private final void c() {
        a("message", a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void c(h r0) {
        r0.c();
    }

    private final void d() {
        a("note", a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void d(h r0) {
        r0.d();
    }

    private final void e() {
        a("album", a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void e(h r0) {
        r0.e();
    }

    private final void f() {
        a(NotificationCompat.CATEGORY_ALARM, a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlarmRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void f(h r0) {
        r0.f();
    }

    private final void g() {
        a("file", a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void g(h r0) {
        r0.g();
    }

    private final void h() {
        a("recording", a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void h(h r0) {
        r0.h();
    }

    private final void i() {
        a("schedule", a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getIcsProtocolRawDbDao().getTableName()));
    }

    public static final /* synthetic */ void i(h r0) {
        r0.i();
    }

    private final void j() {
        int r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getAllMemoryForTracker().size();
        int r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getTotalCount();
        int r2 = a(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().getTableName());
        int r3 = (r0 + r1) + r2;
        a(SlardarSettingsConstants.PERF_KEY_MEMORY, r3 + a(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().getTableName()));
    }

    public static final /* synthetic */ void j(h r0) {
        r0.j();
    }

    private final void k() {
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getAllMemoryForTracker(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        DefaultConstructorMarker r3 = null;
        int r4 = 3;
        int r5 = 0;
        if (r0.hasNext() == false) goto L9;
        EpisodicMemoryEntity r1 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r0.next(), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        String r6 = f10547a.a(r1.getProductType());
        int r7 = r1.getTitle().length() + r1.getContent().length();
        Pair r2 = TuplesKt.to("episodic", r6);
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin");
        Object r9 = r8.get(r2);
        if (r9 != null) goto L8;
        r9 = new a(r5, r5, r4, r3);
        r8.put(r2, r9);
    L8:
        a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
        r10.a(r10.a() + 1);
        r10.b(r10.b() + r7);
        goto L3
    L9:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().getAllOrderByUserEditAndModifyTime(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L11:
        if (r11.hasNext() == false) goto L19;
        ip r12 = (ip) ZeusTransformUtils.preCheckCast(r11.next(), ip.class, "com.obric.memorydata.plugin");
        String r14 = b.f10550a.a(r12.a());
        if (r14 == null) goto L14;
        String r15 = f10547a.a(r12.i());
        int r16 = r12.c().length();
        Pair r17 = TuplesKt.to(r14, r15);
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin");
        Object r19 = r18.get(r17);
        if (r19 != null) goto L18;
        r19 = new a(r5, r5, r4, r3);
        r18.put(r17, r19);
    L18:
        a r20 = (a) ZeusTransformUtils.preCheckCast(r19, a.class, "com.obric.memorydata.plugin");
        r20.a(r20.a() + 1);
        r20.b(r20.b() + r16);
        goto L11
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextCountTracker", "skip semantic memory with unknown semanticType=" + r12.a(), null, 4, null);
        goto L11
    L19:
        List<fj> r21 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().getAllRecordings2();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L33;
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r23 = 0;
    L23:
        if (r22.hasNext() == false) goto L29;
        fj r24 = (fj) ZeusTransformUtils.preCheckCast(r22.next(), fj.class, "com.obric.memorydata.plugin");
        int r25 = r24.c().length();
        String r26 = r24.h();
        if (r26 == null) goto L27;
        int r27 = r26.length();
    L28:
        r23 = r23 + (r25 + r27);
        goto L23
    L27:
        r27 = 0;
        goto L28
    L29:
        Pair r28 = TuplesKt.to("auditory_memory", "");
        Map r29 = (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin");
        Object r30 = r29.get(r28);
        if (r30 != null) goto L32;
        r30 = new a(r5, r5, r4, r3);
        r29.put(r28, r30);
    L32:
        a r31 = (a) ZeusTransformUtils.preCheckCast(r30, a.class, "com.obric.memorydata.plugin");
        r31.a(r31.a() + r21.size());
        r31.b(r31.b() + r23);
    L33:
        List<AutoMemoryProEntity> r32 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().getAllForTracker();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r32, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L43;
        Iterator r33 = ((Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r34 = 0;
    L37:
        if (r33.hasNext() == false) goto L39;
        AutoMemoryProEntity r35 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r33.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        r34 = r34 + ((r35.getTitle().length() + r35.getSubtitle().length()) + r35.getContent().length());
        goto L37
    L39:
        Pair r36 = TuplesKt.to("auto_pro", "auto_memory_pro");
        Map r37 = (Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin");
        Object r38 = r37.get(r36);
        if (r38 != null) goto L42;
        r38 = new a(r5, r5, r4, r3);
        r37.put(r36, r38);
    L42:
        a r39 = (a) ZeusTransformUtils.preCheckCast(r38, a.class, "com.obric.memorydata.plugin");
        r39.a(r39.a() + r32.size());
        r39.b(r39.b() + r34);
    L43:
        Iterator r110 = ((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L45:
        if (r110.hasNext() == false) goto L47;
        Map.Entry r40 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Pair r41 = (Pair) ZeusTransformUtils.preCheckCast(r40.getKey(), Pair.class, "com.obric.memorydata.plugin");
        a r42 = (a) ZeusTransformUtils.preCheckCast(r40.getValue(), a.class, "com.obric.memorydata.plugin");
        String r43 = (String) ZeusTransformUtils.preCheckCast(r41.component1(), String.class, "com.obric.memorydata.plugin");
        String r44 = (String) ZeusTransformUtils.preCheckCast(r41.component2(), String.class, "com.obric.memorydata.plugin");
        JSONObject r45 = new JSONObject();
        r45.put("memory_type", r43);
        r45.put("memory_source", r44);
        r45.put("total_count", r42.a());
        r45.put("total_char", r42.b());
        Tracker.INSTANCE.reportEvent("memory_count_and_char", r45);
        goto L45
    }

    public static final /* synthetic */ void k(h r0) {
        r0.k();
    }

    public final Object a(Continuation<? super Result<Unit>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, PersonalContextCountTracker$reportPersonalContextCount$1.class) == false) goto L7;
        PersonalContextCountTracker$reportPersonalContextCount$1 r0 = (PersonalContextCountTracker$reportPersonalContextCount$1) ZeusTransformUtils.preCheckCast(r7, PersonalContextCountTracker$reportPersonalContextCount$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r5);
    L18:
        return ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new PersonalContextCountTracker$reportPersonalContextCount$2(null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r5 = kotlinx.coroutines.i.a(r9, r3, r0);
        if (r5 != r8) goto L18;
        return r8;
    L7:
        r0 = new PersonalContextCountTracker$reportPersonalContextCount$1(this, r7);
        goto L8
    }

    public final String a(int r1) {
        switch(r1) {
            case 1001: goto L9;
            case 1002: goto L8;
            case 1003: goto L7;
            case 1004: goto L6;
            case 1005: goto L5;
            case 1006: goto L4;
            default: goto L3;
        };
    L3:
        return "";
    L4:
        return "auditory_memory";
    L5:
        return "environment_memory";
    L6:
        return "auto_memory_pro";
    L7:
        return "proactive";
    L8:
        return "oauto";
    L9:
        return "screen_observation";
    }

    public final Object b(Continuation<? super Result<Unit>> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, PersonalContextCountTracker$reportMemoryCountAndChar$1.class) == false) goto L7;
        PersonalContextCountTracker$reportMemoryCountAndChar$1 r0 = (PersonalContextCountTracker$reportMemoryCountAndChar$1) ZeusTransformUtils.preCheckCast(r7, PersonalContextCountTracker$reportMemoryCountAndChar$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r5);
    L18:
        return ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r3 = (Function2) ZeusTransformUtils.preCheckCast(new PersonalContextCountTracker$reportMemoryCountAndChar$2(null), Function2.class, "com.obric.memorydata.plugin");
        r0.label = 1;
        r5 = kotlinx.coroutines.i.a(r9, r3, r0);
        if (r5 != r8) goto L18;
        return r8;
    L7:
        r0 = new PersonalContextCountTracker$reportMemoryCountAndChar$1(this, r7);
        goto L8
    }
}
