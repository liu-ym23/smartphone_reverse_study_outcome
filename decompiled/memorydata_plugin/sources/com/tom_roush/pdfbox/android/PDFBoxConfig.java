package com.tom_roush.pdfbox.android;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PDFBoxConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static FontLoadLevel f16073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f16074b;

    public static final enum FontLoadLevel extends Enum<FontLoadLevel> {
        private static final /* synthetic */ FontLoadLevel[] $VALUES = null;
        public static final FontLoadLevel FULL = null;
        public static final FontLoadLevel MINIMUM = null;
        public static final FontLoadLevel NONE = null;

        static {
            FontLoadLevel r0 = new FontLoadLevel("FULL", 0);
            FULL = r0;
            FontLoadLevel r1 = new FontLoadLevel("MINIMUM", 1);
            MINIMUM = r1;
            FontLoadLevel r3 = new FontLoadLevel("NONE", 2);
            NONE = r3;
            $VALUES = new FontLoadLevel[]{r0, r1, r3};
        }

        private FontLoadLevel(String r1, int r2) {
            super(r1, r2);
        }

        public static FontLoadLevel valueOf(String r2) {
            return (FontLoadLevel) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontLoadLevel.class, r2), FontLoadLevel.class, "com.obric.memorydata.plugin");
        }

        public static FontLoadLevel[] values() {
            return (FontLoadLevel[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontLoadLevel[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f16073a = FontLoadLevel.MINIMUM;
        f16074b = false;
    }

    public static FontLoadLevel a() {
        return f16073a;
    }

    public static boolean b() {
        return f16074b;
    }
}
