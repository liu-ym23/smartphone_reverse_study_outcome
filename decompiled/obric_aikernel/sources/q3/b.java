package q3;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.proc.CommonProcUtil;
import java.io.File;
import java.util.UUID;
import p3.d;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile b f12454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f12455i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f12456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private File f12457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private File f12458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f12459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private File f12460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private File f12461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12462g;

    private b(@NonNull Context r10) {
        String r11 = o3.a.j().l();
        if (TextUtils.isEmpty(r11) == true) goto L5;
        File r12 = new File(r11);
    L6:
        this.f12462g = r12.getAbsolutePath();
        File r13 = new File(this.f12462g + "/memorywidget2");
        this.f12461f = r13;
        if (r13.exists() == true) goto L9;
        this.f12461f.mkdirs();
    L9:
        File[] r14 = this.f12461f.listFiles();
        if (r14 != null) goto L12;
    L23:
        d.a(this.f12461f);
        f12455i = UUID.randomUUID().toString();
    L24:
        p3.c.c("UUID_STRING " + f12455i, new Object[0]);
        this.f12460e = new File(this.f12462g + "/memorywidget2/" + f12455i);
        this.f12458c = new File(this.f12460e, CommonProcUtil.CACHE);
        this.f12456a = new File(this.f12460e, "festival.jpg");
        this.f12457b = new File(this.f12460e, "festival.jpg.heap");
        this.f12459d = new File(this.f12460e, "shrink");
        a();
        return;
    L12:
        if (r14.length != 1) goto L23;
        int r15 = r14.length;
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L24;
        File r17 = r14[r16];
        if (r17.isDirectory() == false) goto L22;
        if (r17.getName().equals("null") == false) goto L20;
        d.a(r17);
        String r18 = UUID.randomUUID().toString();
    L21:
        f12455i = r18;
        goto L22
    L20:
        r18 = r17.getName();
    L22:
        r16 = r16 + 1;
        goto L14
    L5:
        r12 = r10.getExternalFilesDir(null).getParentFile();
        goto L6
    }

    private void a() {
        d.a(new File(this.f12462g, "memorywidget"));     // Catch: Exception -> L4
        d.a(new File(this.f12462g, "memorywidgets"));     // Catch: Exception -> L4
        return;
    }

    public static b e() {
        if (f12454h != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12454h != null) goto L9;
        f12454h = new b(o3.a.j().i());     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f12454h;
    }

    public void b() {
        if (this.f12456a.exists() == false) goto L6;
        this.f12456a.delete();
        return;
    }

    public void c() {
        p3.c.c("deleteWorkSpace", new Object[0]);
        d.a(this.f12460e);
        com.bytedance.memory.heap.a.j().w("");
        com.bytedance.memory.heap.a.j().y("");
        com.bytedance.memory.heap.a.j().v(0);
        a();
    }

    public File d() {
        return this.f12458c;
    }

    public File f() {
        return this.f12460e;
    }

    public File g() {
        return this.f12456a;
    }

    public File h() {
        return this.f12457b;
    }

    public File i() {
        return this.f12459d;
    }

    public String j() {
        return f12455i;
    }

    public File k() {
        return this.f12460e;
    }

    @Nullable
    public File l() {
        return this.f12456a;
    }

    public boolean m() {
        return new File(this.f12460e, "festival.jpg.heap").exists();
    }

    public void n() {
        p3.c.c("resetDir", new Object[0]);
        f12455i = UUID.randomUUID().toString();
        p3.c.c("UUID_STRING " + f12455i, new Object[0]);
        u3.a.b().j(f12455i);
        if (com.bytedance.apm.d.h() == null) goto L5;
        File r10 = new File(this.f12462g + "/memorywidget2/" + f12455i);
    L6:
        this.f12460e = r10;
        if (this.f12460e.exists() == true) goto L9;
        this.f12460e.mkdirs();
    L9:
        File r11 = new File(this.f12460e, CommonProcUtil.CACHE);
        this.f12458c = r11;
        if (r11.exists() == true) goto L12;
        this.f12458c.mkdirs();
    L12:
        this.f12456a = new File(this.f12460e, "festival.jpg");
        this.f12457b = new File(this.f12460e, "festival.jpg.heap");
        File r12 = new File(this.f12460e, "shrink");
        this.f12459d = r12;
        if (r12.exists() == true) goto L16;
        this.f12459d.mkdirs();
        return;
    L16:
        return;
    L5:
        r10 = new File(this.f12462g + "/memorywidget2/" + f12455i);
        goto L6
    }
}
