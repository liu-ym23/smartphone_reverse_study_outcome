package com.tom_roush.pdfbox.pdmodel.interactive.annotation.layout;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PlainTextFormatter {

    static final enum TextAlign extends Enum<TextAlign> {
        private static final /* synthetic */ TextAlign[] $VALUES = null;
        public static final TextAlign CENTER = null;
        public static final TextAlign JUSTIFY = null;
        public static final TextAlign LEFT = null;
        public static final TextAlign RIGHT = null;
        private final int alignment;

        static {
            TextAlign r0 = new TextAlign("LEFT", 0, 0);
            LEFT = r0;
            TextAlign r1 = new TextAlign("CENTER", 1, 1);
            CENTER = r1;
            TextAlign r3 = new TextAlign("RIGHT", 2, 2);
            RIGHT = r3;
            TextAlign r5 = new TextAlign("JUSTIFY", 3, 4);
            JUSTIFY = r5;
            $VALUES = new TextAlign[]{r0, r1, r3, r5};
        }

        private TextAlign(String r1, int r2, int r3) {
            super(r1, r2);
            this.alignment = r3;
        }

        public static TextAlign valueOf(int r5) {
            TextAlign[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            TextAlign r3 = r0[r2];
            if (r3.getTextAlign() == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            return LEFT;
        }

        public static TextAlign valueOf(String r2) {
            return (TextAlign) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextAlign.class, r2), TextAlign.class, "com.obric.memorydata.plugin");
        }

        public static TextAlign[] values() {
            return (TextAlign[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextAlign[].class, "com.obric.memorydata.plugin");
        }

        int getTextAlign() {
            return this.alignment;
        }
    }
}
