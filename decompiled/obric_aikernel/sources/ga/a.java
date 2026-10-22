package ga;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f9012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f9013c;

    public a(float r10, float r11) {
        this.f9012b = r10;
        this.f9013c = r11;
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        this.f9011a = MathKt.roundToInt(TypedValue.applyDimension(1, r10, r12.getDisplayMetrics()));
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        MathKt.roundToInt(TypedValue.applyDimension(1, r11, r13.getDisplayMetrics()));
    }

    public final int a() {
        return this.f9011a;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L10;
        a r11 = (a) r10;
        if (Float.compare(this.f9012b, r11.f9012b) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f9013c, r11.f9013c) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (Float.hashCode(this.f9012b) * 31) + Float.hashCode(this.f9013c);
    }

    public String toString() {
        return "AvailableWindowSize(width=" + this.f9012b + ", height=" + this.f9013c + ")";
    }
}
