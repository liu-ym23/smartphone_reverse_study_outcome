package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.livesdk.chatroom.widget.LiveMessageRecyclerView;
import com.bytedance.android.livesdk.f7;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenABHelper;
import com.bytedance.android.livesdk.interactivity.publicscreen.utils.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class PSLiveMessageRecyclerView extends LiveMessageRecyclerView {
    public final boolean l;
    public final boolean m;
    public float n;
    public final boolean o;

    public PSLiveMessageRecyclerView(Context r1) {
        super(r1);
        this.l = PublicScreenABHelper.p.booleanValue();
        this.m = ((Boolean) f7.a.getValue()).booleanValue();
        this.o = ((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.f.a.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r3) {
        if (this.o == false) goto L19;
        int r0 = r3.getAction();
        if (r0 != 0) goto L7;
        this.n = r3.getY();
        goto L19
    L7:
        if (r0 != 2) goto L19;
        if ((r3.getY() - this.n) >= 0.0f) goto L19;
        if (canScrollVertically(1) == true) goto L19;
        if (this.m == true) goto L19;
        return false;
    L19:
        return super/*androidx.recyclerview.widget.RecyclerView*/.onTouchEvent(r3);
    }

    public PSLiveMessageRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.l = PublicScreenABHelper.p.booleanValue();
        this.m = ((Boolean) f7.a.getValue()).booleanValue();
        this.o = ((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.f.a.getValue()).booleanValue();
    }

    public final void onMeasure(int r5, int r6) {
        float r0 = v.k;
        v.g = System.nanoTime();
        super/*androidx.recyclerview.widget.RecyclerView*/.onMeasure(r5, r6);
        v.h += System.nanoTime() - v.g;
        v.i++;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean requestFocus(int r2, Rect r3) {
        if (this.l == false) goto L7;
        return false;
    L7:
        return super/*android.view.ViewGroup*/.requestFocus(r2, r3);
    }

    public PSLiveMessageRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.l = PublicScreenABHelper.p.booleanValue();
        this.m = ((Boolean) f7.a.getValue()).booleanValue();
        this.o = ((Boolean) com.bytedance.android.livesdk.interactivity.service.settings.f.a.getValue()).booleanValue();
    }

    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        float r0 = v.k;
        v.j = System.nanoTime();
        super/*androidx.recyclerview.widget.RecyclerView*/.onLayout(r3, r4, r5, r6, r7);     // Catch: Throwable -> L5
    L7:
        float r8 = v.k;
        long r9 = System.nanoTime() - v.j;
        float r10 = v.k;
        long r11 = v.l;
        float r13 = (r10 * r11) + r9;
        long r14 = r11 + 1;
        v.k = r13 / r14;
        v.l = r14;
        return;
    L5:
        th = move-exception;
        SafetyGuard.a(null, th, "LiveMessageRecyclerView onLayout Error");
        goto L7
    }
}
