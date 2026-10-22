package com.larus.project;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.im.bean.message.Message;
import com.larus.im.internal.jni.bean.OmniArchiveStatus;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.larus.im.internal.jni.bean.OmniGetProjectRequest;
import com.larus.im.internal.jni.bean.OmniGetProjectSource;
import com.larus.im.internal.jni.bean.OmniPinStatus;
import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectStatus;
import com.larus.im.internal.jni.bean.OmniSelectConversationGroupRequest;
import com.larus.im.internal.jni.bean.OmniSelectProjectListOrderByIndexRequest;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0004*\u0001\u0017\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\fH\u0016J \u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001bH\u0096@¢\u0006\u0004\b!\u0010\"J\u000e\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010\"J\u0010\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0012H\u0016J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020$2\u0006\u0010(\u001a\u00020\nH\u0016J\u001c\u0010*\u001a\u00020\u00152\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0082@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020$H\u0082@¢\u0006\u0002\u0010\"J\b\u00100\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\fH\u0002J\u001a\u00103\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u00152\b\b\u0002\u00105\u001a\u00020\u0015H\u0002J\b\u00106\u001a\u00020\u0010H\u0002J&\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010;J\"\u0010<\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000e0,H\u0082@¢\u0006\u0002\u0010.J\u0012\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001c0,*\u000208H\u0002J \u0010?\u001a\u00020$*\b\u0012\u0004\u0012\u00020\u001c0@2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001c0,H\u0002J\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001c0,*\b\u0012\u0004\u0012\u00020\u001c0,H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006D"}, d2 = {"Lcom/larus/project/ProjectListDataSourceImpl;", "Lcom/larus/bmhome/taskskill/service/IProjectListDataSource;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "loadMutex", "Lkotlinx/coroutines/sync/Mutex;", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/bmhome/taskskill/service/IProjectListDataSource$Listener;", "currentSnapshot", "Lcom/larus/bmhome/taskskill/service/ProjectListSnapshot;", "currentUserId", "", "currentCursor", "", "conversationSortType", "Lcom/larus/im/internal/jni/bean/OmniConversationSortType;", "loadGeneration", "hasLoadedSecondPage", "", "projectChangeListener", "com/larus/project/ProjectListDataSourceImpl$projectChangeListener$1", "Lcom/larus/project/ProjectListDataSourceImpl$projectChangeListener$1;", "getList", "getProject", "Lkotlin/Result;", "Lcom/larus/bmhome/taskskill/service/ProjectListItem;", "projectId", "getProject-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMore", "loadMore-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refresh", "", "updateConversationSortType", "sortType", "registerListener", "listener", "unregisterListener", "mergeChangedProjectsIntoMemory", "changedProjects", "", "Lcom/larus/im/internal/jni/bean/OmniProject;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshLoadedRange", "ensureCurrentUser", "updateSnapshot", "snapshot", "pageSize", "isFirstPage", "isFirstLoadMore", "projectConversationFirstPageRequestLimit", "queryProjectPage", "Lcom/larus/project/ProjectListPage;", "cursor", "limit", "(IILcom/larus/im/internal/jni/bean/OmniConversationSortType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryProjects", "projectIds", "toProjectListItems", "mergePageItems", "", "newItems", "sortedByProjectOrder", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ProjectListDataSourceImpl implements IProjectListDataSource {
    public static final /* synthetic */ int j = 0;
    public final CoroutineScope a;
    public final MutexImpl b;
    public final CopyOnWriteArraySet<IProjectListDataSource.a> c;
    public volatile com.larus.bmhome.taskskill.service.i d;
    public String e;
    public int f;
    public OmniConversationSortType g;
    public int h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    public final com.larus.bmhome.taskskill.service.i getList() {
        if (Intrinsics.areEqual(this.e, AccountService.a.getUserId()) == false) goto L6;
        return this.d;
    L6:
        return new com.larus.bmhome.taskskill.service.i(false, 7);
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.larus.project.ProjectListDataSourceImpl$projectChangeListener$1] */
    public ProjectListDataSourceImpl() {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.b = kotlinx.coroutines.sync.b.a();
        this.c = new CopyOnWriteArraySet();
        this.d = new com.larus.bmhome.taskskill.service.i(false, 7);
        this.f = Integer.MAX_VALUE;
        this.g = OmniConversationSortType.OmniConversationSortType_UPDATE_TIME;
        ?? r0 = new ProjectListDataSourceImpl$projectChangeListener$1(this);
        com.larus.im.service.v.a.getClass();
        com.larus.im.service.v.a.a().b(r0);
    }

    public static final void g(ProjectListDataSourceImpl r3) {
        r3.getClass();
        String r0 = AccountService.a.getUserId();
        if (Intrinsics.areEqual(r3.e, r0) == true) goto L7;
        r3.e = r0;
        r3.f = Integer.MAX_VALUE;
        r3.d = new com.larus.bmhome.taskskill.service.i(false, 7);
        r3.i = false;
        return;
    }

    public final Object a(Continuation<? super Unit> r2) {
        Object r3 = o(r2);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }

    public final void b(IProjectListDataSource.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.remove(r2);
    }

    public final void c(IProjectListDataSource.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.add(r2);
    }

    public final Object d(Continuation<? super Result<com.larus.bmhome.taskskill.service.i>> r6) {
        if ((r6 instanceof ProjectListDataSourceImpl$loadMore$1) == false) goto L7;
        ProjectListDataSourceImpl$loadMore$1 r0 = (ProjectListDataSourceImpl$loadMore$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13 CancellationException -> L15
    L23:
    L30:
        return Result.constructor-impl((com.larus.bmhome.taskskill.service.i) r7);
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r7);
        MainCoroutineDispatcher r8 = Dispatchers.getMain().getImmediate();     // Catch: Throwable -> L13 CancellationException -> L15
        ProjectListDataSourceImpl$loadMore$snapshot$1 r4 = new ProjectListDataSourceImpl$loadMore$snapshot$1(this, null);     // Catch: Throwable -> L13 CancellationException -> L15
        r0.label = 1;     // Catch: Throwable -> L13 CancellationException -> L15
        r7 = BuildersKt.withContext(r8, r4, r0);     // Catch: Throwable -> L13 CancellationException -> L15
        if (r7 != r2) goto L23;
        return r2;
    L15:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        FLogger.a.e("ProjectListDataSource", "loadMore failed cursor=" + this.f, th);
        Result.Companion r5 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ProjectListDataSourceImpl$loadMore$1(this, r6);
        goto L8
    }

    public final void e(OmniConversationSortType r7) {
        Intrinsics.checkNotNullParameter(r7, "sortType");
        if (this.g != r7) goto L5;
        return;
    L5:
        this.g = r7;
        if (this.d.c == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(this.a, null, null, new ProjectListDataSourceImpl$updateConversationSortType$1(this, null), 3, null);
    }

    public final Object o(Continuation<? super Unit> r6) {
        if ((r6 instanceof ProjectListDataSourceImpl$refreshLoadedRange$1) == false) goto L7;
        ProjectListDataSourceImpl$refreshLoadedRange$1 r0 = (ProjectListDataSourceImpl$refreshLoadedRange$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 != 1) goto L18;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13 CancellationException -> L15
    L27:
    L25:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r7);
        MainCoroutineDispatcher r8 = Dispatchers.getMain().getImmediate();     // Catch: Throwable -> L13 CancellationException -> L15
        ProjectListDataSourceImpl$refreshLoadedRange$2 r4 = new ProjectListDataSourceImpl$refreshLoadedRange$2(this, null);     // Catch: Throwable -> L13 CancellationException -> L15
        r0.label = 1;     // Catch: Throwable -> L13 CancellationException -> L15
        if (BuildersKt.withContext(r8, r4, r0) != r2) goto L27;
        return r2;
    L15:
        e = move-exception;
        throw e;
    L13:
        th = move-exception;
        FLogger.a.e("ProjectListDataSource", "refreshLoadedRange failed", th);
    L7:
        r0 = new ProjectListDataSourceImpl$refreshLoadedRange$1(this, r6);
        goto L8
    }

    public static final List k(ProjectListDataSourceImpl r0, List r1) {
        return CollectionsKt.sortedWith(r1, new f());
    }

    public static final List l(ProjectListDataSourceImpl r9, h r10) {
        r9.getClass();
        List<OmniProject> r11 = r10.a;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L22;
        OmniProject r1 = (OmniProject) r12.next();
        String r2 = r1.projectId;
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        List<wc9.e> r3 = r10.b.get(r2);
        if (r3 != null) goto L11;
        r3 = CollectionsKt.emptyList();
    L11:
        LinkedHashSet r5 = new LinkedHashSet();
        Iterator<T> r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        r5.add(((wc9.e) r4.next()).a);
        goto L13
    L15:
        Map<String, Message> r6 = r10.c;
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<Map.Entry<String, Message>> r8 = r6.entrySet().iterator();
    L17:
        if (r8.hasNext() == false) goto L21;
        Map.Entry<String, Message> r13 = r8.next();
        if (r5.contains(r13.getKey()) == false) goto L17;
        r7.put(r13.getKey(), r13.getValue());
        goto L17
    L21:
        r0.add(new com.larus.bmhome.taskskill.service.h(r1, r3, r7, r10.d.contains(r2)));
        goto L4
    L22:
        return r0;
    }

    public static final void m(ProjectListDataSourceImpl r1, com.larus.bmhome.taskskill.service.i r2) {
        r1.d = r2;
        Iterator<IProjectListDataSource.a> r3 = r1.c.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().a(r2);
        goto L4
    }

    public static int n(boolean r2, boolean r3) {
        b r0 = g.a(z2.a.b4().a, er9.a.e.a);
        if (r2 == false) goto L5;
        int r4 = r0.a;
    L9:
        return RangesKt.coerceIn(r4, 1, 100);
    L5:
        if (r3 == false) goto L7;
        r4 = r0.b;
        goto L9
    L7:
        r4 = r0.c;
        goto L9
    }

    public final Object f(String r6, Continuation<? super Result<com.larus.bmhome.taskskill.service.h>> r7) {
        if ((r7 instanceof ProjectListDataSourceImpl$getProject$1) == false) goto L7;
        ProjectListDataSourceImpl$getProject$1 r0 = (ProjectListDataSourceImpl$getProject$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        String r9 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L25 CancellationException -> L28
    L23:
    L32:
        return Result.constructor-impl((com.larus.bmhome.taskskill.service.h) r8);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        if (StringsKt.isBlank(r6) == true) goto L19;
        MainCoroutineDispatcher r10 = Dispatchers.getMain().getImmediate();     // Catch: Throwable -> L25 CancellationException -> L28
        ProjectListDataSourceImpl$getProject$projectItem$1 r4 = new ProjectListDataSourceImpl$getProject$projectItem$1(this, r6, null);     // Catch: Throwable -> L25 CancellationException -> L28
        r0.L$0 = r6;     // Catch: Throwable -> L25 CancellationException -> L28
        r0.label = 1;     // Catch: Throwable -> L25 CancellationException -> L28
        r8 = BuildersKt.withContext(r10, r4, r0);     // Catch: Throwable -> L25 CancellationException -> L28
        if (r8 != r2) goto L23;
        return r2;
    L19:
        return Result.constructor-impl(null);
    L28:
        e = move-exception;
        throw e;
    L25:
        th = move-exception;
        FLogger.a.e("ProjectListDataSource", "getProject failed projectId=" + r6, th);
        Result.Companion r11 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ProjectListDataSourceImpl$getProject$1(this, r7);
        goto L8
    }

    public static final void h(ProjectListDataSourceImpl r5, List r6, List r7) {
        List r8 = r6;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
        int r1 = 0;
    L3:
        String r3 = "";
        if (r9.hasNext() == false) goto L13;
        Object r2 = r9.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        String r10 = ((com.larus.bmhome.taskskill.service.h) r2).a.projectId;
        if (r10 == null) goto L12;
        r3 = r10;
    L12:
        r0.add(TuplesKt.to(r3, Integer.valueOf(r1)));
        r1 = r4;
        goto L3
    L13:
        Map r11 = MapsKt.toMutableMap(MapsKt.toMap(r0));
        Iterator r12 = r7.iterator();
    L15:
        if (r12.hasNext() == false) goto L23;
        com.larus.bmhome.taskskill.service.h r13 = (com.larus.bmhome.taskskill.service.h) r12.next();
        String r14 = r13.a.projectId;
        if (r14 != null) goto L19;
        r14 = "";
    L19:
        Integer r15 = (Integer) r11.get(r14);
        if (r15 == null) goto L21;
        ListProtector.set(r6, r15.intValue(), r13);
        goto L15
    L21:
        r11.put(r14, Integer.valueOf(r6.size()));
        r6.add(r13);
        goto L15
    }

    public static final Object j(ProjectListDataSourceImpl r3, List r4, Continuation r5) {
        kotlinx.coroutines.j r6 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r5), 1);
        r6.C();
        com.larus.im.service.v.a.getClass();
        com.larus.im.service.v.a.a().f(new OmniGetProjectRequest(r4, OmniGetProjectSource.OmniGetProjectSource_MIXED), new e(r6));
        Object r7 = r6.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L5:
        return r7;
    }

    public static final Object i(ProjectListDataSourceImpl r24, int r25, int r26, OmniConversationSortType r27, Continuation r28) {
        r24.getClass();
        if ((r28 instanceof ProjectListDataSourceImpl$queryProjectPage$1) == false) goto L7;
        ProjectListDataSourceImpl$queryProjectPage$1 r2 = (ProjectListDataSourceImpl$queryProjectPage$1) r28;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        int r0 = r2.I$0;
        OmniConversationSortType r6 = (OmniConversationSortType) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L24:
        cd9.b r7 = (cd9.b) r1;
        List r8 = r7.a;
        if (r8 != null) goto L27;
        r8 = CollectionsKt.emptyList();
    L27:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L28:
        boolean r11 = false;
        OmniProjectStatus r12 = null;
        if (r10.hasNext() == false) goto L38;
        Object r13 = r10.next();
        OmniProject r14 = ((cd9.a) r13).a;
        if (r14 == null) goto L34;
        r12 = r14.status;
    L34:
        if (r12 == OmniProjectStatus.OmniProjectStatus_DELETED) goto L36;
        r11 = true;
    L36:
        if (r11 == false) goto L28;
        r9.add(r13);
        goto L28
    L38:
        ArrayList r15 = new ArrayList();
        Iterator r16 = r9.iterator();
    L40:
        if (r16.hasNext() == false) goto L57;
        OmniProject r17 = ((cd9.a) r16.next()).a;
        if (r17 == null) goto L54;
        String r18 = r17.projectId;
        if (r18 != null) goto L46;
    L49:
        boolean r19 = true;
    L51:
        if ((!r19) == false) goto L54;
    L55:
        if (r17 == null) goto L40;
        r15.add(r17);
        goto L40
    L46:
        if (r18.length() == 0) goto L49;
        r19 = false;
    L54:
        r17 = null;
        goto L55
    L57:
        ArrayList r20 = new ArrayList();
        Iterator r21 = r9.iterator();
    L59:
        if (r21.hasNext() == false) goto L86;
        cd9.a r22 = (cd9.a) r21.next();
        OmniProject r110 = r22.a;
        if (r110 == null) goto L83;
        String r111 = r110.projectId;
        if (r111 == null) goto L83;
        if (r111.length() <= 0) goto L67;
        boolean r112 = true;
    L68:
        if (r112 == true) goto L71;
        r111 = null;
    L71:
        if (r111 == null) goto L83;
        List r23 = r22.b;
        if (r23 != null) goto L76;
        r23 = CollectionsKt.emptyList();
    L76:
        ArrayList r113 = new ArrayList();
        Iterator r29 = r23.iterator();
    L78:
        if (r29.hasNext() == false) goto L82;
        wc9.e r114 = ((wc9.l) r29.next()).a;
        if (r114 == null) goto L78;
        r113.add(r114);
        goto L78
    L82:
        Pair r30 = TuplesKt.to(r111, r113);
    L84:
        if (r30 == null) goto L59;
        r20.add(r30);
        goto L59
    L67:
        r112 = false;
    L83:
        r30 = null;
        goto L84
    L86:
        Map r31 = MapsKt.toMap(r20);
        ArrayList r32 = new ArrayList();
        Iterator r33 = r9.iterator();
    L88:
        if (r33.hasNext() == false) goto L93;
        List r115 = ((cd9.a) r33.next()).b;
        if (r115 != null) goto L92;
        r115 = CollectionsKt.emptyList();
    L92:
        CollectionsKt.addAll(r32, r115);
        goto L88
    L93:
        ArrayList r34 = new ArrayList();
        Iterator r35 = r32.iterator();
    L95:
        if (r35.hasNext() == false) goto L118;
        wc9.l r116 = (wc9.l) r35.next();
        wc9.e r117 = r116.a;
        if (r117 == null) goto L115;
        String r118 = r117.a;
        if (r118 == null) goto L115;
        if (r118.length() <= 0) goto L103;
        boolean r119 = true;
    L104:
        if (r119 == true) goto L107;
        r118 = null;
    L107:
        if (r118 == null) goto L115;
        List r120 = r116.b;
        if (r120 == null) goto L115;
        Message r121 = (Message) CollectionsKt.firstOrNull(r120);
        if (r121 == null) goto L115;
        Pair r122 = TuplesKt.to(r118, r121);
    L116:
        if (r122 == null) goto L95;
        r34.add(r122);
        goto L95
    L103:
        r119 = false;
    L115:
        r122 = null;
        goto L116
    L118:
        Map r36 = MapsKt.toMap(r34);
        List r37 = r7.a;
        if (r37 != null) goto L121;
        r37 = CollectionsKt.emptyList();
    L121:
        cd9.a r38 = (cd9.a) CollectionsKt.lastOrNull(r37);
        if (r38 == null) goto L126;
        OmniProject r39 = r38.a;
        if (r39 == null) goto L126;
        int r123 = r39.displayOrder;
    L127:
        LinkedHashSet r124 = new LinkedHashSet();
        Iterator r40 = r9.iterator();
    L129:
        if (r40.hasNext() == false) goto L149;
        cd9.a r41 = (cd9.a) r40.next();
        OmniProject r125 = r41.a;
        if (r125 == null) goto L145;
        String r126 = r125.projectId;
        if (r126 == null) goto L145;
        if (r126.length() <= 0) goto L137;
        boolean r127 = true;
    L138:
        if (r127 == true) goto L140;
    L142:
        boolean r42 = false;
    L143:
        if (r42 == false) goto L145;
    L146:
        if (r126 == null) goto L129;
        r124.add(r126);
        goto L129
    L140:
        if (r41.d == false) goto L142;
        r42 = true;
        goto L143
    L137:
        r127 = false;
    L145:
        r126 = null;
        goto L146
    L149:
        if (r7.b == true) goto L151;
    L154:
        boolean r128 = false;
    L156:
        return new h(r15, r31, r36, r124, r123, r128);
    L151:
        if (r123 <= 0) goto L154;
        if (r123 == r0) goto L154;
        r128 = true;
    L126:
        r123 = r0;
        goto L127
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        int r43 = RangesKt.coerceIn(g.a(z2.a.b4().b, er9.a.e.b).a, 1, 100);
        if (r43 >= 100) goto L18;
        r43 = r43 + 1;
    L18:
        r2.L$0 = r27;
        r2.I$0 = r25;
        r2.I$1 = r26;
        r2.I$2 = r43;
        r2.label = 1;
        kotlinx.coroutines.j r129 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r2), 1);
        r129.C();
        com.larus.im.service.v.a.getClass();
        com.larus.im.service.v.a.a().a(new OmniSelectProjectListOrderByIndexRequest(OmniPinStatus.PinStatus_ALL, r25, RangesKt.coerceIn(r26, 1, 100), new OmniSelectConversationGroupRequest(OmniPinStatus.PinStatus_UNPIN, OmniArchiveStatus.ArchiveStatus_NO_BELONG_ARCHIVE, true, Long.MAX_VALUE, "", r27, r43)), new d(r129));
        r1 = r129.B();
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(r2);
    L21:
        if (r1 == r4) goto L190;
        r0 = r25;
        goto L24
    L190:
        return r4;
    L7:
        r2 = new ProjectListDataSourceImpl$queryProjectPage$1(r24, r28);
        goto L8
    }
}
