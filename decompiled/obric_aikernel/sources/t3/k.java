package t3;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.bytedance.memory.model.MemoryWidgetConfig;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class k {
    @WorkerThread
    public static File a(@NonNull File r13, @NonNull File r14) {
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L28
        r3.a.e("shrink_begin");     // Catch: Exception -> L28
        MemoryWidgetConfig.b r11 = o3.a.j().k().getShrinkConfig();     // Catch: Exception -> L28
        File r12 = new File(q3.b.e().i(), ".mini.hprof");     // Catch: Exception -> L28
        if (r11 != null) goto L6;
    L11:
        r3.a.e("deepShrink");     // Catch: Exception -> L28
        if (o3.a.j().k().isDeepShrink() == true) goto L14;
    L16:
        boolean r15 = false;
    L17:
        if (r15 == false) goto L19;
        r3.a.e("shrink_deep_begin");     // Catch: Exception -> L28
    L19:
        new b().b(r13, r14, r15);     // Catch: Exception -> L28
        p3.h.d(r14, r12, true);     // Catch: Exception -> L28
        com.bytedance.memory.heap.a.j().v(5);     // Catch: Exception -> L28
        if (r15 == false) goto L22;
        r3.a.e("shrink_deep_end");     // Catch: Exception -> L28
    L22:
        r3.a.e("shrink_end");     // Catch: Exception -> L28
        r3.a.g("shrink_time", System.currentTimeMillis() - r10);     // Catch: Exception -> L28
        r3.a.g("origin_size", r13.length() / 1024);     // Catch: Exception -> L28
        r3.a.g("shrink_size", r12.length() / 1024);     // Catch: Exception -> L28
        p3.c.c("shrink hprof file %s, size: %dk to %s, size: %dk, use time:%d", new Object[]{r13.getPath(), Long.valueOf(r13.length() / 1024), r12.getPath(), Long.valueOf(r12.length() / 1024), Long.valueOf(System.currentTimeMillis() - r10)});     // Catch: Exception -> L28
        if (r12.exists() == false) goto L33;
        if (r12.length() > 0) goto L35;
        return null;
    L35:
        return r12;
    L33:
        return null;
    L14:
        if (r3.a.c(com.bytedance.memory.upload.a.f2205f) == false) goto L16;
        r15 = true;
        goto L17
    L6:
        if (r3.a.a("close_native_shrink") == true) goto L11;
        if (r11.a(r13, r12) == false) goto L10;
        r3.a.e("native_shrink");     // Catch: Exception -> L28
        com.bytedance.memory.heap.a.j().v(3);     // Catch: Exception -> L28
        goto L22
    L10:
        r3.a.e("java_shrink");     // Catch: Exception -> L28
        new b().a(r13, r14);     // Catch: Exception -> L28
        p3.h.d(r14, r12, true);     // Catch: Exception -> L28
        com.bytedance.memory.heap.a.j().v(5);     // Catch: Exception -> L28
    L28:
        e = move-exception;
        t4.a.d(e, "shrink failed");
        r3.a.e("shrink_error_exception");
        e.printStackTrace();
        return null;
    }
}
