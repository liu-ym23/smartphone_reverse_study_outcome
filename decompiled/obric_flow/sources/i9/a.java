package i9;

import com.bytedance.crash.util.NativeTools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final Pattern d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f17521c;

    static {
        Pattern.compile("(?<===).*?(?===ERROR)");
        Pattern.compile("(?<=AddressSanitizer:).*?(?=on)");
        Pattern.compile("(?<=asan/).*?(?=/asan_report)");
        Pattern.compile("__asan_handle_no_return");
        d = Pattern.compile("(?<=\\().*?(?=\\+)");
    }

    public a(String r10) {
        this.f17521c = new HashMap();
        File r5 = new File(r10);
        if (r5.exists() == true) goto L5;
        return;
    L5:
        if (r5.length() == 0) goto L56;
        this.f17520b = new Date(r5.lastModified()).getTime();
        BufferedReader r11 = new BufferedReader(new FileReader(r5));     // Catch: Throwable -> L33
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L27
    L10:
        String r13 = r11.readLine();     // Catch: Throwable -> L27
        if (r13 == null) goto L30;
        if (r13.startsWith("    #") == false) goto L29;
        Matcher r14 = d.matcher(r13);     // Catch: Throwable -> L27
        if (r14.find() == false) goto L29;
        if (r14.group(0) == null) goto L29;
        String r15 = r14.group(0) + "\n";     // Catch: Throwable -> L27
        if (r15.startsWith("/data/") == false) goto L29;
        String r16 = new File(r15.trim()).getName();     // Catch: Throwable -> L27
        NativeTools.k().getClass();     // Catch: Throwable -> L27
        String r17 = NativeTools.z(r16);     // Catch: Throwable -> L27
        if (r17 == null) goto L24;
        this.f17521c.put(r16, r17);     // Catch: Throwable -> L27
        goto L29
    L24:
        NativeTools.k().getClass();     // Catch: Throwable -> L27
        String r18 = NativeTools.z(r15);     // Catch: Throwable -> L27
        if (r18 == null) goto L29;
        this.f17521c.put(r16, r18);     // Catch: Throwable -> L27
    L29:
        r12.append(r13 + "\n");     // Catch: Throwable -> L27
        goto L10
    L30:
        this.f17519a = r12.toString();     // Catch: Throwable -> L27
        com.bytedance.android.anniex.base.service.f.h(r11);
        return;
    L27:
        th = th;
    L41:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L37
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L37
        com.bytedance.android.anniex.base.service.f.h(r11);
        return;
    L37:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r11);
        throw th;
    L33:
        th = th;
        r11 = null;
        goto L41
    }
}
