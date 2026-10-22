package androidx.core.content;

import android.net.Uri;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public interface FileProvider$PathStrategy {
    File getFileForUri(Uri r1);

    Uri getUriForFile(File r1);
}
