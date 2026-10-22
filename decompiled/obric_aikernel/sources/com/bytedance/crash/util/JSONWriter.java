package com.bytedance.crash.util;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class JSONWriter {
    private final Writer out;
    private final List<Scope> stack;

    static final enum Scope extends Enum<Scope> {
        private static final /* synthetic */ Scope[] $VALUES = null;
        public static final Scope DANGLING_KEY = null;
        public static final Scope EMPTY_ARRAY = null;
        public static final Scope EMPTY_OBJECT = null;
        public static final Scope NONEMPTY_ARRAY = null;
        public static final Scope NONEMPTY_OBJECT = null;
        public static final Scope NULL = null;

        static {
            Scope r10 = new Scope("EMPTY_ARRAY", 0);
            EMPTY_ARRAY = r10;
            Scope r11 = new Scope("NONEMPTY_ARRAY", 1);
            NONEMPTY_ARRAY = r11;
            Scope r12 = new Scope("EMPTY_OBJECT", 2);
            EMPTY_OBJECT = r12;
            Scope r13 = new Scope("DANGLING_KEY", 3);
            DANGLING_KEY = r13;
            Scope r14 = new Scope("NONEMPTY_OBJECT", 4);
            NONEMPTY_OBJECT = r14;
            Scope r15 = new Scope("NULL", 5);
            NULL = r15;
            $VALUES = new Scope[]{r10, r11, r12, r13, r14, r15};
        }

        private Scope(String r10, int r11) {
            super(r10, r11);
        }

        public static Scope valueOf(String r10) {
            return (Scope) Enum.valueOf(Scope.class, r10);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }
    }

    private JSONWriter(Writer r10) {
        this.stack = new ArrayList();
        this.out = r10;
    }

    private JSONWriter array() {
        return open(Scope.EMPTY_ARRAY, "[");
    }

    private void arrayWriteTo(JSONArray r10) {
        array();
        int r11 = 0;
    L4:
        if (r11 >= r10.length()) goto L6;
        value(r10.get(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        endArray();
    }

    private void beforeKey() {
        Scope r10 = peek();
        if (r10 != Scope.NONEMPTY_OBJECT) goto L6;
        this.out.write(44);
    L7:
        replaceTop(Scope.DANGLING_KEY);
        return;
    L6:
        if (r10 == Scope.EMPTY_OBJECT) goto L7;
        throw new JSONException("Nesting problem");
    }

    private void beforeValue() {
        if (this.stack.isEmpty() == false) goto L5;
        return;
    L5:
        Scope r10 = peek();
        if (r10 != Scope.EMPTY_ARRAY) goto L10;
        Scope r11 = Scope.NONEMPTY_ARRAY;
    L8:
        replaceTop(r11);
        return;
    L10:
        if (r10 != Scope.NONEMPTY_ARRAY) goto L13;
        this.out.write(44);
        return;
    L13:
        if (r10 != Scope.DANGLING_KEY) goto L16;
        this.out.write(":");
        r11 = Scope.NONEMPTY_OBJECT;
        goto L8
    L16:
        if (r10 != Scope.NULL) goto L19;
        return;
    L19:
        throw new JSONException("Nesting problem");
    }

    private JSONWriter close(Scope r10, Scope r11, String r12) {
        peek();
        List<Scope> r13 = this.stack;
        r13.remove(r13.size() - 1);
        this.out.write(r12);
        return this;
    }

    private JSONWriter endArray() {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    private JSONWriter endObject() {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    private void jsonWriteTo(JSONObject r10) {
        object();
        Iterator<String> r11 = r10.keys();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = r11.next();
        Object r13 = r10.get(r12);
        key(r12).value(r13);
        goto L4
    L6:
        endObject();
    }

    private JSONWriter key(String r10) {
        beforeKey();
        string(r10);
        return this;
    }

    private JSONWriter object() {
        return open(Scope.EMPTY_OBJECT, "{");
    }

    private JSONWriter open(Scope r10, String r11) {
        beforeValue();
        this.stack.add(r10);
        this.out.write(r11);
        return this;
    }

    private Scope peek() {
        List<Scope> r10 = this.stack;
        return r10.get(r10.size() - 1);
    }

    private void replaceTop(Scope r10) {
        List<Scope> r11 = this.stack;
        r11.set(r11.size() - 1, r10);
    }

    private void string(String r10) {
        this.out.write("\"");
        int r11 = r10.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L26;
        char r13 = r10.charAt(r12);
        if (r13 != '\f') goto L7;
        Writer r14 = this.out;
        String r15 = "\\f";
    L20:
        r14.write(r15);
    L25:
        r12 = r12 + 1;
        goto L3
    L7:
        if (r13 != '\r') goto L9;
        r14 = this.out;
        r15 = "\\r";
        goto L20
    L9:
        if (r13 != '\"') goto L11;
    L21:
        this.out.write(92);
    L22:
        this.out.write(r13);
        goto L25
    L11:
        if (r13 == '/') goto L21;
        if (r13 == '\\') goto L21;
        switch(r13) {
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L15;
        };
    L17:
        r14 = this.out;
        r15 = "\\n";
        goto L20
    L18:
        r14 = this.out;
        r15 = "\\t";
        goto L20
    L19:
        r14 = this.out;
        r15 = "\\b";
        goto L20
    L15:
        if (r13 > 31) goto L22;
        this.out.write(String.format("\\u%04x", new Object[]{Integer.valueOf(r13)}));
        goto L25
    L26:
        this.out.write("\"");
    }

    private JSONWriter value(Object r10) {
        if ((r10 instanceof JSONArray) == false) goto L7;
        arrayWriteTo((JSONArray) r10);
        return this;
    L7:
        if ((r10 instanceof JSONObject) == false) goto L10;
        jsonWriteTo((JSONObject) r10);
        return this;
    L10:
        beforeValue();
        if (r10 != null) goto L13;
    L23:
        this.out.write("null");
    L24:
        return this;
    L13:
        if (r10 == JSONObject.NULL) goto L23;
        if ((r10 instanceof Boolean) == false) goto L20;
        Writer r11 = this.out;
        String r12 = String.valueOf(r10);
    L18:
        r11.write(r12);
        goto L24
    L20:
        if ((r10 instanceof Number) == false) goto L22;
        r11 = this.out;
        r12 = JSONObject.numberToString((Number) r10);
        goto L18
    L22:
        string(r10.toString());
        goto L24
    }

    public static void writeTo(JSONArray r10, Writer r11) {
        new JSONWriter(r11).arrayWriteTo(r10);
        r11.flush();
    }

    public static void writeTo(JSONObject r10, Writer r11) {
        new JSONWriter(r11).jsonWriteTo(r10);
        r11.flush();
    }

    public String toString() {
        return "";
    }

    public JSONWriter value(double r10) {
        beforeValue();
        this.out.write(JSONObject.numberToString(Double.valueOf(r10)));
        return this;
    }

    public JSONWriter value(long r10) {
        beforeValue();
        this.out.write(String.valueOf(r10));
        return this;
    }

    public JSONWriter value(boolean r10) {
        beforeValue();
        this.out.write(String.valueOf(r10));
        return this;
    }
}
