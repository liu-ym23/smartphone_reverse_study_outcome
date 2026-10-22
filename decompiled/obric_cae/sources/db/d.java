package db;

import android.view.Choreographer;
import android.view.View;
import ge.p;
import ge.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xd.j;
import yd.f;
import yd.i;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f7028d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f7030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7031c;

    static {
        new mb.b();
    }

    public d() {
        this.f7029a = new b();
        int r8 = f7028d;
        f7028d = r8 + 1;
        this.f7031c = r8;
    }

    public static void a(d r8) {
        mb.a.d("AnimationManager", "cancel, instanceId: [" + r8.f7031c + "], clearVelocity: false");
        a r10 = r8.f7030b;
        if (r10 == null) goto L9;
        mb.a.c("cancelAnimation, clearVelocity: false");
        Choreographer.getInstance().removeFrameCallback(r10.f7005a);
        r10.f7006b.a(false);
        p<? super Boolean, ? super Throwable, j> r11 = r10.f7008d;
        if (r11 == null) goto L7;
        j r12 = r11.invoke(Boolean.FALSE, null);
    L7:
        mb.a.a("AnimatableRunner", "releaseCallbacks, scene: ".concat("cancelAnimation"));
        r10.f7007c = null;
        r10.f7008d = null;
        return;
    }

    public final void b(View r8, cb.b r10, float r11, cb.a r12, List r13, q r14, p r15) {
        StringBuilder r16 = new StringBuilder("start, instanceId: [");
        r16.append(this.f7031c);
        r16.append("], runAnimation, mode: ");
        r16.append(r10);
        r16.append(", speed: ");
        r16.append(r11);
        r16.append(", repeatMode: ");
        r16.append(r12);
        r16.append(", animationInfos: ");
        ArrayList r17 = new ArrayList(f.f1(r13));
        Iterator r18 = r13.iterator();
    L4:
        if (r18.hasNext() == false) goto L6;
        ya.a r19 = (ya.a) r18.next();
        r19.getClass();
        r17.add("AnimationInfo(property: " + r19.f14097e + ", initialValue: " + r19.f14098f + ", targetValue: " + r19.f14099g + ", spec: " + r19.f14100h.c() + ", initialVelocity: " + r19.f14101i + ", valueClass: " + r19.f14102j + ", currentVelocity: " + r19.f14103k + ", durationNanos: " + r19.f14093a + ", firstFrameTimeNanos: " + r19.f14094b + ", lastFrameTimeNanos: " + r19.f14095c + ", isRunning: " + r19.f14096d + ')');
        goto L4
    L6:
        r16.append(i.j1(r17, "\n", null, 62));
        mb.a.d("AnimationManager", r16.toString());
        b r20 = this.f7029a;
        r20.getClass();
        he.i.f(r10, "runMode");
        r20.f7010a = r10;
        he.i.f(r12, "repeatMode");
        r20.f7011b = r12;
        r20.f7012c = r13;
        if (r8 == null) goto L9;
        boolean r21 = true;
    L10:
        r20.f7019j = r21;
        r20.f7013d = new WeakReference(r8);
        r20.f7016g = r11;
        a r22 = new a(r20, r14, r15);
        this.f7030b = r22;
        Choreographer.getInstance().postFrameCallback(r22.f7005a);
        return;
    L9:
        r21 = false;
        goto L10
    }
}
