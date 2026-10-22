package com.bytedance.android.live.room.api.messagewindow.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"com/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$State", "", "Lcom/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$State;", "state", "", "isAtLeast", "isAtMost", "isShowOrHide", "Initialized", "Created", "Stored", "Started", "Showed", "Hidden", "Destroyed", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ICardLifecycle$State extends Enum<ICardLifecycle$State> {
    public static final ICardLifecycle$State Created = null;
    public static final ICardLifecycle$State Destroyed = null;
    public static final ICardLifecycle$State Hidden = null;
    public static final ICardLifecycle$State Initialized = null;
    public static final ICardLifecycle$State Showed = null;
    public static final ICardLifecycle$State Started = null;
    public static final ICardLifecycle$State Stored = null;
    public static final /* synthetic */ ICardLifecycle$State[] a = null;

    static {
        ICardLifecycle$State r1 = new ICardLifecycle$State("Initialized", 0);
        Initialized = r1;
        ICardLifecycle$State r2 = new ICardLifecycle$State("Created", 1);
        Created = r2;
        ICardLifecycle$State r3 = new ICardLifecycle$State("Stored", 2);
        Stored = r3;
        ICardLifecycle$State r4 = new ICardLifecycle$State("Started", 3);
        Started = r4;
        ICardLifecycle$State r5 = new ICardLifecycle$State("Showed", 4);
        Showed = r5;
        ICardLifecycle$State r6 = new ICardLifecycle$State("Hidden", 5);
        Hidden = r6;
        ICardLifecycle$State r7 = new ICardLifecycle$State("Destroyed", 6);
        Destroyed = r7;
        a = new ICardLifecycle$State[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static ICardLifecycle$State valueOf(String r1) {
        return (ICardLifecycle$State) a.a(ICardLifecycle$State.class, r1);
    }

    public static ICardLifecycle$State[] values() {
        return (ICardLifecycle$State[]) a.clone();
    }

    public final boolean isShowOrHide() {
        ICardLifecycle$State r0 = Hidden;
        if (compareTo(Showed) >= 0) goto L6;
    L8:
        return false;
    L6:
        if (compareTo(r0) > 0) goto L8;
        return true;
    }

    public final boolean isAtLeast(ICardLifecycle$State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (compareTo(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isAtMost(ICardLifecycle$State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (compareTo(r2) > 0) goto L5;
        return true;
    L5:
        return false;
    }

    public ICardLifecycle$State(String r1, int r2) {
        super(r1, r2);
    }
}
