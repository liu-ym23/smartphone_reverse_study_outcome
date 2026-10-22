package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.bytedance.crash.entity.EventBody;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u001a\u0010\n\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t\u001a\u001a\u0010\r\u001a\u00020\u000b*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0005¨\u0006\u000e"}, d2 = {"buildMethodName", "", "propertyName", "buildSetterMethodName", "getPropertyValue", "", "Landroid/view/View;", "isValidColorValue", "", "", "setColorPropertyValue", "", EventBody.KEY_VALUE, "setPropertyValue", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class h {
    public static final Object a(View r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "$this$getPropertyValue");
        Intrinsics.checkNotNullParameter(r8, "propertyName");
        AnimationProperty.FloatProperty[] r0 = AnimationProperty.FloatProperty.values();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L21;
        AnimationProperty.FloatProperty r4 = r0[r3];
        r3 = r3 + 1;
        if (Intrinsics.areEqual(r4.getPropertyName(), r8) == false) goto L3;
        switch(i.f16375a[r4.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            default: goto L64;
        };
    L9:
        float r9 = r7.getAlpha();
    L20:
        return Float.valueOf(r9);
    L10:
        r9 = r7.getRotationY();
        goto L20
    L11:
        r9 = r7.getRotationX();
        goto L20
    L12:
        r9 = r7.getTranslationY();
        goto L20
    L13:
        r9 = r7.getTranslationX();
        goto L20
    L14:
        r9 = r7.getRotation();
        goto L20
    L15:
        r9 = r7.getScaleY();
        goto L20
    L16:
        r9 = r7.getScaleX();
        goto L20
    L17:
        r9 = r7.getY();
        goto L20
    L18:
        r9 = r7.getX();
        goto L20
    L64:
        return Unit.INSTANCE;
    L21:
        AnimationProperty.IntProperty[] r2 = AnimationProperty.IntProperty.values();
        int r5 = r2.length;
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L57;
        AnimationProperty.IntProperty r10 = r2[r6];
        r6 = r6 + 1;
        if (Intrinsics.areEqual(r10.getPropertyName(), r8) == false) goto L23;
        switch(i.f16376b[r10.ordinal()]) {
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L38;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L30;
            default: goto L29;
        };
    L30:
        int r11 = r7.getHeight();
    L49:
        return Integer.valueOf(r11);
    L31:
        r11 = r7.getWidth();
        goto L49
    L33:
        Drawable r12 = r7.getBackground();
        if (ZeusTransformUtils.instanceOf(r12, ShapeDrawable.class) == false) goto L65;
        Paint r13 = ((ShapeDrawable) ZeusTransformUtils.preCheckCast(r12, ShapeDrawable.class, "com.obric.memorydata.plugin")).getPaint();
        Intrinsics.checkNotNullExpressionValue(r13, "paint");
        if (r13.getStyle() != Paint.Style.FILL) goto L66;
    L42:
        r11 = r13.getColor();
        goto L49
    L66:
        return null;
    L65:
        return null;
    L38:
        Drawable r14 = r7.getBackground();
        if (ZeusTransformUtils.instanceOf(r14, ShapeDrawable.class) == false) goto L67;
        r13 = ((ShapeDrawable) ZeusTransformUtils.preCheckCast(r14, ShapeDrawable.class, "com.obric.memorydata.plugin")).getPaint();
        Intrinsics.checkNotNullExpressionValue(r13, "paint");
        if (r13.getStyle() == Paint.Style.STROKE) goto L42;
        return null;
    L67:
        return null;
    L46:
        Drawable r15 = r7.getBackground();
        if (ZeusTransformUtils.instanceOf(r15, ColorDrawable.class) == false) goto L70;
        r11 = ((ColorDrawable) ZeusTransformUtils.preCheckCast(r15, ColorDrawable.class, "com.obric.memorydata.plugin")).getColor();
        goto L49
    L70:
        return null;
    L29:
        throw new NoWhenBranchMatchedException();
    L44:
        if (ZeusTransformUtils.instanceOf(r7, TextView.class) == false) goto L69;
        ColorStateList r16 = ((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.memorydata.plugin")).getTextColors();
        Intrinsics.checkNotNullExpressionValue(r16, "this.textColors");
        r11 = r16.getDefaultColor();
        goto L49
    L69:
        return null;
    L57:
        Method r17 = r7.getClass().getMethod(a(r8), new Class[0]);     // Catch: Exception -> L52 NoSuchMethodException -> L54
        Intrinsics.checkNotNullExpressionValue(r17, "this.javaClass.getMethod(methodName)");     // Catch: Exception -> L52 NoSuchMethodException -> L54
        return r17.invoke(r7, new Object[0]);
    L54:
        e = move-exception;
        e.printStackTrace();
    L56:
        return null;
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L56
    }

    private static final String a(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        StringBuilder r1 = new StringBuilder().append("get").append(Character.toUpperCase(r4.charAt(0)));
        String r5 = r4.substring(1);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).substring(startIndex)");
        return r1.append(r5).toString();
    L9:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    public static final void a(View r5, String r6, Object r7) {
        Intrinsics.checkNotNullParameter(r5, "$this$setPropertyValue");
        Intrinsics.checkNotNullParameter(r6, "propertyName");
        Intrinsics.checkNotNullParameter(r7, EventBody.KEY_VALUE);
        if (Intrinsics.areEqual(r6, "x") == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L127;
        r5.setX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L127:
        return;
    L8:
        if (Intrinsics.areEqual(r6, "y") == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L129;
        r5.setY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L129:
        return;
    L13:
        if (Intrinsics.areEqual(r6, "alpha") == false) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L131;
        r5.setAlpha(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L131:
        return;
    L18:
        if (Intrinsics.areEqual(r6, Key.ROTATION) == false) goto L23;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L133;
        r5.setRotation(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L133:
        return;
    L23:
        if (Intrinsics.areEqual(r6, "scaleX") == false) goto L28;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L135;
        r5.setScaleX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L135:
        return;
    L28:
        if (Intrinsics.areEqual(r6, "scaleY") == false) goto L33;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L137;
    L31:
        r5.setScaleY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L137:
        return;
    L33:
        if (Intrinsics.areEqual(r6, "translationX") == false) goto L38;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L139;
        r5.setTranslationX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L139:
        return;
    L38:
        if (Intrinsics.areEqual(r6, "translationY") == false) goto L43;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L141;
        r5.setTranslationY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L141:
        return;
    L43:
        if (Intrinsics.areEqual(r6, "rotationX") == false) goto L48;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L143;
        r5.setRotationX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L143:
        return;
    L48:
        if (Intrinsics.areEqual(r6, "rotationY") == false) goto L53;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L145;
        r5.setRotationY(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        return;
    L145:
        return;
    L53:
        if (Intrinsics.areEqual(r6, "scale") == false) goto L58;
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L147;
        r5.setScaleX(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L31
    L147:
        return;
    L58:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.BACKGROUND_COLOR.getPropertyName()) == false) goto L63;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L148;
        r5.setBackgroundColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L148:
        return;
    L63:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.TEXT_COLOR.getPropertyName()) == false) goto L70;
        if (ZeusTransformUtils.instanceOf(r5, TextView.class) == true) goto L67;
        return;
    L67:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L151;
        ((TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.memorydata.plugin")).setTextColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue());
        return;
    L151:
        return;
    L70:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.STROKE_COLOR.getPropertyName()) == false) goto L79;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L153;
        Drawable r8 = r5.getBackground();
        if (ZeusTransformUtils.instanceOf(r8, ShapeDrawable.class) == false) goto L154;
        Paint r9 = ((ShapeDrawable) ZeusTransformUtils.preCheckCast(r8, ShapeDrawable.class, "com.obric.memorydata.plugin")).getPaint();
        Intrinsics.checkNotNullExpressionValue(r9, "paint");
        if (r9.getStyle() != Paint.Style.STROKE) goto L155;
    L77:
        r9.setColor(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue());
        r5.invalidate();
        return;
    L155:
        return;
    L154:
        return;
    L153:
        return;
    L79:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.FILL_COLOR.getPropertyName()) == true) goto L81;
        int r2 = 0;
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.WIDTH.getPropertyName()) == false) goto L99;
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L160;
        ViewGroup.LayoutParams r10 = r5.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.LayoutParams.class) == true) goto L94;
        return;
    L94:
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L96;
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
    L96:
        r10.width = r2;
    L97:
        r5.setLayoutParams(r10);
        r5.requestLayout();
        return;
    L160:
        return;
    L99:
        if (Intrinsics.areEqual(r6, AnimationProperty.IntProperty.HEIGHT.getPropertyName()) == true) goto L101;
        String r11 = b(r6);     // Catch: Exception -> L120 NoSuchMethodException -> L122
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L112;
        Class<?> r0 = Integer.TYPE;     // Catch: Exception -> L120 NoSuchMethodException -> L122
    L118:
        Method r12 = r5.getClass().getMethod(r11, new Class[]{r0});     // Catch: Exception -> L120 NoSuchMethodException -> L122
        Intrinsics.checkNotNullExpressionValue(r12, "this.javaClass.getMethod(methodName, valueClass)");     // Catch: Exception -> L120 NoSuchMethodException -> L122
        r12.invoke(r5, new Object[]{r7});     // Catch: Exception -> L120 NoSuchMethodException -> L122
    L166:
        return;
    L112:
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L115;
        r0 = Float.TYPE;     // Catch: Exception -> L120 NoSuchMethodException -> L122
        goto L118
    L115:
        if (ZeusTransformUtils.instanceOf(r7, Boolean.class) == false) goto L117;
        r0 = Boolean.TYPE;     // Catch: Exception -> L120 NoSuchMethodException -> L122
        goto L118
    L117:
        r0 = r7.getClass();     // Catch: Exception -> L120 NoSuchMethodException -> L122
    L122:
        e = move-exception;
        e.printStackTrace();
        return;
    L120:
        e = move-exception;
        e.printStackTrace();
        return;
    L101:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L163;
        r10 = r5.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r10, ViewGroup.LayoutParams.class) == true) goto L105;
        return;
    L105:
        if (((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L107;
        r2 = ((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).intValue();
    L107:
        r10.height = r2;
        goto L97
    L163:
        return;
    L81:
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L157;
        Drawable r13 = r5.getBackground();
        if (ZeusTransformUtils.instanceOf(r13, ShapeDrawable.class) == false) goto L158;
        r9 = ((ShapeDrawable) ZeusTransformUtils.preCheckCast(r13, ShapeDrawable.class, "com.obric.memorydata.plugin")).getPaint();
        Intrinsics.checkNotNullExpressionValue(r9, "paint");
        if (r9.getStyle() == Paint.Style.FILL) goto L77;
        return;
    L158:
        return;
    }

    private static final String b(String r4) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        StringBuilder r1 = new StringBuilder().append("set").append(Character.toUpperCase(r4.charAt(0)));
        String r5 = r4.substring(1);
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String).substring(startIndex)");
        return r1.append(r5).toString();
    L9:
        return r4;
    L5:
        r0 = false;
        goto L6
    }
}
