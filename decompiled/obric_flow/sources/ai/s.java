package ai;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f293c;
    public final i d;
    public final boolean e;

    public /* synthetic */ s(i r5, boolean r10, int r11) {
        this.f293c = r11;
        this.d = r5;
        this.e = r10;
    }

    @Override // ai.w0
    public final void a(e0 r5, Object r10) {
        switch(this.f293c) {
            case 0: goto L40;
            case 1: goto L23;
            case 2: goto L8;
            default: goto L4;
        };
    L4:
        if (r10 == null) goto L63;
        r5.b((String) this.d.convert(r10), null, this.e);
        return;
    L63:
        return;
    L8:
        Map r11 = (Map) r10;
        if (r11 == null) goto L22;
        Iterator r12 = r11.entrySet().iterator();
    L13:
        if (r12.hasNext() == false) goto L64;
        Map.Entry r13 = (Map.Entry) r12.next();
        String r14 = (String) r13.getKey();
        if (r14 == null) goto L21;
        Object r15 = r13.getValue();
        if (r15 == null) goto L13;
        r5.b(r14, (String) this.d.convert(r15), this.e);
        goto L13
    L21:
        throw new IllegalArgumentException("Query map contained null key.");
    L64:
        return;
    L22:
        return;
    L23:
        Map r16 = (Map) r10;
        if (r16 == null) goto L39;
        Iterator r17 = r16.entrySet().iterator();
    L27:
        if (r17.hasNext() == false) goto L37;
        Map.Entry r18 = (Map.Entry) r17.next();
        String r19 = (String) r18.getKey();
        if (r19 == null) goto L36;
        Object r20 = r18.getValue();
        if (r20 == null) goto L34;
        String r21 = (String) this.d.convert(r20);
        fi.c r22 = r5.f191i;
        String r23 = r21.toString();
        boolean r24 = this.e;
        r22.f(r19, r23, r24, r24);
        goto L27
    L34:
        throw new IllegalArgumentException(j0.k("Field map contained null value for key '", r19, "'."));
    L36:
        throw new IllegalArgumentException("Field map contained null key.");
    L37:
        return;
    L39:
        throw new IllegalArgumentException("Field map was null.");
    L40:
        if (r10 == null) goto L42;
        r5.f193k = (fi.j) this.d.convert(r10);
        return;
    L49:
        e = move-exception;
        throw new RuntimeException("Unable to convert " + r10 + " to TypedOutput", e);
    L42:
        if (this.e == false) goto L45;
        return;
    L45:
        throw new IllegalArgumentException("Body parameter value must not be null.");
    }

    public s(boolean r5, i r10) {
        this.f293c = 0;
        this.e = r5;
        this.d = r10;
    }
}
