package ko1;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.widgetdescriptor.data.LandscapeInteractionModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class b implements c {
    public final e a;
    public final f b;
    public final g c;
    public final h d;
    public boolean e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final View j;
    public final ViewGroup k;
    public final LandscapeInteractionModel l;
    public final com.bytedance.android.live.platformplayer.layout.c m;

    @Override // ko1.c
    public final void a() {
        this.a.c = true;
        this.c.q = true;
        if (LiveInitSettingKeys.get_LIVE_PLAYER_LAYOUT_V1_ENABLE() == true) goto L6;
        this.j.getViewTreeObserver().addOnPreDrawListener(new a(this));
        return;
    }

    public final void e() {
        e r0 = this.a;
        r0.a = 1.0f;
        r0.b = 1.0f;
        r0.f = false;
        r0.g = true;
        g r1 = this.c;
        r1.a = 1.0f;
        r1.r = 1.0f;
        r1.s = 1.0f;
        r1.b = 0.0f;
        r1.c = 0.0f;
        r1.d = 0.0f;
        r1.e = 0.0f;
        r1.f = 0.0f;
        r1.g = 0.0f;
        r1.h = false;
        r1.i = 0;
        r1.j = 0;
        r1.k = 0;
        r1.l = 0;
        r1.m = 0.0f;
        r1.n = 0.0f;
        r1.o = 0.0f;
        r1.p = 0.0f;
    }

    @Override // ko1.c
    public boolean b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "resetType");
        if (this.j.getScaleX() == 1.0f) goto L5;
    L7:
        this.j.setScaleX(1.0f);
        this.j.setScaleY(1.0f);
        this.j.setX(this.h);
        this.j.setY(this.i);
        this.j.setPivotX(this.f);
        this.j.setPivotY(this.g);
        e();
        d(false);
        int r5 = x6.a;
        x6.e = false;
        com.bytedance.android.live.platformplayer.layout.c r6 = this.m;
        if (r6 == null) goto L12;
        r6.setScaleX(1.0f);
        r6.setScaleY(1.0f);
        r6.setTranslationX(0.0f);
        r6.setTranslationY(0.0f);
        return true;
    L12:
        return true;
    L5:
        if (this.j.getScaleY() != 1.0f) goto L7;
        return false;
    }

    @Override // ko1.c
    public boolean c(MotionEvent r15) {
        Intrinsics.checkNotNullParameter(r15, "event");
        if (x6.c() == true) goto L8;
        if (x6.e() == true) goto L8;
        return false;
    L8:
        if (r15.getPointerCount() != 1) goto L14;
        if (this.e == false) goto L14;
        return this.d.onTouchEvent(r15);
    L14:
        if (r15.getPointerCount() == 2) goto L20;
        if (this.e == false) goto L20;
        return false;
    L20:
        if (r15.getAction() != 1) goto L22;
        boolean r0 = true;
    L23:
        this.e = r0;
        if (r0 == false) goto L30;
        e r1 = this.a;
        if (r1.c == false) goto L30;
        if (r1.b >= r1.e) goto L30;
        r1.a = 1.0f;
        r1.a(Float.valueOf(1.0f), Float.valueOf(r1.a));
        r1.b = r1.a;
    L30:
        e r2 = this.a;
        r2.getClass();
        float r4 = x6.a();
        float r5 = r2.a;
        float r6 = r2.d;
        if (r5 > (r6 * r4)) goto L35;
        r6 = r2.e;
        if (r5 < (r6 * r4)) goto L35;
    L36:
        g r3 = this.c;
        r3.getClass();
        if (x6.a != 1) goto L42;
        float r7 = r5 / x6.a();
        if (x6.b == false) goto L41;
        float r8 = r7;
        r7 = r5;
    L43:
        float r9 = r3.i;
        float r10 = r9 * r7;
        r3.d = r10;
        r3.e = r3.j * r8;
        if (r10 < r3.k) goto L46;
        float r11 = r10 - r9;
        float r12 = 2;
        r3.m = (r11 / r12) - (r3.u.getWidth() - r3.t.getRight());
        float r13 = ((r3.d - r3.i) / r12) - r3.t.getLeft();
        r3.o = r13;
        float r14 = r3.r;
        if (r7 >= r14) goto L68;
        float r16 = r3.b;
        if (r16 >= 0) goto L68;
        if ((-r16) <= r3.m) goto L68;
        float r17 = (r3.f - r3.d) / r12;
        r3.a(r3.t.getTranslationX() + r17);
        r3.b += r17;
    L74:
        float r18 = r3.e;
        if (r18 >= r3.l) goto L92;
        float r19 = 2;
        r3.n = r3.t.getTop() - ((r3.e - r3.j) / r19);
        r3.p = (r3.u.getHeight() - r3.t.getBottom()) - ((r3.e - r3.j) / r19);
        if (r3.q == false) goto L79;
        r3.c = 0.0f;
        r3.b(0.0f);
    L79:
        float r20 = r3.s;
        if (r8 <= r20) goto L86;
        float r21 = r3.c;
        if (r21 >= 0) goto L86;
        if ((-r21) <= r3.n) goto L86;
        float r22 = (r3.e - r3.g) / r19;
        r3.b(r3.t.getTranslationY() + r22);
        r3.c += r22;
    L105:
        r3.f = r3.d;
        r3.g = r3.e;
        r3.a = r5;
        r3.r = r7;
        r3.s = r8;
        if (r5 <= x6.a()) goto L108;
        d(true);
        x6.e = true;
    L110:
        return this.b.onTouchEvent(r15);
    L108:
        d(false);
        x6.e = false;
    L86:
        if (r8 <= r20) goto L105;
        float r23 = r3.c;
        if (r23 <= 0) goto L105;
        if (r23 <= r3.p) goto L105;
        float r24 = (r3.e - r3.g) / r19;
        r3.b(r3.t.getTranslationY() - r24);
        r3.c -= r24;
        goto L105
    L92:
        float r25 = 2;
        r3.n = ((r18 - r3.j) / r25) - (r3.u.getHeight() - r3.t.getBottom());
        float r26 = ((r3.e - r3.j) / r25) - r3.t.getTop();
        r3.p = r26;
        float r27 = r3.s;
        if (r8 >= r27) goto L99;
        float r28 = r3.c;
        if (r28 >= 0) goto L99;
        if ((-r28) <= r3.n) goto L99;
        float r29 = (r3.g - r3.e) / r25;
        r3.b(r3.t.getTranslationY() + r29);
        r3.c += r29;
    L99:
        if (r8 >= r27) goto L105;
        float r30 = r3.c;
        if (r30 <= 0) goto L105;
        if (r30 <= r26) goto L105;
        float r31 = (r3.g - r3.e) / r25;
        r3.b(r3.t.getTranslationY() - r31);
        r3.c -= r31;
    L68:
        if (r7 >= r14) goto L74;
        float r32 = r3.b;
        if (r32 <= 0) goto L74;
        if (r32 <= r13) goto L74;
        float r33 = (r3.f - r3.d) / r12;
        r3.a(r3.t.getTranslationX() - r33);
        r3.b -= r33;
        goto L74
    L46:
        if (r3.q == false) goto L48;
        r3.b = 0.0f;
        r3.a(0.0f);
    L48:
        float r34 = 2;
        r3.m = r3.t.getLeft() - ((r3.d - r3.i) / r34);
        float r35 = r3.u.getWidth() - r3.t.getRight();
        float r36 = r3.d;
        float r37 = r35 - ((r36 - r3.i) / r34);
        r3.o = r37;
        float r110 = r3.r;
        if (r7 <= r110) goto L55;
        float r111 = r3.b;
        if (r111 >= 0) goto L55;
        if ((-r111) <= r3.m) goto L55;
        float r38 = (r36 - r3.f) / r34;
        r3.a(r3.t.getTranslationX() + r38);
        r3.b += r38;
    L55:
        if (r7 <= r110) goto L74;
        float r112 = r3.b;
        if (r112 <= 0) goto L74;
        if (r112 <= r37) goto L74;
        float r39 = (r36 - r3.f) / r34;
        r3.a(r3.t.getTranslationX() - r39);
        r3.b -= r39;
        goto L74
    L41:
        r8 = r5;
        goto L43
    L42:
        r7 = r5;
        r8 = r7;
    L35:
        r5 = r6 * r4;
        goto L36
    L22:
        r0 = false;
        goto L23
    }

    public void d(boolean r2) {
        LandscapeInteractionModel r0 = this.l;
        if (r0 == null) goto L8;
        MutableLiveData r1 = r0.isInZoomState();
        if (r1 == null) goto L9;
        r1.setValue(Boolean.valueOf(r2));
        return;
    L9:
        return;
    }

    public b(Context r2, View r3, ViewGroup r4, LandscapeInteractionModel r5, com.bytedance.android.live.platformplayer.layout.c r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "targetView");
        Intrinsics.checkNotNullParameter(r4, "viewGroup");
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        e r7 = new e(r3, r4, r6);
        this.a = r7;
        this.b = new f(r2, r7);
        g r8 = new g(r3, r4, r6);
        this.c = r8;
        this.d = new h(r2, r8);
        this.e = true;
        r3.setClickable(false);
        this.h = r3.getX();
        this.i = r3.getY();
        this.f = r3.getPivotX();
        this.g = r3.getPivotY();
    }
}
