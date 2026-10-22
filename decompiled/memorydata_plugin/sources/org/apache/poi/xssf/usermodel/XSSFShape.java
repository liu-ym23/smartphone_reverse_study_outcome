package org.apache.poi.xssf.usermodel;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XSSFShape {
    protected XSSFAnchor anchor;
    protected XSSFDrawing drawing;

    public XSSFShape() {
    }

    public XSSFDrawing getDrawing() {
        return this.drawing;
    }
}
