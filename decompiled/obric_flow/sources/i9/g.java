package i9;

import android.text.TextUtils;
import com.bytedance.crash.util.NativeTools;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f17545i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f17546j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f17547k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f17548l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f17549m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f17552c;
    public String d;
    public String e;
    public boolean f;
    public final HashMap g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet f17553h;

    static {
        f17545i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");
        f17546j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");
        f17547k = Pattern.compile("^Abort message: (.*)$");
        f17548l = Pattern.compile("^Crash message: (.*)$");
        f17549m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");
    }

    public g(File r5) {
        this.f = false;
        this.g = new HashMap();
        this.f17553h = new HashSet();
        String r10 = com.bytedance.crash.util.g.f4181a;
        d(new File(r5, "tombstone.txt"));
    }

    public static String[] c(String r10) {
        String[] r11 = r10.split("\\s+");
        String[] r5 = {"", ""};
        if (r11.length < 4) goto L27;
        int r12 = r11.length;
        int r13 = 0;
        String r14 = null;
    L6:
        if (r13 >= r12) goto L14;
        String r15 = r11[r13];
        if (r15.startsWith("/") == false) goto L12;
        if (r15.endsWith(".so") == false) goto L12;
        r14 = r15;
    L12:
        r13 = r13 + 1;
        goto L6
    L14:
        if (TextUtils.isEmpty(r14) == false) goto L17;
        return null;
    L17:
        if (r14.endsWith(".so") == false) goto L27;
        if (r14.contains("/system/lib") == true) goto L27;
        int r16 = r14.lastIndexOf(47);
        if (r16 == (-1)) goto L27;
        int r17 = r16 + 1;
        String r18 = r14.substring(r17);
        if (r18.contains(".apk!") == false) goto L25;
        r18 = r18.substring(r18.indexOf(".apk!") + 5);
    L25:
        String r19 = r14.substring(0, r17) + r18;
        r5[0] = r18;
        r5[1] = r19;
        return r5;
    L27:
        return null;
    }

    public final String a() {
        StringBuilder r5 = new StringBuilder();
        String r10 = this.f17552c;
        if (r10 == null) goto L5;
        r5.append(r10);
    L5:
        String r11 = this.d;
        if (r11 == null) goto L8;
        r5.append(r11);
    L8:
        String r12 = this.e;
        if (r12 == null) goto L12;
        r5.append(r12);
    L12:
        return r5.toString();
    }

    public final void b(File r10) {
        ArrayList r5 = new ArrayList();
        Iterator r11 = this.f17553h.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        String r12 = (String) r11.next();
        if (TextUtils.isEmpty(r12) == true) goto L4;
        String r13 = new File(r12).getName();
        HashMap r14 = this.g;
        if (r14.containsKey(r13) == true) goto L4;
        NativeTools.k().getClass();
        String r15 = NativeTools.z(r12);
        if (TextUtils.isEmpty(r15) == true) goto L4;
        r14.put(r13, r15);
        r5.add("    " + r12 + " (BuildId: " + r15 + ")");
        StringBuilder r16 = com.lynx.tasm.utils.e.b("getBuildId nextStart: ", r12, " : ");
        r16.append((String) r14.get(r13));
        io.reactivex.exceptions.a.i(r16.toString());
        goto L4
    L13:
        if (r5.size() <= 0) goto L46;
        String[] r17 = new String[r5.size()];
        String r18 = r10.getAbsolutePath();
        String[] r19 = (String[]) r5.toArray(r17);
        File r20 = new File(r18);     // Catch: Throwable -> L27
        BufferedReader r21 = new BufferedReader(new InputStreamReader(new FileInputStream(r20)));     // Catch: Throwable -> L27
        File r110 = new File(r20.getParent(), r20.getName() + ".temp");     // Catch: Throwable -> L27
        PrintWriter r22 = new PrintWriter(new FileOutputStream(r110));     // Catch: Throwable -> L27
        int r23 = 0;
    L16:
        String r24 = r21.readLine();     // Catch: Throwable -> L27
        if (r24 == null) goto L25;
        if (r24.equals("build id:") == false) goto L24;
        if (r23 > 0) goto L24;
        r23 = r23 + 1;     // Catch: Throwable -> L27
        r22.println(r24);     // Catch: Throwable -> L27
        int r25 = r19.length;     // Catch: Throwable -> L27
        int r26 = 0;
    L22:
        if (r26 >= r25) goto L16;
        r22.println(r19[r26]);     // Catch: Throwable -> L27
        r26 = r26 + 1;     // Catch: Throwable -> L27
    L24:
        r22.println(r24);     // Catch: Throwable -> L27
        goto L16
    L25:
        r22.flush();     // Catch: Throwable -> L27
        r22.close();     // Catch: Throwable -> L27
        r21.close();     // Catch: Throwable -> L27
        r20.delete();     // Catch: Throwable -> L27
        r110.renameTo(r20);     // Catch: Throwable -> L27
        return;
    L47:
        return;
    }

    public final void d(File r14) {
        HashMap r5 = this.g;
        if (r14.exists() == true) goto L5;
        return;
    L5:
        if (r14.length() == 0) goto L140;
        BufferedReader r10 = new BufferedReader(new FileReader(r14));     // Catch: Throwable -> L91
        int r11 = 0;
        int r12 = 0;
    L99:
        String r13 = r10.readLine();     // Catch: Throwable -> L85
        if (r13 == null) goto L88;
        if (r12 >= 64) goto L88;
        if (this.f17550a != null) goto L24;
        if (r13.startsWith("pid: ") == false) goto L24;
        Matcher r15 = f17545i.matcher(r13);     // Catch: Throwable -> L85
        if (r15.find() == false) goto L87;
        if (r15.groupCount() != 4) goto L87;
        this.f17550a = r15.group(1);     // Catch: Throwable -> L85
        r15.group(2);     // Catch: Throwable -> L85
        this.f17551b = r15.group(3);     // Catch: Throwable -> L85
        r15.group(4);     // Catch: Throwable -> L85
    L87:
        r12 = r12 + 1;     // Catch: Throwable -> L85
    L24:
        if (this.f17552c != null) goto L36;
        if (r13.startsWith("signal ") == false) goto L36;
        Matcher r16 = f17546j.matcher(r13);     // Catch: Throwable -> L85
        if (r16.find() == false) goto L87;
        if (r16.groupCount() != 3) goto L87;
        String r17 = r16.group(1).replace(" ", "");     // Catch: Throwable -> L85
        String r18 = r16.group(2).replace(" ", "");     // Catch: Throwable -> L85
        int r19 = r18.indexOf("frompid");     // Catch: Throwable -> L85
        if (r19 <= 0) goto L34;
        r18 = r18.substring(0, r19) + ")";     // Catch: Throwable -> L85
    L34:
        this.f17552c = "Signal " + r17 + ", Code " + r18 + "\n";     // Catch: Throwable -> L85
    L36:
        if (this.d != null) goto L45;
        if (r13.startsWith("Abort ") == false) goto L45;
        Matcher r20 = f17547k.matcher(r13);     // Catch: Throwable -> L85
        if (r20.find() == false) goto L87;
        if (r20.groupCount() != 1) goto L87;
        this.d = "abort message: " + r20.group(1) + "\n";     // Catch: Throwable -> L85
    L45:
        if (this.d != null) goto L54;
        if (r13.startsWith("Crash ") == false) goto L54;
        Matcher r21 = f17548l.matcher(r13);     // Catch: Throwable -> L85
        if (r21.find() == false) goto L87;
        if (r21.groupCount() != 1) goto L87;
        this.d = "crash message: " + r21.group(1) + "\n";     // Catch: Throwable -> L85
    L54:
        if (this.e != null) goto L67;
        if (r13.startsWith("backtrace:") == false) goto L67;
        StringBuilder r22 = new StringBuilder();     // Catch: Throwable -> L85
    L58:
        String r23 = r10.readLine();     // Catch: Throwable -> L85
        if (r23 == null) goto L65;
        if (r23.startsWith("    #") == false) goto L65;
        String r24 = r23.substring(4);     // Catch: Throwable -> L85
        r22.append(r24);     // Catch: Throwable -> L85
        r22.append('\n');     // Catch: Throwable -> L85
        String[] r25 = c(r24);     // Catch: Throwable -> L85
        if (r25 == null) goto L58;
        this.f17553h.add(r25[1]);     // Catch: Throwable -> L85
    L65:
        r12 = r12 + 1;     // Catch: Throwable -> L85
        this.e = r22.toString();     // Catch: Throwable -> L85
    L67:
        if (r5.isEmpty() == false) goto L87;
        if (r13.startsWith("build id:") == false) goto L87;
    L70:
        String r26 = r10.readLine();     // Catch: Throwable -> L85
        if (r26 == null) goto L84;
        if (r26.contains("BuildId:") == false) goto L74;
        Matcher r27 = f17549m.matcher(r26);     // Catch: Throwable -> L85
        if (r27.find() == false) goto L70;
        r5.put(r27.group(2), r27.group(3));     // Catch: Throwable -> L85
    L74:
        if (r11 >= 10) goto L84;
        if (r26 == null) goto L84;
        if (r26.startsWith("stack:") == true) goto L78;
        r26 = r10.readLine();     // Catch: Throwable -> L85
        r11 = r11 + 1;     // Catch: Throwable -> L85
        goto L74
    L78:
        this.f = true;     // Catch: Throwable -> L85
    L84:
        io.reactivex.exceptions.a.i("check complete end buildIds");     // Catch: Throwable -> L85
    L88:
        io.reactivex.exceptions.a.i("check complete end");     // Catch: Throwable -> L85
        com.bytedance.android.anniex.base.service.f.h(r10);     // Catch: Throwable -> L85
        b(r14);     // Catch: Throwable -> L85
        com.bytedance.android.anniex.base.service.f.h(r10);
        return;
    L85:
        th = th;
    L101:
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L95
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L95
        com.bytedance.android.anniex.base.service.f.h(r10);
        return;
    L95:
        th = move-exception;
        com.bytedance.android.anniex.base.service.f.h(r10);
        throw th;
    L91:
        th = th;
        r10 = null;
        goto L101
    }
}
