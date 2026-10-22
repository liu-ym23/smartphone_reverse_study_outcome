package org.apache.poi.ss.usermodel;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes7.dex */
public interface Workbook extends Closeable, Iterable<Sheet> {
    int getActiveSheetIndex();

    List<? extends PictureData> getAllPictures();

    Font getFontAt(int r1);

    int getNumberOfSheets();

    Sheet getSheet(String r1);

    Sheet getSheetAt(int r1);

    @Override // java.lang.Iterable
    default Iterator<Sheet> iterator() {
        return sheetIterator();
    }

    Iterator<Sheet> sheetIterator();

    @Override // java.lang.Iterable
    default Spliterator<Sheet> spliterator() {
        return Spliterators.spliterator(sheetIterator(), getNumberOfSheets(), 0);
    }
}
