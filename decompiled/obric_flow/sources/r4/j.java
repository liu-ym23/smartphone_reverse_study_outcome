package r4;

import android.graphics.Paint;
import android.graphics.Path;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Path f21688c;

    @Override // r4.a
    public final String d() {
        return "pas";
    }

    @Override // r4.a
    public final void e(HashMap r14, q4.c r15) {
        Intrinsics.checkNotNullParameter(r14, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "dataManager");
        Object r5 = r14.get("st");
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        if (Intrinsics.areEqual(r5, "bp") == false) goto L10;
        r15.f21484j.add(new Path());
        return;
    L10:
        if (Intrinsics.areEqual(r5, "mt") == false) goto L19;
        boolean r13 = r15.f21484j.isEmpty();
        ArrayList r10 = r15.f21484j;
        if (r13 == false) goto L16;
        r10.add(new Path());
        if (r15.f21483i == false) goto L16;
        r15.f21483i = false;
    L16:
        ((Path) CollectionsKt.last(r10)).moveTo(a.b("x", r14), a.b("y", r14));
        return;
    L19:
        if (Intrinsics.areEqual(r5, "cp") == false) goto L23;
        ((Path) CollectionsKt.last(r15.f21484j)).close();
        return;
    L23:
        if (Intrinsics.areEqual(r5, "lt") == false) goto L27;
        ((Path) CollectionsKt.last(r15.f21484j)).lineTo(a.b("x", r14), a.b("y", r14));
        return;
    L27:
        if (Intrinsics.areEqual(r5, "ar") == false) goto L31;
        float r16 = a.b("x", r14);
        float r11 = a.b("y", r14);
        float r12 = a.b("r", r14);
        double r17 = 180;
        double r18 = (((double) a.b("sAngle", r14)) / 3.141592653589793d) * r17;
        double r19 = ((((double) a.b("eAngle", r14)) / 3.141592653589793d) * r17) - r18;
        float r110 = r16 + r12;
        float r20 = r11 + r12;
        r15.f21486l.set(r16 - r12, r11 - r12, r110, r20);
        ((Path) CollectionsKt.last(r15.f21484j)).addArc(r15.f21486l, (float) r18, (float) r19);
        return;
    L31:
        if (Intrinsics.areEqual(r5, "at") == false) goto L35;
        float r111 = a.b("x1", r14);
        float r21 = a.b("y1", r14);
        float r22 = a.b("x2", r14);
        float r23 = a.b("y2", r14);
        a.b("r", r14);
        ((Path) CollectionsKt.last(r15.f21484j)).quadTo(r111, r21, r22, r23);
        return;
    L35:
        if (Intrinsics.areEqual(r5, "qc") == false) goto L39;
        ((Path) CollectionsKt.last(r15.f21484j)).quadTo(a.b("cpx", r14), a.b("cpy", r14), a.b("x", r14), a.b("y", r14));
        return;
    L39:
        if (Intrinsics.areEqual(r5, "bc") == false) goto L43;
        ((Path) CollectionsKt.last(r15.f21484j)).cubicTo(a.b("cp1x", r14), a.b("cp1y", r14), a.b("cp2x", r14), a.b("cp2y", r14), a.b("x", r14), a.b("y", r14));
        return;
    L43:
        if (Intrinsics.areEqual(r5, "rc") == false) goto L52;
        float r24 = a.b("x", r14);
        float r25 = a.b("y", r14);
        float r112 = a.b("w", r14);
        float r113 = a.b("h", r14);
        boolean r26 = r15.f21484j.isEmpty();
        ArrayList r27 = r15.f21484j;
        if (r26 == false) goto L49;
        r27.add(new Path());
        if (r15.f21483i == false) goto L49;
        r15.f21483i = false;
    L49:
        ((Path) CollectionsKt.last(r27)).addRect(r24, r25, r24 + r112, r25 + r113, Path.Direction.CW);
        return;
    L52:
        if (Intrinsics.areEqual(r5, "st") == false) goto L56;
        this.f21687b = 1;
        this.f21688c = (Path) CollectionsKt.last(r15.f21484j);
        return;
    L56:
        if (Intrinsics.areEqual(r5, "fi") == false) goto L59;
        this.f21687b = 0;
        this.f21688c = (Path) CollectionsKt.last(r15.f21484j);
        return;
    }

    @Override // r4.a
    public final void f(q4.b r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Path r10 = this.f21688c;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f21687b != 0) goto L8;
        r5.f21477b.setStyle(Paint.Style.FILL);
        Paint r11 = r5.f21477b;
        q4.c r12 = r5.d;
        r11.setColor(r12.f21480b);
        r11.setAlpha(r12.f21481c);
        r5.a().drawPath(r10, r11);
        return;
    L8:
        r5.f21477b.setStyle(Paint.Style.STROKE);
        Paint r13 = r5.f21477b;
        q4.c r14 = r5.d;
        r13.setColor(r14.f21479a);
        r13.setAlpha(r14.f21481c);
        r5.a().drawPath(r10, r13);
    }
}
