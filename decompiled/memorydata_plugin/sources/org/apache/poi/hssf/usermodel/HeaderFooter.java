package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HeaderFooter {

    private static final enum MarkupTag extends Enum<MarkupTag> {
        private static final /* synthetic */ MarkupTag[] $VALUES = null;
        public static final MarkupTag BOLD_FIELD = null;
        public static final MarkupTag DATE_FIELD = null;
        public static final MarkupTag DOUBLE_UNDERLINE_FIELD = null;
        public static final MarkupTag FILE_FIELD = null;
        public static final MarkupTag FULL_FILE_FIELD = null;
        public static final MarkupTag ITALIC_FIELD = null;
        public static final MarkupTag NUM_PAGES_FIELD = null;
        public static final MarkupTag PAGE_FIELD = null;
        public static final MarkupTag PICTURE_FIELD = null;
        public static final MarkupTag SHEET_NAME_FIELD = null;
        public static final MarkupTag STRIKETHROUGH_FIELD = null;
        public static final MarkupTag SUBSCRIPT_FIELD = null;
        public static final MarkupTag SUPERSCRIPT_FIELD = null;
        public static final MarkupTag TIME_FIELD = null;
        public static final MarkupTag UNDERLINE_FIELD = null;
        private final boolean _occursInPairs;
        private final String _representation;

        static {
            MarkupTag r0 = new MarkupTag("SHEET_NAME_FIELD", 0, "&A", false);
            SHEET_NAME_FIELD = r0;
            MarkupTag r1 = new MarkupTag("DATE_FIELD", 1, "&D", false);
            DATE_FIELD = r1;
            MarkupTag r3 = new MarkupTag("FILE_FIELD", 2, "&F", false);
            FILE_FIELD = r3;
            MarkupTag r5 = new MarkupTag("FULL_FILE_FIELD", 3, "&Z", false);
            FULL_FILE_FIELD = r5;
            MarkupTag r7 = new MarkupTag("PAGE_FIELD", 4, "&P", false);
            PAGE_FIELD = r7;
            MarkupTag r9 = new MarkupTag("TIME_FIELD", 5, "&T", false);
            TIME_FIELD = r9;
            MarkupTag r11 = new MarkupTag("NUM_PAGES_FIELD", 6, "&N", false);
            NUM_PAGES_FIELD = r11;
            MarkupTag r13 = new MarkupTag("PICTURE_FIELD", 7, "&G", false);
            PICTURE_FIELD = r13;
            MarkupTag r12 = new MarkupTag("BOLD_FIELD", 8, "&B", true);
            BOLD_FIELD = r12;
            MarkupTag r10 = new MarkupTag("ITALIC_FIELD", 9, "&I", true);
            ITALIC_FIELD = r10;
            MarkupTag r8 = new MarkupTag("STRIKETHROUGH_FIELD", 10, "&S", true);
            STRIKETHROUGH_FIELD = r8;
            MarkupTag r6 = new MarkupTag("SUBSCRIPT_FIELD", 11, "&Y", true);
            SUBSCRIPT_FIELD = r6;
            MarkupTag r2 = new MarkupTag("SUPERSCRIPT_FIELD", 12, "&X", true);
            SUPERSCRIPT_FIELD = r2;
            MarkupTag r14 = new MarkupTag("UNDERLINE_FIELD", 13, "&U", true);
            UNDERLINE_FIELD = r14;
            MarkupTag r4 = new MarkupTag("DOUBLE_UNDERLINE_FIELD", 14, "&E", true);
            DOUBLE_UNDERLINE_FIELD = r4;
            $VALUES = new MarkupTag[]{r0, r1, r3, r5, r7, r9, r11, r13, r12, r10, r8, r6, r2, r14, r4};
        }

        private MarkupTag(String r1, int r2, String r3, boolean r4) {
            super(r1, r2);
            this._representation = r3;
            this._occursInPairs = r4;
        }

        public static MarkupTag valueOf(String r2) {
            return (MarkupTag) ZeusTransformUtils.preCheckCast(Enum.valueOf(MarkupTag.class, r2), MarkupTag.class, "com.obric.memorydata.plugin");
        }

        public static MarkupTag[] values() {
            return (MarkupTag[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MarkupTag[].class, "com.obric.memorydata.plugin");
        }

        public String getRepresentation() {
            return this._representation;
        }

        public boolean occursPairs() {
            return this._occursInPairs;
        }
    }
}
