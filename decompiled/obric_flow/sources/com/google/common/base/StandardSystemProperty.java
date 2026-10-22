package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
public final enum StandardSystemProperty extends Enum<StandardSystemProperty> {
    public static final StandardSystemProperty FILE_SEPARATOR = null;
    public static final StandardSystemProperty JAVA_CLASS_PATH = null;
    public static final StandardSystemProperty JAVA_CLASS_VERSION = null;
    public static final StandardSystemProperty JAVA_COMPILER = null;

    @Deprecated
    public static final StandardSystemProperty JAVA_EXT_DIRS = null;
    public static final StandardSystemProperty JAVA_HOME = null;
    public static final StandardSystemProperty JAVA_IO_TMPDIR = null;
    public static final StandardSystemProperty JAVA_LIBRARY_PATH = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_NAME = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_VENDOR = null;
    public static final StandardSystemProperty JAVA_SPECIFICATION_VERSION = null;
    public static final StandardSystemProperty JAVA_VENDOR = null;
    public static final StandardSystemProperty JAVA_VENDOR_URL = null;
    public static final StandardSystemProperty JAVA_VERSION = null;
    public static final StandardSystemProperty JAVA_VM_NAME = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_NAME = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_VENDOR = null;
    public static final StandardSystemProperty JAVA_VM_SPECIFICATION_VERSION = null;
    public static final StandardSystemProperty JAVA_VM_VENDOR = null;
    public static final StandardSystemProperty JAVA_VM_VERSION = null;
    public static final StandardSystemProperty LINE_SEPARATOR = null;
    public static final StandardSystemProperty OS_ARCH = null;
    public static final StandardSystemProperty OS_NAME = null;
    public static final StandardSystemProperty OS_VERSION = null;
    public static final StandardSystemProperty PATH_SEPARATOR = null;
    public static final StandardSystemProperty USER_DIR = null;
    public static final StandardSystemProperty USER_HOME = null;
    public static final StandardSystemProperty USER_NAME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StandardSystemProperty[] f8645a = null;
    private final String key;

    static {
        StandardSystemProperty r5 = new StandardSystemProperty("JAVA_VERSION", 0, "java.version");
        JAVA_VERSION = r5;
        StandardSystemProperty r10 = new StandardSystemProperty("JAVA_VENDOR", 1, "java.vendor");
        JAVA_VENDOR = r10;
        StandardSystemProperty r11 = new StandardSystemProperty("JAVA_VENDOR_URL", 2, "java.vendor.url");
        JAVA_VENDOR_URL = r11;
        StandardSystemProperty r12 = new StandardSystemProperty("JAVA_HOME", 3, "java.home");
        JAVA_HOME = r12;
        StandardSystemProperty r13 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VERSION", 4, "java.vm.specification.version");
        JAVA_VM_SPECIFICATION_VERSION = r13;
        StandardSystemProperty r14 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_VENDOR", 5, "java.vm.specification.vendor");
        JAVA_VM_SPECIFICATION_VENDOR = r14;
        StandardSystemProperty r15 = new StandardSystemProperty("JAVA_VM_SPECIFICATION_NAME", 6, "java.vm.specification.name");
        JAVA_VM_SPECIFICATION_NAME = r15;
        StandardSystemProperty r16 = new StandardSystemProperty("JAVA_VM_VERSION", 7, "java.vm.version");
        JAVA_VM_VERSION = r16;
        StandardSystemProperty r17 = new StandardSystemProperty("JAVA_VM_VENDOR", 8, "java.vm.vendor");
        JAVA_VM_VENDOR = r17;
        StandardSystemProperty r18 = new StandardSystemProperty("JAVA_VM_NAME", 9, "java.vm.name");
        JAVA_VM_NAME = r18;
        StandardSystemProperty r19 = new StandardSystemProperty("JAVA_SPECIFICATION_VERSION", 10, "java.specification.version");
        JAVA_SPECIFICATION_VERSION = r19;
        StandardSystemProperty r110 = new StandardSystemProperty("JAVA_SPECIFICATION_VENDOR", 11, "java.specification.vendor");
        JAVA_SPECIFICATION_VENDOR = r110;
        StandardSystemProperty r111 = new StandardSystemProperty("JAVA_SPECIFICATION_NAME", 12, "java.specification.name");
        JAVA_SPECIFICATION_NAME = r111;
        StandardSystemProperty r112 = new StandardSystemProperty("JAVA_CLASS_VERSION", 13, "java.class.version");
        JAVA_CLASS_VERSION = r112;
        StandardSystemProperty r113 = new StandardSystemProperty("JAVA_CLASS_PATH", 14, "java.class.path");
        JAVA_CLASS_PATH = r113;
        StandardSystemProperty r114 = new StandardSystemProperty("JAVA_LIBRARY_PATH", 15, "java.library.path");
        JAVA_LIBRARY_PATH = r114;
        StandardSystemProperty r115 = new StandardSystemProperty("JAVA_IO_TMPDIR", 16, "java.io.tmpdir");
        JAVA_IO_TMPDIR = r115;
        StandardSystemProperty r116 = new StandardSystemProperty("JAVA_COMPILER", 17, "java.compiler");
        JAVA_COMPILER = r116;
        StandardSystemProperty r117 = new StandardSystemProperty("JAVA_EXT_DIRS", 18, "java.ext.dirs");
        JAVA_EXT_DIRS = r117;
        StandardSystemProperty r118 = new StandardSystemProperty("OS_NAME", 19, "os.name");
        OS_NAME = r118;
        StandardSystemProperty r119 = new StandardSystemProperty("OS_ARCH", 20, "os.arch");
        OS_ARCH = r119;
        StandardSystemProperty r120 = new StandardSystemProperty("OS_VERSION", 21, "os.version");
        OS_VERSION = r120;
        StandardSystemProperty r121 = new StandardSystemProperty("FILE_SEPARATOR", 22, "file.separator");
        FILE_SEPARATOR = r121;
        StandardSystemProperty r122 = new StandardSystemProperty("PATH_SEPARATOR", 23, "path.separator");
        PATH_SEPARATOR = r122;
        StandardSystemProperty r123 = new StandardSystemProperty("LINE_SEPARATOR", 24, "line.separator");
        LINE_SEPARATOR = r123;
        StandardSystemProperty r124 = new StandardSystemProperty("USER_NAME", 25, "user.name");
        USER_NAME = r124;
        StandardSystemProperty r125 = new StandardSystemProperty("USER_HOME", 26, "user.home");
        USER_HOME = r125;
        StandardSystemProperty r126 = new StandardSystemProperty("USER_DIR", 27, "user.dir");
        USER_DIR = r126;
        f8645a = new StandardSystemProperty[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
    }

    public StandardSystemProperty(String r5, int r10, String r11) {
        super(r5, r10);
        this.key = r11;
    }

    public static StandardSystemProperty valueOf(String r5) {
        return (StandardSystemProperty) Enum.valueOf(StandardSystemProperty.class, r5);
    }

    public static StandardSystemProperty[] values() {
        return (StandardSystemProperty[]) f8645a.clone();
    }

    public String key() {
        return this.key;
    }

    @Override // java.lang.Enum
    public String toString() {
        String r5 = key();
        String r10 = value();
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(androidx.room.jarjarred.org.antlr.runtime.a.g(1, r5), r10), r5, "=", r10);
    }

    public String value() {
        return System.getProperty(this.key);
    }
}
