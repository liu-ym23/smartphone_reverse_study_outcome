package t6;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.apm.d;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.NetworkUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Boolean> f12968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile File f12969b;

    class a implements FileFilter {
        a(b r10) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File r10) {
            return r10.isFile();
        }
    }

    /* JADX INFO: renamed from: t6.b$b, reason: collision with other inner class name */
    private static class C0298b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f12970a = null;

        static {
            f12970a = new b();
        }

        static /* synthetic */ b a() {
            return f12970a;
        }
    }

    public b() {
        this.f12968a = new HashMap();
    }

    private void a() {
        if (this.f12969b != null) goto L5;
        return;
    L5:
        if (this.f12969b.exists() == true) goto L9;
        this.f12969b.mkdirs();
        return;
    }

    public static b b() {
        return C0298b.a();
    }

    public File c() {
        if (this.f12969b == null) goto L5;
    L9:
        a();
        return this.f12969b;
    L5:
        if (d.g() == null) goto L7;
        this.f12969b = new File(d.g().getFilesDir(), "cloud_uploading");
        goto L9
    L7:
        return null;
    }

    public boolean d(String r10) {
        if (this.f12968a.get(r10) != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public synchronized void e(n6.a r11, File r12, String r13) {
        monitor-enter(this);
        t6.a.c("命令产物已生成，等待上传", r11);     // Catch: Throwable -> L38
        a();     // Catch: Throwable -> L38
        String r10 = r11.b();     // Catch: Throwable -> L38
        File r14 = c();     // Catch: Throwable -> L38
        if (r14 == null) goto L37;
        File r15 = new File(r14, r10);     // Catch: Throwable -> L38
        if (r15.exists() == false) goto L8;
        com.monitor.cloudmessage.utils.b.f(r15);     // Catch: Throwable -> L38
    L8:
        r12.renameTo(r15);     // Catch: Throwable -> L38
        long r16 = com.bytedance.apm.util.b.g(r15);     // Catch: Throwable -> L38
        boolean r17 = true;
        if (r11.f() == true) goto L11;
    L13:
        boolean r18 = false;
    L14:
        this.f12968a.put(r10, Boolean.valueOf(r18));     // Catch: Throwable -> L38
        if (r18 == true) goto L17;
    L21:
        File[] r19 = r15.listFiles(new a(this));     // Catch: Throwable -> L38
        int r20 = r19.length;     // Catch: Throwable -> L38
        int r21 = 0;
    L22:
        if (r21 >= r20) goto L31;
        File r22 = r19[r21];     // Catch: Throwable -> L38
        boolean r23 = t6.a.b(r10, r22, r13, "正在上传:" + r22.getName());     // Catch: Throwable -> L38
        StringBuilder r24 = new StringBuilder();     // Catch: Throwable -> L38
        r24.append("文件上传");     // Catch: Throwable -> L38
        if (r23 == false) goto L26;
        String r25 = "成功";
    L27:
        r24.append(r25);     // Catch: Throwable -> L38
        r24.append(":");     // Catch: Throwable -> L38
        r24.append(r22.getName());     // Catch: Throwable -> L38
        t6.a.c(r24.toString(), r11);     // Catch: Throwable -> L38
        if (r23 == true) goto L30;
        r17 = false;
    L30:
        r21 = r21 + 1;     // Catch: Throwable -> L38
        goto L22
    L26:
        r25 = "失败";
        goto L27
    L31:
        if (r17 == false) goto L33;
        t6.a.e(r10);     // Catch: Throwable -> L38
    L33:
        com.monitor.cloudmessage.utils.b.f(r15);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L17:
        if (NetworkUtils.l(k6.a.k().i()) == true) goto L21;
        t6.a.c("产物超过阈值，等待WiFi环境执行. fileTotalSize=" + r16, r11);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L11:
        if (r16 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) goto L13;
        r18 = true;
        goto L14
    L37:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }
}
