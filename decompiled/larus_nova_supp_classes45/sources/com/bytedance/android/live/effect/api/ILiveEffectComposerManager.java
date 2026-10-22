package com.bytedance.android.live.effect.api;

import android.view.SurfaceView;
import com.bytedance.android.live.effect.beauty.presets.LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1;
import com.bytedance.android.live.effect.common.LiveCommonStickerUIViewModel;
import com.bytedance.android.livesdk.widget.BroadcastKtvEffectMusicWidget;
import com.bytedance.android.livesdk.widget.u2;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface ILiveEffectComposerManager {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$EffectInstanceType;", "", "DEFAULT", "SPECIAL", "RENDER_FILTER", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EffectInstanceType extends Enum<EffectInstanceType> {
        public static final EffectInstanceType DEFAULT = null;
        public static final EffectInstanceType RENDER_FILTER = null;
        public static final EffectInstanceType SPECIAL = null;
        public static final /* synthetic */ EffectInstanceType[] a = null;

        static {
            EffectInstanceType r1 = new EffectInstanceType("DEFAULT", 0);
            DEFAULT = r1;
            EffectInstanceType r2 = new EffectInstanceType("SPECIAL", 1);
            SPECIAL = r2;
            EffectInstanceType r3 = new EffectInstanceType("RENDER_FILTER", 2);
            RENDER_FILTER = r3;
            a = new EffectInstanceType[]{r1, r2, r3};
        }

        public static EffectInstanceType valueOf(String r1) {
            return (EffectInstanceType) r27.a.a(EffectInstanceType.class, r1);
        }

        public static EffectInstanceType[] values() {
            return (EffectInstanceType[]) a.clone();
        }

        public EffectInstanceType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a();
    }

    public interface b {
        void F(String r1, Sticker r2, String r3, float r4);
    }

    public interface c extends b {

        public static final class a {
            public static void a(c r6, String r7, Sticker r8, String r9, float r11) {
                r6.u2(r7, r8, r9, r11, null);
            }
        }

        void u2(String r1, Sticker r2, String r3, float r4, HashMap<String, String> r5);
    }

    public interface d {
        void a(String r1, Sticker r2);

        void b(boolean r1, String r2, Sticker r3);
    }

    public interface e extends d, k {
        void d(boolean r1, String r2, Sticker r3, HashMap<String, String> r4);

        void e(String r1, Sticker r2);
    }

    public static final class f {
        public static /* synthetic */ void b(ILiveEffectComposerManager r2, String r3, String r4) {
            r2.k(r3, r4, null, true);
        }

        public static /* synthetic */ void e(ILiveEffectComposerManager r6, String r7, Sticker r8, String r9, float r11) {
            r6.J(r7, r8, r9, r11, EffectInstanceType.DEFAULT);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(ILiveEffectComposerManager r9, String r11, Sticker r12, String r13, HashMap r14, com.bytedance.android.live.effect.base.e r15, int r16) {
            EffectInstanceType r1 = null;
            if ((r16 & 8) == 0) goto L5;
            HashMap r6 = null;
        L7:
            if ((r16 & 16) == 0) goto L9;
            com.bytedance.android.live.effect.base.e r7 = null;
        L11:
            if ((r16 & 32) == 0) goto L13;
            r1 = EffectInstanceType.DEFAULT;
        L13:
            r9.I(r11, r12, r13, r6, r7, r1);
            return;
        L9:
            r7 = r15;
            goto L11
        L5:
            r6 = r14;
            goto L7
        }

        public static /* synthetic */ void c(ILiveEffectComposerManager r8, String r9, Sticker r11, Sticker r12, String r13, HashMap r14, com.bytedance.android.live.effect.base.e r15) {
            r8.Q(r9, r11, r12, r13, r14, r15, EffectInstanceType.DEFAULT);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(ILiveEffectComposerManager r9, String r11, Sticker r12, String r13, float r14, HashMap r15, int r16) {
            if ((r16 & 16) == 0) goto L5;
            EffectInstanceType r7 = EffectInstanceType.DEFAULT;
        L7:
            if ((r16 & 32) == 0) goto L9;
            HashMap r8 = null;
        L10:
            r9.C(r11, r12, r13, r14, r7, r8);
            return;
        L9:
            r8 = r15;
            goto L10
        L5:
            r7 = null;
            goto L7
        }
    }

    public static final class g {
        public final int a;
        public final int b;
        public final int c;
        public final String d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof g) == false) goto L14;
            g r4 = (g) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
            String r1 = this.d;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "EffectMsg(messageType=" + this.a + ", arg1=" + this.b + ", arg2=" + this.c + ", arg3=" + this.d + ")";
        }

        public g(int r1, int r2, int r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public interface h {
        void a(List<String> r1);
    }

    public interface i {
        void a(boolean r1, String r2, List<Sticker> r3);
    }

    public interface j {
        void a(long r1, Map<String, Long> r3);
    }

    public interface k {
        void c(List<com.bytedance.android.live.effect.composer.n> r1, Map<String, ? extends List<Sticker>> r2);
    }

    void A(LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r1);

    boolean B(Sticker r1);

    void C(String r1, Sticker r2, String r3, float r4, EffectInstanceType r5, HashMap<String, String> r6);

    void D();

    boolean E(Sticker r1);

    void F(boolean r1);

    Float G(String r1, String r2);

    Pair<Boolean, Boolean> H();

    void I(String r1, Sticker r2, String r3, HashMap<String, String> r4, com.bytedance.android.live.effect.base.e r5, EffectInstanceType r6);

    void J(String r1, Sticker r2, String r3, float r4, EffectInstanceType r5);

    void K(c r1);

    void L(String r1);

    void M();

    Map<Long, String> N(String r1);

    void O(String r1, Sticker r2, String r3);

    List<com.bytedance.android.live.effect.composer.n> P();

    void Q(String r1, Sticker r2, Sticker r3, String r4, HashMap<String, String> r5, com.bytedance.android.live.effect.base.e r6, EffectInstanceType r7);

    List<com.bytedance.android.live.effect.composer.n> R();

    void S(String r1, Sticker r2, Sticker r3);

    void T(String r1, boolean r2);

    int U(String r1);

    void V(d r1);

    boolean W();

    void a(String r1, Sticker r2, String r3);

    void b(String r1, String r2);

    Map<String, Map<String, Sticker>> c();

    void d(String r1, List<? extends Effect> r2, Function1<? super Effect, Boolean> r3);

    List<com.bytedance.android.live.effect.composer.n> e();

    void f(LiveBeautyPresetsFragment$waitForRestoreComplete$restoreListener$1 r1);

    void g(d r1);

    void h(String r1, LiveCommonStickerUIViewModel.b r2);

    void i(SurfaceView r1);

    void j(String r1, h r2);

    void k(String r1, String r2, HashMap<String, String> r3, boolean r4);

    void l(c r1);

    void m(String r1, LiveCommonStickerUIViewModel.b r2);

    void n(String r1, String r2);

    List<Sticker> o(String r1);

    boolean p();

    void q();

    void r(BroadcastKtvEffectMusicWidget.h r1);

    Disposable s(String r1, String r2, u2.a r3);

    void t(String r1, String r2, HashMap<String, String> r3);

    void u();

    void v(g r1, EffectInstanceType r2, String r3);

    void w(String r1, String r2);

    void x(String r1);

    void y(com.bytedance.android.live.effect.sticker.presenter.q.a r1);

    int z(String[] r1, int[] r2, String r3);
}
