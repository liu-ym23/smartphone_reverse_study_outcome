package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import q.n;

/* JADX INFO: loaded from: classes.dex */
public final enum ShapeStroke$LineCapType extends Enum<ShapeStroke$LineCapType> {
    public static final ShapeStroke$LineCapType BUTT = null;
    public static final ShapeStroke$LineCapType ROUND = null;
    public static final ShapeStroke$LineCapType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShapeStroke$LineCapType[] f1288a = null;

    static {
        ShapeStroke$LineCapType r5 = new ShapeStroke$LineCapType("BUTT", 0);
        BUTT = r5;
        ShapeStroke$LineCapType r10 = new ShapeStroke$LineCapType("ROUND", 1);
        ROUND = r10;
        ShapeStroke$LineCapType r11 = new ShapeStroke$LineCapType("UNKNOWN", 2);
        UNKNOWN = r11;
        f1288a = new ShapeStroke$LineCapType[]{r5, r10, r11};
    }

    public static ShapeStroke$LineCapType valueOf(String r5) {
        return (ShapeStroke$LineCapType) Enum.valueOf(ShapeStroke$LineCapType.class, r5);
    }

    public static ShapeStroke$LineCapType[] values() {
        return (ShapeStroke$LineCapType[]) f1288a.clone();
    }

    public Paint.Cap toPaintCap() {
        int r5 = n.f21435a[ordinal()];
        if (r5 == 1) goto L11;
        if (r5 == 2) goto L9;
        return Paint.Cap.SQUARE;
    L9:
        return Paint.Cap.ROUND;
    L11:
        return Paint.Cap.BUTT;
    }
}
