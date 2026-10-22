package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
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

    static int computeSizeBoolList(int r2, List<?> r3, boolean r4) {
        int r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).size();
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r4 == false) goto L10;
        return CodedOutputStream.computeTagSize(r2) + CodedOutputStream.computeLengthDelimitedFieldSize(r5);
    L10:
        return r5 * CodedOutputStream.computeBoolSize(r2, true);
    }

    static int computeSizeBoolListNoTag(List<?> r2) {
        return ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size();
    }

    static int computeSizeByteStringList(int r4, List<ByteString> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r0 = r6.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r1 = r0 * CodedOutputStream.computeTagSize(r4);
    L7:
        if (r2 >= r6.size()) goto L9;
        r1 = r1 + CodedOutputStream.computeBytesSizeNoTag((ByteString) ZeusTransformUtils.preCheckCast(r6.get(r2), ByteString.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    static int computeSizeEnumList(int r2, List<Integer> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = computeSizeEnumListNoTag(r5);
        int r7 = CodedOutputStream.computeTagSize(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.computeLengthDelimitedFieldSize(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int computeSizeEnumListNoTag(List<Integer> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, IntArrayList.class) == false) goto L10;
        IntArrayList r8 = (IntArrayList) ZeusTransformUtils.preCheckCast(r7, IntArrayList.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.computeEnumSizeNoTag(r8.getInt(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.computeEnumSizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    static int computeSizeFixed32List(int r2, List<?> r3, boolean r4) {
        int r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).size();
        if (r5 != 0) goto L5;
        return 0;
    L5:
        if (r4 == false) goto L9;
        return CodedOutputStream.computeTagSize(r2) + CodedOutputStream.computeLengthDelimitedFieldSize(r5 * 4);
    L9:
        return r5 * CodedOutputStream.computeFixed32Size(r2, 0);
    }

    static int computeSizeFixed32ListNoTag(List<?> r2) {
        return ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size() * 4;
    }

    static int computeSizeFixed64List(int r2, List<?> r3, boolean r4) {
        int r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).size();
        if (r5 != 0) goto L6;
        return 0;
    L6:
        if (r4 == false) goto L10;
        return CodedOutputStream.computeTagSize(r2) + CodedOutputStream.computeLengthDelimitedFieldSize(r5 * 8);
    L10:
        return r5 * CodedOutputStream.computeFixed64Size(r2, 0);
    }

    static int computeSizeFixed64ListNoTag(List<?> r2) {
        return ((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin")).size() * 8;
    }

    static int computeSizeGroupList(int r6, List<MessageLite> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        int r0 = r8.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r3 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r3 = r3 + CodedOutputStream.computeGroupSize(r6, (MessageLite) ZeusTransformUtils.preCheckCast(r8.get(r2), MessageLite.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L6
    L8:
        return r3;
    }

    static int computeSizeGroupList(int r6, List<MessageLite> r7, Schema<?> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Schema r10 = (Schema) ZeusTransformUtils.wrapperContextForParams(r8, Schema.class, "com.obric.memorydata.plugin");
        int r0 = r9.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r3 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r3 = r3 + CodedOutputStream.computeGroupSize(r6, (MessageLite) ZeusTransformUtils.preCheckCast(r9.get(r2), MessageLite.class, "com.obric.memorydata.plugin"), r10);
        r2 = r2 + 1;
        goto L6
    L8:
        return r3;
    }

    static int computeSizeInt32List(int r2, List<Integer> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = computeSizeInt32ListNoTag(r5);
        int r7 = CodedOutputStream.computeTagSize(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.computeLengthDelimitedFieldSize(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int computeSizeInt32ListNoTag(List<Integer> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, IntArrayList.class) == false) goto L10;
        IntArrayList r8 = (IntArrayList) ZeusTransformUtils.preCheckCast(r7, IntArrayList.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.computeInt32SizeNoTag(r8.getInt(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    static int computeSizeInt64List(int r2, List<Long> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (r5.size() != 0) goto L6;
        return 0;
    L6:
        int r0 = computeSizeInt64ListNoTag(r5);
        if (r4 == false) goto L11;
        return CodedOutputStream.computeTagSize(r2) + CodedOutputStream.computeLengthDelimitedFieldSize(r0);
    L11:
        return r0 + (r5.size() * CodedOutputStream.computeTagSize(r2));
    }

    static int computeSizeInt64ListNoTag(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, LongArrayList.class) == false) goto L10;
        LongArrayList r8 = (LongArrayList) ZeusTransformUtils.preCheckCast(r7, LongArrayList.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.computeInt64SizeNoTag(r8.getLong(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.computeInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r7.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    static int computeSizeMessage(int r2, Object r3, Schema<?> r4) {
        Schema r5 = (Schema) ZeusTransformUtils.wrapperContextForParams(r4, Schema.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, LazyFieldLite.class) == false) goto L7;
        return CodedOutputStream.computeLazyFieldSize(r2, (LazyFieldLite) ZeusTransformUtils.preCheckCast(r3, LazyFieldLite.class, "com.obric.memorydata.plugin"));
    L7:
        return CodedOutputStream.computeMessageSize(r2, (MessageLite) ZeusTransformUtils.preCheckCast(r3, MessageLite.class, "com.obric.memorydata.plugin"), r5);
    }

    static int computeSizeMessageList(int r5, List<?> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r8 = CodedOutputStream.computeTagSize(r5) * r0;
    L6:
        if (r2 >= r0) goto L12;
        Object r3 = r7.get(r2);
        if (ZeusTransformUtils.instanceOf(r3, LazyFieldLite.class) == false) goto L10;
        int r4 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) ZeusTransformUtils.preCheckCast(r3, LazyFieldLite.class, "com.obric.memorydata.plugin"));
    L11:
        r8 = r8 + r4;
        r2 = r2 + 1;
        goto L6
    L10:
        r4 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) ZeusTransformUtils.preCheckCast(r3, MessageLite.class, "com.obric.memorydata.plugin"));
        goto L11
    L12:
        return r8;
    }

    static int computeSizeMessageList(int r5, List<?> r6, Schema<?> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Schema r9 = (Schema) ZeusTransformUtils.wrapperContextForParams(r7, Schema.class, "com.obric.memorydata.plugin");
        int r0 = r8.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r10 = CodedOutputStream.computeTagSize(r5) * r0;
    L6:
        if (r2 >= r0) goto L12;
        Object r3 = r8.get(r2);
        if (ZeusTransformUtils.instanceOf(r3, LazyFieldLite.class) == false) goto L10;
        int r4 = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) ZeusTransformUtils.preCheckCast(r3, LazyFieldLite.class, "com.obric.memorydata.plugin"));
    L11:
        r10 = r10 + r4;
        r2 = r2 + 1;
        goto L6
    L10:
        r4 = CodedOutputStream.computeMessageSizeNoTag((MessageLite) ZeusTransformUtils.preCheckCast(r3, MessageLite.class, "com.obric.memorydata.plugin"), r9);
        goto L11
    L12:
        return r10;
    }

    static int computeSizeSInt32List(int r2, List<Integer> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = computeSizeSInt32ListNoTag(r5);
        int r7 = CodedOutputStream.computeTagSize(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.computeLengthDelimitedFieldSize(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int computeSizeSInt32ListNoTag(List<Integer> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, IntArrayList.class) == false) goto L10;
        IntArrayList r8 = (IntArrayList) ZeusTransformUtils.preCheckCast(r7, IntArrayList.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.computeSInt32SizeNoTag(r8.getInt(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.computeSInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    static int computeSizeSInt64List(int r2, List<Long> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = computeSizeSInt64ListNoTag(r5);
        int r7 = CodedOutputStream.computeTagSize(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.computeLengthDelimitedFieldSize(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int computeSizeSInt64ListNoTag(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, LongArrayList.class) == false) goto L10;
        LongArrayList r8 = (LongArrayList) ZeusTransformUtils.preCheckCast(r7, LongArrayList.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.computeSInt64SizeNoTag(r8.getLong(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.computeSInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r7.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    static int computeSizeStringList(int r5, List<?> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r8 = CodedOutputStream.computeTagSize(r5) * r0;
        if (ZeusTransformUtils.instanceOf(r7, LazyStringList.class) == false) goto L14;
        LazyStringList r9 = (LazyStringList) ZeusTransformUtils.preCheckCast(r7, LazyStringList.class, "com.obric.memorydata.plugin");
    L8:
        if (r2 >= r0) goto L20;
        Object r3 = r9.getRaw(r2);
        if (ZeusTransformUtils.instanceOf(r3, ByteString.class) == false) goto L12;
        int r4 = CodedOutputStream.computeBytesSizeNoTag((ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"));
    L13:
        r8 = r8 + r4;
        r2 = r2 + 1;
        goto L8
    L12:
        r4 = CodedOutputStream.computeStringSizeNoTag((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    L20:
        return r8;
    L14:
        if (r2 >= r0) goto L20;
        Object r10 = r7.get(r2);
        if (ZeusTransformUtils.instanceOf(r10, ByteString.class) == false) goto L18;
        int r11 = CodedOutputStream.computeBytesSizeNoTag((ByteString) ZeusTransformUtils.preCheckCast(r10, ByteString.class, "com.obric.memorydata.plugin"));
    L19:
        r8 = r8 + r11;
        r2 = r2 + 1;
        goto L14
    L18:
        r11 = CodedOutputStream.computeStringSizeNoTag((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin"));
        goto L19
    }

    static int computeSizeUInt32List(int r2, List<Integer> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = computeSizeUInt32ListNoTag(r5);
        int r7 = CodedOutputStream.computeTagSize(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.computeLengthDelimitedFieldSize(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int computeSizeUInt32ListNoTag(List<Integer> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, IntArrayList.class) == false) goto L10;
        IntArrayList r8 = (IntArrayList) ZeusTransformUtils.preCheckCast(r7, IntArrayList.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.computeUInt32SizeNoTag(r8.getInt(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.computeUInt32SizeNoTag(((Integer) ZeusTransformUtils.preCheckCast(r7.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    static int computeSizeUInt64List(int r2, List<Long> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        if (r0 != 0) goto L6;
        return 0;
    L6:
        int r6 = computeSizeUInt64ListNoTag(r5);
        int r7 = CodedOutputStream.computeTagSize(r2);
        if (r4 == false) goto L11;
        return r7 + CodedOutputStream.computeLengthDelimitedFieldSize(r6);
    L11:
        return r6 + (r0 * r7);
    }

    static int computeSizeUInt64ListNoTag(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
        if (r0 != 0) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, LongArrayList.class) == false) goto L10;
        LongArrayList r8 = (LongArrayList) ZeusTransformUtils.preCheckCast(r7, LongArrayList.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L8:
        if (r2 >= r0) goto L17;
        r1 = r1 + CodedOutputStream.computeUInt64SizeNoTag(r8.getLong(r2));
        r2 = r2 + 1;
        goto L8
    L17:
        return r1;
    L10:
        int r3 = 0;
    L11:
        if (r2 >= r0) goto L14;
        r3 = r3 + CodedOutputStream.computeUInt64SizeNoTag(((Long) ZeusTransformUtils.preCheckCast(r7.get(r2), Long.class, "com.obric.memorydata.plugin")).longValue());
        r2 = r2 + 1;
        goto L11
    L14:
        return r3;
    }

    static <UT, UB> UB filterUnknownEnumList(Object r6, int r7, List<Integer> r8, Internal.EnumLiteMap<?> r9, UB r10, UnknownFieldSchema<UT, UB> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Internal.EnumLiteMap r13 = (Internal.EnumLiteMap) ZeusTransformUtils.wrapperContextForParams(r9, Internal.EnumLiteMap.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L6;
        return r10;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, RandomAccess.class) == false) goto L18;
        int r0 = r12.size();
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r2 >= r0) goto L16;
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r12.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.findValueByNumber(r4) == null) goto L14;
        if (r2 == r3) goto L13;
        r12.set(r3, Integer.valueOf(r4));
    L13:
        r3 = r3 + 1;
    L15:
        r2 = r2 + 1;
        goto L8
    L14:
        r10 = (UB) storeUnknownEnum(r6, r7, r4, r10, r11);
        goto L15
    L16:
        if (r3 == r0) goto L24;
        r12.subList(r3, r0).clear();
    L24:
        return r10;
    L18:
        Iterator r14 = r12.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r14.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.findValueByNumber(r1) != null) goto L20;
        r10 = (UB) storeUnknownEnum(r6, r7, r1, r10, r11);
        r14.remove();
        goto L20
    }

    static <UT, UB> UB filterUnknownEnumList(Object r6, int r7, List<Integer> r8, Internal.EnumVerifier r9, UB r10, UnknownFieldSchema<UT, UB> r11) {
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Internal.EnumVerifier r13 = (Internal.EnumVerifier) ZeusTransformUtils.wrapperContextForParams(r9, Internal.EnumVerifier.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L6;
        return r10;
    L6:
        if (ZeusTransformUtils.instanceOf(r12, RandomAccess.class) == false) goto L18;
        int r0 = r12.size();
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r2 >= r0) goto L16;
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r12.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.isInRange(r4) == false) goto L14;
        if (r2 == r3) goto L13;
        r12.set(r3, Integer.valueOf(r4));
    L13:
        r3 = r3 + 1;
    L15:
        r2 = r2 + 1;
        goto L8
    L14:
        r10 = (UB) storeUnknownEnum(r6, r7, r4, r10, r11);
        goto L15
    L16:
        if (r3 == r0) goto L24;
        r12.subList(r3, r0).clear();
    L24:
        return r10;
    L18:
        Iterator r14 = r12.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r14.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        if (r13.isInRange(r1) == true) goto L20;
        r10 = (UB) storeUnknownEnum(r6, r7, r1, r10, r11);
        r14.remove();
        goto L20
    }

    private static Class<?> getGeneratedMessageClass() {
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        return ZeusTransformUtils.forName("com.google.protobuf.GeneratedMessage", "com.obric.memorydata.plugin");
    L7:
        return null;
    }

    static Object getMapDefaultEntry(Class<?> r3, String r4) {
        java.lang.reflect.Field[] r0 = ZeusTransformUtils.forName(r3.getName() + "$" + toCamelCase(r4, true) + "DefaultEntryHolder", "com.obric.memorydata.plugin").getDeclaredFields();     // Catch: Throwable -> L8
        if (r0.length != 1) goto L7;
        return UnsafeUtil.getStaticObject(r0[0]);
    L7:
        throw new IllegalStateException("Unable to look up map field default entry holder class for " + r4 + " in " + r3.getName());     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw new RuntimeException(th);
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        Class<?> r1 = getUnknownFieldSetSchemaClass();     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        return null;
    L6:
        return (UnknownFieldSchema) ZeusTransformUtils.preCheckCast(r1.getConstructor(new Class[0]).newInstance(new Object[0]), UnknownFieldSchema.class, "com.obric.memorydata.plugin");
    L8:
        return null;
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        if (Protobuf.assumeLiteRuntime == false) goto L8;
        return null;
    L8:
        return ZeusTransformUtils.forName("com.google.protobuf.UnknownFieldSetSchema", "com.obric.memorydata.plugin");
    L7:
        return null;
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> r1, T r2, T r3) {
        FieldSet<T> r4 = r1.getExtensions(r3);
        if (r4.isEmpty() == true) goto L6;
        r1.getMutableExtensions(r2).mergeFrom(r4);
        return;
    }

    static <T> void mergeMap(MapFieldSchema r2, T r3, T r4, long r5) {
        UnsafeUtil.putObject(r3, r5, ((MapFieldSchema) ZeusTransformUtils.wrapperContextForParams(r2, MapFieldSchema.class, "com.obric.memorydata.plugin")).mergeFrom(UnsafeUtil.getObject(r3, r5), UnsafeUtil.getObject(r4, r5)));
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> r1, T r2, T r3) {
        r1.setToMessage(r2, r1.merge(r1.getFromMessage(r2), r1.getFromMessage(r3)));
    }

    public static void requireGeneratedMessage(Class<?> r1) {
        if (GeneratedMessageLite.class.isAssignableFrom(r1) == false) goto L5;
        return;
    L5:
        if (Protobuf.assumeLiteRuntime == true) goto L14;
        Class<?> r0 = GENERATED_MESSAGE_CLASS;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.isAssignableFrom(r1) == false) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    static boolean safeEquals(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static boolean shouldUseTableSwitch(int r9, int r10, int r11) {
        if (r10 >= 40) goto L5;
        return true;
    L5:
        long r3 = r11;
        if ((((((long) r10) - ((long) r9)) + 1) + 9) <= (((2 * r3) + 3) + ((r3 + 3) * 3))) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] r2) {
        if (r2.length != 0) goto L6;
        return false;
    L6:
        return shouldUseTableSwitch(r2[0].getFieldNumber(), r2[r2.length - 1].getFieldNumber(), r2.length);
    }

    static <UT, UB> UB storeUnknownEnum(Object r2, int r3, int r4, UB r5, UnknownFieldSchema<UT, UB> r6) {
        if (r5 != null) goto L4;
        r5 = r6.getBuilderFromMessage(r2);
    L4:
        r6.addVarint(r5, r3, r4);
        return r5;
    }

    static String toCamelCase(String r6, boolean r7) {
        StringBuilder r0 = new StringBuilder();
        int r2 = 0;
    L4:
        if (r2 >= r6.length()) goto L29;
        char r3 = r6.charAt(r2);
        if ('a' > r3) goto L15;
        if (r3 > 'z') goto L15;
        if (r7 == false) goto L12;
        int r4 = r3 - ' ';
    L11:
        r0.append((char) r4);
    L13:
        r7 = false;
    L27:
        r2 = r2 + 1;
    L12:
        r0.append(r3);
    L15:
        if ('A' > r3) goto L22;
        if (r3 > 'Z') goto L22;
        if (r2 != 0) goto L12;
        if (r7 == true) goto L12;
        r4 = r3 + ' ';
    L22:
        if ('0' <= r3) goto L24;
    L26:
        r7 = true;
        goto L27
    L24:
        if (r3 > '9') goto L26;
        r0.append(r3);
        goto L26
    L29:
        return r0.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int r2, boolean r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == false) goto L6;
        r5.writeBool(r2, true);
        return;
    }

    public static void writeBoolList(int r2, List<Boolean> r3, Writer r4, boolean r5) {
        List<Boolean> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeBoolList(r2, r6, r5);
        return;
    }

    public static void writeBytes(int r2, ByteString r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L9;
        r5.writeBytes(r2, r3);
        return;
    }

    public static void writeBytesList(int r2, List<ByteString> r3, Writer r4) {
        List<ByteString> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L9;
        r6.writeBytesList(r2, r5);
        return;
    }

    public static void writeDouble(int r4, double r5, Writer r7) {
        Writer r8 = (Writer) ZeusTransformUtils.wrapperContextForParams(r7, Writer.class, "com.obric.memorydata.plugin");
        if (Double.doubleToRawLongBits(r5) == 0) goto L6;
        r8.writeDouble(r4, r5);
        return;
    }

    public static void writeDoubleList(int r2, List<Double> r3, Writer r4, boolean r5) {
        List<Double> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeDoubleList(r2, r6, r5);
        return;
    }

    public static void writeEnum(int r2, int r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r5.writeEnum(r2, r3);
        return;
    }

    public static void writeEnumList(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeEnumList(r2, r6, r5);
        return;
    }

    public static void writeFixed32(int r2, int r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r5.writeFixed32(r2, r3);
        return;
    }

    public static void writeFixed32List(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeFixed32List(r2, r6, r5);
        return;
    }

    public static void writeFixed64(int r2, long r3, Writer r5) {
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r6.writeFixed64(r2, r3);
        return;
    }

    public static void writeFixed64List(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeFixed64List(r2, r6, r5);
        return;
    }

    public static void writeFloat(int r2, float r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (Float.floatToRawIntBits(r3) == 0) goto L6;
        r5.writeFloat(r2, r3);
        return;
    }

    public static void writeFloatList(int r2, List<Float> r3, Writer r4, boolean r5) {
        List<Float> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeFloatList(r2, r6, r5);
        return;
    }

    public static void writeGroupList(int r2, List<?> r3, Writer r4) {
        List<?> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L9;
        r6.writeGroupList(r2, r5);
        return;
    }

    public static void writeGroupList(int r2, List<?> r3, Writer r4, Schema<?> r5) {
        List<?> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        Schema r8 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeGroupList(r2, r6, r8);
        return;
    }

    public static void writeInt32(int r2, int r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r5.writeInt32(r2, r3);
        return;
    }

    public static void writeInt32List(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeInt32List(r2, r6, r5);
        return;
    }

    public static void writeInt64(int r2, long r3, Writer r5) {
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r6.writeInt64(r2, r3);
        return;
    }

    public static void writeInt64List(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeInt64List(r2, r6, r5);
        return;
    }

    public static void writeLazyFieldList(int r3, List<?> r4, Writer r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L12;
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        ((LazyFieldLite) ZeusTransformUtils.preCheckCast(r8.next(), LazyFieldLite.class, "com.obric.memorydata.plugin")).writeTo(r7, r3);
        goto L8
    L13:
        return;
    }

    public static void writeMessage(int r2, Object r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L6;
        r5.writeMessage(r2, r3);
        return;
    }

    public static void writeMessageList(int r2, List<?> r3, Writer r4) {
        List<?> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L9;
        r6.writeMessageList(r2, r5);
        return;
    }

    public static void writeMessageList(int r2, List<?> r3, Writer r4, Schema<?> r5) {
        List<?> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        Schema r8 = (Schema) ZeusTransformUtils.wrapperContextForParams(r5, Schema.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeMessageList(r2, r6, r8);
        return;
    }

    public static void writeSFixed32(int r2, int r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r5.writeSFixed32(r2, r3);
        return;
    }

    public static void writeSFixed32List(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeSFixed32List(r2, r6, r5);
        return;
    }

    public static void writeSFixed64(int r2, long r3, Writer r5) {
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r6.writeSFixed64(r2, r3);
        return;
    }

    public static void writeSFixed64List(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeSFixed64List(r2, r6, r5);
        return;
    }

    public static void writeSInt32(int r2, int r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r5.writeSInt32(r2, r3);
        return;
    }

    public static void writeSInt32List(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeSInt32List(r2, r6, r5);
        return;
    }

    public static void writeSInt64(int r2, long r3, Writer r5) {
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r6.writeSInt64(r2, r3);
        return;
    }

    public static void writeSInt64List(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeSInt64List(r2, r6, r5);
        return;
    }

    public static void writeString(int r2, Object r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L5;
        writeStringInternal(r2, (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"), r5);
        return;
    L5:
        writeBytes(r2, (ByteString) ZeusTransformUtils.preCheckCast(r3, ByteString.class, "com.obric.memorydata.plugin"), r5);
    }

    private static void writeStringInternal(int r2, String r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L9;
        r5.writeString(r2, r3);
        return;
    }

    public static void writeStringList(int r2, List<String> r3, Writer r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L9;
        r6.writeStringList(r2, r5);
        return;
    }

    public static void writeUInt32(int r2, int r3, Writer r4) {
        Writer r5 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r5.writeUInt32(r2, r3);
        return;
    }

    public static void writeUInt32List(int r2, List<Integer> r3, Writer r4, boolean r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeUInt32List(r2, r6, r5);
        return;
    }

    public static void writeUInt64(int r2, long r3, Writer r5) {
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        if (r3 == 0) goto L6;
        r6.writeUInt64(r2, r3);
        return;
    }

    public static void writeUInt64List(int r2, List<Long> r3, Writer r4, boolean r5) {
        List<Long> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.isEmpty() == true) goto L9;
        r7.writeUInt64List(r2, r6, r5);
        return;
    }
}
