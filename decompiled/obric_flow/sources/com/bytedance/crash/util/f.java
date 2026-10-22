package com.bytedance.crash.util;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BufferedWriter f4179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f4180b;

    public f(BufferedWriter r5) {
        this.f4180b = new ArrayList();
        this.f4179a = r5;
    }

    public final void a() {
        ArrayList r5 = this.f4180b;
        if (r5.isEmpty() == true) goto L22;
        JSONWriter$Scope r10 = (JSONWriter$Scope) androidx.constraintlayout.motion.widget.a.h(r5, 1);
        if (r10 != JSONWriter$Scope.f4164a) goto L9;
        JSONWriter$Scope r11 = JSONWriter$Scope.f4165b;
        r5.set(r5.size() - 1, r11);
        return;
    L9:
        JSONWriter$Scope r12 = JSONWriter$Scope.f4165b;
        BufferedWriter r13 = this.f4179a;
        if (r10 != r12) goto L14;
        r13.write(44);
        return;
    L14:
        if (r10 != JSONWriter$Scope.d) goto L18;
        r13.write(":");
        JSONWriter$Scope r14 = JSONWriter$Scope.e;
        r5.set(r5.size() - 1, r14);
        return;
    L18:
        if (r10 != JSONWriter$Scope.f) goto L21;
        return;
    L21:
        throw new JSONException("Nesting problem");
    }

    public final void b(Object r5) {
        if ((r5 instanceof JSONArray) == false) goto L7;
        d((JSONArray) r5);
        return;
    L7:
        if ((r5 instanceof JSONObject) == false) goto L10;
        e((JSONObject) r5);
        return;
    L10:
        a();
        BufferedWriter r10 = this.f4179a;
        if (r5 != null) goto L13;
    L25:
        r10.write("null");
        return;
    L13:
        if (r5 == JSONObject.NULL) goto L25;
        if ((r5 instanceof Boolean) == false) goto L20;
        r10.write(String.valueOf(r5));
        return;
    L20:
        if ((r5 instanceof Number) == false) goto L23;
        r10.write(JSONObject.numberToString((Number) r5));
        return;
    L23:
        c(r5.toString());
    }

    public final void c(String r10) {
        BufferedWriter r11 = this.f4179a;
        r11.write("\"");
        int r5 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L25;
        char r13 = r10.charAt(r12);
        if (r13 != '\f') goto L7;
        r11.write("\\f");
    L24:
        r12 = r12 + 1;
        goto L3
    L7:
        if (r13 != '\r') goto L9;
        r11.write("\\r");
        goto L24
    L9:
        if (r13 != '\"') goto L11;
    L21:
        r11.write(92);
        r11.write(r13);
        goto L24
    L11:
        if (r13 == '/') goto L21;
        if (r13 == '\\') goto L21;
        switch(r13) {
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L15;
        };
    L18:
        r11.write("\\n");
        goto L24
    L19:
        r11.write("\\t");
        goto L24
    L20:
        r11.write("\\b");
        goto L24
    L15:
        if (r13 > 31) goto L17;
        r11.write(String.format("\\u%04x", new Object[]{Integer.valueOf(r13)}));
        goto L24
    L17:
        r11.write(r13);
        goto L24
    L25:
        r11.write("\"");
    }

    public final void d(JSONArray r5) {
        JSONWriter$Scope r10 = JSONWriter$Scope.f4164a;
        a();
        ArrayList r11 = this.f4180b;
        r11.add(r10);
        BufferedWriter r12 = this.f4179a;
        r12.write("[");
        int r13 = 0;
    L4:
        if (r13 >= r5.length()) goto L6;
        b(r5.get(r13));
        r13 = r13 + 1;
        goto L4
    L6:
        JSONWriter$Scope r14 = (JSONWriter$Scope) androidx.constraintlayout.motion.widget.a.h(r11, 1);
        r11.remove(r11.size() - 1);
        r12.write("]");
    }

    public final void e(JSONObject r10) {
        JSONWriter$Scope r5 = JSONWriter$Scope.f4166c;
        a();
        ArrayList r11 = this.f4180b;
        r11.add(r5);
        BufferedWriter r12 = this.f4179a;
        r12.write("{");
        Iterator<String> r13 = r10.keys();
    L4:
        if (r13.hasNext() == false) goto L13;
        String r14 = r13.next();
        Object r15 = r10.get(r14);
        JSONWriter$Scope r16 = (JSONWriter$Scope) androidx.constraintlayout.motion.widget.a.h(r11, 1);
        if (r16 != JSONWriter$Scope.e) goto L9;
        r12.write(44);
    L10:
        JSONWriter$Scope r17 = JSONWriter$Scope.d;
        r11.set(r11.size() - 1, r17);
        c(r14);
        b(r15);
        goto L4
    L9:
        if (r16 == JSONWriter$Scope.f4166c) goto L10;
        throw new JSONException("Nesting problem");
    L13:
        JSONWriter$Scope r18 = (JSONWriter$Scope) androidx.constraintlayout.motion.widget.a.h(r11, 1);
        r11.remove(r11.size() - 1);
        r12.write("}");
    }

    public final String toString() {
        return "";
    }
}
