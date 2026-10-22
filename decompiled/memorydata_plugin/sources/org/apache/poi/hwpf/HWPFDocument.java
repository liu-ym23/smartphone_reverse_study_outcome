package org.apache.poi.hwpf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hwpf.model.BookmarksTables;
import org.apache.poi.hwpf.model.CHPBinTable;
import org.apache.poi.hwpf.model.ComplexFileTable;
import org.apache.poi.hwpf.model.DocumentProperties;
import org.apache.poi.hwpf.model.FSPADocumentPart;
import org.apache.poi.hwpf.model.FSPATable;
import org.apache.poi.hwpf.model.FieldsTables;
import org.apache.poi.hwpf.model.FontTable;
import org.apache.poi.hwpf.model.ListTables;
import org.apache.poi.hwpf.model.NoteType;
import org.apache.poi.hwpf.model.NotesTables;
import org.apache.poi.hwpf.model.OfficeArtContent;
import org.apache.poi.hwpf.model.PAPBinTable;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.model.RevisionMarkAuthorTable;
import org.apache.poi.hwpf.model.SavedByTable;
import org.apache.poi.hwpf.model.SectionTable;
import org.apache.poi.hwpf.model.SinglentonTextPiece;
import org.apache.poi.hwpf.model.StyleSheet;
import org.apache.poi.hwpf.model.SubdocumentType;
import org.apache.poi.hwpf.model.TextPieceTable;
import org.apache.poi.hwpf.usermodel.Bookmarks;
import org.apache.poi.hwpf.usermodel.BookmarksImpl;
import org.apache.poi.hwpf.usermodel.Fields;
import org.apache.poi.hwpf.usermodel.FieldsImpl;
import org.apache.poi.hwpf.usermodel.Notes;
import org.apache.poi.hwpf.usermodel.NotesImpl;
import org.apache.poi.hwpf.usermodel.OfficeDrawingsImpl;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/* JADX INFO: loaded from: classes7.dex */
public final class HWPFDocument extends HWPFDocumentCore {
    private static int MAX_RECORD_LENGTH = 100000;
    private Bookmarks _bookmarks;
    private BookmarksTables _bookmarksTables;
    private ComplexFileTable _cft;
    private byte[] _dataStream;
    private DocumentProperties _dop;
    private Notes _endnotes;
    private NotesTables _endnotesTables;
    private Fields _fields;
    private FieldsTables _fieldsTables;
    private Notes _footnotes;
    private NotesTables _footnotesTables;
    private FSPATable _fspaHeaders;
    private FSPATable _fspaMain;
    private OfficeDrawingsImpl _officeDrawingsHeaders;
    private OfficeDrawingsImpl _officeDrawingsMain;
    private PicturesTable _pictures;
    private RevisionMarkAuthorTable _rmat;
    private SavedByTable _sbt;
    private byte[] _tableStream;
    private StringBuilder _text;
    private final OfficeArtContent officeArtContent;

    static {
    }

    public HWPFDocument(InputStream r1) {
        this(verifyAndBuildPOIFS(r1));
    }

