package we;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13232a = null;

    public static class a implements n {
        @Override // we.n
        public final List<InetAddress> lookup(String r8) {
            if (r8 == null) goto L12;
            return Arrays.asList(InetAddress.getAllByName(r8));
        L8:
            e = move-exception;
            UnknownHostException r10 = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(r8));
            r10.initCause(e);
            throw r10;
        L5:
            e = move-exception;
            UnknownHostException r11 = new UnknownHostException("Permission denied for dns lookup of ".concat(r8));
            r11.initCause(e);
            throw r11;
        L12:
            throw new UnknownHostException("hostname == null");
        }
    }

    static {
        f13232a = new a();
    }

    List<InetAddress> lookup(String r8);
}
