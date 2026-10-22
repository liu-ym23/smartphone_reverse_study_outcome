package org.apache.poi.hssf.eventusermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactoryInputStream;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes7.dex */
public class HSSFEventFactory {
    public HSSFEventFactory() {
    }

    private short genericProcessEvents(HSSFRequest r2, InputStream r3) {
        short r0 = 0;
        RecordFactoryInputStream r1 = new RecordFactoryInputStream(r3, false);
    L3:
        Record r4 = r1.nextRecord();
        if (r4 == null) goto L8;
        r0 = r2.processRecord(r4);
        if (r0 == 0) goto L3;
    L8:
        return r0;
    }

    public void processEvents(HSSFRequest r1, InputStream r2) {
        genericProcessEvents(r1, r2);     // Catch: HSSFUserException -> L4
        return;
    }

    public void processWorkbookEvents(HSSFRequest r6, DirectoryNode r7) {
        Set<String> r0 = r7.getEntryNames();
        Iterator<String> r1 = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r0.contains(r2) == false) goto L4;
    L9:
        if (r2 != null) goto L11;
        r2 = (String) ZeusTransformUtils.preCheckCast(InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES.get(0), String.class, "com.obric.memorydata.plugin");
    L11:
        DocumentInputStream r8 = r7.createDocumentInputStream(r2);
        processEvents(r6, r8);     // Catch: Throwable -> L16
        if (r8 == null) goto L34;
        r8.close();
        return;
    L34:
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        if (r8 != null) goto L29;
    L24:
        throw th;
    L29:
        r8.close();     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        th.addSuppressed(th);
        goto L24
    L8:
        r2 = null;
        goto L9
    }

    public void processWorkbookEvents(HSSFRequest r1, POIFSFileSystem r2) {
        processWorkbookEvents(r1, r2.getRoot());
    }
}
