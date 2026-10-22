package s3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.IOOMCallback;
import java.util.HashMap;
import q3.c;

/* JADX INFO: loaded from: classes.dex */
public class a implements IOOMCallback {
    public a() {
    }

    @Override // com.bytedance.crash.IOOMCallback
    public void onCrash(@NonNull CrashType r10, @Nullable Throwable r11, @Nullable Thread r12, long r13) {
        r3.a.e("onCrash");     // Catch: Throwable -> L9
        if (q3.b.e().m() == true) goto L6;
        q3.b.e().c();     // Catch: Throwable -> L9
        q3.b.e().n();     // Catch: Throwable -> L9
        u3.a.b().g("oomDump");     // Catch: Throwable -> L9
        Runtime r14 = Runtime.getRuntime();     // Catch: Throwable -> L9
        long r15 = r14.maxMemory();     // Catch: Throwable -> L9
        u3.a.b().f13128f = r14.totalMemory() - r14.freeMemory();     // Catch: Throwable -> L9
        u3.a.b().f13129g = r15;     // Catch: Throwable -> L9
        u3.a.b().f("oomDump");     // Catch: Throwable -> L9
        c.m().h(r13);     // Catch: Throwable -> L9
    L18:
    L25:
        Thread.sleep(2000);     // Catch: InterruptedException -> L16
        return;
    L27:
        return;
    L6:
        r3.a.e("hasDumpFile");     // Catch: Throwable -> L9
        u3.a.b().f("hasDumpFile");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        p3.c.c("onCrash_exception " + th.getMessage(), new Object[0]);     // Catch: Throwable -> L13
        HashMap<String, Object> r16 = new HashMap();     // Catch: Throwable -> L13
        r16.put("http_error_message", th.getMessage());     // Catch: Throwable -> L13
        u3.a.b().c("onCrash_exception", r16);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Thread.sleep(2000);     // Catch: InterruptedException -> L17
    L15:
        throw th;
    }
}
