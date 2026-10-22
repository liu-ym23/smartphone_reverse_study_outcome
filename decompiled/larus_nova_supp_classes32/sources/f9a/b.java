package f9a;

import com.bytedance.apm.d;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;
import x8a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public final Map<String, Boolean> a;
    public volatile PolarisFileWrapper b;

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r1) {
            return r1.isFile();
        }
    }

    /* JADX INFO: renamed from: f9a.b$b, reason: collision with other inner class name */
    public static class C0092b {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public final File a() {
        if (this.b != null) goto L10;
        if (d.getContext() == null) goto L7;
        this.b = new PolarisFileWrapper(d.getContext().getFilesDir(), "cloud_uploading");
        goto L10
    L7:
        return null;
    L10:
        if (this.b == null) goto L15;
        if (this.b.exists() == true) goto L15;
        this.b.mkdirs();
    L15:
        return this.b;
    }

    public b() {
        this.a = new HashMap();
    }

    public final synchronized void b(z8a.a r12, File r13, String r14) throws Exception {
        monitor-enter(this);
        f9a.a.a(r12.c, "命令产物已生成，等待上传", 0, null);     // Catch: Throwable -> L44
        if (this.b != null) goto L7;
    L9:
        String r1 = r12.c;     // Catch: Throwable -> L44
        File r2 = a();     // Catch: Throwable -> L44
        if (r2 == null) goto L43;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r2, r1);     // Catch: Throwable -> L44
        if (r5.exists() == false) goto L14;
        com.monitor.cloudmessage.utils.a.d(r5);     // Catch: Throwable -> L44
    L14:
        r13.renameTo(r5);     // Catch: Throwable -> L44
        long r6 = com.bytedance.apm.util.b.c(r5);     // Catch: Throwable -> L44
        boolean r3 = true;
        if (r12.d.optBoolean("wifiOnly") == true) goto L17;
    L19:
        boolean r15 = false;
    L20:
        ((HashMap) this.a).put(r1, Boolean.valueOf(r15));     // Catch: Throwable -> L44
        if (r15 == true) goto L23;
    L27:
        File[] r16 = r5.listFiles(new a());     // Catch: Throwable -> L44
        int r0 = r16.length;     // Catch: Throwable -> L44
        int r7 = 0;
    L28:
        if (r7 >= r0) goto L37;
        File r8 = r16[r7];     // Catch: Throwable -> L44
        boolean r9 = f9a.a.b(r1, r8, r14, "正在上传:" + r8.getName());     // Catch: Throwable -> L44
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L44
        r10.append("文件上传");     // Catch: Throwable -> L44
        if (r9 == false) goto L32;
        String r11 = "成功";
    L33:
        r10.append(r11);     // Catch: Throwable -> L44
        r10.append(":");     // Catch: Throwable -> L44
        r10.append(r8.getName());     // Catch: Throwable -> L44
        f9a.a.a(r12.c, r10.toString(), 0, null);     // Catch: Throwable -> L44
        if (r9 == true) goto L36;
        r3 = false;
    L36:
        r7 = r7 + 1;     // Catch: Throwable -> L44
        goto L28
    L32:
        r11 = "失败";
        goto L33
    L37:
        if (r3 == false) goto L39;
        f9a.a.a(r1, "上传成功", 2, null);     // Catch: Throwable -> L44
    L39:
        com.monitor.cloudmessage.utils.a.d(r5);     // Catch: Throwable -> L44
        monitor-exit(this);
        return;
    L23:
        if (NetworkUtils.g(c.b().getContext()) == true) goto L27;
        f9a.a.a(r12.c, "产物超过阈值，等待WiFi环境执行. fileTotalSize=" + r6, 0, null);     // Catch: Throwable -> L44
        monitor-exit(this);
        return;
    L17:
        if (r6 <= 2097152) goto L19;
        r15 = true;
        goto L20
    L43:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L44
    L7:
        if (this.b.exists() == true) goto L9;
        this.b.mkdirs();     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }
}
