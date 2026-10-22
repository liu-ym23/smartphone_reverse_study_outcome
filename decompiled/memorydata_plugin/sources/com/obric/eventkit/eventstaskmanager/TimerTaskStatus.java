package com.obric.eventkit.eventstaskmanager;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerTaskStatus;", "", "()V", "STATE_ACTIONING", "", "STATE_COMPLETED", "STATE_FAILED", "STATE_PENDING", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerTaskStatus {
    public static final TimerTaskStatus INSTANCE = null;
    public static final int STATE_ACTIONING = 1;
    public static final int STATE_COMPLETED = 2;
    public static final int STATE_FAILED = 3;
    public static final int STATE_PENDING = 0;

    static {
        INSTANCE = new TimerTaskStatus();
    }

    private TimerTaskStatus() {
    }
}
