package gh;

import com.bytedance.pia.core.api.bridge.PiaMethod$InvalidResultError;
import com.bytedance.pia.core.utils.i;
import com.bytedance.pia.core.utils.j;
import com.google.gson.JsonObject;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f17095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ fh.a f17096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f17097c;
    public final /* synthetic */ String d;
    public final /* synthetic */ fh.a e;

    public /* synthetic */ b(c r5, fh.a r10, Class r11, String r12, fh.a r13, JsonObject r14, long r15) {
        this.f17095a = r5;
        this.f17096b = r10;
        this.f17097c = r11;
        this.d = r12;
        this.e = r13;
    }

    @Override // fh.a
    public final void accept(Object r10) {
        c r5 = this.f17095a;
        r5.getClass();
        fh.a r11 = this.f17096b;
        if (r11 == null) goto L31;
        Class r12 = j.j(r11, fh.a.class, 0);
        Class r13 = this.f17097c;
        Object r14 = null;
        if (Void.class != r13) goto L8;
    L25:
        r11.accept(r14);
        return;
    L8:
        if (Unit.class == r13) goto L25;
        String r15 = this.d;
        fh.a r16 = this.e;
        if (r12 == null) goto L15;
        if (r12.isInstance(r10) == false) goto L15;
    L21:
        if (r10 != null) goto L24;
        if (Void.class == r12) goto L24;
        r5.a(-4, r15, "unsupported result type.", null);
        c.b(r16, new PiaMethod$InvalidResultError());
        return;
    L24:
        r14 = r10;
    L15:
        if (JsonObject.class == r12) goto L27;
        r10 = null;
        goto L21
    L27:
        r10 = i.a().toJsonTree(r10);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r5.a(-4, r15, null, th);
        c.b(r16, new PiaMethod$InvalidResultError());
        return;
    }
}
