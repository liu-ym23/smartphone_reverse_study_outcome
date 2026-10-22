package ms.bd.c;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class u implements FileFilter {
    public u() {
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r8) {
        return Pattern.matches((String) p2.a(16777217, 0, 0, "ab1ba8", new byte[]{115, 112, 87, 45, 14, 98, 59, 126}), r8.getName());
    }
}
