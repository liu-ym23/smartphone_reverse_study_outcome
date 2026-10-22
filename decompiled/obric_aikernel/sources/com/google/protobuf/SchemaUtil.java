package com.google.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
@CheckReturnValue
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = null;
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_FULL_SCHEMA = null;
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = null;

    static {
        GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
        UNKNOWN_FIELD_SET_FULL_SCHEMA = getUnknownFieldSetSchema();
        UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();
    }

    private SchemaUtil() {
    }

    static int computeSizeBoolList(int r10, List<?> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L6;
        return 0;
    L6:
        if (r12 == false) goto L10;
        return CodedOutputStream.computeTagSize(r10) + CodedOutputStream.computeLengthDelimitedFieldSize(r13);
    L10:
        return r13 * CodedOutputStream.computeBoolSize(r10, true);
    }

    static int computeSizeBoolListNoTag(List<?> r10) {
        return r10.size();
    }

    static int computeSizeByteStringList(int r10, List<ByteString> r11) {
        int r12 = r11.size();
        int r13 = 0;
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r14 = r12 * CodedOutputStream.computeTagSize(r10);
    L7:
        if (r13 >= r11.size()) goto L9;
        r14 = r14 + CodedOutputStream.computeBytesSizeNoTag(r11.get(r13));
        r13 = r13 + 1;
        goto L7
    L9:
        return r14;
    }

    static int computeSizeEnumList(int r10, List<Integer> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L6;
        return 0;
    L6:
        int r14 = computeSizeEnumListNoTag(r11);
        int r15 = CodedOutputStream.computeTagSize(r10);
        if (r12 == false) goto L11;
        return r15 + CodedOutputStream.computeLengthDelimitedFieldSize(r14);
    L11:
        return r14 + (r13 * r15);
    }

    static int computeSizeEnumListNoTag(List<Integer> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if ((r10 instanceof IntArrayList) == false) goto L10;
        IntArrayList r13 = (IntArrayList) r10;
        int r14 = 0;
    L8:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeEnumSizeNoTag(r13.getInt(r12));
        r12 = r12 + 1;
    L13:
        return r14;
    L10:
        r14 = 0;
    L11:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeEnumSizeNoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L11
    }

    static int computeSizeFixed32List(int r10, List<?> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L5;
        return 0;
    L5:
        if (r12 == false) goto L9;
        return CodedOutputStream.computeTagSize(r10) + CodedOutputStream.computeLengthDelimitedFieldSize(r13 * 4);
    L9:
        return r13 * CodedOutputStream.computeFixed32Size(r10, 0);
    }

    static int computeSizeFixed32ListNoTag(List<?> r10) {
        return r10.size() * 4;
    }

    static int computeSizeFixed64List(int r10, List<?> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L6;
        return 0;
    L6:
        if (r12 == false) goto L10;
        return CodedOutputStream.computeTagSize(r10) + CodedOutputStream.computeLengthDelimitedFieldSize(r13 * 8);
    L10:
        return r13 * CodedOutputStream.computeFixed64Size(r10, 0);
    }

    static int computeSizeFixed64ListNoTag(List<?> r10) {
        return r10.size() * 8;
    }

    static int computeSizeGroupList(int r10, List<MessageLite> r11) {
        int r12 = r11.size();
        int r13 = 0;
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r14 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r14 = r14 + CodedOutputStream.computeGroupSize(r10, r11.get(r13));
        r13 = r13 + 1;
        goto L6
    L8:
        return r14;
    }

    static int computeSizeGroupList(int r10, List<MessageLite> r11, Schema<?> r12) {
        int r13 = r11.size();
        int r14 = 0;
        if (r13 != 0) goto L5;
        return 0;
    L5:
        int r15 = 0;
    L6:
        if (r14 >= r13) goto L8;
        r15 = r15 + CodedOutputStream.computeGroupSize(r10, r11.get(r14), r12);
        r14 = r14 + 1;
        goto L6
    L8:
        return r15;
    }

    static int computeSizeInt32List(int r10, List<Integer> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L6;
        return 0;
    L6:
        int r14 = computeSizeInt32ListNoTag(r11);
        int r15 = CodedOutputStream.computeTagSize(r10);
        if (r12 == false) goto L11;
        return r15 + CodedOutputStream.computeLengthDelimitedFieldSize(r14);
    L11:
        return r14 + (r13 * r15);
    }

    static int computeSizeInt32ListNoTag(List<Integer> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if ((r10 instanceof IntArrayList) == false) goto L10;
        IntArrayList r13 = (IntArrayList) r10;
        int r14 = 0;
    L8:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(r13.getInt(r12));
        r12 = r12 + 1;
    L13:
        return r14;
    L10:
        r14 = 0;
    L11:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeInt32SizeNoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L11
    }

    static int computeSizeInt64List(int r10, List<Long> r11, boolean r12) {
        if (r11.size() != 0) goto L6;
        return 0;
    L6:
        int r13 = computeSizeInt64ListNoTag(r11);
        if (r12 == false) goto L11;
        return CodedOutputStream.computeTagSize(r10) + CodedOutputStream.computeLengthDelimitedFieldSize(r13);
    L11:
        return r13 + (r11.size() * CodedOutputStream.computeTagSize(r10));
    }

    static int computeSizeInt64ListNoTag(List<Long> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if ((r10 instanceof LongArrayList) == false) goto L10;
        LongArrayList r13 = (LongArrayList) r10;
        int r14 = 0;
    L8:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeInt64SizeNoTag(r13.getLong(r12));
        r12 = r12 + 1;
    L13:
        return r14;
    L10:
        r14 = 0;
    L11:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeInt64SizeNoTag(r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L11
    }

    static int computeSizeMessage(int r10, Object r11, Schema<?> r12) {
        if ((r11 instanceof LazyFieldLite) == false) goto L7;
        return CodedOutputStream.computeLazyFieldSize(r10, (LazyFieldLite) r11);
    L7:
        return CodedOutputStream.computeMessageSize(r10, (MessageLite) r11, r12);
    }

    static int computeSizeMessageList(int r10, List<?> r11) {
        int r12 = r11.size();
        int r13 = 0;
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r14 = CodedOutputStream.computeTagSize(r10) * r12;
    L6:
        if (r13 >= r12) goto L12;
        Object r15 = r11.get(r13);
        if ((r15 instanceof LazyFieldLite) == false) goto L10;
        int r16 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) r15);
    L11:
        r14 = r14 + r16;
        r13 = r13 + 1;
        goto L6
    L10:
        r16 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) r15);
        goto L11
    L12:
        return r14;
    }

    static int computeSizeMessageList(int r10, List<?> r11, Schema<?> r12) {
        int r13 = r11.size();
        int r14 = 0;
        if (r13 != 0) goto L5;
        return 0;
    L5:
        int r15 = CodedOutputStream.computeTagSize(r10) * r13;
    L6:
        if (r14 >= r13) goto L12;
        Object r16 = r11.get(r14);
        if ((r16 instanceof LazyFieldLite) == false) goto L10;
        int r17 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) r16);
    L11:
        r15 = r15 + r17;
        r14 = r14 + 1;
        goto L6
    L10:
        r17 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) r16, r12);
        goto L11
    L12:
        return r15;
    }

    static int computeSizeSInt32List(int r10, List<Integer> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L6;
        return 0;
    L6:
        int r14 = computeSizeSInt32ListNoTag(r11);
        int r15 = CodedOutputStream.computeTagSize(r10);
        if (r12 == false) goto L11;
        return r15 + CodedOutputStream.computeLengthDelimitedFieldSize(r14);
    L11:
        return r14 + (r13 * r15);
    }

    static int computeSizeSInt32ListNoTag(List<Integer> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if ((r10 instanceof IntArrayList) == false) goto L10;
        IntArrayList r13 = (IntArrayList) r10;
        int r14 = 0;
    L8:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeSInt32SizeNoTag(r13.getInt(r12));
        r12 = r12 + 1;
    L13:
        return r14;
    L10:
        r14 = 0;
    L11:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeSInt32SizeNoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L11
    }

    static int computeSizeSInt64List(int r10, List<Long> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L6;
        return 0;
    L6:
        int r14 = computeSizeSInt64ListNoTag(r11);
        int r15 = CodedOutputStream.computeTagSize(r10);
        if (r12 == false) goto L11;
        return r15 + CodedOutputStream.computeLengthDelimitedFieldSize(r14);
    L11:
        return r14 + (r13 * r15);
    }

    static int computeSizeSInt64ListNoTag(List<Long> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if ((r10 instanceof LongArrayList) == false) goto L10;
        LongArrayList r13 = (LongArrayList) r10;
        int r14 = 0;
    L8:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeSInt64SizeNoTag(r13.getLong(r12));
        r12 = r12 + 1;
    L13:
        return r14;
    L10:
        r14 = 0;
    L11:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeSInt64SizeNoTag(r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L11
    }

    static int computeSizeStringList(int r10, List<?> r11) {
        int r12 = r11.size();
        int r13 = 0;
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r14 = CodedOutputStream.computeTagSize(r10) * r12;
        if ((r11 instanceof LazyStringList) == false) goto L14;
        LazyStringList r15 = (LazyStringList) r11;
    L8:
        if (r13 >= r12) goto L20;
        Object r16 = r15.getRaw(r13);
        if ((r16 instanceof ByteString) == false) goto L12;
        int r17 = CodedOutputStream.computeBytesSizeNoTag((ByteString) r16);
    L13:
        r14 = r14 + r17;
        r13 = r13 + 1;
        goto L8
    L12:
        r17 = CodedOutputStream.computeStringSizeNoTag((String) r16);
    L20:
        return r14;
    L14:
        if (r13 >= r12) goto L20;
        Object r18 = r11.get(r13);
        if ((r18 instanceof ByteString) == false) goto L18;
        int r19 = CodedOutputStream.computeBytesSizeNoTag((ByteString) r18);
    L19:
        r14 = r14 + r19;
        r13 = r13 + 1;
        goto L14
    L18:
        r19 = CodedOutputStream.computeStringSizeNoTag((String) r18);
        goto L19
    }

    static int computeSizeUInt32List(int r10, List<Integer> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L6;
        return 0;
    L6:
        int r14 = computeSizeUInt32ListNoTag(r11);
        int r15 = CodedOutputStream.computeTagSize(r10);
        if (r12 == false) goto L11;
        return r15 + CodedOutputStream.computeLengthDelimitedFieldSize(r14);
    L11:
        return r14 + (r13 * r15);
    }

    static int computeSizeUInt32ListNoTag(List<Integer> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if ((r10 instanceof IntArrayList) == false) goto L10;
        IntArrayList r13 = (IntArrayList) r10;
        int r14 = 0;
    L8:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeUInt32SizeNoTag(r13.getInt(r12));
        r12 = r12 + 1;
    L13:
        return r14;
    L10:
        r14 = 0;
    L11:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeUInt32SizeNoTag(r10.get(r12).intValue());
        r12 = r12 + 1;
        goto L11
    }

    static int computeSizeUInt64List(int r10, List<Long> r11, boolean r12) {
        int r13 = r11.size();
        if (r13 != 0) goto L6;
        return 0;
    L6:
        int r14 = computeSizeUInt64ListNoTag(r11);
        int r15 = CodedOutputStream.computeTagSize(r10);
        if (r12 == false) goto L11;
        return r15 + CodedOutputStream.computeLengthDelimitedFieldSize(r14);
    L11:
        return r14 + (r13 * r15);
    }

    static int computeSizeUInt64ListNoTag(List<Long> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if ((r10 instanceof LongArrayList) == false) goto L10;
        LongArrayList r13 = (LongArrayList) r10;
        int r14 = 0;
    L8:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeUInt64SizeNoTag(r13.getLong(r12));
        r12 = r12 + 1;
    L13:
        return r14;
    L10:
        r14 = 0;
    L11:
        if (r12 >= r11) goto L13;
        r14 = r14 + CodedOutputStream.computeUInt64SizeNoTag(r10.get(r12).longValue());
        r12 = r12 + 1;
        goto L11
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB filterUnknownEnumList(Object r10, int r11, List<Integer> r12, Internal.EnumLiteMap<?> r13, UB r14, UnknownFieldSchema<UT, UB> r15) {
        if (r13 != null) goto L5;
        return r14;
    L5:
        if ((r12 instanceof RandomAccess) == false) goto L17;
        int r16 = r12.size();
        int r17 = 0;
        int r18 = 0;
    L7:
        if (r17 >= r16) goto L15;
        int r19 = r12.get(r17).intValue();
        if (r13.findValueByNumber(r19) == null) goto L13;
        if (r17 == r18) goto L12;
        r12.set(r18, Integer.valueOf(r19));
    L12:
        r18 = r18 + 1;
    L14:
        r17 = r17 + 1;
        goto L7
    L13:
        r14 = (UB) storeUnknownEnum(r10, r11, r19, r14, r15);
        goto L14
    L15:
        if (r18 == r16) goto L23;
        r12.subList(r18, r16).clear();
    L23:
        return r14;
    L17:
        Iterator<Integer> r20 = r12.iterator();
    L19:
        if (r20.hasNext() == false) goto L23;
        int r21 = r20.next().intValue();
        if (r13.findValueByNumber(r21) != null) goto L19;
        r14 = (UB) storeUnknownEnum(r10, r11, r21, r14, r15);
        r20.remove();
        goto L19
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB filterUnknownEnumList(Object r10, int r11, List<Integer> r12, Internal.EnumVerifier r13, UB r14, UnknownFieldSchema<UT, UB> r15) {
        if (r13 != null) goto L5;
        return r14;
    L5:
        if ((r12 instanceof RandomAccess) == false) goto L17;
        int r16 = r12.size();
        int r17 = 0;
        int r18 = 0;
    L7:
        if (r17 >= r16) goto L15;
        int r19 = r12.get(r17).intValue();
        if (r13.isInRange(r19) == false) goto L13;
        if (r17 == r18) goto L12;
        r12.set(r18, Integer.valueOf(r19));
    L12:
        r18 = r18 + 1;
    L14:
        r17 = r17 + 1;
        goto L7
    L13:
        r14 = (UB) storeUnknownEnum(r10, r11, r19, r14, r15);
        goto L14
    L15:
        if (r18 == r16) goto L23;
        r12.subList(r18, r16).clear();
    L23:
        return r14;
    L17:
        Iterator<Integer> r20 = r12.iterator();
    L19:
        if (r20.hasNext() == false) goto L23;
        int r21 = r20.next().intValue();
        if (r13.isInRange(r21) == true) goto L19;
        r14 = (UB) storeUnknownEnum(r10, r11, r21, r14, r15);
        r20.remove();
        goto L19
    }

    private static Class<?> getGeneratedMessageClass() {
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        return Class.forName("com.google.protobuf.GeneratedMessage");
    L7:
        return null;
    }

    static Object getMapDefaultEntry(Class<?> r10, String r11) {
        java.lang.reflect.Field[] r12 = Class.forName(r10.getName() + "$" + toCamelCase(r11, true) + "DefaultEntryHolder").getDeclaredFields();     // Catch: Throwable -> L8
        if (r12.length != 1) goto L7;
        return UnsafeUtil.getStaticObject(r12[0]);
    L7:
        throw new IllegalStateException("Unable to look up map field default entry holder class for " + r11 + " in " + r10.getName());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw new RuntimeException(th);
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        Class<?> r10 = getUnknownFieldSetSchemaClass();     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return null;
    L6:
        return (UnknownFieldSchema) r10.getConstructor(new Class[0]).newInstance(new Object[0]);
    L8:
        return null;
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        int r10 = UnknownFieldSetSchema.f4292a;     // Catch: Throwable -> L7
        return UnknownFieldSetSchema.class;
    L7:
        return null;
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> r10, T r11, T r12) {
        FieldSet<T> r13 = r10.getExtensions(r12);
        if (r13.isEmpty() == true) goto L6;
        r10.getMutableExtensions(r11).mergeFrom(r13);
        return;
    }

    static <T> void mergeMap(MapFieldSchema r10, T r11, T r12, long r13) {
        UnsafeUtil.putObject(r11, r13, r10.mergeFrom(UnsafeUtil.getObject(r11, r13), UnsafeUtil.getObject(r12, r13)));
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> r10, T r11, T r12) {
        r10.setToMessage(r11, r10.merge(r10.getFromMessage(r11), r10.getFromMessage(r12)));
    }

    public static void requireGeneratedMessage(Class<?> r10) {
        if (GeneratedMessageLite.class.isAssignableFrom(r10) == false) goto L5;
        return;
    L5:
        if (Protobuf.assumeLiteRuntime == true) goto L14;
        Class<?> r11 = GENERATED_MESSAGE_CLASS;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.isAssignableFrom(r10) == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    static boolean safeEquals(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        return true;
    }

    public static boolean shouldUseTableSwitch(int r10, int r11, int r12) {
        if (r11 >= 40) goto L5;
        return true;
    L5:
        long r13 = r12;
        if ((((((long) r11) - ((long) r10)) + 1) + 9) <= (((2 * r13) + 3) + ((r13 + 3) * 3))) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] r10) {
        if (r10.length != 0) goto L6;
        return false;
    L6:
        return shouldUseTableSwitch(r10[0].getFieldNumber(), r10[r10.length - 1].getFieldNumber(), r10.length);
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB storeUnknownEnum(Object r10, int r11, int r12, UB r13, UnknownFieldSchema<UT, UB> r14) {
        if (r13 != null) goto L4;
        r13 = r14.getBuilderFromMessage(r10);
    L4:
        r14.addVarint(r13, r11, r12);
        return r13;
    }

    static String toCamelCase(String r10, boolean r11) {
        StringBuilder r12 = new StringBuilder();
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L29;
        char r14 = r10.charAt(r13);
        if ('a' > r14) goto L15;
        if (r14 > 'z') goto L15;
        if (r11 == false) goto L12;
        int r15 = r14 - ' ';
    L11:
        r12.append((char) r15);
    L13:
        r11 = false;
    L27:
        r13 = r13 + 1;
    L12:
        r12.append(r14);
    L15:
        if ('A' > r14) goto L22;
        if (r14 > 'Z') goto L22;
        if (r13 != 0) goto L12;
        if (r11 == true) goto L12;
        r15 = r14 + ' ';
    L22:
        if ('0' <= r14) goto L24;
    L26:
        r11 = true;
        goto L27
    L24:
        if (r14 > '9') goto L26;
        r12.append(r14);
        goto L26
    L29:
        return r12.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int r10, boolean r11, Writer r12) {
        if (r11 == false) goto L5;
        r12.writeBool(r10, true);
        return;
    }

    public static void writeBoolList(int r10, List<Boolean> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeBoolList(r10, r11, r13);
        return;
    }

    public static void writeBytes(int r10, ByteString r11, Writer r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeBytes(r10, r11);
        return;
    }

    public static void writeBytesList(int r10, List<ByteString> r11, Writer r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeBytesList(r10, r11);
        return;
    }

    public static void writeDouble(int r10, double r11, Writer r12) {
        if (Double.doubleToRawLongBits(r11) == 0) goto L6;
        r12.writeDouble(r10, r11);
        return;
    }

    public static void writeDoubleList(int r10, List<Double> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeDoubleList(r10, r11, r13);
        return;
    }

    public static void writeEnum(int r10, int r11, Writer r12) {
        if (r11 == 0) goto L5;
        r12.writeEnum(r10, r11);
        return;
    }

    public static void writeEnumList(int r10, List<Integer> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeEnumList(r10, r11, r13);
        return;
    }

    public static void writeFixed32(int r10, int r11, Writer r12) {
        if (r11 == 0) goto L5;
        r12.writeFixed32(r10, r11);
        return;
    }

    public static void writeFixed32List(int r10, List<Integer> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeFixed32List(r10, r11, r13);
        return;
    }

    public static void writeFixed64(int r10, long r11, Writer r12) {
        if (r11 == 0) goto L6;
        r12.writeFixed64(r10, r11);
        return;
    }

    public static void writeFixed64List(int r10, List<Long> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeFixed64List(r10, r11, r13);
        return;
    }

    public static void writeFloat(int r10, float r11, Writer r12) {
        if (Float.floatToRawIntBits(r11) == 0) goto L6;
        r12.writeFloat(r10, r11);
        return;
    }

    public static void writeFloatList(int r10, List<Float> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeFloatList(r10, r11, r13);
        return;
    }

    public static void writeGroupList(int r10, List<?> r11, Writer r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeGroupList(r10, r11);
        return;
    }

    public static void writeGroupList(int r10, List<?> r11, Writer r12, Schema<?> r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeGroupList(r10, r11, r13);
        return;
    }

    public static void writeInt32(int r10, int r11, Writer r12) {
        if (r11 == 0) goto L5;
        r12.writeInt32(r10, r11);
        return;
    }

    public static void writeInt32List(int r10, List<Integer> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeInt32List(r10, r11, r13);
        return;
    }

    public static void writeInt64(int r10, long r11, Writer r12) {
        if (r11 == 0) goto L6;
        r12.writeInt64(r10, r11);
        return;
    }

    public static void writeInt64List(int r10, List<Long> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeInt64List(r10, r11, r13);
        return;
    }

    public static void writeLazyFieldList(int r10, List<?> r11, Writer r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L11;
        Iterator<?> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L12;
        ((LazyFieldLite) r13.next()).writeTo(r12, r10);
        goto L7
    L12:
        return;
    }

    public static void writeMessage(int r10, Object r11, Writer r12) {
        if (r11 == null) goto L5;
        r12.writeMessage(r10, r11);
        return;
    }

    public static void writeMessageList(int r10, List<?> r11, Writer r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeMessageList(r10, r11);
        return;
    }

    public static void writeMessageList(int r10, List<?> r11, Writer r12, Schema<?> r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeMessageList(r10, r11, r13);
        return;
    }

    public static void writeSFixed32(int r10, int r11, Writer r12) {
        if (r11 == 0) goto L5;
        r12.writeSFixed32(r10, r11);
        return;
    }

    public static void writeSFixed32List(int r10, List<Integer> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeSFixed32List(r10, r11, r13);
        return;
    }

    public static void writeSFixed64(int r10, long r11, Writer r12) {
        if (r11 == 0) goto L6;
        r12.writeSFixed64(r10, r11);
        return;
    }

    public static void writeSFixed64List(int r10, List<Long> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeSFixed64List(r10, r11, r13);
        return;
    }

    public static void writeSInt32(int r10, int r11, Writer r12) {
        if (r11 == 0) goto L5;
        r12.writeSInt32(r10, r11);
        return;
    }

    public static void writeSInt32List(int r10, List<Integer> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeSInt32List(r10, r11, r13);
        return;
    }

    public static void writeSInt64(int r10, long r11, Writer r12) {
        if (r11 == 0) goto L6;
        r12.writeSInt64(r10, r11);
        return;
    }

    public static void writeSInt64List(int r10, List<Long> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeSInt64List(r10, r11, r13);
        return;
    }

    public static void writeString(int r10, Object r11, Writer r12) {
        if ((r11 instanceof String) == false) goto L5;
        writeStringInternal(r10, (String) r11, r12);
        return;
    L5:
        writeBytes(r10, (ByteString) r11, r12);
    }

    private static void writeStringInternal(int r10, String r11, Writer r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeString(r10, r11);
        return;
    }

    public static void writeStringList(int r10, List<String> r11, Writer r12) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeStringList(r10, r11);
        return;
    }

    public static void writeUInt32(int r10, int r11, Writer r12) {
        if (r11 == 0) goto L5;
        r12.writeUInt32(r10, r11);
        return;
    }

    public static void writeUInt32List(int r10, List<Integer> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeUInt32List(r10, r11, r13);
        return;
    }

    public static void writeUInt64(int r10, long r11, Writer r12) {
        if (r11 == 0) goto L6;
        r12.writeUInt64(r10, r11);
        return;
    }

    public static void writeUInt64List(int r10, List<Long> r11, Writer r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.isEmpty() == true) goto L8;
        r12.writeUInt64List(r10, r11, r13);
        return;
    }
}
