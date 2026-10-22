package com.bytedance.lego.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B/\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskConfig;", "", "", "bootFinishTimeOut", "J", "getBootFinishTimeOut", "()J", "", "nonUIThreadTaskNum", "I", "getNonUIThreadTaskNum", "()I", "", "autoIdleTask", "Z", "getAutoIdleTask", "()Z", "uiThreadTaskNum", "getUiThreadTaskNum", "<init>", "(IIZJ)V", "Companion", "a", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class IdleTaskConfig {
    public static final a Companion = null;
    private static final IdleTaskConfig DEFAULT_IDLETASK_CONFIG = null;
    private static final long IDLE_START_TIME_OUT = 15000;
    private final boolean autoIdleTask;
    private final long bootFinishTimeOut;
    private final int nonUIThreadTaskNum;
    private final int uiThreadTaskNum;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final IdleTaskConfig a() {
            return IdleTaskConfig.access$getDEFAULT_IDLETASK_CONFIG$cp();
        }
    }

    static {
        Companion = new a(null);
        DEFAULT_IDLETASK_CONFIG = new IdleTaskConfig(0, 0, false, 0, 15, null);
    }

    public IdleTaskConfig() {
        this(0, 0, false, 0, 15, null);
    }

    public IdleTaskConfig(int r10, int r11, boolean r12, long r13) {
        this.uiThreadTaskNum = r10;
        this.nonUIThreadTaskNum = r11;
        this.autoIdleTask = r12;
        this.bootFinishTimeOut = r13;
    }

    public /* synthetic */ IdleTaskConfig(int r10, int r11, boolean r12, long r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r10 = 1;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r11 = 1;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r12 = false;
    L12:
        if ((r14 & 8) == 0) goto L14;
        r13 = IDLE_START_TIME_OUT;
    L14:
        this(r10, r11, r12, r13);
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
}
