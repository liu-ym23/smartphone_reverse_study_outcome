package ef;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ProxySelector {
    @Override // java.net.ProxySelector
    public final void connectFailed(URI r8, SocketAddress r10, IOException r11) {
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI r8) {
        if (r8 == null) goto L6;
        return Collections.singletonList(Proxy.NO_PROXY);
    L6:
        throw new IllegalArgumentException("uri must not be null");
    }
}
