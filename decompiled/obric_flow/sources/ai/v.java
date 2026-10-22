package ai;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes2.dex */
public final class v extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f301c;
    public final String d;
    public final i e;
    public final boolean f;

    public v(String r5, i r10, boolean r11, int r12) {
        this.f301c = r12;
        switch(r12) {
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        w0.b(r5, "name == null");
        this.d = r5;
        this.e = r10;
        this.f = r11;
        return;
    L6:
        w0.b(r5, "name == null");
        this.d = r5;
        this.e = r10;
        this.f = r11;
        return;
    L8:
        w0.b(r5, "name == null");
        this.d = r5;
        this.e = r10;
        this.f = r11;
    }

    @Override // ai.w0
    public final void a(e0 r10, Object r11) {
        switch(this.f301c) {
            case 0: goto L31;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        if (r11 == null) goto L38;
        r10.b(this.d, (String) this.e.convert(r11), this.f);
        return;
    L38:
        return;
    L8:
        String r5 = this.d;
        if (r11 == null) goto L30;
        String r12 = (String) this.e.convert(r11);
        String r13 = r10.d;
        if (r13 == null) goto L28;
        if (r5 == null) goto L26;
        if (r12 == null) goto L24;
        if (this.f == false) goto L19;
        String r14 = URLEncoder.encode(r12, "UTF-8").replace("+", "%20");     // Catch: UnsupportedEncodingException -> L17
        r10.d = r10.d.replace("{" + r5 + "}", r14);     // Catch: UnsupportedEncodingException -> L17
    L35:
        return;
    L19:
        r10.d = r13.replace("{" + r5 + "}", r12);     // Catch: UnsupportedEncodingException -> L17
    L17:
        e = move-exception;
        throw new RuntimeException(androidx.constraintlayout.motion.widget.a.p("Unable to convert path parameter \"", r5, "\" value to UTF-8:", r12), e);
    L24:
        throw new IllegalArgumentException(j0.k("Path replacement \"", r5, "\" value must not be null."));
    L26:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L28:
        throw new AssertionError();
    L30:
        throw new IllegalArgumentException(j0.k("Path parameter \"", r5, "\" value must not be null."));
    L31:
        if (r11 == null) goto L39;
        String r15 = (String) this.e.convert(r11);
        fi.c r16 = r10.f191i;
        String r17 = r15.toString();
        String r18 = this.d;
        boolean r19 = this.f;
        r16.f(r18, r17, r19, r19);
        return;
    }
}
