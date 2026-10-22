package com.obric.oui.window.bean;

import android.content.res.Resources;
import android.util.TypedValue;
import ga.b;
import ga.c;
import ga.d;
import ga.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/window/bean/WindowSizeClass;", "", "", "dpSize", "I", "getDpSize", "()I", "Lga/c;", "baseGridConfig", "Lga/c;", "getBaseGridConfig", "()Lga/c;", "<init>", "(Ljava/lang/String;IILga/c;)V", "MINUS_ERROR_SIZE", "FLOATING_WINDOW", "SMALL_SPLIT_SCREEN", "SMALLER_ANDROID_SCREEN", "SMALL", "STANDARD", "NORMAL", "LARGE", "OVERSIZE", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum WindowSizeClass extends Enum<WindowSizeClass> {
    private static final /* synthetic */ WindowSizeClass[] $VALUES = null;
    public static final WindowSizeClass FLOATING_WINDOW = null;
    public static final WindowSizeClass LARGE = null;
    public static final WindowSizeClass MINUS_ERROR_SIZE = null;
    public static final WindowSizeClass NORMAL = null;
    public static final WindowSizeClass OVERSIZE = null;
    public static final WindowSizeClass SMALL = null;
    public static final WindowSizeClass SMALLER_ANDROID_SCREEN = null;
    public static final WindowSizeClass SMALL_SPLIT_SCREEN = null;
    public static final WindowSizeClass STANDARD = null;
    private final c baseGridConfig;
    private final int dpSize;

    static {
        b r10 = new b(1);
        float r11 = 0;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        d r13 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics())));
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        WindowSizeClass r15 = new WindowSizeClass("MINUS_ERROR_SIZE", 0, -1, new c("MINUS_ERROR_SIZE", r10, r13, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r11, r14.getDisplayMetrics())))));
        MINUS_ERROR_SIZE = r15;
        b r16 = new b(12);
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        d r18 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, 11, r17.getDisplayMetrics())));
        float r19 = 12;
        Resources r110 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r110, "Resources.getSystem()");
        WindowSizeClass r20 = new WindowSizeClass("FLOATING_WINDOW", 1, 0, new c("FLOATING_WINDOW", r16, r18, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r19, r110.getDisplayMetrics())))));
        FLOATING_WINDOW = r20;
        b r21 = new b(12);
        Resources r22 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r22, "Resources.getSystem()");
        d r23 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, r19, r22.getDisplayMetrics())));
        Resources r24 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r24, "Resources.getSystem()");
        WindowSizeClass r25 = new WindowSizeClass("SMALL_SPLIT_SCREEN", 2, 375, new c("SMALL_SPLIT_SCREEN", r21, r23, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r19, r24.getDisplayMetrics())))));
        SMALL_SPLIT_SCREEN = r25;
        b r26 = new b(12);
        Resources r27 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
        d r28 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, r19, r27.getDisplayMetrics())));
        float r29 = 16;
        Resources r111 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r111, "Resources.getSystem()");
        WindowSizeClass r30 = new WindowSizeClass("SMALLER_ANDROID_SCREEN", 3, 516, new c("SMALLER_ANDROID_SCREEN", r26, r28, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r29, r111.getDisplayMetrics())))));
        SMALLER_ANDROID_SCREEN = r30;
        b r31 = new b(12);
        Resources r32 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r32, "Resources.getSystem()");
        d r33 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, r19, r32.getDisplayMetrics())));
        Resources r112 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r112, "Resources.getSystem()");
        WindowSizeClass r34 = new WindowSizeClass("SMALL", 4, 640, new c("SMALL", r31, r33, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r29, r112.getDisplayMetrics())))));
        SMALL = r34;
        b r35 = new b(12);
        Resources r36 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r36, "Resources.getSystem()");
        d r37 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, r19, r36.getDisplayMetrics())));
        float r113 = 24;
        Resources r114 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r114, "Resources.getSystem()");
        WindowSizeClass r38 = new WindowSizeClass("STANDARD", 5, 768, new c("STANDARD", r35, r37, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r113, r114.getDisplayMetrics())))));
        STANDARD = r38;
        b r39 = new b(12);
        Resources r40 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r40, "Resources.getSystem()");
        d r41 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, r19, r40.getDisplayMetrics())));
        Resources r42 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r42, "Resources.getSystem()");
        WindowSizeClass r43 = new WindowSizeClass("NORMAL", 6, 834, new c("NORMAL", r39, r41, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r113, r42.getDisplayMetrics())))));
        NORMAL = r43;
        b r44 = new b(20);
        Resources r45 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r45, "Resources.getSystem()");
        d r46 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, r29, r45.getDisplayMetrics())));
        float r47 = 32;
        Resources r115 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r115, "Resources.getSystem()");
        WindowSizeClass r48 = new WindowSizeClass("LARGE", 7, 1024, new c("LARGE", r44, r46, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r47, r115.getDisplayMetrics())))));
        LARGE = r48;
        b r49 = new b(24);
        Resources r50 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r50, "Resources.getSystem()");
        d r51 = new d(MathKt.roundToInt(TypedValue.applyDimension(1, r29, r50.getDisplayMetrics())));
        Resources r52 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r52, "Resources.getSystem()");
        WindowSizeClass r53 = new WindowSizeClass("OVERSIZE", 8, 1366, new c("OVERSIZE", r49, r51, new e(MathKt.roundToInt(TypedValue.applyDimension(1, r47, r52.getDisplayMetrics())))));
        OVERSIZE = r53;
        $VALUES = new WindowSizeClass[]{r15, r20, r25, r30, r34, r38, r43, r48, r53};
    }

    private WindowSizeClass(String r10, int r11, int r12, c r13) {
        super(r10, r11);
        this.dpSize = r12;
        this.baseGridConfig = r13;
    }

    public static WindowSizeClass valueOf(String r10) {
        return (WindowSizeClass) Enum.valueOf(WindowSizeClass.class, r10);
    }

    public static WindowSizeClass[] values() {
        return (WindowSizeClass[]) $VALUES.clone();
    }

    public final c getBaseGridConfig() {
        return this.baseGridConfig;
    }

    public final int getDpSize() {
        return this.dpSize;
    }
}
