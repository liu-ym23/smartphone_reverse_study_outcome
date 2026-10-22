package com.obric.memorydata.memory.api;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0006\u0012\u0013\u0014\u0015\u0016\u0017J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildApi;", "Lcom/bytedance/news/common/service/manager/IService;", "insertProactiveSemanticRelevantData", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveSemanticRelevantDataParams;", "insertProactiveEpisodicRelevantData", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveEpisodicRelevantDataParams;", "hasMemorySource", "", "productType", "", "trackNewProactiveMemory", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$TrackNewProactiveMemoryParams;", "resolveProactiveSourceLinkBySession", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$SourceLinkInfo;", ObricMemoryConstants.KEY_SESSION_ID, "", "Action", "InsertProactiveSemanticRelevantDataParams", "InsertProactiveEpisodicRelevantDataParams", "SourceLinkInfo", "TrackNewProactiveMemoryParams", "Schedule", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryBuildApi extends IService {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "INSERT", "UPDATE", "INSERT_SNAPSHOT", "UPDATE_SNAPSHOT", "UNKNOWN", "isSnapshotAction", "", "Companion", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Action extends Enum<Action> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final a Companion = null;
        public static final Action INSERT = null;
        public static final Action INSERT_SNAPSHOT = null;
        public static final Action UNKNOWN = null;
        public static final Action UPDATE = null;
        public static final Action UPDATE_SNAPSHOT = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action$Companion;", "", "<init>", "()V", "fromValue", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", EventBody.KEY_VALUE, "", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker r1) {
                this();
            }

            public final Action a(String r5) {
                Action[] r4 = Action.values();
                int r0 = r4.length;
                int r1 = 0;
            L3:
                if (r1 >= r0) goto L8;
                Action r2 = r4[r1];
                if (Intrinsics.areEqual(r2.getValue(), r5) == true) goto L9;
                r1 = r1 + 1;
            L9:
                if (r2 == null) goto L11;
                return r2;
            L11:
                return Action.UNKNOWN;
            L8:
                r2 = null;
                goto L9
            }
        }

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{INSERT, UPDATE, INSERT_SNAPSHOT, UPDATE_SNAPSHOT, UNKNOWN};
        }

        static {
            INSERT = new Action("INSERT", 0, "insert");
            UPDATE = new Action("UPDATE", 1, com.obric.memorydata.BuildConfig.CHANNEL);
            INSERT_SNAPSHOT = new Action("INSERT_SNAPSHOT", 2, "insert_snapshot");
            UPDATE_SNAPSHOT = new Action("UPDATE_SNAPSHOT", 3, "update_snapshot");
            UNKNOWN = new Action("UNKNOWN", 4, "unknown");
            Action[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
            Companion = new a(null);
        }

        private Action(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }

        public static EnumEntries<Action> getEntries() {
            return $ENTRIES;
        }

        public static Action valueOf(String r2) {
            return (Action) ZeusTransformUtils.preCheckCast(Enum.valueOf(Action.class, r2), Action.class, "com.obric.memorydata.plugin");
        }

        public static Action[] values() {
            return (Action[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Action[].class, "com.obric.memorydata.plugin");
        }

        public final String getValue() {
            return this.value;
        }

        public final boolean isSnapshotAction() {
            if (this != INSERT_SNAPSHOT) goto L5;
        L8:
            return true;
        L5:
            if (this == UPDATE_SNAPSHOT) goto L8;
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildApi$Schedule;", "", "scheduleType", "", "startTime", "", "endTime", "title", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getScheduleType", "()Ljava/lang/String;", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getTitle", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Schedule {
        private final Long endTime;
        private final String scheduleType;
        private final Long startTime;
        private final String title;

        public Schedule(String r2, Long r3, Long r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "scheduleType");
            Intrinsics.checkNotNullParameter(r5, "title");
            this.scheduleType = r2;
            this.startTime = r3;
            this.endTime = r4;
            this.title = r5;
        }

        public final Long getEndTime() {
            return this.endTime;
        }

        public final String getScheduleType() {
            return this.scheduleType;
        }

        public final Long getStartTime() {
            return this.startTime;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\tHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u00106\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0018\u00010\u0013HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0016HÆ\u0003J¯\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0013\u0010:\u001a\u00020\u00162\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0007HÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001aR%\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010+¨\u0006>"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveEpisodicRelevantDataParams;", "", ObricMemoryConstants.KEY_SESSION_ID, "", "entityId", "memoryUuid", "entityType", "", "createTime", "", "modifyTime", "action", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", Params.CONTENT, "schedules", "", "Lcom/obric/memorydata/memory/api/MemoryBuildApi$Schedule;", LocationMonitorConst.TAG, "keyInfoMap", "", "contentFrom", "isNewEntity", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJJLcom/obric/memorydata/memory/api/MemoryBuildApi$Action;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Z)V", "getSessionId", "()Ljava/lang/String;", "getEntityId", "getMemoryUuid", "getEntityType", "()I", "getCreateTime", "()J", "getModifyTime", "getAction", "()Lcom/obric/memorydata/memory/api/MemoryBuildApi$Action;", "getContent", "getSchedules", "()Ljava/util/List;", "getTag", "getKeyInfoMap", "()Ljava/util/Map;", "getContentFrom", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "toString", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10051b;
        private final String c;
        private final int d;
        private final long e;
        private final long f;
        private final Action g;
        private final String h;
        private final List<Schedule> i;
        private final String j;
        private final Map<String, List<String>> k;
        private final String l;
        private final boolean m;

        public a(String r9, String r10, String r11, int r12, long r13, long r15, Action r17, String r18, List<Schedule> r19, String r20, Map<String, ? extends List<String>> r21, String r22, boolean r23) {
            List<Schedule> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            Map<String, List<String>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_SESSION_ID);
            Intrinsics.checkNotNullParameter(r10, "entityId");
            Intrinsics.checkNotNullParameter(r17, "action");
            this.f10050a = r9;
            this.f10051b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r15;
            this.g = r17;
            this.h = r18;
            this.i = r4;
            this.j = r20;
            this.k = r5;
            this.l = r22;
            this.m = r23;
        }

        public final String a() {
            return this.f10050a;
        }

        public final String b() {
            return this.f10051b;
        }

        public final String c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10050a, r10.f10050a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10051b, r10.f10051b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r10.l) == true) goto L45;
            return false;
        L45:
            if (this.m == r10.m) goto L47;
            return false;
        L47:
            return true;
        }

        public final long f() {
            return this.f;
        }

        public final Action g() {
            return this.g;
        }

        public final String h() {
            return this.h;
        }

        public int hashCode() {
            int r0 = ((this.f10050a.hashCode() * 31) + this.f10051b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((((((r0 + r3) * 31) + Integer.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31;
            String r5 = this.h;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            List<Schedule> r8 = this.i;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.j;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Map<String, List<String>> r14 = this.k;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.l;
            if (r17 == null) goto L27;
            r2 = r17.hashCode();
        L27:
            return ((r16 + r2) * 31) + Boolean.hashCode(this.m);
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final List<Schedule> i() {
            return this.i;
        }

        public final String j() {
            return this.j;
        }

        public final Map<String, List<String>> k() {
            return this.k;
        }

        public final String l() {
            return this.l;
        }

        public final boolean m() {
            return this.m;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("InsertProactiveEpisodicRelevantDataParams(sessionId=").append(this.f10050a).append(", entityId=").append(this.f10051b).append(", memoryUuid=").append(this.c).append(", entityType=").append(this.d).append(", createTime=").append(this.e).append(", modifyTime=").append(this.f).append(", action=").append(this.g).append(", content=").append(this.h).append(", schedules=").append(this.i).append(", tag=").append(this.j).append(", keyInfoMap=").append(this.k).append(", contentFrom=");
            r0.append(this.l).append(", isNewEntity=").append(this.m).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0086\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010.J\u0013\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014¨\u00064"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveSemanticRelevantDataParams;", "", ObricMemoryConstants.KEY_SESSION_ID, "", "entityId", "memoryUuid", "createTime", "", "modifyTime", "semanticType", "contentFrom", "isNewEntity", "", "confidenceScore", "", "previousConfidenceScore", "memoryTag", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getEntityId", "getMemoryUuid", "getCreateTime", "()J", "getModifyTime", "getSemanticType", "getContentFrom", "()Z", "getConfidenceScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPreviousConfidenceScore", "getMemoryTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;ZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lcom/obric/memorydata/memory/api/MemoryBuildApi$InsertProactiveSemanticRelevantDataParams;", "equals", "other", "hashCode", "", "toString", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10053b;
        private final String c;
        private final long d;
        private final long e;
        private final String f;
        private final String g;
        private final boolean h;
        private final Float i;
        private final Float j;
        private final String k;

        public b(String r2, String r3, String r4, long r5, long r7, String r9, String r10, boolean r11, Float r12, Float r13, String r14) {
            Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_SESSION_ID);
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r9, "semanticType");
            this.f10052a = r2;
            this.f10053b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r7;
            this.f = r9;
            this.g = r10;
            this.h = r11;
            this.i = r12;
            this.j = r13;
            this.k = r14;
        }

        public final String a() {
            return this.f10052a;
        }

        public final String b() {
            return this.f10053b;
        }

        public final String c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final long e() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10052a, r10.f10052a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10053b, r10.f10053b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (this.e == r10.e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r10.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final String f() {
            return this.f;
        }

        public final String g() {
            return this.g;
        }

        public final boolean h() {
            return this.h;
        }

        public int hashCode() {
            int r0 = ((this.f10052a.hashCode() * 31) + this.f10053b.hashCode()) * 31;
            String r1 = this.c;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((((r0 + r3) * 31) + Long.hashCode(this.d)) * 31) + Long.hashCode(this.e)) * 31) + this.f.hashCode()) * 31;
            String r5 = this.g;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (((r4 + r6) * 31) + Boolean.hashCode(this.h)) * 31;
            Float r8 = this.i;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Float r11 = this.j;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.k;
            if (r14 == null) goto L23;
            r2 = r14.hashCode();
        L23:
            return r13 + r2;
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final Float i() {
            return this.i;
        }

        public final Float j() {
            return this.j;
        }

        public final String k() {
            return this.k;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("InsertProactiveSemanticRelevantDataParams(sessionId=").append(this.f10052a).append(", entityId=").append(this.f10053b).append(", memoryUuid=").append(this.c).append(", createTime=").append(this.d).append(", modifyTime=").append(this.e).append(", semanticType=").append(this.f).append(", contentFrom=").append(this.g).append(", isNewEntity=").append(this.h).append(", confidenceScore=").append(this.i).append(", previousConfidenceScore=").append(this.j).append(", memoryTag=").append(this.k).append(')');
            return r0.toString();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildApi$SourceLinkInfo;", "", "sourceLink", "", "sourceLinkType", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSourceLink", "()Ljava/lang/String;", "getSourceLinkType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10055b;

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "sourceLink");
            this.f10054a = r2;
            this.f10055b = r3;
        }

        public final String a() {
            return this.f10054a;
        }

        public final String b() {
            return this.f10055b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10054a, r6.f10054a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f10055b, r6.f10055b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f10054a.hashCode() * 31;
            String r1 = this.f10055b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "SourceLinkInfo(sourceLink=" + this.f10054a + ", sourceLinkType=" + this.f10055b + ')';
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\rHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0092\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\r2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0005HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010#\u001a\u0004\b$\u0010\"R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u00068"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildApi$TrackNewProactiveMemoryParams;", "", Api.KEY_UUID, "", "sourceProductType", "", "sourcePackageName", "type", LocationMonitorConst.TAG, "createTime", "", "modifyTime", "isNewEntity", "", "forceAddNew", "confidenceScore", "", "previousConfidenceScore", "memoryTag", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JJZZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)V", "getUuid", "()Ljava/lang/String;", "getSourceProductType", "()I", "getSourcePackageName", "getType", "getTag", "getCreateTime", "()J", "getModifyTime", "()Z", "getForceAddNew", "getConfidenceScore", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getPreviousConfidenceScore", "getMemoryTag", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JJZZLjava/lang/Float;Ljava/lang/Float;Ljava/lang/String;)Lcom/obric/memorydata/memory/api/MemoryBuildApi$TrackNewProactiveMemoryParams;", "equals", "other", "hashCode", "toString", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10057b;
        private final String c;
        private final int d;
        private final String e;
        private final long f;
        private final long g;
        private final boolean h;
        private final boolean i;
        private final Float j;
        private final Float k;
        private final String l;

        public d(String r1, int r2, String r3, int r4, String r5, long r6, long r8, boolean r10, boolean r11, Float r12, Float r13, String r14) {
            this.f10056a = r1;
            this.f10057b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r8;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
            this.l = r14;
        }

        public /* synthetic */ d(String r18, int r19, String r20, int r21, String r22, long r23, long r25, boolean r27, boolean r28, Float r29, Float r30, String r31, int r32, DefaultConstructorMarker r33) {
            if ((r32 & 256) == 0) goto L5;
            boolean r13 = false;
        L7:
            if ((r32 & 512) == 0) goto L9;
            Float r14 = null;
        L11:
            if ((r32 & 1024) == 0) goto L13;
            Float r15 = null;
        L15:
            if ((r32 & 2048) == 0) goto L17;
            String r16 = null;
        L18:
            this(r18, r19, r20, r21, r22, r23, r25, r27, r13, r14, r15, r16);
            return;
        L17:
            r16 = r31;
            goto L18
        L13:
            r15 = r30;
            goto L15
        L9:
            r14 = r29;
            goto L11
        L5:
            r13 = r28;
            goto L7
        }

        public static /* synthetic */ d a(d r15, String r16, int r17, String r18, int r19, String r20, long r21, long r23, boolean r25, boolean r26, Float r27, Float r28, String r29, int r30, Object r31) {
            if ((r30 & 1) == 0) goto L5;
            String r2 = r15.f10056a;
        L7:
            if ((r30 & 2) == 0) goto L9;
            int r3 = r15.f10057b;
        L11:
            if ((r30 & 4) == 0) goto L13;
            String r4 = r15.c;
        L15:
            if ((r30 & 8) == 0) goto L17;
            int r5 = r15.d;
        L19:
            if ((r30 & 16) == 0) goto L21;
            String r6 = r15.e;
        L23:
            if ((r30 & 32) == 0) goto L25;
            long r7 = r15.f;
        L27:
            if ((r30 & 64) == 0) goto L29;
            long r9 = r15.g;
        L31:
            if ((r30 & 128) == 0) goto L33;
            boolean r11 = r15.h;
        L35:
            if ((r30 & 256) == 0) goto L37;
            boolean r12 = r15.i;
        L39:
            if ((r30 & 512) == 0) goto L41;
            Float r13 = r15.j;
        L43:
            if ((r30 & 1024) == 0) goto L45;
            Float r14 = r15.k;
        L47:
            if ((r30 & 2048) == 0) goto L49;
            String r1 = r15.l;
        L51:
            return r15.a(r2, r3, r4, r5, r6, r7, r9, r11, r12, r13, r14, r1);
        L49:
            r1 = r29;
            goto L51
        L45:
            r14 = r28;
            goto L47
        L41:
            r13 = r27;
            goto L43
        L37:
            r12 = r26;
            goto L39
        L33:
            r11 = r25;
            goto L35
        L29:
            r9 = r23;
            goto L31
        L25:
            r7 = r21;
            goto L27
        L21:
            r6 = r20;
            goto L23
        L17:
            r5 = r19;
            goto L19
        L13:
            r4 = r18;
            goto L15
        L9:
            r3 = r17;
            goto L11
        L5:
            r2 = r16;
            goto L7
        }

        public final d a(String r17, int r18, String r19, int r20, String r21, long r22, long r24, boolean r26, boolean r27, Float r28, Float r29, String r30) {
            return new d(r17, r18, r19, r20, r21, r22, r24, r26, r27, r28, r29, r30);
        }

        public final String a() {
            return this.f10056a;
        }

        public final int b() {
            return this.f10057b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.e;
        }

        public final long e() {
            return this.f;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10056a, r10.f10056a) == true) goto L12;
            return false;
        L12:
            if (this.f10057b == r10.f10057b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L33;
            return false;
        L33:
            if (this.i == r10.i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r10.l) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final long f() {
            return this.g;
        }

        public final boolean g() {
            return this.h;
        }

        public final int getType() {
            return this.d;
        }

        public final boolean h() {
            return this.i;
        }

        public int hashCode() {
            String r0 = this.f10056a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + Integer.hashCode(this.f10057b)) * 31;
            String r4 = this.c;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.d)) * 31;
            String r7 = this.e;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((((((((r6 + r8) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31) + Boolean.hashCode(this.h)) * 31) + Boolean.hashCode(this.i)) * 31;
            Float r10 = this.j;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            Float r13 = this.k;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.l;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final Float i() {
            return this.j;
        }

        public final Float j() {
            return this.k;
        }

        public final String k() {
            return this.l;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("TrackNewProactiveMemoryParams(uuid=").append(this.f10056a).append(", sourceProductType=").append(this.f10057b).append(", sourcePackageName=").append(this.c).append(", type=").append(this.d).append(", tag=").append(this.e).append(", createTime=").append(this.f).append(", modifyTime=").append(this.g).append(", isNewEntity=").append(this.h).append(", forceAddNew=").append(this.i).append(", confidenceScore=").append(this.j).append(", previousConfidenceScore=").append(this.k).append(", memoryTag=");
            r0.append(this.l).append(')');
            return r0.toString();
        }
    }

    boolean hasMemorySource(int r1);

    void insertProactiveEpisodicRelevantData(a r1);

    void insertProactiveSemanticRelevantData(b r1);

    c resolveProactiveSourceLinkBySession(String r1);

    void trackNewProactiveMemory(d r1);
}
