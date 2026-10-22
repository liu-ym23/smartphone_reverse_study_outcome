package com.monitor.cloudmessage.e;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.monitor.cloudmessage.CloudMessageManager;
import com.monitor.cloudmessage.entity.CloudMessageException;
import com.monitor.cloudmessage.utils.NetworkUtils;
import com.monitor.cloudmessage.utils.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Boolean> f5846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile File f5847b;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f5849a = null;

        static {
            f5849a = new b();
        }

        static /* synthetic */ b a() {
            return f5849a;
        }
    }

    public b() {
        this.f5846a = new HashMap();
    }

    public static b a() {
        return a.a();
    }

    private void c() {
        if (this.f5847b != null) goto L5;
        return;
    L5:
        if (this.f5847b.exists() == true) goto L9;
        this.f5847b.mkdirs();
        return;
    }

    public synchronized void a(com.monitor.cloudmessage.entity.a r11, File r12, String r13) {
        monitor-enter(this);
        com.monitor.cloudmessage.e.a.a("命令产物已生成，等待上传", r11);     // Catch: Throwable -> L38
        c();     // Catch: Throwable -> L38
        String r0 = r11.d();     // Catch: Throwable -> L38
        File r1 = b();     // Catch: Throwable -> L38
        if (r1 == null) goto L37;
        File r2 = new File(r1, r0);     // Catch: Throwable -> L38
        if (r2.exists() == false) goto L8;
        c.b(r2);     // Catch: Throwable -> L38
    L8:
        r12.renameTo(r2);     // Catch: Throwable -> L38
        long r3 = com.bytedance.apm.util.b.a(r2);     // Catch: Throwable -> L38
        boolean r4 = true;
        if (r11.c() == true) goto L11;
    L13:
        boolean r14 = false;
    L14:
        this.f5846a.put(r0, Boolean.valueOf(r14));     // Catch: Throwable -> L38
        if (r14 == true) goto L17;
    L21:
        File[] r15 = r2.listFiles(new AnonymousClass1(this));     // Catch: Throwable -> L38
        int r5 = r15.length;     // Catch: Throwable -> L38
        int r6 = 0;
    L22:
        if (r6 >= r5) goto L31;
        File r7 = r15[r6];     // Catch: Throwable -> L38
        boolean r8 = com.monitor.cloudmessage.e.a.a(r0, r7, r13, "正在上传:" + r7.getName());     // Catch: Throwable -> L38
        StringBuilder r9 = new StringBuilder().append("文件上传");     // Catch: Throwable -> L38
        if (r8 == false) goto L26;
        String r10 = "成功";
    L27:
        com.monitor.cloudmessage.e.a.a(r9.append(r10).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r7.getName()).toString(), r11);     // Catch: Throwable -> L38
        if (r8 == true) goto L30;
        r4 = false;
    L30:
        r6 = r6 + 1;     // Catch: Throwable -> L38
        goto L22
    L26:
        r10 = "失败";
        goto L27
    L31:
        if (r4 == false) goto L33;
        com.monitor.cloudmessage.e.a.a(r0);     // Catch: Throwable -> L38
    L33:
        c.b(r2);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L17:
        if (NetworkUtils.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(CloudMessageManager.getInstance().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L21;
        com.monitor.cloudmessage.e.a.a("产物超过阈值，等待WiFi环境执行. fileTotalSize=" + r3, r11);     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L11:
        if (r3 <= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) goto L13;
        r14 = true;
        goto L14
    L37:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    public boolean a(String r1) {
        if (this.f5846a.get(r1) != Boolean.TRUE) goto L5;
        return true;
    L5:
        return false;
    }

    public File b() {
        if (this.f5847b == null) goto L5;
    L9:
        c();
        return this.f5847b;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L7;
        this.f5847b = new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "cloud_uploading");
        goto L9
    L7:
        return null;
    }
}
