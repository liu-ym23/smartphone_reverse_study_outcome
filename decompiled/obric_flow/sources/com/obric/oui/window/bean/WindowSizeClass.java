package com.obric.oui.window.bean;

import com.google.android.material.internal.ViewUtils;
import ib.d;
import kotlin.Metadata;
import r9.c;
import ss.b;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/window/bean/WindowSizeClass;", "", "", "dpSize", "I", "getDpSize", "()I", "Lss/b;", "baseGridConfig", "Lss/b;", "getBaseGridConfig", "()Lss/b;", "MINUS_ERROR_SIZE", "FLOATING_WINDOW", "SMALL_SPLIT_SCREEN", "SMALLER_ANDROID_SCREEN", "SMALL", "STANDARD", "NORMAL", "LARGE", "OVERSIZE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum WindowSizeClass extends Enum<WindowSizeClass> {
    public static final WindowSizeClass FLOATING_WINDOW = null;
    public static final WindowSizeClass LARGE = null;
    public static final WindowSizeClass MINUS_ERROR_SIZE = null;
    public static final WindowSizeClass NORMAL = null;
    public static final WindowSizeClass OVERSIZE = null;
    public static final WindowSizeClass SMALL = null;
    public static final WindowSizeClass SMALLER_ANDROID_SCREEN = null;
    public static final WindowSizeClass SMALL_SPLIT_SCREEN = null;
    public static final WindowSizeClass STANDARD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WindowSizeClass[] f14898a = null;
    private final b baseGridConfig;
    private final int dpSize;

    static {
        WindowSizeClass r5 = new WindowSizeClass("MINUS_ERROR_SIZE", 0, -1, new b("MINUS_ERROR_SIZE", new d(16), new m.b(16), new c(16)));
        MINUS_ERROR_SIZE = r5;
        WindowSizeClass r10 = new WindowSizeClass("FLOATING_WINDOW", 1, 0, new b("FLOATING_WINDOW", new d(16), new m.b(16), new c(16)));
        FLOATING_WINDOW = r10;
        WindowSizeClass r11 = new WindowSizeClass("SMALL_SPLIT_SCREEN", 2, 375, new b("SMALL_SPLIT_SCREEN", new d(16), new m.b(16), new c(16)));
        SMALL_SPLIT_SCREEN = r11;
        WindowSizeClass r12 = new WindowSizeClass("SMALLER_ANDROID_SCREEN", 3, 516, new b("SMALLER_ANDROID_SCREEN", new d(16), new m.b(16), new c(16)));
        SMALLER_ANDROID_SCREEN = r12;
        WindowSizeClass r13 = new WindowSizeClass("SMALL", 4, 640, new b("SMALL", new d(16), new m.b(16), new c(16)));
        SMALL = r13;
        WindowSizeClass r14 = new WindowSizeClass("STANDARD", 5, ViewUtils.EDGE_TO_EDGE_FLAGS, new b("STANDARD", new d(16), new m.b(16), new c(16)));
        STANDARD = r14;
        WindowSizeClass r15 = new WindowSizeClass("NORMAL", 6, 834, new b("NORMAL", new d(16), new m.b(16), new c(16)));
        NORMAL = r15;
        WindowSizeClass r16 = new WindowSizeClass("LARGE", 7, 1024, new b("LARGE", new d(16), new m.b(16), new c(16)));
        LARGE = r16;
        WindowSizeClass r17 = new WindowSizeClass("OVERSIZE", 8, 1366, new b("OVERSIZE", new d(16), new m.b(16), new c(16)));
        OVERSIZE = r17;
        f14898a = new WindowSizeClass[]{r5, r10, r11, r12, r13, r14, r15, r16, r17};
    }

    public WindowSizeClass(String r5, int r10, int r11, b r12) {
        super(r5, r10);
        this.dpSize = r11;
        this.baseGridConfig = r12;
    }

    public static WindowSizeClass valueOf(String r5) {
        return (WindowSizeClass) Enum.valueOf(WindowSizeClass.class, r5);
    }

    public static WindowSizeClass[] values() {
        return (WindowSizeClass[]) f14898a.clone();
    }

    public final b getBaseGridConfig() {
        return this.baseGridConfig;
    }

    public final int getDpSize() {
        return this.dpSize;
    }
}
