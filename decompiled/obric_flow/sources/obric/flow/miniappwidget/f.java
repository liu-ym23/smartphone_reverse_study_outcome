package obric.flow.miniappwidget;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f20476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20477c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f20478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f20479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f20480j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f20481k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map f20482l;

    public f(String r5, String r10, String r11, int r12, int r13, String r14, String r15, Map r16, Map r17, int r18) {
        if ((r18 & 512) == 0) goto L6;
        r15 = null;
    L6:
        if ((r18 & 1024) == 0) goto L8;
        r16 = MapsKt.emptyMap();
    L8:
        Intrinsics.checkNotNullParameter(r5, "appletId");
        Intrinsics.checkNotNullParameter(r10, "widgetId");
        Intrinsics.checkNotNullParameter(r16, "config");
        Intrinsics.checkNotNullParameter(r17, "extras");
        this.f20475a = r5;
        this.f20476b = r10;
        this.f20477c = r11;
        this.d = r12;
        this.e = r13;
        this.f = 0;
        this.g = 0;
        this.f20478h = null;
        this.f20479i = r14;
        this.f20480j = r15;
        this.f20481k = r16;
        this.f20482l = r17;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r10 = (f) r5;
        String r11 = r10.f20475a;
        if (Intrinsics.areEqual(this.f20475a, r11) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f20476b, r10.f20476b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f20477c, r10.f20477c) == true) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f20478h, r10.f20478h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f20479i, r10.f20479i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f20480j, r10.f20480j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f20481k, r10.f20481k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f20482l, r10.f20482l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(this.f20475a.hashCode() * 31, 31, this.f20476b);
        int r10 = 0;
        String r11 = this.f20477c;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.g, androidx.room.jarjarred.org.antlr.runtime.a.c(this.f, androidx.room.jarjarred.org.antlr.runtime.a.c(this.e, androidx.room.jarjarred.org.antlr.runtime.a.c(this.d, (r5 + r12) * 31, 31), 31), 31), 31);
        Long r14 = this.f20478h;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f20479i;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.f20480j;
        if (r20 == null) goto L19;
        r10 = r20.hashCode();
    L19:
        return this.f20482l.hashCode() + ((this.f20481k.hashCode() + ((r19 + r10) * 31)) * 31);
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
        return "MiniAppWidgetDefinition(appletId=" + this.f20475a + ", widgetId=" + this.f20476b + ", displayName=" + this.f20477c + ", spanX=" + this.d + ", spanY=" + this.e + ", minSpanX=" + this.f + ", minSpanY=" + this.g + ", version=" + this.f20478h + ", definitionId=" + this.f20479i + ", description=" + this.f20480j + ", config=" + this.f20481k + ", extras=" + this.f20482l + ")";
    }
}
