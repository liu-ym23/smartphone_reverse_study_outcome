package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.content.Context;
import android.os.Build;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class DecorateWebViewV2 extends NestBridgeWebView implements zv4.c<WebView>, zv4.b {
    public boolean H0;
    public boolean L0;
    public zv4.d T;
    public List<zv4.d> U;
    public Map<zv4.d, View[]> V;
    public List<zv4.a> W;
    public ActionMode k0;
    public boolean p0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getHostView, reason: collision with other method in class */
    public WebView m67getHostView() {
        return this;
    }

    public final void c() {
        ActionMode r0 = this.k0;
        if (r0 == null) goto L6;
        r0.finish();
        this.k0 = null;
        return;
    }

    public final zv4.d v() {
        if (swb.e.a(this.U) == false) goto L6;
        return null;
    L6:
        List<zv4.d> r0 = this.U;
        return (zv4.d) ListProtector.get(r0, ((ArrayList) r0).size() - 1);
    }

    public /* bridge */ /* synthetic */ View getHostView() {
        return m67getHostView();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        zv4.d r0 = v();
        if (r0 == null) goto L6;
        r0.onAttachedToWindow();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetachedFromWindow() {
        super/*android.webkit.WebView*/.onDetachedFromWindow();
        zv4.d r0 = v();
        if (r0 == null) goto L5;
        r0.onDetachedFromWindow();
    L5:
        c();
    }

    public List<zv4.d> getDecorateLayers() {
        return this.U;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(zv4.d r4) {
        if (((ArrayList) this.U).contains(r4) == false) goto L5;
        return;
    L5:
        r4.b(this);
        ((ArrayList) this.U).add(r4);
        View[] r0 = r4.c();
        ((HashMap) this.V).put(r4, r0);
        if (r0 == null) goto L10;
        int r5 = r0.length;
        int r1 = 0;
    L8:
        if (r1 >= r5) goto L12;
        addView(r0[r1]);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(zv4.d r4) {
        if (((ArrayList) this.U).remove(r4) == true) goto L5;
        return;
    L5:
        r4.d();
        View[] r5 = (View[]) ((HashMap) this.V).remove(r4);
        if (r5 == null) goto L10;
        int r0 = r5.length;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L12;
        removeView(r5[r1]);
        r1 = r1 + 1;
        goto L8
    L12:
        return;
    }

    public final void e(zv4.a r2) {
        if (((ArrayList) this.W).contains(r2) == true) goto L6;
        ((ArrayList) this.W).add(r2);
        return;
    }

    public final void f(zv4.a r2) {
        ((ArrayList) this.W).remove(r2);
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.NestBridgeWebView
    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        if (r3.getAction() != 0) goto L6;
        this.p0 = false;
    L6:
        if (super.onInterceptTouchEvent(r3) == false) goto L9;
        this.p0 = true;
        return true;
    L9:
        this.T = null;
        return false;
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.NestBridgeWebView
    public final boolean onTouchEvent(MotionEvent r4) {
        if (this.p0 == false) goto L7;
        return super.onTouchEvent(r4);
    L7:
        if (this.T == null) goto L10;
        MotionEvent r0 = MotionEvent.obtain(r4);
        r0.setAction(3);
        super.onTouchEvent(r0);
        r0.recycle();
        return this.T.onTouchEvent(r4);
    L10:
        zv4.d r1 = v();
        if (r1 == null) goto L16;
        if (r1.onTouchEvent(r4) == false) goto L16;
        this.T = r1;
        r4.setAction(3);
    L16:
        return super.onTouchEvent(r4);
    }

    public void setDisableCustomActionMode(boolean r1) {
        this.L0 = r1;
    }

    public void setEnableOverScrollBy(boolean r1) {
        this.H0 = r1;
    }

    public final ActionMode startActionMode(ActionMode.Callback r2) {
        return u(r2, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DecorateWebViewV2(Context r1, boolean r2) {
        super(r1, r2);
        this.H0 = true;
        this.L0 = false;
        LayoutInflater.from(getContext());
        this.U = new ArrayList();
        this.V = new HashMap();
        this.W = new ArrayList();
    }

    public final ActionMode startActionMode(ActionMode.Callback r1, int r2) {
        return u(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ActionMode u(ActionMode.Callback r6, int r7) {
        if (this.L0 == false) goto L5;
    L10:
        ActionMode.Callback r0 = null;
    L11:
        Log.i("DecorateWebViewV2", "start action mode actionModeCallback " + r0);
        boolean r2 = true;
        if (r0 == null) goto L22;
        if (Build.VERSION.SDK_INT >= 23) goto L17;
        r2 = false;
    L17:
        if (r2 == false) goto L19;
        ActionMode r8 = super.startActionMode(r0, r7);
    L20:
        this.k0 = r8;
    L33:
        return this.k0;
    L19:
        r8 = super/*android.webkit.WebView*/.startActionMode(r0);
        goto L20
    L22:
        if (hasFocus() == true) goto L24;
        Log.w("DecorateWebViewV2", "WebView has no focus, intercept system actionMode!");
        c();
        goto L33
    L24:
        if (Build.VERSION.SDK_INT >= 23) goto L27;
        r2 = false;
    L27:
        if (r2 == false) goto L29;
        ActionMode r9 = super.startActionMode(r6, r7);
    L30:
        this.k0 = r9;
        goto L33
    L29:
        r9 = super/*android.webkit.WebView*/.startActionMode(r6);
        goto L30
    L5:
        if (swb.e.a(this.W) == true) goto L7;
        List<zv4.a> r1 = this.W;
        r0 = ((zv4.a) ListProtector.get(r1, ((ArrayList) r1).size() - 1)).prepareActionMode(r6);
        Log.i("DecorateWebViewV2", "delegate is not empty");
        goto L11
    L7:
        zv4.d r3 = v();
        if (r3 == null) goto L10;
        r0 = r3.prepareActionMode(r6);
        goto L11
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.view.NestBridgeWebView
    public final void onOverScrolled(int r2, int r3, boolean r4, boolean r5) {
        super.onOverScrolled(r2, r3, r4, r5);
        zv4.d r0 = v();
        if (r0 == null) goto L6;
        r0.a(r2, r3, r4, r5);
        return;
    }

    public final boolean overScrollBy(int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9, boolean r10) {
        if (this.H0 == true) goto L7;
        return true;
    L7:
        return super.overScrollBy(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
