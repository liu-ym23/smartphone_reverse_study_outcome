package com.obric.memorydata.task.scheduler.impl;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", "", EventBody.KEY_VALUE, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "REPLACE_IN_QUEUE", "KEEP_IN_QUEUE", "SINGLE_QUEUE", "CANCEL_EXISTING", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ExistingTaskPolicy extends Enum<ExistingTaskPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ExistingTaskPolicy[] $VALUES = null;
    public static final ExistingTaskPolicy CANCEL_EXISTING = null;
    public static final a Companion = null;
    public static final ExistingTaskPolicy KEEP_IN_QUEUE = null;
    public static final ExistingTaskPolicy REPLACE_IN_QUEUE = null;
    public static final ExistingTaskPolicy SINGLE_QUEUE = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy$Companion;", "", "<init>", "()V", "from", "Lcom/obric/memorydata/task/scheduler/impl/ExistingTaskPolicy;", EventBody.KEY_VALUE, "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final ExistingTaskPolicy a(String r5) {
            Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
            ExistingTaskPolicy[] r4 = ExistingTaskPolicy.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            ExistingTaskPolicy r2 = r4[r1];
            if (Intrinsics.areEqual(r2.getValue(), r5) == true) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }
    }

    private static final /* synthetic */ ExistingTaskPolicy[] $values() {
        return new ExistingTaskPolicy[]{REPLACE_IN_QUEUE, KEEP_IN_QUEUE, SINGLE_QUEUE, CANCEL_EXISTING};
    }

    static {
        REPLACE_IN_QUEUE = new ExistingTaskPolicy("REPLACE_IN_QUEUE", 0, "replace");
        KEEP_IN_QUEUE = new ExistingTaskPolicy("KEEP_IN_QUEUE", 1, "keep");
        SINGLE_QUEUE = new ExistingTaskPolicy("SINGLE_QUEUE", 2, "single_queue");
        CANCEL_EXISTING = new ExistingTaskPolicy("CANCEL_EXISTING", 3, "cancel_existing");
        ExistingTaskPolicy[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
    }

    private ExistingTaskPolicy(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static EnumEntries<ExistingTaskPolicy> getEntries() {
        return $ENTRIES;
    }

    public static ExistingTaskPolicy valueOf(String r2) {
        return (ExistingTaskPolicy) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExistingTaskPolicy.class, r2), ExistingTaskPolicy.class, "com.obric.memorydata.plugin");
    }

    public static ExistingTaskPolicy[] values() {
        return (ExistingTaskPolicy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExistingTaskPolicy[].class, "com.obric.memorydata.plugin");
    }

    public final String getValue() {
        return this.value;
    }
}
