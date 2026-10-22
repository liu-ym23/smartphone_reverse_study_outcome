package com.ss.android.lark.provider.spprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import g5c.a;
import java.util.Iterator;
import java.util.Map;
import y1c.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class SPContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    public SPContentProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r7) {
        String[] r8 = r7.getPath().split("/");
        String r0 = r8[1];
        String r9 = r8[2];
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
        if (r0.equals("contain") == false) goto L10;
        StringBuilder r1 = new StringBuilder();
        a r5 = c.a();
        if (r5 == null) goto L8;
        r3 = r5.contains(r9);
    L8:
        r1.append(r3);
        r1.append("");
        return r1.toString();
    L10:
        StringBuilder r6 = new StringBuilder("");
        a r10 = c.a();
        if (r10 != null) goto L13;
        boolean r11 = false;
    L14:
        Object r12 = null;
        if (r11 == true) goto L18;
    L58:
        r6.append(r12 + "");
        return r6.toString();
    L18:
        if (r0.equalsIgnoreCase("string") == false) goto L25;
        a r13 = c.a();
        if (r13 == null) goto L58;
        String r14 = r13.getString(r9, null);
    L23:
        r12 = r14;
        goto L58
    L25:
        if (r0.equalsIgnoreCase("boolean") == false) goto L32;
        a r15 = c.a();
        if (r15 == null) goto L30;
        r4 = r15.getBoolean(r9, false);
    L30:
        r12 = Boolean.valueOf(r4);
        goto L58
    L32:
        if (r0.equalsIgnoreCase("int") == false) goto L39;
        a r16 = c.a();
        if (r16 == null) goto L37;
        r2 = r16.getInt(r9);
    L37:
        r12 = Integer.valueOf(r2);
        goto L58
    L39:
        if (r0.equalsIgnoreCase("long") == false) goto L46;
        a r17 = c.a();
        if (r17 != null) goto L43;
        long r18 = 0;
    L44:
        r12 = Long.valueOf(r18);
        goto L58
    L43:
        r18 = r17.getLong(r9);
        goto L44
    L46:
        if (r0.equalsIgnoreCase("float") == false) goto L53;
        a r19 = c.a();
        float r20 = 0.0f;
        if (r19 == null) goto L51;
        r20 = r19.getFloat(r9, 0.0f);
    L51:
        r12 = Float.valueOf(r20);
        goto L58
    L53:
        if (r0.equalsIgnoreCase("string_set") == false) goto L58;
        a r21 = c.a();
        if (r21 == null) goto L58;
        r14 = r21.getString(r9, null);
        goto L23
    L13:
        r11 = r10.contains(r9);
        goto L14
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r10, ContentValues r11) {
        String[] r12 = r10.getPath().split("/");
        String r1 = r12[1];
        String r13 = r12[2];
        Object r14 = r11.get("value");
        monitor-enter(c.class);
        a r4 = c.a();     // Catch: Throwable -> L62
        if (r4 != null) goto L9;
        monitor-exit(c.class);
    L61:
        return null;
    L9:
        if (r1 != null) goto L14;
        c.b(r13, r1, r14);     // Catch: Throwable -> L62
        monitor-exit(c.class);
        goto L61
    L14:
        switch(r1.hashCode()) {
            case -891985903: goto L29;
            case 104431: goto L26;
            case 3327612: goto L23;
            case 64711720: goto L20;
            case 97526364: goto L17;
            default: goto L31;
        };     // Catch: Throwable -> L62
    L31:
        byte r6 = -1;
    L32:
        if (r6 == 0) goto L57;
        if (r6 == 1) goto L50;
        if (r6 == 2) goto L47;
        if (r6 == 3) goto L43;
        if (r6 == 4) goto L39;
    L60:
        monitor-exit(c.class);
        goto L61
    L39:
        if ((r14 instanceof Float) == false) goto L41;
        r4.putFloat(r13, ((Float) r14).floatValue());     // Catch: Throwable -> L62
        goto L60
    L41:
        c.b(r13, r1, r14);     // Catch: Throwable -> L62
        goto L60
    L43:
        if ((r14 instanceof Long) == false) goto L45;
        r4.putLong(r13, ((Long) r14).longValue());     // Catch: Throwable -> L62
        goto L60
    L45:
        c.b(r13, r1, r14);     // Catch: Throwable -> L62
        goto L60
    L47:
        if ((r14 instanceof Integer) == false) goto L49;
        r4.putInt(r13, ((Integer) r14).intValue());     // Catch: Throwable -> L62
        goto L60
    L49:
        c.b(r13, r1, r14);     // Catch: Throwable -> L62
        goto L60
    L50:
        if (r14 != null) goto L53;
        r4.putString(r13, null);     // Catch: Throwable -> L62
        goto L60
    L53:
        if ((r14 instanceof String) == false) goto L55;
        r4.putString(r13, (String) r14);     // Catch: Throwable -> L62
        goto L60
    L55:
        c.b(r13, r1, r14);     // Catch: Throwable -> L62
        goto L60
    L57:
        if ((r14 instanceof Boolean) == false) goto L59;
        r4.putBoolean(r13, ((Boolean) r14).booleanValue());     // Catch: Throwable -> L62
        goto L60
    L59:
        c.b(r13, r1, r14);     // Catch: Throwable -> L62
        goto L60
    L17:
        if (r1.equals("float") == false) goto L31;
        r6 = 4;
        goto L32
    L20:
        if (r1.equals("boolean") == false) goto L31;
        r6 = 0;
        goto L32
    L23:
        if (r1.equals("long") == false) goto L31;
        r6 = 3;
        goto L32
    L26:
        if (r1.equals("int") == false) goto L31;
        r6 = 2;
        goto L32
    L29:
        if (r1.equals("string") == false) goto L31;
        r6 = 1;
    L62:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        String[] r4 = r1.getPath().split("/");
        if (r4[1].equals("clean") == false) goto L6;
        c.a().cleanSharedPreference();
        return 0;
    L6:
        String r5 = r4[2];
        a r6 = c.a();
        if (r6 != null) goto L9;
        boolean r7 = false;
    L10:
        if (r7 == false) goto L15;
        a r8 = c.a();
        if (r8 == null) goto L15;
        r8.remove(r5);
    L15:
        return 0;
    L9:
        r7 = r6.contains(r5);
        goto L10
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        insert(r1, r2);
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r3, String[] r4, String r5, String[] r6, String r7) {
        if (r3.getPath().split("/")[1].equals("get_all") == false) goto L26;
        Map r8 = c.a().getAll();
        if (r8 == null) goto L35;
        MatrixCursor r9 = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        Iterator r10 = r8.keySet().iterator();
    L8:
        if (r10.hasNext() == false) goto L25;
        String r11 = (String) r10.next();
        Object[] r0 = new Object[3];
        r0[0] = r11;
        Object r12 = r8.get(r11);
        r0[2] = r12;
        if ((r12 instanceof Boolean) == false) goto L13;
        r0[1] = "boolean";
    L24:
        r9.addRow(r0);
        goto L8
    L13:
        if ((r12 instanceof String) == false) goto L16;
        r0[1] = "string";
        goto L24
    L16:
        if ((r12 instanceof Integer) == false) goto L19;
        r0[1] = "int";
        goto L24
    L19:
        if ((r12 instanceof Long) == false) goto L22;
        r0[1] = "long";
        goto L24
    L22:
        if ((r12 instanceof Float) == false) goto L24;
        r0[1] = "float";
        goto L24
    L25:
        return r9;
    L35:
        return null;
    L26:
        return null;
    }
}
