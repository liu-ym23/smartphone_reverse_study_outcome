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

/* JADX INFO: loaded from: classes2.dex */
final class DescriptorMessageInfoFactory implements MessageInfoFactory {
    private static final String GET_DEFAULT_INSTANCE_METHOD_NAME = "getDefaultInstance";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4289a = 0;
    private static final DescriptorMessageInfoFactory instance = null;
    private static IsInitializedCheckAnalyzer isInitializedCheckAnalyzer;
    private static final Set<String> specialFieldNames = null;

    /* JADX INFO: renamed from: com.google.protobuf.DescriptorMessageInfoFactory$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$DescriptorProtos$Edition = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$JavaType = null;

        static {
            int[] r10 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r10;
            r10[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L43
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
            int[] r11 = new int[JavaType.values().length];
            $SwitchMap$com$google$protobuf$JavaType = r11;
            r11[JavaType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L61
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
            int[] r12 = new int[DescriptorProtos.Edition.values().length];
            $SwitchMap$com$google$protobuf$DescriptorProtos$Edition = r12;
            r12[DescriptorProtos.Edition.EDITION_PROTO2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L70
        L78:
            $SwitchMap$com$google$protobuf$DescriptorProtos$Edition[DescriptorProtos.Edition.EDITION_PROTO3.ordinal()] = 2;     // Catch: NoSuchFieldError -> L71
            return;
        }
    }

    static class IsInitializedCheckAnalyzer {
        private int index;
        private final Map<Descriptors.Descriptor, Node> nodeCache;
        private final Map<Descriptors.Descriptor, Boolean> resultCache;
        private final Stack<Node> stack;

        private static class Node {
            StronglyConnectedComponent component;
            final Descriptors.Descriptor descriptor;
            final int index;
            int lowLink;

            Node(Descriptors.Descriptor r10, int r11) {
                this.descriptor = r10;
                this.index = r11;
                this.lowLink = r11;
                this.component = null;
            }
        }

        private static class StronglyConnectedComponent {
            final List<Descriptors.Descriptor> messages;
            boolean needsIsInitializedCheck;

            private StronglyConnectedComponent() {
                this.messages = new ArrayList();
                this.needsIsInitializedCheck = false;
            }

            /* synthetic */ StronglyConnectedComponent(AnonymousClass1 r10) {
                this();
            }
        }

        IsInitializedCheckAnalyzer() {
            this.resultCache = new ConcurrentHashMap();
            this.index = 0;
            this.stack = new Stack();
            this.nodeCache = new HashMap();
        }

        private void analyze(StronglyConnectedComponent r10) {
            Iterator<Descriptors.Descriptor> r11 = r10.messages.iterator();
        L3:
            boolean r12 = true;
            if (r11.hasNext() == false) goto L21;
            Descriptors.Descriptor r13 = r11.next();
            if (r13.isExtendable() == true) goto L22;
            Iterator<Descriptors.FieldDescriptor> r14 = r13.getFields().iterator();
        L10:
            if (r14.hasNext() == false) goto L3;
            Descriptors.FieldDescriptor r15 = r14.next();
            if (r15.isRequired() == true) goto L22;
            if (r15.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L10;
            StronglyConnectedComponent r16 = this.nodeCache.get(r15.getMessageType()).component;
            if (r16 == r10) goto L10;
            if (r16.needsIsInitializedCheck == false) goto L10;
        L22:
            r10.needsIsInitializedCheck = r12;
            Iterator<Descriptors.Descriptor> r17 = r10.messages.iterator();
        L24:
            if (r17.hasNext() == false) goto L26;
            Descriptors.Descriptor r18 = r17.next();
            this.resultCache.put(r18, Boolean.valueOf(r10.needsIsInitializedCheck));
            goto L24
        L26:
            return;
        L21:
            r12 = false;
            goto L22
        }

        private Node dfs(Descriptors.Descriptor r10) {
            int r11 = this.index;
            this.index = r11 + 1;
            Node r12 = new Node(r10, r11);
            this.stack.push(r12);
            this.nodeCache.put(r10, r12);
            Iterator<Descriptors.FieldDescriptor> r13 = r10.getFields().iterator();
        L4:
            if (r13.hasNext() == false) goto L15;
            Descriptors.FieldDescriptor r14 = r13.next();
            if (r14.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L4;
            Node r15 = this.nodeCache.get(r14.getMessageType());
            if (r15 == null) goto L9;
            if (r15.component != null) goto L4;
            int r16 = Math.min(r12.lowLink, r15.lowLink);
        L10:
            r12.lowLink = r16;
            goto L4
        L9:
            Node r17 = dfs(r14.getMessageType());
            r16 = Math.min(r12.lowLink, r17.lowLink);
            goto L10
        L15:
            if (r12.index != r12.lowLink) goto L20;
            StronglyConnectedComponent r18 = new StronglyConnectedComponent(null);
        L17:
            Node r19 = this.stack.pop();
            r19.component = r18;
            r18.messages.add(r19.descriptor);
            if (r19 != r12) goto L17;
            analyze(r18);
        L20:
            return r12;
        }

        public boolean needsIsInitializedCheck(Descriptors.Descriptor r10) {
            Boolean r11 = this.resultCache.get(r10);
            if (r11 != null) goto L5;
            monitor-enter(this);
            Boolean r12 = this.resultCache.get(r10);     // Catch: Throwable -> L15
            if (r12 == null) goto L12;
            boolean r13 = r12.booleanValue();     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return r13;
        L12:
            boolean r14 = dfs(r10).component.needsIsInitializedCheck;     // Catch: Throwable -> L15
            monitor-exit(this);     // Catch: Throwable -> L15
            return r14;
        L15:
            th = move-exception;
            throw th;
        L5:
            return r11.booleanValue();
        }
    }

    private static final class OneofState {
        private OneofInfo[] oneofs;

        private OneofState() {
            this.oneofs = new OneofInfo[2];
        }

        /* synthetic */ OneofState(AnonymousClass1 r10) {
            this();
        }

        private static OneofInfo newInfo(Class<?> r10, Descriptors.OneofDescriptor r11) {
            String r12 = DescriptorMessageInfoFactory.access$200(r11.getName());
            String r13 = r12 + "_";
            return new OneofInfo(r11.getIndex(), DescriptorMessageInfoFactory.access$300(r10, r12 + "Case_"), DescriptorMessageInfoFactory.access$300(r10, r13));
        }

        OneofInfo getOneof(Class<?> r10, Descriptors.OneofDescriptor r11) {
            int r12 = r11.getIndex();
            OneofInfo[] r13 = this.oneofs;
            if (r12 < r13.length) goto L5;
            this.oneofs = (OneofInfo[]) Arrays.copyOf(r13, r12 * 2);
        L5:
            OneofInfo r14 = this.oneofs[r12];
            if (r14 != null) goto L9;
            OneofInfo r15 = newInfo(r10, r11);
            this.oneofs[r12] = r15;
            return r15;
        L9:
            return r14;
        }
    }

    static {
        instance = new DescriptorMessageInfoFactory();
        specialFieldNames = new HashSet(Arrays.asList(new String[]{"Class", "DefaultInstanceForType", "ParserForType", "SerializedSize", "AllFields", "DescriptorForType", "InitializationErrorString", "UnknownFields", "CachedSize"}));
        isInitializedCheckAnalyzer = new IsInitializedCheckAnalyzer();
    }

    private DescriptorMessageInfoFactory() {
    }

    static /* synthetic */ String access$200(String r10) {
        return snakeCaseToLowerCamelCase(r10);
    }

    static /* synthetic */ java.lang.reflect.Field access$300(Class r10, String r11) {
        return field(r10, r11);
    }

    private static java.lang.reflect.Field bitField(Class<?> r10, int r11) {
        return field(r10, "bitField" + r11 + "_");
    }

    private static FieldInfo buildOneofMember(Class<?> r10, Descriptors.FieldDescriptor r11, OneofState r12, boolean r13, Internal.EnumVerifier r14) {
        OneofInfo r15 = r12.getOneof(r10, r11.getContainingOneof());
        FieldType r16 = getFieldType(r11);
        Class<?> r17 = getOneofStoredType(r10, r11, r16);
        return FieldInfo.forOneofMemberField(r11.getNumber(), r16, r15, r17, r13, r14);
    }

    private static java.lang.reflect.Field cachedSizeField(Class<?> r10, Descriptors.FieldDescriptor r11) {
        return field(r10, getCachedSizeFieldName(r11));
    }

    private static MessageInfo convert(Class<?> r18, Descriptors.Descriptor r19) {
        List<Descriptors.FieldDescriptor> r10 = r19.getFields();
        StructuralMessageInfo.Builder r11 = StructuralMessageInfo.newBuilder(r10.size());
        r11.withDefaultInstance(getDefaultInstance(r18));
        r11.withSyntax(convertSyntax(r19.getFile().getEdition()));
        r11.withMessageSetWireFormat(r19.getOptions().getMessageSetWireFormat());
        AnonymousClass1 r12 = null;
        OneofState r13 = new OneofState(r12);
        java.lang.reflect.Field r14 = null;
        int r17 = 1;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r15 >= r10.size()) goto L49;
        final Descriptors.FieldDescriptor r110 = r10.get(r15);
        boolean r111 = r110.needsUtf8Check();
        Descriptors.FieldDescriptor.JavaType r112 = r110.getJavaType();
        Descriptors.FieldDescriptor.JavaType r113 = Descriptors.FieldDescriptor.JavaType.ENUM;
        if (r112 == r113) goto L8;
    L10:
        Internal.EnumVerifier r114 = r12;
    L12:
        if (r110.getRealContainingOneof() == null) goto L14;
        r11.withField(buildOneofMember(r18, r110, r13, r111, r114));
    L48:
        r15 = r15 + 1;
        r12 = null;
        goto L4
    L14:
        java.lang.reflect.Field r115 = field(r18, r110);
        int r116 = r110.getNumber();
        FieldType r20 = getFieldType(r110);
        if (r110.hasPresence() == false) goto L17;
        if (r14 != null) goto L42;
        r14 = bitField(r18, r16);
    L42:
        if (r110.isRequired() == false) goto L44;
        FieldInfo r21 = FieldInfo.forLegacyRequiredField(r115, r116, r20, r14, r17, r111, r114);
    L45:
        r11.withField(r21);
        r17 = r17 << 1;
        if (r17 != 0) goto L48;
        r16 = r16 + 1;
        r17 = 1;
        r14 = null;
        goto L48
    L44:
        r21 = FieldInfo.forExplicitPresenceField(r115, r116, r20, r14, r17, r111, r114);
        goto L45
    L17:
        if (r110.isMapField() == false) goto L25;
        final Descriptors.FieldDescriptor r22 = r110.getMessageType().findFieldByNumber(2);
        if (r22.getJavaType() == r113) goto L21;
    L23:
        FieldInfo r23 = FieldInfo.forMapField(r115, r116, SchemaUtil.getMapDefaultEntry(r18, r110.getName()), r114);
    L38:
        r11.withField(r23);
        goto L48
    L21:
        if (r22.legacyEnumFieldTreatedAsClosed() == false) goto L23;
        r114 = new AnonymousClass2(r22);
        goto L23
    L25:
        if (r110.isRepeated() == false) goto L30;
        if (r110.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L30;
        r23 = FieldInfo.forRepeatedMessageField(r115, r116, r20, getTypeForRepeatedMessageField(r18, r110));
    L30:
        if (r110.isPacked() == false) goto L35;
        java.lang.reflect.Field r24 = cachedSizeField(r18, r110);
        if (r114 == null) goto L34;
        r23 = FieldInfo.forPackedFieldWithEnumVerifier(r115, r116, r20, r114, r24);
        goto L38
    L34:
        r23 = FieldInfo.forPackedField(r115, r116, r20, r24);
        goto L38
    L35:
        if (r114 == null) goto L37;
        r23 = FieldInfo.forFieldWithEnumVerifier(r115, r116, r20, r114);
        goto L38
    L37:
        r23 = FieldInfo.forField(r115, r116, r20, r111);
        goto L38
    L8:
        if (r110.legacyEnumFieldTreatedAsClosed() == false) goto L10;
        r114 = new AnonymousClass1(r110);
        goto L12
    L49:
        ArrayList r25 = new ArrayList();
        int r26 = 0;
    L51:
        if (r26 >= r10.size()) goto L60;
        Descriptors.FieldDescriptor r27 = r10.get(r26);
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
        r11.withCheckInitialized(r29);
    L67:
        return r11.build();
    }

    private static ProtoSyntax convertSyntax(DescriptorProtos.Edition r10) {
        int r11 = AnonymousClass3.$SwitchMap$com$google$protobuf$DescriptorProtos$Edition[r10.ordinal()];
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L9;
        return ProtoSyntax.EDITIONS;
    L9:
        return ProtoSyntax.PROTO3;
    L11:
        return ProtoSyntax.PROTO2;
    }

    private static Descriptors.Descriptor descriptorForType(Class<?> r10) {
        return getDefaultInstance(r10).getDescriptorForType();
    }

    private static java.lang.reflect.Field field(Class<?> r10, Descriptors.FieldDescriptor r11) {
        return field(r10, getFieldName(r11));
    }

    private static java.lang.reflect.Field field(Class<?> r10, String r11) {
        return r10.getDeclaredField(r11);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Unable to find field " + r11 + " in message class " + r10.getName(), e);
    }

    private static String getCachedSizeFieldName(Descriptors.FieldDescriptor r10) {
        return snakeCaseToLowerCamelCase(r10.getName()) + "MemoizedSerializedSize";
    }

    private static Message getDefaultInstance(Class<?> r10) {
        return (Message) r10.getDeclaredMethod(GET_DEFAULT_INSTANCE_METHOD_NAME, new Class[0]).invoke(null, new Object[0]);
    L4:
        e = move-exception;
        throw new IllegalArgumentException("Unable to get default instance for message class " + r10.getName(), e);
    }

    static String getFieldName(Descriptors.FieldDescriptor r10) {
        if (r10.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r11 = r10.getMessageType().getName();
    L7:
        if (specialFieldNames.contains(snakeCaseToUpperCamelCase(r11)) == false) goto L9;
        String r12 = "__";
    L11:
        return snakeCaseToLowerCamelCase(r11) + r12;
    L9:
        r12 = "_";
        goto L11
    L5:
        r11 = r10.getName();
        goto L7
    }

    private static FieldType getFieldType(Descriptors.FieldDescriptor r10) {
        switch(AnonymousClass3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r10.getType().ordinal()]) {
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
        throw new IllegalArgumentException("Unsupported field type: " + r10.getType());
    L7:
        if (r10.isRepeated() == true) goto L11;
        return FieldType.UINT64;
    L11:
        if (r10.isPacked() == false) goto L14;
        return FieldType.UINT64_LIST_PACKED;
    L14:
        return FieldType.UINT64_LIST;
    L16:
        if (r10.isRepeated() == true) goto L20;
        return FieldType.UINT32;
    L20:
        if (r10.isPacked() == false) goto L23;
        return FieldType.UINT32_LIST_PACKED;
    L23:
        return FieldType.UINT32_LIST;
    L25:
        if (r10.isRepeated() == false) goto L28;
        return FieldType.STRING_LIST;
    L28:
        return FieldType.STRING;
    L30:
        if (r10.isRepeated() == true) goto L34;
        return FieldType.SINT64;
    L34:
        if (r10.isPacked() == false) goto L37;
        return FieldType.SINT64_LIST_PACKED;
    L37:
        return FieldType.SINT64_LIST;
    L39:
        if (r10.isRepeated() == true) goto L43;
        return FieldType.SINT32;
    L43:
        if (r10.isPacked() == false) goto L46;
        return FieldType.SINT32_LIST_PACKED;
    L46:
        return FieldType.SINT32_LIST;
    L48:
        if (r10.isRepeated() == true) goto L52;
        return FieldType.SFIXED64;
    L52:
        if (r10.isPacked() == false) goto L55;
        return FieldType.SFIXED64_LIST_PACKED;
    L55:
        return FieldType.SFIXED64_LIST;
    L57:
        if (r10.isRepeated() == true) goto L61;
        return FieldType.SFIXED32;
    L61:
        if (r10.isPacked() == false) goto L64;
        return FieldType.SFIXED32_LIST_PACKED;
    L64:
        return FieldType.SFIXED32_LIST;
    L66:
        if (r10.isMapField() == false) goto L70;
        return FieldType.MAP;
    L70:
        if (r10.isRepeated() == false) goto L73;
        return FieldType.MESSAGE_LIST;
    L73:
        return FieldType.MESSAGE;
    L75:
        if (r10.isRepeated() == true) goto L79;
        return FieldType.INT64;
    L79:
        if (r10.isPacked() == false) goto L82;
        return FieldType.INT64_LIST_PACKED;
    L82:
        return FieldType.INT64_LIST;
    L84:
        if (r10.isRepeated() == true) goto L88;
        return FieldType.INT32;
    L88:
        if (r10.isPacked() == false) goto L91;
        return FieldType.INT32_LIST_PACKED;
    L91:
        return FieldType.INT32_LIST;
    L93:
        if (r10.isRepeated() == false) goto L96;
        return FieldType.GROUP_LIST;
    L96:
        return FieldType.GROUP;
    L98:
        if (r10.isRepeated() == true) goto L102;
        return FieldType.FLOAT;
    L102:
        if (r10.isPacked() == false) goto L105;
        return FieldType.FLOAT_LIST_PACKED;
    L105:
        return FieldType.FLOAT_LIST;
    L107:
        if (r10.isRepeated() == true) goto L111;
        return FieldType.FIXED64;
    L111:
        if (r10.isPacked() == false) goto L114;
        return FieldType.FIXED64_LIST_PACKED;
    L114:
        return FieldType.FIXED64_LIST;
    L116:
        if (r10.isRepeated() == true) goto L120;
        return FieldType.FIXED32;
    L120:
        if (r10.isPacked() == false) goto L123;
        return FieldType.FIXED32_LIST_PACKED;
    L123:
        return FieldType.FIXED32_LIST;
    L125:
        if (r10.isRepeated() == true) goto L129;
        return FieldType.ENUM;
    L129:
        if (r10.isPacked() == false) goto L132;
        return FieldType.ENUM_LIST_PACKED;
    L132:
        return FieldType.ENUM_LIST;
    L134:
        if (r10.isRepeated() == true) goto L138;
        return FieldType.DOUBLE;
    L138:
        if (r10.isPacked() == false) goto L141;
        return FieldType.DOUBLE_LIST_PACKED;
    L141:
        return FieldType.DOUBLE_LIST;
    L143:
        if (r10.isRepeated() == false) goto L146;
        return FieldType.BYTES_LIST;
    L146:
        return FieldType.BYTES;
    L148:
        if (r10.isRepeated() == true) goto L152;
        return FieldType.BOOL;
    L152:
        if (r10.isPacked() == false) goto L155;
        return FieldType.BOOL_LIST_PACKED;
    L155:
        return FieldType.BOOL_LIST;
    }

    public static DescriptorMessageInfoFactory getInstance() {
        return instance;
    }

    private static Class<?> getOneofStoredType(Class<?> r10, Descriptors.FieldDescriptor r11, FieldType r12) {
        switch(AnonymousClass3.$SwitchMap$com$google$protobuf$JavaType[r12.getJavaType().ordinal()]) {
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
        throw new IllegalArgumentException("Invalid type for oneof: " + r12);
    L7:
        return getOneofStoredTypeForMessage(r10, r11);
    }

    private static Class<?> getOneofStoredTypeForMessage(Class<?> r10, Descriptors.FieldDescriptor r11) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (r11.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r12 = r11.getMessageType().getName();     // Catch: Exception -> L8
    L6:
        return r10.getDeclaredMethod(getterForField(r12), new Class[0]).getReturnType();
    L5:
        r12 = r11.getName();     // Catch: Exception -> L8
        goto L6
    }

    private static Class<?> getTypeForRepeatedMessageField(Class<?> r10, Descriptors.FieldDescriptor r11) {
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (r11.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L5;
        String r12 = r11.getMessageType().getName();     // Catch: Exception -> L8
    L6:
        return r10.getDeclaredMethod(getterForField(r12), new Class[]{Integer.TYPE}).getReturnType();
    L5:
        r12 = r11.getName();     // Catch: Exception -> L8
        goto L6
    }

    private static String getterForField(String r10) {
        String r11 = snakeCaseToLowerCamelCase(r10);
        return "get" + Character.toUpperCase(r11.charAt(0)) + r11.substring(1, r11.length());
    }

    private static boolean needsIsInitializedCheck(Descriptors.Descriptor r10) {
        return isInitializedCheckAnalyzer.needsIsInitializedCheck(r10);
    }

    private static String snakeCaseToCamelCase(String r10, boolean r11) {
        StringBuilder r12 = new StringBuilder(r10.length() + 1);
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L18;
        char r14 = r10.charAt(r13);
        if (r14 != '_') goto L9;
    L7:
        r11 = true;
    L16:
        r13 = r13 + 1;
        goto L4
    L9:
        if (Character.isDigit(r14) == false) goto L11;
        r12.append(r14);
        goto L7
    L11:
        if (r11 == false) goto L13;
        r12.append(Character.toUpperCase(r14));
        r11 = false;
        goto L16
    L13:
        if (r13 != 0) goto L15;
        r14 = Character.toLowerCase(r14);
    L15:
        r12.append(r14);
        goto L16
    L18:
        return r12.toString();
    }

    private static String snakeCaseToLowerCamelCase(String r10) {
        return snakeCaseToCamelCase(r10, false);
    }

    private static String snakeCaseToUpperCamelCase(String r10) {
        return snakeCaseToCamelCase(r10, true);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public boolean isSupported(Class<?> r10) {
        return GeneratedMessage.class.isAssignableFrom(r10);
    }

    @Override // com.google.protobuf.MessageInfoFactory
    public MessageInfo messageInfoFor(Class<?> r10) {
        if (GeneratedMessage.class.isAssignableFrom(r10) == false) goto L7;
        return convert(r10, descriptorForType(r10));
    L7:
        throw new IllegalArgumentException("Unsupported message type: " + r10.getName());
    }
}
