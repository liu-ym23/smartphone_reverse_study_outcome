package oc;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nNullProxySelector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NullProxySelector.kt\nokhttp3/internal/proxy/NullProxySelector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,36:1\n1#2:37\n*E\n"})
public final class a extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11652a = null;

    static {
        f11652a = new a();
    }

    private a() {
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI r10, SocketAddress r11, IOException r12) {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI r10) {
        if (r10 == null) goto L6;
        return CollectionsKt.listOf(Proxy.NO_PROXY);
    L6:
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
