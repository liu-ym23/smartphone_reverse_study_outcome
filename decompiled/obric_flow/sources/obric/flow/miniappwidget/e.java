package obric.flow.miniappwidget;

import android.graphics.Rect;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f20473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f20474c;
    public final Integer d;
    public final Float e;
    public final Map f;

    public e(boolean r5, Float r10, Rect r11, Integer r12, Float r13, Map r14) {
        Intrinsics.checkNotNullParameter(r14, "extras");
        this.f20472a = r5;
        this.f20473b = r10;
        this.f20474c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r10 = (e) r5;
        boolean r11 = r10.f20472a;
        if (this.f20472a == r11) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20473b, r10.f20473b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20474c, r10.f20474c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r5 = Boolean.hashCode(this.f20472a) * 31;
        int r10 = 0;
        Float r11 = this.f20473b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        Rect r14 = this.f20474c;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.d;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Float r20 = this.e;
        if (r20 == null) goto L19;
        r10 = r20.hashCode();
    L19:
        return this.f.hashCode() + ((r19 + r10) * 31);
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final String toString() {
        return "MiniAppWidgetConfig(darkMode=" + this.f20472a + ", cornerRadius=" + this.f20473b + ", padding=" + this.f20474c + ", backgroundColor=" + this.d + ", elevation=" + this.e + ", extras=" + this.f + ")";
    }
}
