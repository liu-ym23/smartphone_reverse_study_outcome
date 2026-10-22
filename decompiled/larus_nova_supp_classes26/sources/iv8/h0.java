package iv8;

import com.larus.browsertakeover.cdp.BrowserCdpClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class h0 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ BrowserCdpClient b;
    public final /* synthetic */ BrowserCdpClient.j c;
    public final /* synthetic */ BrowserCdpClient.l d;

    public /* synthetic */ h0(int r1, BrowserCdpClient r2, BrowserCdpClient.j r3, BrowserCdpClient.l r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.a;
        BrowserCdpClient r1 = this.b;
        BrowserCdpClient.j r2 = this.c;
        BrowserCdpClient.l r3 = this.d;
        if (r0 != r1.j.get()) goto L9;
        if (r2 != null) goto L6;
    L7:
        r1.b.ko(r3);
        return;
    L6:
        if (r1.v(r2) == true) goto L7;
        return;
    }
}
