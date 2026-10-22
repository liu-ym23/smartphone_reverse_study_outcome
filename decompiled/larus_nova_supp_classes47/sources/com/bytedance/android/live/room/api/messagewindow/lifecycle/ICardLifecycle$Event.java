package com.bytedance.android.live.room.api.messagewindow.lifecycle;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0006\u0010\u0004\u001a\u00020\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$Event", "", "Lcom/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$Event;", "Lcom/bytedance/android/live/room/api/messagewindow/lifecycle/ICardLifecycle$State;", "getTargetState", "OnCreate", "OnStore", "OnShow", "OnStart", "OnHide", "OnDestroy", "OnAny", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ICardLifecycle$Event extends Enum<ICardLifecycle$Event> {
    public static final ICardLifecycle$Event OnAny = null;
    public static final ICardLifecycle$Event OnCreate = null;
    public static final ICardLifecycle$Event OnDestroy = null;
    public static final ICardLifecycle$Event OnHide = null;
    public static final ICardLifecycle$Event OnShow = null;
    public static final ICardLifecycle$Event OnStart = null;
    public static final ICardLifecycle$Event OnStore = null;
    public static final /* synthetic */ ICardLifecycle$Event[] a = null;

    static {
        ICardLifecycle$Event r1 = new ICardLifecycle$Event("OnCreate", 0);
        OnCreate = r1;
        ICardLifecycle$Event r2 = new ICardLifecycle$Event("OnStore", 1);
        OnStore = r2;
        ICardLifecycle$Event r3 = new ICardLifecycle$Event("OnShow", 2);
        OnShow = r3;
        ICardLifecycle$Event r4 = new ICardLifecycle$Event("OnStart", 3);
        OnStart = r4;
        ICardLifecycle$Event r5 = new ICardLifecycle$Event("OnHide", 4);
        OnHide = r5;
        ICardLifecycle$Event r6 = new ICardLifecycle$Event("OnDestroy", 5);
        OnDestroy = r6;
        ICardLifecycle$Event r7 = new ICardLifecycle$Event("OnAny", 6);
        OnAny = r7;
        a = new ICardLifecycle$Event[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static ICardLifecycle$Event valueOf(String r1) {
        return (ICardLifecycle$Event) a.a(ICardLifecycle$Event.class, r1);
    }

    public static ICardLifecycle$Event[] values() {
        return (ICardLifecycle$Event[]) a.clone();
    }

    public final ICardLifecycle$State getTargetState() {
        switch(c71.a.a[ordinal()]) {
            case 1: goto L12;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException(this + " has no target state");
    L13:
        return ICardLifecycle$State.Destroyed;
    L14:
        return ICardLifecycle$State.Hidden;
    L15:
        return ICardLifecycle$State.Showed;
    L16:
        return ICardLifecycle$State.Started;
    L17:
        return ICardLifecycle$State.Stored;
    L12:
        return ICardLifecycle$State.Created;
    }

    public ICardLifecycle$Event(String r1, int r2) {
        super(r1, r2);
    }
}
