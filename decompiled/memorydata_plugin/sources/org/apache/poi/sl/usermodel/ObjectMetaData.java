package org.apache.poi.sl.usermodel;

import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.hpsf.ClassIDPredefined;

/* JADX INFO: loaded from: classes7.dex */
public interface ObjectMetaData {

    public static final enum Application extends Enum<Application> {
        private static final /* synthetic */ Application[] $VALUES = null;
        public static final Application CUSTOM = null;
        public static final Application EXCEL_V12 = null;
        public static final Application EXCEL_V8 = null;
        public static final Application PDF = null;
        public static final Application WORD_V12 = null;
        public static final Application WORD_V8 = null;
        ClassID classId;
        String objectName;
        String oleEntry;
        String progId;

        static {
            Application r7 = new Application("EXCEL_V8", 0, "Worksheet", "Excel.Sheet.8", "Package", ClassIDPredefined.EXCEL_V8);
            EXCEL_V8 = r7;
            Application r0 = new Application("EXCEL_V12", 1, "Worksheet", "Excel.Sheet.12", "Package", ClassIDPredefined.EXCEL_V12);
            EXCEL_V12 = r0;
            Application r1 = new Application("WORD_V8", 2, i.f16175a, "Word.Document.8", "Package", ClassIDPredefined.WORD_V8);
            WORD_V8 = r1;
            Application r2 = new Application("WORD_V12", 3, i.f16175a, "Word.Document.12", "Package", ClassIDPredefined.WORD_V12);
            WORD_V12 = r2;
            Application r3 = new Application("PDF", 4, "PDF", "AcroExch.Document", "Contents", ClassIDPredefined.PDF);
            PDF = r3;
            Application r4 = new Application("CUSTOM", 5, null, null, null, null);
            CUSTOM = r4;
            $VALUES = new Application[]{r7, r0, r1, r2, r3, r4};
        }

        private Application(String r1, int r2, String r3, String r4, String r5, ClassIDPredefined r6) {
            super(r1, r2);
            this.objectName = r3;
            this.progId = r4;
            if (r6 != null) goto L5;
            ClassID r7 = null;
        L6:
            this.classId = r7;
            this.oleEntry = r5;
            return;
        L5:
            r7 = r6.getClassID();
            goto L6
        }

        public static Application lookup(String r5) {
            Application[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            Application r3 = r0[r2];
            String r4 = r3.progId;
            if (r4 == null) goto L9;
            if (r4.equals(r5) == false) goto L9;
            return r3;
        L9:
            r2 = r2 + 1;
            goto L3
        L10:
            return null;
        }

        public static Application valueOf(String r2) {
            return (Application) ZeusTransformUtils.preCheckCast(Enum.valueOf(Application.class, r2), Application.class, "com.obric.memorydata.plugin");
        }

        public static Application[] values() {
            return (Application[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Application[].class, "com.obric.memorydata.plugin");
        }

        public ObjectMetaData getMetaData() {
            return new AnonymousClass1(this);
        }
    }
}
