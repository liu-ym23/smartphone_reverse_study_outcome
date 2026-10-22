package org.apache.poi.hssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.record.Record;

/* JADX INFO: loaded from: classes7.dex */
public final class WorkbookRecordList {
    private int backuppos;
    private int bspos;
    private int externsheetPos;
    private int fontpos;
    private int namepos;
    private int palettepos;
    private int protpos;
    private List<Record> records;
    private int supbookpos;
    private int tabpos;
    private int xfpos;

    public WorkbookRecordList() {
        this.records = new ArrayList();
        this.tabpos = -1;
        this.palettepos = -1;
    }

    private void updateRecordPos(int r3, boolean r4) {
        if (r4 == false) goto L5;
        int r5 = 1;
    L6:
        int r1 = getProtpos();
        if (r1 < r3) goto L9;
        setProtpos(r1 + r5);
    L9:
        int r2 = getBspos();
        if (r2 < r3) goto L12;
        setBspos(r2 + r5);
    L12:
        int r6 = getTabpos();
        if (r6 < r3) goto L15;
        setTabpos(r6 + r5);
    L15:
        int r7 = getFontpos();
        if (r7 < r3) goto L18;
        setFontpos(r7 + r5);
    L18:
        int r8 = getXfpos();
        if (r8 < r3) goto L21;
        setXfpos(r8 + r5);
    L21:
        int r9 = getBackuppos();
        if (r9 < r3) goto L24;
        setBackuppos(r9 + r5);
    L24:
        int r10 = getNamepos();
        if (r10 < r3) goto L27;
        setNamepos(r10 + r5);
    L27:
        int r11 = getSupbookpos();
        if (r11 < r3) goto L30;
        setSupbookpos(r11 + r5);
    L30:
        int r12 = getPalettepos();
        if (r12 == (-1)) goto L34;
        if (r12 < r3) goto L34;
        setPalettepos(r12 + r5);
    L34:
        int r0 = getExternsheetPos();
        if (r0 < r3) goto L38;
        setExternsheetPos(r0 + r5);
        return;
    L38:
        return;
    L5:
        r5 = -1;
        goto L6
    }

    public void add(int r2, Record r3) {
        this.records.add(r2, r3);
        updateRecordPos(r2, true);
    }

    public Record get(int r2) {
        return (Record) ZeusTransformUtils.preCheckCast(this.records.get(r2), Record.class, "com.obric.memorydata.plugin");
    }

    public int getBackuppos() {
        return this.backuppos;
    }

    public int getBspos() {
        return this.bspos;
    }

    public int getExternsheetPos() {
        return this.externsheetPos;
    }

    public int getFontpos() {
        return this.fontpos;
    }

    public int getNamepos() {
        return this.namepos;
    }

    public int getPalettepos() {
        return this.palettepos;
    }

    public int getProtpos() {
        return this.protpos;
    }

    public List<Record> getRecords() {
        return this.records;
    }

    public int getSupbookpos() {
        return this.supbookpos;
    }

    public int getTabpos() {
        return this.tabpos;
    }

    public int getXfpos() {
        return this.xfpos;
    }

    public void setBackuppos(int r1) {
        this.backuppos = r1;
    }

    public void setBspos(int r1) {
        this.bspos = r1;
    }

    public void setExternsheetPos(int r1) {
        this.externsheetPos = r1;
    }

    public void setFontpos(int r1) {
        this.fontpos = r1;
    }

    public void setNamepos(int r1) {
        this.namepos = r1;
    }

    public void setPalettepos(int r1) {
        this.palettepos = r1;
    }

    public void setProtpos(int r1) {
        this.protpos = r1;
    }

    public void setRecords(List<Record> r3) {
        this.records = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public void setSupbookpos(int r1) {
        this.supbookpos = r1;
    }

    public void setTabpos(int r1) {
        this.tabpos = r1;
    }

    public void setXfpos(int r1) {
        this.xfpos = r1;
    }

    public int size() {
        return this.records.size();
    }
}
