package eu8;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h extends eu8.a {
    public final d c;

    public static class a extends eu8.a {
        public final String c;
        public final List<String> d;
        public final Object e;

        @Override // eu8.a
        public final String a() {
            Iterator<String> r0 = this.d.iterator();
            if (r0.hasNext() == false) goto L29;
            SharedPreferences.Editor r1 = this.a.getSharedPreferences(r0.next(), 0).edit();
            Object r2 = this.e;
            if (r2 != null) goto L9;
            r1.remove(this.c);
            r1.apply();
            return String.format("remove key %s successfully", new Object[]{this.c});
        L9:
            if ((r2 instanceof Integer) == false) goto L12;
            r1.putInt(this.c, ((Integer) r2).intValue());
        L26:
            r1.apply();
            return String.format("put key %s successfully", new Object[]{this.c});
        L12:
            if ((r2 instanceof Float) == false) goto L15;
            r1.putFloat(this.c, ((Float) r2).floatValue());
            goto L26
        L15:
            if ((r2 instanceof String) == false) goto L18;
            r1.putString(this.c, (String) r2);
            goto L26
        L18:
            if ((r2 instanceof Long) == false) goto L21;
            r1.putLong(this.c, ((Long) r2).longValue());
            goto L26
        L21:
            if ((r2 instanceof Boolean) == false) goto L24;
            r1.putBoolean(this.c, ((Boolean) r2).booleanValue());
            goto L26
        L24:
            if ((r2 instanceof Set) == false) goto L26;
            r1.putStringSet(this.c, (Set) r2);
            goto L26
        L29:
            return String.format("remove key %s failed", new Object[]{this.c});
        }

        public a(Context r1, JsonElement r2, List<String> r3, String r4, Object r5) {
            super(r1, r2);
            this.c = r4;
            this.d = r3;
            this.e = r5;
        }
    }

    @Override // eu8.a
    public final String a() {
        return (String) this.c.execute();
    }

    public static eu8.a c(Context r9, JsonObject r10) {
        String r0 = r10.get("cmd").getAsString();
        if (r0.startsWith("delete sp") == false) goto L38;
        if (r10.has("key") == true) goto L28;
        if (r10.has("repo") == false) goto L28;
        String r1 = String.format("%s.xml", new Object[]{r10.get("repo").getAsString()});
        String r2 = new PolarisFileWrapper(r9.getFilesDir().getParent(), "shared_prefs").getAbsolutePath();
        List<File> r3 = lu8.b.b(r2, true);
        ArrayList r4 = new ArrayList();
        if (r3 == null) goto L26;
        Iterator r5 = ((ArrayList) r3).iterator();     // Catch: Exception -> L23
    L12:
        if (r5.hasNext() == false) goto L26;
        File r6 = (File) r5.next();     // Catch: Exception -> L23
        if (r6 == null) goto L12;
        if (r6.exists() == false) goto L12;
        if (r6.isFile() == false) goto L12;
        String r7 = r6.getAbsolutePath().substring((r6.getAbsolutePath().indexOf(r2) + r2.length()) + 1);     // Catch: Exception -> L23
        nu8.a.a("SpOpExecutor", "subFilePath is " + r7 + " params is " + r1);     // Catch: Exception -> L23
        if (r7.matches(eu8.a.b(r1)) == false) goto L12;
        nu8.a.b("SpOpExecutor", "delete sp match success");     // Catch: Exception -> L23
        r4.add(new PolarisFileWrapper(r2, r7));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        nu8.a.b("SpOpExecutor", "getMatchedFiles failed:" + e);
    L26:
        return new h(r9, r10, new b(r9, r10, r4));
    L28:
        if (r10.has("key") == false) goto L85;
        if (r10.has("repo") == false) goto L85;
        if (r10.has("valueType") == false) goto L36;
        if (r10.has("value") == true) goto L85;
    L36:
        return new h(r9, r10, new a(r9, r10, d(r9, String.format("%s.xml", new Object[]{r10.get("repo").getAsString()})), r10.get("key").getAsString(), null));
    L85:
        return new f(r9, String.format("SpOpExecutor unsupport cmd %s", new Object[]{r0}));
    L38:
        if (r0.startsWith("set sp") == false) goto L85;
        String r8 = r10.get("repo").getAsString();
        String r11 = r10.get("key").getAsString();
        JsonElement r12 = r10.get("value");
        if (r12 != null) goto L42;
    L80:
        Object r13 = null;
    L81:
        Object r14 = r13;
    L83:
        return new h(r9, r10, new a(r9, r10, d(r9, String.format("%s.xml", new Object[]{r8})), r11, r14));
    L42:
        if (r12.isJsonPrimitive() == false) goto L74;
        String r15 = r10.get("valueType").getAsString();
        r15.getClass();
        byte r16 = -1;
        switch(r15.hashCode()) {
            case -891985903: goto L63;
            case 104431: goto L59;
            case 3327612: goto L55;
            case 64711720: goto L51;
            case 97526364: goto L47;
            default: goto L66;
        };
    L66:
        switch(r16) {
            case 0: goto L72;
            case 1: goto L71;
            case 2: goto L70;
            case 3: goto L69;
            case 4: goto L68;
            default: goto L80;
        };
    L68:
        r13 = Float.valueOf(r12.getAsFloat());
        goto L81
    L69:
        r13 = Boolean.valueOf(r12.getAsBoolean());
        goto L81
    L70:
        r13 = Long.valueOf(r12.getAsLong());
        goto L81
    L71:
        r13 = Integer.valueOf(r12.getAsInt());
        goto L81
    L72:
        r13 = r12.getAsString();
        goto L81
    L47:
        if (r15.equals("float") == false) goto L66;
        r16 = 4;
        goto L66
    L51:
        if (r15.equals("boolean") == false) goto L66;
        r16 = 3;
        goto L66
    L55:
        if (r15.equals("long") == false) goto L66;
        r16 = 2;
        goto L66
    L59:
        if (r15.equals("int") == false) goto L66;
        r16 = 1;
        goto L66
    L63:
        if (r15.equals("string") == false) goto L66;
        r16 = 0;
        goto L66
    L74:
        if (r12.isJsonArray() == false) goto L80;
        HashSet r17 = new HashSet();
        Iterator r18 = r12.getAsJsonArray().iterator();
    L77:
        if (r18.hasNext() == false) goto L79;
        r17.add(((JsonElement) r18.next()).getAsString());
        goto L77
    L79:
        r14 = r17;
        goto L83
    }

    public static ArrayList<String> d(Context r7, String r8) {
        String r9 = new PolarisFileWrapper(r7.getFilesDir().getParent(), "shared_prefs").getAbsolutePath();
        List<File> r2 = lu8.b.b(r9, true);
        ArrayList<String> r3 = new ArrayList();
        if (r2 != null) goto L20;
    L19:
        return r3;
    L20:
        Iterator r4 = ((ArrayList) r2).iterator();     // Catch: Exception -> L17
    L6:
        if (r4.hasNext() == false) goto L19;
        File r5 = (File) r4.next();     // Catch: Exception -> L17
        if (r5 == null) goto L6;
        if (r5.exists() == false) goto L6;
        if (r5.isFile() == false) goto L6;
        String r6 = r5.getAbsolutePath().substring((r5.getAbsolutePath().indexOf(r9) + r9.length()) + 1);     // Catch: Exception -> L17
        nu8.a.a("SpOpExecutor", "subFilePath is " + r6 + " params is " + r8);     // Catch: Exception -> L17
        if (r6.matches(eu8.a.b(r8)) == false) goto L6;
        nu8.a.b("SpOpExecutor", "match sp files success: " + r6);     // Catch: Exception -> L17
        r3.add(r6.replaceAll("\\.xml", ""));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        nu8.a.b("SpOpExecutor", "getMatchedSps failed: " + e);
        goto L19
    }

    public h(Context r1, JsonElement r2, eu8.a r3) {
        super(r1, r2);
        this.c = r3;
    }
}
