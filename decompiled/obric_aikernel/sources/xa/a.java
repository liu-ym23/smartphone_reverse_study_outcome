package xa;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a(Context r10) {
        File r11 = r10.getFilesDir();
        if (r11 == null) goto L9;
        File r12 = new File(r11.getAbsolutePath(), "ALOG");
        if (r12.exists() == true) goto L8;
        r12.mkdir();
    L8:
        return r12.getAbsolutePath();
    L9:
        return null;
    }

    public static File b(Context r10) {
        File r11 = new File(r10.getFilesDir(), "logs");
        if (r11.exists() == true) goto L5;
        r11.mkdir();
    L5:
        return r11;
    }
}
