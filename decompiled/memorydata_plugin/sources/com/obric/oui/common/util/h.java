package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0016\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c\u001a\u0016\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r\u001a\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\r\u001a\u0016\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r\u001a\u0016\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\r\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020!2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020!2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u0010\"\u001a\u00020\r*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010\"\u001a\u00020\r*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010\"\u001a\u00020\r*\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u0010\"\u001a\u00020\r*\u00020!2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010\"\u001a\u00020\r*\u00020!2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010\"\u001a\u00020\r*\u00020!2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u0010#\u001a\u00020\r*\u00020\u001c2\u0006\u0010$\u001a\u00020 \u001a\u0012\u0010#\u001a\u00020\r*\u00020\u001c2\u0006\u0010$\u001a\u00020\r\u001a\u0012\u0010#\u001a\u00020\r*\u00020\u001c2\u0006\u0010$\u001a\u00020\u0001\u001a\u0012\u0010#\u001a\u00020\r*\u00020!2\u0006\u0010$\u001a\u00020 \u001a\u0012\u0010#\u001a\u00020\r*\u00020!2\u0006\u0010$\u001a\u00020\r\u001a\u0012\u0010#\u001a\u00020\r*\u00020!2\u0006\u0010$\u001a\u00020\u0001\u001a\n\u0010%\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010&\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010'\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010(\u001a\u00020\u0001*\u00020\u001c\u001a\n\u0010)\u001a\u00020\u0001*\u00020\u001c\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010+\u001a\u00020\r\u001a\f\u0010,\u001a\u00020\u0001*\u00020-H\u0000\u001a\u0012\u0010.\u001a\u00020\u0001*\u00020/2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u0010.\u001a\u00020\u0001*\u00020/2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u0010.\u001a\u00020\u0001*\u00020/2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u00100\u001a\u00020\r*\u00020/2\u0006\u0010\u001a\u001a\u00020 \u001a\u0012\u00100\u001a\u00020\r*\u00020/2\u0006\u0010\u001a\u001a\u00020\r\u001a\u0012\u00100\u001a\u00020\r*\u00020/2\u0006\u0010\u001a\u001a\u00020\u0001\u001a\u0012\u00101\u001a\u00020\r*\u00020/2\u0006\u0010$\u001a\u00020 \u001a\u0012\u00101\u001a\u00020\r*\u00020/2\u0006\u0010$\u001a\u00020\r\u001a\u0012\u00101\u001a\u00020\r*\u00020/2\u0006\u0010$\u001a\u00020\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"+\u0010\u0005\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"+\u0010\f\u001a\u00020\r\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010\"\"\u0010\u0011\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"+\u0010\u0013\u001a\u00020\u0001\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b\"+\u0010\u0016\u001a\u00020\r\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u0002H\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u0010¨\u00062"}, d2 = {TypedValues.Custom.S_COLOR, "", "", "getColor", "(Ljava/lang/String;)I", "dp", ExifInterface.GPS_DIRECTION_TRUE, "", "getDp$annotations", "(Ljava/lang/Number;)V", "getDp", "(Ljava/lang/Number;)I", "dpFloat", "", "getDpFloat$annotations", "getDpFloat", "(Ljava/lang/Number;)F", "px", "getPx", "sp", "getSp$annotations", "getSp", "spFloat", "getSpFloat$annotations", "getSpFloat", "dp2px", "dpValue", "context", "Landroid/content/Context;", "density", "dp2pxFloat", "cdp", "", "Landroid/content/res/Resources;", "cdpFloat", "cspFloat", "spValue", "getAppScreenHeight", "getRealScreenHeight", "getRealScreenWidth", "getScreenHeight", "getScreenWidth", "px2dp", "pxValue", "toInt", "", "vdp", "Landroid/view/View;", "vdpFloat", "vspFloat", "OUI_standardRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class h {
    public static final float a(float r1) {
        return r1 * Resources.getSystem().getDisplayMetrics().density;
    }

    public static final float a(float r2, float r3) {
        if (r2 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return r2 * r3;
    L5:
        r1 = false;
        goto L6
    }

    public static final float a(float r2, Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return r2 * ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().density;
    }

    public static final float a(Context r2, double r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return c(r4, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    @Deprecated(message = "use dp2px(dpValue: Int, context: Context) instead")
    public static final int a(int r1) {
        return (int) ((r1 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.widthPixels;
    }

    public static final int a(Context r2, float r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return MathKt.roundToInt(r3 / ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    }

    public static final int a(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r3 != 0) goto L6;
        return 0;
    L6:
        return b(r4, r3);
    }

    public static final int a(View r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return a(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final int a(View r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r3 * ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    L5:
        r0 = false;
        goto L6
    }

    public static final int a(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0;
    L6:
        return a(r1, r2);
    }

    public static final int a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Color.parseColor(r1);
    }

    public static final float b(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r3 != 0) goto L6;
        return 0.0f;
    L6:
        return c(r4, r3);
    }

    public static final float b(View r2, double r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0d) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0.0f;
    L9:
        return b(r2, (float) r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final float b(View r3, float r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r4, ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final float b(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r2 != 0) goto L6;
        return 0.0f;
    L6:
        return b(r1, r2);
    }

    public static final int b(float r2, float r3) {
        if (r2 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return (int) ((r2 * r3) + 0.5f);
    L5:
        r0 = false;
        goto L6
    }

    public static final int b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        DisplayMetrics r4 = ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin").getDisplayMetrics();
        if (r4 != null) goto L6;
        return 0;
    L6:
        return r4.heightPixels;
    }

    public static final int b(Context r3, float r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return 0;
    L9:
        return MathKt.roundToInt(r4 * ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDisplayMetrics().density);
    L5:
        r0 = false;
        goto L6
    }

    public static final float c(Context r4, float r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        if (r5 != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(1, r5, ZeusTransformUtils.getResources(r6, "com.obric.memorydata.plugin").getDisplayMetrics());
    L5:
        r2 = false;
        goto L6
    }

    public static final float c(View r2, float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 != 0.0f) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r3, ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getDisplayMetrics());
    L5:
        r1 = false;
        goto L6
    }

    public static final int c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (Build.VERSION.SDK_INT < 30) goto L31;
        WindowManager r0 = (WindowManager) ZeusTransformUtils.preCheckCast(r5.getSystemService(WindowManager.class), WindowManager.class, "com.obric.memorydata.plugin");
        Integer r1 = null;
        if (r0 != null) goto L7;
        WindowMetrics r2 = null;
    L8:
        if (r2 != null) goto L10;
    L9:
        Insets r3 = null;
    L14:
        if (r2 == null) goto L20;
        Rect r6 = r2.getBounds();
        if (r6 == null) goto L20;
        r1 = Integer.valueOf(r6.height());
    L20:
        if (r1 != null) goto L22;
        int r7 = b(r5);
    L23:
        int r8 = 0;
        if (r3 != null) goto L26;
        int r9 = 0;
    L27:
        if (r3 == null) goto L33;
        r8 = r3.bottom;
    L33:
        return (r7 - r9) - r8;
    L26:
        r9 = r3.top;
        goto L27
    L22:
        r7 = r1.intValue();
        goto L23
    L10:
        WindowInsets r10 = r2.getWindowInsets();
        if (r10 == null) goto L9;
        r3 = r10.getInsets(WindowInsets.Type.systemBars());
        goto L14
    L7:
        r2 = r0.getCurrentWindowMetrics();
        goto L8
    L31:
        Object r11 = r5.getSystemService("window");
        Objects.requireNonNull(r11, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager r12 = (WindowManager) ZeusTransformUtils.preCheckCast(r11, WindowManager.class, "com.obric.memorydata.plugin");
        DisplayMetrics r13 = new DisplayMetrics();
        r12.getDefaultDisplay().getMetrics(r13);
        return r13.heightPixels;
    }

    public static final float d(Context r3, float r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r4 != 0.0f) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        return 0.0f;
    L9:
        return TypedValue.applyDimension(2, r4, ZeusTransformUtils.getResources(r5, "com.obric.memorydata.plugin").getDisplayMetrics());
    L5:
        r2 = false;
        goto L6
    }
}
