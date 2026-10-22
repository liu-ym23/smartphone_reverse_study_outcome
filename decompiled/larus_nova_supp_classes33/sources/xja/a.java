package xja;

import com.obric.datatransfer.logger.TransferLogger;
import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final TransferLogger a = null;
    public static final CopyOnWriteArraySet<String> b = null;

    static {
        com.obric.datatransfer.logger.a r0 = TransferLogger.b;
        a = TransferLogger.a.a("DataTransferUtils");
        b = new CopyOnWriteArraySet();
    }

    public static void a(File r4) {
    L5:
        if (b.contains(r4.getCanonicalPath()) == false) goto L8;
        TransferLogger.c(a, "Skip deleting protected directory " + r4);
        return;
    L8:
        TransferLogger r0 = a;
        TransferLogger.c(r0, "Deleting file " + r4);
        if (r4.isDirectory() == false) goto L26;
        TransferLogger.c(r0, "Deleting directory " + r4);
        File[] r1 = r4.listFiles();
        if (r1 == null) goto L26;
        int r2 = r1.length;
        int r3 = 0;
    L13:
        if (r3 >= r2) goto L26;
        a(r1[r3]);
        r3 = r3 + 1;
    L26:
        boolean r5 = r4.delete();     // Catch: SecurityException -> L17
        TransferLogger.c(a, "delete " + r4 + " status = " + r5);     // Catch: SecurityException -> L17
        return;
    L17:
        e = move-exception;
        a.b("Error deleting file " + r4, e);
        return;
    L23:
        e = move-exception;
        a.b("Error getting canonical path for " + r4, e);
        return;
    L20:
        e = move-exception;
        a.b("Error getting canonical path for " + r4, e);
    }
}
