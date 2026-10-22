package androidx.profileinstaller;

import ai.j0;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.room.jarjarred.org.antlr.v4.runtime.tree.xpath.XPath;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

    private static int computeMethodFlags(@NonNull DexProfileData r5) {
        Iterator<Map.Entry<Integer, Integer>> r10 = r5.methods.entrySet().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L6;
        r11 = r11 | r10.next().getValue().intValue();
        goto L4
    L6:
        return r11;
    }

    @NonNull
    private static byte[] createCompressibleBody(@NonNull DexProfileData[] r10, @NonNull byte[] r11) throws IOException {
        int r5 = r10.length;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r5) goto L5;
        DexProfileData r15 = r10[r13];
        r14 = r14 + ((((r15.classSetSize * 2) + (Encoding.utf8Length(generateDexKey(r15.apkName, r15.dexName, r11)) + 16)) + r15.hotMethodRegionSize) + getMethodBitmapStorageSize(r15.numMethodIds));
        r13 = r13 + 1;
        goto L3
    L5:
        ByteArrayOutputStream r16 = new ByteArrayOutputStream(r14);
        if (Arrays.equals(r11, ProfileVersion.V009_O_MR1) == false) goto L10;
        int r17 = r10.length;
    L8:
        if (r12 >= r17) goto L17;
        DexProfileData r18 = r10[r12];
        writeLineHeader(r16, r18, generateDexKey(r18.apkName, r18.dexName, r11));
        writeLineData(r16, r18);
        r12 = r12 + 1;
    L17:
        if (r16.size() != r14) goto L21;
        return r16.toByteArray();
    L21:
        throw Encoding.error("The bytes saved do not match expectation. actual=" + r16.size() + " expected=" + r14);
    L10:
        int r19 = r10.length;
        int r20 = 0;
    L11:
        if (r20 >= r19) goto L13;
        DexProfileData r21 = r10[r20];
        writeLineHeader(r16, r21, generateDexKey(r21.apkName, r21.dexName, r11));
        r20 = r20 + 1;
        goto L11
    L13:
        int r22 = r10.length;
    L14:
        if (r12 >= r22) goto L17;
        writeLineData(r16, r10[r12]);
        r12 = r12 + 1;
        goto L14
    }

    private static WritableFileSection createCompressibleClassSection(@NonNull DexProfileData[] r5) throws IOException {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        int r11 = 0;
        int r12 = 0;
    L20:
    L6:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L4:
        if (r11 >= r5.length) goto L8;
        DexProfileData r13 = r5[r11];     // Catch: Throwable -> L6
        Encoding.writeUInt16(r10, r11);     // Catch: Throwable -> L6
        Encoding.writeUInt16(r10, r13.classSetSize);     // Catch: Throwable -> L6
        r12 = (r12 + 4) + (r13.classSetSize * 2);     // Catch: Throwable -> L6
        writeClasses(r10, r13);     // Catch: Throwable -> L6
        r11 = r11 + 1;     // Catch: Throwable -> L6
        goto L20
    L8:
        byte[] r14 = r10.toByteArray();     // Catch: Throwable -> L6
        if (r12 != r14.length) goto L14;
        WritableFileSection r15 = new WritableFileSection(FileSectionType.CLASSES, r12, r14, true);     // Catch: Throwable -> L6
        r10.close();
        return r15;
    L14:
        throw Encoding.error("Expected size " + r12 + ", does not match actual size " + r14.length);     // Catch: Throwable -> L6
    }

    private static WritableFileSection createCompressibleMethodsSection(@NonNull DexProfileData[] r10) throws IOException {
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();
        int r11 = 0;
        int r12 = 0;
    L20:
    L6:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L17
    L19:
        throw th;
    L17:
        th = move-exception;
        th.addSuppressed(th);
        goto L19
    L4:
        if (r11 >= r10.length) goto L8;
        DexProfileData r13 = r10[r11];     // Catch: Throwable -> L6
        int r14 = computeMethodFlags(r13);     // Catch: Throwable -> L6
        byte[] r15 = createMethodBitmapRegion(r13);     // Catch: Throwable -> L6
        byte[] r16 = createMethodsWithInlineCaches(r13);     // Catch: Throwable -> L6
        Encoding.writeUInt16(r5, r11);     // Catch: Throwable -> L6
        int r17 = (r15.length + 2) + r16.length;     // Catch: Throwable -> L6
        Encoding.writeUInt32(r5, r17);     // Catch: Throwable -> L6
        Encoding.writeUInt16(r5, r14);     // Catch: Throwable -> L6
        r5.write(r15);     // Catch: Throwable -> L6
        r5.write(r16);     // Catch: Throwable -> L6
        r12 = (r12 + 6) + r17;     // Catch: Throwable -> L6
        r11 = r11 + 1;     // Catch: Throwable -> L6
        goto L20
    L8:
        byte[] r18 = r5.toByteArray();     // Catch: Throwable -> L6
        if (r12 != r18.length) goto L14;
        WritableFileSection r19 = new WritableFileSection(FileSectionType.METHODS, r12, r18, true);     // Catch: Throwable -> L6
        r5.close();
        return r19;
    L14:
        throw Encoding.error("Expected size " + r12 + ", does not match actual size " + r18.length);     // Catch: Throwable -> L6
    }

    private static byte[] createMethodBitmapRegion(@NonNull DexProfileData r5) throws IOException {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        writeMethodBitmap(r10, r5);     // Catch: Throwable -> L6
        byte[] r11 = r10.toByteArray();     // Catch: Throwable -> L6
        r10.close();
        return r11;
    L6:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static byte[] createMethodsWithInlineCaches(@NonNull DexProfileData r5) throws IOException {
        ByteArrayOutputStream r10 = new ByteArrayOutputStream();
        writeMethodsWithInlineCaches(r10, r5);     // Catch: Throwable -> L6
        byte[] r11 = r10.toByteArray();     // Catch: Throwable -> L6
        r10.close();
        return r11;
    L6:
        th = move-exception;
        r10.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    @NonNull
    private static String enforceSeparator(@NonNull String r5, @NonNull String r10) {
        if (XPath.NOT.equals(r10) == false) goto L7;
        return r5.replace(":", XPath.NOT);
    L7:
        if (":".equals(r10) == true) goto L9;
        return r5;
    L9:
        return r5.replace(XPath.NOT, ":");
    }

    @NonNull
    private static String extractKey(@NonNull String r5) {
        int r10 = r5.indexOf(XPath.NOT);
        if (r10 >= 0) goto L5;
        r10 = r5.indexOf(":");
    L5:
        if (r10 > 0) goto L7;
        return r5;
    L7:
        return r5.substring(r10 + 1);
    }

    @Nullable
    private static DexProfileData findByDexName(@NonNull DexProfileData[] r5, @NonNull String r10) {
        if (r5.length > 0) goto L5;
        return null;
    L5:
        String r11 = extractKey(r10);
        int r12 = 0;
    L7:
        if (r12 >= r5.length) goto L13;
        if (r5[r12].dexName.equals(r11) == true) goto L11;
        r12 = r12 + 1;
        goto L7
    L11:
        return r5[r12];
    L13:
        return null;
    }

    @NonNull
    private static String generateDexKey(@NonNull String r5, @NonNull String r10, @NonNull byte[] r11) {
        String r12 = ProfileVersion.dexKeySeparator(r11);
        if (r5.length() > 0) goto L7;
        return enforceSeparator(r10, r12);
    L7:
        if (r10.equals("classes.dex") == false) goto L10;
        return r5;
    L10:
        if (r10.contains(XPath.NOT) == true) goto L20;
        if (r10.contains(":") == true) goto L20;
        if (r10.endsWith(".apk") == false) goto L17;
        return r10;
    L17:
        StringBuilder r13 = j0.u(r5);
        r13.append(ProfileVersion.dexKeySeparator(r11));
        r13.append(r10);
        return r13.toString();
    L20:
        return enforceSeparator(r10, r12);
    }

    private static int getMethodBitmapStorageSize(int r5) {
        return roundUpToByte(r5 * 2) / 8;
    }

    private static int methodFlagBitmapIndex(int r5, int r10, int r11) {
        if (r5 == 1) goto L14;
        if (r5 != 2) goto L7;
        return r10;
    L7:
        if (r5 != 4) goto L11;
        return r10 + r11;
    L11:
        throw Encoding.error(j0.g(r5, "Unexpected flag: "));
    L14:
        throw Encoding.error("HOT methods are not stored in the bitmap");
    }

    private static int[] readClasses(@NonNull InputStream r5, int r10) throws IOException {
        int[] r11 = new int[r10];
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r10) goto L5;
        r13 = r13 + Encoding.readUInt16(r5);
        r11[r12] = r13;
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    private static int readFlagsFromBitmap(@NonNull BitSet r5, int r10, int r11) {
        int r12 = 2;
        if (r5.get(methodFlagBitmapIndex(2, r10, r11)) == true) goto L7;
        r12 = 0;
    L7:
        if (r5.get(methodFlagBitmapIndex(4, r10, r11)) == true) goto L9;
        return r12;
    L9:
        return r12 | 4;
    }

    public static byte[] readHeader(@NonNull InputStream r5, @NonNull byte[] r10) throws IOException {
        if (Arrays.equals(r10, Encoding.read(r5, r10.length)) == false) goto L7;
        return Encoding.read(r5, ProfileVersion.V010_P.length);
    L7:
        throw Encoding.error("Invalid magic");
    }

    private static void readHotMethodRegion(@NonNull InputStream r5, @NonNull DexProfileData r10) throws IOException {
        int r11 = r5.available() - r10.hotMethodRegionSize;
        int r12 = 0;
    L4:
        if (r5.available() <= r11) goto L9;
        r12 = r12 + Encoding.readUInt16(r5);
        r10.methods.put(Integer.valueOf(r12), 1);
        int r13 = Encoding.readUInt16(r5);
    L6:
        if (r13 <= 0) goto L4;
        skipInlineCache(r5);
        r13 = r13 - 1;
        goto L6
    L9:
        if (r5.available() != r11) goto L12;
        return;
    L12:
        throw Encoding.error("Read too much data during profile line parse");
    }

    @NonNull
    public static DexProfileData[] readMeta(@NonNull InputStream r5, @NonNull byte[] r10, @NonNull byte[] r11, DexProfileData[] r12) throws IOException {
        if (Arrays.equals(r10, ProfileVersion.METADATA_V001_N) == false) goto L11;
        if (Arrays.equals(ProfileVersion.V015_S, r11) == true) goto L9;
        return readMetadata001(r5, r10, r12);
    L9:
        throw Encoding.error("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
    L11:
        if (Arrays.equals(r10, ProfileVersion.METADATA_V002) == false) goto L15;
        return readMetadataV002(r5, r11, r12);
    L15:
        throw Encoding.error("Unsupported meta version");
    }

    @NonNull
    public static DexProfileData[] readMetadata001(@NonNull InputStream r5, @NonNull byte[] r10, DexProfileData[] r11) throws IOException {
        if (Arrays.equals(r10, ProfileVersion.METADATA_V001_N) == false) goto L19;
        int r12 = Encoding.readUInt8(r5);
        long r13 = Encoding.readUInt32(r5);
        byte[] r14 = Encoding.readCompressed(r5, (int) Encoding.readUInt32(r5), (int) r13);
        if (r5.read() > 0) goto L17;
        ByteArrayInputStream r15 = new ByteArrayInputStream(r14);
        DexProfileData[] r16 = readMetadataForNBody(r15, r12, r11);     // Catch: Throwable -> L10
        r15.close();
        return r16;
    L10:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L13
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
    private static DexProfileData[] readMetadataForNBody(@NonNull InputStream r10, int r11, DexProfileData[] r12) throws IOException {
        int r5 = 0;
        if (r10.available() != 0) goto L7;
        return new DexProfileData[0];
    L7:
        if (r11 != r12.length) goto L19;
        String[] r13 = new String[r11];
        int[] r14 = new int[r11];
        int r15 = 0;
    L9:
        if (r15 >= r11) goto L11;
        int r16 = Encoding.readUInt16(r10);
        r14[r15] = Encoding.readUInt16(r10);
        r13[r15] = Encoding.readString(r10, r16);
        r15 = r15 + 1;
    L11:
        if (r5 >= r11) goto L17;
        DexProfileData r17 = r12[r5];
        if (r17.dexName.equals(r13[r5]) == false) goto L16;
        int r18 = r14[r5];
        r17.classSetSize = r18;
        r17.classes = readClasses(r10, r18);
        r5 = r5 + 1;
        goto L11
    L16:
        throw Encoding.error("Order of dexfiles in metadata did not match baseline");
    L17:
        return r12;
    L19:
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    @NonNull
    public static DexProfileData[] readMetadataV002(@NonNull InputStream r5, @NonNull byte[] r10, DexProfileData[] r11) throws IOException {
        int r12 = Encoding.readUInt16(r5);
        long r13 = Encoding.readUInt32(r5);
        byte[] r14 = Encoding.readCompressed(r5, (int) Encoding.readUInt32(r5), (int) r13);
        if (r5.read() > 0) goto L15;
        ByteArrayInputStream r15 = new ByteArrayInputStream(r14);
        DexProfileData[] r16 = readMetadataV002Body(r15, r10, r12, r11);     // Catch: Throwable -> L8
        r15.close();
        return r16;
    L8:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L11
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
    private static DexProfileData[] readMetadataV002Body(@NonNull InputStream r10, @NonNull byte[] r11, int r12, DexProfileData[] r13) throws IOException {
        int r5 = 0;
        if (r10.available() != 0) goto L7;
        return new DexProfileData[0];
    L7:
        if (r12 != r13.length) goto L19;
    L8:
        if (r5 >= r12) goto L17;
        Encoding.readUInt16(r10);
        String r14 = Encoding.readString(r10, Encoding.readUInt16(r10));
        long r15 = Encoding.readUInt32(r10);
        int r16 = Encoding.readUInt16(r10);
        DexProfileData r17 = findByDexName(r13, r14);
        if (r17 == null) goto L16;
        r17.mTypeIdCount = r15;
        int[] r18 = readClasses(r10, r16);
        if (Arrays.equals(r11, ProfileVersion.V001_N) == false) goto L14;
        r17.classSetSize = r16;
        r17.classes = r18;
    L14:
        r5 = r5 + 1;
        goto L8
    L16:
        throw Encoding.error(j0.C("Missing profile key: ", r14));
    L17:
        return r13;
    L19:
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    private static void readMethodBitmap(@NonNull InputStream r10, @NonNull DexProfileData r11) throws IOException {
        BitSet r12 = BitSet.valueOf(Encoding.read(r10, Encoding.bitsToBytes(r11.numMethodIds * 2)));
        int r5 = 0;
    L3:
        int r13 = r11.numMethodIds;
        if (r5 >= r13) goto L12;
        int r14 = readFlagsFromBitmap(r12, r5, r13);
        if (r14 == 0) goto L11;
        Integer r15 = r11.methods.get(Integer.valueOf(r5));
        if (r15 != null) goto L10;
        r15 = 0;
    L10:
        r11.methods.put(Integer.valueOf(r5), Integer.valueOf(r14 | r15.intValue()));
    L11:
        r5 = r5 + 1;
        goto L3
    }

    @NonNull
    public static DexProfileData[] readProfile(@NonNull InputStream r5, @NonNull byte[] r10, @NonNull String r11) throws IOException {
        if (Arrays.equals(r10, ProfileVersion.V010_P) == false) goto L19;
        int r12 = Encoding.readUInt8(r5);
        long r13 = Encoding.readUInt32(r5);
        byte[] r14 = Encoding.readCompressed(r5, (int) Encoding.readUInt32(r5), (int) r13);
        if (r5.read() > 0) goto L17;
        ByteArrayInputStream r15 = new ByteArrayInputStream(r14);
        DexProfileData[] r16 = readUncompressedBody(r15, r11, r12);     // Catch: Throwable -> L10
        r15.close();
        return r16;
    L10:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L13
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
    private static DexProfileData[] readUncompressedBody(@NonNull InputStream r19, @NonNull String r20, int r21) throws IOException {
        int r5 = 0;
        if (r19.available() == 0) goto L5;
        DexProfileData[] r10 = new DexProfileData[r21];
        int r11 = 0;
    L7:
        if (r11 >= r21) goto L9;
        int r12 = Encoding.readUInt16(r19);
        int r13 = Encoding.readUInt16(r19);
        long r14 = Encoding.readUInt32(r19);
        r10[r11] = new DexProfileData(r20, Encoding.readString(r19, r12), Encoding.readUInt32(r19), 0, r13, (int) r14, (int) Encoding.readUInt32(r19), new int[r13], new TreeMap());
        r11 = r11 + 1;
    L9:
        if (r5 >= r21) goto L11;
        DexProfileData r15 = r10[r5];
        readHotMethodRegion(r19, r15);
        r15.classes = readClasses(r19, r15.classSetSize);
        readMethodBitmap(r19, r15);
        r5 = r5 + 1;
        goto L9
    L11:
        return r10;
    L5:
        return new DexProfileData[0];
    }

    private static int roundUpToByte(int r5) {
        return (r5 + 7) & (-8);
    }

    private static void setMethodBitmapBit(@NonNull byte[] r5, int r10, int r11, @NonNull DexProfileData r12) {
        int r13 = methodFlagBitmapIndex(r10, r11, r12.numMethodIds);
        int r14 = r13 / 8;
        int r15 = 1 << (r13 % 8);
        r5[r14] = (byte) (r15 | r5[r14]);
    }

    private static void skipInlineCache(@NonNull InputStream r5) throws IOException {
        Encoding.readUInt16(r5);
        int r10 = Encoding.readUInt8(r5);
        if (r10 != 6) goto L6;
        return;
    L6:
        if (r10 != 7) goto L8;
        return;
    L8:
        if (r10 <= 0) goto L13;
        Encoding.readUInt8(r5);
        int r11 = Encoding.readUInt8(r5);
    L10:
        if (r11 <= 0) goto L12;
        Encoding.readUInt16(r5);
        r11 = r11 - 1;
        goto L10
    L12:
        r10 = r10 - 1;
        goto L8
    }

    public static boolean transcodeAndWriteBody(@NonNull OutputStream r5, @NonNull byte[] r10, @NonNull DexProfileData[] r11) throws IOException {
        if (Arrays.equals(r10, ProfileVersion.V015_S) == false) goto L7;
        writeProfileForS(r5, r11);
        return true;
    L7:
        if (Arrays.equals(r10, ProfileVersion.V010_P) == false) goto L11;
        writeProfileForP(r5, r11);
        return true;
    L11:
        if (Arrays.equals(r10, ProfileVersion.V005_O) == false) goto L15;
        writeProfileForO(r5, r11);
        return true;
    L15:
        if (Arrays.equals(r10, ProfileVersion.V009_O_MR1) == false) goto L19;
        writeProfileForO_MR1(r5, r11);
        return true;
    L19:
        if (Arrays.equals(r10, ProfileVersion.V001_N) == false) goto L22;
        writeProfileForN(r5, r11);
        return true;
    L22:
        return false;
    }

    private static void writeClasses(@NonNull OutputStream r5, @NonNull DexProfileData r10) throws IOException {
        int[] r11 = r10.classes;
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        int r15 = r11[r13];
        Encoding.writeUInt16(r5, r15 - r14);
        r13 = r13 + 1;
        r14 = r15;
        goto L3
    }

    private static WritableFileSection writeDexFileSection(@NonNull DexProfileData[] r10) throws IOException {
        ByteArrayOutputStream r5 = new ByteArrayOutputStream();
        Encoding.writeUInt16(r5, r10.length);     // Catch: Throwable -> L7
        int r11 = 2;
        int r12 = 0;
    L5:
        if (r12 >= r10.length) goto L9;
        DexProfileData r13 = r10[r12];     // Catch: Throwable -> L7
        Encoding.writeUInt32(r5, r13.dexChecksum);     // Catch: Throwable -> L7
        Encoding.writeUInt32(r5, r13.mTypeIdCount);     // Catch: Throwable -> L7
        Encoding.writeUInt32(r5, r13.numMethodIds);     // Catch: Throwable -> L7
        String r14 = generateDexKey(r13.apkName, r13.dexName, ProfileVersion.V015_S);     // Catch: Throwable -> L7
        int r15 = Encoding.utf8Length(r14);     // Catch: Throwable -> L7
        Encoding.writeUInt16(r5, r15);     // Catch: Throwable -> L7
        r11 = (r11 + 14) + r15;     // Catch: Throwable -> L7
        Encoding.writeString(r5, r14);     // Catch: Throwable -> L7
        r12 = r12 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        byte[] r16 = r5.toByteArray();     // Catch: Throwable -> L7
        if (r11 != r16.length) goto L15;
        WritableFileSection r17 = new WritableFileSection(FileSectionType.DEX_FILES, r11, r16, false);     // Catch: Throwable -> L7
        r5.close();
        return r17;
    L15:
        throw Encoding.error("Expected size " + r11 + ", does not match actual size " + r16.length);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        r5.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }

    public static void writeHeader(@NonNull OutputStream r5, byte[] r10) throws IOException {
        r5.write(MAGIC_PROF);
        r5.write(r10);
    }

    private static void writeLineData(@NonNull OutputStream r5, @NonNull DexProfileData r10) throws IOException {
        writeMethodsWithInlineCaches(r5, r10);
        writeClasses(r5, r10);
        writeMethodBitmap(r5, r10);
    }

    private static void writeLineHeader(@NonNull OutputStream r5, @NonNull DexProfileData r10, @NonNull String r11) throws IOException {
        Encoding.writeUInt16(r5, Encoding.utf8Length(r11));
        Encoding.writeUInt16(r5, r10.classSetSize);
        Encoding.writeUInt32(r5, r10.hotMethodRegionSize);
        Encoding.writeUInt32(r5, r10.dexChecksum);
        Encoding.writeUInt32(r5, r10.numMethodIds);
        Encoding.writeString(r5, r11);
    }

    private static void writeMethodBitmap(@NonNull OutputStream r5, @NonNull DexProfileData r10) throws IOException {
        byte[] r11 = new byte[getMethodBitmapStorageSize(r10.numMethodIds)];
        Iterator<Map.Entry<Integer, Integer>> r12 = r10.methods.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Map.Entry<Integer, Integer> r13 = r12.next();
        int r14 = r13.getKey().intValue();
        int r15 = r13.getValue().intValue();
        if ((r15 & 2) == 0) goto L9;
        setMethodBitmapBit(r11, 2, r14, r10);
    L9:
        if ((r15 & 4) == 0) goto L4;
        setMethodBitmapBit(r11, 4, r14, r10);
        goto L4
    L11:
        r5.write(r11);
    }

    private static void writeMethodsWithInlineCaches(@NonNull OutputStream r5, @NonNull DexProfileData r10) throws IOException {
        Iterator<Map.Entry<Integer, Integer>> r11 = r10.methods.entrySet().iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<Integer, Integer> r13 = r11.next();
        int r14 = r13.getKey().intValue();
        if ((r13.getValue().intValue() & 1) == 0) goto L4;
        Encoding.writeUInt16(r5, r14 - r12);
        Encoding.writeUInt16(r5, 0);
        r12 = r14;
        goto L4
    }

    private static void writeProfileForN(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) throws IOException {
        Encoding.writeUInt16(r10, r11.length);
        int r5 = r11.length;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L12;
        DexProfileData r13 = r11[r12];
        String r14 = generateDexKey(r13.apkName, r13.dexName, ProfileVersion.V001_N);
        Encoding.writeUInt16(r10, Encoding.utf8Length(r14));
        Encoding.writeUInt16(r10, r13.methods.size());
        Encoding.writeUInt16(r10, r13.classes.length);
        Encoding.writeUInt32(r10, r13.dexChecksum);
        Encoding.writeString(r10, r14);
        Iterator<Integer> r15 = r13.methods.keySet().iterator();
    L6:
        if (r15.hasNext() == false) goto L8;
        Encoding.writeUInt16(r10, r15.next().intValue());
        goto L6
    L8:
        int[] r16 = r13.classes;
        int r17 = r16.length;
        int r18 = 0;
    L9:
        if (r18 >= r17) goto L11;
        Encoding.writeUInt16(r10, r16[r18]);
        r18 = r18 + 1;
        goto L9
    L11:
        r12 = r12 + 1;
        goto L3
    }

    private static void writeProfileForO(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) throws IOException {
        Encoding.writeUInt8(r10, r11.length);
        int r5 = r11.length;
        int r12 = 0;
    L3:
        if (r12 >= r5) goto L12;
        DexProfileData r13 = r11[r12];
        int r14 = r13.methods.size() * 4;
        String r15 = generateDexKey(r13.apkName, r13.dexName, ProfileVersion.V005_O);
        Encoding.writeUInt16(r10, Encoding.utf8Length(r15));
        Encoding.writeUInt16(r10, r13.classes.length);
        Encoding.writeUInt32(r10, r14);
        Encoding.writeUInt32(r10, r13.dexChecksum);
        Encoding.writeString(r10, r15);
        Iterator<Integer> r16 = r13.methods.keySet().iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        Encoding.writeUInt16(r10, r16.next().intValue());
        Encoding.writeUInt16(r10, 0);
        goto L6
    L8:
        int[] r17 = r13.classes;
        int r18 = r17.length;
        int r19 = 0;
    L9:
        if (r19 >= r18) goto L11;
        Encoding.writeUInt16(r10, r17[r19]);
        r19 = r19 + 1;
        goto L9
    L11:
        r12 = r12 + 1;
        goto L3
    }

    private static void writeProfileForO_MR1(@NonNull OutputStream r5, @NonNull DexProfileData[] r10) throws IOException {
        byte[] r11 = createCompressibleBody(r10, ProfileVersion.V009_O_MR1);
        Encoding.writeUInt8(r5, r10.length);
        Encoding.writeCompressed(r5, r11);
    }

    private static void writeProfileForP(@NonNull OutputStream r5, @NonNull DexProfileData[] r10) throws IOException {
        byte[] r11 = createCompressibleBody(r10, ProfileVersion.V010_P);
        Encoding.writeUInt8(r5, r10.length);
        Encoding.writeCompressed(r5, r11);
    }

    private static void writeProfileForS(@NonNull OutputStream r5, @NonNull DexProfileData[] r10) throws IOException {
        writeProfileSections(r5, r10);
    }

    private static void writeProfileSections(@NonNull OutputStream r10, @NonNull DexProfileData[] r11) throws IOException {
        ArrayList r5 = new ArrayList(3);
        ArrayList r12 = new ArrayList(3);
        r5.add(writeDexFileSection(r11));
        r5.add(createCompressibleClassSection(r11));
        r5.add(createCompressibleMethodsSection(r11));
        long r13 = ((((long) ProfileVersion.V015_S.length) + ((long) MAGIC_PROF.length)) + 4) + ((long) (r5.size() * 16));
        Encoding.writeUInt32(r10, r5.size());
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r15 >= r5.size()) goto L12;
        WritableFileSection r16 = (WritableFileSection) r5.get(r15);
        Encoding.writeUInt32(r10, r16.mType.getValue());
        Encoding.writeUInt32(r10, r13);
        if (r16.mNeedsCompression == false) goto L9;
        byte[] r17 = r16.mContents;
        long r18 = r17.length;
        byte[] r19 = Encoding.compress(r17);
        r12.add(r19);
        Encoding.writeUInt32(r10, r19.length);
        Encoding.writeUInt32(r10, r18);
        int r20 = r19.length;
    L8:
        r13 = r13 + ((long) r20);
        r15 = r15 + 1;
        goto L4
    L9:
        r12.add(r16.mContents);
        Encoding.writeUInt32(r10, r16.mContents.length);
        Encoding.writeUInt32(r10, 0);
        r20 = r16.mContents.length;
    L12:
        if (r14 >= r12.size()) goto L14;
        r10.write((byte[]) r12.get(r14));
        r14 = r14 + 1;
        goto L12
    }
}
