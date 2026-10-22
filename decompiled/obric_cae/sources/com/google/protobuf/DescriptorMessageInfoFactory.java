package com.google.protobuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
final class DescriptorMessageInfoFactory implements MessageInfoFactory {
    private static final String GET_DEFAULT_INSTANCE_METHOD_NAME = "getDefaultInstance";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5185a = 0;
    private static final DescriptorMessageInfoFactory instance = null;
    private static IsInitializedCheckAnalyzer isInitializedCheckAnalyzer;
    private static final Set<String> specialFieldNames = null;

    /* JADX INFO: renamed from: com.google.protobuf.DescriptorMessageInfoFactory$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$DescriptorProtos$Edition = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = null;

        static {
            int[] r8 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r8;
            r8[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
        L90:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L44
        L106:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L45
        L114:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L46
        L118:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 5;     // Catch: NoSuchFieldError -> L47
        L74:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L48
        L80:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L49
        L98:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 8;     // Catch: NoSuchFieldError -> L50
        L100:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 9;     // Catch: NoSuchFieldError -> L51
        L120:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 10;     // Catch: NoSuchFieldError -> L52
        L124:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;     // Catch: NoSuchFieldError -> L53
        L82:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 12;     // Catch: NoSuchFieldError -> L54
        L88:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L55
        L104:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 14;     // Catch: NoSuchFieldError -> L56
        L110:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 15;     // Catch: NoSuchFieldError -> L57
        L128:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L58
        L72:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 17;     // Catch: NoSuchFieldError -> L59
        L92:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 18;     // Catch: NoSuchFieldError -> L60
        L29:
            int[] r10 = new int[JavaType.values().length];
            $SwitchMap$com$google$protobuf$JavaType = r10;
            r10[JavaType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L61
        L112:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.BYTE_STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L62
        L116:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.DOUBLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L63
        L126:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L64
        L84:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.ENUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L65
        L94:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.INT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L66
        L96:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.LONG.ordinal()] = 7;     // Catch: NoSuchFieldError -> L67
        L102:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.STRING.ordinal()] = 8;     // Catch: NoSuchFieldError -> L68
        L122:
            $SwitchMap$com$google$protobuf$JavaType[JavaType.MESSAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L69
        L39:
            int[] r11 = new int[DescriptorProtos.Edition.values().length];
            $SwitchMap$com$google$protobuf$DescriptorProtos$Edition = r11;
            r11[DescriptorProtos.Edition.EDITION_PROTO2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L70
        L78:
            $SwitchMap$com$google$protobuf$DescriptorProtos$Edition[DescriptorProtos.Edition.EDITION_PROTO3.ordinal()] = 2;     // Catch: NoSuchFieldError -> L71
            return;
        }
    }

    public static class IsInitializedCheckAnalyzer {
        private int index;
        private final Map<Descriptors.Descriptor, Node> nodeCache;
        private final Map<Descriptors.Descriptor, Boolean> resultCache;
        private final Stack<Node> stack;

        public static class Node {
            StronglyConnectedComponent component;
            final Descriptors.Descriptor descriptor;
            final int index;
            int lowLink;

            public Node(Descriptors.Descriptor r8, int r10) {
                this.descriptor = r8;
                this.index = r10;
                this.lowLink = r10;
                this.component = null;
            }
        }

        public static class StronglyConnectedComponent {
            final List<Descriptors.Descriptor> messages;
            boolean needsIsInitializedCheck;

            private StronglyConnectedComponent() {
                this.messages = new ArrayList();
                this.needsIsInitializedCheck = false;
            }

            public /* synthetic */ StronglyConnectedComponent(AnonymousClass1 r8) {
                this();
            }
        }

        public IsInitializedCheckAnalyzer() {
            this.resultCache = new ConcurrentHashMap();
            this.index = 0;
            this.stack = new Stack();
            this.nodeCache = new HashMap();
        }

        private void analyze(StronglyConnectedComponent r8) {
            Iterator<Descriptors.Descriptor> r10 = r8.messages.iterator();
        L4:
            if (r10.hasNext() == false) goto L21;
            Descriptors.Descriptor r11 = r10.next();
            boolean r12 = true;
            if (r11.isExtendable() == true) goto L22;
            Iterator<Descriptors.FieldDescriptor> r13 = r11.getFields().iterator();
        L10:
            if (r13.hasNext() == false) goto L4;
            Descriptors.FieldDescriptor r14 = r13.next();
            if (r14.isRequired() == true) goto L22;
            if (r14.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L10;
            StronglyConnectedComponent r15 = this.nodeCache.get(r14.getMessageType()).component;
            if (r15 == r8) goto L10;
            if (r15.needsIsInitializedCheck == false) goto L10;
        L22:
            r8.needsIsInitializedCheck = r12;
            Iterator<Descriptors.Descriptor> r16 = r8.messages.iterator();
        L24:
            if (r16.hasNext() == false) goto L26;
            Descriptors.Descriptor r17 = r16.next();
            this.resultCache.put(r17, Boolean.valueOf(r8.needsIsInitializedCheck));
            goto L24
        L26:
            return;
        L21:
            r12 = false;
            goto L22
        }

        private Node dfs(Descriptors.Descriptor r8) {
            int r10 = this.index;
            this.index = r10 + 1;
            Node r11 = new Node(r8, r10);
            this.stack.push(r11);
            this.nodeCache.put(r8, r11);
            Iterator<Descriptors.FieldDescriptor> r12 = r8.getFields().iterator();
        L4:
            if (r12.hasNext() == false) goto L15;
            Descriptors.FieldDescriptor r13 = r12.next();
            if (r13.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
            Node r14 = this.nodeCache.get(r13.getMessageType());
            if (r14 == null) goto L9;
            if (r14.component != null) goto L4;
            int r15 = Math.min(r11.lowLink, r14.lowLink);
        L10:
            r11.lowLink = r15;
            goto L4
        L9:
            Node r16 = dfs(r13.getMessageType());
            r15 = Math.min(r11.lowLink, r16.lowLink);
            goto L10
        L15:
            if (r11.index != r11.lowLink) goto L20;
            StronglyConnectedComponent r17 = new StronglyConnectedComponent(null);
        L17:
            Node r18 = this.stack.pop();
            r18.component = r17;
            r17.messages.add(r18.descriptor);
            if (r18 != r11) goto L17;
            analyze(r17);
        L20:
            return r11;
        }

        public boolean needsIsInitializedCheck(Descriptors.Descriptor r8) {
            Boolean r10 = this.resultCache.get(r8);
            if (r10 != null) goto L5;
            monitor-enter(this);
            Boolean r11 = this.resultCache.get(r8);     // Catch: Throwable -> L15
            if (r11 == null) goto L12;
            boolean r12 = r11.booleanValue();     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return r12;
        L12:
            boolean r13 = dfs(r8).component.needsIsInitializedCheck;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return r13;
        L15:
            th = move-exception;
            throw th;
        L5:
            return r10.booleanValue();
        }
    }

    public static final class OneofState {
        private OneofInfo[] oneofs;

        private OneofState() {
            this.oneofs = new OneofInfo[2];
        }

        private static OneofInfo newInfo(Class<?> r8, Descriptors.OneofDescriptor r10) {
            String r11 = DescriptorMessageInfoFactory.access$200(r10.getName());
            String r12 = defpackage.a.e(r11, "_");
            String r13 = defpackage.a.e(r11, "Case_");
            return new OneofInfo(r10.getIndex(), DescriptorMessageInfoFactory.access$300(r8, r13), DescriptorMessageInfoFactory.access$300(r8, r12));
        }

        public OneofInfo getOneof(Class<?> r8, Descriptors.OneofDescriptor r10) {
            int r11 = r10.getIndex();
            OneofInfo[] r12 = this.oneofs;
            if (r11 < r12.length) goto L5;
            this.oneofs = (OneofInfo[]) Arrays.copyOf(r12, r11 * 2);
        L5:
            OneofInfo r13 = this.oneofs[r11];
            if (r13 != null) goto L9;
            OneofInfo r14 = newInfo(r8, r10);
            this.oneofs[r11] = r14;
            return r14;
        L9:
            return r13;
        }

        public /* synthetic */ OneofState(AnonymousClass1 r8) {
            this();
        }
    }

    static {
        instance = new DescriptorMessageInfoFactory();
        specialFieldNames = new HashSet(Arrays.asList(new String[]{"Class", "DefaultInstanceForType", "ParserForType", "SerializedSize", "AllFields", "DescriptorForType", "InitializationErrorString", "UnknownFields", "CachedSize"}));
        isInitializedCheckAnalyzer = new IsInitializedCheckAnalyzer();
    }

    private DescriptorMessageInfoFactory() {
    }

    public static /* synthetic */ String access$200(String r8) {
        return snakeCaseToLowerCamelCase(r8);
    }

    public static /* synthetic */ java.lang.reflect.Field access$300(Class r8, String r10) {
        return field(r8, r10);
    }

    private static java.lang.reflect.Field bitField(Class<?> r8, int r10) {
        return field(r8, android.aimedia.a.c("bitField", r10, "_"));
    }

    private static FieldInfo buildOneofMember(Class<?> r8, Descriptors.FieldDescriptor r10, OneofState r11, boolean r12, Internal.EnumVerifier r13) {
        OneofInfo r14 = r11.getOneof(r8, r10.getContainingOneof());
        FieldType r15 = getFieldType(r10);
        Class<?> r16 = getOneofStoredType(r8, r10, r15);
        return FieldInfo.forOneofMemberField(r10.getNumber(), r15, r14, r16, r12, r13);
    }

    private static java.lang.reflect.Field cachedSizeField(Class<?> r8, Descriptors.FieldDescriptor r10) {
        return field(r8, getCachedSizeFieldName(r10));
    }

    private static MessageInfo convert(Class<?> r18, Descriptors.Descriptor r19) {
        List<Descriptors.FieldDescriptor> r8 = r19.getFields();
        StructuralMessageInfo.Builder r10 = StructuralMessageInfo.newBuilder(r8.size());
        r10.withDefaultInstance(getDefaultInstance(r18));
        r10.withSyntax(convertSyntax(r19.getFile().getEdition()));
        r10.withMessageSetWireFormat(r19.getOptions().getMessageSetWireFormat());
        AnonymousClass1 r11 = null;
        OneofState r12 = new OneofState(r11);
        java.lang.reflect.Field r13 = null;
        int r17 = 1;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r8.size()) goto L49;
        final Descriptors.FieldDescriptor r16 = r8.get(r14);
        boolean r110 = r16.needsUtf8Check();
        Descriptors.FieldDescriptor.JavaType r111 = r16.getJavaType();
        Descriptors.FieldDescriptor.JavaType r112 = Descriptors.FieldDescriptor.JavaType.ENUM;
        if (r111 == r112) goto L8;
    L10:
        Internal.EnumVerifier r113 = r11;
    L12:
        if (r16.getRealContainingOneof() == null) goto L14;
        r10.withField(buildOneofMember(r18, r16, r12, r110, r113));
    L48:
        r14 = r14 + 1;
        r11 = null;
        goto L4
    L14:
        java.lang.reflect.Field r114 = field(r18, r16);
        int r115 = r16.getNumber();
        FieldType r20 = getFieldType(r16);
        if (r16.hasPresence() == false) goto L17;
        if (r13 != null) goto L42;
        r13 = bitField(r18, r15);
    L42:
        if (r16.isRequired() == false) goto L44;
        FieldInfo r21 = FieldInfo.forLegacyRequiredField(r114, r115, r20, r13, r17, r110, r113);
    L45:
        r10.withField(r21);
        r17 = r17 << 1;
        if (r17 != 0) goto L48;
        r15 = r15 + 1;
        r17 = 1;
        r13 = null;
        goto L48
    L44:
        r21 = FieldInfo.forExplicitPresenceField(r114, r115, r20, r13, r17, r110, r113);
        goto L45
    L17:
        if (r16.isMapField() == false) goto L25;
        final Descriptors.FieldDescriptor r22 = r16.getMessageType().findFieldByNumber(2);
        if (r22.getJavaType() == r112) goto L21;
    L23:
        FieldInfo r23 = FieldInfo.forMapField(r114, r115, SchemaUtil.getMapDefaultEntry(r18, r16.getName()), r113);
    L38:
        r10.withField(r23);
        goto L48
    L21:
        if (r22.legacyEnumFieldTreatedAsClosed() == false) goto L23;
        r113 = new AnonymousClass2(r22);
        goto L23
    L25:
        if (r16.isRepeated() == false) goto L30;
        if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L30;
        r23 = FieldInfo.forRepeatedMessageField(r114, r115, r20, getTypeForRepeatedMessageField(r18, r16));
    L30:
        if (r16.isPacked() == false) goto L35;
        java.lang.reflect.Field r24 = cachedSizeField(r18, r16);
        if (r113 == null) goto L34;
        r23 = FieldInfo.forPackedFieldWithEnumVerifier(r114, r115, r20, r113, r24);
        goto L38
    L34:
        r23 = FieldInfo.forPackedField(r114, r115, r20, r24);
        goto L38
    L35:
        if (r113 == null) goto L37;
        r23 = FieldInfo.forFieldWithEnumVerifier(r114, r115, r20, r113);
        goto L38
    L37:
        r23 = FieldInfo.forField(r114, r115, r20, r110);
        goto L38
    L8:
        if (r16.legacyEnumFieldTreatedAsClosed() == false) goto L10;
        r113 = new AnonymousClass1(r16);
        goto L12
    L49:
        ArrayList r25 = new ArrayList();
        int r26 = 0;
    L51:
        if (r26 >= r8.size()) goto L60;
        Descriptors.FieldDescriptor r27 = r8.get(r26);
        if (r27.isRequired() == false) goto L55;
    L58:
        r25.add(Integer.valueOf(r27.getNumber()));
    L59:
        r26 = r26 + 1;
        goto L51
    L55:
        if (r27.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L59;
        if (needsIsInitializedCheck(r27.getMessageType()) == false) goto L59;
    L60:
        int r28 = r25.size();
        int[] r29 = new int[r28];
        int r30 = 0;
    L62:
        if (r30 >= r25.size()) goto L64;
        r29[r30] = ((Integer) r25.get(r30)).intValue();
        r30 = r30 + 1;
        goto L62
    L64:
        if (r28 <= 0) goto L67;
        r10.withCheckInitialized(r29);
    L67:
        return r10.build();
    }

    private static ProtoSyntax convertSyntax(DescriptorProtos.Edition r8) {
        int r10 = AnonymousClass3.$SwitchMap$com$google$protobuf$DescriptorProtos$Edition[r8.ordinal()];
        if (r10 == 1) goto L11;
        if (r10 == 2) goto L9;
        return ProtoSyntax.EDITIONS;
    L9:
        return ProtoSyntax.PROTO3;
    L11:
        return ProtoSyntax.PROTO2;
    }

    private static Descriptors.Descriptor descriptorForType(Class<?> r8) {
        return getDefaultInstance(r8).getDescriptorForType();
    }

    private static java.lang.reflect.Field field(Class<?> r8, Descriptors.FieldDescriptor r10) {
        return field(r8, getFieldName(r10));
    }

    private static String getCachedSizeFieldName(Descriptors.FieldDescriptor r8) {
        return android.aimedia.a.i(new StringBuilder(), snakeCaseToLowerCamelCase(r8.getName()), "MemoizedSerializedSize");
    }

    private static Message getDefaultInstance(Class<?> r8) {
        return (Message) r8.getDeclaredMethod(GET_DEFAULT_INSTANCE_METHOD_NAME, new Class[0]).invoke(null, new Object[0]);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Unable to get default instance for message class ".concat(r8.getName()), e);
    }

    public static String getFieldName(Descriptors.FieldDescriptor r8) {
        if (r8.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r10 = r8.getMessageType().getName();
    L6:
        String r11 = snakeCaseToUpperCamelCase(r10);
        if (specialFieldNames.contains(r11) == false) goto L9;
        String r12 = "__";
    L11:
        return android.aimedia.a.i(new StringBuilder(), snakeCaseToLowerCamelCase(r10), r12);
    L9:
        r12 = "_";
        goto L11
    L5:
        r10 = r8.getName();
        goto L6
    }

    private static FieldType getFieldType(Descriptors.FieldDescriptor r8) {
        switch(AnonymousClass3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r8.getType().ordinal()]) {
            case 1: goto L148;
            case 2: goto L143;
            case 3: goto L134;
            case 4: goto L125;
            case 5: goto L116;
            case 6: goto L107;
            case 7: goto L98;
            case 8: goto L93;
            case 9: goto L84;
            case 10: goto L75;
            case 11: goto L66;
            case 12: goto L57;
            case 13: goto L48;
            case 14: goto L39;
            case 15: goto L30;
            case 16: goto L25;
            case 17: goto L16;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalArgumentException("Unsupported field type: " + r8.getType());
    L7:
        if (r8.isRepeated() == true) goto L11;
        return FieldType.UINT64;
    L11:
        if (r8.isPacked() == false) goto L14;
        return FieldType.UINT64_LIST_PACKED;
    L14:
        return FieldType.UINT64_LIST;
    L16:
        if (r8.isRepeated() == true) goto L20;
        return FieldType.UINT32;
    L20:
        if (r8.isPacked() == false) goto L23;
        return FieldType.UINT32_LIST_PACKED;
    L23:
        return FieldType.UINT32_LIST;
    L25:
        if (r8.isRepeated() == false) goto L28;
        return FieldType.STRING_LIST;
    L28:
        return FieldType.STRING;
    L30:
        if (r8.isRepeated() == true) goto L34;
        return FieldType.SINT64;
    L34:
        if (r8.isPacked() == false) goto L37;
        return FieldType.SINT64_LIST_PACKED;
    L37:
        return FieldType.SINT64_LIST;
    L39:
        if (r8.isRepeated() == true) goto L43;
        return FieldType.SINT32;
    L43:
        if (r8.isPacked() == false) goto L46;
        return FieldType.SINT32_LIST_PACKED;
    L46:
        return FieldType.SINT32_LIST;
    L48:
        if (r8.isRepeated() == true) goto L52;
        return FieldType.SFIXED64;
    L52:
        if (r8.isPacked() == false) goto L55;
        return FieldType.SFIXED64_LIST_PACKED;
    L55:
        return FieldType.SFIXED64_LIST;
    L57:
        if (r8.isRepeated() == true) goto L61;
        return FieldType.SFIXED32;
    L61:
        if (r8.isPacked() == false) goto L64;
        return FieldType.SFIXED32_LIST_PACKED;
    L64:
        return FieldType.SFIXED32_LIST;
    L66:
        if (r8.isMapField() == false) goto L70;
        return FieldType.MAP;
    L70:
        if (r8.isRepeated() == false) goto L73;
        return FieldType.MESSAGE_LIST;
    L73:
        return FieldType.MESSAGE;
    L75:
        if (r8.isRepeated() == true) goto L79;
        return FieldType.INT64;
    L79:
        if (r8.isPacked() == false) goto L82;
        return FieldType.INT64_LIST_PACKED;
    L82:
        return FieldType.INT64_LIST;
    L84:
        if (r8.isRepeated() == true) goto L88;
        return FieldType.INT32;
    L88:
        if (r8.isPacked() == false) goto L91;
        return FieldType.INT32_LIST_PACKED;
    L91:
        return FieldType.INT32_LIST;
    L93:
        if (r8.isRepeated() == false) goto L96;
        return FieldType.GROUP_LIST;
    L96:
        return FieldType.GROUP;
    L98:
        if (r8.isRepeated() == true) goto L102;
        return FieldType.FLOAT;
    L102:
        if (r8.isPacked() == false) goto L105;
        return FieldType.FLOAT_LIST_PACKED;
    L105:
        return FieldType.FLOAT_LIST;
    L107:
        if (r8.isRepeated() == true) goto L111;
        return FieldType.FIXED64;
    L111:
        if (r8.isPacked() == false) goto L114;
        return FieldType.FIXED64_LIST_PACKED;
    L114:
        return FieldType.FIXED64_LIST;
    L116:
        if (r8.isRepeated() == true) goto L120;
        return FieldType.FIXED32;
    L120:
        if (r8.isPacked() == false) goto L123;
        return FieldType.FIXED32_LIST_PACKED;
    L123:
        return FieldType.FIXED32_LIST;
    L125:
        if (r8.isRepeated() == true) goto L129;
        return FieldType.ENUM;
    L129:
        if (r8.isPacked() == false) goto L132;
        return FieldType.ENUM_LIST_PACKED;
    L132:
        return FieldType.ENUM_LIST;
    L134:
        if (r8.isRepeated() == true) goto L138;
        return FieldType.DOUBLE;
    L138:
        if (r8.isPacked() == false) goto L141;
        return FieldType.DOUBLE_LIST_PACKED;
    L141:
        return FieldType.DOUBLE_LIST;
    L143:
        if (r8.isRepeated() == false) goto L146;
        return FieldType.BYTES_LIST;
    L146:
        return FieldType.BYTES;
    L148:
        if (r8.isRepeated() == true) goto L152;
        return FieldType.BOOL;
    L152:
        if (r8.isPacked() == false) goto L155;
        return FieldType.BOOL_LIST_PACKED;
    L155:
        return FieldType.BOOL_LIST;
    }

    public static DescriptorMessageInfoFactory getInstance() {
        return instance;
    }

    private static Class<?> getOneofStoredType(Class<?> r8, Descriptors.FieldDescriptor r10, FieldType r11) {
        switch(AnonymousClass3.$SwitchMap$com$google$protobuf$JavaType[r11.getJavaType().ordinal()]) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L5;
        };
    L8:
        return String.class;
    L10:
        return Long.class;
    L12:
        return Integer.class;
    L14:
        return Float.class;
    L16:
        return Double.class;
    L18:
        return ByteString.class;
    L20:
        return Boolean.class;
    L5:
        throw new IllegalArgumentException("Invalid type for oneof: " + r11);
    L7:
        return getOneofStoredTypeForMessage(r8, r10);
    }

    private static Class<?> getOneofStoredTypeForMessage(Class<?> r8, Descriptors.FieldDescriptor r10) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (r10.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r11 = r10.getMessageType().getName();     // Catch: Exception -> L8
    L6:
        return r8.getDeclaredMethod(getterForField(r11), new Class[0]).getReturnType();
    L5:
        r11 = r10.getName();     // Catch: Exception -> L8
        goto L6
    }

    private static Class<?> getTypeForRepeatedMessageField(Class<?> r8, Descriptors.FieldDescriptor r10) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (r10.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r11 = r10.getMessageType().getName();     // Catch: Exception -> L8
    L6:
        return r8.getDeclaredMethod(getterForField(r11), new Class[]{Integer.TYPE}).getReturnType();
    L5:
        r11 = r10.getName();     // Catch: Exception -> L8
        goto L6
    }

    private static String getterForField(String r8) {
        String r10 = snakeCaseToLowerCamelCase(r8);
        return "get" + Character.toUpperCase(r10.charAt(0)) + r10.substring(1, r10.length());
    }

    private static boolean needsIsInitializedCheck(Descriptors.Descriptor r8) {
        return isInitializedCheckAnalyzer.needsIsInitializedCheck(r8);
    }

    private static String snakeCaseToCamelCase(String r8, boolean r10) {
        StringBuilder r11 = new StringBuilder(r8.length() + 1);
        int r12 = 0;
    L4:
        if (r12 >= r8.length()) goto L18;
        char r13 = r8.charAt(r12);
        if (r13 != '_') goto L9;
    L7:
        r10 = true;
    L16:
        r12 = r12 + 1;
        goto L4
    L9:
        if (Character.isDigit(r13) == false) goto L11;
        r11.append(r13);
        goto L7
    L11:
        if (r10 == false) goto L13;
        r11.append(Character.toUpperCase(r13));
        r10 = false;
        goto L16
    L13:
        if (r12 != 0) goto L15;
        r13 = Character.toLowerCase(r13);
    L15:
        r11.append(r13);
        goto L16
    L18:
        return r11.toString();
    }

    private static String snakeCaseToLowerCamelCase(String r8) {
        return snakeCaseToCamelCase(r8, false);
    }

    private static String snakeCaseToUpperCamelCase(String r8) {
        return snakeCaseToCamelCase(r8, true);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> r8) {
        return GeneratedMessage.class.isAssignableFrom(r8);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> r8) {
        if (GeneratedMessage.class.isAssignableFrom(r8) == false) goto L7;
        return convert(r8, descriptorForType(r8));
    L7:
        throw new IllegalArgumentException("Unsupported message type: ".concat(r8.getName()));
    }

    private static java.lang.reflect.Field field(Class<?> r8, String r10) {
        return r8.getDeclaredField(r10);
    L4:
        e = move-exception;
        StringBuilder r11 = defpackage.b.h("Unable to find field ", r10, " in message class ");
        r11.append(r8.getName());
        throw new IllegalArgumentException(r11.toString(), e);
    }
}
