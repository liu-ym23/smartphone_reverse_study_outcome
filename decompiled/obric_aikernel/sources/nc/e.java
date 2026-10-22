package nc;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final /* synthetic */ int a(LogRecord r10) {
        return b(r10);
    }

    private static final int b(LogRecord r10) {
        if (r10.getLevel().intValue() <= Level.INFO.intValue()) goto L6;
        return 5;
    L6:
        if (r10.getLevel().intValue() != Level.INFO.intValue()) goto L8;
        return 4;
    L8:
        return 3;
    }
}
