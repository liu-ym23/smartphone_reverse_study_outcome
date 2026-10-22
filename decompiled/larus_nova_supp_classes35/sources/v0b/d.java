package v0b;

import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSPath;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public static VFSPath a;
    public static OkHttpClient b;

    static {
    }

    public d() {
    }

    public static final void a(Closeable r2) {
        if (r2 == null) goto L10;
        r2.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        j.b("CML_TAG_D_DownloadHelper", "closeQuietly, err:" + e);
        return;
    }

    public static void b(String r6, VFSPath r7, a r8, Map r9) {
        Intrinsics.checkNotNullParameter(r6, "url");
        Intrinsics.checkNotNullParameter(r7, "downloadPath");
        a = r7;
        if (b != null) goto L28;
        OkHttpClient.Builder r1 = new OkHttpClient.Builder().retryOnConnectionFailure(true);
        TimeUnit r3 = TimeUnit.SECONDS;
        b = r1.connectTimeout(30, r3).readTimeout(30, r3).build();
    L28:
        Request.Builder r10 = new Request.Builder().url(r6);     // Catch: Exception -> L23
        Iterator r11 = ((HashMap) r9).entrySet().iterator();     // Catch: Exception -> L23
    L7:
        if (r11.hasNext() == false) goto L17;
        Map.Entry r2 = (Map.Entry) r11.next();     // Catch: Exception -> L23
        String r4 = (String) r2.getKey();     // Catch: Exception -> L23
        String r5 = (String) r2.getValue();     // Catch: Exception -> L23
    L15:
        e = move-exception;
        j.c("CML_TAG_D_DownloadHelper", "忽略异常请求头: " + r4, e);     // Catch: Exception -> L23
        goto L7
    L10:
        if ((!StringsKt.isBlank(r4)) == false) goto L7;
        if ((!StringsKt.isBlank(r5)) == false) goto L7;
        r10.header(r4, r5);     // Catch: Exception -> L15
    L17:
        Request r12 = r10.build();     // Catch: Exception -> L23
        r8.onStart();     // Catch: Exception -> L23
        OkHttpClient r13 = b;     // Catch: Exception -> L23
        if (r13 == null) goto L38;
        Call r14 = r13.newCall(r12);     // Catch: Exception -> L23
        if (r14 == null) goto L39;
        r14.enqueue(new c(r8, r7));     // Catch: Exception -> L23
        return;
    L39:
        return;
    L38:
        return;
    L23:
        e = move-exception;
        j.b("CML_TAG_D_DownloadHelper", "create request error: " + e);
        r8.c(e);
    }
}
