package com.bytedance.android.livesdk.drawer;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.List;
import ut1.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveDrawerLayout extends DrawerLayout {
    public static final /* synthetic */ int g = 0;
    public int a;
    public float b;
    public float c;
    public boolean d;
    public ILiveDrawerLayoutInterceptor e;
    public List<DrawerLayout.DrawerListener> f;

    public LiveDrawerLayout(Context r2) {
        this(r2, null);
    }

    public final void addDrawerListener(DrawerLayout.DrawerListener r2) {
        super.addDrawerListener(r2);
        if (this.f != null) goto L5;
        this.f = new ArrayList();
    L5:
        this.f.add(r2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r7) {
        float r1 = r7.getX();     // Catch: IllegalArgumentException -> L42
        float r2 = r7.getY();     // Catch: IllegalArgumentException -> L42
        int r3 = r7.getAction();     // Catch: IllegalArgumentException -> L42
        if (r3 != 0) goto L6;
        this.b = r1;     // Catch: IllegalArgumentException -> L42
        this.c = r2;     // Catch: IllegalArgumentException -> L42
    L35:
        ILiveDrawerLayoutInterceptor r4 = this.e;     // Catch: IllegalArgumentException -> L42
        if (r4 == null) goto L41;
        if (r4.onInterceptTouchEvent(r7) == true) goto L41;
        return false;
    L41:
        return super.onInterceptTouchEvent(r7);
    L6:
        if (r3 != 2) goto L35;
        float r5 = this.b;     // Catch: IllegalArgumentException -> L42
        if (r1 > r5) goto L11;
    L13:
        int r6 = (int) Math.abs(r1 - r5);     // Catch: IllegalArgumentException -> L42
        int r8 = (int) Math.abs(r2 - this.c);     // Catch: IllegalArgumentException -> L42
        int r9 = (r6 * r6) + (r8 * r8);     // Catch: IllegalArgumentException -> L42
        int r10 = this.a;     // Catch: IllegalArgumentException -> L42
        if (r9 <= (r10 * r10)) goto L16;
        boolean r11 = true;
    L17:
        if (r11 == true) goto L19;
    L23:
        if (r11 == false) goto L35;
        if (this.d == false) goto L35;
        if (r6 <= (r8 * 4)) goto L46;
        ILiveDrawerLayoutInterceptor r12 = this.e;     // Catch: IllegalArgumentException -> L42
        if (r12 != null) goto L31;
    L32:
        return true;
    L31:
        if (r12.onInterceptTouchEvent(r7) == false) goto L32;
        return false;
    L46:
        return false;
    L19:
        if (this.d == true) goto L23;
        if (r6 >= (r8 * 4)) goto L23;
        return false;
    L16:
        r11 = false;
        goto L17
    L11:
        if (this.d == true) goto L13;
        return false;
    L42:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public final void removeDrawerListener(DrawerLayout.DrawerListener r2) {
        super.removeDrawerListener(r2);
        List<DrawerLayout.DrawerListener> r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((ArrayList) r0).contains(r2) == false) goto L9;
        ((ArrayList) this.f).remove(r2);
        return;
    }

    public void setDrawerLayoutInterceptor(ILiveDrawerLayoutInterceptor r1) {
        this.e = r1;
    }

    public LiveDrawerLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveDrawerLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        ViewConfiguration r4 = ViewConfiguration.get(getContext());
        Resources r5 = r1.getResources();
        float r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
        this.a = r4.getScaledTouchSlop();
        addDrawerListener(new i(this));
    }
}
