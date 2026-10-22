package com.bytedance.android.live.liveinteract.plantform.utils;

import android.content.Context;
import android.media.AudioManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class m0 {
    public final AudioManager a;
    public int b;
    public final int c;
    public float d;
    public final CompositeDisposable e;
    public boolean f;
    public final com.bytedance.android.livesdk.chatroom.o g;
    public final hg6.g h;
    public final LifecycleOwner i;

    public final boolean a() {
        com.bytedance.android.livesdk.chatroom.o r0 = this.g;
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.m r1 = r0.X1();
        if (r1 == null) goto L8;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L8;
        return true;
    L8:
        com.bytedance.android.livesdk.chatroom.o r2 = this.g;
        if (r2 == null) goto L15;
        com.bytedance.live.datacontext.m r3 = r2.n2();
        if (r3 == null) goto L15;
        if (((Boolean) r3.getValue()).booleanValue() != true) goto L15;
        return true;
    L15:
        return false;
    }

    public final void b() {
        if (((Boolean) vm2.d.j5.getValue(null, vm2.d.a[319(0x13f, float:4.47E-43)])).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.f == false) goto L8;
        return;
    L8:
        this.f = true;
        if (a() == true) goto L23;
        int r0 = this.a.getStreamMaxVolume(0);
        float r2 = this.d;
        if (r2 <= 0) goto L22;
        int r3 = (int) (r0 * r2);
        if (r3 > r0) goto L17;
        r0 = r3;
    L17:
        int r4 = this.a.getStreamVolume(0);
        this.a.getMode();
        if (r4 > r0) goto L23;
        if (r0 <= 0) goto L22;
        this.a.setStreamVolume(0, r0, 0);
    L22:
        this.d = 0.0f;
    L23:
        this.e.add(((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.event.a.class).as(AutoDispose.bind(this.i))).subscribe(new l0(this)));
        com.bytedance.android.livesdk.chatroom.o r1 = this.g;
        if (r1 == null) goto L34;
        com.bytedance.live.datacontext.m r5 = r1.X1();
        if (r5 == null) goto L34;
        Observable r6 = r5.a();
        if (r6 == null) goto L34;
        ObservableSubscribeProxy r7 = (ObservableSubscribeProxy) r6.as(AutoDispose.bind(this.i));
        if (r7 == null) goto L34;
        Disposable r8 = r7.subscribe(new j0(this));
        if (r8 == null) goto L34;
        this.e.add(r8);
    L34:
        com.bytedance.android.livesdk.chatroom.o r9 = this.g;
        if (r9 == null) goto L46;
        com.bytedance.live.datacontext.m r10 = r9.n2();
        if (r10 == null) goto L47;
        Observable r11 = r10.a();
        if (r11 == null) goto L48;
        ObservableSubscribeProxy r12 = (ObservableSubscribeProxy) r11.as(AutoDispose.bind(this.i));
        if (r12 == null) goto L49;
        Disposable r13 = r12.subscribe(new k0(this));
        if (r13 == null) goto L50;
        this.e.add(r13);
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    }

    public final void c() {
        CompositeDisposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        this.f = false;
    }

    public final void d() {
        if (((Boolean) vm2.d.j5.getValue(null, vm2.d.a[319(0x13f, float:4.47E-43)])).booleanValue() == true) goto L5;
        return;
    L5:
        int r0 = this.a.getStreamVolume(3);
        int r1 = this.a.getStreamMaxVolume(3);
        if (r1 <= 0) goto L8;
        float r2 = r0 / r1;
    L9:
        this.d = r2;
        this.a.getMode();
        return;
    L8:
        r2 = 0.0f;
        goto L9
    }

    public m0(Context r2, com.bytedance.android.livesdk.chatroom.o r3, hg6.g r4, LifecycleOwner r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        this.g = r3;
        this.h = r4;
        this.i = r5;
        Object r6 = r2.getSystemService("audio");
        if (r6 == null) goto L7;
        this.a = (AudioManager) r6;
        this.b = 100;
        this.c = ((Number) vm2.d.k5.getValue(null, vm2.d.a[320(0x140, float:4.48E-43)])).intValue();
        this.e = new CompositeDisposable();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }
}
