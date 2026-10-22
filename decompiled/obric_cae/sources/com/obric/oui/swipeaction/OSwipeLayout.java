package com.obric.oui.swipeaction;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.obric.oui.layout.OUIFrameLayout;
import j0.h0;
import j0.w;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class OSwipeLayout extends OUIFrameLayout {
    public static final e P = null;
    public final HashMap A;
    public final HashMap B;
    public boolean C;
    public final boolean[] D;
    public boolean E;
    public float F;
    public float G;
    public int H;
    public boolean I;
    public float J;
    public float K;
    public View.OnClickListener L;
    public View.OnLongClickListener M;
    public Rect N;
    public final GestureDetector O;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f6553q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public e f6554r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final o0.c f6555s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f6556t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinkedHashMap<e, View> f6557u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public g f6558v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float[] f6559w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayList f6560x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList f6561y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final HashMap f6562z;

    public class a extends o0.c.AbstractC0128c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f6564b;

        public a(OSwipeLayout r8) {
            this.f6564b = r8;
            this.f6563a = true;
        }

        @Override // o0.c.AbstractC0128c
        public final int a(View r8, int r10) {
            OSwipeLayout r11 = this.f6564b;
            if (r8 != r11.getSurfaceView()) goto L29;
            int r12 = r11.f6554r.ordinal();
            if (r12 == 0) goto L21;
            if (r12 == 1) goto L19;
            if (r12 == 2) goto L11;
            if (r12 == 3) goto L19;
        L50:
            return r10;
        L11:
            if (r10 <= r11.getPaddingLeft()) goto L15;
            return r11.getPaddingLeft();
        L15:
            if (r10 >= (r11.getPaddingLeft() - r11.f6556t)) goto L50;
            return r11.getPaddingLeft() - r11.f6556t;
        L19:
            return r11.getPaddingLeft();
        L21:
            if (r10 >= r11.getPaddingLeft()) goto L25;
            return r11.getPaddingLeft();
        L25:
            if (r10 <= (r11.getPaddingLeft() + r11.f6556t)) goto L50;
            return r11.getPaddingLeft() + r11.f6556t;
        L29:
            if (r11.getCurrentBottomView() != r8) goto L50;
            int r13 = r11.f6554r.ordinal();
            if (r13 == 0) goto L45;
            if (r13 == 1) goto L43;
            if (r13 == 2) goto L37;
            if (r13 == 3) goto L43;
        L37:
            if (r11.f6558v != g.f6573b) goto L50;
            if (r10 >= (r11.getMeasuredWidth() - r11.f6556t)) goto L50;
            return r11.getMeasuredWidth() - r11.f6556t;
        L43:
            return r11.getPaddingLeft();
        L45:
            if (r11.f6558v != g.f6573b) goto L50;
            if (r10 <= r11.getPaddingLeft()) goto L50;
            return r11.getPaddingLeft();
        }

        @Override // o0.c.AbstractC0128c
        public final int b(View r8, int r10, int r11) {
            OSwipeLayout r12 = this.f6564b;
            if (r8 != r12.getSurfaceView()) goto L28;
            int r13 = r12.f6554r.ordinal();
            if (r13 == 0) goto L27;
            if (r13 == 1) goto L19;
            if (r13 == 2) goto L27;
            if (r13 == 3) goto L11;
        L66:
            return r10;
        L11:
            if (r10 >= (r12.getPaddingTop() - r12.f6556t)) goto L15;
            return r12.getPaddingTop() - r12.f6556t;
        L15:
            if (r10 <= r12.getPaddingTop()) goto L66;
            return r12.getPaddingTop();
        L19:
            if (r10 >= r12.getPaddingTop()) goto L23;
            return r12.getPaddingTop();
        L23:
            if (r10 <= (r12.getPaddingTop() + r12.f6556t)) goto L66;
            return r12.getPaddingTop() + r12.f6556t;
        L27:
            return r12.getPaddingTop();
        L28:
            View r14 = r12.getSurfaceView();
            if (r14 != null) goto L31;
            int r15 = 0;
        L32:
            int r16 = r12.f6554r.ordinal();
            if (r16 == 0) goto L68;
            if (r16 == 1) goto L53;
            if (r16 == 2) goto L68;
            if (r16 != 3) goto L66;
            if (r12.f6558v == g.f6573b) goto L41;
            int r17 = r15 + r11;
            if (r17 < r12.getPaddingTop()) goto L49;
            return r12.getPaddingTop();
        L49:
            if (r17 > (r12.getPaddingTop() - r12.f6556t)) goto L66;
            return r12.getPaddingTop() - r12.f6556t;
        L41:
            if (r10 >= (r12.getMeasuredHeight() - r12.f6556t)) goto L66;
            return r12.getMeasuredHeight() - r12.f6556t;
        L53:
            if (r12.f6558v == g.f6573b) goto L55;
            int r18 = r15 + r11;
            if (r18 >= r12.getPaddingTop()) goto L63;
            return r12.getPaddingTop();
        L63:
            if (r18 <= (r12.getPaddingTop() + r12.f6556t)) goto L66;
            return r12.getPaddingTop() + r12.f6556t;
        L55:
            if (r10 <= r12.getPaddingTop()) goto L66;
            return r12.getPaddingTop();
        L68:
            return r12.getPaddingTop();
        L31:
            r15 = r14.getTop();
            goto L32
        }

        @Override // o0.c.AbstractC0128c
        public final int c(View r8) {
            return this.f6564b.f6556t;
        }

        @Override // o0.c.AbstractC0128c
        public final int d() {
            return this.f6564b.f6556t;
        }

        @Override // o0.c.AbstractC0128c
        public final void g(View r18, int r19, int r20, int r21, int r22) {
            OSwipeLayout r8 = this.f6564b;
            View r10 = r8.getSurfaceView();
            if (r10 != null) goto L5;
            return;
        L5:
            View r11 = r8.getCurrentBottomView();
            int r12 = r10.getLeft();
            int r13 = r10.getRight();
            int r14 = r10.getTop();
            int r15 = r10.getBottom();
            if (r18 != r10) goto L18;
            if (r8.f6558v != g.f6573b) goto L58;
            if (r11 == null) goto L58;
            e r16 = r8.f6554r;
            if (r16 != e.f6567a) goto L13;
        L16:
            r11.offsetLeftAndRight(r21);
            goto L58
        L13:
            if (r16 == e.f6569m) goto L16;
            r11.offsetTopAndBottom(r22);
        L58:
            HashMap r17 = r8.f6562z;
            int r110 = 0;
            if (r17.isEmpty() == true) goto L221;
            Iterator r23 = r17.entrySet().iterator();
        L63:
            if (r23.hasNext() == false) goto L221;
            Map.Entry r24 = (Map.Entry) r23.next();
            View r111 = (View) r24.getKey();
            Rect r112 = new Rect(r111.getLeft(), r111.getTop(), r110, r110);
            View r113 = r111;
        L66:
            if (r113.getParent() == null) goto L73;
            if (r113 == r8.getRootView()) goto L73;
            r113 = (View) r113.getParent();
            if (r113 == r8) goto L73;
            r112.left = r113.getLeft() + r112.left;
            r112.top = r113.getTop() + r112.top;
        L73:
            r112.right = r111.getMeasuredWidth() + r112.left;
            int r114 = r111.getMeasuredHeight() + r112.top;
            r112.bottom = r114;
            e r115 = r8.f6554r;
            int r116 = r112.left;
            int r25 = r112.right;
            int r117 = r112.top;
            Iterator r26 = r23;
            g r27 = r8.getShowMode();
            g r28 = g.f6572a;
            if (r27 != r28) goto L96;
            int r29 = r115.ordinal();
            if (r29 != 0) goto L78;
            if (r12 >= r25) goto L126;
            if (r12 < r116) goto L126;
        L94:
            boolean r30 = true;
        L127:
            HashMap r31 = r8.A;
            if (r30 == false) goto L170;
            r31.put(r111, Boolean.FALSE);
            float r32 = 0.0f;
            if (r8.getShowMode() != r28) goto L145;
            int r33 = r8.f6554r.ordinal();
            if (r33 != 0) goto L134;
            int r34 = r112.left - r12;
        L162:
            float r35 = r34;
            int r36 = r111.getWidth();
        L163:
            r32 = r35 / r36;
        L164:
            Iterator r37 = ((ArrayList) r24.getValue()).iterator();
        L166:
            if (r37.hasNext() == false) goto L170;
            f r38 = (f) r37.next();
            Math.abs(r32);
            r38.a();
            if (Math.abs(r32) != 1.0f) goto L166;
            r31.put(r111, Boolean.TRUE);
            goto L166
        L134:
            if (r33 != 1) goto L136;
            int r39 = r112.top - r14;
        L159:
            r35 = r39;
            r36 = r111.getHeight();
            goto L163
        L136:
            if (r33 != 2) goto L138;
            r34 = r112.right - r13;
            goto L162
        L138:
            if (r33 != 3) goto L164;
            r39 = r112.bottom - r15;
            goto L159
        L145:
            if (r8.getShowMode() != g.f6573b) goto L164;
            int r40 = r8.f6554r.ordinal();
            if (r40 != 0) goto L149;
            int r41 = r112.right;
            int r42 = r8.getPaddingLeft();
        L161:
            r34 = r41 - r42;
            goto L162
        L149:
            if (r40 != 1) goto L151;
            int r43 = r112.bottom;
            int r44 = r8.getPaddingTop();
        L158:
            r39 = r43 - r44;
            goto L159
        L151:
            if (r40 != 2) goto L153;
            r41 = r112.left;
            r42 = r8.getWidth();
            goto L161
        L153:
            if (r40 != 3) goto L164;
            r43 = r112.top;
            r44 = r8.getHeight();
        L170:
            e r45 = r8.f6554r;
            if (((Boolean) r31.get(r111)).booleanValue() == true) goto L207;
            int r46 = r112.left;
            int r47 = r112.right;
            int r118 = r112.top;
            int r119 = r112.bottom;
            if (r8.getShowMode() != g.f6572a) goto L189;
            if (r45 != e.f6569m) goto L179;
            if (r13 > r46) goto L179;
        L206:
            boolean r48 = true;
        L208:
            if (r48 == false) goto L220;
            r31.put(r111, Boolean.TRUE);
            Iterator r49 = ((ArrayList) r24.getValue()).iterator();
        L211:
            if (r49.hasNext() == false) goto L220;
            f r50 = (f) r49.next();
            e r51 = r8.f6554r;
            if (r51 != e.f6567a) goto L215;
        L218:
            r111.getWidth();
        L219:
            r50.a();
            goto L211
        L215:
            if (r51 == e.f6569m) goto L218;
            r111.getHeight();
        L220:
            r23 = r26;
            r110 = 0;
        L179:
            if (r45 != e.f6567a) goto L182;
            if (r12 >= r47) goto L206;
        L182:
            if (r45 != e.f6568b) goto L185;
            if (r14 >= r119) goto L206;
        L185:
            if (r45 != e.f6570n) goto L207;
            if (r15 > r118) goto L207;
        L189:
            if (r8.getShowMode() != g.f6573b) goto L207;
            if (r45 != e.f6569m) goto L195;
            if (r47 <= r8.getWidth()) goto L206;
        L195:
            if (r45 != e.f6567a) goto L199;
            if (r46 >= r8.getPaddingLeft()) goto L206;
        L199:
            if (r45 != e.f6568b) goto L203;
            if (r118 >= r8.getPaddingTop()) goto L206;
        L203:
            if (r45 != e.f6570n) goto L207;
            if (r119 <= r8.getHeight()) goto L206;
        L207:
            r48 = false;
        L126:
            r30 = false;
            goto L127
        L78:
            if (r29 != 1) goto L80;
            if (r14 < r117) goto L126;
            if (r14 >= r114) goto L126;
        L80:
            if (r29 == 2) goto L86;
            if (r29 != 3) goto L126;
            if (r15 <= r117) goto L126;
            if (r15 > r114) goto L126;
        L86:
            if (r13 <= r116) goto L126;
            if (r13 > r25) goto L126;
        L96:
            if (r8.getShowMode() != g.f6573b) goto L126;
            int r52 = r115.ordinal();
            if (r52 == 0) goto L122;
            if (r52 == 1) goto L117;
            if (r52 == 2) goto L112;
            if (r52 != 3) goto L126;
            if (r117 >= r8.getHeight()) goto L126;
            if (r117 < r8.getPaddingTop()) goto L126;
        L112:
            if (r116 > r8.getWidth()) goto L126;
            if (r25 <= r8.getWidth()) goto L126;
        L117:
            if (r117 >= r8.getPaddingTop()) goto L126;
            if (r114 < r8.getPaddingTop()) goto L126;
        L122:
            if (r25 < r8.getPaddingLeft()) goto L126;
            if (r116 >= r8.getPaddingLeft()) goto L126;
        L221:
            e r53 = r8.getDragEdge();
            if (r53 != e.f6567a) goto L226;
            if (r21 < 0) goto L236;
        L237:
            boolean r54 = true;
        L238:
            r8.n();
            h r55 = r8.getOpenStatus();
            ArrayList r56 = r8.f6560x;
            if (r56.isEmpty() == true) goto L266;
            int r57 = 1;
            r8.H++;
            Iterator r58 = r56.iterator();
        L242:
            if (r58.hasNext() == false) goto L250;
            k r59 = (k) r58.next();
            if (r8.H != r57) goto L248;
            if (r54 == false) goto L247;
            r59.f();
            goto L248
        L247:
            r59.d();
        L248:
            int r60 = r12 - r8.getPaddingLeft();
            r8.getPaddingTop();
            r59.b(r60);
            r57 = 1;
            goto L242
        L250:
            if (r55 != h.f6577m) goto L257;
            Iterator r61 = r56.iterator();
        L253:
            if (r61.hasNext() == false) goto L255;
            ((k) r61.next()).a();
            goto L253
        L255:
            r8.H = 0;
        L257:
            if (r55 != h.f6576b) goto L266;
            View r62 = r8.getCurrentBottomView();
            if (r62 == null) goto L261;
            r62.setEnabled(true);
        L261:
            Iterator r63 = r56.iterator();
        L263:
            if (r63.hasNext() == false) goto L265;
            ((k) r63.next()).c();
            goto L263
        L265:
            int r64 = 0;
            r8.H = 0;
        L267:
            r8.invalidate();
            View r65 = r8.getCurrentBottomView();
            h r66 = r8.getOpenStatus();
            h r67 = h.f6577m;
            HashMap r68 = r8.B;
            if (r66 != r67) goto L270;
            r68.remove(r65);
            return;
        L270:
            View[] r69 = {r8.getSurfaceView(), r65};
            int r120 = r64;
        L271:
            if (r120 >= 2) goto L299;
            View r70 = r69[r120];
            Rect r71 = (Rect) r68.get(r70);
            if (r71 != null) goto L275;
            r71 = new Rect();
            r68.put(r70, r71);
        L275:
            r71.left = r70.getLeft();
            r71.top = r70.getTop();
            r71.right = r70.getRight();
            r71.bottom = r70.getBottom();
            r120 = r120 + 1;
            goto L271
        L299:
            return;
        L266:
            r64 = 0;
        L236:
            r54 = false;
            goto L238
        L226:
            if (r53 != e.f6569m) goto L230;
            if (r21 <= 0) goto L237;
        L230:
            if (r53 != e.f6568b) goto L234;
            if (r22 >= 0) goto L237;
        L234:
            if (r53 != e.f6570n) goto L237;
            if (r22 <= 0) goto L237;
        L18:
            if (r8.getBottomViews().contains(r18) == false) goto L58;
            if (r8.f6558v != g.f6573b) goto L22;
            r10.offsetLeftAndRight(r21);
            r10.offsetTopAndBottom(r22);
            goto L58
        L22:
            e r72 = r8.f6554r;
            int r121 = r8.getPaddingLeft();
            int r122 = r8.getPaddingTop();
            e r123 = e.f6569m;
            if (r72 != r123) goto L26;
            r121 = r8.getMeasuredWidth() - r8.f6556t;
        L28:
            e r124 = e.f6567a;
            if (r72 == r124) goto L33;
            if (r72 == r123) goto L33;
            int r73 = r8.getMeasuredWidth() + r121;
            int r125 = r8.f6556t;
        L34:
            Rect r126 = new Rect(r121, r122, r73, r125 + r122);
            if (r11 == null) goto L37;
            r11.layout(r126.left, r126.top, r126.right, r126.bottom);
        L37:
            int r74 = r10.getLeft() + r21;
            int r75 = r10.getTop() + r22;
            if (r8.f6554r != r124) goto L43;
            if (r74 >= r8.getPaddingLeft()) goto L43;
        L46:
            r74 = r8.getPaddingLeft();
        L57:
            r10.layout(r74, r75, r8.getMeasuredWidth() + r74, r8.getMeasuredHeight() + r75);
        L43:
            if (r8.f6554r != r123) goto L48;
            if (r74 > r8.getPaddingLeft()) goto L46;
        L48:
            if (r8.f6554r != e.f6568b) goto L53;
            if (r75 >= r8.getPaddingTop()) goto L53;
        L56:
            r75 = r8.getPaddingTop();
        L53:
            if (r8.f6554r != e.f6570n) goto L57;
            if (r75 <= r8.getPaddingTop()) goto L57;
        L33:
            r73 = r8.f6556t + r121;
            r125 = r8.getMeasuredHeight();
            goto L34
        L26:
            if (r72 != e.f6570n) goto L28;
            r122 = r8.getMeasuredHeight() - r8.f6556t;
            goto L28
        }

        @Override // o0.c.AbstractC0128c
        public final void h(View r8, float r10, float r11) {
            boolean r12 = this.f6563a;
            OSwipeLayout r13 = this.f6564b;
            float r14 = r13.f6555s.f9601n;
            View r15 = r13.getSurfaceView();
            e r16 = r13.f6554r;
            if (r16 == null) goto L60;
            if (r15 == null) goto L60;
            if (r12 == false) goto L8;
            float r17 = r13.G;
        L9:
            e r18 = e.f6567a;
            o0.c r19 = r13.f6555s;
            if (r16 != r18) goto L21;
            if (r10 <= r14) goto L15;
        L52:
            View r20 = r13.getSurfaceView();
            r13.getCurrentBottomView();
            if (r20 == null) goto L60;
            Rect r21 = r13.k(true);
            r19.s(r20, r21.left, r21.top);
            r13.invalidate();
            goto L60
        L15:
            if (r10 < (-r14)) goto L57;
            if (((r13.getSurfaceView().getLeft() * 1.0f) / r13.f6556t) > r17) goto L52;
        L57:
            if (r13.getSurfaceView() == null) goto L60;
            r19.s(r13.getSurfaceView(), r13.getPaddingLeft(), r13.getPaddingTop());
            r13.invalidate();
            goto L60
        L21:
            if (r16 != e.f6569m) goto L32;
            if (r10 > r14) goto L57;
            if (r10 < (-r14)) goto L52;
            if ((((-r13.getSurfaceView().getLeft()) * 1.0f) / r13.f6556t) <= r17) goto L57;
        L32:
            if (r16 != e.f6568b) goto L43;
            if (r11 > r14) goto L52;
            if (r11 < (-r14)) goto L57;
            if (((r13.getSurfaceView().getTop() * 1.0f) / r13.f6556t) <= r17) goto L57;
        L43:
            if (r16 != e.f6570n) goto L60;
            if (r11 > r14) goto L57;
            if (r11 < (-r14)) goto L52;
            if ((((-r13.getSurfaceView().getTop()) * 1.0f) / r13.f6556t) <= r17) goto L57;
        L8:
            r17 = r13.F;
        L60:
            Iterator r22 = r13.f6560x.iterator();
        L62:
            if (r22.hasNext() == false) goto L64;
            ((k) r22.next()).e();
            goto L62
        L64:
            r13.invalidate();
        }

        @Override // o0.c.AbstractC0128c
        public final boolean i(View r8, int r10) {
            OSwipeLayout r11 = this.f6564b;
            boolean r12 = false;
            if (r8 != r11.getSurfaceView()) goto L5;
        L8:
            boolean r13 = true;
        L9:
            if (r13 == true) goto L11;
        L14:
            return r13;
        L11:
            if (r11.getOpenStatus() != h.f6577m) goto L13;
            r12 = true;
        L13:
            this.f6563a = r12;
            goto L14
        L5:
            if (r11.getBottomViews().contains(r8) == true) goto L8;
            r13 = false;
            goto L9
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f6565a;

        public b(OSwipeLayout r8) {
            this.f6565a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            OSwipeLayout.b(this.f6565a);
        }
    }

    public class c implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f6566a;

        public c(OSwipeLayout r8) {
            this.f6566a = r8;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r8) {
            OSwipeLayout.h(this.f6566a);
            return true;
        }
    }

    public interface d {
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6567a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f6568b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final e f6569m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final e f6570n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ e[] f6571o = null;

        static {
            e r8 = new e("Left", 0);
            f6567a = r8;
            e r10 = new e("Top", 1);
            f6568b = r10;
            e r11 = new e("Right", 2);
            f6569m = r11;
            e r12 = new e("Bottom", 3);
            f6570n = r12;
            f6571o = new e[]{r8, r10, r11, r12};
        }

        public e(String r8, int r10) {
            super(r8, r10);
        }

        public static e valueOf(String r8) {
            return (e) Enum.valueOf(e.class, r8);
        }

        public static e[] values() {
            return (e[]) f6571o.clone();
        }
    }

    public interface f {
        void a();
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f6572a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f6573b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ g[] f6574m = null;

        static {
            g r8 = new g("LayDown", 0);
            f6572a = r8;
            g r10 = new g("PullOut", 1);
            f6573b = r10;
            f6574m = new g[]{r8, r10};
        }

        public g(String r8, int r10) {
            super(r8, r10);
        }

        public static g valueOf(String r8) {
            return (g) Enum.valueOf(g.class, r8);
        }

        public static g[] values() {
            return (g[]) f6574m.clone();
        }
    }

    public static final enum h extends Enum<h> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f6575a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h f6576b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final h f6577m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final /* synthetic */ h[] f6578n = null;

        static {
            h r8 = new h("Middle", 0);
            f6575a = r8;
            h r10 = new h("Open", 1);
            f6576b = r10;
            h r11 = new h("Close", 2);
            f6577m = r11;
            f6578n = new h[]{r8, r10, r11};
        }

        public h(String r8, int r10) {
            super(r8, r10);
        }

        public static h valueOf(String r8) {
            return (h) Enum.valueOf(h.class, r8);
        }

        public static h[] values() {
            return (h[]) f6578n.clone();
        }
    }

    public interface i {
        boolean a();
    }

    public class j extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSwipeLayout f6579a;

        public j(OSwipeLayout r8) {
            this.f6579a = r8;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r8) {
            e r10 = OSwipeLayout.P;
            this.f6579a.getClass();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r8) {
            OSwipeLayout r10 = this.f6579a;
            if (r10.E == false) goto L11;
            if (r10.m(r8) == false) goto L11;
            if (r10.getSurfaceView() == null) goto L11;
            View r11 = r10.getSurfaceView();
            int r12 = r10.getPaddingLeft();
            int r13 = r10.getPaddingTop();
            r10.f6555s.s(r11, r12, r13);
            r10.invalidate();
        L11:
            return super.onSingleTapUp(r8);
        }
    }

    public interface k {
        void a();

        void b(int r8);

        void c();

        void d();

        void e();

        void f();
    }

    static {
        P = e.f6569m;
    }

    public OSwipeLayout(Context r14, AttributeSet r15) {
        super(r14, r15, 0, 8);
        this.f6554r = P;
        this.f6556t = 0;
        LinkedHashMap<e, View> r8 = new LinkedHashMap();
        this.f6557u = r8;
        this.f6559w = new float[]{r14.getDimension(3, 0.0f), r14.getDimension(6, 0.0f), r14.getDimension(4, 0.0f), r14.getDimension(0, 0.0f)};
        this.f6560x = new ArrayList();
        this.f6561y = new ArrayList();
        this.f6562z = new HashMap();
        this.A = new HashMap();
        this.B = new HashMap();
        this.C = true;
        this.D = new boolean[]{true, true, true, true};
        this.E = false;
        this.F = 0.75f;
        this.G = 0.25f;
        a r10 = new a(this);
        this.H = 0;
        this.J = -1.0f;
        this.K = -1.0f;
        this.O = new GestureDetector(getContext(), new j(this));
        this.f6555s = new o0.c(getContext(), this, r10);
        this.f6553q = ViewConfiguration.get(r14).getScaledTouchSlop();
        TypedArray r16 = r14.obtainStyledAttributes(r15, nb.a.f9506t);
        int r11 = r16.getInt(2, 2);
        e r12 = e.f6567a;
        e r13 = e.f6569m;
        e r17 = e.f6568b;
        e r18 = e.f6570n;
        setClickToClose(r16.getBoolean(1, this.E));
        if ((r11 & 1) != 1) goto L6;
        r8.put(r12, null);
    L6:
        if ((r11 & 4) != 4) goto L9;
        r8.put(r17, null);
    L9:
        if ((r11 & 2) != 2) goto L12;
        r8.put(r13, null);
    L12:
        if ((r11 & 8) != 8) goto L14;
        r8.put(r18, null);
    L14:
        g r19 = g.f6572a;
        this.f6558v = g.values()[r16.getInt(5, 1)];
        r16.recycle();
    }

    public static void b(OSwipeLayout r8) {
        if (r8.getOpenStatus() != h.f6577m) goto L13;
        AdapterView r10 = r8.getAdapterView();
        if (r10 == null) goto L11;
        int r11 = r10.getPositionForView(r8);
        if (r11 == (-1)) goto L12;
        r10.performItemClick(r10.getChildAt(r11 - r10.getFirstVisiblePosition()), r11, r10.getAdapter().getItemId(r11));
        return;
    L12:
        return;
    L11:
        return;
    }

    private AdapterView getAdapterView() {
        ViewParent r8 = getParent();
        if ((r8 instanceof AdapterView) == true) goto L5;
        return null;
    L5:
        return (AdapterView) r8;
    }

    private float getCurrentOffset() {
        e r8 = this.f6554r;
        if (r8 != null) goto L7;
        return 0.0f;
    L7:
        return this.f6559w[r8.ordinal()];
    }

    public static void h(OSwipeLayout r12) {
        if (r12.getOpenStatus() != h.f6577m) goto L25;
        AdapterView<?> r8 = r12.getAdapterView();
        if (r8 == null) goto L23;
        int r10 = r8.getPositionForView(r12);
        if (r10 == (-1)) goto L26;
        long r11 = r8.getItemIdAtPosition(r10);
        Method r13 = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});     // Catch: Exception -> L13
        r13.setAccessible(true);     // Catch: Exception -> L13
        ((Boolean) r13.invoke(r8, new Object[]{r12, Integer.valueOf(r10), Long.valueOf(r11)})).booleanValue();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        if (r8.getOnItemLongClickListener() == null) goto L17;
        boolean r14 = r8.getOnItemLongClickListener().onItemLongClick(r8, r12, r10, r11);
    L18:
        if (r14 == false) goto L24;
        r8.performHapticFeedback(0);
        return;
    L24:
        return;
    L17:
        r14 = false;
        goto L18
    L26:
        return;
    L23:
        return;
    }

    private void setCurrentDragEdge(e r8) {
        this.f6554r = r8;
        o();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r8, int r10, ViewGroup.LayoutParams r11) {
        if (r8 != null) goto L34;
        return;
    L34:
        int r12 = ((Integer) r11.getClass().getField("gravity").get(r11)).intValue();     // Catch: Exception -> L6
    L8:
        LinkedHashMap<e, View> r13 = this.f6557u;
        if (r12 <= 0) goto L22;
        WeakHashMap<View, h0> r14 = w.f8437a;
        int r15 = Gravity.getAbsoluteGravity(r12, w.e.d(this));
        if ((r15 & 3) != 3) goto L14;
        r13.put(e.f6567a, r8);
    L14:
        if ((r15 & 5) != 5) goto L17;
        r13.put(e.f6569m, r8);
    L17:
        if ((r15 & 48) != 48) goto L20;
        r13.put(e.f6568b, r8);
    L20:
        if ((r15 & 80) != 80) goto L30;
        e r16 = e.f6570n;
    L28:
        r13.put(r16, r8);
    L30:
        if (r8.getParent() != this) goto L32;
        return;
    L32:
        super.addView(r8, r10, r11);
        return;
    L22:
        Iterator<Map.Entry<e, View>> r17 = r13.entrySet().iterator();
    L24:
        if (r17.hasNext() == false) goto L30;
        Map.Entry<e, View> r18 = r17.next();
        if (r18.getValue() != null) goto L24;
        r16 = r18.getKey();
    L6:
        e = move-exception;
        e.printStackTrace();
        r12 = 0;
        goto L8
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f6555s.g() == false) goto L6;
        WeakHashMap<View, h0> r8 = w.f8437a;
        w.d.k(this);
        return;
    }

    public List<View> getBottomViews() {
        ArrayList r8 = new ArrayList();
        e[] r10 = e.values();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        e r13 = r10[r12];
        r8.add(this.f6557u.get(r13));
        r12 = r12 + 1;
        goto L3
    L5:
        return r8;
    }

    public View getCurrentBottomView() {
        List<View> r8 = getBottomViews();
        if (this.f6554r.ordinal() < r8.size()) goto L5;
        return null;
    L5:
        return r8.get(this.f6554r.ordinal());
    }

    public int getDragDistance() {
        return this.f6556t;
    }

    public e getDragEdge() {
        return this.f6554r;
    }

    public Map<e, View> getDragEdgeMap() {
        return this.f6557u;
    }

    @Deprecated
    public List<e> getDragEdges() {
        return new ArrayList(this.f6557u.keySet());
    }

    public h getOpenStatus() {
        View r8 = getSurfaceView();
        if (r8 == null) goto L5;
        int r10 = r8.getLeft();
        int r11 = r8.getTop();
        if (r10 != getPaddingLeft()) goto L13;
        if (r11 != getPaddingTop()) goto L13;
        return h.f6577m;
    L13:
        if (r10 == (getPaddingLeft() - this.f6556t)) goto L24;
        if (r10 == (getPaddingLeft() + this.f6556t)) goto L24;
        if (r11 == (getPaddingTop() - this.f6556t)) goto L24;
        if (r11 == (getPaddingTop() + this.f6556t)) goto L24;
        return h.f6575a;
    L24:
        return h.f6576b;
    L5:
        return h.f6577m;
    }

    public g getShowMode() {
        return this.f6558v;
    }

    public View getSurfaceView() {
        if (getChildCount() != 0) goto L7;
        return null;
    L7:
        return getChildAt(getChildCount() - 1);
    }

    public float getWillOpenPercentAfterClose() {
        return this.G;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.F;
    }

    public final void i(MotionEvent r14) {
        if (this.I == false) goto L5;
        return;
    L5:
        h r8 = getOpenStatus();
        h r10 = h.f6575a;
        if (r8 != r10) goto L9;
        this.I = true;
        return;
    L9:
        h r11 = getOpenStatus();
        float r12 = r14.getRawX() - this.J;
        float r15 = r14.getRawY() - this.K;
        float r13 = (float) Math.toDegrees(Math.atan(Math.abs(r15 / r12)));
        h r16 = getOpenStatus();
        h r17 = h.f6577m;
        boolean r18 = false;
        if (r16 != r17) goto L71;
        boolean[] r19 = this.D;
        LinkedHashMap<e, View> r20 = this.f6557u;
        if (r13 >= 45.0f) goto L43;
        if (r12 <= 0.0f) goto L28;
        e r21 = e.f6567a;
        View r110 = r20.get(r21);
        if (r110 != null) goto L18;
    L24:
        boolean r111 = false;
    L25:
        if (r111 == false) goto L28;
    L69:
        setCurrentDragEdge(r21);
        goto L71
    L18:
        if (r110.getParent() != this) goto L24;
        if (r110 == getSurfaceView()) goto L24;
        if (r19[0] == false) goto L24;
        r111 = true;
    L28:
        if (r12 >= 0.0f) goto L41;
        r21 = e.f6569m;
        View r22 = r20.get(r21);
        if (r22 != null) goto L32;
    L38:
        boolean r23 = false;
    L39:
        if (r23 == true) goto L69;
        return;
    L32:
        if (r22.getParent() != this) goto L38;
        if (r22 == getSurfaceView()) goto L38;
        if (r19[2] == false) goto L38;
        r23 = true;
        goto L39
    L41:
        return;
    L43:
        if (r15 <= 0.0f) goto L57;
        r21 = e.f6568b;
        View r112 = r20.get(r21);
        if (r112 != null) goto L47;
    L53:
        boolean r113 = false;
    L54:
        if (r113 == false) goto L57;
    L47:
        if (r112.getParent() != this) goto L53;
        if (r112 == getSurfaceView()) goto L53;
        if (r19[1] == false) goto L53;
        r113 = true;
    L57:
        if (r15 >= 0.0f) goto L70;
        r21 = e.f6570n;
        View r24 = r20.get(r21);
        if (r24 != null) goto L61;
    L67:
        boolean r25 = false;
    L68:
        if (r25 == true) goto L69;
        return;
    L61:
        if (r24.getParent() != this) goto L67;
        if (r24 == getSurfaceView()) goto L67;
        if (r19[3] == false) goto L67;
        r25 = true;
        goto L68
    L70:
        return;
    L71:
        e r26 = this.f6554r;
        e r27 = e.f6569m;
        int r114 = this.f6553q;
        if (r26 == r27) goto L74;
    L91:
        boolean r28 = false;
    L93:
        if (r26 != e.f6567a) goto L113;
        if (r11 == h.f6576b) goto L97;
    L98:
        if (r11 == r17) goto L100;
    L102:
        boolean r29 = false;
    L103:
        if (r29 == true) goto L107;
        if (r11 == r10) goto L107;
        boolean r30 = false;
    L109:
        if (r13 > 30.0f) goto L111;
        if (r30 == true) goto L113;
    L111:
        r28 = true;
    L107:
        r30 = true;
        goto L109
    L100:
        if (r12 <= r114) goto L102;
    L101:
        r29 = true;
        goto L103
    L97:
        if (r12 < (-r114)) goto L101;
    L113:
        if (r26 != e.f6568b) goto L133;
        if (r11 == h.f6576b) goto L117;
    L118:
        if (r11 == r17) goto L120;
    L122:
        boolean r31 = false;
    L123:
        if (r31 == true) goto L127;
        if (r11 == r10) goto L127;
        boolean r32 = false;
    L129:
        if (r13 < 60.0f) goto L131;
        if (r32 == true) goto L133;
    L131:
        r28 = true;
    L127:
        r32 = true;
        goto L129
    L120:
        if (r15 <= r114) goto L122;
    L121:
        r31 = true;
        goto L123
    L117:
        if (r15 < (-r114)) goto L121;
    L133:
        if (r26 == e.f6570n) goto L135;
    L150:
        this.I = !r28;
        return;
    L135:
        if (r11 == h.f6576b) goto L137;
    L138:
        if (r11 == r17) goto L140;
    L142:
        boolean r115 = false;
    L143:
        if (r115 == true) goto L145;
        if (r11 == r10) goto L145;
    L147:
        if (r13 < 60.0f) goto L149;
        if (r18 == true) goto L150;
    L149:
        r28 = true;
    L145:
        r18 = true;
        goto L147
    L140:
        if (r15 >= (-r114)) goto L142;
    L141:
        r115 = true;
        goto L143
    L137:
        if (r15 > r114) goto L141;
    L74:
        if (r11 == h.f6576b) goto L76;
    L77:
        if (r11 == r17) goto L79;
    L81:
        boolean r33 = false;
    L82:
        if (r33 == true) goto L86;
        if (r11 == r10) goto L86;
        boolean r34 = false;
    L88:
        if (r13 > 30.0f) goto L90;
        if (r34 == true) goto L91;
    L90:
        r28 = true;
    L86:
        r34 = true;
        goto L88
    L79:
        if (r12 >= (-r114)) goto L81;
    L80:
        r33 = true;
        goto L82
    L76:
        if (r12 > r114) goto L80;
        goto L77
    }

    public final Rect j(g r8, Rect r10) {
        View r11 = getCurrentBottomView();
        int r12 = r10.left;
        int r13 = r10.top;
        int r14 = r10.right;
        int r15 = r10.bottom;
        if (r8 != g.f6573b) goto L27;
        e r16 = this.f6554r;
        e r17 = e.f6567a;
        if (r16 != r17) goto L8;
        r12 = r12 - this.f6556t;
    L14:
        int r18 = 0;
        if (r16 != r17) goto L17;
    L23:
        if (r11 == null) goto L31;
        r18 = r11.getMeasuredWidth();
    L31:
        r14 = r12 + r18;
    L40:
        return new Rect(r12, r13, r14, r15);
    L17:
        if (r16 == e.f6569m) goto L23;
        if (r11 == null) goto L22;
        r18 = r11.getMeasuredHeight();
    L22:
        r15 = r13 + r18;
        r14 = r10.right;
        goto L40
    L8:
        if (r16 != e.f6569m) goto L11;
        r12 = r14;
        goto L14
    L11:
        if (r16 != e.f6568b) goto L13;
        r13 = r13 - this.f6556t;
        goto L14
    L13:
        r13 = r15;
        goto L14
    L27:
        if (r8 != g.f6572a) goto L40;
        e r19 = this.f6554r;
        if (r19 != e.f6567a) goto L33;
        r18 = this.f6556t;
        goto L31
    L33:
        if (r19 != e.f6569m) goto L35;
        r12 = r14 - this.f6556t;
        goto L40
    L35:
        e r20 = e.f6568b;
        int r21 = this.f6556t;
        if (r19 != r20) goto L38;
        r15 = r13 + r21;
        goto L40
    L38:
        r13 = r15 - r21;
        goto L40
    }

    public final Rect k(boolean r8) {
        int r10 = getPaddingLeft();
        int r11 = getPaddingTop();
        if (r8 == false) goto L15;
        e r12 = this.f6554r;
        if (r12 != e.f6567a) goto L8;
        int r13 = getPaddingLeft();
        r10 = this.f6556t + r13;
        goto L15
    L8:
        if (r12 != e.f6569m) goto L11;
        r10 = getPaddingLeft() - this.f6556t;
        goto L15
    L11:
        if (r12 != e.f6568b) goto L13;
        int r14 = getPaddingTop();
        r11 = this.f6556t + r14;
        goto L15
    L13:
        r11 = getPaddingTop() - this.f6556t;
    L15:
        return new Rect(r10, r11, getMeasuredWidth() + r10, getMeasuredHeight() + r11);
    }

    public final int l(float r8) {
        return (int) ((r8 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final boolean m(MotionEvent r8) {
        View r10 = getSurfaceView();
        if (r10 != null) goto L7;
        return false;
    L7:
        if (this.N != null) goto L9;
        this.N = new Rect();
    L9:
        r10.getHitRect(this.N);
        return this.N.contains((int) r8.getX(), (int) r8.getY());
    }

    public final void n() {
        h r8 = getOpenStatus();
        List<View> r10 = getBottomViews();
        if (r8 != h.f6577m) goto L12;
        Iterator<View> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L27;
        View r12 = r11.next();
        if (r12 == null) goto L6;
        if (r12.getVisibility() == 4) goto L6;
        r12.setVisibility(4);
        goto L6
    L27:
        return;
    L12:
        View r13 = getCurrentBottomView();
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.getVisibility() == 0) goto L26;
        r13.setVisibility(0);
        return;
    }

    public final void o() {
        View r8 = getCurrentBottomView();
        if (r8 == null) goto L12;
        e r10 = this.f6554r;
        if (r10 != e.f6567a) goto L7;
    L10:
        int r11 = r8.getMeasuredWidth();
    L11:
        this.f6556t = r11 - l(getCurrentOffset());
        goto L12
    L7:
        if (r10 == e.f6569m) goto L10;
        r11 = r8.getMeasuredHeight();
    L12:
        g r12 = this.f6558v;
        g r13 = g.f6573b;
        boolean r14 = false;
        if (r12 != r13) goto L23;
        View r15 = getSurfaceView();
        if (getOpenStatus() == h.f6577m) goto L17;
        r14 = true;
    L17:
        Rect r16 = k(r14);
        if (r15 == null) goto L20;
        r15.layout(r16.left, r16.top, r16.right, r16.bottom);
        bringChildToFront(r15);
    L20:
        View r17 = getCurrentBottomView();
        Rect r18 = j(r13, r16);
        if (r17 == null) goto L35;
        r17.layout(r18.left, r18.top, r18.right, r18.bottom);
    L35:
        n();
        return;
    L23:
        g r19 = g.f6572a;
        if (r12 != r19) goto L35;
        View r20 = getSurfaceView();
        HashMap r21 = this.B;
        Rect r22 = (Rect) r21.get(r20);
        if (r22 != null) goto L28;
        r22 = k(false);
    L28:
        if (r20 == null) goto L30;
        r20.layout(r22.left, r22.top, r22.right, r22.bottom);
        bringChildToFront(r20);
    L30:
        View r23 = getCurrentBottomView();
        Rect r24 = (Rect) r21.get(r23);
        if (r24 != null) goto L33;
        r24 = j(r19, r22);
    L33:
        if (r23 == null) goto L35;
        r23.layout(r24.left, r24.top, r24.right, r24.bottom);
        goto L35
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getAdapterView() == null) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L8;
        return;
    L8:
        if (this.L != null) goto L11;
        setOnClickListener(new b(this));
    L11:
        if (this.M != null) goto L15;
        setOnLongClickListener(new c(this));
        return;
    L15:
        return;
    L5:
        r8 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r8) {
        if (this.C == true) goto L6;
        return false;
    L6:
        if (this.E == true) goto L8;
    L12:
        Iterator r10 = this.f6561y.iterator();
    L14:
        if (r10.hasNext() == false) goto L20;
        i r11 = (i) r10.next();
        if (r11 == null) goto L14;
        if (r11.a() == false) goto L14;
        return false;
    L20:
        int r12 = r8.getAction();
        o0.c r13 = this.f6555s;
        if (r12 == 0) goto L39;
        if (r12 != 1) goto L24;
    L37:
        this.I = false;
    L38:
        r13.k(r8);
    L43:
        return this.I;
    L24:
        if (r12 != 2) goto L26;
        boolean r14 = this.I;
        i(r8);
        if (this.I == false) goto L33;
        ViewParent r15 = getParent();
        if (r15 == null) goto L33;
        r15.requestDisallowInterceptTouchEvent(true);
    L33:
        if (r14 == true) goto L43;
        if (this.I == false) goto L43;
        return false;
    L26:
        if (r12 == 3) goto L37;
    L39:
        r13.k(r8);
        this.I = false;
        this.J = r8.getRawX();
        this.K = r8.getRawY();
        if (getOpenStatus() != h.f6575a) goto L43;
        this.I = true;
        goto L43
    L8:
        if (getOpenStatus() != h.f6576b) goto L12;
        if (m(r8) == false) goto L12;
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        o();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r8) {
        if (this.C == false) goto L5;
        int r10 = r8.getActionMasked();
        this.O.onTouchEvent(r8);
        o0.c r11 = this.f6555s;
        if (r10 == 0) goto L16;
        if (r10 != 1) goto L10;
    L14:
        this.I = false;
    L15:
        r11.k(r8);
    L21:
        if (super.onTouchEvent(r8) == true) goto L26;
        if (this.I == true) goto L26;
        if (r10 == 0) goto L26;
        return false;
    L26:
        return true;
    L10:
        if (r10 != 2) goto L12;
    L17:
        i(r8);
        if (this.I == false) goto L21;
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L15
    L12:
        if (r10 == 3) goto L14;
    L16:
        r11.k(r8);
        this.J = r8.getRawX();
        this.K = r8.getRawY();
        goto L17
    L5:
        return super.onTouchEvent(r8);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r8) {
        LinkedHashMap<e, View> r10 = this.f6557u;
        Iterator r11 = new HashMap(r10).entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Map.Entry r12 = (Map.Entry) r11.next();
        if (r12.getValue() != r8) goto L4;
        r10.remove(r12.getKey());
        goto L4
    }

    public void setBottomSwipeEnabled(boolean r8) {
        e r10 = e.f6567a;
        this.D[3] = r8;
    }

    public void setClickToClose(boolean r8) {
        this.E = r8;
    }

    public void setDragDistance(int r8) {
        if (r8 >= 0) goto L4;
        r8 = 0;
    L4:
        this.f6556t = l(r8);
        requestLayout();
    }

    @Deprecated
    public void setDragEdge(e r8) {
        LinkedHashMap<e, View> r10 = this.f6557u;
        r10.clear();
        if (getChildCount() < 2) goto L5;
        r10.put(r8, getChildAt(getChildCount() - 2));
    L5:
        setCurrentDragEdge(r8);
    }

    @Deprecated
    public void setDragEdges(List<e> r8) {
        LinkedHashMap<e, View> r10 = this.f6557u;
        r10.clear();
        int r11 = Math.min(r8.size(), getChildCount() - 1);
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r10.put(r8.get(r12), getChildAt(r12));
        r12 = r12 + 1;
        goto L3
    L5:
        int r13 = r8.size();
        e r14 = P;
        if (r13 != 0) goto L8;
    L11:
        setCurrentDragEdge(r14);
        return;
    L8:
        if (r8.contains(r14) == true) goto L11;
        setCurrentDragEdge(r8.get(0));
    }

    public void setLeftSwipeEnabled(boolean r8) {
        e r10 = e.f6567a;
        this.D[0] = r8;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r8) {
        super.setOnClickListener(r8);
        this.L = r8;
    }

    public void setOnDoubleClickListener(d r8) {
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener r8) {
        super.setOnLongClickListener(r8);
        this.M = r8;
    }

    public void setRightSwipeEnabled(boolean r8) {
        e r10 = e.f6567a;
        this.D[2] = r8;
    }

    public void setShowMode(g r8) {
        this.f6558v = r8;
        requestLayout();
    }

    public void setSwipeEnabled(boolean r8) {
        this.C = r8;
    }

    public void setTopSwipeEnabled(boolean r8) {
        e r10 = e.f6567a;
        this.D[1] = r8;
    }

    public void setWillOpenPercentAfterClose(float r8) {
        this.G = r8;
    }

    public void setWillOpenPercentAfterOpen(float r8) {
        this.F = r8;
    }

    @Deprecated
    public void setDragEdges(e... r8) {
        this.f6557u.clear();
        setDragEdges(Arrays.asList(r8));
    }
}
