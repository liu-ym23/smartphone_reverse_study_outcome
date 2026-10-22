package com.tom_roush.pdfbox.pdmodel.interactive.viewerpreferences;

import com.tom_roush.pdfbox.a.b;
import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.pdmodel.common.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PDViewerPreferences implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f16296a;

    public static final enum BOUNDARY extends Enum<BOUNDARY> {
        private static final /* synthetic */ BOUNDARY[] $VALUES = null;
        public static final BOUNDARY ArtBox = null;
        public static final BOUNDARY BleedBox = null;
        public static final BOUNDARY CropBox = null;
        public static final BOUNDARY MediaBox = null;
        public static final BOUNDARY TrimBox = null;

        static {
            BOUNDARY r0 = new BOUNDARY("MediaBox", 0);
            MediaBox = r0;
            BOUNDARY r1 = new BOUNDARY("CropBox", 1);
            CropBox = r1;
            BOUNDARY r3 = new BOUNDARY("BleedBox", 2);
            BleedBox = r3;
            BOUNDARY r5 = new BOUNDARY("TrimBox", 3);
            TrimBox = r5;
            BOUNDARY r7 = new BOUNDARY("ArtBox", 4);
            ArtBox = r7;
            $VALUES = new BOUNDARY[]{r0, r1, r3, r5, r7};
        }

        private BOUNDARY(String r1, int r2) {
            super(r1, r2);
        }

        public static BOUNDARY valueOf(String r2) {
            return (BOUNDARY) ZeusTransformUtils.preCheckCast(Enum.valueOf(BOUNDARY.class, r2), BOUNDARY.class, "com.obric.memorydata.plugin");
        }

        public static BOUNDARY[] values() {
            return (BOUNDARY[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BOUNDARY[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum DUPLEX extends Enum<DUPLEX> {
        private static final /* synthetic */ DUPLEX[] $VALUES = null;
        public static final DUPLEX DuplexFlipLongEdge = null;
        public static final DUPLEX DuplexFlipShortEdge = null;
        public static final DUPLEX Simplex = null;

        static {
            DUPLEX r0 = new DUPLEX("Simplex", 0);
            Simplex = r0;
            DUPLEX r1 = new DUPLEX("DuplexFlipShortEdge", 1);
            DuplexFlipShortEdge = r1;
            DUPLEX r3 = new DUPLEX("DuplexFlipLongEdge", 2);
            DuplexFlipLongEdge = r3;
            $VALUES = new DUPLEX[]{r0, r1, r3};
        }

        private DUPLEX(String r1, int r2) {
            super(r1, r2);
        }

        public static DUPLEX valueOf(String r2) {
            return (DUPLEX) ZeusTransformUtils.preCheckCast(Enum.valueOf(DUPLEX.class, r2), DUPLEX.class, "com.obric.memorydata.plugin");
        }

        public static DUPLEX[] values() {
            return (DUPLEX[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DUPLEX[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum NON_FULL_SCREEN_PAGE_MODE extends Enum<NON_FULL_SCREEN_PAGE_MODE> {
        private static final /* synthetic */ NON_FULL_SCREEN_PAGE_MODE[] $VALUES = null;
        public static final NON_FULL_SCREEN_PAGE_MODE UseNone = null;
        public static final NON_FULL_SCREEN_PAGE_MODE UseOC = null;
        public static final NON_FULL_SCREEN_PAGE_MODE UseOutlines = null;
        public static final NON_FULL_SCREEN_PAGE_MODE UseThumbs = null;

        static {
            NON_FULL_SCREEN_PAGE_MODE r0 = new NON_FULL_SCREEN_PAGE_MODE("UseNone", 0);
            UseNone = r0;
            NON_FULL_SCREEN_PAGE_MODE r1 = new NON_FULL_SCREEN_PAGE_MODE("UseOutlines", 1);
            UseOutlines = r1;
            NON_FULL_SCREEN_PAGE_MODE r3 = new NON_FULL_SCREEN_PAGE_MODE("UseThumbs", 2);
            UseThumbs = r3;
            NON_FULL_SCREEN_PAGE_MODE r5 = new NON_FULL_SCREEN_PAGE_MODE("UseOC", 3);
            UseOC = r5;
            $VALUES = new NON_FULL_SCREEN_PAGE_MODE[]{r0, r1, r3, r5};
        }

        private NON_FULL_SCREEN_PAGE_MODE(String r1, int r2) {
            super(r1, r2);
        }

        public static NON_FULL_SCREEN_PAGE_MODE valueOf(String r2) {
            return (NON_FULL_SCREEN_PAGE_MODE) ZeusTransformUtils.preCheckCast(Enum.valueOf(NON_FULL_SCREEN_PAGE_MODE.class, r2), NON_FULL_SCREEN_PAGE_MODE.class, "com.obric.memorydata.plugin");
        }

        public static NON_FULL_SCREEN_PAGE_MODE[] values() {
            return (NON_FULL_SCREEN_PAGE_MODE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NON_FULL_SCREEN_PAGE_MODE[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum PRINT_SCALING extends Enum<PRINT_SCALING> {
        private static final /* synthetic */ PRINT_SCALING[] $VALUES = null;
        public static final PRINT_SCALING AppDefault = null;
        public static final PRINT_SCALING None = null;

        static {
            PRINT_SCALING r0 = new PRINT_SCALING("None", 0);
            None = r0;
            PRINT_SCALING r1 = new PRINT_SCALING("AppDefault", 1);
            AppDefault = r1;
            $VALUES = new PRINT_SCALING[]{r0, r1};
        }

        private PRINT_SCALING(String r1, int r2) {
            super(r1, r2);
        }

        public static PRINT_SCALING valueOf(String r2) {
            return (PRINT_SCALING) ZeusTransformUtils.preCheckCast(Enum.valueOf(PRINT_SCALING.class, r2), PRINT_SCALING.class, "com.obric.memorydata.plugin");
        }

        public static PRINT_SCALING[] values() {
            return (PRINT_SCALING[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PRINT_SCALING[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum READING_DIRECTION extends Enum<READING_DIRECTION> {
        private static final /* synthetic */ READING_DIRECTION[] $VALUES = null;
        public static final READING_DIRECTION L2R = null;
        public static final READING_DIRECTION R2L = null;

        static {
            READING_DIRECTION r0 = new READING_DIRECTION("L2R", 0);
            L2R = r0;
            READING_DIRECTION r1 = new READING_DIRECTION("R2L", 1);
            R2L = r1;
            $VALUES = new READING_DIRECTION[]{r0, r1};
        }

        private READING_DIRECTION(String r1, int r2) {
            super(r1, r2);
        }

        public static READING_DIRECTION valueOf(String r2) {
            return (READING_DIRECTION) ZeusTransformUtils.preCheckCast(Enum.valueOf(READING_DIRECTION.class, r2), READING_DIRECTION.class, "com.obric.memorydata.plugin");
        }

        public static READING_DIRECTION[] values() {
            return (READING_DIRECTION[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), READING_DIRECTION[].class, "com.obric.memorydata.plugin");
        }
    }

    public d a() {
        return this.f16296a;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ b e() {
        return a();
    }
}
