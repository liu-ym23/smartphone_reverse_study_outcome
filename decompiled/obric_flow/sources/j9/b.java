package j9;

import android.content.Context;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.NativeTools;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l9.c;
import mh.e;
import org.json.JSONArray;
import z8.d;
import z8.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18292c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18293h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f18294i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f18295j;

    public b(File r10, Context r11) {
        this.e = e.c(c.e(), 500, new String[]{"custom_event_settings", "fd_track", "track_water_line"});
        this.d = e.c(c.e(), 1000, new String[]{"custom_event_settings", "fd_track", "track_dump_line"});
        this.f = e.c(c.e(), 60000, new String[]{"custom_event_settings", "fd_track", "track_sleep_time"});
        this.f18295j = e.c(c.e(), 10, new String[]{"custom_event_settings", "fd_track", "backtrace_limit"});
        this.f18293h = "all";
        String[] r5 = "1,2,3".split(",");
        int r12 = r5.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L10;
        int r15 = Integer.parseInt(r5[r13]);
        if (r15 < 0) goto L9;
        if (r15 >= 32) goto L9;
        r14 = r14 + (1 << r15);
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "monitor type: " + r14);
        this.g = r14;
        this.f18294i = r10.getAbsolutePath();
        this.f18290a = r11;
        this.f18291b = 0;
        this.f18292c = false;
        if (r10.exists() == true) goto L18;
        r10.mkdirs();
        return;
    }

    public static int a(File r16) {
        File[] r5 = r16.listFiles();
        File r10 = new File(r16, "tombstone.txt");
        File r11 = new File(r16, "javastack.txt");
        File r12 = new File(r16, "fd_types.txt");
        if (r5 == null) goto L122;
        if (r5.length == 0) goto L122;
        if (r10.exists() == false) goto L122;
    L12:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        return -1;
    L10:
        if (r11.exists() == false) goto L15;
        String r13 = cl.a.D(r11.getAbsolutePath());     // Catch: Throwable -> L12 IOException -> L14
    L16:
        JSONArray r14 = cl.a.F(r10.getAbsolutePath());     // Catch: Throwable -> L12 IOException -> L14
        if (r14 != null) goto L21;
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "stack content is null");     // Catch: Throwable -> L12 IOException -> L14
        return -1;
    L21:
        int r15 = b(r14, 0, "pid:");     // Catch: Throwable -> L12 IOException -> L14
        int r17 = 1;
        if (r15 < 0) goto L32;
        String[] r18 = r14.optString(r15, null).trim().split("\\s");     // Catch: Throwable -> L12 IOException -> L14
        int r19 = 0;
    L112:
        if (r19 >= r18.length) goto L32;
        if ("name:".equals(r18[r19]) == true) goto L29;
        r19 = r19 + 1;     // Catch: Throwable -> L12 IOException -> L30
        goto L112
    L29:
        String r20 = r18[r19 + 1];     // Catch: Throwable -> L12 IOException -> L30
        String r21 = r20.substring(0, r20.length());     // Catch: Throwable -> L12 IOException -> L30
    L33:
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L12 IOException -> L30
        int r111 = b(r14, r15 + 1, "Signal ");     // Catch: Throwable -> L12 IOException -> L30
        if (r111 < 0) goto L36;
        r110.append(r14.optString(r111, null));     // Catch: Throwable -> L12 IOException -> L30
        r110.append('\n');     // Catch: Throwable -> L12 IOException -> L30
    L36:
        int r112 = b(r14, r111 + 1, "Abort message:");     // Catch: Throwable -> L12 IOException -> L30
        if (r112 < 0) goto L53;
        String r22 = r14.optString(r112, null).replace("Abort message:", "abort message:");     // Catch: Throwable -> L12 IOException -> L30
        r110.append(r22);     // Catch: Throwable -> L12 IOException -> L30
        r110.append('\n');     // Catch: Throwable -> L12 IOException -> L30
        if (r22.startsWith("abort message:") == true) goto L114;
    L52:
        String r113 = r22;
        String r23 = null;
        String r114 = null;
    L54:
        int r24 = b(r14, r112 + 1, "backtrace:");     // Catch: Throwable -> L12 IOException -> L30
        if (r24 < 0) goto L63;
    L56:
        r24 = r24 + r17;     // Catch: Throwable -> L12 IOException -> L30
        if (r24 >= r14.length()) goto L61;
        String r115 = r14.optString(r24, null);     // Catch: Throwable -> L12 IOException -> L30
        if (r115.startsWith("    #") == false) goto L61;
        r110.append(r115.trim());     // Catch: Throwable -> L12 IOException -> L30
        r110.append('\n');     // Catch: Throwable -> L12 IOException -> L30
        r17 = 1;
    L61:
        String r25 = r110.toString();     // Catch: Throwable -> L12 IOException -> L30
    L116:
        JSONArray r26 = cl.a.F(r12.getAbsolutePath());     // Catch: Throwable -> L76
        if (r26 == null) goto L75;
        String r27 = null;
        String r28 = r26.optString(0, null);     // Catch: Throwable -> L73
        if (r28 != null) goto L70;
    L79:
        String r116 = r27;
    L80:
        if (r114 == null) goto L84;
        if (r116 == null) goto L84;
        if (r23 == null) goto L84;
        boolean r29 = true;
    L85:
        if (r25 == null) goto L101;
        if (r21 == null) goto L125;
        if (r113 == null) goto L126;
        if (r114 == null) goto L127;
        if (r116 == null) goto L128;
        f r30 = f.r(r13, r25, r113, r21);     // Catch: Throwable -> L93
        z8.c.l(r30.b(), "filters", "fd_leak_count", r116);     // Catch: Throwable -> L93
        z8.c.l(r30.b(), "filters", "fd_leak_lib", r114);     // Catch: Throwable -> L93
        z8.c.l(r30.b(), "filters", "fd_leak_reason", r23);     // Catch: Throwable -> L93
        if (r29 == false) goto L95;
        String r31 = "true";
    L96:
        z8.c.l(r30.b(), "filters", "has_fd_track", r31);     // Catch: Throwable -> L93
        z8.c.l(r30.b(), "filters", "is_64_devices", String.valueOf(Header.h()));     // Catch: Throwable -> L93
        z8.c.l(r30.b(), "filters", "is_64_runtime", String.valueOf(NativeTools.k().E()));     // Catch: Throwable -> L93
        c(r30, r16);     // Catch: Throwable -> L93
        n.d(r30, d.f23419b, System.currentTimeMillis(), r16);     // Catch: Throwable -> L93
        return 1;
    L95:
        r31 = "false";
    L93:
        th = move-exception;
        io.reactivex.exceptions.a.d("[NpthFdTracker]: ", "upload exception:" + th);
        return 0;
    L128:
        return 0;
    L127:
        return 0;
    L126:
        return 0;
    L125:
        return 0;
    L101:
        return 0;
    L84:
        r29 = false;
        goto L85
    L70:
        if ("".equals(r28) == true) goto L79;
        r116 = r28.trim().split(" ")[1];     // Catch: Throwable -> L73
    L73:
        th = th;
    L78:
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L79
    L75:
        r27 = null;
    L76:
        th = th;
        r27 = null;
        goto L78
    L63:
        r25 = null;
        goto L116
    L114:
        Matcher r32 = Pattern.compile("^.*:\\s+(\\S+):.*,.*,\\s+\\S+\\s+(\\S+)\\(.*$").matcher(r22);     // Catch: Throwable -> L49
        if (r32.find() == false) goto L52;
        r114 = r32.group(1);     // Catch: Throwable -> L49
        r113 = r22;
        r23 = r32.group(2);     // Catch: Throwable -> L47
    L47:
        th = th;
    L51:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L12 IOException -> L30
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L12 IOException -> L30
        r113 = r22;
        r23 = null;
    L49:
        th = th;
        r114 = null;
        goto L51
    L53:
        r23 = null;
        r114 = null;
        r113 = null;
    L124:
        return -1;
    L32:
        r21 = null;
        goto L33
    L15:
        r13 = null;
        goto L16
    L123:
        return -1;
    L122:
        return -1;
    }

    public static int b(JSONArray r5, int r10, String r11) {
    L3:
        if (r10 >= r5.length()) goto L10;
        String r12 = r5.optString(r10, null);
        if (r12 == null) goto L9;
        if (r12.startsWith(r11) == false) goto L9;
        return r10;
    L9:
        r10 = r10 + 1;
        goto L3
    L10:
        return -1;
    }

    public static void c(f r10, File r11) {
        File r5 = new File(r11, "logcat.txt");
        if (r5.exists() == false) goto L34;
        JSONArray r12 = new JSONArray();
        BufferedReader r13 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L17
    L10:
        th = th;
    L30:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L23
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L23
        com.bytedance.android.anniex.base.service.f.h(r13);
    L21:
        e.g(r12, "logcat", r10.f23416a);
        return;
    L23:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r13);
        throw th;
    L8:
        if (r5.length() <= LynxResourceModule.DEFAULT_MEDIA_SIZE) goto L12;
        r13.skip(r5.length() - LynxResourceModule.DEFAULT_MEDIA_SIZE);     // Catch: Throwable -> L10
    L12:
        String r14 = r13.readLine();     // Catch: Throwable -> L10
        if (r14 == null) goto L16;
        r12.put(r14);     // Catch: Throwable -> L10
        goto L12
    L16:
        com.bytedance.android.anniex.base.service.f.h(r13);
    L17:
        th = th;
        r13 = null;
        goto L30
    }
}
