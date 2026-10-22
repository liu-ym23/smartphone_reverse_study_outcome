package com.lynx.tasm.behavior.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.behavior.y0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UIShadowProxy extends UIGroup<d0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxBaseUI f10388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f10389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b0 f10390c;
    public final Matrix d;
    public boolean e;

    public UIShadowProxy(com.lynx.tasm.b0 r5, LynxBaseUI r10) {
        super(r5, null);
        this.d = new Matrix();
        int r11 = 0;
        this.e = false;
        this.mOverflow = 3;
        this.f10388a = r10;
        r10.setParent(this);
        setSign(r10.getSign(), r10.getTagName());
        initialize();
        onInsertChild(r10, 0);
        super.insertDrawList(null, r10);
        super.insertView((LynxUI) r10);
        r10.getTransformRaws();
        if (r10.getVisibility() == true) goto L6;
        r11 = 4;
    L6:
        setVisibilityForView(r11);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean checkStickyOnParentScroll(int r5, int r10) {
        boolean r11 = this.f10388a.checkStickyOnParentScroll(r5, r10);
        if (r11 == false) goto L5;
        invalidate();
    L5:
        return r11;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean childrenContainPoint(float r5, float r10) {
        LynxBaseUI r11 = this.f10388a;
        if (r11 != null) goto L7;
        return false;
    L7:
        return r11.childrenContainPoint(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean containsPoint(float r5, float r10) {
        return containsPoint(r5, r10, false);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        return new d0(this, r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean enableLayoutAnimation() {
        return this.f10388a.enableLayoutAnimation();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getAlpha() {
        LynxBaseUI r5 = this.f10388a;
        if ((r5 instanceof LynxUI) == true) goto L5;
        return 1.0f;
    L5:
        return ((LynxUI) r5).getView().getAlpha();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBound() {
        return this.f10388a.getBound();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final Rect getBoundRectForOverflow() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final LynxBaseUI getChildAt(int r5) {
        return this.f10388a.mChildren.get(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final int getChildCount() {
        LynxBaseUI r5 = this.f10388a;
        if ((r5 instanceof UIGroup) == true) goto L5;
        return 0;
    L5:
        return ((UIGroup) r5).getChildCount();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final List getChildren() {
        return this.f10388a.getChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getHeight() {
        return this.f10388a.getHeight();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final String getIdSelector() {
        LynxBaseUI r5 = this.f10388a;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getIdSelector();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final um.e getLayoutAnimator() {
        return this.f10388a.getLayoutAnimator();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getLeft() {
        return this.f10388a.getLeft();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getOriginLeft() {
        return this.f10388a.getOriginLeft();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getOriginTop() {
        return this.f10388a.getOriginTop();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final JavaOnlyMap getProps() {
        return this.f10388a.getProps();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getRealTimeTranslationZ() {
        LynxBaseUI r5 = this.f10388a;
        if ((r5 instanceof LynxUI) == true) goto L5;
        return 0.0f;
    L5:
        return ((LynxUI) r5).getRealTimeTranslationZ();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final String getRefIdSelector() {
        LynxBaseUI r5 = this.f10388a;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getRefIdSelector();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final String getTagName() {
        LynxBaseUI r5 = this.f10388a;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.getTagName();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getTop() {
        return this.f10388a.getTop();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final i getTransformValue(float r5, float r10, float r11, float r12) {
        return this.f10388a.getTransformValue(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final vm.i getTransitionAnimator() {
        return this.f10388a.getTransitionAnimator();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final float getTranslationZ() {
        LynxBaseUI r5 = this.f10388a;
        if ((r5 instanceof LynxUI) == true) goto L5;
        return 0.0f;
    L5:
        return ((LynxUI) r5).getTranslationZ();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final int getWidth() {
        return this.f10388a.getWidth();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final wm.a hitTest(float r5, float r10) {
        return hitTest(r5, r10, false);
    }

    public final b0 i() {
        if (this.f10390c != null) goto L8;
        b0 r5 = new b0();
        r5.f10422b = null;
        r5.f10423c = 0.0f;
        r5.f10421a = BorderStyle.f10733h;
        r5.f10422b = Integer.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.f10390c = r5;
        T r10 = this.mView;
        if (r10 == 0) goto L8;
        ((d0) r10).f10448c = r5;
    L8:
        return this.f10390c;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        ViewCompat.setImportantForAccessibility(this.mView, 1);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        this.f10388a.insertChild(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void insertDrawList(LynxBaseUI r5, LynxBaseUI r10) {
        ((LynxUI) this.f10388a).insertDrawList(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void insertView(LynxUI r5) {
        ((UIGroup) this.f10388a).insertView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isFirstAnimatedReady() {
        return this.f10388a.isFirstAnimatedReady();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isFlatten() {
        return this.f10388a.isFlatten();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final boolean isInsertViewCalled() {
        LynxBaseUI r5 = this.f10388a;
        if ((r5 instanceof UIGroup) == false) goto L7;
        return ((UIGroup) r5).isInsertViewCalled();
    L7:
        return super.isInsertViewCalled();
    }

    public final void j() {
        UIShadowProxy r5 = this;
        LynxBaseUI r10 = r5.f10388a;
        com.lynx.tasm.behavior.ui.utils.d r11 = r10.getLynxBackground().n();
        int r12 = r10.getWidth();
        int r13 = r10.getHeight();
        if (r12 == 0) goto L154;
        if (r13 == 0) goto L154;
        if (r11 == null) goto L11;
        if (r12 <= 0) goto L10;
        if (r13 <= 0) goto L10;
        r11.a(r12, r13);
    L10:
        float[] r14 = r11.c();
    L12:
        if (r12 <= 0) goto L140;
        if (r13 <= 0) goto L140;
        Rect r15 = new Rect(r10.getLeft(), r10.getTop(), r10.getWidth() + r10.getLeft(), r10.getHeight() + r10.getTop());
        b0 r16 = r5.f10390c;
        if (r16 == null) goto L17;
        r16.d = r15;
    L17:
        d0 r17 = (d0) r5.mView;
        r17.f10448c = r16;
        ArrayList r18 = r5.f10389b;
        r17.f10447b = null;
        if (r18 == null) goto L140;
        if (r18.isEmpty() == false) goto L22;
        LynxBaseUI r28 = r10;
    L142:
        if (((d0) r5.mView).f10446a == true) goto L144;
    L152:
        ((d0) r5.mView).invalidate();
        return;
    L144:
        if (r28.getLynxBackground() == null) goto L148;
        com.lynx.tasm.behavior.ui.utils.f r19 = r28.getLynxBackground().f10750b;
        if (r19 == null) goto L148;
        com.lynx.component.svg.parser.d r20 = ((BackgroundDrawable) r19).A;
    L149:
        if (r20 != null) goto L151;
        d0 r21 = (d0) r5.mView;
        r20 = new com.lynx.component.svg.parser.d();
        r20.f9799c = r21;
        ((BackgroundDrawable) r28.getLynxBackground().d()).A = r20;
    L151:
        float r22 = r28.getLeft();
        float r23 = r28.getTop();
        r20.f9797a = r22;
        r20.f9798b = r23;
    L148:
        r20 = null;
        goto L149
    L22:
        r17.f10447b = new ArrayList();
        Iterator r24 = r18.iterator();
    L24:
        if (r24.hasNext() == false) goto L138;
        r r25 = (r) r24.next();
        c0 r26 = new c0();
        r26.f10434k = r25;
        float[] r27 = r26.f10433j;
        if (r14 != null) goto L28;
    L30:
        Arrays.fill(r27, 0.0f);
    L31:
        float[] r110 = r26.f10432i;
        System.arraycopy(r27, 0, r110, 0, 8);
        RectF r111 = r26.g;
        r111.set(r15);
        RectF r112 = r26.f10431h;
        r112.set(r15);
        r r113 = r26.f10434k;
        if (r113 == null) goto L77;
        float r29 = r113.e - (r113.d / 2.0f);
        if (r113.b() == false) goto L36;
        int r114 = 1;
    L37:
        float r30 = r29 * r114;
        if (r30 <= 0.0f) goto L42;
        float r115 = Math.min(r111.width(), r111.height()) / 2.0f;
        if (r30 <= r115) goto L42;
        r30 = r115;
    L42:
        r111.inset(r30, r30);
        r r116 = r26.f10434k;
        r111.offset(r116.f10592b, r116.f10593c);
        int r117 = 0;
    L43:
        if (r117 >= 8) goto L46;
        r110[r117] = Math.max(r110[r117] - r30, 0.0f);
        r117 = r117 + 1;
        goto L43
    L46:
        if (com.lynx.tasm.utils.a.k(r111.width(), 0.0f) == true) goto L77;
        if (com.lynx.tasm.utils.a.k(r111.height(), 0.0f) == true) goto L77;
        if ((r110[0] + r110[2]) <= r111.width()) goto L55;
        float r118 = r111.width() / (r110[0] + r110[2]);
        if (r118 >= 1.0f) goto L55;
    L57:
        if ((r110[4] + r110[6]) <= r111.width()) goto L62;
        float r31 = r111.width() / (r110[4] + r110[6]);
        if (r31 >= r118) goto L62;
        r118 = r31;
    L62:
        if ((r110[1] + r110[7]) <= r111.height()) goto L67;
        float r210 = r111.height() / (r110[1] + r110[7]);
        if (r210 >= r118) goto L67;
        r118 = r210;
    L67:
        if ((r110[3] + r110[5]) <= r111.height()) goto L72;
        float r32 = r111.height() / (r110[3] + r110[5]);
        if (r32 >= r118) goto L72;
        r118 = r32;
    L72:
        if (r118 >= 1.0f) goto L77;
        int r33 = 0;
    L74:
        if (r33 >= 8) goto L77;
        r110[r33] = r110[r33] * r118;
        r33 = r33 + 1;
    L55:
        r118 = 1.0f;
        goto L57
    L36:
        r114 = -1;
    L77:
        if (r26.f10434k == null) goto L130;
        Path r34 = r26.f10437n;
        r26.c(r34, r110[0], r110[1]);
        Path r35 = r26.f10440q;
        r26.c(r35, r110[2], r110[3]);
        Path r119 = r26.f10438o;
        r26.c(r119, r110[4], r110[5]);
        Path r120 = r26.f10439p;
        float[] r211 = r14;
        r26.c(r120, r110[6], r110[7]);
        r r36 = r26.f10434k;
        float r121 = r36.f;
        Rect r212 = r15;
        Iterator r213 = r24;
        LynxBaseUI r214 = r10;
        int[] r37 = {Color.alpha(r36.f10591a), Color.red(r26.f10434k.f10591a), Color.green(r26.f10434k.f10591a), Color.blue(r26.f10434k.f10591a)};
        Paint r38 = r26.f10428a;
        r38.setColor(r26.f10434k.f10591a);
        int r39 = 10;
        int[] r40 = new int[10];
        int r41 = 0;
    L79:
        double[] r215 = c0.f10427v;
        if (r41 >= r39) goto L82;
        r40[r41] = Color.argb((int) (((double) r37[0]) * r215[r41]), r37[1], r37[2], r37[3]);
        r41 = r41 + 1;
        r35 = r35;
        r120 = r120;
        r17 = r17;
        r39 = 10;
        goto L79
    L82:
        d0 r310 = r17;
        Path r311 = r35;
        Path r312 = r120;
        Paint r42 = r26.f;
        if (r26.f10434k.b() == true) goto L86;
        r121 = -r121;
    L86:
        r42.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r121, r40, null, Shader.TileMode.CLAMP));
        r26.b(r26.f10429b, r37, r110[0], r110[1]);
        r26.b(r26.f10430c, r37, r110[2], r110[3]);
        r26.b(r26.e, r37, r110[4], r110[5]);
        r26.b(r26.d, r37, r110[6], r110[7]);
        Path r43 = new Path();
        Path r44 = new Path();
        Path r45 = new Path();
        Path r46 = new Path();
        Path r47 = r26.f10435l;
        r47.reset();
        Path r48 = r26.f10436m;
        r48.reset();
        Path.Direction r122 = Path.Direction.CW;
        r47.addRoundRect(r111, r110, r122);
        r48.addRoundRect(r112, r27, r122);
        if (r26.f10434k.b() == false) goto L89;
        Path.Op r49 = Path.Op.REVERSE_DIFFERENCE;
    L90:
        r47.op(r48, r49);
        r38.setColor(r26.f10434k.f10591a);
        r43.reset();
        r43.set(r48);
        r43.offset(-r111.left, -r111.top);
        Matrix r50 = new Matrix();
        r44.reset();
        r44.set(r48);
        r50.reset();
        r50.preRotate(-180.0f);
        r50.preTranslate(-r111.right, -r111.bottom);
        r44.transform(r50);
        r45.reset();
        r45.set(r48);
        r50.reset();
        r50.preRotate(-270.0f);
        r50.preTranslate(-r111.left, -r111.bottom);
        r45.transform(r50);
        r46.reset();
        r46.set(r48);
        r50.reset();
        r50.preRotate(-90.0f);
        r50.preTranslate(-r111.right, -r111.top);
        r46.transform(r50);
        if (r26.f10434k.b() == false) goto L93;
        Path.Op r51 = Path.Op.INTERSECT;
    L95:
        if (r34.isEmpty() == true) goto L98;
        r34.op(r43, r51);
    L98:
        if (r119.isEmpty() == true) goto L101;
        r119.op(r44, r51);
    L101:
        if (r312.isEmpty() == true) goto L104;
        r312.op(r45, r51);
    L104:
        if (r311.isEmpty() == true) goto L106;
        r311.op(r46, r51);
    L106:
        Path r52 = r26.f10441r;
        r52.reset();
        Path r53 = r26.s;
        r53.reset();
        Path r54 = r26.f10442t;
        r54.reset();
        Path r55 = r26.f10443u;
        r55.reset();
        if (r26.f10434k.b() == false) goto L109;
        float r56 = 0.0f;
    L111:
        if (r26.f10434k.b() == false) goto L113;
        float r216 = r26.f10434k.f;
        char r123 = 0;
    L114:
        float r313 = r56;
        float r314 = r216;
        r52.addRect(r110[r123], r313, r111.width() - r110[2], r314, r122);
        r53.addRect(r110[4], r313, r111.width() - r110[6], r314, r122);
        r54.addRect(r110[7], r313, r111.height() - r110[1], r314, r122);
        r55.addRect(r110[3], r313, r111.height() - r110[5], r314, r122);
        if (r26.f10434k.b() == false) goto L117;
        Path.Op r57 = Path.Op.INTERSECT;
    L119:
        if (r52.isEmpty() == true) goto L122;
        r52.op(r43, r57);
    L122:
        if (r53.isEmpty() == true) goto L125;
        r53.op(r44, r57);
    L125:
        if (r54.isEmpty() == true) goto L128;
        r54.op(r45, r57);
    L128:
        if (r55.isEmpty() == true) goto L131;
        r55.op(r46, r57);
    L131:
        r r58 = r26.f10434k;
        if (r58 != null) goto L134;
    L136:
        r17 = r310;
    L137:
        r17.f10447b.add(r26);
        r14 = r211;
        r15 = r212;
        r24 = r213;
        r10 = r214;
        goto L24
    L134:
        if (r58.b() == false) goto L136;
        r17 = r310;
        r17.f10446a = true;
        goto L137
    L117:
        r57 = Path.Op.DIFFERENCE;
        goto L119
    L113:
        r123 = 0;
        r216 = 0.0f;
        goto L114
    L109:
        r56 = -r26.f10434k.f;
        goto L111
    L93:
        r51 = Path.Op.DIFFERENCE;
        goto L95
    L89:
        r49 = Path.Op.DIFFERENCE;
        goto L90
    L130:
        r214 = r10;
        r211 = r14;
        r212 = r15;
        r213 = r24;
        r310 = r17;
        goto L131
    L28:
        if (r14.length != 8) goto L30;
        System.arraycopy(r14, 0, r27, 0, 8);
        goto L31
    L138:
        r28 = r10;
        r17.invalidate();
    L139:
        r5 = this;
    L140:
        r28 = r10;
        goto L139
    L11:
        r14 = null;
    L154:
        d0 r59 = (d0) r5.mView;
        ArrayList r60 = r59.f10447b;
        if (r60 == null) goto L157;
        r60.clear();
    L157:
        r59.invalidate();
        ((d0) r5.mView).f10448c = null;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        View r5 = (View) ((d0) this.mView).getParent();
        if (r5 == null) goto L13;
        ((d0) this.mView).layout(0, 0, r5.getWidth(), r5.getHeight());
        if ((((d0) this.mView).getParent() instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) ((d0) this.mView).getParent()).setClipChildren(false);
        ViewCompat.setClipBounds(this.mView, null);
    L8:
        LynxBaseUI r10 = this.f10388a;
        if ((r10 instanceof LynxUI) == false) goto L12;
        ((LynxUI) r10).layout();
        return;
    L12:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        this.f10388a.measure();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDrawingPositionChanged() {
        super.onDrawingPositionChanged();
        this.e = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        this.e = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onPropsUpdated() {
        LynxBaseUI r5 = this.f10388a;
        if (r5 == null) goto L5;
        r5.onPropsUpdated();
    L5:
        super.onPropsUpdated();
        this.e = true;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        this.f10388a.removeChild(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeView(LynxBaseUI r5) {
        ((UIGroup) this.f10388a).removeView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setBound(Rect r5) {
        this.f10388a.setBound(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setBoxShadow(ReadableArray r5) {
        this.f10389b = r.a(r5);
        j();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setLeft(int r5) {
        this.f10388a.setLeft(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOutlineColor(int r5) {
        b0 r10 = i();
        r10.f10422b = Integer.valueOf(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setOutlineWidth(float r5) {
        i().f10423c = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setTop(int r5) {
        this.f10388a.setTop(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean updateDrawingLayoutInfo(int r5, int r10, Rect r11) {
        if (this.f10388a.updateDrawingLayoutInfo(r5, r10, r11) == false) goto L6;
        this.e = true;
        invalidate();
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r5) {
        this.f10388a.updateExtraData(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, int r35, Rect r36) {
        this.f10388a.updateLayout(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36);
        this.e = true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayoutInfo(LynxBaseUI r5) {
        this.f10388a.updateLayoutInfo(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(y0 r5) {
        this.f10388a.updateProperties(r5);
        onPropsUpdated();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateSticky(float[] r5) {
        this.f10388a.updateSticky(r5);
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean containsPoint(float r5, float r10, boolean r11) {
        LynxBaseUI r12 = this.f10388a;
        if (r12 != null) goto L7;
        return false;
    L7:
        return r12.containsPoint(r5, r10, r11);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final wm.a hitTest(float r5, float r10, boolean r11) {
        LynxBaseUI r12 = this.f10388a;
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.hitTest(r5, r10, r11);
    }
}
