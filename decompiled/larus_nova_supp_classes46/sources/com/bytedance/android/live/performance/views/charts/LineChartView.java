package com.bytedance.android.live.performance.views.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import xr0.c;
import xr0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class LineChartView extends SurfaceView implements SurfaceHolder.Callback {
    public static final /* synthetic */ int K = 0;
    public SurfaceHolder A;
    public a B;
    public int C;
    public boolean D;
    public boolean E;
    public boolean F;
    public int G;
    public Button H;
    public Button I;
    public wr0.a J;
    public Paint a;
    public Paint b;
    public Paint c;
    public Paint d;
    public Paint e;
    public Path f;
    public Path g;
    public int h;
    public int i;
    public final List<Data> j;
    public final List<b> k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public double q;
    public double r;
    public double s;
    public int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public boolean z;

    public static class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = null;
        public final double a;
        public final Date b;

        public class a implements Parcelable.Creator<Data> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Data createFromParcel(Parcel r2) {
                return new Data(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final Data[] newArray(int r1) {
                return new Data[r1];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public Data(Parcel r3) {
            this.a = r3.readDouble();
            this.b = (Date) r3.readSerializable();
        }

        public Data(double r1, Date r3) {
            this.a = r1;
            this.b = r3;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r3, int r4) {
            r3.writeDouble(this.a);
            r3.writeSerializable(this.b);
        }
    }

    public class a extends PthreadThreadV2 {
        public final /* synthetic */ LineChartView v;

        public final void l() {
        L17:
            LineChartView r0 = this.v;     // Catch: Exception -> L14
            if (r0.z == false) goto L22;
            int r1 = Build.VERSION.SDK_INT;     // Catch: Exception -> L14
            if (r1 < 23) goto L7;
            Canvas r2 = r0.A.getSurface().lockHardwareCanvas();     // Catch: Exception -> L14
        L8:
            LineChartView.a(this.v, r2);     // Catch: Exception -> L14
            if (r1 < 23) goto L11;
            this.v.A.getSurface().unlockCanvasAndPost(r2);     // Catch: Exception -> L14
        L12:
            Thread.sleep(16);     // Catch: Exception -> L14
            goto L17
        L11:
            this.v.A.unlockCanvasAndPost(r2);     // Catch: Exception -> L14
            goto L12
        L7:
            r2 = r0.A.lockCanvas();     // Catch: Exception -> L14
            goto L8
        L22:
            return;
        L14:
            e = move-exception;
            e.printStackTrace();
        }

        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LineChartView r1) {
            this.v = r1;
            super("LineChartView$1");
        }
    }

    public class b {
        public final double a;
        public final Date b;
        public final Point c;

        public b(double r1, Date r3, Point r4) {
            this.a = r1;
            this.b = r3;
            this.c = r4;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
    }

    private int getTableEnd() {
        int r0 = this.l;
        int r1 = this.m;
        if (((ArrayList) this.k).isEmpty() == false) goto L5;
        int r2 = 0;
    L7:
        return (r0 + (r1 * r2)) + this.p;
    L5:
        r2 = ((ArrayList) this.k).size() - 1;
        goto L7
    }

    private int getTableStart() {
        return this.l + this.p;
    }

    public final void f() {
        Path r0 = this.f;
        if (r0 == null) goto L5;
        r0.reset();
    L5:
        Path r1 = this.g;
        if (r1 == null) goto L8;
        r1.reset();
    L8:
        this.m = (int) s1.e(30.0f);
        this.p = (int) s1.e(15.0f);
        this.t = (int) s1.e(8.0f);
        int r2 = this.p;
        this.l = r2 * 2;
        this.o = r2;
        this.n = r2;
    }

    public int getDataCount() {
        List<Data> r0 = this.j;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return ((ArrayList) r0).size();
    }

    public final void i() {
        if (((ArrayList) this.j).isEmpty() == true) goto L5;
        double r3 = ((Data) Collections.max(this.j, new xr0.b(this))).a;
    L6:
        this.q = g(r3);
        if (((ArrayList) this.j).isEmpty() == true) goto L9;
        double r4 = ((Data) Collections.min(this.j, new c(this))).a;
    L10:
        double r5 = g(r4);
        this.r = r5;
        double r6 = this.q;
        double r7 = (r6 - r5) / 2.0d;
        this.s = r7;
        if (r7 != 0.0d) goto L13;
        r7 = r6 * 2.0d;
    L13:
        this.s = r7;
        this.s = g(r7);
        if (wr0.c.a() == false) goto L16;
        f();
        requestLayout();
        postInvalidate();
        return;
    L16:
        post(new d(this));
        return;
    L9:
        r4 = 0.0d;
        goto L10
    L5:
        r3 = 0.0d;
        goto L6
    }

    private float getViewDrawHeight() {
        return getMeasuredHeight() * 0.618f;
    }

    public final void h() {
        SurfaceHolder r0 = getHolder();
        this.A = r0;
        r0.setFormat(-2);
        this.A.addCallback(this);
        setZOrderOnTop(true);
        Paint r1 = new Paint();
        this.a = r1;
        r1.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setColor(this.u);
        this.a.setStrokeWidth(s1.e(1.0f));
        Paint r2 = new Paint();
        this.b = r2;
        r2.setAntiAlias(true);
        this.b.setStyle(Paint.Style.FILL);
        this.b.setColor(this.v);
        this.b.setStrokeWidth(s1.e(4.0f));
        Paint r3 = new Paint();
        this.c = r3;
        r3.setAntiAlias(true);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setColor(this.w);
        this.c.setStrokeWidth(s1.e(0.25f));
        Paint r4 = new Paint();
        this.d = r4;
        r4.setAntiAlias(true);
        this.d.setStyle(Paint.Style.FILL);
        this.d.setTextAlign(Paint.Align.CENTER);
        this.d.setColor(this.x);
        this.d.setTextSize(s1.I(5.0f));
        Paint r5 = new Paint();
        this.e = r5;
        r5.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setColor(this.y);
        this.e.setTextSize(s1.I(5.0f));
        this.f = new Path();
        this.g = new Path();
        f();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
    }

    public LineChartView(Context r2) {
        this(r2, null);
    }

    public static double g(double r4) {
        double r0 = Math.pow(10.0d, 2);
        return Math.ceil(r4 * r0) / r0;
    }

    public final boolean b(boolean r5) {
        if (((ArrayList) this.j).isEmpty() == true) goto L27;
        wr0.a r0 = this.J;
        if (r0 == null) goto L30;
        boolean r2 = this.D;
        if (r2 == false) goto L13;
        if (this.E == false) goto L13;
        return false;
    L13:
        if (r5 == false) goto L20;
        if (r0.d <= 0) goto L25;
        if (r2 == true) goto L26;
        return true;
    L26:
        return false;
    L25:
        return false;
    L20:
        if (r0.c < ((ArrayList) this.j).size()) goto L22;
        return false;
    L22:
        if (this.E == true) goto L29;
        return true;
    L29:
        return false;
    L30:
        return false;
    L27:
        return false;
    }

    public final int d(double r7) {
        double r8 = (Math.abs(g(r7) - this.r) * 100.0d) / (Math.abs(this.q - this.r) * 100.0d);
        return (int) (((((double) getViewDrawHeight()) * r8) + ((double) this.o)) + 0.5d);
    }

    public final void e(boolean r4) {
        wr0.a r0 = this.J;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = this.D;
        if (r1 == false) goto L11;
        if (this.E == false) goto L11;
        return;
    L11:
        if (r4 == false) goto L19;
        if (r0.b <= 0) goto L17;
        if (r1 == true) goto L30;
        r0.d--;
        r0.c--;
    L24:
        this.J.a = true;
        i();
        return;
    L30:
        return;
    L17:
        return;
    L19:
        if (r0.c >= ((ArrayList) this.j).size()) goto L27;
        if (this.E == true) goto L27;
        wr0.a r5 = this.J;
        r5.d++;
        r5.c++;
    L27:
        if (this.E == false) goto L31;
        this.J.a = false;
        return;
    }

    public void setBackwardButton(Button r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.H = r1;
    }

    public void setCurrentDataShowRange(wr0.a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.J = r2;
        r2.a = false;
        r2.b = 0;
        r2.c = Integer.MAX_VALUE;
        r2.d = -1;
    }

    public void setData(List<Double> r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        ((ArrayList) this.j).clear();
        Iterator<Double> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        Double r0 = r7.next();
        List<Data> r1 = this.j;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new Data(r0.doubleValue(), new Date()));
        goto L6
    L8:
        i();
    }

    public void setForwardButton(Button r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.I = r1;
    }

    public void setWidth(int r1) {
        if (r1 > 0) goto L4;
        return;
    L4:
        this.h = r1;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.android.live.performance.views.charts.LineChartView$a, java.lang.Thread] */
    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r1) {
        this.z = true;
        ?? r2 = new a(this);
        this.B = r2;
        ThreadMethodProxy.start(r2);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r1) {
        this.z = false;
        a r2 = this.B;
        if (r2 == null) goto L6;
        r2.interrupt();
        return;
    }

    public LineChartView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public static void a(final LineChartView r17, Canvas r18) {
        if (r18 != null) goto L6;
        r17.getClass();
        return;
    L6:
        if (r17.f != null) goto L8;
    L13:
        r17.h();
    L14:
        r17.f.reset();
        r17.g.reset();
        r18.drawColor(0, PorterDuff.Mode.CLEAR);
        r18.translate(0.0f, (((r17.i + r17.getViewDrawHeight()) + r17.n) + r17.o) / 2.0f);
        if (r17.J == null) goto L105;
        ((ArrayList) r17.k).clear();
        r17.D = false;
        r17.E = false;
        if (((ArrayList) r17.j).isEmpty() == false) goto L22;
        wr0.a r0 = r17.J;
        if (r0 == null) goto L105;
        r0.a = false;
        r0.b = 0;
        r0.c = Integer.MAX_VALUE;
        r0.d = -1;
        goto L105
    L22:
        r17.G = r17.getTableStart();
        int r1 = ((ArrayList) r17.j).size();
        wr0.a r8 = r17.J;
        boolean r9 = r8.a;
        if (r9 == false) goto L25;
        int r10 = r8.d;
    L26:
        int r11 = Math.max(0, r10);
        if (r9 == false) goto L29;
        int r12 = Math.min(r17.J.c, r1);
    L30:
        r17.F = false;
        int r13 = r11;
    L31:
        if (r13 >= r12) goto L101;
        Data r14 = (Data) ListProtector.get(r17.j, r13);
        if (r14 == null) goto L97;
        int r15 = Math.max(r11, r17.J.b);
        if (r9 == true) goto L39;
        if (r13 < r15) goto L97;
    L39:
        int r16 = r17.G;
        if (r9 == false) goto L42;
        r15 = r11;
    L42:
        Point r19 = new Point(r16 + ((r13 - r15) * r17.m), -r17.d(r14.a));
    L44:
        if (r19.x > 0) goto L46;
    L48:
        boolean r4 = false;
    L49:
        if (r4 == true) goto L66;
        if (((ArrayList) r17.k).isEmpty() == true) goto L66;
        if (((ArrayList) r17.k).isEmpty() == true) goto L62;
        ListProtector.remove(r17.k, 0);
        Iterator r5 = ((ArrayList) r17.k).iterator();
    L57:
        if (r5.hasNext() == false) goto L62;
        Point r6 = ((b) r5.next()).c;
        if (r6 == null) goto L57;
        r6.x -= r17.m;
    L62:
        r19.x -= r17.m;
        wr0.a r7 = r17.J;
        if (r7 == null) goto L44;
        r7.b++;
    L66:
        if (r19.x > 0) goto L68;
    L70:
        boolean r20 = false;
    L71:
        if (r20 == true) goto L73;
        boolean r21 = false;
    L98:
        if (r21 == false) goto L105;
        r13 = r13 + 1;
        goto L31
    L73:
        if (r13 != 0) goto L76;
        r17.D = true;
    L79:
        if (r17.F == true) goto L86;
        r17.f.moveTo(r19.x, r19.y);
        r17.F = true;
        if (r9 == false) goto L83;
        r17.C = r13;
    L96:
        ((ArrayList) r17.k).add(new b(r14.a, r14.b, r19));
        goto L97
    L83:
        wr0.a r22 = r17.J;
        if (r22 == null) goto L96;
        r22.b = r13;
        r22.d = r13;
        goto L96
    L86:
        r17.f.lineTo(r19.x, r19.y);
        if (r9 == true) goto L89;
        wr0.a r23 = r17.J;
        if (r23 == null) goto L96;
        r23.c = r13;
        goto L96
    L89:
        if (r17.E == false) goto L96;
        wr0.a r24 = r17.J;
        if (r24 == null) goto L96;
        r24.a = false;
        r24.b = r17.C;
        r17.C = 0;
        goto L96
    L76:
        if (r13 != (r1 - 1)) goto L79;
        r17.E = true;
        goto L79
    L68:
        if ((r17.getMeasuredWidth() - r17.p) <= r19.x) goto L70;
        r20 = true;
        goto L71
    L46:
        if ((r17.getMeasuredWidth() - r17.p) <= r19.x) goto L48;
        r4 = true;
    L97:
        r21 = true;
        goto L98
    L101:
        if (r9 == true) goto L103;
        r17.J.c = r12;
    L103:
        r17.post(new xr0.a(r17));
        goto L105
    L29:
        r12 = r1;
        goto L30
    L25:
        r10 = r8.b;
    L105:
        if (r17.g == null) goto L142;
        int r2 = r17.getTableEnd();
        double r25 = r17.r;
        double r26 = 0.0d;
        if (r25 > 0.0d) goto L111;
        r26 = r25 % r17.s;
    L111:
        double r27 = r25 - r26;
        double r28 = r17.q + r17.s;
    L112:
        float r29 = -r17.d(r27);
        r17.g.moveTo(r17.l, r29);
        float r110 = r2;
        r17.g.lineTo(r110, r29);
        String r111 = String.format(Locale.CHINA, "%.2f", new Object[]{Double.valueOf(r27)});
        float r112 = r17.l;
        r17.d.setTextAlign(Paint.Align.RIGHT);
        Paint.FontMetrics r113 = r17.d.getFontMetrics();
        float r114 = r113.bottom;
        r18.drawText(r111, r112 - r17.t, (((r114 - r113.top) / 2.0f) - r114) + r29, r17.d);
        r27 = r27 + r17.s;
        if (r27 < r28) goto L112;
        r17.g.moveTo(r17.l, r29);
        r17.g.lineTo(r17.l, 0.0f);
        r17.g.lineTo(r110, 0.0f);
        r18.drawPath(r17.g, r17.c);
        if (((ArrayList) r17.k).isEmpty() == true) goto L142;
        SimpleDateFormat r30 = new SimpleDateFormat("HH:mm");
        Iterator r31 = ((ArrayList) r17.k).iterator();
        Date r32 = null;
    L119:
        if (r31.hasNext() == false) goto L142;
        b r3 = (b) r31.next();
        if (r3.c == null) goto L119;
        int r33 = ((ArrayList) r17.k).indexOf(r3);     // Catch: Exception -> L138
        Date r115 = r3.b;     // Catch: Exception -> L138
        if (r33 != 0) goto L127;
        r32 = r115;
    L127:
        if (r33 == 0) goto L128;
        if (r115 == null) goto L119;
        if (r32 == null) goto L119;
        if ((r115.getTime() - r32.getTime()) <= 5000) goto L119;
        r17.c(r18, r30.format(r115), r3.c.x);     // Catch: Exception -> L136
    L141:
        r32 = r115;
    L136:
        e = e;
    L140:
        e.printStackTrace();
        goto L141
    L128:
        r17.c(r18, r30.format(r115), r3.c.x);     // Catch: Exception -> L138
    L138:
        e = e;
        r115 = r32;
    L142:
        r18.drawPath(r17.f, r17.a);
        if (((ArrayList) r17.k).isEmpty() == true) goto L194;
        float r34 = s1.e(4.0f) / 2.0f;
        if (((ArrayList) r17.k).size() > ((ArrayList) r17.j).size()) goto L195;
        Iterator r35 = ((ArrayList) r17.k).iterator();
    L150:
        if (r35.hasNext() == false) goto L196;
        b r36 = (b) r35.next();
        if (r36 == null) goto L197;
        Point r37 = r36.c;
        if (r37 == null) goto L198;
        r18.drawCircle(r37.x, r37.y, r34, r17.b);
        String r38 = String.format(Locale.CHINA, "%.2f", new Object[]{Double.valueOf(r36.a)});
        Point r39 = r36.c;
        float r40 = r39.x;
        float r41 = r39.y;
        r17.e.setTextAlign(Paint.Align.CENTER);
        r18.drawText(r38, r40, r41 - r17.t, r17.e);
        goto L150
    L198:
        return;
    L197:
        return;
    L196:
        return;
    L195:
        return;
    L194:
        return;
    L8:
        if (r17.g == null) goto L13;
        if (r17.c == null) goto L13;
        if (r17.a != null) goto L14;
        goto L13
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int r3, int r4) {
        int r5 = this.h;
        if (r5 > 0) goto L5;
        r5 = (int) s1.e(345.0f);
    L5:
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        if (1073741824 != r0) goto L8;
        r6 = r6 + (getPaddingTop() + getPaddingBottom());
    L8:
        setMeasuredDimension(r5, r6);
    }

    public LineChartView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.s = 10.0d;
        this.u = ColorProtector.parseColor("#286DD4");
        this.v = ColorProtector.parseColor("#FF4081");
        int r4 = ColorProtector.parseColor("#BBBBBB");
        this.w = r4;
        this.x = r4;
        this.y = ColorProtector.parseColor("#009688");
        this.z = true;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = null;
        this.I = null;
        this.J = null;
        h();
    }

    public final void c(Canvas r4, String r5, float r6) {
        this.d.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics r0 = this.d.getFontMetrics();
        float r1 = r0.bottom;
        r4.drawText(r5, r6, (0.0f + (((r1 - r0.top) / 2.0f) - r1)) + this.t, this.d);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.h = r1;
        this.i = r2;
    }
}
