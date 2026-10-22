package com.ss.ugc.live.barrage.barrage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class AbsBarrage {
    public static final /* synthetic */ KProperty[] n = null;
    public static float o;
    public static final a p = null;
    public final Lazy a;
    public boolean b;
    public int c;
    public c d;
    public boolean e;
    public final RectF f;
    public volatile State g;
    public float h;
    public float i;
    public final long j;
    public boolean k;
    public final d l;
    public final b m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/ugc/live/barrage/barrage/AbsBarrage$State;", "", "CREATED", "ADDED", "PREPARING", "VISIBLE", "HIDDEN", "barrage_release"}, k = 1, mv = {1, 4, 0})
    public static final enum State extends Enum<State> {
        public static final State ADDED = null;
        public static final State CREATED = null;
        public static final State HIDDEN = null;
        public static final State PREPARING = null;
        public static final State VISIBLE = null;
        public static final /* synthetic */ State[] a = null;

        static {
            State r1 = new State("CREATED", 0);
            CREATED = r1;
            State r2 = new State("ADDED", 1);
            ADDED = r2;
            State r3 = new State("PREPARING", 2);
            PREPARING = r3;
            State r4 = new State("VISIBLE", 3);
            VISIBLE = r4;
            State r5 = new State("HIDDEN", 4);
            HIDDEN = r5;
            a = new State[]{r1, r2, r3, r4, r5};
        }

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public int a;
        public final int b;
        public final int c;
        public final olc.a d;
        public final Executor e;

        public b() {
            this(0, 0, null, 31);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L5;
        L27:
            return true;
        L5:
            if ((r5 instanceof b) == false) goto L26;
            b r6 = (b) r5;
            if (this.a != r6.a) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L26;
            if (this.b != r6.b) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == false) goto L26;
            if (this.c != r6.c) goto L19;
            boolean r3 = true;
        L20:
            if (r3 == false) goto L26;
            if (Intrinsics.areEqual(this.d, r6.d) == false) goto L26;
            if (Intrinsics.areEqual(this.e, r6.e) == false) goto L26;
        L19:
            r3 = false;
            goto L20
        L14:
            r2 = false;
            goto L15
        L9:
            r1 = false;
        L26:
            return false;
        }

        public final int hashCode() {
            int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
            olc.a r1 = this.d;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Executor r5 = this.e;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(alpha=" + this.a + ", paddingHorizontal=" + this.b + ", paddingVertical=" + this.c + ", bitmapProvider=" + this.d + ", workingExecutor=" + this.e + ")";
        }

        public b(int r3, int r4, olc.b r5, int r6) {
            if ((r6 & 1) == 0) goto L6;
            r3 = 255;
        L6:
            if ((r6 & 2) == 0) goto L8;
            r4 = 0;
        L8:
            olc.a r7 = r5;
            if ((r6 & 8) == 0) goto L12;
            r7 = olc.e.b;
        L12:
            if ((r6 & 16) == 0) goto L14;
            Executor r8 = AsyncTask.THREAD_POOL_EXECUTOR;
        L15:
            this.a = r3;
            this.b = r4;
            this.c = 0;
            this.d = r7;
            this.e = r8;
            return;
        L14:
            r8 = null;
            goto L15
        }
    }

    public interface c {
    }

    public static final class d implements Runnable {
        public final /* synthetic */ AbsBarrage a;

        public d(AbsBarrage r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbsBarrage r0 = this.a;     // Catch: Throwable -> L6
            r0.k = true;     // Catch: Throwable -> L6
            if (r0.d == null) goto L9;
            Intrinsics.checkNotNullParameter(r0, "barrage");     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
        n = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(AbsBarrage.class), "paint", "getPaint()Landroid/graphics/Paint;"))};
        p = new a();
        o = 1.0f;
    }

    public abstract Bitmap h();

    public final Paint i() {
        Lazy r0 = this.a;
        KProperty r1 = n[0];
        return (Paint) r0.getValue();
    }

    public void j() {
    }

    public AbsBarrage() {
        this(new b(0, 0, null, 31));
    }

    public final void m() {
        o = 1.0f;
        i().setAlpha(this.m.a);
    }

    public void k() {
        Bitmap r0 = h();
        if (r0 == null) goto L5;
        o(r0.getWidth() + (this.m.b * 2), r0.getHeight() + (this.m.c * 2));
    L5:
        this.b = true;
    }

    public AbsBarrage(b r3) {
        this.m = r3;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.NONE, new AbsBarrage$paint$2(this));
        this.c = -1;
        this.f = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.g = State.CREATED;
        this.j = 500;
        this.l = new d(this);
    }

    public void g(Canvas r6) {
        Bitmap r0 = h();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.g == State.VISIBLE) goto L7;
        return;
    L7:
        if (r0.isRecycled() == true) goto L13;
        RectF r1 = this.f;
        float r2 = r1.left;
        b r3 = this.m;
        r6.drawBitmap(r0, r2 + r3.b, r1.top + r3.c, i());
        return;
    }

    public final void n(float r3) {
        o = r3;
        i().setAlpha((int) (o * this.m.a));
    }

    public final void p(State r4) {
        State r0 = this.g;
        this.g = r4;
        if (r0 != r4) goto L6;
        return;
    L6:
        if (r0.compareTo(r4) >= 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L23;
        int r5 = com.ss.ugc.live.barrage.barrage.a.a[r4.ordinal()];
        if (r5 == 1) goto L21;
        if (r5 != 3) goto L15;
        k();
        return;
    L15:
        if (r5 != 5) goto L26;
        j();
        return;
    L26:
        return;
    L21:
        throw new IllegalStateException("Shouldn't set state to CREATED.");
    L23:
        throw new IllegalStateException(("Wrong state! Prev: " + r0 + ", Target: " + r4).toString());
    L8:
        r1 = false;
        goto L9
    }

    public final boolean l(MotionEvent r9, View r10) {
        int r0 = r9.getAction();
        if (r0 == 0) goto L28;
        if (r0 == 1) goto L17;
        if (r0 != 2) goto L8;
        float r1 = 10;
        if (Math.abs(r9.getX() - this.h) <= r1) goto L14;
    L15:
        r10.removeCallbacks(this.l);
    L29:
        return true;
    L14:
        if (Math.abs(r9.getY() - this.i) <= r1) goto L29;
    L8:
        if (r0 != 3) goto L31;
        r10.removeCallbacks(this.l);
        this.k = false;
        goto L29
    L31:
        return false;
    L17:
        if (this.k == true) goto L27;
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.b r11 = this.d;
        if (r11 == null) goto L27;
        float r2 = this.h;
        float r3 = this.i;
        com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.b r12 = r11;
        Intrinsics.checkNotNullParameter(this, "barrage");
        View r4 = r12.c;
        if (r4 == null) goto L27;
        if (r12.a == false) goto L27;
        r12.a = false;
        r4.postDelayed(r12.b, 800);
        r12.d.invoke(this, new PointF(r2, r3));
    L27:
        r10.removeCallbacks(this.l);
        this.k = false;
        goto L29
    L28:
        this.h = r9.getX();
        this.i = r9.getY();
        this.k = false;
        r10.postDelayed(this.l, this.j);
        goto L29
    }

    public final void o(float r4, float r5) {
        RectF r0 = this.f;
        float r1 = r0.left + r4;
        b r6 = this.m;
        r0.right = r1 + (r6.b * 2);
        r0.bottom = (r0.top + r5) + (r6.c * 2);
    }
}
