package org.apache.poi.xssf.binary;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.zaxxer.sparsebits.SparseBitSet;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.poi.ss.util.CellAddress;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFBHyperlinksTable {
    private static final SparseBitSet RECORDS = null;

    /* JADX INFO: renamed from: org.apache.poi.xssf.binary.XSSFBHyperlinksTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class TopLeftCellAddressComparator implements Serializable, Comparator<CellAddress> {
        private static final long serialVersionUID = 1;

        private TopLeftCellAddressComparator() {
        }

        /* synthetic */ TopLeftCellAddressComparator(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.Comparator
        public /* synthetic */ int compare(CellAddress r3, CellAddress r4) {
            return compare2((CellAddress) ZeusTransformUtils.preCheckCast(r3, CellAddress.class, "com.obric.memorydata.plugin"), (CellAddress) ZeusTransformUtils.preCheckCast(r4, CellAddress.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(CellAddress r4, CellAddress r5) {
            if (r4.getRow() >= r5.getRow()) goto L6;
            return -1;
        L6:
            if (r4.getRow() <= r5.getRow()) goto L9;
            return 1;
        L9:
            if (r4.getColumn() >= r5.getColumn()) goto L12;
            return -1;
        L12:
            if (r4.getColumn() <= r5.getColumn()) goto L14;
            return 1;
        L14:
            return 0;
        }
    }

    static {
        SparseBitSet r0 = new SparseBitSet();
        RECORDS = r0;
        r0.set(XSSFBRecordType.BrtHLink.getId());
    }
}
