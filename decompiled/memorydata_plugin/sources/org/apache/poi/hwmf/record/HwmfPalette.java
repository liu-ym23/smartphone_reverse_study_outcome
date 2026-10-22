package org.apache.poi.hwmf.record;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfPalette {

    public static class PaletteEntry implements GenericRecord {
        private static final int[] FLAGS_MASKS = null;
        private static final String[] FLAGS_NAMES = null;
        private static final BitField PC_EXPLICIT = null;
        private static final BitField PC_NOCOLLAPSE = null;
        private static final BitField PC_RESERVED = null;
        private Color colorRef;
        private int values;

        static {
            PC_RESERVED = BitFieldFactory.getInstance(1);
            PC_EXPLICIT = BitFieldFactory.getInstance(2);
            PC_NOCOLLAPSE = BitFieldFactory.getInstance(4);
            FLAGS_MASKS = new int[]{1, 2, 4};
            FLAGS_NAMES = new String[]{"RESERVED", "EXPLICIT", "NOCOLLAPSE"};
        }

        public PaletteEntry() {
            this.values = PC_RESERVED.set(0);
            this.colorRef = Color.BLACK;
        }

        public PaletteEntry(PaletteEntry r2) {
            this.values = r2.values;
            this.colorRef = r2.colorRef;
        }

        public Color getColorRef() {
            return this.colorRef;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getBitsAsString(new $$Lambda$HwmfPalette$PaletteEntry$5jJCalANtIVAfSOv2QFmKqd7HCs(this), FLAGS_MASKS, FLAGS_NAMES), TypedValues.Custom.S_COLOR, new $$Lambda$N0iSxR68HUIVyTLhY0xiZjQFiY0(this));
        }

        public /* synthetic */ Number lambda$getGenericProperties$0$HwmfPalette$PaletteEntry() {
            return Integer.valueOf(this.values);
        }
    }

    public static class WmfAnimatePalette extends WmfPaletteParent {
        public WmfAnimatePalette() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.animatePalette;
        }
    }

    public static class WmfCreatePalette extends WmfPaletteParent {
        public WmfCreatePalette() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.createPalette;
        }
    }

    public static abstract class WmfPaletteParent implements HwmfRecord {
        protected final List<PaletteEntry> palette;
        protected int start;

        public WmfPaletteParent() {
            this.palette = new ArrayList();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("paletteStart", new $$Lambda$VgymiDfUBEFIeQ3gAEp3YLuQmjQ(this), "pallete", new $$Lambda$KQd80TWeNxkFw231gX3YgSlW6hA(this));
        }

        List<PaletteEntry> getPaletteCopy() {
            ArrayList r0 = new ArrayList();
            Iterator<PaletteEntry> r4 = this.palette.iterator();
        L4:
            if (r4.hasNext() == false) goto L6;
            r0.add(new PaletteEntry((PaletteEntry) ZeusTransformUtils.preCheckCast(r4.next(), PaletteEntry.class, "com.obric.memorydata.plugin")));
            goto L4
        L6:
            return r0;
        }

        int getPaletteStart() {
            return this.start;
        }
    }

    public static class WmfRealizePalette implements HwmfRecord {
        public WmfRealizePalette() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return null;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.realizePalette;
        }
    }

    public static class WmfResizePalette implements HwmfRecord {
        protected int numberOfEntries;

        public WmfResizePalette() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("numberOfEntries", new $$Lambda$kwUyNA856CTQ081qKKElIbpQUY(this));
        }

        public int getNumberOfEntries() {
            return this.numberOfEntries;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.resizePalette;
        }
    }

    public static class WmfSelectPalette implements HwmfRecord {
        protected int paletteIndex;

        public WmfSelectPalette() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("paletteIndex", new $$Lambda$4WqsfTDNAmwqdeOlAios6Bflz0(this));
        }

        public int getPaletteIndex() {
            return this.paletteIndex;
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.selectPalette;
        }
    }

    public static class WmfSetPaletteEntries extends WmfPaletteParent {
        public WmfSetPaletteEntries() {
        }

        @Override // org.apache.poi.hwmf.record.HwmfRecord
        public HwmfRecordType getWmfRecordType() {
            return HwmfRecordType.setPalEntries;
        }
    }
}
