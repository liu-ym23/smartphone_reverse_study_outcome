package org.apache.poi.hwmf.record;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes7.dex */
public class HwmfEscape implements HwmfRecord {
    private HwmfEscapeData escapeData;
    private EscapeFunction escapeFunction;

    public static final enum EscapeFunction extends Enum<EscapeFunction> {
        private static final /* synthetic */ EscapeFunction[] $VALUES = null;
        public static final EscapeFunction ABORTDOC = null;
        public static final EscapeFunction BANDINFO = null;
        public static final EscapeFunction BEGIN_PATH = null;
        public static final EscapeFunction CHECKJPEGFORMAT = null;
        public static final EscapeFunction CHECKPNGFORMAT = null;
        public static final EscapeFunction CLIP_TO_PATH = null;
        public static final EscapeFunction CLOSE_CHANNEL = null;
        public static final EscapeFunction DOWNLOADFACE = null;
        public static final EscapeFunction DOWNLOADHEADER = null;
        public static final EscapeFunction DRAFTMODE = null;
        public static final EscapeFunction DRAWPATTERNRECT = null;
        public static final EscapeFunction ENABLEDUPLEX = null;
        public static final EscapeFunction ENCAPSULATED_POSTSCRIPT = null;
        public static final EscapeFunction ENDDOC = null;
        public static final EscapeFunction END_PATH = null;
        public static final EscapeFunction ENUMPAPERBINS = null;
        public static final EscapeFunction ENUMPAPERMETRICS = null;
        public static final EscapeFunction EPSPRINTING = null;
        public static final EscapeFunction EXTTEXTOUT = null;
        public static final EscapeFunction FLUSHOUT = null;
        public static final EscapeFunction GETCOLORTABLE = null;
        public static final EscapeFunction GETDEVICEUNITS = null;
        public static final EscapeFunction GETEXTENDEDTEXTMETRICS = null;
        public static final EscapeFunction GETFACENAME = null;
        public static final EscapeFunction GETPAIRKERNTABLE = null;
        public static final EscapeFunction GETPHYSPAGESIZE = null;
        public static final EscapeFunction GETPRINTINGOFFSET = null;
        public static final EscapeFunction GETSCALINGFACTOR = null;
        public static final EscapeFunction GETSETPAPERBINS = null;
        public static final EscapeFunction GETSETPAPERMETRICS = null;
        public static final EscapeFunction GETSETPRINTORIENT = null;
        public static final EscapeFunction GETTECHNOLOGY = null;
        public static final EscapeFunction GETVECTORBRUSHSIZE = null;
        public static final EscapeFunction GETVECTORPENSIZE = null;
        public static final EscapeFunction GET_PS_FEATURESETTING = null;
        public static final EscapeFunction METAFILE_DRIVER = null;
        public static final EscapeFunction META_ESCAPE_ENHANCED_METAFILE = null;
        public static final EscapeFunction MXDC_ESCAPE = null;
        public static final EscapeFunction NEWFRAME = null;
        public static final EscapeFunction NEXTBAND = null;
        public static final EscapeFunction OPEN_CHANNEL = null;
        public static final EscapeFunction PASSTHROUGH = null;
        public static final EscapeFunction POSTSCRIPT_DATA = null;
        public static final EscapeFunction POSTSCRIPT_IDENTIFY = null;
        public static final EscapeFunction POSTSCRIPT_IGNORE = null;
        public static final EscapeFunction POSTSCRIPT_INJECTION = null;
        public static final EscapeFunction POSTSCRIPT_PASSTHROUGH = null;
        public static final EscapeFunction QUERYDIBSUPPORT = null;
        public static final EscapeFunction QUERYESCSUPPORT = null;
        public static final EscapeFunction SETABORTPROC = null;
        public static final EscapeFunction SETCOLORTABLE = null;
        public static final EscapeFunction SETCOPYCOUNT = null;
        public static final EscapeFunction SETDIBSCALING = null;
        public static final EscapeFunction SETLINECAP = null;
        public static final EscapeFunction SETLINEJOIN = null;
        public static final EscapeFunction SETMITERLIMIT = null;
        public static final EscapeFunction SETPAPERSOURCE = null;
        public static final EscapeFunction SETPENWIDTH = null;
        public static final EscapeFunction SPCLPASSTHROUGH2 = null;
        public static final EscapeFunction STARTDOC = null;
        private final Supplier<? extends HwmfEscapeData> constructor;
        private final int flag;

