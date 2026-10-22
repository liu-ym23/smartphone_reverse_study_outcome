package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum ThreadState extends Enum<ThreadState> implements WireEnum {
    private static final /* synthetic */ ThreadState[] $VALUES = null;
    public static final ProtoAdapter<ThreadState> ADAPTER = null;
    public static final ThreadState CLOSED = null;
    public static final ThreadState OPEN = null;
    public static final ThreadState UNKNOWN_STATE = null;
    private final int value;

    static {
        ThreadState r0 = new ThreadState("UNKNOWN_STATE", 0, 0);
        UNKNOWN_STATE = r0;
        ThreadState r1 = new ThreadState("OPEN", 1, 1);
        OPEN = r1;
        ThreadState r3 = new ThreadState("CLOSED", 2, 2);
        CLOSED = r3;
        $VALUES = new ThreadState[]{r0, r1, r3};
        ADAPTER = ProtoAdapter.newEnumAdapter(ThreadState.class);
    }

    public static ThreadState[] values() {
        return (ThreadState[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ThreadState fromValue(int r1) {
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L10;
        return null;
    L10:
        return CLOSED;
    L12:
        return OPEN;
    L14:
        return UNKNOWN_STATE;
    }

    public static ThreadState valueOf(String r1) {
        return (ThreadState) a.a(ThreadState.class, r1);
    }

    private ThreadState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
