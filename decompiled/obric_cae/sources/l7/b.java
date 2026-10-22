package l7;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class b extends IOException {
    public b(int r8, long r10) {
        super("Download file too large: " + r10 + " exceed maxsize: " + r8);
    }
}
