package com.obric.memorydata.realtimecontext.cache;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/realtimecontext/cache/State;", "", "<init>", "(Ljava/lang/String;I)V", "CACHING", "CACHED", "CLEARED", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum State extends Enum<State> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ State[] $VALUES = null;
    public static final State CACHED = null;
    public static final State CACHING = null;
    public static final State CLEARED = null;

    private static final /* synthetic */ State[] $values() {
        return new State[]{CACHING, CACHED, CLEARED};
    }

    static {
        CACHING = new State("CACHING", 0);
        CACHED = new State("CACHED", 1);
        CLEARED = new State("CLEARED", 2);
        State[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private State(String r1, int r2) {
        super(r1, r2);
    }

    public static EnumEntries<State> getEntries() {
        return $ENTRIES;
    }

    public static State valueOf(String r2) {
        return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
    }

    public static State[] values() {
        return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
    }
}
