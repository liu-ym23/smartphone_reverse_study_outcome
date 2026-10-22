package com.tom_roush.pdfbox.multipdf;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PDFMergerUtility {

    public static final enum AcroFormMergeMode extends Enum<AcroFormMergeMode> {
        private static final /* synthetic */ AcroFormMergeMode[] $VALUES = null;
        public static final AcroFormMergeMode JOIN_FORM_FIELDS_MODE = null;
        public static final AcroFormMergeMode PDFBOX_LEGACY_MODE = null;

        static {
            AcroFormMergeMode r0 = new AcroFormMergeMode("JOIN_FORM_FIELDS_MODE", 0);
            JOIN_FORM_FIELDS_MODE = r0;
            AcroFormMergeMode r1 = new AcroFormMergeMode("PDFBOX_LEGACY_MODE", 1);
            PDFBOX_LEGACY_MODE = r1;
            $VALUES = new AcroFormMergeMode[]{r0, r1};
        }

        private AcroFormMergeMode(String r1, int r2) {
            super(r1, r2);
        }

        public static AcroFormMergeMode valueOf(String r2) {
            return (AcroFormMergeMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(AcroFormMergeMode.class, r2), AcroFormMergeMode.class, "com.obric.memorydata.plugin");
        }

        public static AcroFormMergeMode[] values() {
            return (AcroFormMergeMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AcroFormMergeMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum DocumentMergeMode extends Enum<DocumentMergeMode> {
        private static final /* synthetic */ DocumentMergeMode[] $VALUES = null;
        public static final DocumentMergeMode OPTIMIZE_RESOURCES_MODE = null;
        public static final DocumentMergeMode PDFBOX_LEGACY_MODE = null;

        static {
            DocumentMergeMode r0 = new DocumentMergeMode("OPTIMIZE_RESOURCES_MODE", 0);
            OPTIMIZE_RESOURCES_MODE = r0;
            DocumentMergeMode r1 = new DocumentMergeMode("PDFBOX_LEGACY_MODE", 1);
            PDFBOX_LEGACY_MODE = r1;
            $VALUES = new DocumentMergeMode[]{r0, r1};
        }

        private DocumentMergeMode(String r1, int r2) {
            super(r1, r2);
        }

        public static DocumentMergeMode valueOf(String r2) {
            return (DocumentMergeMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(DocumentMergeMode.class, r2), DocumentMergeMode.class, "com.obric.memorydata.plugin");
        }

        public static DocumentMergeMode[] values() {
            return (DocumentMergeMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DocumentMergeMode[].class, "com.obric.memorydata.plugin");
        }
    }
}
