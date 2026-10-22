package com.ss.android.lark.imagewidget.subsampling;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageDecoder;
import com.ss.android.lark.imagewidget.subsampling.decoder.SkiaImageRegionDecoder;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class SubsamplingScaleImageView extends View {
    public static final List<Integer> E2 = null;
    public static final List<Integer> F2 = null;
    public static final List<Integer> G2 = null;
    public static Bitmap.Config H2;
    public static final List<Integer> x2 = null;
    public static final List<Integer> y2 = null;
    public PointF A;
    public PointF B;
    public Float C;
    public PointF D;
    public PointF E;
    public int F;
    public int G;
    public Paint G1;
    public int H;
    public PointF H0;
    public Paint H1;
    public Rect I;
    public Rect J;
    public boolean K;
    public boolean L;
    public PointF L0;
    public Paint L1;
    public boolean M;
    public Paint M1;
    public int N;
    public GestureDetector O;
    public GestureDetector P;
    public PointF P0;
    public l P1;
    public rlb.d Q;
    public Matrix Q1;
    public final ReadWriteLock R;
    public rlb.b<? extends rlb.c> S;
    public RectF S1;
    public rlb.b<? extends rlb.d> T;
    public final float[] T1;
    public PointF U;
    public float V;
    public e V0;
    public final float[] V1;
    public final float W;
    public Bitmap a;
    public boolean b;
    public boolean b1;
    public final float b2;
    public boolean c;
    public Uri d;
    public int e;
    public Map<Integer, List<n>> f;
    public boolean g;
    public boolean g1;
    public plb.a g2;
    public int h;
    public h h1;
    public float h2;
    public float i;
    public float j;
    public int k;
    public float k0;
    public OnScaleEventListener k1;
    public int l;
    public int m;
    public int n;
    public int o;
    public Executor p;
    public boolean p0;
    public i p1;
    public final RectF p2;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public float u;
    public int v;
    public View.OnLongClickListener v1;
    public final ScaleGestureDetector v2;
    public int w;
    public float x;
    public j x1;
    public float y;
    public final Handler y1;
    public PointF z;

    public interface OnScaleEventListener {

        public static final enum ScaleCause extends Enum<ScaleCause> {
            public static final ScaleCause DOUBLE_TAP = null;
            public static final ScaleCause GESTURE = null;
            public static final /* synthetic */ ScaleCause[] a = null;

            static {
                ScaleCause r0 = new ScaleCause("DOUBLE_TAP", 0);
                DOUBLE_TAP = r0;
                ScaleCause r1 = new ScaleCause("GESTURE", 1);
                GESTURE = r1;
                a = new ScaleCause[]{r0, r1};
            }

            public static ScaleCause[] values() {
                return (ScaleCause[]) a.clone();
            }

            public static ScaleCause valueOf(String r1) {
                return (ScaleCause) r27.a.a(ScaleCause.class, r1);
            }

            public ScaleCause(String r1, int r2) {
                super(r1, r2);
            }
        }

        void a(float r1, float r2, ScaleCause r3);

        void b(float r1);
    }

    public class a implements Handler.Callback {
        public final /* synthetic */ SubsamplingScaleImageView a;

        public a(SubsamplingScaleImageView r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r4) {
            if (r4.what != 1) goto L7;
            SubsamplingScaleImageView r5 = this.a;
            View.OnLongClickListener r1 = r5.v1;
            if (r1 == null) goto L7;
            r5.N = 0;
            SubsamplingScaleImageView.b(r5, r1);
            this.a.performLongClick();
            SubsamplingScaleImageView.c(this.a);
        L7:
            return true;
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ SubsamplingScaleImageView b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r6) {
            SubsamplingScaleImageView r0 = this.b;
            if (r0.s == false) goto L15;
            if (r0.b1 == false) goto L15;
            if (r0.z == null) goto L15;
            r0.setGestureDetector(this.a);
            SubsamplingScaleImageView r1 = this.b;
            if (r1.t == false) goto L12;
            r1.U = new PointF(r6.getX(), r6.getY());
            SubsamplingScaleImageView r2 = this.b;
            PointF r3 = this.b.z;
            r2.A = new PointF(r3.x, r3.y);
            SubsamplingScaleImageView r4 = this.b;
            r4.y = r4.x;
            r4.M = true;
            r4.K = true;
            r4.k0 = -1.0f;
            r4.L0 = r4.R(r4.U);
            SubsamplingScaleImageView r5 = this.b;
            r5.P0 = new PointF(r6.getX(), r6.getY());
            SubsamplingScaleImageView r7 = this.b;
            PointF r8 = this.b.L0;
            r7.H0 = new PointF(r8.x, r8.y);
            this.b.p0 = false;
            return false;
        L12:
            r1.o(r1.R(new PointF(r6.getX(), r6.getY())), new PointF(r6.getX(), r6.getY()));
            return true;
        L15:
            return onDoubleTapEvent(r6);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r1) {
            this.b.performClick();
            return true;
        }

        public b(SubsamplingScaleImageView r1, Context r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            SubsamplingScaleImageView r0 = this.b;
            if (r0.r == false) goto L23;
            if (r0.b1 == false) goto L23;
            if (r0.z == null) goto L23;
            if (r4 == null) goto L23;
            if (r5 == null) goto L23;
            if (Math.abs(r4.getX() - r5.getX()) > 50.0f) goto L15;
            if (Math.abs(r4.getY() - r5.getY()) <= 50.0f) goto L23;
        L15:
            if (Math.abs(r6) > 500.0f) goto L19;
            if (Math.abs(r7) <= 500.0f) goto L23;
        L19:
            if (this.b.K == true) goto L23;
            PointF r8 = this.b.z;
            PointF r9 = new PointF(r8.x + (r6 * 0.25f), r8.y + (r7 * 0.25f));
            float r10 = (this.b.getWidth() / 2) - r9.x;
            SubsamplingScaleImageView r11 = this.b;
            float r12 = r10 / r11.x;
            float r13 = (r11.getHeight() / 2) - r9.y;
            SubsamplingScaleImageView r14 = this.b;
            f r15 = new f(r14, new PointF(r12, r13 / r14.x));
            r15.b();
            r15.h = false;
            r15.f = 3;
            r15.a();
            return true;
        L23:
            return super.onFling(r4, r5, r6, r7);
        }
    }

    public class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ SubsamplingScaleImageView a;

        public c(SubsamplingScaleImageView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r1) {
            this.a.performClick();
            return true;
        }
    }

    public class d implements ScaleGestureDetector.OnScaleGestureListener {
        public final /* synthetic */ SubsamplingScaleImageView a;

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r1) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector r1) {
        }

        public d(SubsamplingScaleImageView r1) {
            this.a = r1;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r2) {
            OnScaleEventListener r0 = this.a.k1;
            if (r0 == null) goto L7;
            r0.b(r2.getScaleFactor());
            return true;
        L7:
            return true;
        }
    }

    public static class e {
        public float a;
        public float b;
        public PointF c;
        public PointF d;
        public PointF e;
        public PointF f;
        public PointF g;
        public long h;
        public boolean i;
        public int j;
        public int k;
        public long l;
        public boolean m;

        public e() {
            this.h = 500;
            this.i = true;
            this.j = 2;
            this.k = 1;
            this.l = System.currentTimeMillis();
            this.m = false;
        }
    }

    public final class f {
        public final float a;
        public final PointF b;
        public final PointF c;
        public long d;
        public int e;
        public int f;
        public boolean g;
        public boolean h;
        public boolean i;
        public final /* synthetic */ SubsamplingScaleImageView j;

        public final void a() {
            SubsamplingScaleImageView r0 = this.j;
            e r1 = r0.V0;
            int r2 = r0.getPaddingLeft() + (((this.j.getWidth() - this.j.getPaddingRight()) - this.j.getPaddingLeft()) / 2);
            int r3 = this.j.getPaddingTop() + (((this.j.getHeight() - this.j.getPaddingBottom()) - this.j.getPaddingTop()) / 2);
            SubsamplingScaleImageView r4 = this.j;
            float r5 = Math.min(r4.i, Math.max(r4.x(), this.a));
            if (this.h == false) goto L5;
            SubsamplingScaleImageView r6 = this.j;
            PointF r7 = this.b;
            float r8 = r7.x;
            float r9 = r7.y;
            PointF r10 = new PointF();
            PointF r11 = r6.Q(r8, r9, r5);
            r10.set(((r6.getPaddingLeft() + (((r6.getWidth() - r6.getPaddingRight()) - r6.getPaddingLeft()) / 2)) - r11.x) / r5, ((r6.getPaddingTop() + (((r6.getHeight() - r6.getPaddingBottom()) - r6.getPaddingTop()) / 2)) - r11.y) / r5);
        L6:
            this.j.V0 = new e();
            SubsamplingScaleImageView r12 = this.j;
            e r13 = r12.V0;
            r13.a = r12.x;
            r13.b = r5;
            r13.l = System.currentTimeMillis();
            SubsamplingScaleImageView r14 = this.j;
            e r15 = r14.V0;
            r15.e = r10;
            r15.c = r14.getCenter();
            SubsamplingScaleImageView r16 = this.j;
            e r17 = r16.V0;
            r17.d = r10;
            r17.f = r16.N(r10);
            this.j.V0.g = new PointF(r2, r3);
            e r18 = this.j.V0;
            r18.h = this.d;
            r18.i = this.g;
            r18.j = this.e;
            r18.k = this.f;
            r18.m = this.i;
            r18.l = System.currentTimeMillis();
            this.j.V0.getClass();
            PointF r19 = this.c;
            if (r19 == null) goto L9;
            float r20 = r19.x;
            PointF r21 = this.j.V0.c;
            float r22 = r20 - (r21.x * r5);
            float r23 = r19.y - (r21.y * r5);
            PointF r24 = new PointF(r22, r23);
            this.j.s(true, new l(r5, r24));
            e r25 = this.j.V0;
            PointF r26 = this.c;
            r25.g = new PointF(r26.x + (r24.x - r22), r26.y + (r24.y - r23));
        L9:
            this.j.invalidate();
            return;
        L5:
            r10 = this.b;
            goto L6
        }

        public final void b() {
            if (SubsamplingScaleImageView.E2.contains(1) == false) goto L7;
            this.e = 1;
            return;
        L7:
            throw new IllegalArgumentException("Unknown easing type: 1");
        }

        public f(SubsamplingScaleImageView r3, float r4) {
            this.j = r3;
            this.d = 500;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.i = false;
            this.a = r4;
            this.b = r3.getCenter();
            this.c = null;
        }

        public f(SubsamplingScaleImageView r3, PointF r4) {
            this.j = r3;
            this.d = 500;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.i = false;
            this.a = r3.x;
            this.b = r4;
            this.c = null;
        }

        public f(SubsamplingScaleImageView r3, float r4, PointF r5) {
            this.j = r3;
            this.d = 500;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.i = false;
            this.a = r4;
            this.b = r5;
            this.c = null;
        }

        public f(SubsamplingScaleImageView r3, float r4, PointF r5, PointF r6) {
            this.j = r3;
            this.d = 500;
            this.e = 2;
            this.f = 1;
            this.g = true;
            this.h = true;
            this.i = false;
            this.a = r4;
            this.b = r5;
            this.c = r6;
        }
    }

    public static class g extends PthreadAsyncTask<Void, Void, Integer> {
        public final WeakReference<SubsamplingScaleImageView> h;
        public final WeakReference<Context> i;
        public final WeakReference<rlb.b<? extends rlb.c>> j;
        public final Uri k;
        public final boolean l;
        public Bitmap m;
        public Exception n;

        public final Object doInBackground(Object[] r8) {
            Void[] r9 = (Void[]) r8;
            String r0 = this.k.toString();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            Context r1 = this.i.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            rlb.b<? extends rlb.c> r2 = this.j.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            SubsamplingScaleImageView r3 = this.h.get();     // Catch: OutOfMemoryError -> L9 Exception -> L11
            if (r1 == null) goto L13;
            if (r2 == null) goto L13;
            if (r3 == null) goto L13;
            List<Integer> r6 = SubsamplingScaleImageView.x2;     // Catch: OutOfMemoryError -> L9 Exception -> L11
            r3.m("BitmapLoadTask.doInBackground", new Object[0]);     // Catch: OutOfMemoryError -> L9 Exception -> L11
            this.m = r2.make().decode(r1, this.k);     // Catch: OutOfMemoryError -> L9 Exception -> L11
        L17:
            return Integer.valueOf(SubsamplingScaleImageView.d(r3, r1, r0));
        L13:
            return null;
        L11:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to load bitmap", e);
            this.n = e;
        L9:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to load bitmap - OutOfMemoryError", e);
            this.n = new RuntimeException(e);
            goto L13
        }

        public final void onPostExecute(Object r4) {
            Integer r5 = (Integer) r4;
            SubsamplingScaleImageView r0 = this.h.get();
            if (r0 == null) goto L20;
            Bitmap r1 = this.m;
            if (r1 == null) goto L12;
            if (r5 == null) goto L12;
            if (this.l == false) goto L10;
            List<Integer> r6 = SubsamplingScaleImageView.x2;
            r0.z(r1);
            return;
        L10:
            int r7 = r5.intValue();
            List<Integer> r2 = SubsamplingScaleImageView.x2;
            r0.y(r1, r7, false);
            return;
        L12:
            if (this.n == null) goto L23;
            h r8 = r0.h1;
            if (r8 != null) goto L16;
            return;
        L16:
            if (this.l == false) goto L18;
            r8.a();
            return;
        L18:
            r8.b();
            return;
        L23:
            return;
        }

        public g(SubsamplingScaleImageView r2, Context r3, rlb.b<? extends rlb.c> r4, Uri r5, boolean r6) {
            this.h = new WeakReference(r2);
            this.i = new WeakReference(r3);
            this.j = new WeakReference(r4);
            this.k = r5;
            this.l = r6;
        }
    }

    public interface h {
        void a();

        void b();

        void c();

        void onImageLoaded();

        void onPreviewReleased();

        void onReady();
    }

    public interface i {
        void a(RectF r1);
    }

    public interface j {
        PointF a(PointF r1);

        float b(int r1, int r2, int r3, int r4);
    }

    public interface k {
    }

    public static class l {
        public float a;
        public final PointF b;

        public l(float r1, PointF r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class m {
    }

    public static class n {
        public Rect a;
        public int b;
        public Bitmap c;
        public boolean d;
        public boolean e;
        public Rect f;
        public Rect g;

        public n() {
        }
    }

    public static class o extends PthreadAsyncTask<Void, Void, Bitmap> {
        public final WeakReference<SubsamplingScaleImageView> h;
        public final WeakReference<rlb.d> i;
        public final WeakReference<n> j;
        public Exception k;

        public final Object doInBackground(Object[] r9) {
            Void[] r10 = (Void[]) r9;
            SubsamplingScaleImageView r0 = this.h.get();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            rlb.d r1 = this.i.get();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            n r2 = this.j.get();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            if (r1 == null) goto L25;
            if (r2 == null) goto L25;
            if (r0 == null) goto L25;
            if (r1.isReady() == false) goto L25;
            if (r2.e == false) goto L25;
            Object[] r5 = {r2.a, Integer.valueOf(r2.b)};     // Catch: OutOfMemoryError -> L28 Exception -> L30
            List<Integer> r6 = SubsamplingScaleImageView.x2;     // Catch: OutOfMemoryError -> L28 Exception -> L30
            r0.m("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", r5);     // Catch: OutOfMemoryError -> L28 Exception -> L30
            ((ReentrantReadWriteLock) r0.R).readLock().lock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L22:
            th = move-exception;
            ((ReentrantReadWriteLock) r0.R).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            throw th;     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L13:
            if (r1.isReady() == false) goto L20;
            SubsamplingScaleImageView.e(r0, r2.a, r2.g);     // Catch: Throwable -> L22
            Rect r3 = r0.I;     // Catch: Throwable -> L22
            if (r3 == null) goto L17;
            r2.g.offset(r3.left, r3.top);     // Catch: Throwable -> L22
        L17:
            Bitmap r4 = r1.decodeRegion(r2.g, r2.b);     // Catch: Throwable -> L22
            ((ReentrantReadWriteLock) r0.R).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
            return r4;
        L20:
            r2.d = false;     // Catch: Throwable -> L22
            ((ReentrantReadWriteLock) r0.R).readLock().unlock();     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L32:
            return null;
        L25:
            if (r2 == null) goto L32;
            r2.d = false;     // Catch: OutOfMemoryError -> L28 Exception -> L30
        L30:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to decode tile", e);
            this.k = e;
        L28:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to decode tile - OutOfMemoryError", e);
            this.k = new RuntimeException(e);
            goto L32
        }

        public final void onPostExecute(Object r4) {
            Bitmap r5 = (Bitmap) r4;
            SubsamplingScaleImageView r0 = this.h.get();
            n r1 = this.j.get();
            if (r0 == null) goto L35;
            if (r1 == null) goto L36;
            if (r5 == null) goto L28;
            r1.c = r5;
            r1.d = false;
            List<Integer> r2 = SubsamplingScaleImageView.x2;
            monitor-enter(r0);
            r0.m("onTileLoaded", new Object[0]);     // Catch: Throwable -> L24
            r0.k();     // Catch: Throwable -> L24
            r0.j();     // Catch: Throwable -> L24
            if (r0.w() == false) goto L21;
            Bitmap r3 = r0.a;     // Catch: Throwable -> L24
            if (r3 == null) goto L21;
            if (r0.c == true) goto L15;
            r3.recycle();     // Catch: Throwable -> L24
        L15:
            r0.a = null;     // Catch: Throwable -> L24
            h r6 = r0.h1;     // Catch: Throwable -> L24
            if (r6 != null) goto L18;
        L20:
            r0.b = false;     // Catch: Throwable -> L24
            r0.c = false;     // Catch: Throwable -> L24
            goto L21
        L18:
            if (r0.c == false) goto L20;
            r6.onPreviewReleased();     // Catch: Throwable -> L24
        L21:
            r0.invalidate();     // Catch: Throwable -> L24
            monitor-exit(r0);
            return;
        L24:
            th = move-exception;
            throw th;
        L28:
            if (this.k == null) goto L37;
            h r7 = r0.h1;
            if (r7 == null) goto L38;
            r7.c();
            return;
        L38:
            return;
        L37:
            return;
        L36:
            return;
        }

        public o(SubsamplingScaleImageView r2, rlb.d r3, n r4) {
            this.h = new WeakReference(r2);
            this.i = new WeakReference(r3);
            this.j = new WeakReference(r4);
            r4.d = true;
        }
    }

    public static class p extends PthreadAsyncTask<Void, Void, int[]> {
        public final WeakReference<SubsamplingScaleImageView> h;
        public final WeakReference<Context> i;
        public final WeakReference<rlb.b<? extends rlb.d>> j;
        public final Uri k;
        public rlb.d l;
        public Exception m;

        public final Object doInBackground(Object[] r8) {
            Void[] r9 = (Void[]) r8;
            String r10 = this.k.toString();     // Catch: Exception -> L12
            Context r0 = this.i.get();     // Catch: Exception -> L12
            rlb.b<? extends rlb.d> r1 = this.j.get();     // Catch: Exception -> L12
            SubsamplingScaleImageView r2 = this.h.get();     // Catch: Exception -> L12
            if (r0 == null) goto L14;
            if (r1 == null) goto L14;
            if (r2 == null) goto L14;
            List<Integer> r6 = SubsamplingScaleImageView.x2;     // Catch: Exception -> L12
            r2.m("TilesInitTask.doInBackground", new Object[0]);     // Catch: Exception -> L12
            rlb.d r3 = r1.make();     // Catch: Exception -> L12
            this.l = r3;     // Catch: Exception -> L12
            Point r4 = r3.init(r0, this.k);     // Catch: Exception -> L12
            int r5 = r4.x;     // Catch: Exception -> L12
            int r7 = r4.y;     // Catch: Exception -> L12
            int r11 = SubsamplingScaleImageView.d(r2, r0, r10);     // Catch: Exception -> L12
            Rect r12 = r2.I;     // Catch: Exception -> L12
            if (r12 == null) goto L10;
            r12.left = Math.max(0, r12.left);     // Catch: Exception -> L12
            Rect r13 = r2.I;     // Catch: Exception -> L12
            r13.top = Math.max(0, r13.top);     // Catch: Exception -> L12
            Rect r14 = r2.I;     // Catch: Exception -> L12
            r14.right = Math.min(r5, r14.right);     // Catch: Exception -> L12
            Rect r15 = r2.I;     // Catch: Exception -> L12
            r15.bottom = Math.min(r7, r15.bottom);     // Catch: Exception -> L12
            r5 = r2.I.width();     // Catch: Exception -> L12
            r7 = r2.I.height();     // Catch: Exception -> L12
        L10:
            return new int[]{r5, r7, r11};
        L14:
            return null;
        L12:
            e = move-exception;
            Log.e("SubsamplingScaleImageView", "Failed to initialise bitmap decoder", e);
            this.m = e;
            goto L14
        }

        public final void onPostExecute(Object r11) {
            int[] r12 = (int[]) r11;
            SubsamplingScaleImageView r0 = this.h.get();
            if (r0 == null) goto L56;
            rlb.d r1 = this.l;
            if (r1 == null) goto L49;
            if (r12 == null) goto L49;
            if (r12.length != 3) goto L49;
            int r4 = r12[0];
            int r6 = r12[1];
            int r13 = r12[2];
            List<Integer> r8 = SubsamplingScaleImageView.x2;
            monitor-enter(r0);
            r0.m("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", new Object[]{Integer.valueOf(r4), Integer.valueOf(r6), Integer.valueOf(r0.h)});     // Catch: Throwable -> L45
            int r3 = r0.F;     // Catch: Throwable -> L45
            if (r3 <= 0) goto L28;
            int r5 = r0.G;     // Catch: Throwable -> L45
            if (r5 <= 0) goto L28;
            if (r3 != r4) goto L17;
            if (r5 == r6) goto L28;
        L17:
            r0.G(false);     // Catch: Throwable -> L45
            Bitmap r7 = r0.a;     // Catch: Throwable -> L45
            if (r7 == null) goto L28;
            if (r0.c == true) goto L22;
            r7.recycle();     // Catch: Throwable -> L45
        L22:
            r0.a = null;     // Catch: Throwable -> L45
            h r9 = r0.h1;     // Catch: Throwable -> L45
            if (r9 != null) goto L25;
        L27:
            r0.b = false;     // Catch: Throwable -> L45
            r0.c = false;     // Catch: Throwable -> L45
            goto L28
        L25:
            if (r0.c == false) goto L27;
            r9.onPreviewReleased();     // Catch: Throwable -> L45
        L28:
            r0.Q = r1;     // Catch: Throwable -> L45
            r0.F = r4;     // Catch: Throwable -> L45
            r0.G = r6;     // Catch: Throwable -> L45
            r0.H = r13;     // Catch: Throwable -> L45
            r0.k();     // Catch: Throwable -> L45
            if (r0.j() == true) goto L42;
            int r14 = r0.n;     // Catch: Throwable -> L45
            if (r14 <= 0) goto L42;
            if (r14 == Integer.MAX_VALUE) goto L42;
            int r15 = r0.o;     // Catch: Throwable -> L45
            if (r15 <= 0) goto L42;
            if (r15 == Integer.MAX_VALUE) goto L42;
            if (r0.getWidth() <= 0) goto L42;
            if (r0.getHeight() <= 0) goto L42;
            r0.v(new Point(r0.n, r0.o));     // Catch: Throwable -> L45
        L42:
            r0.invalidate();     // Catch: Throwable -> L45
            r0.requestLayout();     // Catch: Throwable -> L45
            monitor-exit(r0);
            return;
        L45:
            th = move-exception;
            throw th;
        L49:
            if (this.m == null) goto L57;
            h r16 = r0.h1;
            if (r16 == null) goto L58;
            r16.b();
            return;
        L58:
            return;
        L57:
            return;
        }

        public p(SubsamplingScaleImageView r2, Context r3, rlb.b<? extends rlb.d> r4, Uri r5) {
            this.h = new WeakReference(r2);
            this.i = new WeakReference(r3);
            this.j = new WeakReference(r4);
            this.k = r5;
        }
    }

    static {
        x2 = Arrays.asList(new Integer[]{0, 90, 180, 270, 2, 4, -1});
        y2 = Arrays.asList(new Integer[]{1, 2, 3});
        E2 = Arrays.asList(new Integer[]{2, 1});
        F2 = Arrays.asList(new Integer[]{1, 2, 3});
        G2 = Arrays.asList(new Integer[]{2, 1, 3, 4});
    }

    public void B() {
        C(false);
    }

    public void f(Canvas r1) {
    }

    public void g(Canvas r1) {
    }

    public void setOnStateChangedListener(k r1) {
    }

    public void setScaleImageConfig(m r1) {
    }

    public Matrix getBitmapMatrix() {
        Matrix r0 = this.Q1;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new Matrix();
    }

    public RectF getContentRect() {
        if (this.z != null) goto L5;
        return null;
    L5:
        if (getSWidth() > 0) goto L7;
        return null;
    L7:
        if (getSHeight() <= 0) goto L14;
        float r0 = getScale();
        float r1 = getSWidth() * r0;
        float r2 = getSHeight() * r0;
        PointF r3 = this.z;
        float r4 = r3.x;
        float r5 = r3.y;
        return new RectF(r4, r5, r1 + r4, r2 + r5);
    L14:
        return null;
    }

    public Bitmap getImageBitmap() {
        Bitmap r0 = this.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (CollectionUtils.isEmpty(this.f) == true) goto L36;
        Iterator<List<n>> r1 = this.f.values().iterator();     // Catch: Exception -> L21
    L9:
        if (r1.hasNext() == false) goto L37;
        Iterator<n> r2 = r1.next().iterator();     // Catch: Exception -> L21
    L12:
        if (r2.hasNext() == false) goto L9;
        n r3 = r2.next();     // Catch: Exception -> L21
        if (r3.e == false) goto L12;
        Bitmap r4 = r3.c;     // Catch: Exception -> L21
        if (r4 == null) goto L12;
        if (r4.isRecycled() == true) goto L12;
        return r3.c;
    L37:
        return null;
    L21:
        e = move-exception;
        Log.e("SubsamplingScaleImageView", "Error getting bitmap from tiles", e);
        return null;
    L36:
        return null;
    }

    public Drawable getImageDrawable() {
        return new ukb.a(getContext().getResources(), this.a);
    }

    public int getRequiredRotation() {
        int r0 = this.h;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return this.H;
    }

    public float getScaleFactor() {
        return 1.0f / getMinScale();
    }

    public final ImageViewState getState() {
        if (this.z != null) goto L5;
        return null;
    L5:
        if (this.F > 0) goto L7;
        return null;
    L7:
        if (this.G > 0) goto L9;
        return null;
    L9:
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public RectF getVisibleTileRectOnView() {
        return new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    public final boolean u() {
        if (this.d == null) goto L5;
    L8:
        return true;
    L5:
        if (this.a != null) goto L8;
        return false;
    }

    public final boolean w() {
        boolean r1 = true;
        if (this.a != null) goto L5;
    L7:
        Map<Integer, List<n>> r0 = this.f;
        if (r0 == null) goto L23;
        Iterator<Map.Entry<Integer, List<n>>> r2 = r0.entrySet().iterator();
    L11:
        if (r2.hasNext() == false) goto L22;
        Map.Entry<Integer, List<n>> r3 = r2.next();
        if (r3.getKey().intValue() != this.e) goto L11;
        Iterator<n> r4 = r3.getValue().iterator();
    L16:
        if (r4.hasNext() == false) goto L11;
        n r5 = r4.next();
        if (r5.d == true) goto L21;
        if (r5.c != null) goto L16;
    L21:
        r1 = false;
        goto L16
    L22:
        return r1;
    L23:
        return false;
    L5:
        if (this.b == true) goto L7;
        return true;
    }

    public final int H() {
        int r0 = getRequiredRotation();
        if (r0 == 90) goto L10;
        if (r0 == 270) goto L10;
        return this.G;
    L10:
        return this.F;
    }

    public final int I() {
        int r0 = getRequiredRotation();
        if (r0 == 90) goto L10;
        if (r0 == 270) goto L10;
        return this.F;
    L10:
        return this.G;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        float r0 = getWidth() / 2;
        float r1 = getHeight() / 2;
        PointF r2 = new PointF();
        PointF r3 = this.z;
        if (r3 != null) goto L5;
        return null;
    L5:
        float r4 = r0 - r3.x;
        float r5 = this.x;
        r2.set(r4 / r5, (r1 - r3.y) / r5);
        return r2;
    }

    public float getMaximumScale() {
        return getMaxScale();
    }

    public final float getMinScale() {
        return x();
    }

    public float getMinimumScale() {
        return getMinScale();
    }

    public final boolean j() {
        boolean r0 = w();
        if (this.g1 == true) goto L11;
        if (r0 == false) goto L11;
        B();
        this.g1 = true;
        h r1 = this.h1;
        if (r1 == null) goto L9;
        r1.onImageLoaded();
    L9:
        if (this.p1 == null) goto L11;
        i(this.z);
        this.p1.a(this.p2);
    L11:
        return r0;
    }

    public final boolean k() {
        if (getWidth() > 0) goto L5;
    L15:
        boolean r0 = false;
    L17:
        if (this.b1 == true) goto L22;
        if (r0 == false) goto L22;
        B();
        this.b1 = true;
        h r1 = this.h1;
        if (r1 == null) goto L22;
        r1.onReady();
    L22:
        return r0;
    L5:
        if (getHeight() <= 0) goto L15;
        if (this.F <= 0) goto L15;
        if (this.G <= 0) goto L15;
        if (this.a == null) goto L13;
    L14:
        r0 = true;
        goto L17
    L13:
        if (w() == false) goto L15;
        goto L14
    }

    public final float x() {
        int r0 = getPaddingBottom() + getPaddingTop();
        int r1 = getPaddingLeft() + getPaddingRight();
        int r2 = this.m;
        if (r2 == 2) goto L15;
        if (r2 == 4) goto L15;
        if (r2 != 3) goto L13;
        float r3 = this.j;
        if (r3 <= 0.0f) goto L13;
        return r3;
    L13:
        return Math.min((getWidth() - r1) / I(), (getHeight() - r0) / H());
    L15:
        return Math.max((getWidth() - r1) / I(), (getHeight() - r0) / H());
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return H2;
    }

    public float getMaxScale() {
        return this.i;
    }

    public j getOnSizeChangedStrategy() {
        return this.x1;
    }

    public final int getOrientation() {
        return this.h;
    }

    public final int getSHeight() {
        return this.G;
    }

    public final int getSWidth() {
        return this.F;
    }

    public final float getScale() {
        return this.x;
    }

    public SubsamplingScaleImageView(Context r2) {
        this(r2, null);
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ void c(SubsamplingScaleImageView r1) {
        super.setOnLongClickListener(null);
    }

    public static void setPreferredBitmapConfig(Bitmap.Config r0) {
        H2 = r0;
    }

    public boolean A(MotionEvent r13) {
        int r0 = r13.getPointerCount();
        int r1 = r13.getAction();
        if (r1 == 0) goto L172;
        if (r1 == 1) goto L137;
        if (r1 == 2) goto L16;
        if (r1 != 5) goto L9;
    L173:
        this.V0 = null;
        F(true);
        this.N = Math.max(this.N, r0);
        if (r0 < 2) goto L181;
        if (this.s == false) goto L178;
        float r2 = n(r13.getX(0), r13.getX(1), r13.getY(0), r13.getY(1));
        this.y = this.x;
        this.V = r2;
        PointF r3 = this.A;
        PointF r4 = this.z;
        r3.set(r4.x, r4.y);
        this.U.set((r13.getX(0) + r13.getX(1)) / 2.0f, (r13.getY(0) + r13.getY(1)) / 2.0f);
    L179:
        this.y1.removeMessages(1);
    L183:
        return true;
    L178:
        this.N = 0;
        goto L179
    L181:
        if (this.M == true) goto L183;
        PointF r5 = this.A;
        PointF r6 = this.z;
        r5.set(r6.x, r6.y);
        this.U.set(r13.getX(), r13.getY());
        this.y1.sendEmptyMessageDelayed(1, 600);
        goto L183
    L9:
        if (r1 != 6) goto L11;
    L145:
        this.y1.removeMessages(1);
        if (this.M == false) goto L151;
        this.M = false;
        if (this.p0 == true) goto L151;
        o(this.L0, this.U);
    L151:
        if (this.N <= 0) goto L169;
        boolean r7 = this.K;
        if (r7 == false) goto L155;
    L156:
        if (r7 == false) goto L163;
        if (r0 != 2) goto L163;
        this.L = true;
        PointF r8 = this.A;
        PointF r9 = this.z;
        r8.set(r9.x, r9.y);
        if (r13.getActionIndex() != 1) goto L161;
        this.U.set(r13.getX(0), r13.getY(0));
        goto L163
    L161:
        this.U.set(r13.getX(1), r13.getY(1));
    L163:
        if (r0 >= 3) goto L165;
        this.K = false;
    L165:
        if (r0 >= 2) goto L167;
        this.L = false;
        this.N = 0;
    L167:
        E(true);
        return true;
    L155:
        if (this.L == true) goto L156;
    L169:
        if (r0 != 1) goto L171;
        this.K = false;
        this.L = false;
        this.N = 0;
    L171:
        return true;
    L11:
        if (r1 == 261) goto L173;
        if (r1 == 262) goto L145;
    L136:
        return false;
    L16:
        if (this.N > 0) goto L18;
    L132:
        boolean r14 = false;
    L133:
        if (r14 == false) goto L136;
        this.y1.removeMessages(1);
        invalidate();
        return true;
    L18:
        if (r0 < 2) goto L47;
        float r10 = n(r13.getX(0), r13.getX(1), r13.getY(0), r13.getY(1));
        float r11 = (r13.getX(0) + r13.getX(1)) / 2.0f;
        float r12 = (r13.getY(0) + r13.getY(1)) / 2.0f;
        if (this.s == false) goto L132;
        PointF r15 = this.U;
        if (n(r15.x, r11, r15.y, r12) <= 5.0f) goto L24;
    L27:
        this.K = true;
        this.L = true;
        double r16 = this.x;
        float r17 = Math.min(this.i, (r10 / this.V) * this.y);
        this.x = r17;
        if (r17 > x()) goto L31;
        this.V = r10;
        this.y = x();
        this.U.set(r11, r12);
        this.A.set(this.z);
    L45:
        r(true);
        E(this.q);
    L131:
        r14 = true;
        goto L133
    L31:
        if (this.r == false) goto L42;
        PointF r18 = this.U;
        float r19 = r18.x;
        PointF r20 = this.A;
        float r21 = r19 - r20.x;
        float r110 = r18.y - r20.y;
        float r22 = this.x / this.y;
        float r23 = r21 * r22;
        float r111 = r110 * r22;
        PointF r24 = this.z;
        r24.x = r11 - r23;
        r24.y = r12 - r111;
        if ((((double) H()) * r16) >= getHeight()) goto L37;
        if ((this.x * H()) < getHeight()) goto L37;
    L40:
        r(true);
        this.U.set(r11, r12);
        this.A.set(this.z);
        this.y = this.x;
        this.V = r10;
    L37:
        if ((r16 * ((double) I())) >= getWidth()) goto L45;
        if ((this.x * I()) < getWidth()) goto L45;
    L42:
        if (this.E == null) goto L44;
        this.z.x = (getWidth() / 2) - (this.x * this.E.x);
        this.z.y = (getHeight() / 2) - (this.x * this.E.y);
        goto L45
    L44:
        this.z.x = (getWidth() / 2) - (this.x * (I() / 2));
        this.z.y = (getHeight() / 2) - (this.x * (H() / 2));
        goto L45
    L24:
        if (Math.abs(r10 - this.V) > 5.0f) goto L27;
        if (this.L == false) goto L132;
    L47:
        if (this.M == false) goto L81;
        float r25 = (Math.abs(this.P0.y - r13.getY()) * 2.0f) + this.W;
        if (this.k0 != (-1.0f)) goto L51;
        this.k0 = r25;
    L51:
        float r26 = r13.getY();
        PointF r27 = this.H0;
        if (r26 <= r27.y) goto L54;
        boolean r28 = true;
    L55:
        r27.set(0.0f, r13.getY());
        float r29 = 1.0f;
        float r112 = Math.abs(1.0f - (r25 / this.k0)) * 0.5f;
        if (r112 <= 0.03f) goto L58;
    L59:
        this.p0 = true;
        if (this.k0 <= 0.0f) goto L64;
        if (r28 == false) goto L63;
        r29 = 1.0f + r112;
        goto L64
    L63:
        r29 = 1.0f - r112;
    L64:
        double r30 = this.x;
        float r113 = Math.max(x(), Math.min(this.i, this.x * r29));
        this.x = r113;
        if (this.r == false) goto L76;
        PointF r31 = this.U;
        float r32 = r31.x;
        PointF r33 = this.A;
        float r34 = r32 - r33.x;
        float r35 = r31.y;
        float r36 = r35 - r33.y;
        float r114 = r113 / this.y;
        float r37 = r34 * r114;
        float r38 = r36 * r114;
        PointF r115 = this.z;
        r115.x = r32 - r37;
        r115.y = r35 - r38;
        if ((((double) H()) * r30) >= getHeight()) goto L71;
        if ((this.x * H()) < getHeight()) goto L71;
    L74:
        r(true);
        this.U.set(N(this.L0));
        this.A.set(this.z);
        this.y = this.x;
        r25 = 0.0f;
    L79:
        this.k0 = r25;
        r(true);
        E(this.q);
    L71:
        if ((r30 * ((double) I())) >= getWidth()) goto L79;
        if ((this.x * I()) < getWidth()) goto L79;
    L76:
        if (this.E == null) goto L78;
        this.z.x = (getWidth() / 2) - (this.x * this.E.x);
        this.z.y = (getHeight() / 2) - (this.x * this.E.y);
        goto L79
    L78:
        this.z.x = (getWidth() / 2) - (this.x * (I() / 2));
        this.z.y = (getHeight() / 2) - (this.x * (H() / 2));
        goto L79
    L58:
        if (this.p0 == false) goto L79;
    L54:
        r28 = false;
        goto L55
    L81:
        if (this.K == true) goto L132;
        float r39 = Math.abs(r13.getX() - this.U.x);
        float r40 = Math.abs(r13.getY() - this.U.y);
        float r41 = this.b2 * 5.0f;
        if (r39 <= r41) goto L85;
    L88:
        this.z.x = this.A.x + (r13.getX() - this.U.x);
        this.z.y = this.A.y + (r13.getY() - this.U.y);
        PointF r116 = this.z;
        float r42 = r116.x;
        float r117 = r116.y;
        r(true);
        PointF r43 = this.z;
        if (r42 == r43.x) goto L91;
        boolean r44 = true;
    L92:
        float r45 = r43.y;
        if (r117 == r45) goto L95;
        boolean r46 = true;
    L96:
        if (r44 == true) goto L98;
    L102:
        boolean r47 = false;
    L103:
        if (r46 == true) goto L105;
    L109:
        boolean r48 = false;
    L110:
        if (r117 == r45) goto L112;
    L114:
        boolean r118 = false;
    L115:
        if (r47 == true) goto L123;
        if (r48 == true) goto L123;
        if (r44 == false) goto L122;
        if (r46 == false) goto L122;
        if (r118 == true) goto L122;
        if (this.L == false) goto L123;
    L122:
        this.L = true;
    L128:
        if (this.r == true) goto L130;
        PointF r119 = this.z;
        PointF r49 = this.A;
        r119.x = r49.x;
        r119.y = r49.y;
        F(false);
    L130:
        E(this.q);
    L123:
        if (r39 <= r41) goto L125;
    L126:
        this.N = 0;
        this.y1.removeMessages(1);
        F(false);
        goto L128
    L125:
        if (r40 <= r41) goto L128;
    L112:
        if (r40 <= (3.0f * r41)) goto L114;
        r118 = true;
        goto L115
    L105:
        if (r40 <= r39) goto L109;
        if (this.L == true) goto L109;
        r48 = true;
        goto L110
    L98:
        if (r39 <= r40) goto L102;
        if (this.L == true) goto L102;
        r47 = true;
        goto L103
    L95:
        r46 = false;
        goto L96
    L91:
        r44 = false;
        goto L92
    L85:
        if (r40 > r41) goto L88;
        if (this.L == false) goto L132;
    L137:
        float r50 = getScale();
        if (this.k1 == null) goto L145;
        if (Math.abs(r50 - this.h2) >= 1.0E-8f) goto L142;
        boolean r51 = true;
    L143:
        if (r51 == true) goto L145;
        this.k1.a(this.h2, r50, OnScaleEventListener.ScaleCause.GESTURE);
        goto L145
    L142:
        r51 = false;
        goto L143
    L172:
        this.h2 = getScale();
        goto L173
    }

    public final void C(boolean r7) {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        if (getHeight() != 0) goto L7;
        return;
    L7:
        if (this.F > 0) goto L9;
        return;
    L9:
        if (this.G <= 0) goto L25;
        PointF r0 = this.D;
        Float r1 = this.C;
        if (r0 == null) goto L18;
        if (r1 == null) goto L18;
        this.x = r1.floatValue();
        if (this.z != null) goto L17;
        this.z = new PointF();
    L17:
        this.z.x = (getWidth() / 2.0f) - (this.x * r0.x);
        this.z.y = (getHeight() / 2.0f) - (this.x * r0.y);
        this.D = null;
        this.C = null;
        r(true);
        E(true);
    L18:
        if (r7 == true) goto L26;
        r(false);
        return;
    L26:
        return;
    }

    public final int D(int r2) {
        return (int) (this.b2 * r2);
    }

    public final void E(boolean r15) {
        if (this.Q != null) goto L5;
        return;
    L5:
        if (this.f == null) goto L87;
        int r0 = Math.min(this.e, h(this.x));
        Iterator r1 = ((LinkedHashMap) this.f).entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L88;
        Iterator r2 = ((List) ((Map.Entry) r1.next()).getValue()).iterator();
    L12:
        if (r2.hasNext() == false) goto L9;
        n r3 = (n) r2.next();
        int r4 = r3.b;
        if (r4 < r0) goto L18;
        if (r4 > r0) goto L17;
    L21:
        int r5 = r3.b;
        if (r5 == r0) goto L23;
        if (r5 != this.e) goto L12;
        r3.e = true;
        goto L12
    L23:
        RectF r6 = getVisibleTileRectOnView();
        float r8 = r6.left;
        PointF r9 = this.z;
        float r10 = Float.NaN;
        if (r9 != null) goto L26;
        float r11 = Float.NaN;
    L27:
        float r12 = r6.right;
        if (r9 != null) goto L30;
        float r13 = Float.NaN;
    L31:
        float r14 = r6.top;
        if (r9 != null) goto L34;
        float r16 = Float.NaN;
    L35:
        float r7 = r6.bottom;
        if (r9 == null) goto L39;
        r10 = (r7 - r9.y) / this.x;
    L39:
        Rect r17 = r3.a;
        if (r11 <= r17.right) goto L42;
    L48:
        boolean r18 = false;
    L49:
        if (r18 == true) goto L50;
        if (r3.b == this.e) goto L12;
        r3.e = false;
        Bitmap r19 = r3.c;
        if (r19 == null) goto L12;
        r19.recycle();
        r3.c = null;
        goto L12
    L50:
        r3.e = true;
        if (r3.d == true) goto L12;
        if (r3.c != null) goto L12;
        if (r15 == false) goto L12;
        new o(this, this.Q, r3).executeOnExecutor(this.p, new Void[0]);
        goto L12
    L42:
        if (r17.left > r13) goto L48;
        if (r16 > r17.bottom) goto L48;
        if (r17.top > r10) goto L48;
        r18 = true;
        goto L49
    L34:
        r16 = (r14 - r9.y) / this.x;
        goto L35
    L30:
        r13 = (r12 - r9.x) / this.x;
        goto L31
    L26:
        r11 = (r8 - r9.x) / this.x;
        goto L27
    L17:
        if (r4 == this.e) goto L21;
    L18:
        r3.e = false;
        Bitmap r20 = r3.c;
        if (r20 == null) goto L21;
        r20.recycle();
        r3.c = null;
        goto L21
    L88:
        return;
    }

    public final void F(boolean r2) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(r2);
        return;
    }

    public final void G(boolean r8) {
        m("reset newImage=" + r8, new Object[0]);
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = Float.valueOf(0.0f);
        this.D = null;
        this.E = null;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = 0;
        this.e = 0;
        this.U = null;
        this.V = 0.0f;
        this.k0 = 0.0f;
        this.p0 = false;
        this.L0 = null;
        this.H0 = null;
        this.P0 = null;
        this.V0 = null;
        this.P1 = null;
        this.Q1 = null;
        this.S1 = null;
        if (r8 == false) goto L27;
        this.d = null;
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try getLock:start");
        boolean r9 = ((ReentrantReadWriteLock) this.R).writeLock().tryLock();
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", getLock: success");
        if (r9 == true) goto L41;
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", getLock: Failed!");
    L14:
        Bitmap r10 = this.a;
        if (r10 == null) goto L20;
        if (this.c == true) goto L20;
        r10.recycle();
    L20:
        if (this.a != null) goto L22;
    L26:
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = null;
        this.J = null;
        this.b1 = false;
        this.g1 = false;
        this.a = null;
        this.b = false;
        this.c = false;
        goto L27
    L22:
        if (this.c == false) goto L26;
        h r11 = this.h1;
        if (r11 == null) goto L26;
        r11.onPreviewReleased();
        goto L26
    L41:
        rlb.d r12 = this.Q;     // Catch: Throwable -> L10
        if (r12 == null) goto L9;
        r12.recycle();     // Catch: Throwable -> L10
        this.Q = null;     // Catch: Throwable -> L10
    L9:
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try freed writeLock:start");
        ((ReentrantReadWriteLock) this.R).writeLock().unlock();
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", freed writeLock success");
    L10:
        th = move-exception;
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", try freed writeLock:start");
        ((ReentrantReadWriteLock) this.R).writeLock().unlock();
        Log.w("SubsamplingScaleImageView", ThreadMethodProxy.currentThread().getName() + ", freed writeLock success");
        throw th;
    L27:
        Map<Integer, List<n>> r13 = this.f;
        if (r13 == null) goto L39;
        Iterator<Map.Entry<Integer, List<n>>> r14 = r13.entrySet().iterator();
    L31:
        if (r14.hasNext() == false) goto L38;
        Iterator<n> r0 = r14.next().getValue().iterator();
    L34:
        if (r0.hasNext() == false) goto L31;
        n r1 = r0.next();
        r1.e = false;
        Bitmap r2 = r1.c;
        if (r2 == null) goto L34;
        r2.recycle();
        r1.c = null;
        goto L34
    L38:
        this.f = null;
    L39:
        setGestureDetector(getContext());
    }

    public final PointF N(PointF r4) {
        float r0 = r4.x;
        float r5 = r4.y;
        PointF r1 = new PointF();
        if (this.z != null) goto L5;
        return null;
    L5:
        r1.set(O(r0), P(r5));
        return r1;
    }

    public final float O(float r3) {
        PointF r0 = this.z;
        if (r0 != null) goto L7;
        return Float.NaN;
    L7:
        return (r3 * this.x) + r0.x;
    }

    public final float P(float r3) {
        if (this.z != null) goto L6;
        return Float.NaN;
    L6:
        Log.i("SubsamplingScaleImageView", "source to view scale y: " + this.x);
        return (r3 * this.x) + this.z.y;
    }

    public final PointF R(PointF r5) {
        float r0 = r5.x;
        float r6 = r5.y;
        PointF r1 = new PointF();
        PointF r2 = this.z;
        if (r2 != null) goto L5;
        return null;
    L5:
        float r3 = r0 - r2.x;
        float r4 = this.x;
        r1.set(r3 / r4, (r6 - r2.y) / r4);
        return r1;
    }

    public final int h(float r4) {
        if (this.k <= 0) goto L5;
        DisplayMetrics r0 = a(getResources());
        r4 = r4 * (this.k / ((r0.xdpi + r0.ydpi) / 2.0f));
    L5:
        int r1 = (int) (I() * r4);
        int r5 = (int) (H() * r4);
        if (r1 == 0) goto L23;
        if (r5 == 0) goto L27;
        int r2 = 1;
        if (H() <= r5) goto L12;
    L15:
        int r6 = Math.round(H() / r5);
        int r3 = Math.round(I() / r1);
        if (r6 < r3) goto L19;
        r6 = r3;
    L19:
        int r7 = r2 * 2;
        if (r7 >= r6) goto L22;
        r2 = r7;
        goto L19
    L22:
        return r2;
    L12:
        if (I() > r1) goto L15;
        r6 = 1;
        goto L19
    L27:
        return 32;
    L23:
        return 32;
    }

    public final void i(PointF r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        RectF r0 = this.p2;
        r0.left = r5.x;
        r0.top = r5.y;
        if (getRequiredRotation() != 90) goto L7;
    L10:
        RectF r1 = this.p2;
        float r2 = r5.x;
        float r3 = this.G;
        float r4 = this.x;
        r1.right = r2 + (r3 * r4);
        r1.bottom = r5.y + (this.F * r4);
        return;
    L7:
        if (getRequiredRotation() == 270) goto L10;
        RectF r6 = this.p2;
        float r7 = r5.x;
        float r8 = this.F;
        float r9 = this.x;
        r6.right = r7 + (r8 * r9);
        r6.bottom = r5.y + (this.G * r9);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        this.z = new PointF(0.0f, 0.0f);
        post(new qlb.b(this));
    }

    @Override // android.view.View
    public final void onDraw(Canvas r34) {
        long r2 = System.currentTimeMillis();
        super.onDraw(r34);
        if (this.G1 != null) goto L6;
        Paint r4 = new Paint();
        this.G1 = r4;
        r4.setAntiAlias(true);
        this.G1.setFilterBitmap(true);
        this.G1.setDither(true);
    L6:
        if (this.H1 == null) goto L10;
        if (this.L1 == null) goto L10;
    L13:
        if (this.F != 0) goto L15;
        return;
    L15:
        if (this.G != 0) goto L17;
        return;
    L17:
        if (getWidth() != 0) goto L19;
        return;
    L19:
        if (getHeight() != 0) goto L22;
        return;
    L22:
        if (this.f != null) goto L27;
        if (this.Q == null) goto L27;
        v(new Point(Math.min(r34.getMaximumBitmapWidth(), this.n), Math.min(r34.getMaximumBitmapHeight(), this.o)));
    L27:
        if (k() == true) goto L29;
        return;
    L29:
        B();
        e r5 = this.V0;
        if (r5 == null) goto L55;
        if (r5.f == null) goto L55;
        Log.i("SubsamplingScaleImageView", "anim and vFocusStart is not null");
        float r6 = this.x;
        if (this.B != null) goto L36;
        this.B = new PointF(0.0f, 0.0f);
    L36:
        this.B.set(this.z);
        long r10 = System.currentTimeMillis();
        e r12 = this.V0;
        long r11 = r10 - r12.l;
        long r13 = r12.h;
        if (r11 <= r13) goto L39;
        boolean r14 = true;
    L40:
        long r15 = Math.min(r11, r13);
        e r16 = this.V0;
        int r17 = r16.j;
        float r18 = r16.a;
        this.x = p(r17, r15, r18, r16.b - r18, r16.h);
        e r7 = this.V0;
        int r19 = r7.j;
        float r8 = r7.f.x;
        float r9 = p(r19, r15, r8, r7.g.x - r8, r7.h);
        e r20 = this.V0;
        int r110 = r20.j;
        float r111 = r20.f.y;
        float r21 = p(r110, r15, r111, r20.g.y - r111, r20.h);
        this.z.x -= O(this.V0.d.x) - r9;
        this.z.y -= P(this.V0.d.y) - r21;
        e r22 = this.V0;
        if (r22.m == true) goto L50;
        if (r14 == false) goto L45;
    L48:
        boolean r23 = true;
    L49:
        r(r23);
        goto L50
    L45:
        if (r22.a == r22.b) goto L48;
        r23 = false;
    L50:
        PointF r24 = this.B;
        int r25 = this.V0.k;
        J(r6, r24);
        E(r14);
        if (r14 == false) goto L53;
        this.V0.getClass();
        this.V0 = null;
    L53:
        invalidate();
        goto L55
    L39:
        r14 = false;
    L55:
        g(r34);
        if (this.f != null) goto L58;
    L161:
        Bitmap r26 = this.a;
        if (r26 != null) goto L164;
    L216:
        f(r34);
        if (this.g == false) goto L233;
        StringBuilder r27 = new StringBuilder("Scale: ");
        Locale r28 = Locale.ENGLISH;
        r27.append(String.format(r28, "%.2f", new Object[]{Float.valueOf(this.x)}));
        r27.append(" (");
        r27.append(String.format(r28, "%.2f", new Object[]{Float.valueOf(x())}));
        r27.append(" - ");
        r27.append(String.format(r28, "%.2f", new Object[]{Float.valueOf(this.i)}));
        r27.append(")");
        r34.drawText(r27.toString(), D(5), D(15), this.H1);
        r34.drawText("Translate: " + String.format(r28, "%.2f", new Object[]{Float.valueOf(this.z.x)}) + ":" + String.format(r28, "%.2f", new Object[]{Float.valueOf(this.z.y)}), D(5), D(30), this.H1);
        PointF r29 = getCenter();
        r34.drawText("Source center: " + String.format(r28, "%.2f", new Object[]{Float.valueOf(r29.x)}) + ":" + String.format(r28, "%.2f", new Object[]{Float.valueOf(r29.y)}), D(5), D(45), this.H1);
        e r30 = this.V0;
        if (r30 == null) goto L222;
        PointF r31 = N(r30.c);
        PointF r32 = N(this.V0.e);
        PointF r112 = N(this.V0.d);
        r34.drawCircle(r31.x, r31.y, D(10), this.L1);
        this.L1.setColor(-65536);
        r34.drawCircle(r32.x, r32.y, D(20), this.L1);
        this.L1.setColor(-16776961);
        r34.drawCircle(r112.x, r112.y, D(25), this.L1);
        this.L1.setColor(-16711681);
        r34.drawCircle(getWidth() / 2, getHeight() / 2, D(30), this.L1);
    L222:
        if (this.U == null) goto L225;
        this.L1.setColor(-65536);
        PointF r33 = this.U;
        r34.drawCircle(r33.x, r33.y, D(20), this.L1);
    L225:
        if (this.L0 == null) goto L228;
        this.L1.setColor(-16776961);
        r34.drawCircle(O(this.L0.x), P(this.L0.y), D(35), this.L1);
    L228:
        if (this.P0 != null) goto L230;
    L232:
        this.L1.setColor(-65281);
        goto L233
    L230:
        if (this.M == false) goto L232;
        this.L1.setColor(-16711681);
        PointF r35 = this.P0;
        r34.drawCircle(r35.x, r35.y, D(30), this.L1);
    L233:
        plb.a r36 = this.g2;
        if (r36 == null) goto L236;
        r36.b(r34);
    L236:
        Log.i("SubsamplingScaleImageView", "onDraw finish, costTime:" + (System.currentTimeMillis() - r2));
        return;
    L164:
        if (r26.isRecycled() == true) goto L216;
        float r37 = this.x;
        if (this.b == false) goto L168;
        r37 = r37 * (this.F / this.a.getWidth());
        float r38 = this.x * (this.G / this.a.getHeight());
    L170:
        if (this.Q1 != null) goto L172;
        this.Q1 = new Matrix();
    L172:
        this.Q1.reset();
        if (this.b == false) goto L175;
    L180:
        this.Q1.postScale(r37, r38);
        if (getRequiredRotation() != 90) goto L183;
    L186:
        this.Q1.postRotate(getRequiredRotation());
    L187:
        Matrix r39 = this.Q1;
        PointF r40 = this.z;
        r39.postTranslate(r40.x, r40.y);
        if (getRequiredRotation() != 180) goto L191;
        Matrix r41 = this.Q1;
        float r42 = this.x;
        r41.postTranslate(this.F * r42, r42 * this.G);
    L197:
        if (this.M1 != null) goto L199;
    L215:
        r34.drawBitmap(this.a, this.Q1, this.G1);
        goto L216
    L199:
        if (this.S1 != null) goto L201;
        this.S1 = new RectF();
    L201:
        RectF r43 = this.S1;
        if (this.b == false) goto L204;
        int r44 = this.a.getWidth();
    L205:
        float r45 = r44;
        if (this.b == false) goto L208;
        int r46 = this.a.getHeight();
    L209:
        r43.set(0.0f, 0.0f, r45, r46);
        this.Q1.mapRect(this.S1);
        r34.drawRect(this.S1, this.M1);
        plb.a r47 = this.g2;
        if (r47 == null) goto L215;
        RectF r48 = this.S1;
        int r49 = plb.a.e;
        Log.i("ILargeImageViewPlusProvider", "updateContentRect, bitmapRectF:" + r48);
        if (r48 == null) goto L214;
        r47.c.set(r48);
    L214:
        Region r50 = r47.d;
        RectF r51 = r47.c;
        r50.set((int) r51.left, (int) r51.top, (int) r51.right, (int) r51.bottom);
        Log.i("ILargeImageViewPlusProvider", "updateContentRect, bitmap result:" + r47.c);
        r47.e();
        goto L215
    L208:
        r46 = this.G;
        goto L209
    L204:
        r44 = this.F;
        goto L205
    L191:
        if (getRequiredRotation() != 90) goto L194;
        this.Q1.postTranslate(this.x * this.G, 0.0f);
        goto L197
    L194:
        if (getRequiredRotation() != 270) goto L197;
        this.Q1.postTranslate(0.0f, this.x * this.F);
        goto L197
    L183:
        if (getRequiredRotation() == 180) goto L186;
        if (getRequiredRotation() != 270) goto L187;
    L175:
        if (getRequiredRotation() != 4) goto L178;
        this.Q1.postScale(1.0f, -1.0f, this.a.getWidth() / 2.0f, this.a.getHeight() / 2.0f);
        goto L180
    L178:
        if (getRequiredRotation() != 2) goto L180;
        this.Q1.postScale(-1.0f, 1.0f, this.a.getWidth() / 2.0f, this.a.getHeight() / 2.0f);
        goto L180
    L168:
        r38 = r37;
        goto L170
    L58:
        if (w() == false) goto L161;
        int r52 = Math.min(this.e, h(this.x));
        Iterator r53 = ((LinkedHashMap) this.f).entrySet().iterator();
        boolean r113 = false;
    L61:
        if (r53.hasNext() == false) goto L74;
        Map.Entry r114 = (Map.Entry) r53.next();
        if (((Integer) r114.getKey()).intValue() != r52) goto L61;
        Iterator r115 = ((List) r114.getValue()).iterator();
    L66:
        if (r115.hasNext() == false) goto L61;
        n r54 = (n) r115.next();
        if (r54.e == false) goto L66;
        if (r54.d == true) goto L73;
        if (r54.c != null) goto L66;
    L73:
        r113 = true;
        goto L66
    L74:
        Iterator r55 = ((LinkedHashMap) this.f).entrySet().iterator();
        int r56 = -1;
    L76:
        if (r55.hasNext() == false) goto L216;
        Map.Entry r57 = (Map.Entry) r55.next();
        if (((Integer) r57.getKey()).intValue() == r52) goto L82;
        if (r113 == true) goto L82;
    L160:
        r52 = r52;
    L82:
        Iterator r58 = ((List) r57.getValue()).iterator();
    L84:
        if (r58.hasNext() == false) goto L160;
        n r116 = (n) r58.next();
        Rect r59 = r116.a;
        r116.f.set((int) O(r59.left), (int) P(r59.top), (int) O(r59.right), (int) P(r59.bottom));
        r56 = r56 + 1;
        plb.a r60 = this.g2;
        if (r60 == null) goto L125;
        if (r56 != 0) goto L89;
        boolean r61 = true;
    L90:
        Rect r117 = t(r116);
        int r118 = plb.a.e;
        Log.i("ILargeImageViewPlusProvider", "updateContentRect, first:" + r61 + ",tileRect:" + r117);
        if (r61 == false) goto L93;
        r60.c.set(r60.b);
    L93:
        if (r117 == null) goto L123;
        RectF r62 = r60.c;
        float r119 = r62.left;
        if (r119 != 2.1474836E9f) goto L97;
        boolean r210 = true;
    L98:
        if (r210 == true) goto L100;
        float r120 = RangesKt.coerceAtMost(r119, r117.left);
    L101:
        r62.left = r120;
        RectF r63 = r60.c;
        float r121 = r63.top;
        if (r121 != 2.1474836E9f) goto L104;
        boolean r122 = true;
    L105:
        if (r122 == true) goto L107;
        float r123 = RangesKt.coerceAtMost(r121, r117.top);
    L108:
        r63.top = r123;
        RectF r64 = r60.c;
        float r124 = r64.right;
        if (r124 != 2.1474836E9f) goto L111;
        boolean r125 = true;
    L112:
        if (r125 == true) goto L114;
        float r126 = RangesKt.coerceAtLeast(r124, r117.right);
    L115:
        r64.right = r126;
        RectF r65 = r60.c;
        float r127 = r65.bottom;
        if (r127 != 2.1474836E9f) goto L118;
        boolean r128 = true;
    L119:
        float r129 = r117.bottom;
        if (r128 == true) goto L122;
        r129 = RangesKt.coerceAtLeast(r127, r129);
    L122:
        r65.bottom = r129;
        goto L123
    L118:
        r128 = false;
        goto L119
    L114:
        r126 = r117.right;
        goto L115
    L111:
        r125 = false;
        goto L112
    L107:
        r123 = r117.top;
        goto L108
    L104:
        r122 = false;
        goto L105
    L100:
        r120 = r117.left;
        goto L101
    L97:
        r210 = false;
    L123:
        Region r66 = r60.d;
        RectF r130 = r60.c;
        r66.set((int) r130.left, (int) r130.top, (int) r130.right, (int) r130.bottom);
        Log.i("ILargeImageViewPlusProvider", "updateContentRect, tile result:" + r60.c);
        r60.e();
        goto L125
    L89:
        r61 = false;
    L125:
        boolean r67 = r116.d;
        if (r67 == false) goto L128;
    L150:
        if (r67 == true) goto L152;
    L155:
        if (r116.e == false) goto L159;
        if (this.g == false) goto L159;
        r34.drawText("ISS " + r116.b + " RECT " + r116.a.top + "," + r116.a.left + "," + r116.a.bottom + "," + r116.a.right, r116.f.left + D(5), r116.f.top + D(15), this.H1);
    L159:
        r52 = r52;
        goto L84
    L152:
        if (this.g == false) goto L155;
        r34.drawText("LOADING", r116.f.left + D(5), r116.f.top + D(35), this.H1);
        goto L155
    L128:
        if (r116.c == null) goto L150;
        Paint r68 = this.M1;
        if (r68 == null) goto L133;
        r34.drawRect(r116.f, r68);
    L133:
        if (this.Q1 != null) goto L135;
        this.Q1 = new Matrix();
    L135:
        this.Q1.reset();
        L(this.T1, 0.0f, 0.0f, r116.c.getWidth(), 0.0f, r116.c.getWidth(), r116.c.getHeight(), 0.0f, r116.c.getHeight());
        if (getRequiredRotation() != 0) goto L139;
        float[] r69 = this.V1;
        Rect r70 = r116.f;
        float r71 = r70.left;
        float r131 = r70.top;
        float r132 = r70.right;
        float r72 = r70.bottom;
        L(r69, r71, r131, r132, r131, r132, r72, r71, r72);
    L147:
        this.Q1.setPolyToPoly(this.T1, 0, this.V1, 0, 4);
        r34.drawBitmap(r116.c, this.Q1, this.G1);
        if (this.g == false) goto L155;
        r34.drawRect(r116.f, this.L1);
        goto L155
    L139:
        if (getRequiredRotation() != 90) goto L142;
        float[] r73 = this.V1;
        Rect r74 = r116.f;
        float r75 = r74.right;
        float r133 = r74.top;
        float r134 = r74.bottom;
        float r76 = r74.left;
        L(r73, r75, r133, r75, r134, r76, r134, r76, r133);
        goto L147
    L142:
        if (getRequiredRotation() != 180) goto L145;
        float[] r77 = this.V1;
        Rect r78 = r116.f;
        float r79 = r78.right;
        float r135 = r78.bottom;
        float r136 = r78.left;
        float r80 = r78.top;
        L(r77, r79, r135, r136, r135, r136, r80, r79, r80);
        goto L147
    L145:
        if (getRequiredRotation() != 270) goto L147;
        float[] r81 = this.V1;
        Rect r82 = r116.f;
        float r83 = r82.left;
        float r137 = r82.bottom;
        float r138 = r82.top;
        float r84 = r82.right;
        L(r81, r83, r137, r83, r138, r84, r138, r84, r137);
    L10:
        if (this.g == false) goto L13;
        Paint r85 = new Paint();
        this.H1 = r85;
        r85.setTextSize(D(12));
        this.H1.setColor(-65281);
        this.H1.setStyle(Paint.Style.FILL);
        Paint r86 = new Paint();
        this.L1 = r86;
        r86.setColor(-65281);
        this.L1.setStyle(Paint.Style.STROKE);
        this.L1.setStrokeWidth(D(1));
        goto L13
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r6) {
        this.v2.onTouchEvent(r6);
        plb.a r0 = this.g2;
        if (r0 == null) goto L49;
        if (r0.c(r6) == false) goto L49;
        return true;
    L49:
        e r2 = this.V0;     // Catch: Exception -> L46
        if (r2 != null) goto L11;
    L14:
        this.V0 = null;     // Catch: Exception -> L46
        if (this.z != null) goto L21;
        GestureDetector r3 = this.P;     // Catch: Exception -> L46
        if (r3 == null) goto L19;
        r3.onTouchEvent(r6);     // Catch: Exception -> L46
    L19:
        return true;
    L21:
        if (this.M == true) goto L29;
        GestureDetector r4 = this.O;     // Catch: Exception -> L46
        if (r4 != null) goto L25;
    L26:
        this.K = false;     // Catch: Exception -> L46
        this.L = false;     // Catch: Exception -> L46
        this.N = 0;     // Catch: Exception -> L46
        return true;
    L25:
        if (r4.onTouchEvent(r6) == true) goto L26;
    L29:
        if (this.A != null) goto L32;
        this.A = new PointF(0.0f, 0.0f);     // Catch: Exception -> L46
    L32:
        if (this.B != null) goto L35;
        this.B = new PointF(0.0f, 0.0f);     // Catch: Exception -> L46
    L35:
        if (this.U != null) goto L37;
        this.U = new PointF(0.0f, 0.0f);     // Catch: Exception -> L46
    L37:
        float r5 = this.x;     // Catch: Exception -> L46
        PointF r7 = this.z;     // Catch: Exception -> L46
        if (r7 == null) goto L50;
        this.B.set(r7);     // Catch: Exception -> L46
        boolean r8 = A(r6);     // Catch: Exception -> L46
        J(r5, this.B);     // Catch: Exception -> L46
        if (r8 == false) goto L42;
        return true;
    L42:
        if (super.onTouchEvent(r6) == true) goto L52;
        return false;
    L52:
        return true;
    L50:
        return true;
    L11:
        if (r2.i == true) goto L14;
        F(true);     // Catch: Exception -> L46
        return true;
    L46:
        e = move-exception;
        Log.e("SubsamplingScaleImageView", "onTouchEvent", e);
        return false;
    }

    public final void q(Point r18) {
        int r2 = 1;
        if (this.e == 1) goto L5;
    L14:
        m("initialiseTileMap maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r18.x), Integer.valueOf(r18.y)});
        this.f = new LinkedHashMap();
        int r1 = this.e;
        int r3 = 1;
        int r4 = 1;
    L15:
        int r5 = I() / r3;
        int r8 = H() / r4;
        int r9 = r5 / r1;
        int r10 = r8 / r1;
    L17:
        if (((r9 + r3) + r2) > r18.x) goto L58;
        if (r9 <= (((double) getWidth()) * 1.25d)) goto L24;
        if (r1 < this.e) goto L58;
    L24:
        if (((r10 + r4) + r2) > r18.y) goto L57;
        if (r10 <= (((double) getHeight()) * 1.25d)) goto L30;
        if (r1 < this.e) goto L57;
    L30:
        ArrayList r11 = new ArrayList(r3 * r4);
        int r12 = 0;
    L31:
        if (r12 >= r3) goto L48;
        int r13 = 0;
    L33:
        if (r13 >= r4) goto L47;
        n r14 = new n();
        r14.b = r1;
        if (r1 != this.e) goto L37;
        boolean r15 = true;
    L38:
        r14.e = r15;
        int r16 = r12 * r5;
        int r17 = r13 * r8;
        if (r12 != (r3 - 1)) goto L41;
        int r6 = I();
    L43:
        if (r13 != (r4 - 1)) goto L45;
        int r7 = H();
    L46:
        r14.a = new Rect(r16, r17, r6, r7);
        r14.f = new Rect(0, 0, 0, 0);
        r14.g = new Rect(r14.a);
        r11.add(r14);
        r13 = r13 + 1;
        goto L33
    L45:
        r7 = (r13 + 1) * r8;
        goto L46
    L41:
        r6 = (r12 + 1) * r5;
        goto L43
    L37:
        r15 = false;
        goto L38
    L47:
        r12 = r12 + 1;
        goto L31
    L48:
        this.f.put(Integer.valueOf(r1), r11);
        r2 = 1;
        if (r1 == 1) goto L50;
        r1 = r1 / 2;
        goto L15
    L50:
        Iterator r0 = ((List) ((LinkedHashMap) this.f).get(Integer.valueOf(this.e))).iterator();
    L52:
        if (r0.hasNext() == false) goto L54;
        new o(this, this.Q, (n) r0.next()).executeOnExecutor(this.p, new Void[0]);
        goto L52
    L54:
        E(true);
        return;
    L57:
        r4 = r4 + 1;
        r8 = H() / r4;
        r10 = r8 / r1;
    L58:
        r3 = r3 + 1;
        r5 = I() / r3;
        r9 = r5 / r1;
        goto L17
    L5:
        if (this.I != null) goto L14;
        if (I() >= r18.x) goto L14;
        if (H() >= r18.y) goto L14;
        rlb.d r19 = this.Q;
        if (r19 == null) goto L13;
        r19.recycle();
    L13:
        this.Q = null;
        new g(this, getContext(), this.S, this.d, false).executeOnExecutor(this.p, new Void[0]);
    }

    public final void r(boolean r5) {
        if (this.z != null) goto L5;
        this.z = new PointF(0.0f, 0.0f);
        boolean r0 = true;
    L7:
        if (this.P1 != null) goto L9;
        this.P1 = new l(0.0f, new PointF(0.0f, 0.0f));
    L9:
        l r1 = this.P1;
        r1.a = this.x;
        r1.b.set(this.z);
        s(r5, this.P1);
        l r6 = this.P1;
        this.x = r6.a;
        this.z.set(r6.b);
        if (r0 == true) goto L12;
        return;
    L12:
        if (this.m == 4) goto L16;
        this.z.set(Q(I() / 2, H() / 2, this.x));
        return;
    L16:
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void setBitmapDecoderClass(Class<? extends rlb.c> r2) {
        if (r2 == null) goto L6;
        this.S = new rlb.a(r2);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(rlb.b<? extends rlb.c> r2) {
        if (r2 == null) goto L6;
        this.S = r2;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean r1) {
        this.g = r1;
    }

    public final void setDoubleTapZoomDpi(int r3) {
        DisplayMetrics r0 = a(getResources());
        setDoubleTapZoomScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setDoubleTapZoomDuration(int r2) {
        this.w = Math.max(0, r2);
    }

    public final void setDoubleTapZoomScale(float r1) {
        this.u = r1;
    }

    public final void setDoubleTapZoomStyle(int r4) {
        if (y2.contains(Integer.valueOf(r4)) == false) goto L7;
        this.v = r4;
        return;
    L7:
        throw new IllegalArgumentException("Invalid zoom style: " + r4);
    }

    public void setEagerLoadingEnabled(boolean r1) {
        this.q = r1;
    }

    public void setExecutor(Executor r2) {
        if (r2 == null) goto L6;
        this.p = r2;
        return;
    L6:
        throw new NullPointerException("Executor must not be null");
    }

    public void setGestureDetector(Context r3) {
        this.O = new GestureDetector(r3, new b(this, r3));
        this.P = new GestureDetector(r3, new c(this));
    }

    public final void setImage(qlb.a r2) {
        K(r2, null);
    }

    public final void setMaxScale(float r1) {
        this.i = r1;
    }

    public void setMaxTileSize(int r1) {
        this.n = r1;
        this.o = r1;
    }

    public final void setMaximumDpi(int r3) {
        DisplayMetrics r0 = a(getResources());
        setMinScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setMinScale(float r1) {
        this.j = r1;
    }

    public final void setMinimumDpi(int r3) {
        DisplayMetrics r0 = a(getResources());
        setMaxScale(((r0.xdpi + r0.ydpi) / 2.0f) / r3);
    }

    public final void setMinimumScaleType(int r4) {
        if (G2.contains(Integer.valueOf(r4)) == false) goto L9;
        this.m = r4;
        if (this.b1 == false) goto L10;
        r(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid scale type: " + r4);
    }

    public void setMinimumTileDpi(int r3) {
        DisplayMetrics r0 = a(getResources());
        this.k = (int) Math.min((r0.xdpi + r0.ydpi) / 2.0f, r3);
        if (this.b1 == false) goto L6;
        G(false);
        invalidate();
        return;
    }

    public void setOnImageEventListener(h r1) {
        this.h1 = r1;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        this.v1 = r1;
    }

    public void setOnMatrixChangeListener(i r1) {
        this.p1 = r1;
    }

    public void setOnMatrixChangedListener(i r1) {
        this.p1 = r1;
    }

    public void setOnScaleEventListener(OnScaleEventListener r1) {
        this.k1 = r1;
    }

    public void setOnSizeChangedStrategy(j r1) {
        this.x1 = r1;
    }

    public final void setOrientation(int r4) {
        if (x2.contains(Integer.valueOf(r4)) == false) goto L7;
        this.h = r4;
        G(false);
        invalidate();
        requestLayout();
        return;
    L7:
        throw new IllegalArgumentException("Invalid orientation: " + r4);
    }

    public final void setPanEnabled(boolean r4) {
        this.r = r4;
        if (r4 == true) goto L10;
        PointF r5 = this.z;
        if (r5 == null) goto L11;
        r5.x = (getWidth() / 2) - (this.x * (I() / 2));
        this.z.y = (getHeight() / 2) - (this.x * (H() / 2));
        if (this.b1 == false) goto L12;
        E(true);
        invalidate();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void setPanLimit(int r4) {
        if (F2.contains(Integer.valueOf(r4)) == false) goto L9;
        this.l = r4;
        if (this.b1 == false) goto L10;
        r(true);
        invalidate();
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("Invalid pan limit: " + r4);
    }

    public final void setPhotoViewDoubleTapZoomScale(float r2) {
        this.u = r2 / getScaleFactor();
    }

    public void setPlusProvider(plb.a r1) {
        this.g2 = r1;
    }

    public final void setQuickScaleEnabled(boolean r1) {
        this.t = r1;
    }

    public final void setRegionDecoderClass(Class<? extends rlb.d> r2) {
        if (r2 == null) goto L6;
        this.T = new rlb.a(r2);
        return;
    L6:
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(rlb.b<? extends rlb.d> r2) {
        if (r2 == null) goto L6;
        this.T = r2;
        return;
    L6:
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public void setScale(float r1) {
        this.x = r1;
    }

    public final void setTileBackgroundColor(int r3) {
        if (Color.alpha(r3) != 0) goto L5;
        this.M1 = null;
    L6:
        invalidate();
        return;
    L5:
        Paint r0 = new Paint();
        this.M1 = r0;
        r0.setStyle(Paint.Style.FILL);
        this.M1.setColor(r3);
        goto L6
    }

    public final void setZoomEnabled(boolean r1) {
        this.s = r1;
    }

    public Rect t(n r1) {
        return r1.f;
    }

    public final synchronized void v(Point r6) {
        monitor-enter(this);
        m("initialiseBaseLayer maxTileDimensions=%dx%d", new Object[]{Integer.valueOf(r6.x), Integer.valueOf(r6.y)});     // Catch: Throwable -> L9
        l r0 = new l(0.0f, new PointF(0.0f, 0.0f));     // Catch: Throwable -> L9
        this.P1 = r0;     // Catch: Throwable -> L9
        s(true, r0);     // Catch: Throwable -> L9
        int r1 = h(this.P1.a);     // Catch: Throwable -> L9
        this.e = r1;     // Catch: Throwable -> L9
        if (r1 <= 1) goto L6;
        this.e = r1 / 2;     // Catch: Throwable -> L9
    L6:
        q(r6);     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void z(Bitmap r5) {
        monitor-enter(this);
        m("onPreviewLoaded", new Object[0]);     // Catch: Throwable -> L20
        if (this.a == null) goto L6;
    L17:
        r5.recycle();     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L6:
        if (this.g1 == true) goto L17;
        Rect r0 = this.J;     // Catch: Throwable -> L20
        if (r0 == null) goto L11;
        this.a = Bitmap.createBitmap(r5, r0.left, r0.top, r0.width(), this.J.height());     // Catch: Throwable -> L20
    L12:
        this.b = true;     // Catch: Throwable -> L20
        if (k() == false) goto L15;
        invalidate();     // Catch: Throwable -> L20
        requestLayout();     // Catch: Throwable -> L20
    L15:
        monitor-exit(this);
        return;
    L11:
        this.a = r5;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public SubsamplingScaleImageView(Context r6, AttributeSet r7) {
        super(r6, r7);
        this.h = 0;
        this.i = 2.0f;
        this.j = x();
        this.k = -1;
        this.l = 1;
        this.m = 1;
        this.n = Integer.MAX_VALUE;
        this.o = Integer.MAX_VALUE;
        this.p = AsyncTask.THREAD_POOL_EXECUTOR;
        this.q = true;
        this.r = true;
        this.s = true;
        this.t = true;
        this.u = 1.0f;
        this.v = 1;
        this.w = 500;
        this.R = new ReentrantReadWriteLock(true);
        this.S = new rlb.a(SkiaImageDecoder.class);
        this.T = new rlb.a(SkiaImageRegionDecoder.class);
        this.T1 = new float[8];
        this.V1 = new float[8];
        this.p2 = new RectF();
        this.v2 = new ScaleGestureDetector(getContext(), new d(this));
        this.b2 = a(getResources()).density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(r6);
        this.y1 = new Handler(new a(this));
        if (r7 == null) goto L39;
        TypedArray r8 = getContext().obtainStyledAttributes(r7, new int[]{2130968854, 2130973433, 2130973708, 2130974137, 2130974566, 2130975242});
        if (r8.hasValue(0) == false) goto L22;
        String r2 = r8.getString(0);
        if (r2 == null) goto L22;
        if (r2.length() <= 0) goto L22;
        String r3 = "file:///android_asset/".concat(r2);
        if (r3 == null) goto L20;
        if (r3.contains("://") == false) goto L15;
    L18:
        qlb.a r4 = new qlb.a(UriProtector.parse(r3));
        r4.d = true;
        setImage(r4);
        goto L22
    L15:
        if (r3.startsWith("/") == false) goto L17;
        r3 = r3.substring(1);
    L17:
        r3 = "file:///" + r3;
        goto L18
    L20:
        throw new NullPointerException("Uri must not be null");
    L22:
        if (r8.hasValue(3) == false) goto L27;
        int r5 = r8.getResourceId(3, 0);
        if (r5 <= 0) goto L27;
        qlb.a r9 = new qlb.a(r5);
        r9.d = true;
        setImage(r9);
    L27:
        if (r8.hasValue(1) == false) goto L30;
        setPanEnabled(r8.getBoolean(1, true));
    L30:
        if (r8.hasValue(5) == false) goto L33;
        setZoomEnabled(r8.getBoolean(5, true));
    L33:
        if (r8.hasValue(2) == false) goto L36;
        setQuickScaleEnabled(r8.getBoolean(2, true));
    L36:
        if (r8.hasValue(4) == false) goto L38;
        setTileBackgroundColor(r8.getColor(4, Color.argb(0, 0, 0, 0)));
    L38:
        r8.recycle();
    L39:
        this.W = TypedValue.applyDimension(1, 20.0f, a(r6.getResources()));
    }

    public static /* synthetic */ void b(SubsamplingScaleImageView r0, View.OnLongClickListener r1) {
        super.setOnLongClickListener(r1);
    }

    public final void J(float r2, PointF r3) {
        if (this.p1 != null) goto L5;
        return;
    L5:
        if (this.x == r2) goto L7;
    L8:
        i(this.z);
        this.p1.a(this.p2);
        return;
    L7:
        if (this.z.equals(r3) == false) goto L8;
    }

    public final void K(qlb.a r11, qlb.a r12) {
        if (r11 == null) goto L45;
        G(true);
        if (r12 != null) goto L6;
    L24:
        Bitmap r13 = r11.b;
        if (r13 == null) goto L29;
        Rect r3 = r11.g;
        if (r3 == null) goto L29;
        y(Bitmap.createBitmap(r13, r3.left, r3.top, r3.width(), r11.g.height()), 0, false);
        return;
    L29:
        if (r13 == null) goto L31;
        y(r13, 0, r11.h);
        return;
    L31:
        this.I = r11.g;
        Uri r14 = r11.a;
        this.d = r14;
        if (r14 != null) goto L37;
        if (r11.c == null) goto L37;
        this.d = UriProtector.parse("android.resource://" + getContext().getPackageName() + "/" + r11.c);
    L37:
        if (r11.d == false) goto L39;
    L42:
        new p(this, getContext(), this.T, this.d).executeOnExecutor(this.p, new Void[0]);
        return;
    L39:
        if (this.I != null) goto L42;
        new g(this, getContext(), this.S, this.d, false).executeOnExecutor(this.p, new Void[0]);
        return;
    L6:
        if (r11.b != null) goto L23;
        int r4 = r11.e;
        if (r4 <= 0) goto L21;
        int r5 = r11.f;
        if (r5 <= 0) goto L21;
        this.F = r4;
        this.G = r5;
        this.J = r12.g;
        Bitmap r6 = r12.b;
        if (r6 == null) goto L14;
        this.c = r12.h;
        z(r6);
        goto L24
    L14:
        Uri r7 = r12.a;
        if (r7 == null) goto L17;
    L19:
        new g(this, getContext(), this.S, r7, true).executeOnExecutor(this.p, new Void[0]);
        goto L24
    L17:
        if (r12.c == null) goto L19;
        r7 = UriProtector.parse("android.resource://" + getContext().getPackageName() + "/" + r12.c);
    L21:
        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
    L23:
        throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
    L45:
        throw new NullPointerException("imageSource must not be null");
    }

    public final void M(float r2, PointF r3) {
        this.V0 = null;
        this.C = Float.valueOf(r2);
        this.D = r3;
        this.E = r3;
        invalidate();
    }

    public final void m(String r2, Object... r3) {
        if (this.g == false) goto L6;
        Log.d("SubsamplingScaleImageView", String.format(r2, r3));
        return;
    }

    public void o(PointF r11, PointF r12) {
        if (this.r == true) goto L8;
        PointF r0 = this.E;
        if (r0 == null) goto L7;
        r11.x = r0.x;
        r11.y = r0.y;
        goto L8
    L7:
        r11.x = I() / 2;
        r11.y = H() / 2;
    L8:
        float r1 = Math.min(this.i, this.u);
        float r2 = this.x;
        if (r2 > (((double) r1) * 0.9d)) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == true) goto L18;
        r1 = x();
    L18:
        int r4 = this.v;
        if (r4 != 3) goto L22;
        M(r1, r11);
    L30:
        invalidate();
        OnScaleEventListener r13 = this.k1;
        if (r13 == null) goto L34;
        r13.a(getScale(), r1, OnScaleEventListener.ScaleCause.DOUBLE_TAP);
        return;
    L34:
        return;
    L22:
        if (r4 == 2) goto L29;
        if (r3 == false) goto L29;
        if (this.r == false) goto L29;
        if (r4 != 1) goto L30;
        f r5 = new f(this, r1, r11, r12);
        r5.g = false;
        r5.d = this.w;
        r5.f = 4;
        r5.a();
    L29:
        f r14 = new f(this, r1, r11);
        r14.g = false;
        r14.d = this.w;
        r14.f = 4;
        r14.a();
        goto L30
    L11:
        if (r2 == this.j) goto L14;
        r3 = false;
        goto L15
    }

    @Override // android.view.View
    public final void onMeasure(int r6, int r7) {
        int r0 = View.MeasureSpec.getMode(r6);
        int r1 = View.MeasureSpec.getMode(r7);
        int r8 = View.MeasureSpec.getSize(r6);
        int r9 = View.MeasureSpec.getSize(r7);
        boolean r2 = true;
        if (r0 == 1073741824) goto L5;
        boolean r3 = true;
    L6:
        if (r1 != 1073741824) goto L10;
        r2 = false;
    L10:
        if (this.F > 0) goto L12;
    L20:
        setMeasuredDimension(Math.max(r8, getSuggestedMinimumWidth()), Math.max(r9, getSuggestedMinimumHeight()));
        return;
    L12:
        if (this.G <= 0) goto L20;
        if (r3 == false) goto L16;
        if (r2 == false) goto L16;
        r8 = I();
        r9 = H();
    L16:
        if (r2 == false) goto L18;
        r9 = (int) ((((double) H()) / ((double) I())) * ((double) r8));
        goto L20
    L18:
        if (r3 == false) goto L20;
        r8 = (int) ((((double) I()) / ((double) H())) * ((double) r9));
        goto L20
    L5:
        r3 = false;
        goto L6
    }

    public final void s(boolean r12, l r13) {
        if (this.l == 2) goto L5;
    L7:
        PointF r0 = r13.b;
        float r3 = Math.min(this.i, Math.max(x(), r13.a));
        float r4 = I() * r3;
        float r5 = H() * r3;
        if (this.l == 3) goto L10;
    L12:
        if (r12 == false) goto L14;
        r0.x = Math.max(r0.x, getWidth() - r4);
        r0.y = Math.max(r0.y, getHeight() - r5);
    L15:
        float r8 = 0.5f;
        if (getPaddingLeft() <= 0) goto L18;
    L21:
        float r6 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
    L23:
        if (getPaddingTop() <= 0) goto L25;
    L26:
        r8 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
    L28:
        if (this.l == 3) goto L30;
    L32:
        if (r12 == false) goto L34;
        float r14 = Math.max(0.0f, (getWidth() - r4) * r6);
        float r1 = Math.max(0.0f, (getHeight() - r5) * r8);
    L36:
        r0.x = Math.min(r0.x, r14);
        r0.y = Math.min(r0.y, r1);
        r13.a = r3;
        return;
    L34:
        r14 = Math.max(0, getWidth());
        int r2 = Math.max(0, getHeight());
    L35:
        r1 = r2;
        goto L36
    L30:
        if (this.b1 == false) goto L32;
        r14 = Math.max(0, getWidth() / 2);
        r2 = Math.max(0, getHeight() / 2);
        goto L35
    L25:
        if (getPaddingBottom() <= 0) goto L28;
    L18:
        if (getPaddingRight() > 0) goto L21;
        r6 = 0.5f;
        goto L23
    L14:
        r0.x = Math.max(r0.x, -r4);
        r0.y = Math.max(r0.y, -r5);
        goto L15
    L10:
        if (this.b1 == false) goto L12;
        r0.x = Math.max(r0.x, (getWidth() / 2) - r4);
        r0.y = Math.max(r0.y, (getHeight() / 2) - r5);
        goto L15
    L5:
        if (this.b1 == false) goto L7;
        r12 = false;
        goto L7
    }

    public static int d(SubsamplingScaleImageView r4, Context r5, String r6) {
        int r3 = 0;
        if (r6.startsWith("content") == false) goto L26;
        Cursor r7 = null;
        r7 = l(r5.getContentResolver(), Uri.parse(r6), new String[]{"orientation"});     // Catch: Throwable -> L17 Exception -> L19
        if (r7 != null) goto L8;
    L15:
        if (r7 == null) goto L56;
    L21:
        r7.close();
        return r3;
    L56:
        return r3;
    L8:
        if (r7.moveToFirst() == false) goto L15;
        int r8 = r7.getInt(0);     // Catch: Throwable -> L17 Exception -> L19
        if (x2.contains(Integer.valueOf(r8)) == true) goto L12;
    L14:
        Log.w("SubsamplingScaleImageView", "Unsupported orientation: " + r8);     // Catch: Throwable -> L17 Exception -> L19
    L12:
        if (r8 == (-1)) goto L14;
        r3 = r8;
    L17:
        th = move-exception;
        if (r7 == null) goto L24;
        r7.close();
    L24:
        throw th;
    L19:
        Log.w("SubsamplingScaleImageView", "Could not get orientation of image from media store");     // Catch: Throwable -> L17
        if (r7 != null) goto L21;
        return 0;
    L26:
        if (r6.startsWith("file:///") == true) goto L28;
        return 0;
    L28:
        if (r6.startsWith("file:///android_asset/") == true) goto L60;
        int r9 = new ExifInterface(r6.substring(7)).getAttributeInt("Orientation", 1);     // Catch: Exception -> L50
        if (r9 == 1) goto L61;
        if (r9 != 0) goto L34;
        return 0;
    L34:
        if (r9 != 6) goto L37;
        return 90;
    L37:
        if (r9 != 3) goto L40;
        return 180;
    L40:
        if (r9 != 8) goto L43;
        return 270;
    L43:
        if (r9 != 2) goto L46;
        return 2;
    L46:
        if (r9 == 4) goto L67;
        Log.w("SubsamplingScaleImageView", "Unsupported EXIF orientation: " + r9);     // Catch: Exception -> L50
        return 0;
    L67:
        return 4;
    L61:
        return 0;
    L50:
        Log.w("SubsamplingScaleImageView", "Could not get EXIF orientation of image");
        return 0;
    L60:
        return 0;
    }

    public static void e(SubsamplingScaleImageView r4, Rect r5, Rect r6) {
        if (r4.getRequiredRotation() != 0) goto L6;
        r6.set(r5);
        return;
    L6:
        if (r4.getRequiredRotation() != 90) goto L9;
        int r0 = r5.top;
        int r7 = r4.G;
        r6.set(r0, r7 - r5.right, r5.bottom, r7 - r5.left);
        return;
    L9:
        if (r4.getRequiredRotation() != 180) goto L11;
        int r1 = r4.F;
        int r2 = r1 - r5.right;
        int r8 = r4.G;
        r6.set(r2, r8 - r5.bottom, r1 - r5.left, r8 - r5.top);
        return;
    L11:
        int r9 = r4.F;
        r6.set(r9 - r5.bottom, r5.left, r9 - r5.top, r5.right);
    }

    public static Cursor l(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public final PointF Q(float r6, float r7, float r8) {
        int r0 = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int r1 = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.P1 != null) goto L5;
        this.P1 = new l(0.0f, new PointF(0.0f, 0.0f));
    L5:
        l r2 = this.P1;
        r2.a = r8;
        r2.b.set(r0 - (r6 * r8), r1 - (r7 * r8));
        s(true, this.P1);
        return this.P1.b;
    }

    public final synchronized void y(Bitmap r4, int r5, boolean r6) {
        monitor-enter(this);
        m("onImageLoaded", new Object[0]);     // Catch: Throwable -> L30
        int r0 = this.F;     // Catch: Throwable -> L30
        if (r0 > 0) goto L6;
    L12:
        Bitmap r1 = this.a;     // Catch: Throwable -> L30
        if (r1 == null) goto L18;
        if (this.c == true) goto L18;
        r1.recycle();     // Catch: Throwable -> L30
    L18:
        if (this.a != null) goto L20;
    L24:
        this.b = false;     // Catch: Throwable -> L30
        this.c = r6;     // Catch: Throwable -> L30
        this.a = r4;     // Catch: Throwable -> L30
        this.F = r4.getWidth();     // Catch: Throwable -> L30
        this.G = r4.getHeight();     // Catch: Throwable -> L30
        this.H = r5;     // Catch: Throwable -> L30
        boolean r7 = k();     // Catch: Throwable -> L30
        boolean r8 = j();     // Catch: Throwable -> L30
        if (r7 == true) goto L27;
        if (r8 == true) goto L27;
    L28:
        monitor-exit(this);
        return;
    L27:
        invalidate();     // Catch: Throwable -> L30
        requestLayout();     // Catch: Throwable -> L30
        goto L28
    L20:
        if (this.c == false) goto L24;
        h r2 = this.h1;     // Catch: Throwable -> L30
        if (r2 == null) goto L24;
        r2.onPreviewReleased();     // Catch: Throwable -> L30
        goto L24
    L6:
        if (this.G <= 0) goto L12;
        if (r0 == r4.getWidth()) goto L10;
    L11:
        G(false);     // Catch: Throwable -> L30
        goto L12
    L10:
        if (this.G == r4.getHeight()) goto L12;
    L30:
        th = move-exception;
        throw th;
    }

    public static float n(float r0, float r1, float r2, float r3) {
        float r4 = r0 - r1;
        float r5 = r2 - r3;
        return (float) Math.sqrt((r4 * r4) + (r5 * r5));
    }

    @Override // android.view.View
    public final void onSizeChanged(int r4, int r5, int r6, int r7) {
        Log.i("SubsamplingScaleImageView", "onSizeChanged from:" + r6 + "*" + r7 + ", to:" + r4 + "*" + r5);
        PointF r8 = getCenter();
        if (this.b1 == false) goto L11;
        if (r8 == null) goto L11;
        this.V0 = null;
        j r0 = this.x1;
        if (r0 == null) goto L8;
        this.C = Float.valueOf(r0.b(r4, r5, this.F, this.G));
        this.D = this.x1.a(r8);
    L9:
        Log.i("SubsamplingScaleImageView", "onSizeChanged refresh, pendingScale=" + this.C + ",sPendingCenter=" + this.D);
        goto L11
    L8:
        this.C = Float.valueOf(this.x);
        this.D = r8;
    L11:
        if (this.p1 == null) goto L14;
        r(true);
        i(this.z);
        this.p1.a(this.p2);
        return;
    }

    public static float p(int r2, long r3, float r5, float r6, long r7) {
        if (r2 != 1) goto L5;
        float r4 = r3 / r7;
        return (((-r6) * r4) * (r4 - 2.0f)) + r5;
    L5:
        if (r2 != 2) goto L13;
        float r8 = r3 / (r7 / 2.0f);
        if (r8 >= 1.0f) goto L9;
        float r9 = (r6 / 2.0f) * r8;
    L11:
        return (r9 * r8) + r5;
    L9:
        float r10 = r8 - 1.0f;
        r9 = (-r6) / 2.0f;
        r8 = (r10 * (r10 - 2.0f)) - 1.0f;
        goto L11
    L13:
        throw new IllegalStateException("Unexpected easing type: " + r2);
    }

    public static void L(float[] r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        r1[0] = r2;
        r1[1] = r3;
        r1[2] = r4;
        r1[3] = r5;
        r1[4] = r6;
        r1[5] = r7;
        r1[6] = r8;
        r1[7] = r9;
    }
}
