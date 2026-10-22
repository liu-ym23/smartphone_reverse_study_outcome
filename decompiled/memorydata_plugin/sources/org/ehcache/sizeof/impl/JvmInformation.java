package org.ehcache.sizeof.impl;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import org.slf4j.c;
import org.slf4j.d;

/* JADX INFO: loaded from: classes7.dex */
public abstract enum JvmInformation extends Enum<JvmInformation> {
    private static final /* synthetic */ JvmInformation[] $VALUES = null;
    public static final JvmInformation CURRENT_JVM_INFORMATION = null;
    private static final long FIFTY_SEVEN_GB = 61203283968L;
    public static final JvmInformation HOTSPOT_32_BIT = null;
    public static final JvmInformation HOTSPOT_32_BIT_WITH_CONCURRENT_MARK_AND_SWEEP = null;
    public static final JvmInformation HOTSPOT_64_BIT = null;
    public static final JvmInformation HOTSPOT_64_BIT_WITH_COMPRESSED_OOPS = null;
    public static final JvmInformation HOTSPOT_64_BIT_WITH_COMPRESSED_OOPS_AND_CONCURRENT_MARK_AND_SWEEP = null;
    public static final JvmInformation HOTSPOT_64_BIT_WITH_CONCURRENT_MARK_AND_SWEEP = null;
    public static final JvmInformation IBM_32_BIT = null;
    public static final JvmInformation IBM_64_BIT = null;
    public static final JvmInformation IBM_64_BIT_WITH_COMPRESSED_REFS = null;
    private static final c LOGGER = null;
    public static final JvmInformation OPENJDK_32_BIT = null;
    public static final JvmInformation OPENJDK_32_BIT_WITH_CONCURRENT_MARK_AND_SWEEP = null;
    public static final JvmInformation OPENJDK_64_BIT = null;
    public static final JvmInformation OPENJDK_64_BIT_WITH_COMPRESSED_OOPS = null;
    public static final JvmInformation OPENJDK_64_BIT_WITH_COMPRESSED_OOPS_AND_CONCURRENT_MARK_AND_SWEEP = null;
    public static final JvmInformation OPENJDK_64_BIT_WITH_CONCURRENT_MARK_AND_SWEEP = null;
    private static final long TWENTY_FIVE_GB = 26843545600L;
    public static final JvmInformation UNKNOWN_32_BIT = null;
    public static final JvmInformation UNKNOWN_64_BIT = null;
    private JvmInformation parent;

