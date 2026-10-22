package c32;

import am3.h;
import com.bytedance.android.live.base.model.message.a5;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements am3.c<d> {
    public g() {
    }

    public static d a(am3.g r13) throws Exception {
        d r0 = new d();
        r0.extraMap = new HashMap();
        r0.trackMap = new HashMap();
        long r1 = r13.c();
    L3:
        int r3 = r13.f();
        if (r3 == (-1)) goto L51;
        if (r3 != 1) goto L8;
        r0.actionType = r13.i();
        goto L3
    L8:
        if (r3 != 2) goto L10;
        r0.associationDisplayText = (a5) vh7.f.a(r13, a5.class);
        goto L3
    L10:
        if (r3 != 3) goto L11;
        r0.schemaUrl = h.c(r13);
        goto L3
    L11:
        String r10 = null;
        if (r3 != 4) goto L14;
        long r11 = r13.c();
        String r4 = null;
    L33:
        int r7 = r13.f();
        if (r7 == (-1)) goto L40;
        if (r7 != 1) goto L36;
        r10 = h.c(r13);
        goto L33
    L36:
        if (r7 != 2) goto L33;
        r4 = h.c(r13);
        goto L33
    L40:
        r13.d(r11);
        if (r10 == null) goto L47;
        if (r4 == null) goto L45;
        r0.trackMap.put(r10, r4);
        goto L3
    L45:
        throw new IllegalStateException("Map value must not be null!");
    L47:
        throw new IllegalStateException("Map key must not be null!");
    L14:
        if (r3 != 100) goto L15;
        long r14 = r13.c();
        String r5 = null;
    L17:
        int r8 = r13.f();
        if (r8 == (-1)) goto L24;
        if (r8 != 1) goto L20;
        r10 = h.c(r13);
        goto L17
    L20:
        if (r8 != 2) goto L17;
        r5 = h.c(r13);
        goto L17
    L24:
        r13.d(r14);
        if (r10 == null) goto L31;
        if (r5 == null) goto L29;
        r0.extraMap.put(r10, r5);
        goto L3
    L29:
        throw new IllegalStateException("Map value must not be null!");
    L31:
        throw new IllegalStateException("Map key must not be null!");
    L15:
        h.e(r13);
        goto L3
    L51:
        r13.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
