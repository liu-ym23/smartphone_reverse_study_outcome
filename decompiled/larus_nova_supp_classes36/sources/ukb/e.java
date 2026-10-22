package ukb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static boolean a;
    public static boolean b;

    public static void a(Context r5) {
    L11:
        th = move-exception;
        Log.e("GlideCustomUtils", "replaceGlideTransCoder failed");     // Catch: Throwable -> L15
        th.printStackTrace();     // Catch: Throwable -> L15
    L10:
        a = true;
        return;
    L15:
        th = move-exception;
        a = true;
        throw th;
    L4:
        if (a == false) goto L7;
        a = true;
        return;
    L7:
        Registry r1 = Glide.get(r5).getRegistry();     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        r1.registerAtHead(Bitmap.class, BitmapDrawable.class, new b(r5));     // Catch: Throwable -> L11
        goto L10
    }
}
