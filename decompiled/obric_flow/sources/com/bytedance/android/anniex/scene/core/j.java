package com.bytedance.android.anniex.scene.core;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.LruCache;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static j f3400n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f3401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f3402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f3403c;
    public f d;
    public g e;
    public final Lazy f;
    public final Lazy g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f3404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f3405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f3406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f3407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f3409m;

    public j() {
        this.f3401a = LazyKt.lazy(SceneManager$viewEventBuffer$2.f3376a);
        this.f3402b = LazyKt.lazy(SceneManager$timeline$2.f3375a);
        this.f3403c = LazyKt.lazy(SceneManager$aViewHotMapByScene$2.f3352a);
        this.f = LazyKt.lazy(SceneManager$signalBuffer$2.f3374a);
        this.g = LazyKt.lazy(SceneManager$pageSignalBuffer$2.f3371a);
        this.f3404h = LazyKt.lazy(SceneManager$behaviorModel$2.f3353a);
        this.f3405i = LazyKt.lazy(SceneManager$sceneDbHelper$2.f3373a);
        this.f3406j = LazyKt.lazy(SceneManager$clientComponentMap$2.f3354a);
    }

    public static void a() {
        Intrinsics.checkNotNullParameter("default_bid", "bid");
        Intrinsics.checkNotNullParameter(p3.c.class, "clazz");
        com.bytedance.android.anniex.base.service.c.a(p3.c.class, "default_bid");
    }

    public final void b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "pageName");
        if (((Boolean) com.bytedance.android.anniex.scene.settings.a.f3447a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (com.lynx.tasm.utils.k.o(r10) == false) goto L32;
        Set r5 = (Set) com.bytedance.android.anniex.scene.settings.a.e.getValue();
        if (r5 == null) goto L12;
        if (r5.contains(r10) != true) goto L12;
        return;
    L12:
        if (((Boolean) com.bytedance.android.anniex.scene.settings.a.f3448b.getValue()).booleanValue() == true) goto L19;
        Set r11 = (Set) com.bytedance.android.anniex.scene.settings.a.f.getValue();
        if (r11 != null) goto L17;
        return;
    L17:
        if (r11.contains(r10) == true) goto L19;
        return;
    L19:
        if (this.f3408l == true) goto L21;
        d();
    L21:
        long r12 = System.currentTimeMillis();
        c r13 = new c(r10, r12);
        d r14 = (d) this.g.getValue();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "event");
        if (r14.f3388b != 0) goto L24;
        r14.f3388b = r12;
    L24:
        r14.f3387a.add(r13);
        h r15 = this.f3407k;
        if (r15 == null) goto L27;
        r15.removeMessages(2);
    L27:
        Message r16 = Message.obtain();
        r16.what = 2;
        r16.obj = r13;
        h r17 = this.f3407k;
        if (r17 == null) goto L35;
        r17.sendMessageDelayed(r16, ((Number) com.bytedance.android.anniex.scene.settings.a.f3450h.getValue()).longValue());
        return;
    L35:
        return;
    }

    public final void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "sessionId");
        Intrinsics.checkNotNullParameter(r10, "type");
        if (this.f3407k == null) goto L5;
    L7:
        h r11 = this.f3407k;
        if (r11 == null) goto L11;
        r11.post(new i(this, 0, r5, r10));
        return;
    L11:
        return;
    L5:
        if (this.f3408l == true) goto L7;
        d();
        goto L7
    }

    public final void d() {
        if (((Boolean) com.bytedance.android.anniex.scene.settings.a.f3447a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (this.f3408l == true) goto L9;
        HandlerThread r5 = new HandlerThread("AnnieXSceneManager", 0);
        r5.start();
        new Handler(r5.getLooper());
        this.f3407k = new h(this, r5.getLooper());
        this.f3408l = true;
        return;
    }

    public final void e(String r10, String r11) {
        if (((Boolean) com.bytedance.android.anniex.scene.settings.a.f3447a.getValue()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.f3408l == true) goto L9;
        d();
    L9:
        if (((Boolean) com.bytedance.android.anniex.scene.settings.a.f3448b.getValue()).booleanValue() == false) goto L16;
        if (this.f3409m == true) goto L16;
        h r5 = this.f3407k;
        if (r5 == null) goto L16;
        Message r12 = new Message();
        r12.what = 3;
        r5.sendMessage(r12);
    L16:
        if (com.lynx.tasm.utils.k.o(r10) == true) goto L18;
        return;
    L18:
        if (com.lynx.tasm.utils.k.o(r11) == true) goto L20;
        return;
    L20:
        if (Intrinsics.areEqual(r10, "unknown") == false) goto L22;
        return;
    L22:
        if (Intrinsics.areEqual(r11, "null") == false) goto L25;
        return;
    L25:
        if (((LruCache) this.f3401a.getValue()).get(r10) != null) goto L50;
        Uri r13 = Uri.parse(r11);
        String r14 = r13.getHost() + r13.getPath();
        final k r15 = new k(System.currentTimeMillis(), r14, r10);
        a r16 = (a) this.f.getValue();
        r16.getClass();
        Intrinsics.checkNotNullParameter(r15, "viewAttachEvent");
        Function0<String> r17 = new AViewSignalBuffer$receive$1(r15);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r17, "message");
        com.lynx.tasm.utils.g.f(3, r17);
        long r18 = System.currentTimeMillis();
        if (r16.f3382c != 0) goto L29;
        r16.f3382c = r18;
    L29:
        r16.d++;
        r16.f3381b.add(r15);
        Map r19 = (Map) this.f3403c.getValue();
        if (r19 != null) goto L32;
    L36:
        d r20 = (d) this.g.getValue();
        r20.f3387a.clear();
        r20.f3388b = 0;
        h r21 = this.f3407k;
        if (r21 == null) goto L39;
        r21.removeMessages(2);
    L39:
        h r22 = this.f3407k;
        if (r22 == null) goto L42;
        r22.removeMessages(1);
    L42:
        Message r23 = Message.obtain();
        r23.what = 1;
        r23.obj = r15;
        h r24 = this.f3407k;
        if (r24 == null) goto L45;
        r24.sendMessageDelayed(r23, ((Number) com.bytedance.android.anniex.scene.settings.a.g.getValue()).longValue());
    L45:
        ((LruCache) this.f3401a.getValue()).put(r10, r14);
        return;
    L32:
        if (r19.get("") == null) goto L36;
        throw new ClassCastException();
    }
}
