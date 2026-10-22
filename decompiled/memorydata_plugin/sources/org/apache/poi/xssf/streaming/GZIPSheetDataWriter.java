package org.apache.poi.xssf.streaming;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.model.SharedStringsTable;

/* JADX INFO: loaded from: classes7.dex */
public class GZIPSheetDataWriter extends SheetDataWriter {
    public GZIPSheetDataWriter() {
    }

    public GZIPSheetDataWriter(SharedStringsTable r1) {
        super(r1);
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    @Deprecated
    public File createTempFile() {
        return TempFile.createTempFile("poi-sxssf-sheet-xml", ".gz");
    }

    @Override // org.apache.poi.xssf.streaming.SheetDataWriter
    public OutputStream decorateOutputStream(FileOutputStream r1) {
        return new GZIPOutputStream(r1);
    }
}