        static {
            NEWFRAME = new EscapeFunction("NEWFRAME", 0, 1, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            ABORTDOC = new EscapeFunction("ABORTDOC", 1, 2, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            NEXTBAND = new EscapeFunction("NEXTBAND", 2, 3, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SETCOLORTABLE = new EscapeFunction("SETCOLORTABLE", 3, 4, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETCOLORTABLE = new EscapeFunction("GETCOLORTABLE", 4, 5, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            FLUSHOUT = new EscapeFunction("FLUSHOUT", 5, 6, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            DRAFTMODE = new EscapeFunction("DRAFTMODE", 6, 7, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            QUERYESCSUPPORT = new EscapeFunction("QUERYESCSUPPORT", 7, 8, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SETABORTPROC = new EscapeFunction("SETABORTPROC", 8, 9, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            STARTDOC = new EscapeFunction("STARTDOC", 9, 10, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            ENDDOC = new EscapeFunction("ENDDOC", 10, 11, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETPHYSPAGESIZE = new EscapeFunction("GETPHYSPAGESIZE", 11, 12, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETPRINTINGOFFSET = new EscapeFunction("GETPRINTINGOFFSET", 12, 13, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETSCALINGFACTOR = new EscapeFunction("GETSCALINGFACTOR", 13, 14, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            META_ESCAPE_ENHANCED_METAFILE = new EscapeFunction("META_ESCAPE_ENHANCED_METAFILE", 14, 15, $$Lambda$54wMbMYtOc12mkGhRzPEp7ijiE.INSTANCE);
            SETPENWIDTH = new EscapeFunction("SETPENWIDTH", 15, 16, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SETCOPYCOUNT = new EscapeFunction("SETCOPYCOUNT", 16, 17, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SETPAPERSOURCE = new EscapeFunction("SETPAPERSOURCE", 17, 18, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            PASSTHROUGH = new EscapeFunction("PASSTHROUGH", 18, 19, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETTECHNOLOGY = new EscapeFunction("GETTECHNOLOGY", 19, 20, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SETLINECAP = new EscapeFunction("SETLINECAP", 20, 21, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SETLINEJOIN = new EscapeFunction("SETLINEJOIN", 21, 22, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SETMITERLIMIT = new EscapeFunction("SETMITERLIMIT", 22, 23, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            BANDINFO = new EscapeFunction("BANDINFO", 23, 24, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            DRAWPATTERNRECT = new EscapeFunction("DRAWPATTERNRECT", 24, 25, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETVECTORPENSIZE = new EscapeFunction("GETVECTORPENSIZE", 25, 26, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETVECTORBRUSHSIZE = new EscapeFunction("GETVECTORBRUSHSIZE", 26, 27, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            ENABLEDUPLEX = new EscapeFunction("ENABLEDUPLEX", 27, 28, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETSETPAPERBINS = new EscapeFunction("GETSETPAPERBINS", 28, 29, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETSETPRINTORIENT = new EscapeFunction("GETSETPRINTORIENT", 29, 30, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            ENUMPAPERBINS = new EscapeFunction("ENUMPAPERBINS", 30, 31, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SETDIBSCALING = new EscapeFunction("SETDIBSCALING", 31, 32, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            EPSPRINTING = new EscapeFunction("EPSPRINTING", 32, 33, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            ENUMPAPERMETRICS = new EscapeFunction("ENUMPAPERMETRICS", 33, 34, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETSETPAPERMETRICS = new EscapeFunction("GETSETPAPERMETRICS", 34, 35, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            POSTSCRIPT_DATA = new EscapeFunction("POSTSCRIPT_DATA", 35, 37, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            POSTSCRIPT_IGNORE = new EscapeFunction("POSTSCRIPT_IGNORE", 36, 38, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETDEVICEUNITS = new EscapeFunction("GETDEVICEUNITS", 37, 42, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETEXTENDEDTEXTMETRICS = new EscapeFunction("GETEXTENDEDTEXTMETRICS", 38, 256, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETPAIRKERNTABLE = new EscapeFunction("GETPAIRKERNTABLE", 39, 258, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            EXTTEXTOUT = new EscapeFunction("EXTTEXTOUT", 40, 512, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GETFACENAME = new EscapeFunction("GETFACENAME", 41, InputDeviceCompat.SOURCE_DPAD, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            DOWNLOADFACE = new EscapeFunction("DOWNLOADFACE", 42, 514, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            METAFILE_DRIVER = new EscapeFunction("METAFILE_DRIVER", 43, 2049, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            QUERYDIBSUPPORT = new EscapeFunction("QUERYDIBSUPPORT", 44, 3073, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            BEGIN_PATH = new EscapeFunction("BEGIN_PATH", 45, 4096, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            CLIP_TO_PATH = new EscapeFunction("CLIP_TO_PATH", 46, FragmentTransaction.TRANSIT_FRAGMENT_OPEN, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            END_PATH = new EscapeFunction("END_PATH", 47, InputDeviceCompat.SOURCE_TOUCHSCREEN, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            OPEN_CHANNEL = new EscapeFunction("OPEN_CHANNEL", 48, 4110, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            DOWNLOADHEADER = new EscapeFunction("DOWNLOADHEADER", 49, 4111, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            CLOSE_CHANNEL = new EscapeFunction("CLOSE_CHANNEL", 50, 4112, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            POSTSCRIPT_PASSTHROUGH = new EscapeFunction("POSTSCRIPT_PASSTHROUGH", 51, 4115, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            ENCAPSULATED_POSTSCRIPT = new EscapeFunction("ENCAPSULATED_POSTSCRIPT", 52, 4116, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            POSTSCRIPT_IDENTIFY = new EscapeFunction("POSTSCRIPT_IDENTIFY", 53, 4117, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            POSTSCRIPT_INJECTION = new EscapeFunction("POSTSCRIPT_INJECTION", 54, 4118, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            CHECKJPEGFORMAT = new EscapeFunction("CHECKJPEGFORMAT", 55, 4119, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            CHECKPNGFORMAT = new EscapeFunction("CHECKPNGFORMAT", 56, 4120, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            GET_PS_FEATURESETTING = new EscapeFunction("GET_PS_FEATURESETTING", 57, 4121, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            MXDC_ESCAPE = new EscapeFunction("MXDC_ESCAPE", 58, 4122, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            SPCLPASSTHROUGH2 = new EscapeFunction("SPCLPASSTHROUGH2", 59, 4568, $$Lambda$AjfqojjLrzlPfk54jBA4amey3vA.INSTANCE);
            $VALUES = new EscapeFunction[]{NEWFRAME, ABORTDOC, NEXTBAND, SETCOLORTABLE, GETCOLORTABLE, FLUSHOUT, DRAFTMODE, QUERYESCSUPPORT, SETABORTPROC, STARTDOC, ENDDOC, GETPHYSPAGESIZE, GETPRINTINGOFFSET, GETSCALINGFACTOR, META_ESCAPE_ENHANCED_METAFILE, SETPENWIDTH, SETCOPYCOUNT, SETPAPERSOURCE, PASSTHROUGH, GETTECHNOLOGY, SETLINECAP, SETLINEJOIN, SETMITERLIMIT, BANDINFO, DRAWPATTERNRECT, GETVECTORPENSIZE, GETVECTORBRUSHSIZE, ENABLEDUPLEX, GETSETPAPERBINS, GETSETPRINTORIENT, ENUMPAPERBINS, SETDIBSCALING, EPSPRINTING, ENUMPAPERMETRICS, GETSETPAPERMETRICS, POSTSCRIPT_DATA, POSTSCRIPT_IGNORE, GETDEVICEUNITS, GETEXTENDEDTEXTMETRICS, GETPAIRKERNTABLE, EXTTEXTOUT, GETFACENAME, DOWNLOADFACE, METAFILE_DRIVER, QUERYDIBSUPPORT, BEGIN_PATH, CLIP_TO_PATH, END_PATH, OPEN_CHANNEL, DOWNLOADHEADER, CLOSE_CHANNEL, POSTSCRIPT_PASSTHROUGH, ENCAPSULATED_POSTSCRIPT, POSTSCRIPT_IDENTIFY, POSTSCRIPT_INJECTION, CHECKJPEGFORMAT, CHECKPNGFORMAT, GET_PS_FEATURESETTING, MXDC_ESCAPE, SPCLPASSTHROUGH2};
        }

        private EscapeFunction(String r3, int r4, int r5, Supplier r6) {
            Supplier<? extends HwmfEscapeData> r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r6, Supplier.class, "com.obric.memorydata.plugin");
            super(r3, r4);
            this.flag = r5;
            this.constructor = r7;
        }

        static /* synthetic */ Supplier access$000(EscapeFunction r0) {
            return r0.constructor;
        }

        static EscapeFunction valueOf(int r5) {
            EscapeFunction[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            EscapeFunction r3 = r0[r2];
            if (r3.flag == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static EscapeFunction valueOf(String r2) {
            return (EscapeFunction) ZeusTransformUtils.preCheckCast(Enum.valueOf(EscapeFunction.class, r2), EscapeFunction.class, "com.obric.memorydata.plugin");
        }

        public static EscapeFunction[] values() {
            return (EscapeFunction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EscapeFunction[].class, "com.obric.memorydata.plugin");
        }

        public Supplier<? extends HwmfEscapeData> getConstructor() {
            return this.constructor;
        }

        public int getFlag() {
            return this.flag;
        }
    }

    public interface HwmfEscapeData {
    }

    public static class WmfEscapeEMF implements GenericRecord, HwmfEscapeData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        int checksum;
        int commentIdentifier;
        int commentRecordCount;
        int commentType;
        int currentRecordSize;
        byte[] emfData;
        int emfRecordSize;
        int flags;
        int remainingBytes;
        int version;

        static {
        }

        public WmfEscapeEMF() {
        }

        public int getCommentRecordCount() {
            return this.commentRecordCount;
        }

        public int getCurrentRecordSize() {
            return this.currentRecordSize;
        }

        public byte[] getEmfData() {
            return this.emfData;
        }

        public int getEmfRecordSize() {
            return this.emfRecordSize;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            LinkedHashMap r0 = new LinkedHashMap();
            r0.put("commentIdentifier", new $$Lambda$HwmfEscape$WmfEscapeEMF$W47eS9X_KIf5FT7ECQxbOI_60Zc(this));
            r0.put("commentType", new $$Lambda$HwmfEscape$WmfEscapeEMF$3gSXZa1HPUSqqs997SZiBYO9k(this));
            r0.put("version", new $$Lambda$HwmfEscape$WmfEscapeEMF$TLoI_0dirkYgo_c3cqidjcUmIpc(this));
            r0.put("checksum", new $$Lambda$HwmfEscape$WmfEscapeEMF$HoMC2AASIKbU4Yc8PtuWpysdxwE(this));
            r0.put("flags", new $$Lambda$HwmfEscape$WmfEscapeEMF$TFz7VmOERPC7tMn5hgPlQdSE5no(this));
            r0.put("commentRecordCount", new $$Lambda$aliGbCpPCCF7ZEBIzyOcznygsPs(this));
            r0.put("currentRecordSize", new $$Lambda$TMkDoWYIsHryi2eCQdiYbkoc1y0(this));
            r0.put("remainingBytes", new $$Lambda$2oFBh52AvY6n2bRon5p7fsmDBM8(this));
            r0.put("emfRecordSize", new $$Lambda$vI5NNfYPUSrmWK36p7rDoC_MuSA(this));
            r0.put("emfData", new $$Lambda$9MY1waUMzY5GfNZ3rlKzbGbjeIc(this));
            return Collections.unmodifiableMap(r0);
        }

        public int getRemainingBytes() {
            return this.remainingBytes;
        }

        public /* synthetic */ Object lambda$getGenericProperties$0$HwmfEscape$WmfEscapeEMF() {
            return Integer.valueOf(this.commentIdentifier);
        }

        public /* synthetic */ Object lambda$getGenericProperties$1$HwmfEscape$WmfEscapeEMF() {
            return Integer.valueOf(this.commentType);
        }

        public /* synthetic */ Object lambda$getGenericProperties$2$HwmfEscape$WmfEscapeEMF() {
            return Integer.valueOf(this.version);
        }

        public /* synthetic */ Object lambda$getGenericProperties$3$HwmfEscape$WmfEscapeEMF() {
            return Integer.valueOf(this.checksum);
        }

        public /* synthetic */ Object lambda$getGenericProperties$4$HwmfEscape$WmfEscapeEMF() {
            return Integer.valueOf(this.flags);
        }
    }

    public static class WmfEscapeUnknownData implements GenericRecord, HwmfEscapeData {
        private byte[] escapeDataBytes;

        public WmfEscapeUnknownData() {
        }

        public byte[] getEscapeDataBytes() {
            return this.escapeDataBytes;
        }

        @Override // org.apache.poi.common.usermodel.GenericRecord
        public Map<String, Supplier<?>> getGenericProperties() {
            return GenericRecordUtil.getGenericProperties("escapeDataBytes", new $$Lambda$su4OfLCaK2MdNxtn7P8Q3EZHQ7I(this));
        }

        public String toString() {
            return GenericRecordJsonWriter.marshal(this);
        }
    }

    public HwmfEscape() {
    }

    public <T extends HwmfEscapeData> T getEscapeData() {
        return (T) this.escapeData;
    }

    public EscapeFunction getEscapeFunction() {
        return this.escapeFunction;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("escapeFunction", new $$Lambda$rTxKMuRpuClJDRaZb7IYLrvJio(this), "escapeData", new $$Lambda$ccIVACse1HIqtsmJfADjCbYYFo(this));
    }

    @Override // org.apache.poi.hwmf.record.HwmfRecord
    public HwmfRecordType getWmfRecordType() {
        return HwmfRecordType.escape;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
