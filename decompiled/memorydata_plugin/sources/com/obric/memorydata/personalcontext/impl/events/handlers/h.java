package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.database.entity.go;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.task.impl.TaskInfo;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016JB\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/MessageEntityEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "suppressor", "Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils$BurstSuppressor;", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "enqueueClassifierAndDispatch", "", "message", "", "messageType", "baseExtra", "", "enqueueAt", "onUpdate", "oldRaw", "onDelete", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.personalcontext.impl.events.b.a f12215b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/MessageEntityEventHandler$Companion;", "", "<init>", "()V", "TAG", "", "PKG_MESSAGE_WORD_LEVEL_CLASSIFIER", "MSG_TYPE_VERIFICATION_CODE", "RAW_MESSAGE_TYPE_VERIFICATION_CODE", "KEY_MESSAGE", "KEY_MESSAGE_TYPE", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/personalcontext/impl/events/handlers/MessageEntityEventHandler$enqueueClassifierAndDispatch$1", "Lcom/obric/memorydata/task/scheduler/OnTaskInfoCallBack;", "onChanged", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.task.scheduler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f12216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f12217b;
        final /* synthetic */ long c;

        b(Map<String, ? extends Object> r3, long r4, long r6) {
            this.f12216a = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
            this.f12217b = r4;
            this.c = r6;
        }

        @Override // com.obric.memorydata.task.scheduler.c
        public void a(TaskInfo r11) {
            Intrinsics.checkNotNullParameter(r11, "taskInfo");
            if (r11.c().isFinished() == true) goto L5;
            return;
        L5:
            Map<String, ? extends Object> r0 = MapsKt.toMutableMap(this.f12216a);
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
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MessageEntityEventHandler", "classifier finished rawId=" + this.f12217b + " code=" + r11.e().getCode() + " category.count=" + r3 + " latencyMs=" + (System.currentTimeMillis() - this.c), false, 4, null);
            AwarenessManager.INSTANCE.dispatchAwarenessEvent(EventNames.RECEIVE_SMS, r0);
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends String>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends TypeToken<List<? extends String>> {
        public d() {
        }
    }

    static {
        f12214a = new a(null);
    }

    public h() {
        this.f12215b = new com.obric.memorydata.personalcontext.impl.events.b.a(5, 1000);
    }

    private static final CharSequence a(fx r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2.a(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final void a(long r8, String r10, String r11, Map<String, ? extends Object> r12, long r13) {
        Map<String, ? extends Object> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r14 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r9 = true;
    L9:
        if (r9 == false) goto L12;
        AwarenessManager.INSTANCE.dispatchAwarenessEvent(EventNames.RECEIVE_SMS, r2);
        return;
    L12:
        JSONObject r15 = new JSONObject();
        r15.put("message", r10);
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L15;
    L16:
        r14 = true;
    L17:
        if (r14 == true) goto L19;
        r15.put("message_type", r11);
    L19:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("message_word_level_classifier").setInputParam(r15), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTaskInfoCallback((com.obric.memorydata.task.scheduler.c) ZeusTransformUtils.preCheckCast(new b(r2, r8, r13), com.obric.memorydata.task.scheduler.c.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        return;
    L15:
        if (StringsKt.isBlank(r16) == false) goto L17;
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r9 = false;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$lQGJUo1nmiUoZJu-XzDq75rAtJk, reason: not valid java name */
    public static /* synthetic */ CharSequence m1080lambda$lQGJUo1nmiUoZJuXzDq75rAtJk(fx r0) {
        return a(r0);
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r32, Object r34) {
        Intrinsics.checkNotNullParameter(r34, "raw");
        if (ZeusTransformUtils.instanceOf(r34, go.class) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.a(((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).getCreateTime()) == false) goto L11;
        RunLog.INSTANCE.debug("MessageEntityEventHandler", "history filtered rawId=" + r32 + " createTime=" + ((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).getCreateTime());
        return CollectionsKt.emptyList();
    L11:
        if (this.f12215b.a() == true) goto L14;
        RunLog.INSTANCE.debug("MessageEntityEventHandler", "burst suppressed rawId=" + r32);
        return CollectionsKt.emptyList();
    L14:
        String r0 = ((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).h();
        if (Intrinsics.areEqual(r0, "INBOX") == false) goto L18;
        String r13 = EventNames.RECEIVE_SMS;
    L21:
        if (r13 != null) goto L79;
        return CollectionsKt.emptyList();
    L79:
        List r1 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).a(), new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L27 JsonSyntaxException -> L29
    L33:
        if (r1 == null) goto L35;
        String r2 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L36:
        String r6 = "";
        if (r2 != null) goto L39;
        String r14 = "";
    L40:
        String r3 = ((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).f();
        if (r3 != null) goto L77;
    L49:
        List<String> r4 = null;
    L50:
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L53;
    L56:
        boolean r7 = true;
    L57:
        if (r7 == true) goto L59;
        r6 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().queryByEntityIdListAndPackageName(r4, AppInfo.Contact.getPackageName()), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$h$lQGJUo1nmiUoZJuXzDq75rAtJk.INSTANCE, 30, null);
    L59:
        List<String> r24 = r4;
        if (Intrinsics.areEqual(r13, EventNames.RECEIVE_SMS) == true) goto L62;
        IRunLog r25 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r8 = new StringBuilder().append("dispatch ").append(r13).append(" rawId=").append(r32).append(" phones.len=").append(r14.length()).append(" contacts.count=");
        if (r24 == null) goto L74;
        int r9 = r24.size();
    L75:
        IRunLog.a.a(r25, "MessageEntityEventHandler", r8.append(r9).toString(), false, 4, null);
        return CollectionsKt.listOf(new com.obric.memorydata.personalcontext.impl.events.a(r13, MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r32)), TuplesKt.to("receiver", r14), TuplesKt.to("contact_name", r6), TuplesKt.to(Params.CONTENT, ((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).b()), TuplesKt.to("raw_table", "RawMessageEntity"), TuplesKt.to("timestamp", Long.valueOf(((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).getCreateTime()))})));
    L74:
        r9 = 0;
        goto L75
    L62:
        if (Intrinsics.areEqual(((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).g(), "VERIFICATION_CODE") == false) goto L64;
        String r10 = "verification_code";
    L65:
        String r23 = r10;
        a(r32, ((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).b(), r23, MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r32)), TuplesKt.to("sender", r14), TuplesKt.to("contact_name", r6), TuplesKt.to(Params.CONTENT, ((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).b()), TuplesKt.to("raw_table", "RawMessageEntity"), TuplesKt.to("timestamp", Long.valueOf(((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).getCreateTime()))}), System.currentTimeMillis());
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r12 = new StringBuilder().append("enqueue classifier for ").append(r13).append(" rawId=").append(r32).append(" msg.len=").append(((go) ZeusTransformUtils.preCheckCast(r34, go.class, "com.obric.memorydata.plugin")).b().length()).append(" phones.len=").append(r14.length()).append(" contacts.count=");
        if (r24 == null) goto L68;
        int r15 = r24.size();
    L69:
        IRunLog.a.a(r11, "MessageEntityEventHandler", r12.append(r15).append(" msgType=").append(r23).toString(), false, 4, null);
        return CollectionsKt.emptyList();
    L68:
        r15 = 0;
        goto L69
    L64:
        r10 = null;
        goto L65
    L53:
        if (r5.isEmpty() == true) goto L56;
        r7 = false;
        goto L57
    L77:
        r4 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r3, new d().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L44 JsonSyntaxException -> L46
    L46:
        e = e;
        IRunLog r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r17 = new StringBuilder();
    L48:
        IRunLog.a.b(r16, "GsonExt", r17.append("toListObj error : ").append(e).toString(), null, 4, null);
    L44:
        e = e;
        r16 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r17 = new StringBuilder();
        goto L48
    L39:
        r14 = r2;
        goto L40
    L35:
        r2 = null;
    L29:
        e = e;
        IRunLog r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r19 = new StringBuilder();
    L31:
        IRunLog.a.b(r18, "GsonExt", r19.append("toListObj error : ").append(e).toString(), null, 4, null);
        r1 = null;
    L27:
        e = e;
        r18 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r19 = new StringBuilder();
        goto L31
    L18:
        if (Intrinsics.areEqual(r0, "OUTBOX") == false) goto L20;
        r13 = EventNames.SEND_SMS;
        goto L21
    L20:
        r13 = null;
        goto L21
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r1, Object r3, Object r4) {
        Intrinsics.checkNotNullParameter(r4, "raw");
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r1, Object r3) {
        return CollectionsKt.emptyList();
    }
}
