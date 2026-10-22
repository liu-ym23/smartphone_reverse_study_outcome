package com.google.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
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

    @Deprecated
    public static int computeGroupSize(int r8, MessageLite r10, Schema r11) {
        return (CodedOutputStream.computeTagSize(r8) * 2) + computeGroupSizeNoTag(r10, r11);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite r8, Schema r10) {
        return ((AbstractMessageLite) r8).getSerializedSize(r10);
    }

    public static int computeMessageSize(int r8, AbstractMessageLite r10, Schema r11) {
        return CodedOutputStream.computeTagSize(r8) + computeMessageSizeNoTag(r10, r11);
    }

    public static int computeMessageSizeNoTag(AbstractMessageLite r8, Schema r10) {
        return CodedOutputStream.computeLengthDelimitedFieldSize(r8.getSerializedSize(r10));
    }

    public static int computeSizeBoolList(int r8, List<?> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        if (r11 == false) goto L10;
        int r13 = CodedOutputStream.computeTagSize(r8);
        return CodedOutputStream.computeLengthDelimitedFieldSize(r12) + r13;
    L10:
        return CodedOutputStream.computeBoolSize(r8, true) * r12;
    }

    public static int computeSizeBoolListNoTag(List<?> r8) {
        return r8.size();
    }

    public static int computeSizeByteStringList(int r8, List<ByteString> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L5;
        return 0;
    L5:
        int r13 = CodedOutputStream.computeTagSize(r8) * r11;
    L7:
        if (r12 >= r10.size()) goto L9;
        r13 = r13 + CodedOutputStream.computeBytesSizeNoTag(r10.get(r12));
        r12 = r12 + 1;
        goto L7
    L9:
        return r13;
    }

    public static int computeSizeEnumList(int r8, List<Integer> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        int r13 = computeSizeEnumListNoTag(r10);
        int r14 = CodedOutputStream.computeTagSize(r8);
        if (r11 == false) goto L11;
        return CodedOutputStream.computeLengthDelimitedFieldSize(r13) + r14;
    L11:
        return (r14 * r12) + r13;
    }

    public static int computeSizeEnumListNoTag(List<Integer> r8) {
        int r10 = r8.size();
        int r11 = 0;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if ((r8 instanceof IntArrayList) == false) goto L10;
        IntArrayList r12 = (IntArrayList) r8;
        int r13 = 0;
    L8:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeEnumSizeNoTag(r12.getInt(r11));
        r11 = r11 + 1;
    L13:
        return r13;
    L10:
        r13 = 0;
    L11:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeEnumSizeNoTag(r8.get(r11).intValue());
        r11 = r11 + 1;
        goto L11
    }

    public static int computeSizeFixed32List(int r8, List<?> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L5;
        return 0;
    L5:
        if (r11 == false) goto L9;
        int r13 = CodedOutputStream.computeTagSize(r8);
        return CodedOutputStream.computeLengthDelimitedFieldSize(r12 * 4) + r13;
    L9:
        return CodedOutputStream.computeFixed32Size(r8, 0) * r12;
    }

    public static int computeSizeFixed32ListNoTag(List<?> r8) {
        return r8.size() * 4;
    }

    public static int computeSizeFixed64List(int r8, List<?> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        if (r11 == false) goto L10;
        int r13 = CodedOutputStream.computeTagSize(r8);
        return CodedOutputStream.computeLengthDelimitedFieldSize(r12 * 8) + r13;
    L10:
        return CodedOutputStream.computeFixed64Size(r8, 0) * r12;
    }

    public static int computeSizeFixed64ListNoTag(List<?> r8) {
        return r8.size() * 8;
    }

    public static int computeSizeGroupList(int r8, List<MessageLite> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L5;
        return 0;
    L5:
        int r13 = 0;
    L6:
        if (r12 >= r11) goto L8;
        r13 = r13 + CodedOutputStream.computeGroupSize(r8, r10.get(r12));
        r12 = r12 + 1;
        goto L6
    L8:
        return r13;
    }

    public static int computeSizeInt32List(int r8, List<Integer> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        int r13 = computeSizeInt32ListNoTag(r10);
        int r14 = CodedOutputStream.computeTagSize(r8);
        if (r11 == false) goto L11;
        return CodedOutputStream.computeLengthDelimitedFieldSize(r13) + r14;
    L11:
        return (r14 * r12) + r13;
    }

    public static int computeSizeInt32ListNoTag(List<Integer> r8) {
        int r10 = r8.size();
        int r11 = 0;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if ((r8 instanceof IntArrayList) == false) goto L10;
        IntArrayList r12 = (IntArrayList) r8;
        int r13 = 0;
    L8:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(r12.getInt(r11));
        r11 = r11 + 1;
    L13:
        return r13;
    L10:
        r13 = 0;
    L11:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeInt32SizeNoTag(r8.get(r11).intValue());
        r11 = r11 + 1;
        goto L11
    }

    public static int computeSizeInt64List(int r8, List<Long> r10, boolean r11) {
        if (r10.size() != 0) goto L6;
        return 0;
    L6:
        int r12 = computeSizeInt64ListNoTag(r10);
        if (r11 == false) goto L10;
        int r13 = CodedOutputStream.computeTagSize(r8);
        return CodedOutputStream.computeLengthDelimitedFieldSize(r12) + r13;
    L10:
        int r14 = r10.size();
        return (CodedOutputStream.computeTagSize(r8) * r14) + r12;
    }

    public static int computeSizeInt64ListNoTag(List<Long> r8) {
        int r10 = r8.size();
        int r11 = 0;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if ((r8 instanceof LongArrayList) == false) goto L10;
        LongArrayList r12 = (LongArrayList) r8;
        int r13 = 0;
    L8:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeInt64SizeNoTag(r12.getLong(r11));
        r11 = r11 + 1;
    L13:
        return r13;
    L10:
        r13 = 0;
    L11:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeInt64SizeNoTag(r8.get(r11).longValue());
        r11 = r11 + 1;
        goto L11
    }

    public static int computeSizeMessage(int r8, Object r10, Schema<?> r11) {
        if ((r10 instanceof LazyFieldLite) == false) goto L7;
        return ((LazyFieldLite) r10).computeSize(r8);
    L7:
        return computeMessageSize(r8, (AbstractMessageLite) r10, r11);
    }

    public static int computeSizeMessageList(int r8, List<?> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L5;
        return 0;
    L5:
        int r13 = CodedOutputStream.computeTagSize(r8) * r11;
    L6:
        if (r12 >= r11) goto L12;
        Object r14 = r10.get(r12);
        if ((r14 instanceof LazyFieldLite) == false) goto L10;
        int r15 = ((LazyFieldLite) r14).computeSizeNoTag();
    L11:
        r13 = r15 + r13;
        r12 = r12 + 1;
        goto L6
    L10:
        r15 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) r14);
        goto L11
    L12:
        return r13;
    }

    public static int computeSizeSInt32List(int r8, List<Integer> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        int r13 = computeSizeSInt32ListNoTag(r10);
        int r14 = CodedOutputStream.computeTagSize(r8);
        if (r11 == false) goto L11;
        return CodedOutputStream.computeLengthDelimitedFieldSize(r13) + r14;
    L11:
        return (r14 * r12) + r13;
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> r8) {
        int r10 = r8.size();
        int r11 = 0;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if ((r8 instanceof IntArrayList) == false) goto L10;
        IntArrayList r12 = (IntArrayList) r8;
        int r13 = 0;
    L8:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeSInt32SizeNoTag(r12.getInt(r11));
        r11 = r11 + 1;
    L13:
        return r13;
    L10:
        r13 = 0;
    L11:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeSInt32SizeNoTag(r8.get(r11).intValue());
        r11 = r11 + 1;
        goto L11
    }

    public static int computeSizeSInt64List(int r8, List<Long> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        int r13 = computeSizeSInt64ListNoTag(r10);
        int r14 = CodedOutputStream.computeTagSize(r8);
        if (r11 == false) goto L11;
        return CodedOutputStream.computeLengthDelimitedFieldSize(r13) + r14;
    L11:
        return (r14 * r12) + r13;
    }

    public static int computeSizeSInt64ListNoTag(List<Long> r8) {
        int r10 = r8.size();
        int r11 = 0;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if ((r8 instanceof LongArrayList) == false) goto L10;
        LongArrayList r12 = (LongArrayList) r8;
        int r13 = 0;
    L8:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeSInt64SizeNoTag(r12.getLong(r11));
        r11 = r11 + 1;
    L13:
        return r13;
    L10:
        r13 = 0;
    L11:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeSInt64SizeNoTag(r8.get(r11).longValue());
        r11 = r11 + 1;
        goto L11
    }

    public static int computeSizeStringList(int r8, List<?> r10) {
        int r11 = r10.size();
        int r12 = 0;
        if (r11 != 0) goto L5;
        return 0;
    L5:
        int r13 = CodedOutputStream.computeTagSize(r8) * r11;
        if ((r10 instanceof LazyStringList) == false) goto L14;
        LazyStringList r14 = (LazyStringList) r10;
    L8:
        if (r12 >= r11) goto L20;
        Object r15 = r14.getRaw(r12);
        if ((r15 instanceof ByteString) == false) goto L12;
        int r16 = CodedOutputStream.computeBytesSizeNoTag((ByteString) r15);
    L13:
        r13 = r16 + r13;
        r12 = r12 + 1;
        goto L8
    L12:
        r16 = CodedOutputStream.computeStringSizeNoTag((String) r15);
    L20:
        return r13;
    L14:
        if (r12 >= r11) goto L20;
        Object r17 = r10.get(r12);
        if ((r17 instanceof ByteString) == false) goto L18;
        int r18 = CodedOutputStream.computeBytesSizeNoTag((ByteString) r17);
    L19:
        r13 = r18 + r13;
        r12 = r12 + 1;
        goto L14
    L18:
        r18 = CodedOutputStream.computeStringSizeNoTag((String) r17);
        goto L19
    }

    public static int computeSizeUInt32List(int r8, List<Integer> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        int r13 = computeSizeUInt32ListNoTag(r10);
        int r14 = CodedOutputStream.computeTagSize(r8);
        if (r11 == false) goto L11;
        return CodedOutputStream.computeLengthDelimitedFieldSize(r13) + r14;
    L11:
        return (r14 * r12) + r13;
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> r8) {
        int r10 = r8.size();
        int r11 = 0;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if ((r8 instanceof IntArrayList) == false) goto L10;
        IntArrayList r12 = (IntArrayList) r8;
        int r13 = 0;
    L8:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeUInt32SizeNoTag(r12.getInt(r11));
        r11 = r11 + 1;
    L13:
        return r13;
    L10:
        r13 = 0;
    L11:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeUInt32SizeNoTag(r8.get(r11).intValue());
        r11 = r11 + 1;
        goto L11
    }

    public static int computeSizeUInt64List(int r8, List<Long> r10, boolean r11) {
        int r12 = r10.size();
        if (r12 != 0) goto L6;
        return 0;
    L6:
        int r13 = computeSizeUInt64ListNoTag(r10);
        int r14 = CodedOutputStream.computeTagSize(r8);
        if (r11 == false) goto L11;
        return CodedOutputStream.computeLengthDelimitedFieldSize(r13) + r14;
    L11:
        return (r14 * r12) + r13;
    }

    public static int computeSizeUInt64ListNoTag(List<Long> r8) {
        int r10 = r8.size();
        int r11 = 0;
        if (r10 != 0) goto L6;
        return 0;
    L6:
        if ((r8 instanceof LongArrayList) == false) goto L10;
        LongArrayList r12 = (LongArrayList) r8;
        int r13 = 0;
    L8:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeUInt64SizeNoTag(r12.getLong(r11));
        r11 = r11 + 1;
    L13:
        return r13;
    L10:
        r13 = 0;
    L11:
        if (r11 >= r10) goto L13;
        r13 = r13 + CodedOutputStream.computeUInt64SizeNoTag(r8.get(r11).longValue());
        r11 = r11 + 1;
        goto L11
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object r8, int r10, List<Integer> r11, Internal.EnumLiteMap<?> r12, UB r13, UnknownFieldSchema<UT, UB> r14) {
        if (r12 != null) goto L5;
        return r13;
    L5:
        if ((r11 instanceof RandomAccess) == false) goto L17;
        int r15 = r11.size();
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r16 >= r15) goto L15;
        int r18 = r11.get(r16).intValue();
        if (r12.findValueByNumber(r18) == null) goto L13;
        if (r16 == r17) goto L12;
        r11.set(r17, Integer.valueOf(r18));
    L12:
        r17 = r17 + 1;
    L14:
        r16 = r16 + 1;
        goto L7
    L13:
        r13 = (UB) storeUnknownEnum(r8, r10, r18, r13, r14);
        goto L14
    L15:
        if (r17 == r15) goto L23;
        r11.subList(r17, r15).clear();
    L23:
        return r13;
    L17:
        Iterator<Integer> r19 = r11.iterator();
    L19:
        if (r19.hasNext() == false) goto L23;
        int r20 = r19.next().intValue();
        if (r12.findValueByNumber(r20) != null) goto L19;
        r13 = (UB) storeUnknownEnum(r8, r10, r20, r13, r14);
        r19.remove();
        goto L19
    }

    private static Class<?> getGeneratedMessageClass() {
        if (Android.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        boolean r8 = GeneratedMessage.alwaysUseFieldBuilders;     // Catch: Throwable -> L7
        return GeneratedMessage.class;
    L7:
        return null;
    }

    public static Object getMapDefaultEntry(Class<?> r8, String r10) {
        java.lang.reflect.Field[] r11 = Class.forName(r8.getName() + "$" + toCamelCase(r10, true) + "DefaultEntryHolder").getDeclaredFields();     // Catch: Throwable -> L9
        if (r11.length != 1) goto L8;
        return UnsafeUtil.getStaticObject(r11[0]);
    L8:
        throw new IllegalStateException("Unable to look up map field default entry holder class for " + r10 + " in " + r8.getName());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw new RuntimeException(th);
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        Class<?> r8 = getUnknownFieldSetSchemaClass();     // Catch: Throwable -> L8
        if (r8 != null) goto L6;
        return null;
    L6:
        return (UnknownFieldSchema) r8.getConstructor(new Class[0]).newInstance(new Object[0]);
    L8:
        return null;
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        if (Android.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        int r8 = UnknownFieldSetSchema.f5190a;     // Catch: Throwable -> L7
        return UnknownFieldSetSchema.class;
    L7:
        return null;
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> r8, T r10, T r11) {
        FieldSet<T> r12 = r8.getExtensions(r11);
        if (r12.isEmpty() == true) goto L6;
        r8.getMutableExtensions(r10).mergeFrom(r12);
        return;
    }

    public static <T> void mergeMap(MapFieldSchema r8, T r10, T r11, long r12) {
        UnsafeUtil.putObject(r10, r12, r8.mergeFrom(UnsafeUtil.getObject(r10, r12), UnsafeUtil.getObject(r11, r12)));
    }

    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> r8, T r10, T r11) {
        r8.setToMessage(r10, r8.merge(r8.getFromMessage(r10), r8.getFromMessage(r11)));
    }

    public static void requireGeneratedMessage(Class<?> r8) {
        if (GeneratedMessageLite.class.isAssignableFrom(r8) == false) goto L5;
        return;
    L5:
        if (Android.assumeLiteRuntime == true) goto L14;
        Class<?> r10 = GENERATED_MESSAGE_CLASS;
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.isAssignableFrom(r8) == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public static boolean safeEquals(Object r8, Object r10) {
        if (r8 == r10) goto L8;
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.equals(r10) == false) goto L7;
    L8:
        return true;
    }

    public static boolean shouldUseTableSwitch(int r10, int r11, int r12) {
        if (r11 >= 40) goto L5;
        return true;
    L5:
        long r8 = (((long) r11) - ((long) r10)) + 1;
        long r13 = r12;
        if ((r8 + 9) <= (((r13 + 3) * 3) + ((2 * r13) + 3))) goto L10;
        return false;
    L10:
        return true;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB storeUnknownEnum(Object r8, int r10, int r11, UB r12, UnknownFieldSchema<UT, UB> r13) {
        if (r12 != null) goto L4;
        r12 = r13.getBuilderFromMessage(r8);
    L4:
        r13.addVarint(r12, r10, r11);
        return r12;
    }

    public static String toCamelCase(String r8, boolean r10) {
        StringBuilder r11 = new StringBuilder();
        int r12 = 0;
    L4:
        if (r12 >= r8.length()) goto L29;
        char r13 = r8.charAt(r12);
        if ('a' > r13) goto L15;
        if (r13 > 'z') goto L15;
        if (r10 == false) goto L12;
        int r14 = r13 - ' ';
    L11:
        r11.append((char) r14);
    L13:
        r10 = false;
    L27:
        r12 = r12 + 1;
    L12:
        r11.append(r13);
    L15:
        if ('A' > r13) goto L22;
        if (r13 > 'Z') goto L22;
        if (r12 != 0) goto L12;
        if (r10 == true) goto L12;
        r14 = r13 + ' ';
    L22:
        if ('0' <= r13) goto L24;
    L26:
        r10 = true;
        goto L27
    L24:
        if (r13 > '9') goto L26;
        r11.append(r13);
        goto L26
    L29:
        return r11.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int r8, boolean r10, Writer r11) {
        if (r10 == false) goto L5;
        r11.writeBool(r8, true);
        return;
    }

    public static void writeBoolList(int r8, List<Boolean> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeBoolList(r8, r10, r12);
        return;
    }

    public static void writeBytes(int r8, ByteString r10, Writer r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeBytes(r8, r10);
        return;
    }

    public static void writeBytesList(int r8, List<ByteString> r10, Writer r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeBytesList(r8, r10);
        return;
    }

    public static void writeDouble(int r8, double r10, Writer r11) {
        if (Double.doubleToRawLongBits(r10) == 0) goto L6;
        r11.writeDouble(r8, r10);
        return;
    }

    public static void writeDoubleList(int r8, List<Double> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeDoubleList(r8, r10, r12);
        return;
    }

    public static void writeEnum(int r8, int r10, Writer r11) {
        if (r10 == 0) goto L5;
        r11.writeEnum(r8, r10);
        return;
    }

    public static void writeEnumList(int r8, List<Integer> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeEnumList(r8, r10, r12);
        return;
    }

    public static void writeFixed32(int r8, int r10, Writer r11) {
        if (r10 == 0) goto L5;
        r11.writeFixed32(r8, r10);
        return;
    }

    public static void writeFixed32List(int r8, List<Integer> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeFixed32List(r8, r10, r12);
        return;
    }

    public static void writeFixed64(int r8, long r10, Writer r11) {
        if (r10 == 0) goto L6;
        r11.writeFixed64(r8, r10);
        return;
    }

    public static void writeFixed64List(int r8, List<Long> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeFixed64List(r8, r10, r12);
        return;
    }

    public static void writeFloat(int r8, float r10, Writer r11) {
        if (Float.floatToRawIntBits(r10) == 0) goto L6;
        r11.writeFloat(r8, r10);
        return;
    }

    public static void writeFloatList(int r8, List<Float> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeFloatList(r8, r10, r12);
        return;
    }

    public static void writeGroupList(int r8, List<?> r10, Writer r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeGroupList(r8, r10);
        return;
    }

    public static void writeInt32(int r8, int r10, Writer r11) {
        if (r10 == 0) goto L5;
        r11.writeInt32(r8, r10);
        return;
    }

    public static void writeInt32List(int r8, List<Integer> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeInt32List(r8, r10, r12);
        return;
    }

    public static void writeInt64(int r8, long r10, Writer r11) {
        if (r10 == 0) goto L6;
        r11.writeInt64(r8, r10);
        return;
    }

    public static void writeInt64List(int r8, List<Long> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeInt64List(r8, r10, r12);
        return;
    }

    public static void writeLazyFieldList(int r8, List<?> r10, Writer r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L11;
        Iterator<?> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        ((LazyFieldLite) r12.next()).writeTo(r11, r8);
        goto L7
    L12:
        return;
    }

    public static void writeMessage(int r8, Object r10, Writer r11) {
        if (r10 == null) goto L5;
        r11.writeMessage(r8, r10);
        return;
    }

    public static void writeMessageList(int r8, List<?> r10, Writer r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeMessageList(r8, r10);
        return;
    }

    public static void writeSFixed32(int r8, int r10, Writer r11) {
        if (r10 == 0) goto L5;
        r11.writeSFixed32(r8, r10);
        return;
    }

    public static void writeSFixed32List(int r8, List<Integer> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeSFixed32List(r8, r10, r12);
        return;
    }

    public static void writeSFixed64(int r8, long r10, Writer r11) {
        if (r10 == 0) goto L6;
        r11.writeSFixed64(r8, r10);
        return;
    }

    public static void writeSFixed64List(int r8, List<Long> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeSFixed64List(r8, r10, r12);
        return;
    }

    public static void writeSInt32(int r8, int r10, Writer r11) {
        if (r10 == 0) goto L5;
        r11.writeSInt32(r8, r10);
        return;
    }

    public static void writeSInt32List(int r8, List<Integer> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeSInt32List(r8, r10, r12);
        return;
    }

    public static void writeSInt64(int r8, long r10, Writer r11) {
        if (r10 == 0) goto L6;
        r11.writeSInt64(r8, r10);
        return;
    }

    public static void writeSInt64List(int r8, List<Long> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeSInt64List(r8, r10, r12);
        return;
    }

    public static void writeString(int r8, Object r10, Writer r11) {
        if ((r10 instanceof String) == false) goto L5;
        writeStringInternal(r8, (String) r10, r11);
        return;
    L5:
        writeBytes(r8, (ByteString) r10, r11);
    }

    private static void writeStringInternal(int r8, String r10, Writer r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeString(r8, r10);
        return;
    }

    public static void writeStringList(int r8, List<String> r10, Writer r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeStringList(r8, r10);
        return;
    }

    public static void writeUInt32(int r8, int r10, Writer r11) {
        if (r10 == 0) goto L5;
        r11.writeUInt32(r8, r10);
        return;
    }

    public static void writeUInt32List(int r8, List<Integer> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeUInt32List(r8, r10, r12);
        return;
    }

    public static void writeUInt64(int r8, long r10, Writer r11) {
        if (r10 == 0) goto L6;
        r11.writeUInt64(r8, r10);
        return;
    }

    public static void writeUInt64List(int r8, List<Long> r10, Writer r11, boolean r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeUInt64List(r8, r10, r12);
        return;
    }

    public static int computeSizeGroupList(int r8, List<MessageLite> r10, Schema<?> r11) {
        int r12 = r10.size();
        int r13 = 0;
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r14 = 0;
    L6:
        if (r13 >= r12) goto L8;
        r14 = r14 + computeGroupSize(r8, r10.get(r13), r11);
        r13 = r13 + 1;
        goto L6
    L8:
        return r14;
    }

    public static int computeSizeMessageList(int r8, List<?> r10, Schema<?> r11) {
        int r12 = r10.size();
        int r13 = 0;
        if (r12 != 0) goto L5;
        return 0;
    L5:
        int r14 = CodedOutputStream.computeTagSize(r8) * r12;
    L6:
        if (r13 >= r12) goto L12;
        Object r15 = r10.get(r13);
        if ((r15 instanceof LazyFieldLite) == false) goto L10;
        r14 = ((LazyFieldLite) r15).computeSizeNoTag() + r14;
    L11:
        r13 = r13 + 1;
        goto L6
    L10:
        r14 = r14 + computeMessageSizeNoTag((AbstractMessageLite) r15, r11);
        goto L11
    L12:
        return r14;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object r8, int r10, List<Integer> r11, Internal.EnumVerifier r12, UB r13, UnknownFieldSchema<UT, UB> r14) {
        if (r12 != null) goto L5;
        return r13;
    L5:
        if ((r11 instanceof RandomAccess) == false) goto L17;
        int r15 = r11.size();
        int r16 = 0;
        int r17 = 0;
    L7:
        if (r16 >= r15) goto L15;
        int r18 = r11.get(r16).intValue();
        if (r12.isInRange(r18) == false) goto L13;
        if (r16 == r17) goto L12;
        r11.set(r17, Integer.valueOf(r18));
    L12:
        r17 = r17 + 1;
    L14:
        r16 = r16 + 1;
        goto L7
    L13:
        r13 = (UB) storeUnknownEnum(r8, r10, r18, r13, r14);
        goto L14
    L15:
        if (r17 == r15) goto L23;
        r11.subList(r17, r15).clear();
    L23:
        return r13;
    L17:
        Iterator<Integer> r19 = r11.iterator();
    L19:
        if (r19.hasNext() == false) goto L23;
        int r20 = r19.next().intValue();
        if (r12.isInRange(r20) == true) goto L19;
        r13 = (UB) storeUnknownEnum(r8, r10, r20, r13, r14);
        r19.remove();
        goto L19
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] r8) {
        if (r8.length != 0) goto L6;
        return false;
    L6:
        return shouldUseTableSwitch(r8[0].getFieldNumber(), r8[r8.length - 1].getFieldNumber(), r8.length);
    }

    public static void writeGroupList(int r8, List<?> r10, Writer r11, Schema<?> r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeGroupList(r8, r10, r12);
        return;
    }

    public static void writeMessageList(int r8, List<?> r10, Writer r11, Schema<?> r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L8;
        r11.writeMessageList(r8, r10, r12);
        return;
    }
}
