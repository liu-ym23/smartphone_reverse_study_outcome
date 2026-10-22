package com.google.android.material.color;

import ai.j0;
import android.content.Context;
import android.util.Pair;
import androidx.annotation.ColorInt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.UByte;

/* JADX INFO: loaded from: classes2.dex */
final class ColorResourcesTableCreator {
    private static final byte ANDROID_PACKAGE_ID = 1;
    private static final PackageInfo ANDROID_PACKAGE_INFO = null;
    private static final byte APPLICATION_PACKAGE_ID = 127;
    private static final Comparator<ColorResource> COLOR_RESOURCE_COMPARATOR = null;
    private static final short HEADER_TYPE_PACKAGE = 512;
    private static final short HEADER_TYPE_RES_TABLE = 2;
    private static final short HEADER_TYPE_STRING_POOL = 1;
    private static final short HEADER_TYPE_TYPE = 513;
    private static final short HEADER_TYPE_TYPE_SPEC = 514;
    private static final String RESOURCE_TYPE_NAME_COLOR = "color";
    private static byte typeIdColor;

    public static class ColorResource {
        private final short entryId;
        private final String name;
        private final byte packageId;
        private final byte typeId;

        @ColorInt
        private final int value;

        public ColorResource(int r5, String r10, int r11) {
            this.name = r10;
            this.value = r11;
            this.entryId = (short) (65535 & r5);
            this.typeId = (byte) ((r5 >> 16) & 255);
            this.packageId = (byte) ((r5 >> 24) & 255);
        }

        public static /* synthetic */ short access$000(ColorResource r5) {
            return r5.entryId;
        }

        public static /* synthetic */ String access$100(ColorResource r5) {
            return r5.name;
        }

        public static /* synthetic */ int access$1400(ColorResource r5) {
            return r5.value;
        }

        public static /* synthetic */ byte access$200(ColorResource r5) {
            return r5.typeId;
        }

        public static /* synthetic */ byte access$300(ColorResource r5) {
            return r5.packageId;
        }
    }

    public static class PackageChunk {
        private static final short HEADER_SIZE = 288;
        private static final int PACKAGE_NAME_MAX_LENGTH = 128;
        private final ResChunkHeader header;
        private final StringPoolChunk keyStrings;
        private final PackageInfo packageInfo;
        private final TypeSpecChunk typeSpecChunk;
        private final StringPoolChunk typeStrings;

        public PackageChunk(PackageInfo r10, List<ColorResource> r11) {
            this.packageInfo = r10;
            int r5 = 0;
            this.typeStrings = new StringPoolChunk(false, new String[]{"?1", "?2", "?3", "?4", "?5", ColorResourcesTableCreator.RESOURCE_TYPE_NAME_COLOR});
            String[] r12 = new String[r11.size()];
        L4:
            if (r5 >= r11.size()) goto L6;
            r12[r5] = ColorResource.access$100(r11.get(r5));
            r5 = r5 + 1;
            goto L4
        L6:
            this.keyStrings = new StringPoolChunk(true, r12);
            this.typeSpecChunk = new TypeSpecChunk(r11);
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_PACKAGE, HEADER_SIZE, getChunkSize());
        }

        public int getChunkSize() {
            return ((this.typeStrings.getChunkSize() + 288) + this.keyStrings.getChunkSize()) + this.typeSpecChunk.getChunkSizeWithTypeChunk();
        }

