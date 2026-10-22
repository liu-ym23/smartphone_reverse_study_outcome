package com.lynx.tasm.behavior.shadow;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final enum MeasureMode extends Enum<MeasureMode> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MeasureMode f10339b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MeasureMode f10340c = null;
    public static final MeasureMode d = null;
    public static final /* synthetic */ MeasureMode[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10341a;

    static {
        MeasureMode r5 = new MeasureMode("UNDEFINED", 0, 0);
        f10339b = r5;
        MeasureMode r10 = new MeasureMode("EXACTLY", 1, 1);
        f10340c = r10;
        MeasureMode r11 = new MeasureMode("AT_MOST", 2, 2);
        d = r11;
        e = new MeasureMode[]{r5, r10, r11};
    }

    public MeasureMode(String r5, int r10, int r11) {
        super(r5, r10);
        this.f10341a = r11;
    }

    public static MeasureMode a(int r5) {
        if (r5 == 0) goto L14;
        if (r5 == 1) goto L12;
        if (r5 != 2) goto L10;
        return d;
    L10:
        throw new IllegalArgumentException("Unknown measureMode");
    L12:
        return f10340c;
    L14:
        return f10339b;
    }

    public static int b(int r5) {
        int r10 = View.MeasureSpec.getMode(r5);
        if (r10 == Integer.MIN_VALUE) goto L13;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if (r10 != 1073741824) goto L10;
        return 1;
    L10:
        throw new IllegalArgumentException("Unknown measureSpec");
    L13:
        return 2;
    }

    public static MeasureMode valueOf(String r5) {
        return (MeasureMode) Enum.valueOf(MeasureMode.class, r5);
    }

    public static MeasureMode[] values() {
        return (MeasureMode[]) e.clone();
    }
}
