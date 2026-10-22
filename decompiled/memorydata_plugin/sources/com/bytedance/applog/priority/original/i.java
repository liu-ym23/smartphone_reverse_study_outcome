package com.bytedance.applog.priority.original;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010\"\u001a\u00020\u001bJ\u0006\u0010#\u001a\u00020\u001bJ\b\u0010$\u001a\u0004\u0018\u00010%J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,J(\u0010-\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u001dJ&\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,2\f\u00102\u001a\b\u0012\u0004\u0012\u00020%03H\u0016J\"\u00104\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020)2\u0006\u00105\u001a\u00020\u001d2\b\u00106\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u00107\u001a\u00020\u001b2\u0006\u00102\u001a\u00020%J\u0006\u00108\u001a\u00020\u001bJ\b\u00109\u001a\u00020\u001dH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006;"}, d2 = {"Lcom/bytedance/applog/priority/original/Engine;", "Lcom/bytedance/applog/priority/original/AppSessionListener;", "Lcom/bytedance/applog/priority/original/EventTracker;", "context", "Lcom/bytedance/applog/priority/PriorityContext;", "(Lcom/bytedance/applog/priority/PriorityContext;)V", "appSession", "Lcom/bytedance/applog/priority/original/AppSession;", "backOffConfigVersion", "Lcom/bytedance/applog/priority/original/Model$Version;", "config", "Lcom/bytedance/applog/priority/original/Config;", "databasePool", "Lcom/bytedance/applog/priority/original/EventDatabasePool;", "fastMatchGroups", "Lcom/bytedance/applog/priority/original/Model$FastMatchGroups;", "groupConfigVersion", "priorityConfigVersion", "workerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "Lcom/bytedance/applog/priority/original/Worker;", "getWorkerMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "workerMap$delegate", "Lkotlin/Lazy;", "addSessionDuration", "", ObricMemoryConstants.KEY_SESSION_ID, "", "pageName", "duration", "", "extraParams", "clearEvents", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "getVersionConfig", "Lorg/json/JSONObject;", "initConfig", "configJson", "isEmpty", "", "isSupportEventType", "eventType", "", "newSession", "isForegroundSession", "timestamp", "onEvent", "eventName", "json", "Lkotlin/Lazy;", "onSessionChanged", "newSessionId", "oldSessionId", "setConfig", CommonConsts.APM_INNER_EVENT_COST_START, "toString", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i implements c, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f1836a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.priority.g f1837b;
    private final Lazy c;
    private Model.b d;
    private final f e;
    private final k f;
    private final com.bytedance.applog.priority.original.a g;
    private Model.h h;
    private Model.h i;
    private Model.h j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applog/priority/original/Engine$Companion;", "", "()V", "create", "Lcom/bytedance/applog/priority/original/Engine;", "context", "Lcom/bytedance/applog/priority/PriorityContext;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final i a(final com.bytedance.applog.priority.g r4) {
            Intrinsics.checkNotNullParameter(r4, "context");
            r4.b().a("createEngine", (Function0) ZeusTransformUtils.preCheckCast(new Engine$Companion$create$1(r4), Function0.class, "com.obric.memorydata.plugin"));
            return new i(r4);
        }
    }

    static {
        f1836a = new a(null);
    }

    public i(com.bytedance.applog.priority.g r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        this.f1837b = r6;
        this.c = LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(Engine$workerMap$2.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
        this.d = new Model.b(new CopyOnWriteArrayList());
        this.e = new f(r6.b(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6.a().a());
        this.f = new k(r6.b(), (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r6.a().a());
        this.g = new com.bytedance.applog.priority.original.a(r6, (c) ZeusTransformUtils.preCheckCast(this, c.class, "com.obric.memorydata.plugin"), (l) ZeusTransformUtils.preCheckCast(this, l.class, "com.obric.memorydata.plugin"));
    }

    private static final boolean a(i r3, JSONObject r4, JSONObject r5, String r6) {
        JSONObject r7 = r4.optJSONObject(r6);
        if (r7 == null) goto L15;
        JSONObject r8 = r5.optJSONObject(r6);
        if (r8 == null) goto L11;
        Intrinsics.checkNotNullExpressionValue(r8, "optJSONObject(key)");
        if (Model.h.f1823a.a(r7).a(Model.h.f1823a.a(r8)) == false) goto L10;
        r5.put(r6, r7);
        return true;
    L10:
        Unit r9 = Unit.INSTANCE;
    L12:
        if (r9 != null) goto L17;
        r5.put(r6, r7);
        return true;
    L17:
        return false;
    L11:
        r9 = null;
        goto L12
    L15:
        return false;
    }

    private final ConcurrentHashMap<Model.PriorityName, v> e() {
        return (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(this.c.getValue(), ConcurrentHashMap.class, "com.obric.memorydata.plugin");
    }

    public final void a() {
        JSONObject r0 = this.e.a();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.length() != 0) goto L8;
        return;
    L8:
        a(r0);
        this.g.a();
    }

    public final void a(final String r10, final String r11, final long r12, final String r14) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_SESSION_ID);
        Intrinsics.checkNotNullParameter(r11, "pageName");
        this.f1837b.b().a("Engine:addTerminateDuration", (Function0) ZeusTransformUtils.preCheckCast(new Engine$addSessionDuration$1(this, r10, r11, r12, r14), Function0.class, "com.obric.memorydata.plugin"));
        long r5 = Math.max(0, r12);
        if (r5 <= 0) goto L6;
        this.g.a(r10, r11, r5, r14);
        return;
    }

    public final void a(String r8, boolean r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_SESSION_ID);
        this.g.a(r8, r9, r10, r12);
    }

    public final synchronized void a(final JSONObject r53) {
        Class<i> r14 = i.class;
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r53, "configJson");     // Catch: Throwable -> L70
        this.f1837b.b().a("Engine:initConfig", (Function0) ZeusTransformUtils.preCheckCast(new Engine$initConfig$1(this, r53), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L70
        JSONObject r1 = r53.optJSONObject("group_priority_list");     // Catch: Throwable -> L70
        if (r1 != null) goto L7;
        r1 = new JSONObject();     // Catch: Throwable -> L70
    L7:
        Model.g.e r15 = new Model.g.e(r1, this.f1837b.d(), this.f1837b.e());     // Catch: Throwable -> L70
        if (r15.b().isEmpty() == true) goto L10;
    L13:
        this.j = r15.a();     // Catch: Throwable -> L70
        JSONObject r2 = r53.optJSONObject("backoff_priority_list");     // Catch: Throwable -> L70
        if (r2 != null) goto L16;
        r2 = new JSONObject();     // Catch: Throwable -> L70
    L16:
        Model.g.b r12 = new Model.g.b(r2);     // Catch: Throwable -> L70
        this.h = r12.a();     // Catch: Throwable -> L70
        JSONObject r0 = r53.optJSONObject("event_priority_config");     // Catch: Throwable -> L70
        if (r0 != null) goto L19;
        r0 = new JSONObject();     // Catch: Throwable -> L70
    L19:
        Model.g.f r10 = new Model.g.f(r0);     // Catch: Throwable -> L70
        this.i = r10.a();     // Catch: Throwable -> L70
        Model.e r3 = new Model.e(this, r10.a(), Model.PriorityName.P0, r10.b().a().a(), r10.b().a().b(), r10.b().a().c(), r10.b().a().d(), this.f1837b.a().f());     // Catch: Throwable -> L70
        Model.e r17 = new Model.e(this, r10.a(), Model.PriorityName.P1, r10.b().b().a(), r10.b().b().b(), r10.b().b().c(), r10.b().b().d(), this.f1837b.a().f());     // Catch: Throwable -> L70
        Model.e r18 = new Model.e(this, r10.a(), Model.PriorityName.P2, r10.b().c().a(), r10.b().c().b(), r10.b().c().c(), r10.b().c().d(), this.f1837b.a().f());     // Catch: Throwable -> L70
        Model.f r11 = new Model.f(this.f, this.f1837b);     // Catch: Throwable -> L70
        CopyOnWriteArrayList r13 = new CopyOnWriteArrayList();     // Catch: Throwable -> L70
        List<m> r16 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        List<m> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        List<m> r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Iterator<Model.g.c> r29 = r15.b().iterator();     // Catch: Throwable -> L70
    L21:
        if (r29.hasNext() == false) goto L43;
        Model.g.c r4 = (Model.g.c) ZeusTransformUtils.preCheckCast(r29.next(), Model.g.c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Model.g.a r5 = (Model.g.a) ZeusTransformUtils.preCheckCast(r12.d().get(Integer.valueOf(r4.a())), Model.g.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if (r5 == null) goto L30;
        if (r4.b() > 0) goto L27;
        boolean r31 = true;
    L28:
        Model.d r24 = new Model.d(r31, r12.a(), r5.a(), r5.b(), new AtomicInteger(0), new AtomicInteger(0), 0, 0);     // Catch: Throwable -> L70
    L34:
        String r28 = e.a(r4.a(), r4.c(), r4.d());     // Catch: Throwable -> L70
        String r6 = r4.f();     // Catch: Throwable -> L70
        if (Intrinsics.areEqual(r6, Model.PriorityName.P0.name()) == false) goto L38;
        Model.e r7 = r3;
        List<m> r19 = r8;
        List<m> r110 = r9;
        m r20 = new m(r11, new Model.c(r4.a(), r15.a(), r4.b(), r24, r7, r4.g(), r4.e(), r28), this.f1837b.b(), this.f1837b.a().f(), this.g);     // Catch: Throwable -> L70
        r16.add(r20);     // Catch: Throwable -> L70
        r13.add(r20);     // Catch: Throwable -> L70
    L37:
        r8 = r19;
        r9 = r110;
        r3 = r3;
        r14 = r14;
        goto L21
    L38:
        r19 = r8;
        r110 = r9;
        if (Intrinsics.areEqual(r6, Model.PriorityName.P1.name()) == false) goto L42;
        m r21 = new m(r11, new Model.c(r4.a(), r15.a(), r4.b(), r24, r17, r4.g(), r4.e(), r28), this.f1837b.b(), this.f1837b.a().f(), this.g);     // Catch: Throwable -> L70
        r110.add(r21);     // Catch: Throwable -> L70
    L41:
        r13.add(r21);     // Catch: Throwable -> L70
        goto L37
    L42:
        r21 = new m(r11, new Model.c(r4.a(), r15.a(), r4.b(), r24, r18, r4.g(), r4.e(), r28), this.f1837b.b(), this.f1837b.a().f(), this.g);     // Catch: Throwable -> L70
        r19.add(r21);     // Catch: Throwable -> L70
        goto L41
    L27:
        r31 = false;
        goto L28
    L30:
        if (r4.b() > 0) goto L32;
        boolean r42 = true;
    L33:
        r24 = new Model.d(r42, r12.a(), r12.b(), r12.c(), new AtomicInteger(0), new AtomicInteger(0), 0, 0);     // Catch: Throwable -> L70
        goto L34
    L32:
        r42 = false;
        goto L33
    L43:
        List<m> r22 = r8;
        Class<i> r32 = r14;
        List<m> r111 = r9;
        v r23 = (v) ZeusTransformUtils.preCheckCast(e().get(Model.PriorityName.P0), v.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        Unit r25 = null;
        if (r23 == null) goto L46;
        r23.a(r16);     // Catch: Throwable -> L70
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L70
    L47:
        if (r26 != null) goto L51;
        Class<i> r27 = r32;
        i r30 = (i) ZeusTransformUtils.preCheckCast(this, r27, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L52;
        ((Map) ZeusTransformUtils.preCheckCast(r30.e(), Map.class, "com.obric.memorydata.plugin")).put(Model.PriorityName.P0, new v(Model.PriorityName.P0, r11, r16));     // Catch: Throwable -> L70
    L52:
        v r33 = (v) ZeusTransformUtils.preCheckCast(e().get(Model.PriorityName.P1), v.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if (r33 == null) goto L55;
        r33.a(r111);     // Catch: Throwable -> L70
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L70
    L56:
        if (r34 != null) goto L60;
        i r35 = (i) ZeusTransformUtils.preCheckCast(this, r27, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L60;
        ((Map) ZeusTransformUtils.preCheckCast(r35.e(), Map.class, "com.obric.memorydata.plugin")).put(Model.PriorityName.P1, new v(Model.PriorityName.P1, r11, r111));     // Catch: Throwable -> L70
    L60:
        v r36 = (v) ZeusTransformUtils.preCheckCast(e().get(Model.PriorityName.P2), v.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if (r36 == null) goto L63;
        r36.a(r22);     // Catch: Throwable -> L70
        r25 = Unit.INSTANCE;     // Catch: Throwable -> L70
    L63:
        if (r25 != null) goto L67;
        i r37 = (i) ZeusTransformUtils.preCheckCast(this, r27, "com.obric.memorydata.plugin");     // Catch: Throwable -> L70
        if ((true ^ ((Collection) ZeusTransformUtils.preCheckCast(r22, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L67;
        ((Map) ZeusTransformUtils.preCheckCast(r37.e(), Map.class, "com.obric.memorydata.plugin")).put(Model.PriorityName.P2, new v(Model.PriorityName.P2, r11, r22));     // Catch: Throwable -> L70
    L67:
        this.f1837b.b().a("Engine:initConfig", (Function0) ZeusTransformUtils.preCheckCast(new Engine$initConfig$5(this), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L70
        Model.b r38 = new Model.b(r13);     // Catch: Throwable -> L70
        this.d = r38;     // Catch: Throwable -> L70
        this.e.a(r38);     // Catch: Throwable -> L70
        monitor-exit(this);
        return;
    L55:
        r34 = null;
        goto L56
    L51:
        r27 = r32;
        goto L52
    L46:
        r26 = null;
        goto L47
    L10:
        if (e().isEmpty() == false) goto L13;
        monitor-exit(this);
        return;
    L70:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.priority.original.c
    public void a(final boolean r3, final String r4, final String r5) {
        Intrinsics.checkNotNullParameter(r4, "newSessionId");
        this.f1837b.b().a("Engine:onSessionChanged", (Function0) ZeusTransformUtils.preCheckCast(new Engine$onSessionChanged$1(this, r4, r3, r5), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final boolean a(int r2) {
        Model.EventType r3 = Model.EventType.Companion.a(r2);
        if (this.d.a(r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.e.a(r3) == true) goto L8;
        return false;
    }

    @Override // com.bytedance.applog.priority.original.l
    public boolean a(final String r12, final int r13, Lazy<? extends JSONObject> r14) {
        Lazy<? extends JSONObject> r15 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r14, Lazy.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "eventName");
        Intrinsics.checkNotNullParameter(r15, "json");
        this.f1837b.b().a("Engine:onEvent", (Function0) ZeusTransformUtils.preCheckCast(new Engine$onEvent$1(this, r12, r13), Function0.class, "com.obric.memorydata.plugin"));
        Model.EventType r0 = Model.EventType.Companion.a(r13);
        m r2 = this.d.a(r12, r0, r15);
        if (r2 != null) goto L6;
        return false;
    L6:
        e.a(this.f1837b.a().f(), "2A", r13, (JSONObject) ZeusTransformUtils.preCheckCast(r15.getValue(), JSONObject.class, "com.obric.memorydata.plugin"), r2.a().e().c(), r2.a().a());
        final Model.a r1 = r2.a(r0, r12, (JSONObject) ZeusTransformUtils.preCheckCast(r15.getValue(), JSONObject.class, "com.obric.memorydata.plugin"));
        this.f1837b.b().a("Engine:onEvent", (Function0) ZeusTransformUtils.preCheckCast(new Engine$onEvent$2(this, r12, r1), Function0.class, "com.obric.memorydata.plugin"));
        e.a(this.f1837b.a().f(), "2F", r13, (JSONObject) ZeusTransformUtils.preCheckCast(r15.getValue(), JSONObject.class, "com.obric.memorydata.plugin"), r2.a().e().c(), r2.a().a());
        return true;
    }

    public final void b(JSONObject r7) {
        Intrinsics.checkNotNullParameter(r7, "json");
        boolean r4 = false;
        if (r7.has("backoff_priority_list") == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return;
    L13:
        JSONObject r2 = this.e.a();
        if (r2 != null) goto L16;
        r2 = new JSONObject();
    L16:
        boolean r0 = a(this, r7, r2, "backoff_priority_list");
        if (a(this, r7, r2, "event_priority_config") == true) goto L21;
        if (r0 == true) goto L21;
        boolean r3 = false;
    L23:
        if (a(this, r7, r2, "group_priority_list") == true) goto L25;
        if (r3 == true) goto L25;
    L26:
        if (r4 == true) goto L29;
        this.f1837b.b().a("Engine:setConfig", (Function0) ZeusTransformUtils.preCheckCast(new Engine$setConfig$1(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L29:
        f r8 = this.e;
        String r5 = r2.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "finalJson.toString()");
        r8.a(r5);
        a(r2);
        return;
    L25:
        r4 = true;
    L21:
        r3 = true;
        goto L23
    L5:
        if (r7.has("event_priority_config") == true) goto L10;
        if (r7.has("group_priority_list") == true) goto L10;
        r1 = false;
        goto L11
    }

    public final boolean b() {
        if (this.d.a().isEmpty() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.e.b() == false) goto L7;
        return true;
    }

    public final void c() {
        Iterator<v> r3 = e().values().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((v) ZeusTransformUtils.preCheckCast(r3.next(), v.class, "com.obric.memorydata.plugin")).a();
        goto L4
    }

    public final JSONObject d() {
        if (this.h == null) goto L5;
    L10:
        JSONObject r0 = new JSONObject();
        Model.h r1 = this.h;
        if (r1 == null) goto L13;
        r0.put("backoff_priority", r1.a());
    L13:
        Model.h r2 = this.i;
        if (r2 == null) goto L16;
        r0.put("event_priority_config", r2.a());
    L16:
        Model.h r3 = this.j;
        if (r3 == null) goto L19;
        r0.put("group_priority", r3.a());
    L19:
        return r0;
    L5:
        if (this.i != null) goto L10;
        if (this.j != null) goto L10;
        return null;
    }

    public String toString() {
        return "Engine-" + this.f1837b.a().a();
    }
}
