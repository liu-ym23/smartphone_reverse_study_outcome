package com.obric.memorydata.awareness.impl;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.database.entity.ex;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J6\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00052\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/awareness/impl/DbTableEventEmitter;", "", "<init>", "()V", "TAG", "", "PKG_MESSAGE_WORD_LEVEL_CLASSIFIER", "KEY_MESSAGE", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "proactiveNotificationJob", "Lkotlinx/coroutines/Job;", "lastNotificationId", "", "Ljava/lang/Long;", CommonConsts.APM_INNER_EVENT_COST_START, "", "stop", "startProactiveNotificationObserver", "dispatchNotificationEventIfNeeded", "rawId", "enqueueClassifierAndDispatch", "message", "baseExtra", "", "enqueueAt", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f8700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f8701b = null;
    private static final al c = null;
    private static bx d;
    private static volatile Long e;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/awareness/impl/DbTableEventEmitter$enqueueClassifierAndDispatch$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f8702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f8703b;
        final /* synthetic */ long c;

        a(Map<String, ? extends Object> r3, long r4, long r6) {
            this.f8702a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            this.f8703b = r4;
            this.c = r6;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r11) {
            Intrinsics.checkNotNullParameter(r11, "taskInfo");
            if (r11.c().isFinished() == true) goto L5;
            return;
        L5:
            Map<String, ? extends Object> r0 = MapsKt.toMutableMap(this.f8702a);
            JSONArray r1 = r11.e().getOutput().optJSONArray(EventBody.KEY_CATEGORY);
            int r3 = 0;
            if (r11.e().getCode() != 0) goto L19;
            if (r1 == null) goto L19;
            if (r1.length() <= 0) goto L19;
            ArrayList r2 = new ArrayList(r1.length());
            int r5 = r1.length();
            int r6 = 0;
        L11:
            if (r6 >= r5) goto L17;
            String r7 = r1.optString(r6);
            Intrinsics.checkNotNull(r7);
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L15;
            r2.add(r7);
        L15:
            r6 = r6 + 1;
            goto L11
        L17:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L19;
            r3 = r2.size();
            r0.put("category_list", r2);
        L19:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DbTableEventEmitter", "classifier finished rawId=" + this.f8703b + " code=" + r11.e().getCode() + " category.count=" + r3 + " latencyMs=" + (System.currentTimeMillis() - this.c), false, 4, null);
            AwarenessManager.INSTANCE.dispatchAwarenessEvent(EventNames.RECEIVE_NOTIFICATION, r0);
        }
    }

    static {
        f8700a = new j();
        f8701b = new AtomicBoolean(false);
        c = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private j() {
    }

    private final void a(long r17) {
        ex r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getProactiveOsNotificationDao().queryById(r17);
        if (r0 != null) goto L5;
        return;
    L5:
        String r3 = null;
        com.obric.memorydata.utils.c.a r1 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r0.b(), null, 2, null);
        if (r1 == null) goto L8;
        r3 = r1.a();
    L8:
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        long r7 = System.currentTimeMillis();
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("dispatch RECEIVE_NOTIFICATION rawId=").append(r17).append(" pkg=").append(r0.b()).append(" title.len=");
        String r4 = r0.c();
        if (r4 == null) goto L13;
        int r5 = r4.length();
    L14:
        StringBuilder r6 = r2.append(r5).append(" text.len=");
        String r8 = r0.d();
        if (r8 == null) goto L17;
        int r10 = r8.length();
    L18:
        IRunLog.a.a(r9, "DbTableEventEmitter", r6.append(r10).toString(), false, 4, null);
        a(r0.c() + ':' + r0.d(), MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r17)), TuplesKt.to("raw_table", "ProactiveOsNotification"), TuplesKt.to("package_name", r0.b()), TuplesKt.to(Api.KEY_APP_NAME, r3), TuplesKt.to("title", r0.c()), TuplesKt.to(Params.CONTENT, r0.d()), TuplesKt.to("timestamp", Long.valueOf(r0.f()))}), r7, r17);
        return;
    L17:
        r10 = 0;
        goto L18
    L13:
        r5 = 0;
        goto L14
    }

    public static final /* synthetic */ void a(j r0, long r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void a(Long r0) {
        e = r0;
    }

    private final void a(String r10, Map<String, ? extends Object> r11, long r12, long r14) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        JSONObject r9 = new JSONObject();
        r9.put("message", r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DbTableEventEmitter", "enqueue classifier for RECEIVE_NOTIFICATION rawId=" + r14 + " msg.len=" + r10.length(), false, 4, null);
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("message_word_level_classifier").setInputParam(r9), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new a(r2, r14, r12), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public static final /* synthetic */ Long b() {
        return e;
    }

    private final void c() {
        bx r8 = d;
        if (r8 == null) goto L5;
        bx.a.a(r8, null, 1, null);
    L5:
        e = null;
        d = kotlinx.coroutines.i.a(c, null, null, (Function2) ZeusTransformUtils.preCheckCast(new DbTableEventEmitter$startProactiveNotificationObserver$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void a() {
        if (f8701b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        e = null;
        c();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DbTableEventEmitter", "started", false, 4, null);
    }
}
