package com.bytedance.crash.dumper.tools;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class JsonDumper extends StringDumper {
    public JsonDumper(String r1) {
        super(r1);
    }

    public JsonDumper arrayBegin() {
        append('[');
        return this;
    }

    public JsonDumper arrayEnd() {
        append(']');
        return this;
    }

    public JsonDumper key(String r3) {
        append(Typography.quote).append(r3).append(Typography.quote).append(':').append(' ');
        return this;
    }

    public JsonDumper next() {
        append(',');
        return this;
    }

    public JsonDumper objectBegin() {
        append('{');
        return this;
    }

    public JsonDumper objectEnd() {
        append('}');
        return this;
    }

    public JsonDumper value(char r1) {
        append(r1);
        return this;
    }

    public JsonDumper value(int r1) {
        append(r1);
        return this;
    }

    public JsonDumper value(long r1) {
        append(r1);
        return this;
    }

    public JsonDumper value(String r9) {
        append(Typography.quote);
        if (r9 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L33;
        char r4 = r9.charAt(r3);
        if (r4 != '\f') goto L11;
        String r5 = "\\f";
    L26:
        append(r5);
    L32:
        r3 = r3 + 1;
        goto L7
    L11:
        if (r4 != '\r') goto L13;
        r5 = "\\r";
        goto L26
    L13:
        if (r4 == '\"') goto L28;
        if (r4 == '\\') goto L28;
        if (r4 != 8232) goto L18;
    L27:
        r5 = String.format("\\u%04x", new Object[]{Integer.valueOf(r4)});
        goto L26
    L18:
        if (r4 == 8233) goto L27;
        switch(r4) {
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            default: goto L21;
        };
    L23:
        r5 = "\\n";
        goto L26
    L24:
        r5 = "\\t";
        goto L26
    L25:
        r5 = "\\b";
        goto L26
    L21:
        if (r4 > 31) goto L29;
        r5 = String.format("\\u%04x", new Object[]{Integer.valueOf(r4)});
    L29:
        append(r4);
    L28:
        append('\\');
        goto L29
    L33:
        append(Typography.quote);
        return this;
    L5:
        r2 = r9.length();
        goto L6
    }

    public JsonDumper value(boolean r1) {
        append(r1);
        return this;
    }
}
