package com.ss.android.lark.floating.widget.appfloat;

import android.animation.TypeEvaluator;
import android.graphics.Point;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g<T> implements TypeEvaluator {
    public final /* synthetic */ Point a;

    public g(Point r1) {
        this.a = r1;
    }

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float r5, Object r6, Object r7) {
        Point r8 = (Point) r6;
        Point r9 = (Point) r7;
        Point r0 = this.a;
        int r1 = r8.x;
        r0.x = (int) (r1 + ((r9.x - r1) * r5));
        int r10 = r8.y;
        r0.y = (int) (r10 + ((r9.y - r10) * r5));
        return r0;
    }
}
