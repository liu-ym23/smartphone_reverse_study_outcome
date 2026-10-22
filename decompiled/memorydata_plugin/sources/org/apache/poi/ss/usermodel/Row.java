package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes7.dex */
public interface Row extends Iterable<Cell> {

    public static final enum MissingCellPolicy extends Enum<MissingCellPolicy> {
        private static final /* synthetic */ MissingCellPolicy[] $VALUES = null;
        public static final MissingCellPolicy CREATE_NULL_AS_BLANK = null;
        public static final MissingCellPolicy RETURN_BLANK_AS_NULL = null;
        public static final MissingCellPolicy RETURN_NULL_AND_BLANK = null;

        static {
            MissingCellPolicy r0 = new MissingCellPolicy("RETURN_NULL_AND_BLANK", 0);
            RETURN_NULL_AND_BLANK = r0;
            MissingCellPolicy r1 = new MissingCellPolicy("RETURN_BLANK_AS_NULL", 1);
            RETURN_BLANK_AS_NULL = r1;
            MissingCellPolicy r3 = new MissingCellPolicy("CREATE_NULL_AS_BLANK", 2);
            CREATE_NULL_AS_BLANK = r3;
            $VALUES = new MissingCellPolicy[]{r0, r1, r3};
        }

        private MissingCellPolicy(String r1, int r2) {
            super(r1, r2);
        }

        public static MissingCellPolicy valueOf(String r2) {
            return (MissingCellPolicy) ZeusTransformUtils.preCheckCast(Enum.valueOf(MissingCellPolicy.class, r2), MissingCellPolicy.class, "com.obric.memorydata.plugin");
        }

        public static MissingCellPolicy[] values() {
            return (MissingCellPolicy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MissingCellPolicy[].class, "com.obric.memorydata.plugin");
        }
    }

    Iterator<Cell> cellIterator();

    Cell createCell(int r1);

    Cell getCell(int r1);

    Cell getCell(int r1, MissingCellPolicy r2);

    short getFirstCellNum();

    short getLastCellNum();

    int getPhysicalNumberOfCells();

    int getRowNum();

    Sheet getSheet();

    @Override // java.lang.Iterable
    default Iterator<Cell> iterator() {
        return cellIterator();
    }

    @Override // java.lang.Iterable
    default Spliterator<Cell> spliterator() {
        return Spliterators.spliterator(cellIterator(), getPhysicalNumberOfCells(), 0);
    }
}
