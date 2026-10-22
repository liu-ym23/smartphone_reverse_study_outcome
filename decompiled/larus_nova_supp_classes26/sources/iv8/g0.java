package iv8;

import com.larus.browsertakeover.cdp.BrowserCdpClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class g0 implements Function0 {
    public final /* synthetic */ BrowserCdpClient a;
    public final /* synthetic */ int b;

    public /* synthetic */ g0(BrowserCdpClient r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        BrowserCdpClient r0 = this.a;
        int r1 = this.b;
        BrowserCdpClient.j r2 = r0.d();
        if (r2 == null) goto L28;
        BrowserCdpClient.h r3 = r0.K;
        if (r3 != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == true) goto L27;
        if (r1 < 0) goto L14;
    L15:
        if (r1 > 0) goto L17;
    L19:
        r0.i.incrementAndGet();
        r0.c(false, true);
        if (r0.v(r2) == true) goto L23;
        return Unit.INSTANCE;
    L23:
        if (r0.K == null) goto L25;
        r0.P();
    L25:
        r0.t();
        r0.L = null;
        BrowserCdpClient.h r5 = r0.b(r2, true);
        Integer r6 = Integer.valueOf(r1);
        r0.Z(r5, "Page.getNavigationHistory", new JSONObject(), new k0(r0, r5, r6));
        return Unit.INSTANCE;
    L17:
        if (r0.J.b == true) goto L19;
    L14:
        if (r0.J.a == true) goto L15;
    L27:
        return Unit.INSTANCE;
    L8:
        if (r3.c != true) goto L10;
        r4 = true;
        goto L11
    L28:
        return Unit.INSTANCE;
    }
}
