package ai;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class w extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f304c;
    public final String d;
    public final i e;

    public w(i r5, String r10) {
        this.f304c = 3;
        this.e = r5;
        this.d = r10;
    }

    @Override // ai.w0
    public final void a(e0 r5, Object r10) {
        switch(this.f304c) {
            case 0: goto L39;
            case 1: goto L29;
            case 2: goto L21;
            default: goto L4;
        };
    L4:
        Map r11 = (Map) r10;
        if (r11 == null) goto L20;
        Iterator r12 = r11.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        if (r14 == null) goto L17;
        Object r15 = r13.getValue();
        if (r15 == null) goto L15;
        r5.f192j.c(r14, this.d, (fi.j) this.e.convert(r15));
        goto L8
    L15:
        throw new IllegalArgumentException(j0.k("Part map contained null value for key '", r14, "'."));
    L17:
        throw new IllegalArgumentException("Part map contained null key.");
    L18:
        return;
    L20:
        throw new IllegalArgumentException("Part map was null.");
    L21:
        if (r10 == null) goto L48;
        r5.f192j.c(this.d, "binary", (fi.j) this.e.convert(r10));
        return;
    L26:
        e = move-exception;
        throw new RuntimeException("Unable to convert " + r10 + " to RequestBody", e);
    L48:
        return;
    L29:
        String r16 = this.d;
        if (r10 == null) goto L38;
        String r17 = (String) this.e.convert(r10);
        String r18 = r5.f187a;
        if (r18 == null) goto L36;
        r5.f187a = r18.replace("{" + r16 + "}", r17);
        return;
    L36:
        throw new AssertionError();
    L38:
        throw new IllegalArgumentException(j0.k("Method parameter \"", r16, "\" value must not be null."));
    L39:
        if (r10 == null) goto L49;
        r5.a(this.d, (String) this.e.convert(r10));
        return;
    }

    public w(String r5, i r10, int r11) {
        this.f304c = r11;
        switch(r11) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        w0.b(r5, "name == null");
        this.d = r5;
        this.e = r10;
        return;
    L6:
        this.d = r5;
        this.e = r10;
        return;
    L8:
        w0.b(r5, "name == null");
        this.d = r5;
        this.e = r10;
    }
}
