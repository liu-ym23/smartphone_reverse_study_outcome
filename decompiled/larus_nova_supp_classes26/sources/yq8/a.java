package yq8;

import android.os.SystemClock;
import com.larus.bmhome.metadata.ExifInterface2;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tx9.a2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(String r8, Map r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, MusicAppletPage.KEY_PATH);
        if (Intrinsics.areEqual(r10, "heic") == false) goto L5;
    L41:
        FLogger.a.i("ImageSaveExifUtil", "heic can not write exif:" + r10);
        return;
    L5:
        if (Intrinsics.areEqual(r10, "heif") == true) goto L41;
        if (r9 != null) goto L10;
    L13:
        boolean r3 = true;
    L14:
        if (r3 == true) goto L35;
        if (r9 != null) goto L17;
    L19:
        boolean r4 = false;
    L20:
        if (r4 == true) goto L22;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L35;
        long r6 = SystemClock.elapsedRealtime();
        ExifInterface2 r7 = new ExifInterface2(r8);     // Catch: Exception -> L33
        Iterator r11 = r9.entrySet().iterator();     // Catch: Exception -> L33
    L29:
        if (r11.hasNext() == false) goto L31;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Exception -> L33
        r7.K((String) r12.getKey(), (String) r12.getValue());     // Catch: Exception -> L33
        goto L29
    L31:
        r7.G();     // Catch: Exception -> L33
        FLogger.a.i("ImageSaveExifUtil", "writeMetadata success, exifMap: " + HttpExtKt.p(r9));     // Catch: Exception -> L33
        a2.a(1, "picture", Long.valueOf(SystemClock.elapsedRealtime() - r6));     // Catch: Exception -> L33
        return;
    L33:
        e = move-exception;
        FLogger.a.e("ImageSaveExifUtil", "writeMetadata fail:" + e.getMessage());
        a2.a(0, "picture", Long.valueOf(SystemClock.elapsedRealtime() - r6));
        return;
    L22:
        if (r9.containsKey("UserComment") == false) goto L24;
        r5 = true;
        goto L25
    L17:
        if (r9.size() != 1) goto L19;
        r4 = true;
    L35:
        FLogger r13 = FLogger.a;
        StringBuilder r14 = new StringBuilder("not writeMetadata , exifMap is:");
        if (r9 == null) goto L38;
        String r15 = HttpExtKt.p(r9);
    L39:
        r14.append(r15);
        r13.i("ImageSaveExifUtil", r14.toString());
        return;
    L38:
        r15 = null;
        goto L39
    L10:
        if (r9.isEmpty() == true) goto L13;
        r3 = false;
        goto L14
    }
}
