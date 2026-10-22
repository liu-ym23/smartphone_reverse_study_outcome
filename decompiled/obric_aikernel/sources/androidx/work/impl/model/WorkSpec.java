package androidx.work.impl.model;

import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.Relation;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Entity(indices = {@Index({"schedule_requested_at"}), @Index({"last_enqueue_time"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkSpec {
    public static final Companion Companion = null;
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG = null;

    @JvmField
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = null;

    @JvmField
    @ColumnInfo(name = "backoff_delay_duration")
    public long backoffDelayDuration;

    @JvmField
    @ColumnInfo(name = "backoff_policy")
    public BackoffPolicy backoffPolicy;

    @Embedded
    @JvmField
    public Constraints constraints;

    @JvmField
    @ColumnInfo(name = "run_in_foreground")
    public boolean expedited;

    @JvmField
    @ColumnInfo(name = "flex_duration")
    public long flexDuration;

    @ColumnInfo(defaultValue = NetConst.NOT_ENCRYPT_VERISON_CODE)
    private final int generation;

    @PrimaryKey
    @JvmField
    @ColumnInfo(name = OaidModel.KEY_ID)
    public final String id;

    @JvmField
    @ColumnInfo(name = "initial_delay")
    public long initialDelay;

    @JvmField
    @ColumnInfo(name = "input")
    public Data input;

    @JvmField
    @ColumnInfo(name = "input_merger_class_name")
    public String inputMergerClassName;

    @JvmField
    @ColumnInfo(name = "interval_duration")
    public long intervalDuration;

    @JvmField
    @ColumnInfo(name = "last_enqueue_time")
    public long lastEnqueueTime;

    @JvmField
    @ColumnInfo(name = "minimum_retention_duration")
    public long minimumRetentionDuration;

    @JvmField
    @ColumnInfo(name = "out_of_quota_policy")
    public OutOfQuotaPolicy outOfQuotaPolicy;

    @JvmField
    @ColumnInfo(name = "output")
    public Data output;

    @ColumnInfo(defaultValue = NetConst.NOT_ENCRYPT_VERISON_CODE, name = "period_count")
    private int periodCount;

    @JvmField
    @ColumnInfo(name = "run_attempt_count")
    public int runAttemptCount;

    @JvmField
    @ColumnInfo(name = "schedule_requested_at")
    public long scheduleRequestedAt;

    @JvmField
    @ColumnInfo(name = "state")
    public WorkInfo.State state;

    @JvmField
    @ColumnInfo(name = "worker_class_name")
    public String workerClassName;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class IdAndState {

        @JvmField
        @ColumnInfo(name = OaidModel.KEY_ID)
        public String id;

        @JvmField
        @ColumnInfo(name = "state")
        public WorkInfo.State state;

        public IdAndState(String r10, WorkInfo.State r11) {
            Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r11, "state");
            this.id = r10;
            this.state = r11;
        }

        public static /* synthetic */ IdAndState copy$default(IdAndState r10, String r11, WorkInfo.State r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r11 = r10.id;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r12 = r10.state;
        L9:
            return r10.copy(r11, r12);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final IdAndState copy(String r10, WorkInfo.State r11) {
            Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r11, "state");
            return new IdAndState(r10, r11);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof IdAndState) == true) goto L8;
            return false;
        L8:
            IdAndState r11 = (IdAndState) r10;
            if (Intrinsics.areEqual(this.id, r11.id) == true) goto L12;
            return false;
        L12:
            if (this.state == r11.state) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }
    }

    public static final class WorkInfoPojo {

        @ColumnInfo(name = "generation")
        private final int generation;

        @ColumnInfo(name = OaidModel.KEY_ID)
        private String id;

        @ColumnInfo(name = "output")
        private Data output;

        @Relation(entity = WorkProgress.class, entityColumn = "work_spec_id", parentColumn = OaidModel.KEY_ID, projection = {"progress"})
        private List<Data> progress;

        @ColumnInfo(name = "run_attempt_count")
        private int runAttemptCount;

        @ColumnInfo(name = "state")
        private WorkInfo.State state;

        @Relation(entity = WorkTag.class, entityColumn = "work_spec_id", parentColumn = OaidModel.KEY_ID, projection = {"tag"})
        private List<String> tags;

        public WorkInfoPojo(String r10, WorkInfo.State r11, Data r12, int r13, int r14, List<String> r15, List<Data> r16) {
            Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r11, "state");
            Intrinsics.checkNotNullParameter(r12, "output");
            Intrinsics.checkNotNullParameter(r15, "tags");
            Intrinsics.checkNotNullParameter(r16, "progress");
            this.id = r10;
            this.state = r11;
            this.output = r12;
            this.runAttemptCount = r13;
            this.generation = r14;
            this.tags = r15;
            this.progress = r16;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo r10, String r11, WorkInfo.State r12, Data r13, int r14, int r15, List r16, List r17, int r18, Object r19) {
            if ((r18 & 1) == 0) goto L6;
            r11 = r10.id;
        L6:
            if ((r18 & 2) == 0) goto L8;
            r12 = r10.state;
        L8:
            WorkInfo.State r110 = r12;
            if ((r18 & 4) == 0) goto L11;
            r13 = r10.output;
        L11:
            Data r20 = r13;
            if ((r18 & 8) == 0) goto L14;
            r14 = r10.runAttemptCount;
        L14:
            int r21 = r14;
            if ((r18 & 16) == 0) goto L17;
            r15 = r10.generation;
        L17:
            int r22 = r15;
            if ((r18 & 32) == 0) goto L20;
            r16 = r10.tags;
        L20:
            List r23 = r16;
            if ((r18 & 64) == 0) goto L23;
            r17 = r10.progress;
        L23:
            String r24 = r11;
            return r10.copy(r24, r110, r20, r21, r22, r23, r17);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final int component4() {
            return this.runAttemptCount;
        }

        public final int component5() {
            return this.generation;
        }

        public final List<String> component6() {
            return this.tags;
        }

        public final List<Data> component7() {
            return this.progress;
        }

        public final WorkInfoPojo copy(String r10, WorkInfo.State r11, Data r12, int r13, int r14, List<String> r15, List<Data> r16) {
            Intrinsics.checkNotNullParameter(r10, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r11, "state");
            Intrinsics.checkNotNullParameter(r12, "output");
            Intrinsics.checkNotNullParameter(r15, "tags");
            Intrinsics.checkNotNullParameter(r16, "progress");
            return new WorkInfoPojo(r10, r11, r12, r13, r14, r15, r16);
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof WorkInfoPojo) == true) goto L8;
            return false;
        L8:
            WorkInfoPojo r11 = (WorkInfoPojo) r10;
            if (Intrinsics.areEqual(this.id, r11.id) == true) goto L12;
            return false;
        L12:
            if (this.state == r11.state) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.output, r11.output) == true) goto L18;
            return false;
        L18:
            if (this.runAttemptCount == r11.runAttemptCount) goto L21;
            return false;
        L21:
            if (this.generation == r11.generation) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.tags, r11.tags) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.progress, r11.progress) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final String getId() {
            return this.id;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public int hashCode() {
            return (((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + Integer.hashCode(this.runAttemptCount)) * 31) + Integer.hashCode(this.generation)) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public final void setId(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.id = r10;
        }

        public final void setOutput(Data r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.output = r10;
        }

        public final void setProgress(List<Data> r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.progress = r10;
        }

        public final void setRunAttemptCount(int r10) {
            this.runAttemptCount = r10;
        }

        public final void setState(WorkInfo.State r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.state = r10;
        }

        public final void setTags(List<String> r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.tags = r10;
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public final WorkInfo toWorkInfo() {
            if ((!this.progress.isEmpty()) == false) goto L5;
            Data r10 = this.progress.get(0);
        L7:
            return new WorkInfo(UUID.fromString(this.id), this.state, this.output, this.tags, r10, this.runAttemptCount, this.generation);
        L5:
            r10 = Data.EMPTY;
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
        String r10 = Logger.tagWithPrefix("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"WorkSpec\")");
        TAG = r10;
        WORK_INFO_MAPPER = a.f481a;
    }

    public WorkSpec(String r11, WorkInfo.State r12, String r13, String r14, Data r15, Data r16, long r17, long r19, long r21, Constraints r23, @IntRange(from = 0) int r24, BackoffPolicy r25, long r26, long r28, long r30, long r32, boolean r34, OutOfQuotaPolicy r35, int r36, int r37) {
        Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r12, "state");
        Intrinsics.checkNotNullParameter(r13, "workerClassName");
        Intrinsics.checkNotNullParameter(r15, "input");
        Intrinsics.checkNotNullParameter(r16, "output");
        Intrinsics.checkNotNullParameter(r23, "constraints");
        Intrinsics.checkNotNullParameter(r25, "backoffPolicy");
        Intrinsics.checkNotNullParameter(r35, "outOfQuotaPolicy");
        this.id = r11;
        this.state = r12;
        this.workerClassName = r13;
        this.inputMergerClassName = r14;
        this.input = r15;
        this.output = r16;
        this.initialDelay = r17;
        this.intervalDuration = r19;
        this.flexDuration = r21;
        this.constraints = r23;
        this.runAttemptCount = r24;
        this.backoffPolicy = r25;
        this.backoffDelayDuration = r26;
        this.lastEnqueueTime = r28;
        this.minimumRetentionDuration = r30;
        this.scheduleRequestedAt = r32;
        this.expedited = r34;
        this.outOfQuotaPolicy = r35;
        this.periodCount = r36;
        this.generation = r37;
    }

    public /* synthetic */ WorkSpec(String r31, WorkInfo.State r32, String r33, String r34, Data r35, Data r36, long r37, long r39, long r41, Constraints r43, int r44, BackoffPolicy r45, long r46, long r48, long r50, long r52, boolean r54, OutOfQuotaPolicy r55, int r56, int r57, int r58, DefaultConstructorMarker r59) {
        if ((r58 & 2) == 0) goto L5;
        WorkInfo.State r10 = WorkInfo.State.ENQUEUED;
    L7:
        if ((r58 & 8) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r58 & 16) == 0) goto L13;
        Data r12 = Data.EMPTY;
        Intrinsics.checkNotNullExpressionValue(r12, "EMPTY");
        Data r13 = r12;
    L15:
        if ((r58 & 32) == 0) goto L17;
        Data r14 = Data.EMPTY;
        Intrinsics.checkNotNullExpressionValue(r14, "EMPTY");
        Data r15 = r14;
    L19:
        if ((r58 & 64) == 0) goto L21;
        long r16 = 0;
    L23:
        if ((r58 & 128) == 0) goto L25;
        long r17 = 0;
    L27:
        if ((r58 & 256) == 0) goto L29;
        long r18 = 0;
    L31:
        if ((r58 & 512) == 0) goto L33;
        Constraints r19 = Constraints.NONE;
    L35:
        if ((r58 & 1024) == 0) goto L37;
        int r110 = 0;
    L39:
        if ((r58 & 2048) == 0) goto L41;
        BackoffPolicy r111 = BackoffPolicy.EXPONENTIAL;
    L43:
        if ((r58 & 4096) == 0) goto L45;
        long r112 = WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    L47:
        if ((r58 & 8192) == 0) goto L49;
        long r20 = 0;
    L51:
        if ((r58 & 16384) == 0) goto L53;
        long r22 = 0;
    L55:
        if ((32768 & r58) == 0) goto L57;
        long r24 = -1;
    L59:
        if ((65536 & r58) == 0) goto L61;
        boolean r26 = false;
    L63:
        if ((131072 & r58) == 0) goto L65;
        OutOfQuotaPolicy r27 = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    L67:
        if ((262144 & r58) == 0) goto L69;
        int r28 = 0;
    L71:
        if ((r58 & 524288) == 0) goto L73;
        int r29 = 0;
    L74:
        this(r31, r10, r33, r11, r13, r15, r16, r17, r18, r19, r110, r111, r112, r20, r22, r24, r26, r27, r28, r29);
        return;
    L73:
        r29 = r57;
        goto L74
    L69:
        r28 = r56;
        goto L71
    L65:
        r27 = r55;
        goto L67
    L61:
        r26 = r54;
        goto L63
    L57:
        r24 = r52;
        goto L59
    L53:
        r22 = r50;
        goto L55
    L49:
        r20 = r48;
        goto L51
    L45:
        r112 = r46;
        goto L47
    L41:
        r111 = r45;
        goto L43
    L37:
        r110 = r44;
        goto L39
    L33:
        r19 = r43;
        goto L35
    L29:
        r18 = r41;
        goto L31
    L25:
        r17 = r39;
        goto L27
    L21:
        r16 = r37;
        goto L23
    L17:
        r15 = r36;
        goto L19
    L13:
        r13 = r35;
        goto L15
    L9:
        r11 = r34;
        goto L11
    L5:
        r10 = r32;
        goto L7
    }

    public WorkSpec(String r33, WorkSpec r34) {
        Intrinsics.checkNotNullParameter(r33, "newId");
        Intrinsics.checkNotNullParameter(r34, "other");
        String r10 = r34.workerClassName;
        this(r33, r34.state, r10, r34.inputMergerClassName, new Data(r34.input), new Data(r34.output), r34.initialDelay, r34.intervalDuration, r34.flexDuration, new Constraints(r34.constraints), r34.runAttemptCount, r34.backoffPolicy, r34.backoffDelayDuration, r34.lastEnqueueTime, r34.minimumRetentionDuration, r34.scheduleRequestedAt, r34.expedited, r34.outOfQuotaPolicy, r34.periodCount, 0, 524288, null);
    }

    public WorkSpec(String r31, String r32) {
        Intrinsics.checkNotNullParameter(r31, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r32, "workerClassName_");
        this(r31, null, r32, null, null, null, 0, 0, 0, null, 0, null, 0, 0, 0, 0, false, null, 0, 0, 1048570, null);
    }

    private static final List WORK_INFO_MAPPER$lambda$1(List r10) {
        if (r10 == null) goto L7;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L5:
        if (r12.hasNext() == false) goto L10;
        r11.add(((WorkInfoPojo) r12.next()).toWorkInfo());
        goto L5
    L10:
        return r11;
    L7:
        return null;
    }

    public static /* synthetic */ List a(List r10) {
        return WORK_INFO_MAPPER$lambda$1(r10);
    }

    public static /* synthetic */ WorkSpec copy$default(WorkSpec r17, String r18, WorkInfo.State r19, String r20, String r21, Data r22, Data r23, long r24, long r26, long r28, Constraints r30, int r31, BackoffPolicy r32, long r33, long r35, long r37, long r39, boolean r41, OutOfQuotaPolicy r42, int r43, int r44, int r45, Object r46) {
        if ((r45 & 1) == 0) goto L5;
        String r10 = r17.id;
    L7:
        if ((r45 & 2) == 0) goto L9;
        WorkInfo.State r11 = r17.state;
    L11:
        if ((r45 & 4) == 0) goto L13;
        String r12 = r17.workerClassName;
    L15:
        if ((r45 & 8) == 0) goto L17;
        String r13 = r17.inputMergerClassName;
    L19:
        if ((r45 & 16) == 0) goto L21;
        Data r14 = r17.input;
    L23:
        if ((r45 & 32) == 0) goto L25;
        Data r15 = r17.output;
    L27:
        if ((r45 & 64) == 0) goto L29;
        long r16 = r17.initialDelay;
    L31:
        if ((r45 & 128) == 0) goto L33;
        long r110 = r17.intervalDuration;
    L35:
        if ((r45 & 256) == 0) goto L37;
        long r111 = r17.flexDuration;
    L39:
        if ((r45 & 512) == 0) goto L41;
        Constraints r112 = r17.constraints;
    L43:
        if ((r45 & 1024) == 0) goto L45;
        int r113 = r17.runAttemptCount;
    L46:
        int r34 = r113;
        if ((r45 & 2048) == 0) goto L49;
        BackoffPolicy r114 = r17.backoffPolicy;
    L50:
        BackoffPolicy r36 = r114;
        Constraints r38 = r112;
        if ((r45 & 4096) == 0) goto L53;
        long r115 = r17.backoffDelayDuration;
    L54:
        long r310 = r115;
        if ((r45 & 8192) == 0) goto L57;
        long r116 = r17.lastEnqueueTime;
    L58:
        long r311 = r116;
        if ((r45 & 16384) == 0) goto L61;
        long r117 = r17.minimumRetentionDuration;
    L62:
        long r312 = r117;
        if ((r45 & 32768) == 0) goto L65;
        long r118 = r17.scheduleRequestedAt;
    L66:
        long r313 = r118;
        if ((r45 & 65536) == 0) goto L69;
        boolean r119 = r17.expedited;
    L71:
        if ((131072 & r45) == 0) goto L73;
        OutOfQuotaPolicy r120 = r17.outOfQuotaPolicy;
    L74:
        OutOfQuotaPolicy r47 = r120;
        if ((r45 & 262144) == 0) goto L77;
        int r121 = r17.periodCount;
    L79:
        if ((r45 & 524288) == 0) goto L81;
        int r25 = r17.generation;
    L83:
        return r17.copy(r10, r11, r12, r13, r14, r15, r16, r110, r111, r38, r34, r36, r310, r311, r312, r313, r119, r47, r121, r25);
    L81:
        r25 = r44;
        goto L83
    L77:
        r121 = r43;
        goto L79
    L73:
        r120 = r42;
        goto L74
    L69:
        r119 = r41;
        goto L71
    L65:
        r118 = r39;
        goto L66
    L61:
        r117 = r37;
        goto L62
    L57:
        r116 = r35;
        goto L58
    L53:
        r115 = r33;
        goto L54
    L49:
        r114 = r32;
        goto L50
    L45:
        r113 = r31;
        goto L46
    L41:
        r112 = r30;
        goto L43
    L37:
        r111 = r28;
        goto L39
    L33:
        r110 = r26;
        goto L35
    L29:
        r16 = r24;
        goto L31
    L25:
        r15 = r23;
        goto L27
    L21:
        r14 = r22;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    public final long calculateNextRunTime() {
        boolean r10 = false;
        if (isBackedOff() == true) goto L5;
        long r11 = 0;
        if (isPeriodic() == false) goto L27;
        int r12 = this.periodCount;
        long r13 = this.lastEnqueueTime;
        if (r12 != 0) goto L16;
        r13 = r13 + this.initialDelay;
    L16:
        long r14 = this.flexDuration;
        long r15 = this.intervalDuration;
        if (r14 == r15) goto L19;
        r10 = true;
    L19:
        if (r10 == false) goto L23;
        if (r12 != 0) goto L22;
        r11 = ((long) (-1)) * r14;
    L22:
        r13 = r13 + r15;
    L33:
        return r13 + r11;
    L23:
        if (r12 == 0) goto L33;
        r11 = r15;
        goto L33
    L27:
        long r16 = this.lastEnqueueTime;
        if (r16 != 0) goto L31;
        r16 = System.currentTimeMillis();
    L31:
        return this.initialDelay + r16;
    L5:
        if (this.backoffPolicy != BackoffPolicy.LINEAR) goto L7;
        r10 = true;
    L7:
        if (r10 == false) goto L9;
        long r17 = this.backoffDelayDuration * ((long) this.runAttemptCount);
    L32:
        return this.lastEnqueueTime + RangesKt.coerceAtMost(r17, WorkRequest.MAX_BACKOFF_MILLIS);
    L9:
        r17 = (long) Math.scalb(this.backoffDelayDuration, this.runAttemptCount - 1);
        goto L32
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String r30, WorkInfo.State r31, String r32, String r33, Data r34, Data r35, long r36, long r38, long r40, Constraints r42, @IntRange(from = 0) int r43, BackoffPolicy r44, long r45, long r47, long r49, long r51, boolean r53, OutOfQuotaPolicy r54, int r55, int r56) {
        Intrinsics.checkNotNullParameter(r30, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r31, "state");
        Intrinsics.checkNotNullParameter(r32, "workerClassName");
        Intrinsics.checkNotNullParameter(r34, "input");
        Intrinsics.checkNotNullParameter(r35, "output");
        Intrinsics.checkNotNullParameter(r42, "constraints");
        Intrinsics.checkNotNullParameter(r44, "backoffPolicy");
        Intrinsics.checkNotNullParameter(r54, "outOfQuotaPolicy");
        return new WorkSpec(r30, r31, r32, r33, r34, r35, r36, r38, r40, r42, r43, r44, r45, r47, r49, r51, r53, r54, r55, r56);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WorkSpec) == true) goto L8;
        return false;
    L8:
        WorkSpec r11 = (WorkSpec) r10;
        if (Intrinsics.areEqual(this.id, r11.id) == true) goto L12;
        return false;
    L12:
        if (this.state == r11.state) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.workerClassName, r11.workerClassName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.inputMergerClassName, r11.inputMergerClassName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.input, r11.input) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.output, r11.output) == true) goto L27;
        return false;
    L27:
        if (this.initialDelay == r11.initialDelay) goto L30;
        return false;
    L30:
        if (this.intervalDuration == r11.intervalDuration) goto L33;
        return false;
    L33:
        if (this.flexDuration == r11.flexDuration) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.constraints, r11.constraints) == true) goto L39;
        return false;
    L39:
        if (this.runAttemptCount == r11.runAttemptCount) goto L42;
        return false;
    L42:
        if (this.backoffPolicy == r11.backoffPolicy) goto L45;
        return false;
    L45:
        if (this.backoffDelayDuration == r11.backoffDelayDuration) goto L48;
        return false;
    L48:
        if (this.lastEnqueueTime == r11.lastEnqueueTime) goto L51;
        return false;
    L51:
        if (this.minimumRetentionDuration == r11.minimumRetentionDuration) goto L54;
        return false;
    L54:
        if (this.scheduleRequestedAt == r11.scheduleRequestedAt) goto L57;
        return false;
    L57:
        if (this.expedited == r11.expedited) goto L60;
        return false;
    L60:
        if (this.outOfQuotaPolicy == r11.outOfQuotaPolicy) goto L63;
        return false;
    L63:
        if (this.periodCount == r11.periodCount) goto L66;
        return false;
    L66:
        if (this.generation == r11.generation) goto L68;
        return false;
    L68:
        return true;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final boolean hasConstraints() {
        return !Intrinsics.areEqual(Constraints.NONE, this.constraints);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v39 */
    public int hashCode() {
        int r10 = ((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31;
        String r11 = this.inputMergerClassName;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (((((((((((((((((((((((((r10 + r12) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + Long.hashCode(this.initialDelay)) * 31) + Long.hashCode(this.intervalDuration)) * 31) + Long.hashCode(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + Integer.hashCode(this.runAttemptCount)) * 31) + this.backoffPolicy.hashCode()) * 31) + Long.hashCode(this.backoffDelayDuration)) * 31) + Long.hashCode(this.lastEnqueueTime)) * 31) + Long.hashCode(this.minimumRetentionDuration)) * 31) + Long.hashCode(this.scheduleRequestedAt)) * 31;
        boolean r14 = this.expedited;
        ?? r15 = r14;
        if (r14 == false) goto L10;
        r15 = 1;
    L10:
        return ((((((r13 + r15) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + Integer.hashCode(this.periodCount)) * 31) + Integer.hashCode(this.generation);
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final boolean isBackedOff() {
        if (this.state == WorkInfo.State.ENQUEUED) goto L5;
    L7:
        return false;
    L5:
        if (this.runAttemptCount <= 0) goto L7;
        return true;
    }

    public final boolean isPeriodic() {
        if (this.intervalDuration == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void setBackoffDelayDuration(long r10) {
        if (r10 <= WorkRequest.MAX_BACKOFF_MILLIS) goto L6;
        Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
    L6:
        if (r10 >= WorkRequest.MIN_BACKOFF_MILLIS) goto L8;
        Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
    L8:
        this.backoffDelayDuration = RangesKt.coerceIn(r10, WorkRequest.MIN_BACKOFF_MILLIS, WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final void setPeriodCount(int r10) {
        this.periodCount = r10;
    }

    public final void setPeriodic(long r10) {
        if (r10 >= 900000) goto L5;
        Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
    L5:
        setPeriodic(RangesKt.coerceAtLeast(r10, 900000), RangesKt.coerceAtLeast(r10, 900000));
    }

    public final void setPeriodic(long r10, long r11) {
        if (r10 >= 900000) goto L5;
        Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
    L5:
        this.intervalDuration = RangesKt.coerceAtLeast(r10, 900000);
        if (r11 >= 300000) goto L9;
        Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
    L9:
        if (r11 <= this.intervalDuration) goto L11;
        Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + r10);
    L11:
        this.flexDuration = RangesKt.coerceIn(r11, 300000, this.intervalDuration);
    }

    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }
}
