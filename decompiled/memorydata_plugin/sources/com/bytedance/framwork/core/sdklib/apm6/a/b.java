package com.bytedance.framwork.core.sdklib.apm6.a;

import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.framwork.core.sdklib.apm6.safety.c;
import com.obric.cae.userAware.WifiScanStateMachine;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f2580a = null;

        static {
            f2580a = new b();
        }

        static /* synthetic */ b a() {
            return f2580a;
        }
    }

    public b() {
    }

    private static long a(long r3) {
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        return r3 >> 16;
    }

    public static b a() {
        return a.a();
    }

    static /* synthetic */ boolean a(b r0, File r1) {
        return r0.a(r1);
    }

    private boolean a(File r7) {
        String r8 = r7.getName();     // Catch: Throwable -> L14
        int r0 = r8.lastIndexOf(".bin");     // Catch: Throwable -> L14
        if (r0 != (-1)) goto L6;
        return true;
    L6:
        String[] r9 = r8.substring(0, r0).split("_");     // Catch: Throwable -> L14
        if (r9.length >= 2) goto L9;
        return true;
    L9:
        String r10 = r9[1];     // Catch: Throwable -> L14
        if ((System.currentTimeMillis() - a(Long.parseLong(r10))) < WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS) goto L13;
        return true;
    L13:
        return false;
    L14:
        return true;
    }

    private String b(String r1) {
        return r1 + ".bin";
    }

    JSONObject a(String r4) {
        File r0 = com.bytedance.framwork.core.sdklib.apm6.a.f();
        if (r0 != null) goto L5;
        return null;
    L5:
        byte[] r3 = FileUtils.readFileToByteArray(new File(r0, b(r4)));
        if (r3 != null) goto L11;
    L9:
        return null;
    L11:
        return new JSONObject(new String(r3));
    }

    void a(String r3, JSONObject r4) {
        File r0 = com.bytedance.framwork.core.sdklib.apm6.a.f();
        if (r0 == null) goto L16;
        if (r4 == null) goto L21;
        File r1 = new File(r0, b(r3));
        FileChannel r2 = null;
        r2 = new FileOutputStream(r1).getChannel();     // Catch: Throwable -> L9
        r2.write(ByteBuffer.wrap(r4.toString().getBytes()));     // Catch: Throwable -> L9
    L8:
        IOUtils.closeQuietly(r2);
        return;
    L9:
        th = move-exception;
        c.c("APM", "header couldn't write file" + th.getMessage());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        IOUtils.closeQuietly(r2);
        throw th;
    L21:
        return;
    }

    void b() {
        File r0 = com.bytedance.framwork.core.sdklib.apm6.a.f();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.listFiles(new AnonymousClass1(this));
    }
}
