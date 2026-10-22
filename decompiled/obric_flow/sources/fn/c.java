package fn;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.bytedance.common.utility.Logger;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.utils.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f16949c;
    public Object d;

    public c(int r5) {
        this.d = new AtomicBoolean(false);
        this.f16947a = r5;
        this.f16948b = Keva.getRepo("pia_pages_info");
        this.f16949c = Keva.getRepo("pia_pages_info_last_access_time");
    }

    public void a() {
        b r5 = (b) this.f16948b;
        r5.f16936b = r5.d;
        r5.f16942l = true;
        b r10 = (b) this.f16949c;
        r10.f16936b = r10.d;
        r10.f16942l = true;
    }

    public void b(int r5, int r10, int r11, int r12, int r13) {
        this.f16947a = 0;
        b r14 = (b) this.f16948b;
        r14.f16942l = false;
        r14.f16935a = r5;
        r14.f16937c = r5;
        r14.f16936b = r5;
        r14.d = r5 + r11;
        r14.f16938h = AnimationUtils.currentAnimationTimeMillis();
        r14.f16939i = r13;
        r14.g = 0.0f;
        r14.e = 0;
        b r15 = (b) this.f16949c;
        r15.f16942l = false;
        r15.f16935a = r10;
        r15.f16937c = r10;
        r15.f16936b = r10;
        r15.d = r10 + r12;
        r15.f16938h = AnimationUtils.currentAnimationTimeMillis();
        r15.f16939i = r13;
        r15.g = 0.0f;
        r15.e = 0;
    }

    public void c(int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, int r22, int r23) {
        if (g() == true) goto L10;
        float r5 = ((b) this.f16948b).f;
        float r10 = ((b) this.f16949c).f;
        int r11 = r16;
        float r12 = r11;
        if (Math.signum(r12) != Math.signum(r5)) goto L9;
        int r13 = r17;
        float r24 = r13;
        if (Math.signum(r24) != Math.signum(r10)) goto L11;
        int r25 = (int) (r24 + r10);
        int r26 = (int) (r12 + r5);
    L12:
        this.f16947a = 1;
        if (r26 < 0.0f) goto L15;
        int r27 = r22;
    L16:
        ((b) this.f16948b).c(r14, r26, r18, r19, 0, r27);
        if (r25 < 0.0f) goto L19;
        int r110 = r22;
    L20:
        ((b) this.f16949c).c(r15, r25, r20, r21, 0, r110);
        return;
    L19:
        r110 = r23;
        goto L20
    L15:
        r27 = r23;
    L11:
        r25 = r13;
        r26 = r11;
    L9:
        r13 = r17;
        goto L11
    L10:
        r11 = r16;
        goto L9
    }

    public void d() {
        if (((Keva) this.f16949c).count() >= this.f16947a) goto L5;
        return;
    L5:
        m.b(new com.obric.oui.lisitem.a(this, 24));
    }

    public boolean e() {
        if (g() == false) goto L6;
        return false;
    L6:
        int r5 = this.f16947a;
        b r10 = (b) this.f16949c;
        b r11 = (b) this.f16948b;
        if (r5 == 0) goto L24;
        if (r5 == 1) goto L11;
    L28:
        return true;
    L11:
        if (r11.f16942l == true) goto L18;
        if (r11.f() == true) goto L18;
        if (r11.d() == true) goto L18;
        r11.f16936b = r11.d;
        r11.f16942l = true;
    L18:
        if (r10.f16942l == true) goto L28;
        if (r10.f() == true) goto L28;
        if (r10.d() == true) goto L28;
        r10.f16936b = r10.d;
        r10.f16942l = true;
        goto L28
    L24:
        long r12 = AnimationUtils.currentAnimationTimeMillis() - r11.f16938h;
        int r13 = r11.f16939i;
        if (r12 >= r13) goto L27;
        float r14 = ((Interpolator) this.d).getInterpolation(r12 / r13);
        r11.f16937c = r11.f16936b;
        int r15 = r11.f16935a;
        r11.f16936b = Math.round((r11.d - r15) * r14) + r15;
        r10.f16937c = r10.f16936b;
        int r16 = r10.f16935a;
        r10.f16936b = Math.round(r14 * (r10.d - r16)) + r16;
        goto L28
    L27:
        a();
        goto L28
    }

    public synchronized String f() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.common.utility.b.b((String) this.d) == false) goto L10;
        int r5 = ((ArrayList) this.f16948b).size();     // Catch: Throwable -> L8
        int r10 = this.f16947a;     // Catch: Throwable -> L8
        if (r5 <= r10) goto L10;
        this.d = (String) ((ArrayList) this.f16948b).get(r10);     // Catch: Throwable -> L8
    L10:
        String r11 = (String) this.d;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    }

    public boolean g() {
        if (((b) this.f16948b).f16942l == true) goto L5;
        return false;
    L5:
        if (((b) this.f16949c).f16942l == false) goto L10;
        return true;
    L10:
        return false;
    }

    public c(Context r5, Interpolator r10) {
        this.d = r10;
        this.f16948b = new b(r5);
        this.f16949c = new b(r5);
    }

    public c(List r5, k8.a r10) {
        this.f16947a = 0;
        ArrayList r11 = new ArrayList();
        this.f16948b = r11;
        if (r5 == null) goto L5;
        r11.addAll(r5);
    L5:
        Logger.d("WsChannelSdk_ok", "urls : " + r11);
        this.f16949c = r10;
        monitor-enter(this);
        r10.f18625b = 0;     // Catch: Throwable -> L10
        r10.f18626c = 0;     // Catch: Throwable -> L10
        this.d = null;     // Catch: Throwable -> L10
        this.f16947a = 0;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
