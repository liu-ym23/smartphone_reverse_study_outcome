package com.ss.android.lark.flow.chat.mediapreview;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import nlb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class FlowSubsamplingScaleImageView extends SubsamplingScaleImageView {
    public static final /* synthetic */ int N2 = 0;
    public boolean I2;
    public float J2;
    public g K2;
    public FlowLargeImageView.c L2;
    public final c M2;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ FlowSubsamplingScaleImageView b;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r6) {
            FlowSubsamplingScaleImageView r0 = this.b;
            int r1 = FlowSubsamplingScaleImageView.N2;
            if (r0.s == false) goto L15;
            if (r0.b1 == false) goto L15;
            if (r0.z == null) goto L15;
            r0.setGestureDetector(this.a);
            FlowSubsamplingScaleImageView r2 = this.b;
            if (r2.t == false) goto L12;
            r2.U = new PointF(r6.getX(), r6.getY());
            FlowSubsamplingScaleImageView r3 = this.b;
            PointF r4 = this.b.z;
            r3.A = new PointF(r4.x, r4.y);
            FlowSubsamplingScaleImageView r5 = this.b;
            r5.y = r5.x;
            r5.M = true;
            r5.K = true;
            r5.k0 = -1.0f;
            r5.L0 = r5.R(r5.U);
            FlowSubsamplingScaleImageView r7 = this.b;
            r7.P0 = new PointF(r6.getX(), r6.getY());
            FlowSubsamplingScaleImageView r8 = this.b;
            PointF r9 = this.b.L0;
            r8.H0 = new PointF(r9.x, r9.y);
            this.b.p0 = false;
            return false;
        L12:
            r2.o(r2.R(new PointF(r6.getX(), r6.getY())), new PointF(r6.getX(), r6.getY()));
            return true;
        L15:
            return onDoubleTapEvent(r6);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r15) {
            this.b.performClick();
            FlowSubsamplingScaleImageView r16 = this.b;
            FlowLargeImageView.c r0 = r16.L2;
            if (r0 != null) goto L6;
            Log.e("FlowSubsamplingScaleImageView", "ability is null");
        L25:
            return true;
        L6:
            if (r0.a.k == false) goto L15;
            if (Math.abs(r16.x - r16.J2) > 0.01f) goto L25;
            SubsamplingScaleImageView.f r2 = new SubsamplingScaleImageView.f(r16, r16.j);
            r2.d = 100;
            r2.b();
            r2.g = false;
            r2.a();
            kza.g r17 = r0.a.j;
            if (r17 == null) goto L13;
            r17.b(false);
        L13:
            r0.a.k = false;
            r0.a(true);
            goto L25
        L15:
            if (Math.abs(r16.x - r16.j) >= 0.001f) goto L24;
            float r3 = r16.J2;
            int[] r6 = new int[2];
            r16.getLocationOnScreen(r6);
            int r7 = UIHelper.getWindowWidth(r16.getContext());
            int r8 = UIUtils.getScreenHeight(r16.getContext());
            float r9 = r16.getWidth() / 2.0f;
            float r11 = r16.getHeight() / 2.0f;
            float r10 = r8;
            if ((r16.H() * r3) >= r10) goto L19;
            PointF r12 = new PointF((r16.I() / 2.0f) + (((r9 - (r7 / 2.0f)) + r6[0]) / r3), (r16.H() / 2.0f) + (((r11 - (r10 / 2.0f)) + r6[1]) / r3));
        L20:
            SubsamplingScaleImageView.f r13 = new SubsamplingScaleImageView.f(r16, r3, r12);
            r13.d = 100;
            r13.b();
            r13.h = false;
            r13.g = false;
            r13.i = true;
            r13.a();
            kza.g r18 = r0.a.j;
            if (r18 == null) goto L23;
            r18.b(true);
        L23:
            r0.a.k = true;
            r0.a(false);
            goto L25
        L19:
            r12 = new PointF((r9 + r6[0]) / r3, (r11 + r6[1]) / r3);
            goto L20
        L24:
            SubsamplingScaleImageView.f r4 = new SubsamplingScaleImageView.f(r16, r16.j);
            r4.g = false;
            r4.b();
            r4.d = 100;
            r4.a();
            r0.a(true);
            goto L25
        }

        public a(FlowSubsamplingScaleImageView r1, Context r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r5, MotionEvent r6, float r7, float r8) {
            FlowSubsamplingScaleImageView r0 = this.b;
            int r1 = FlowSubsamplingScaleImageView.N2;
            if (r0.N != 1) goto L25;
            if (r0.r == false) goto L25;
            if (r0.b1 == false) goto L25;
            if (r0.z == null) goto L25;
            if (r5 == null) goto L25;
            if (r6 == null) goto L25;
            if (Math.abs(r5.getX() - r6.getX()) > 50.0f) goto L17;
            if (Math.abs(r5.getY() - r6.getY()) <= 50.0f) goto L25;
        L17:
            if (Math.abs(r7) > 500.0f) goto L21;
            if (Math.abs(r8) <= 500.0f) goto L25;
        L21:
            if (this.b.K == true) goto L25;
            PointF r9 = this.b.z;
            PointF r10 = new PointF(r9.x + (r7 * 0.25f), r9.y + (r8 * 0.25f));
            float r11 = (this.b.getWidth() / 2.0f) - r10.x;
            FlowSubsamplingScaleImageView r12 = this.b;
            float r13 = r11 / r12.x;
            float r14 = (r12.getHeight() / 2.0f) - r10.y;
            FlowSubsamplingScaleImageView r15 = this.b;
            SubsamplingScaleImageView.f r16 = new SubsamplingScaleImageView.f(r15, new PointF(r13, r14 / r15.x));
            r16.b();
            r16.h = false;
            r16.g = true;
            r16.f = 3;
            r16.a();
            return true;
        L25:
            return super.onFling(r5, r6, r7, r8);
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ FlowSubsamplingScaleImageView a;

        public b(FlowSubsamplingScaleImageView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r1) {
            this.a.performClick();
            return true;
        }
    }

    public class c implements SubsamplingScaleImageView.j {
        public final /* synthetic */ FlowSubsamplingScaleImageView a;

        public c(FlowSubsamplingScaleImageView r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.j
        public final PointF a(PointF r2) {
            return new PointF(0.0f, 0.0f);
        }

        @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView.j
        public final float b(int r2, int r3, int r4, int r5) {
            if (r2 <= 0) goto L15;
            if (r3 <= 0) goto L15;
            if (r4 <= 0) goto L15;
            if (r5 <= 0) goto L15;
            float r6 = (r2 * 1.0f) / r4;
            float r7 = (r3 * 1.0f) / r5;
            FlowLargeImageView.c r8 = this.a.L2;
            if (r8 == null) goto L14;
            if (r8.a.l == false) goto L14;
            return Math.min(r6, r7);
        L14:
            return Math.max(r6, r7);
        L15:
            return 1.0f;
        }
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public final void B() {
        if (this.z != null) goto L5;
        this.z = new PointF();
    L5:
        C(true);
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public RectF getVisibleTileRectOnView() {
        FlowLargeImageView.c r0 = this.L2;
        if (r0 != null) goto L7;
        return super.getVisibleTileRectOnView();
    L7:
        if (r0.a.k == false) goto L11;
        int[] r1 = new int[2];
        getLocationOnScreen(r1);
        int r2 = UIHelper.getWindowWidth(getContext());
        int r3 = UIUtils.getScreenHeight(getContext());
        int r4 = r1[0];
        int r5 = r1[1];
        return new RectF(-r4, -r5, r2 - r4, r3 - r5);
    L11:
        return super.getVisibleTileRectOnView();
    }

    public FlowSubsamplingScaleImageView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v94 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public final boolean A(MotionEvent r19) {
        int r2 = r19.getPointerCount();
        int r3 = r19.getAction();
        if (r3 == 0) goto L247;
        float r8 = 0.0f;
        if (r3 == 1) goto L146;
        if (r3 != 2) goto L8;
        int r4 = this.N;
        boolean r10 = this.K;
        if (r4 > 0) goto L31;
    L140:
        boolean r1 = false;
    L141:
        if (r1 == false) goto L144;
        this.y1.removeMessages(1);
        invalidate();
        return true;
    L144:
        return false;
    L31:
        if (r2 < 2) goto L54;
        float r5 = SubsamplingScaleImageView.n(r19.getX(0), r19.getX(1), r19.getY(0), r19.getY(1));
        float r6 = (r19.getX(0) + r19.getX(1)) / 2.0f;
        float r9 = (r19.getY(0) + r19.getY(1)) / 2.0f;
        if (this.s == false) goto L140;
        PointF r7 = this.U;
        if (SubsamplingScaleImageView.n(r7.x, r6, r7.y, r9) <= 5.0f) goto L37;
    L40:
        this.K = true;
        this.L = true;
        this.x = Math.min(this.i, (r5 / this.V) * this.y);
        FlowLargeImageView.c r11 = this.L2;
        if (r11 == null) goto L46;
        if (r11.a.l == false) goto L46;
        r11.a(false);
    L46:
        if (this.r == false) goto L49;
        PointF r12 = this.U;
        float r13 = r12.x;
        PointF r14 = this.A;
        float r15 = r13 - r14.x;
        float r16 = r12.y - r14.y;
        float r17 = this.x / this.y;
        float r18 = r15 * r17;
        float r20 = r16 * r17;
        PointF r21 = this.z;
        r21.x = r6 - r18;
        r21.y = r9 - r20;
        r12.set(r6, r9);
        this.A.set(this.z);
        this.y = this.x;
        this.V = r5;
    L52:
        E(this.q);
    L139:
        r1 = true;
        goto L141
    L49:
        if (this.E == null) goto L51;
        this.z.x = (getWidth() / 2.0f) - (this.x * this.E.x);
        this.z.y = (getHeight() / 2.0f) - (this.x * this.E.y);
        goto L52
    L51:
        this.z.x = (getWidth() / 2.0f) - (this.x * (I() / 2.0f));
        this.z.y = (getHeight() / 2.0f) - (this.x * (H() / 2.0f));
        goto L52
    L37:
        if (Math.abs(r5 - this.V) > 5.0f) goto L40;
        if (this.L == false) goto L140;
    L54:
        if (this.M == false) goto L89;
        float r22 = (Math.abs(this.P0.y - r19.getY()) * 2.0f) + this.W;
        if (this.k0 != (-1.0f)) goto L58;
        this.k0 = r22;
    L58:
        float r23 = r19.getY();
        PointF r24 = this.H0;
        if (r23 <= r24.y) goto L61;
        boolean r25 = true;
    L62:
        r24.set(0.0f, r19.getY());
        float r26 = 1.0f;
        float r27 = Math.abs(1.0f - (r22 / this.k0)) * 0.5f;
        if (r27 <= 0.03f) goto L65;
    L66:
        this.p0 = true;
        if (this.k0 <= 0.0f) goto L71;
        if (r25 == false) goto L70;
        r26 = 1.0f + r27;
        goto L71
    L70:
        r26 = 1.0f - r27;
    L71:
        double r28 = this.x;
        float r29 = Math.max(x(), Math.min(this.i, this.x * r26));
        this.x = r29;
        if (this.r == false) goto L85;
        PointF r30 = this.U;
        float r31 = r30.x;
        PointF r32 = this.A;
        float r110 = r31 - r32.x;
        float r33 = r30.y;
        float r34 = r33 - r32.y;
        float r35 = r29 / this.y;
        float r111 = r110 * r35;
        float r36 = r34 * r35;
        PointF r37 = this.z;
        r37.x = r31 - r111;
        r37.y = r33 - r36;
        if ((((double) H()) * r28) >= getHeight()) goto L78;
        if ((this.x * H()) < getHeight()) goto L78;
    L81:
        r(true);
        this.U.set(N(this.L0));
        this.A.set(this.z);
        this.y = this.x;
    L83:
        r22 = r8;
    L88:
        this.k0 = r22;
        r(true);
        E(this.q);
    L78:
        if ((r28 * ((double) I())) < getWidth()) goto L80;
    L82:
        r8 = r22;
        goto L83
    L80:
        if ((this.x * I()) < getWidth()) goto L82;
    L85:
        if (this.E == null) goto L87;
        this.z.x = (getWidth() / 2.0f) - (this.x * this.E.x);
        this.z.y = (getHeight() / 2.0f) - (this.x * this.E.y);
        goto L88
    L87:
        this.z.x = (getWidth() / 2.0f) - (this.x * (I() / 2.0f));
        this.z.y = (getHeight() / 2.0f) - (this.x * (H() / 2.0f));
        goto L88
    L65:
        if (this.p0 == false) goto L88;
    L61:
        r25 = false;
        goto L62
    L89:
        if (r10 == true) goto L140;
        float r38 = Math.abs(r19.getX() - this.U.x);
        float r39 = Math.abs(r19.getY() - this.U.y);
        float r40 = this.b2 * 5.0f;
        if (r38 <= r40) goto L93;
    L96:
        this.z.x = this.A.x + (r19.getX() - this.U.x);
        this.z.y = this.A.y + (r19.getY() - this.U.y);
        PointF r41 = this.z;
        float r42 = r41.x;
        float r43 = r41.y;
        r(true);
        PointF r44 = this.z;
        if (r42 == r44.x) goto L99;
        boolean r45 = true;
    L100:
        float r46 = r44.y;
        if (r43 == r46) goto L103;
        boolean r47 = true;
    L104:
        if (r45 == true) goto L106;
    L110:
        boolean r112 = false;
    L111:
        if (r47 == true) goto L113;
    L117:
        boolean r48 = false;
    L118:
        if (r43 == r46) goto L120;
    L122:
        boolean r49 = false;
    L123:
        if (r112 == true) goto L131;
        if (r48 == true) goto L131;
        if (r45 == false) goto L130;
        if (r47 == false) goto L130;
        if (r49 == true) goto L130;
        if (this.L == false) goto L131;
    L130:
        this.L = true;
    L136:
        if (this.r == true) goto L138;
        PointF r50 = this.z;
        PointF r51 = this.A;
        r50.x = r51.x;
        r50.y = r51.y;
        F(false);
    L138:
        E(this.q);
    L131:
        if (r38 <= r40) goto L133;
    L134:
        this.N = 0;
        this.y1.removeMessages(1);
        F(false);
        goto L136
    L133:
        if (r39 <= r40) goto L136;
    L120:
        if (r39 <= (3.0f * r40)) goto L122;
        r49 = true;
        goto L123
    L113:
        if (r39 <= r38) goto L117;
        if (this.L == true) goto L117;
        r48 = true;
        goto L118
    L106:
        if (r38 <= r39) goto L110;
        if (this.L == true) goto L110;
        r112 = true;
        goto L111
    L103:
        r47 = false;
        goto L104
    L99:
        r45 = false;
        goto L100
    L93:
        if (r39 > r40) goto L96;
        if (this.L == false) goto L140;
    L8:
        if (r3 != 5) goto L10;
    L27:
        ?? r52 = 1;
    L248:
        this.V0 = null;
        F(r52);
        this.N = Math.max(this.N, r2);
        if (r2 < 2) goto L256;
        if (this.s == false) goto L253;
        float r53 = SubsamplingScaleImageView.n(r19.getX(0), r19.getX(r52), r19.getY(0), r19.getY(r52));
        this.y = this.x;
        this.V = r53;
        PointF r54 = this.A;
        PointF r55 = this.z;
        r54.set(r55.x, r55.y);
        ?? r56 = 1;
        this.U.set((r19.getX(0) + r19.getX(1)) / 2.0f, (r19.getY(0) + r19.getY(1)) / 2.0f);
    L254:
        this.y1.removeMessages(r56);
        return r56;
    L253:
        r56 = 1;
        this.N = 0;
        goto L254
    L256:
        if (this.M == true) goto L258;
        PointF r57 = this.A;
        PointF r58 = this.z;
        r57.set(r58.x, r58.y);
        this.U.set(r19.getX(), r19.getY());
        this.y1.sendEmptyMessageDelayed(1, 600);
        return true;
    L258:
        return true;
    L10:
        if (r3 != 6) goto L12;
        this.y1.removeMessages(1);
        if (this.N <= 0) goto L26;
        boolean r59 = this.K;
        if (r59 == false) goto L19;
    L20:
        if (r59 == false) goto L26;
        if (r2 != 2) goto L26;
        this.L = true;
        PointF r60 = this.A;
        PointF r61 = this.z;
        r60.set(r61.x, r61.y);
        if (r19.getActionIndex() != 1) goto L25;
        this.U.set(r19.getX(0), r19.getY(0));
        goto L26
    L25:
        this.U.set(r19.getX(1), r19.getY(1));
        goto L26
    L19:
        if (this.L == true) goto L20;
    L26:
        return true;
    L12:
        if (r3 == 261) goto L27;
    L146:
        if (this.M == false) goto L151;
        this.M = false;
        if (this.p0 == true) goto L238;
        o(this.L0, this.U);
    L238:
        if (this.N > 0) goto L240;
    L244:
        boolean r62 = true;
    L245:
        this.K = false;
        this.L = false;
        this.N = 0;
        return r62;
    L240:
        if (this.K == false) goto L242;
    L243:
        r62 = true;
        E(true);
        goto L245
    L242:
        if (this.L == false) goto L244;
    L151:
        if (this.K == true) goto L155;
        if (this.L == false) goto L238;
    L155:
        if (this.z == null) goto L238;
        if (this.P1 != null) goto L160;
        this.P1 = new SubsamplingScaleImageView.l(0.0f, new PointF(0.0f, 0.0f));
    L160:
        float r63 = this.x;
        PointF r64 = this.z;
        float r65 = r64.x;
        float r66 = r64.y;
        SubsamplingScaleImageView.l r113 = this.P1;
        r113.a = r63;
        r113.b.set(r64);
        SubsamplingScaleImageView.l r67 = this.P1;
        if (this.l == 2) goto L163;
    L165:
        boolean r114 = true;
    L166:
        PointF r115 = r67.b;
        float r116 = r67.a;
        FlowLargeImageView.c r117 = this.L2;
        if (this.K == true) goto L169;
    L195:
        float r118 = Math.min(this.i, Math.max(x(), r116));
        float r119 = I() * r118;
        float r120 = H() * r118;
        if (this.l == 3) goto L198;
    L200:
        if (r114 == false) goto L202;
        r115.x = Math.max(r115.x, getWidth() - r119);
        r115.y = Math.max(r115.y, getHeight() - r120);
    L204:
        if (getPaddingLeft() <= 0) goto L206;
    L209:
        float r68 = getPaddingLeft() / (getPaddingLeft() + getPaddingRight());
    L211:
        if (getPaddingTop() <= 0) goto L213;
    L216:
        float r121 = getPaddingTop() / (getPaddingTop() + getPaddingBottom());
    L218:
        if (this.l == 3) goto L220;
    L222:
        if (r114 == false) goto L224;
        float r69 = Math.max(0.0f, (getWidth() - r119) * r68);
        float r70 = Math.max(0.0f, (getHeight() - r120) * r121);
    L226:
        r115.x = Math.min(r115.x, r69);
        r115.y = Math.min(r115.y, r70);
        r67.a = r118;
        SubsamplingScaleImageView.l r71 = this.P1;
        float r72 = r71.a;
        PointF r73 = r71.b;
        float r74 = r73.x;
        float r75 = r73.y;
        if (Math.abs(r63 - r72) >= 1.0E-8f) goto L229;
        boolean r76 = true;
    L230:
        if (r76 == true) goto L232;
    L236:
        SubsamplingScaleImageView.f r77 = new SubsamplingScaleImageView.f(this, r72, new PointF(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - r74) / r72, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - r75) / r72));
        r77.d = 200;
        r77.b();
        r77.g = true;
        r77.i = true;
        r77.a();
        goto L238
    L232:
        if (Math.abs(r65 - r74) >= 0.5f) goto L236;
        if (Math.abs(r66 - r75) >= 0.5f) goto L236;
    L229:
        r76 = false;
        goto L230
    L224:
        r69 = Math.max(0, getWidth());
        int r78 = Math.max(0, getHeight());
    L225:
        r70 = r78;
        goto L226
    L220:
        if (this.b1 == false) goto L222;
        r69 = Math.max(0, getWidth() / 2);
        r78 = Math.max(0, getHeight() / 2);
        goto L225
    L213:
        if (getPaddingBottom() > 0) goto L216;
        r121 = 0.5f;
        goto L218
    L206:
        if (getPaddingRight() > 0) goto L209;
        r68 = 0.5f;
        goto L211
    L202:
        r115.x = Math.max(r115.x, -r119);
        r115.y = Math.max(r115.y, -r120);
        goto L204
    L198:
        if (this.b1 == false) goto L200;
        r115.x = Math.max(r115.x, (getWidth() / 2) - r119);
        r115.y = Math.max(r115.y, (getHeight() / 2) - r120);
        goto L204
    L169:
        if (Math.abs(r116 - this.h2) <= 0.001f) goto L195;
        if (r117 == null) goto L195;
        FlowLargeImageView r122 = r117.a;
        if (r122.k == false) goto L181;
        if (r116 > this.J2) goto L195;
        r116 = this.j;
        kza.g r123 = r122.j;
        if (r123 == null) goto L179;
        r123.b(false);
    L179:
        r117.a.k = false;
        r117.a(true);
        goto L195
    L181:
        if (r116 <= this.h2) goto L183;
        boolean r124 = true;
    L184:
        if (r124 == false) goto L190;
        float r125 = this.J2;
        if (r116 >= r125) goto L188;
        r116 = r125;
    L188:
        r117.a(false);
        goto L195
    L190:
        if (r116 >= this.J2) goto L193;
        r116 = this.j;
    L193:
        if (r122.l == true) goto L195;
        r117.a(true);
        goto L195
    L183:
        r124 = false;
        goto L184
    L163:
        if (this.b1 == false) goto L165;
        r114 = false;
        goto L166
    L247:
        r52 = 1;
        this.h2 = getScale();
        goto L248
    }

    public void setDefaultScale(float r1) {
        this.J2 = r1;
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public void setGestureDetector(Context r3) {
        this.O = new GestureDetector(r3, new a(this, r3));
        this.P = new GestureDetector(r3, new b(this));
    }

    public FlowSubsamplingScaleImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.I2 = false;
        this.J2 = x();
        this.K2 = null;
        this.L2 = null;
        this.M2 = new c(this);
    }

    @Override // com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView
    public final void o(PointF r9, PointF r10) {
        if (this.r == true) goto L8;
        PointF r0 = this.E;
        if (r0 == null) goto L7;
        r9.x = r0.x;
        r9.y = r0.y;
        goto L8
    L7:
        r9.x = I() / 2;
        r9.y = H() / 2;
    L8:
        FlowLargeImageView.c r1 = this.L2;
        if (r1 != null) goto L13;
        Log.e("FlowSubsamplingScaleImageView", "doubleTapZoom ability is null");
        return;
    L13:
        if (r1.a.k == false) goto L19;
        float r2 = Math.min(this.i, this.u);
        if (Math.abs(this.x - this.J2) <= 0.001f) goto L17;
        SubsamplingScaleImageView.f r11 = new SubsamplingScaleImageView.f(this, this.J2);
        r11.g = false;
        r11.b();
        r11.d = 200;
        r11.f = 4;
        r11.a();
    L25:
        invalidate();
        return;
    L17:
        SubsamplingScaleImageView.f r3 = new SubsamplingScaleImageView.f(this, r2, r9, r10);
        r3.g = false;
        r3.d = 200;
        r3.f = 4;
        r3.a();
        goto L25
    L19:
        if (Math.abs(this.x - this.j) <= 0.001f) goto L21;
        SubsamplingScaleImageView.f r12 = new SubsamplingScaleImageView.f(this, this.j);
        r12.g = false;
        r12.b();
        r12.d = 200;
        r12.f = 4;
        r12.a();
        r1.a(true);
        goto L25
    L21:
        float r4 = Math.min(this.i, this.u);
        if (this.I2 == false) goto L24;
        r4 = this.J2;
    L24:
        SubsamplingScaleImageView.f r5 = new SubsamplingScaleImageView.f(this, r4, r9, r10);
        r5.g = false;
        r5.d = 200;
        r5.f = 4;
        r5.a();
        r1.a(false);
        goto L25
    }
}
