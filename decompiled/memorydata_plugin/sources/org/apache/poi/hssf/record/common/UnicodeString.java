package org.apache.poi.hssf.record.common;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.cont.ContinuableRecordInput;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class UnicodeString implements Comparable<UnicodeString>, GenericRecord {
    private static final c LOG = null;
    private static final BitField extBit = null;
    private static final BitField highByte = null;
    private static final BitField richText = null;
    private short field_1_charCount;
    private byte field_2_optionflags;
    private String field_3_string;
    private List<FormatRun> field_4_format_runs;
    private ExtRst field_5_ext_rst;

    static {
        LOG = b.a(UnicodeString.class);
        highByte = BitFieldFactory.getInstance(1);
        extBit = BitFieldFactory.getInstance(4);
        richText = BitFieldFactory.getInstance(8);
    }

    public UnicodeString(String r1) {
        setString(r1);
    }

    public UnicodeString(RecordInputStream r6) {
        this.field_1_charCount = r6.readShort();
        this.field_2_optionflags = r6.readByte();
        int r1 = 0;
        if (isRichText() == false) goto L5;
        short r0 = r6.readShort();
    L7:
        if (isExtendedText() == false) goto L9;
        int r2 = r6.readInt();
    L10:
        boolean r4 = true;
        if ((this.field_2_optionflags & 1) == 0) goto L14;
        r4 = false;
    L14:
        int r3 = getCharCount();
        if (r4 == false) goto L17;
        String r5 = r6.readCompressedUnicode(r3);
    L18:
        this.field_3_string = r5;
        if (isRichText() == false) goto L25;
        if (r0 <= 0) goto L25;
        this.field_4_format_runs = new ArrayList(r0);
    L22:
        if (r1 >= r0) goto L25;
        this.field_4_format_runs.add(new FormatRun(r6));
        r1 = r1 + 1;
    L25:
        if (isExtendedText() == false) goto L32;
        if (r2 <= 0) goto L33;
        ExtRst r7 = new ExtRst(new ContinuableRecordInput(r6), r2);
        this.field_5_ext_rst = r7;
        if ((r7.getDataSize() + 4) == r2) goto L34;
        LOG.atWarn().a("ExtRst was supposed to be {} bytes long, but seems to actually be {}", v.a(r2), v.a(this.field_5_ext_rst.getDataSize() + 4));
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L17:
        r5 = r6.readUnicodeLEString(r3);
        goto L18
    L9:
        r2 = 0;
        goto L10
    L5:
        r0 = 0;
        goto L7
    }

    private UnicodeString(UnicodeString r5) {
        this.field_1_charCount = r5.field_1_charCount;
        this.field_2_optionflags = r5.field_2_optionflags;
        this.field_3_string = r5.field_3_string;
        List<FormatRun> r0 = r5.field_4_format_runs;
        ExtRst r1 = null;
        if (r0 != null) goto L5;
        List<FormatRun> r2 = null;
    L6:
        this.field_4_format_runs = r2;
        ExtRst r6 = r5.field_5_ext_rst;
        if (r6 == null) goto L10;
        r1 = r6.copy();
    L10:
        this.field_5_ext_rst = r1;
        return;
    L5:
        r2 = (List) ZeusTransformUtils.preCheckCast(r0.stream().map($$Lambda$2O0NkWJuWLsiCtKoOwTPvege4Q.INSTANCE).collect(Collectors.toList()), List.class, "com.obric.memorydata.plugin");
        goto L6
    }

    private int findFormatRunAt(int r7) {
        int r0 = this.field_4_format_runs.size();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L12;
        FormatRun r3 = (FormatRun) ZeusTransformUtils.preCheckCast(this.field_4_format_runs.get(r1), FormatRun.class, "com.obric.memorydata.plugin");
        if (r3._character == r7) goto L7;
        if (r3._character > r7) goto L10;
        r1 = r1 + 1;
        goto L4
    L10:
        return -1;
    L7:
        return r1;
    L12:
        return -1;
    }

    private boolean isExtendedText() {
        return extBit.isSet(getOptionFlags());
    }

    private boolean isRichText() {
        return richText.isSet(getOptionFlags());
    }

    public void addFormatRun(FormatRun r3) {
        if (this.field_4_format_runs != null) goto L5;
        this.field_4_format_runs = new ArrayList();
    L5:
        int r0 = findFormatRunAt(r3._character);
        if (r0 == (-1)) goto L8;
        this.field_4_format_runs.remove(r0);
    L8:
        this.field_4_format_runs.add(r3);
        Collections.sort(this.field_4_format_runs);
        this.field_2_optionflags = richText.setByte(this.field_2_optionflags);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(UnicodeString r3) {
        return compareTo2((UnicodeString) ZeusTransformUtils.preCheckCast(r3, UnicodeString.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnicodeString r10) {
        int r0 = getString().compareTo(r10.getString());
        if (r0 == 0) goto L5;
        return r0;
    L5:
        List<FormatRun> r1 = this.field_4_format_runs;
        if (r1 != null) goto L13;
        if (r10.field_4_format_runs != null) goto L11;
        return 0;
    L11:
        return 1;
    L13:
        if (r10.field_4_format_runs != null) goto L15;
        return -1;
    L15:
        int r2 = r1.size();
        if (r2 != r10.field_4_format_runs.size()) goto L18;
        int r3 = 0;
    L20:
        if (r3 >= r2) goto L25;
        int r5 = ((FormatRun) ZeusTransformUtils.preCheckCast(this.field_4_format_runs.get(r3), FormatRun.class, "com.obric.memorydata.plugin")).compareTo2((FormatRun) ZeusTransformUtils.preCheckCast(r10.field_4_format_runs.get(r3), FormatRun.class, "com.obric.memorydata.plugin"));
        if (r5 != 0) goto L23;
        r3 = r3 + 1;
        goto L20
    L23:
        return r5;
    L25:
        ExtRst r9 = this.field_5_ext_rst;
        if (r9 == null) goto L28;
        ExtRst r11 = r10.field_5_ext_rst;
        if (r11 != null) goto L36;
        return -1;
    L36:
        return r9.compareTo2(r11);
    L28:
        if (r10.field_5_ext_rst != null) goto L31;
        return 0;
    L31:
        return 1;
    L18:
        return r2 - r10.field_4_format_runs.size();
    }

    public UnicodeString copy() {
        return new UnicodeString(this);
    }

    public boolean equals(Object r9) {
        if (ZeusTransformUtils.instanceOf(r9, UnicodeString.class) == true) goto L5;
        return false;
    L5:
        UnicodeString r10 = (UnicodeString) ZeusTransformUtils.preCheckCast(r9, UnicodeString.class, "com.obric.memorydata.plugin");
        if (this.field_1_charCount == r10.field_1_charCount) goto L8;
    L41:
        return false;
    L8:
        if (this.field_2_optionflags != r10.field_2_optionflags) goto L41;
        if (this.field_3_string.equals(r10.field_3_string) == false) goto L41;
        List<FormatRun> r0 = this.field_4_format_runs;
        if (r0 != null) goto L19;
        if (r10.field_4_format_runs == null) goto L17;
        return false;
    L17:
        return true;
    L19:
        if (r10.field_4_format_runs != null) goto L21;
        return false;
    L21:
        int r1 = r0.size();
        if (r1 == r10.field_4_format_runs.size()) goto L24;
        return false;
    L24:
        int r4 = 0;
    L25:
        if (r4 >= r1) goto L30;
        if (((FormatRun) ZeusTransformUtils.preCheckCast(this.field_4_format_runs.get(r4), FormatRun.class, "com.obric.memorydata.plugin")).equals((FormatRun) ZeusTransformUtils.preCheckCast(r10.field_4_format_runs.get(r4), FormatRun.class, "com.obric.memorydata.plugin")) == false) goto L28;
        r4 = r4 + 1;
        goto L25
    L28:
        return false;
    L30:
        ExtRst r8 = this.field_5_ext_rst;
        if (r8 == null) goto L33;
        ExtRst r11 = r10.field_5_ext_rst;
        if (r11 != null) goto L40;
        return false;
    L40:
        return r8.equals(r11);
    L33:
        if (r10.field_5_ext_rst == null) goto L35;
        return false;
    L35:
        return true;
    }

    public Iterator<FormatRun> formatIterator() {
        List<FormatRun> r0 = this.field_4_format_runs;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.iterator();
    }

    public int getCharCount() {
        short r1 = this.field_1_charCount;
        if (r1 < 0) goto L5;
        return r1;
    L5:
        return r1 + 65536;
    }

    public ExtRst getExtendedRst() {
        return this.field_5_ext_rst;
    }

    public FormatRun getFormatRun(int r3) {
        List<FormatRun> r0 = this.field_4_format_runs;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r3 >= 0) goto L7;
    L11:
        return null;
    L7:
        if (r3 >= r0.size()) goto L11;
        return (FormatRun) ZeusTransformUtils.preCheckCast(this.field_4_format_runs.get(r3), FormatRun.class, "com.obric.memorydata.plugin");
    }

    public int getFormatRunCount() {
        List<FormatRun> r0 = this.field_4_format_runs;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("charCount", new $$Lambda$1WZP3FCGdX2ehpd_i0lVCME6Xk4(this), "optionFlags", new $$Lambda$Ls45pQwdiYoGZ3t1tSDcGppLtQ(this), TypedValues.Custom.S_STRING, new $$Lambda$8fd_ISh25A64oJPgLp12SWebRGo(this), "formatRuns", new $$Lambda$UnicodeString$vJebNHZZXNngD14yvXWDQhmmqw(this), "extendedRst", new $$Lambda$AYyiaI9aa5k3i3ghpbMsuLRJ3P8(this));
    }

    public byte getOptionFlags() {
        return this.field_2_optionflags;
    }

    public String getString() {
        return this.field_3_string;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Short.valueOf(this.field_1_charCount), this.field_3_string});
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$UnicodeString() {
        return this.field_4_format_runs;
    }

    public void serialize(ContinuableRecordOutput r8) {
        int r1 = 0;
        if (isRichText() == false) goto L7;
        List<FormatRun> r0 = this.field_4_format_runs;
        if (r0 == null) goto L7;
        int r2 = r0.size();
    L9:
        if (isExtendedText() == false) goto L13;
        ExtRst r3 = this.field_5_ext_rst;
        if (r3 == null) goto L13;
        int r4 = r3.getDataSize() + 4;
    L14:
        r8.writeString(this.field_3_string, r2, r4);
        if (r2 <= 0) goto L21;
    L16:
        if (r1 >= r2) goto L21;
        if (r8.getAvailableSpace() >= 4) goto L20;
        r8.writeContinue();
    L20:
        ((FormatRun) ZeusTransformUtils.preCheckCast(this.field_4_format_runs.get(r1), FormatRun.class, "com.obric.memorydata.plugin")).serialize(r8);
        r1 = r1 + 1;
    L21:
        if (r4 <= 0) goto L29;
        ExtRst r7 = this.field_5_ext_rst;
        if (r7 == null) goto L30;
        r7.serialize(r8);
        return;
    L30:
        return;
    L29:
        return;
    L13:
        r4 = 0;
    L7:
        r2 = 0;
        goto L9
    }

    public void setCharCount(short r1) {
        this.field_1_charCount = r1;
    }

    public void setString(String r6) {
        this.field_3_string = r6;
        setCharCount((short) r6.length());
        int r0 = r6.length();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r6.charAt(r2) > 255) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r1 = true;
    L8:
        BitField r7 = highByte;
        byte r3 = this.field_2_optionflags;
        if (r1 == false) goto L11;
        byte r8 = r7.setByte(r3);
    L12:
        this.field_2_optionflags = r8;
        return;
    L11:
        r8 = r7.clearByte(r3);
        goto L12
    }

    public String toString() {
        return getString();
    }
}
