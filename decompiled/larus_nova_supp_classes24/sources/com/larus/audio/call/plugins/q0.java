package com.larus.audio.call.plugins;

import com.larus.audio.call.tracer.AudioFileSaver;
import com.larus.im.service.audio.DataType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class q0 extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements v0 {
    public final String f;
    public final Lazy g;
    public String h;
    public final c i;

    public static final class a implements com.larus.im.service.audio.x {
        public final DataType a;
        public final /* synthetic */ q0 b;

        public final String getName() {
            return "DefaultAudioDumpPlugin#streamListener";
        }

        public DataType getType() {
            return this.a;
        }

        public a(q0 r1) {
            this.b = r1;
            this.a = DataType.PLAYER;
        }

        public final void a(com.larus.im.service.audio.l r5) {
            Intrinsics.checkNotNullParameter(r5, "frame");
            this.b.j3().j(3, r5.a, this.b.h);
            if (r5.d == true) goto L6;
            this.b.j3().j(1, r5.a, this.b.h);
            return;
        }
    }

    public static final class b implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ q0 b;

        public final String getName() {
            return this.a;
        }

        public b(q0 r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r3, jd9.c r4) {
            Intrinsics.checkNotNullParameter(r3, "oldState");
            Intrinsics.checkNotNullParameter(r4, "newState");
            if ((r4 instanceof jd9.c.a) == false) goto L10;
            q0 r5 = this.b;
            r4.getClass();
            Intrinsics.checkNotNullParameter("roomId", "key");
            ouc.d0 r6 = r4.b;
            if (r6 == null) goto L7;
            String r7 = sf9.a.c(r6, "roomId", "");
        L8:
            r5.h = r7;
            return;
        L7:
            r7 = null;
            goto L8
        }
    }

    public static final class c implements com.larus.im.service.audio.o {
        public final /* synthetic */ q0 a;

        public c(q0 r1) {
            this.a = r1;
        }

        public final void j(byte[] r4) {
            Intrinsics.checkNotNullParameter(r4, "content");
            this.a.j3().j(19, r4, this.a.h);
        }

        public final void c(byte[] r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "content");
            if (r4 == false) goto L5;
            this.a.j3().j(8, r3, this.a.h);
            return;
        L5:
            this.a.j3().j(5, r3, this.a.h);
        }

        public final void i(byte[] r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "content");
            if (r4 == false) goto L5;
            this.a.j3().j(5, r3, this.a.h);
            return;
        L5:
            this.a.j3().j(8, r3, this.a.h);
        }
    }

    @Override // com.larus.audio.call.plugins.v0
    public final void F1(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.x Q2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    public final AudioFileSaver j3() {
        return (AudioFileSaver) this.g.getValue();
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        j3().i();
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        id9.d r0 = getContext().j();
        if (r0 == null) goto L6;
        r0.A(this.i);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        id9.d r0 = getContext().j();
        if (r0 == null) goto L6;
        r0.A(null);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f;
    }

    public q0(final com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "DefaultAudioDumpPlugin";
        this.g = LazyKt.lazy(new p0(r2));
        this.i = new c(this);
    }

    @Override // com.larus.audio.call.plugins.v0
    public final void i(byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        if (getContext().params().y == false) goto L5;
        j3().j(4, r4, this.h);
        return;
    L5:
        j3().j(2, r4, this.h);
    }

    @Override // com.larus.audio.call.plugins.v0
    public final void q2(byte[] r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        j3().k(r4, r3, this.h);
    }
}
