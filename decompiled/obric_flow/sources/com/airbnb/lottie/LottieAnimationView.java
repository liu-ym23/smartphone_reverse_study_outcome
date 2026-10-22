package com.airbnb.lottie;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.utilities.Contrast;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f1229r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f1231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f1232c;
    public int d;
    public final w e;
    public boolean f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1235j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f1236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f1237l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RenderMode f1238m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashSet f1239n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1240o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c0 f1241p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h f1242q;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1245c;
        public boolean d;
        public String e;
        public int f;
        public int g;

        static {
            CREATOR = new g();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeString(this.f1243a);
            r5.writeFloat(this.f1245c);
            r5.writeInt(this.d ? 1 : 0);
            r5.writeString(this.e);
            r5.writeInt(this.f);
            r5.writeInt(this.g);
        }
    }

    static {
        f1229r = new d();
    }

    public LottieAnimationView(Context r5) {
        super(r5);
        this.f1230a = new e(this, 0);
        this.f1231b = new e(this, 1);
        this.d = 0;
        this.e = new w();
        this.f1234i = false;
        this.f1235j = false;
        this.f1236k = false;
        this.f1237l = true;
        this.f1238m = RenderMode.AUTOMATIC;
        this.f1239n = new HashSet();
        this.f1240o = 0;
        o(null);
    }

    private void setCompositionTask(c0 r5) {
        this.f1242q = null;
        this.e.c();
        e();
        r5.b(this.f1230a);
        r5.a(this.f1231b);
        this.f1241p = r5;
    }

    @Override // android.view.View
    public final void buildDrawingCache(boolean r5) {
        this.f1240o++;
        super.buildDrawingCache(r5);
        if (this.f1240o == 1) goto L5;
    L13:
        this.f1240o--;
        c.a();
        return;
    L5:
        if (getWidth() <= 0) goto L13;
        if (getHeight() <= 0) goto L13;
        if (getLayerType() != 1) goto L13;
        if (getDrawingCache(r5) != null) goto L13;
        setRenderMode(RenderMode.HARDWARE);
        goto L13
    }

    public final void e() {
        c0 r5 = this.f1241p;
        if (r5 == null) goto L19;
        e r10 = this.f1230a;
        monitor-enter(r5);
        r5.f1251a.remove(r10);     // Catch: Throwable -> L16
        monitor-exit(r5);
        c0 r11 = this.f1241p;
        e r12 = this.f1231b;
        monitor-enter(r11);
        r11.f1252b.remove(r12);     // Catch: Throwable -> L13
        monitor-exit(r11);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    @Nullable
    public h getComposition() {
        return this.f1242q;
    }

    public long getDuration() {
        h r5 = this.f1242q;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return (long) r5.b();
    }

    public int getFrame() {
        return (int) this.e.f1341c.f;
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.e.f1344j;
    }

    public float getMaxFrame() {
        return this.e.f1341c.b();
    }

    public float getMinFrame() {
        return this.e.f1341c.c();
    }

    @Nullable
    public d0 getPerformanceTracker() {
        h r5 = this.e.f1340b;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.f1260a;
    }

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    public float getProgress() {
        return this.e.f1341c.a();
    }

    public int getRepeatCount() {
        return this.e.f1341c.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.e.f1341c.getRepeatMode();
    }

    public float getScale() {
        return this.e.d;
    }

    public float getSpeed() {
        return this.e.f1341c.f22184c;
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r5) {
        Drawable r10 = getDrawable();
        w r11 = this.e;
        if (r10 != r11) goto L5;
        super.invalidateDrawable(r11);
        return;
    L5:
        super.invalidateDrawable(r5);
    }

    public final void n() {
        int r5 = f.f1259a[this.f1238m.ordinal()];
        int r10 = 2;
        if (r5 == 1) goto L14;
        if (r5 != 2) goto L6;
    L7:
        r10 = 1;
        goto L14
    L6:
        if (r5 != 3) goto L7;
        h r11 = this.f1242q;
        if (r11 == null) goto L14;
        if (r11.f1269n > 4) goto L7;
    L14:
        if (r10 == getLayerType()) goto L17;
        setLayerType(r10, null);
        return;
    }

    public final void o(AttributeSet r10) {
        TypedArray r11 = getContext().obtainStyledAttributes(r10, R$styleable.LottieAnimationView);
        boolean r5 = false;
        if (isInEditMode() == true) goto L24;
        this.f1237l = r11.getBoolean(R$styleable.LottieAnimationView_lottie_cacheComposition, true);
        boolean r12 = r11.hasValue(R$styleable.LottieAnimationView_lottie_rawRes);
        boolean r13 = r11.hasValue(R$styleable.LottieAnimationView_lottie_fileName);
        boolean r14 = r11.hasValue(R$styleable.LottieAnimationView_lottie_url);
        if (r12 == false) goto L10;
        if (r13 == false) goto L10;
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    L10:
        if (r12 == false) goto L14;
        int r15 = r11.getResourceId(R$styleable.LottieAnimationView_lottie_rawRes, 0);
        if (r15 == 0) goto L22;
        setAnimation(r15);
    L22:
        setFallbackResource(r11.getResourceId(R$styleable.LottieAnimationView_lottie_fallbackRes, 0));
        goto L24
    L14:
        if (r13 == false) goto L18;
        String r16 = r11.getString(R$styleable.LottieAnimationView_lottie_fileName);
        if (r16 == null) goto L22;
        setAnimation(r16);
        goto L22
    L18:
        if (r14 == false) goto L22;
        String r17 = r11.getString(R$styleable.LottieAnimationView_lottie_url);
        if (r17 == null) goto L22;
        setAnimationFromUrl(r17);
    L24:
        if (r11.getBoolean(R$styleable.LottieAnimationView_lottie_autoPlay, false) == false) goto L26;
        this.f1235j = true;
        this.f1236k = true;
    L26:
        boolean r18 = r11.getBoolean(R$styleable.LottieAnimationView_lottie_loop, false);
        w r19 = this.e;
        if (r18 == false) goto L30;
        r19.f1341c.setRepeatCount(-1);
    L30:
        if (r11.hasValue(R$styleable.LottieAnimationView_lottie_repeatMode) == false) goto L33;
        setRepeatMode(r11.getInt(R$styleable.LottieAnimationView_lottie_repeatMode, 1));
    L33:
        if (r11.hasValue(R$styleable.LottieAnimationView_lottie_repeatCount) == false) goto L36;
        setRepeatCount(r11.getInt(R$styleable.LottieAnimationView_lottie_repeatCount, -1));
    L36:
        if (r11.hasValue(R$styleable.LottieAnimationView_lottie_speed) == false) goto L38;
        setSpeed(r11.getFloat(R$styleable.LottieAnimationView_lottie_speed, 1.0f));
    L38:
        setImageAssetsFolder(r11.getString(R$styleable.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(r11.getFloat(R$styleable.LottieAnimationView_lottie_progress, 0.0f));
        boolean r20 = r11.getBoolean(R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
        if (r19.f1346l == r20) goto L45;
        r19.f1346l = r20;
        if (r19.f1340b == null) goto L45;
        r19.b();
    L45:
        if (r11.hasValue(R$styleable.LottieAnimationView_lottie_colorFilter) == false) goto L48;
        e0 r21 = new e0(r11.getColor(R$styleable.LottieAnimationView_lottie_colorFilter, 0), PorterDuff.Mode.SRC_ATOP);
        r19.a(new o.e(new String[]{"**"}), z.f1375y, new v.c(r21));
    L48:
        if (r11.hasValue(R$styleable.LottieAnimationView_lottie_scale) == false) goto L51;
        r19.d = r11.getFloat(R$styleable.LottieAnimationView_lottie_scale, 1.0f);
        r19.n();
    L51:
        if (r11.hasValue(R$styleable.LottieAnimationView_lottie_renderMode) == false) goto L57;
        int r22 = R$styleable.LottieAnimationView_lottie_renderMode;
        RenderMode r23 = RenderMode.AUTOMATIC;
        int r24 = r11.getInt(r22, r23.ordinal());
        if (r24 < RenderMode.values().length) goto L55;
        r24 = r23.ordinal();
    L55:
        setRenderMode(RenderMode.values()[r24]);
    L57:
        if (getScaleType() == null) goto L59;
        r19.f1342h = getScaleType();
    L59:
        r11.recycle();
        Context r25 = getContext();
        PathMeasure r26 = u.f.f22191a;
        if (Settings.Global.getFloat(r25.getContentResolver(), "animator_duration_scale", 1.0f) == 0.0f) goto L62;
        r5 = true;
    L62:
        r19.e = r5;
        n();
        this.f = true;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1236k == true) goto L7;
        if (this.f1235j == true) goto L7;
        return;
    L7:
        if (isShown() == false) goto L9;
        this.e.e();
        n();
    L10:
        this.f1236k = false;
        this.f1235j = false;
        return;
    L9:
        this.f1234i = true;
        goto L10
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        w r5 = this.e;
        u.c r10 = r5.f1341c;
        if (r10 != null) goto L5;
        boolean r11 = false;
    L6:
        if (r11 == false) goto L8;
        this.f1234i = false;
        r5.g.clear();
        r5.f1341c.cancel();
        n();
        this.f1235j = true;
    L8:
        super.onDetachedFromWindow();
        return;
    L5:
        r11 = r10.f22188k;
        goto L6
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        String r11 = r10.f1243a;
        this.g = r11;
        if (TextUtils.isEmpty(r11) == true) goto L9;
        setAnimation(this.g);
    L9:
        int r12 = r10.f1244b;
        this.f1233h = r12;
        if (r12 == 0) goto L12;
        setAnimation(r12);
    L12:
        setProgress(r10.f1245c);
        boolean r13 = r10.d;
        w r14 = this.e;
        if (r13 == true) goto L15;
    L18:
        r14.f1344j = r10.e;
        setRepeatMode(r10.f);
        setRepeatCount(r10.g);
        return;
    L15:
        if (isShown() == false) goto L17;
        r14.e();
        n();
        goto L18
    L17:
        this.f1234i = true;
        goto L18
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        r5.f1243a = this.g;
        r5.f1244b = this.f1233h;
        w r10 = this.e;
        r5.f1245c = r10.f1341c.a();
        boolean r11 = false;
        u.c r12 = r10.f1341c;
        if (r12 != null) goto L5;
        boolean r13 = false;
    L6:
        if (r13 == false) goto L8;
    L11:
        r11 = true;
    L12:
        r5.d = r11;
        r5.e = r10.f1344j;
        r5.f = r12.getRepeatMode();
        r5.g = r12.getRepeatCount();
        return r5;
    L8:
        if (ViewCompat.isAttachedToWindow(this) == true) goto L12;
        if (this.f1235j == false) goto L12;
    L5:
        r13 = r12.f22188k;
        goto L6
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r5, int r10) {
        if (this.f == true) goto L5;
        return;
    L5:
        boolean r11 = isShown();
        w r12 = this.e;
        if (r11 == true) goto L8;
        u.c r13 = r12.f1341c;
        if (r13 != null) goto L17;
        boolean r14 = false;
    L18:
        if (r14 == false) goto L23;
        this.f1236k = false;
        this.f1235j = false;
        this.f1234i = false;
        r12.g.clear();
        r12.f1341c.f(true);
        n();
        this.f1234i = true;
        return;
    L23:
        return;
    L17:
        r14 = r13.f22188k;
        goto L18
    L8:
        if (this.f1234i == true) goto L10;
        return;
    L10:
        if (isShown() == false) goto L12;
        r12.f();
        n();
    L13:
        this.f1234i = false;
        return;
    L12:
        this.f1234i = true;
        goto L13
    }

    public void setAnimation(@RawRes int r5) {
        this.f1233h = r5;
        this.g = null;
        if (this.f1237l == false) goto L5;
        Context r10 = getContext();
        c0 r11 = n.a(n.e(r5, r10), new l(new WeakReference(r10), r10.getApplicationContext(), r5));
    L6:
        setCompositionTask(r11);
        return;
    L5:
        Context r12 = getContext();
        HashMap r13 = n.f1293a;
        r11 = n.a(null, new l(new WeakReference(r12), r12.getApplicationContext(), r5));
        goto L6
    }

    @Deprecated
    public void setAnimationFromJson(String r5) {
        setCompositionTask(n.a(null, new m(new ByteArrayInputStream(r5.getBytes()), 0)));
    }

    public void setAnimationFromUrl(String r5) {
        int r10 = 0;
        if (this.f1237l == false) goto L5;
        Context r11 = getContext();
        HashMap r12 = n.f1293a;
        c0 r13 = n.a(j0.C("url_", r5), new j(r11, r5, r10));
    L6:
        setCompositionTask(r13);
        return;
    L5:
        r13 = n.a(null, new j(getContext(), r5, r10));
        goto L6
    }

    public void setApplyingOpacityToLayersEnabled(boolean r5) {
        this.e.f1350p = r5;
    }

    public void setCacheComposition(boolean r5) {
        this.f1237l = r5;
    }

    public void setComposition(@NonNull h r10) {
        w r5 = this.e;
        r5.setCallback(this);
        this.f1242q = r10;
        boolean r11 = false;
        if (r5.f1340b == r10) goto L17;
        r5.f1352r = false;
        r5.c();
        r5.f1340b = r10;
        r5.b();
        u.c r12 = r5.f1341c;
        if (r12.f22187j != null) goto L8;
        r11 = true;
    L8:
        r12.f22187j = r10;
        if (r11 == false) goto L11;
        r12.h((int) Math.max(r12.f22185h, r10.f1266k), (int) Math.min(r12.f22186i, r10.f1267l));
    L12:
        float r13 = r12.f;
        r12.f = 0.0f;
        r12.g((int) r13);
        r5.m(r12.getAnimatedFraction());
        r5.d = r5.d;
        r5.n();
        r5.n();
        ArrayList r14 = r5.g;
        Iterator r15 = new ArrayList(r14).iterator();
    L14:
        if (r15.hasNext() == false) goto L16;
        ((v) r15.next()).run();
        r15.remove();
        goto L14
    L16:
        r14.clear();
        r10.f1260a.f1254a = r5.f1349o;
        r11 = true;
        goto L17
    L11:
        r12.h((int) r10.f1266k, (int) r10.f1267l);
    L17:
        n();
        if (getDrawable() != r5) goto L21;
        if (r11 == true) goto L21;
        return;
    L21:
        setImageDrawable(null);
        setImageDrawable(r5);
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator r16 = this.f1239n.iterator();
        if (r16.hasNext() == true) goto L25;
        return;
    L25:
        throw androidx.constraintlayout.motion.widget.a.g(r16);
    }

    public void setFailureListener(@Nullable y r5) {
        this.f1232c = r5;
    }

    public void setFallbackResource(@DrawableRes int r5) {
        this.d = r5;
    }

    public void setFontAssetDelegate(a r5) {
        z4.a r10 = this.e.f1345k;
    }

    public void setFrame(int r5) {
        this.e.g(r5);
    }

    public void setImageAssetDelegate(b r5) {
        n.a r10 = this.e.f1343i;
    }

    public void setImageAssetsFolder(String r5) {
        this.e.f1344j = r5;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r5) {
        e();
        super.setImageBitmap(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable r5) {
        e();
        super.setImageDrawable(r5);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int r5) {
        e();
        super.setImageResource(r5);
    }

    public void setMaxFrame(int r5) {
        this.e.h(r5);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        w r10 = this.e;
        h r11 = r10.f1340b;
        if (r11 != null) goto L5;
        r10.g.add(new r(r10, r5, 2));
        return;
    L5:
        r10.h((int) u.e.d(r11.f1266k, r11.f1267l, r5));
    }

    public void setMinAndMaxFrame(String r5) {
        this.e.j(r5);
    }

    public void setMinFrame(int r5) {
        this.e.k(r5);
    }

    public void setMinProgress(float r5) {
        w r10 = this.e;
        h r11 = r10.f1340b;
        if (r11 != null) goto L5;
        r10.g.add(new r(r10, r5, 1));
        return;
    L5:
        r10.k((int) u.e.d(r11.f1266k, r11.f1267l, r5));
    }

    public void setPerformanceTrackingEnabled(boolean r5) {
        w r10 = this.e;
        r10.f1349o = r5;
        h r11 = r10.f1340b;
        if (r11 == null) goto L6;
        r11.f1260a.f1254a = r5;
        return;
    }

    public void setProgress(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        this.e.m(r5);
    }

    public void setRenderMode(RenderMode r5) {
        this.f1238m = r5;
        n();
    }

    public void setRepeatCount(int r5) {
        this.e.f1341c.setRepeatCount(r5);
    }

    public void setRepeatMode(int r5) {
        this.e.f1341c.setRepeatMode(r5);
    }

    public void setSafeMode(boolean r5) {
        this.e.f = r5;
    }

    public void setScale(float r5) {
        w r10 = this.e;
        r10.d = r5;
        r10.n();
        if (getDrawable() != r10) goto L6;
        setImageDrawable(null);
        setImageDrawable(r10);
        return;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType r5) {
        super.setScaleType(r5);
        w r10 = this.e;
        if (r10 == null) goto L6;
        r10.f1342h = r5;
        return;
    }

    public void setSpeed(float r5) {
        this.e.f1341c.f22184c = r5;
    }

    public void setTextDelegate(f0 r5) {
        this.e.getClass();
    }

    public void setMaxFrame(String r5) {
        this.e.i(r5);
    }

    public void setMinFrame(String r5) {
        this.e.l(r5);
    }

    public LottieAnimationView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f1230a = new e(this, 0);
        this.f1231b = new e(this, 1);
        this.d = 0;
        this.e = new w();
        this.f1234i = false;
        this.f1235j = false;
        this.f1236k = false;
        this.f1237l = true;
        this.f1238m = RenderMode.AUTOMATIC;
        this.f1239n = new HashSet();
        this.f1240o = 0;
        o(r10);
    }

    public void setAnimation(String r5) {
        this.g = r5;
        int r10 = 0;
        this.f1233h = 0;
        if (this.f1237l == false) goto L5;
        Context r11 = getContext();
        HashMap r12 = n.f1293a;
        String r13 = j0.C("asset_", r5);
        c0 r14 = n.a(r13, new k(r11.getApplicationContext(), r5, r13, r10));
    L6:
        setCompositionTask(r14);
        return;
    L5:
        Context r15 = getContext();
        HashMap r16 = n.f1293a;
        r14 = n.a(null, new k(r15.getApplicationContext(), r5, null, r10));
        goto L6
    }

    public LottieAnimationView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f1230a = new e(this, 0);
        this.f1231b = new e(this, 1);
        this.d = 0;
        this.e = new w();
        this.f1234i = false;
        this.f1235j = false;
        this.f1236k = false;
        this.f1237l = true;
        this.f1238m = RenderMode.AUTOMATIC;
        this.f1239n = new HashSet();
        this.f1240o = 0;
        o(r10);
    }
}
