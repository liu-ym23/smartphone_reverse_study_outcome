package nc;

import ac.k;
import android.content.Context;
import android.media.SoundPool;
import android.provider.Settings;
import android.view.VelocityTracker;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import com.obric.cae.R;
import com.obric.oui.picker.reels.views.WheelView;
import defpackage.c;
import he.i;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends OverScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f9514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f9516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f9518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WheelView f9519g;

    public b(Context r8, WheelView r10) {
        i.f(r10, "mWheelView");
        super(r8, new LinearInterpolator());
        this.f9519g = r10;
    L13:
        e = move-exception;
        zc.b.c("ScrollerExt", "init reflect error", e);
        t2.b.A = false;
    L15:
        this.f9518f = -1;
        return;
    L4:
        if (t2.b.f12264x != null) goto L7;
        t2.b.f12264x = OverScroller.class;     // Catch: Exception -> L13
    L7:
        if (t2.b.f12265y != null) goto L11;
        Class r11 = t2.b.f12264x;     // Catch: Exception -> L13
        i.c(r11);     // Catch: Exception -> L13
        Method r12 = r11.getDeclaredMethod("getSplineFlingDistance", new Class[]{Integer.TYPE});     // Catch: Exception -> L13
        t2.b.f12265y = r12;     // Catch: Exception -> L13
        if (r12 == null) goto L11;
        r12.setAccessible(true);     // Catch: Exception -> L13
    L11:
        t2.b.A = true;     // Catch: Exception -> L13
        goto L15
    }

    public static void c(b r8) {
        WheelView r10 = r8.f9519g;
        int r11 = r10.getItemHeightPx();
        int r12 = r8.f9513a;
        int r13 = r12 % r11;
        if (r13 <= 0) goto L8;
        if (r13 >= (r11 / 2)) goto L8;
    L13:
        r8.f9515c = true;
        int r14 = -r13;
    L17:
        r8.f("justify", r12, r14, 200);
        r10.invalidate();
        return;
    L8:
        if (r13 >= (r11 / 2)) goto L16;
        if (r13 < 0) goto L12;
    L14:
        r11 = -r11;
        if (r13 <= (r11 / 2)) goto L16;
        return;
    L12:
        if (r13 <= ((-r11) / 2)) goto L14;
    L16:
        r8.f9515c = true;
        r14 = r11 - r13;
        goto L17
    }

    public final void a(int r8, String r10) {
        this.f9513a += r8;
        WheelView r11 = this.f9519g;
        if (r11.E == true) goto L10;
        int r12 = r11.getItemHeightPx() * (r11.getItemSize() - 1);
        int r13 = r11.getItemHeightPx() * 0;
        int r14 = this.f9513a;
        int r15 = -r13;
        if (r14 >= r15) goto L7;
        this.f9513a = r15;
        goto L10
    L7:
        int r16 = r12 + r13;
        if (r14 <= r16) goto L10;
        this.f9513a = r16;
    L10:
        d(r10);
    }

    public final int b() {
        WheelView r8 = this.f9519g;
        int r10 = r8.getItemHeightPx();
        int r11 = r8.getItemSize();
        if (r11 != 0) goto L6;
        return -1;
    L6:
        int r12 = this.f9513a;
        int r13 = r10 / 2;
        if (r12 >= 0) goto L9;
        int r14 = (r12 - r13) / r10;
    L10:
        int r15 = r14 % r11;
        if (r8.E == true) goto L14;
        if (r14 < r11) goto L14;
        r15 = r11 - 1;
    L14:
        if (r15 < 0) goto L16;
        return r15;
    L16:
        return r15 + r11;
    L9:
        r14 = (r13 + r12) / r10;
        goto L10
    }

    public final void d(String r8) {
        int r10 = this.f9518f;
        int r11 = b();
        if (r10 == r11) goto L46;
        this.f9518f = r11;
        WheelView r12 = this.f9519g;
        Context r13 = r12.getContext();
        zc.b.a("WheelScroller", "performVibrateEffect, scene: [" + r8 + ']');
        int r14 = r8.hashCode();
        if (r14 == (-1621011813)) goto L13;
        if (r14 == 530781668) goto L10;
        return;
    L10:
        if (r8.equals("computeScroll") == false) goto L47;
    L14:
        c.a0(r12, 26);
        SoundPool r15 = k.f322a;
        if (r13 != null) goto L17;
        zc.b.h("OUISoundEffectHelper", "can't play, context is null");
        return;
    L17:
        int r16 = 0;
        r16 = Settings.System.getInt(r13.getContentResolver(), "sound_effects_enabled", 0);     // Catch: Exception -> L20
    L22:
        if (r16 == 0) goto L51;
        k.a();     // Catch: Exception -> L37
        boolean r17 = k.f324c.contains(Integer.valueOf(R.raw.reel_picker));     // Catch: Exception -> L37
        ConcurrentHashMap<Integer, Integer> r18 = k.f323b;
        if (r17 == false) goto L28;
        Integer r19 = r18.get(Integer.valueOf(R.raw.reel_picker));     // Catch: Exception -> L37
        if (r19 == null) goto L42;
        SoundPool r20 = k.f322a;     // Catch: Exception -> L37
        if (r20 == null) goto L42;
        r20.play(r19.intValue(), 1.0f, 1.0f, 1, 0, 1.0f);     // Catch: Exception -> L37
    L42:
        return;
    L28:
        if (r18.containsKey(Integer.valueOf(R.raw.reel_picker)) == true) goto L30;
        zc.b.h("OUISoundEffectHelper", "not loaded, start now: resId=2131820547");     // Catch: Exception -> L37
        k.b(r13, new int[]{R.raw.reel_picker});     // Catch: Exception -> L37
        goto L42
    L30:
        zc.b.a("OUISoundEffectHelper", "loading: resId=2131820547");     // Catch: Exception -> L37
    L37:
        e = move-exception;
        zc.b.c("OUISoundEffectHelper", "play failed, resId=2131820547", e);
        return;
    L51:
        return;
    L20:
        e = move-exception;
        zc.b.c("OUISoundEffectHelper", "get sound effect enabled failed", e);
        goto L22
    L47:
        return;
    L13:
        if (r8.equals("touchEvent") == true) goto L14;
        return;
    }

    public final void e(int r8, boolean r10) {
        WheelView r11 = this.f9519g;
        int r12 = r11.getItemHeightPx() * r8;
        int r13 = this.f9513a;
        int r14 = r12 - r13;
        if (r14 != 0) goto L6;
        return;
    L6:
        if (r10 == false) goto L8;
        this.f9515c = true;
        f("setCurrentIndex", r13, r14, 200);
    L9:
        r11.invalidate();
        return;
    L8:
        a(r14, "setCurrentIndex");
        goto L9
    }

    public final void f(String r8, int r10, int r11, int r12) {
        StringBuilder r13 = defpackage.a.g("startScrollInternal, startX: 0, startY: ", r10, ", dx: 0, dy: ", r11, ", duration: ");
        r13.append(r12);
        r13.append(", scene: ");
        r13.append(r8);
        zc.b.a("WheelScroller", r13.toString());
        startScroll(0, r10, 0, r11, r12);
    }
}
