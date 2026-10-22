package p2a;

import com.larus.im.bean.bot.SpeakerVoice;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.jvm.internal.Intrinsics;
import ouc.d0;
import w2a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z implements h {

    public static final class a implements p2a.a {
        public a() {
        }

        @Override // p2a.a
        public final boolean a() {
            return false;
        }

        @Override // p2a.a
        public final boolean b(String r1) {
            return false;
        }

        @Override // p2a.a
        public final boolean d(String r1) {
            return false;
        }

        @Override // p2a.a
        public final boolean e() {
            return false;
        }

        @Override // p2a.a
        public final p c() {
            return new p(0);
        }
    }

    public static final class b implements v2a.b {
        public b() {
        }

        @Override // v2a.b
        public final void a(f r1, String r2, String r3, String r4, SpeakerVoice r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "previousPage");
            Intrinsics.checkNotNullParameter(r4, "scene");
        }
    }

    public static final class c implements d {
        public c() {
        }

        @Override // p2a.d
        public final void a(SpeakerVoice r3, String r4, boolean r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, Float r13, Float r14, Integer r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, d0 r24) {
            Intrinsics.checkNotNullParameter(r24, LynxResourceModule.PARAMS_KEY);
        }
    }

    public z() {
    }

    public final void G(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
    }

    public final void T0(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
    }

    public final void X2(d0 r2) {
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
    }

    public final d a3() {
        return new c();
    }

    public final v2a.b f7() {
        return new b();
    }

    public final p2a.a l2() {
        return new a();
    }
}
