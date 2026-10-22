package com.bytedance.android.livesdk.gamesticker.hok;

import com.bytedance.android.livesdk.chatroom.model.b2;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.chatroom.model.n0;
import com.bytedance.android.livesdk.chatroom.model.o;
import com.bytedance.android.livesdk.chatroom.model.p;
import com.bytedance.android.livesdk.gamesticker.hok.machine.BattleMachine;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public final BattleMachine a;
    public Disposable b;
    public Disposable c;
    public Disposable d;
    public int e;
    public int f;
    public int g;
    public c3 h;
    public b2 i;
    public k2 j;
    public j0 k;
    public o l;

    public final void e() {
        c3 r0 = this.h;
        if (r0 == null) goto L8;
        j0 r1 = this.k;
        if (r1 == null) goto L9;
        this.a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.d(r0, r1));
        return;
    L9:
        return;
    }

    public d(HokGameStickerView r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.a = new BattleMachine(r2);
    }

    public static final void a(d r3) {
        c3 r0 = r3.h;
        if (r0 == null) goto L8;
        k2 r1 = r3.j;
        if (r1 == null) goto L9;
        r3.a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.e(r0, r1));
        return;
    L9:
        return;
    }

    public static j0 b(o r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.a() == null) goto L17;
        j0 r0 = r5.a();
        if (r0 == null) goto L9;
        long r3 = r0.a();
    L11:
        if (r3 > 0) goto L13;
        return null;
    L13:
        return r5.a();
    L9:
        r3 = 0;
        goto L11
    L17:
        return null;
    }

    public static k2 c(o r4) {
        if (r4 != null) goto L5;
    L29:
        return null;
    L5:
        if (r4.b() == null) goto L29;
        k2 r5 = r4.b();
        if (r5 == null) goto L10;
        String r1 = r5.b();
    L11:
        boolean r2 = true;
        if (r1 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L29;
        if (r5 == null) goto L21;
        String r6 = r5.a();
    L22:
        if (r6 != null) goto L24;
    L27:
        if (r2 == true) goto L29;
        return r5;
    L24:
        if (r6.length() == 0) goto L27;
        r2 = false;
        goto L27
    L21:
        r6 = null;
        goto L22
    L14:
        if (r1.length() == 0) goto L17;
        r3 = false;
        goto L18
    L10:
        r1 = null;
        goto L11
    }

    public final void d(n0 r13) {
        Intrinsics.checkNotNullParameter(r13, "info");
        c3 r0 = r13.d();
        boolean r1 = false;
        Integer r2 = null;
        if (r0 == null) goto L54;
        String r4 = r0.a();
        if (r4 != null) goto L8;
    L11:
        boolean r5 = true;
    L12:
        if (r5 == true) goto L21;
        String r6 = r0.b();
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L21;
    L55:
        this.h = r0;
        b2 r3 = r13.c();
        if (r3 == null) goto L73;
        String r8 = r3.c();
        if (r8 != null) goto L61;
    L64:
        boolean r9 = true;
    L65:
        if (r9 == false) goto L74;
        String r10 = r3.a();
        if (r10 != null) goto L69;
    L70:
        r1 = true;
    L71:
        if (r1 == true) goto L73;
    L69:
        if (r10.length() != 0) goto L71;
    L74:
        this.i = r3;
        this.k = b(r13.a());
        this.j = c(r13.a());
        o r11 = r13.a();
        if (b(r11) == null) goto L77;
    L80:
        this.l = r11;
        p r14 = r13.b();
        if (r14 == null) goto L92;
        this.e = r14.c();
        this.f = r14.a();
        this.g = r14.b();
        r14.toString();
        if (this.e > 0) goto L87;
        this.e = 5;
    L87:
        if (this.f > 0) goto L90;
        this.f = 10;
    L90:
        if (this.g > 0) goto L92;
        this.g = 5;
    L92:
        c3 r15 = this.h;
        if (r15 != null) goto L95;
    L113:
        long r12 = 10;
        long r16 = 5;
        if (r15 != null) goto L116;
    L148:
        if (r15 != null) goto L150;
    L170:
        if (r15 != null) goto L172;
        return;
    L172:
        if (this.i != null) goto L174;
        return;
    L174:
        if (this.k != null) goto L176;
        return;
    L176:
        if (this.j == null) goto L238;
        Objects.toString((com.bytedance.android.livesdk.gamesticker.hok.machine.c) this.a.a.b());
        Disposable r17 = this.b;
        if (r17 == null) goto L180;
        r17.dispose();
    L180:
        this.b = null;
        if (Intrinsics.areEqual((com.bytedance.android.livesdk.gamesticker.hok.machine.c) this.a.a.b(), com.bytedance.android.livesdk.gamesticker.hok.machine.c.b.a) == true) goto L183;
    L191:
        this.a.a(com.bytedance.android.livesdk.gamesticker.hok.machine.a.C0362a.a);
        b2 r18 = this.i;
        if (r18 == null) goto L194;
        Integer r19 = r18.b();
    L195:
        if (r19 == null) goto L216;
        b2 r110 = this.i;
        if (r110 == null) goto L199;
        r2 = r110.b();
    L199:
        if (r2 != null) goto L202;
    L204:
        c3 r111 = this.h;
        if (r111 == null) goto L209;
        b2 r20 = this.i;
        if (r20 == null) goto L209;
        this.a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.f(r111, r20));
    L209:
        int r112 = this.e;
        if (r112 <= 0) goto L213;
        r16 = r112;
    L213:
        Disposable r113 = Observable.timer(r16, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(new HokGameViewController$enterContinueBattleState$4(this)));
        if (r113 == null) goto L242;
        this.d = r113;
        return;
    L242:
        return;
    L202:
        if (r2.intValue() != 0) goto L204;
    L216:
        e();
        int r114 = this.f;
        if (r114 <= 0) goto L220;
        r12 = r114;
    L220:
        long r21 = r12;
        int r115 = this.g;
        if (r115 <= 0) goto L224;
        r16 = r115;
    L224:
        Disposable r116 = f(r21, r16, new HokGameViewController$enterContinueBattleState$1(this), new HokGameViewController$enterContinueBattleState$2(this));
        if (r116 == null) goto L244;
        this.c = r116;
        return;
    L244:
        return;
    L194:
        r19 = null;
        goto L195
    L183:
        if (this.c == null) goto L185;
    L186:
        c3 r117 = this.h;
        if (r117 == null) goto L239;
        o r22 = this.l;
        if (r22 == null) goto L240;
        this.a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.i(r117, r22));
        return;
    L240:
        return;
    L239:
        return;
    L185:
        if (this.d == null) goto L191;
    L238:
        return;
    L150:
        if (this.i == null) goto L170;
        if (this.k != null) goto L170;
        if (this.j != null) goto L170;
        Disposable r118 = this.b;
        if (r118 == null) goto L158;
        r118.dispose();
    L158:
        this.b = null;
        Disposable r119 = this.d;
        if (r119 == null) goto L161;
        r119.dispose();
    L161:
        this.d = null;
        Disposable r120 = this.c;
        if (r120 == null) goto L164;
        r120.dispose();
    L164:
        this.c = null;
        this.a.a(com.bytedance.android.livesdk.gamesticker.hok.machine.a.b.a);
        c3 r121 = this.h;
        if (r121 == null) goto L233;
        b2 r23 = this.i;
        if (r23 == null) goto L234;
        this.a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.f(r121, r23));
        return;
    L234:
        return;
    L233:
        return;
    L116:
        if (this.i != null) goto L148;
        if (this.k == null) goto L148;
        if (this.j == null) goto L148;
        Disposable r122 = this.d;
        if (r122 == null) goto L124;
        r122.dispose();
    L124:
        this.d = null;
        Disposable r123 = this.c;
        if (r123 == null) goto L127;
        r123.dispose();
    L127:
        this.c = null;
        if (Intrinsics.areEqual((com.bytedance.android.livesdk.gamesticker.hok.machine.c) this.a.a.b(), com.bytedance.android.livesdk.gamesticker.hok.machine.c.C0364c.a) == true) goto L130;
    L136:
        this.a.a(com.bytedance.android.livesdk.gamesticker.hok.machine.a.h.a);
        e();
        int r124 = this.f;
        if (r124 <= 0) goto L140;
        r12 = r124;
    L140:
        long r24 = r12;
        int r125 = this.g;
        if (r125 <= 0) goto L144;
        r16 = r125;
    L144:
        Disposable r126 = f(r24, r16, new HokGameViewController$enterInFirstBattleState$1(this), new HokGameViewController$enterInFirstBattleState$2(this));
        if (r126 == null) goto L232;
        this.b = r126;
        return;
    L232:
        return;
    L130:
        if (this.b == null) goto L136;
        c3 r127 = this.h;
        if (r127 == null) goto L229;
        o r25 = this.l;
        if (r25 == null) goto L230;
        this.a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.i(r127, r25));
        return;
    L230:
        return;
    L229:
        return;
    L95:
        if (this.i != null) goto L113;
        if (this.k != null) goto L113;
        if (this.j != null) goto L113;
        Disposable r128 = this.b;
        if (r128 == null) goto L103;
        r128.dispose();
    L103:
        this.b = null;
        Disposable r129 = this.d;
        if (r129 == null) goto L106;
        r129.dispose();
    L106:
        this.d = null;
        Disposable r130 = this.c;
        if (r130 == null) goto L109;
        r130.dispose();
    L109:
        this.c = null;
        this.a.a(com.bytedance.android.livesdk.gamesticker.hok.machine.a.c.a);
        c3 r131 = this.h;
        if (r131 == null) goto L228;
        this.a.a(new com.bytedance.android.livesdk.gamesticker.hok.machine.a.g(r131));
        return;
    L228:
        return;
    L77:
        if (c(r11) != null) goto L80;
        r11 = null;
        goto L80
    L61:
        if (r8.length() == 0) goto L64;
        r9 = false;
    L73:
        r3 = null;
        goto L74
    L16:
        if (r6.length() == 0) goto L19;
        r7 = false;
    L21:
        String r26 = r0.e();
        if (r26 != null) goto L24;
    L27:
        boolean r27 = true;
    L28:
        if (r27 == true) goto L37;
        String r28 = r0.f();
        if (r28 != null) goto L32;
    L35:
        boolean r29 = true;
    L36:
        if (r29 == false) goto L55;
    L32:
        if (r28.length() == 0) goto L35;
        r29 = false;
    L37:
        String r30 = r0.d();
        if (r30 != null) goto L40;
    L43:
        boolean r31 = true;
    L44:
        if (r31 == true) goto L54;
        String r32 = r0.c();
        if (r32 != null) goto L48;
    L51:
        boolean r33 = true;
    L52:
        if (r33 == true) goto L54;
    L48:
        if (r32.length() == 0) goto L51;
        r33 = false;
        goto L52
    L40:
        if (r30.length() == 0) goto L43;
        r31 = false;
        goto L44
    L24:
        if (r26.length() == 0) goto L27;
        r27 = false;
        goto L28
    L8:
        if (r4.length() == 0) goto L11;
        r5 = false;
    L54:
        r0 = null;
        goto L55
    }

    public final Disposable f(long r17, long r19, Function0 r21, Function0 r22) {
        return Observable.intervalRange(0, 1 + (r17 + r19), 0, 1, TimeUnit.SECONDS).repeat().filter(new b(r17, r19)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, r17, r22, r19, r21));
    }
}
