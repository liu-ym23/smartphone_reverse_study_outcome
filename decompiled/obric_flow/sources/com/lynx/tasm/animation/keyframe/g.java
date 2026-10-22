package com.lynx.tasm.animation.keyframe;

import android.animation.ArgbEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import com.airbnb.lottie.t;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.m;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.ui.utils.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f10100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f10101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f10102c;
    public final HashMap d;
    public long e;
    public c f;
    public ObjectAnimator[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LynxKeyframeAnimator$LynxKFAnimatorState f10103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public tm.b f10104i;

    public g(View r5, LynxUI r10) {
        e r11 = new e();
        r11.f10098b = -1;
        this.f10100a = r11;
        this.d = new HashMap();
        this.e = -1;
        this.f = null;
        this.g = null;
        this.f10103h = LynxKeyframeAnimator$LynxKFAnimatorState.f10078a;
        this.f10104i = null;
        this.f10101b = new WeakReference(r10);
        this.f10102c = new WeakReference(r5);
    }

    public static PropertyValuesHolder a(String r5, ArrayList r10) {
        return PropertyValuesHolder.ofKeyframe(r5, (Keyframe[]) r10.toArray(new Keyframe[r10.size()]));
    }

    public static void b(float r5, LynxKeyframeAnimator$LynxAnimationPropertyType r10, c r11) {
        if (r5 != 0.0f) goto L6;
        r11.f10093l.add(r10);
    L6:
        if (r5 != 1.0f) goto L9;
        r11.f10094m.add(r10);
        return;
    }

    public final void c(tm.b r10) {
        tm.b r5 = this.f10104i;
        if (r5 == null) goto L6;
        r10.f22140a.equals(r5.f22140a);
    L6:
        if (((LynxUI) this.f10101b.get()) == null) goto L67;
        int r11 = this.f10103h.ordinal();
        long r12 = 0;
        if (r11 != 0) goto L11;
    L47:
        tm.b r13 = this.f10104i;
        if (r13 == null) goto L59;
        if (r10.c(r13) == false) goto L59;
        if (r10.f22149n != r13.f22149n) goto L59;
        if (this.f10103h != LynxKeyframeAnimator$LynxKFAnimatorState.f10078a) goto L59;
        if (k() == true) goto L59;
        return;
    L59:
        if (r10.f22146k >= 0) goto L61;
        return;
    L61:
        if (r10.f22141b <= 0) goto L71;
        e(r10);
        return;
    L71:
        return;
    L11:
        if (r11 != 1) goto L13;
    L17:
        tm.b r14 = this.f10104i;
        if (r14 != null) goto L20;
    L26:
        tm.b r15 = this.f10104i;
        if (r10.c(r15) == true) goto L29;
    L45:
        d();
        c(r10);
        return;
    L29:
        if (r10.f22149n == r15.f22149n) goto L45;
        if (this.f10103h != LynxKeyframeAnimator$LynxKFAnimatorState.f10080c) goto L43;
        this.f10103h = LynxKeyframeAnimator$LynxKFAnimatorState.f10079b;
        ObjectAnimator[] r16 = this.g;
        if (r16 == null) goto L37;
        int r17 = r16.length;
        int r18 = 0;
    L35:
        if (r18 >= r17) goto L37;
        r16[r18].resume();
        r18 = r18 + 1;
    L37:
        long r19 = this.e;
        e r20 = this.f10100a;
        if (r20.f10098b == (-1)) goto L41;
        r12 = System.currentTimeMillis() - r20.f10098b;
        r20.f10098b = -1;
    L41:
        this.e = r19 + r12;
        this.f10104i = r10;
        return;
    L43:
        i(r10);
        return;
    L20:
        if (r10.c(r14) == false) goto L26;
        if (r10.f22149n != r14.f22149n) goto L26;
        if (k() == true) goto L26;
        return;
    L13:
        if (r11 == 2) goto L17;
        if (r11 == 3) goto L47;
        return;
    }

    public final void d() {
        LynxKeyframeAnimator$LynxKFAnimatorState r5 = this.f10103h;
        if (r5 != LynxKeyframeAnimator$LynxKFAnimatorState.f10079b) goto L5;
    L7:
        ObjectAnimator[] r10 = this.g;
        if (r10 != null) goto L10;
    L14:
        this.g = null;
        this.f10103h = LynxKeyframeAnimator$LynxKFAnimatorState.d;
        return;
    L10:
        if (r10.length <= 0) goto L14;
        int r11 = r10.length;
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L14;
        r10[r12].cancel();
        r12 = r12 + 1;
        goto L12
    L5:
        if (r5 == LynxKeyframeAnimator$LynxKFAnimatorState.f10080c) goto L7;
    }

    public final void e(tm.b r29) {
        g r5 = this;
        tm.b r10 = r29;
        LynxKeyframeAnimator$LynxKFAnimatorState r11 = LynxKeyframeAnimator$LynxKFAnimatorState.f10078a;
        View r12 = (View) r5.f10102c.get();
        LynxUI r13 = (LynxUI) r5.f10101b.get();
        if (r12 == null) goto L341;
        if (r13 == null) goto L342;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r5.f != null) goto L10;
    L13:
        ReadableMap r14 = r13.getKeyframes(r10.f22140a);
        if (r14 == null) goto L49;
        c r15 = new c();
        ReadableMapKeySetIterator r16 = r14.keySetIterator();
    L17:
        boolean r17 = r16.hasNextKey();
        ArrayList r18 = r15.f10090i;
        ArrayList r19 = r15.f10089h;
        ArrayList r110 = r15.g;
        ArrayList r20 = r15.f;
        ArrayList r21 = r15.e;
        ArrayList r22 = r15.d;
        ArrayList r23 = r15.f10088c;
        ArrayList r24 = r15.f10087b;
        View r111 = r12;
        ArrayList r25 = r15.f10086a;
        ArrayList r112 = r18;
        ArrayList r113 = r15.f10091j;
        String r114 = "Color";
        String r26 = "BackgroundColor";
        String r115 = "Alpha";
        ArrayList r27 = r19;
        if (r17 == false) goto L92;
        String r116 = r16.nextKey();
        float r28 = Float.parseFloat(r116);
        int r117 = r10.f22148m;
        ReadableMapKeySetIterator r210 = r16;
        if (r117 == 1) goto L25;
        if (r117 == 3) goto L25;
    L24:
        float r118 = r28;
        ReadableMap r119 = r14.getMap(r116);
        ReadableMapKeySetIterator r120 = r119.keySetIterator();
    L28:
        if (r120.hasNextKey() == false) goto L91;
        r14 = r14;
        String r30 = r120.nextKey();
        r120 = r120;
        boolean r121 = r30.equals("opacity");
        HashMap r31 = r5.d;
        if (r121 == false) goto L42;
        Float r122 = Float.valueOf(((View) r5.f10102c.get()).getAlpha());
        if (r31.containsKey(r115) == true) goto L34;
        r31.put(r115, r122);
    L34:
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.f10075i, r15);
        String r211 = r115;
        float r32 = (float) r119.getDouble(r30);
        if (r32 < 0.0f) goto L49;
        if (r32 > 1.0f) goto L49;
        r25.add(Keyframe.ofFloat(r118, r32));
    L41:
        r115 = r211;
        goto L28
    L42:
        r211 = r115;
        if (r30.equals("transform") == false) goto L77;
        List<o> r123 = r13.getTransformRaws();
        if (r31.containsKey("Transform") == true) goto L47;
        r31.put("Transform", r123);
    L47:
        ArrayList r33 = o.b(r119.getArray(r30));
        r13.getLynxContext().f10145m.getFontSize();
        r13.getFontSize();
        r13.getLynxContext().f10145m.getLatestWidth();
        r13.getLynxContext().f10145m.getLatestHeight();
        n r34 = n.n(r33, r13.getLatestWidth(), r13.getLatestHeight());
        if (r34 == null) goto L49;
        if (r33 != null) goto L53;
    L68:
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.f10071a, r15);
        LinkedHashMap r35 = (LinkedHashMap) r34.f10761a;
        Float r124 = (Float) r35.get("translateX");
        if (r124 == null) goto L71;
        float r125 = r124.floatValue();
    L72:
        r24.add(Keyframe.ofFloat(r118, r125));
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.f10072b, r15);
        Float r36 = (Float) r35.get("translateY");
        if (r36 == null) goto L75;
        float r37 = r36.floatValue();
    L76:
        r23.add(Keyframe.ofFloat(r118, r37));
        r13.getView().setOutlineProvider(null);
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.f10073c, r15);
        r22.add(Keyframe.ofFloat(r118, r34.w()));
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.f, r15);
        r21.add(Keyframe.ofFloat(r118, r34.f()));
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.d, r15);
        r20.add(Keyframe.ofFloat(r118, r34.s()));
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.e, r15);
        r110.add(Keyframe.ofFloat(r118, r34.t()));
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.g, r15);
        r27.add(Keyframe.ofFloat(r118, r34.u()));
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.f10074h, r15);
        r112.add(Keyframe.ofFloat(r118, r34.v()));
        goto L41
    L75:
        r37 = 0.0f;
        goto L76
    L71:
        r125 = 0.0f;
        goto L72
    L53:
        if (r33.isEmpty() == true) goto L68;
        Iterator r38 = r33.iterator();
    L57:
        if (r38.hasNext() == false) goto L68;
        o r126 = (o) r38.next();
        Iterator r212 = r38;
        if (r126.d == 1) goto L66;
        if (r126.g == 1) goto L66;
        if (r126.f10766i == 1) goto L66;
        r38 = r212;
    L66:
        r15.f10092k = true;
        goto L68
    L77:
        ArrayList r127 = r27;
        if (r30.equals("background-color") == true) goto L80;
        r27 = r127;
        String r128 = r26;
    L89:
        r26 = r128;
        goto L41
    L80:
        if (h() != null) goto L85;
        Integer r129 = Integer.valueOf(r13.getBackgroundColor());
        r27 = r127;
        r128 = r26;
        if (r31.containsKey(r128) == true) goto L84;
        r31.put(r128, r129);
    L84:
        LynxUI r213 = r13;
        String r39 = r114;
    L88:
        b(r118, LynxKeyframeAnimator$LynxAnimationPropertyType.f10076j, r15);
        r113.add(Keyframe.ofInt(r118, r119.getInt(r30)));
        r114 = r39;
        r13 = r213;
        goto L89
    L85:
        r27 = r127;
        r128 = r26;
        Integer r130 = Integer.valueOf(r13.getBackgroundColor());
        r213 = r13;
        r39 = r114;
        if (r31.containsKey(r39) == true) goto L88;
        r31.put(r39, r130);
        goto L88
    L91:
        r10 = r29;
        r12 = r111;
        r16 = r210;
    L25:
        r28 = 1.0f - r28;
        goto L24
    L92:
        String r214 = "Alpha";
        ArrayList r40 = r113;
        String r131 = r26;
        LynxUI r215 = r13;
        String r41 = r114;
        if (h() == null) goto L95;
        int r42 = 2;
    L96:
        int r132 = 0;
    L97:
        if (r132 >= r42) goto L234;
        View r133 = (View) r5.f10102c.get();
        LynxUI r134 = (LynxUI) r5.f10101b.get();
        if (r133 == null) goto L101;
        if (r134 == null) goto L101;
        ArrayList r43 = new ArrayList();
        r41 = r41;
        String r44 = r131;
        ca.d r45 = new ca.d(12);
        int r135 = r25.size();
        HashSet r136 = r15.f10094m;
        int r216 = r42;
        HashSet r46 = r15.f10093l;
        if (r135 == 0) goto L113;
        if (r132 != 0) goto L113;
        LynxKeyframeAnimator$LynxAnimationPropertyType r137 = LynxKeyframeAnimator$LynxAnimationPropertyType.f10075i;
        if (r46.contains(r137) == true) goto L110;
        r25.add(Keyframe.ofFloat(0.0f, r133.getAlpha()));
    L110:
        if (r136.contains(r137) == true) goto L112;
        r25.add(Keyframe.ofFloat(1.0f, r133.getAlpha()));
    L112:
        Collections.sort(r25, r45);
        String r47 = r214;
        r43.add(a(r47, r25));
    L115:
        if (r24.size() == 0) goto L125;
        if (r132 != 0) goto L125;
        LynxKeyframeAnimator$LynxAnimationPropertyType r138 = LynxKeyframeAnimator$LynxAnimationPropertyType.f10071a;
        if (r46.contains(r138) == true) goto L122;
        r24.add(Keyframe.ofFloat(0.0f, r133.getTranslationX()));
    L122:
        if (r136.contains(r138) == true) goto L124;
        r24.add(Keyframe.ofFloat(1.0f, r133.getTranslationX()));
    L124:
        Collections.sort(r24, r45);
        r43.add(a("TranslationX", r24));
    L127:
        if (r23.size() == 0) goto L137;
        if (r132 != 0) goto L137;
        LynxKeyframeAnimator$LynxAnimationPropertyType r48 = LynxKeyframeAnimator$LynxAnimationPropertyType.f10072b;
        if (r46.contains(r48) == true) goto L133;
        r23.add(Keyframe.ofFloat(0.0f, r133.getTranslationY()));
    L133:
        if (r136.contains(r48) == true) goto L135;
        r23.add(Keyframe.ofFloat(1.0f, r133.getTranslationY()));
    L135:
        Collections.sort(r23, r45);
        r43.add(a("TranslationY", r23));
    L137:
        if (r22.size() == 0) goto L148;
        if (r132 != 0) goto L148;
        float r49 = r133.getTranslationZ();
        LynxKeyframeAnimator$LynxAnimationPropertyType r139 = LynxKeyframeAnimator$LynxAnimationPropertyType.f10073c;
        if (r46.contains(r139) == true) goto L143;
        r22.add(Keyframe.ofFloat(0.0f, r49));
    L143:
        if (r136.contains(r139) == true) goto L145;
        r22.add(Keyframe.ofFloat(1.0f, r49));
    L145:
        Collections.sort(r22, r45);
        r43.add(a("TranslationZ", r22));
    L148:
        if (r21.size() == 0) goto L158;
        if (r132 != 0) goto L158;
        LynxKeyframeAnimator$LynxAnimationPropertyType r50 = LynxKeyframeAnimator$LynxAnimationPropertyType.f;
        if (r46.contains(r50) == true) goto L154;
        r21.add(Keyframe.ofFloat(0.0f, r133.getRotation()));
    L154:
        if (r136.contains(r50) == true) goto L156;
        r21.add(Keyframe.ofFloat(1.0f, r133.getRotation()));
    L156:
        Collections.sort(r21, r45);
        r43.add(a("Rotation", r21));
    L158:
        if (r20.size() == 0) goto L168;
        if (r132 != 0) goto L168;
        LynxKeyframeAnimator$LynxAnimationPropertyType r51 = LynxKeyframeAnimator$LynxAnimationPropertyType.d;
        if (r46.contains(r51) == true) goto L164;
        r20.add(Keyframe.ofFloat(0.0f, r133.getRotationX()));
    L164:
        if (r136.contains(r51) == true) goto L166;
        r20.add(Keyframe.ofFloat(1.0f, r133.getRotationX()));
    L166:
        Collections.sort(r20, r45);
        r43.add(a("RotationX", r20));
    L168:
        if (r110.size() == 0) goto L178;
        if (r132 != 0) goto L178;
        LynxKeyframeAnimator$LynxAnimationPropertyType r52 = LynxKeyframeAnimator$LynxAnimationPropertyType.e;
        if (r46.contains(r52) == true) goto L174;
        r110.add(Keyframe.ofFloat(0.0f, r133.getRotationY()));
    L174:
        if (r136.contains(r52) == true) goto L176;
        r110.add(Keyframe.ofFloat(1.0f, r133.getRotationY()));
    L176:
        Collections.sort(r110, r45);
        r43.add(a("RotationY", r110));
    L178:
        if (r27.size() == 0) goto L188;
        if (r132 != 0) goto L188;
        LynxKeyframeAnimator$LynxAnimationPropertyType r53 = LynxKeyframeAnimator$LynxAnimationPropertyType.g;
        if (r46.contains(r53) == true) goto L183;
        ArrayList r140 = r27;
        r140.add(Keyframe.ofFloat(0.0f, r133.getScaleX()));
    L185:
        if (r136.contains(r53) == true) goto L187;
        r140.add(Keyframe.ofFloat(1.0f, r133.getScaleX()));
    L187:
        Collections.sort(r140, r45);
        r43.add(a("ScaleX", r140));
    L190:
        if (r112.size() == 0) goto L200;
        if (r132 != 0) goto L200;
        LynxKeyframeAnimator$LynxAnimationPropertyType r54 = LynxKeyframeAnimator$LynxAnimationPropertyType.f10074h;
        if (r46.contains(r54) == true) goto L195;
        ArrayList r141 = r112;
        r141.add(Keyframe.ofFloat(0.0f, r133.getScaleY()));
    L197:
        if (r136.contains(r54) == true) goto L199;
        r141.add(Keyframe.ofFloat(1.0f, r133.getScaleY()));
    L199:
        Collections.sort(r141, r45);
        r43.add(a("ScaleY", r141));
    L202:
        if (r40.size() == 0) goto L220;
        int r55 = r216;
        if ((r132 + 1) != r55) goto L219;
        LynxKeyframeAnimator$LynxAnimationPropertyType r56 = LynxKeyframeAnimator$LynxAnimationPropertyType.f10076j;
        if (r46.contains(r56) == true) goto L208;
        ArrayList r142 = r40;
        r142.add(Keyframe.ofInt(0.0f, r134.getBackgroundColor()));
    L210:
        if (r136.contains(r56) == true) goto L213;
        r142.add(Keyframe.ofInt(1.0f, r134.getBackgroundColor()));
    L213:
        Collections.sort(r142, r45);
        if (r132 != 0) goto L216;
        r44 = r44;
        PropertyValuesHolder r143 = a(r44, r142);
        r41 = r41;
    L217:
        r143.setEvaluator(new ArgbEvaluator());
        r43.add(r143);
    L222:
        if (r43.size() == 0) goto L224;
        PropertyValuesHolder[] r57 = (PropertyValuesHolder[]) r43.toArray(new PropertyValuesHolder[r43.size()]);
    L225:
        if (r57 != null) goto L228;
        c r58 = r15;
    L227:
        int r144 = 1;
    L233:
        r132 = r132 + r144;
        r5 = this;
        r27 = r140;
        r112 = r141;
        r131 = r44;
        r42 = r55;
        r15 = r58;
        r25 = r25;
        r23 = r23;
        r214 = r47;
        r40 = r142;
        goto L97
    L228:
        if (r132 != 0) goto L230;
        r58 = r15;
        r58.f10095n = r57;
        goto L227
    L230:
        r58 = r15;
        r144 = 1;
        if (r132 != 1) goto L233;
        r58.f10096o = r57;
    L224:
        r57 = null;
        goto L225
    L216:
        r44 = r44;
        r41 = r41;
        r143 = a(r41, r142);
        goto L217
    L208:
        r142 = r40;
    L219:
        r142 = r40;
        goto L222
    L220:
        r55 = r216;
        goto L219
    L195:
        r141 = r112;
    L200:
        r141 = r112;
        goto L202
    L183:
        r140 = r27;
    L188:
        r140 = r27;
    L125:
        r25 = r25;
    L113:
        r40 = r40;
        r15 = r15;
        r47 = r214;
    L101:
        r23 = r23;
        r142 = r40;
        r15 = r15;
        r140 = r27;
        r47 = r214;
        r55 = r42;
        r25 = r25;
        r44 = r131;
        r141 = r112;
        goto L224
    L234:
        int r145 = 1;
        r5.f = r15;
    L235:
        long r59 = r5.e;
        long r60 = 0;
        if (r59 == (-1)) goto L244;
        tm.b r61 = r29;
        if (r61.f22149n != r145) goto L245;
        e r62 = r5.f10100a;
        if (r62.f10098b != (-1)) goto L242;
        long r63 = 0;
    L243:
        r5.e = r59 + r63;
        goto L245
    L242:
        r63 = System.currentTimeMillis() - r62.f10098b;
        r62.f10098b = -1;
    L245:
        BackgroundDrawable r64 = h();
        if (r64 == null) goto L248;
        int r146 = 2;
    L249:
        ObjectAnimator[] r65 = new ObjectAnimator[r146];
        int r66 = 0;
        int r67 = 0;
    L250:
        if (r66 >= r146) goto L288;
        if (r66 != 1) goto L254;
        PropertyValuesHolder[] r147 = r5.f.f10096o;
    L255:
        if (r147 != null) goto L257;
        int r68 = 1;
    L287:
        r66 = r66 + r68;
        r60 = 0;
        goto L250
    L257:
        if (r66 != 1) goto L259;
        Object r148 = r64;
    L260:
        ObjectAnimator r149 = ObjectAnimator.ofPropertyValuesHolder(r148, r147);
        r149.addUpdateListener(new t(r5, 3));
        r65[r66] = r149;
        r149.setDuration(r61.f22141b);
        r149.setRepeatCount(r61.f22146k);
        int r150 = r61.f22148m;
        if (r150 == 2) goto L265;
        if (r150 == 3) goto L265;
        r149.setRepeatMode(1);
    L266:
        r149.setInterpolator(tm.e.a(r29));
        if (r61.f22142c == r60) goto L274;
        int r151 = r61.f22147l;
        if (r151 == 2) goto L273;
        if (r151 == 3) goto L273;
        int r152 = 1;
    L276:
        r67 = r67 + r152;
        long r153 = r61.f22142c;
        if (r153 < r60) goto L279;
        r149.setStartDelay(r153);
    L281:
        if (r5.e == (-1)) goto L286;
        long r154 = System.currentTimeMillis() - r5.e;
        long r69 = r61.f22142c;
        if (r154 >= r69) goto L285;
        r149.setStartDelay(r69 - r154);
        goto L286
    L285:
        r149.setCurrentPlayTime(r154 - r69);
    L286:
        r149.start();
        r68 = 1;
        goto L287
    L279:
        r149.setCurrentPlayTime(r153 * (-1));
    L273:
        ObjectAnimator r155 = r149.clone();
        r155.setDuration(10000000);
        r155.addListener(new f(0));
        r155.start();
    L274:
        r152 = 1;
    L265:
        r149.setRepeatMode(2);
        goto L266
    L259:
        r148 = r111;
        goto L260
    L254:
        r147 = r5.f.f10095n;
        goto L255
    L288:
        int r156 = 0;
        if (r67 != 0) goto L292;
        r5.g = null;
    L301:
        ObjectAnimator[] r70 = r5.g;
        if (r70 == null) goto L308;
        int r71 = r70.length;
        if (r71 <= 0) goto L308;
        r70[r71 - 1].addListener(new b(r5));
    L308:
        if (r5.e != (-1)) goto L311;
        r5.e = System.currentTimeMillis();
    L311:
        if (g(r29) == false) goto L313;
    L318:
        r5.f10104i = r61;
        return;
    L313:
        if (r5.f10103h != LynxKeyframeAnimator$LynxKFAnimatorState.f10078a) goto L315;
        b.a(r215, "animationstart", r61.f22140a);
    L315:
        r5.f10103h = LynxKeyframeAnimator$LynxKFAnimatorState.f10079b;
        if (r61.f22149n != 0) goto L318;
        i(r29);
        goto L318
    L292:
        if (r67 != r146) goto L294;
        r5.g = r65;
        goto L301
    L294:
        r5.g = new ObjectAnimator[r67];
        int r72 = 0;
    L295:
        if (r156 >= r146) goto L301;
        ObjectAnimator r73 = r65[r156];
        if (r73 == null) goto L299;
        int r74 = 1;
        r5.g[r72] = r73;
        r72 = r72 + 1;
    L300:
        r156 = r156 + r74;
        goto L295
    L299:
        r74 = 1;
        goto L300
    L248:
        r146 = 1;
        goto L249
    L244:
        r61 = r29;
        goto L245
    L95:
        r42 = 1;
    L49:
        LynxLog.b(4, LynxMonitorService.DEFAULT_PID, "Keyframes input error.");
        return;
    L10:
        if (k() == true) goto L13;
        r111 = r12;
        r215 = r13;
        r145 = 1;
        goto L235
    L342:
        return;
    }

    public final void f() {
        LynxKeyframeAnimator$LynxKFAnimatorState r5 = this.f10103h;
        if (r5 != LynxKeyframeAnimator$LynxKFAnimatorState.d) goto L5;
    L8:
        LynxUI r10 = (LynxUI) this.f10101b.get();
        tm.b r11 = this.f10104i;
        if (r11 == null) goto L11;
        String r12 = r11.f22140a;
    L12:
        b.a(r10, "animationcancel", r12);
    L13:
        d();
        j();
        this.f10103h = LynxKeyframeAnimator$LynxKFAnimatorState.e;
        return;
    L11:
        r12 = "";
        goto L12
    L5:
        if (r5 == LynxKeyframeAnimator$LynxKFAnimatorState.f10079b) goto L8;
        if (r5 != LynxKeyframeAnimator$LynxKFAnimatorState.f10080c) goto L13;
        goto L8
    }

    public final boolean g(tm.b r10) {
        if (this.e != (-1)) goto L5;
        return false;
    L5:
        int r5 = r10.f22146k;
        if (r5 < 9.99999999E8d) goto L8;
        long r11 = Long.MAX_VALUE;
    L10:
        if ((System.currentTimeMillis() - this.e) < r11) goto L12;
        return true;
    L12:
        return false;
    L8:
        r11 = (r10.f22141b * ((long) (r5 + 1))) + r10.f22142c;
        goto L10
    }

    public final BackgroundDrawable h() {
        LynxUI r5 = (LynxUI) this.f10101b.get();
        if (r5 != null) goto L5;
        return null;
    L5:
        com.lynx.tasm.behavior.ui.utils.b r10 = r5.getBackgroundManager();
        if (r10 != null) goto L8;
        return null;
    L8:
        return (BackgroundDrawable) r10.f10750b;
    }

    public final void i(tm.b r10) {
        int r5 = r10.f22149n;
        this.f10103h = LynxKeyframeAnimator$LynxKFAnimatorState.f10080c;
        ObjectAnimator[] r11 = this.g;
        if (r11 == null) goto L8;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L8;
        r11[r13].pause();
        r13 = r13 + 1;
    L8:
        if (g(r10) == true) goto L12;
        e r14 = this.f10100a;
        if (r14.f10098b != (-1)) goto L12;
        r14.f10098b = System.currentTimeMillis();
    L12:
        this.f10104i = r10;
    }

    public final void j() {
        View r5 = (View) this.f10102c.get();
        LynxUI r10 = (LynxUI) this.f10101b.get();
        if (r10 == null) goto L36;
        if (r5 == null) goto L50;
        Iterator r11 = this.d.entrySet().iterator();
    L8:
        if (r11.hasNext() == false) goto L51;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();
        r13.getClass();
        byte r14 = -1;
        switch(r13.hashCode()) {
            case -1238332596: goto L25;
            case 63357246: goto L21;
            case 65290051: goto L17;
            case 290107061: goto L13;
            default: goto L28;
        };
    L28:
        switch(r14) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L31;
            case 3: goto L30;
            default: goto L8;
        };
    L30:
        r5.setBackgroundColor(((Integer) r12.getValue()).intValue());
        goto L8
    L31:
        h().setColor(((Integer) r12.getValue()).intValue());
        goto L8
    L32:
        r5.setAlpha(((Float) r12.getValue()).floatValue());
        goto L8
    L34:
        if (r10.getBackgroundManager() == null) goto L8;
        r10.getBackgroundManager().o((List) r12.getValue());
        goto L8
    L13:
        if (r13.equals("BackgroundColor") == false) goto L28;
        r14 = 3;
        goto L28
    L17:
        if (r13.equals("Color") == false) goto L28;
        r14 = 2;
        goto L28
    L21:
        if (r13.equals("Alpha") == false) goto L28;
        r14 = 1;
        goto L28
    L25:
        if (r13.equals("Transform") == false) goto L28;
        r14 = 0;
        goto L28
    L51:
        return;
    L50:
        return;
    }

    public final boolean k() {
        LynxUI r5 = (LynxUI) this.f10101b.get();
        c r10 = this.f;
        if (r10 != null) goto L5;
    L7:
        m r11 = ((LynxUI) this.f10101b.get()).getTransformOriginStr();
        if (r11 != null) goto L10;
        return false;
    L10:
        if (r11.f10759b != 1) goto L13;
    L14:
        if (r5 != null) goto L16;
        return false;
    L16:
        if (r5.hasSizeChanged() == false) goto L22;
        return true;
    L22:
        return false;
    L13:
        if (r11.d == 1) goto L14;
        return false;
    L5:
        if (r10.f10092k == false) goto L7;
        goto L7
    }
}
