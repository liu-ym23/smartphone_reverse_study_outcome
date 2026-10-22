package j4a;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class k {
    public static Uri a(Context r2, File r3) {
        if (Build.VERSION.SDK_INT < 24) goto L8;
        if (r2.getApplicationInfo().targetSdkVersion < 24) goto L8;
        return FileProvider.getUriForFile(r2, r2.getPackageName() + ".choosemedia.fileprovider", r3);
    L8:
        return Uri.fromFile(r3);
    }
}
