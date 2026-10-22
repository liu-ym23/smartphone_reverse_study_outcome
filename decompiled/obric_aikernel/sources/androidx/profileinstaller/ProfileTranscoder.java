package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
class ProfileTranscoder {
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    static final byte[] MAGIC_PROF = null;
    static final byte[] MAGIC_PROFM = null;
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;

    static {
        MAGIC_PROF = new byte[]{112, 114, 111, 0};
        MAGIC_PROFM = new byte[]{112, 114, 109, 0};
    }

    private ProfileTranscoder() {
    }

    private static int computeMethodFlags(@NonNull DexProfileData r10) {
        Iterator<Map.Entry<Integer, Integer>> r11 = r10.methods.entrySet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 | r11.next().getValue().intValue();
        goto L4
    L6:
        return r12;
    }

    @NonNull
    private static byte[] createCompressibleBody(@NonNull DexProfileData[] r10, @NonNull byte[] r11) {
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r12) goto L5;
        DexProfileData r16 = r10[r14];
        r15 = r15 + ((((Encoding.utf8Length(generateDexKey(r16.apkName, r16.dexName, r11)) + 16) + (r16.classSetSize * 2)) + r16.hotMethodRegionSize) + getMethodBitmapStorageSize(r16.numMethodIds));
        r14 = r14 + 1;
        goto L3
    L5:
        ByteArrayOutputStream r17 = new ByteArrayOutputStream(r15);
        if (Arrays.equals(r11, ProfileVersion.V009_O_MR1) == false) goto L10;
        int r18 = r10.length;
    L8:
        if (r13 >= r18) goto L17;
        DexProfileData r19 = r10[r13];
        writeLineHeader(r17, r19, generateDexKey(r19.apkName, r19.dexName, r11));
        writeLineData(r17, r19);
        r13 = r13 + 1;
    L17:
        if (r17.size() != r15) goto L21;
        return r17.toByteArray();
    L21:
        throw Encoding.error("The bytes saved do not match expectation. actual=" + r17.size() + " expected=" + r15);
    L10:
        int r20 = r10.length;
        int r21 = 0;
    L11:
        if (r21 >= r20) goto L13;
        DexProfileData r22 = r10[r21];
        writeLineHeader(r17, r22, generateDexKey(r22.apkName, r22.dexName, r11));
        r21 = r21 + 1;
        goto L11
    L13:
        int r23 = r10.length;
    L14:
        if (r13 >= r23) goto L17;
        writeLineData(r17, r10[r13]);
        r13 = r13 + 1;
        goto L14
    }

    private static WritableFileSection createCompressibleClassSection(@NonNull DexProfileData[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        int r12 = 0;
        int r13 = 0;
    L19:
    L13:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        if (r12 >= r10.length) goto L6;
        DexProfileData r14 = r10[r12];     // Catch: Throwable -> L13
        Encoding.writeUInt16(r11, r12);     // Catch: Throwable -> L13
        Encoding.writeUInt16(r11, r14.classSetSize);     // Catch: Throwable -> L13
        r13 = ((r13 + 2) + 2) + (r14.classSetSize * 2);     // Catch: Throwable -> L13
        writeClasses(r11, r14);     // Catch: Throwable -> L13
        r12 = r12 + 1;     // Catch: Throwable -> L13
        goto L19
    L6:
        byte[] r15 = r11.toByteArray();     // Catch: Throwable -> L13
        if (r13 != r15.length) goto L12;
        WritableFileSection r16 = new WritableFileSection(FileSectionType.CLASSES, r13, r15, true);     // Catch: Throwable -> L13
        r11.close();
        return r16;
    L12:
        throw Encoding.error("Expected size " + r13 + ", does not match actual size " + r15.length);     // Catch: Throwable -> L13
    }

    private static WritableFileSection createCompressibleMethodsSection(@NonNull DexProfileData[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        int r12 = 0;
        int r13 = 0;
    L19:
    L13:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L16
    L18:
        throw th;
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    L4:
        if (r12 >= r10.length) goto L6;
        DexProfileData r14 = r10[r12];     // Catch: Throwable -> L13
        int r15 = computeMethodFlags(r14);     // Catch: Throwable -> L13
        byte[] r16 = createMethodBitmapRegion(r14);     // Catch: Throwable -> L13
        byte[] r17 = createMethodsWithInlineCaches(r14);     // Catch: Throwable -> L13
        Encoding.writeUInt16(r11, r12);     // Catch: Throwable -> L13
        int r18 = (r16.length + 2) + r17.length;     // Catch: Throwable -> L13
        Encoding.writeUInt32(r11, r18);     // Catch: Throwable -> L13
        Encoding.writeUInt16(r11, r15);     // Catch: Throwable -> L13
        r11.write(r16);     // Catch: Throwable -> L13
        r11.write(r17);     // Catch: Throwable -> L13
        r13 = ((r13 + 2) + 4) + r18;     // Catch: Throwable -> L13
        r12 = r12 + 1;     // Catch: Throwable -> L13
        goto L19
    L6:
        byte[] r19 = r11.toByteArray();     // Catch: Throwable -> L13
        if (r13 != r19.length) goto L12;
        WritableFileSection r20 = new WritableFileSection(FileSectionType.METHODS, r13, r19, true);     // Catch: Throwable -> L13
        r11.close();
        return r20;
    L12:
        throw Encoding.error("Expected size " + r13 + ", does not match actual size " + r19.length);     // Catch: Throwable -> L13
    }

    private static byte[] createMethodBitmapRegion(@NonNull DexProfileData r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        writeMethodBitmap(r11, r10);     // Catch: Throwable -> L6
        byte[] r12 = r11.toByteArray();     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static byte[] createMethodsWithInlineCaches(@NonNull DexProfileData r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        writeMethodsWithInlineCaches(r11, r10);     // Catch: Throwable -> L6
        byte[] r12 = r11.toByteArray();     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @NonNull
    private static String enforceSeparator(@NonNull String r10, @NonNull String r11) {
        if ("!".equals(r11) == false) goto L7;
        return r10.replace(":", "!");
    L7:
        if (":".equals(r11) == true) goto L9;
        return r10;
    L9:
        return r10.replace("!", ":");
    }

    @NonNull
    private static String extractKey(@NonNull String r10) {
        int r11 = r10.indexOf("!");
        if (r11 >= 0) goto L5;
        r11 = r10.indexOf(":");
    L5:
        if (r11 > 0) goto L7;
        return r10;
    L7:
        return r10.substring(r11 + 1);
    }

    @Nullable
    private static DexProfileData findByDexName(@NonNull DexProfileData[] r10, @NonNull String r11) {
        if (r10.length > 0) goto L5;
        return null;
    L5:
        String r12 = extractKey(r11);
        int r13 = 0;
    L7:
        if (r13 >= r10.length) goto L13;
        if (r10[r13].dexName.equals(r12) == true) goto L11;
        r13 = r13 + 1;
        goto L7
    L11:
        return r10[r13];
    L13:
        return null;
    }

    @NonNull
    private static String generateDexKey(@NonNull String r10, @NonNull String r11, @NonNull byte[] r12) {
        String r13 = ProfileVersion.dexKeySeparator(r12);
        if (r10.length() > 0) goto L7;
        return enforceSeparator(r11, r13);
    L7:
        if (r11.equals("classes.dex") == false) goto L10;
        return r10;
    L10:
        if (r11.contains("!") == true) goto L20;
        if (r11.contains(":") == true) goto L20;
        if (r11.endsWith(".apk") == false) goto L18;
        return r11;
    L18:
        return r10 + ProfileVersion.dexKeySeparator(r12) + r11;
    L20:
        return enforceSeparator(r11, r13);
    }

    private static int getMethodBitmapStorageSize(int r10) {
        return roundUpToByte(r10 * 2) / 8;
    }

    private static int methodFlagBitmapIndex(int r10, int r11, int r12) {
        if (r10 == 1) goto L14;
        if (r10 != 2) goto L7;
        return r11;
    L7:
        if (r10 != 4) goto L11;
        return r11 + r12;
    L11:
        throw Encoding.error("Unexpected flag: " + r10);
    L14:
        throw Encoding.error("HOT methods are not stored in the bitmap");
    }

    private static int[] readClasses(@NonNull InputStream r10, int r11) {
        int[] r12 = new int[r11];
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r14 = r14 + Encoding.readUInt16(r10);
        r12[r13] = r14;
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    private static int readFlagsFromBitmap(@NonNull BitSet r10, int r11, int r12) {
        int r13 = 2;
        if (r10.get(methodFlagBitmapIndex(2, r11, r12)) == true) goto L7;
        r13 = 0;
    L7:
        if (r10.get(methodFlagBitmapIndex(4, r11, r12)) == true) goto L9;
        return r13;
    L9:
        return r13 | 4;
    }

    static byte[] readHeader(@NonNull InputStream r10, @NonNull byte[] r11) {
        if (Arrays.equals(r11, Encoding.read(r10, r11.length)) == false) goto L7;
        return Encoding.read(r10, ProfileVersion.V010_P.length);
    L7:
        throw Encoding.error("Invalid magic");
    }

    private static void readHotMethodRegion(@NonNull InputStream r10, @NonNull DexProfileData r11) {
        int r12 = r10.available() - r11.hotMethodRegionSize;
        int r13 = 0;
    L4:
        if (r10.available() <= r12) goto L9;
        r13 = r13 + Encoding.readUInt16(r10);
        r11.methods.put(Integer.valueOf(r13), 1);
        int r14 = Encoding.readUInt16(r10);
    L6:
        if (r14 <= 0) goto L4;
        skipInlineCache(r10);
        r14 = r14 - 1;
        goto L6
    L9:
        if (r10.available() != r12) goto L12;
        return;
    L12:
        throw Encoding.error("Read too much data during profile line parse");
    }

    @NonNull
    static DexProfileData[] readMeta(@NonNull InputStream r10, @NonNull byte[] r11, @NonNull byte[] r12, DexProfileData[] r13) {
        if (Arrays.equals(r11, ProfileVersion.METADATA_V001_N) == false) goto L11;
        if (Arrays.equals(ProfileVersion.V015_S, r12) == true) goto L9;
        return readMetadata001(r10, r11, r13);
    L9:
        throw Encoding.error("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
    L11:
        if (Arrays.equals(r11, ProfileVersion.METADATA_V002) == false) goto L15;
        return readMetadataV002(r10, r12, r13);
    L15:
        throw Encoding.error("Unsupported meta version");
    }

    @NonNull
    static DexProfileData[] readMetadata001(@NonNull InputStream r10, @NonNull byte[] r11, DexProfileData[] r12) {
        if (Arrays.equals(r11, ProfileVersion.METADATA_V001_N) == false) goto L19;
        int r13 = Encoding.readUInt8(r10);
        long r14 = Encoding.readUInt32(r10);
        byte[] r15 = Encoding.readCompressed(r10, (int) Encoding.readUInt32(r10), (int) r14);
        if (r10.read() > 0) goto L17;
        ByteArrayInputStream r16 = new ByteArrayInputStream(r15);
        DexProfileData[] r17 = readMetadataForNBody(r16, r13, r12);     // Catch: Throwable -> L10
        r16.close();
        return r17;
    L10:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw Encoding.error("Content found after the end of file");
    L19:
        throw Encoding.error("Unsupported meta version");
    }

    @NonNull
    private static DexProfileData[] readMetadataForNBody(@NonNull InputStream r10, int r11, DexProfileData[] r12) {
        int r13 = 0;
        if (r10.available() != 0) goto L7;
        return new DexProfileData[0];
    L7:
        if (r11 != r12.length) goto L19;
        String[] r14 = new String[r11];
        int[] r15 = new int[r11];
        int r16 = 0;
    L9:
        if (r16 >= r11) goto L11;
        int r17 = Encoding.readUInt16(r10);
        r15[r16] = Encoding.readUInt16(r10);
        r14[r16] = Encoding.readString(r10, r17);
        r16 = r16 + 1;
    L11:
        if (r13 >= r11) goto L17;
        DexProfileData r18 = r12[r13];
        if (r18.dexName.equals(r14[r13]) == false) goto L16;
        int r19 = r15[r13];
        r18.classSetSize = r19;
        r18.classes = readClasses(r10, r19);
        r13 = r13 + 1;
        goto L11
    L16:
        throw Encoding.error("Order of dexfiles in metadata did not match baseline");
    L17:
        return r12;
    L19:
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    @NonNull
    static DexProfileData[] readMetadataV002(@NonNull InputStream r10, @NonNull byte[] r11, DexProfileData[] r12) {
        int r13 = Encoding.readUInt16(r10);
        long r14 = Encoding.readUInt32(r10);
        byte[] r15 = Encoding.readCompressed(r10, (int) Encoding.readUInt32(r10), (int) r14);
        if (r10.read() > 0) goto L15;
        ByteArrayInputStream r16 = new ByteArrayInputStream(r15);
        DexProfileData[] r17 = readMetadataV002Body(r16, r11, r13, r12);     // Catch: Throwable -> L8
        r16.close();
        return r17;
    L8:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L11
    L13:
        throw th;
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    L15:
        throw Encoding.error("Content found after the end of file");
    }

    @NonNull
    private static DexProfileData[] readMetadataV002Body(@NonNull InputStream r10, @NonNull byte[] r11, int r12, DexProfileData[] r13) {
        int r14 = 0;
        if (r10.available() != 0) goto L7;
        return new DexProfileData[0];
    L7:
        if (r12 != r13.length) goto L19;
    L8:
        if (r14 >= r12) goto L17;
        Encoding.readUInt16(r10);
        String r15 = Encoding.readString(r10, Encoding.readUInt16(r10));
        long r16 = Encoding.readUInt32(r10);
        int r17 = Encoding.readUInt16(r10);
        DexProfileData r18 = findByDexName(r13, r15);
        if (r18 == null) goto L16;
        r18.mTypeIdCount = r16;
        int[] r19 = readClasses(r10, r17);
        if (Arrays.equals(r11, ProfileVersion.V001_N) == false) goto L14;
        r18.classSetSize = r17;
        r18.classes = r19;
    L14:
        r14 = r14 + 1;
        goto L8
    L16:
        throw Encoding.error("Missing profile key: " + r15);
    L17:
        return r13;
    L19:
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    private static void readMethodBitmap(@NonNull InputStream r10, @NonNull DexProfileData r11) {
        BitSet r12 = BitSet.valueOf(Encoding.read(r10, Encoding.bitsToBytes(r11.numMethodIds * 2)));
        int r13 = 0;
    L3:
        int r14 = r11.numMethodIds;
        if (r13 >= r14) goto L12;
        int r15 = readFlagsFromBitmap(r12, r13, r14);
        if (r15 == 0) goto L11;
        Integer r16 = r11.methods.get(Integer.valueOf(r13));
        if (r16 != null) goto L10;
        r16 = 0;
    L10:
        r11.methods.put(Integer.valueOf(r13), Integer.valueOf(r15 | r16.intValue()));
    L11:
        r13 = r13 + 1;
        goto L3
    }

    @NonNull
    static DexProfileData[] readProfile(@NonNull InputStream r10, @NonNull byte[] r11, @NonNull String r12) {
        if (Arrays.equals(r11, ProfileVersion.V010_P) == false) goto L19;
        int r13 = Encoding.readUInt8(r10);
        long r14 = Encoding.readUInt32(r10);
        byte[] r15 = Encoding.readCompressed(r10, (int) Encoding.readUInt32(r10), (int) r14);
        if (r10.read() > 0) goto L17;
        ByteArrayInputStream r16 = new ByteArrayInputStream(r15);
        DexProfileData[] r17 = readUncompressedBody(r16, r12, r13);     // Catch: Throwable -> L10
        r16.close();
        return r17;
    L10:
        th = move-exception;
        r16.close();     // Catch: Throwable -> L13
    L15:
        throw th;
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw Encoding.error("Content found after the end of file");
    L19:
        throw Encoding.error("Unsupported version");
    }

    @NonNull
    private static DexProfileData[] readUncompressedBody(@NonNull InputStream r20, @NonNull String r21, int r22) {
        int r10 = 0;
        if (r20.available() == 0) goto L5;
        DexProfileData[] r11 = new DexProfileData[r22];
        int r12 = 0;
    L7:
        if (r12 >= r22) goto L9;
        int r13 = Encoding.readUInt16(r20);
        int r14 = Encoding.readUInt16(r20);
        long r15 = Encoding.readUInt32(r20);
        r11[r12] = new DexProfileData(r21, Encoding.readString(r20, r13), Encoding.readUInt32(r20), 0, r14, (int) r15, (int) Encoding.readUInt32(r20), new int[r14], new TreeMap());
        r12 = r12 + 1;
    L9:
        if (r10 >= r22) goto L11;
        DexProfileData r16 = r11[r10];
        readHotMethodRegion(r20, r16);
        r16.classes = readClasses(r20, r16.classSetSize);
        readMethodBitmap(r20, r16);
        r10 = r10 + 1;
        goto L9
    L11:
        return r11;
    L5:
        return new DexProfileData[0];
    }

    private static int roundUpToByte(int r10) {
        return ((r10 + 8) - 1) & (-8);
    }

    private static void setMethodBitmapBit(@NonNull byte[] r10, int r11, int r12, @NonNull DexProfileData r13) {
        int r14 = methodFlagBitmapIndex(r11, r12, r13.numMethodIds);
        int r15 = r14 / 8;
        int r16 = 1 << (r14 % 8);
        r10[r15] = (byte) (r16 | r10[r15]);
    }

    private static void skipInlineCache(@NonNull InputStream r10) {
        Encoding.readUInt16(r10);
        int r11 = Encoding.readUInt8(r10);
        if (r11 != 6) goto L6;
        return;
    L6:
        if (r11 != 7) goto L8;
        return;
    L8:
        if (r11 <= 0) goto L13;
        Encoding.readUInt8(r10);
        int r12 = Encoding.readUInt8(r10);
    L10:
        if (r12 <= 0) goto L12;
        Encoding.readUInt16(r10);
        r12 = r12 - 1;
        goto L10
    L12:
        r11 = r11 - 1;
        goto L8
    }

    static boolean transcodeAndWriteBody(@NonNull OutputStream r10, @NonNull byte[] r11, @NonNull DexProfileData[] r12) {
        if (Arrays.equals(r11, ProfileVersion.V015_S) == false) goto L7;
        writeProfileForS(r10, r12);
        return true;
    L7:
        if (Arrays.equals(r11, ProfileVersion.V010_P) == false) goto L11;
        writeProfileForP(r10, r12);
        return true;
    L11:
        if (Arrays.equals(r11, ProfileVersion.V005_O) == false) goto L15;
        writeProfileForO(r10, r12);
        return true;
    L15:
        if (Arrays.equals(r11, ProfileVersion.V009_O_MR1) == false) goto L19;
        writeProfileForO_MR1(r10, r12);
        return true;
    L19:
        if (Arrays.equals(r11, ProfileVersion.V001_N) == false) goto L22;
        writeProfileForN(r10, r12);
        return true;
    L22:
        return false;
    }

    private static void writeClasses(@NonNull OutputStream r10, @NonNull DexProfileData r11) {
        int[] r12 = r11.classes;
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        Integer r16 = Integer.valueOf(r12[r14]);
        Encoding.writeUInt16(r10, r16.intValue() - r15);
        r15 = r16.intValue();
        r14 = r14 + 1;
        goto L3
    }

    private static WritableFileSection writeDexFileSection(@NonNull DexProfileData[] r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        Encoding.writeUInt16(r11, r10.length);     // Catch: Throwable -> L14
        int r12 = 0;
        int r13 = 2;
    L5:
        if (r12 >= r10.length) goto L7;
        DexProfileData r14 = r10[r12];     // Catch: Throwable -> L14
        Encoding.writeUInt32(r11, r14.dexChecksum);     // Catch: Throwable -> L14
        Encoding.writeUInt32(r11, r14.mTypeIdCount);     // Catch: Throwable -> L14
        Encoding.writeUInt32(r11, r14.numMethodIds);     // Catch: Throwable -> L14
        String r15 = generateDexKey(r14.apkName, r14.dexName, ProfileVersion.V015_S);     // Catch: Throwable -> L14
        int r16 = Encoding.utf8Length(r15);     // Catch: Throwable -> L14
        Encoding.writeUInt16(r11, r16);     // Catch: Throwable -> L14
        r13 = ((((r13 + 4) + 4) + 4) + 2) + (r16 * 1);     // Catch: Throwable -> L14
        Encoding.writeString(r11, r15);     // Catch: Throwable -> L14
        r12 = r12 + 1;     // Catch: Throwable -> L14
        goto L5
    L7:
        byte[] r17 = r11.toByteArray();     // Catch: Throwable -> L14
        if (r13 != r17.length) goto L13;
        WritableFileSection r18 = new WritableFileSection(FileSectionType.DEX_FILES, r13, r17, false);     // Catch: Throwable -> L14
        r11.close();
        return r18;
    L13:
        throw Encoding.error("Expected size " + r13 + ", does not match actual size " + r17.length);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r11.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    }

    static void writeHeader(@NonNull OutputStream r10, byte[] r11) {
        r10.write(MAGIC_PROF);
        r10.write(r11);
    }

    private static void writeLineData(@NonNull OutputStream r10, @NonNull DexProfileData r11) {
        writeMethodsWithInlineCaches(r10, r11);
        writeClasses(r10, r11);
        writeMethodBitmap(r10, r11);
    }

    private static void writeLineHeader(@NonNull OutputStream r10, @NonNull DexProfileData r11, @NonNull String r12) {
        Encoding.writeUInt16(r10, Encoding.utf8Length(r12));
        Encoding.writeUInt16(r10, r11.classSetSize);
        Encoding.writeUInt32(r10, r11.hotMethodRegionSize);
        Encoding.writeUInt32(r10, r11.dexChecksum);
        Encoding.writeUInt32(r10, r11.numMethodIds);
        Encoding.writeString(r10, r12);
    }

    private static void writeMethodBitmap(@NonNull OutputStream r10, @NonNull DexProfileData r11) {
        byte[] r12 = new byte[getMethodBitmapStorageSize(r11.numMethodIds)];
        Iterator<Map.Entry<Integer, Integer>> r13 = r11.methods.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Map.Entry<Integer, Integer> r14 = r13.next();
        int r15 = r14.getKey().intValue();
        int r16 = r14.getValue().intValue();
        if ((r16 & 2) == 0) goto L9;
        setMethodBitmapBit(r12, 2, r15, r11);
    L9:
        if ((r16 & 4) == 0) goto L4;
        setMethodBitmapBit(r12, 4, r15, r11);
        goto L4
    L11:
        r10.write(r12);
    }

    private static void writeMethodsWithInlineCaches(@NonNull OutputStream r10, @NonNull DexProfileData r11) {
        Iterator<Map.Entry<Integer, Integer>> r12 = r11.methods.entrySet().iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<Integer, Integer> r14 = r12.next();
        int r15 = r14.getKey().intValue();
        if ((r14.getValue().intValue() & 1) == 0) goto L4;
        Encoding.writeUInt16(r10, r15 - r13);
        Encoding.writeUInt16(r10, 0);
        r13 = r15;
        goto L4
    }

    private static void writeProfileForN(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) {
        Encoding.writeUInt16(r10, r11.length);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        DexProfileData r14 = r11[r13];
        String r15 = generateDexKey(r14.apkName, r14.dexName, ProfileVersion.V001_N);
        Encoding.writeUInt16(r10, Encoding.utf8Length(r15));
        Encoding.writeUInt16(r10, r14.methods.size());
        Encoding.writeUInt16(r10, r14.classes.length);
        Encoding.writeUInt32(r10, r14.dexChecksum);
        Encoding.writeString(r10, r15);
        Iterator<Integer> r16 = r14.methods.keySet().iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        Encoding.writeUInt16(r10, r16.next().intValue());
        goto L6
    L8:
        int[] r17 = r14.classes;
        int r18 = r17.length;
        int r19 = 0;
    L9:
        if (r19 >= r18) goto L11;
        Encoding.writeUInt16(r10, r17[r19]);
        r19 = r19 + 1;
        goto L9
    L11:
        r13 = r13 + 1;
        goto L3
    }

    private static void writeProfileForO(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) {
        Encoding.writeUInt8(r10, r11.length);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        DexProfileData r14 = r11[r13];
        int r15 = r14.methods.size() * 4;
        String r16 = generateDexKey(r14.apkName, r14.dexName, ProfileVersion.V005_O);
        Encoding.writeUInt16(r10, Encoding.utf8Length(r16));
        Encoding.writeUInt16(r10, r14.classes.length);
        Encoding.writeUInt32(r10, r15);
        Encoding.writeUInt32(r10, r14.dexChecksum);
        Encoding.writeString(r10, r16);
        Iterator<Integer> r17 = r14.methods.keySet().iterator();
    L6:
        if (r17.hasNext() == false) goto L8;
        Encoding.writeUInt16(r10, r17.next().intValue());
        Encoding.writeUInt16(r10, 0);
        goto L6
    L8:
        int[] r18 = r14.classes;
        int r19 = r18.length;
        int r20 = 0;
    L9:
        if (r20 >= r19) goto L11;
        Encoding.writeUInt16(r10, r18[r20]);
        r20 = r20 + 1;
        goto L9
    L11:
        r13 = r13 + 1;
        goto L3
    }

    private static void writeProfileForO_MR1(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) {
        byte[] r12 = createCompressibleBody(r11, ProfileVersion.V009_O_MR1);
        Encoding.writeUInt8(r10, r11.length);
        Encoding.writeCompressed(r10, r12);
    }

    private static void writeProfileForP(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) {
        byte[] r12 = createCompressibleBody(r11, ProfileVersion.V010_P);
        Encoding.writeUInt8(r10, r11.length);
        Encoding.writeCompressed(r10, r12);
    }

    private static void writeProfileForS(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) {
        writeProfileSections(r10, r11);
    }

    private static void writeProfileSections(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) {
        ArrayList r12 = new ArrayList(3);
        ArrayList r13 = new ArrayList(3);
        r12.add(writeDexFileSection(r11));
        r12.add(createCompressibleClassSection(r11));
        r12.add(createCompressibleMethodsSection(r11));
        long r14 = ((((long) ProfileVersion.V015_S.length) + ((long) MAGIC_PROF.length)) + 4) + ((long) (r12.size() * 16));
        Encoding.writeUInt32(r10, r12.size());
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r16 >= r12.size()) goto L11;
        WritableFileSection r17 = (WritableFileSection) r12.get(r16);
        Encoding.writeUInt32(r10, r17.mType.getValue());
        Encoding.writeUInt32(r10, r14);
        if (r17.mNeedsCompression == false) goto L8;
        byte[] r18 = r17.mContents;
        long r19 = r18.length;
        byte[] r20 = Encoding.compress(r18);
        r13.add(r20);
        Encoding.writeUInt32(r10, r20.length);
        Encoding.writeUInt32(r10, r19);
        int r21 = r20.length;
    L9:
        r14 = r14 + ((long) r21);
        r16 = r16 + 1;
        goto L4
    L8:
        r13.add(r17.mContents);
        Encoding.writeUInt32(r10, r17.mContents.length);
        Encoding.writeUInt32(r10, 0);
        r21 = r17.mContents.length;
    L11:
        if (r15 >= r13.size()) goto L13;
        r10.write((byte[]) r13.get(r15));
        r15 = r15 + 1;
        goto L11
    }
}
