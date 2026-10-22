package q4;

import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Canvas f21476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f21477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f21478c;
    public final c d;

    public b() {
        Paint r5 = new Paint();
        this.f21477b = r5;
        Paint r10 = new Paint();
        this.f21478c = r10;
        this.d = new c();
        r5.setStrokeWidth(1.0f);
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeCap(Paint.Cap.ROUND);
        r10.setColor(-1);
    }

    public final Canvas a() {
        Canvas r5 = this.f21476a;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("canvas");
        return null;
    }
}
