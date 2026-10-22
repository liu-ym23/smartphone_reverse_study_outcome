package org.apache.poi.hemf.record.emfplus;

import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusFont {

    public static class EmfPlusFont implements HemfPlusObject.EmfPlusObjectData {
        private static final BitField BOLD = null;
        private static final BitField ITALIC = null;
        private static final BitField STRIKEOUT = null;
        private static final BitField UNDERLINE = null;
        private double emSize;
        private String family;
        private final HemfPlusHeader.EmfPlusGraphicsVersion graphicsVersion;
        private HemfPlusDraw.EmfPlusUnitType sizeUnit;
        private int styleFlags;

        static {
            BOLD = BitFieldFactory.getInstance(1);
            ITALIC = BitFieldFactory.getInstance(2);
            UNDERLINE = BitFieldFactory.getInstance(4);
            STRIKEOUT = BitFieldFactory.getInstance(8);
        }

        public EmfPlusFont() {
            this.graphicsVersion = new HemfPlusHeader.EmfPlusGraphicsVersion();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("graphicsVersion", new $$Lambda$HemfPlusFont$EmfPlusFont$qESfhMjrtQs807a_QQgStGZd4U4(this), "emSize", new $$Lambda$HemfPlusFont$EmfPlusFont$UuF37oJxO3QbssbWyWgFVOLczIM(this), "sizeUnit", new $$Lambda$HemfPlusFont$EmfPlusFont$LsC41CLbL1FkN8lVIU184IL8Nc(this), "styleFlags", new $$Lambda$HemfPlusFont$EmfPlusFont$vzXsq7ginelYgmL3OHwCgxolIFE(this), "family", new $$Lambda$HemfPlusFont$EmfPlusFont$u_eEyoaay2pQH8fcZ2etS2r6tCA(this));
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
            return getGenericRecordType();
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public HemfPlusObject.EmfPlusObjectType getGenericRecordType() {
            return HemfPlusObject.EmfPlusObjectType.FONT;
        }

        @Override // org.apache.poi.hemf.record.emfplus.HemfPlusObject.EmfPlusObjectData
        public HemfPlusHeader.EmfPlusGraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HemfPlusFont$EmfPlusFont() {
            return this.graphicsVersion;
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HemfPlusFont$EmfPlusFont() {
            return Double.valueOf(this.emSize);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HemfPlusFont$EmfPlusFont() {
            return this.sizeUnit;
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HemfPlusFont$EmfPlusFont() {
            return Integer.valueOf(this.styleFlags);
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HemfPlusFont$EmfPlusFont() {
            return this.family;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }
}
