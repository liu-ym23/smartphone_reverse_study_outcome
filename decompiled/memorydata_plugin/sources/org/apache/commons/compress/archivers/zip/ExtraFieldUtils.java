package org.apache.commons.compress.archivers.zip;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipException;

/* JADX INFO: loaded from: classes6.dex */
public class ExtraFieldUtils {
    static final ZipExtraField[] EMPTY_ZIP_EXTRA_FIELD_ARRAY = null;
    private static final Map<ZipShort, Class<?>> implementations = null;

    public static final class UnparseableExtraField implements UnparseableExtraFieldBehavior {
        public static final UnparseableExtraField READ = null;
        public static final UnparseableExtraField SKIP = null;
        public static final UnparseableExtraField THROW = null;
        private final int key;

        static {
            THROW = new UnparseableExtraField(0);
            SKIP = new UnparseableExtraField(1);
            READ = new UnparseableExtraField(2);
        }

        private UnparseableExtraField(int r1) {
            this.key = r1;
        }

        @Override // org.apache.commons.compress.archivers.zip.UnparseableExtraFieldBehavior
        public ZipExtraField onUnparseableExtraField(byte[] r2, int r3, int r4, boolean r5, int r6) {
            int r0 = this.key;
            if (r0 == 0) goto L18;
            if (r0 != 1) goto L7;
            return null;
        L7:
            if (r0 != 2) goto L14;
            UnparseableExtraFieldData r1 = new UnparseableExtraFieldData();
            if (r5 == false) goto L11;
            r1.parseFromLocalFileData(r2, r3, r4);
        L12:
            return r1;
        L11:
            r1.parseFromCentralDirectoryData(r2, r3, r4);
            goto L12
        L14:
            throw new ZipException("Unknown UnparseableExtraField key: " + this.key);
        L18:
            throw new ZipException("Bad extra field starting at " + r3 + ".  Block length of " + r6 + " bytes exceeds remaining data of " + (r4 - 4) + " bytes.");
        }
    }

    static {
        implementations = new ConcurrentHashMap();
        register(AsiExtraField.class);
        register(X5455_ExtendedTimestamp.class);
        register(X7875_NewUnix.class);
        register(JarMarker.class);
        register(UnicodePathExtraField.class);
        register(UnicodeCommentExtraField.class);
        register(Zip64ExtendedInformationExtraField.class);
        register(X000A_NTFS.class);
        register(X0014_X509Certificates.class);
        register(X0015_CertificateIdForFile.class);
        register(X0016_CertificateIdForCentralDirectory.class);
        register(X0017_StrongEncryptionHeader.class);
        register(X0019_EncryptionRecipientCertificateList.class);
        register(ResourceAlignmentExtraField.class);
        EMPTY_ZIP_EXTRA_FIELD_ARRAY = new ZipExtraField[0];
    }

    public static ZipExtraField createExtraField(ZipShort r1) {
        ZipExtraField r0 = createExtraFieldNoDefault(r1);
        if (r0 == null) goto L5;
        return r0;
    L5:
        UnrecognizedExtraField r2 = new UnrecognizedExtraField();
        r2.setHeaderId(r1);
        return r2;
    }

