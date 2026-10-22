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
import com.obric.common.oea.foundation.animation.token.AnimationProperty$FloatProperty;
import com.obric.common.oea.foundation.animation.token.AnimationProperty$IntProperty;
import java.lang.reflect.Method;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String a(String r10) {
        if (r10.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        StringBuilder r12 = new StringBuilder();
        r12.append("get");
        r12.append(Character.toUpperCase(r10.charAt(0)));
        String r13 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");
        r12.append(r13);
        return r12.toString();
    L9:
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    private static final String b(String r10) {
        if (r10.length() <= 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        StringBuilder r12 = new StringBuilder();
        r12.append("set");
        r12.append(Character.toUpperCase(r10.charAt(0)));
        String r13 = r10.substring(1);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String).substring(startIndex)");
        r12.append(r13);
        return r12.toString();
    L9:
        return r10;
    L5:
        r11 = false;
        goto L6
    }

    public static final Object c(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$getPropertyValue");
        Intrinsics.checkNotNullParameter(r11, "propertyName");
        AnimationProperty$FloatProperty[] r12 = AnimationProperty$FloatProperty.values();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L21;
        AnimationProperty$FloatProperty r15 = r12[r14];
        r14 = r14 + 1;
        if (Intrinsics.areEqual(r15.getPropertyName(), r11) == false) goto L3;
        switch(a.f3a[r15.ordinal()]) {
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
        float r16 = r10.getAlpha();
    L20:
        return Float.valueOf(r16);
    L10:
        r16 = r10.getRotationY();
        goto L20
    L11:
        r16 = r10.getRotationX();
        goto L20
    L12:
        r16 = r10.getTranslationY();
        goto L20
    L13:
        r16 = r10.getTranslationX();
        goto L20
    L14:
        r16 = r10.getRotation();
        goto L20
    L15:
        r16 = r10.getScaleY();
        goto L20
    L16:
        r16 = r10.getScaleX();
        goto L20
    L17:
        r16 = r10.getY();
        goto L20
    L18:
        r16 = r10.getX();
        goto L20
    L64:
        return Unit.INSTANCE;
    L21:
        AnimationProperty$IntProperty[] r17 = AnimationProperty$IntProperty.values();
        int r18 = r17.length;
        int r19 = 0;
    L23:
        if (r19 >= r18) goto L57;
        AnimationProperty$IntProperty r20 = r17[r19];
        r19 = r19 + 1;
        if (Intrinsics.areEqual(r20.getPropertyName(), r11) == false) goto L23;
        switch(a.f4b[r20.ordinal()]) {
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L38;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L30;
            default: goto L29;
        };
    L30:
        int r21 = r10.getHeight();
    L49:
        return Integer.valueOf(r21);
    L31:
        r21 = r10.getWidth();
        goto L49
    L33:
        Drawable r22 = r10.getBackground();
        if ((r22 instanceof ShapeDrawable) == false) goto L65;
        Paint r23 = ((ShapeDrawable) r22).getPaint();
        Intrinsics.checkNotNullExpressionValue(r23, "paint");
        if (r23.getStyle() != Paint.Style.FILL) goto L66;
    L42:
        r21 = r23.getColor();
        goto L49
    L66:
        return null;
    L65:
        return null;
    L38:
        Drawable r24 = r10.getBackground();
        if ((r24 instanceof ShapeDrawable) == false) goto L67;
        r23 = ((ShapeDrawable) r24).getPaint();
        Intrinsics.checkNotNullExpressionValue(r23, "paint");
        if (r23.getStyle() == Paint.Style.STROKE) goto L42;
        return null;
    L67:
        return null;
    L46:
        Drawable r25 = r10.getBackground();
        if ((r25 instanceof ColorDrawable) == false) goto L70;
        r21 = ((ColorDrawable) r25).getColor();
        goto L49
    L70:
        return null;
    L29:
        throw new NoWhenBranchMatchedException();
    L44:
        if ((r10 instanceof TextView) == false) goto L69;
        ColorStateList r26 = ((TextView) r10).getTextColors();
        Intrinsics.checkNotNullExpressionValue(r26, "this.textColors");
        r21 = r26.getDefaultColor();
        goto L49
    L69:
        return null;
    L57:
        Method r27 = r10.getClass().getMethod(a(r11), new Class[0]);     // Catch: Exception -> L52 NoSuchMethodException -> L54
        Intrinsics.checkNotNullExpressionValue(r27, "this.javaClass.getMethod(methodName)");     // Catch: Exception -> L52 NoSuchMethodException -> L54
        return r27.invoke(r10, new Object[0]);
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

    public static final void d(View r10, String r11, Object r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$setPropertyValue");
        Intrinsics.checkNotNullParameter(r11, "propertyName");
        Intrinsics.checkNotNullParameter(r12, EventBody.KEY_VALUE);
        if (Intrinsics.areEqual(r11, "x") == false) goto L8;
        if ((r12 instanceof Float) == false) goto L128;
        r10.setX(((Number) r12).floatValue());
        return;
    L128:
        return;
    L8:
        if (Intrinsics.areEqual(r11, "y") == false) goto L13;
        if ((r12 instanceof Float) == false) goto L130;
        r10.setY(((Number) r12).floatValue());
        return;
    L130:
        return;
    L13:
        if (Intrinsics.areEqual(r11, "alpha") == false) goto L18;
        if ((r12 instanceof Float) == false) goto L132;
        r10.setAlpha(((Number) r12).floatValue());
        return;
    L132:
        return;
    L18:
        if (Intrinsics.areEqual(r11, Key.ROTATION) == false) goto L23;
        if ((r12 instanceof Float) == false) goto L134;
        r10.setRotation(((Number) r12).floatValue());
        return;
    L134:
        return;
    L23:
        if (Intrinsics.areEqual(r11, "scaleX") == false) goto L28;
        if ((r12 instanceof Float) == false) goto L136;
        r10.setScaleX(((Number) r12).floatValue());
        return;
    L136:
        return;
    L28:
        if (Intrinsics.areEqual(r11, "scaleY") == false) goto L34;
        if ((r12 instanceof Float) == false) goto L138;
        Number r13 = (Number) r12;
    L32:
        r10.setScaleY(r13.floatValue());
        return;
    L138:
        return;
    L34:
        if (Intrinsics.areEqual(r11, "translationX") == false) goto L39;
        if ((r12 instanceof Float) == false) goto L140;
        r10.setTranslationX(((Number) r12).floatValue());
        return;
    L140:
        return;
    L39:
        if (Intrinsics.areEqual(r11, "translationY") == false) goto L44;
        if ((r12 instanceof Float) == false) goto L142;
        r10.setTranslationY(((Number) r12).floatValue());
        return;
    L142:
        return;
    L44:
        if (Intrinsics.areEqual(r11, "rotationX") == false) goto L49;
        if ((r12 instanceof Float) == false) goto L144;
        r10.setRotationX(((Number) r12).floatValue());
        return;
    L144:
        return;
    L49:
        if (Intrinsics.areEqual(r11, "rotationY") == false) goto L54;
        if ((r12 instanceof Float) == false) goto L146;
        r10.setRotationY(((Number) r12).floatValue());
        return;
    L146:
        return;
    L54:
        if (Intrinsics.areEqual(r11, "scale") == false) goto L59;
        if ((r12 instanceof Float) == false) goto L148;
        r13 = (Number) r12;
        r10.setScaleX(r13.floatValue());
        goto L32
    L148:
        return;
    L59:
        if (Intrinsics.areEqual(r11, AnimationProperty$IntProperty.BACKGROUND_COLOR.getPropertyName()) == false) goto L64;
        if ((r12 instanceof Integer) == false) goto L149;
        r10.setBackgroundColor(((Number) r12).intValue());
        return;
    L149:
        return;
    L64:
        if (Intrinsics.areEqual(r11, AnimationProperty$IntProperty.TEXT_COLOR.getPropertyName()) == false) goto L71;
        if ((r10 instanceof TextView) == true) goto L68;
        return;
    L68:
        if ((r12 instanceof Integer) == false) goto L152;
        ((TextView) r10).setTextColor(((Number) r12).intValue());
        return;
    L152:
        return;
    L71:
        if (Intrinsics.areEqual(r11, AnimationProperty$IntProperty.STROKE_COLOR.getPropertyName()) == false) goto L80;
        if ((r12 instanceof Integer) == false) goto L154;
        Drawable r14 = r10.getBackground();
        if ((r14 instanceof ShapeDrawable) == false) goto L155;
        Paint r15 = ((ShapeDrawable) r14).getPaint();
        Intrinsics.checkNotNullExpressionValue(r15, "paint");
        if (r15.getStyle() != Paint.Style.STROKE) goto L156;
    L78:
        r15.setColor(((Number) r12).intValue());
        r10.invalidate();
        return;
    L156:
        return;
    L155:
        return;
    L154:
        return;
    L80:
        if (Intrinsics.areEqual(r11, AnimationProperty$IntProperty.FILL_COLOR.getPropertyName()) == true) goto L82;
        int r16 = 0;
        if (Intrinsics.areEqual(r11, AnimationProperty$IntProperty.WIDTH.getPropertyName()) == false) goto L100;
        if ((r12 instanceof Integer) == false) goto L161;
        ViewGroup.LayoutParams r17 = r10.getLayoutParams();
        if ((r17 instanceof ViewGroup.LayoutParams) == false) goto L162;
        Number r18 = (Number) r12;
        if (r18.intValue() <= 0) goto L97;
        r16 = r18.intValue();
    L97:
        r17.width = r16;
    L98:
        r10.setLayoutParams(r17);
        r10.requestLayout();
        return;
    L162:
        return;
    L161:
        return;
    L100:
        if (Intrinsics.areEqual(r11, AnimationProperty$IntProperty.HEIGHT.getPropertyName()) == true) goto L102;
        String r19 = b(r11);     // Catch: Exception -> L121 NoSuchMethodException -> L123
        if ((r12 instanceof Integer) == false) goto L113;
        Class<?> r20 = Integer.TYPE;     // Catch: Exception -> L121 NoSuchMethodException -> L123
    L119:
        Method r21 = r10.getClass().getMethod(r19, new Class[]{r20});     // Catch: Exception -> L121 NoSuchMethodException -> L123
        Intrinsics.checkNotNullExpressionValue(r21, "this.javaClass.getMethod(methodName, valueClass)");     // Catch: Exception -> L121 NoSuchMethodException -> L123
        r21.invoke(r10, new Object[]{r12});     // Catch: Exception -> L121 NoSuchMethodException -> L123
    L167:
        return;
    L113:
        if ((r12 instanceof Float) == false) goto L116;
        r20 = Float.TYPE;     // Catch: Exception -> L121 NoSuchMethodException -> L123
        goto L119
    L116:
        if ((r12 instanceof Boolean) == false) goto L118;
        r20 = Boolean.TYPE;     // Catch: Exception -> L121 NoSuchMethodException -> L123
        goto L119
    L118:
        r20 = r12.getClass();     // Catch: Exception -> L121 NoSuchMethodException -> L123
    L123:
        e = move-exception;
        e.printStackTrace();
        return;
    L121:
        e = move-exception;
        e.printStackTrace();
        return;
    L102:
        if ((r12 instanceof Integer) == false) goto L164;
        r17 = r10.getLayoutParams();
        if ((r17 instanceof ViewGroup.LayoutParams) == false) goto L165;
        Number r22 = (Number) r12;
        if (r22.intValue() <= 0) goto L108;
        r16 = r22.intValue();
    L108:
        r17.height = r16;
        goto L98
    L165:
        return;
    L164:
        return;
    L82:
        if ((r12 instanceof Integer) == false) goto L158;
        Drawable r23 = r10.getBackground();
        if ((r23 instanceof ShapeDrawable) == false) goto L159;
        r15 = ((ShapeDrawable) r23).getPaint();
        Intrinsics.checkNotNullExpressionValue(r15, "paint");
        if (r15.getStyle() == Paint.Style.FILL) goto L78;
        return;
    L159:
        return;
    }
}
