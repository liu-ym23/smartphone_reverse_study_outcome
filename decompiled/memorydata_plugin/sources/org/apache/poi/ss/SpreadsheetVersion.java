package org.apache.poi.ss;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public final enum SpreadsheetVersion extends Enum<SpreadsheetVersion> {
    private static final /* synthetic */ SpreadsheetVersion[] $VALUES = null;
    public static final SpreadsheetVersion EXCEL2007 = null;
    public static final SpreadsheetVersion EXCEL97 = null;
    private final int _maxCellStyles;
    private final int _maxColumns;
    private final int _maxCondFormats;
    private final int _maxFunctionArgs;
    private final int _maxRows;
    private final int _maxTextLength;

    static {
        SpreadsheetVersion r9 = new SpreadsheetVersion("EXCEL97", 0, 65536, 256, 30, 3, 4000, 32767);
        EXCEL97 = r9;
        SpreadsheetVersion r0 = new SpreadsheetVersion("EXCEL2007", 1, 1048576, 16384, 255, Integer.MAX_VALUE, 64000, 32767);
        EXCEL2007 = r0;
        $VALUES = new SpreadsheetVersion[]{r9, r0};
    }

    private SpreadsheetVersion(String r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        super(r1, r2);
        this._maxRows = r3;
        this._maxColumns = r4;
        this._maxFunctionArgs = r5;
        this._maxCondFormats = r6;
        this._maxCellStyles = r7;
        this._maxTextLength = r8;
    }

    public static SpreadsheetVersion valueOf(String r2) {
        return (SpreadsheetVersion) ZeusTransformUtils.preCheckCast(Enum.valueOf(SpreadsheetVersion.class, r2), SpreadsheetVersion.class, "com.obric.memorydata.plugin");
    }

    public static SpreadsheetVersion[] values() {
        return (SpreadsheetVersion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SpreadsheetVersion[].class, "com.obric.memorydata.plugin");
    }

    public int getLastColumnIndex() {
        return this._maxColumns - 1;
    }

    public String getLastColumnName() {
        return CellReference.convertNumToColString(getLastColumnIndex());
    }

    public int getLastRowIndex() {
        return this._maxRows - 1;
    }

    public int getMaxCellStyles() {
        return this._maxCellStyles;
    }

    public int getMaxColumns() {
        return this._maxColumns;
    }

    public int getMaxConditionalFormats() {
        return this._maxCondFormats;
    }

    public int getMaxFunctionArgs() {
        return this._maxFunctionArgs;
    }

    public int getMaxRows() {
        return this._maxRows;
    }

    public int getMaxTextLength() {
        return this._maxTextLength;
    }
}
