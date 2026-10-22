package com.bytedance.lego.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskConfig;", "", "uiThreadTaskNum", "", "nonUIThreadTaskNum", "autoIdleTask", "", "bootFinishTimeOut", "", "(IIZJ)V", "getAutoIdleTask", "()Z", "getBootFinishTimeOut", "()J", "getNonUIThreadTaskNum", "()I", "getUiThreadTaskNum", "Companion", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class IdleTaskConfig {
    public static final a Companion = null;
    private static final IdleTaskConfig DEFAULT_IDLETASK_CONFIG = null;
    private static final long IDLE_START_TIME_OUT = 15000;
    private final boolean autoIdleTask;
    private final long bootFinishTimeOut;
    private final int nonUIThreadTaskNum;
    private final int uiThreadTaskNum;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskConfig$Companion;", "", "()V", "DEFAULT_IDLETASK_CONFIG", "Lcom/bytedance/lego/init/IdleTaskConfig;", "getDEFAULT_IDLETASK_CONFIG$initscheduler_release", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "IDLE_START_TIME_OUT", "", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
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

    public IdleTaskConfig(int r1, int r2, boolean r3, long r4) {
        this.uiThreadTaskNum = r1;
        this.nonUIThreadTaskNum = r2;
        this.autoIdleTask = r3;
        this.bootFinishTimeOut = r4;
    }

    public /* synthetic */ IdleTaskConfig(int r2, int r3, boolean r4, long r5, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 1;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r5 = 15000;
    L14:
        this(r2, r3, r4, r5);
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
