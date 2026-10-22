package com.larus.avlink.simulInterpret.plugin;

import com.larus.audio.call.arch.n;
import com.larus.audio.call.plugins.e;
import com.larus.audio.call.plugins.v0;
import com.larus.avlink.n1;
import com.larus.avlink.plugins.n4;
import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.l;
import com.larus.im.service.audio.s;
import com.larus.im.service.audio.x;
import fa8.f;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b extends e<n4> {
    public static final /* synthetic */ int m = 0;
    public final Function0<s> l;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.avlink.simulInterpret.plugin.b$b, reason: collision with other inner class name */
    public static final class C0028b implements x {
        public final DataType a;
        public final /* synthetic */ b b;

        public final String getName() {
            return "SiFrameReceiver";
        }

        public DataType getType() {
            return this.a;
        }

        public C0028b(b r1) {
            this.b = r1;
            this.a = DataType.PLAYER;
        }

        public final void a(l r9) {
            Intrinsics.checkNotNullParameter(r9, "frame");
            if (r9.d == true) goto L32;
            b r0 = this.b;
            int r2 = b.m;
            r0.getClass();
            String r3 = sf9.a.d(r9.b(), "src_channel");
            n1.d("SiFrameReceiver", "audio play enqueue: " + r9.a.length + ", data srcChannel = " + r3 + ", ");
            if (Intrinsics.areEqual(r3, "0") == false) goto L19;
            f r1 = ((com.larus.avlink.simulInterpret.plugin.a) r0.getContext().b(Reflection.getOrCreateKotlinClass(com.larus.avlink.simulInterpret.plugin.a.class), null)).f2();
            byte[] r4 = r9.a;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "data");
            if (r1.g == false) goto L12;
            ReentrantLock r6 = r1.h;
            r6.lock();
            r1.a();     // Catch: Throwable -> L15
            r1.e.a(r4);     // Catch: Throwable -> L15
            n1.d("StereoAudioPlayer", "Feed right channel data size=" + r4.length + ". " + r1.b());     // Catch: Throwable -> L15
            r1.i.signal();     // Catch: Throwable -> L15
            Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
            r6.unlock();
        L15:
            th = move-exception;
            r6.unlock();
            throw th;
        L12:
            v0 r7 = com.larus.audio.call.arch.b.b(r0.getContext());
            if (r7 == null) goto L38;
            r7.q2(r9.a, 15);
            return;
        L38:
            return;
        L19:
            if (Intrinsics.areEqual(r3, "1") == false) goto L40;
            f r8 = ((com.larus.avlink.simulInterpret.plugin.a) r0.getContext().b(Reflection.getOrCreateKotlinClass(com.larus.avlink.simulInterpret.plugin.a.class), null)).f2();
            byte[] r10 = r9.a;
            r8.getClass();
            Intrinsics.checkNotNullParameter(r10, "data");
            if (r8.g == false) goto L26;
            ReentrantLock r11 = r8.h;
            r11.lock();
            r8.a();     // Catch: Throwable -> L29
            r8.d.a(r10);     // Catch: Throwable -> L29
            n1.d("StereoAudioPlayer", "Feed left channel data size=" + r10.length + ". " + r8.b());     // Catch: Throwable -> L29
            r8.i.signal();     // Catch: Throwable -> L29
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L29
            r11.unlock();
        L29:
            th = move-exception;
            r11.unlock();
            throw th;
        L26:
            v0 r13 = com.larus.audio.call.arch.b.b(r0.getContext());
            if (r13 == null) goto L41;
            r13.q2(r9.a, 14);
            return;
        L41:
            return;
        L40:
            return;
        L32:
            n1.d("SiFrameReceiver", "zchhhhh, audio scrChannel is 0");
        }
    }

    static {
    }

    public final x Q2() {
        return new C0028b(this);
    }

    public b(n4 r2, n r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "postProcessor");
        super(r2, r3);
        this.l = r3;
    }
}
