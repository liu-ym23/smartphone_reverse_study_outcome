package org.apache.poi.hsmf.datatypes;

import com.tom_roush.pdfbox.pdmodel.a.d.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class Types {
    public static final MAPIType APP_TIME = null;
    public static final MAPIType ASCII_STRING = null;
    public static final MAPIType BINARY = null;
    public static final MAPIType BOOLEAN = null;
    public static final MAPIType CLS_ID = null;
    public static final MAPIType CURRENCY = null;
    public static final MAPIType DIRECTORY = null;
    public static final MAPIType DOUBLE = null;
    public static final MAPIType ERROR = null;
    public static final MAPIType FLOAT = null;
    public static final MAPIType LONG = null;
    public static final MAPIType LONG_LONG = null;
    public static final MAPIType NULL = null;
    public static final MAPIType SHORT = null;
    public static final MAPIType TIME = null;
    public static final MAPIType UNICODE_STRING = null;
    public static final MAPIType UNKNOWN = null;
    public static final MAPIType UNSPECIFIED = null;
    private static final Map<Integer, MAPIType> builtInTypes = null;
    private static final Map<Integer, MAPIType> customTypes = null;

    /* JADX INFO: renamed from: org.apache.poi.hsmf.datatypes.Types$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class MAPIType {
        private final int id;
        private final int length;
        private final String name;

        private MAPIType(int r2, int r3) {
            this.id = r2;
            this.name = Types.access$200(r2);
            this.length = r3;
            Types.access$300().put(Integer.valueOf(r2), this);
        }

        /* synthetic */ MAPIType(int r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private MAPIType(int r1, String r2, int r3) {
            this.id = r1;
            this.name = r2;
            this.length = r3;
            Types.access$100().put(Integer.valueOf(r1), this);
        }

        /* synthetic */ MAPIType(int r1, String r2, int r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        public String asFileEnding() {
            return Types.asFileEnding(this.id);
        }

        public String toString() {
            return this.id + " / 0x" + asFileEnding() + " - " + this.name + " @ " + this.length;
        }
    }

    static {
        builtInTypes = new HashMap();
        customTypes = new HashMap();
        int r1 = 0;
        int r3 = -1;
        AnonymousClass1 r4 = null;
        UNSPECIFIED = new MAPIType(r1, "Unspecified", r3, r4);
        UNKNOWN = new MAPIType(r3, "Unknown", r3, r4);
        NULL = new MAPIType(1, "Null", r1, r4);
        int r2 = 2;
        SHORT = new MAPIType(r2, "Short", r2, r4);
        int r6 = 4;
        LONG = new MAPIType(3, "Long", r6, r4);
        FLOAT = new MAPIType(r6, "Float", r6, r4);
        int r7 = 8;
        DOUBLE = new MAPIType(5, d.v, r7, r4);
        CURRENCY = new MAPIType(6, "Currency", r7, r4);
        APP_TIME = new MAPIType(7, "Application Time", r7, r4);
        ERROR = new MAPIType(10, "Error", r6, r4);
        BOOLEAN = new MAPIType(11, "Boolean", r2, r4);
        DIRECTORY = new MAPIType(13, "Directory", r3, r4);
        LONG_LONG = new MAPIType(20, "Long Long", r7, r4);
        TIME = new MAPIType(64, "Time", r7, r4);
        CLS_ID = new MAPIType(72, "CLS ID GUID", 16, r4);
        BINARY = new MAPIType(258, "Binary", r3, r4);
        ASCII_STRING = new MAPIType(30, "ASCII String", r3, r4);
        UNICODE_STRING = new MAPIType(31, "Unicode String", r3, r4);
    }

    static /* synthetic */ Map access$100() {
        return builtInTypes;
    }

    static /* synthetic */ String access$200(int r0) {
        return asCustomName(r0);
    }

    static /* synthetic */ Map access$300() {
        return customTypes;
    }

    private static String asCustomName(int r2) {
        return "0x" + Integer.toHexString(r2);
    }

    public static String asFileEnding(int r3) {
        StringBuilder r0 = new StringBuilder(Integer.toHexString(r3).toUpperCase(Locale.ROOT));
        int r4 = 4 - r0.length();
        if (r4 <= 0) goto L6;
        r0.insert(0, StringUtil.repeat('0', r4));
    L6:
        return r0.toString();
    }

    public static MAPIType createCustom(int r4) {
        if (getById(r4) != null) goto L5;
        Map<Integer, MAPIType> r0 = customTypes;
        MAPIType r1 = (MAPIType) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r4)), MAPIType.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L17;
        monitor-enter(r0);
        r1 = (MAPIType) ZeusTransformUtils.preCheckCast(r0.get(Integer.valueOf(r4)), MAPIType.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 != null) goto L12;
        r1 = new MAPIType(r4, -1, null);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L17:
        return r1;
    L5:
        return getById(r4);
    }

    public static MAPIType getById(int r2) {
        return (MAPIType) ZeusTransformUtils.preCheckCast(builtInTypes.get(Integer.valueOf(r2)), MAPIType.class, "com.obric.memorydata.plugin");
    }
}
