package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityHttpResponse;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010#\u001a\u00020$H\u0016J\u0014\u0010%\u001a\u00020$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'J\b\u0010)\u001a\u00020$H\u0016J \u0010*\u001a\u00020$2\u000e\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0,2\u0006\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020$H\u0016J\b\u00100\u001a\u000201H\u0016JJ\u00102\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020-04\u0012\u0004\u0012\u000205032\u0006\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u0002012\u0006\u00108\u001a\u00020\u00182\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u0002050:J\b\u0010;\u001a\u000201H\u0016J$\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020>2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020-04H\u0002J\"\u0010@\u001a\u0004\u0018\u00010(2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020-H\u0016J\b\u0010F\u001a\u000201H\u0016J\b\u0010G\u001a\u000205H\u0016J\u0010\u0010H\u001a\u0002052\u0006\u0010.\u001a\u00020\u0018H\u0016J\u001e\u0010I\u001a\u0002052\u0006\u0010E\u001a\u00020-2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020D0KH\u0002J4\u0010L\u001a\u0002052\u0006\u0010E\u001a\u00020-2\"\u0010M\u001a\u001e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D0Nj\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D`OH\u0002J\"\u0010P\u001a\u0002052\u0006\u0010A\u001a\u00020B2\u0006\u0010Q\u001a\u00020D2\b\u0010R\u001a\u0004\u0018\u00010-H\u0016J\u000e\u0010S\u001a\u00020$2\u0006\u0010.\u001a\u00020\u0018J\b\u0010T\u001a\u00020DH\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001e\"\u0004\b!\u0010\"¨\u0006U"}, d2 = {"Lcom/bytedance/applog/priority/original/Group;", "Lcom/bytedance/applog/priority/original/GroupInterface;", "priorityContext", "Lcom/bytedance/applog/priority/original/Model$PriorityInnerContext;", "config", "Lcom/bytedance/applog/priority/original/Model$GroupConfig;", "logger", "Lcom/bytedance/applog/log/AbsLogger;", "callback", "Lcom/bytedance/applog/priority/PriorityCallback;", "appSession", "Lcom/bytedance/applog/priority/original/AppSession;", "(Lcom/bytedance/applog/priority/original/Model$PriorityInnerContext;Lcom/bytedance/applog/priority/original/Model$GroupConfig;Lcom/bytedance/applog/log/AbsLogger;Lcom/bytedance/applog/priority/PriorityCallback;Lcom/bytedance/applog/priority/original/AppSession;)V", "getAppSession", "()Lcom/bytedance/applog/priority/original/AppSession;", "getCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "getConfig", "()Lcom/bytedance/applog/priority/original/Model$GroupConfig;", "db", "Lcom/bytedance/applog/priority/original/DatabaseInterface;", "getLogger", "()Lcom/bytedance/applog/log/AbsLogger;", "nextReportTimeSec", "", "getPriorityContext", "()Lcom/bytedance/applog/priority/original/Model$PriorityInnerContext;", "running", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getRunning", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "workable", "getWorkable", "setWorkable", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "clear", "", "deleteEvents", "keys", "", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "destroy", "doWork", "header", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "runTimeSecs", ObricMemoryConstants.VALUE_IN_APP_SIGNAL_ACTION_FLUSH, "getEventCount", "", "getEventsBySizeAndCount", "Lkotlin/Pair;", "", "", "maxSize", "maxCount", "eventTtl", "filter", "Lkotlin/Function1;", "groupId", "handleLogResponse", ChatMessage.TYPE_RESPONSE, "Lcom/bytedance/applog/priority/PriorityHttpResponse;", "events", "insertEvent", "eventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "eventName", "", "json", "interval", "isEmpty", "isTimeout", "jsonContainsArray", "arr", "", "jsonContainsKvs", "kvs", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "match", "event", "paramJson", "setRunTime", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class m implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Model.f f1842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Model.c f1843b;
    private final com.bytedance.applog.log.a c;
    private final PriorityCallback d;
    private final com.bytedance.applog.priority.original.a e;
    private final g f;
    private AtomicBoolean g;
    private long h;
    private final AtomicBoolean i;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1844a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f1845b = null;

        static {
            int[] r0 = new int[Model.EventType.values().length];
            r0[Model.EventType.V3.ordinal()] = 1;
            r0[Model.EventType.V1.ordinal()] = 2;
            r0[Model.EventType.LogData.ordinal()] = 3;
            r0[Model.EventType.Launch.ordinal()] = 4;
            r0[Model.EventType.Terminate.ordinal()] = 5;
            r0[Model.EventType.Impression.ordinal()] = 6;
            r0[Model.EventType.Unknown.ordinal()] = 7;
            r0[Model.EventType.ForwardV3.ordinal()] = 8;
            f1844a = r0;
            int[] r1 = new int[Model.GroupFrequencyAllow.values().length];
            r1[Model.GroupFrequencyAllow.Allow.ordinal()] = 1;
            r1[Model.GroupFrequencyAllow.BlockByBackoff.ordinal()] = 2;
            r1[Model.GroupFrequencyAllow.BlockByFrequency.ordinal()] = 3;
            f1845b = r1;
        }
    }

    public m(Model.f r3, Model.c r4, com.bytedance.applog.log.a r5, PriorityCallback r6, com.bytedance.applog.priority.original.a r7) {
        com.bytedance.applog.log.a r8 = (com.bytedance.applog.log.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.applog.log.a.class, "com.obric.memorydata.plugin");
        PriorityCallback r9 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r6, PriorityCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "priorityContext");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r8, "logger");
        Intrinsics.checkNotNullParameter(r9, "callback");
        Intrinsics.checkNotNullParameter(r7, "appSession");
        this.f1842a = r3;
        this.f1843b = r4;
        this.c = r8;
        this.d = r9;
        this.e = r7;
        this.f = r3.a().a(r4.e().c());
        this.g = new AtomicBoolean(true);
        this.i = new AtomicBoolean(false);
    }

    private final boolean a(final PriorityHttpResponse r11, Map<Model.a, ? extends JSONObject> r12) {
        final Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        int r0 = r11.getCode();
        if (200 <= r0) goto L5;
    L7:
        boolean r4 = false;
    L9:
        if (r4 == false) goto L24;
        this.f1843b.d().f();
        this.c.a("Group:doWork", (Function0) ZeusTransformUtils.preCheckCast(new Group$handleLogResponse$1(this, r11), Function0.class, "com.obric.memorydata.plugin"));
        JSONObject r1 = new JSONObject(r11.getData());
        if (Intrinsics.areEqual(r1.optString("message"), "success") == true) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L20;
        a((Iterable) ZeusTransformUtils.preCheckCast(r13.keySet(), Iterable.class, "com.obric.memorydata.plugin"));
        e.a(this.d, "3F", r13, this.f1843b.e().c(), this.f1843b.a());
        e.a(this.d, this.f1843b.a(), r13);
        this.d.monitorIncreaseStats("priority_request_success_cnt", 1);
        this.c.a("Group:doWork", (Function0) ZeusTransformUtils.preCheckCast(new Group$handleLogResponse$2(this, r13), Function0.class, "com.obric.memorydata.plugin"));
        this.f1843b.e().a().b(r1);
        return true;
    L20:
        if (this.d.isMonitorEnabled() == false) goto L22;
        this.d.monitorError("post priority[" + this + "] log biz error", "response: " + r11);
    L22:
        this.c.a("Group:doWork", null, (Function0) ZeusTransformUtils.preCheckCast(new Group$handleLogResponse$3(this, r11), Function0.class, "com.obric.memorydata.plugin"));
    L46:
        e.a(this.d, "3B", r13, this.f1843b.e().c(), this.f1843b.a());
        this.d.monitorIncreaseStats("priority_request_failed_cnt", 1);
        return false;
    L13:
        if (Intrinsics.areEqual(r1.optString(Api.KEY_MAGIC), Api.MSG_MAGIC) == false) goto L15;
        r5 = true;
        goto L16
    L24:
        if (500 <= r0) goto L26;
    L28:
        boolean r9 = false;
    L29:
        if (r9 == false) goto L35;
        this.f1843b.d().d();
        if (this.d.isMonitorEnabled() == false) goto L46;
        PriorityCallback r2 = this.d;
        String r3 = "post priority[" + this + "] log 5xx error";
        StringBuilder r6 = new StringBuilder();
    L33:
        r2.monitorError(r3, r6.append("response: ").append(r11).toString());
        goto L46
    L35:
        if (400 > r0) goto L38;
        if (r0 >= 500) goto L38;
        boolean r7 = true;
    L39:
        if (r7 == false) goto L43;
        this.f1843b.d().e();
        this.c.a("Group:doWork", null, (Function0) ZeusTransformUtils.preCheckCast(new Group$handleLogResponse$4(this, r11), Function0.class, "com.obric.memorydata.plugin"));
        if (this.d.isMonitorEnabled() == false) goto L46;
        r2 = this.d;
        r3 = "post priority[" + this + "] log 4xx error";
        r6 = new StringBuilder();
        goto L33
    L43:
        this.c.a("Group:doWork", null, (Function0) ZeusTransformUtils.preCheckCast(new Group$handleLogResponse$5(this, r11), Function0.class, "com.obric.memorydata.plugin"));
        if (this.d.isMonitorEnabled() == false) goto L46;
        r2 = this.d;
        r3 = "post priority[" + this + "] log unknown error";
        r6 = new StringBuilder();
    L38:
        r7 = false;
        goto L39
    L26:
        if (r0 >= 600) goto L28;
        r9 = true;
        goto L29
    L5:
        if (r0 >= 300) goto L7;
        r4 = true;
        goto L9
    }

    private final boolean a(JSONObject r4, HashMap<String, String> r5) {
        Iterator<Map.Entry<String, String>> r3 = r5.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "kvs.entries");
        String r0 = (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin");
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r4.optString(r0), r7) == true) goto L4;
        Object r1 = r4.opt(r0);
        if (r1 == null) goto L10;
        String r2 = r1.toString();
    L12:
        if (Intrinsics.areEqual(r2, r7) == true) goto L4;
        return false;
    L10:
        r2 = null;
        goto L12
    L15:
        return true;
    }

    private final boolean a(JSONObject r3, List<String> r4) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (r3.has((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public Model.a a(Model.EventType r17, String r18, JSONObject r19) {
        Intrinsics.checkNotNullParameter(r17, "eventType");
        Intrinsics.checkNotNullParameter(r18, "eventName");
        Intrinsics.checkNotNullParameter(r19, "json");
        String r2 = r19.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "json.toString()");
        int r4 = e.a(r2);
        if (this.f1843b.e().d() >= r4) goto L25;
        int r3 = a.f1844a[r17.ordinal()];
        if (r3 != 1) goto L7;
        JSONObject r5 = new JSONObject();
        r5.put("params_cleared_by_event_size_limit", r4);
        r5.put("max_event_size", this.f1843b.e().d());
        r19.put(TrackerImpl.PARAMS, r5);
    L24:
        r2 = r19.toString();
        Intrinsics.checkNotNullExpressionValue(r2, "json.toString()");
        goto L25
    L7:
        if (r3 != 2) goto L9;
        final Set r6 = SetsKt.setOf(new String[]{LocationMonitorConst.TAG, AnnotatedPrivateKey.LABEL, "monitor_id", "event_stained"});
        Iterator<String> r11 = r19.keys();
        Intrinsics.checkNotNullExpressionValue(r11, "json.keys()");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r11), (Function1) ZeusTransformUtils.preCheckCast(new Group$insertEvent$1(r6), Function1.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r7.hasNext() == false) goto L22;
        r19.remove((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin"));
    L22:
        r19.put("params_cleared_by_event_size_limit", r4);
        r19.put("max_event_size", this.f1843b.e().d());
        goto L24
    L9:
        if (r3 == 3) goto L14;
        final Set r8 = SetsKt.setOf(new String[]{"monitor_id", "event_stained"});
        Iterator<String> r12 = r19.keys();
        Intrinsics.checkNotNullExpressionValue(r12, "json.keys()");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r12), (Function1) ZeusTransformUtils.preCheckCast(new Group$insertEvent$5(r8), Function1.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r9.hasNext() == false) goto L22;
        r19.remove((String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        final Set r10 = SetsKt.setOf(new String[]{"log_type", "monitor_id", "event_stained"});
        Iterator<String> r13 = r19.keys();
        Intrinsics.checkNotNullExpressionValue(r13, "json.keys()");
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(SequencesKt.toList(SequencesKt.filterNot(SequencesKt.asSequence(r13), (Function1) ZeusTransformUtils.preCheckCast(new Group$insertEvent$3(r10), Function1.class, "com.obric.memorydata.plugin"))), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r14.hasNext() == false) goto L22;
        r19.remove((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"));
    L25:
        int r15 = this.f1843b.a();
        long r16 = System.currentTimeMillis() / ((long) 1000);
        if (r19.optInt("event_stained") <= 0) goto L28;
        boolean r110 = true;
    L29:
        String r1 = r19.optString("monitor_id");
        if (r1 != null) goto L33;
        r1 = "";
    L33:
        return this.f.insert(new Model.a(-1, r15, r16, r17, r110, r1, r18), r2);
    L28:
        r110 = false;
        goto L29
    }

    public final Model.c a() {
        return this.f1843b;
    }

    public final Pair<Map<Model.a, JSONObject>, Boolean> a(long r9, int r11, long r12, Function1<? super JSONObject, Boolean> r14) {
        Function1<? super JSONObject, Boolean> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r14, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "filter");
        return this.f.a(this.f1843b.a(), r9, r11, r12, r7);
    }

    public final void a(Iterable<Model.a> r3) {
        Iterable<Model.a> r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "keys");
        this.f.a(r4);
    }

    @Override // com.bytedance.applog.priority.original.n
    public void a(Lazy<? extends JSONObject> r17, long r18) {
        Lazy r0 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r17, Lazy.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "header");
        b(r18);
        boolean r11 = false;
        int r12 = 1;
        if (this.i.compareAndSet(false, true) == true) goto L6;
        this.c.a("Group:doWork", null, (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$1(this), Function0.class, "com.obric.memorydata.plugin"));
        return;
    L6:
        this.c.a("Group:doWork", (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$2(this), Function0.class, "com.obric.memorydata.plugin"));
        int r15 = this.f1843b.d().b();     // Catch: Throwable -> L48
        final int r7 = 0;
    L8:
        if (r7 >= r15) goto L46;
        if (this.g.get() == false) goto L46;
        if (e() == true) goto L46;
        int r1 = a.f1845b[this.f1843b.d().c().ordinal()];     // Catch: Throwable -> L48
        if (r1 != r12) goto L17;
        this.c.a("Group:doWork", (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$3(this, r7), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48
    L54:
        int r13 = r7;
        Pair<Map<Model.a, JSONObject>, Boolean> r2 = a(this.f1843b.e().e(), this.f1843b.e().f(), this.f1843b.e().g() * ((long) 1000), (Function1) ZeusTransformUtils.preCheckCast(new Group$doWork$6(this), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L44
        final Map<Model.a, ? extends JSONObject> r3 = (Map) ZeusTransformUtils.preCheckCast(r2.component1(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(r2.component2(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L44
        if (r3.isEmpty() == true) goto L29;
        if (r0.getValue() == null) goto L33;
        this.c.a("Group:doWork", (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$9(this, r3), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L44
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L44
        r5.put("header", r0.getValue());     // Catch: Throwable -> L44
        e.a(r5, r3, this.f1842a.getContext().b());     // Catch: Throwable -> L44
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L44
        r6.put("backoff_priority", this.f1843b.d().a().a(Integer.valueOf(this.f1843b.a())));     // Catch: Throwable -> L44
        r6.put("group_priority", this.f1843b.b().a(Integer.valueOf(this.f1843b.a())));     // Catch: Throwable -> L44
        r6.put("event_priority_config", this.f1843b.e().b().a(this.f1843b.e().c().name()));     // Catch: Throwable -> L44
        r5.put("options", r6);     // Catch: Throwable -> L44
        e.a(r5);     // Catch: Throwable -> L44
        if (this.f1842a.getContext().a().d() == false) goto L37;
        Pair<String, String> r8 = e.a(r5, this.f1842a.getContext().a().e());     // Catch: Throwable -> L44
    L38:
        this.d.monitorIncreaseStats("REPORT_REQUEST_COUNT", 1);     // Catch: Throwable -> L44
        PriorityCallback r9 = this.d;     // Catch: Throwable -> L44
        String r10 = this.f1843b.h();     // Catch: Throwable -> L44
        String r14 = r5.toString();     // Catch: Throwable -> L44
        Intrinsics.checkNotNullExpressionValue(r14, "packJson.toString()");     // Catch: Throwable -> L44
        byte[] r16 = r14.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L44
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L44
        PriorityHttpResponse r19 = r9.doHttpPost(r10, r16, r8);     // Catch: Throwable -> L44
        Intrinsics.checkNotNullExpressionValue(r19, ChatMessage.TYPE_RESPONSE);     // Catch: Throwable -> L44
        if (a(r19, r3) == false) goto L43;
        if (r4 == true) goto L43;
        com.bytedance.applog.log.a r20 = this.c;     // Catch: Throwable -> L44
        Function0<String> r21 = (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$10(this), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
    L30:
        r20.a("Group:doWork", r21);     // Catch: Throwable -> L44
    L43:
        int r22 = r13 + 1;
        r12 = 1;
        r11 = false;
        r7 = r22;
        goto L8
    L37:
        r8 = null;
        goto L38
    L33:
        r20 = this.c;     // Catch: Throwable -> L44
        r21 = (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$8(this), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        goto L30
    L29:
        r20 = this.c;     // Catch: Throwable -> L44
        r21 = (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$7(this), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
    L44:
        th = th;
        boolean r23 = false;
    L50:
        this.i.set(r23);
        throw th;
    L17:
        if (r1 == 2) goto L23;
        if (r1 != 3) goto L54;
        com.bytedance.applog.log.a r24 = this.c;     // Catch: Throwable -> L48
        Function0<String> r25 = (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$5(this), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
    L22:
        r24.a("Group:doWork", r25);     // Catch: Throwable -> L48
        goto L46
    L23:
        r24 = this.c;     // Catch: Throwable -> L48
        r25 = (Function0) ZeusTransformUtils.preCheckCast(new Group$doWork$4(this), Function0.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
    L46:
        this.i.set(false);
        return;
    L48:
        th = th;
        r23 = r11;
        goto L50
    }

    @Override // com.bytedance.applog.priority.original.n
    public boolean a(long r6) {
        if (this.g.get() == true) goto L6;
        return false;
    L6:
        if (this.f1843b.c() > 0) goto L9;
        return true;
    L9:
        if (this.h <= r6) goto L11;
        return false;
    L11:
        return true;
    }

    public final PriorityCallback b() {
        return this.d;
    }

    public final void b(long r3) {
        this.h = r3 + ((long) this.f1843b.c());
    }

    public boolean b(Model.EventType r7, String r8, JSONObject r9) {
        Intrinsics.checkNotNullParameter(r7, "eventType");
        Intrinsics.checkNotNullParameter(r8, "event");
        if (this.f1843b.g().contains(r7.getAlias()) == true) goto L6;
        return false;
    L6:
        if (this.f1843b.f() != null) goto L9;
        return true;
    L9:
        switch(a.f1844a[r7.ordinal()]) {
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L11;
            default: goto L14;
        };
    L11:
        return false;
    L12:
        return true;
    L14:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f1843b.f().a(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L16;
    L18:
        if (r9 != null) goto L21;
        return false;
    L21:
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.f1843b.f().b(), Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L53;
        List r10 = (List) ZeusTransformUtils.preCheckCast(this.f1843b.f().b().get(r8), List.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L37;
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r11, Collection.class) == true) goto L27;
    L29:
        Iterator r12 = r11.iterator();
    L31:
        if (r12.hasNext() == false) goto L28;
        if (a(r9, (List) ZeusTransformUtils.preCheckCast(r12.next(), List.class, "com.obric.memorydata.plugin")) == false) goto L31;
        boolean r13 = true;
    L35:
        if (r13 == false) goto L37;
        return true;
    L28:
        r13 = false;
        goto L35
    L27:
        if (((Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L29;
    L37:
        List r14 = (List) ZeusTransformUtils.preCheckCast(this.f1843b.f().b().get("*"), List.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L53;
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, Collection.class) == true) goto L42;
    L44:
        Iterator r16 = r15.iterator();
    L46:
        if (r16.hasNext() == false) goto L43;
        if (a(r9, (List) ZeusTransformUtils.preCheckCast(r16.next(), List.class, "com.obric.memorydata.plugin")) == false) goto L46;
        boolean r17 = true;
    L50:
        if (r17 == false) goto L53;
        return true;
    L43:
        r17 = false;
        goto L50
    L42:
        if (((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L44;
    L53:
        if ((!((Map) ZeusTransformUtils.preCheckCast(this.f1843b.f().c(), Map.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L84;
        List r18 = (List) ZeusTransformUtils.preCheckCast(this.f1843b.f().c().get(r8), List.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L69;
        Iterable r19 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r19, Collection.class) == true) goto L59;
    L61:
        Iterator r20 = r19.iterator();
    L63:
        if (r20.hasNext() == false) goto L60;
        if (a(r9, (HashMap) ZeusTransformUtils.preCheckCast(r20.next(), HashMap.class, "com.obric.memorydata.plugin")) == false) goto L63;
        boolean r21 = true;
    L67:
        if (r21 == false) goto L69;
        return true;
    L60:
        r21 = false;
        goto L67
    L59:
        if (((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L61;
    L69:
        List r22 = (List) ZeusTransformUtils.preCheckCast(this.f1843b.f().c().get("*"), List.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L84;
        Iterable r23 = (Iterable) ZeusTransformUtils.preCheckCast(r22, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r23, Collection.class) == true) goto L74;
    L76:
        Iterator r24 = r23.iterator();
    L78:
        if (r24.hasNext() == false) goto L75;
        if (a(r9, (HashMap) ZeusTransformUtils.preCheckCast(r24.next(), HashMap.class, "com.obric.memorydata.plugin")) == false) goto L78;
        boolean r6 = true;
    L82:
        if (r6 == false) goto L84;
        return true;
    L75:
        r6 = false;
        goto L82
    L74:
        if (((Collection) ZeusTransformUtils.preCheckCast(r23, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L76;
    L84:
        return false;
    L16:
        if (this.f1843b.f().a().contains(r8) == false) goto L18;
        return true;
    }

    @Override // com.bytedance.applog.priority.original.n
    public int c() {
        return this.f1843b.c();
    }

    @Override // com.bytedance.applog.priority.original.n
    public int d() {
        return this.f1843b.a();
    }

    public boolean e() {
        return this.f.b(this.f1843b.a());
    }

    public int f() {
        return this.f.a(this.f1843b.a());
    }

    @Override // com.bytedance.applog.priority.original.n
    public void g() {
        this.g.set(false);
    }

    @Override // com.bytedance.applog.priority.original.n
    public void h() {
        this.h = 0;
    }

    public String toString() {
        return "Group-" + this.f1843b.e().c() + '-' + this.f1843b.a() + '-' + this.f1843b.c() + 's';
    }
}
