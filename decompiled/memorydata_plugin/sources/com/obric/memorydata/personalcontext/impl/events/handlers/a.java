package com.obric.memorydata.personalcontext.impl.events.handlers;

import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.fe;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.awareness.EventNames;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J.\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J0\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00172\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0002J\f\u0010\u001a\u001a\u00020\u0014*\u00020\u001bH\u0002J.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/AlarmEntityEventHandler;", "Lcom/obric/memorydata/personalcontext/impl/events/RawEntityEventHandler;", "<init>", "()V", "suppressor", "Lcom/obric/memorydata/personalcontext/impl/events/EventDispatchUtils$BurstSuppressor;", "onInsert", "", "Lcom/obric/memorydata/personalcontext/impl/events/AwarenessEvent;", "rawId", "", "raw", "", "onUpdate", "oldRaw", "onDelete", "buildAlarmChangedEvent", "operation", "", "current", "Lcom/obric/memorydata/personalcontext/impl/events/handlers/AlarmEntityEventHandler$AlarmSnapshot;", "old", "eventMetaExtras", "", "op", ObricMemoryConstants.KEY_PACKAGE_NAME, "toSnapshot", "Lcom/obric/memorydata/database/entity/RawAlarmEntity;", "logDispatch", "", "parseDays", "", EventBody.KEY_VALUE, "Companion", "AlarmSnapshot", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements com.obric.memorydata.personalcontext.impl.events.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12203a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.memorydata.personalcontext.impl.events.b.a f12204b;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.impl.events.handlers.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bJ\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001bJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003JU\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014¨\u0006)"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/AlarmEntityEventHandler$AlarmSnapshot;", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", ActivityLifecycle.NAME, "ringTime", "enabled", "", "repeatType", "", "repeatDaysOfWeek", "", "closeInHoliday", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/util/List;Z)V", "getPackageName", "()Ljava/lang/String;", "getName", "getRingTime", "getEnabled", "()Z", "getRepeatType", "()I", "getRepeatDaysOfWeek", "()Ljava/util/List;", "getCloseInHoliday", "toExtras", "", "toOldExtras", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class C0656a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12206b;
        private final String c;
        private final boolean d;
        private final int e;
        private final List<Integer> f;
        private final boolean g;

        public C0656a(String r3, String r4, String r5, boolean r6, int r7, List<Integer> r8, boolean r9) {
            List<Integer> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r5, "ringTime");
            Intrinsics.checkNotNullParameter(r10, "repeatDaysOfWeek");
            this.f12205a = r3;
            this.f12206b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r10;
            this.g = r9;
        }

        public final String a() {
            return this.f12205a;
        }

        public final String b() {
            return this.f12206b;
        }

        public final boolean c() {
            return this.d;
        }

        public final int d() {
            return this.e;
        }

        public final Map<String, Object> e() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("alarm_name", this.f12206b), TuplesKt.to("ring_time", this.c), TuplesKt.to("alarm_enabled", Boolean.valueOf(this.d)), TuplesKt.to("repeat_type", Integer.valueOf(this.e)), TuplesKt.to("repeat_day_of_week", this.f), TuplesKt.to("close_in_holiday", Boolean.valueOf(this.g))});
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0656a.class) == true) goto L8;
            return false;
        L8:
            C0656a r6 = (C0656a) ZeusTransformUtils.preCheckCast(r5, C0656a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12205a, r6.f12205a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12206b, r6.f12206b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (this.g == r6.g) goto L29;
            return false;
        L29:
            return true;
        }

        public final Map<String, Object> f() {
            return MapsKt.mapOf(new Pair[]{TuplesKt.to("old_alarm_name", this.f12206b), TuplesKt.to("old_ring_time", this.c), TuplesKt.to("old_alarm_enabled", Boolean.valueOf(this.d)), TuplesKt.to("old_repeat_type", Integer.valueOf(this.e)), TuplesKt.to("old_repeat_day_of_week", this.f), TuplesKt.to("old_close_in_holiday", Boolean.valueOf(this.g))});
        }

        public int hashCode() {
            return (((((((((((this.f12205a.hashCode() * 31) + this.f12206b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g);
        }

        public String toString() {
            return "AlarmSnapshot(packageName=" + this.f12205a + ", name=" + this.f12206b + ", ringTime=" + this.c + ", enabled=" + this.d + ", repeatType=" + this.e + ", repeatDaysOfWeek=" + this.f + ", closeInHoliday=" + this.g + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/events/handlers/AlarmEntityEventHandler$Companion;", "", "<init>", "()V", "TAG", "", "OP_INSERT", "OP_UPDATE", "OP_DELETE", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c extends TypeToken<List<? extends Integer>> {
        public c() {
        }
    }

    static {
        f12203a = new b(null);
    }

    public a() {
        this.f12204b = new com.obric.memorydata.personalcontext.impl.events.b.a(5, 1000);
    }

    private final com.obric.memorydata.personalcontext.impl.events.a a(long r3, String r5, C0656a r6, C0656a r7) {
        Map r0 = MapsKt.createMapBuilder();
        if (r6 == null) goto L5;
        String r1 = r6.a();
    L6:
        r0.putAll(a(r3, r5, r1));
        if (r6 == null) goto L9;
        r0.putAll(r6.e());
    L9:
        if (r7 == null) goto L12;
        r0.put("old_alarm", r7.f());
    L12:
        return new com.obric.memorydata.personalcontext.impl.events.a(EventNames.ALARM_CHANGED, MapsKt.build(r0));
    L5:
        r1 = null;
        goto L6
    }

    static /* synthetic */ com.obric.memorydata.personalcontext.impl.events.a a(a r6, long r7, String r9, C0656a r10, C0656a r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L6;
        r11 = null;
    L6:
        return r6.a(r7, r9, r10, r11);
    }

    private final C0656a a(fe r10) {
        String r1 = r10.getPackageName();
        String r2 = r10.a();
        String r3 = r10.b();
        boolean r4 = Intrinsics.areEqual(r10.c(), "ON");
        Integer r0 = r10.g();
        if (r0 == null) goto L5;
        int r5 = r0.intValue();
    L7:
        return new C0656a(r1, r2, r3, r4, r5, a(r10.d()), r10.e());
    L5:
        r5 = 0;
        goto L7
    }

    private final List<Integer> a(String r10) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        List r2 = null;
        r2 = (List) ZeusTransformUtils.preCheckCast(u.a().fromJson(r10, new c().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L15 JsonSyntaxException -> L17
    L20:
        if (r2 != null) goto L23;
        r2 = CollectionsKt.emptyList();
    L23:
        return CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"));
    L17:
        e = e;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder();
    L19:
        IRunLog.a.b(r3, "GsonExt", r4.append("toListObj error : ").append(e).toString(), null, 4, null);
    L15:
        e = e;
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r4 = new StringBuilder();
        goto L19
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    private final Map<String, Object> a(long r1, String r3, String r4) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("raw_id", Long.valueOf(r1)), TuplesKt.to("raw_table", "RawAlarmEntity"), TuplesKt.to("operation", r3), TuplesKt.to("package_name", r4)});
    }

    private final void b(long r14, String r16, C0656a r17, C0656a r18) {
        int r3 = r16.hashCode();
        boolean r5 = true;
        int r6 = 0;
        if (r3 == (-1335458389)) goto L40;
        Object r12 = null;
        if (r3 == (-1183792455)) goto L24;
        if (r3 == (-838846263)) goto L10;
        return;
    L10:
        if (r16.equals(BuildConfig.CHANNEL) == false) goto L50;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("dispatch alarm_changed(").append(r16).append(") rawId=").append(r14).append(" hasOld=");
        if (r18 != null) goto L16;
        r5 = false;
    L16:
        StringBuilder r1 = r0.append(r5).append(" enabled=");
        if (r17 == null) goto L19;
        Boolean r2 = Boolean.valueOf(r17.c());
    L20:
        StringBuilder r7 = r1.append(r2).append(" repeatType=");
        if (r17 == null) goto L38;
        r12 = Integer.valueOf(r17.d());
    L38:
        StringBuilder r8 = r7.append(r12);
    L47:
        IRunLog.a.a(r4, "AlarmEntityEventHandler", r8.toString(), false, 4, null);
        return;
    L19:
        r2 = null;
        goto L20
    L50:
        return;
    L24:
        if (r16.equals("insert") == false) goto L51;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("dispatch alarm_changed(").append(r16).append(") rawId=").append(r14).append(" nameLen=");
        if (r17 == null) goto L31;
        String r10 = r17.b();
        if (r10 == null) goto L31;
        r6 = r10.length();
    L31:
        StringBuilder r11 = r9.append(r6).append(" repeatType=");
        if (r17 == null) goto L34;
        Integer r13 = Integer.valueOf(r17.d());
    L35:
        r7 = r11.append(r13).append(" enabled=");
        if (r17 == null) goto L38;
        r12 = Boolean.valueOf(r17.c());
        goto L38
    L34:
        r13 = null;
        goto L35
    L51:
        return;
    L40:
        if (r16.equals("delete") == false) goto L52;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r15 = new StringBuilder().append("dispatch alarm_changed(").append(r16).append(") rawId=").append(r14).append(" hasRaw=");
        if (r17 != null) goto L46;
        r5 = false;
    L46:
        r8 = r15.append(r5);
        goto L47
    }

    static /* synthetic */ void b(a r6, long r7, String r9, C0656a r10, C0656a r11, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = null;
    L5:
        r6.b(r7, r9, r10, r11);
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r9, Object r11) {
        Intrinsics.checkNotNullParameter(r11, "raw");
        if (ZeusTransformUtils.instanceOf(r11, fe.class) == false) goto L5;
        fe r12 = (fe) ZeusTransformUtils.preCheckCast(r11, fe.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 != null) goto L10;
        return CollectionsKt.emptyList();
    L10:
        if (com.obric.memorydata.personalcontext.impl.events.b.f12198a.a(r12.getCreateTime()) == false) goto L14;
        RunLog.INSTANCE.debug("AlarmEntityEventHandler", "history filtered rawId=" + r9 + " createTime=" + r12.getCreateTime());
        return CollectionsKt.emptyList();
    L14:
        if (this.f12204b.a() == true) goto L17;
        RunLog.INSTANCE.debug("AlarmEntityEventHandler", "burst suppressed rawId=" + r9);
        return CollectionsKt.emptyList();
    L17:
        C0656a r13 = a(r12);
        b(this, r9, "insert", r13, null, 8, null);
        return CollectionsKt.listOf(a(this, r9, "insert", r13, null, 8, null));
    L5:
        r12 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> a(long r7, Object r9, Object r10) {
        Intrinsics.checkNotNullParameter(r10, "raw");
        C0656a r2 = null;
        if (ZeusTransformUtils.instanceOf(r10, fe.class) == false) goto L5;
        fe r11 = (fe) ZeusTransformUtils.preCheckCast(r10, fe.class, "com.obric.memorydata.plugin");
    L6:
        if (r11 == null) goto L8;
        C0656a r12 = a(r11);
        if (ZeusTransformUtils.instanceOf(r9, fe.class) == false) goto L12;
        fe r13 = (fe) ZeusTransformUtils.preCheckCast(r9, fe.class, "com.obric.memorydata.plugin");
    L13:
        if (r13 == null) goto L15;
        r2 = a(r13);
    L15:
        C0656a r14 = r2;
        if (r14 == null) goto L22;
        if (Intrinsics.areEqual(r14, r12) == false) goto L22;
        RunLog.INSTANCE.debug("AlarmEntityEventHandler", "no meaningful change, skip rawId=" + r7);
        return CollectionsKt.emptyList();
    L22:
        if (this.f12204b.a() == true) goto L25;
        RunLog.INSTANCE.debug("AlarmEntityEventHandler", "burst suppressed rawId=" + r7);
        return CollectionsKt.emptyList();
    L25:
        b(r7, BuildConfig.CHANNEL, r12, r14);
        return CollectionsKt.listOf(a(r7, BuildConfig.CHANNEL, r12, r14));
    L12:
        r13 = null;
        goto L13
    L8:
        return CollectionsKt.emptyList();
    L5:
        r11 = null;
        goto L6
    }

    @Override // com.obric.memorydata.personalcontext.impl.events.c
    public List<com.obric.memorydata.personalcontext.impl.events.a> b(long r11, Object r13) {
        if (this.f12204b.a() == true) goto L6;
        RunLog.INSTANCE.debug("AlarmEntityEventHandler", "burst suppressed rawId=" + r11);
        return CollectionsKt.emptyList();
    L6:
        C0656a r1 = null;
        if (ZeusTransformUtils.instanceOf(r13, fe.class) == false) goto L9;
        fe r14 = (fe) ZeusTransformUtils.preCheckCast(r13, fe.class, "com.obric.memorydata.plugin");
    L10:
        if (r14 == null) goto L12;
        r1 = a(r14);
    L12:
        C0656a r6 = r1;
        b(this, r11, "delete", r6, null, 8, null);
        return CollectionsKt.listOf(a(this, r11, "delete", r6, null, 8, null));
    L9:
        r14 = null;
        goto L10
    }
}
