package com.obric.memorydata.memory.ui.list;

import android.database.sqlite.SQLiteException;
import android.security.obric.guard.ObricSecurityGuardStub;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import com.google.gson.reflect.TypeToken;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.SemanticConflictSnapshot;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.union.build.storage.SemanticConfirmationResult;
import com.obric.memorydata.utils.GsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0002\u001b\u001e\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010 \u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0019H\u0096@¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u000fH\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\bH\u0002J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J'\u0010.\u001a\u0004\u0018\u00010/2\f\u00100\u001a\b\u0012\u0004\u0012\u0002010,2\b\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0002\u00103J\b\u00104\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u00065"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/DatabasePendingPersonalInfoRepository;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "mutableState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoRepositoryState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "requests", "Lkotlinx/coroutines/channels/Channel;", "", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "observedDatabase", "Landroidx/room/RoomDatabase;", "boundUserId", "", "manualReviewItemIds", "", "closed", "", "observer", "com/obric/memorydata/memory/ui/list/DatabasePendingPersonalInfoRepository$observer$1", "Lcom/obric/memorydata/memory/ui/list/DatabasePendingPersonalInfoRepository$observer$1;", "loginListener", "com/obric/memorydata/memory/ui/list/DatabasePendingPersonalInfoRepository$loginListener$1", "Lcom/obric/memorydata/memory/ui/list/DatabasePendingPersonalInfoRepository$loginListener$1;", "refresh", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "review", "Lcom/obric/memorydata/union/build/storage/SemanticConfirmationResult;", "item", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;", ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CONFIRM, "(Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshLocked", "canAccessUser", "readSnapshot", "readPendingCandidates", "", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "activation", "", "times", "", "referenceTime", "(Ljava/util/List;Ljava/lang/Long;)Ljava/lang/Double;", IslandSession.REOPEN_VALUE_CLOSE, "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlinx.coroutines.flow.ae<ay> f11305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.flow.ar<ay> f11306b;
    private final kotlinx.coroutines.channels.i<Unit> c;
    private final kotlinx.coroutines.sync.a d;
    private RoomDatabase e;
    private String f;
    private Set<String> g;
    private volatile boolean h;
    private final DatabasePendingPersonalInfoRepository$observer$1 i;
    private final a j;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/DatabasePendingPersonalInfoRepository$loginListener$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.middleware.api.app.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f11307a;

        a(f r1) {
            this.f11307a = r1;
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "userId");
            f.f(this.f11307a).mo54trySendJP2dKIU(Unit.INSTANCE);
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r10) {
            Intrinsics.checkNotNullParameter(r10, "lastUserId");
            f.d(this.f11307a).b(new ay(null, 0, false, false, "ACCOUNT_CHANGED", 15, null));
            f.f(this.f11307a).mo54trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b<T> implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getSecond(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f11308a;

        public c(Comparator r3) {
            this.f11308a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            int r1 = this.f11308a.compare(r2, r3);
            if (r1 == 0) goto L6;
            return r1;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((ar) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r2, Pair.class, "com.obric.memorydata.plugin")).getFirst(), ar.class, "com.obric.memorydata.plugin")).a(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((ar) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r3, Pair.class, "com.obric.memorydata.plugin")).getFirst(), ar.class, "com.obric.memorydata.plugin")).a(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f11309a;

        public d(Comparator r3) {
            this.f11309a = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Comparator
        public final int compare(T r4, T r5) {
            int r3 = this.f11309a.compare(r4, r5);
            if (r3 == 0) goto L6;
            return r3;
        L6:
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ar) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r5, Pair.class, "com.obric.memorydata.plugin")).getFirst(), ar.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(((ar) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r4, Pair.class, "com.obric.memorydata.plugin")).getFirst(), ar.class, "com.obric.memorydata.plugin")).e()), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e extends TypeToken<List<? extends String>> {
        public e() {
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.f$f, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0608f extends TypeToken<List<? extends String>> {
        public C0608f() {
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [com.obric.memorydata.memory.ui.list.DatabasePendingPersonalInfoRepository$observer$1] */
    public f(kotlinx.coroutines.al r12) {
        kotlinx.coroutines.al r2 = (kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r12, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "scope");
        kotlinx.coroutines.flow.ae<ay> r13 = kotlinx.coroutines.flow.at.a(new ay(null, 0, false, false, null, 31, null));
        this.f11305a = r13;
        this.f11306b = kotlinx.coroutines.flow.k.a(r13);
        kotlinx.coroutines.channels.i<Unit> r14 = kotlinx.coroutines.channels.l.a(-1, null, null, 6, null);
        this.c = r14;
        this.d = kotlinx.coroutines.sync.c.a(false, 1, null);
        final String[] r3 = {"ShortMemory", "SemanticState"};
        this.i = new DatabasePendingPersonalInfoRepository$observer$1(this, r3);
        a r4 = new a(this);
        this.j = r4;
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        kotlinx.coroutines.i.a(r2, (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new DatabasePendingPersonalInfoRepository$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
        r14.mo54trySendJP2dKIU(Unit.INSTANCE);
    }

    private final Double a(List<Long> r8, Long r9) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r7.isEmpty() == true) goto L20;
        if (r9 == null) goto L29;
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r11.hasNext() == false) goto L14;
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(r11.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r10.isEmpty() == true) goto L13;
        if ((r1 - ((Number) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r10), Number.class, "com.obric.memorydata.plugin")).longValue()) <= ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L8;
    L13:
        ((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.memorydata.plugin")).add(Long.valueOf(r1));
        goto L8
    L14:
        double r2 = 0.0d;
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r12.hasNext() == false) goto L19;
        r2 = r2 + (1.0d / Math.sqrt(RangesKt.coerceAtLeast((r9.longValue() - ((Number) ZeusTransformUtils.preCheckCast(r12.next(), Number.class, "com.obric.memorydata.plugin")).longValue()) / 8.64E7d, 1.0d)));
        goto L16
    L19:
        return Double.valueOf(Math.log(r2));
    L29:
        return null;
    L20:
        return null;
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a a(f r0) {
        return r0.d;
    }

    public static final /* synthetic */ void a(f r2, Set r3) {
        r2.g = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void b(f r0) {
        r0.c();
    }

    private final void c() {
        if (d() == true) goto L25;
        this.f11305a.b(new ay(null, 0, false, false, "ACCOUNT_CHANGED", 15, null));
        return;
    L25:
        PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();     // Catch: SQLiteException -> L23
        monitor-enter(this);     // Catch: SQLiteException -> L23
    L20:
        th = move-exception;
        throw th;     // Catch: SQLiteException -> L23
    L9:
        if (this.h == false) goto L13;
        monitor-exit(this);     // Catch: SQLiteException -> L23
        return;
    L13:
        if (this.e != null) goto L15;
        r0.getInvalidationTracker().addObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(this.i, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L20
        this.e = (RoomDatabase) ZeusTransformUtils.preCheckCast(r0, RoomDatabase.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
    L15:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: SQLiteException -> L23
        ay r2 = (ay) ZeusTransformUtils.preCheckCast(r0.runInTransaction(new $$Lambda$f$dOfQvo7qIw8_CeQWLrk65j3gA(this)), ay.class, "com.obric.memorydata.plugin");     // Catch: SQLiteException -> L23
        if (d() == false) goto L28;
        this.f11305a.b(r2);     // Catch: SQLiteException -> L23
        return;
    L28:
        return;
    L23:
        kotlinx.coroutines.flow.ae<ay> r9 = this.f11305a;
        r9.b(ay.a((ay) ZeusTransformUtils.preCheckCast(r9.c(), ay.class, "com.obric.memorydata.plugin"), null, 0, false, false, "STORAGE_FAILED", 15, null));
    }

    public static final /* synthetic */ boolean c(f r0) {
        return r0.d();
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae d(f r0) {
        return r0.f11305a;
    }

    private final boolean d() {
        String r0 = UserSettings.INSTANCE.getUserId();
        if (this.h == false) goto L5;
        return false;
    L5:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L7;
        return false;
    L7:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L10;
        return false;
    L10:
        if (this.f != null) goto L13;
        this.f = r0;
    L13:
        return Intrinsics.areEqual(this.f, r0);
    }

    private final ay e() {
        PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        if (com.obric.memorydata.database.manager.q.f9592a.a(r0.getSemanticStateDao().queryText("migration_phase")) == true) goto L5;
        List<ip> r1 = f();
        List<SemanticConflictSnapshot> r2 = r0.getSemanticMemoryDao().queryReviewConflictSnapshots();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L7:
        List r8 = null;
        if (r4.hasNext() == false) goto L23;
        ip r6 = (ip) ZeusTransformUtils.preCheckCast(r4.next(), ip.class, "com.obric.memorydata.plugin");
        GsonUtil r10 = GsonUtil.INSTANCE;
        String r7 = r6.u();
        if (r7 != null) goto L12;
    L20:
        if (r8 != null) goto L22;
        r8 = CollectionsKt.emptyList();
    L22:
        CollectionsKt.addAll(r5, (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"));
        goto L7
    L12:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r9 = true;
    L15:
        if (r9 == true) goto L18;
        r7 = null;
    L18:
        if (r7 == null) goto L20;
        r8 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r7, new e().getType()), List.class, "com.obric.memorydata.plugin");
        goto L20
    L14:
        r9 = false;
        goto L15
    L23:
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 400), Iterable.class, "com.obric.memorydata.plugin");
        EpisodicMemoryDao r12 = r0.getEpisodicMemoryDao();
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r11.iterator();
    L25:
        if (r14.hasNext() == false) goto L27;
        CollectionsKt.addAll(r13, (Iterable) ZeusTransformUtils.preCheckCast(r12.queryByEntityIds((List) ZeusTransformUtils.preCheckCast(r14.next(), List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L25
    L27:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r16 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r15.iterator();
    L29:
        if (r17.hasNext() == false) goto L41;
        Object r18 = r17.next();
        EpisodicMemoryEntity r19 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r18, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        Integer r110 = r19.getCategory();
        if (r110 != null) goto L34;
    L38:
        boolean r111 = false;
    L39:
        if (r111 == false) goto L29;
        r16.add(r18);
        goto L29
    L34:
        if (r110.intValue() != 0) goto L38;
        if (r19.getCreateTime() <= 0) goto L38;
        r111 = true;
        goto L39
    L41:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r16, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r21 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r20, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r22 = r20.iterator();
    L43:
        if (r22.hasNext() == false) goto L45;
        Object r112 = r22.next();
        r21.put(((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r112, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin")).getEntityId(), r112);
        goto L43
    L45:
        Long r23 = r0.getEpisodicMemoryDao().latestValidCreateTime();
        Iterable r24 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Collection r25 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r26 = r24.iterator();
    L47:
        if (r26.hasNext() == false) goto L72;
        ip r113 = (ip) ZeusTransformUtils.preCheckCast(r26.next(), ip.class, "com.obric.memorydata.plugin");
        GsonUtil r114 = GsonUtil.INSTANCE;
        String r115 = r113.u();
        if (r115 != null) goto L51;
    L59:
        List r116 = null;
    L60:
        if (r116 != null) goto L62;
        r116 = CollectionsKt.emptyList();
    L62:
        Iterable r117 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
        Collection r118 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r119 = r117.iterator();
    L64:
        if (r119.hasNext() == false) goto L71;
        EpisodicMemoryEntity r120 = (EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r21.get((String) ZeusTransformUtils.preCheckCast(r119.next(), String.class, "com.obric.memorydata.plugin")), EpisodicMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r120 == null) goto L68;
        Long r121 = Long.valueOf(r120.getCreateTime());
    L69:
        if (r121 == null) goto L64;
        r118.add(r121);
        goto L64
    L68:
        r121 = null;
        goto L69
    L71:
        r25.add(TuplesKt.to(new ar(r113.getEntityId(), r113.getUuid(), r113.c(), r113.d(), iq.b(r113.a()), 3, r113.getModifyTime(), r113.r(), com.obric.memorydata.union.build.storage.d.f13117a.a(r113.getEntityId(), r2), false, 512, null), a((List) ZeusTransformUtils.preCheckCast(r118, List.class, "com.obric.memorydata.plugin"), r23)));
        goto L47
    L51:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L53;
        boolean r122 = true;
    L54:
        if (r122 == true) goto L57;
        r115 = null;
    L57:
        if (r115 == null) goto L59;
        r116 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r115, new C0608f().getType()), List.class, "com.obric.memorydata.plugin");
        goto L60
    L53:
        r122 = false;
        goto L54
    L72:
        List r27 = CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r25, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new c((Comparator) ZeusTransformUtils.preCheckCast(new d((Comparator) ZeusTransformUtils.preCheckCast(new b(), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin"));
        List r123 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r28 = r27.iterator();
    L74:
        if (r28.hasNext() == false) goto L97;
        ar r29 = (ar) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r28.next(), Pair.class, "com.obric.memorydata.plugin")).component1(), ar.class, "com.obric.memorydata.plugin");
        Iterable r30 = (Iterable) ZeusTransformUtils.preCheckCast(r123, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r30, Collection.class) == true) goto L78;
    L80:
        Iterator r31 = r30.iterator();
    L82:
        if (r31.hasNext() == false) goto L79;
        ar r32 = (ar) ZeusTransformUtils.preCheckCast(r31.next(), ar.class, "com.obric.memorydata.plugin");
        if (r29.g().containsKey(r32.a()) == false) goto L86;
    L89:
        boolean r33 = true;
    L90:
        if (r33 == false) goto L82;
        boolean r34 = false;
    L92:
        if (r34 == false) goto L95;
        ((Collection) ZeusTransformUtils.preCheckCast(r123, Collection.class, "com.obric.memorydata.plugin")).add(r29);
    L95:
        if (r123.size() != 20) goto L74;
    L86:
        if (r32.g().containsKey(r29.a()) == true) goto L89;
        r33 = false;
    L79:
        r34 = true;
        goto L92
    L78:
        if (((Collection) ZeusTransformUtils.preCheckCast(r30, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L80;
    L97:
        return new ay(r123, r0.getSemanticMemoryDao().countPendingConfirmation(), true, true, null, 16, null);
    L5:
        return new ay(null, 0, false, false, null, 31, null);
    }

    public static final /* synthetic */ Set e(f r0) {
        return r0.g;
    }

    private final List<ip> f() {
        SemanticMemoryDao r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao();
        Set<String> r7 = this.g;
        if (r7 != null) goto L7;
        return r0.queryPendingConfirmationNewest(100);
    L7:
        if (r7.isEmpty() == true) goto L9;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r0.queryByEntityIds(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L25;
        Object r2 = r9.next();
        ip r3 = (ip) ZeusTransformUtils.preCheckCast(r2, ip.class, "com.obric.memorydata.plugin");
        boolean r5 = true;
        if (r3.l() != 3.0f) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == true) goto L19;
    L21:
        r5 = false;
    L22:
        if (r5 == false) goto L12;
        r1.add(r2);
        goto L12
    L19:
        if (Intrinsics.areEqual(r3.s(), "pending") == false) goto L21;
    L16:
        r4 = false;
        goto L17
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
    L9:
        return CollectionsKt.emptyList();
    }

    public static final /* synthetic */ kotlinx.coroutines.channels.i f(f r0) {
        return r0.c;
    }

    private static final ay g(f r0) {
        return r0.e();
    }

    /* JADX INFO: renamed from: lambda$dOfQvo7qIw8_CeQWL-rk65j-3gA, reason: not valid java name */
    public static /* synthetic */ ay m948lambda$dOfQvo7qIw8_CeQWLrk65j3gA(f r0) {
        return g(r0);
    }

    @Override // com.obric.memorydata.memory.ui.list.aw
    public Object a(ar r5, boolean r6, Continuation<? super SemanticConfirmationResult> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DatabasePendingPersonalInfoRepository$review$2(this, r5, r6, null), Function2.class, "com.obric.memorydata.plugin"), r8);
    }

    @Override // com.obric.memorydata.memory.ui.list.aw
    public Object a(Continuation<? super Unit> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        Object r4 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new DatabasePendingPersonalInfoRepository$refresh$2(this, null), Function2.class, "com.obric.memorydata.plugin"), r6);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.obric.memorydata.memory.ui.list.aw
    public kotlinx.coroutines.flow.ar<ay> a() {
        return this.f11306b;
    }

    @Override // com.obric.memorydata.memory.ui.list.aw
    public synchronized void b() {
        monitor-enter(this);
        this.h = true;     // Catch: Throwable -> L12
        UserSettings.INSTANCE.unregisterLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(this.j, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        RoomDatabase r1 = this.e;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        InvalidationTracker r2 = r1.getInvalidationTracker();     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.removeObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(this.i, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
    L9:
        kotlinx.coroutines.channels.z.a.a((kotlinx.coroutines.channels.z) ZeusTransformUtils.preCheckCast(this.c, kotlinx.coroutines.channels.z.class, "com.obric.memorydata.plugin"), null, 1, null);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
