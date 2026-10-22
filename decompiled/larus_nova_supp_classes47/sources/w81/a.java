package w81;

import com.bytedance.android.live.base.model.message.a4;
import com.bytedance.android.live.room.incentiveinfo.model.CarouselTabType;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public d a;
    public Boolean b;
    public String c;
    public Integer d;
    public final CarouselTabType e;

    /* JADX INFO: renamed from: w81.a$a, reason: collision with other inner class name */
    public static final class C0338a {
    }

    static {
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final String toString() {
        return "IncentiveInfoModel(carouselTabType=" + this.e + ", messageData=" + this.a + ')';
    }

    public a(CarouselTabType r2) {
        Intrinsics.checkNotNullParameter(r2, "carouselTabType");
        this.e = r2;
        this.b = Boolean.TRUE;
        this.d = 0;
    }

    public final boolean equals(Object r6) {
        if (this != r6) goto L5;
        return true;
    L5:
        Long r2 = null;
        if (r6 == null) goto L8;
        Class<?> r3 = r6.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r3)) == false) goto L12;
        return false;
    L12:
        CarouselTabType r1 = this.e;
        if ((r6 instanceof a) == true) goto L15;
        Object r4 = null;
    L16:
        a r5 = (a) r4;
        if (r5 == null) goto L19;
        CarouselTabType r7 = r5.e;
    L20:
        if (r1 == r7) goto L22;
        return false;
    L22:
        d r8 = this.a;
        if ((r8 instanceof a4) == true) goto L25;
        r8 = null;
    L25:
        a4 r9 = (a4) r8;
        if (r9 == null) goto L28;
        Long r10 = r9.G();
    L29:
        a r12 = (a) r6;
        if (r12 == null) goto L32;
        d r13 = r12.a;
    L34:
        if ((r13 instanceof a4) == true) goto L36;
        r13 = null;
    L36:
        a4 r14 = (a4) r13;
        if (r14 == null) goto L40;
        r2 = r14.G();
    L40:
        if ((!Intrinsics.areEqual(r10, r2)) == false) goto L42;
        return false;
    L42:
        return true;
    L32:
        r13 = null;
        goto L34
    L28:
        r10 = null;
        goto L29
    L19:
        r7 = null;
        goto L20
    L15:
        r4 = r6;
        goto L16
    L8:
        r3 = null;
        goto L10
    }
}
