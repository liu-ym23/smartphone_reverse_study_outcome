package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"com/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/IPSHighlightCompLifecycle$State", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/IPSHighlightCompLifecycle$State;", "state", BuildConfig.FLAVOR, "isAtLeast", "Initialized", "Created", "Started", "Showed", "Hidden", "Destroyed", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IPSHighlightCompLifecycle$State extends Enum<IPSHighlightCompLifecycle$State> {
    public static final IPSHighlightCompLifecycle$State Created = null;
    public static final IPSHighlightCompLifecycle$State Destroyed = null;
    public static final IPSHighlightCompLifecycle$State Hidden = null;
    public static final IPSHighlightCompLifecycle$State Initialized = null;
    public static final IPSHighlightCompLifecycle$State Showed = null;
    public static final IPSHighlightCompLifecycle$State Started = null;
    public static final /* synthetic */ IPSHighlightCompLifecycle$State[] a = null;

    static {
        IPSHighlightCompLifecycle$State r1 = new IPSHighlightCompLifecycle$State("Initialized", 0);
        Initialized = r1;
        IPSHighlightCompLifecycle$State r2 = new IPSHighlightCompLifecycle$State("Created", 1);
        Created = r2;
        IPSHighlightCompLifecycle$State r3 = new IPSHighlightCompLifecycle$State("Started", 2);
        Started = r3;
        IPSHighlightCompLifecycle$State r4 = new IPSHighlightCompLifecycle$State("Showed", 3);
        Showed = r4;
        IPSHighlightCompLifecycle$State r5 = new IPSHighlightCompLifecycle$State("Hidden", 4);
        Hidden = r5;
        IPSHighlightCompLifecycle$State r6 = new IPSHighlightCompLifecycle$State("Destroyed", 5);
        Destroyed = r6;
        a = new IPSHighlightCompLifecycle$State[]{r1, r2, r3, r4, r5, r6};
    }

    public static IPSHighlightCompLifecycle$State valueOf(String r1) {
        return (IPSHighlightCompLifecycle$State) r27.a.a(IPSHighlightCompLifecycle$State.class, r1);
    }

    public static IPSHighlightCompLifecycle$State[] values() {
        return (IPSHighlightCompLifecycle$State[]) a.clone();
    }

    public final boolean isAtLeast(IPSHighlightCompLifecycle$State r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        if (compareTo(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public IPSHighlightCompLifecycle$State(String r1, int r2) {
        super(r1, r2);
    }
}
