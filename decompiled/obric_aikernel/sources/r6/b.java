package r6;

import com.bytedance.apm6.util.ListUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static void a(File r10, HashMap<String, Object> r11, List<String> r12) {
        if (c(r10.getName()) == false) goto L5;
        return;
    L5:
        int r13 = 0;
        if (ListUtils.isEmpty(r12) == true) goto L13;
        Iterator<String> r14 = r12.iterator();
    L9:
        if (r14.hasNext() == false) goto L13;
        if (r10.getAbsolutePath().startsWith(r14.next()) == false) goto L9;
        boolean r15 = true;
    L14:
        if (r15 == false) goto L20;
        StringBuilder r16 = new StringBuilder();
        int r17 = 0;
    L17:
        if (r17 >= r10.getName().length()) goto L19;
        r16.append("*");
        r17 = r17 + 1;
        goto L17
    L19:
        String r18 = r16.toString();
    L22:
        if (r10.isFile() == false) goto L25;
        r11.put(r18, Long.valueOf(r10.length()));
    L25:
        if (r10.isDirectory() == false) goto L29;
        HashMap r19 = new HashMap();
        r11.put(r18, r19);
        String[] r20 = r10.list();
        int r21 = r20.length;
    L27:
        if (r13 >= r21) goto L35;
        a(new File(r10, r20[r13]), r19, r12);
        r13 = r13 + 1;
        goto L27
    L35:
        return;
    L29:
        return;
    L20:
        r18 = r10.getName();
    L13:
        r15 = false;
        goto L14
    }

    protected static void b(File r10, BufferedWriter r11, List<String> r12) {
        HashMap r13 = new HashMap();
        r11.write("{");
        r11.newLine();
        File[] r14 = r10.listFiles();
        int r15 = 0;
    L4:
        if (r15 >= r14.length) goto L12;
        r13.clear();
        a(r14[r15], r13, r12);
        if (r13.keySet().isEmpty() == true) goto L11;
        e(r13, 1, r11);
        if ((r15 + 1) >= r14.length) goto L11;
        r11.write(",");
    L11:
        r15 = r15 + 1;
        goto L4
    L12:
        r11.write("}");
        r11.flush();
    }

    private static boolean c(String r10) {
        return r10.startsWith(".");
    }

    public static boolean d(File r10, File r11, List<String> r12) {
        BufferedWriter r13 = null;
        FileWriter r14 = new FileWriter(r11);     // Catch: Throwable -> L18 IOException -> L20
        BufferedWriter r15 = new BufferedWriter(r14);     // Catch: IOException -> L16 Throwable -> L33
        b(r10, r15, r12);     // Catch: Throwable -> L12 IOException -> L14
    L45:
        r15.close();     // Catch: IOException -> L9
        r14.close();     // Catch: IOException -> L9
    L11:
        return true;
    L9:
        e = move-exception;
        e.printStackTrace();
    L14:
        e = e;
        r13 = r15;
    L22:
        e.printStackTrace();     // Catch: Throwable -> L33
        if (r13 != null) goto L47;
    L27:
        if (r14 == null) goto L56;
        r14.close();     // Catch: IOException -> L25
        return false;
    L25:
        e = move-exception;
        e.printStackTrace();
        return false;
    L56:
        return false;
    L47:
        r13.close();     // Catch: IOException -> L25
    L12:
        th = th;
        r13 = r15;
    L34:
        if (r13 != null) goto L43;
    L38:
        if (r14 == null) goto L42;
        r14.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        e.printStackTrace();
    L42:
        throw th;
    L43:
        r13.close();     // Catch: IOException -> L36
    L16:
        e = e;
    L33:
        th = th;
        goto L34
    L20:
        e = e;
        r14 = null;
    L18:
        th = th;
        r14 = null;
        goto L34
    }

    private static void e(HashMap<String, Object> r13, int r14, BufferedWriter r15) {
        int r10 = r13.keySet().size();
        Iterator<String> r11 = r13.keySet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L24;
        String r16 = r11.next();
        Object r17 = r13.get(r16);
        r12 = r12 + 1;
        if ((r17 instanceof Long) == false) goto L15;
        int r18 = 0;
    L9:
        if (r18 >= (r14 + 1)) goto L11;
        r15.write("\t");
        r18 = r18 + 1;
        goto L9
    L11:
        r15.write(String.format("\"%s\": %d", new Object[]{r16.replaceAll("\n", ""), Long.valueOf(((Long) r17).longValue())}));
        if (r12 >= r10) goto L14;
    L13:
        r15.write(",");
    L14:
        r15.newLine();
        goto L4
    L15:
        int r19 = 0;
    L16:
        if (r19 >= r14) goto L18;
        r15.write("\t");
        r19 = r19 + 1;
        goto L16
    L18:
        r15.write(String.format("\"%s\": {", new Object[]{r16.replaceAll("\n", "")}));
        r15.newLine();
        int r20 = r14 + 1;
        e((HashMap) r17, r20, r15);
        int r21 = 0;
    L19:
        if (r21 >= r20) goto L21;
        r15.write("\t");
        r21 = r21 + 1;
        goto L19
    L21:
        r15.write("}");
        if (r12 >= r10) goto L14;
    }
}
