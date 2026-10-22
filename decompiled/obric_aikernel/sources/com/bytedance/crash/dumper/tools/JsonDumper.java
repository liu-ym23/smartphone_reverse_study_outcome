package com.bytedance.crash.dumper.tools;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class JsonDumper extends StringDumper {
    public JsonDumper(String r10) {
        super(r10);
    }

    public JsonDumper arrayBegin() {
        append('[');
        return this;
    }

    public JsonDumper arrayEnd() {
        append(']');
        return this;
    }

    public JsonDumper key(String r10) {
        append(Typography.quote).append(r10).append(Typography.quote).append(':').append(' ');
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

    public JsonDumper value(char r10) {
        append(r10);
        return this;
    }

    public JsonDumper value(int r10) {
        append(r10);
        return this;
    }

    public JsonDumper value(long r10) {
        append(r10);
        return this;
    }

    public JsonDumper value(String r10) {
        append(Typography.quote);
        if (r10 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L33;
        char r13 = r10.charAt(r12);
        if (r13 != '\f') goto L11;
        String r14 = "\\f";
    L26:
        append(r14);
    L32:
        r12 = r12 + 1;
        goto L7
    L11:
        if (r13 != '\r') goto L13;
        r14 = "\\r";
        goto L26
    L13:
        if (r13 == '\"') goto L28;
        if (r13 == '\\') goto L28;
        if (r13 != 8232) goto L18;
    L27:
        r14 = String.format("\\u%04x", new Object[]{Integer.valueOf(r13)});
        goto L26
    L18:
        if (r13 == 8233) goto L27;
        switch(r13) {
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            default: goto L21;
        };
    L23:
        r14 = "\\n";
        goto L26
    L24:
        r14 = "\\t";
        goto L26
    L25:
        r14 = "\\b";
        goto L26
    L21:
        if (r13 > 31) goto L29;
        r14 = String.format("\\u%04x", new Object[]{Integer.valueOf(r13)});
    L29:
        append(r13);
    L28:
        append('\\');
        goto L29
    L33:
        append(Typography.quote);
        return this;
    L5:
        r11 = r10.length();
        goto L6
    }

    public JsonDumper value(boolean r10) {
        append(r10);
        return this;
    }
}
