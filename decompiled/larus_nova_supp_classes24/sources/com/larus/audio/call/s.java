package com.larus.audio.call;

import com.larus.audio.call.plugins.CommonCallTimingPlugin;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class s {
    public final a a;
    public final Lazy b;
    public final Lazy c;
    public b d;
    public volatile boolean e;

    public static abstract class a {
        public a() {
        }

        public abstract boolean a();

        public abstract HangUpState b();

        public abstract void c();

        public abstract RealtimeCallParam.WaitingEventConfig d();
    }

    public static final class b extends p {
        public final /* synthetic */ s g;

        @Override // com.larus.audio.call.p
        public final void c(long r1) {
        }

        @Override // com.larus.audio.call.p
        public final void b() {
            if (this.g.a.b() == HangUpState.IDLE) goto L5;
            return;
        L5:
            if (this.g.a.a() == false) goto L9;
            this.g.a.c();
            this.g.e = true;
            return;
        }

        public b(s r3, long r4) {
            this.g = r3;
            super(r4, 1000);
        }
    }

    public final void a() {
        b r0 = this.d;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.d = null;
        this.e = false;
    }

    public final void b() {
        RealtimeCallParam.WaitingEventConfig r0 = (RealtimeCallParam.WaitingEventConfig) this.b.getValue();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.getLimitStart();
    L6:
        RealtimeCallParam.WaitingEventConfig r3 = (RealtimeCallParam.WaitingEventConfig) this.b.getValue();
        if (r3 == null) goto L10;
        r1 = r3.getLimitEnd();
    L10:
        if (((Boolean) this.c.getValue()).booleanValue() == false) goto L32;
        CoroutineScope r4 = com.larus.audio.call.util.s.a;
        RealtimeCallParam.WaitingEventConfig r5 = (RealtimeCallParam.WaitingEventConfig) this.b.getValue();
        if (r5 == null) goto L14;
        float r6 = r5.getFrequency();
    L16:
        if (com.larus.audio.call.util.s.a(r6) == false) goto L33;
        if (r2 <= 0) goto L34;
        if (r1 <= 0) goto L35;
        if (r1 < r2) goto L36;
        Integer r7 = f.d().q;
        if (r7 != null) goto L23;
    L26:
        int r8 = Random.Default.nextInt(r2, r1 + 1);
    L27:
        b r9 = this.d;
        if (r9 == null) goto L30;
        r9.a();
    L30:
        b r10 = new b(this, ((long) r8) * 1000);
        r10.d();
        this.d = r10;
        return;
    L23:
        if (r7.intValue() <= 0) goto L26;
        r8 = r7.intValue();
        goto L27
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L14:
        r6 = 0.0f;
        goto L16
    L32:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public s(CommonCallTimingPlugin.d r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
        this.b = LazyKt.lazy(new q(this));
        this.c = LazyKt.lazy(new r(this));
    }
}
