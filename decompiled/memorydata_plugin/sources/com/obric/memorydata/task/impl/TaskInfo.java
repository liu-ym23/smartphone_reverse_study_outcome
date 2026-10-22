package com.obric.memorydata.task.impl;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b.\u0018\u00002\u00020\u0001:\u0001>Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010<\u001a\u00020\u000fH\u0016J\b\u0010=\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0012\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001a\u0010\u0013\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00103\"\u0004\b9\u00105¨\u0006?"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskInfo;", "", OaidModel.KEY_ID, "Ljava/util/UUID;", ActivityLifecycle.NAME, "", "state", "Lcom/obric/memorydata/task/impl/TaskInfo$State;", "data", "Lorg/json/JSONObject;", "taskResult", "Lcom/obric/memorydata/task/impl/TaskResult;", "executeImmediately", "", "runAttemptRetryCount", "", "executeTimeCost", "", "executeLogicTimeCost", "waitQueueExecuteCost", "<init>", "(Ljava/util/UUID;Ljava/lang/String;Lcom/obric/memorydata/task/impl/TaskInfo$State;Lorg/json/JSONObject;Lcom/obric/memorydata/task/impl/TaskResult;ZIJJJ)V", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getState", "()Lcom/obric/memorydata/task/impl/TaskInfo$State;", "setState", "(Lcom/obric/memorydata/task/impl/TaskInfo$State;)V", "getData", "()Lorg/json/JSONObject;", "setData", "(Lorg/json/JSONObject;)V", "getTaskResult", "()Lcom/obric/memorydata/task/impl/TaskResult;", "setTaskResult", "(Lcom/obric/memorydata/task/impl/TaskResult;)V", "getExecuteImmediately", "()Z", "setExecuteImmediately", "(Z)V", "getRunAttemptRetryCount", "()I", "setRunAttemptRetryCount", "(I)V", "getExecuteTimeCost", "()J", "setExecuteTimeCost", "(J)V", "getExecuteLogicTimeCost", "setExecuteLogicTimeCost", "getWaitQueueExecuteCost", "setWaitQueueExecuteCost", "equals", "o", "hashCode", "toString", "State", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UUID f12926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12927b;
    private State c;
    private JSONObject d;
    private TaskResult e;
    private boolean f;
    private int g;
    private long h;
    private long i;
    private long j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/task/impl/TaskInfo$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ENQUEUED", "RUNNING", "SUCCEEDED", RawObservationEntity.STATE_FAILED, "TIMEOUT", "CANCELLED", "isFinished", "", "()Z", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State CANCELLED = null;
        public static final State ENQUEUED = null;
        public static final State FAILED = null;
        public static final State IDLE = null;
        public static final State RUNNING = null;
        public static final State SUCCEEDED = null;
        public static final State TIMEOUT = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{IDLE, ENQUEUED, RUNNING, SUCCEEDED, FAILED, TIMEOUT, CANCELLED};
        }

        static {
            IDLE = new State("IDLE", 0);
            ENQUEUED = new State("ENQUEUED", 1);
            RUNNING = new State("RUNNING", 2);
            SUCCEEDED = new State("SUCCEEDED", 3);
            FAILED = new State(RawObservationEntity.STATE_FAILED, 4);
            TIMEOUT = new State("TIMEOUT", 5);
            CANCELLED = new State("CANCELLED", 6);
            State[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }

        public final boolean isFinished() {
            if (this != SUCCEEDED) goto L5;
        L12:
            return true;
        L5:
            if (this == FAILED) goto L12;
            if (this == CANCELLED) goto L12;
            if (this == TIMEOUT) goto L12;
            return false;
        }
    }

    public TaskInfo(UUID r2, String r3, State r4, JSONObject r5, TaskResult r6, boolean r7, int r8, long r9, long r11, long r13) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "state");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "taskResult");
        this.f12926a = r2;
        this.f12927b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r11;
        this.j = r13;
    }

    public /* synthetic */ TaskInfo(UUID r15, String r16, State r17, JSONObject r18, TaskResult r19, boolean r20, int r21, long r22, long r24, long r26, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 2) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r28 & 4) == 0) goto L9;
        State r2 = State.IDLE;
    L11:
        if ((r28 & 8) == 0) goto L13;
        JSONObject r3 = new JSONObject();
    L15:
        if ((r28 & 16) == 0) goto L17;
        TaskResult r4 = new TaskResult(-1, null, null, null, 14, null);
    L18:
        int r6 = 0;
        if ((r28 & 32) == 0) goto L21;
        boolean r5 = false;
    L23:
        if ((r28 & 64) != 0) goto L26;
        r6 = r21;
    L26:
        long r8 = 0;
        if ((r28 & 128) == 0) goto L29;
        long r10 = 0;
    L31:
        if ((r28 & 256) == 0) goto L33;
        long r12 = 0;
    L35:
        if ((r28 & 512) != 0) goto L38;
        r8 = r26;
    L38:
        this(r15, r1, r2, r3, r4, r5, r6, r10, r12, r8);
        return;
    L33:
        r12 = r24;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L21:
        r5 = r20;
        goto L23
    L17:
        r4 = r19;
        goto L18
    L13:
        r3 = r18;
        goto L15
    L9:
        r2 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }

    public final UUID a() {
        return this.f12926a;
    }

    public final void a(int r1) {
        this.g = r1;
    }

    public final void a(long r1) {
        this.h = r1;
    }

    public final void a(State r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    public final void a(TaskResult r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f12927b = r2;
    }

    public final void a(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void a(boolean r1) {
        this.f = r1;
    }

    public final String b() {
        return this.f12927b;
    }

    public final void b(long r1) {
        this.i = r1;
    }

    public final State c() {
        return this.c;
    }

    public final void c(long r1) {
        this.j = r1;
    }

    public final JSONObject d() {
        return this.d;
    }

    public final TaskResult e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L18:
        return false;
    L8:
        if (Intrinsics.areEqual(getClass(), r5.getClass()) == false) goto L18;
        TaskInfo r6 = (TaskInfo) ZeusTransformUtils.preCheckCast(r5, TaskInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f12926a, r6.f12926a) == true) goto L14;
        return false;
    L14:
        if (this.c != r6.c) goto L17;
        return true;
    L17:
        return false;
    }

    public final boolean f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        return (((this.f12926a.hashCode() * 31) + this.c.hashCode()) * 31) + Integer.hashCode(this.g);
    }

    public final long i() {
        return this.i;
    }

    public final long j() {
        return this.j;
    }

    public String toString() {
        if (com.obric.memorydata.infra.a.a.f9875a.b(this.f12927b) == false) goto L7;
        StringBuilder r0 = new StringBuilder();
    L6:
        return r0.append("TaskInfo{name=").append(this.f12927b).append(", id='").append(this.f12926a).append("', state=").append(this.c).append(", runAttemptRetryCount=").append(this.g).append('}').toString();
    L7:
        r0 = new StringBuilder();
        goto L6
    }
}
