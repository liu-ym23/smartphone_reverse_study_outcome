package io.noties.markwon.core.spans;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes6.dex */
abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Rect f16476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final RectF f16477b = null;
    private static final Paint c = null;

    static {
        f16476a = new Rect();
        f16477b = new RectF();
        c = new Paint(1);
    }

    static Rect a() {
        return f16476a;
    }

    static RectF b() {
        return f16477b;
    }

    static Paint c() {
        return c;
    }
}
