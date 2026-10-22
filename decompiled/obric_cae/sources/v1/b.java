package v1;

import androidx.work.m;
import he.i;
import java.util.Iterator;
import java.util.List;
import r1.j;
import r1.n;
import r1.t;
import r1.y;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12705a = null;

    static {
        String r8 = m.f("DiagnosticsWrkr");
        i.e(r8, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f12705a = r8;
    }

    public static final String a(n r10, y r11, j r12, List r13) {
        StringBuilder r8 = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        t r15 = (t) r14.next();
        r1.i r16 = r12.b(l6.a.L(r15));
        if (r16 == null) goto L8;
        Integer r17 = Integer.valueOf(r16.f11319c);
    L9:
        String r18 = r15.f11339a;
        String r19 = yd.i.j1(r10.b(r18), ",", null, 62);
        String r20 = yd.i.j1(r11.a(r18), ",", null, 62);
        StringBuilder r21 = defpackage.b.h("\n", r18, "\t ");
        r21.append(r15.f11341c);
        r21.append("\t ");
        r21.append(r17);
        r21.append("\t ");
        r21.append(r15.f11340b.name());
        r21.append("\t ");
        r21.append(r19);
        r21.append("\t ");
        r21.append(r20);
        r21.append('\t');
        r8.append(r21.toString());
        goto L4
    L8:
        r17 = null;
        goto L9
    L10:
        String r22 = r8.toString();
        i.e(r22, "StringBuilder().apply(builderAction).toString()");
        return r22;
    }
}
