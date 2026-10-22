package u7a;

import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.media.OptionalBool;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i extends g8a.a {
    public final LynxContext a;
    public final g8a.a b;
    public final boolean c;
    public final i8a.e d;

    @Override // g8a.a
    public final void a(LynxResourceRequest r1, com.lynx.tasm.ui.image.j r2) {
    }

    public i(LynxContext r2) {
        this.a = r2;
        if (r2.isAsyncRedirect() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.c = r0;
        this.b = r2.getMediaResourceFetcher();
        this.d = (i8a.e) n.c().a(i8a.e.class);
        return;
    L5:
        if (r2.getAsyncImageInterceptor() == null) goto L7;
        r0 = true;
        goto L8
    }

    @Override // g8a.a
    public final OptionalBool b(String r2) {
        g8a.a r0 = this.b;
        if (r0 != null) goto L5;
        i8a.e r1 = this.d;
        if (r1 == null) goto L19;
        int r3 = r1.isLocalResource(r2);
        if (r3 != (-1)) goto L12;
        return OptionalBool.UNDEFINED;
    L12:
        if (r3 == 1) goto L21;
        if (r3 != 0) goto L17;
        return OptionalBool.FALSE;
    L17:
        return OptionalBool.UNDEFINED;
    L21:
        return OptionalBool.TRUE;
    L19:
        return OptionalBool.UNDEFINED;
    L5:
        return r0.b(r2);
    }

    @Override // g8a.a
    public final String c(LynxResourceRequest r3) {
        g8a.a r0 = this.b;
        if (r0 == null) goto L7;
        return r0.c(r3);
    L7:
        if (this.c == false) goto L11;
        return d7a.a.b(this.a, r3.a, true);
    L11:
        return d7a.a.b(this.a, r3.a, false);
    }
}
