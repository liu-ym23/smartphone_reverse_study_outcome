package com.obric.eventkit.eventstaskmanager;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/TimerEnableStatus;", "", "()V", "STATE_CLOSE", "", "STATE_DELETE", "STATE_DISABLED", "STATE_ENABLED", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimerEnableStatus {
    public static final TimerEnableStatus INSTANCE = null;
    public static final int STATE_CLOSE = 2;
    public static final int STATE_DELETE = 3;
    public static final int STATE_DISABLED = 1;
    public static final int STATE_ENABLED = 0;

    static {
        INSTANCE = new TimerEnableStatus();
    }

    private TimerEnableStatus() {
    }
}
