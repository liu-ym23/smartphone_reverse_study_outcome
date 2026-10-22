package ja2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.z0;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.textmessage.model.d;
import com.bytedance.android.livesdk.interactivity.utils.PublicScreenMessageMonitor;
import com.bytedance.android.livesdk.interactivity.utils.g;
import com.bytedance.android.livesdk.utils.ntp.e;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public long a;
    public final b b;
    public long c;
    public boolean d;
    public final long e;
    public final ss1.a f;

    /* JADX INFO: renamed from: ja2.a$a, reason: collision with other inner class name */
    public static final class C0240a {
    }

    public final class b {
        public final int a;
        public final Queue<Long> b;
        public long c;
        public long d;
        public final /* synthetic */ a e;

        public b(a r2) {
            this.e = r2;
            this.a = Math.max(20, 0);
            this.b = new ArrayDeque();
        }
    }

    static {
    }

    public a(ss1.a r3) {
        Intrinsics.checkNotNullParameter(r3, "delayConfig");
        this.f = r3;
        this.b = new b(this);
        this.d = true;
        this.e = r3.anchorChatDelay;
    }

    public final f<?> a(Queue<f<?>> r13) {
        Iterator<f<?>> r0 = r13.iterator();
        if (r0.hasNext() == true) goto L5;
        return null;
    L5:
        f<?> r1 = r0.next();
        if ((r1 instanceof d) == true) goto L9;
        r0.remove();
        return r1;
    L9:
        long r3 = System.currentTimeMillis() - ((d) r1).p().longValue();
        long r5 = (this.a + this.e) - r3;
        ss1.a r7 = this.f;
        if (r5 <= r7.chatMaxDelay) goto L14;
        ALogger.e("ChatAlignDelay", "chat message delay " + r5 + " too big. stream delay: " + this.a + ", client delay: " + r3);
        r0.remove();
        return r1;
    L14:
        if (r5 >= (this.c * r7.thresholdCoefficient)) goto L26;
        r0.remove();
        if (r1.s <= 0) goto L24;
        long r2 = System.currentTimeMillis() - r1.s;
        SimpleDateFormat r4 = PublicScreenMessageMonitor.a;
        g r6 = (g) PublicScreenMessageMonitor.u.getValue();
        Iterator<T> r14 = r13.iterator();
        int r8 = 0;
    L19:
        if (r14.hasNext() == false) goto L23;
        if ((((f) r14.next()) instanceof d) == false) goto L19;
        r8 = r8 + 1;
        goto L19
    L23:
        long r9 = r8;
        r6.q += r2 * r9;
        r6.r += r9;
    L24:
        return r1;
    L26:
        if (r1.s != 0) goto L29;
        r1.s = System.currentTimeMillis();
    L29:
        if (r0.hasNext() == false) goto L34;
        f<?> r15 = r0.next();
        if ((r15 instanceof d) == true) goto L29;
        r0.remove();
        return r15;
    L34:
        return null;
    }

    public final void b(z0 r11) {
        Intrinsics.checkNotNullParameter(r11, "timePair");
        long r0 = e.a() - r11.a;
        ss1.a r13 = this.f;
        if (r0 >= r13.streamDelayMinValue) goto L5;
    L29:
        ALogger.e("StreamAlignDelay", "stream delay: " + r0 + " out of normal range");
        return;
    L5:
        if (r0 > r13.streamDelayMaxValue) goto L29;
        b r14 = this.b;
        ((ArrayDeque) r14.b).offer(Long.valueOf(r0));
    L9:
        if (((ArrayDeque) r14.b).size() <= r14.a) goto L11;
        ((ArrayDeque) r14.b).poll();
        goto L9
    L11:
        boolean r3 = true;
        if (r14.e.d == true) goto L19;
        r14.c = CollectionsKt.sumOfLong(r14.b) / ((long) RangesKt.coerceAtLeast(((ArrayDeque) r14.b).size(), 1));
        Iterator r2 = ((ArrayDeque) r14.b).iterator();
        long r4 = 0;
    L15:
        if (r2.hasNext() == false) goto L17;
        long r6 = ((Long) r2.next()).longValue() - r14.c;
        r4 = r4 + (r6 * r6);
        goto L15
    L17:
        r14.d = (long) Math.sqrt((r4 * 1.0d) / ((double) RangesKt.coerceAtLeast(((ArrayDeque) r14.b).size(), 1)));
    L19:
        if (this.d == true) goto L24;
        b r15 = this.b;
        long r5 = r15.d * ((long) 3);
        if (new LongRange(r15.c - r5, r15.c + r5).contains(r0) == false) goto L33;
        this.a = r0;
        return;
    L33:
        return;
    L24:
        if (((ArrayDeque) this.b.b).size() < this.f.startDelaySEICount) goto L27;
        r3 = false;
    L27:
        this.d = r3;
    }
}
