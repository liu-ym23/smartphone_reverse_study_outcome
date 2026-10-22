package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes7.dex */
final class PlainCellCache {
    private Map<Loc, PlainValueCellCacheEntry> _plainValueEntriesByLoc;

    public static final class Loc {
        private final long _bookSheetColumn;
        private final int _rowIndex;

        public Loc(int r1, int r2, int r3, int r4) {
            this._bookSheetColumn = toBookSheetColumn(r1, r2, r4);
            this._rowIndex = r3;
        }

        public static long toBookSheetColumn(int r5, int r6, int r7) {
            return (((((long) r5) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 48) + ((((long) r6) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 32)) + ((((long) r7) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 0);
        }

        public boolean equals(Object r6) {
            if (ZeusTransformUtils.instanceOf(r6, Loc.class) == true) goto L5;
            return false;
        L5:
            Loc r7 = (Loc) ZeusTransformUtils.preCheckCast(r6, Loc.class, "com.obric.memorydata.plugin");
            if (this._bookSheetColumn == r7._bookSheetColumn) goto L8;
            return false;
        L8:
            if (this._rowIndex != r7._rowIndex) goto L12;
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            long r0 = this._bookSheetColumn;
            return ((int) (r0 ^ (r0 >>> 32))) + (this._rowIndex * 17);
        }
    }

    public PlainValueCellCacheEntry get(Loc r2) {
        return (PlainValueCellCacheEntry) ZeusTransformUtils.preCheckCast(this._plainValueEntriesByLoc.get(r2), PlainValueCellCacheEntry.class, "com.obric.memorydata.plugin");
    }

    public void put(Loc r1, PlainValueCellCacheEntry r2) {
        this._plainValueEntriesByLoc.put(r1, r2);
    }
}
