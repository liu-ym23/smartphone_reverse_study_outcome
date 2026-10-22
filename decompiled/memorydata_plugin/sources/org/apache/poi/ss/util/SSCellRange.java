package org.apache.poi.ss.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellRange;

/* JADX INFO: loaded from: classes7.dex */
public final class SSCellRange<K extends Cell> implements CellRange<K> {
    private final int _firstColumn;
    private final int _firstRow;
    private final K[] _flattenedArray;
    private final int _height;
    private final int _width;

    private SSCellRange(int r1, int r2, int r3, int r4, K[] r5) {
        this._firstRow = r1;
        this._firstColumn = r2;
        this._height = r3;
        this._width = r4;
        this._flattenedArray = (K[]) ((Cell[]) ZeusTransformUtils.preCheckCast(r5.clone(), Cell[].class, "com.obric.memorydata.plugin"));
    }

    public static <B extends Cell> SSCellRange<B> create(int r6, int r7, int r8, int r9, List<B> r10, Class<B> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        int r0 = r12.size();
        if ((r8 * r9) != r0) goto L7;
        Cell[] r5 = (Cell[]) ZeusTransformUtils.preCheckCast((Cell[]) ZeusTransformUtils.preCheckCast(Array.newInstance(r11, r0), Cell[].class, "com.obric.memorydata.plugin"), Cell[].class, "com.obric.memorydata.plugin");
        r12.toArray(r5);
        return new SSCellRange(r6, r7, r8, r9, r5);
    L7:
        throw new IllegalArgumentException("Array size mismatch.");
    }

    @Override // org.apache.poi.ss.usermodel.CellRange, java.lang.Iterable
    public Iterator<K> iterator() {
        return Stream.of(this._flattenedArray).iterator();
    }

    @Override // java.lang.Iterable
    public Spliterator<K> spliterator() {
        return Stream.of(this._flattenedArray).spliterator();
    }
}
