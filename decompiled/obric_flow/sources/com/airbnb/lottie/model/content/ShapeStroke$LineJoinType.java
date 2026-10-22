package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import q.n;

/* JADX INFO: loaded from: classes.dex */
public final enum ShapeStroke$LineJoinType extends Enum<ShapeStroke$LineJoinType> {
    public static final ShapeStroke$LineJoinType BEVEL = null;
    public static final ShapeStroke$LineJoinType MITER = null;
    public static final ShapeStroke$LineJoinType ROUND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShapeStroke$LineJoinType[] f1289a = null;

    static {
        ShapeStroke$LineJoinType r5 = new ShapeStroke$LineJoinType("MITER", 0);
        MITER = r5;
        ShapeStroke$LineJoinType r10 = new ShapeStroke$LineJoinType("ROUND", 1);
        ROUND = r10;
        ShapeStroke$LineJoinType r11 = new ShapeStroke$LineJoinType("BEVEL", 2);
        BEVEL = r11;
        f1289a = new ShapeStroke$LineJoinType[]{r5, r10, r11};
    }

    public static ShapeStroke$LineJoinType valueOf(String r5) {
        return (ShapeStroke$LineJoinType) Enum.valueOf(ShapeStroke$LineJoinType.class, r5);
    }

    public static ShapeStroke$LineJoinType[] values() {
        return (ShapeStroke$LineJoinType[]) f1289a.clone();
    }

    public Paint.Join toPaintJoin() {
        int r5 = n.f21436b[ordinal()];
        if (r5 == 1) goto L15;
        if (r5 == 2) goto L13;
        if (r5 == 3) goto L11;
        return null;
    L11:
        return Paint.Join.ROUND;
    L13:
        return Paint.Join.MITER;
    L15:
        return Paint.Join.BEVEL;
    }
}
