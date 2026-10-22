package com.bytedance.android.live.anchormodelink.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/anchormodelink/model/LinkerUserState;", "", "None", "Audience", "Waiting", "Ready", "Linked", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkerUserState extends Enum<LinkerUserState> {
    public static final LinkerUserState Audience = null;
    public static final LinkerUserState Linked = null;
    public static final LinkerUserState None = null;
    public static final LinkerUserState Ready = null;
    public static final LinkerUserState Waiting = null;
    public static final /* synthetic */ LinkerUserState[] a = null;

    static {
        LinkerUserState r1 = new LinkerUserState("None", 0);
        None = r1;
        LinkerUserState r2 = new LinkerUserState("Audience", 1);
        Audience = r2;
        LinkerUserState r3 = new LinkerUserState("Waiting", 2);
        Waiting = r3;
        LinkerUserState r4 = new LinkerUserState("Ready", 3);
        Ready = r4;
        LinkerUserState r5 = new LinkerUserState("Linked", 4);
        Linked = r5;
        a = new LinkerUserState[]{r1, r2, r3, r4, r5};
    }

    public static LinkerUserState valueOf(String r1) {
        return (LinkerUserState) a.a(LinkerUserState.class, r1);
    }

    public static LinkerUserState[] values() {
        return (LinkerUserState[]) a.clone();
    }

    public LinkerUserState(String r1, int r2) {
        super(r1, r2);
    }
}
