package ai;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends w0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f297c;
    public final Object d;

    public /* synthetic */ u(Object r5, int r10) {
        this.f297c = r10;
        this.d = r5;
    }

    @Override // ai.w0
    public final void a(e0 r10, Object r11) {
        switch(this.f297c) {
            case 0: goto L22;
            default: goto L4;
        };
    L4:
        Map r12 = (Map) r11;
        if (r12 == null) goto L21;
        Iterator r13 = r12.entrySet().iterator();
    L8:
        if (r13.hasNext() == false) goto L18;
        Map.Entry r5 = (Map.Entry) r13.next();
        String r14 = (String) r5.getKey();
        if (r14 == null) goto L17;
        okhttp3.q0 r15 = (okhttp3.q0) r5.getValue();
        if (r15 == null) goto L15;
        okhttp3.c0 r16 = okhttp3.z.h(new String[]{"Content-Disposition", j0.k("form-data; name=\"", r14, "\""), "Content-Transfer-Encoding", (String) this.d});
        r10.s.a(r16, r15);
        goto L8
    L15:
        throw new IllegalArgumentException(j0.k("Part map contained null value for key '", r14, "'."));
    L17:
        throw new IllegalArgumentException("Part map contained null key.");
    L18:
        r10.f202u = true;
        return;
    L21:
        throw new IllegalArgumentException("Part map was null.");
    L22:
        okhttp3.q0 r17 = (okhttp3.q0) r11;
        if (r17 == null) goto L30;
        r10.s.a((okhttp3.c0) this.d, r17);
        r10.f202u = true;
        return;
    }
}
