package com.google.gson;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class FormattingStyle {
    public static final FormattingStyle COMPACT = null;
    public static final FormattingStyle PRETTY = null;
    private final String indent;
    private final String newline;
    private final boolean spaceAfterSeparators;

    static {
        COMPACT = new FormattingStyle("", "", false);
        PRETTY = new FormattingStyle("\n", "  ", true);
    }

    private FormattingStyle(String r5, String r10, boolean r11) {
        Objects.requireNonNull(r5, "newline == null");
        Objects.requireNonNull(r10, "indent == null");
        if (r5.matches("[\r\n]*") == false) goto L11;
        if (r10.matches("[ \t]*") == false) goto L9;
        this.newline = r5;
        this.indent = r10;
        this.spaceAfterSeparators = r11;
        return;
    L9:
        throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
    L11:
        throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
    }

    public String getIndent() {
        return this.indent;
    }

    public String getNewline() {
        return this.newline;
    }

    public boolean usesSpaceAfterSeparators() {
        return this.spaceAfterSeparators;
    }

    public FormattingStyle withIndent(String r5) {
        return new FormattingStyle(this.newline, r5, this.spaceAfterSeparators);
    }

    public FormattingStyle withNewline(String r5) {
        return new FormattingStyle(r5, this.indent, this.spaceAfterSeparators);
    }

    public FormattingStyle withSpaceAfterSeparators(boolean r5) {
        return new FormattingStyle(this.newline, this.indent, r5);
    }
}
