package com.bytedance.android.live.broadcastgame.channel.receiver.helper;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.broadcastgame.api.channel.DelayType;
import com.bytedance.android.live.broadcastgame.api.model.k;
import com.bytedance.android.live.broadcastgame.opengame.message.b0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.PriorityQueue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ImAlignHelper {
    public static final /* synthetic */ int e = 0;
    public final Handler a;
    public final Lazy b;
    public final Lazy c;
    public final Function1<k, Unit> d;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final k a;
        public final Function1<b, Unit> b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            k r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Function1<b, Unit> r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Entry(message=" + this.a + ", runAction=" + this.b + ")";
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.invoke(this);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(b0 r2, Function1 r3) {
            Intrinsics.checkNotNullParameter(r2, "message");
            Intrinsics.checkNotNullParameter(r3, "runAction");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImAlignHelper(Function1<? super k, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "dispatch");
        this.d = r2;
        this.a = new Handler(Looper.getMainLooper());
        this.b = LazyKt.lazy(ImAlignHelper$cale$2.INSTANCE);
        this.c = LazyKt.lazy(ImAlignHelper$queue$2.INSTANCE);
    }

    public final void a(b0 r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        if (r11.b() != DelayType.NO_DELAY.getValue()) goto L5;
    L21:
        this.d.invoke(r11);
        return;
    L5:
        if (r11.b == 0) goto L21;
        b r0 = new b(r11, new ImAlignHelper$addMessage$entry$1(this));
        com.bytedance.android.live.broadcastgame.channel.receiver.helper.a r1 = (com.bytedance.android.live.broadcastgame.channel.receiver.helper.a) this.b.getValue();
        long r4 = r11.b;
        if (r4 <= 0) goto L15;
        long r6 = r1.c;
        if (r6 <= 0) goto L15;
        if (r1.b <= 0) goto L15;
        long r2 = Math.max(com.bytedance.android.live.broadcastgame.channel.receiver.helper.a.e, Math.min(com.bytedance.android.live.broadcastgame.channel.receiver.helper.a.d, (r4 - r6) - (System.currentTimeMillis() - r1.b)));
        r1.a = r2;
    L17:
        if (v.a() == false) goto L19;
        ALogger.i("AAM.ImAlignHelper", "delay " + r2);
    L19:
        this.a.postDelayed(r0, r2);
        ((PriorityQueue) this.c.getValue()).offer(r0);
        return;
    L15:
        r2 = r1.a;
        goto L17
    }
}
