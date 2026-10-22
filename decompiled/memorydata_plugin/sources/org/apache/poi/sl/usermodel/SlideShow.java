package org.apache.poi.sl.usermodel;

import java.io.Closeable;
import java.util.List;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: classes7.dex */
public interface SlideShow<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Closeable {
    List<? extends Slide<S, P>> getSlides();
}