    static {
        final String r1 = "UNKNOWN_32_BIT";
        final int r2 = 0;
        final JvmInformation r3 = null;
        final JvmInformation r0 = new AnonymousClass1(r1, r2, r3);
        UNKNOWN_32_BIT = r0;
        final String r4 = "UNKNOWN_64_BIT";
        final int r5 = 1;
        final JvmInformation r6 = new AnonymousClass2(r4, r5, r0);
        UNKNOWN_64_BIT = r6;
        final String r7 = "HOTSPOT_32_BIT";
        final int r8 = 2;
        final JvmInformation r9 = new AnonymousClass3(r7, r8, r0);
        HOTSPOT_32_BIT = r9;
        final String r10 = "HOTSPOT_32_BIT_WITH_CONCURRENT_MARK_AND_SWEEP";
        final int r11 = 3;
        JvmInformation r12 = new AnonymousClass4(r10, r11, r0);
        HOTSPOT_32_BIT_WITH_CONCURRENT_MARK_AND_SWEEP = r12;
        final String r13 = "HOTSPOT_64_BIT";
        final int r14 = 4;
        final JvmInformation r15 = new AnonymousClass5(r13, r14, r6);
        HOTSPOT_64_BIT = r15;
        final String r16 = "HOTSPOT_64_BIT_WITH_CONCURRENT_MARK_AND_SWEEP";
        final int r17 = 5;
        JvmInformation r18 = new AnonymousClass6(r16, r17, r15);
        HOTSPOT_64_BIT_WITH_CONCURRENT_MARK_AND_SWEEP = r18;
        final String r19 = "HOTSPOT_64_BIT_WITH_COMPRESSED_OOPS";
        final int r110 = 6;
        final JvmInformation r111 = new AnonymousClass7(r19, r110, r15);
        HOTSPOT_64_BIT_WITH_COMPRESSED_OOPS = r111;
        final String r112 = "HOTSPOT_64_BIT_WITH_COMPRESSED_OOPS_AND_CONCURRENT_MARK_AND_SWEEP";
        final int r113 = 7;
        JvmInformation r114 = new AnonymousClass8(r112, r113, r111);
        HOTSPOT_64_BIT_WITH_COMPRESSED_OOPS_AND_CONCURRENT_MARK_AND_SWEEP = r114;
        final String r115 = "OPENJDK_32_BIT";
        final int r116 = 8;
        JvmInformation r117 = new AnonymousClass9(r115, r116, r9);
        OPENJDK_32_BIT = r117;
        final String r118 = "OPENJDK_32_BIT_WITH_CONCURRENT_MARK_AND_SWEEP";
        final int r119 = 9;
        JvmInformation r120 = new AnonymousClass10(r118, r119, r9);
        OPENJDK_32_BIT_WITH_CONCURRENT_MARK_AND_SWEEP = r120;
        final String r121 = "OPENJDK_64_BIT";
        final int r20 = 10;
        final JvmInformation r122 = new AnonymousClass11(r121, r20, r15);
        OPENJDK_64_BIT = r122;
        final String r21 = "OPENJDK_64_BIT_WITH_CONCURRENT_MARK_AND_SWEEP";
        final int r22 = 11;
        JvmInformation r123 = new AnonymousClass12(r21, r22, r122);
        OPENJDK_64_BIT_WITH_CONCURRENT_MARK_AND_SWEEP = r123;
        final String r23 = "OPENJDK_64_BIT_WITH_COMPRESSED_OOPS";
        final int r24 = 12;
        final JvmInformation r25 = new AnonymousClass13(r23, r24, r122);
        OPENJDK_64_BIT_WITH_COMPRESSED_OOPS = r25;
        final String r26 = "OPENJDK_64_BIT_WITH_COMPRESSED_OOPS_AND_CONCURRENT_MARK_AND_SWEEP";
        final int r27 = 13;
        JvmInformation r28 = new AnonymousClass14(r26, r27, r25);
        OPENJDK_64_BIT_WITH_COMPRESSED_OOPS_AND_CONCURRENT_MARK_AND_SWEEP = r28;
        final String r29 = "IBM_32_BIT";
        final int r30 = 14;
        final JvmInformation r31 = new AnonymousClass15(r29, r30, r0);
        IBM_32_BIT = r31;
        final String r32 = "IBM_64_BIT";
        final int r33 = 15;
        JvmInformation r34 = new AnonymousClass16(r32, r33, r6);
        IBM_64_BIT = r34;
        final String r35 = "IBM_64_BIT_WITH_COMPRESSED_REFS";
        final int r36 = 16;
        JvmInformation r37 = new AnonymousClass17(r35, r36, r31);
        IBM_64_BIT_WITH_COMPRESSED_REFS = r37;
        $VALUES = new JvmInformation[]{r0, r6, r9, r12, r15, r18, r111, r114, r117, r120, r122, r123, r25, r28, r31, r34, r37};
        c r38 = d.a(JvmInformation.class);
        LOGGER = r38;
        JvmInformation r39 = getJvmInformation();
        CURRENT_JVM_INFORMATION = r39;
        r38.info("Detected JVM data model settings of: " + r39.getJvmDescription());
    }

    private JvmInformation(String r1, int r2, JvmInformation r3) {
        super(r1, r2);
        this.parent = r3;
    }

