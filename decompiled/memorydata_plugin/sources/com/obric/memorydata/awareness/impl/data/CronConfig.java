package com.obric.memorydata.awareness.impl.data;

import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/awareness/impl/data/CronConfig;", "", CronJobRunnerTask.KEY_CRON, "", "triggerExactly", "", "<init>", "(Ljava/lang/String;Z)V", "getCron", "()Ljava/lang/String;", "getTriggerExactly", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CronConfig {
    private final String cron;
    private final boolean triggerExactly;

    public CronConfig(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, CronJobRunnerTask.KEY_CRON);
        this.cron = r2;
        this.triggerExactly = r3;
    }

    public /* synthetic */ CronConfig(String r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ CronConfig copy$default(CronConfig r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.cron;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.triggerExactly;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.cron;
    }

    public final boolean component2() {
        return this.triggerExactly;
    }

    public final CronConfig copy(String r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, CronJobRunnerTask.KEY_CRON);
        return new CronConfig(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, CronConfig.class) == true) goto L8;
        return false;
    L8:
        CronConfig r6 = (CronConfig) ZeusTransformUtils.preCheckCast(r5, CronConfig.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.cron, r6.cron) == true) goto L12;
        return false;
    L12:
        if (this.triggerExactly == r6.triggerExactly) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getCron() {
        return this.cron;
    }

    public final boolean getTriggerExactly() {
        return this.triggerExactly;
    }

    public int hashCode() {
        return (this.cron.hashCode() * 31) + Boolean.hashCode(this.triggerExactly);
    }

    public String toString() {
        return "CronConfig(cron=" + this.cron + ", triggerExactly=" + this.triggerExactly + ')';
    }
}
