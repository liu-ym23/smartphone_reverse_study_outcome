package com.bytedance.crash.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
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
            Scope r0 = new Scope("EMPTY_ARRAY", 0);
            EMPTY_ARRAY = r0;
            Scope r1 = new Scope("NONEMPTY_ARRAY", 1);
            NONEMPTY_ARRAY = r1;
            Scope r3 = new Scope("EMPTY_OBJECT", 2);
            EMPTY_OBJECT = r3;
            Scope r5 = new Scope("DANGLING_KEY", 3);
            DANGLING_KEY = r5;
            Scope r7 = new Scope("NONEMPTY_OBJECT", 4);
            NONEMPTY_OBJECT = r7;
            Scope r9 = new Scope("NULL", 5);
            NULL = r9;
            $VALUES = new Scope[]{r0, r1, r3, r5, r7, r9};
        }

        private Scope(String r1, int r2) {
            super(r1, r2);
        }

        public static Scope valueOf(String r2) {
            return (Scope) ZeusTransformUtils.preCheckCast(Enum.valueOf(Scope.class, r2), Scope.class, "com.obric.memorydata.plugin");
        }

        public static Scope[] values() {
            return (Scope[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Scope[].class, "com.obric.memorydata.plugin");
        }
    }

    private JSONWriter(Writer r2) {
        this.stack = new ArrayList();
        this.out = r2;
    }

    private JSONWriter array() {
        return open(Scope.EMPTY_ARRAY, "[");
    }

    private void arrayWriteTo(JSONArray r3) {
        array();
        int r0 = 0;
    L4:
        if (r0 >= r3.length()) goto L6;
        value(r3.get(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        endArray();
    }

    private void beforeKey() {
        Scope r0 = peek();
        if (r0 != Scope.NONEMPTY_OBJECT) goto L6;
        this.out.write(44);
    L7:
        replaceTop(Scope.DANGLING_KEY);
        return;
    L6:
        if (r0 == Scope.EMPTY_OBJECT) goto L7;
        throw new JSONException("Nesting problem");
    }

    private void beforeValue() {
        if (this.stack.isEmpty() == false) goto L5;
        return;
    L5:
        Scope r0 = peek();
        if (r0 != Scope.EMPTY_ARRAY) goto L10;
        Scope r1 = Scope.NONEMPTY_ARRAY;
    L8:
        replaceTop(r1);
        return;
    L10:
        if (r0 != Scope.NONEMPTY_ARRAY) goto L13;
        this.out.write(44);
        return;
    L13:
        if (r0 != Scope.DANGLING_KEY) goto L16;
        this.out.write(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r1 = Scope.NONEMPTY_OBJECT;
        goto L8
    L16:
        if (r0 != Scope.NULL) goto L19;
        return;
    L19:
        throw new JSONException("Nesting problem");
    }

    private JSONWriter close(Scope r1, Scope r2, String r3) {
        peek();
        List<Scope> r4 = this.stack;
        r4.remove(r4.size() - 1);
        this.out.write(r3);
        return this;
    }

    private JSONWriter endArray() {
        return close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, "]");
    }

    private JSONWriter endObject() {
        return close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}");
    }

    private void jsonWriteTo(JSONObject r5) {
        object();
        Iterator<String> r0 = r5.keys();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        Object r2 = r5.get(r1);
        key(r1).value(r2);
        goto L4
    L6:
        endObject();
    }

    private JSONWriter key(String r1) {
        beforeKey();
        string(r1);
        return this;
    }

    private JSONWriter object() {
        return open(Scope.EMPTY_OBJECT, "{");
    }

    private JSONWriter open(Scope r2, String r3) {
        beforeValue();
        this.stack.add(r2);
        this.out.write(r3);
        return this;
    }

    private Scope peek() {
        List<Scope> r2 = this.stack;
        return (Scope) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), Scope.class, "com.obric.memorydata.plugin");
    }

    private void replaceTop(Scope r2) {
        List<Scope> r1 = this.stack;
        r1.set(r1.size() - 1, r2);
    }

    private void string(String r8) {
        this.out.write("\"");
        int r0 = r8.length();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L26;
        char r4 = r8.charAt(r3);
        if (r4 != '\f') goto L7;
        Writer r5 = this.out;
        String r6 = "\\f";
    L20:
        r5.write(r6);
    L25:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 != '\r') goto L9;
        r5 = this.out;
        r6 = "\\r";
        goto L20
    L9:
        if (r4 != '\"') goto L11;
    L21:
        this.out.write(92);
    L22:
        this.out.write(r4);
        goto L25
    L11:
        if (r4 == '/') goto L21;
        if (r4 == '\\') goto L21;
        switch(r4) {
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L15;
        };
    L17:
        r5 = this.out;
        r6 = "\\n";
        goto L20
    L18:
        r5 = this.out;
        r6 = "\\t";
        goto L20
    L19:
        r5 = this.out;
        r6 = "\\b";
        goto L20
    L15:
        if (r4 > 31) goto L22;
        this.out.write(String.format("\\u%04x", new Object[]{Integer.valueOf(r4)}));
        goto L25
    L26:
        this.out.write("\"");
    }

    private JSONWriter value(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, JSONArray.class) == false) goto L7;
        arrayWriteTo((JSONArray) ZeusTransformUtils.preCheckCast(r4, JSONArray.class, "com.obric.memorydata.plugin"));
        return this;
    L7:
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L10;
        jsonWriteTo((JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin"));
        return this;
    L10:
        beforeValue();
        if (r4 != null) goto L13;
    L23:
        this.out.write("null");
    L24:
        return this;
    L13:
        if (r4 == JSONObject.NULL) goto L23;
        if (ZeusTransformUtils.instanceOf(r4, Boolean.class) == false) goto L20;
        Writer r0 = this.out;
        String r5 = String.valueOf(r4);
    L18:
        r0.write(r5);
        goto L24
    L20:
        if (ZeusTransformUtils.instanceOf(r4, Number.class) == false) goto L22;
        r0 = this.out;
        r5 = JSONObject.numberToString((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin"));
        goto L18
    L22:
        string(r4.toString());
        goto L24
    }

    public static void writeTo(JSONArray r1, Writer r2) {
        new JSONWriter(r2).arrayWriteTo(r1);
        r2.flush();
    }

    public static void writeTo(JSONObject r1, Writer r2) {
        new JSONWriter(r2).jsonWriteTo(r1);
        r2.flush();
    }

    public String toString() {
        return "";
    }

    public JSONWriter value(double r2) {
        beforeValue();
        this.out.write(JSONObject.numberToString(Double.valueOf(r2)));
        return this;
    }

    public JSONWriter value(long r2) {
        beforeValue();
        this.out.write(String.valueOf(r2));
        return this;
    }

    public JSONWriter value(boolean r2) {
        beforeValue();
        this.out.write(String.valueOf(r2));
        return this;
    }
}