    /* synthetic */ JvmInformation(String r1, int r2, JvmInformation r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    private static JvmInformation detectHotSpot() {
        if (isHotspot() == true) goto L5;
        return null;
    L5:
        if (is64Bit() == false) goto L19;
        if (isHotspotCompressedOops() == false) goto L12;
        if (isHotspotConcurrentMarkSweepGC() == false) goto L12;
        return HOTSPOT_64_BIT_WITH_COMPRESSED_OOPS_AND_CONCURRENT_MARK_AND_SWEEP;
    L12:
        if (isHotspotCompressedOops() == false) goto L15;
        return HOTSPOT_64_BIT_WITH_COMPRESSED_OOPS;
    L15:
        if (isHotspotConcurrentMarkSweepGC() == false) goto L27;
        return HOTSPOT_64_BIT_WITH_CONCURRENT_MARK_AND_SWEEP;
    L27:
        return HOTSPOT_64_BIT;
    L19:
        if (isHotspotConcurrentMarkSweepGC() == false) goto L29;
        return HOTSPOT_32_BIT_WITH_CONCURRENT_MARK_AND_SWEEP;
    L29:
        return HOTSPOT_32_BIT;
    }

    private static JvmInformation detectIBM() {
        if (isIBM() == true) goto L5;
        return null;
    L5:
        if (is64Bit() == false) goto L15;
        if (isIBMCompressedRefs() == false) goto L14;
        return IBM_64_BIT_WITH_COMPRESSED_REFS;
    L14:
        return IBM_64_BIT;
    L15:
        return IBM_32_BIT;
    }

    private static JvmInformation detectOpenJDK() {
        if (isOpenJDK() == true) goto L5;
        return null;
    L5:
        if (is64Bit() == false) goto L19;
        if (isHotspotCompressedOops() == false) goto L12;
        if (isHotspotConcurrentMarkSweepGC() == false) goto L12;
        return OPENJDK_64_BIT_WITH_COMPRESSED_OOPS_AND_CONCURRENT_MARK_AND_SWEEP;
    L12:
        if (isHotspotCompressedOops() == false) goto L15;
        return OPENJDK_64_BIT_WITH_COMPRESSED_OOPS;
    L15:
        if (isHotspotConcurrentMarkSweepGC() == false) goto L27;
        return OPENJDK_64_BIT_WITH_CONCURRENT_MARK_AND_SWEEP;
    L27:
        return OPENJDK_64_BIT;
    L19:
        if (isHotspotConcurrentMarkSweepGC() == false) goto L29;
        return OPENJDK_32_BIT_WITH_CONCURRENT_MARK_AND_SWEEP;
    L29:
        return OPENJDK_32_BIT;
    }

    private static String getHotSpotVmOptionValue(String r6) {
        return (String) ZeusTransformUtils.preCheckCast(((CompositeData) ZeusTransformUtils.preCheckCast(ManagementFactory.getPlatformMBeanServer().invoke(ObjectName.getInstance("com.sun.management:type=HotSpotDiagnostic"), "getVMOption", new Object[]{r6}, new String[]{"java.lang.String"}), CompositeData.class, "com.obric.memorydata.plugin")).get(EventBody.KEY_VALUE), String.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    private static String getJRockitVmArgs() {
        return getPlatformMBeanAttribute("oracle.jrockit.management:type=PerfCounters", "java.rt.vmArgs");
    }

    private static JvmInformation getJvmInformation() {
        JvmInformation r0 = detectHotSpot();
        if (r0 != null) goto L5;
        r0 = detectOpenJDK();
    L5:
        if (r0 != null) goto L7;
        r0 = detectIBM();
    L7:
        if (r0 == null) goto L9;
    L11:
        if (r0 == null) goto L13;
        return r0;
    L13:
        return UNKNOWN_32_BIT;
    L9:
        if (is64Bit() == false) goto L11;
        return UNKNOWN_64_BIT;
    }

    private static String getPlatformMBeanAttribute(String r2, String r3) {
        Object r4 = ManagementFactory.getPlatformMBeanServer().getAttribute(ObjectName.getInstance(r2), r3);     // Catch: Throwable -> L8
        if (r4 == null) goto L7;
        return r4.toString();
    L7:
        return null;
    }

    private static boolean is64Bit() {
        String r0 = System.getProperty("com.ibm.vm.bitmode");
        if (r0 != null) goto L5;
        String r1 = System.getProperty("sun.arch.data.model");
        if (r1 != null) goto L9;
        String r2 = System.getProperty("java.vm.version");
        if (r2 != null) goto L13;
        return false;
    L13:
        return r2.contains("_64");
    L9:
        return r1.equals(BDLocationException.ERROR_RESTRICTED_MODE_ON);
    L5:
        return r0.equals(BDLocationException.ERROR_RESTRICTED_MODE_ON);
    }

    public static boolean isHotspot() {
        return System.getProperty("java.vm.name", "").toLowerCase().contains("hotspot");
    }

    private static boolean isHotspotCompressedOops() {
        String r0 = getHotSpotVmOptionValue("UseCompressedOops");
        if (r0 != null) goto L7;
        return false;
    L7:
        return Boolean.valueOf(r0).booleanValue();
    }

    private static boolean isHotspotConcurrentMarkSweepGC() {
        Iterator r0 = ManagementFactory.getGarbageCollectorMXBeans().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if ("ConcurrentMarkSweep".equals(((GarbageCollectorMXBean) ZeusTransformUtils.preCheckCast(r0.next(), GarbageCollectorMXBean.class, "com.obric.memorydata.plugin")).getName()) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static boolean isIBM() {
        if (System.getProperty("java.vm.name", "").contains("IBM") == true) goto L5;
    L7:
        return false;
    L5:
        if (System.getProperty("java.vm.vendor").contains("IBM") == false) goto L7;
        return true;
    }

    private static boolean isIBMCompressedRefs() {
        return System.getProperty("com.ibm.oti.vm.bootstrap.library.path", "").contains("compressedrefs");
    }

    public static boolean isJRockit() {
        if (System.getProperty("jrockit.version") == null) goto L5;
    L8:
        return true;
    L5:
        if (System.getProperty("java.vm.name", "").toLowerCase().contains("jrockit") == true) goto L8;
        return false;
    }

    private static boolean isJRockit64GBCompression() {
        if (getJRockitVmArgs().contains("-XXcompressedRefs:enable=false") == false) goto L6;
        return false;
    L6:
        if (getJRockitVmArgs().contains("-XXcompressedRefs:size=4GB") == false) goto L8;
    L20:
        return false;
    L8:
        if (getJRockitVmArgs().contains("-XXcompressedRefs:size=32GB") == true) goto L20;
        if (getJRockitVmArgs().contains("-XXcompressedRefs:size=64GB") == false) goto L13;
        return true;
    L13:
        long r3 = Runtime.getRuntime().maxMemory();
        if (r3 <= TWENTY_FIVE_GB) goto L20;
        if (r3 > FIFTY_SEVEN_GB) goto L20;
        if (getJRockitVmArgs().contains("-XXcompressedRefs:enable=true") == false) goto L20;
        return true;
    }

    public static boolean isOSX() {
        String r0 = System.getProperty("java.vm.vendor");
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.startsWith("Apple") == false) goto L7;
        return true;
    }

    public static boolean isOpenJDK() {
        return System.getProperty("java.vm.name", "").toLowerCase().contains("openjdk");
    }

    public static JvmInformation valueOf(String r2) {
        return (JvmInformation) ZeusTransformUtils.preCheckCast(Enum.valueOf(JvmInformation.class, r2), JvmInformation.class, "com.obric.memorydata.plugin");
    }

    public static JvmInformation[] values() {
        return (JvmInformation[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), JvmInformation[].class, "com.obric.memorydata.plugin");
    }

    public int getAgentSizeOfAdjustment() {
        return this.parent.getAgentSizeOfAdjustment();
    }

    public int getFieldOffsetAdjustment() {
        return this.parent.getFieldOffsetAdjustment();
    }

    public int getJavaPointerSize() {
        return this.parent.getJavaPointerSize();
    }

    public abstract String getJvmDescription();

    public int getMinimumObjectSize() {
        return getObjectAlignment();
    }

    public int getObjectAlignment() {
        return this.parent.getObjectAlignment();
    }

    public int getObjectHeaderSize() {
        return getPointerSize() + getJavaPointerSize();
    }

    public int getPointerSize() {
        return this.parent.getPointerSize();
    }

    public boolean supportsAgentSizeOf() {
        return this.parent.supportsAgentSizeOf();
    }

    public boolean supportsReflectionSizeOf() {
        return this.parent.supportsReflectionSizeOf();
    }

    public boolean supportsUnsafeSizeOf() {
        return this.parent.supportsUnsafeSizeOf();
    }
}
