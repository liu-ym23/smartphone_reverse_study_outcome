package org.apache.poi.hssf.extractor;

import java.io.Closeable;
import org.apache.poi.extractor.POIOLE2TextExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/* JADX INFO: loaded from: classes7.dex */
public class ExcelExtractor implements POIOLE2TextExtractor {
    private final HSSFWorkbook _wb;
    private boolean doCloseFilesystem;

    private static final class CommandParseException extends Exception {
        public CommandParseException(String r1) {
            super(r1);
        }
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public /* bridge */ /* synthetic */ Closeable getFilesystem() {
        return getFilesystem();
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public HSSFWorkbook getFilesystem() {
        return this._wb;
    }

    @Override // org.apache.poi.extractor.POITextExtractor
    public boolean isCloseFilesystem() {
        return this.doCloseFilesystem;
    }
}
