package h3;

import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import j3.c;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f9159a;

        a(b r10) {
            this.f9159a = r10;
        }

        @Override // java.io.FileFilter
        public boolean accept(File r10) {
            if (b.a(this.f9159a, r10) == false) goto L7;
            FileUtils.deleteFile(r10);
            return false;
        L7:
            return false;
        }
    }

    /* JADX INFO: renamed from: h3.b$b, reason: collision with other inner class name */
    private static class C0176b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f9160a = null;

        static {
            f9160a = new b();
        }

        static /* synthetic */ b a() {
            return f9160a;
        }
    }

    public b() {
    }

    static /* synthetic */ boolean a(b r10, File r11) {
        return r10.g(r11);
    }

    private String c(String r10) {
        return r10 + ".bin";
    }

    public static b e() {
        return C0176b.a();
    }

    private static long f(long r10) {
        if (r10 >= 0) goto L6;
        return 0;
    L6:
        return r10 >> 16;
    }

    private boolean g(File r10) {
        String r11 = r10.getName();     // Catch: Throwable -> L14
        int r12 = r11.lastIndexOf(".bin");     // Catch: Throwable -> L14
        if (r12 != (-1)) goto L6;
        return true;
    L6:
        String[] r13 = r11.substring(0, r12).split("_");     // Catch: Throwable -> L14
        if (r13.length >= 2) goto L9;
        return true;
    L9:
        String r14 = r13[1];     // Catch: Throwable -> L14
        if ((System.currentTimeMillis() - f(Long.parseLong(r14))) < 604800000) goto L13;
        return true;
    L13:
        return false;
    L14:
        return true;
    }

    void b() {
        File r10 = com.bytedance.framwork.core.sdklib.apm6.a.b();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.listFiles(new a(this));
    }

    JSONObject d(String r10) {
        File r11 = com.bytedance.framwork.core.sdklib.apm6.a.b();
        if (r11 != null) goto L5;
        return null;
    L5:
        byte[] r12 = FileUtils.readFileToByteArray(new File(r11, c(r10)));
        if (r12 != null) goto L11;
    L9:
        return null;
    L11:
        return new JSONObject(new String(r12));
    }

    void h(String r10, JSONObject r11) {
        File r12 = com.bytedance.framwork.core.sdklib.apm6.a.b();
        if (r12 == null) goto L16;
        if (r11 == null) goto L21;
        File r13 = new File(r12, c(r10));
        FileChannel r14 = null;
        r14 = new FileOutputStream(r13).getChannel();     // Catch: Throwable -> L9
        r14.write(ByteBuffer.wrap(r11.toString().getBytes()));     // Catch: Throwable -> L9
    L8:
        IOUtils.closeQuietly(r14);
        return;
    L9:
        th = move-exception;
        c.b("APM", "header couldn't write file" + th.getMessage());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        IOUtils.closeQuietly(r14);
        throw th;
    L21:
        return;
    }
}
