package org.apache.poi.ddf;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.apache.poi.util.BitField;

/* JADX INFO: loaded from: classes6.dex */
public class EscherColorRef {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BitField FLAG_BLUE = null;
    private static final BitField FLAG_GREEN = null;
    private static final BitField FLAG_PALETTE_INDEX = null;
    private static final BitField FLAG_PALETTE_RGB = null;
    private static final BitField FLAG_RED = null;
    private static final BitField FLAG_SCHEME_INDEX = null;
    private static final BitField FLAG_SYSTEM_RGB = null;
    private static final BitField FLAG_SYS_INDEX = null;

    public static final enum SysIndexProcedure extends Enum<SysIndexProcedure> {
        private static final /* synthetic */ SysIndexProcedure[] $VALUES = null;
        public static final SysIndexProcedure ADD_GRAY_LEVEL = null;
        public static final SysIndexProcedure DARKEN_COLOR = null;
        public static final SysIndexProcedure INVERT_AFTER = null;
        public static final SysIndexProcedure INVERT_HIGHBIT_AFTER = null;
        public static final SysIndexProcedure LIGHTEN_COLOR = null;
        public static final SysIndexProcedure REVERSE_GRAY_LEVEL = null;
        public static final SysIndexProcedure SUB_GRAY_LEVEL = null;
        public static final SysIndexProcedure THRESHOLD = null;
        private BitField mask;

        static {
            SysIndexProcedure r0 = new SysIndexProcedure("DARKEN_COLOR", 0, 1);
            DARKEN_COLOR = r0;
            SysIndexProcedure r1 = new SysIndexProcedure("LIGHTEN_COLOR", 1, 2);
            LIGHTEN_COLOR = r1;
            SysIndexProcedure r4 = new SysIndexProcedure("ADD_GRAY_LEVEL", 2, 3);
            ADD_GRAY_LEVEL = r4;
            SysIndexProcedure r6 = new SysIndexProcedure("SUB_GRAY_LEVEL", 3, 4);
            SUB_GRAY_LEVEL = r6;
            SysIndexProcedure r8 = new SysIndexProcedure("REVERSE_GRAY_LEVEL", 4, 5);
            REVERSE_GRAY_LEVEL = r8;
            SysIndexProcedure r10 = new SysIndexProcedure("THRESHOLD", 5, 6);
            THRESHOLD = r10;
            SysIndexProcedure r12 = new SysIndexProcedure("INVERT_AFTER", 6, 32);
            INVERT_AFTER = r12;
            SysIndexProcedure r14 = new SysIndexProcedure("INVERT_HIGHBIT_AFTER", 7, 64);
            INVERT_HIGHBIT_AFTER = r14;
            $VALUES = new SysIndexProcedure[]{r0, r1, r4, r6, r8, r10, r12, r14};
        }

        private SysIndexProcedure(String r1, int r2, int r3) {
            super(r1, r2);
            this.mask = new BitField(r3);
        }

        static /* synthetic */ BitField access$100(SysIndexProcedure r0) {
            return r0.mask;
        }

        public static SysIndexProcedure valueOf(String r2) {
            return (SysIndexProcedure) ZeusTransformUtils.preCheckCast(Enum.valueOf(SysIndexProcedure.class, r2), SysIndexProcedure.class, "com.obric.memorydata.plugin");
        }

        public static SysIndexProcedure[] values() {
            return (SysIndexProcedure[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SysIndexProcedure[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum SysIndexSource extends Enum<SysIndexSource> {
        private static final /* synthetic */ SysIndexSource[] $VALUES = null;
        public static final SysIndexSource CURRENT_OR_LAST_COLOR = null;
        public static final SysIndexSource FILL_BACKGROUND_COLOR = null;
        public static final SysIndexSource FILL_COLOR = null;
        public static final SysIndexSource FILL_OR_LINE_COLOR = null;
        public static final SysIndexSource LINE_BACKGROUND_COLOR = null;
        public static final SysIndexSource LINE_COLOR = null;
        public static final SysIndexSource LINE_OR_FILL_COLOR = null;
        public static final SysIndexSource SHADOW_COLOR = null;
        private int value;

        static {
            SysIndexSource r0 = new SysIndexSource("FILL_COLOR", 0, 240);
            FILL_COLOR = r0;
            SysIndexSource r1 = new SysIndexSource("LINE_OR_FILL_COLOR", 1, 241);
            LINE_OR_FILL_COLOR = r1;
            SysIndexSource r3 = new SysIndexSource("LINE_COLOR", 2, 242);
            LINE_COLOR = r3;
            SysIndexSource r5 = new SysIndexSource("SHADOW_COLOR", 3, 243);
            SHADOW_COLOR = r5;
            SysIndexSource r7 = new SysIndexSource("CURRENT_OR_LAST_COLOR", 4, 244);
            CURRENT_OR_LAST_COLOR = r7;
            SysIndexSource r9 = new SysIndexSource("FILL_BACKGROUND_COLOR", 5, 245);
            FILL_BACKGROUND_COLOR = r9;
            SysIndexSource r11 = new SysIndexSource("LINE_BACKGROUND_COLOR", 6, 246);
            LINE_BACKGROUND_COLOR = r11;
            SysIndexSource r13 = new SysIndexSource("FILL_OR_LINE_COLOR", 7, 247);
            FILL_OR_LINE_COLOR = r13;
            $VALUES = new SysIndexSource[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }

        private SysIndexSource(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        static /* synthetic */ int access$000(SysIndexSource r0) {
            return r0.value;
        }

        public static SysIndexSource valueOf(String r2) {
            return (SysIndexSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(SysIndexSource.class, r2), SysIndexSource.class, "com.obric.memorydata.plugin");
        }

        public static SysIndexSource[] values() {
            return (SysIndexSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SysIndexSource[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        FLAG_SYS_INDEX = new BitField(SQLiteDatabase.CREATE_IF_NECESSARY);
        FLAG_SCHEME_INDEX = new BitField(134217728);
        FLAG_SYSTEM_RGB = new BitField(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        FLAG_PALETTE_RGB = new BitField(33554432);
        FLAG_PALETTE_INDEX = new BitField(16777216);
        FLAG_BLUE = new BitField(16711680);
        FLAG_GREEN = new BitField(MotionEventCompat.ACTION_POINTER_INDEX_MASK);
        FLAG_RED = new BitField(255);
    }
}
