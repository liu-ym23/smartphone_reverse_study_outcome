package com.bytedance.ies.bullet.service.popup.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.t;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.crash.p;
import com.bytedance.crash.util.g;
import i9.f;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mh.e;
import org.json.JSONObject;
import sj.k;
import ym.m;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements z8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f6099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Serializable f6100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f6101c;

    public c(w8.b r5, long r10, ArrayList r11) {
        this.f6101c = r5;
        this.f6099a = r10;
        this.f6100b = r11;
    }

    @Override // z8.a
    public void a(JSONObject r13) {
        k r5 = k.g();
        long r10 = this.f6099a;
        boolean r11 = ((w8.b) this.f6101c).f;
        ArrayList r12 = (ArrayList) this.f6100b;
        r5.getClass();
        Context r14 = (Context) r5.f21937a;
        if (e.n(r13) == true) goto L31;
        String r15 = com.bytedance.crash.upload.b.i(n.f4062j.getJavaCrashUploadUrl(), r13.optJSONObject("header"));     // Catch: Throwable -> L24
        String r16 = g.f4181a;     // Catch: Throwable -> L24
        File r17 = new File(g.h(r14), x8.a.f22983b);     // Catch: Throwable -> L24
        CrashType r18 = CrashType.ANR;     // Catch: Throwable -> L24
        File r19 = new File(r17, n.b(r10, r18, false, false));     // Catch: Throwable -> L24
        cl.a.m(r19, r19.getName(), r15, r13);     // Catch: Throwable -> L24
        if (r11 == true) goto L8;
        return;
    L8:
        if (p.f4084h == true) goto L28;
        r13.put("upload_scene", "direct");     // Catch: Throwable -> L24
        r13.put("crash_uuid", r19.getName());     // Catch: Throwable -> L24
        if (e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_anr_all_process_trace"}) != 1) goto L13;
        boolean r20 = true;
    L14:
        File r21 = g.c(r14, n.f());     // Catch: Throwable -> L24
        z5.a.c(r21, r18);     // Catch: Throwable -> L24
        com.lynx.jsbridge.a.j(r21, r13);     // Catch: Throwable -> L24
        String r22 = r18.getName();     // Catch: Throwable -> L24
        String r110 = r13.toString();     // Catch: Throwable -> L24
        c5.a r111 = new c5.a(r21, true);     // Catch: Throwable -> L24
        c5.a r23 = com.bytedance.android.anniex.base.service.e.m(r10);     // Catch: Throwable -> L24
        c5.a r24 = new c5.a(com.bytedance.crash.upload.b.e(), false);     // Catch: Throwable -> L24
        if (r20 == false) goto L17;
        c5.a r112 = f.c(r13.optJSONArray("alive_pids"));     // Catch: Throwable -> L24
    L19:
        if (com.bytedance.crash.upload.b.a(r22, r15, r110, null, new c5.a[]{r111, r23, r24, r112}).c() == false) goto L29;
        v8.a.a(m.o(r14), r12);     // Catch: Throwable -> L24
        cl.a.C(r19);     // Catch: Throwable -> L24
        if (p.e() == true) goto L30;
        cl.a.C(g.f(n.f4057a));     // Catch: Throwable -> L24
        return;
    L30:
        return;
    L29:
        return;
    L17:
        r112 = null;
        goto L19
    L13:
        r20 = false;
        goto L14
    L28:
        return;
    L32:
        return;
    }

    public void b(View r5, ObjectAnimator r10, int r11, Function0 r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r12, "succUnits");
        Intrinsics.checkNotNullParameter(r13, "animProgressListener");
        if (((AnimController$AnimProcessType) this.f6101c) == AnimController$AnimProcessType.f6091a) goto L12;
        long r14 = this.f6099a - System.currentTimeMillis();
        if (r14 <= 0) goto L10;
        long r15 = r11;
        if (r14 <= r15) goto L9;
        Log.e("bullet", "doExitAnim with long sleep time " + r14);
        Thread.sleep(r15);
        goto L10
    L9:
        Thread.sleep(r14);
    L10:
        r12.invoke();
        return;
    L12:
        if (r10 != null) goto L15;
        r12.invoke();
        return;
    L15:
        if (r5 == null) goto L17;
        long r16 = r11;
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r5, "alpha", new float[]{1.0f, 0.0f}).setDuration(r16);
        r10.setDuration(r16);
        r10.addListener(new b(this, r12, 1));
        r10.addUpdateListener(new t(r13));
        AnimatorSet r18 = new AnimatorSet();
        r18.playTogether(new Animator[]{r17, r10});
        r18.start();
    L18:
        this.f6099a = System.currentTimeMillis() + ((long) r11);
        return;
    L17:
        r10.setDuration(r11);
        r10.addListener(new b(this, r12, 1));
        r10.addUpdateListener(new t(r13));
        r10.start();
        goto L18
    }
}