        public void writeTo(ByteArrayOutputStream r5) throws IOException {
            this.header.writeTo(r5);
            r5.write(ColorResourcesTableCreator.access$500(PackageInfo.access$1000(this.packageInfo)));
            char[] r10 = PackageInfo.access$1100(this.packageInfo).toCharArray();
            int r11 = 0;
        L4:
            if (r11 >= 128) goto L10;
            if (r11 >= r10.length) goto L8;
            r5.write(ColorResourcesTableCreator.access$1200(r10[r11]));
        L9:
            r11 = r11 + 1;
            goto L4
        L8:
            r5.write(ColorResourcesTableCreator.access$1200(0));
            goto L9
        L10:
            r5.write(ColorResourcesTableCreator.access$500(288));
            r5.write(ColorResourcesTableCreator.access$500(0));
            r5.write(ColorResourcesTableCreator.access$500(this.typeStrings.getChunkSize() + 288));
            r5.write(ColorResourcesTableCreator.access$500(0));
            r5.write(ColorResourcesTableCreator.access$500(0));
            this.typeStrings.writeTo(r5);
            this.keyStrings.writeTo(r5);
            this.typeSpecChunk.writeTo(r5);
        }
    }

    public static class PackageInfo {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f8521id;
        private final String name;

        public PackageInfo(int r5, String r10) {
            this.f8521id = r5;
            this.name = r10;
        }

        public static /* synthetic */ int access$1000(PackageInfo r5) {
            return r5.f8521id;
        }

        public static /* synthetic */ String access$1100(PackageInfo r5) {
            return r5.name;
        }
    }

    public static class ResChunkHeader {
        private final int chunkSize;
        private final short headerSize;
        private final short type;

        public ResChunkHeader(short r5, short r10, int r11) {
            this.type = r5;
            this.headerSize = r10;
            this.chunkSize = r11;
        }

        public void writeTo(ByteArrayOutputStream r5) throws IOException {
            r5.write(ColorResourcesTableCreator.access$600(this.type));
            r5.write(ColorResourcesTableCreator.access$600(this.headerSize));
            r5.write(ColorResourcesTableCreator.access$500(this.chunkSize));
        }
    }

    public static class ResEntry {
        private static final byte DATA_TYPE_AARRGGBB = 28;
        private static final short ENTRY_SIZE = 8;
        private static final short FLAG_PUBLIC = 2;
        private static final int SIZE = 16;
        private static final short VALUE_SIZE = 8;
        private final int data;
        private final int keyStringIndex;

        public ResEntry(int r5, @ColorInt int r10) {
            this.keyStringIndex = r5;
            this.data = r10;
        }

        public void writeTo(ByteArrayOutputStream r5) throws IOException {
            r5.write(ColorResourcesTableCreator.access$600(8));
            r5.write(ColorResourcesTableCreator.access$600(2));
            r5.write(ColorResourcesTableCreator.access$500(this.keyStringIndex));
            r5.write(ColorResourcesTableCreator.access$600(8));
            r5.write(new byte[]{0, DATA_TYPE_AARRGGBB});
            r5.write(ColorResourcesTableCreator.access$500(this.data));
        }
    }

    public static class ResTable {
        private static final short HEADER_SIZE = 12;
        private final ResChunkHeader header;
        private final List<PackageChunk> packageChunks;
        private final int packageCount;
        private final StringPoolChunk stringPool;

        public ResTable(Map<PackageInfo, List<ColorResource>> r5) {
            this.packageChunks = new ArrayList();
            this.packageCount = r5.size();
            this.stringPool = new StringPoolChunk(new String[0]);
            Iterator<Map.Entry<PackageInfo, List<ColorResource>>> r10 = r5.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            Map.Entry<PackageInfo, List<ColorResource>> r11 = r10.next();
            List<ColorResource> r12 = r11.getValue();
            Collections.sort(r12, ColorResourcesTableCreator.access$400());
            this.packageChunks.add(new PackageChunk(r11.getKey(), r12));
            goto L4
        L6:
            this.header = new ResChunkHeader(2, 12, getOverallSize());
        }

        private int getOverallSize() {
            Iterator<PackageChunk> r5 = this.packageChunks.iterator();
            int r10 = 0;
        L4:
            if (r5.hasNext() == false) goto L7;
            r10 = r10 + r5.next().getChunkSize();
            goto L4
        L7:
            return (this.stringPool.getChunkSize() + 12) + r10;
        }

        public void writeTo(ByteArrayOutputStream r5) throws IOException {
            this.header.writeTo(r5);
            r5.write(ColorResourcesTableCreator.access$500(this.packageCount));
            this.stringPool.writeTo(r5);
            Iterator<PackageChunk> r10 = this.packageChunks.iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            r10.next().writeTo(r5);
            goto L4
        }
    }

    public static class StringPoolChunk {
        private static final int FLAG_UTF8 = 256;
        private static final short HEADER_SIZE = 28;
        private static final int STYLED_SPAN_LIST_END = -1;
        private final int chunkSize;
        private final ResChunkHeader header;
        private final int stringCount;
        private final List<Integer> stringIndex;
        private final List<byte[]> strings;
        private final int stringsPaddingSize;
        private final int stringsStart;
        private final int styledSpanCount;
        private final List<Integer> styledSpanIndex;
        private final List<List<StringStyledSpan>> styledSpans;
        private final int styledSpansStart;
        private final boolean utf8Encode;

        public StringPoolChunk(String... r5) {
            this(false, r5);
        }

        private Pair<byte[], List<StringStyledSpan>> processString(String r5) {
            if (this.utf8Encode == false) goto L5;
            byte[] r10 = ColorResourcesTableCreator.access$800(r5);
        L7:
            return new Pair(r10, Collections.emptyList());
        L5:
            r10 = ColorResourcesTableCreator.access$900(r5);
            goto L7
        }

        public int getChunkSize() {
            return this.chunkSize;
        }

        public void writeTo(ByteArrayOutputStream r5) throws IOException {
            this.header.writeTo(r5);
            r5.write(ColorResourcesTableCreator.access$500(this.stringCount));
            r5.write(ColorResourcesTableCreator.access$500(this.styledSpanCount));
            if (this.utf8Encode == false) goto L5;
            int r10 = 256;
        L6:
            r5.write(ColorResourcesTableCreator.access$500(r10));
            r5.write(ColorResourcesTableCreator.access$500(this.stringsStart));
            r5.write(ColorResourcesTableCreator.access$500(this.styledSpansStart));
            Iterator<Integer> r11 = this.stringIndex.iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            r5.write(ColorResourcesTableCreator.access$500(r11.next().intValue()));
            goto L8
        L10:
            Iterator<Integer> r12 = this.styledSpanIndex.iterator();
        L12:
            if (r12.hasNext() == false) goto L14;
            r5.write(ColorResourcesTableCreator.access$500(r12.next().intValue()));
            goto L12
        L14:
            Iterator<byte[]> r13 = this.strings.iterator();
        L16:
            if (r13.hasNext() == false) goto L18;
            r5.write(r13.next());
            goto L16
        L18:
            int r14 = this.stringsPaddingSize;
            if (r14 <= 0) goto L21;
            r5.write(new byte[r14]);
        L21:
            Iterator<List<StringStyledSpan>> r15 = this.styledSpans.iterator();
        L23:
            if (r15.hasNext() == false) goto L29;
            Iterator<StringStyledSpan> r16 = r15.next().iterator();
        L26:
            if (r16.hasNext() == false) goto L28;
            r16.next().writeTo(r5);
            goto L26
        L28:
            r5.write(ColorResourcesTableCreator.access$500(-1));
            goto L23
        L29:
            return;
        L5:
            r10 = 0;
            goto L6
        }

        public StringPoolChunk(boolean r10, String... r11) {
            this.stringIndex = new ArrayList();
            this.styledSpanIndex = new ArrayList();
            this.strings = new ArrayList();
            this.styledSpans = new ArrayList();
            this.utf8Encode = r10;
            int r12 = r11.length;
            int r5 = 0;
            int r13 = 0;
            int r14 = 0;
        L3:
            if (r13 >= r12) goto L5;
            Pair<byte[], List<StringStyledSpan>> r15 = processString(r11[r13]);
            this.stringIndex.add(Integer.valueOf(r14));
            Object r16 = r15.first;
            r14 = r14 + ((byte[]) r16).length;
            this.strings.add((byte[]) r16);
            this.styledSpans.add((List) r15.second);
            r13 = r13 + 1;
            goto L3
        L5:
            Iterator<List<StringStyledSpan>> r17 = this.styledSpans.iterator();
            int r18 = 0;
        L7:
            if (r17.hasNext() == false) goto L13;
            List<StringStyledSpan> r19 = r17.next();
            Iterator<StringStyledSpan> r20 = r19.iterator();
        L10:
            if (r20.hasNext() == false) goto L12;
            StringStyledSpan r21 = r20.next();
            this.stringIndex.add(Integer.valueOf(r14));
            r14 = r14 + StringStyledSpan.access$700(r21).length;
            this.strings.add(StringStyledSpan.access$700(r21));
            goto L10
        L12:
            this.styledSpanIndex.add(Integer.valueOf(r18));
            r18 = r18 + ((r19.size() * 12) + 4);
            goto L7
        L13:
            int r22 = r14 % 4;
            if (r22 != 0) goto L16;
            int r23 = 0;
        L17:
            this.stringsPaddingSize = r23;
            int r24 = this.strings.size();
            this.stringCount = r24;
            this.styledSpanCount = this.strings.size() - r11.length;
            if ((this.strings.size() - r11.length) <= 0) goto L20;
            boolean r25 = true;
        L21:
            if (r25 == true) goto L23;
            this.styledSpanIndex.clear();
            this.styledSpans.clear();
        L23:
            int r26 = (this.styledSpanIndex.size() * 4) + ((r24 * 4) + 28);
            this.stringsStart = r26;
            int r27 = r14 + r23;
            if (r25 == false) goto L26;
            int r28 = r26 + r27;
        L27:
            this.styledSpansStart = r28;
            int r29 = r26 + r27;
            if (r25 == false) goto L30;
            r5 = r18;
        L30:
            int r30 = r29 + r5;
            this.chunkSize = r30;
            this.header = new ResChunkHeader(1, 28, r30);
            return;
        L26:
            r28 = 0;
            goto L27
        L20:
            r25 = false;
            goto L21
        L16:
            r23 = 4 - r22;
            goto L17
        }
    }

    public static class StringStyledSpan {
        private int firstCharacterIndex;
        private int lastCharacterIndex;
        private int nameReference;
        private byte[] styleString;

        private StringStyledSpan() {
        }

        public static /* synthetic */ byte[] access$700(StringStyledSpan r5) {
            return r5.styleString;
        }

        public void writeTo(ByteArrayOutputStream r5) throws IOException {
            r5.write(ColorResourcesTableCreator.access$500(this.nameReference));
            r5.write(ColorResourcesTableCreator.access$500(this.firstCharacterIndex));
            r5.write(ColorResourcesTableCreator.access$500(this.lastCharacterIndex));
        }
    }

    public static class TypeChunk {
        private static final byte CONFIG_SIZE = 64;
        private static final short HEADER_SIZE = 84;
        private static final int OFFSET_NO_ENTRY = -1;
        private final byte[] config;
        private final int entryCount;
        private final ResChunkHeader header;
        private final int[] offsetTable;
        private final ResEntry[] resEntries;

        public TypeChunk(List<ColorResource> r10, Set<Short> r11, int r12) {
            byte[] r5 = new byte[64];
            this.config = r5;
            this.entryCount = r12;
            short r13 = 0;
            r5[0] = CONFIG_SIZE;
            this.resEntries = new ResEntry[r10.size()];
            int r14 = 0;
        L4:
            if (r14 >= r10.size()) goto L6;
            this.resEntries[r14] = new ResEntry(r14, ColorResource.access$1400(r10.get(r14)));
            r14 = r14 + 1;
            goto L4
        L6:
            this.offsetTable = new int[r12];
            int r15 = 0;
        L7:
            if (r13 >= r12) goto L13;
            if (r11.contains(Short.valueOf(r13)) == false) goto L11;
            this.offsetTable[r13] = r15;
            r15 = r15 + 16;
        L12:
            r13 = (short) (r13 + 1);
            goto L7
        L11:
            this.offsetTable[r13] = -1;
            goto L12
        L13:
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_TYPE, HEADER_SIZE, getChunkSize());
        }

        private int getEntryStart() {
            return getOffsetTableSize() + 84;
        }

        private int getOffsetTableSize() {
            return this.offsetTable.length * 4;
        }

        public int getChunkSize() {
            int r5 = getEntryStart();
            return (this.resEntries.length * 16) + r5;
        }

        public void writeTo(ByteArrayOutputStream r10) throws IOException {
            this.header.writeTo(r10);
            int r5 = 0;
            r10.write(new byte[]{ColorResourcesTableCreator.access$1300(), 0, 0, 0});
            r10.write(ColorResourcesTableCreator.access$500(this.entryCount));
            r10.write(ColorResourcesTableCreator.access$500(getEntryStart()));
            r10.write(this.config);
            int[] r11 = this.offsetTable;
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r10.write(ColorResourcesTableCreator.access$500(r11[r13]));
            r13 = r13 + 1;
            goto L3
        L5:
            ResEntry[] r14 = this.resEntries;
            int r15 = r14.length;
        L6:
            if (r5 >= r15) goto L8;
            r14[r5].writeTo(r10);
            r5 = r5 + 1;
            goto L6
        }
    }

    public static class TypeSpecChunk {
        private static final short HEADER_SIZE = 16;
        private static final int SPEC_PUBLIC = 1073741824;
        private final int entryCount;
        private final int[] entryFlags;
        private final ResChunkHeader header;
        private final TypeChunk typeChunk;

        public TypeSpecChunk(List<ColorResource> r10) {
            this.entryCount = ColorResource.access$000((ColorResource) j0.e(r10, 1)) + 1;
            HashSet r5 = new HashSet();
            Iterator<ColorResource> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            r5.add(Short.valueOf(ColorResource.access$000(r11.next())));
            goto L4
        L6:
            this.entryFlags = new int[this.entryCount];
            short r12 = 0;
        L8:
            if (r12 >= this.entryCount) goto L13;
            if (r5.contains(Short.valueOf(r12)) == false) goto L12;
            this.entryFlags[r12] = 1073741824;
        L12:
            r12 = (short) (r12 + 1);
            goto L8
        L13:
            this.header = new ResChunkHeader(ColorResourcesTableCreator.HEADER_TYPE_TYPE_SPEC, 16, getChunkSize());
            this.typeChunk = new TypeChunk(r10, r5, this.entryCount);
        }

        private int getChunkSize() {
            return (this.entryCount * 4) + 16;
        }

        public int getChunkSizeWithTypeChunk() {
            return getChunkSize() + this.typeChunk.getChunkSize();
        }

        public void writeTo(ByteArrayOutputStream r10) throws IOException {
            this.header.writeTo(r10);
            int r5 = 0;
            r10.write(new byte[]{ColorResourcesTableCreator.access$1300(), 0, 0, 0});
            r10.write(ColorResourcesTableCreator.access$500(this.entryCount));
            int[] r11 = this.entryFlags;
            int r12 = r11.length;
        L3:
            if (r5 >= r12) goto L5;
            r10.write(ColorResourcesTableCreator.access$500(r11[r5]));
            r5 = r5 + 1;
            goto L3
        L5:
            this.typeChunk.writeTo(r10);
        }
    }

    static {
        ANDROID_PACKAGE_INFO = new PackageInfo(1, "android");
        COLOR_RESOURCE_COMPARATOR = new AnonymousClass1();
    }

    private ColorResourcesTableCreator() {
    }

    public static /* synthetic */ byte[] access$1200(char r5) {
        return charToByteArray(r5);
    }

    public static /* synthetic */ byte access$1300() {
        return typeIdColor;
    }

    public static /* synthetic */ Comparator access$400() {
        return COLOR_RESOURCE_COMPARATOR;
    }

    public static /* synthetic */ byte[] access$500(int r5) {
        return intToByteArray(r5);
    }

    public static /* synthetic */ byte[] access$600(short r5) {
        return shortToByteArray(r5);
    }

    public static /* synthetic */ byte[] access$800(String r5) {
        return stringToByteArrayUtf8(r5);
    }

    public static /* synthetic */ byte[] access$900(String r5) {
        return stringToByteArray(r5);
    }

    private static byte[] charToByteArray(char r5) {
        return new byte[]{(byte) (r5 & 255), (byte) ((r5 >> '\b') & 255)};
    }

    public static byte[] create(Context r10, Map<Integer, Integer> r11) throws IOException {
        if (r11.entrySet().isEmpty() == true) goto L30;
        PackageInfo r5 = new PackageInfo(127, r10.getPackageName());
        HashMap r12 = new HashMap();
        Iterator<Map.Entry<Integer, Integer>> r13 = r11.entrySet().iterator();
        ColorResource r14 = null;
    L6:
        if (r13.hasNext() == false) goto L23;
        Map.Entry<Integer, Integer> r15 = r13.next();
        ColorResource r16 = new ColorResource(r15.getKey().intValue(), r10.getResources().getResourceName(r15.getKey().intValue()), r15.getValue().intValue());
        if (r10.getResources().getResourceTypeName(r15.getKey().intValue()).equals(RESOURCE_TYPE_NAME_COLOR) == false) goto L22;
        if (ColorResource.access$300(r16) != 1) goto L13;
        PackageInfo r17 = ANDROID_PACKAGE_INFO;
    L16:
        if (r12.containsKey(r17) == true) goto L18;
        r12.put(r17, new ArrayList());
    L18:
        ((List) r12.get(r17)).add(r16);
        r14 = r16;
        goto L6
    L13:
        if (ColorResource.access$300(r16) != 127) goto L20;
        r17 = r5;
        goto L16
    L20:
        throw new IllegalArgumentException("Not supported with unknown package id: " + ColorResource.access$300(r16));
    L22:
        throw new IllegalArgumentException("Non color resource found: name=" + ColorResource.access$100(r16) + ", typeId=" + Integer.toHexString(ColorResource.access$200(r16) & UByte.MAX_VALUE));
    L23:
        byte r18 = ColorResource.access$200(r14);
        typeIdColor = r18;
        if (r18 == 0) goto L28;
        ByteArrayOutputStream r19 = new ByteArrayOutputStream();
        new ResTable(r12).writeTo(r19);
        return r19.toByteArray();
    L28:
        throw new IllegalArgumentException("No color resources found for harmonization.");
    L30:
        throw new IllegalArgumentException("No color resources provided for harmonization.");
    }

    private static byte[] intToByteArray(int r5) {
        return new byte[]{(byte) (r5 & 255), (byte) ((r5 >> 8) & 255), (byte) ((r5 >> 16) & 255), (byte) ((r5 >> 24) & 255)};
    }

    private static byte[] shortToByteArray(short r5) {
        return new byte[]{(byte) (r5 & 255), (byte) ((r5 >> 8) & 255)};
    }

    private static byte[] stringToByteArray(String r10) {
        char[] r11 = r10.toCharArray();
        int r5 = r11.length * 2;
        byte[] r12 = new byte[r5 + 4];
        byte[] r13 = shortToByteArray((short) r11.length);
        r12[0] = r13[0];
        r12[1] = r13[1];
        int r14 = 0;
    L4:
        if (r14 >= r11.length) goto L6;
        byte[] r15 = charToByteArray(r11[r14]);
        int r16 = r14 * 2;
        r12[r16 + 2] = r15[0];
        r12[r16 + 3] = r15[1];
        r14 = r14 + 1;
        goto L4
    L6:
        r12[r5 + 2] = 0;
        r12[r5 + 3] = 0;
        return r12;
    }

    private static byte[] stringToByteArrayUtf8(String r5) {
        byte[] r10 = r5.getBytes(Charset.forName("UTF-8"));
        byte r11 = (byte) r10.length;
        int r12 = r10.length;
        byte[] r13 = new byte[r12 + 3];
        System.arraycopy(r10, 0, r13, 2, r11);
        r13[1] = r11;
        r13[0] = r11;
        r13[r12 + 2] = 0;
        return r13;
    }
}
