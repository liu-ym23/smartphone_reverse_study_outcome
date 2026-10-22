package com.bytedance.android.livesdk.interactivity.api.entity;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.utils.MaxSizeList;
import com.bytedance.android.live.core.utils.StateMachine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class DisplayTimeRecorder {
    public int a;
    public long b;
    public final MaxSizeList<b> c;
    public final StateMachine<i, g, h> d;
    public final t e;
    public final a f;

    public interface a {
        void a(int r1);

        void b(b r1);
    }

    public static final class b {
        public final long a;
        public final long b;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L10;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (this.b == r7.b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.b;
            return r1 + ((int) (r3 ^ (r3 >>> 32)));
        }

        public final String toString() {
            return "TimeRecord(startTime=" + this.a + ", endTime=" + this.b + ")";
        }

        public b(long r1, long r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    public final void a(g r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        StateMachine<i, g, h> r0 = this.d;
        StateMachine.a r1 = StateMachine.c;
        r0.d(r3, null);
    }

    public DisplayTimeRecorder(t r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        this.e = r2;
        this.f = r3;
        this.c = new MaxSizeList(10);
        StateMachine.a r4 = StateMachine.c;
        Function1<StateMachine.GraphBuilder<i, g, h>, Unit> r5 = new DisplayTimeRecorder$stateMachine$1(this);
        r4.getClass();
        this.d = StateMachine.a.a(r5);
    }
}
