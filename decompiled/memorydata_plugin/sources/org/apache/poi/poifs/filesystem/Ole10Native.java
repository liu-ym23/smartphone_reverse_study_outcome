package org.apache.poi.poifs.filesystem;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class Ole10Native {
    private static int MAX_RECORD_LENGTH;
    private static int MAX_STRING_LENGTH;
    private static final byte[] OLE_MARKER_BYTES = null;
    private static final Charset UTF8 = null;

    private static final enum EncodingMode extends Enum<EncodingMode> {
        private static final /* synthetic */ EncodingMode[] $VALUES = null;
        public static final EncodingMode compact = null;
        public static final EncodingMode parsed = null;
        public static final EncodingMode unparsed = null;

        static {
            EncodingMode r0 = new EncodingMode("parsed", 0);
            parsed = r0;
            EncodingMode r1 = new EncodingMode("unparsed", 1);
            unparsed = r1;
            EncodingMode r3 = new EncodingMode("compact", 2);
            compact = r3;
            $VALUES = new EncodingMode[]{r0, r1, r3};
        }

        private EncodingMode(String r1, int r2) {
            super(r1, r2);
        }

        public static EncodingMode valueOf(String r2) {
            return (EncodingMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(EncodingMode.class, r2), EncodingMode.class, "com.obric.memorydata.plugin");
        }

        public static EncodingMode[] values() {
            return (EncodingMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), EncodingMode[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        UTF8 = StandardCharsets.UTF_8;
        MAX_RECORD_LENGTH = 100000000;
        MAX_STRING_LENGTH = 1024;
        OLE_MARKER_BYTES = new byte[]{1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }
}
