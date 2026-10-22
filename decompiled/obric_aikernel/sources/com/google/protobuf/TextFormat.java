package com.google.protobuf;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.crash.entity.EventBody;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class TextFormat {
    private static final String DEBUG_STRING_SILENT_MARKER = " \t ";
    private static final Parser PARSER = null;
    private static final String REDACTED_MARKER = "[REDACTED]";
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r10 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r10;
            r10[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L80:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L58:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
        L74:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L33
        L82:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;     // Catch: NoSuchFieldError -> L34
        L62:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L35
        L66:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L36
        L94:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L37
        L54:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L38
        L86:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L39
        L88:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L40
        L68:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L41
        L76:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L42
        L56:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L43
        L64:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L44
        L92:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L45
        L52:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L46
        L84:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;     // Catch: NoSuchFieldError -> L47
        L24:
            int[] r11 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r11;
            r11[Descriptors.FieldDescriptor.JavaType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L48
        L72:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.LONG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L49
        L78:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.INT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L50
        L90:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[Descriptors.FieldDescriptor.JavaType.STRING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L51
            return;
        }
    }

    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(String r10) {
            super(r10);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(int r10, int r11, String r12) {
            super(Integer.toString(r10) + ":" + r11 + ": " + r12);
            this.line = r10;
            this.column = r11;
        }

        public ParseException(String r10) {
            this(-1, -1, r10);
        }

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }
    }

    public static class Parser {
        private static final int BUFFER_SIZE = 4096;
        private final boolean allowUnknownEnumValues;
        private final boolean allowUnknownExtensions;
        private final boolean allowUnknownFields;
        private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private final int recursionLimit;
        private final SingularOverwritePolicy singularOverwritePolicy;
        private final TypeRegistry typeRegistry;

        public static class Builder {
            private boolean allowUnknownEnumValues;
            private boolean allowUnknownExtensions;
            private boolean allowUnknownFields;
            private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
            private int recursionLimit;
            private SingularOverwritePolicy singularOverwritePolicy;
            private TypeRegistry typeRegistry;

            public Builder() {
                this.allowUnknownFields = false;
                this.allowUnknownEnumValues = false;
                this.allowUnknownExtensions = false;
                this.singularOverwritePolicy = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
                this.parseInfoTreeBuilder = null;
                this.typeRegistry = TypeRegistry.getEmptyTypeRegistry();
                this.recursionLimit = 100;
            }

            public Parser build() {
                return new Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder, this.recursionLimit, null);
            }

            public Builder setAllowUnknownExtensions(boolean r10) {
                this.allowUnknownExtensions = r10;
                return this;
            }

            public Builder setAllowUnknownFields(boolean r10) {
                this.allowUnknownFields = r10;
                return this;
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder r10) {
                this.parseInfoTreeBuilder = r10;
                return this;
            }

            public Builder setRecursionLimit(int r10) {
                this.recursionLimit = r10;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy r10) {
                this.singularOverwritePolicy = r10;
                return this;
            }

            public Builder setTypeRegistry(TypeRegistry r10) {
                this.typeRegistry = r10;
                return this;
            }
        }

        public static final enum SingularOverwritePolicy extends java.lang.Enum<SingularOverwritePolicy> {
            private static final /* synthetic */ SingularOverwritePolicy[] $VALUES = null;
            public static final SingularOverwritePolicy ALLOW_SINGULAR_OVERWRITES = null;
            public static final SingularOverwritePolicy FORBID_SINGULAR_OVERWRITES = null;

            private static /* synthetic */ SingularOverwritePolicy[] $values() {
                return new SingularOverwritePolicy[]{ALLOW_SINGULAR_OVERWRITES, FORBID_SINGULAR_OVERWRITES};
            }

            static {
                ALLOW_SINGULAR_OVERWRITES = new SingularOverwritePolicy("ALLOW_SINGULAR_OVERWRITES", 0);
                FORBID_SINGULAR_OVERWRITES = new SingularOverwritePolicy("FORBID_SINGULAR_OVERWRITES", 1);
                $VALUES = $values();
            }

            private SingularOverwritePolicy(String r10, int r11) {
                super(r10, r11);
            }

            public static SingularOverwritePolicy valueOf(String r10) {
                return (SingularOverwritePolicy) java.lang.Enum.valueOf(SingularOverwritePolicy.class, r10);
            }

            public static SingularOverwritePolicy[] values() {
                return (SingularOverwritePolicy[]) $VALUES.clone();
            }
        }

        static final class UnknownField {
            final String message;
            final Type type;

            static final enum Type extends java.lang.Enum<Type> {
                private static final /* synthetic */ Type[] $VALUES = null;
                public static final Type EXTENSION = null;
                public static final Type FIELD = null;

                private static /* synthetic */ Type[] $values() {
                    return new Type[]{FIELD, EXTENSION};
                }

                static {
                    FIELD = new Type("FIELD", 0);
                    EXTENSION = new Type("EXTENSION", 1);
                    $VALUES = $values();
                }

                private Type(String r10, int r11) {
                    super(r10, r11);
                }

                public static Type valueOf(String r10) {
                    return (Type) java.lang.Enum.valueOf(Type.class, r10);
                }

                public static Type[] values() {
                    return (Type[]) $VALUES.clone();
                }
            }

            UnknownField(String r10, Type r11) {
                this.message = r10;
                this.type = r11;
            }
        }

        private Parser(TypeRegistry r10, boolean r11, boolean r12, boolean r13, SingularOverwritePolicy r14, TextFormatParseInfoTree.Builder r15, int r16) {
            this.typeRegistry = r10;
            this.allowUnknownFields = r11;
            this.allowUnknownEnumValues = r12;
            this.allowUnknownExtensions = r13;
            this.singularOverwritePolicy = r14;
            this.parseInfoTreeBuilder = r15;
            this.recursionLimit = r16;
        }

        /* synthetic */ Parser(TypeRegistry r10, boolean r11, boolean r12, boolean r13, SingularOverwritePolicy r14, TextFormatParseInfoTree.Builder r15, int r16, AnonymousClass1 r17) {
            this(r10, r11, r12, r13, r14, r15, r16);
        }

        private void checkUnknownFields(List<UnknownField> r10) {
            if (r10.isEmpty() == false) goto L5;
            return;
        L5:
            StringBuilder r11 = new StringBuilder("Input contains unknown fields and/or extensions:");
            Iterator<UnknownField> r12 = r10.iterator();
        L7:
            if (r12.hasNext() == false) goto L10;
            UnknownField r13 = r12.next();
            r11.append('\n');
            r11.append(r13.message);
            goto L7
        L10:
            if (this.allowUnknownFields == false) goto L14;
        L11:
            TextFormat.access$700().warning(r11.toString());
            return;
        L14:
            if (this.allowUnknownExtensions == false) goto L25;
            Iterator<UnknownField> r14 = r10.iterator();
            int r15 = 0;
        L17:
            if (r14.hasNext() == false) goto L22;
            if (r14.next().type == UnknownField.Type.FIELD) goto L20;
            r15 = r15 + 1;
            goto L17
        L20:
            boolean r16 = false;
        L23:
            if (r16 == true) goto L11;
        L26:
            String[] r17 = r10.get(r15).message.split(":");
            throw new ParseException(Integer.parseInt(r17[0]), Integer.parseInt(r17[1]), r11.toString());
        L22:
            r16 = true;
            goto L23
        L25:
            r15 = 0;
            goto L26
        }

        private void consumeFieldValue(Tokenizer r17, ExtensionRegistry r18, MessageReflection.MergeTarget r19, Descriptors.FieldDescriptor r20, ExtensionRegistry.ExtensionInfo r21, TextFormatParseInfoTree.Builder r22, List<UnknownField> r23, int r24) {
            if (this.singularOverwritePolicy == SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES) goto L5;
        L17:
            Object r10 = null;
            Message r11 = null;
            if (r20.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L41;
            if (r24 < 1) goto L39;
            if (r17.tryConsume("<") == false) goto L24;
            String r12 = ">";
        L25:
            String r14 = r12;
            if (r21 == null) goto L29;
            r11 = r21.defaultInstance;
        L29:
            MessageReflection.MergeTarget r15 = r19.newMergeTargetForField(r20, r11);
        L31:
            if (r17.tryConsume(r14) == true) goto L37;
            if (r17.atEnd() == true) goto L36;
            mergeField(r17, r18, r15, r22, r23, r24 - 1);
            goto L31
        L36:
            throw r17.parseException("Expected \"" + r14 + "\".");
        L37:
            r10 = r15.finish();
        L78:
            if (r20.isRepeated() == false) goto L80;
            r19.addRepeatedField(r20, r10);
            return;
        L80:
            r19.setField(r20, r10);
            return;
        L24:
            r17.consume("{");
            r12 = "}";
            goto L25
        L39:
            throw r17.parseException("Message is nested too deep");
        L41:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r20.getType().ordinal()]) {
                case 1: goto L75;
                case 2: goto L75;
                case 3: goto L75;
                case 4: goto L73;
                case 5: goto L73;
                case 6: goto L73;
                case 7: goto L72;
                case 8: goto L71;
                case 9: goto L70;
                case 10: goto L69;
                case 11: goto L69;
                case 12: goto L68;
                case 13: goto L68;
                case 14: goto L67;
                case 15: goto L66;
                case 16: goto L45;
                case 17: goto L44;
                case 18: goto L44;
                default: goto L78;
            };
        L45:
            Descriptors.EnumDescriptor r13 = r20.getEnumType();
            if (r17.lookingAtInteger() == false) goto L58;
            int r16 = r17.consumeInt32();
            if (r13.isClosed() == false) goto L50;
            r10 = r13.findValueByNumber(r16);
        L51:
            if (r10 != null) goto L78;
            String r25 = "Enum type \"" + r13.getFullName() + "\" has no value with number " + r16 + '.';
            if (this.allowUnknownEnumValues == false) goto L57;
            TextFormat.access$700().warning(r25);
            return;
        L57:
            throw r17.parseExceptionPreviousToken("Enum type \"" + r13.getFullName() + "\" has no value with number " + r16 + '.');
        L50:
            r10 = r13.findValueByNumberCreatingIfUnknown(r16);
            goto L51
        L58:
            String r26 = r17.consumeIdentifier();
            r10 = r13.findValueByName(r26);
            if (r10 != null) goto L78;
            String r27 = "Enum type \"" + r13.getFullName() + "\" has no value named \"" + r26 + "\".";
            if (this.allowUnknownEnumValues == false) goto L65;
            TextFormat.access$700().warning(r27);
            return;
        L65:
            throw r17.parseExceptionPreviousToken(r27);
        L66:
            r10 = r17.consumeByteString();
            goto L78
        L67:
            r10 = r17.consumeString();
            goto L78
        L68:
            long r28 = r17.consumeUInt64();
        L74:
            r10 = Long.valueOf(r28);
            goto L78
        L69:
            int r29 = r17.consumeUInt32();
        L76:
            r10 = Integer.valueOf(r29);
            goto L78
        L70:
            r10 = Double.valueOf(r17.consumeDouble());
            goto L78
        L71:
            r10 = Float.valueOf(r17.consumeFloat());
            goto L78
        L72:
            r10 = Boolean.valueOf(r17.consumeBoolean());
            goto L78
        L73:
            r28 = r17.consumeInt64();
            goto L74
        L75:
            r29 = r17.consumeInt32();
            goto L76
        L44:
            throw new RuntimeException("Can't get here.");
        L5:
            if (r20.isRepeated() == true) goto L17;
            if (r19.hasField(r20) == true) goto L16;
            if (r20.getContainingOneof() == null) goto L17;
            if (r19.hasOneof(r20.getContainingOneof()) == false) goto L17;
            Descriptors.OneofDescriptor r30 = r20.getContainingOneof();
            throw r17.parseExceptionPreviousToken("Field \"" + r20.getFullName() + "\" is specified along with field \"" + r19.getOneofFieldDescriptor(r30).getFullName() + "\", another member of oneof \"" + r30.getName() + "\".");
        L16:
            throw r17.parseExceptionPreviousToken("Non-repeated field \"" + r20.getFullName() + "\" cannot be overwritten.");
        }

        private void consumeFieldValues(Tokenizer r10, ExtensionRegistry r11, MessageReflection.MergeTarget r12, Descriptors.FieldDescriptor r13, ExtensionRegistry.ExtensionInfo r14, TextFormatParseInfoTree.Builder r15, List<UnknownField> r16, int r17) {
            if (r13.isRepeated() == true) goto L5;
        L12:
            consumeFieldValue(r10, r11, r12, r13, r14, r15, r16, r17);
            return;
        L5:
            if (r10.tryConsume("[") == false) goto L12;
            if (r10.tryConsume("]") == true) goto L15;
        L8:
            consumeFieldValue(r10, r11, r12, r13, r14, r15, r16, r17);
            if (r10.tryConsume("]") == true) goto L16;
            r10.consume(",");
            goto L8
        L16:
            return;
        }

        private String consumeFullTypeName(Tokenizer r10) {
            if (r10.tryConsume("[") == false) goto L5;
            String r11 = r10.consumeIdentifier();
        L8:
            if (r10.tryConsume(".") == false) goto L11;
            r11 = r11 + "." + r10.consumeIdentifier();
            goto L8
        L11:
            if (r10.tryConsume("/") == false) goto L16;
            r11 = r11 + "/" + r10.consumeIdentifier();
        L14:
            if (r10.tryConsume(".") == false) goto L16;
            r11 = r11 + "." + r10.consumeIdentifier();
        L16:
            r10.consume("]");
            return r11;
        L5:
            return r10.consumeIdentifier();
        }

        private void detectSilentMarker(Tokenizer r10, Descriptors.Descriptor r11, String r12) {
        }

        private void guessFieldTypeAndSkip(Tokenizer r10, Descriptors.Descriptor r11, int r12) {
            boolean r13 = r10.tryConsume(":");
            if (r10.lookingAt("[") == false) goto L5;
            skipFieldShortFormedRepeated(r10, r13, r11, r12);
            return;
        L5:
            if (r13 == false) goto L12;
            if (r10.lookingAt("{") == true) goto L12;
            if (r10.lookingAt("<") == true) goto L12;
            skipFieldValue(r10);
            return;
        L12:
            if (r12 < 1) goto L16;
            skipFieldMessage(r10, r11, r12 - 1);
            return;
        L16:
            throw r10.parseException("Message is nested too deep");
        }

        private void mergeAnyFieldValue(Tokenizer r16, ExtensionRegistry r17, MessageReflection.MergeTarget r18, TextFormatParseInfoTree.Builder r19, List<UnknownField> r20, Descriptors.Descriptor r21, int r22) {
            StringBuilder r11 = new StringBuilder();
        L3:
            r11.append(r16.consumeIdentifier());
            if (r16.tryConsume("]") == true) goto L5;
            String r10 = "/";
            if (r16.tryConsume("/") == true) goto L24;
            r10 = ".";
            if (r16.tryConsume(".") == true) goto L24;
            throw r16.parseExceptionPreviousToken("Expected a valid type URL.");
        L24:
            r11.append(r10);
            goto L3
        L5:
            detectSilentMarker(r16, r21, r11.toString());
            r16.tryConsume(":");
            if (r16.tryConsume("<") == false) goto L8;
            String r12 = ">";
        L9:
            String r13 = r12;
            String r14 = r11.toString();
            Descriptors.Descriptor r15 = this.typeRegistry.getDescriptorForTypeUrl(r14);     // Catch: InvalidProtocolBufferException -> L20
            if (r15 == null) goto L19;
            DynamicMessage.Builder r110 = DynamicMessage.getDefaultInstance(r15).newBuilderForType();
            MessageReflection.BuilderAdapter r111 = new MessageReflection.BuilderAdapter(r110);
        L14:
            if (r16.tryConsume(r13) == true) goto L16;
            mergeField(r16, r17, r111, r19, r20, r22);
            goto L14
        L16:
            r18.setField(r21.findFieldByName("type_url"), r11.toString());
            r18.setField(r21.findFieldByName(EventBody.KEY_VALUE), r110.build().toByteString());
            return;
        L19:
            throw r16.parseException("Unable to parse Any of type: " + r14 + ". Please make sure that the TypeRegistry contains the descriptors for the given types.");
        L21:
            throw r16.parseException("Invalid valid type URL. Found: " + r14);
        L8:
            r16.consume("{");
            r12 = "}";
            goto L9
        }

        private void mergeField(Tokenizer r20, ExtensionRegistry r21, MessageReflection.MergeTarget r22, TextFormatParseInfoTree.Builder r23, List<UnknownField> r24, int r25) {
            int r11 = r20.getLine();
            int r12 = r20.getColumn();
            Descriptors.Descriptor r10 = r22.getDescriptorForType();
            if ("google.protobuf.Any".equals(r10.getFullName()) == false) goto L12;
            if (r20.tryConsume("[") == false) goto L12;
            if (r25 < 1) goto L10;
            mergeAnyFieldValue(r20, r21, r22, r23, r24, r10, r25 - 1);
            return;
        L10:
            throw r20.parseException("Message is nested too deep");
        L12:
            if (r20.tryConsume("[") == false) goto L26;
            StringBuilder r13 = new StringBuilder(r20.consumeIdentifier());
        L15:
            if (r20.tryConsume(".") == false) goto L17;
            r13.append('.');
            r13.append(r20.consumeIdentifier());
            goto L15
        L17:
            String r14 = r13.toString();
            ExtensionRegistry.ExtensionInfo r15 = r22.findExtensionByName(r21, r14);
            if (r15 != null) goto L21;
            r24.add(new UnknownField((r20.getPreviousLine() + 1) + ":" + (r20.getPreviousColumn() + 1) + ":\t" + r10.getFullName() + ".[" + r14 + "]", UnknownField.Type.EXTENSION));
            Descriptors.FieldDescriptor r16 = null;
        L23:
            r20.consume("]");
            Descriptors.FieldDescriptor r17 = r16;
            ExtensionRegistry.ExtensionInfo r18 = r15;
        L40:
            if (r17 != null) goto L44;
            detectSilentMarker(r20, r10, r14);
            guessFieldTypeAndSkip(r20, r10, r25);
            return;
        L44:
            if (r17.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L48;
            detectSilentMarker(r20, r10, r17.getFullName());
            r20.tryConsume(":");
            if (r23 == null) goto L49;
            TextFormatParseInfoTree.Builder r19 = r23.getBuilderForSubMessageField(r17);
        L50:
            consumeFieldValues(r20, r21, r22, r17, r18, r19, r24, r25);
            if (r23 == null) goto L54;
            r23.setLocation(r17, TextFormatParseLocation.create(r11, r12));
        L54:
            if (r20.tryConsume(";") == true) goto L58;
            r20.tryConsume(",");
            return;
        L58:
            return;
        L49:
            r19 = r23;
            goto L50
        L48:
            detectSilentMarker(r20, r10, r17.getFullName());
            r20.consume(":");
            goto L49
        L21:
            if (r15.descriptor.getContainingType() != r10) goto L25;
            r16 = r15.descriptor;
            goto L23
        L25:
            throw r20.parseExceptionPreviousToken("Extension \"" + r14 + "\" does not extend message type \"" + r10.getFullName() + "\".");
        L26:
            r14 = r20.consumeIdentifier();
            Descriptors.FieldDescriptor r26 = r10.findFieldByName(r14);
            if (r26 != null) goto L37;
            r26 = r10.findFieldByName(r14.toLowerCase(Locale.US));
            if (r26 != null) goto L31;
        L33:
            if (r26 == null) goto L37;
            if (r26.getMessageType().getName().equals(r14) == true) goto L37;
            r26 = null;
            goto L37
        L31:
            if (r26.isGroupLike() == true) goto L33;
            r26 = null;
        L37:
            if (r26 != null) goto L39;
            r24.add(new UnknownField((r20.getPreviousLine() + 1) + ":" + (r20.getPreviousColumn() + 1) + ":\t" + r10.getFullName() + "." + r14, UnknownField.Type.FIELD));
        L39:
            r17 = r26;
            r18 = null;
            goto L40
        }

        private void mergeField(Tokenizer r10, ExtensionRegistry r11, MessageReflection.MergeTarget r12, List<UnknownField> r13, int r14) {
            mergeField(r10, r11, r12, this.parseInfoTreeBuilder, r13, r14);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private void skipField(Tokenizer r10, Descriptors.Descriptor r11, int r12) {
            detectSilentMarker(r10, r11, consumeFullTypeName(r10));
            guessFieldTypeAndSkip(r10, r11, r12);
            if (r10.tryConsume(";") == true) goto L6;
            r10.tryConsume(",");
            return;
        }

        private void skipFieldMessage(Tokenizer r10, Descriptors.Descriptor r11, int r12) {
            if (r10.tryConsume("<") == false) goto L5;
            String r13 = ">";
        L7:
            if (r10.lookingAt(">") == true) goto L11;
            if (r10.lookingAt("}") == true) goto L11;
            skipField(r10, r11, r12);
        L11:
            r10.consume(r13);
            return;
        L5:
            r10.consume("{");
            r13 = "}";
            goto L7
        }

        private void skipFieldShortFormedRepeated(Tokenizer r10, boolean r11, Descriptors.Descriptor r12, int r13) {
            if (r10.tryConsume("[") == true) goto L5;
            return;
        L5:
            if (r10.tryConsume("]") == false) goto L8;
            return;
        L8:
            if (r10.lookingAt("{") == true) goto L17;
            if (r10.lookingAt("<") == true) goto L17;
            if (r11 == false) goto L15;
            skipFieldValue(r10);
        L20:
            if (r10.tryConsume("]") == true) goto L21;
            r10.consume(",");
            goto L8
        L21:
            return;
        L15:
            throw r10.parseException("Invalid repeated scalar field: missing \":\" before \"[\".");
        L17:
            if (r13 < 1) goto L24;
            skipFieldMessage(r10, r12, r13 - 1);
            goto L20
        L24:
            throw r10.parseException("Message is nested too deep");
        }

        private void skipFieldValue(Tokenizer r10) {
            if (r10.tryConsumeByteString() == false) goto L5;
            return;
        L5:
            if (r10.tryConsumeIdentifier() == false) goto L7;
            return;
        L7:
            if (r10.tryConsumeInt64() == false) goto L9;
            return;
        L9:
            if (r10.tryConsumeUInt64() == false) goto L11;
            return;
        L11:
            if (r10.tryConsumeDouble() == false) goto L13;
            return;
        L13:
            if (r10.tryConsumeFloat() == false) goto L16;
            return;
        L16:
            throw r10.parseException("Invalid field value: " + Tokenizer.access$900(r10));
        }

        private static StringBuilder toStringBuilder(Readable r10) {
            StringBuilder r11 = new StringBuilder();
            CharBuffer r12 = CharBuffer.allocate(4096);
        L3:
            int r13 = r10.read(r12);
            if (r13 == (-1)) goto L5;
            Java8Compatibility.flip(r12);
            r11.append(r12, 0, r13);
            goto L3
        L5:
            return r11;
        }

        public void merge(CharSequence r10, ExtensionRegistry r11, Message.Builder r12) {
            Tokenizer r13 = new Tokenizer(r10, null);
            MessageReflection.BuilderAdapter r14 = new MessageReflection.BuilderAdapter(r12);
            ArrayList r15 = new ArrayList();
        L4:
            if (r13.atEnd() == true) goto L6;
            mergeField(r13, r11, r14, r15, this.recursionLimit);
            goto L4
        L6:
            checkUnknownFields(r15);
        }

        public void merge(CharSequence r10, Message.Builder r11) {
            merge(r10, ExtensionRegistry.getEmptyRegistry(), r11);
        }

        public void merge(Readable r10, ExtensionRegistry r11, Message.Builder r12) {
            merge(toStringBuilder(r10), r11, r12);
        }

        public void merge(Readable r10, Message.Builder r11) {
            merge(r10, ExtensionRegistry.getEmptyRegistry(), r11);
        }
    }

    public static final class Printer {
        private static final Printer DEFAULT_DEBUG_FORMAT = null;
        private static final Printer DEFAULT_TEXT_FORMAT = null;
        private static final ThreadLocal<FieldReporterLevel> sensitiveFieldReportingLevel = null;
        private final boolean enablingSafeDebugFormat;
        private final boolean escapeNonAscii;
        private final ExtensionRegistryLite extensionRegistry;
        private final boolean singleLine;
        private final TypeRegistry typeRegistry;
        private final boolean useShortRepeatedPrimitives;

        static final enum FieldReporterLevel extends java.lang.Enum<FieldReporterLevel> {
            private static final /* synthetic */ FieldReporterLevel[] $VALUES = null;
            public static final FieldReporterLevel ABSTRACT_BUILDER_TO_STRING = null;
            public static final FieldReporterLevel ABSTRACT_MUTABLE_TO_STRING = null;
            public static final FieldReporterLevel ABSTRACT_TO_STRING = null;
            public static final FieldReporterLevel DEBUG_MULTILINE = null;
            public static final FieldReporterLevel DEBUG_SINGLE_LINE = null;
            public static final FieldReporterLevel LEGACY_MULTILINE = null;
            public static final FieldReporterLevel LEGACY_SINGLE_LINE = null;
            public static final FieldReporterLevel PRINT = null;
            public static final FieldReporterLevel PRINTER_PRINT_TO_STRING = null;
            public static final FieldReporterLevel PRINT_UNICODE = null;
            public static final FieldReporterLevel REPORT_ALL = null;
            public static final FieldReporterLevel REPORT_NONE = null;
            public static final FieldReporterLevel SHORT_DEBUG_STRING = null;
            public static final FieldReporterLevel TEXTFORMAT_PRINT_TO_STRING = null;
            public static final FieldReporterLevel TEXT_GENERATOR = null;
            private final int index;

            private static /* synthetic */ FieldReporterLevel[] $values() {
                return new FieldReporterLevel[]{REPORT_ALL, TEXT_GENERATOR, PRINT, PRINTER_PRINT_TO_STRING, TEXTFORMAT_PRINT_TO_STRING, PRINT_UNICODE, SHORT_DEBUG_STRING, LEGACY_MULTILINE, LEGACY_SINGLE_LINE, DEBUG_MULTILINE, DEBUG_SINGLE_LINE, ABSTRACT_TO_STRING, ABSTRACT_BUILDER_TO_STRING, ABSTRACT_MUTABLE_TO_STRING, REPORT_NONE};
            }

            static {
                REPORT_ALL = new FieldReporterLevel("REPORT_ALL", 0, 0);
                TEXT_GENERATOR = new FieldReporterLevel("TEXT_GENERATOR", 1, 1);
                PRINT = new FieldReporterLevel("PRINT", 2, 2);
                PRINTER_PRINT_TO_STRING = new FieldReporterLevel("PRINTER_PRINT_TO_STRING", 3, 3);
                TEXTFORMAT_PRINT_TO_STRING = new FieldReporterLevel("TEXTFORMAT_PRINT_TO_STRING", 4, 4);
                PRINT_UNICODE = new FieldReporterLevel("PRINT_UNICODE", 5, 5);
                SHORT_DEBUG_STRING = new FieldReporterLevel("SHORT_DEBUG_STRING", 6, 6);
                LEGACY_MULTILINE = new FieldReporterLevel("LEGACY_MULTILINE", 7, 7);
                LEGACY_SINGLE_LINE = new FieldReporterLevel("LEGACY_SINGLE_LINE", 8, 8);
                DEBUG_MULTILINE = new FieldReporterLevel("DEBUG_MULTILINE", 9, 9);
                DEBUG_SINGLE_LINE = new FieldReporterLevel("DEBUG_SINGLE_LINE", 10, 10);
                ABSTRACT_TO_STRING = new FieldReporterLevel("ABSTRACT_TO_STRING", 11, 11);
                ABSTRACT_BUILDER_TO_STRING = new FieldReporterLevel("ABSTRACT_BUILDER_TO_STRING", 12, 12);
                ABSTRACT_MUTABLE_TO_STRING = new FieldReporterLevel("ABSTRACT_MUTABLE_TO_STRING", 13, 13);
                REPORT_NONE = new FieldReporterLevel("REPORT_NONE", 14, 14);
                $VALUES = $values();
            }

            private FieldReporterLevel(String r10, int r11, int r12) {
                super(r10, r11);
                this.index = r12;
            }

            public static FieldReporterLevel valueOf(String r10) {
                return (FieldReporterLevel) java.lang.Enum.valueOf(FieldReporterLevel.class, r10);
            }

            public static FieldReporterLevel[] values() {
                return (FieldReporterLevel[]) $VALUES.clone();
            }
        }

        static class MapEntryAdapter implements Comparable<MapEntryAdapter> {
            private Object entry;
            private final Descriptors.FieldDescriptor keyField;
            private Message messageEntry;

            MapEntryAdapter(Object r10, Descriptors.FieldDescriptor r11) {
                if ((r10 instanceof Message) == false) goto L5;
                this.messageEntry = (Message) r10;
            L6:
                this.keyField = r11.getMessageType().findFieldByName("key");
                return;
            L5:
                this.entry = r10;
                goto L6
            }

            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(MapEntryAdapter r10) {
                Object r11 = getKey();
                Object r12 = r10.getKey();
                if (r11 != null) goto L6;
                if (r12 != null) goto L6;
                return 0;
            L6:
                if (r11 != null) goto L10;
                return -1;
            L10:
                if (r12 != null) goto L12;
                return 1;
            L12:
                int r13 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.keyField.getJavaType().ordinal()];
                if (r13 == 1) goto L28;
                if (r13 == 2) goto L26;
                if (r13 == 3) goto L24;
                if (r13 == 4) goto L22;
                return 0;
            L22:
                return ((String) r11).compareTo((String) r12);
            L24:
                return ((Integer) r11).compareTo((Integer) r12);
            L26:
                return ((Long) r11).compareTo((Long) r12);
            L28:
                return ((Boolean) r11).compareTo((Boolean) r12);
            }

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(MapEntryAdapter r10) {
                return compareTo2(r10);
            }

            Object getEntry() {
                Message r10 = this.messageEntry;
                if (r10 == null) goto L6;
                return r10;
            L6:
                return this.entry;
            }

            Object getKey() {
                Message r10 = this.messageEntry;
                if (r10 == null) goto L8;
                Descriptors.FieldDescriptor r11 = this.keyField;
                if (r11 != null) goto L7;
                return null;
            L7:
                return r10.getField(r11);
            L8:
                return null;
            }
        }

        static {
            DEFAULT_TEXT_FORMAT = new Printer(true, false, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), false, false);
            DEFAULT_DEBUG_FORMAT = new Printer(true, false, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), true, false);
            sensitiveFieldReportingLevel = new AnonymousClass1();
        }

        private Printer(boolean r10, boolean r11, TypeRegistry r12, ExtensionRegistryLite r13, boolean r14, boolean r15) {
            this.escapeNonAscii = r10;
            this.useShortRepeatedPrimitives = r11;
            this.typeRegistry = r12;
            this.extensionRegistry = r13;
            this.enablingSafeDebugFormat = r14;
            this.singleLine = r15;
        }

        static /* synthetic */ void access$000(UnknownFieldSet r10, TextGenerator r11, boolean r12) {
            printUnknownFields(r10, r11, r12);
        }

        static /* synthetic */ Printer access$100() {
            return DEFAULT_TEXT_FORMAT;
        }

        static /* synthetic */ Printer access$200() {
            return DEFAULT_DEBUG_FORMAT;
        }

        private void applyUnstablePrefix(Appendable r10) {
            r10.append("");     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        private void print(MessageOrBuilder r10, TextGenerator r11) {
            if (r10.getDescriptorForType().getFullName().equals("google.protobuf.Any") == true) goto L5;
        L7:
            printMessage(r10, r11);
            return;
        L5:
            if (printAny(r10, r11) == false) goto L7;
        }

        private boolean printAny(MessageOrBuilder r10, TextGenerator r11) {
            Descriptors.Descriptor r12 = r10.getDescriptorForType();
            Descriptors.FieldDescriptor r13 = r12.findFieldByNumber(1);
            Descriptors.FieldDescriptor r14 = r12.findFieldByNumber(2);
            if (r13 != null) goto L5;
        L20:
            return false;
        L5:
            if (r13.getType() != Descriptors.FieldDescriptor.Type.STRING) goto L20;
            if (r14 == null) goto L20;
            if (r14.getType() != Descriptors.FieldDescriptor.Type.BYTES) goto L20;
            String r15 = (String) r10.getField(r13);
            if (r15.isEmpty() == false) goto L13;
            return false;
        L13:
            Object r16 = r10.getField(r14);
            Descriptors.Descriptor r17 = this.typeRegistry.getDescriptorForTypeUrl(r15);     // Catch: InvalidProtocolBufferException -> L21
            if (r17 != null) goto L17;
            return false;
        L17:
            DynamicMessage.Builder r18 = DynamicMessage.getDefaultInstance(r17).newBuilderForType();     // Catch: InvalidProtocolBufferException -> L21
            r18.mergeFrom((ByteString) r16, this.extensionRegistry);     // Catch: InvalidProtocolBufferException -> L21
            r11.print("[");
            r11.print(r15);
            r11.print("] {");
            r11.eol();
            r11.indent();
            print(r18, r11);
            r11.outdent();
            r11.print("}");
            r11.eol();
            return true;
        }

        private void printField(Descriptors.FieldDescriptor r10, Object r11, TextGenerator r12) {
            if (r10.isMapField() == false) goto L13;
            ArrayList r13 = new ArrayList();
            Iterator r14 = ((List) r11).iterator();
        L6:
            if (r14.hasNext() == false) goto L8;
            r13.add(new MapEntryAdapter(r14.next(), r10));
            goto L6
        L8:
            Collections.sort(r13);
            Iterator r15 = r13.iterator();
        L10:
            if (r15.hasNext() == false) goto L29;
            printSingleField(r10, ((MapEntryAdapter) r15.next()).getEntry(), r12);
            goto L10
        L29:
            return;
        L13:
            if (r10.isRepeated() == true) goto L15;
            printSingleField(r10, r11, r12);
            return;
        L15:
            if (this.useShortRepeatedPrimitives == true) goto L17;
        L19:
            Iterator r16 = ((List) r11).iterator();
        L21:
            if (r16.hasNext() == false) goto L30;
            printSingleField(r10, r16.next(), r12);
            goto L21
        L30:
            return;
        L17:
            if (r10.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L19;
            printShortRepeatedField(r10, r11, r12);
        }

        private void printFieldValue(Descriptors.FieldDescriptor r10, Object r11, TextGenerator r12) {
            if (shouldRedact(r10, r12) == false) goto L9;
            r12.print(TextFormat.REDACTED_MARKER);
            if (r10.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L34;
            r12.eol();
            return;
        L34:
            return;
        L9:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r10.getType().ordinal()]) {
                case 1: goto L31;
                case 2: goto L31;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L30;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L26;
                case 11: goto L26;
                case 12: goto L25;
                case 13: goto L25;
                case 14: goto L20;
                case 15: goto L16;
                case 16: goto L12;
                case 17: goto L11;
                case 18: goto L11;
                default: goto L37;
            };
        L11:
            print((MessageOrBuilder) r11, r12);
            return;
        L12:
            Descriptors.EnumValueDescriptor r13 = (Descriptors.EnumValueDescriptor) r11;
            if (r13.getIndex() != (-1)) goto L15;
            String r14 = Integer.toString(r13.getNumber());
        L32:
            r12.print(r14);
            return;
        L15:
            r14 = r13.getName();
            goto L32
        L16:
            r12.print("\"");
            if ((r11 instanceof ByteString) == false) goto L19;
            String r15 = TextFormat.escapeBytes((ByteString) r11);
        L24:
            r12.print(r15);
            r12.print("\"");
            return;
        L19:
            r15 = TextFormat.escapeBytes((byte[]) r11);
            goto L24
        L20:
            r12.print("\"");
            String r16 = (String) r11;
            if (this.escapeNonAscii == false) goto L23;
            r15 = TextFormatEscaper.escapeText(r16);
            goto L24
        L23:
            r15 = TextFormat.escapeDoubleQuotesAndBackslashes(r16).replace("\n", "\\n");
            goto L24
        L25:
            r14 = TextFormat.unsignedToString(((Long) r11).longValue());
            goto L32
        L26:
            r14 = TextFormat.unsignedToString(((Integer) r11).intValue());
            goto L32
        L27:
            r14 = ((Double) r11).toString();
            goto L32
        L28:
            r14 = ((Float) r11).toString();
            goto L32
        L29:
            r14 = ((Boolean) r11).toString();
            goto L32
        L30:
            r14 = ((Long) r11).toString();
            goto L32
        L31:
            r14 = ((Integer) r11).toString();
            goto L32
        }

        private void printMessage(MessageOrBuilder r10, TextGenerator r11) {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r12 = r10.getAllFields().entrySet().iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            Map.Entry<Descriptors.FieldDescriptor, Object> r13 = r12.next();
            printField(r13.getKey(), r13.getValue(), r11);
            goto L4
        L6:
            printUnknownFields(r10.getUnknownFields(), r11, this.enablingSafeDebugFormat);
        }

        private void printShortRepeatedField(Descriptors.FieldDescriptor r10, Object r11, TextGenerator r12) {
            r12.print(r10.getName());
            r12.print(": ");
            r12.print("[");
            Iterator r13 = ((List) r11).iterator();
            String r14 = "";
        L4:
            if (r13.hasNext() == false) goto L6;
            Object r15 = r13.next();
            r12.print(r14);
            printFieldValue(r10, r15, r12);
            r14 = ", ";
            goto L4
        L6:
            r12.print("]");
            r12.eol();
        }

        private void printSingleField(Descriptors.FieldDescriptor r10, Object r11, TextGenerator r12) {
            if (r10.isExtension() == false) goto L16;
            r12.print("[");
            if (r10.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L7;
        L13:
            String r13 = r10.getFullName();
        L14:
            r12.print(r13);
            String r14 = "]";
        L19:
            r12.print(r14);
            Descriptors.FieldDescriptor.JavaType r15 = r10.getJavaType();
            Descriptors.FieldDescriptor.JavaType r16 = Descriptors.FieldDescriptor.JavaType.MESSAGE;
            if (r15 != r16) goto L22;
            r12.print(" {");
            r12.eol();
            r12.indent();
        L23:
            printFieldValue(r10, r11, r12);
            if (r10.getJavaType() != r16) goto L26;
            r12.outdent();
            r12.print("}");
        L26:
            r12.eol();
            return;
        L22:
            r12.print(": ");
            goto L23
        L7:
            if (r10.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L13;
            if (r10.isOptional() == false) goto L13;
            if (r10.getExtensionScope() != r10.getMessageType()) goto L13;
            r13 = r10.getMessageType().getFullName();
            goto L14
        L16:
            if (r10.isGroupLike() == false) goto L18;
            r14 = r10.getMessageType().getName();
            goto L19
        L18:
            r14 = r10.getName();
            goto L19
        }

        private static void printUnknownField(int r10, int r11, List<?> r12, TextGenerator r13, boolean r14) {
            Iterator<?> r15 = r12.iterator();
        L4:
            if (r15.hasNext() == false) goto L6;
            Object r16 = r15.next();
            r13.print(String.valueOf(r10));
            r13.print(": ");
            printUnknownFieldValue(r11, r16, r13, r14);
            r13.eol();
            goto L4
        }

        private static void printUnknownFieldValue(int r10, Object r11, TextGenerator r12, boolean r13) {
            int r14 = WireFormat.getTagWireType(r10);
            if (r14 != 0) goto L5;
            if (r13 == false) goto L30;
            String r15 = String.format("UNKNOWN_VARINT %s", new Object[]{TextFormat.REDACTED_MARKER});
        L31:
            r12.print(r15);
            return;
        L30:
            r15 = TextFormat.unsignedToString(((Long) r11).longValue());
            goto L31
        L5:
            if (r14 != 1) goto L7;
            Object[] r16 = new Object[1];
            if (r13 == false) goto L27;
            r16[0] = TextFormat.REDACTED_MARKER;
            r15 = String.format("UNKNOWN_FIXED64 %s", r16);
            goto L31
        L27:
            r16[0] = (Long) r11;
            r15 = String.format(null, "0x%016x", r16);
            goto L31
        L7:
            if (r14 != 2) goto L9;
            UnknownFieldSet r17 = UnknownFieldSet.parseFrom((ByteString) r11);     // Catch: InvalidProtocolBufferException -> L21
            r12.print("{");     // Catch: InvalidProtocolBufferException -> L21
            r12.eol();     // Catch: InvalidProtocolBufferException -> L21
            r12.indent();     // Catch: InvalidProtocolBufferException -> L21
            printUnknownFields(r17, r12, r13);     // Catch: InvalidProtocolBufferException -> L21
            r12.outdent();     // Catch: InvalidProtocolBufferException -> L21
            r12.print("}");     // Catch: InvalidProtocolBufferException -> L21
            return;
        L21:
            if (r13 == false) goto L23;
            r15 = String.format("UNKNOWN_STRING %s", new Object[]{TextFormat.REDACTED_MARKER});
            goto L31
        L23:
            r15 = "\"";
            r12.print("\"");
            r12.print(TextFormat.escapeBytes((ByteString) r11));
            goto L31
        L9:
            if (r14 != 3) goto L11;
            printUnknownFields((UnknownFieldSet) r11, r12, r13);
            return;
        L11:
            if (r14 != 5) goto L17;
            Object[] r18 = new Object[1];
            if (r13 == false) goto L15;
            r18[0] = TextFormat.REDACTED_MARKER;
            r15 = String.format("UNKNOWN_FIXED32 %s", r18);
            goto L31
        L15:
            r18[0] = (Integer) r11;
            r15 = String.format(null, "0x%08x", r18);
            goto L31
        L17:
            throw new IllegalArgumentException("Bad tag: " + r10);
        }

        private static void printUnknownFields(UnknownFieldSet r10, TextGenerator r11, boolean r12) {
            if (r10.isEmpty() == false) goto L5;
            return;
        L5:
            Iterator<Map.Entry<Integer, UnknownFieldSet.Field>> r13 = r10.asMap().entrySet().iterator();
        L7:
            if (r13.hasNext() == false) goto L12;
            Map.Entry<Integer, UnknownFieldSet.Field> r14 = r13.next();
            int r15 = r14.getKey().intValue();
            UnknownFieldSet.Field r16 = r14.getValue();
            printUnknownField(r15, 0, r16.getVarintList(), r11, r12);
            printUnknownField(r15, 5, r16.getFixed32List(), r11, r12);
            printUnknownField(r15, 1, r16.getFixed64List(), r11, r12);
            printUnknownField(r15, 2, r16.getLengthDelimitedList(), r11, r12);
            Iterator<UnknownFieldSet> r17 = r16.getGroupList().iterator();
        L10:
            if (r17.hasNext() == false) goto L7;
            UnknownFieldSet r18 = r17.next();
            r11.print(r14.getKey().toString());
            r11.print(" {");
            r11.eol();
            r11.indent();
            printUnknownFields(r18, r11, r12);
            r11.outdent();
            r11.print("}");
            r11.eol();
            goto L10
        }

        private boolean shouldRedact(Descriptors.FieldDescriptor r10, TextGenerator r11) {
            if (this.enablingSafeDebugFormat == true) goto L5;
        L7:
            return false;
        L5:
            if (r10.isSensitive() == false) goto L7;
            return true;
        }

        public Printer emittingSingleLine(boolean r10) {
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, r10);
        }

        Printer enablingSafeDebugFormat(boolean r10) {
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, r10, this.singleLine);
        }

        public Printer escapingNonAscii(boolean r10) {
            return new Printer(r10, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
        }

        public void print(MessageOrBuilder r10, Appendable r11) {
            print(r10, r11, FieldReporterLevel.PRINT);
        }

        void print(MessageOrBuilder r10, Appendable r11, FieldReporterLevel r12) {
            print(r10, TextFormat.access$300(r11, this.singleLine, r10.getDescriptorForType(), r12));
        }

        public void print(UnknownFieldSet r10, Appendable r11) {
            printUnknownFields(r10, TextFormat.access$400(r11, this.singleLine), this.enablingSafeDebugFormat);
        }

        public void printField(Descriptors.FieldDescriptor r10, Object r11, Appendable r12) {
            printField(r10, r11, TextFormat.access$400(r12, this.singleLine));
        }

        public String printFieldToString(Descriptors.FieldDescriptor r10, Object r11) {
            StringBuilder r12 = new StringBuilder();     // Catch: IOException -> L7
            if (this.enablingSafeDebugFormat == false) goto L5;
            applyUnstablePrefix(r12);     // Catch: IOException -> L7
        L5:
            printField(r10, r11, r12);     // Catch: IOException -> L7
            return r12.toString();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        public void printFieldValue(Descriptors.FieldDescriptor r10, Object r11, Appendable r12) {
            printFieldValue(r10, r11, TextFormat.access$400(r12, this.singleLine));
        }

        public String printToString(MessageOrBuilder r10) {
            return printToString(r10, FieldReporterLevel.PRINTER_PRINT_TO_STRING);
        }

        String printToString(MessageOrBuilder r10, FieldReporterLevel r11) {
            StringBuilder r12 = new StringBuilder();     // Catch: IOException -> L7
            if (this.enablingSafeDebugFormat == false) goto L5;
            applyUnstablePrefix(r12);     // Catch: IOException -> L7
        L5:
            print(r10, r12, r11);     // Catch: IOException -> L7
            return r12.toString();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        public String printToString(UnknownFieldSet r10) {
            StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L7
            if (this.enablingSafeDebugFormat == false) goto L5;
            applyUnstablePrefix(r11);     // Catch: IOException -> L7
        L5:
            print(r10, r11);     // Catch: IOException -> L7
            return r11.toString();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        void setSensitiveFieldReportingLevel(FieldReporterLevel r10) {
            sensitiveFieldReportingLevel.set(r10);
        }

        @InlineMe(replacement = "this.emittingSingleLine(true).printFieldToString(field, value)")
        @Deprecated
        public String shortDebugString(Descriptors.FieldDescriptor r10, Object r11) {
            return emittingSingleLine(true).printFieldToString(r10, r11);
        }

        @Deprecated
        public String shortDebugString(MessageOrBuilder r10) {
            return emittingSingleLine(true).printToString(r10, FieldReporterLevel.SHORT_DEBUG_STRING);
        }

        @InlineMe(replacement = "this.emittingSingleLine(true).printToString(fields)")
        @Deprecated
        public String shortDebugString(UnknownFieldSet r10) {
            return emittingSingleLine(true).printToString(r10);
        }

        public Printer usingExtensionRegistry(ExtensionRegistryLite r10) {
            if (this.extensionRegistry != ExtensionRegistryLite.getEmptyRegistry()) goto L7;
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, this.typeRegistry, r10, this.enablingSafeDebugFormat, this.singleLine);
        L7:
            throw new IllegalArgumentException("Only one extensionRegistry is allowed.");
        }

        public Printer usingShortRepeatedPrimitives(boolean r10) {
            return new Printer(this.escapeNonAscii, r10, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
        }

        public Printer usingTypeRegistry(TypeRegistry r10) {
            if (this.typeRegistry != TypeRegistry.getEmptyTypeRegistry()) goto L7;
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, r10, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
        L7:
            throw new IllegalArgumentException("Only one typeRegistry is allowed.");
        }
    }

    private static final class TextGenerator {
        private boolean atStartOfLine;
        private final Printer.FieldReporterLevel fieldReporterLevel;
        private final StringBuilder indent;
        private final Appendable output;
        private final Descriptors.Descriptor rootMessageType;
        private final boolean singleLineMode;

        private TextGenerator(Appendable r10, boolean r11, Descriptors.Descriptor r12, Printer.FieldReporterLevel r13) {
            this.indent = new StringBuilder();
            this.atStartOfLine = false;
            this.output = r10;
            this.singleLineMode = r11;
            this.rootMessageType = r12;
            this.fieldReporterLevel = r13;
        }

        /* synthetic */ TextGenerator(Appendable r10, boolean r11, Descriptors.Descriptor r12, Printer.FieldReporterLevel r13, AnonymousClass1 r14) {
            this(r10, r11, r12, r13);
        }

        public void eol() {
            if (this.singleLineMode == true) goto L5;
            this.output.append("\n");
        L5:
            this.atStartOfLine = true;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int r10 = this.indent.length();
            if (r10 == 0) goto L7;
            this.indent.setLength(r10 - 2);
            return;
        L7:
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void print(CharSequence r10) {
            if (this.atStartOfLine == false) goto L9;
            this.atStartOfLine = false;
            Appendable r11 = this.output;
            if (this.singleLineMode == false) goto L7;
            CharSequence r12 = " ";
        L8:
            r11.append(r12);
            goto L9
        L7:
            r12 = this.indent;
        L9:
            this.output.append(r10);
        }
    }

    private static final class Tokenizer {
        private int column;
        private boolean containsSilentMarkerAfterCurrentToken;
        private boolean containsSilentMarkerAfterPrevToken;
        private String currentToken;
        private int line;
        private int lineInfoTrackingPos;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;

        private Tokenizer(CharSequence r10) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.lineInfoTrackingPos = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.containsSilentMarkerAfterCurrentToken = false;
            this.containsSilentMarkerAfterPrevToken = false;
            this.text = r10;
            skipWhitespace();
            nextToken();
        }

        /* synthetic */ Tokenizer(CharSequence r10, AnonymousClass1 r11) {
            this(r10);
        }

        static /* synthetic */ String access$900(Tokenizer r10) {
            return r10.currentToken;
        }

        private void consumeByteString(List<ByteString> r10) {
            char r11 = 0;
            if (this.currentToken.length() <= 0) goto L6;
            r11 = this.currentToken.charAt(0);
        L6:
            if (r11 == '\"') goto L13;
            if (r11 == '\'') goto L13;
            throw parseException("Expected string.");
        L13:
            if (this.currentToken.length() < 2) goto L22;
            String r12 = this.currentToken;
            if (r12.charAt(r12.length() - 1) != r11) goto L22;
            String r13 = this.currentToken;     // Catch: InvalidEscapeSequenceException -> L18
            ByteString r14 = TextFormat.unescapeBytes(r13.substring(1, r13.length() - 1));     // Catch: InvalidEscapeSequenceException -> L18
            nextToken();     // Catch: InvalidEscapeSequenceException -> L18
            r10.add(r14);     // Catch: InvalidEscapeSequenceException -> L18
            return;
        L18:
            e = move-exception;
            throw parseException(e.getMessage());
        L22:
            throw parseException("String missing ending quote.");
        }

        private ParseException floatParseException(NumberFormatException r10) {
            return parseException("Couldn't parse number: " + r10.getMessage());
        }

        private ParseException integerParseException(NumberFormatException r10) {
            return parseException("Couldn't parse integer: " + r10.getMessage());
        }

        private static boolean isAlphaUnder(char r10) {
            if ('a' > r10) goto L7;
            if (r10 > 'z') goto L7;
        L12:
            return true;
        L7:
            if ('A' > r10) goto L11;
            if (r10 <= 'Z') goto L12;
        L11:
            if (r10 == '_') goto L12;
            return false;
        }

        private static boolean isDigitPlusMinus(char r10) {
            if ('0' > r10) goto L7;
            if (r10 > '9') goto L7;
        L12:
            return true;
        L7:
            if (r10 == '+') goto L12;
            if (r10 == '-') goto L12;
            return false;
        }

        private static boolean isWhitespace(char r10) {
            if (r10 != ' ') goto L5;
        L14:
            return true;
        L5:
            if (r10 == '\f') goto L14;
            if (r10 == '\n') goto L14;
            if (r10 == '\r') goto L14;
            if (r10 == '\t') goto L14;
            return false;
        }

        private String nextTokenInternal() {
            int r10 = this.text.length();
            int r11 = this.pos;
            char r12 = this.text.charAt(r11);
            int r13 = this.pos;
            if (isAlphaUnder(r12) == false) goto L12;
        L4:
            r13 = r13 + 1;
            if (r13 == r10) goto L54;
            char r14 = this.text.charAt(r13);
            if (isAlphaUnder(r14) == true) goto L4;
            if (isDigitPlusMinus(r14) == true) goto L4;
        L54:
            this.pos = r13;
            return this.text.subSequence(r11, r13).toString();
        L12:
            if (isDigitPlusMinus(r12) == true) goto L38;
            if (r12 == '.') goto L38;
            if (r12 == '\"') goto L22;
            if (r12 == '\'') goto L22;
            return nextTokenSingleChar();
        L22:
            r13 = r13 + 1;
            if (r13 == r10) goto L54;
            char r15 = this.text.charAt(r13);
            if (r15 == r12) goto L26;
            if (r15 == '\n') goto L54;
            if (r15 != '\\') goto L22;
            r13 = r13 + 1;
            if (r13 == r10) goto L54;
            if (this.text.charAt(r13) != '\n') goto L22;
        L26:
            r13 = r13 + 1;
        L38:
            if (r12 != '.') goto L47;
            r13 = r13 + 1;
            if (r13 != r10) goto L44;
            return nextTokenSingleChar();
        L44:
            if (isDigitPlusMinus(this.text.charAt(r13)) == true) goto L47;
            return nextTokenSingleChar();
        L47:
            r13 = r13 + 1;
            if (r13 == r10) goto L54;
            char r16 = this.text.charAt(r13);
            if (isDigitPlusMinus(r16) == true) goto L47;
            if (isAlphaUnder(r16) == true) goto L47;
            if (r16 == '.') goto L47;
            goto L54
        }

        private String nextTokenSingleChar() {
            CharSequence r10 = this.text;
            int r11 = this.pos;
            this.pos = r11 + 1;
            char r12 = r10.charAt(r11);
            if (r12 != ',') goto L5;
            return ",";
        L5:
            if (r12 != ':') goto L7;
            return ":";
        L7:
            if (r12 != '<') goto L9;
            return "<";
        L9:
            if (r12 != '>') goto L11;
            return ">";
        L11:
            if (r12 != '[') goto L13;
            return "[";
        L13:
            if (r12 != ']') goto L15;
            return "]";
        L15:
            if (r12 != '{') goto L17;
            return "{";
        L17:
            if (r12 != '}') goto L19;
            return "}";
        L19:
            return String.valueOf(r12);
        }

        private void skipWhitespace() {
            int r10 = this.text.length();
            int r11 = this.pos - 1;
        L3:
            r11 = r11 + 1;
            if (r11 == r10) goto L16;
            char r12 = this.text.charAt(r11);
            if (r12 == '#') goto L7;
            if (isWhitespace(r12) == false) goto L16;
        L7:
            r11 = r11 + 1;
            if (r11 == r10) goto L11;
            if (this.text.charAt(r11) != '\n') goto L7;
        L11:
            if (r11 != r10) goto L3;
        L16:
            this.pos = r11;
        }

        boolean atEnd() {
            if (this.currentToken.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        void consume(String r10) {
            if (tryConsume(r10) == false) goto L6;
            return;
        L6:
            throw parseException("Expected \"" + r10 + "\".");
        }

        public boolean consumeBoolean() {
            if (this.currentToken.equals("true") == false) goto L5;
        L24:
            nextToken();
            return true;
        L5:
            if (this.currentToken.equals("True") == true) goto L24;
            if (this.currentToken.equals("t") == true) goto L24;
            if (this.currentToken.equals(NetConst.ENCRYPT_VERISON_CODE) == true) goto L24;
            if (this.currentToken.equals("false") == false) goto L14;
        L22:
            nextToken();
            return false;
        L14:
            if (this.currentToken.equals("False") == true) goto L22;
            if (this.currentToken.equals("f") == true) goto L22;
            if (this.currentToken.equals(NetConst.NOT_ENCRYPT_VERISON_CODE) == true) goto L22;
            throw parseException("Expected \"true\" or \"false\". Found \"" + this.currentToken + "\".");
        }

        @CanIgnoreReturnValue
        ByteString consumeByteString() {
            ArrayList r10 = new ArrayList();
        L3:
            consumeByteString(r10);
            if (this.currentToken.startsWith("'") == true) goto L3;
            if (this.currentToken.startsWith("\"") == true) goto L3;
            return ByteString.copyFrom(r10);
        }

        public double consumeDouble() {
            String r10 = this.currentToken.toLowerCase(Locale.ROOT);
            r10.hashCode();
            byte r11 = -1;
            switch(r10.hashCode()) {
                case 104417: goto L22;
                case 108827: goto L18;
                case 1445012: goto L14;
                case 173173288: goto L10;
                case 442101077: goto L6;
                default: goto L25;
            };
        L25:
            switch(r11) {
                case 0: goto L35;
                case 1: goto L33;
                case 2: goto L31;
                case 3: goto L35;
                case 4: goto L31;
                default: goto L37;
            };
        L31:
            nextToken();
            return Double.NEGATIVE_INFINITY;
        L33:
            nextToken();
            return Double.NaN;
        L35:
            nextToken();
            return Double.POSITIVE_INFINITY;
        L37:
            double r12 = Double.parseDouble(this.currentToken);     // Catch: NumberFormatException -> L28
            nextToken();     // Catch: NumberFormatException -> L28
            return r12;
        L28:
            e = move-exception;
            throw floatParseException(e);
        L6:
            if (r10.equals("-infinity") == false) goto L25;
            r11 = 4;
            goto L25
        L10:
            if (r10.equals("infinity") == false) goto L25;
            r11 = 3;
            goto L25
        L14:
            if (r10.equals("-inf") == false) goto L25;
            r11 = 2;
            goto L25
        L18:
            if (r10.equals("nan") == false) goto L25;
            r11 = 1;
            goto L25
        L22:
            if (r10.equals("inf") == false) goto L25;
            r11 = 0;
            goto L25
        }

        public float consumeFloat() {
            String r10 = this.currentToken.toLowerCase(Locale.ROOT);
            r10.hashCode();
            byte r11 = -1;
            switch(r10.hashCode()) {
                case 104417: goto L42;
                case 108827: goto L38;
                case 1445012: goto L34;
                case 3237029: goto L30;
                case 3373739: goto L26;
                case 44795474: goto L22;
                case 173173288: goto L18;
                case 442101077: goto L14;
                case 820231601: goto L10;
                case 1073404734: goto L6;
                default: goto L45;
            };
        L45:
            switch(r11) {
                case 0: goto L55;
                case 1: goto L53;
                case 2: goto L51;
                case 3: goto L55;
                case 4: goto L53;
                case 5: goto L51;
                case 6: goto L55;
                case 7: goto L51;
                case 8: goto L51;
                case 9: goto L55;
                default: goto L57;
            };
        L51:
            nextToken();
            return Float.NEGATIVE_INFINITY;
        L53:
            nextToken();
            return Float.NaN;
        L55:
            nextToken();
            return Float.POSITIVE_INFINITY;
        L57:
            float r12 = Float.parseFloat(this.currentToken);     // Catch: NumberFormatException -> L48
            nextToken();     // Catch: NumberFormatException -> L48
            return r12;
        L48:
            e = move-exception;
            throw floatParseException(e);
        L6:
            if (r10.equals("infinityf") == false) goto L45;
            r11 = 9;
            goto L45
        L10:
            if (r10.equals("-infinityf") == false) goto L45;
            r11 = 8;
            goto L45
        L14:
            if (r10.equals("-infinity") == false) goto L45;
            r11 = 7;
            goto L45
        L18:
            if (r10.equals("infinity") == false) goto L45;
            r11 = 6;
            goto L45
        L22:
            if (r10.equals("-inff") == false) goto L45;
            r11 = 5;
            goto L45
        L26:
            if (r10.equals("nanf") == false) goto L45;
            r11 = 4;
            goto L45
        L30:
            if (r10.equals("inff") == false) goto L45;
            r11 = 3;
            goto L45
        L34:
            if (r10.equals("-inf") == false) goto L45;
            r11 = 2;
            goto L45
        L38:
            if (r10.equals("nan") == false) goto L45;
            r11 = 1;
            goto L45
        L42:
            if (r10.equals("inf") == false) goto L45;
            r11 = 0;
            goto L45
        }

        String consumeIdentifier() {
            int r10 = 0;
        L4:
            if (r10 >= this.currentToken.length()) goto L17;
            char r11 = this.currentToken.charAt(r10);
            if (isAlphaUnder(r11) == true) goto L16;
            if ('0' > r11) goto L12;
            if (r11 <= '9') goto L16;
        L12:
            if (r11 == '.') goto L16;
            throw parseException("Expected identifier. Found '" + this.currentToken + "'");
        L16:
            r10 = r10 + 1;
            goto L4
        L17:
            String r12 = this.currentToken;
            nextToken();
            return r12;
        }

        int consumeInt32() {
            int r10 = TextFormat.parseInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r10;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        long consumeInt64() {
            long r10 = TextFormat.parseInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r10;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public String consumeString() {
            return consumeByteString().toStringUtf8();
        }

        int consumeUInt32() {
            int r10 = TextFormat.parseUInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r10;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        long consumeUInt64() {
            long r10 = TextFormat.parseUInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r10;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        int getColumn() {
            return this.column;
        }

        boolean getContainsSilentMarkerAfterCurrentToken() {
            return this.containsSilentMarkerAfterCurrentToken;
        }

        boolean getContainsSilentMarkerAfterPrevToken() {
            return this.containsSilentMarkerAfterPrevToken;
        }

        int getLine() {
            return this.line;
        }

        int getPreviousColumn() {
            return this.previousColumn;
        }

        int getPreviousLine() {
            return this.previousLine;
        }

        boolean lookingAt(String r10) {
            return this.currentToken.equals(r10);
        }

        boolean lookingAtInteger() {
            if (this.currentToken.length() != 0) goto L6;
            return false;
        L6:
            return isDigitPlusMinus(this.currentToken.charAt(0));
        }

        void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
        L3:
            int r10 = this.lineInfoTrackingPos;
            int r11 = this.pos;
            if (r10 >= r11) goto L11;
            if (this.text.charAt(r10) != '\n') goto L8;
            this.line++;
            int r12 = 0;
        L9:
            this.column = r12;
            this.lineInfoTrackingPos++;
            goto L3
        L8:
            r12 = this.column + 1;
            goto L9
        L11:
            if (r11 != this.text.length()) goto L13;
            this.currentToken = "";
            return;
        L13:
            this.currentToken = nextTokenInternal();
            skipWhitespace();
        }

        ParseException parseException(String r10) {
            return new ParseException(this.line + 1, this.column + 1, r10);
        }

        ParseException parseExceptionPreviousToken(String r10) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, r10);
        }

        boolean tryConsume(String r10) {
            if (this.currentToken.equals(r10) == false) goto L6;
            nextToken();
            return true;
        L6:
            return false;
        }

        boolean tryConsumeByteString() {
            consumeByteString();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeDouble() {
            consumeDouble();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeFloat() {
            consumeFloat();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        boolean tryConsumeIdentifier() {
            consumeIdentifier();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        boolean tryConsumeInt64() {
            consumeInt64();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeUInt64() {
            consumeUInt64();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }
    }

    @Deprecated
    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(int r10, int r11, String r12, String r13) {
            super(r10, r11, r13);
            this.unknownField = r12;
        }

        public UnknownFieldParseException(String r10) {
            this(-1, -1, "", r10);
        }

        public String getUnknownField() {
            return this.unknownField;
        }
    }

    static {
        logger = Logger.getLogger(TextFormat.class.getName());
        PARSER = Parser.newBuilder().build();
    }

    private TextFormat() {
    }

    static /* synthetic */ TextGenerator access$300(Appendable r10, boolean r11, Descriptors.Descriptor r12, Printer.FieldReporterLevel r13) {
        return setSingleLineOutput(r10, r11, r12, r13);
    }

    static /* synthetic */ TextGenerator access$400(Appendable r10, boolean r11) {
        return setSingleLineOutput(r10, r11);
    }

    static /* synthetic */ Logger access$700() {
        return logger;
    }

    public static Printer debugFormatPrinter() {
        return Printer.access$200();
    }

    private static int digitValue(byte r10) {
        if (48 > r10) goto L9;
        if (r10 > 57) goto L9;
        return r10 - 48;
    L9:
        if (97 <= r10) goto L11;
    L15:
        int r11 = r10 - 65;
    L14:
        return r11 + 10;
    L11:
        if (r10 > 122) goto L15;
        r11 = r10 - 97;
        goto L14
    }

    public static String escapeBytes(ByteString r10) {
        return TextFormatEscaper.escapeBytes(r10);
    }

    public static String escapeBytes(byte[] r10) {
        return TextFormatEscaper.escapeBytes(r10);
    }

    public static String escapeDoubleQuotesAndBackslashes(String r10) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(r10);
    }

    static String escapeText(String r10) {
        return escapeBytes(ByteString.copyFromUtf8(r10));
    }

    public static Parser getParser() {
        return PARSER;
    }

    private static boolean isHex(byte r10) {
        if (48 > r10) goto L7;
        if (r10 > 57) goto L7;
    L14:
        return true;
    L7:
        if (97 > r10) goto L11;
        if (r10 <= 102) goto L14;
    L11:
        if (65 <= r10) goto L13;
    L15:
        return false;
    L13:
        if (r10 > 70) goto L15;
        goto L14
    }

    private static boolean isOctal(byte r10) {
        if (48 <= r10) goto L5;
    L7:
        return false;
    L5:
        if (r10 > 55) goto L7;
        return true;
    }

    public static void merge(CharSequence r10, ExtensionRegistry r11, Message.Builder r12) {
        PARSER.merge(r10, r11, r12);
    }

    public static void merge(CharSequence r10, Message.Builder r11) {
        PARSER.merge(r10, r11);
    }

    public static void merge(Readable r10, ExtensionRegistry r11, Message.Builder r12) {
        PARSER.merge(r10, r11, r12);
    }

    public static void merge(Readable r10, Message.Builder r11) {
        PARSER.merge(r10, r11);
    }

    public static <T extends Message> T parse(CharSequence r10, ExtensionRegistry r11, Class<T> r12) {
        Message.Builder r13 = ((Message) Internal.getDefaultInstance(r12)).newBuilderForType();
        merge(r10, r11, r13);
        return (T) r13.build();
    }

    public static <T extends Message> T parse(CharSequence r10, Class<T> r11) {
        Message.Builder r12 = ((Message) Internal.getDefaultInstance(r11)).newBuilderForType();
        merge(r10, r12);
        return (T) r12.build();
    }

    static int parseInt32(String r10) {
        return (int) parseInteger(r10, true, false);
    }

    static long parseInt64(String r10) {
        return parseInteger(r10, true, true);
    }

    private static long parseInteger(String r10, boolean r11, boolean r12) {
        int r13 = 0;
        boolean r14 = true;
        if (r10.startsWith("-", 0) == false) goto L8;
        if (r11 == false) goto L7;
        r13 = 1;
    L9:
        int r15 = 10;
        if (r10.startsWith("0x", r13) == false) goto L13;
        r13 = r13 + 2;
        r15 = 16;
    L15:
        String r16 = r10.substring(r13);
        if (r16.length() >= 16) goto L36;
        long r17 = Long.parseLong(r16, r15);
        if (r14 == false) goto L20;
        r17 = -r17;
    L20:
        if (r12 == true) goto L63;
        if (r11 == false) goto L30;
        if (r17 > 2147483647L) goto L28;
        if (r17 < (-2147483648L)) goto L28;
        return r17;
    L28:
        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + r10);
    L30:
        if (r17 >= 4294967296L) goto L35;
        if (r17 < 0) goto L35;
        return r17;
    L35:
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + r10);
    L63:
        return r17;
    L36:
        BigInteger r18 = new BigInteger(r16, r15);
        if (r14 == false) goto L39;
        r18 = r18.negate();
    L39:
        if (r12 == true) goto L51;
        if (r11 == false) goto L47;
        if (r18.bitLength() <= 31) goto L60;
        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + r10);
    L60:
        return r18.longValue();
    L47:
        if (r18.bitLength() <= 32) goto L60;
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + r10);
    L51:
        if (r11 == false) goto L58;
        if (r18.bitLength() <= 63) goto L60;
        throw new NumberFormatException("Number out of range for 64-bit signed integer: " + r10);
    L58:
        if (r18.bitLength() <= 64) goto L60;
        throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + r10);
    L13:
        if (r10.startsWith(NetConst.NOT_ENCRYPT_VERISON_CODE, r13) == false) goto L15;
        r15 = 8;
        goto L15
    L7:
        throw new NumberFormatException("Number must be positive: " + r10);
    L8:
        r14 = false;
        goto L9
    }

    static int parseUInt32(String r10) {
        return (int) parseInteger(r10, false, false);
    }

    static long parseUInt64(String r10) {
        return parseInteger(r10, false, true);
    }

    private static void printUnknownFieldValue(int r10, Object r11, TextGenerator r12, boolean r13) {
        int r14 = WireFormat.getTagWireType(r10);
        if (r14 != 0) goto L5;
        String r15 = unsignedToString(((Long) r11).longValue());
    L21:
        r12.print(r15);
        return;
    L5:
        if (r14 != 1) goto L7;
        r15 = String.format(null, "0x%016x", new Object[]{(Long) r11});
        goto L21
    L7:
        if (r14 != 2) goto L9;
        UnknownFieldSet r16 = UnknownFieldSet.parseFrom((ByteString) r11);     // Catch: InvalidProtocolBufferException -> L18
        r12.print("{");     // Catch: InvalidProtocolBufferException -> L18
        r12.eol();     // Catch: InvalidProtocolBufferException -> L18
        r12.indent();     // Catch: InvalidProtocolBufferException -> L18
        Printer.access$000(r16, r12, r13);     // Catch: InvalidProtocolBufferException -> L18
        r12.outdent();     // Catch: InvalidProtocolBufferException -> L18
        r12.print("}");     // Catch: InvalidProtocolBufferException -> L18
        return;
    L18:
        r15 = "\"";
        r12.print("\"");
        r12.print(escapeBytes((ByteString) r11));
        goto L21
    L9:
        if (r14 != 3) goto L11;
        Printer.access$000((UnknownFieldSet) r11, r12, r13);
        return;
    L11:
        if (r14 != 5) goto L14;
        r15 = String.format(null, "0x%08x", new Object[]{(Integer) r11});
        goto L21
    L14:
        throw new IllegalArgumentException("Bad tag: " + r10);
    }

    public static void printUnknownFieldValue(int r10, Object r11, Appendable r12) {
        printUnknownFieldValue(r10, r11, setSingleLineOutput(r12, false), false);
    }

    public static Printer printer() {
        return Printer.access$100();
    }

    private static TextGenerator setSingleLineOutput(Appendable r10, boolean r11) {
        Descriptors.Descriptor r12 = null;
        return new TextGenerator(r10, r11, r12, Printer.FieldReporterLevel.TEXT_GENERATOR, null);
    }

    private static TextGenerator setSingleLineOutput(Appendable r10, boolean r11, Descriptors.Descriptor r12, Printer.FieldReporterLevel r13) {
        return new TextGenerator(r10, r11, r12, r13, null);
    }

    @Deprecated
    public static String shortDebugString(MessageOrBuilder r10) {
        return printer().emittingSingleLine(true).printToString(r10, Printer.FieldReporterLevel.SHORT_DEBUG_STRING);
    }

    public static ByteString unescapeBytes(CharSequence r12) {
        ByteString r13 = ByteString.copyFromUtf8(r12.toString());
        int r10 = r13.size();
        byte[] r11 = new byte[r10];
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r14 >= r13.size()) goto L124;
        byte r16 = r13.byteAt(r14);
        if (r16 != 92) goto L121;
        r14 = r14 + 1;
        if (r14 >= r13.size()) goto L120;
        byte r17 = r13.byteAt(r14);
        if (isOctal(r17) == false) goto L23;
        int r18 = digitValue(r17);
        int r19 = r14 + 1;
        if (r19 < r13.size()) goto L14;
    L16:
        int r20 = r14 + 1;
        if (r20 < r13.size()) goto L19;
    L21:
        int r21 = r15 + 1;
        r11[r15] = (byte) r18;
    L122:
        r15 = r21;
    L123:
        r14 = r14 + 1;
        goto L4
    L19:
        if (isOctal(r13.byteAt(r20)) == false) goto L21;
        r18 = (r18 * 8) + digitValue(r13.byteAt(r20));
        r14 = r20;
        goto L21
    L14:
        if (isOctal(r13.byteAt(r19)) == false) goto L16;
        r18 = (r18 * 8) + digitValue(r13.byteAt(r19));
        r14 = r19;
        goto L16
    L23:
        if (r17 != 34) goto L25;
        int r22 = r15 + 1;
        r11[r15] = 34;
    L118:
        r15 = r22;
        goto L123
    L25:
        if (r17 != 39) goto L27;
        r22 = r15 + 1;
        r11[r15] = 39;
        goto L118
    L27:
        if (r17 != 63) goto L29;
        r22 = r15 + 1;
        r11[r15] = 63;
        goto L118
    L29:
        if (r17 == 85) goto L86;
        if (r17 != 92) goto L32;
        r22 = r15 + 1;
        r11[r15] = 92;
        goto L118
    L32:
        if (r17 != 102) goto L34;
        r22 = r15 + 1;
        r11[r15] = 12;
        goto L118
    L34:
        if (r17 != 110) goto L36;
        r22 = r15 + 1;
        r11[r15] = 10;
        goto L118
    L36:
        if (r17 != 114) goto L38;
        r22 = r15 + 1;
        r11[r15] = 13;
        goto L118
    L38:
        if (r17 != 120) goto L40;
        r14 = r14 + 1;
        if (r14 >= r13.size()) goto L81;
        if (isHex(r13.byteAt(r14)) == false) goto L81;
        int r23 = digitValue(r13.byteAt(r14));
        int r24 = r14 + 1;
        if (r24 < r13.size()) goto L77;
    L79:
        r21 = r15 + 1;
        r11[r15] = (byte) r23;
        goto L122
    L77:
        if (isHex(r13.byteAt(r24)) == false) goto L79;
        r23 = (r23 * 16) + digitValue(r13.byteAt(r24));
        r14 = r24;
    L81:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
    L40:
        if (r17 != 97) goto L42;
        r22 = r15 + 1;
        r11[r15] = 7;
        goto L118
    L42:
        if (r17 == 98) goto L68;
        switch(r17) {
            case 116: goto L67;
            case 117: goto L47;
            case 118: goto L46;
            default: goto L45;
        };
    L46:
        r22 = r15 + 1;
        r11[r15] = 11;
        goto L118
    L47:
        int r25 = r14 + 1;
        int r26 = r25 + 3;
        if (r26 >= r13.size()) goto L66;
        if (isHex(r13.byteAt(r25)) == false) goto L66;
        int r27 = r25 + 1;
        if (isHex(r13.byteAt(r27)) == false) goto L66;
        int r28 = r25 + 2;
        if (isHex(r13.byteAt(r28)) == false) goto L66;
        if (isHex(r13.byteAt(r26)) == false) goto L66;
        char r29 = (char) ((((digitValue(r13.byteAt(r25)) << 12) | (digitValue(r13.byteAt(r27)) << 8)) | (digitValue(r13.byteAt(r28)) << 4)) | digitValue(r13.byteAt(r26)));
        if (r29 >= 55296) goto L60;
    L64:
        byte[] r30 = Character.toString(r29).getBytes(Internal.UTF_8);
        System.arraycopy(r30, 0, r11, r15, r30.length);
        int r31 = r30.length;
    L110:
        r15 = r15 + r31;
        r14 = r26;
        goto L123
    L60:
        if (r29 > 57343) goto L64;
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' refers to a surrogate");
    L66:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' with too few hex chars");
    L67:
        r22 = r15 + 1;
        r11[r15] = 9;
        goto L118
    L45:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) r17) + '\'');
    L68:
        r22 = r15 + 1;
        r11[r15] = 8;
        goto L118
    L86:
        int r32 = r14 + 1;
        r26 = r32 + 7;
        if (r26 >= r13.size()) goto L114;
        int r33 = 0;
        int r34 = r32;
    L89:
        int r110 = r32 + 8;
        if (r34 >= r110) goto L97;
        byte r111 = r13.byteAt(r34);
        if (isHex(r111) == false) goto L95;
        r33 = (r33 << 4) | digitValue(r111);
        r34 = r34 + 1;
        goto L89
    L95:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
    L97:
        if (Character.isValidCodePoint(r33) == false) goto L112;
        Character.UnicodeBlock r35 = Character.UnicodeBlock.of(r33);
        if (r35 != null) goto L101;
    L109:
        byte[] r36 = new String(new int[]{r33}, 0, 1).getBytes(Internal.UTF_8);
        System.arraycopy(r36, 0, r11, r15, r36.length);
        r31 = r36.length;
        goto L110
    L101:
        if (r35.equals(Character.UnicodeBlock.LOW_SURROGATES) == true) goto L108;
        if (r35.equals(Character.UnicodeBlock.HIGH_SURROGATES) == true) goto L108;
        if (r35.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES) == false) goto L109;
    L108:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + r13.substring(r32, r110).toStringUtf8() + "' refers to a surrogate code unit");
    L112:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + r13.substring(r32, r110).toStringUtf8() + "' is not a valid code point value");
    L114:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
    L120:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
    L121:
        r21 = r15 + 1;
        r11[r15] = r16;
        goto L122
    L124:
        if (r10 != r15) goto L127;
        return ByteString.wrap(r11);
    L127:
        return ByteString.copyFrom(r11, 0, r15);
    }

    static String unescapeText(String r10) {
        return unescapeBytes(r10).toStringUtf8();
    }

    public static String unsignedToString(int r10) {
        if (r10 < 0) goto L6;
        return Integer.toString(r10);
    L6:
        return Long.toString(((long) r10) & 4294967295L);
    }

    public static String unsignedToString(long r10) {
        if (r10 < 0) goto L7;
        return Long.toString(r10);
    L7:
        return BigInteger.valueOf(r10 & Long.MAX_VALUE).setBit(63).toString();
    }
}
