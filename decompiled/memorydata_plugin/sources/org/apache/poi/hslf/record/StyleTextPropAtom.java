package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.hslf.model.textproperties.TextPropCollection;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class StyleTextPropAtom extends RecordAtom {
    public static final long _type = 0;
    private final byte[] _header;
    private List<TextPropCollection> charStyles;
    private boolean initialised;
    private List<TextPropCollection> paragraphStyles;
    private byte[] rawContents;
    private byte[] reserved;

    static {
        _type = RecordTypes.StyleTextPropAtom.typeID;
    }

    public StyleTextPropAtom(int r4) {
        byte[] r0 = new byte[8];
        this._header = r0;
        this.rawContents = new byte[0];
        this.reserved = new byte[0];
        LittleEndian.putInt(r0, 2, (short) _type);
        LittleEndian.putInt(r0, 4, 10);
        this.paragraphStyles = new ArrayList();
        this.charStyles = new ArrayList();
        addParagraphTextPropCollection(r4);
        addCharacterTextPropCollection(r4);
        this.initialised = true;
        updateRawContents();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        throw new HSLFException(e);
    }

    public StyleTextPropAtom(byte[] r2, int r3, int r4) {
        if (r4 < 18) goto L5;
    L9:
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this.rawContents = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
        this.reserved = new byte[0];
        this.paragraphStyles = new ArrayList();
        this.charStyles = new ArrayList();
        return;
    L5:
        if ((r2.length - r3) < 18) goto L8;
        r4 = 18;
        goto L9
    L8:
        throw new HSLFException("Not enough data to form a StyleTextPropAtom (min size 18 bytes long) - found " + (r2.length - r3));
    }

    private int checkTextLength(int r4, int r5, int r6) {
        int r0 = r6 + 1;
        if ((r4 + r5) <= r0) goto L6;
        LOG.atWarn().a("Style length of {} at {} larger than stated size of {}, truncating", v.a(r4), v.a(r5), v.a(r6));
        return r0 - r5;
    L6:
        return r4;
    }

    private void updateRawContents() {
        if (this.initialised == false) goto L24;
        UnsynchronizedByteArrayOutputStream r0 = new UnsynchronizedByteArrayOutputStream();
        Iterator<TextPropCollection> r1 = this.paragraphStyles.iterator();     // Catch: Throwable -> L16
    L8:
        if (r1.hasNext() == false) goto L10;
        ((TextPropCollection) ZeusTransformUtils.preCheckCast(r1.next(), TextPropCollection.class, "com.obric.memorydata.plugin")).writeOut(r0);     // Catch: Throwable -> L16
        goto L8
    L10:
        Iterator<TextPropCollection> r2 = this.charStyles.iterator();     // Catch: Throwable -> L16
    L12:
        if (r2.hasNext() == false) goto L14;
        ((TextPropCollection) ZeusTransformUtils.preCheckCast(r2.next(), TextPropCollection.class, "com.obric.memorydata.plugin")).writeOut(r0);     // Catch: Throwable -> L16
        goto L12
    L14:
        this.rawContents = r0.toByteArray();     // Catch: Throwable -> L16
        r0.close();
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L21
    L23:
        throw th;
    L21:
        th = move-exception;
        th.addSuppressed(th);
    L24:
        int r3 = this.rawContents.length + this.reserved.length;
        LittleEndian.putInt(this._header, 4, r3);
    }

    public TextPropCollection addCharacterTextPropCollection(int r3) {
        TextPropCollection r0 = new TextPropCollection(r3, TextPropCollection.TextPropType.character);
        this.charStyles.add(r0);
        return r0;
    }

    public TextPropCollection addParagraphTextPropCollection(int r3) {
        TextPropCollection r0 = new TextPropCollection(r3, TextPropCollection.TextPropType.paragraph);
        this.paragraphStyles.add(r0);
        return r0;
    }

    public List<TextPropCollection> getCharacterStyles() {
        return this.charStyles;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        if (this.initialised == true) goto L6;
        return null;
    L6:
        return GenericRecordUtil.getGenericProperties("paragraphStyles", new $$Lambda$VXmLt4tKNimYj_pwhWt8d_r3A(this), "characterStyles", new $$Lambda$x6TjddZD2Jr2DnTQJnSEzZ398AY(this));
    }

    public List<TextPropCollection> getParagraphStyles() {
        return this.paragraphStyles;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public void setParentTextSize(int r10) {
        if (this.initialised == false) goto L5;
        return;
    L5:
        this.paragraphStyles.clear();
        this.charStyles.clear();
        int r0 = 0;
        int r3 = r10;
        int r1 = 0;
        int r2 = 0;
    L6:
        byte[] r4 = this.rawContents;
        if (r1 >= r4.length) goto L14;
        if (r2 >= r3) goto L14;
        int r5 = checkTextLength(LittleEndian.getInt(r4, r1), r2, r10);
        r2 = r2 + r5;
        int r6 = r1 + 4;
        short r7 = LittleEndian.getShort(this.rawContents, r6);
        int r8 = r6 + 2;
        int r9 = LittleEndian.getInt(this.rawContents, r8);
        int r11 = r8 + 4;
        TextPropCollection r12 = new TextPropCollection(r5, TextPropCollection.TextPropType.paragraph);
        r12.setIndentLevel(r7);
        r1 = r11 + r12.buildTextPropList(r9, this.rawContents, r11);
        this.paragraphStyles.add(r12);
        if (r1 >= this.rawContents.length) goto L6;
        if (r2 != r10) goto L6;
        r3 = r3 + 1;
    L14:
        if (r4.length <= 0) goto L18;
        int r13 = r10 + 1;
        if (r2 == r13) goto L18;
        LOG.atWarn().a("Problem reading paragraph style runs: textHandled = {}, text.size+1 = {}", v.a(r2), v.a(r13));
    L18:
        int r14 = r10;
    L19:
        byte[] r15 = this.rawContents;
        if (r1 >= r15.length) goto L27;
        if (r0 >= r14) goto L27;
        int r16 = checkTextLength(LittleEndian.getInt(r15, r1), r0, r10);
        r0 = r0 + r16;
        int r17 = r1 + 4;
        int r18 = LittleEndian.getInt(this.rawContents, r17);
        int r19 = r17 + 4;
        TextPropCollection r20 = new TextPropCollection(r16, TextPropCollection.TextPropType.character);
        r1 = r19 + r20.buildTextPropList(r18, this.rawContents, r19);
        this.charStyles.add(r20);
        if (r1 >= this.rawContents.length) goto L19;
        if (r0 != r10) goto L19;
        r14 = r14 + 1;
    L27:
        if (r15.length <= 0) goto L31;
        int r110 = r10 + 1;
        if (r0 == r110) goto L31;
        LOG.atWarn().a("Problem reading character style runs: textHandled = {}, text.size+1 = {}", v.a(r0), v.a(r110));
    L31:
        byte[] r111 = this.rawContents;
        if (r1 >= r111.length) goto L34;
        this.reserved = IOUtils.safelyClone(r111, r1, r111.length - r1, r111.length);
    L34:
        this.initialised = true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("StyleTextPropAtom:\n");
        if (this.initialised == true) goto L6;
        String r1 = "Uninitialised, dumping Raw Style Data\n";
    L5:
        r0.append(r1);
        r0.append("  original byte stream \n");
        byte[] r2 = IOUtils.safelyAllocate(((long) this.rawContents.length) + ((long) this.reserved.length), getMaxRecordLength());
        byte[] r5 = this.rawContents;
        System.arraycopy(r5, 0, r2, 0, r5.length);
        byte[] r6 = this.reserved;
        System.arraycopy(r6, 0, r2, this.rawContents.length, r6.length);
        r0.append(HexDump.dump(r2, 0, 0));
        return r0.toString();
    L6:
        r0.append("Paragraph properties\n");
        Iterator<TextPropCollection> r3 = getParagraphStyles().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r0.append((TextPropCollection) ZeusTransformUtils.preCheckCast(r3.next(), TextPropCollection.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        r0.append("Character properties\n");
        Iterator<TextPropCollection> r4 = getCharacterStyles().iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r0.append((TextPropCollection) ZeusTransformUtils.preCheckCast(r4.next(), TextPropCollection.class, "com.obric.memorydata.plugin"));
        goto L12
    L14:
        r0.append("Reserved bytes\n");
        r1 = HexDump.dump(this.reserved, 0, 0);
        goto L5
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        updateRawContents();
        r2.write(this._header);
        r2.write(this.rawContents);
        r2.write(this.reserved);
    }
}
