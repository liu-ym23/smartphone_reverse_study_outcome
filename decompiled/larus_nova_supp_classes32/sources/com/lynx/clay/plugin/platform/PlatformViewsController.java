package com.lynx.clay.plugin.platform;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.android.FlutterImageView;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.android.b;
import com.lynx.clay.embedding.android.i;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.embedding.engine.FlutterOverlaySurface;
import com.lynx.clay.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import e5a.a;
import m5a.h;
import m5a.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class PlatformViewsController {
    public b a;
    public Context b;
    public FlutterView c;
    public final SparseArray<View> d;
    public final SparseBooleanArray e;
    public final SparseArray<a.b> f;
    public final SparseArray<a> g;
    public boolean h;

    public void onAttachedToJNI() {
    }

    public final void a() {
        if (this.h == true) goto L13;
        FlutterView r0 = this.c;
        r0.g.pause();
        FlutterImageView r1 = r0.e;
        if (r1 != null) goto L7;
        FlutterImageView r2 = new FlutterImageView(r0.getContext(), r0.getWidth(), r0.getHeight(), FlutterImageView.SurfaceKind.background);
        r0.e = r2;
        r0.addView(r2);
    L8:
        FlutterImageView r3 = r0.e;
        r0.g = r3;
        FlutterEngine r4 = r0.r;
        if (r4 == null) goto L11;
        r3.a(r4.b);
    L11:
        this.h = true;
        return;
    L7:
        r1.e(r0.getWidth(), r0.getHeight());
        goto L8
    }

    public void onDetachedFromJNI() {
    L3:
        if (this.d.size() <= 0) goto L5;
        int r0 = this.d.keyAt(0);
        dispose(r0);
        this.e.delete(r0);
        this.f.remove(r0);
        goto L3
    }

    public void onEndFrame() {
        if (this.h == false) goto L8;
        FlutterImageView r0 = this.c.e;
        if (r0 == null) goto L9;
        r0.c(false);
        return;
    L9:
        return;
    }

    public PlatformViewsController() {
        this.e = new SparseBooleanArray();
        this.f = new SparseArray();
        this.h = false;
        this.d = new SparseArray();
        this.g = new SparseArray();
        if (i.c != null) goto L6;
        i.c = new i();
        return;
    }

    private void bringToFront(int r2) {
        a r3 = this.g.get(r2);
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        r3.bringToFront();
        return;
    }

    private void dispose(int r5) {
        View r0 = this.d.get(r5);
        ViewGroup r1 = (ViewGroup) r0.getParent();
        if (r1 == null) goto L5;
        r1.removeView(r0);
    L5:
        this.d.remove(r5);
        this.e.delete(r5);
        this.f.remove(r5);
        a r2 = this.g.get(r5);
        if (r2 == null) goto L17;
        r2.removeAllViews();
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3.isAlive() == false) goto L12;
        a.ViewTreeObserverOnGlobalFocusChangeListenerC0084a r4 = r2.i;
        if (r4 == null) goto L12;
        r2.i = null;
        r3.removeOnGlobalFocusChangeListener(r4);
    L12:
        ViewGroup r6 = (ViewGroup) r2.getParent();
        if (r6 == null) goto L15;
        r6.removeView(r2);
    L15:
        this.g.remove(r5);
        return;
    }

    private void hide(int r2) {
        a r3 = this.g.get(r2);
        if (r3 == null) goto L6;
        r3.setVisibility(4);
        return;
    }

    public void onDisplayOverlaySurface(FlutterOverlaySurface r2, int r3, int r4, int r5, int r6, int r7) {
        a();
        if (r7 == 0) goto L10;
        q r8 = h.e.b.get(Integer.valueOf(r7));
        if (r8 != null) goto L7;
        boolean r9 = false;
    L8:
        if (r9 == false) goto L10;
        return;
    L7:
        r8.n(r2, r5, r6);
        r9 = true;
    L10:
        View r10 = r2.a();
        if (r10 != null) goto L14;
        return;
    L14:
        if (r10.getParent() != null) goto L16;
        this.c.addView(r10);
    L16:
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(r5, r6);
        r11.leftMargin = r3;
        r11.topMargin = r4;
        r10.setLayoutParams(r11);
    }

    public void onDisplayPlatformView(int r6, int r7, int r8, int r9, int r10, int r11, int r12, FlutterMutatorsStack r13) {
        Resources r0 = this.b.getResources();
        int r14 = Math.round(r11 / WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density);
        Resources r1 = this.b.getResources();
        int r15 = Math.round(r12 / WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density);
        a();
        if (this.g.get(r6) != null) goto L15;
        View r2 = this.d.get(r6);
        if (r2 == null) goto L22;
        if (r2.getParent() != null) goto L20;
        Context r3 = this.b;
        Resources r4 = r3.getResources();
        float r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density;
        a r16 = new a(r3, this.a);
        if (this.e.get(r6) == false) goto L12;
        r16.setSystemTouchDispatchEnabled(true);
        r16.setTouchDispatchResultListener(this.f.get(r6));
    L12:
        this.g.put(r6, r16);
        r2.setImportantForAccessibility(4);
        r16.addView(r2);
        if (r2.willNotDraw() == true) goto L15;
        this.c.addView(r16);
        goto L15
    L20:
        throw new IllegalStateException("The Android view returned was already added to a parent view.");
    L22:
        throw new IllegalStateException("Android view reference was expected.");
    L15:
        a r17 = this.g.get(r6);
        r17.a = r13;
        r17.b = r7;
        r17.c = r8;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(r9, r10);
        r18.leftMargin = r7;
        r18.topMargin = r8;
        r17.setLayoutParams(r18);
        FrameLayout.LayoutParams r19 = new FrameLayout.LayoutParams(r14, r15);
        View r20 = this.d.get(r6);
        if (r20 == null) goto L23;
        r20.setLayoutParams(r19);
        return;
    }
}
