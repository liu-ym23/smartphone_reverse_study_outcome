package eu8;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
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
public final class e extends eu8.a {
    public final d c;

    public static class a extends eu8.a {
        public final String c;
        public final List<String> d;

        @Override // eu8.a
        public final String a() {
            List<String> r0 = this.d;
            if (r0 != null) goto L5;
            return "invalid keva del op";
        L5:
            if (r0.size() == 0) goto L30;
            Iterator<String> r1 = this.d.iterator();
        L8:
            if (r1.hasNext() == false) goto L31;
            String r2 = r1.next();
            if (TextUtils.isEmpty(r2) == true) goto L16;
            if (TextUtils.isEmpty(this.c) == false) goto L16;
            Keva.getRepo(r2, 1).clear();
            return String.format("del keva repo %s success", new Object[]{r2});
        L16:
            if (TextUtils.isEmpty(r2) == true) goto L8;
            if (TextUtils.isEmpty(this.c) == true) goto L8;
            Keva.getRepo(r2, 1).erase(this.c);
            return String.format("del keva key repo %s key %s success", new Object[]{r2, this.c});
        L31:
            return "invalid keva del op";
        L30:
            return "invalid keva del op";
        }

        public a(Context r1, JsonElement r2, List<String> r3, String r4) {
            super(r1, r2);
            this.c = r4;
            this.d = r3;
        }
    }

    public static class b extends eu8.a {
        public final String c;
        public final List<String> d;
        public final Object e;

        @Override // eu8.a
        public final String a() {
            List<String> r0 = this.d;
            if (r0 == null) goto L32;
            if (r0.size() == 0) goto L32;
            Iterator<String> r1 = this.d.iterator();
        L8:
            if (r1.hasNext() == false) goto L30;
            Keva r3 = Keva.getRepo(r1.next(), 1);
            Object r4 = this.e;
            if (r4 == null) goto L8;
            if ((r4 instanceof Integer) == true) goto L13;
            if ((r4 instanceof Float) == true) goto L16;
            if ((r4 instanceof String) == true) goto L19;
            if ((r4 instanceof Long) == true) goto L22;
            if ((r4 instanceof Boolean) == true) goto L25;
            if ((r4 instanceof Set) == false) goto L8;
            r3.storeStringSet(this.c, (Set) r4);
            goto L8
        L25:
            r3.storeBoolean(this.c, ((Boolean) r4).booleanValue());
            goto L8
        L22:
            r3.storeLong(this.c, ((Long) r4).longValue());
            goto L8
        L19:
            r3.storeString(this.c, (String) r4);
            goto L8
        L16:
            r3.storeFloat(this.c, ((Float) r4).floatValue());
            goto L8
        L13:
            r3.storeInt(this.c, ((Integer) r4).intValue());
            goto L8
        L30:
            return String.format("put key %s successfully", new Object[]{this.c});
        L32:
            return String.format("put key %s failed, NO repo MATCHED ", new Object[]{this.c});
        }

        public b(Context r1, JsonElement r2, List<String> r3, String r4, Object r5) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static eu8.a c(Context r13, JsonObject r14) {
        String r0 = r14.get("cmd").getAsString();
        ?? r3 = 0;
        r3 = 0;
        r3 = 0;
        byte r5 = 0;
        if (r0.startsWith("delete keva") == false) goto L21;
        if (r14.has("key") == true) goto L11;
        if (r14.has("repo") == false) goto L11;
        return new e(r13, r14, new a(r13, r14, d(r13, r14.get("repo").getAsString()), null));
    L11:
        if (r14.has("key") == false) goto L68;
        if (r14.has("repo") == false) goto L68;
        if (r14.has("valueType") == true) goto L17;
    L18:
        String r1 = r14.get("repo").getAsString();
        return new e(r13, r14, new a(r13, r14, d(r13, r1), r14.get("key").getAsString()));
    L17:
        if (r14.has("value") == false) goto L18;
    L68:
        return new f(r13, String.format("SpOpExecutor unsupport cmd %s", new Object[]{r0}));
    L21:
        if (r0.startsWith("set keva") == false) goto L68;
        String r2 = r14.get("repo").getAsString();
        String r11 = r14.get("key").getAsString();
        JsonElement r4 = r14.get("value");
        if (r4 == null) goto L66;
        if (r4.isJsonPrimitive() == false) goto L60;
        String r6 = r14.get("valueType").getAsString();
        r6.getClass();
        switch(r6.hashCode()) {
            case -891985903: goto L46;
            case 104431: goto L42;
            case 3327612: goto L38;
            case 64711720: goto L34;
            case 97526364: goto L30;
            default: goto L47;
        };
    L47:
        r5 = -1;
    L48:
        if (r5 == 0) goto L58;
        if (r5 == 1) goto L57;
        if (r5 == 2) goto L56;
        if (r5 == 3) goto L55;
        if (r5 != 4) goto L66;
        r3 = Float.valueOf(r4.getAsFloat());
        goto L66
    L55:
        r3 = Boolean.valueOf(r4.getAsBoolean());
        goto L66
    L56:
        r3 = Long.valueOf(r4.getAsLong());
        goto L66
    L57:
        r3 = Integer.valueOf(r4.getAsInt());
        goto L66
    L58:
        r3 = r4.getAsString();
        goto L66
    L30:
        if (r6.equals("float") == false) goto L47;
        r5 = 4;
        goto L48
    L34:
        if (r6.equals("boolean") == false) goto L47;
        r5 = 3;
        goto L48
    L38:
        if (r6.equals("long") == false) goto L47;
        r5 = 2;
        goto L48
    L42:
        if (r6.equals("int") == false) goto L47;
        r5 = 1;
        goto L48
    L46:
        if (r6.equals("string") == true) goto L48;
    L60:
        if (r4.isJsonArray() == false) goto L66;
        r3 = new HashSet();
        Iterator r7 = r4.getAsJsonArray().iterator();
    L63:
        if (r7.hasNext() == false) goto L66;
        r3.add(((JsonElement) r7.next()).getAsString());
    L66:
        return new e(r13, r14, new b(r13, r14, d(r13, r2), r11, r3));
    }

    public static ArrayList<String> d(Context r6, String r7) {
        String r8 = new PolarisFileWrapper(r6.getFilesDir(), "keva/repo").getAbsolutePath();
        List<File> r1 = lu8.b.b(r8, false);
        ArrayList<String> r2 = new ArrayList();
        if (r1 != null) goto L20;
    L19:
        return r2;
    L20:
        Iterator r3 = ((ArrayList) r1).iterator();     // Catch: Exception -> L17
    L6:
        if (r3.hasNext() == false) goto L19;
        File r4 = (File) r3.next();     // Catch: Exception -> L17
        if (r4 == null) goto L6;
        if (r4.exists() == false) goto L6;
        if (r4.isDirectory() == false) goto L6;
        String r5 = r4.getAbsolutePath().substring((r4.getAbsolutePath().indexOf(r8) + r8.length()) + 1);     // Catch: Exception -> L17
        nu8.a.a("KevaOpExecutor", "subFilePath is " + r5 + " params is " + r7);     // Catch: Exception -> L17
        if (r5.matches(eu8.a.b(r7)) == false) goto L6;
        nu8.a.h("KevaOpExecutor", "match keva files success: " + r5);     // Catch: Exception -> L17
        r2.add(r5);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        nu8.a.b("KevaOpExecutor", "getMatchedKevas failed: " + e);
        goto L19
    }

    public e(Context r1, JsonElement r2, eu8.a r3) {
        super(r1, r2);
        this.c = r3;
    }
}
