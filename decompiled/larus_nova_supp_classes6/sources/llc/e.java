package llc;

import com.ss.ugc.effectplatform.bridge.network.ByteReadStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e implements ByteReadStream {
    public final InputStream a;

    public final boolean available() {
        if (this.a.available() < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void close() {
        this.a.close();
    }

    public final int read() {
        return this.a.read();
    }

    public e(c.a r1) {
        this.a = r1;
    }

    public final int read(byte[] r2, int r3, int r4) {
        return this.a.read(r2, r3, r4);
    }
}
