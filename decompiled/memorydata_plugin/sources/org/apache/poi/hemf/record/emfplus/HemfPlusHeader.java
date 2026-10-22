package org.apache.poi.hemf.record.emfplus;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: loaded from: classes7.dex */
public class HemfPlusHeader implements HemfPlusRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int[] EMFFLAGS_MASK = null;
    private static final String[] EMFFLAGS_NAMES = null;
    private static final int[] FLAGS_MASK = null;
    private static final String[] FLAGS_NAMES = null;
    private long emfPlusFlags;
    private int flags;
    private long logicalDpiX;
    private long logicalDpiY;
    private final EmfPlusGraphicsVersion version;

    public static class EmfPlusGraphicsVersion implements GenericRecord {
        private static final BitField GRAPHICS_VERSION = null;
        private static final BitField METAFILE_SIGNATURE = null;
        private GraphicsVersion graphicsVersion;
        private int metafileSignature;

        static {
            METAFILE_SIGNATURE = BitFieldFactory.getInstance(-4096);
            GRAPHICS_VERSION = BitFieldFactory.getInstance(4095);
        }

        public EmfPlusGraphicsVersion() {
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("metafileSignature", new $$Lambda$UyxmiBjuOBcBwlfSvoHtWNW36ss(this), "graphicsVersion", new $$Lambda$waq3txz4KQFqVa_z1dHRpH83H_g(this));
        }

        public GraphicsVersion getGraphicsVersion() {
            return this.graphicsVersion;
        }

        public int getMetafileSignature() {
            return this.metafileSignature;
        }

        public long init(LittleEndianInputStream r2) {
            int r3 = r2.readInt();
            this.metafileSignature = METAFILE_SIGNATURE.getValue(r3);
            this.graphicsVersion = GraphicsVersion.valueOf(GRAPHICS_VERSION.getValue(r3));
            return 4;
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public static final enum GraphicsVersion extends Enum<GraphicsVersion> {
        private static final /* synthetic */ GraphicsVersion[] $VALUES = null;
        public static final GraphicsVersion V1 = null;
        public static final GraphicsVersion V1_1 = null;
        public final int id;

        static {
            GraphicsVersion r0 = new GraphicsVersion("V1", 0, 1);
            V1 = r0;
            GraphicsVersion r1 = new GraphicsVersion("V1_1", 1, 2);
            V1_1 = r1;
            $VALUES = new GraphicsVersion[]{r0, r1};
        }

        private GraphicsVersion(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
        }

        public static GraphicsVersion valueOf(int r5) {
            GraphicsVersion[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            GraphicsVersion r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static GraphicsVersion valueOf(String r2) {
            return (GraphicsVersion) ZeusTransformUtils.preCheckCast(Enum.valueOf(GraphicsVersion.class, r2), GraphicsVersion.class, "com.obric.memorydata.plugin");
        }

        public static GraphicsVersion[] values() {
            return (GraphicsVersion[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), GraphicsVersion[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        FLAGS_MASK = new int[]{0, 1};
        FLAGS_NAMES = new String[]{"EMF_PLUS_MODE", "DUAL_MODE"};
        EMFFLAGS_MASK = new int[]{0, 1};
        EMFFLAGS_NAMES = new String[]{"CONTEXT_PRINTER", "CONTEXT_VIDEO"};
    }

    public HemfPlusHeader() {
        this.version = new EmfPlusGraphicsVersion();
    }

    public long getEmfPlusFlags() {
        return this.emfPlusFlags;
    }

    @Override // org.apache.poi.hemf.record.emfplus.HemfPlusRecord
    public HemfPlusRecordType getEmfPlusRecordType() {
        return HemfPlusRecordType.header;
    }

    public int getFlags() {
        return this.flags;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("flags", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$b1qqYqDNLDayDxooc5j2I0JwGE(this), FLAGS_MASK, FLAGS_NAMES), "version", new $$Lambda$Zqj7gBWsbAYeE_94sufu1IQkPyY(this), "emfPlusFlags", GenericRecordUtil.getEnumBitsAsString(new $$Lambda$Gfr3lik6SAxXGNYpxEasr32GLPE(this), EMFFLAGS_MASK, EMFFLAGS_NAMES), "logicalDpiX", new $$Lambda$rQy6nmHN2XDQukYFt4tf2jiPQX4(this), "logicalDpiY", new $$Lambda$ZP9PE0oPsi1IyN1150oJznpXhc(this));
    }

    public long getLogicalDpiX() {
        return this.logicalDpiX;
    }

    public long getLogicalDpiY() {
        return this.logicalDpiY;
    }

    public EmfPlusGraphicsVersion getVersion() {
        return this.version;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
