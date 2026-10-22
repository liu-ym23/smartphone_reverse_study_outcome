package c71;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$Event;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;

    static {
        int[] r0 = new int[ICardLifecycle$Event.values().length];
        a = r0;
        r0[ICardLifecycle$Event.OnCreate.ordinal()] = 1;
        r0[ICardLifecycle$Event.OnStore.ordinal()] = 2;
        r0[ICardLifecycle$Event.OnStart.ordinal()] = 3;
        r0[ICardLifecycle$Event.OnShow.ordinal()] = 4;
        r0[ICardLifecycle$Event.OnHide.ordinal()] = 5;
        r0[ICardLifecycle$Event.OnDestroy.ordinal()] = 6;
    }
}
