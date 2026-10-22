package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface Dns {
    public static final Dns SYSTEM = null;

    public static class a implements Dns {
        public a() {
        }

        @Override // okhttp3.Dns
        public final List<InetAddress> lookup(String r4) throws UnknownHostException {
            if (r4 == null) goto L9;
            return Arrays.asList(InetAddress.getAllByName(r4));
        L5:
            e = move-exception;
            UnknownHostException r1 = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(r4));
            r1.initCause(e);
            throw r1;
        L9:
            throw new UnknownHostException("hostname == null");
        }
    }

    List<InetAddress> lookup(String r1) throws UnknownHostException;

    static {
        SYSTEM = new a();
    }
}
