package d9a;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.aivoice.core.data.NameKeys;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public static void a(File r5, HashMap<String, Object> r6, List<String> r7) {
        if (r5.getName().startsWith(".") == false) goto L5;
        return;
    L5:
        int r1 = 0;
        if (xu3.e.b(r7) == true) goto L13;
        Iterator r0 = ((ArrayList) r7).iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        String r2 = (String) r0.next();
        if (r5.getAbsolutePath().startsWith(r2) == false) goto L9;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L20;
        StringBuilder r4 = new StringBuilder();
        int r8 = 0;
    L17:
        if (r8 >= r5.getName().length()) goto L19;
        r4.append("*");
        r8 = r8 + 1;
        goto L17
    L19:
        String r9 = r4.toString();
    L22:
        if (r5.isFile() == false) goto L25;
        r6.put(r9, Long.valueOf(r5.length()));
    L25:
        if (r5.isDirectory() == false) goto L29;
        HashMap r10 = new HashMap();
        r6.put(r9, r10);
        String[] r11 = r5.list();
        int r12 = r11.length;
    L27:
        if (r1 >= r12) goto L35;
        a(new PolarisFileWrapper(r5, r11[r1]), r10, r7);
        r1 = r1 + 1;
        goto L27
    L35:
        return;
    L29:
        return;
    L20:
        r9 = r5.getName();
    L13:
        r3 = false;
        goto L14
    }

    public static void b(PolarisFileWrapper r4, BufferedWriter r5, List r6) throws IOException {
        HashMap r0 = new HashMap();
        r5.write("{");
        r5.newLine();
        File[] r7 = r4.listFiles();
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L12;
        r0.clear();
        a(r7[r1], r0, r6);
        if (r0.keySet().isEmpty() == true) goto L11;
        c(r0, 1, r5);
        if ((r1 + 1) >= r7.length) goto L11;
        r5.write(",");
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        r5.write("}");
        r5.flush();
    }

    public static void c(HashMap<String, Object> r13, int r14, BufferedWriter r15) throws IOException {
        int r0 = r13.keySet().size();
        Iterator<String> r1 = r13.keySet().iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L25;
        String r4 = r1.next();
        Object r5 = r13.get(r4);
        r3 = r3 + 1;
        if ((r5 instanceof Long) == true) goto L7;
        int r7 = 0;
    L16:
        if (r7 >= r14) goto L18;
        r15.write("\t");
        r7 = r7 + 1;
        goto L16
    L18:
        r15.write(String.format("\"%s\": {", new Object[]{r4.replaceAll("\n", NameKeys.UnloadStrategy_No_Strategy)}));
        r15.newLine();
        int r6 = r14 + 1;
        c((HashMap) r5, r6, r15);
        int r8 = 0;
    L19:
        if (r8 >= r6) goto L21;
        r15.write("\t");
        r8 = r8 + 1;
        goto L19
    L21:
        r15.write("}");
        if (r3 >= r0) goto L24;
        r15.write(",");
    L24:
        r15.newLine();
        goto L4
    L7:
        int r9 = 0;
    L9:
        if (r9 >= (r14 + 1)) goto L11;
        r15.write("\t");
        r9 = r9 + 1;
        goto L9
    L11:
        r15.write(String.format("\"%s\": %d", new Object[]{r4.replaceAll("\n", NameKeys.UnloadStrategy_No_Strategy), Long.valueOf(((Long) r5).longValue())}));
        if (r3 >= r0) goto L14;
        r15.write(",");
    L14:
        r15.newLine();
        goto L4
    }
}
