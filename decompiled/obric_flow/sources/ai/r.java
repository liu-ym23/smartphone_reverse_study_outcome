package ai;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f292c;
    public final i d;

    public /* synthetic */ r(i r5, int r10) {
        this.f292c = r10;
        this.d = r5;
    }

    @Override // ai.w0
    public final void a(e0 r5, Object r10) {
        switch(this.f292c) {
            case 0: goto L43;
            case 1: goto L36;
            case 2: goto L28;
            case 3: goto L11;
            default: goto L4;
        };
    L4:
        if (r10 == null) goto L60;
        r5.f198p = Integer.parseInt((String) this.d.convert(r10));     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("Unable to convert " + r10 + " to MaxLength", e);
    L60:
        return;
    L11:
        Map r11 = (Map) r10;
        if (r11 == null) goto L27;
        Iterator r12 = r11.entrySet().iterator();
    L15:
        if (r12.hasNext() == false) goto L25;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        if (r14 == null) goto L24;
        Object r15 = r13.getValue();
        if (r15 == null) goto L22;
        r5.a(r14, (String) this.d.convert(r15));
        goto L15
    L22:
        throw new IllegalArgumentException(j0.k("Header map contained null value for key '", r14, "'."));
    L24:
        throw new IllegalArgumentException("Header map contained null key.");
    L25:
        return;
    L27:
        throw new IllegalArgumentException("Header map was null.");
    L28:
        List r16 = (List) r10;
        if (r16 == null) goto L35;
        Iterator r17 = r16.iterator();
    L33:
        if (r17.hasNext() == false) goto L61;
        bi.c r18 = (bi.c) this.d.convert(r17.next());
        r5.a(r18.f915a, r18.f916b);
        goto L33
    L61:
        return;
    L35:
        return;
    L36:
        if (r10 == null) goto L62;
        r5.f200r = this.d.convert(r10);     // Catch: IOException -> L40
        return;
    L40:
        e = move-exception;
        throw new RuntimeException("Unable to convert " + r10 + " to ExtraInfo", e);
    L62:
        return;
    L43:
        if (r10 == null) goto L63;
        r5.f199q = Boolean.parseBoolean((String) this.d.convert(r10));     // Catch: IOException -> L47
        return;
    L47:
        e = move-exception;
        throw new RuntimeException("Unable to convert " + r10 + " to AddCommonParam", e);
    }
}
