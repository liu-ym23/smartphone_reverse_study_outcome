package com.obric.memorydata.sdk.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/memory/State;", "", "<init>", "(Ljava/lang/String;I)V", "BEGIN", "SUCCESS_NEW", "SUCCESS_UPDATE", "FAILURE_ERROR", "TIMEOUT", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum State extends Enum<State> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ State[] $VALUES = null;
    public static final State BEGIN = null;
    public static final a Companion = null;
    public static final State FAILURE_ERROR = null;
    public static final State SUCCESS_NEW = null;
    public static final State SUCCESS_UPDATE = null;
    public static final State TIMEOUT = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/memory/State$Companion;", "", "<init>", "()V", "fromOrdinal", "Lcom/obric/memorydata/sdk/memory/State;", "ordinal", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    private static final /* synthetic */ State[] $values() {
        return new State[]{BEGIN, SUCCESS_NEW, SUCCESS_UPDATE, FAILURE_ERROR, TIMEOUT};
    }

    static {
        BEGIN = new State("BEGIN", 0);
        SUCCESS_NEW = new State("SUCCESS_NEW", 1);
        SUCCESS_UPDATE = new State("SUCCESS_UPDATE", 2);
        FAILURE_ERROR = new State("FAILURE_ERROR", 3);
        TIMEOUT = new State("TIMEOUT", 4);
        State[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        Companion = new a(null);
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