    public static ZipExtraField createExtraFieldNoDefault(ZipShort r2) {
        Class r3 = (Class) ZeusTransformUtils.preCheckCast(implementations.get(r2), Class.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return null;
    L5:
        return (ZipExtraField) ZeusTransformUtils.preCheckCast(r3.newInstance(), ZipExtraField.class, "com.obric.memorydata.plugin");
    }

    public static ZipExtraField fillExtraField(ZipExtraField r2, byte[] r3, int r4, int r5, boolean r6) {
        ZipExtraField r7 = (ZipExtraField) ZeusTransformUtils.wrapperContextForParams(r2, ZipExtraField.class, "com.obric.memorydata.plugin");
        if (r6 == false) goto L5;
        r7.parseFromLocalFileData(r3, r4, r5);     // Catch: ArrayIndexOutOfBoundsException -> L7
    L10:
        return r7;
    L5:
        r7.parseFromCentralDirectoryData(r3, r4, r5);     // Catch: ArrayIndexOutOfBoundsException -> L7
    L7:
        e = move-exception;
        throw ((ZipException) ZeusTransformUtils.preCheckCast(new ZipException("Failed to parse corrupt ZIP extra field of type " + Integer.toHexString(r7.getHeaderId().getValue())).initCause(e), ZipException.class, "com.obric.memorydata.plugin"));
    }

    public static byte[] mergeCentralDirectoryData(ZipExtraField[] r11) {
        int r0 = r11.length;
        if (r0 > 0) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        int r4 = r0 - 1;
    L11:
        int r5 = r4 * 4;
        int r6 = r11.length;
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L14;
        r5 = r5 + r11[r7].getCentralDirectoryLength().getValue();
        r7 = r7 + 1;
        goto L12
    L14:
        byte[] r8 = new byte[r5];
        int r9 = 0;
        int r10 = 0;
    L15:
        if (r9 >= r4) goto L20;
        System.arraycopy(r11[r9].getHeaderId().getBytes(), 0, r8, r10, 2);
        System.arraycopy(r11[r9].getCentralDirectoryLength().getBytes(), 0, r8, r10 + 2, 2);
        r10 = r10 + 4;
        byte[] r12 = r11[r9].getCentralDirectoryData();
        if (r12 == null) goto L19;
        System.arraycopy(r12, 0, r8, r10, r12.length);
        r10 = r10 + r12.length;
    L19:
        r9 = r9 + 1;
        goto L15
    L20:
        if (r3 == false) goto L24;
        byte[] r13 = r11[r0 - 1].getCentralDirectoryData();
        if (r13 == null) goto L24;
        System.arraycopy(r13, 0, r8, r10, r13.length);
    L24:
        return r8;
    L10:
        r4 = r0;
        goto L11
    L5:
        if (ZeusTransformUtils.instanceOf(r11[r0 - 1], UnparseableExtraFieldData.class) == false) goto L7;
        r3 = true;
        goto L8
    }

    public static byte[] mergeLocalFileDataData(ZipExtraField[] r11) {
        int r0 = r11.length;
        if (r0 > 0) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == false) goto L10;
        int r4 = r0 - 1;
    L11:
        int r5 = r4 * 4;
        int r6 = r11.length;
        int r7 = 0;
    L12:
        if (r7 >= r6) goto L14;
        r5 = r5 + r11[r7].getLocalFileDataLength().getValue();
        r7 = r7 + 1;
        goto L12
    L14:
        byte[] r8 = new byte[r5];
        int r9 = 0;
        int r10 = 0;
    L15:
        if (r9 >= r4) goto L20;
        System.arraycopy(r11[r9].getHeaderId().getBytes(), 0, r8, r10, 2);
        System.arraycopy(r11[r9].getLocalFileDataLength().getBytes(), 0, r8, r10 + 2, 2);
        r10 = r10 + 4;
        byte[] r12 = r11[r9].getLocalFileDataData();
        if (r12 == null) goto L19;
        System.arraycopy(r12, 0, r8, r10, r12.length);
        r10 = r10 + r12.length;
    L19:
        r9 = r9 + 1;
        goto L15
    L20:
        if (r3 == false) goto L24;
        byte[] r13 = r11[r0 - 1].getLocalFileDataData();
        if (r13 == null) goto L24;
        System.arraycopy(r13, 0, r8, r10, r13.length);
    L24:
        return r8;
    L10:
        r4 = r0;
        goto L11
    L5:
        if (ZeusTransformUtils.instanceOf(r11[r0 - 1], UnparseableExtraFieldData.class) == false) goto L7;
        r3 = true;
        goto L8
    }

    public static ZipExtraField[] parse(byte[] r11, boolean r12, ExtraFieldParsingBehavior r13) {
        ExtraFieldParsingBehavior r14 = (ExtraFieldParsingBehavior) ZeusTransformUtils.wrapperContextForParams(r13, ExtraFieldParsingBehavior.class, "com.obric.memorydata.plugin");
        ArrayList r0 = new ArrayList();
        int r8 = r11.length;
        int r9 = 0;
    L4:
        if (r9 > (r8 - 4)) goto L16;
        ZipShort r2 = new ZipShort(r11, r9);
        int r10 = new ZipShort(r11, r9 + 2).getValue();
        int r5 = r9 + 4;
        if ((r5 + r10) > r8) goto L7;
        r0.add(Objects.requireNonNull(r14.fill((ZipExtraField) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r14.createExtraField(r2), "createExtraField must not return null"), ZipExtraField.class, "com.obric.memorydata.plugin"), r11, r5, r10, r12), "fill must not return null"));     // Catch: Throwable -> L12
        r9 = r9 + (r10 + 4);
    L12:
        e = move-exception;
        throw ((ZipException) ZeusTransformUtils.preCheckCast(new ZipException(e.getMessage()).initCause(e), ZipException.class, "com.obric.memorydata.plugin"));
    L7:
        ZipExtraField r15 = r14.onUnparseableExtraField(r11, r9, r8 - r9, r12, r10);
        if (r15 == null) goto L16;
        r0.add(r15);
    L16:
        return (ZipExtraField[]) ZeusTransformUtils.preCheckCast(r0.toArray(EMPTY_ZIP_EXTRA_FIELD_ARRAY), ZipExtraField[].class, "com.obric.memorydata.plugin");
    }

    public static void register(Class<?> r3) {
        implementations.put(((ZipExtraField) ZeusTransformUtils.preCheckCast(r3.newInstance(), ZipExtraField.class, "com.obric.memorydata.plugin")).getHeaderId(), r3);     // Catch: IllegalAccessException -> L4 InstantiationException -> L6 ClassCastException -> L8
        return;
    L9:
        throw new RuntimeException(r3 + " doesn't implement ZipExtraField");
    L5:
        throw new RuntimeException(r3 + "'s no-arg constructor is not public");
    L7:
        throw new RuntimeException(r3 + " is not a concrete class");
    }
}
