package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: classes7.dex */
public interface TextShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Iterable<P>, SimpleShape<S, P> {

    public static final enum TextAutofit extends Enum<TextAutofit> {
        private static final /* synthetic */ TextAutofit[] $VALUES = null;
        public static final TextAutofit NONE = null;
        public static final TextAutofit NORMAL = null;
        public static final TextAutofit SHAPE = null;

        static {
            TextAutofit r0 = new TextAutofit("NONE", 0);
            NONE = r0;
            TextAutofit r1 = new TextAutofit("NORMAL", 1);
            NORMAL = r1;
            TextAutofit r3 = new TextAutofit("SHAPE", 2);
            SHAPE = r3;
            $VALUES = new TextAutofit[]{r0, r1, r3};
        }

        private TextAutofit(String r1, int r2) {
            super(r1, r2);
        }

        public static TextAutofit valueOf(String r2) {
            return (TextAutofit) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextAutofit.class, r2), TextAutofit.class, "com.obric.memorydata.plugin");
        }

        public static TextAutofit[] values() {
            return (TextAutofit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextAutofit[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum TextDirection extends Enum<TextDirection> {
        private static final /* synthetic */ TextDirection[] $VALUES = null;
        public static final TextDirection HORIZONTAL = null;
        public static final TextDirection STACKED = null;
        public static final TextDirection VERTICAL = null;
        public static final TextDirection VERTICAL_270 = null;

        static {
            TextDirection r0 = new TextDirection("HORIZONTAL", 0);
            HORIZONTAL = r0;
            TextDirection r1 = new TextDirection("VERTICAL", 1);
            VERTICAL = r1;
            TextDirection r3 = new TextDirection("VERTICAL_270", 2);
            VERTICAL_270 = r3;
            TextDirection r5 = new TextDirection("STACKED", 3);
            STACKED = r5;
            $VALUES = new TextDirection[]{r0, r1, r3, r5};
        }

        private TextDirection(String r1, int r2) {
            super(r1, r2);
        }

        public static TextDirection valueOf(String r2) {
            return (TextDirection) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextDirection.class, r2), TextDirection.class, "com.obric.memorydata.plugin");
        }

        public static TextDirection[] values() {
            return (TextDirection[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextDirection[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum TextPlaceholder extends Enum<TextPlaceholder> {
        private static final /* synthetic */ TextPlaceholder[] $VALUES = null;
        public static final TextPlaceholder BODY = null;
        public static final TextPlaceholder CENTER_BODY = null;
        public static final TextPlaceholder CENTER_TITLE = null;
        public static final TextPlaceholder HALF_BODY = null;
        public static final TextPlaceholder NOTES = null;
        public static final TextPlaceholder OTHER = null;
        public static final TextPlaceholder QUARTER_BODY = null;
        public static final TextPlaceholder TITLE = null;
        public final int nativeId;

        static {
            TextPlaceholder r0 = new TextPlaceholder("TITLE", 0, 0);
            TITLE = r0;
            TextPlaceholder r1 = new TextPlaceholder("BODY", 1, 1);
            BODY = r1;
            TextPlaceholder r3 = new TextPlaceholder("CENTER_TITLE", 2, 6);
            CENTER_TITLE = r3;
            TextPlaceholder r5 = new TextPlaceholder("CENTER_BODY", 3, 5);
            CENTER_BODY = r5;
            TextPlaceholder r8 = new TextPlaceholder("HALF_BODY", 4, 7);
            HALF_BODY = r8;
            TextPlaceholder r11 = new TextPlaceholder("QUARTER_BODY", 5, 8);
            QUARTER_BODY = r11;
            TextPlaceholder r14 = new TextPlaceholder("NOTES", 6, 2);
            NOTES = r14;
            TextPlaceholder r10 = new TextPlaceholder("OTHER", 7, 4);
            OTHER = r10;
            $VALUES = new TextPlaceholder[]{r0, r1, r3, r5, r8, r11, r14, r10};
        }

        private TextPlaceholder(String r1, int r2, int r3) {
            super(r1, r2);
            this.nativeId = r3;
        }

        public static TextPlaceholder fromNativeId(int r5) {
            TextPlaceholder[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            TextPlaceholder r3 = r0[r2];
            if (r3.nativeId == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static boolean isTitle(int r1) {
            if (r1 != TITLE.nativeId) goto L5;
        L8:
            return true;
        L5:
            if (r1 == CENTER_TITLE.nativeId) goto L8;
            return false;
        }

        public static TextPlaceholder valueOf(String r2) {
            return (TextPlaceholder) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextPlaceholder.class, r2), TextPlaceholder.class, "com.obric.memorydata.plugin");
        }

        public static TextPlaceholder[] values() {
            return (TextPlaceholder[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextPlaceholder[].class, "com.obric.memorydata.plugin");
        }
    }

    String getText();

    List<P> getTextParagraphs();
}
