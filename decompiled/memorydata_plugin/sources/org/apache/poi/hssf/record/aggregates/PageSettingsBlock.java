package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.BottomMarginRecord;
import org.apache.poi.hssf.record.ContinueRecord;
import org.apache.poi.hssf.record.FooterRecord;
import org.apache.poi.hssf.record.HCenterRecord;
import org.apache.poi.hssf.record.HeaderFooterRecord;
import org.apache.poi.hssf.record.HeaderRecord;
import org.apache.poi.hssf.record.HorizontalPageBreakRecord;
import org.apache.poi.hssf.record.LeftMarginRecord;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.apache.poi.hssf.record.PrintSetupRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.RightMarginRecord;
import org.apache.poi.hssf.record.TopMarginRecord;
import org.apache.poi.hssf.record.UserSViewBegin;
import org.apache.poi.hssf.record.VCenterRecord;
import org.apache.poi.hssf.record.VerticalPageBreakRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class PageSettingsBlock extends RecordAggregate {
    private Record _bitmap;
    private BottomMarginRecord _bottomMargin;
    private PageBreakRecord _columnBreaksRecord;
    private FooterRecord _footer;
    private HCenterRecord _hCenter;
    private HeaderRecord _header;
    private HeaderFooterRecord _headerFooter;
    private LeftMarginRecord _leftMargin;
    private final List<PLSAggregate> _plsRecords;
    private PrintSetupRecord _printSetup;
    private Record _printSize;
    private RightMarginRecord _rightMargin;
    private PageBreakRecord _rowBreaksRecord;
    private final List<HeaderFooterRecord> _sviewHeaderFooters;
    private TopMarginRecord _topMargin;
    private VCenterRecord _vCenter;

    private static final class PLSAggregate extends RecordAggregate {
        private static final ContinueRecord[] EMPTY_CONTINUE_RECORD_ARRAY = null;
        private final Record _pls;
        private ContinueRecord[] _plsContinues;

        static {
            EMPTY_CONTINUE_RECORD_ARRAY = new ContinueRecord[0];
        }

        public PLSAggregate(RecordStream r6) {
            this._pls = r6.getNext();
            if (r6.peekNextSid() != 60) goto L9;
            ArrayList r0 = new ArrayList();
        L6:
            if (r6.peekNextSid() != 60) goto L8;
            r0.add((ContinueRecord) ZeusTransformUtils.preCheckCast(r6.getNext(), ContinueRecord.class, "com.obric.memorydata.plugin"));
            goto L6
        L8:
            ContinueRecord[] r7 = new ContinueRecord[r0.size()];
            this._plsContinues = r7;
            r0.toArray(r7);
            return;
        L9:
            this._plsContinues = EMPTY_CONTINUE_RECORD_ARRAY;
        }

        @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
        public void visitContainedRecords(RecordAggregate.RecordVisitor r4) {
            RecordAggregate.RecordVisitor r5 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r4, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
            r5.visitRecord(this._pls);
            ContinueRecord[] r3 = this._plsContinues;
            int r0 = r3.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            r5.visitRecord(r3[r1]);
            r1 = r1 + 1;
            goto L3
        }
    }

    public PageSettingsBlock() {
        this._sviewHeaderFooters = new ArrayList();
        this._plsRecords = new ArrayList();
        this._rowBreaksRecord = new HorizontalPageBreakRecord();
        this._columnBreaksRecord = new VerticalPageBreakRecord();
        this._header = new HeaderRecord("");
        this._footer = new FooterRecord("");
        this._hCenter = createHCenter();
        this._vCenter = createVCenter();
        this._printSetup = createPrintSetup();
    }

    public PageSettingsBlock(RecordStream r2) {
        this._sviewHeaderFooters = new ArrayList();
        this._plsRecords = new ArrayList();
    L4:
        if (readARecord(r2) == true) goto L4;
    }

    private void checkNotPresent(Record r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        throw new RecordFormatException("Duplicate PageSettingsBlock record (sid=0x" + Integer.toHexString(r3.getSid()) + ")");
    }

    private static HCenterRecord createHCenter() {
        HCenterRecord r0 = new HCenterRecord();
        r0.setHCenter(false);
        return r0;
    }

    private static PrintSetupRecord createPrintSetup() {
        PrintSetupRecord r0 = new PrintSetupRecord();
        r0.setPaperSize(1);
        r0.setScale(100);
        r0.setPageStart(1);
        r0.setFitWidth(1);
        r0.setFitHeight(1);
        r0.setOptions(2);
        r0.setHResolution(300);
        r0.setVResolution(300);
        r0.setHeaderMargin(0.5d);
        r0.setFooterMargin(0.5d);
        r0.setCopies(1);
        return r0;
    }

    private static VCenterRecord createVCenter() {
        VCenterRecord r0 = new VCenterRecord();
        r0.setVCenter(false);
        return r0;
    }

    public static boolean isComponentRecord(int r1) {
        if (r1 != 20) goto L5;
        return true;
    L5:
        if (r1 != 21) goto L7;
        return true;
    L7:
        if (r1 != 26) goto L9;
        return true;
    L9:
        if (r1 != 27) goto L11;
        return true;
    L11:
        if (r1 != 51) goto L13;
        return true;
    L13:
        if (r1 != 77) goto L15;
        return true;
    L15:
        if (r1 != 161) goto L17;
        return true;
    L17:
        if (r1 != 233) goto L19;
        return true;
    L19:
        if (r1 != 2204) goto L21;
        return true;
    L21:
        if (r1 != 131) goto L23;
        return true;
    L23:
        if (r1 == 132) goto L38;
        switch(r1) {
            case 38: goto L39;
            case 39: goto L39;
            case 40: goto L39;
            case 41: goto L39;
            default: goto L25;
        };
    L25:
        return false;
    L39:
        return true;
    L38:
        return true;
    }

    private boolean readARecord(RecordStream r4) {
        int r0 = r4.peekNextSid();
        if (r0 != 20) goto L5;
        checkNotPresent(this._header);
        this._header = (HeaderRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), HeaderRecord.class, "com.obric.memorydata.plugin");
        return true;
    L5:
        if (r0 != 21) goto L7;
        checkNotPresent(this._footer);
        this._footer = (FooterRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), FooterRecord.class, "com.obric.memorydata.plugin");
        return true;
    L7:
        if (r0 != 26) goto L9;
        checkNotPresent(this._columnBreaksRecord);
        this._columnBreaksRecord = (PageBreakRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), PageBreakRecord.class, "com.obric.memorydata.plugin");
        return true;
    L9:
        if (r0 != 27) goto L11;
        checkNotPresent(this._rowBreaksRecord);
        this._rowBreaksRecord = (PageBreakRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), PageBreakRecord.class, "com.obric.memorydata.plugin");
        return true;
    L11:
        if (r0 != 51) goto L13;
        checkNotPresent(this._printSize);
        this._printSize = r4.getNext();
        return true;
    L13:
        if (r0 != 77) goto L15;
        this._plsRecords.add(new PLSAggregate(r4));
        return true;
    L15:
        if (r0 != 161) goto L17;
        checkNotPresent(this._printSetup);
        this._printSetup = (PrintSetupRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), PrintSetupRecord.class, "com.obric.memorydata.plugin");
        return true;
    L17:
        if (r0 != 233) goto L19;
        checkNotPresent(this._bitmap);
        this._bitmap = r4.getNext();
        return true;
    L19:
        if (r0 != 2204) goto L21;
        HeaderFooterRecord r5 = (HeaderFooterRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), HeaderFooterRecord.class, "com.obric.memorydata.plugin");
        if (r5.isCurrentSheet() == false) goto L36;
        this._headerFooter = r5;
        return true;
    L36:
        this._sviewHeaderFooters.add(r5);
        return true;
    L21:
        if (r0 != 131) goto L23;
        checkNotPresent(this._hCenter);
        this._hCenter = (HCenterRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), HCenterRecord.class, "com.obric.memorydata.plugin");
        return true;
    L23:
        if (r0 == 132) goto L31;
        switch(r0) {
            case 38: goto L30;
            case 39: goto L29;
            case 40: goto L28;
            case 41: goto L27;
            default: goto L25;
        };
    L25:
        return false;
    L27:
        checkNotPresent(this._bottomMargin);
        this._bottomMargin = (BottomMarginRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), BottomMarginRecord.class, "com.obric.memorydata.plugin");
        return true;
    L28:
        checkNotPresent(this._topMargin);
        this._topMargin = (TopMarginRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), TopMarginRecord.class, "com.obric.memorydata.plugin");
        return true;
    L29:
        checkNotPresent(this._rightMargin);
        this._rightMargin = (RightMarginRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), RightMarginRecord.class, "com.obric.memorydata.plugin");
        return true;
    L30:
        checkNotPresent(this._leftMargin);
        this._leftMargin = (LeftMarginRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), LeftMarginRecord.class, "com.obric.memorydata.plugin");
        return true;
    L31:
        checkNotPresent(this._vCenter);
        this._vCenter = (VCenterRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), VCenterRecord.class, "com.obric.memorydata.plugin");
        return true;
    }

    private static void visitIfPresent(PageBreakRecord r2, RecordAggregate.RecordVisitor r3) {
        RecordAggregate.RecordVisitor r4 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return;
    L7:
        r4.visitRecord(r2);
    }

    private static void visitIfPresent(Record r2, RecordAggregate.RecordVisitor r3) {
        RecordAggregate.RecordVisitor r4 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r4.visitRecord(r2);
        return;
    }

    public void addLateHeaderFooter(HeaderFooterRecord r3) {
        if (this._headerFooter != null) goto L11;
        if (r3.getSid() != 2204) goto L9;
        this._headerFooter = r3;
        return;
    L9:
        throw new RecordFormatException("Unexpected header-footer record sid: 0x" + Integer.toHexString(r3.getSid()));
    L11:
        throw new IllegalStateException("This page settings block already has a header/footer record");
    }

    public void addLateRecords(RecordStream r2) {
    L3:
        if (readARecord(r2) == true) goto L3;
    }

    public /* synthetic */ void lambda$positionRecords$0$PageSettingsBlock(Map r4, CustomViewSettingsRecordAggregate r5, Record r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if (r6.getSid() != 426) goto L8;
        HeaderFooterRecord r8 = (HeaderFooterRecord) ZeusTransformUtils.preCheckCast(r7.get(HexDump.toHex(((UserSViewBegin) ZeusTransformUtils.preCheckCast(r6, UserSViewBegin.class, "com.obric.memorydata.plugin")).getGuid())), HeaderFooterRecord.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L9;
        r5.append(r8);
        this._sviewHeaderFooters.remove(r8);
        return;
    L9:
        return;
    }

    public void positionRecords(List<RecordBase> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList(this._sviewHeaderFooters);
        final HashMap r2 = new HashMap();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        HeaderFooterRecord r3 = (HeaderFooterRecord) ZeusTransformUtils.preCheckCast(r1.next(), HeaderFooterRecord.class, "com.obric.memorydata.plugin");
        r2.put(HexDump.toHex(r3.getGuid()), r3);
        goto L4
    L6:
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        RecordBase r4 = (RecordBase) ZeusTransformUtils.preCheckCast(r8.next(), RecordBase.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, CustomViewSettingsRecordAggregate.class) == false) goto L8;
        final CustomViewSettingsRecordAggregate r5 = (CustomViewSettingsRecordAggregate) ZeusTransformUtils.preCheckCast(r4, CustomViewSettingsRecordAggregate.class, "com.obric.memorydata.plugin");
        r5.visitContainedRecords(new $$Lambda$PageSettingsBlock$0In05vESXkq3vv6CYfcHqyknwac(this, r2, r5));
        goto L8
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r5) {
        RecordAggregate.RecordVisitor r6 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r5, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        visitIfPresent(this._rowBreaksRecord, r6);
        visitIfPresent(this._columnBreaksRecord, r6);
        HeaderRecord r0 = this._header;
        if (r0 != null) goto L5;
        r0 = new HeaderRecord("");
    L5:
        r6.visitRecord(r0);
        FooterRecord r1 = this._footer;
        if (r1 != null) goto L8;
        r1 = new FooterRecord("");
    L8:
        r6.visitRecord(r1);
        visitIfPresent(this._hCenter, r6);
        visitIfPresent(this._vCenter, r6);
        visitIfPresent(this._leftMargin, r6);
        visitIfPresent(this._rightMargin, r6);
        visitIfPresent(this._topMargin, r6);
        visitIfPresent(this._bottomMargin, r6);
        Iterator<PLSAggregate> r2 = this._plsRecords.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((RecordAggregate) ZeusTransformUtils.preCheckCast(r2.next(), RecordAggregate.class, "com.obric.memorydata.plugin")).visitContainedRecords(r6);
        goto L10
    L12:
        visitIfPresent(this._printSetup, r6);
        visitIfPresent(this._printSize, r6);
        visitIfPresent(this._headerFooter, r6);
        visitIfPresent(this._bitmap, r6);
    }
}
