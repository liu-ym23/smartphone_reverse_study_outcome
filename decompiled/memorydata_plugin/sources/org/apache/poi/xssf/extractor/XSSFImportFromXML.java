package org.apache.poi.xssf.extractor;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFImportFromXML {
    private static final c LOG = null;

    private static final enum DataType extends Enum<DataType> {
        private static final /* synthetic */ DataType[] $VALUES = null;
        public static final DataType BOOLEAN = null;
        public static final DataType DATE = null;
        public static final DataType DOUBLE = null;
        public static final DataType INTEGER = null;
        public static final DataType STRING = null;
        private Set<String> xmlDataTypes;

        static {
            DataType r0 = new DataType("BOOLEAN", 0, new String[]{TypedValues.Custom.S_BOOLEAN});
            BOOLEAN = r0;
            DataType r1 = new DataType("DOUBLE", 1, new String[]{"double"});
            DOUBLE = r1;
            DataType r2 = new DataType("INTEGER", 2, new String[]{"int", "unsignedInt", TypedValues.Custom.S_INT});
            INTEGER = r2;
            DataType r4 = new DataType("STRING", 3, new String[]{TypedValues.Custom.S_STRING});
            STRING = r4;
            DataType r6 = new DataType("DATE", 4, new String[]{"date"});
            DATE = r6;
            $VALUES = new DataType[]{r0, r1, r2, r4, r6};
        }

        private DataType(String r1, int r2, String... r3) {
            super(r1, r2);
            this.xmlDataTypes = new HashSet(Arrays.asList(r3));
        }

        public static DataType getDataType(String r5) {
            DataType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L8;
            DataType r3 = r0[r2];
            if (r3.xmlDataTypes.contains(r5) == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L8:
            return null;
        }

        public static DataType valueOf(String r2) {
            return (DataType) ZeusTransformUtils.preCheckCast(Enum.valueOf(DataType.class, r2), DataType.class, "com.obric.memorydata.plugin");
        }

        public static DataType[] values() {
            return (DataType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DataType[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        LOG = b.a(XSSFImportFromXML.class);
    }
}
