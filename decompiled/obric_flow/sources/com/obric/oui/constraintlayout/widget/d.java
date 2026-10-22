package com.obric.oui.constraintlayout.widget;

import ai.j0;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import gr.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import lr.f;
import lr.g;
import lr.h;
import lr.i;
import lr.j;
import lr.m;
import org.xmlpull.v1.XmlPullParserException;
import ym.k;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f13066h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SparseIntArray f13067i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f13068j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f13070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f13071c;
    public int d;
    public final HashMap e;
    public boolean f;
    public final HashMap g;

    static {
        f13066h = new int[]{0, 4, 8};
        SparseIntArray r5 = new SparseIntArray();
        f13067i = r5;
        SparseIntArray r10 = new SparseIntArray();
        f13068j = r10;
        r5.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        r5.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        r5.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        r5.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        r5.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        r5.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        r5.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        r5.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        r5.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        r5.append(R$styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        r5.append(R$styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        r5.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        r5.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        r5.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        r5.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        r5.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        r5.append(R$styleable.Constraint_guidelineUseRtl, 99);
        r5.append(R$styleable.Constraint_android_orientation, 27);
        r5.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        r5.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        r5.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        r5.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        r5.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        r5.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        r5.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        r5.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        r5.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        r5.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        r5.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        r5.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        r5.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        r5.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        r5.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        r5.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        r5.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        r5.append(R$styleable.Constraint_layout_constraintLeft_creator, 87);
        r5.append(R$styleable.Constraint_layout_constraintTop_creator, 87);
        r5.append(R$styleable.Constraint_layout_constraintRight_creator, 87);
        r5.append(R$styleable.Constraint_layout_constraintBottom_creator, 87);
        r5.append(R$styleable.Constraint_layout_constraintBaseline_creator, 87);
        r5.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        r5.append(R$styleable.Constraint_android_layout_marginRight, 28);
        r5.append(R$styleable.Constraint_android_layout_marginStart, 31);
        r5.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        r5.append(R$styleable.Constraint_android_layout_marginTop, 34);
        r5.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        r5.append(R$styleable.Constraint_android_layout_width, 23);
        r5.append(R$styleable.Constraint_android_layout_height, 21);
        r5.append(R$styleable.Constraint_layout_constraintWidth, 95);
        r5.append(R$styleable.Constraint_layout_constraintHeight, 96);
        r5.append(R$styleable.Constraint_android_visibility, 22);
        r5.append(R$styleable.Constraint_android_alpha, 43);
        r5.append(R$styleable.Constraint_android_elevation, 44);
        r5.append(R$styleable.Constraint_android_rotationX, 45);
        r5.append(R$styleable.Constraint_android_rotationY, 46);
        r5.append(R$styleable.Constraint_android_rotation, 60);
        r5.append(R$styleable.Constraint_android_scaleX, 47);
        r5.append(R$styleable.Constraint_android_scaleY, 48);
        r5.append(R$styleable.Constraint_android_transformPivotX, 49);
        r5.append(R$styleable.Constraint_android_transformPivotY, 50);
        r5.append(R$styleable.Constraint_android_translationX, 51);
        r5.append(R$styleable.Constraint_android_translationY, 52);
        r5.append(R$styleable.Constraint_android_translationZ, 53);
        r5.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        r5.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        r5.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        r5.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        r5.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        r5.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        r5.append(R$styleable.Constraint_layout_constraintCircle, 61);
        r5.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        r5.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        r5.append(R$styleable.Constraint_animateRelativeTo, 64);
        r5.append(R$styleable.Constraint_transitionEasing, 65);
        r5.append(R$styleable.Constraint_drawPath, 66);
        r5.append(R$styleable.Constraint_transitionPathRotate, 67);
        r5.append(R$styleable.Constraint_motionStagger, 79);
        r5.append(R$styleable.Constraint_android_id, 38);
        r5.append(R$styleable.Constraint_motionProgress, 68);
        r5.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        r5.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        r5.append(R$styleable.Constraint_layout_wrapBehaviorInParent, 97);
        r5.append(R$styleable.Constraint_chainUseRtl, 71);
        r5.append(R$styleable.Constraint_barrierDirection, 72);
        r5.append(R$styleable.Constraint_barrierMargin, 73);
        r5.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        r5.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        r5.append(R$styleable.Constraint_pathMotionArc, 76);
        r5.append(R$styleable.Constraint_layout_constraintTag, 77);
        r5.append(R$styleable.Constraint_visibilityMode, 78);
        r5.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        r5.append(R$styleable.Constraint_layout_constrainedHeight, 81);
        r5.append(R$styleable.Constraint_polarRelativeTo, 82);
        r5.append(R$styleable.Constraint_transformPivotTarget, 83);
        r5.append(R$styleable.Constraint_quantizeMotionSteps, 84);
        r5.append(R$styleable.Constraint_quantizeMotionPhase, 85);
        r5.append(R$styleable.Constraint_quantizeMotionInterpolator, 86);
        r10.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 6);
        r10.append(R$styleable.ConstraintOverride_layout_editor_absoluteY, 7);
        r10.append(R$styleable.ConstraintOverride_android_orientation, 27);
        r10.append(R$styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        r10.append(R$styleable.ConstraintOverride_layout_goneMarginTop, 16);
        r10.append(R$styleable.ConstraintOverride_layout_goneMarginRight, 14);
        r10.append(R$styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        r10.append(R$styleable.ConstraintOverride_layout_goneMarginStart, 15);
        r10.append(R$styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        r10.append(R$styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        r10.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        r10.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        r10.append(R$styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        r10.append(R$styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        r10.append(R$styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        r10.append(R$styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        r10.append(R$styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        r10.append(R$styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        r10.append(R$styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        r10.append(R$styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        r10.append(R$styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        r10.append(R$styleable.ConstraintOverride_android_layout_marginLeft, 24);
        r10.append(R$styleable.ConstraintOverride_android_layout_marginRight, 28);
        r10.append(R$styleable.ConstraintOverride_android_layout_marginStart, 31);
        r10.append(R$styleable.ConstraintOverride_android_layout_marginEnd, 8);
        r10.append(R$styleable.ConstraintOverride_android_layout_marginTop, 34);
        r10.append(R$styleable.ConstraintOverride_android_layout_marginBottom, 2);
        r10.append(R$styleable.ConstraintOverride_android_layout_width, 23);
        r10.append(R$styleable.ConstraintOverride_android_layout_height, 21);
        r10.append(R$styleable.ConstraintOverride_layout_constraintWidth, 95);
        r10.append(R$styleable.ConstraintOverride_layout_constraintHeight, 96);
        r10.append(R$styleable.ConstraintOverride_android_visibility, 22);
        r10.append(R$styleable.ConstraintOverride_android_alpha, 43);
        r10.append(R$styleable.ConstraintOverride_android_elevation, 44);
        r10.append(R$styleable.ConstraintOverride_android_rotationX, 45);
        r10.append(R$styleable.ConstraintOverride_android_rotationY, 46);
        r10.append(R$styleable.ConstraintOverride_android_rotation, 60);
        r10.append(R$styleable.ConstraintOverride_android_scaleX, 47);
        r10.append(R$styleable.ConstraintOverride_android_scaleY, 48);
        r10.append(R$styleable.ConstraintOverride_android_transformPivotX, 49);
        r10.append(R$styleable.ConstraintOverride_android_transformPivotY, 50);
        r10.append(R$styleable.ConstraintOverride_android_translationX, 51);
        r10.append(R$styleable.ConstraintOverride_android_translationY, 52);
        r10.append(R$styleable.ConstraintOverride_android_translationZ, 53);
        r10.append(R$styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        r10.append(R$styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        r10.append(R$styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        r10.append(R$styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        r10.append(R$styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        r10.append(R$styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        r10.append(R$styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        r10.append(R$styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        r10.append(R$styleable.ConstraintOverride_animateRelativeTo, 64);
        r10.append(R$styleable.ConstraintOverride_transitionEasing, 65);
        r10.append(R$styleable.ConstraintOverride_drawPath, 66);
        r10.append(R$styleable.ConstraintOverride_transitionPathRotate, 67);
        r10.append(R$styleable.ConstraintOverride_motionStagger, 79);
        r10.append(R$styleable.ConstraintOverride_android_id, 38);
        r10.append(R$styleable.ConstraintOverride_motionTarget, 98);
        r10.append(R$styleable.ConstraintOverride_motionProgress, 68);
        r10.append(R$styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        r10.append(R$styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        r10.append(R$styleable.ConstraintOverride_chainUseRtl, 71);
        r10.append(R$styleable.ConstraintOverride_barrierDirection, 72);
        r10.append(R$styleable.ConstraintOverride_barrierMargin, 73);
        r10.append(R$styleable.ConstraintOverride_constraint_referenced_ids, 74);
        r10.append(R$styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        r10.append(R$styleable.ConstraintOverride_pathMotionArc, 76);
        r10.append(R$styleable.ConstraintOverride_layout_constraintTag, 77);
        r10.append(R$styleable.ConstraintOverride_visibilityMode, 78);
        r10.append(R$styleable.ConstraintOverride_layout_constrainedWidth, 80);
        r10.append(R$styleable.ConstraintOverride_layout_constrainedHeight, 81);
        r10.append(R$styleable.ConstraintOverride_polarRelativeTo, 82);
        r10.append(R$styleable.ConstraintOverride_transformPivotTarget, 83);
        r10.append(R$styleable.ConstraintOverride_quantizeMotionSteps, 84);
        r10.append(R$styleable.ConstraintOverride_quantizeMotionPhase, 85);
        r10.append(R$styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        r10.append(R$styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public d() {
        this.f13070b = "";
        this.f13071c = new String[0];
        this.d = 0;
        this.e = new HashMap();
        this.f = true;
        this.g = new HashMap();
    }

    public static c d(Context r5, XmlResourceParser r10) {
        AttributeSet r11 = Xml.asAttributeSet(r10);
        c r12 = new c();
        TypedArray r13 = r5.obtainStyledAttributes(r11, R$styleable.ConstraintOverride);
        o(r12, r13);
        r13.recycle();
        return r12;
    }

    public static int[] f(Barrier r10, String r11) {
        String[] r12 = r11.split(",");
        Context r5 = r10.getContext();
        int[] r13 = new int[r12.length];
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r12.length) goto L29;
        String r16 = r12[r14].trim();
        Object r17 = null;
        int r18 = R$id.class.getField(r16).getInt(null);     // Catch: Exception -> L8
    L9:
        if (r18 != 0) goto L11;
        r18 = r5.getResources().getIdentifier(r16, "id", r5.getPackageName());
    L11:
        if (r18 != 0) goto L27;
        if (r10.isInEditMode() == false) goto L27;
        if ((r10.getParent() instanceof ConstraintLayout) == false) goto L27;
        ConstraintLayout r19 = (ConstraintLayout) r10.getParent();
        r19.getClass();
        if (r16 == null) goto L23;
        HashMap r20 = r19.f12998m;
        if (r20 == null) goto L23;
        if (r20.containsKey(r16) == false) goto L23;
        r17 = r19.f12998m.get(r16);
    L23:
        if (r17 == null) goto L27;
        if ((r17 instanceof Integer) == false) goto L27;
        r18 = ((Integer) r17).intValue();
    L27:
        r13[r15] = r18;
        r14 = r14 + 1;
        r15 = r15 + 1;
    L8:
        r18 = 0;
        goto L9
    L29:
        if (r15 != r12.length) goto L31;
        return r13;
    L31:
        return Arrays.copyOf(r13, r15);
    }

    public static c g(Context r16, AttributeSet r17, boolean r18) {
        c r5 = new c();
        if (r18 == false) goto L6;
        int[] r10 = R$styleable.ConstraintOverride;
    L7:
        TypedArray r11 = r16.obtainStyledAttributes(r17, r10);
        if (r18 == false) goto L10;
        o(r5, r11);
    L134:
        r11.recycle();
        return r5;
    L10:
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L11:
        g r14 = r5.e;
        if (r13 >= r12) goto L132;
        int r15 = r11.getIndex(r13);
        int r19 = R$styleable.Constraint_android_id;
        i r20 = r5.f13064c;
        j r110 = r5.f;
        h r111 = r5.d;
        if (r15 != r19) goto L16;
    L20:
        SparseIntArray r21 = f13067i;
        switch(r21.get(r15)) {
            case 1: goto L129;
            case 2: goto L128;
            case 3: goto L127;
            case 4: goto L126;
            case 5: goto L125;
            case 6: goto L124;
            case 7: goto L123;
            case 8: goto L122;
            case 9: goto L121;
            case 10: goto L120;
            case 11: goto L119;
            case 12: goto L118;
            case 13: goto L117;
            case 14: goto L116;
            case 15: goto L115;
            case 16: goto L114;
            case 17: goto L113;
            case 18: goto L112;
            case 19: goto L111;
            case 20: goto L110;
            case 21: goto L109;
            case 22: goto L108;
            case 23: goto L107;
            case 24: goto L106;
            case 25: goto L105;
            case 26: goto L104;
            case 27: goto L103;
            case 28: goto L102;
            case 29: goto L101;
            case 30: goto L100;
            case 31: goto L99;
            case 32: goto L98;
            case 33: goto L97;
            case 34: goto L96;
            case 35: goto L95;
            case 36: goto L94;
            case 37: goto L93;
            case 38: goto L92;
            case 39: goto L91;
            case 40: goto L90;
            case 41: goto L89;
            case 42: goto L88;
            case 43: goto L87;
            case 44: goto L86;
            case 45: goto L85;
            case 46: goto L84;
            case 47: goto L83;
            case 48: goto L82;
            case 49: goto L81;
            case 50: goto L80;
            case 51: goto L79;
            case 52: goto L78;
            case 53: goto L77;
            case 54: goto L76;
            case 55: goto L75;
            case 56: goto L74;
            case 57: goto L73;
            case 58: goto L72;
            case 59: goto L71;
            case 60: goto L70;
            case 61: goto L69;
            case 62: goto L68;
            case 63: goto L67;
            case 64: goto L66;
            case 65: goto L63;
            case 66: goto L61;
            case 67: goto L60;
            case 68: goto L59;
            case 69: goto L58;
            case 70: goto L57;
            case 71: goto L56;
            case 72: goto L55;
            case 73: goto L54;
            case 74: goto L53;
            case 75: goto L52;
            case 76: goto L51;
            case 77: goto L50;
            case 78: goto L49;
            case 79: goto L48;
            case 80: goto L47;
            case 81: goto L46;
            case 82: goto L45;
            case 83: goto L44;
            case 84: goto L43;
            case 85: goto L42;
            case 86: goto L31;
            case 87: goto L30;
            case 88: goto L22;
            case 89: goto L22;
            case 90: goto L22;
            case 91: goto L29;
            case 92: goto L28;
            case 93: goto L27;
            case 94: goto L26;
            case 95: goto L25;
            case 96: goto L24;
            case 97: goto L23;
            default: goto L22;
        };
    L22:
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r15) + "   " + r21.get(r15));
    L130:
        r13 = r13 + 1;
        goto L11
    L23:
        r14.f19739p0 = r11.getInt(r15, r14.f19739p0);
        goto L130
    L24:
        m(r14, r11, r15, 1);
        goto L130
    L25:
        m(r14, r11, r15, 0);
        goto L130
    L26:
        r14.T = r11.getDimensionPixelSize(r15, r14.T);
        goto L130
    L27:
        r14.M = r11.getDimensionPixelSize(r15, r14.M);
        goto L130
    L28:
        r14.s = l(r11, r15, r14.s);
        goto L130
    L29:
        r14.f19741r = l(r11, r15, r14.f19741r);
        goto L130
    L30:
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r15) + "   " + r21.get(r15));
        goto L130
    L31:
        int r22 = r11.peekValue(r15).type;
        if (r22 != 1) goto L36;
        int r23 = r11.getResourceId(r15, -1);
        r111.f19758m = r23;
        if (r23 == (-1)) goto L130;
        r111.f19757l = -2;
        goto L130
    L36:
        if (r22 != 3) goto L41;
        String r24 = r11.getString(r15);
        r111.f19756k = r24;
        if (r24.indexOf("/") <= 0) goto L40;
        r111.f19758m = r11.getResourceId(r15, -1);
        r111.f19757l = -2;
        goto L130
    L40:
        r111.f19757l = -1;
        goto L130
    L41:
        r111.f19757l = r11.getInteger(r15, r111.f19758m);
        goto L130
    L42:
        r111.f19754i = r11.getFloat(r15, r111.f19754i);
        goto L130
    L43:
        r111.f19755j = r11.getInteger(r15, r111.f19755j);
        goto L130
    L44:
        r110.f19767i = l(r11, r15, r110.f19767i);
        goto L130
    L45:
        r111.f19752c = r11.getInteger(r15, r111.f19752c);
        goto L130
    L46:
        r14.f19735n0 = r11.getBoolean(r15, r14.f19735n0);
        goto L130
    L47:
        r14.f19733m0 = r11.getBoolean(r15, r14.f19733m0);
        goto L130
    L48:
        r111.g = r11.getFloat(r15, r111.g);
        goto L130
    L49:
        r20.f19761c = r11.getInt(r15, r20.f19761c);
        goto L130
    L50:
        r14.l0 = r11.getString(r15);
        goto L130
    L51:
        r111.e = r11.getInt(r15, r111.e);
        goto L130
    L52:
        r14.f19737o0 = r11.getBoolean(r15, r14.f19737o0);
        goto L130
    L53:
        r14.f19730k0 = r11.getString(r15);
        goto L130
    L54:
        r14.f19725h0 = r11.getDimensionPixelSize(r15, r14.f19725h0);
        goto L130
    L55:
        r14.g0 = r11.getInt(r15, r14.g0);
        goto L130
    L56:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L130
    L57:
        r14.f19723f0 = r11.getFloat(r15, 1.0f);
        goto L130
    L58:
        r14.f19722e0 = r11.getFloat(r15, 1.0f);
        goto L130
    L59:
        r20.e = r11.getFloat(r15, r20.e);
        goto L130
    L60:
        r111.f19753h = r11.getFloat(r15, r111.f19753h);
        goto L130
    L61:
        r111.f = r11.getInt(r15, 0);
        goto L130
    L66:
        r111.f19751b = l(r11, r15, r111.f19751b);
        goto L130
    L67:
        r14.C = r11.getFloat(r15, r14.C);
        goto L130
    L68:
        r14.B = r11.getDimensionPixelSize(r15, r14.B);
        goto L130
    L69:
        r14.A = l(r11, r15, r14.A);
        goto L130
    L70:
        r110.f19764b = r11.getFloat(r15, r110.f19764b);
        goto L130
    L71:
        r14.f19721d0 = r11.getDimensionPixelSize(r15, r14.f19721d0);
        goto L130
    L72:
        r14.f19720c0 = r11.getDimensionPixelSize(r15, r14.f19720c0);
        goto L130
    L73:
        r14.f19718b0 = r11.getDimensionPixelSize(r15, r14.f19718b0);
        goto L130
    L74:
        r14.f19716a0 = r11.getDimensionPixelSize(r15, r14.f19716a0);
        goto L130
    L75:
        r14.Z = r11.getInt(r15, r14.Z);
        goto L130
    L76:
        r14.Y = r11.getInt(r15, r14.Y);
        goto L130
    L77:
        r110.f19770l = r11.getDimension(r15, r110.f19770l);
        goto L130
    L78:
        r110.f19769k = r11.getDimension(r15, r110.f19769k);
        goto L130
    L79:
        r110.f19768j = r11.getDimension(r15, r110.f19768j);
        goto L130
    L80:
        r110.f19766h = r11.getDimension(r15, r110.f19766h);
        goto L130
    L81:
        r110.g = r11.getDimension(r15, r110.g);
        goto L130
    L82:
        r110.f = r11.getFloat(r15, r110.f);
        goto L130
    L83:
        r110.e = r11.getFloat(r15, r110.e);
        goto L130
    L84:
        r110.d = r11.getFloat(r15, r110.d);
        goto L130
    L85:
        r110.f19765c = r11.getFloat(r15, r110.f19765c);
        goto L130
    L86:
        r110.f19771m = true;
        r110.f19772n = r11.getDimension(r15, r110.f19772n);
        goto L130
    L87:
        r20.d = r11.getFloat(r15, r20.d);
        goto L130
    L88:
        r14.X = r11.getInt(r15, r14.X);
        goto L130
    L89:
        r14.W = r11.getInt(r15, r14.W);
        goto L130
    L90:
        r14.U = r11.getFloat(r15, r14.U);
        goto L130
    L91:
        r14.V = r11.getFloat(r15, r14.V);
        goto L130
    L92:
        r5.f13062a = r11.getResourceId(r15, r5.f13062a);
        goto L130
    L93:
        r14.f19747y = r11.getFloat(r15, r14.f19747y);
        goto L130
    L94:
        r14.f19732m = l(r11, r15, r14.f19732m);
        goto L130
    L95:
        r14.f19734n = l(r11, r15, r14.f19734n);
        goto L130
    L96:
        r14.I = r11.getDimensionPixelSize(r15, r14.I);
        goto L130
    L97:
        r14.f19743u = l(r11, r15, r14.f19743u);
        goto L130
    L98:
        r14.f19742t = l(r11, r15, r14.f19742t);
        goto L130
    L99:
        r14.L = r11.getDimensionPixelSize(r15, r14.L);
        goto L130
    L100:
        r14.f19731l = l(r11, r15, r14.f19731l);
        goto L130
    L101:
        r14.f19729k = l(r11, r15, r14.f19729k);
        goto L130
    L102:
        r14.H = r11.getDimensionPixelSize(r15, r14.H);
        goto L130
    L103:
        r14.F = r11.getInt(r15, r14.F);
        goto L130
    L104:
        r14.f19727j = l(r11, r15, r14.f19727j);
        goto L130
    L105:
        r14.f19726i = l(r11, r15, r14.f19726i);
        goto L130
    L106:
        r14.G = r11.getDimensionPixelSize(r15, r14.G);
        goto L130
    L107:
        r14.f19719c = r11.getLayoutDimension(r15, r14.f19719c);
        goto L130
    L108:
        int r25 = r11.getInt(r15, r20.f19760b);
        r20.f19760b = r25;
        r20.f19760b = f13066h[r25];
        goto L130
    L109:
        r14.d = r11.getLayoutDimension(r15, r14.d);
        goto L130
    L110:
        r14.f19746x = r11.getFloat(r15, r14.f19746x);
        goto L130
    L111:
        r14.g = r11.getFloat(r15, r14.g);
        goto L130
    L112:
        r14.f = r11.getDimensionPixelOffset(r15, r14.f);
        goto L130
    L113:
        r14.e = r11.getDimensionPixelOffset(r15, r14.e);
        goto L130
    L114:
        r14.O = r11.getDimensionPixelSize(r15, r14.O);
        goto L130
    L115:
        r14.S = r11.getDimensionPixelSize(r15, r14.S);
        goto L130
    L116:
        r14.P = r11.getDimensionPixelSize(r15, r14.P);
        goto L130
    L117:
        r14.N = r11.getDimensionPixelSize(r15, r14.N);
        goto L130
    L118:
        r14.R = r11.getDimensionPixelSize(r15, r14.R);
        goto L130
    L119:
        r14.Q = r11.getDimensionPixelSize(r15, r14.Q);
        goto L130
    L120:
        r14.f19744v = l(r11, r15, r14.f19744v);
        goto L130
    L121:
        r14.f19745w = l(r11, r15, r14.f19745w);
        goto L130
    L122:
        r14.K = r11.getDimensionPixelSize(r15, r14.K);
        goto L130
    L123:
        r14.E = r11.getDimensionPixelOffset(r15, r14.E);
        goto L130
    L124:
        r14.D = r11.getDimensionPixelOffset(r15, r14.D);
        goto L130
    L125:
        r14.f19748z = r11.getString(r15);
        goto L130
    L126:
        r14.f19736o = l(r11, r15, r14.f19736o);
        goto L130
    L127:
        r14.f19738p = l(r11, r15, r14.f19738p);
        goto L130
    L128:
        r14.J = r11.getDimensionPixelSize(r15, r14.J);
        goto L130
    L129:
        r14.f19740q = l(r11, r15, r14.f19740q);
        goto L130
    L63:
        if (r11.peekValue(r15).type != 3) goto L65;
        r111.d = r11.getString(r15);
        goto L130
    L65:
        r111.d = e.d[r11.getInteger(r15, 0)];
        goto L130
    L16:
        if (R$styleable.Constraint_android_layout_marginStart == r15) goto L20;
        if (R$styleable.Constraint_android_layout_marginEnd == r15) goto L20;
        r111.f19750a = true;
        r14.f19717b = true;
        r20.f19759a = true;
        r110.f19763a = true;
        goto L20
    L132:
        if (r14.f19730k0 == null) goto L134;
        r14.f19728j0 = null;
        goto L134
    L6:
        r10 = R$styleable.Constraint;
        goto L7
    }

    public static int l(TypedArray r5, int r10, int r11) {
        int r12 = r5.getResourceId(r10, r11);
        if (r12 == (-1)) goto L5;
        return r12;
    L5:
        return r5.getInt(r10, -1);
    }

    public static void m(Object r10, TypedArray r11, int r12, int r13) {
        if (r10 != null) goto L4;
        return;
    L4:
        int r5 = r11.peekValue(r12).type;
        boolean r14 = true;
        int r15 = 0;
        if (r5 == 3) goto L37;
        if (r5 == 5) goto L17;
        int r16 = r11.getInt(r12, 0);
        if (r16 != (-4)) goto L10;
        r15 = -2;
    L19:
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L25;
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r10;
        if (r13 != 0) goto L23;
        ((ViewGroup.MarginLayoutParams) r17).width = r15;
        r17.W = r14;
        return;
    L23:
        ((ViewGroup.MarginLayoutParams) r17).height = r15;
        r17.X = r14;
        return;
    L25:
        if ((r10 instanceof g) == false) goto L31;
        g r18 = (g) r10;
        if (r13 != 0) goto L29;
        r18.f19719c = r15;
        r18.f19733m0 = r14;
        return;
    L29:
        r18.d = r15;
        r18.f19735n0 = r14;
        return;
    L31:
        if ((r10 instanceof f) == false) goto L111;
        f r19 = (f) r10;
        if (r13 != 0) goto L35;
        r19.b(23, r15);
        r19.d(80, r14);
        return;
    L35:
        r19.b(21, r15);
        r19.d(81, r14);
        return;
    L111:
        return;
    L10:
        if (r16 == (-3)) goto L14;
        if (r16 != (-2)) goto L13;
    L15:
        r14 = false;
        r15 = r16;
        goto L19
    L13:
        if (r16 == (-1)) goto L15;
    L14:
        r14 = false;
        goto L19
    L17:
        r16 = r11.getDimensionPixelSize(r12, 0);
        goto L15
    L37:
        String r20 = r11.getString(r12);
        if (r20 == null) goto L121;
        int r21 = r20.indexOf(61);
        int r22 = r20.length();
        if (r21 > 0) goto L43;
        return;
    L43:
        if (r21 >= (r22 - 1)) goto L114;
        String r23 = r20.substring(0, r21);
        String r24 = r20.substring(r21 + 1);
        if (r24.length() <= 0) goto L115;
        String r25 = r23.trim();
        String r26 = r24.trim();
        if ("ratio".equalsIgnoreCase(r25) == false) goto L105;
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L56;
        ConstraintLayout.LayoutParams r27 = (ConstraintLayout.LayoutParams) r10;
        if (r13 != 0) goto L53;
        ((ViewGroup.MarginLayoutParams) r27).width = 0;
    L54:
        n(r27, r26);
        return;
    L53:
        ((ViewGroup.MarginLayoutParams) r27).height = 0;
        goto L54
    L56:
        if ((r10 instanceof g) == false) goto L59;
        ((g) r10).f19748z = r26;
        return;
    L59:
        if ((r10 instanceof f) == false) goto L118;
        ((f) r10).c(5, r26);
        return;
    L118:
        return;
    L105:
        if ("weight".equalsIgnoreCase(r25) == false) goto L83;
        float r28 = Float.parseFloat(r26);     // Catch: NumberFormatException -> L103
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L70;
        ConstraintLayout.LayoutParams r29 = (ConstraintLayout.LayoutParams) r10;     // Catch: NumberFormatException -> L103
        if (r13 != 0) goto L68;
        ((ViewGroup.MarginLayoutParams) r29).width = 0;     // Catch: NumberFormatException -> L103
        r29.H = r28;     // Catch: NumberFormatException -> L103
    L104:
        return;
    L68:
        ((ViewGroup.MarginLayoutParams) r29).height = 0;     // Catch: NumberFormatException -> L103
        r29.I = r28;     // Catch: NumberFormatException -> L103
        goto L104
    L70:
        if ((r10 instanceof g) == false) goto L76;
        g r30 = (g) r10;     // Catch: NumberFormatException -> L103
        if (r13 != 0) goto L74;
        r30.f19719c = 0;     // Catch: NumberFormatException -> L103
        r30.V = r28;     // Catch: NumberFormatException -> L103
        goto L104
    L74:
        r30.d = 0;     // Catch: NumberFormatException -> L103
        r30.U = r28;     // Catch: NumberFormatException -> L103
        goto L104
    L76:
        if ((r10 instanceof f) == false) goto L104;
        f r31 = (f) r10;     // Catch: NumberFormatException -> L103
        if (r13 != 0) goto L80;
        r31.b(23, 0);     // Catch: NumberFormatException -> L103
        r31.a(r28, 39);     // Catch: NumberFormatException -> L103
        goto L104
    L80:
        r31.b(21, 0);     // Catch: NumberFormatException -> L103
        r31.a(r28, 40);     // Catch: NumberFormatException -> L103
        goto L104
    L83:
        if ("parent".equalsIgnoreCase(r25) == false) goto L120;
        float r32 = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(r26)));     // Catch: NumberFormatException -> L103
        if ((r10 instanceof ConstraintLayout.LayoutParams) == false) goto L91;
        ConstraintLayout.LayoutParams r33 = (ConstraintLayout.LayoutParams) r10;     // Catch: NumberFormatException -> L103
        if (r13 != 0) goto L89;
        ((ViewGroup.MarginLayoutParams) r33).width = 0;     // Catch: NumberFormatException -> L103
        r33.R = r32;     // Catch: NumberFormatException -> L103
        r33.L = 2;     // Catch: NumberFormatException -> L103
        goto L104
    L89:
        ((ViewGroup.MarginLayoutParams) r33).height = 0;     // Catch: NumberFormatException -> L103
        r33.S = r32;     // Catch: NumberFormatException -> L103
        r33.M = 2;     // Catch: NumberFormatException -> L103
        goto L104
    L91:
        if ((r10 instanceof g) == false) goto L97;
        g r34 = (g) r10;     // Catch: NumberFormatException -> L103
        if (r13 != 0) goto L95;
        r34.f19719c = 0;     // Catch: NumberFormatException -> L103
        r34.f19722e0 = r32;     // Catch: NumberFormatException -> L103
        r34.Y = 2;     // Catch: NumberFormatException -> L103
        goto L104
    L95:
        r34.d = 0;     // Catch: NumberFormatException -> L103
        r34.f19723f0 = r32;     // Catch: NumberFormatException -> L103
        r34.Z = 2;     // Catch: NumberFormatException -> L103
        goto L104
    L97:
        if ((r10 instanceof f) == false) goto L104;
        f r35 = (f) r10;     // Catch: NumberFormatException -> L103
        if (r13 != 0) goto L101;
        r35.b(23, 0);     // Catch: NumberFormatException -> L103
        r35.b(54, 2);     // Catch: NumberFormatException -> L103
        goto L104
    L101:
        r35.b(21, 0);     // Catch: NumberFormatException -> L103
        r35.b(55, 2);     // Catch: NumberFormatException -> L103
        goto L104
    L120:
        return;
    L122:
        return;
    L115:
        return;
    L114:
        return;
    }

    public static void n(ConstraintLayout.LayoutParams r10, String r11) {
        if (r11 == null) goto L33;
        int r5 = r11.length();
        int r12 = r11.indexOf(44);
        byte r13 = -1;
        int r14 = 0;
        if (r12 > 0) goto L6;
    L14:
        int r15 = r11.indexOf(58);
        if (r15 >= 0) goto L17;
    L30:
        String r16 = r11.substring(r14);
        if (r16.length() <= 0) goto L33;
        Float.parseFloat(r16);     // Catch: NumberFormatException -> L35
    L36:
        goto L33
    L17:
        if (r15 >= (r5 - 1)) goto L30;
        String r17 = r11.substring(r14, r15);
        String r18 = r11.substring(r15 + 1);
        if (r17.length() <= 0) goto L33;
        if (r18.length() <= 0) goto L33;
        float r19 = Float.parseFloat(r17);     // Catch: NumberFormatException -> L35
        float r20 = Float.parseFloat(r18);     // Catch: NumberFormatException -> L35
        if (r19 <= 0.0f) goto L36;
        if (r20 <= 0.0f) goto L36;
        if (r13 != 1) goto L28;
        Math.abs(r20 / r19);     // Catch: NumberFormatException -> L35
        goto L36
    L28:
        Math.abs(r19 / r20);     // Catch: NumberFormatException -> L35
        goto L36
    L6:
        if (r12 >= (r5 - 1)) goto L14;
        String r21 = r11.substring(0, r12);
        if (r21.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST) == false) goto L11;
        r13 = 0;
    L13:
        r14 = r12 + 1;
        goto L14
    L11:
        if (r21.equalsIgnoreCase("H") == false) goto L13;
        r13 = 1;
    L33:
        r10.G = r11;
    }

    public static void o(c r16, TypedArray r17) {
        int r5 = r17.getIndexCount();
        f r10 = new f();
        r10.f19706a = new int[10];
        r10.f19707b = new int[10];
        r10.f19708c = 0;
        r10.d = new int[10];
        r10.e = new float[10];
        r10.f = 0;
        r10.g = new int[5];
        r10.f19709h = new String[5];
        r10.f19710i = 0;
        r10.f19711j = new int[4];
        r10.f19712k = new boolean[4];
        r10.f19713l = 0;
        r16.f13065h = r10;
        h r11 = r16.d;
        r11.f19750a = false;
        g r12 = r16.e;
        r12.f19717b = false;
        i r13 = r16.f13064c;
        r13.f19759a = false;
        j r14 = r16.f;
        r14.f19763a = false;
        int r15 = 0;
    L3:
        if (r15 >= r5) goto L112;
        int r18 = r17.getIndex(r15);
        int r19 = f13068j.get(r18);
        SparseIntArray r110 = f13067i;
        switch(r19) {
            case 2: goto L110;
            case 3: goto L6;
            case 4: goto L6;
            case 5: goto L109;
            case 6: goto L108;
            case 7: goto L107;
            case 8: goto L106;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L105;
            case 12: goto L104;
            case 13: goto L103;
            case 14: goto L102;
            case 15: goto L101;
            case 16: goto L100;
            case 17: goto L99;
            case 18: goto L98;
            case 19: goto L97;
            case 20: goto L96;
            case 21: goto L95;
            case 22: goto L94;
            case 23: goto L93;
            case 24: goto L92;
            case 25: goto L6;
            case 26: goto L6;
            case 27: goto L91;
            case 28: goto L90;
            case 29: goto L6;
            case 30: goto L6;
            case 31: goto L89;
            case 32: goto L6;
            case 33: goto L6;
            case 34: goto L88;
            case 35: goto L6;
            case 36: goto L6;
            case 37: goto L87;
            case 38: goto L86;
            case 39: goto L85;
            case 40: goto L84;
            case 41: goto L83;
            case 42: goto L82;
            case 43: goto L81;
            case 44: goto L80;
            case 45: goto L79;
            case 46: goto L78;
            case 47: goto L77;
            case 48: goto L76;
            case 49: goto L75;
            case 50: goto L74;
            case 51: goto L73;
            case 52: goto L72;
            case 53: goto L71;
            case 54: goto L70;
            case 55: goto L69;
            case 56: goto L68;
            case 57: goto L67;
            case 58: goto L66;
            case 59: goto L65;
            case 60: goto L64;
            case 61: goto L6;
            case 62: goto L63;
            case 63: goto L62;
            case 64: goto L61;
            case 65: goto L58;
            case 66: goto L56;
            case 67: goto L55;
            case 68: goto L54;
            case 69: goto L53;
            case 70: goto L52;
            case 71: goto L51;
            case 72: goto L50;
            case 73: goto L49;
            case 74: goto L48;
            case 75: goto L47;
            case 76: goto L46;
            case 77: goto L45;
            case 78: goto L44;
            case 79: goto L43;
            case 80: goto L42;
            case 81: goto L41;
            case 82: goto L40;
            case 83: goto L39;
            case 84: goto L38;
            case 85: goto L37;
            case 86: goto L25;
            case 87: goto L24;
            case 88: goto L6;
            case 89: goto L6;
            case 90: goto L6;
            case 91: goto L6;
            case 92: goto L6;
            case 93: goto L23;
            case 94: goto L22;
            case 95: goto L21;
            case 96: goto L20;
            case 97: goto L19;
            case 98: goto L11;
            case 99: goto L9;
            default: goto L6;
        };
    L6:
        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(r18) + "   " + r110.get(r18));
    L8:
        char r111 = 5;
    L111:
        r15 = r15 + 1;
        goto L3
    L9:
        r10.d(99, r17.getBoolean(r18, r12.f19724h));
        goto L8
    L19:
        r10.b(97, r17.getInt(r18, r12.f19739p0));
        goto L8
    L20:
        m(r10, r17, r18, 1);
        goto L8
    L21:
        m(r10, r17, r18, 0);
        goto L8
    L22:
        r10.b(94, r17.getDimensionPixelSize(r18, r12.T));
        goto L8
    L23:
        r10.b(93, r17.getDimensionPixelSize(r18, r12.M));
        goto L8
    L24:
        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(r18) + "   " + r110.get(r18));
        goto L8
    L25:
        int r20 = r17.peekValue(r18).type;
        if (r20 != 1) goto L31;
        int r21 = r17.getResourceId(r18, -1);
        r11.f19758m = r21;
        r10.b(89, r21);
        if (r11.f19758m == (-1)) goto L8;
        r11.f19757l = -2;
        r10.b(88, -2);
        goto L8
    L31:
        if (r20 != 3) goto L36;
        String r22 = r17.getString(r18);
        r11.f19756k = r22;
        r10.c(90, r22);
        if (r11.f19756k.indexOf("/") <= 0) goto L35;
        int r23 = r17.getResourceId(r18, -1);
        r11.f19758m = r23;
        r10.b(89, r23);
        r11.f19757l = -2;
        r10.b(88, -2);
        goto L8
    L35:
        r11.f19757l = -1;
        r10.b(88, -1);
        goto L8
    L36:
        int r24 = r17.getInteger(r18, r11.f19758m);
        r11.f19757l = r24;
        r10.b(88, r24);
        goto L8
    L37:
        r10.a(r17.getFloat(r18, r11.f19754i), 85);
        goto L8
    L38:
        r10.b(84, r17.getInteger(r18, r11.f19755j));
        goto L8
    L39:
        r10.b(83, l(r17, r18, r14.f19767i));
        goto L8
    L40:
        r10.b(82, r17.getInteger(r18, r11.f19752c));
        goto L8
    L41:
        r10.d(81, r17.getBoolean(r18, r12.f19735n0));
        goto L8
    L42:
        r10.d(80, r17.getBoolean(r18, r12.f19733m0));
        goto L8
    L43:
        r10.a(r17.getFloat(r18, r11.g), 79);
        goto L8
    L44:
        r10.b(78, r17.getInt(r18, r13.f19761c));
        goto L8
    L45:
        r10.c(77, r17.getString(r18));
        goto L8
    L46:
        r10.b(76, r17.getInt(r18, r11.e));
        goto L8
    L47:
        r10.d(75, r17.getBoolean(r18, r12.f19737o0));
        goto L8
    L48:
        r10.c(74, r17.getString(r18));
        goto L8
    L49:
        r10.b(73, r17.getDimensionPixelSize(r18, r12.f19725h0));
        goto L8
    L50:
        r10.b(72, r17.getInt(r18, r12.g0));
        goto L8
    L51:
        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
        goto L8
    L52:
        r10.a(r17.getFloat(r18, 1.0f), 70);
        goto L8
    L53:
        r10.a(r17.getFloat(r18, 1.0f), 69);
        goto L8
    L54:
        r10.a(r17.getFloat(r18, r13.e), 68);
        goto L8
    L55:
        r10.a(r17.getFloat(r18, r11.f19753h), 67);
        goto L8
    L56:
        r10.b(66, r17.getInt(r18, 0));
        goto L8
    L61:
        r10.b(64, l(r17, r18, r11.f19751b));
        goto L8
    L62:
        r10.a(r17.getFloat(r18, r12.C), 63);
        goto L8
    L63:
        r10.b(62, r17.getDimensionPixelSize(r18, r12.B));
        goto L8
    L64:
        r10.a(r17.getFloat(r18, r14.f19764b), 60);
        goto L8
    L65:
        r10.b(59, r17.getDimensionPixelSize(r18, r12.f19721d0));
        goto L8
    L66:
        r10.b(58, r17.getDimensionPixelSize(r18, r12.f19720c0));
        goto L8
    L67:
        r10.b(57, r17.getDimensionPixelSize(r18, r12.f19718b0));
        goto L8
    L68:
        r10.b(56, r17.getDimensionPixelSize(r18, r12.f19716a0));
        goto L8
    L69:
        r10.b(55, r17.getInt(r18, r12.Z));
        goto L8
    L70:
        r10.b(54, r17.getInt(r18, r12.Y));
        goto L8
    L71:
        r10.a(r17.getDimension(r18, r14.f19770l), 53);
        goto L8
    L72:
        r10.a(r17.getDimension(r18, r14.f19769k), 52);
        goto L8
    L73:
        r10.a(r17.getDimension(r18, r14.f19768j), 51);
        goto L8
    L74:
        r10.a(r17.getDimension(r18, r14.f19766h), 50);
        goto L8
    L75:
        r10.a(r17.getDimension(r18, r14.g), 49);
        goto L8
    L76:
        r10.a(r17.getFloat(r18, r14.f), 48);
        goto L8
    L77:
        r10.a(r17.getFloat(r18, r14.e), 47);
        goto L8
    L78:
        r10.a(r17.getFloat(r18, r14.d), 46);
        goto L8
    L79:
        r10.a(r17.getFloat(r18, r14.f19765c), 45);
        goto L8
    L80:
        r10.d(44, true);
        r10.a(r17.getDimension(r18, r14.f19772n), 44);
        goto L8
    L81:
        r10.a(r17.getFloat(r18, r13.d), 43);
        goto L8
    L82:
        r10.b(42, r17.getInt(r18, r12.X));
        goto L8
    L83:
        r10.b(41, r17.getInt(r18, r12.W));
        goto L8
    L84:
        r10.a(r17.getFloat(r18, r12.U), 40);
        goto L8
    L85:
        r10.a(r17.getFloat(r18, r12.V), 39);
        goto L8
    L86:
        int r25 = r17.getResourceId(r18, r16.f13062a);
        r16.f13062a = r25;
        r10.b(38, r25);
        goto L8
    L87:
        r10.a(r17.getFloat(r18, r12.f19747y), 37);
        goto L8
    L88:
        r10.b(34, r17.getDimensionPixelSize(r18, r12.I));
        goto L8
    L89:
        r10.b(31, r17.getDimensionPixelSize(r18, r12.L));
        goto L8
    L90:
        r10.b(28, r17.getDimensionPixelSize(r18, r12.H));
        goto L8
    L91:
        r10.b(27, r17.getInt(r18, r12.F));
        goto L8
    L92:
        r10.b(24, r17.getDimensionPixelSize(r18, r12.G));
        goto L8
    L93:
        r10.b(23, r17.getLayoutDimension(r18, r12.f19719c));
        goto L8
    L94:
        r10.b(22, f13066h[r17.getInt(r18, r13.f19760b)]);
        goto L8
    L95:
        r10.b(21, r17.getLayoutDimension(r18, r12.d));
        goto L8
    L96:
        r10.a(r17.getFloat(r18, r12.f19746x), 20);
        goto L8
    L97:
        r10.a(r17.getFloat(r18, r12.g), 19);
        goto L8
    L98:
        r10.b(18, r17.getDimensionPixelOffset(r18, r12.f));
        goto L8
    L99:
        r10.b(17, r17.getDimensionPixelOffset(r18, r12.e));
        goto L8
    L100:
        r10.b(16, r17.getDimensionPixelSize(r18, r12.O));
        goto L8
    L101:
        r10.b(15, r17.getDimensionPixelSize(r18, r12.S));
        goto L8
    L102:
        r10.b(14, r17.getDimensionPixelSize(r18, r12.P));
        goto L8
    L103:
        r10.b(13, r17.getDimensionPixelSize(r18, r12.N));
        goto L8
    L104:
        r10.b(12, r17.getDimensionPixelSize(r18, r12.R));
        goto L8
    L105:
        r10.b(11, r17.getDimensionPixelSize(r18, r12.Q));
        goto L8
    L106:
        r10.b(8, r17.getDimensionPixelSize(r18, r12.K));
        goto L8
    L107:
        r10.b(7, r17.getDimensionPixelOffset(r18, r12.E));
        goto L8
    L108:
        r10.b(6, r17.getDimensionPixelOffset(r18, r12.D));
        goto L8
    L109:
        r111 = 5;
        r10.c(5, r17.getString(r18));
        goto L111
    L110:
        r111 = 5;
        r10.b(2, r17.getDimensionPixelSize(r18, r12.J));
        goto L111
    L11:
        if (MotionLayout.F0 == false) goto L16;
        int r26 = r17.getResourceId(r18, r16.f13062a);
        r16.f13062a = r26;
        if (r26 != (-1)) goto L8;
        r16.f13063b = r17.getString(r18);
        goto L8
    L16:
        if (r17.peekValue(r18).type != 3) goto L18;
        r16.f13063b = r17.getString(r18);
        goto L8
    L18:
        r16.f13062a = r17.getResourceId(r18, r16.f13062a);
        goto L8
    L58:
        if (r17.peekValue(r18).type != 3) goto L60;
        r10.c(65, r17.getString(r18));
        goto L8
    L60:
        r10.c(65, e.d[r17.getInteger(r18, 0)]);
        goto L8
    }

    public final void a(MotionLayout r10) {
        int r5 = r10.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L21;
        View r12 = r10.getChildAt(r11);
        int r13 = r12.getId();
        HashMap r14 = this.g;
        if (r14.containsKey(Integer.valueOf(r13)) == true) goto L8;
        Log.w("ConstraintSet", "id unknown " + k.h(r12));
    L20:
        r11 = r11 + 1;
        goto L3
    L8:
        if (this.f == false) goto L15;
        if (r13 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (r14.containsKey(Integer.valueOf(r13)) == false) goto L20;
        c r15 = (c) r14.get(Integer.valueOf(r13));
        if (r15 == null) goto L20;
        lr.b.e(r12, r15.g);
        goto L20
    }

    public final void b(ConstraintLayout r5) {
        c(r5);
        r5.setConstraintSet(null);
        r5.requestLayout();
    }

    public final void c(ConstraintLayout r13) {
        int r5 = r13.getChildCount();
        HashMap r10 = this.g;
        HashSet r11 = new HashSet(r10.keySet());
        int r12 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r5) goto L51;
        View r15 = r13.getChildAt(r14);
        int r16 = r15.getId();
        if (r10.containsKey(Integer.valueOf(r16)) == true) goto L8;
        Log.w("ConstraintSet", "id unknown " + k.h(r15));
    L50:
        r14 = r14 + 1;
        goto L3
    L8:
        if (this.f == false) goto L13;
        if (r16 != (-1)) goto L13;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L13:
        if (r16 == (-1)) goto L50;
        if (r10.containsKey(Integer.valueOf(r16)) == false) goto L49;
        r11.remove(Integer.valueOf(r16));
        c r17 = (c) r10.get(Integer.valueOf(r16));
        if (r17 == null) goto L50;
        if ((r15 instanceof Barrier) == false) goto L28;
        g r18 = r17.e;
        r18.i0 = 1;
        Barrier r19 = (Barrier) r15;
        r19.setId(r16);
        r19.setType(r18.g0);
        r19.setMargin(r18.f19725h0);
        r19.setAllowsGoneWidget(r18.f19737o0);
        int[] r20 = r18.f19728j0;
        if (r20 == null) goto L25;
        r19.setReferencedIds(r20);
        goto L28
    L25:
        String r21 = r18.f19730k0;
        if (r21 == null) goto L28;
        int[] r22 = f(r19, r21);
        r18.f19728j0 = r22;
        r19.setReferencedIds(r22);
    L28:
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r15.getLayoutParams();
        r23.a();
        r17.a(r23);
        lr.b.e(r15, r17.g);
        r15.setLayoutParams(r23);
        i r24 = r17.f13064c;
        if (r24.f19761c != 0) goto L31;
        r15.setVisibility(r24.f19760b);
    L31:
        r15.setAlpha(r24.d);
        j r25 = r17.f;
        r15.setRotation(r25.f19764b);
        r15.setRotationX(r25.f19765c);
        r15.setRotationY(r25.d);
        r15.setScaleX(r25.e);
        r15.setScaleY(r25.f);
        if (r25.f19767i == (-1)) goto L41;
        View r26 = ((View) r15.getParent()).findViewById(r25.f19767i);
        if (r26 == null) goto L46;
        float r27 = (r26.getBottom() + r26.getTop()) / 2.0f;
        float r28 = (r26.getRight() + r26.getLeft()) / 2.0f;
        if ((r15.getRight() - r15.getLeft()) <= 0) goto L46;
        if ((r15.getBottom() - r15.getTop()) <= 0) goto L46;
        float r29 = r28 - r15.getLeft();
        float r30 = r27 - r15.getTop();
        r15.setPivotX(r29);
        r15.setPivotY(r30);
    L46:
        r15.setTranslationX(r25.f19768j);
        r15.setTranslationY(r25.f19769k);
        r15.setTranslationZ(r25.f19770l);
        if (r25.f19771m == false) goto L50;
        r15.setElevation(r25.f19772n);
        goto L50
    L41:
        if (Float.isNaN(r25.g) == true) goto L44;
        r15.setPivotX(r25.g);
    L44:
        if (Float.isNaN(r25.f19766h) == true) goto L46;
        r15.setPivotY(r25.f19766h);
        goto L46
    L49:
        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + r16);
        goto L50
    L51:
        Iterator r110 = r11.iterator();
    L53:
        if (r110.hasNext() == false) goto L69;
        Integer r31 = (Integer) r110.next();
        c r32 = (c) r10.get(r31);
        if (r32 == null) goto L53;
        g r33 = r32.e;
        if (r33.i0 != 1) goto L67;
        Barrier r34 = new Barrier(r13.getContext());
        r34.setId(r31.intValue());
        int[] r35 = r33.f19728j0;
        if (r35 == null) goto L62;
        r34.setReferencedIds(r35);
    L65:
        r34.setType(r33.g0);
        r34.setMargin(r33.f19725h0);
        m r36 = ConstraintLayout.f12989p;
        ConstraintLayout.LayoutParams r37 = new ConstraintLayout.LayoutParams(-2, -2);
        r34.q();
        r32.a(r37);
        r13.addView(r34, r37);
        goto L67
    L62:
        String r38 = r33.f19730k0;
        if (r38 == null) goto L65;
        int[] r39 = f(r34, r38);
        r33.f19728j0 = r39;
        r34.setReferencedIds(r39);
    L67:
        if (r33.f19715a == false) goto L53;
        View r40 = new Guideline(r13.getContext());
        r40.setId(r31.intValue());
        m r41 = ConstraintLayout.f12989p;
        ConstraintLayout.LayoutParams r42 = new ConstraintLayout.LayoutParams(-2, -2);
        r32.a(r42);
        r13.addView(r40, r42);
    L69:
        if (r12 >= r5) goto L74;
        View r111 = r13.getChildAt(r12);
        if ((r111 instanceof ConstraintHelper) == false) goto L73;
        ((ConstraintHelper) r111).g(r13);
    L73:
        r12 = r12 + 1;
        goto L69
    }

    public final void e(Context r19, int r20) {
        d r5 = this;
        ConstraintLayout r10 = (ConstraintLayout) LayoutInflater.from(r19).inflate(r20, null);
        int r11 = r10.getChildCount();
        HashMap r12 = r5.g;
        r12.clear();
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L56;
        View r14 = r10.getChildAt(r13);
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14.getLayoutParams();
        int r16 = r14.getId();
        if (r5.f == false) goto L12;
        if (r16 != (-1)) goto L12;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L12:
        if (r12.containsKey(Integer.valueOf(r16)) == true) goto L14;
        r12.put(Integer.valueOf(r16), new c());
    L14:
        c r17 = (c) r12.get(Integer.valueOf(r16));
        if (r17 != null) goto L17;
        ConstraintLayout r21 = r10;
        int r18 = r11;
    L55:
        r13 = r13 + 1;
        r5 = this;
        r10 = r21;
        r11 = r18;
        goto L3
    L17:
        HashMap r110 = r5.e;
        HashMap r111 = new HashMap();
        Class<?> r22 = r14.getClass();
        Iterator r112 = r110.keySet().iterator();
    L19:
        if (r112.hasNext() == false) goto L44;
        String r23 = (String) r112.next();
        lr.b r24 = (lr.b) r110.get(r23);
        ConstraintLayout r25 = r10;
    L34:
        e = e;
        int r113 = r11;
    L41:
        StringBuilder r26 = j0.x(" Custom Attribute \"", r23, "\" not found on ");
        r26.append(r22.getName());
        Log.e("TransitionLayout", r26.toString(), e);
    L43:
        r10 = r25;
        r11 = r113;
    L36:
        e = e;
        r113 = r11;
    L42:
        Log.e("TransitionLayout", r22.getName() + " must have a method " + r23, e);
    L32:
        e = e;
        r113 = r11;
    L40:
        StringBuilder r27 = j0.x(" Custom Attribute \"", r23, "\" not found on ");
        r27.append(r22.getName());
        Log.e("TransitionLayout", r27.toString(), e);
        goto L43
    L22:
        if (r23.equals("BackgroundColor") == false) goto L38;
        r113 = r11;
        r111.put(r23, new lr.b(r24, Integer.valueOf(((ColorDrawable) r14.getBackground()).getColor())));     // Catch: InvocationTargetException -> L26 IllegalAccessException -> L28 NoSuchMethodException -> L30
    L28:
        e = e;
    L30:
        e = e;
    L26:
        e = e;
        goto L40
    L38:
        r113 = r11;
        r111.put(r23, new lr.b(r24, r22.getMethod("getMap" + r23, null).invoke(r14, null)));     // Catch: InvocationTargetException -> L26 IllegalAccessException -> L28 NoSuchMethodException -> L30
        goto L43
    L44:
        r21 = r10;
        r18 = r11;
        r17.g = r111;
        r17.c(r16, r15);
        int r28 = r14.getVisibility();
        i r29 = r17.f13064c;
        r29.f19760b = r28;
        r29.d = r14.getAlpha();
        float r30 = r14.getRotation();
        j r31 = r17.f;
        r31.f19764b = r30;
        r31.f19765c = r14.getRotationX();
        r31.d = r14.getRotationY();
        r31.e = r14.getScaleX();
        r31.f = r14.getScaleY();
        float r32 = r14.getPivotX();
        float r33 = r14.getPivotY();
        if (r32 == 0.0d) goto L47;
    L48:
        r31.g = r32;
        r31.f19766h = r33;
    L49:
        r31.f19768j = r14.getTranslationX();
        r31.f19769k = r14.getTranslationY();
        r31.f19770l = r14.getTranslationZ();
        if (r31.f19771m == false) goto L53;
        r31.f19772n = r14.getElevation();
    L53:
        if ((r14 instanceof Barrier) == false) goto L55;
        Barrier r34 = (Barrier) r14;
        boolean r35 = r34.getAllowsGoneWidget();
        g r36 = r17.e;
        r36.f19737o0 = r35;
        r36.f19728j0 = r34.getReferencedIds();
        r36.g0 = r34.getType();
        r36.f19725h0 = r34.getMargin();
        goto L55
    L47:
        if (r33 == 0.0d) goto L49;
    }

    public final c h(int r5) {
        HashMap r10 = this.g;
        if (r10.containsKey(Integer.valueOf(r5)) == true) goto L6;
        r10.put(Integer.valueOf(r5), new c());
    L6:
        return (c) r10.get(Integer.valueOf(r5));
    }

    public final c i(int r5) {
        HashMap r10 = this.g;
        if (r10.containsKey(Integer.valueOf(r5)) == true) goto L5;
        return null;
    L5:
        return (c) r10.get(Integer.valueOf(r5));
    }

    public final void j(Context r10, int r11) {
        XmlResourceParser r5 = r10.getResources().getXml(r11);
        int r12 = r5.getEventType();     // Catch: IOException -> L12 XmlPullParserException -> L14
    L5:
        if (r12 == 1) goto L29;
        if (r12 != 2) goto L17;
        String r13 = r5.getName();     // Catch: IOException -> L12 XmlPullParserException -> L14
        c r14 = g(r10, Xml.asAttributeSet(r5), false);     // Catch: IOException -> L12 XmlPullParserException -> L14
        if (r13.equalsIgnoreCase("Guideline") == false) goto L16;
        r14.e.f19715a = true;     // Catch: IOException -> L12 XmlPullParserException -> L14
    L16:
        this.g.put(Integer.valueOf(r14.f13062a), r14);     // Catch: IOException -> L12 XmlPullParserException -> L14
    L17:
        r12 = r5.next();     // Catch: IOException -> L12 XmlPullParserException -> L14
    L29:
        return;
    L12:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing resource: " + r11, e);
        return;
    L14:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing resource: " + r11, e);
    }

    public final void k(Context r12, XmlResourceParser r13) {
        int r5 = r13.getEventType();     // Catch: IOException -> L17 XmlPullParserException -> L19
        c r10 = null;
    L5:
        if (r5 == 1) goto L126;
        if (r5 == 0) goto L97;
        byte r11 = -1;
        if (r5 == 2) goto L37;
        if (r5 != 3) goto L98;
        String r14 = r13.getName().toLowerCase(Locale.ROOT);     // Catch: IOException -> L17 XmlPullParserException -> L19
        switch(r14.hashCode()) {
            case -2075718416: goto L28;
            case -190376483: goto L25;
            case 426575017: goto L22;
            case 2146106725: goto L15;
            default: goto L30;
        };     // Catch: IOException -> L17 XmlPullParserException -> L19
    L30:
        if (r11 == 0) goto L36;
        if (r11 == 1) goto L35;
        if (r11 == 2) goto L35;
        if (r11 != 3) goto L98;
    L35:
        this.g.put(Integer.valueOf(r10.f13062a), r10);     // Catch: IOException -> L17 XmlPullParserException -> L19
        r10 = null;
        goto L98
    L36:
        return;
    L15:
        if (r14.equals("constraintset") == false) goto L30;
        r11 = 0;
        goto L30
    L22:
        if (r14.equals("constraintoverride") == false) goto L30;
        r11 = 2;
        goto L30
    L25:
        if (r14.equals("constraint") == false) goto L30;
        r11 = 1;
        goto L30
    L28:
        if (r14.equals("guideline") == false) goto L30;
        r11 = 3;
    L98:
        r5 = r13.next();     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L5
    L37:
        String r15 = r13.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        switch(r15.hashCode()) {
            case -2025855158: goto L68;
            case -1984451626: goto L65;
            case -1962203927: goto L62;
            case -1269513683: goto L59;
            case -1238332596: goto L56;
            case -71750448: goto L53;
            case 366511058: goto L50;
            case 1331510167: goto L47;
            case 1791837707: goto L44;
            case 1803088381: goto L41;
            default: goto L71;
        };     // Catch: IOException -> L17 XmlPullParserException -> L19
    L71:
        switch(r11) {
            case 0: goto L96;
            case 1: goto L95;
            case 2: goto L94;
            case 3: goto L93;
            case 4: goto L89;
            case 5: goto L85;
            case 6: goto L81;
            case 7: goto L77;
            case 8: goto L73;
            case 9: goto L73;
            default: goto L98;
        };
    L73:
        if (r10 == null) goto L76;
        lr.b.d(r12, r13, r10.g);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L76:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L77:
        if (r10 == null) goto L80;
        r10.d.b(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L80:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L81:
        if (r10 == null) goto L84;
        r10.e.b(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L84:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L85:
        if (r10 == null) goto L88;
        r10.f.b(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L88:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L89:
        if (r10 == null) goto L92;
        r10.f13064c.a(r12, Xml.asAttributeSet(r13));     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L92:
        throw new RuntimeException("XML parser error must be within a Constraint " + r13.getLineNumber());     // Catch: IOException -> L17 XmlPullParserException -> L19
    L93:
        r10 = g(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        r10.e.i0 = 1;     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L94:
        r10 = g(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        g r16 = r10.e;     // Catch: IOException -> L17 XmlPullParserException -> L19
        r16.f19715a = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
        r16.f19717b = true;     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L95:
        r10 = g(r12, Xml.asAttributeSet(r13), true);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L96:
        r10 = g(r12, Xml.asAttributeSet(r13), false);     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L41:
        if (r15.equals("Constraint") == false) goto L71;
        r11 = 0;
        goto L71
    L44:
        if (r15.equals("CustomAttribute") == false) goto L71;
        r11 = 8;
        goto L71
    L47:
        if (r15.equals("Barrier") == false) goto L71;
        r11 = 3;
        goto L71
    L50:
        if (r15.equals("CustomMethod") == false) goto L71;
        r11 = 9;
        goto L71
    L53:
        if (r15.equals("Guideline") == false) goto L71;
        r11 = 2;
        goto L71
    L56:
        if (r15.equals("Transform") == false) goto L71;
        r11 = 5;
        goto L71
    L59:
        if (r15.equals("PropertySet") == false) goto L71;
        r11 = 4;
        goto L71
    L62:
        if (r15.equals("ConstraintOverride") == false) goto L71;
        r11 = 1;
        goto L71
    L65:
        if (r15.equals("Motion") == false) goto L71;
        r11 = 7;
        goto L71
    L68:
        if (r15.equals("Layout") == false) goto L71;
        r11 = 6;
        goto L71
    L97:
        r13.getName();     // Catch: IOException -> L17 XmlPullParserException -> L19
        goto L98
    L126:
        return;
    L17:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing XML resource", e);
        return;
    L19:
        e = move-exception;
        Log.e("ConstraintSet", "Error parsing XML resource", e);
    }
}
