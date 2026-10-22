package org.apache.poi.hssf.record;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.hssf.record.cf.BorderFormatting;
import org.apache.poi.hssf.record.cf.FontFormatting;
import org.apache.poi.hssf.record.cf.PatternFormatting;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public abstract class CFRuleBase extends StandardRecord {
    protected static final c LOG = null;
    static final BitField align = null;
    static final BitField alignHor = null;
    static final BitField alignIndent = null;
    static final BitField alignJustLast = null;
    static final BitField alignRot = null;
    static final BitField alignShrin = null;
    static final BitField alignTextDir = null;
    static final BitField alignVer = null;
    static final BitField alignWrap = null;
    static final BitField bord = null;
    static final BitField bordBlTr = null;
    static final BitField bordBot = null;
    static final BitField bordLeft = null;
    static final BitField bordRight = null;
    static final BitField bordTlBr = null;
    static final BitField bordTop = null;
    static final BitField fmtBlockBits = null;
    static final BitField font = null;
    static final BitField mergeCell = null;
    static final BitField modificationBits = null;
    static final BitField notUsed2 = null;
    static final BitField patt = null;
    static final BitField pattBgCol = null;
    static final BitField pattCol = null;
    static final BitField pattStyle = null;
    static final BitField prot = null;
    static final BitField protHidden = null;
    static final BitField protLocked = null;
    static final BitField undocumented = null;
    protected BorderFormatting _borderFormatting;
    protected FontFormatting _fontFormatting;
    protected PatternFormatting _patternFormatting;
    private byte comparison_operator;
    private byte condition_type;
    protected short formatting_not_used;
    protected int formatting_options;
    private Formula formula1;
    private Formula formula2;

    static {
        LOG = b.a(CFRuleBase.class);
        modificationBits = bf(4194303);
        alignHor = bf(1);
        alignVer = bf(2);
        alignWrap = bf(4);
        alignRot = bf(8);
        alignJustLast = bf(16);
        alignIndent = bf(32);
        alignShrin = bf(64);
        mergeCell = bf(128);
        protLocked = bf(256);
        protHidden = bf(512);
        bordLeft = bf(1024);
        bordRight = bf(2048);
        bordTop = bf(4096);
        bordBot = bf(8192);
        bordTlBr = bf(16384);
        bordBlTr = bf(32768);
        pattStyle = bf(65536);
        pattCol = bf(131072);
        pattBgCol = bf(262144);
        notUsed2 = bf(3670016);
        undocumented = bf(62914560);
        fmtBlockBits = bf(2080374784);
        font = bf(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        align = bf(134217728);
        bord = bf(SQLiteDatabase.CREATE_IF_NECESSARY);
        patt = bf(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        prot = bf(1073741824);
        alignTextDir = bf(Integer.MIN_VALUE);
    }

    public CFRuleBase() {
    }

    private static BitField bf(int r0) {
        return BitFieldFactory.getInstance(r0);
    }

    public static int getFormulaSize(Formula r0) {
        return r0.getEncodedTokenSize();
    }

    private boolean getOptionFlag(BitField r1) {
        return r1.isSet(this.formatting_options);
    }

    public boolean containsBorderFormattingBlock() {
        return getOptionFlag(bord);
    }

    public boolean containsFontFormattingBlock() {
        return getOptionFlag(font);
    }

    public boolean containsPatternFormattingBlock() {
        return getOptionFlag(patt);
    }

    public BorderFormatting getBorderFormatting() {
        if (containsBorderFormattingBlock() == true) goto L5;
        return null;
    L5:
        return this._borderFormatting;
    }

    public byte getComparisonOperation() {
        return this.comparison_operator;
    }

    public byte getConditionType() {
        return this.condition_type;
    }

    public FontFormatting getFontFormatting() {
        if (containsFontFormattingBlock() == true) goto L5;
        return null;
    L5:
        return this._fontFormatting;
    }

    public int getFormattingBlockSize() {
        int r1 = 0;
        if (containsFontFormattingBlock() == false) goto L5;
        int r0 = this._fontFormatting.getRawRecord().length;
    L6:
        int r2 = r0 + 6;
        if (containsBorderFormattingBlock() == false) goto L9;
        int r3 = 8;
    L10:
        int r4 = r2 + r3;
        if (containsPatternFormattingBlock() == false) goto L14;
        r1 = 4;
    L14:
        return r4 + r1;
    L9:
        r3 = 0;
        goto L10
    L5:
        r0 = 0;
        goto L6
    }

    public Formula getFormula1() {
        return this.formula1;
    }

    public Formula getFormula2() {
        return this.formula2;
    }

    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("conditionType", new $$Lambda$J6bNLVo7hRKnsi9BV5Ye_hLhSKw(this), "comparisonOperation", new $$Lambda$2yHcU33WBYReJpfBnSffEE8xhr0(this), "formattingOptions", new $$Lambda$GKuE0pqyyyghDQCda6ZChKw9Yc(this), "formattingNotUsed", new $$Lambda$CFRuleBase$GeDUpTG3jbnna0U7CPQsC5eAB0(this), "fontFormatting", new $$Lambda$rhlnwC1yDS_eRnVTWk9InnAaGOs(this), "borderFormatting", new $$Lambda$QGfMIuOLbeN0p0OBwpmf2vZwdN4(this), "patternFormatting", new $$Lambda$eDSSijJ8XPcKtPYPYdd1GiRqnwo(this), "formula1", new $$Lambda$BRo6uqFa9jppPg0o8PVNUIH2zGo(this), "formula2", new $$Lambda$LlEZn59Nv0N9KfJaozZjDH4hWoY(this));
    }

    public int getOptions() {
        return this.formatting_options;
    }

    public Ptg[] getParsedExpression1() {
        return this.formula1.getTokens();
    }

    public Ptg[] getParsedExpression2() {
        return Formula.getTokens(this.formula2);
    }

    public PatternFormatting getPatternFormatting() {
        if (containsPatternFormattingBlock() == true) goto L5;
        return null;
    L5:
        return this._patternFormatting;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$CFRuleBase() {
        return Short.valueOf(this.formatting_not_used);
    }

    public int readFormatOptions(RecordInputStream r3) {
        this.formatting_options = r3.readInt();
        this.formatting_not_used = r3.readShort();
        int r1 = 6;
        if (containsFontFormattingBlock() == false) goto L6;
        FontFormatting r0 = new FontFormatting(r3);
        this._fontFormatting = r0;
        r1 = 6 + r0.getDataLength();
    L6:
        if (containsBorderFormattingBlock() == false) goto L9;
        BorderFormatting r2 = new BorderFormatting(r3);
        this._borderFormatting = r2;
        r1 = r1 + r2.getDataLength();
    L9:
        if (containsPatternFormattingBlock() == false) goto L12;
        PatternFormatting r4 = new PatternFormatting(r3);
        this._patternFormatting = r4;
        return r1 + r4.getDataLength();
    L12:
        return r1;
    }

    public void setComparisonOperation(byte r2) {
        if (r2 < 0) goto L8;
        if (r2 > 8) goto L8;
        this.comparison_operator = r2;
        return;
    L8:
        throw new IllegalArgumentException("Valid operators are only in the range 0 to 8");
    }

    public void setConditionType(byte r2) {
        if (ZeusTransformUtils.instanceOf(this, CFRuleRecord.class) == true) goto L5;
    L11:
        this.condition_type = r2;
        return;
    L5:
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L11;
        throw new IllegalArgumentException("CFRuleRecord only accepts Value-Is and Formula types");
    }

    public void setFormula1(Formula r1) {
        this.formula1 = r1;
    }

    public void setFormula2(Formula r1) {
        this.formula2 = r1;
    }
}
