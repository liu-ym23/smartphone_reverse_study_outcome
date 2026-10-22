package jvc;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class c {
    public c() {
    }

    public abstract List<Certificate> a(List<Certificate> r1, String r2) throws SSLPeerUnverifiedException;
}
