package org.apache.poi.hwmf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfHeader implements GenericRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int filesize;
    private long maxRecord;
    private int numberOfMembers;
    private int numberOfObjects;
    private int recordSize;
    private HwmfHeaderMetaType type;
    private int version;

    public static final enum HwmfHeaderMetaType extends Enum<HwmfHeaderMetaType> {
        private static final /* synthetic */ HwmfHeaderMetaType[] $VALUES = null;
        public static final HwmfHeaderMetaType DISK_METAFILE = null;
        public static final HwmfHeaderMetaType MEMORY_METAFILE = null;

        static {
            HwmfHeaderMetaType r0 = new HwmfHeaderMetaType("MEMORY_METAFILE", 0);
            MEMORY_METAFILE = r0;
            HwmfHeaderMetaType r1 = new HwmfHeaderMetaType("DISK_METAFILE", 1);
            DISK_METAFILE = r1;
            $VALUES = new HwmfHeaderMetaType[]{r0, r1};
        }

        private HwmfHeaderMetaType(String r1, int r2) {
            super(r1, r2);
        }

        public static HwmfHeaderMetaType valueOf(String r2) {
            return (HwmfHeaderMetaType) ZeusTransformUtils.preCheckCast(Enum.valueOf(HwmfHeaderMetaType.class, r2), HwmfHeaderMetaType.class, "com.obric.memorydata.plugin");
        }

        public static HwmfHeaderMetaType[] values() {
            return (HwmfHeaderMetaType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HwmfHeaderMetaType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("type", new $$Lambda$HwmfHeader$siOfzE3T_tfIU8VXdy1GrMNlOqo(this));
        r0.put("recordSize", new $$Lambda$HwmfHeader$vDb2iyaTvFTDDnrtCk_8CeHFaE(this));
        r0.put("version", new $$Lambda$HwmfHeader$puKhV5ppNWFaAlN_TGHVRnh7s(this));
        r0.put("filesize", new $$Lambda$HwmfHeader$VZI6UMmpWFfOzrggo1oXd0te3yU(this));
        r0.put("numberOfObjects", new $$Lambda$HwmfHeader$BetX46rABShBO67b35VcV_4nrhg(this));
        r0.put("maxRecord", new $$Lambda$HwmfHeader$bnjBXenZBJPnoaoFMMO_IZMINQ(this));
        r0.put("numberOfMembers", new $$Lambda$HwmfHeader$r6llPmzdTMKEbHxGRvyqAptxSs(this));
        return Collections.unmodifiableMap(r0);
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$HwmfHeader() {
        return this.type;
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$HwmfHeader() {
        return Integer.valueOf(this.recordSize);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$HwmfHeader() {
        return Integer.valueOf(this.version);
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$HwmfHeader() {
        return Integer.valueOf(this.filesize);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$HwmfHeader() {
        return Integer.valueOf(this.numberOfObjects);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$HwmfHeader() {
        return Long.valueOf(this.maxRecord);
    }

    public /* synthetic */ Object lambda$getGenericProperties$6$HwmfHeader() {
        return Integer.valueOf(this.numberOfMembers);
    }
}
