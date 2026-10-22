package com.bytedance.android.live.liveinteract.plantform.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/utils/PublicStreamPlayState;", "", "", "usingMcu", "None", "Pulling", "Playing", "Fallback", "End", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PublicStreamPlayState extends Enum<PublicStreamPlayState> {
    public static final PublicStreamPlayState End = null;
    public static final PublicStreamPlayState Fallback = null;
    public static final PublicStreamPlayState None = null;
    public static final PublicStreamPlayState Playing = null;
    public static final PublicStreamPlayState Pulling = null;
    public static final /* synthetic */ PublicStreamPlayState[] a = null;

    static {
        PublicStreamPlayState r1 = new PublicStreamPlayState("None", 0);
        None = r1;
        PublicStreamPlayState r2 = new PublicStreamPlayState("Pulling", 1);
        Pulling = r2;
        PublicStreamPlayState r3 = new PublicStreamPlayState("Playing", 2);
        Playing = r3;
        PublicStreamPlayState r4 = new PublicStreamPlayState("Fallback", 3);
        Fallback = r4;
        PublicStreamPlayState r5 = new PublicStreamPlayState("End", 4);
        End = r5;
        a = new PublicStreamPlayState[]{r1, r2, r3, r4, r5};
    }

    public static PublicStreamPlayState valueOf(String r1) {
        return (PublicStreamPlayState) r27.a.a(PublicStreamPlayState.class, r1);
    }

    public static PublicStreamPlayState[] values() {
        return (PublicStreamPlayState[]) a.clone();
    }

    public final boolean usingMcu() {
        if (this != Playing) goto L5;
        return true;
    L5:
        return false;
    }

    public PublicStreamPlayState(String r1, int r2) {
        super(r1, r2);
    }
}
