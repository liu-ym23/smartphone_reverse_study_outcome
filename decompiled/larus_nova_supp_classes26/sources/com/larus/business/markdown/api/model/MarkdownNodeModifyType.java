package com.larus.business.markdown.api.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/api/model/MarkdownNodeModifyType;", "", "TRAILING_WHITESPACE_REMOVED", "TRAILING_PLACEHOLDER_REMOVED", "TRAILING_EMOJI_REMOVED", "LIST_TOKEN_REMOVED", "ASTERISK_TOKEN_REMOVED", "UNDERSCORE_TOKEN_REMOVED", "LATEX_PROCESSING_APPLIED", "markdown-api_release"}, k = 1, mv = {1, 7, 1})
public final enum MarkdownNodeModifyType extends Enum<MarkdownNodeModifyType> {
    public static final MarkdownNodeModifyType ASTERISK_TOKEN_REMOVED = null;
    public static final MarkdownNodeModifyType LATEX_PROCESSING_APPLIED = null;
    public static final MarkdownNodeModifyType LIST_TOKEN_REMOVED = null;
    public static final MarkdownNodeModifyType TRAILING_EMOJI_REMOVED = null;
    public static final MarkdownNodeModifyType TRAILING_PLACEHOLDER_REMOVED = null;
    public static final MarkdownNodeModifyType TRAILING_WHITESPACE_REMOVED = null;
    public static final MarkdownNodeModifyType UNDERSCORE_TOKEN_REMOVED = null;
    public static final /* synthetic */ MarkdownNodeModifyType[] a = null;

    public static MarkdownNodeModifyType valueOf(String r1) {
        return (MarkdownNodeModifyType) a.a(MarkdownNodeModifyType.class, r1);
    }

    public static MarkdownNodeModifyType[] values() {
        return (MarkdownNodeModifyType[]) a.clone();
    }

    static {
        MarkdownNodeModifyType r0 = new MarkdownNodeModifyType("TRAILING_WHITESPACE_REMOVED", 0);
        TRAILING_WHITESPACE_REMOVED = r0;
        MarkdownNodeModifyType r1 = new MarkdownNodeModifyType("TRAILING_PLACEHOLDER_REMOVED", 1);
        TRAILING_PLACEHOLDER_REMOVED = r1;
        MarkdownNodeModifyType r3 = new MarkdownNodeModifyType("TRAILING_EMOJI_REMOVED", 2);
        TRAILING_EMOJI_REMOVED = r3;
        MarkdownNodeModifyType r5 = new MarkdownNodeModifyType("LIST_TOKEN_REMOVED", 3);
        LIST_TOKEN_REMOVED = r5;
        MarkdownNodeModifyType r7 = new MarkdownNodeModifyType("ASTERISK_TOKEN_REMOVED", 4);
        ASTERISK_TOKEN_REMOVED = r7;
        MarkdownNodeModifyType r9 = new MarkdownNodeModifyType("UNDERSCORE_TOKEN_REMOVED", 5);
        UNDERSCORE_TOKEN_REMOVED = r9;
        MarkdownNodeModifyType r11 = new MarkdownNodeModifyType("LATEX_PROCESSING_APPLIED", 6);
        LATEX_PROCESSING_APPLIED = r11;
        a = new MarkdownNodeModifyType[]{r0, r1, r3, r5, r7, r9, r11};
    }

    public MarkdownNodeModifyType(String r1, int r2) {
        super(r1, r2);
    }
}
