package com.bytedance.apm.agent.instrumentation.transaction;

import com.bytedance.apm.agent.b.a;
import com.bytedance.apm.agent.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class TxState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f1089a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f1090b;
    private long c;
    private long d;
    private long e;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State COMPLETE = null;
        public static final State READY = null;
        public static final State SENT = null;

        static {
            State r0 = new State("READY", 0);
            READY = r0;
            State r1 = new State("SENT", 1);
            SENT = r1;
            State r3 = new State("COMPLETE", 2);
            COMPLETE = r3;
            $VALUES = new State[]{r0, r1, r3};
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r2) {
            return (State) ZeusTransformUtils.preCheckCast(Enum.valueOf(State.class, r2), State.class, "com.obric.memorydata.plugin");
        }

        public static State[] values() {
            return (State[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), State[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f1089a = b.a();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(" StartTime ").append(String.valueOf(this.c)).append(" BytesReceived ").append(String.valueOf(this.e)).append(" BytesSent ").append(String.valueOf(this.d)).append(" Url ").append(this.f1090b);
        return r0.toString();
    }
}
