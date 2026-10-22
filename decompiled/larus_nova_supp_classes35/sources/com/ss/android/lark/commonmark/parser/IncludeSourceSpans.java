package com.ss.android.lark.commonmark.parser;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum IncludeSourceSpans extends Enum<IncludeSourceSpans> {
    public static final IncludeSourceSpans BLOCKS = null;
    public static final IncludeSourceSpans BLOCKS_AND_INLINES = null;
    public static final IncludeSourceSpans NONE = null;
    public static final /* synthetic */ IncludeSourceSpans[] a = null;

    static {
        IncludeSourceSpans r0 = new IncludeSourceSpans("NONE", 0);
        NONE = r0;
        IncludeSourceSpans r1 = new IncludeSourceSpans("BLOCKS", 1);
        BLOCKS = r1;
        IncludeSourceSpans r3 = new IncludeSourceSpans("BLOCKS_AND_INLINES", 2);
        BLOCKS_AND_INLINES = r3;
        a = new IncludeSourceSpans[]{r0, r1, r3};
    }

    public static IncludeSourceSpans[] values() {
        return (IncludeSourceSpans[]) a.clone();
    }

    public static IncludeSourceSpans valueOf(String r1) {
        return (IncludeSourceSpans) a.a(IncludeSourceSpans.class, r1);
    }

    public IncludeSourceSpans(String r1, int r2) {
        super(r1, r2);
    }
}
