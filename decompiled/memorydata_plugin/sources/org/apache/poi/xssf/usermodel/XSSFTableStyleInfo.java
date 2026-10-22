package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.TableStyle;
import org.apache.poi.ss.usermodel.TableStyleInfo;
import org.apache.poi.xssf.model.StylesTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fe;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFTableStyleInfo implements TableStyleInfo {
    private boolean columnStripes;
    private boolean firstColumn;
    private boolean lastColumn;
    private boolean rowStripes;
    private TableStyle style;
    private final fe styleInfo;
    private final StylesTable stylesTable;

    public XSSFTableStyleInfo(StylesTable r3, fe r4) {
        fe r5 = (fe) ZeusTransformUtils.wrapperContextForParams(r4, fe.class, "com.obric.memorydata.plugin");
        this.columnStripes = r5.getShowColumnStripes();
        this.rowStripes = r5.getShowRowStripes();
        this.firstColumn = r5.getShowFirstColumn();
        this.lastColumn = r5.getShowLastColumn();
        this.style = r3.getTableStyle(r5.getName());
        this.stylesTable = r3;
        this.styleInfo = r5;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public TableStyle getStyle() {
        return this.style;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowColumnStripes() {
        return this.columnStripes;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowFirstColumn() {
        return this.firstColumn;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowLastColumn() {
        return this.lastColumn;
    }

    @Override // org.apache.poi.ss.usermodel.TableStyleInfo
    public boolean isShowRowStripes() {
        return this.rowStripes;
    }
}
