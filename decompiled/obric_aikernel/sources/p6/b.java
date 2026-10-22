package p6;

import com.monitor.cloudmessage.entity.CloudMessageException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b extends o6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m6.c f12329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f12330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile long f12331d;

    public b() {
        this.f12330c = new ArrayList();
        this.f12331d = 0;
    }

    @Override // o6.a
    public String f() {
        return "alog";
    }

    @Override // o6.a
    public synchronized boolean g(n6.a r13) {
        monitor-enter(this);
        JSONObject r10 = new JSONObject(r13.c());     // Catch: Throwable -> L51
        if (this.f12329b != null) goto L15;
        boolean r11 = com.bytedance.apm.d.I();     // Catch: Throwable -> L51
        String r12 = com.bytedance.apm.d.h();     // Catch: Throwable -> L51
        if (r12 != null) goto L8;
        r12 = "";
    L8:
        if (r11 == false) goto L10;
        String r14 = "主进程收到命令，未设置ALog回捞组件。请宿主应用检查是否在合适时机设置ALog回捞组件。";
    L11:
        t6.a.c(r14, r13);     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L10:
        r14 = "子进程\"$processName\"收到命令，等待主进程活跃后上报。".replace("$processName", r12);     // Catch: Throwable -> L51
        goto L11
    L15:
        if ((System.currentTimeMillis() - this.f12331d) >= 180000) goto L19;
        w6.b r15 = new w6.b(0, false, r13.b(), null);     // Catch: Throwable -> L51
        r15.h(0);     // Catch: Throwable -> L51
        r15.i("3分钟内不重复执行alog回捞");     // Catch: Throwable -> L51
        u6.a.d(r15);     // Catch: Throwable -> L51
        monitor-exit(this);
        return false;
    L19:
        this.f12331d = System.currentTimeMillis();     // Catch: Throwable -> L51
        List<String> r16 = this.f12329b.b(r10.optLong("fetch_start_time", (System.currentTimeMillis() / 1000) - 18000), r10.optLong("fetch_end_time", System.currentTimeMillis() / 1000), r10);     // Catch: Throwable -> L51
        n6.b r17 = this.f12329b.c();     // Catch: Throwable -> L51
        if (r16 != null) goto L22;
    L23:
        m6.c r18 = this.f12329b;     // Catch: Throwable -> L51
        if ((r18 instanceof m6.b) == false) goto L30;
        r16 = ((m6.b) r18).e();     // Catch: Throwable -> L51
        if (r16 == null) goto L30;
        if (r16.size() == 0) goto L30;
        r17 = n6.b.a(true, "兜底策略数据", r17.c());     // Catch: Throwable -> L51
    L30:
        if (r16 == null) goto L47;
        if (r16.size() == 0) goto L47;
        if (r17.d() == false) goto L47;
        this.f12330c.clear();     // Catch: Throwable -> L51
        this.f12330c.addAll(r16);     // Catch: Throwable -> L51
        File r19 = t6.b.b().c();     // Catch: Throwable -> L51
        if (r19 == null) goto L45;
        File r20 = new File(r19, r13.b() + "temp");     // Catch: Throwable -> L51
        if (r20.exists() == false) goto L40;
        com.monitor.cloudmessage.utils.b.f(r20);     // Catch: Throwable -> L51
    L40:
        r20.mkdirs();     // Catch: Throwable -> L51
        File r21 = new File(r20, r13.b() + "-cloudMsg.zip");     // Catch: Throwable -> L51
        if (r21.exists() == false) goto L43;
        r21.delete();     // Catch: Throwable -> L51
    L43:
        String[] r22 = (String[]) r16.toArray(new String[r16.size()]);     // Catch: Throwable -> L51
        com.monitor.cloudmessage.utils.b.b(r21.getAbsolutePath(), r22);     // Catch: Throwable -> L51
        t6.a.d("Alog回捞:" + Arrays.toString(r22) + " ErrMsg=" + r17.b(), r13, r17.c());     // Catch: Throwable -> L51
        t6.b.b().e(r13, r20, "log_agile");     // Catch: Throwable -> L51
    L49:
        monitor-exit(this);
        return true;
    L45:
        throw new CloudMessageException("pending目录因拿不到context而未设置");     // Catch: Throwable -> L51
    L47:
        if (r17.d() == true) goto L49;
        j(r17.b(), r17.c(), r13);     // Catch: Throwable -> L51
        goto L49
    L22:
        if (r16.size() != 0) goto L30;
    L51:
        th = move-exception;
        throw th;
    }

    public void m(m6.c r10) {
        this.f12329b = r10;
    }
}
