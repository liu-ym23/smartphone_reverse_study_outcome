package androidx.core.content;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class FileProvider$SimplePathStrategy implements FileProvider$PathStrategy {
    private final String mAuthority;
    private final HashMap<String, File> mRoots;

    public FileProvider$SimplePathStrategy(String r2) {
        this.mRoots = new HashMap();
        this.mAuthority = r2;
    }

    @Override // androidx.core.content.FileProvider$PathStrategy
    public File getFileForUri(Uri r5) {
        String r0 = r5.getEncodedPath();
        int r1 = r0.indexOf(47, 1);
        String r3 = Uri.decode(r0.substring(1, r1));
        String r2 = Uri.decode(r0.substring(r1 + 1));
        File r4 = this.mRoots.get(r3);
        if (r4 == null) goto L14;
        File r6 = new File(r4, r2);
        File r7 = r6.getCanonicalFile();     // Catch: IOException -> L11
        if (belongsToRoot(r7.getPath(), r4.getPath()) == false) goto L10;
        return r7;
    L10:
        throw new SecurityException("Resolved path jumped beyond configured root");
    L12:
        throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
    L14:
        throw new IllegalArgumentException("Unable to find configured root for " + r5);
    }

    @Override // androidx.core.content.FileProvider$PathStrategy
    public Uri getUriForFile(File r6) {
        String r7 = r6.getCanonicalPath();     // Catch: IOException -> L21
        Iterator<Map.Entry<String, File>> r0 = this.mRoots.entrySet().iterator();
        Map.Entry<String, File> r1 = null;
    L5:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<String, File> r2 = r0.next();
        String r3 = r2.getValue().getPath();
        if (belongsToRoot(r7, r3) == false) goto L5;
        if (r1 == null) goto L11;
        if (r3.length() <= r1.getValue().getPath().length()) goto L5;
    L11:
        r1 = r2;
        goto L5
    L12:
        if (r1 == null) goto L20;
        String r4 = r1.getValue().getPath();
        if (r4.endsWith("/") == false) goto L16;
        String r8 = r7.substring(r4.length());
    L18:
        return new Uri.Builder().scheme("content").authority(this.mAuthority).encodedPath(Uri.encode(r1.getKey()) + '/' + Uri.encode(r8, "/")).build();
    L16:
        r8 = r7.substring(r4.length() + 1);
        goto L18
    L20:
        throw new IllegalArgumentException("Failed to find configured root that contains " + r7);
    L22:
        throw new IllegalArgumentException("Failed to resolve canonical path for " + r6);
    }

    private boolean belongsToRoot(String r2, String r3) {
        String r4 = FileProvider.access$000(r2);
        String r5 = FileProvider.access$000(r3);
        if (r4.equals(r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (r4.startsWith(r5 + '/') == true) goto L8;
        return false;
    }

    public void addRoot(String r4, File r5) {
        if (TextUtils.isEmpty(r4) == true) goto L11;
        this.mRoots.put(r4, r5.getCanonicalFile());
        return;
    L7:
        e = move-exception;
        throw new IllegalArgumentException("Failed to resolve canonical path for " + r5, e);
    L11:
        throw new IllegalArgumentException("Name must not be empty");
    }
}
