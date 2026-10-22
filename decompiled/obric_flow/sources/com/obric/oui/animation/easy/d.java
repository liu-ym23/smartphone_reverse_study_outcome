package com.obric.oui.animation.easy;

import ai.j0;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import com.google.common.reflect.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import jq.h;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import uq.e;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f11944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f11945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f11946c;
    public float d;
    public float e;
    public w f;
    public uq.c g;

    public d(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        this.f11944a = r5;
        this.f11945b = new ArrayList();
        this.f11946c = new LinkedHashMap();
        this.d = 0.5f;
        this.e = 1500.0f;
    }

    public static /* synthetic */ void b(d r5, float r10) {
        r5.a(h.f18429a, r10, ViewPropertySpringAnimator$animateProperty$2.INSTANCE);
    }

    public static /* synthetic */ void d(d r5, Function1 r10, Function1 r11) {
        r5.c(ViewPropertySpringAnimator$setListener$1.INSTANCE, r10, r11);
    }

    public final void a(a.a r10, float r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r10, "property");
        Intrinsics.checkNotNullParameter(r12, "config");
        LinkedHashMap r5 = this.f11946c;
        uq.d r13 = (uq.d) r5.get(r10);
        if (r13 != null) goto L15;
        r13 = new uq.d(this.f11944a, r10);
        c r14 = new c(this);
        if (r13.f == true) goto L14;
        ArrayList r15 = r13.f22441k;
        if (r15.contains(r14) == true) goto L9;
        r15.add(r14);
    L9:
        b r16 = new b(this, r10, r14);
        ArrayList r17 = r13.f22440j;
        if (r17.contains(r16) == true) goto L12;
        r17.add(r16);
    L12:
        r5.put(r10, r13);
        goto L15
    L14:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    L15:
        a r18 = new a();
        r18.f11934a = r11;
        r18.f11936c = Float.MAX_VALUE;
        r18.d = -3.4028235E38f;
        r18.f = 0.5f;
        r18.g = 0.5f;
        r18.f11938i = 1500.0f;
        r18.f11939j = 1500.0f;
        r12.invoke(r18);
        r18.f = this.d;
        r18.f11938i = this.e;
        this.f11945b.add(new dl.a(r13, r18));
    }

    public final void c(Function1 r5, Function1 r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r5, "onStart");
        Intrinsics.checkNotNullParameter(r10, "onCancel");
        Intrinsics.checkNotNullParameter(r11, "onEnd");
        this.f = new w(r5, 18, r10, r11);
    }

    public final void e() {
        ArrayList r5 = this.f11945b;
        if (r5.isEmpty() == true) goto L70;
        List r10 = CollectionsKt.toList(r5);
        r5.clear();
        w r11 = this.f;
        if (r11 == null) goto L9;
        Intrinsics.checkNotNullParameter(this, "animator");
        ((Function1) r11.f9377c).invoke(this);
    L9:
        Iterator r12 = r10.iterator();
    L11:
        if (r12.hasNext() == false) goto L87;
        dl.a r13 = (dl.a) r12.next();
        a r14 = r13.f16666b;
        uq.d r15 = r13.f16665a;
        Intrinsics.checkNotNullParameter(r15, "animation");
        r15.g = r14.d;
        if (r14.f11935b == false) goto L16;
        r15.f22436b = r14.f11936c;
        r15.f22437c = true;
    L16:
        if (r15.f22442l != null) goto L18;
        r15.f22442l = new e();
    L18:
        e r16 = r15.f22442l;
        if (r14.e == false) goto L21;
        float r17 = r14.g;
    L23:
        if (r17 < 0.0f) goto L68;
        r16.f22446b = r17;
        r16.f22447c = false;
        if (r14.f11937h == false) goto L27;
        float r18 = r14.f11939j;
    L29:
        if (r18 <= 0.0f) goto L67;
        r16.f22445a = Math.sqrt(r18);
        r16.f22447c = false;
        e r19 = r15.f22442l;
        double r20 = r14.f11934a;
        r19.f22449i = r20;
        double r21 = (float) r20;
        if (r21 > Float.MAX_VALUE) goto L65;
        if (r21 < r15.g) goto L63;
        double r22 = Math.abs(r15.f22439i * 0.75f);
        r19.d = r22;
        r19.e = r22 * 62.5d;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L60;
        boolean r23 = r15.f;
        if (r23 == true) goto L11;
        if (r23 == true) goto L11;
        r15.f = true;
        if (r15.f22437c == true) goto L42;
        r15.f22436b = r15.e.u(r15.d);
    L42:
        float r24 = r15.f22436b;
        if (r24 > Float.MAX_VALUE) goto L59;
        if (r24 < r15.g) goto L59;
        ThreadLocal r25 = uq.a.f;
        if (r25.get() != null) goto L49;
        r25.set(new uq.a());
    L49:
        uq.a r26 = (uq.a) r25.get();
        ArrayList r27 = r26.f22426b;
        if (r27.size() != 0) goto L56;
        if (r26.d != null) goto L54;
        r26.d = new i4.a(r26.f22427c);
    L54:
        i4.a r28 = r26.d;
        ((Choreographer) r28.f17503c).postFrameCallback((c7.e) r28.d);
    L56:
        if (r27.contains(r15) == true) goto L11;
        r27.add(r15);
    L59:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    L60:
        long r29 = Thread.currentThread().getId();
        long r30 = Looper.getMainLooper().getThread().getId();
        StringBuilder r31 = j0.t(r29, "Current Thread Id + ", " Main Thread Id + ");
        r31.append(r30);
        Log.e("DynamicAnimation", r31.toString());
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L63:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L65:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L67:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    L27:
        r18 = r14.f11938i;
        goto L29
    L68:
        r16.getClass();
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    L21:
        r17 = r14.f;
        goto L23
    L87:
        return;
    }
}
