package com.bytedance.crash.upload;

import androidx.room.writer.DaoWriter;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.util.NativeTools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f4111c;
    public e d;
    public e e;
    public boolean f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4112h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4113i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f4114j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f4115k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4116l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f4117m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4118n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4119o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public i9.c f4120p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f4121q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f4122r;
    public boolean s;

    public f(String r5) {
        this.f4110b = new ArrayList();
        this.f4111c = new ArrayList();
        this.f4112h = 0;
        this.f4113i = -1;
        this.f4114j = -1;
        this.f4118n = false;
        this.f4119o = false;
        this.f4121q = 0;
        this.f4122r = 0;
        this.s = false;
        this.f4109a = r5;
        String[] r10 = r5.substring(0, r5.length() - 1).split(DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
        if (r10.length < 2) goto L6;
        this.f4113i = Long.decode(r10[1]).longValue();     // Catch: Throwable -> L9
    L6:
        if (r10.length < 3) goto L15;
        this.f4114j = Integer.decode(r10[2]).intValue();     // Catch: Throwable -> L10
        return;
    L16:
        return;
    }

    public final void a(JSONObject r10) {
        i9.c r5 = this.f4120p;
        if (r5 == null) goto L44;
        z8.c.l(r10, "filters", "has_dump", "true");
        long r11 = r5.f17525a;
        if (NativeTools.k().E() == false) goto L9;
        long r12 = Long.MAX_VALUE;
    L12:
        boolean r13 = false;
        if (r11 <= r12) goto L15;
        boolean r14 = true;
    L16:
        z8.c.l(r10, "filters", "memory_leak", String.valueOf(r14));
        if (r5.f17527c <= 960) goto L19;
        boolean r15 = true;
    L20:
        z8.c.l(r10, "filters", "fd_leak", String.valueOf(r15));
        if (r5.d <= 350) goto L23;
        r13 = true;
    L23:
        z8.c.l(r10, "filters", "threads_leak", String.valueOf(r13));
        z8.c.l(r10, "filters", "leak_threads_count", String.valueOf(r5.e));
        r10.putOpt("memory_size", Integer.valueOf(r5.f17525a));     // Catch: Throwable -> L45
        r10.putOpt("rss", Integer.valueOf(r5.f17526b));     // Catch: Throwable -> L45
    L25:
        z8.c.l(r10, "filters", "native_oom_reason", r5.f);
        z8.c.l(r10, "custom_long", "maps_size", r5.g);
        int r16 = r5.f17525a;
        if (r16 <= 1073741824) goto L30;
        if (r16 > Integer.MIN_VALUE) goto L30;
        z8.c.l(r10, "filters", "vmsize_range", "1G < VmSize <= 2G");
    L40:
        Iterator r17 = r5.f17528h.entrySet().iterator();
    L42:
        if (r17.hasNext() == false) goto L49;
        Map.Entry r18 = (Map.Entry) r17.next();
        z8.c.l(r10, "filters", (String) r18.getKey(), r18.getValue());
        goto L42
    L49:
        return;
    L30:
        if (r16 <= Integer.MIN_VALUE) goto L33;
        if (r16 > (-1073741824)) goto L33;
        z8.c.l(r10, "filters", "vmsize_range", "2G < VmSize <= 3G");
    L33:
        if (r16 <= (-1073741824)) goto L36;
        if (r16 > 0) goto L36;
        z8.c.l(r10, "filters", "vmsize_range", "3G < VmSize <= 4G");
    L36:
        if (r16 <= 0) goto L39;
        if (r16 > 0) goto L39;
        z8.c.l(r10, "filters", "vmsize_range", "4G < VmSize <= 8G");
    L39:
        z8.c.l(r10, "filters", "vmsize_range", "VmSize > 8G");
        goto L40
    L19:
        r15 = false;
        goto L20
    L15:
        r14 = false;
        goto L16
    L9:
        if (Header.h() == false) goto L11;
        r12 = 3891200;
        goto L12
    L11:
        r12 = 2867200;
        goto L12
    }
}
