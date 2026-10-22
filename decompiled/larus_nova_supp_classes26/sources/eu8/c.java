package eu8;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static g a(Context r6, JsonObject r7) {
        if (r6 == null) goto L43;
        if (r7 == null) goto L43;
        nu8.a.h("ExecutorBuilder", "createInner input ORIGINAL cmd : " + r7);
        JsonObject r0 = new JsonObject();     // Catch: Exception -> L18
        Iterator r2 = r7.keySet().iterator();     // Catch: Exception -> L18
    L8:
        if (r2.hasNext() == false) goto L17;
        String r3 = (String) r2.next();     // Catch: Exception -> L18
        JsonElement r4 = r7.get(r3);     // Catch: Exception -> L18
        if (r4 == null) goto L8;
        if (r4.isJsonNull() == true) goto L8;
        if (TextUtils.isEmpty(r4.getAsString()) == true) goto L8;
        r0.add(r3, r4);     // Catch: Exception -> L18
        goto L8
    L17:
        r7 = r0;
    L20:
        nu8.a.h("ExecutorBuilder", "createInner input CLEANED cmd : " + r7);
        String r1 = r7.get("cmd").getAsString();
        String[] r5 = r1.split(" ");
    L41:
        e = move-exception;
        StringWriter r8 = new StringWriter();
        e.printStackTrace(new PrintWriter(r8));
        nu8.a.c("ExecutorBuilder", "createInner failed: ", e);
        a r9 = new f(r6, r8.toString());
    L45:
        return new g(r9);
    L22:
        if (r1.startsWith("delete innerData") == false) goto L25;
        r9 = new b(r6, r7, b(r6, r5[2], false));     // Catch: Exception -> L41
    L48:
        goto L45
    L25:
        if (r1.startsWith("delete outerData") == false) goto L28;
        r9 = new b(r6, r7, b(r6, r5[2], true));     // Catch: Exception -> L41
        goto L48
    L28:
        if (r1.startsWith("set keva") == false) goto L30;
    L39:
        r9 = e.c(r6, r7);     // Catch: Exception -> L41
        goto L48
    L30:
        if (r1.startsWith("delete keva") == true) goto L39;
        if (r1.startsWith("set sp") == false) goto L35;
    L38:
        r9 = h.c(r6, r7);     // Catch: Exception -> L41
        goto L48
    L35:
        if (r1.startsWith("delete sp") == true) goto L38;
        r9 = new f(r6, "unsupport cmd");     // Catch: Exception -> L41
    L18:
        e = move-exception;
        nu8.a.c("ExecutorBuilder", "removeEmptyProperties failed: ", e);
    L43:
        r9 = new f(r6, "invalid params");
        goto L45
    }

    public static ArrayList<File> b(Context r6, String r7, boolean r8) {
        if (r8 == true) goto L5;
        String r9 = r6.getFilesDir().getParent();
    L9:
        ArrayList<File> r10 = new ArrayList();
        if (r9 == null) goto L28;
        List<File> r2 = lu8.b.b(r9, true);
        if (r2 == null) goto L28;
        Iterator r3 = ((ArrayList) r2).iterator();     // Catch: Exception -> L26
    L15:
        if (r3.hasNext() == false) goto L28;
        File r4 = (File) r3.next();     // Catch: Exception -> L26
        if (r4 == null) goto L15;
        if (r4.exists() == false) goto L15;
        if (r4.isFile() == false) goto L15;
        String r5 = r4.getAbsolutePath().substring((r4.getAbsolutePath().indexOf(r9) + r9.length()) + 1);     // Catch: Exception -> L26
        nu8.a.a("ExecutorBuilder", "subFilePath is " + r5 + " params is " + r7);     // Catch: Exception -> L26
        if (r5.matches(a.b(r7)) == false) goto L15;
        nu8.a.h("ExecutorBuilder", "match files success: " + r5);     // Catch: Exception -> L26
        r10.add(new PolarisFileWrapper(r9, r5));     // Catch: Exception -> L26
    L26:
        e = move-exception;
        nu8.a.b("ExecutorBuilder", "getMatchesFiles failed: " + e);
    L28:
        return r10;
    L5:
        if (r6.getExternalCacheDir() == null) goto L7;
        r9 = r6.getExternalCacheDir().getParent();
        goto L9
    L7:
        r9 = null;
        goto L9
    }
}
