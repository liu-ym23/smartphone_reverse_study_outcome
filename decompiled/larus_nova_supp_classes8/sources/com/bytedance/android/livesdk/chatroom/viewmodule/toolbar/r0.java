package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.v81;
import com.bytedance.android.livesdk.config.xu0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r0 {
    public final String a;
    public View b;
    public final v81 c;
    public float d;
    public float e;
    public boolean f;
    public final AtomicBoolean g;
    public boolean h;
    public boolean i;
    public final ViewGroup j;

    public static final class a implements Runnable {
        public final /* synthetic */ r0 a;

        public a(r0 r1) {
            this.a = r1;
        }

        public final void a() {
            View r0 = this.a.b;
            if (r0 == null) goto L10;
            Rect r1 = new Rect();
            View r2 = this.a.b;
            Intrinsics.checkNotNull(r2);
            r2.getHitRect(r1);
            new Rect(r1);
            r1.top -= com.bytedance.android.live.core.utils.s1.f(this.a.c.d());
            Object r3 = r0.getParent();
            if ((r3 instanceof View) == true) goto L7;
            r3 = null;
        L7:
            View r4 = (View) r3;
            if (r4 == null) goto L10;
            r4.setTouchDelegate(new e4(r1, this.a, r0));
        L10:
            this.a.g.set(false);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ r0 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ float c;
        public final /* synthetic */ float d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;

        public b(r0 r1, String r2, float r3, float r4, int r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void a() {
            r0 r0 = this.a;
            String r1 = this.b;
            float r2 = this.c;
            float r3 = this.d;
            int r4 = this.e;
            String r5 = this.f;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "type");
            Intrinsics.checkNotNullParameter(r5, "info");
            HashMap r7 = new HashMap();
            JSONObject r8 = new JSONObject();
            r8.put("x", Float.valueOf(r2));
            r8.put("y", Float.valueOf(r3));
            r8.put("position", r4);
            String r6 = r8.put("info", r5).toString();
            r7.put("scene", "3");
            r7.put("time", String.valueOf(System.currentTimeMillis()));
            r7.put("type", r1);
            r7.put("detail", r6);
            qm0.b r9 = om0.c.g();
            if (r9 == null) goto L6;
            r9.sendLog("livesdk_use_behavior_recognition", r7, new Object[0]);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void a() {
        if (this.c.a() == true) goto L5;
        return;
    L5:
        if (this.c.c() == true) goto L7;
        return;
    L7:
        if (this.g.get() == false) goto L9;
        return;
    L9:
        if (this.b == null) goto L15;
        this.g.set(true);
        com.bytedance.android.live.core.utils.i0.h(new a(this));
        return;
    }

    public r0(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "mToolbarContainer");
        this.j = r2;
        this.a = "LiveToolbarExpand";
        this.c = xu0.a.getValue();
        this.d = -1.0f;
        this.e = -1.0f;
        this.g = new AtomicBoolean(false);
        this.i = true;
    }

    public final boolean b(int r28, float r29, float r30, String r31) {
        Intrinsics.checkNotNullParameter(r31, "type");
        if (this.i == true) goto L5;
    L79:
        return false;
    L5:
        if (this.h == true) goto L79;
        if (this.j.getVisibility() != 0) goto L79;
        if (r28 != 0) goto L13;
        this.d = r29;
        this.e = r30;
        this.f = false;
    L78:
        boolean r0 = this.f;
    L61:
        return !r0;
    L13:
        if (r28 == 2) goto L15;
        if (r28 != 1) goto L78;
        if (this.f == true) goto L78;
        float r1 = this.d;
        if (r1 == (-1.0f)) goto L78;
        if (this.e == (-1.0f)) goto L78;
        if (Math.abs(r29 - r1) >= ViewConfiguration.getTouchSlop()) goto L78;
        if (Math.abs(r30 - this.e) >= ViewConfiguration.getTouchSlop()) goto L78;
        if (r29 > 0) goto L33;
    L50:
        int r6 = -1;
    L51:
        if (r6 >= 0) goto L53;
    L77:
        this.d = -1.0f;
        this.e = -1.0f;
        goto L78
    L53:
        if (r6 >= this.j.getChildCount()) goto L77;
        View r2 = this.j.getChildAt(r6);
        if ((r2 instanceof View) == true) goto L57;
        r2 = null;
    L57:
        View r10 = r2;
        if (r10 != null) goto L62;
        r0 = this.f;
        goto L61
    L62:
        ArrayList<View> r3 = r10.getTouchables();
        Object r4 = r10.getTag(2131389840);
        if (Intrinsics.areEqual(r4, 29) == false) goto L65;
        r0 = this.f;
        goto L61
    L65:
        if (r4 != null) goto L67;
        ALogger.d(this.a, "toolbar tag is null, view:" + r10);
        String r5 = r10.toString();
    L68:
        String r11 = r5;
        if (r3.size() != 1) goto L72;
        ((View) ListProtector.get(r3, 0)).performClick();
    L76:
        r10.post(new b(this, r31, r29, r30, r6, r11));
        goto L77
    L72:
        if (r3.size() <= 1) goto L76;
        if (this.c.b() == false) goto L76;
        long r14 = SystemClock.uptimeMillis();
        r10.dispatchTouchEvent(MotionEvent.obtain(r14, r14, 0, r10.getWidth() / 2.0f, r10.getHeight() / 2.0f, 0));
        long r21 = SystemClock.uptimeMillis();
        r10.dispatchTouchEvent(MotionEvent.obtain(r21, r21, 1, r10.getWidth() / 2.0f, r10.getHeight() / 2.0f, 0));
        goto L76
    L67:
        r5 = r4.toString();
        goto L68
    L33:
        if (r29 >= this.j.getWidth()) goto L50;
        int r7 = this.j.getChildCount();
        int r8 = 0;
        int r9 = 0;
    L35:
        if (r8 >= r7) goto L50;
        View r12 = this.j.getChildAt(r8);
        if (r12.getVisibility() == 8) goto L49;
        if (r12.getLayoutParams() == null) goto L45;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L44;
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r13;
        r9 = r9 + ((r15.leftMargin + r12.getWidth()) + r15.rightMargin);
    L47:
        if (r29 >= r9) goto L49;
        r6 = r8;
        goto L51
    L44:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L45:
        r9 = r9 + r12.getWidth();
    L49:
        r8 = r8 + 1;
        goto L35
    L15:
        if (Math.abs(r29 - this.d) <= ViewConfiguration.getTouchSlop()) goto L17;
    L18:
        this.f = true;
        goto L78
    L17:
        if (Math.abs(r30 - this.e) <= ViewConfiguration.getTouchSlop()) goto L78;
        goto L18
    }
}
