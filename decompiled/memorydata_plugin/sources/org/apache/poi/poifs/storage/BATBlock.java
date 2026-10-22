package org.apache.poi.poifs.storage;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.poifs.common.POIFSBigBlockSize;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class BATBlock {
    private boolean _has_free_sectors;
    private int[] _values;
    private POIFSBigBlockSize bigBlockSize;
    private int ourBlockIndex;

    /* JADX INFO: renamed from: org.apache.poi.poifs.storage.BATBlock$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class BATBlockAndIndex {
        private final BATBlock block;
        private final int index;

        private BATBlockAndIndex(int r1, BATBlock r2) {
            this.index = r1;
            this.block = r2;
        }

        /* synthetic */ BATBlockAndIndex(int r1, BATBlock r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        public BATBlock getBlock() {
            return this.block;
        }

        public int getIndex() {
            return this.index;
        }
    }

    private BATBlock(POIFSBigBlockSize r2) {
        this.bigBlockSize = r2;
        int[] r3 = new int[r2.getBATEntriesPerBlock()];
        this._values = r3;
        this._has_free_sectors = true;
        Arrays.fill(r3, -1);
    }

    public static long calculateMaximumSize(POIFSBigBlockSize r4, int r5) {
        return ((((long) r5) * ((long) r4.getBATEntriesPerBlock())) + 1) * ((long) r4.getBigBlockSize());
    }

    public static long calculateMaximumSize(HeaderBlock r2) {
        return calculateMaximumSize(r2.getBigBlockSize(), r2.getBATCount());
    }

    public static BATBlock createBATBlock(POIFSBigBlockSize r4, ByteBuffer r5) {
        BATBlock r0 = new BATBlock(r4);
        byte[] r6 = new byte[4];
        int r1 = 0;
    L4:
        if (r1 >= r0._values.length) goto L6;
        r5.get(r6);
        r0._values[r1] = LittleEndian.getInt(r6);
        r1 = r1 + 1;
        goto L4
    L6:
        r0.recomputeFree();
        return r0;
    }

    public static BATBlock createEmptyBATBlock(POIFSBigBlockSize r2, boolean r3) {
        BATBlock r0 = new BATBlock(r2);
        if (r3 == false) goto L5;
        int r4 = r2.getXBATEntriesPerBlock();
        r0._values[r4] = -2;
    L5:
        return r0;
    }

    public static BATBlockAndIndex getBATBlockAndIndex(int r2, HeaderBlock r3, List<BATBlock> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r6 = r3.getBigBlockSize().getBATEntriesPerBlock();
        int r0 = r2 / r6;
        return new BATBlockAndIndex(r2 % r6, (BATBlock) ZeusTransformUtils.preCheckCast(r5.get(r0), BATBlock.class, "com.obric.memorydata.plugin"), null);
    }

    public static BATBlockAndIndex getSBATBlockAndIndex(int r2, HeaderBlock r3, List<BATBlock> r4) {
        return getBATBlockAndIndex(r2, r3, (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin"));
    }

    private void recomputeFree() {
        int[] r0 = this._values;
        int r1 = r0.length;
        boolean r2 = false;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r0[r3] == (-1)) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        r2 = true;
    L8:
        this._has_free_sectors = r2;
    }

    public int getValueAt(int r4) {
        int[] r0 = this._values;
        if (r4 >= r0.length) goto L7;
        return r0[r4];
    L7:
        throw new ArrayIndexOutOfBoundsException("Unable to fetch offset " + r4 + " as the BAT only contains " + this._values.length + " entries");
    }

    public boolean hasFreeSectors() {
        return this._has_free_sectors;
    }

    public void setOurBlockIndex(int r1) {
        this.ourBlockIndex = r1;
    }

    public void setValueAt(int r3, int r4) {
        int[] r0 = this._values;
        int r1 = r0[r3];
        r0[r3] = r4;
        if (r4 != (-1)) goto L6;
        this._has_free_sectors = true;
        return;
    L6:
        if (r1 != (-1)) goto L9;
        recomputeFree();
        return;
    }
}
