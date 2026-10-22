package com.facebook.imagepipeline;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.view.LazySizeAttach;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SizeDeterminer {
    public static Integer d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f7977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f7978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SizeDeterminerLayoutListener f7979c;

    public static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference f7980a;

        public SizeDeterminerLayoutListener(SizeDeterminer r5) {
            this.f7980a = new WeakReference(r5);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (Log.isLoggable("SizeDeterminer", 2) == false) goto L5;
            Log.v("SizeDeterminer", "OnGlobalLayoutListener called attachStateListener=" + this);
        L5:
            SizeDeterminer r10 = (SizeDeterminer) this.f7980a.get();
            if (r10 != null) goto L8;
            return true;
        L8:
            if (r10.f7978b.isEmpty() == true) goto L41;
            View r5 = (View) r10.f7977a.get();
            if (r5 == null) goto L42;
            int r11 = r5.getPaddingRight() + r5.getPaddingLeft();
            ViewGroup.LayoutParams r12 = r5.getLayoutParams();
            int r13 = 0;
            if (r12 == null) goto L16;
            int r14 = r12.width;
        L17:
            int r15 = SizeDeterminer.a(r5.getWidth(), r14, r11, r5);
            int r16 = r5.getPaddingBottom() + r5.getPaddingTop();
            ViewGroup.LayoutParams r17 = r5.getLayoutParams();
            if (r17 == null) goto L20;
            r13 = r17.height;
        L20:
            int r18 = SizeDeterminer.a(r5.getHeight(), r13, r16, r5);
            if (r15 > 0) goto L23;
            if (r15 == Integer.MIN_VALUE) goto L23;
            return true;
        L23:
            if (r18 > 0) goto L25;
            if (r18 == Integer.MIN_VALUE) goto L25;
            return true;
        L25:
            Iterator r19 = new ArrayList(r10.f7978b).iterator();
        L27:
            if (r19.hasNext() == false) goto L29;
            LazySizeAttach r20 = (LazySizeAttach) ((SizeReadyCallback) r19.next());
            ImageRequestBuilder r21 = r20.f7942a;
            AbstractDraweeControllerBuilder r22 = r20.f7943b;
            r21.f8436c = new ResizeOptions(r15, r18, 2048.0f);
            r22.f7797c = r21.a();
            r20.f7944c.setController(r22.a());
            goto L27
        L29:
            View r23 = (View) r10.f7977a.get();
            if (r23 == null) goto L34;
            ViewTreeObserver r24 = r23.getViewTreeObserver();
            if (r24.isAlive() == false) goto L34;
            r24.removeOnPreDrawListener(r10.f7979c);
        L34:
            r10.f7979c = null;
            r10.f7978b.clear();
            return true;
        L16:
            r14 = 0;
            goto L17
        L42:
            return true;
        L41:
            return true;
        }
    }

    public SizeDeterminer(View r5) {
        this.f7978b = new ArrayList();
        this.f7977a = new WeakReference(r5);
    }

    public final void a(LazySizeAttach r10) {
        View r5 = (View) this.f7977a.get();
        if (r5 == null) goto L28;
        int r11 = r5.getPaddingRight() + r5.getPaddingLeft();
        ViewGroup.LayoutParams r12 = r5.getLayoutParams();
        int r13 = 0;
        if (r12 == null) goto L8;
        int r14 = r12.width;
    L9:
        int r15 = a(r5.getWidth(), r14, r11, r5);
        int r16 = r5.getPaddingBottom() + r5.getPaddingTop();
        ViewGroup.LayoutParams r17 = r5.getLayoutParams();
        if (r17 == null) goto L12;
        r13 = r17.height;
    L12:
        int r18 = a(r5.getHeight(), r13, r16, r5);
        if (r15 > 0) goto L15;
        if (r15 == Integer.MIN_VALUE) goto L15;
    L19:
        if (this.f7978b.contains(r10) == true) goto L22;
        this.f7978b.add(r10);
    L22:
        if (this.f7979c != null) goto L27;
        ViewTreeObserver r19 = r5.getViewTreeObserver();
        SizeDeterminerLayoutListener r20 = new SizeDeterminerLayoutListener(this);
        this.f7979c = r20;
        r19.addOnPreDrawListener(r20);
        return;
    L27:
        return;
    L15:
        if (r18 > 0) goto L25;
        if (r18 != Integer.MIN_VALUE) goto L19;
    L25:
        ImageRequestBuilder r21 = r10.f7942a;
        AbstractDraweeControllerBuilder r22 = r10.f7943b;
        r21.f8436c = new ResizeOptions(r15, r18, 2048.0f);
        r22.f7797c = r21.a();
        r10.f7944c.setController(r22.a());
        return;
    L8:
        r14 = 0;
        goto L9
    }

    public static int a(int r5, int r10, int r11, View r12) {
        int r13 = r10 - r11;
        if (r13 <= 0) goto L5;
        return r13;
    L5:
        int r14 = r5 - r11;
        if (r14 <= 0) goto L9;
        return r14;
    L9:
        if (r12.isLayoutRequested() == false) goto L11;
        return 0;
    L11:
        if (r10 == (-2)) goto L13;
        return 0;
    L13:
        if (Log.isLoggable("SizeDeterminer", 4) == false) goto L15;
        Log.i("SizeDeterminer", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
    L15:
        Context r15 = r12.getContext();
        if (d != null) goto L19;
        WindowManager r16 = (WindowManager) r15.getSystemService("window");
        r16.getClass();
        Display r17 = r16.getDefaultDisplay();
        Point r18 = new Point();
        r17.getSize(r18);
        d = Integer.valueOf(Math.max(r18.x, r18.y));
    L19:
        return d.intValue();
    }
}
