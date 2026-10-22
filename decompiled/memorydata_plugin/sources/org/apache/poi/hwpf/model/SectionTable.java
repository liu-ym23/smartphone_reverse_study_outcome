package org.apache.poi.hwpf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class SectionTable {
    private static final c LOG = null;
    protected List<SEPX> _sections;
    protected List<TextPiece> _text;

    static {
        LOG = b.a(SectionTable.class);
    }

    public SectionTable() {
        this._sections = new ArrayList();
    }

    public SectionTable(byte[] r6, byte[] r7, int r8, int r9, int r10, TextPieceTable r11, int r12) {
        this._sections = new ArrayList();
        PlexOfCps r13 = new PlexOfCps(r7, r8, r9, 12);
        this._text = r11.getTextPieces();
        int r14 = r13.length();
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r16 >= r14) goto L9;
        GenericPropertyNode r17 = r13.getProperty(r16);
        SectionDescriptor r0 = new SectionDescriptor(r17.getBytes(), 0);
        int r1 = r0.getFc();
        int r2 = r17.getStart();
        int r18 = r17.getEnd();
        if (r1 != (-1)) goto L7;
        this._sections.add(new SEPX(r0, r2, r18, new byte[0]));
    L8:
        r16 = r16 + 1;
        goto L3
    L7:
        this._sections.add(new SEPX(r0, r2, r18, IOUtils.safelyClone(r6, r1 + 2, LittleEndian.getShort(r6, r1), HWPFDocument.getMaxRecordLength())));
        goto L8
    L9:
        Iterator<SEPX> r19 = this._sections.iterator();
        boolean r20 = false;
        boolean r21 = false;
    L11:
        if (r19.hasNext() == false) goto L20;
        SEPX r110 = (SEPX) ZeusTransformUtils.preCheckCast(r19.next(), SEPX.class, "com.obric.memorydata.plugin");
        if (r110.getEnd() == r12) goto L14;
        if (r110.getEnd() == r12) goto L19;
        if (r110.getEnd() != (r12 - 1)) goto L11;
    L19:
        r21 = true;
        goto L11
    L14:
        r20 = true;
        goto L11
    L20:
        if (r20 == true) goto L26;
        if (r21 == false) goto L26;
        LOG.atWarn().a("Your document seemed to be mostly unicode, but the section definition was in bytes! Trying anyway, but things may well go wrong!");
    L24:
        if (r15 >= this._sections.size()) goto L26;
        SEPX r22 = (SEPX) ZeusTransformUtils.preCheckCast(this._sections.get(r15), SEPX.class, "com.obric.memorydata.plugin");
        GenericPropertyNode r23 = r13.getProperty(r15);
        int r24 = r23.getStart();
        int r25 = r23.getEnd();
        r22.setStart(r24);
        r22.setEnd(r25);
        r15 = r15 + 1;
    L26:
        this._sections.sort(PropertyNode.StartComparator);
    }

    public List<SEPX> getSections() {
        return this._sections;
    }
}
