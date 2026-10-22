package p20;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g<T> implements Consumer {
    public static final g a = null;

    static {
        a = new g();
    }

    public g() {
    }

    public final void accept(Object r11) {
        e.a r12 = (e.a) r11;
        String r0 = e.a;
        Intrinsics.checkNotNullParameter(r12, "jsbInfo");
        if (e.a() == false) goto L47;
        List<e.a> r1 = e.b;
        e.a r2 = null;
        Object r3 = null;
        if (r1 == null) goto L21;
        Iterator r4 = ((ArrayList) r1).iterator();
    L9:
        if (r4.hasNext() == false) goto L20;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((e.a) r5).c, r12.c) == false) goto L17;
        boolean r6 = true;
        if ((!Intrinsics.areEqual(r12.c, "")) == false) goto L17;
        if ((!Intrinsics.areEqual(r12.c, "0")) == false) goto L17;
    L18:
        if (r6 == false) goto L9;
        r3 = r5;
    L17:
        r6 = false;
    L20:
        r2 = (e.a) r3;
    L21:
        if (r2 != null) goto L23;
    L38:
        if (r12 == null) goto L40;
        ((ArrayList) e.b).add(r12);
    L40:
        ALogger.i("DebugHybridTools", "addRequestJsbCallInfo-> jsbInfo=" + r12);
        return;
    L23:
        if (Intrinsics.areEqual(r12.a, "") == false) goto L25;
        String r7 = "Jsb名称：" + r2.a;
    L26:
        String r8 = r7;
        int r9 = r12.b;
        if (r9 != (-100020)) goto L29;
        r9 = r2.b;
    L29:
        int r13 = r9;
        String r14 = r12.c;
        if (Intrinsics.areEqual(r12.d, "") == false) goto L32;
        String r15 = r2.d;
    L33:
        String r16 = r15;
        if (Intrinsics.areEqual(r12.e, "") == false) goto L36;
        String r17 = r2.e;
    L37:
        r12 = new e.a(r8, r13, r14, r16, r17);
        goto L38
    L36:
        r17 = r12.e;
        goto L37
    L32:
        r15 = r12.d;
        goto L33
    L25:
        r7 = "Jsb名称：" + r12.a;
        goto L26
    }
}
