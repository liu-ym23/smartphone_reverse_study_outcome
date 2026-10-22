package org.apache.poi.ss.usermodel;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;

/* JADX INFO: loaded from: classes7.dex */
public interface CellRange<C extends Cell> extends Iterable<C> {
    @Override // java.lang.Iterable
    Iterator<C> iterator();
}
