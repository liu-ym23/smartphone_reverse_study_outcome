package com.bytedance.applog.priority.original;

import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.resource.utils.GuardFile;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.ss.android.common.lib.AppLogNewUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\u0018\u00002\u00020\u0001:\u000b\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/applog/priority/original/Model;", "", "()V", "EventKey", "EventType", "FastMatchGroups", "GroupConfig", "GroupFrequency", "GroupFrequencyAllow", "PriorityConfig", "PriorityInnerContext", "PriorityName", "Ser", "Version", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Model {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0013B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$EventType;", "", "type", "", "alias", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getAlias", "()Ljava/lang/String;", "getType", "()I", "V3", "V1", "LogData", "Launch", "Terminate", "Impression", "ForwardV3", "Unknown", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum EventType extends Enum<EventType> {
        private static final /* synthetic */ EventType[] $VALUES = null;
        public static final a Companion = null;
        public static final EventType ForwardV3 = null;
        public static final EventType Impression = null;
        public static final EventType Launch = null;
        public static final EventType LogData = null;
        public static final EventType Terminate = null;
        public static final EventType Unknown = null;
        public static final EventType V1 = null;
        public static final EventType V3 = null;
        private final String alias;
        private final int type;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$EventType$Companion;", "", "()V", "getEventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "type", "", "alias", "", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final EventType a(int r6) {
                EventType[] r5 = EventType.values();
                int r0 = r5.length;
                int r2 = 0;
            L3:
                if (r2 >= r0) goto L11;
                EventType r3 = r5[r2];
                if (r3.getType() != r6) goto L7;
                boolean r4 = true;
            L8:
                if (r4 == true) goto L12;
                r2 = r2 + 1;
            L12:
                if (r3 == null) goto L14;
                return r3;
            L14:
                return EventType.Unknown;
            L7:
                r4 = false;
                goto L8
            L11:
                r3 = null;
                goto L12
            }

            public final EventType a(String r7) {
                Intrinsics.checkNotNullParameter(r7, "alias");
                EventType[] r6 = EventType.values();
                int r0 = r6.length;
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L8;
                EventType r2 = r6[r1];
                String r3 = r2.getAlias();
                Locale r4 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(r4, "ROOT");
                String r5 = r7.toLowerCase(r4);
                Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).toLowerCase(locale)");
                if (Intrinsics.areEqual(r3, r5) == true) goto L9;
                r1 = r1 + 1;
            L9:
                if (r2 == null) goto L11;
                return r2;
            L11:
                return EventType.Unknown;
            L8:
                r2 = null;
                goto L9
            }
        }

        private static final /* synthetic */ EventType[] $values() {
            return new EventType[]{V3, V1, LogData, Launch, Terminate, Impression, ForwardV3, Unknown};
        }

        static {
            V3 = new EventType("V3", 0, 0, AppLogNewUtils.EVENT_V3_CATEGORY);
            V1 = new EventType("V1", 1, 1, "event_v1");
            LogData = new EventType("LogData", 2, 2, "log_data");
            Launch = new EventType("Launch", 3, 3, Constants.LAUNCH_TAG);
            Terminate = new EventType("Terminate", 4, 4, "terminate");
            Impression = new EventType("Impression", 5, 5, "item_impression");
            ForwardV3 = new EventType("ForwardV3", 6, 6, "forward_v3");
            Unknown = new EventType("Unknown", 7, 99, "unknown");
            $VALUES = $values();
            Companion = new a(null);
        }

        private EventType(String r1, int r2, int r3, String r4) {
            super(r1, r2);
            this.type = r3;
            this.alias = r4;
        }

        public static EventType valueOf(String r2) {
            return (EventType) ZeusTransformUtils.preCheckCast(Enum.valueOf(EventType.class, r2), EventType.class, "com.obric.memorydata.plugin");
        }

        public static EventType[] values() {
            return (EventType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EventType[].class, "com.obric.memorydata.plugin");
        }

        public final String getAlias() {
            return this.alias;
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$GroupFrequencyAllow;", "", "(Ljava/lang/String;I)V", "Allow", "BlockByFrequency", "BlockByBackoff", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum GroupFrequencyAllow extends Enum<GroupFrequencyAllow> {
        private static final /* synthetic */ GroupFrequencyAllow[] $VALUES = null;
        public static final GroupFrequencyAllow Allow = null;
        public static final GroupFrequencyAllow BlockByBackoff = null;
        public static final GroupFrequencyAllow BlockByFrequency = null;

        private static final /* synthetic */ GroupFrequencyAllow[] $values() {
            return new GroupFrequencyAllow[]{Allow, BlockByFrequency, BlockByBackoff};
        }

        static {
            Allow = new GroupFrequencyAllow("Allow", 0);
            BlockByFrequency = new GroupFrequencyAllow("BlockByFrequency", 1);
            BlockByBackoff = new GroupFrequencyAllow("BlockByBackoff", 2);
            $VALUES = $values();
        }

        private GroupFrequencyAllow(String r1, int r2) {
            super(r1, r2);
        }

        public static GroupFrequencyAllow valueOf(String r2) {
            return (GroupFrequencyAllow) ZeusTransformUtils.preCheckCast(Enum.valueOf(GroupFrequencyAllow.class, r2), GroupFrequencyAllow.class, "com.obric.memorydata.plugin");
        }

        public static GroupFrequencyAllow[] values() {
            return (GroupFrequencyAllow[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GroupFrequencyAllow[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$PriorityName;", "", "(Ljava/lang/String;I)V", "P0", "P1", "P2", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum PriorityName extends Enum<PriorityName> {
        private static final /* synthetic */ PriorityName[] $VALUES = null;
        public static final PriorityName P0 = null;
        public static final PriorityName P1 = null;
        public static final PriorityName P2 = null;

        private static final /* synthetic */ PriorityName[] $values() {
            return new PriorityName[]{P0, P1, P2};
        }

        static {
            P0 = new PriorityName("P0", 0);
            P1 = new PriorityName("P1", 1);
            P2 = new PriorityName("P2", 2);
            $VALUES = $values();
        }

        private PriorityName(String r1, int r2) {
            super(r1, r2);
        }

        public static PriorityName valueOf(String r2) {
            return (PriorityName) ZeusTransformUtils.preCheckCast(Enum.valueOf(PriorityName.class, r2), PriorityName.class, "com.obric.memorydata.plugin");
        }

        public static PriorityName[] values() {
            return (PriorityName[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PriorityName[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u001d\u001a\u00020\fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$EventKey;", "", "dbId", "", "groupId", "", "ts", "eventType", "Lcom/bytedance/applog/priority/original/Model$EventType;", "eventStained", "", "monitorId", "", "eventName", "(JIJLcom/bytedance/applog/priority/original/Model$EventType;ZLjava/lang/String;Ljava/lang/String;)V", "getDbId", "()J", "setDbId", "(J)V", "getEventName", "()Ljava/lang/String;", "getEventStained", "()Z", "getEventType", "()Lcom/bytedance/applog/priority/original/Model$EventType;", "getGroupId", "()I", "getMonitorId", "getTs", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f1794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1795b;
        private final long c;
        private final EventType d;
        private final boolean e;
        private final String f;
        private final String g;

        public a(long r2, int r4, long r5, EventType r7, boolean r8, String r9, String r10) {
            Intrinsics.checkNotNullParameter(r7, "eventType");
            Intrinsics.checkNotNullParameter(r9, "monitorId");
            Intrinsics.checkNotNullParameter(r10, "eventName");
            this.f1794a = r2;
            this.f1795b = r4;
            this.c = r5;
            this.d = r7;
            this.e = r8;
            this.f = r9;
            this.g = r10;
        }

        public final long a() {
            return this.f1794a;
        }

        public final void a(long r1) {
            this.f1794a = r1;
        }

        public final int b() {
            return this.f1795b;
        }

        public final long c() {
            return this.c;
        }

        public final EventType d() {
            return this.d;
        }

        public final boolean e() {
            return this.e;
        }

        public final String f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public String toString() {
            return "id=" + this.f1794a + "|g=" + this.f1795b + "|n=" + this.g + '|' + this.f;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010J\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$FastMatchGroups;", "", "groups", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/applog/priority/original/Group;", "(Ljava/util/concurrent/CopyOnWriteArrayList;)V", "eventTypes", "", "Lcom/bytedance/applog/priority/original/Model$EventType;", "getGroups", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "v3All", "", "v3Names", "", "getSupportEventTypes", "", "isSupportType", "eventType", "loadGroups", "", "match", "eventName", "json", "Lkotlin/Lazy;", "Lorg/json/JSONObject;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CopyOnWriteArrayList<m> f1796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1797b;
        private Set<String> c;
        private Set<EventType> d;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f1798a = null;

            static {
                int[] r0 = new int[EventType.values().length];
                r0[EventType.V3.ordinal()] = 1;
                f1798a = r0;
            }
        }

        public b(CopyOnWriteArrayList<m> r2) {
            Intrinsics.checkNotNullParameter(r2, "groups");
            this.f1796a = r2;
            if (r2.isEmpty() == true) goto L6;
            c();
            return;
        }

        private final void c() {
            this.c = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
            this.d = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
            Iterator<m> r0 = this.f1796a.iterator();
        L4:
            if (r0.hasNext() == false) goto L56;
            m r1 = (m) ZeusTransformUtils.preCheckCast(r0.next(), m.class, "com.obric.memorydata.plugin");
            Iterator<String> r3 = r1.a().g().iterator();
        L7:
            if (r3.hasNext() == false) goto L4;
            String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(r4, EventType.V3.getAlias()) == true) goto L10;
            Set<EventType> r5 = this.d;
            if (r5 == null) goto L7;
            r5.add(EventType.Companion.a(r4));
            goto L7
        L10:
            Set<EventType> r6 = this.d;
            if (r6 == null) goto L14;
            r6.add(EventType.V3);
        L14:
            if (this.f1797b == true) goto L7;
            g.d r7 = r1.a().f();
            if (r7 == null) goto L52;
            Set<String> r8 = r7.a();
            if (r8.contains("*") == false) goto L23;
            this.f1797b = true;
            Set<String> r9 = this.c;
            if (r9 == null) goto L29;
            r9.clear();
        L29:
            HashMap<String, List<List<String>>> r10 = r7.b();
            if (((Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.memorydata.plugin")).containsKey("*") == false) goto L34;
            this.f1797b = true;
            Set<String> r11 = this.c;
            if (r11 == null) goto L40;
            r11.clear();
        L40:
            HashMap<String, List<HashMap<String, String>>> r12 = r7.c();
            if (((Map) ZeusTransformUtils.preCheckCast(r12, Map.class, "com.obric.memorydata.plugin")).containsKey("*") == false) goto L45;
            this.f1797b = true;
            Set<String> r13 = this.c;
            if (r13 == null) goto L51;
            r13.clear();
        L51:
            if (r12 != null) goto L7;
        L45:
            Set<String> r14 = r12.keySet();
            Intrinsics.checkNotNullExpressionValue(r14, "this.keys");
            Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L47:
            if (r15.hasNext() == false) goto L51;
            String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
            Set<String> r17 = this.c;
            if (r17 == null) goto L47;
            Intrinsics.checkNotNullExpressionValue(r16, "e");
            r17.add(r16);
            goto L47
        L34:
            Set<String> r18 = r10.keySet();
            Intrinsics.checkNotNullExpressionValue(r18, "this.keys");
            Iterator r19 = ((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L36:
            if (r19.hasNext() == false) goto L40;
            String r20 = (String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin");
            Set<String> r110 = this.c;
            if (r110 == null) goto L36;
            Intrinsics.checkNotNullExpressionValue(r20, "e");
            r110.add(r20);
            goto L36
        L23:
            Iterator r21 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L25:
            if (r21.hasNext() == false) goto L29;
            String r22 = (String) ZeusTransformUtils.preCheckCast(r21.next(), String.class, "com.obric.memorydata.plugin");
            Set<String> r23 = this.c;
            if (r23 == null) goto L25;
            r23.add(r22);
        L52:
            ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.memorydata.plugin")).f1797b = true;
            Unit r24 = Unit.INSTANCE;
            goto L7
        }

        public final m a(String r5, EventType r6, Lazy<? extends JSONObject> r7) {
            Lazy r8 = (Lazy) ZeusTransformUtils.wrapperContextForParams(r7, Lazy.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "eventName");
            Intrinsics.checkNotNullParameter(r6, "eventType");
            Intrinsics.checkNotNullParameter(r8, "json");
            Object r2 = null;
            if (this.f1796a.isEmpty() == false) goto L6;
            return null;
        L6:
            if (a.f1798a[r6.ordinal()] == 1) goto L8;
            Set<EventType> r9 = this.d;
            if (r9 == null) goto L33;
            Intrinsics.checkNotNull(r9);
            if (r9.contains(r6) == false) goto L33;
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f1796a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L29:
            if (r4.hasNext() == false) goto L22;
            Object r10 = r4.next();
            if (((m) ZeusTransformUtils.preCheckCast(r10, m.class, "com.obric.memorydata.plugin")).b(r6, "", null) == false) goto L29;
            r2 = r10;
        L22:
            return (m) ZeusTransformUtils.preCheckCast(r2, m.class, "com.obric.memorydata.plugin");
        L33:
            return null;
        L8:
            if (this.f1797b == true) goto L15;
            Set<String> r0 = this.c;
            if (r0 == null) goto L14;
            Intrinsics.checkNotNull(r0);
            if (r0.contains(r5) == true) goto L15;
        L14:
            return null;
        L15:
            JSONObject r11 = ((JSONObject) ZeusTransformUtils.preCheckCast(r8.getValue(), JSONObject.class, "com.obric.memorydata.plugin")).optJSONObject(TrackerImpl.PARAMS);
            Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f1796a, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L17:
            if (r12.hasNext() == false) goto L22;
            Object r1 = r12.next();
            if (((m) ZeusTransformUtils.preCheckCast(r1, m.class, "com.obric.memorydata.plugin")).b(r6, r5, r11) == false) goto L17;
            r2 = r1;
            goto L22
        }

        public final CopyOnWriteArrayList<m> a() {
            return this.f1796a;
        }

        public final boolean a(EventType r2) {
            Intrinsics.checkNotNullParameter(r2, "eventType");
            Set<EventType> r1 = this.d;
            if (r1 != null) goto L7;
            return false;
        L7:
            return r1.contains(r2);
        }

        public final Set<EventType> b() {
            Set<EventType> r0 = this.d;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return SetsKt.emptySet();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u000fH\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$GroupConfig;", "", OaidModel.KEY_ID, "", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "interval", "frequency", "Lcom/bytedance/applog/priority/original/Model$GroupFrequency;", "priority", "Lcom/bytedance/applog/priority/original/Model$PriorityConfig;", "filter", "Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "supportEventTypes", "", "", "reportUrl", "(ILcom/bytedance/applog/priority/original/Model$Version;ILcom/bytedance/applog/priority/original/Model$GroupFrequency;Lcom/bytedance/applog/priority/original/Model$PriorityConfig;Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;Ljava/util/List;Ljava/lang/String;)V", "getFilter", "()Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "getFrequency", "()Lcom/bytedance/applog/priority/original/Model$GroupFrequency;", "getId", "()I", "getInterval", "getPriority", "()Lcom/bytedance/applog/priority/original/Model$PriorityConfig;", "getReportUrl", "()Ljava/lang/String;", "getSupportEventTypes", "()Ljava/util/List;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "setMaxRequestFrequency", "", "toString", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h f1800b;
        private final int c;
        private final d d;
        private final e e;
        private final g.d f;
        private final List<String> g;
        private final String h;

        public c(int r3, h r4, int r5, d r6, e r7, g.d r8, List<String> r9, String r10) {
            List<String> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "version");
            Intrinsics.checkNotNullParameter(r6, "frequency");
            Intrinsics.checkNotNullParameter(r7, "priority");
            Intrinsics.checkNotNullParameter(r11, "supportEventTypes");
            Intrinsics.checkNotNullParameter(r10, "reportUrl");
            this.f1799a = r3;
            this.f1800b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r11;
            this.h = r10;
            i();
        }

        private final void i() {
            if (this.c > 0) goto L7;
            this.d.a(Integer.MAX_VALUE);
            return;
        L7:
            if (this.d.b() <= 0) goto L9;
            return;
        L9:
            this.d.a(RangesKt.coerceAtLeast(60 / this.c, 10));
        }

        public final int a() {
            return this.f1799a;
        }

        public final h b() {
            return this.f1800b;
        }

        public final int c() {
            return this.c;
        }

        public final d d() {
            return this.d;
        }

        public final e e() {
            return this.e;
        }

        public final g.d f() {
            return this.f;
        }

        public final List<String> g() {
            return this.g;
        }

        public final String h() {
            return this.h;
        }

        public String toString() {
            return "GroupConfig-" + this.f1799a;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\rH\u0002J\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\"J\u0006\u0010$\u001a\u00020\"J\b\u0010%\u001a\u00020\"H\u0002R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$GroupFrequency;", "", "isRealtime", "", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "backoffRatio", "", "maxRequestPerMinute", "level", "Ljava/util/concurrent/atomic/AtomicInteger;", "levelSuccessCnt", "lastWindowTime", "", "lastCheckTime", "(ZLcom/bytedance/applog/priority/original/Model$Version;IILjava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicInteger;JJ)V", "MAX_BACKOFF_RATIO", "MAX_RECOVERY_COUNT", "getLevel", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setLevel", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getMaxRequestPerMinute", "()I", "setMaxRequestPerMinute", "(I)V", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "allow", "Lcom/bytedance/applog/priority/original/Model$GroupFrequencyAllow;", "backoffAllow", "freqAllow", "checkTime", "handle2xx", "", "handle4xx", "handle5xx", "resetWindow", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f1801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h f1802b;
        private final int c;
        private int d;
        private AtomicInteger e;
        private AtomicInteger f;
        private long g;
        private long h;
        private final int i;
        private final int j;

        public d(boolean r2, h r3, int r4, int r5, AtomicInteger r6, AtomicInteger r7, long r8, long r10) {
            Intrinsics.checkNotNullParameter(r3, "version");
            Intrinsics.checkNotNullParameter(r6, "level");
            Intrinsics.checkNotNullParameter(r7, "levelSuccessCnt");
            this.f1801a = r2;
            this.f1802b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r10;
            this.i = 10000;
            this.j = 5;
        }

        private final boolean a(long r10) {
            int r0 = this.e.get();
            if (r0 != 0) goto L12;
            if ((r10 - this.g) < 60) goto L7;
            boolean r11 = true;
        L8:
            if (r11 == false) goto L19;
            h();
            return true;
        L19:
            if (this.f.get() < this.d) goto L21;
            return false;
        L21:
            return true;
        L7:
            r11 = false;
            goto L8
        L12:
            if ((r10 - this.g) < (((long) 60) * ((long) Math.pow(2.0d, r0)))) goto L14;
            boolean r12 = true;
        L15:
            if (r12 == false) goto L19;
            h();
            return true;
        L14:
            r12 = false;
            goto L15
        }

        private final boolean g() {
            int r0 = this.c;
            if (r0 != 0) goto L5;
        L12:
            return true;
        L5:
            if (r0 == this.i) goto L12;
            if (new SecureRandom().nextInt(this.i) <= this.c) goto L10;
            return true;
        L10:
            this.f.incrementAndGet();
            return false;
        }

        private final void h() {
            this.f.set(0);
            this.g = this.h;
        }

        public final h a() {
            return this.f1802b;
        }

        public final void a(int r1) {
            this.d = r1;
        }

        public final int b() {
            return this.d;
        }

        public final GroupFrequencyAllow c() {
            long r0 = System.currentTimeMillis() / ((long) 1000);
            this.h = r0;
            if (this.f1801a == false) goto L15;
            if (this.e.get() <= 0) goto L13;
            long r1 = this.h;
            if ((r1 - this.g) <= 5) goto L11;
            this.g = r1;
            return GroupFrequencyAllow.Allow;
        L11:
            return GroupFrequencyAllow.BlockByFrequency;
        L13:
            return GroupFrequencyAllow.Allow;
        L15:
            if (a(r0) == true) goto L19;
            return GroupFrequencyAllow.BlockByFrequency;
        L19:
            if (g() == true) goto L23;
            return GroupFrequencyAllow.BlockByBackoff;
        L23:
            return GroupFrequencyAllow.Allow;
        }

        public final void d() {
            this.f.set(this.d);
            this.g = this.h;
            if (this.e.incrementAndGet() <= 4) goto L6;
            this.e.set(4);
            return;
        }

        public final void e() {
        }

        public final void f() {
            int r0 = this.f.incrementAndGet();
            if (this.e.get() > 0) goto L5;
            return;
        L5:
            if (r0 < this.j) goto L7;
        L8:
            this.e.set(0);
            return;
        L7:
            if (this.f1801a == true) goto L8;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$PriorityConfig;", "", "engine", "Lcom/bytedance/applog/priority/original/Engine;", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "maxEventSize", "", "maxRequestBodySize", "maxRequestEventCnt", "", "eventTtl", "callback", "Lcom/bytedance/applog/priority/PriorityCallback;", "(Lcom/bytedance/applog/priority/original/Engine;Lcom/bytedance/applog/priority/original/Model$Version;Lcom/bytedance/applog/priority/original/Model$PriorityName;JJIJLcom/bytedance/applog/priority/PriorityCallback;)V", "getCallback", "()Lcom/bytedance/applog/priority/PriorityCallback;", "getEngine", "()Lcom/bytedance/applog/priority/original/Engine;", "getEventTtl", "()J", "getMaxEventSize", "getMaxRequestBodySize", "getMaxRequestEventCnt", "()I", "getPriorityName", "()Lcom/bytedance/applog/priority/original/Model$PriorityName;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final i f1803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h f1804b;
        private final PriorityName c;
        private final long d;
        private final long e;
        private final int f;
        private final long g;
        private final PriorityCallback h;

        public e(i r3, h r4, PriorityName r5, long r6, long r8, int r10, long r11, PriorityCallback r13) {
            PriorityCallback r14 = (PriorityCallback) ZeusTransformUtils.wrapperContextForParams(r13, PriorityCallback.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "engine");
            Intrinsics.checkNotNullParameter(r4, "version");
            Intrinsics.checkNotNullParameter(r5, "priorityName");
            Intrinsics.checkNotNullParameter(r14, "callback");
            this.f1803a = r3;
            this.f1804b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r8;
            this.f = r10;
            this.g = r11;
            this.h = r14;
        }

        public final i a() {
            return this.f1803a;
        }

        public final h b() {
            return this.f1804b;
        }

        public final PriorityName c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        public final long g() {
            return this.g;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$PriorityInnerContext;", "", "databasePool", "Lcom/bytedance/applog/priority/original/EventDatabasePool;", "context", "Lcom/bytedance/applog/priority/PriorityContext;", "(Lcom/bytedance/applog/priority/original/EventDatabasePool;Lcom/bytedance/applog/priority/PriorityContext;)V", "getContext", "()Lcom/bytedance/applog/priority/PriorityContext;", "getDatabasePool", "()Lcom/bytedance/applog/priority/original/EventDatabasePool;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f1805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.applog.priority.g f1806b;

        public f(k r2, com.bytedance.applog.priority.g r3) {
            Intrinsics.checkNotNullParameter(r2, "databasePool");
            Intrinsics.checkNotNullParameter(r3, "context");
            this.f1805a = r2;
            this.f1806b = r3;
        }

        public final k a() {
            return this.f1805a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f1805a, r6.f1805a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f1806b, r6.f1806b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final com.bytedance.applog.priority.g getContext() {
            return this.f1806b;
        }

        public int hashCode() {
            return (this.f1805a.hashCode() * 31) + this.f1806b.hashCode();
        }

        public String toString() {
            return "PriorityInnerContext(databasePool=" + this.f1805a + ", context=" + this.f1806b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser;", "", "()V", "SerBackoffPriority", "SerBackoffPriorityList", "SerGroup", "SerGroupFilter", "SerGroups", "SerPriorityConfig", "SerPriorityConfigConfig", "SerPriorityConfigConfigItem", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g {

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerBackoffPriority;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "backoffRatio", "", "getBackoffRatio", "()I", "maxRequestFrequency", "getMaxRequestFrequency", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f1807a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f1808b;

            public a(JSONObject r3) {
                Intrinsics.checkNotNullParameter(r3, "json");
                this.f1807a = r3.optInt("backoff_ratio", 0);
                this.f1808b = r3.optInt("max_request_frequency", 10);
            }

            public final int a() {
                return this.f1807a;
            }

            public final int b() {
                return this.f1808b;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerBackoffPriorityList;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "backoffRatio", "", "getBackoffRatio", "()I", "maxRequestFrequency", "getMaxRequestFrequency", "priorityMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/applog/priority/original/Model$Ser$SerBackoffPriority;", "getPriorityMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final h f1809a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f1810b;
            private final int c;
            private final ConcurrentHashMap<Integer, a> d;

            public b(JSONObject r8) {
                Intrinsics.checkNotNullParameter(r8, "json");
                int r2 = 0;
                this.f1809a = new h(r8.optInt("version", 0), r8.optJSONArray("config_ids"));
                this.f1810b = r8.optInt("backoff_ratio", 0);
                this.c = r8.optInt("max_request_frequency", 10);
                this.d = new ConcurrentHashMap();
                JSONArray r9 = r8.optJSONArray("priorities");
                if (r9 == null) goto L12;
                int r0 = r9.length();
            L5:
                if (r2 >= r0) goto L17;
                JSONObject r1 = r9.optJSONObject(r2);
                if (r1 == null) goto L11;
                Intrinsics.checkNotNullExpressionValue(r1, "priority");
                int r3 = r1.optInt("global_priority");
                if (r3 <= 0) goto L11;
                Integer r4 = Integer.valueOf(r3);
                ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r4, new a(r1));
            L11:
                r2 = r2 + 1;
                goto L5
            L17:
                return;
            }

            public final h a() {
                return this.f1809a;
            }

            public final int b() {
                return this.f1810b;
            }

            public final int c() {
                return this.c;
            }

            public final ConcurrentHashMap<Integer, a> d() {
                return this.d;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\nR\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerGroup;", "", "json", "Lorg/json/JSONObject;", "defaultReportHost", "", "defaultReportPath", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "eventPriority", "getEventPriority", "()Ljava/lang/String;", "filter", "Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "getFilter", "()Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", OaidModel.KEY_ID, "", "getId", "()I", "interval", "getInterval", "reportHost", "getReportHost", "reportPath", "getReportPath", "supportEventTypes", "", "getSupportEventTypes", "()Ljava/util/List;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f1811a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f1812b;
            private final String c;
            private final String d;
            private final List<String> e;
            private final String f;
            private final d g;

            public c(JSONObject r7, String r8, String r9) {
                Intrinsics.checkNotNullParameter(r7, "json");
                Intrinsics.checkNotNullParameter(r8, "defaultReportHost");
                Intrinsics.checkNotNullParameter(r9, "defaultReportPath");
                this.f1811a = r7.optInt("global_priority", 0);
                this.f1812b = RangesKt.coerceAtLeast(r7.optInt("interval", 0), 0);
                String r10 = r7.optString("report_host", r8);
                Intrinsics.checkNotNullExpressionValue(r10, "json.optString(\"report_host\", defaultReportHost)");
                this.c = r10;
                String r11 = r7.optString("report_path", r9);
                Intrinsics.checkNotNullExpressionValue(r11, "json.optString(\"report_path\", defaultReportPath)");
                this.d = r11;
                this.e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
                String r12 = r7.optString("event_priority", "P2");
                Intrinsics.checkNotNullExpressionValue(r12, "json.optString(\"event_priority\", \"P2\")");
                this.f = r12;
                JSONObject r13 = r7.optJSONObject("filter");
                if (r13 == null) goto L5;
                d r14 = new d(r13);
            L6:
                this.g = r14;
                JSONArray r15 = r7.optJSONArray("support_event_types");
                if (r15 == null) goto L20;
                int r16 = r15.length();
                int r17 = 0;
            L9:
                if (r17 >= r16) goto L24;
                String r2 = r15.optString(r17);
                CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin");
                if (r3 != null) goto L13;
            L16:
                boolean r4 = true;
            L17:
                if (r4 == true) goto L19;
                List<String> r5 = this.e;
                Intrinsics.checkNotNullExpressionValue(r2, "type");
                Locale r6 = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(r6, "ROOT");
                String r18 = r2.toLowerCase(r6);
                Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String).toLowerCase(locale)");
                r5.add(r18);
            L19:
                r17 = r17 + 1;
                goto L9
            L13:
                if (r3.length() == 0) goto L16;
                r4 = false;
                goto L17
            L24:
                return;
            L20:
                return;
            L5:
                r14 = null;
                goto L6
            }

            public final int a() {
                return this.f1811a;
            }

            public final int b() {
                return this.f1812b;
            }

            public final String c() {
                return this.c;
            }

            public final String d() {
                return this.d;
            }

            public final List<String> e() {
                return this.e;
            }

            public final String f() {
                return this.f;
            }

            public final d g() {
                return this.g;
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tRq\u0010\n\u001ab\u0012\u0004\u0012\u00020\u0007\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\r0\f0\u000bj0\u0012\u0004\u0012\u00020\u0007\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000bj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\r0\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fRE\u0010\u0010\u001a6\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f0\u000bj\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerGroupFilter;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "events", "", "", "getEvents", "()Ljava/util/Set;", "paramKeyValues", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getParamKeyValues", "()Ljava/util/HashMap;", "paramKeys", "getParamKeys", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Set<String> f1813a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final HashMap<String, List<List<String>>> f1814b;
            private final HashMap<String, List<HashMap<String, String>>> c;

            public d(JSONObject r22) {
                Intrinsics.checkNotNullParameter(r22, "json");
                this.f1813a = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
                this.f1814b = new HashMap();
                this.c = new HashMap();
                JSONArray r2 = r22.optJSONArray("events");
                if (r2 == null) goto L16;
                int r6 = r2.length();
                int r7 = 0;
            L5:
                if (r7 >= r6) goto L16;
                String r8 = r2.optString(r7);
                CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin");
                if (r9 != null) goto L9;
            L12:
                boolean r10 = true;
            L13:
                if (r10 == true) goto L15;
                Set<String> r11 = this.f1813a;
                Intrinsics.checkNotNullExpressionValue(r8, "e");
                r11.add(r8);
            L15:
                r7 = r7 + 1;
                goto L5
            L9:
                if (r9.length() == 0) goto L12;
                r10 = false;
            L16:
                JSONObject r3 = r22.optJSONObject("param_keys");
                String r12 = EventBody.KEY_VALUE;
                if (r3 == null) goto L42;
                Iterator<String> r13 = r3.keys();
                Intrinsics.checkNotNullExpressionValue(r13, "it.keys()");
            L20:
                if (r13.hasNext() == false) goto L42;
                String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
                List r15 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
                JSONArray r16 = r3.optJSONArray(r14);
                if (r16 == null) goto L41;
                Intrinsics.checkNotNullExpressionValue(r16, "optJSONArray(key)");
                int r17 = r16.length();
                int r18 = 0;
            L24:
                if (r18 >= r17) goto L41;
                JSONArray r4 = r16.optJSONArray(r18);
                JSONObject r19 = r3;
                List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
                if (r4 == null) goto L40;
                Intrinsics.checkNotNullExpressionValue(r4, "andArr");
                int r20 = r4.length();
                int r110 = 0;
            L28:
                if (r110 >= r20) goto L40;
                int r111 = r20;
                String r21 = r4.optString(r110);
                JSONArray r23 = r4;
                CharSequence r24 = (CharSequence) ZeusTransformUtils.preCheckCast(r21, CharSequence.class, "com.obric.memorydata.plugin");
                if (r24 != null) goto L32;
            L35:
                boolean r25 = true;
            L36:
                if (r25 == true) goto L38;
                Intrinsics.checkNotNullExpressionValue(r21, EventBody.KEY_VALUE);
                r5.add(r21);
            L38:
                r110 = r110 + 1;
                r20 = r111;
                r4 = r23;
                goto L28
            L32:
                if (r24.length() == 0) goto L35;
                r25 = false;
            L40:
                r15.add(r5);
                r18 = r18 + 1;
                r3 = r19;
                r13 = r13;
            L41:
                JSONObject r112 = r3;
                Map r26 = (Map) ZeusTransformUtils.preCheckCast(this.f1814b, Map.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullExpressionValue(r14, "key");
                r26.put(r14, r15);
                r3 = r112;
                r13 = r13;
            L42:
                JSONObject r1 = r22.optJSONObject("param_key_values");
                if (r1 == null) goto L59;
                Iterator<String> r27 = r1.keys();
                Intrinsics.checkNotNullExpressionValue(r27, "it.keys()");
            L46:
                if (r27.hasNext() == false) goto L75;
                String r28 = (String) ZeusTransformUtils.preCheckCast(r27.next(), String.class, "com.obric.memorydata.plugin");
                List r29 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
                JSONArray r30 = r1.optJSONArray(r28);
                if (r30 == null) goto L58;
                Intrinsics.checkNotNullExpressionValue(r30, "optJSONArray(key)");
                int r113 = r30.length();
                int r114 = 0;
            L50:
                if (r114 >= r113) goto L58;
                JSONObject r115 = r30.optJSONObject(r114);
                HashMap r116 = new HashMap();
                if (r115 == null) goto L57;
                Intrinsics.checkNotNullExpressionValue(r115, r12);
                Iterator<String> r117 = r115.keys();
                Intrinsics.checkNotNullExpressionValue(r117, "v.keys()");
            L55:
                if (r117.hasNext() == false) goto L57;
                JSONObject r210 = r1;
                String r31 = (String) ZeusTransformUtils.preCheckCast(r117.next(), String.class, "com.obric.memorydata.plugin");
                Map r118 = (Map) ZeusTransformUtils.preCheckCast(r116, Map.class, "com.obric.memorydata.plugin");
                Iterator<String> r119 = r27;
                Intrinsics.checkNotNullExpressionValue(r31, "k");
                String r32 = r115.optString(r31);
                Intrinsics.checkNotNullExpressionValue(r32, "v.optString(k)");
                r118.put(r31, r32);
                r1 = r210;
                r27 = r119;
                r12 = r12;
            L57:
                r29.add(r116);
                r114 = r114 + 1;
                r1 = r1;
                r27 = r27;
                r12 = r12;
            L58:
                JSONObject r211 = r1;
                Map r33 = (Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullExpressionValue(r28, "key");
                r33.put(r28, r29);
                r1 = r211;
                r27 = r27;
                r12 = r12;
                goto L46
            L75:
                return;
            }

            public final Set<String> a() {
                return this.f1813a;
            }

            public final HashMap<String, List<List<String>>> b() {
                return this.f1814b;
            }

            public final HashMap<String, List<HashMap<String, String>>> c() {
                return this.c;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerGroups;", "", "json", "Lorg/json/JSONObject;", "defaultReportHost", "", "defaultReportPath", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "priorities", "", "Lcom/bytedance/applog/priority/original/Model$Ser$SerGroup;", "getPriorities", "()Ljava/util/List;", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final h f1815a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List<c> f1816b;

            public e(JSONObject r6, String r7, String r8) {
                Intrinsics.checkNotNullParameter(r6, "json");
                Intrinsics.checkNotNullParameter(r7, "defaultReportHost");
                Intrinsics.checkNotNullParameter(r8, "defaultReportPath");
                int r2 = 0;
                this.f1815a = new h(r6.optInt("version", 0), r6.optJSONArray("config_ids"));
                this.f1816b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
                JSONArray r9 = r6.optJSONArray("priorities");
                if (r9 == null) goto L10;
                int r0 = r9.length();
            L5:
                if (r2 >= r0) goto L14;
                JSONObject r1 = r9.optJSONObject(r2);
                if (r1 == null) goto L9;
                Intrinsics.checkNotNullExpressionValue(r1, "priority");
                this.f1816b.add(new c(r1, r7, r8));
            L9:
                r2 = r2 + 1;
                goto L5
            L14:
                return;
            }

            public final h a() {
                return this.f1815a;
            }

            public final List<c> b() {
                return this.f1816b;
            }
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfig;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "config", "Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfig;", "getConfig", "()Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfig;", "version", "Lcom/bytedance/applog/priority/original/Model$Version;", "getVersion", "()Lcom/bytedance/applog/priority/original/Model$Version;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final h f1817a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final C0104g f1818b;

            public f(JSONObject r4) {
                Intrinsics.checkNotNullParameter(r4, "json");
                this.f1817a = new h(r4.optInt("version", 0), r4.optJSONArray("config_ids"));
                JSONObject r5 = r4.optJSONObject("config");
                if (r5 != null) goto L5;
                r5 = new JSONObject();
            L5:
                this.f1818b = new C0104g(r5);
            }

            public final h a() {
                return this.f1817a;
            }

            public final C0104g b() {
                return this.f1818b;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.applog.priority.original.Model$g$g, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfig;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "p0", "Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfigItem;", "getP0", "()Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfigItem;", "p1", "getP1", "p2", "getP2", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class C0104g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final h f1819a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final h f1820b;
            private final h c;

            public C0104g(JSONObject r3) {
                Intrinsics.checkNotNullParameter(r3, "json");
                JSONObject r1 = r3.optJSONObject("P0");
                if (r1 != null) goto L5;
                r1 = new JSONObject();
            L5:
                this.f1819a = new h(r1);
                JSONObject r2 = r3.optJSONObject("P1");
                if (r2 != null) goto L8;
                r2 = new JSONObject();
            L8:
                this.f1820b = new h(r2);
                JSONObject r4 = r3.optJSONObject("P2");
                if (r4 != null) goto L11;
                r4 = new JSONObject();
            L11:
                this.c = new h(r4);
            }

            public final h a() {
                return this.f1819a;
            }

            public final h b() {
                return this.f1820b;
            }

            public final h c() {
                return this.c;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Ser$SerPriorityConfigConfigItem;", "", "json", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "eventTtl", "", "getEventTtl", "()J", "getJson", "()Lorg/json/JSONObject;", "maxEventSize", "getMaxEventSize", "maxRequestBodySize", "getMaxRequestBodySize", "maxRequestEventCnt", "", "getMaxRequestEventCnt", "()I", "getDefaultInt", "key", "", "defaultValue", "getDefaultLong", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final JSONObject f1821a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final long f1822b;
            private final long c;
            private final int d;
            private final long e;

            public h(JSONObject r3) {
                Intrinsics.checkNotNullParameter(r3, "json");
                this.f1821a = r3;
                this.f1822b = a("max_event_size", 1048576);
                this.c = a("max_request_body_size", 3145728);
                this.d = a("max_request_event_count", 2000);
                this.e = a("event_ttl", GuardFile.DEFAULT_EXPIRE_TIME);
            }

            private final int a(String r1, int r2) {
                int r0 = this.f1821a.optInt(r1);
                if (r0 <= 0) goto L5;
                return r0;
            L5:
                return r2;
            }

            private final long a(String r3, long r4) {
                long r2 = this.f1821a.optLong(r3);
                if (r2 <= 0) goto L5;
                return r2;
            L5:
                return r4;
            }

            public final long a() {
                return this.f1822b;
            }

            public final long b() {
                return this.c;
            }

            public final int c() {
                return this.d;
            }

            public final long d() {
                return this.e;
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Version;", "", "version", "", "configIds", "Lorg/json/JSONArray;", "(ILorg/json/JSONArray;)V", "getVersion", "()I", "isNewFrom", "", "other", "toJson", "Lorg/json/JSONObject;", "toJsonWithValue", EventBody.KEY_VALUE, "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1823a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1824b;
        private final JSONArray c;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/applog/priority/original/Model$Version$Companion;", "", "()V", "fromJson", "Lcom/bytedance/applog/priority/original/Model$Version;", "json", "Lorg/json/JSONObject;", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final h a(JSONObject r3) {
                Intrinsics.checkNotNullParameter(r3, "json");
                return new h(r3.optInt("version", 0), r3.optJSONArray("config_ids"));
            }
        }

        static {
            f1823a = new a(null);
        }

        public h(int r1, JSONArray r2) {
            this.f1824b = r1;
            this.c = r2;
        }

        public final JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("version", this.f1824b);
            JSONArray r3 = this.c;
            if (r3 == null) goto L5;
            r0.put("config_ids", r3);
        L5:
            return r0;
        }

        public final JSONObject a(Object r5) {
            Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
            JSONObject r1 = new JSONObject();
            r1.put("version", this.f1824b);
            r1.put(EventBody.KEY_VALUE, r5);
            JSONArray r4 = this.c;
            if (r4 == null) goto L5;
            r1.put("config_ids", r4);
        L5:
            return r1;
        }

        public final boolean a(h r5) {
            Intrinsics.checkNotNullParameter(r5, "other");
            int r0 = this.f1824b;
            int r1 = r5.f1824b;
            if (r0 <= r1) goto L6;
            return true;
        L6:
            if (r0 >= r1) goto L8;
            return false;
        L8:
            JSONArray r4 = this.c;
            String r2 = null;
            if (r4 == null) goto L11;
            String r6 = r4.toString();
        L12:
            JSONArray r7 = r5.c;
            if (r7 == null) goto L16;
            r2 = r7.toString();
        L16:
            if (Intrinsics.areEqual(r6, r2) == true) goto L18;
            return true;
        L18:
            return false;
        L11:
            r6 = null;
            goto L12
        }
    }
}
