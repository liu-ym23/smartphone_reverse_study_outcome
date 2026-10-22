package org.apache.poi.sl.usermodel;

import java.util.List;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: classes7.dex */
public interface ShapeContainer<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Iterable<S> {
    List<S> getShapes();
}
