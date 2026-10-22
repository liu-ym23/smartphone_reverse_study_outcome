package com.bytedance.android.livesdk.interactivity.like.controller;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/controller/State;", BuildConfig.FLAVOR, "CLEAR", "SHOWING", "PROGRESS", "TURNING_LARGE", "LARGE", "ENDING", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum State extends Enum<State> {
    public static final State CLEAR = null;
    public static final State ENDING = null;
    public static final State LARGE = null;
    public static final State PROGRESS = null;
    public static final State SHOWING = null;
    public static final State TURNING_LARGE = null;
    public static final /* synthetic */ State[] a = null;

    static {
        State r1 = new State("CLEAR", 0);
        CLEAR = r1;
        State r2 = new State("SHOWING", 1);
        SHOWING = r2;
        State r3 = new State("PROGRESS", 2);
        PROGRESS = r3;
        State r4 = new State("TURNING_LARGE", 3);
        TURNING_LARGE = r4;
        State r5 = new State("LARGE", 4);
        LARGE = r5;
        State r6 = new State("ENDING", 5);
        ENDING = r6;
        a = new State[]{r1, r2, r3, r4, r5, r6};
    }

    public static State valueOf(String r1) {
        return (State) r27.a.a(State.class, r1);
    }

    public static State[] values() {
        return (State[]) a.clone();
    }

    public State(String r1, int r2) {
        super(r1, r2);
    }
}
