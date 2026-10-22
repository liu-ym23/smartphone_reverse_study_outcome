package qp1;

import com.bytedance.android.scope.o;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements up1.a, o {
    public final mm1.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public a(mm1.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }

    @Override // up1.a
    public final boolean isNeedSendShow(String r8, String r9) {
        List<String> r0 = zp1.b.a;
        if (r8 == null) goto L31;
        if (r9 == null) goto L32;
        Iterator<String> r1 = zp1.b.a.iterator();
    L8:
        if (r1.hasNext() == false) goto L33;
        String r2 = r1.next();
        if (Intrinsics.areEqual(r2, r8 + '_' + r9) == false) goto L13;
    L21:
        boolean r3 = true;
    L23:
        if (r3 == false) goto L8;
        return r3;
    L13:
        if (StringsKt.endsWith$default(r2, "*", false, 2, null) == false) goto L18;
        if (StringsKt.startsWith$default(r2, r8, false, 2, null) == true) goto L21;
    L18:
        if (StringsKt.startsWith$default(r2, "*", false, 2, null) == true) goto L20;
    L22:
        r3 = false;
        goto L23
    L20:
        if (StringsKt.endsWith$default(r2, r9, false, 2, null) == false) goto L22;
    L33:
        return false;
    L32:
        return false;
    L31:
        return false;
    }
}
