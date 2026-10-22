package org.apache.poi.sl.draw.geom;

import java.awt.geom.Rectangle2D;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public class Context {
    private static final Pattern DOUBLE_PATTERN = null;
    private final Rectangle2D _anchor;

    static {
        DOUBLE_PATTERN = Pattern.compile("[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.(\\p{Digit}+)([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
    }

    Rectangle2D getShapeAnchor() {
        return this._anchor;
    }
}
