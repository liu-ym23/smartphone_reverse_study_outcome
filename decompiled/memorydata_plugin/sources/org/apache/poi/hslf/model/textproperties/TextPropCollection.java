package org.apache.poi.hslf.model.textproperties;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.hslf.record.Record;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class TextPropCollection implements GenericRecord {
    private static final c LOG = null;
    private static final TextProp[] characterTextPropTypes = null;
    private static final TextProp[] paragraphTextPropTypes = null;
    private int charactersCovered;
    private short indentLevel;
    private int maskSpecial;
    private final TextPropType textPropType;
    private final Map<String, TextProp> textProps;

    public static final enum TextPropType extends Enum<TextPropType> {
        private static final /* synthetic */ TextPropType[] $VALUES = null;
        public static final TextPropType character = null;
        public static final TextPropType paragraph = null;

        static {
            TextPropType r0 = new TextPropType("paragraph", 0);
            paragraph = r0;
            TextPropType r1 = new TextPropType("character", 1);
            character = r1;
            $VALUES = new TextPropType[]{r0, r1};
        }

        private TextPropType(String r1, int r2) {
            super(r1, r2);
        }

        public static TextPropType valueOf(String r2) {
            return (TextPropType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TextPropType.class, r2), TextPropType.class, "com.obric.memorydata.plugin");
        }

        public static TextPropType[] values() {
            return (TextPropType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TextPropType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(TextPropCollection.class);
        paragraphTextPropTypes = new TextProp[]{new ParagraphFlagsTextProp(), new TextProp(2, 128, "bullet.char"), new TextProp(2, 16, "bullet.font"), new TextProp(2, 64, "bullet.size"), new TextProp(4, 32, "bullet.color"), new TextAlignmentProp(), new TextProp(2, 4096, "linespacing"), new TextProp(2, 8192, "spacebefore"), new TextProp(2, 16384, "spaceafter"), new TextProp(2, 256, "text.offset"), new TextProp(2, 1024, "bullet.offset"), new TextProp(2, 32768, "defaultTabSize"), new HSLFTabStopPropCollection(), new FontAlignmentProp(), new WrapFlagsTextProp(), new TextProp(2, 2097152, "textDirection"), new TextProp(0, 8388608, "bullet.blip"), new TextProp(0, 16777216, "bullet.scheme"), new TextProp(0, 33554432, "hasBulletScheme")};
        characterTextPropTypes = new TextProp[]{new TextProp(0, 1048576, "pp10ext"), new TextProp(0, 16777216, "newAsian.font.index"), new TextProp(0, 33554432, "cs.font.index"), new TextProp(0, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL, "pp11ext"), new CharFlagsTextProp(), new TextProp(2, 65536, "font.index"), new TextProp(2, 2097152, "asian.font.index"), new TextProp(2, 4194304, "ansi.font.index"), new TextProp(2, 8388608, "symbol.font.index"), new TextProp(2, 131072, "font.size"), new TextProp(4, 262144, "font.color"), new TextProp(2, 524288, "superscript")};
    }

    public TextPropCollection(int r2, TextPropType r3) {
        this.textProps = new HashMap();
        this.charactersCovered = r2;
        this.textPropType = r3;
    }

    public TextPropCollection(TextPropCollection r2) {
        this.textProps = new HashMap();
        this.charactersCovered = r2.charactersCovered;
        this.indentLevel = r2.indentLevel;
        this.maskSpecial = r2.maskSpecial;
        this.textPropType = r2.textPropType;
        r2.textProps.forEach(new $$Lambda$TextPropCollection$uUtn2YYMWCVPn8rEtmRwUGgzys(this));
    }

    private TextProp[] getPotentialProperties() {
        if (this.textPropType != TextPropType.paragraph) goto L6;
        return paragraphTextPropTypes;
    L6:
        return characterTextPropTypes;
    }

    static /* synthetic */ void lambda$getGenericProperties$2(Map r2, String r3, final TextProp r4) {
        Supplier r5 = (Supplier) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin")).put(r3, new $$Lambda$TextPropCollection$buTTz6CXlANGg_PxxeG4hgnOwCE(r4)), Supplier.class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ Object lambda$null$1(TextProp r0) {
        return r0;
    }

    private <T extends TextProp> T validatePropName(String r5) {
        TextProp[] r4 = getPotentialProperties();
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        T r2 = (T) r4[r1];
        if (r2.getName().equals(r5) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L9:
        throw new HSLFException("No TextProp with name " + r5 + " is defined to add from. Character and paragraphs have their own properties/names.");
    }

    public final void addProp(TextProp r2) {
        if (r2 == null) goto L6;
        String r0 = r2.getName();
        validatePropName(r0);
        this.textProps.put(r0, r2);
        return;
    L6:
        throw new HSLFException("TextProp must not be null");
    }

    public final <T extends TextProp> T addWithName(String r2) {
        T r0 = (T) findByName(r2);
        if (r0 == null) goto L5;
        return r0;
    L5:
        T r1 = (T) validatePropName(r2).copy();
        this.textProps.put(r2, r1);
        return r1;
    }

    public int buildTextPropList(int r12, byte[] r13, int r14) {
        TextProp[] r0 = getPotentialProperties();
        int r1 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L31;
        TextProp r5 = r0[r3];
        if ((r5.getMask() & r12) == 0) goto L30;
        int r6 = r14 + r4;
        if (r6 >= r13.length) goto L8;
        TextProp r7 = r5.copy();
        if (ZeusTransformUtils.instanceOf(r7, HSLFTabStopPropCollection.class) == false) goto L14;
        ((HSLFTabStopPropCollection) ZeusTransformUtils.preCheckCast(r7, HSLFTabStopPropCollection.class, "com.obric.memorydata.plugin")).parseProperty(r13, r6);
    L22:
        int r8 = 0;
    L24:
        if (ZeusTransformUtils.instanceOf(r7, BitMaskTextProp.class) == false) goto L27;
        ((BitMaskTextProp) ZeusTransformUtils.preCheckCast(r7, BitMaskTextProp.class, "com.obric.memorydata.plugin")).setValueWithMask(r8, r12);
    L29:
        r4 = r4 + r7.getSize();
        addProp(r7);
        goto L30
    L27:
        if (ZeusTransformUtils.instanceOf(r7, HSLFTabStopPropCollection.class) == true) goto L29;
        r7.setValue(r8);
        goto L29
    L14:
        if (r7.getSize() != 2) goto L17;
        r8 = LittleEndian.getShort(r13, r6);
        goto L24
    L17:
        if (r7.getSize() != 4) goto L20;
        r8 = LittleEndian.getInt(r13, r6);
        goto L24
    L20:
        if (r7.getSize() != 0) goto L22;
        this.maskSpecial = r5.getMask() | this.maskSpecial;
        goto L30
    L8:
        this.maskSpecial |= r5.getMask();
        return r4;
    L30:
        r3 = r3 + 1;
        goto L3
    L31:
        return r4;
    }

    public TextPropCollection copy() {
        return new TextPropCollection(this);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (getClass() == r4.getClass()) goto L11;
        return false;
    L11:
        TextPropCollection r5 = (TextPropCollection) ZeusTransformUtils.preCheckCast(r4, TextPropCollection.class, "com.obric.memorydata.plugin");
        if (r5.maskSpecial == this.maskSpecial) goto L14;
    L18:
        return false;
    L14:
        if (r5.indentLevel != this.indentLevel) goto L18;
        return this.textProps.equals(r5.textProps);
    }

    public final <T extends TextProp> T findByName(String r2) {
        return (T) ZeusTransformUtils.preCheckCast(this.textProps.get(r2), TextProp.class, "com.obric.memorydata.plugin");
    }

    public int getCharactersCovered() {
        return this.charactersCovered;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        final LinkedHashMap r0 = new LinkedHashMap();
        r0.put("charactersCovered", new $$Lambda$d0RAvOVRYyWnzwyxd2HODUVbmJw(this));
        r0.put("indentLevel", new $$Lambda$0ROA_ZmAHFfzk2moPI_A2pAzZ3Q(this));
        this.textProps.forEach(new $$Lambda$TextPropCollection$UABiY4gqyovBZJ6GGVXrofeyVE(r0));
        r0.put("maskSpecial", new $$Lambda$HQJpbX9Nke8boKbBus0AE6qaRMs(this));
        r0.put("textPropType", new $$Lambda$wKGnaCrd1jOiKAyd3BEo21ZKyeE(this));
        return Collections.unmodifiableMap(r0);
    }

    public short getIndentLevel() {
        return this.indentLevel;
    }

    public int getSpecialMask() {
        return this.maskSpecial;
    }

    public List<TextProp> getTextPropList() {
        ArrayList r0 = new ArrayList();
        TextProp[] r1 = getPotentialProperties();
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        TextProp r4 = r1[r3];
        TextProp r5 = (TextProp) ZeusTransformUtils.preCheckCast(this.textProps.get(r4.getName()), TextProp.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        r0.add(r5);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        return r0;
    }

    public final TextPropType getTextPropType() {
        return this.textPropType;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.charactersCovered), Integer.valueOf(this.maskSpecial), Short.valueOf(this.indentLevel), this.textProps});
    }

    public /* synthetic */ void lambda$new$0$TextPropCollection(String r1, TextProp r2) {
        TextProp r0 = (TextProp) ZeusTransformUtils.preCheckCast(this.textProps.put(r1, r2.copy()), TextProp.class, "com.obric.memorydata.plugin");
    }

    public final <T extends TextProp> T removeByName(String r2) {
        return (T) ZeusTransformUtils.preCheckCast(this.textProps.remove(r2), TextProp.class, "com.obric.memorydata.plugin");
    }

    public void setIndentLevel(short r3) {
        if (this.textPropType == TextPropType.character) goto L7;
        this.indentLevel = r3;
        return;
    L7:
        throw new RuntimeException("trying to set an indent on a character collection.");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("  chars covered: ").append(getCharactersCovered());
        r0.append("  special mask flags: 0x").append(HexDump.toHex(getSpecialMask())).append("\n");
        if (this.textPropType != TextPropType.paragraph) goto L5;
        r0.append("  indent level: ").append(getIndentLevel()).append("\n");
    L5:
        Iterator<TextProp> r1 = getTextPropList().iterator();
    L6:
        int r4 = 0;
        if (r1.hasNext() == false) goto L16;
        TextProp r3 = (TextProp) ZeusTransformUtils.preCheckCast(r1.next(), TextProp.class, "com.obric.memorydata.plugin");
        r0.append("    ");
        r0.append(r3.toString());
        r0.append("\n");
        if (ZeusTransformUtils.instanceOf(r3, BitMaskTextProp.class) == false) goto L6;
        BitMaskTextProp r5 = (BitMaskTextProp) ZeusTransformUtils.preCheckCast(r3, BitMaskTextProp.class, "com.obric.memorydata.plugin");
        String[] r6 = r5.getSubPropNames();
        int r7 = r6.length;
        int r8 = 0;
    L11:
        if (r4 >= r7) goto L6;
        String r9 = r6[r4];
        if (r5.getSubPropMatches()[r8] == false) goto L15;
        r0.append("          ").append(r9).append(" = ").append(r5.getSubValue(r8)).append("\n");
    L15:
        r8 = r8 + 1;
        r4 = r4 + 1;
        goto L11
    L16:
        r0.append("  bytes that would be written: \n");
        UnsynchronizedByteArrayOutputStream r2 = new UnsynchronizedByteArrayOutputStream();     // Catch: IOException -> L19
        writeOut(r2);     // Catch: IOException -> L19
        r0.append(HexDump.dump(r2.toByteArray(), 0, 0));     // Catch: IOException -> L19
    L22:
        return r0.toString();
    L19:
        e = move-exception;
        LOG.atError().a(e).a("can't dump TextPropCollection");
        goto L22
    }

    public void updateTextSize(int r1) {
        this.charactersCovered = r1;
    }

    public void writeOut(OutputStream r2) {
        writeOut(r2, false);
    }

    public void writeOut(OutputStream r5, boolean r6) {
        if (r6 == true) goto L5;
        Record.writeLittleEndian(this.charactersCovered, r5);
    L5:
        if (this.textPropType != TextPropType.paragraph) goto L9;
        short r7 = this.indentLevel;
        if (r7 <= (-1)) goto L9;
        Record.writeLittleEndian(r7, r5);
    L9:
        int r8 = this.maskSpecial;
        Iterator<TextProp> r0 = this.textProps.values().iterator();
    L11:
        if (r0.hasNext() == false) goto L13;
        r8 = r8 | ((TextProp) ZeusTransformUtils.preCheckCast(r0.next(), TextProp.class, "com.obric.memorydata.plugin")).getWriteMask();
        goto L11
    L13:
        Record.writeLittleEndian(r8, r5);
        Iterator<TextProp> r4 = getTextPropList().iterator();
    L15:
        if (r4.hasNext() == false) goto L30;
        TextProp r9 = (TextProp) ZeusTransformUtils.preCheckCast(r4.next(), TextProp.class, "com.obric.memorydata.plugin");
        int r1 = r9.getValue();
        if (ZeusTransformUtils.instanceOf(r9, BitMaskTextProp.class) == false) goto L22;
        if (r9.getWriteMask() == 0) goto L15;
    L22:
        if (r9.getSize() == 2) goto L23;
        if (r9.getSize() == 4) goto L26;
        if (ZeusTransformUtils.instanceOf(r9, HSLFTabStopPropCollection.class) == false) goto L15;
        ((HSLFTabStopPropCollection) ZeusTransformUtils.preCheckCast(r9, HSLFTabStopPropCollection.class, "com.obric.memorydata.plugin")).writeProperty(r5);
        goto L15
    L26:
        Record.writeLittleEndian(r1, r5);
        goto L15
    L23:
        Record.writeLittleEndian((short) r1, r5);
        goto L15
    }
}
