package com.obric.memorydata.awareness.impl.cron;

import com.bytedance.crypto.utils.CryptoConst;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\f\u0010\u0018\u001a\u00020\n*\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\u0007\u001a6\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t0\bj\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/awareness/impl/cron/CronManager;", "", "<init>", "()V", "TAG", "", "lock", "activeJobsByScope", "Ljava/util/HashMap;", "", "Lcom/obric/memorydata/awareness/impl/cron/CronJobSignature;", "Lkotlin/collections/HashMap;", "sync", "", "scope", "jobs", "", "Lcom/obric/memorydata/awareness/impl/cron/CronManager$CronJobSpec;", "removeScope", "schedule", "taskName", "job", "buildTaskName", "key", "toSignature", "md5Hex", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "CronJobSpec", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f8652b = null;
    private static final HashMap<String, Map<String, com.obric.memorydata.awareness.impl.cron.a>> c = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012¨\u0006-"}, d2 = {"Lcom/obric/memorydata/awareness/impl/cron/CronManager$CronJobSpec;", "", "key", "", CronJobRunnerTask.KEY_CRON, "triggerExactly", "", "targetTask", "payload", "Lorg/json/JSONObject;", "targetConditions", "", "targetExistingTaskPolicy", "targetExecuteImmediately", "targetDedupeKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lorg/json/JSONObject;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getCron", "getTriggerExactly", "()Z", "getTargetTask", "getPayload", "()Lorg/json/JSONObject;", "getTargetConditions", "()Ljava/util/List;", "getTargetExistingTaskPolicy", "getTargetExecuteImmediately", "getTargetDedupeKey", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f8653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f8654b;
        private final boolean c;
        private final String d;
        private final JSONObject e;
        private final List<String> f;
        private final String g;
        private final boolean h;
        private final String i;

        public a(String r3, String r4, boolean r5, String r6, JSONObject r7, List<String> r8, String r9, boolean r10, String r11) {
            List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "key");
            Intrinsics.checkNotNullParameter(r4, CronJobRunnerTask.KEY_CRON);
            Intrinsics.checkNotNullParameter(r6, "targetTask");
            Intrinsics.checkNotNullParameter(r7, "payload");
            Intrinsics.checkNotNullParameter(r12, "targetConditions");
            this.f8653a = r3;
            this.f8654b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r12;
            this.g = r9;
            this.h = r10;
            this.i = r11;
        }

        public /* synthetic */ a(String r13, String r14, boolean r15, String r16, JSONObject r17, List r18, String r19, boolean r20, String r21, int r22, DefaultConstructorMarker r23) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
            if ((r22 & 32) == 0) goto L5;
            r1 = CollectionsKt.emptyList();
        L5:
            List r8 = r1;
            if ((r22 & 64) == 0) goto L8;
            String r9 = null;
        L10:
            if ((r22 & 128) == 0) goto L12;
            boolean r10 = false;
        L14:
            if ((r22 & 256) == 0) goto L16;
            String r11 = null;
        L17:
            this(r13, r14, r15, r16, r17, r8, r9, r10, r11);
            return;
        L16:
            r11 = r21;
            goto L17
        L12:
            r10 = r20;
            goto L14
        L8:
            r9 = r19;
            goto L10
        }

        public final String a() {
            return this.f8653a;
        }

        public final String b() {
            return this.f8654b;
        }

        public final boolean c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final JSONObject e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8653a, r6.f8653a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8654b, r6.f8654b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final List<String> f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public int hashCode() {
            int r0 = ((((((((((this.f8653a.hashCode() * 31) + this.f8654b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
            String r1 = this.g;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + Boolean.hashCode(this.h)) * 31;
            String r5 = this.i;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String i() {
            return this.i;
        }

        public String toString() {
            return "CronJobSpec(key=" + this.f8653a + ", cron=" + this.f8654b + ", triggerExactly=" + this.c + ", targetTask=" + this.d + ", payload=" + this.e + ", targetConditions=" + this.f + ", targetExistingTaskPolicy=" + this.g + ", targetExecuteImmediately=" + this.h + ", targetDedupeKey=" + this.i + ')';
        }
    }

    static {
        f8651a = new b();
        f8652b = new Object();
        c = new HashMap();
    }

    private b() {
    }

    private final com.obric.memorydata.awareness.impl.cron.a a(a r10) {
        String r1 = r10.b();
        boolean r2 = r10.c();
        String r3 = r10.d();
        String r4 = aa.a(r10.e()).toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        return new com.obric.memorydata.awareness.impl.cron.a(r1, r2, r3, r4, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r10.f(), Iterable.class, "com.obric.memorydata.plugin")), r10.g(), r10.h(), r10.i());
    }

    private final String a(String r3, String r4) {
        return CronJobRunnerTask.TASK_NAME_PREFIX + b(r3 + '|' + r4);
    }

    private final void a(String r8, a r9) {
        Long r7 = com.obric.memorydata.utils.b.a.a(com.obric.memorydata.utils.b.a.f13191a, r9.b(), System.currentTimeMillis(), null, 4, null);
        if (r7 == null) goto L29;
        long r0 = r7.longValue();
        long r2 = RangesKt.coerceAtLeast(r0 - System.currentTimeMillis(), 0);
        JSONObject r10 = new JSONObject();
        r10.put(CronJobRunnerTask.KEY_CRON, r9.b());
        r10.put(CronJobRunnerTask.KEY_TARGET_TASK, r9.d());
        r10.put("payload", aa.a(r9.e()));
        r10.put(CronJobRunnerTask.KEY_CRON_FIRE_TIME_MILLIS, r0);
        boolean r1 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9.f(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        r10.put(CronJobRunnerTask.KEY_TARGET_CONDITIONS, new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r9.f(), Collection.class, "com.obric.memorydata.plugin")));
    L7:
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.g(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L17;
        r10.put(CronJobRunnerTask.KEY_TARGET_EXISTING_TASK_POLICY, r9.g());
    L17:
        if (r9.h() == false) goto L19;
        r10.put(CronJobRunnerTask.KEY_TARGET_EXECUTE_IMMEDIATELY, true);
    L19:
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r9.i(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L22;
    L25:
        if (r1 == true) goto L27;
        r10.put(CronJobRunnerTask.KEY_TARGET_DEDUPE_KEY, r9.i());
    L27:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r8).setInputParam(r10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay(new g(r2, TimeUnit.MILLISECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTriggerExactly(r9.c()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.CANCEL_EXISTING), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        RunLog.INSTANCE.debug("CronManager", "schedule taskName=" + r8 + " delayMs=" + r2 + " cron=" + r9.b() + " target=" + r9.d());
        return;
    L22:
        if (StringsKt.isBlank(r5) == true) goto L25;
        r1 = false;
        goto L25
    L10:
        if (StringsKt.isBlank(r3) == true) goto L13;
        r4 = false;
        goto L14
    }

    private final String b(String r7) {
        MessageDigest r6 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);
        byte[] r8 = r7.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r8, "getBytes(...)");
        byte[] r9 = r6.digest(r8);
        StringBuilder r10 = new StringBuilder(r9.length * 2);
        Intrinsics.checkNotNull(r9);
        int r0 = r9.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        int r3 = r9[r1] & 255;
        if (r3 >= 16) goto L8;
        r10.append('0');
    L8:
        String r4 = Integer.toString(r3, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        r10.append(r4);
        r1 = r1 + 1;
        goto L4
    L9:
        String r11 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        return r11;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "scope");
        Object r2 = f8652b;
        monitor-enter(r2);
        Map r4 = (Map) ZeusTransformUtils.preCheckCast(c.remove(r3), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r4 == null) goto L10;
        Set r5 = r4.keySet();     // Catch: Throwable -> L19
        if (r5 == null) goto L10;
        List r6 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
    L11:
        monitor-exit(r2);
        if (r6 != null) goto L14;
        return;
    L14:
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().a(r8);
        goto L16
    L18:
        return;
    L10:
        r6 = null;
    L19:
        th = move-exception;
        throw th;
    }

    public final void a(String r11, List<a> r12) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "scope");
        Intrinsics.checkNotNullParameter(r10, "jobs");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CronManager", "sync scope=" + r11 + " jobs=" + r10.size(), false, 4, null);
        LinkedHashMap r13 = new LinkedHashMap();
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r14.hasNext() == false) goto L18;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r14.next(), a.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1.a(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L16;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1.b(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L16;
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1.d(), CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L16;
        if (com.obric.memorydata.utils.b.a.f13191a.b(r1.b()) == false) goto L14;
        b r2 = f8651a;
        String r3 = r2.a(r11, r1.a());
        ((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin")).put(r3, r1);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r3, r2.a(r1));
        goto L4
    L14:
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r5 = "CronManager";
        StringBuilder r6 = new StringBuilder().append("skip invalid cron scope=").append(r11).append(" key=").append(r1.a()).append(" cron=");
        String r7 = r1.b();
    L17:
        IRunLog.a.a(r4, r5, r6.append(r7).toString(), null, 4, null);
    L16:
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = "CronManager";
        r6 = new StringBuilder().append("skip invalid job scope=").append(r11).append(" key=").append(r1.a()).append(" cron=").append(r1.b()).append(" target=");
        r7 = r1.d();
        goto L17
    L18:
        Object r15 = f8652b;
        monitor-enter(r15);
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(c.get(r11), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        if (r8 != null) goto L23;
        r8 = MapsKt.emptyMap();     // Catch: Throwable -> L48
    L23:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8.keySet(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        Set r16 = r0.keySet();     // Catch: Throwable -> L48
        Intrinsics.checkNotNullExpressionValue(r16, "<get-keys>(...)");     // Catch: Throwable -> L48
        Set r17 = CollectionsKt.subtract(r9, (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L48
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        Map r19 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        Iterator r20 = r18.entrySet().iterator();     // Catch: Throwable -> L48
    L25:
        if (r20.hasNext() == false) goto L29;
        Map.Entry r21 = (Map.Entry) ZeusTransformUtils.preCheckCast(r20.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        String r22 = (String) ZeusTransformUtils.preCheckCast(r21.getKey(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        if ((!Intrinsics.areEqual(r8.get(r22), (com.obric.memorydata.awareness.impl.cron.a) ZeusTransformUtils.preCheckCast(r21.getValue(), com.obric.memorydata.awareness.impl.cron.a.class, "com.obric.memorydata.plugin"))) == false) goto L25;
        r19.put(r21.getKey(), r21.getValue());     // Catch: Throwable -> L48
        goto L25
    L29:
        Set r23 = r19.keySet();     // Catch: Throwable -> L48
        ((Map) ZeusTransformUtils.preCheckCast(c, Map.class, "com.obric.memorydata.plugin")).put(r11, MapsKt.toMutableMap((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L48
        Pair r24 = TuplesKt.to(r17, r23);     // Catch: Throwable -> L48
        monitor-exit(r15);
        Set r110 = (Set) ZeusTransformUtils.preCheckCast(r24.component1(), Set.class, "com.obric.memorydata.plugin");
        Set r25 = (Set) ZeusTransformUtils.preCheckCast(r24.component2(), Set.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r110, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CronManager", "remove scope=" + r11 + " size=" + r110.size(), false, 4, null);
    L34:
        Iterator r111 = ((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L36:
        if (r111.hasNext() == false) goto L39;
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().a((String) ZeusTransformUtils.preCheckCast(r111.next(), String.class, "com.obric.memorydata.plugin"));
        goto L36
    L39:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r25, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L41;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "CronManager", "schedule scope=" + r11 + " size=" + r25.size(), false, 4, null);
    L41:
        Iterator r112 = ((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L43:
        if (r112.hasNext() == false) goto L47;
        String r113 = (String) ZeusTransformUtils.preCheckCast(r112.next(), String.class, "com.obric.memorydata.plugin");
        a r26 = (a) ZeusTransformUtils.preCheckCast(r13.get(r113), a.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L43;
        f8651a.a(r113, r26);
        goto L43
    L47:
        return;
    L48:
        th = move-exception;
        throw th;
    }
}