    public HWPFDocument(DirectoryNode r15) {
        super(r15);
        this._endnotesTables = new NotesTables(NoteType.ENDNOTE);
        this._endnotes = new NotesImpl(this._endnotesTables);
        this._footnotesTables = new NotesTables(NoteType.FOOTNOTE);
        this._footnotes = new NotesImpl(this._footnotesTables);
        if (this._fib.getFibBase().getNFib() < 106) goto L41;
        if (this._fib.getFibBase().isFWhichTblStm() == false) goto L7;
        String r0 = "1Table";
    L9:
        if (r15.hasEntry(r0) == false) goto L39;
        this._tableStream = getDocumentEntryBytes(r0, this._fib.getFibBase().getLKey(), Integer.MAX_VALUE);
        this._fib.fillVariableFields(this._mainStream, this._tableStream);
        boolean r1 = false;
        if (r15.hasEntry("Data") == false) goto L13;
        byte[] r16 = getDocumentEntryBytes("Data", 0, Integer.MAX_VALUE);
    L14:
        this._dataStream = r16;
        this._dop = new DocumentProperties(this._tableStream, this._fib.getFcDop(), this._fib.getLcbDop());
        ComplexFileTable r17 = new ComplexFileTable(this._mainStream, this._tableStream, this._fib.getFcClx(), 0);
        this._cft = r17;
        TextPieceTable r18 = r17.getTextPieceTable();
        this._cbt = new CHPBinTable(this._mainStream, this._tableStream, this._fib.getFcPlcfbteChpx(), this._fib.getLcbPlcfbteChpx(), r18);
        this._pbt = new PAPBinTable(this._mainStream, this._tableStream, this._dataStream, this._fib.getFcPlcfbtePapx(), this._fib.getLcbPlcfbtePapx(), r18);
        this._text = r18.getText();
        boolean r2 = Boolean.parseBoolean(System.getProperty("org.apache.poi.hwpf.preserveBinTables"));     // Catch: Exception -> L17
    L18:
        if (r2 == true) goto L45;
        this._cbt.rebuild(this._cft);
        this._pbt.rebuild(this._text, this._cft);
    L45:
        r1 = Boolean.parseBoolean(System.getProperty("org.apache.poi.hwpf.preserveTextTable"));     // Catch: Exception -> L42
    L21:
        if (r1 == true) goto L23;
        ComplexFileTable r19 = new ComplexFileTable();
        this._cft = r19;
        r18 = r19.getTextPieceTable();
        SinglentonTextPiece r3 = new SinglentonTextPiece(this._text);
        r18.add(r3);
        this._text = r3.getStringBuilder();
    L23:
        TextPieceTable r7 = r18;
        this._fspaHeaders = new FSPATable(this._tableStream, this._fib, FSPADocumentPart.HEADER);
        this._fspaMain = new FSPATable(this._tableStream, this._fib, FSPADocumentPart.MAIN);
        OfficeArtContent r110 = new OfficeArtContent(this._tableStream, this._fib.getFcDggInfo(), this._fib.getLcbDggInfo());
        this.officeArtContent = r110;
        this._pictures = new PicturesTable(this, this._dataStream, this._mainStream, this._fspaMain, r110);
        this._officeDrawingsHeaders = new OfficeDrawingsImpl(this._fspaHeaders, r110, this._mainStream);
        this._officeDrawingsMain = new OfficeDrawingsImpl(this._fspaMain, r110, this._mainStream);
        this._st = new SectionTable(this._mainStream, this._tableStream, this._fib.getFcPlcfsed(), this._fib.getLcbPlcfsed(), 0, r7, this._fib.getSubdocumentTextStreamLength(SubdocumentType.MAIN));
        this._ss = new StyleSheet(this._tableStream, this._fib.getFcStshf());
        this._ft = new FontTable(this._tableStream, this._fib.getFcSttbfffn(), this._fib.getLcbSttbfffn());
        int r111 = this._fib.getFcPlfLst();
        if (r111 != 0) goto L26;
    L28:
        int r112 = this._fib.getFcSttbSavedBy();
        int r4 = this._fib.getLcbSttbSavedBy();
        if (r112 == 0) goto L32;
        if (r4 == 0) goto L32;
        this._sbt = new SavedByTable(this._tableStream, r112, r4);
    L32:
        int r113 = this._fib.getFcSttbfRMark();
        int r5 = this._fib.getLcbSttbfRMark();
        if (r113 == 0) goto L36;
        if (r5 == 0) goto L36;
        this._rmat = new RevisionMarkAuthorTable(this._tableStream, r113, r5);
    L36:
        this._bookmarksTables = new BookmarksTables(this._tableStream, this._fib);
        this._bookmarks = new BookmarksImpl(this._bookmarksTables);
        this._endnotesTables = new NotesTables(NoteType.ENDNOTE, this._tableStream, this._fib);
        this._endnotes = new NotesImpl(this._endnotesTables);
        this._footnotesTables = new NotesTables(NoteType.FOOTNOTE, this._tableStream, this._fib);
        this._footnotes = new NotesImpl(this._footnotesTables);
        this._fieldsTables = new FieldsTables(this._tableStream, this._fib);
        this._fields = new FieldsImpl(this._fieldsTables);
        return;
    L26:
        if (this._fib.getLcbPlfLst() == 0) goto L28;
        this._lt = new ListTables(this._tableStream, r111, this._fib.getFcPlfLfo(), this._fib.getLcbPlfLfo());
    L17:
        r2 = false;
        goto L18
    L13:
        r16 = new byte[0];
        goto L14
    L39:
        throw new IllegalStateException("Table Stream '" + r0 + "' wasn't found - Either the document is corrupt, or is Word95 (or earlier)");
    L7:
        r0 = "0Table";
        goto L9
    L41:
        throw new OldWordFileFormatException("The document is too old - Word 95 or older. Try HWPFOldDocument instead?");
    }

    public HWPFDocument(POIFSFileSystem r1) {
        this(r1.getRoot());
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    private Range getRange(SubdocumentType r6) {
        Iterator<SubdocumentType> r0 = SubdocumentType.ORDERED.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L11;
        SubdocumentType r2 = (SubdocumentType) ZeusTransformUtils.preCheckCast(r0.next(), SubdocumentType.class, "com.obric.memorydata.plugin");
        int r3 = getFileInformationBlock().getSubdocumentTextStreamLength(r2);
        if (r6 == r2) goto L8;
        r1 = r1 + r3;
        goto L4
    L8:
        return new Range(r1, r3 + r1, this);
    L11:
        throw new UnsupportedOperationException("Subdocument type not supported: " + r6);
    }

    public void delete(int r2, int r3) {
        new Range(r2, r3 + r2, this).delete();
    }

    public Bookmarks getBookmarks() {
        return this._bookmarks;
    }

    public Range getOverallRange() {
        return new Range(0, this._text.length(), this);
    }

    public PicturesTable getPicturesTable() {
        return this._pictures;
    }

    public Range getRange() {
        return getRange(SubdocumentType.MAIN);
    }

    @Override // org.apache.poi.hwpf.HWPFDocumentCore
    public StringBuilder getText() {
        return this._text;
    }
}
