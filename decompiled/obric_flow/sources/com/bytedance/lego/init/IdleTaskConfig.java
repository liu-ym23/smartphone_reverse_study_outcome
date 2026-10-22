package com.bytedance.lego.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskConfig;", "", "", "uiThreadTaskNum", "nonUIThreadTaskNum", "", "autoIdleTask", "", "bootFinishTimeOut", "<init>", "(IIZJ)V", "I", "getUiThreadTaskNum", "()I", "getNonUIThreadTaskNum", "Z", "getAutoIdleTask", "()Z", "J", "getBootFinishTimeOut", "()J", "Companion", "com/bytedance/lego/init/g", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class IdleTaskConfig {
    public static final g Companion = null;
    private static final IdleTaskConfig DEFAULT_IDLETASK_CONFIG = null;
    private static final long IDLE_START_TIME_OUT = 15000;
    private final boolean autoIdleTask;
    private final long bootFinishTimeOut;
    private final int nonUIThreadTaskNum;
    private final int uiThreadTaskNum;

    static {
        Companion = new g();
        int r5 = 0;
        int r10 = 0;
        boolean r11 = false;
        long r12 = 0;
        DEFAULT_IDLETASK_CONFIG = new IdleTaskConfig(r5, r10, r11, r12, 15, null);
    }

    public IdleTaskConfig() {
        int r5 = 0;
        int r10 = 0;
        boolean r11 = false;
        long r12 = 0;
        this(r5, r10, r11, r12, 15, null);
    }

    public static final /* synthetic */ IdleTaskConfig access$getDEFAULT_IDLETASK_CONFIG$cp() {
        return DEFAULT_IDLETASK_CONFIG;
    }

    public final boolean getAutoIdleTask() {
        return this.autoIdleTask;
    }

    public final long getBootFinishTimeOut() {
        return this.bootFinishTimeOut;
    }

    public final int getNonUIThreadTaskNum() {
        return this.nonUIThreadTaskNum;
    }

    public final int getUiThreadTaskNum() {
        return this.uiThreadTaskNum;
    }

    public IdleTaskConfig(int r5, int r10, boolean r11, long r12) {
        this.uiThreadTaskNum = r5;
        this.nonUIThreadTaskNum = r10;
        this.autoIdleTask = r11;
        this.bootFinishTimeOut = r12;
    }

    public /* synthetic */ IdleTaskConfig(int r5, int r10, boolean r11, long r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r5 = 1;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = 1;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = false;
    L12:
        if ((r13 & 8) == 0) goto L14;
        r12 = IDLE_START_TIME_OUT;
    L14:
        this(r5, r10, r11, r12);
    }
}
