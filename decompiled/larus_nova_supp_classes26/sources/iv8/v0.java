package iv8;

import com.larus.browsertakeover.cdp.BrowserCdpClient;
import com.larus.browsertakeover.cdp.RemoteInputCommand;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class v0 implements Function1 {
    public final /* synthetic */ BrowserCdpClient a;
    public final /* synthetic */ RemoteInputCommand.Key b;

    public /* synthetic */ v0(BrowserCdpClient r1, RemoteInputCommand.Key r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r7) {
        BrowserCdpClient r0 = this.a;
        RemoteInputCommand.Key r1 = this.b;
        BrowserCdpClient.m r8 = (BrowserCdpClient.m) r7;
        Intrinsics.checkNotNullParameter(r8, "it");
        com.larus.browsertakeover.cdp.b<BrowserCdpClient.m> r2 = r0.r;
        monitor-enter(r2);
        Intrinsics.checkNotNullParameter(r1, "key");     // Catch: Throwable -> L15
        if (2 > (r2.a - (r2.e - r2.f))) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L12;
        b1 r9 = new b1(false, 0);     // Catch: Throwable -> L15
        monitor-exit(r2);
    L14:
        return r9;
    L12:
        r2.a(r8, r1, 1);     // Catch: Throwable -> L15
        r2.e += 2;     // Catch: Throwable -> L15
        r9 = new b1(true, 2);     // Catch: Throwable -> L15
        monitor-exit(r2);
        goto L14
    L7:
        r3 = false;
    L15:
        th = move-exception;
        throw th;
    }
}
