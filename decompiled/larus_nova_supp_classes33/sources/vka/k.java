package vka;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k {
    public final StringBuilder a;
    public final List<String> b;

    public final Pair<String, String[]> b() {
        if (this.a.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        String[] r3 = null;
        if (r0 == false) goto L13;
        String r1 = this.a.toString();
        if ((true ^ this.b.isEmpty()) == false) goto L14;
        r3 = (String[]) this.b.toArray(new String[0]);
    L14:
        return TuplesKt.to(r1, r3);
    L13:
        return TuplesKt.to(null, null);
    L5:
        r0 = false;
        goto L6
    }

    public k() {
        this.a = new StringBuilder();
        this.b = new ArrayList();
    }

    public final void a(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "selection");
        if (r4 != null) goto L5;
        return;
    L5:
        if (this.a.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        this.a.append(" AND ");
    L10:
        this.a.append(r3.concat(" = "));
        if ((r4 instanceof Boolean) == false) goto L17;
        StringBuilder r5 = this.a;
        if (((Boolean) r4).booleanValue() == false) goto L15;
        String r6 = "1";
    L16:
        r5.append(r6);
        return;
    L15:
        r6 = "0";
        goto L16
    L17:
        this.a.append("?");
        List<String> r7 = this.b;
        ArrayList r8 = (ArrayList) r7;
        r8.add(r4.toString());
        return;
    L7:
        r0 = false;
        goto L8
    }
}
