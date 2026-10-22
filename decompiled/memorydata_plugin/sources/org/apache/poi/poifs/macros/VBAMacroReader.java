package org.apache.poi.poifs.macros;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public class VBAMacroReader implements Closeable {
    private static final c LOGGER = null;
    private POIFSFileSystem fs;

    private static final enum DIR_STATE extends Enum<DIR_STATE> {
        private static final /* synthetic */ DIR_STATE[] $VALUES = null;
        public static final DIR_STATE INFORMATION_RECORD = null;
        public static final DIR_STATE MODULES_RECORD = null;
        public static final DIR_STATE REFERENCES_RECORD = null;

        static {
            DIR_STATE r0 = new DIR_STATE("INFORMATION_RECORD", 0);
            INFORMATION_RECORD = r0;
            DIR_STATE r1 = new DIR_STATE("REFERENCES_RECORD", 1);
            REFERENCES_RECORD = r1;
            DIR_STATE r3 = new DIR_STATE("MODULES_RECORD", 2);
            MODULES_RECORD = r3;
            $VALUES = new DIR_STATE[]{r0, r1, r3};
        }

        private DIR_STATE(String r1, int r2) {
            super(r1, r2);
        }

        public static DIR_STATE valueOf(String r2) {
            return (DIR_STATE) ZeusTransformUtils.preCheckCast(Enum.valueOf(DIR_STATE.class, r2), DIR_STATE.class, "com.obric.memorydata.plugin");
        }

        public static DIR_STATE[] values() {
            return (DIR_STATE[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), DIR_STATE[].class, "com.obric.memorydata.plugin");
        }
    }

    protected static class ModuleMap extends HashMap<String, Object> {
        Charset charset;

        public ModuleMap() {
            this.charset = StringUtil.WIN_1252;
        }
    }

    private static final enum RecordType extends Enum<RecordType> {
        private static final /* synthetic */ RecordType[] $VALUES = null;
        public static final RecordType DIR_STREAM_TERMINATOR = null;
        public static final RecordType EOF = null;
        public static final RecordType MODULE_COOKIE = null;
        public static final RecordType MODULE_DOC_STRING = null;
        public static final RecordType MODULE_HELP_CONTEXT = null;
        public static final RecordType MODULE_NAME = null;
        public static final RecordType MODULE_NAME_UNICODE = null;
        public static final RecordType MODULE_OFFSET = null;
        public static final RecordType MODULE_PRIVATE = null;
        public static final RecordType MODULE_STREAM_NAME = null;
        public static final RecordType MODULE_TERMINATOR = null;
        public static final RecordType MODULE_TYPE_OTHER = null;
        public static final RecordType MODULE_TYPE_PROCEDURAL = null;
        public static final RecordType PROJECT_CODEPAGE = null;
        public static final RecordType PROJECT_CONSTANTS = null;
        public static final RecordType PROJECT_COOKIE = null;
        public static final RecordType PROJECT_DOC_STRING = null;
        public static final RecordType PROJECT_HELP_CONTEXT = null;
        public static final RecordType PROJECT_HELP_FILE_PATH = null;
        public static final RecordType PROJECT_LCID = null;
        public static final RecordType PROJECT_LCID_INVOKE = null;
        public static final RecordType PROJECT_LIB_FLAGS = null;
        public static final RecordType PROJECT_MODULES = null;
        public static final RecordType PROJECT_NAME = null;
        public static final RecordType PROJECT_SYS_KIND = null;
        public static final RecordType PROJECT_VERSION = null;
        public static final RecordType REFERENCE_CONTROL_A = null;
        public static final RecordType REFERENCE_CONTROL_B = null;
        public static final RecordType REFERENCE_NAME = null;
        public static final RecordType REFERENCE_PROJECT = null;
        public static final RecordType REFERENCE_REGISTERED = null;
        public static final RecordType UNKNOWN = null;
        private final int constantLength;
        private final int id;

        static {
            RecordType r0 = new RecordType("MODULE_OFFSET", 0, 49);
            MODULE_OFFSET = r0;
            RecordType r1 = new RecordType("PROJECT_SYS_KIND", 1, 1);
            PROJECT_SYS_KIND = r1;
            RecordType r2 = new RecordType("PROJECT_LCID", 2, 2);
            PROJECT_LCID = r2;
            RecordType r4 = new RecordType("PROJECT_LCID_INVOKE", 3, 20);
            PROJECT_LCID_INVOKE = r4;
            RecordType r6 = new RecordType("PROJECT_CODEPAGE", 4, 3);
            PROJECT_CODEPAGE = r6;
            RecordType r9 = new RecordType("PROJECT_NAME", 5, 4);
            PROJECT_NAME = r9;
            RecordType r11 = new RecordType("PROJECT_DOC_STRING", 6, 5);
            PROJECT_DOC_STRING = r11;
            RecordType r13 = new RecordType("PROJECT_HELP_FILE_PATH", 7, 6);
            PROJECT_HELP_FILE_PATH = r13;
            RecordType r15 = new RecordType("PROJECT_HELP_CONTEXT", 8, 7, 8);
            PROJECT_HELP_CONTEXT = r15;
            RecordType r14 = new RecordType("PROJECT_LIB_FLAGS", 9, 8);
            PROJECT_LIB_FLAGS = r14;
            RecordType r12 = new RecordType("PROJECT_VERSION", 10, 9, 10);
            PROJECT_VERSION = r12;
            RecordType r7 = new RecordType("PROJECT_CONSTANTS", 11, 12);
            PROJECT_CONSTANTS = r7;
            RecordType r3 = new RecordType("PROJECT_MODULES", 12, 15);
            PROJECT_MODULES = r3;
            RecordType r5 = new RecordType("DIR_STREAM_TERMINATOR", 13, 16);
            DIR_STREAM_TERMINATOR = r5;
            RecordType r10 = new RecordType("PROJECT_COOKIE", 14, 19);
            PROJECT_COOKIE = r10;
            RecordType r8 = new RecordType("MODULE_NAME", 15, 25);
            MODULE_NAME = r8;
            RecordType r16 = new RecordType("MODULE_NAME_UNICODE", 16, 71);
            MODULE_NAME_UNICODE = r16;
            RecordType r17 = new RecordType("MODULE_STREAM_NAME", 17, 26);
            MODULE_STREAM_NAME = r17;
            RecordType r18 = new RecordType("MODULE_DOC_STRING", 18, 28);
            MODULE_DOC_STRING = r18;
            RecordType r19 = new RecordType("MODULE_HELP_CONTEXT", 19, 30);
            MODULE_HELP_CONTEXT = r19;
            RecordType r20 = new RecordType("MODULE_COOKIE", 20, 44);
            MODULE_COOKIE = r20;
            RecordType r21 = new RecordType("MODULE_TYPE_PROCEDURAL", 21, 33, 4);
            MODULE_TYPE_PROCEDURAL = r21;
            RecordType r22 = new RecordType("MODULE_TYPE_OTHER", 22, 34, 4);
            MODULE_TYPE_OTHER = r22;
            RecordType r23 = new RecordType("MODULE_PRIVATE", 23, 40, 4);
            MODULE_PRIVATE = r23;
            RecordType r24 = new RecordType("REFERENCE_NAME", 24, 22);
            REFERENCE_NAME = r24;
            RecordType r25 = new RecordType("REFERENCE_REGISTERED", 25, 13);
            REFERENCE_REGISTERED = r25;
            RecordType r26 = new RecordType("REFERENCE_PROJECT", 26, 14);
            REFERENCE_PROJECT = r26;
            RecordType r27 = new RecordType("REFERENCE_CONTROL_A", 27, 47);
            REFERENCE_CONTROL_A = r27;
            RecordType r28 = new RecordType("REFERENCE_CONTROL_B", 28, 51);
            REFERENCE_CONTROL_B = r28;
            RecordType r29 = new RecordType("MODULE_TERMINATOR", 29, 43);
            MODULE_TERMINATOR = r29;
            RecordType r30 = new RecordType("EOF", 30, -1);
            EOF = r30;
            RecordType r31 = new RecordType("UNKNOWN", 31, -2);
            UNKNOWN = r31;
            $VALUES = new RecordType[]{r0, r1, r2, r4, r6, r9, r11, r13, r15, r14, r12, r7, r3, r5, r10, r8, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31};
        }

        private RecordType(String r1, int r2, int r3) {
            super(r1, r2);
            this.id = r3;
            this.constantLength = -1;
        }

        private RecordType(String r1, int r2, int r3, int r4) {
            super(r1, r2);
            this.id = r3;
            this.constantLength = r4;
        }

        static /* synthetic */ int access$200(RecordType r0) {
            return r0.id;
        }

        static RecordType lookup(int r5) {
            RecordType[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            RecordType r3 = r0[r2];
            if (r3.id == r5) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            return r3;
        L9:
            return UNKNOWN;
        }

        public static RecordType valueOf(String r2) {
            return (RecordType) ZeusTransformUtils.preCheckCast(Enum.valueOf(RecordType.class, r2), RecordType.class, "com.obric.memorydata.plugin");
        }

        public static RecordType[] values() {
            return (RecordType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RecordType[].class, "com.obric.memorydata.plugin");
        }

        int getConstantLength() {
            return this.constantLength;
        }
    }

    static {
        LOGGER = b.a(VBAMacroReader.class);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.fs.close();
        this.fs = null;
    }
}
