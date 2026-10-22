package com.google.protobuf;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.qualcomm.qti.qesdk.QesdkUtils;
import com.sdk.bwdl.StateMachine.BWDLDataStructure;
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

/* JADX INFO: loaded from: classes.dex */
public final class TextFormat {
    private static final String DEBUG_STRING_SILENT_MARKER = " \t ";
    private static final boolean ENABLE_INSERT_SILENT_MARKER = false;
    private static final String ENABLE_INSERT_SILENT_MARKER_ENV_NAME = "SILENT_MARKER_INSERTION_ENABLED";
    private static final Parser PARSER = null;
    private static final String REDACTED_MARKER = "[REDACTED]";
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r8 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r8;
            r8[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
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
            int[] r10 = new int[Descriptors.FieldDescriptor.JavaType.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType = r10;
            r10[Descriptors.FieldDescriptor.JavaType.BOOLEAN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L48
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

        public InvalidEscapeSequenceException(String r8) {
            super(r8);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(int r8, int r10, String r11) {
            super(Integer.toString(r8) + BdimCategoryConstants.SEPARATOR_COLON + r10 + ": " + r11);
            this.line = r8;
            this.column = r10;
        }

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }

        public ParseException(String r8) {
            this(-1, -1, r8);
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

            public Builder setAllowUnknownExtensions(boolean r8) {
                this.allowUnknownExtensions = r8;
                return this;
            }

            public Builder setAllowUnknownFields(boolean r8) {
                this.allowUnknownFields = r8;
                return this;
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder r8) {
                this.parseInfoTreeBuilder = r8;
                return this;
            }

            public Builder setRecursionLimit(int r8) {
                this.recursionLimit = r8;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy r8) {
                this.singularOverwritePolicy = r8;
                return this;
            }

            public Builder setTypeRegistry(TypeRegistry r8) {
                this.typeRegistry = r8;
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

            private SingularOverwritePolicy(String r8, int r10) {
                super(r8, r10);
            }

            public static SingularOverwritePolicy valueOf(String r8) {
                return (SingularOverwritePolicy) java.lang.Enum.valueOf(SingularOverwritePolicy.class, r8);
            }

            public static SingularOverwritePolicy[] values() {
                return (SingularOverwritePolicy[]) $VALUES.clone();
            }
        }

        public static final class UnknownField {
            final String message;
            final Type type;

            public static final enum Type extends java.lang.Enum<Type> {
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

                private Type(String r8, int r10) {
                    super(r8, r10);
                }

                public static Type valueOf(String r8) {
                    return (Type) java.lang.Enum.valueOf(Type.class, r8);
                }

                public static Type[] values() {
                    return (Type[]) $VALUES.clone();
                }
            }

            public UnknownField(String r8, Type r10) {
                this.message = r8;
                this.type = r10;
            }
        }

        private Parser(TypeRegistry r8, boolean r10, boolean r11, boolean r12, SingularOverwritePolicy r13, TextFormatParseInfoTree.Builder r14, int r15) {
            this.typeRegistry = r8;
            this.allowUnknownFields = r10;
            this.allowUnknownEnumValues = r11;
            this.allowUnknownExtensions = r12;
            this.singularOverwritePolicy = r13;
            this.parseInfoTreeBuilder = r14;
            this.recursionLimit = r15;
        }

        private void checkUnknownFields(List<UnknownField> r8) {
            if (r8.isEmpty() == false) goto L5;
            return;
        L5:
            StringBuilder r10 = new StringBuilder("Input contains unknown fields and/or extensions:");
            Iterator<UnknownField> r11 = r8.iterator();
        L7:
            if (r11.hasNext() == false) goto L10;
            UnknownField r12 = r11.next();
            r10.append('\n');
            r10.append(r12.message);
            goto L7
        L10:
            if (this.allowUnknownFields == false) goto L14;
        L11:
            TextFormat.access$900().warning(r10.toString());
            return;
        L14:
            if (this.allowUnknownExtensions == false) goto L25;
            Iterator<UnknownField> r13 = r8.iterator();
            int r14 = 0;
        L17:
            if (r13.hasNext() == false) goto L22;
            if (r13.next().type == UnknownField.Type.FIELD) goto L20;
            r14 = r14 + 1;
            goto L17
        L20:
            boolean r15 = false;
        L23:
            if (r15 == true) goto L11;
        L26:
            String[] r16 = r8.get(r14).message.split(BdimCategoryConstants.SEPARATOR_COLON);
            throw new ParseException(Integer.parseInt(r16[0]), Integer.parseInt(r16[1]), r10.toString());
        L22:
            r15 = true;
            goto L23
        L25:
            r14 = 0;
            goto L26
        }

        private void consumeFieldValue(Tokenizer r16, ExtensionRegistry r17, MessageReflection.MergeTarget r18, Descriptors.FieldDescriptor r19, ExtensionRegistry.ExtensionInfo r20, TextFormatParseInfoTree.Builder r21, List<UnknownField> r22, int r23) {
            if (this.singularOverwritePolicy == SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES) goto L5;
        L17:
            Object r8 = null;
            Message r10 = null;
            if (r19.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L41;
            if (r23 < 1) goto L39;
            if (r16.tryConsume("<") == false) goto L24;
            String r11 = ">";
        L25:
            String r13 = r11;
            if (r20 == null) goto L29;
            r10 = r20.defaultInstance;
        L29:
            MessageReflection.MergeTarget r14 = r18.newMergeTargetForField(r19, r10);
        L31:
            if (r16.tryConsume(r13) == true) goto L37;
            if (r16.atEnd() == true) goto L36;
            mergeField(r16, r17, r14, r21, r22, r23 - 1);
            goto L31
        L36:
            throw r16.parseException(defpackage.b.d("Expected \"", r13, "\"."));
        L37:
            r8 = r14.finish();
        L78:
            if (r19.isRepeated() == false) goto L80;
            r18.addRepeatedField(r19, r8);
            return;
        L80:
            r18.setField(r19, r8);
            return;
        L24:
            r16.consume("{");
            r11 = "}";
            goto L25
        L39:
            throw r16.parseException("Message is nested too deep");
        L41:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r19.getType().ordinal()]) {
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
            Descriptors.EnumDescriptor r12 = r19.getEnumType();
            if (r16.lookingAtInteger() == false) goto L58;
            int r15 = r16.consumeInt32();
            if (r12.isClosed() == false) goto L50;
            r8 = r12.findValueByNumber(r15);
        L51:
            if (r8 != null) goto L78;
            String r24 = "Enum type \"" + r12.getFullName() + "\" has no value with number " + r15 + '.';
            if (this.allowUnknownEnumValues == false) goto L57;
            TextFormat.access$900().warning(r24);
            return;
        L57:
            throw r16.parseExceptionPreviousToken("Enum type \"" + r12.getFullName() + "\" has no value with number " + r15 + '.');
        L50:
            r8 = r12.findValueByNumberCreatingIfUnknown(r15);
            goto L51
        L58:
            String r25 = r16.consumeIdentifier();
            r8 = r12.findValueByName(r25);
            if (r8 != null) goto L78;
            String r26 = "Enum type \"" + r12.getFullName() + "\" has no value named \"" + r25 + "\".";
            if (this.allowUnknownEnumValues == false) goto L65;
            TextFormat.access$900().warning(r26);
            return;
        L65:
            throw r16.parseExceptionPreviousToken(r26);
        L66:
            r8 = r16.consumeByteString();
            goto L78
        L67:
            r8 = r16.consumeString();
            goto L78
        L68:
            long r27 = r16.consumeUInt64();
        L74:
            r8 = Long.valueOf(r27);
            goto L78
        L69:
            int r28 = r16.consumeUInt32();
        L76:
            r8 = Integer.valueOf(r28);
            goto L78
        L70:
            r8 = Double.valueOf(r16.consumeDouble());
            goto L78
        L71:
            r8 = Float.valueOf(r16.consumeFloat());
            goto L78
        L72:
            r8 = Boolean.valueOf(r16.consumeBoolean());
            goto L78
        L73:
            r27 = r16.consumeInt64();
            goto L74
        L75:
            r28 = r16.consumeInt32();
            goto L76
        L44:
            throw new RuntimeException("Can't get here.");
        L5:
            if (r19.isRepeated() == true) goto L17;
            if (r18.hasField(r19) == true) goto L16;
            if (r19.getContainingOneof() == null) goto L17;
            if (r18.hasOneof(r19.getContainingOneof()) == false) goto L17;
            Descriptors.OneofDescriptor r29 = r19.getContainingOneof();
            throw r16.parseExceptionPreviousToken("Field \"" + r19.getFullName() + "\" is specified along with field \"" + r18.getOneofFieldDescriptor(r29).getFullName() + "\", another member of oneof \"" + r29.getName() + "\".");
        L16:
            throw r16.parseExceptionPreviousToken("Non-repeated field \"" + r19.getFullName() + "\" cannot be overwritten.");
        }

        private void consumeFieldValues(Tokenizer r8, ExtensionRegistry r10, MessageReflection.MergeTarget r11, Descriptors.FieldDescriptor r12, ExtensionRegistry.ExtensionInfo r13, TextFormatParseInfoTree.Builder r14, List<UnknownField> r15, int r16) {
            if (r12.isRepeated() == true) goto L5;
        L12:
            consumeFieldValue(r8, r10, r11, r12, r13, r14, r15, r16);
            return;
        L5:
            if (r8.tryConsume("[") == false) goto L12;
            if (r8.tryConsume("]") == true) goto L15;
        L8:
            consumeFieldValue(r8, r10, r11, r12, r13, r14, r15, r16);
            if (r8.tryConsume("]") == true) goto L16;
            r8.consume(",");
            goto L8
        L16:
            return;
        }

        private String consumeFullTypeName(Tokenizer r8) {
            if (r8.tryConsume("[") == false) goto L5;
            String r10 = r8.consumeIdentifier();
        L8:
            if (r8.tryConsume(".") == false) goto L11;
            StringBuilder r11 = android.aimedia.a.k(r10, ".");
            r11.append(r8.consumeIdentifier());
            r10 = r11.toString();
            goto L8
        L11:
            if (r8.tryConsume("/") == false) goto L16;
            StringBuilder r12 = android.aimedia.a.k(r10, "/");
        L13:
            r12.append(r8.consumeIdentifier());
            r10 = r12.toString();
            if (r8.tryConsume(".") == false) goto L16;
            r12 = android.aimedia.a.k(r10, ".");
        L16:
            r8.consume("]");
            return r10;
        L5:
            return r8.consumeIdentifier();
        }

        private void detectSilentMarker(Tokenizer r8, Descriptors.Descriptor r10, String r11) {
        }

        private void guessFieldTypeAndSkip(Tokenizer r8, Descriptors.Descriptor r10, int r11) {
            boolean r12 = r8.tryConsume(BdimCategoryConstants.SEPARATOR_COLON);
            if (r8.lookingAt("[") == false) goto L5;
            skipFieldShortFormedRepeated(r8, r12, r10, r11);
            return;
        L5:
            if (r12 == false) goto L12;
            if (r8.lookingAt("{") == true) goto L12;
            if (r8.lookingAt("<") == true) goto L12;
            skipFieldValue(r8);
            return;
        L12:
            if (r11 < 1) goto L16;
            skipFieldMessage(r8, r10, r11 - 1);
            return;
        L16:
            throw r8.parseException("Message is nested too deep");
        }

        private void mergeAnyFieldValue(Tokenizer r16, ExtensionRegistry r17, MessageReflection.MergeTarget r18, TextFormatParseInfoTree.Builder r19, List<UnknownField> r20, Descriptors.Descriptor r21, int r22) {
            StringBuilder r11 = new StringBuilder();
        L3:
            r11.append(r16.consumeIdentifier());
            if (r16.tryConsume("]") == true) goto L5;
            String r8 = "/";
            if (r16.tryConsume("/") == true) goto L27;
            r8 = ".";
            if (r16.tryConsume(".") == true) goto L27;
            throw r16.parseExceptionPreviousToken("Expected a valid type URL.");
        L27:
            r11.append(r8);
            goto L3
        L5:
            detectSilentMarker(r16, r21, r11.toString());
            r16.tryConsume(BdimCategoryConstants.SEPARATOR_COLON);
            if (r16.tryConsume("<") == false) goto L8;
            String r10 = ">";
        L9:
            String r12 = r10;
            String r13 = r11.toString();
            Descriptors.Descriptor r14 = this.typeRegistry.getDescriptorForTypeUrl(r13);     // Catch: InvalidProtocolBufferException -> L20
            if (r14 == null) goto L19;
            DynamicMessage.Builder r15 = DynamicMessage.getDefaultInstance(r14).newBuilderForType();
            MessageReflection.BuilderAdapter r110 = new MessageReflection.BuilderAdapter(r15);
        L14:
            if (r16.tryConsume(r12) == true) goto L16;
            mergeField(r16, r17, r110, r19, r20, r22);
            goto L14
        L16:
            r18.setField(r21.findFieldByName("type_url"), r11.toString());
            r18.setField(r21.findFieldByName("value"), r15.build().toByteString());
            return;
        L19:
            throw r16.parseException(defpackage.b.d("Unable to parse Any of type: ", r13, ". Please make sure that the TypeRegistry contains the descriptors for the given types."));
        L21:
            throw r16.parseException(defpackage.b.c("Invalid valid type URL. Found: ", r13));
        L8:
            r16.consume("{");
            r10 = "}";
            goto L9
        }

        private void mergeField(Tokenizer r18, ExtensionRegistry r19, MessageReflection.MergeTarget r20, TextFormatParseInfoTree.Builder r21, List<UnknownField> r22, int r23) {
            int r11 = r18.getLine();
            int r12 = r18.getColumn();
            Descriptors.Descriptor r8 = r20.getDescriptorForType();
            if ("google.protobuf.Any".equals(r8.getFullName()) == false) goto L12;
            if (r18.tryConsume("[") == false) goto L12;
            if (r23 < 1) goto L10;
            mergeAnyFieldValue(r18, r19, r20, r21, r22, r8, r23 - 1);
            return;
        L10:
            throw r18.parseException("Message is nested too deep");
        L12:
            if (r18.tryConsume("[") == false) goto L26;
            StringBuilder r10 = new StringBuilder(r18.consumeIdentifier());
        L15:
            if (r18.tryConsume(".") == false) goto L17;
            r10.append('.');
            r10.append(r18.consumeIdentifier());
            goto L15
        L17:
            String r13 = r10.toString();
            ExtensionRegistry.ExtensionInfo r14 = r20.findExtensionByName(r19, r13);
            if (r14 != null) goto L21;
            r22.add(new UnknownField((r18.getPreviousLine() + 1) + BdimCategoryConstants.SEPARATOR_COLON + (r18.getPreviousColumn() + 1) + ":\t" + r8.getFullName() + ".[" + r13 + "]", UnknownField.Type.EXTENSION));
            Descriptors.FieldDescriptor r15 = null;
        L23:
            r18.consume("]");
            Descriptors.FieldDescriptor r16 = r15;
            ExtensionRegistry.ExtensionInfo r17 = r14;
        L40:
            if (r16 != null) goto L44;
            detectSilentMarker(r18, r8, r13);
            guessFieldTypeAndSkip(r18, r8, r23);
            return;
        L44:
            if (r16.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L48;
            detectSilentMarker(r18, r8, r16.getFullName());
            r18.tryConsume(BdimCategoryConstants.SEPARATOR_COLON);
            if (r21 == null) goto L49;
            TextFormatParseInfoTree.Builder r24 = r21.getBuilderForSubMessageField(r16);
        L50:
            consumeFieldValues(r18, r19, r20, r16, r17, r24, r22, r23);
            if (r21 == null) goto L54;
            r21.setLocation(r16, TextFormatParseLocation.create(r11, r12));
        L54:
            if (r18.tryConsume(";") == true) goto L58;
            r18.tryConsume(",");
            return;
        L58:
            return;
        L49:
            r24 = r21;
            goto L50
        L48:
            detectSilentMarker(r18, r8, r16.getFullName());
            r18.consume(BdimCategoryConstants.SEPARATOR_COLON);
            goto L49
        L21:
            if (r14.descriptor.getContainingType() != r8) goto L24;
            r15 = r14.descriptor;
            goto L23
        L24:
            StringBuilder r25 = defpackage.b.h("Extension \"", r13, "\" does not extend message type \"");
            r25.append(r8.getFullName());
            r25.append("\".");
            throw r18.parseExceptionPreviousToken(r25.toString());
        L26:
            r13 = r18.consumeIdentifier();
            Descriptors.FieldDescriptor r26 = r8.findFieldByName(r13);
            if (r26 != null) goto L37;
            r26 = r8.findFieldByName(r13.toLowerCase(Locale.US));
            if (r26 != null) goto L31;
        L33:
            if (r26 == null) goto L37;
            if (r26.getMessageType().getName().equals(r13) == true) goto L37;
            r26 = null;
            goto L37
        L31:
            if (r26.isGroupLike() == true) goto L33;
            r26 = null;
        L37:
            if (r26 != null) goto L39;
            r22.add(new UnknownField((r18.getPreviousLine() + 1) + BdimCategoryConstants.SEPARATOR_COLON + (r18.getPreviousColumn() + 1) + ":\t" + r8.getFullName() + "." + r13, UnknownField.Type.FIELD));
        L39:
            r16 = r26;
            r17 = null;
            goto L40
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private void skipField(Tokenizer r8, Descriptors.Descriptor r10, int r11) {
            detectSilentMarker(r8, r10, consumeFullTypeName(r8));
            guessFieldTypeAndSkip(r8, r10, r11);
            if (r8.tryConsume(";") == true) goto L6;
            r8.tryConsume(",");
            return;
        }

        private void skipFieldMessage(Tokenizer r8, Descriptors.Descriptor r10, int r11) {
            if (r8.tryConsume("<") == false) goto L5;
            String r12 = ">";
        L7:
            if (r8.lookingAt(">") == true) goto L11;
            if (r8.lookingAt("}") == true) goto L11;
            skipField(r8, r10, r11);
        L11:
            r8.consume(r12);
            return;
        L5:
            r8.consume("{");
            r12 = "}";
            goto L7
        }

        private void skipFieldShortFormedRepeated(Tokenizer r8, boolean r10, Descriptors.Descriptor r11, int r12) {
            if (r8.tryConsume("[") == true) goto L5;
            return;
        L5:
            if (r8.tryConsume("]") == false) goto L8;
            return;
        L8:
            if (r8.lookingAt("{") == true) goto L17;
            if (r8.lookingAt("<") == true) goto L17;
            if (r10 == false) goto L15;
            skipFieldValue(r8);
        L20:
            if (r8.tryConsume("]") == true) goto L21;
            r8.consume(",");
            goto L8
        L21:
            return;
        L15:
            throw r8.parseException("Invalid repeated scalar field: missing \":\" before \"[\".");
        L17:
            if (r12 < 1) goto L24;
            skipFieldMessage(r8, r11, r12 - 1);
            goto L20
        L24:
            throw r8.parseException("Message is nested too deep");
        }

        private void skipFieldValue(Tokenizer r8) {
            if (r8.tryConsumeByteString() == false) goto L5;
            return;
        L5:
            if (r8.tryConsumeIdentifier() == false) goto L7;
            return;
        L7:
            if (r8.tryConsumeInt64() == false) goto L9;
            return;
        L9:
            if (r8.tryConsumeUInt64() == false) goto L11;
            return;
        L11:
            if (r8.tryConsumeDouble() == false) goto L13;
            return;
        L13:
            if (r8.tryConsumeFloat() == false) goto L16;
            return;
        L16:
            throw r8.parseException("Invalid field value: " + Tokenizer.access$1100(r8));
        }

        private static StringBuilder toStringBuilder(Readable r8) {
            StringBuilder r10 = new StringBuilder();
            CharBuffer r11 = CharBuffer.allocate(4096);
        L3:
            int r12 = r8.read(r11);
            if (r12 == (-1)) goto L5;
            Java8Compatibility.flip(r11);
            r10.append(r11, 0, r12);
            goto L3
        L5:
            return r10;
        }

        public void merge(CharSequence r8, ExtensionRegistry r10, Message.Builder r11) {
            Tokenizer r12 = new Tokenizer(r8, null);
            MessageReflection.BuilderAdapter r13 = new MessageReflection.BuilderAdapter(r11);
            ArrayList r14 = new ArrayList();
        L4:
            if (r12.atEnd() == true) goto L6;
            mergeField(r12, r10, r13, r14, this.recursionLimit);
            goto L4
        L6:
            checkUnknownFields(r14);
        }

        public /* synthetic */ Parser(TypeRegistry r8, boolean r10, boolean r11, boolean r12, SingularOverwritePolicy r13, TextFormatParseInfoTree.Builder r14, int r15, AnonymousClass1 r16) {
            this(r8, r10, r11, r12, r13, r14, r15);
        }

        public void merge(CharSequence r8, Message.Builder r10) {
            merge(r8, ExtensionRegistry.getEmptyRegistry(), r10);
        }

        public void merge(Readable r8, ExtensionRegistry r10, Message.Builder r11) {
            merge(toStringBuilder(r8), r10, r11);
        }

        public void merge(Readable r8, Message.Builder r10) {
            merge(r8, ExtensionRegistry.getEmptyRegistry(), r10);
        }

        private void mergeField(Tokenizer r8, ExtensionRegistry r10, MessageReflection.MergeTarget r11, List<UnknownField> r12, int r13) {
            mergeField(r8, r10, r11, this.parseInfoTreeBuilder, r12, r13);
        }
    }

    public static final class Printer {
        private static final Printer DEFAULT_DEBUG_FORMAT = null;
        private static final Printer DEFAULT_FORMAT = null;
        private static final Printer DEFAULT_TEXT_FORMAT = null;
        private static final ThreadLocal<FieldReporterLevel> sensitiveFieldReportingLevel = null;
        private final boolean enablingSafeDebugFormat;
        private final boolean escapeNonAscii;
        private final ExtensionRegistryLite extensionRegistry;
        private boolean insertSilentMarker;
        private final boolean singleLine;
        private final TypeRegistry typeRegistry;
        private final boolean useShortRepeatedPrimitives;

        public static final enum FieldReporterLevel extends java.lang.Enum<FieldReporterLevel> {
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

            private FieldReporterLevel(String r8, int r10, int r11) {
                super(r8, r10);
                this.index = r11;
            }

            public static FieldReporterLevel valueOf(String r8) {
                return (FieldReporterLevel) java.lang.Enum.valueOf(FieldReporterLevel.class, r8);
            }

            public static FieldReporterLevel[] values() {
                return (FieldReporterLevel[]) $VALUES.clone();
            }
        }

        public static class MapEntryAdapter implements Comparable<MapEntryAdapter> {
            private Object entry;
            private final Descriptors.FieldDescriptor keyField;
            private Message messageEntry;

            public MapEntryAdapter(Object r8, Descriptors.FieldDescriptor r10) {
                if ((r8 instanceof Message) == false) goto L5;
                this.messageEntry = (Message) r8;
            L6:
                this.keyField = r10.getMessageType().findFieldByName("key");
                return;
            L5:
                this.entry = r8;
                goto L6
            }

            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(MapEntryAdapter r8) {
                Object r10 = getKey();
                Object r11 = r8.getKey();
                if (r10 != null) goto L6;
                if (r11 != null) goto L6;
                return 0;
            L6:
                if (r10 != null) goto L10;
                return -1;
            L10:
                if (r11 != null) goto L12;
                return 1;
            L12:
                int r12 = AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$JavaType[this.keyField.getJavaType().ordinal()];
                if (r12 == 1) goto L28;
                if (r12 == 2) goto L26;
                if (r12 == 3) goto L24;
                if (r12 == 4) goto L22;
                return 0;
            L22:
                return ((String) r10).compareTo((String) r11);
            L24:
                return ((Integer) r10).compareTo((Integer) r11);
            L26:
                return ((Long) r10).compareTo((Long) r11);
            L28:
                return ((Boolean) r10).compareTo((Boolean) r11);
            }

            public Object getEntry() {
                Message r8 = this.messageEntry;
                if (r8 == null) goto L6;
                return r8;
            L6:
                return this.entry;
            }

            public Object getKey() {
                Message r8 = this.messageEntry;
                if (r8 == null) goto L8;
                Descriptors.FieldDescriptor r10 = this.keyField;
                if (r10 != null) goto L7;
                return null;
            L7:
                return r8.getField(r10);
            L8:
                return null;
            }

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(MapEntryAdapter r8) {
                return compareTo2(r8);
            }
        }

        static {
            DEFAULT_TEXT_FORMAT = new Printer(true, false, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), false, false);
            DEFAULT_DEBUG_FORMAT = new Printer(true, false, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), true, false);
            DEFAULT_FORMAT = new Printer(true, false, TypeRegistry.getEmptyTypeRegistry(), ExtensionRegistryLite.getEmptyRegistry(), false, false).setInsertSilentMarker(TextFormat.access$400());
            sensitiveFieldReportingLevel = new AnonymousClass1();
        }

        private Printer(boolean r8, boolean r10, TypeRegistry r11, ExtensionRegistryLite r12, boolean r13, boolean r14) {
            this.escapeNonAscii = r8;
            this.useShortRepeatedPrimitives = r10;
            this.typeRegistry = r11;
            this.extensionRegistry = r12;
            this.enablingSafeDebugFormat = r13;
            this.singleLine = r14;
            this.insertSilentMarker = false;
        }

        public static /* synthetic */ void access$000(UnknownFieldSet r8, TextGenerator r10, boolean r11) {
            printUnknownFields(r8, r10, r11);
        }

        public static /* synthetic */ Printer access$100() {
            return DEFAULT_TEXT_FORMAT;
        }

        public static /* synthetic */ Printer access$200() {
            return DEFAULT_DEBUG_FORMAT;
        }

        public static /* synthetic */ Printer access$300() {
            return DEFAULT_FORMAT;
        }

        private void applyUnstablePrefix(Appendable r8) {
            r8.append("");     // Catch: IOException -> L4
            return;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        public static Printer getOutputModePrinter() {
            if (ProtobufToStringOutput.isDefaultFormat() == false) goto L7;
            return TextFormat.defaultFormatPrinter();
        L7:
            if (ProtobufToStringOutput.shouldOutputDebugFormat() == false) goto L11;
            return TextFormat.debugFormatPrinter();
        L11:
            return TextFormat.printer();
        }

        private void print(MessageOrBuilder r8, TextGenerator r10) {
            if (r8.getDescriptorForType().getFullName().equals("google.protobuf.Any") == true) goto L5;
        L7:
            printMessage(r8, r10);
            return;
        L5:
            if (printAny(r8, r10) == false) goto L7;
        }

        private boolean printAny(MessageOrBuilder r8, TextGenerator r10) {
            Descriptors.Descriptor r11 = r8.getDescriptorForType();
            Descriptors.FieldDescriptor r12 = r11.findFieldByNumber(1);
            Descriptors.FieldDescriptor r13 = r11.findFieldByNumber(2);
            if (r12 != null) goto L5;
        L20:
            return false;
        L5:
            if (r12.getType() != Descriptors.FieldDescriptor.Type.STRING) goto L20;
            if (r13 == null) goto L20;
            if (r13.getType() != Descriptors.FieldDescriptor.Type.BYTES) goto L20;
            String r14 = (String) r8.getField(r12);
            if (r14.isEmpty() == false) goto L13;
            return false;
        L13:
            Object r15 = r8.getField(r13);
            Descriptors.Descriptor r16 = this.typeRegistry.getDescriptorForTypeUrl(r14);     // Catch: InvalidProtocolBufferException -> L21
            if (r16 != null) goto L17;
            return false;
        L17:
            DynamicMessage.Builder r17 = DynamicMessage.getDefaultInstance(r16).newBuilderForType();     // Catch: InvalidProtocolBufferException -> L21
            r17.mergeFrom((ByteString) r15, this.extensionRegistry);     // Catch: InvalidProtocolBufferException -> L21
            r10.print("[");
            r10.print(r14);
            r10.print("]");
            r10.maybePrintSilentMarker();
            r10.print("{");
            r10.eol();
            r10.indent();
            print(r17, r10);
            r10.outdent();
            r10.print("}");
            r10.eol();
            return true;
        }

        private void printField(Descriptors.FieldDescriptor r8, Object r10, TextGenerator r11) {
            if (r8.isMapField() == false) goto L13;
            ArrayList r12 = new ArrayList();
            Iterator r13 = ((List) r10).iterator();
        L6:
            if (r13.hasNext() == false) goto L8;
            r12.add(new MapEntryAdapter(r13.next(), r8));
            goto L6
        L8:
            Collections.sort(r12);
            Iterator r14 = r12.iterator();
        L10:
            if (r14.hasNext() == false) goto L29;
            printSingleField(r8, ((MapEntryAdapter) r14.next()).getEntry(), r11);
            goto L10
        L29:
            return;
        L13:
            if (r8.isRepeated() == true) goto L15;
            printSingleField(r8, r10, r11);
            return;
        L15:
            if (this.useShortRepeatedPrimitives == true) goto L17;
        L19:
            Iterator r15 = ((List) r10).iterator();
        L21:
            if (r15.hasNext() == false) goto L30;
            printSingleField(r8, r15.next(), r11);
            goto L21
        L30:
            return;
        L17:
            if (r8.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L19;
            printShortRepeatedField(r8, r10, r11);
        }

        private void printFieldValue(Descriptors.FieldDescriptor r8, Object r10, TextGenerator r11) {
            if (shouldRedact(r8, r11) == false) goto L9;
            r11.print(TextFormat.REDACTED_MARKER);
            if (r8.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L34;
            r11.eol();
            return;
        L34:
            return;
        L9:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r8.getType().ordinal()]) {
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
            print((MessageOrBuilder) r10, r11);
            return;
        L12:
            Descriptors.EnumValueDescriptor r12 = (Descriptors.EnumValueDescriptor) r10;
            if (r12.getIndex() != (-1)) goto L15;
            String r13 = Integer.toString(r12.getNumber());
        L32:
            r11.print(r13);
            return;
        L15:
            r13 = r12.getName();
            goto L32
        L16:
            r11.print("\"");
            if ((r10 instanceof ByteString) == false) goto L19;
            String r14 = TextFormat.escapeBytes((ByteString) r10);
        L24:
            r11.print(r14);
            r11.print("\"");
            return;
        L19:
            r14 = TextFormat.escapeBytes((byte[]) r10);
            goto L24
        L20:
            r11.print("\"");
            String r15 = (String) r10;
            if (this.escapeNonAscii == false) goto L23;
            r14 = TextFormatEscaper.escapeText(r15);
            goto L24
        L23:
            r14 = TextFormat.escapeDoubleQuotesAndBackslashes(r15).replace("\n", "\\n");
            goto L24
        L25:
            r13 = TextFormat.unsignedToString(((Long) r10).longValue());
            goto L32
        L26:
            r13 = TextFormat.unsignedToString(((Integer) r10).intValue());
            goto L32
        L27:
            r13 = ((Double) r10).toString();
            goto L32
        L28:
            r13 = ((Float) r10).toString();
            goto L32
        L29:
            r13 = ((Boolean) r10).toString();
            goto L32
        L30:
            r13 = ((Long) r10).toString();
            goto L32
        L31:
            r13 = ((Integer) r10).toString();
            goto L32
        }

        private void printMessage(MessageOrBuilder r8, TextGenerator r10) {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r11 = r8.getAllFields().entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<Descriptors.FieldDescriptor, Object> r12 = r11.next();
            printField(r12.getKey(), r12.getValue(), r10);
            goto L4
        L6:
            printUnknownFields(r8.getUnknownFields(), r10, this.enablingSafeDebugFormat);
        }

        private void printShortRepeatedField(Descriptors.FieldDescriptor r8, Object r10, TextGenerator r11) {
            r11.print(r8.getName());
            r11.print(": ");
            r11.print("[");
            Iterator r12 = ((List) r10).iterator();
            String r13 = "";
        L4:
            if (r12.hasNext() == false) goto L6;
            Object r14 = r12.next();
            r11.print(r13);
            printFieldValue(r8, r14, r11);
            r13 = ", ";
            goto L4
        L6:
            r11.print("]");
            r11.eol();
        }

        private void printSingleField(Descriptors.FieldDescriptor r8, Object r10, TextGenerator r11) {
            if (r8.isExtension() == false) goto L16;
            r11.print("[");
            if (r8.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L7;
        L13:
            String r12 = r8.getFullName();
        L14:
            r11.print(r12);
            String r13 = "]";
        L19:
            r11.print(r13);
            Descriptors.FieldDescriptor.JavaType r14 = r8.getJavaType();
            Descriptors.FieldDescriptor.JavaType r15 = Descriptors.FieldDescriptor.JavaType.MESSAGE;
            if (r14 != r15) goto L22;
            r11.maybePrintSilentMarker();
            r11.print("{");
            r11.eol();
            r11.indent();
        L23:
            printFieldValue(r8, r10, r11);
            if (r8.getJavaType() != r15) goto L26;
            r11.outdent();
            r11.print("}");
        L26:
            r11.eol();
            return;
        L22:
            r11.print(BdimCategoryConstants.SEPARATOR_COLON);
            r11.maybePrintSilentMarker();
            goto L23
        L7:
            if (r8.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L13;
            if (r8.isOptional() == false) goto L13;
            if (r8.getExtensionScope() != r8.getMessageType()) goto L13;
            r12 = r8.getMessageType().getFullName();
            goto L14
        L16:
            if (r8.isGroupLike() == false) goto L18;
            r13 = r8.getMessageType().getName();
            goto L19
        L18:
            r13 = r8.getName();
            goto L19
        }

        private static void printUnknownField(int r8, int r10, List<?> r11, TextGenerator r12, boolean r13) {
            Iterator<?> r14 = r11.iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            Object r15 = r14.next();
            r12.print(String.valueOf(r8));
            r12.print(BdimCategoryConstants.SEPARATOR_COLON);
            r12.maybePrintSilentMarker();
            printUnknownFieldValue(r10, r15, r12, r13);
            r12.eol();
            goto L4
        }

        private static void printUnknownFieldValue(int r8, Object r10, TextGenerator r11, boolean r12) {
            int r13 = WireFormat.getTagWireType(r8);
            if (r13 != 0) goto L5;
            if (r12 == false) goto L28;
            String r14 = String.format("UNKNOWN_VARINT %s", new Object[]{TextFormat.REDACTED_MARKER});
        L29:
            r11.print(r14);
            return;
        L28:
            r14 = TextFormat.unsignedToString(((Long) r10).longValue());
            goto L29
        L5:
            if (r13 != 1) goto L7;
            if (r12 == false) goto L25;
            r14 = String.format("UNKNOWN_FIXED64 %s", new Object[]{TextFormat.REDACTED_MARKER});
            goto L29
        L25:
            r14 = String.format(null, "0x%016x", new Object[]{(Long) r10});
            goto L29
        L7:
            if (r13 != 2) goto L9;
            UnknownFieldSet r15 = UnknownFieldSet.parseFrom((ByteString) r10);     // Catch: InvalidProtocolBufferException -> L20
            r11.print("{");     // Catch: InvalidProtocolBufferException -> L20
            r11.eol();     // Catch: InvalidProtocolBufferException -> L20
            r11.indent();     // Catch: InvalidProtocolBufferException -> L20
            printUnknownFields(r15, r11, r12);     // Catch: InvalidProtocolBufferException -> L20
            r11.outdent();     // Catch: InvalidProtocolBufferException -> L20
            r11.print("}");     // Catch: InvalidProtocolBufferException -> L20
            return;
        L20:
            if (r12 == false) goto L22;
            r14 = String.format("UNKNOWN_STRING %s", new Object[]{TextFormat.REDACTED_MARKER});
            goto L29
        L22:
            r14 = "\"";
            r11.print("\"");
            r11.print(TextFormat.escapeBytes((ByteString) r10));
            goto L29
        L9:
            if (r13 != 3) goto L11;
            printUnknownFields((UnknownFieldSet) r10, r11, r12);
            return;
        L11:
            if (r13 != 5) goto L16;
            if (r12 == false) goto L14;
            r14 = String.format("UNKNOWN_FIXED32 %s", new Object[]{TextFormat.REDACTED_MARKER});
            goto L29
        L14:
            r14 = String.format(null, "0x%08x", new Object[]{(Integer) r10});
            goto L29
        L16:
            throw new IllegalArgumentException(defpackage.a.d("Bad tag: ", r8));
        }

        private static void printUnknownFields(UnknownFieldSet r8, TextGenerator r10, boolean r11) {
            if (r8.isEmpty() == false) goto L5;
            return;
        L5:
            Iterator<Map.Entry<Integer, UnknownFieldSet.Field>> r12 = r8.asMap().entrySet().iterator();
        L7:
            if (r12.hasNext() == false) goto L12;
            Map.Entry<Integer, UnknownFieldSet.Field> r13 = r12.next();
            int r14 = r13.getKey().intValue();
            UnknownFieldSet.Field r15 = r13.getValue();
            printUnknownField(r14, 0, r15.getVarintList(), r10, r11);
            printUnknownField(r14, 5, r15.getFixed32List(), r10, r11);
            printUnknownField(r14, 1, r15.getFixed64List(), r10, r11);
            printUnknownField(r14, 2, r15.getLengthDelimitedList(), r10, r11);
            Iterator<UnknownFieldSet> r16 = r15.getGroupList().iterator();
        L10:
            if (r16.hasNext() == false) goto L7;
            UnknownFieldSet r17 = r16.next();
            r10.print(r13.getKey().toString());
            r10.maybePrintSilentMarker();
            r10.print("{");
            r10.eol();
            r10.indent();
            printUnknownFields(r17, r10, r11);
            r10.outdent();
            r10.print("}");
            r10.eol();
            goto L10
        }

        @CanIgnoreReturnValue
        private Printer setInsertSilentMarker(boolean r8) {
            this.insertSilentMarker = r8;
            return this;
        }

        private boolean shouldRedact(Descriptors.FieldDescriptor r8, TextGenerator r10) {
            Descriptors.FieldDescriptor.RedactionState r11 = r8.getRedactionState();
            if (this.enablingSafeDebugFormat == true) goto L5;
        L7:
            return false;
        L5:
            if (r11.redact == false) goto L7;
            return true;
        }

        public Printer emittingSingleLine(boolean r10) {
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, r10);
        }

        public Printer enablingSafeDebugFormat(boolean r10) {
            return new Printer(this.escapeNonAscii, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, r10, this.singleLine);
        }

        public Printer escapingNonAscii(boolean r10) {
            return new Printer(r10, this.useShortRepeatedPrimitives, this.typeRegistry, this.extensionRegistry, this.enablingSafeDebugFormat, this.singleLine);
        }

        public String printFieldToString(Descriptors.FieldDescriptor r8, Object r10) {
            StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L7
            if (this.enablingSafeDebugFormat == false) goto L5;
            applyUnstablePrefix(r11);     // Catch: IOException -> L7
        L5:
            printField(r8, r10, r11);     // Catch: IOException -> L7
            return r11.toString();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        public String printToString(MessageOrBuilder r8) {
            return printToString(r8, FieldReporterLevel.PRINTER_PRINT_TO_STRING);
        }

        public void setSensitiveFieldReportingLevel(FieldReporterLevel r8) {
            sensitiveFieldReportingLevel.set(r8);
        }

        @InlineMe(replacement = "this.emittingSingleLine(true).printFieldToString(field, value)")
        @Deprecated
        public String shortDebugString(Descriptors.FieldDescriptor r8, Object r10) {
            return emittingSingleLine(true).printFieldToString(r8, r10);
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

        public void print(MessageOrBuilder r8, Appendable r10) {
            print(r8, r10, FieldReporterLevel.PRINT);
        }

        public void printField(Descriptors.FieldDescriptor r8, Object r10, Appendable r11) {
            printField(r8, r10, TextFormat.access$600(r11, this.singleLine));
        }

        public void printFieldValue(Descriptors.FieldDescriptor r8, Object r10, Appendable r11) {
            printFieldValue(r8, r10, TextFormat.access$600(r11, this.singleLine));
        }

        public String printToString(MessageOrBuilder r8, FieldReporterLevel r10) {
            StringBuilder r11 = new StringBuilder();     // Catch: IOException -> L7
            if (this.enablingSafeDebugFormat == false) goto L5;
            applyUnstablePrefix(r11);     // Catch: IOException -> L7
        L5:
            print(r8, r11, r10);     // Catch: IOException -> L7
            return r11.toString();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @Deprecated
        public String shortDebugString(MessageOrBuilder r8) {
            return emittingSingleLine(true).printToString(r8, FieldReporterLevel.SHORT_DEBUG_STRING);
        }

        public void print(MessageOrBuilder r8, Appendable r10, FieldReporterLevel r11) {
            print(r8, TextFormat.access$500(r10, this.singleLine, r8.getDescriptorForType(), r11, this.insertSilentMarker));
        }

        public String printToString(UnknownFieldSet r8) {
            StringBuilder r10 = new StringBuilder();     // Catch: IOException -> L7
            if (this.enablingSafeDebugFormat == false) goto L5;
            applyUnstablePrefix(r10);     // Catch: IOException -> L7
        L5:
            print(r8, r10);     // Catch: IOException -> L7
            return r10.toString();
        L7:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        @InlineMe(replacement = "this.emittingSingleLine(true).printToString(fields)")
        @Deprecated
        public String shortDebugString(UnknownFieldSet r8) {
            return emittingSingleLine(true).printToString(r8);
        }

        public void print(UnknownFieldSet r8, Appendable r10) {
            printUnknownFields(r8, TextFormat.access$600(r10, this.singleLine), this.enablingSafeDebugFormat);
        }
    }

    public static final class TextGenerator {
        private boolean atStartOfLine;
        private final Printer.FieldReporterLevel fieldReporterLevel;
        private final StringBuilder indent;
        private final Appendable output;
        private final Descriptors.Descriptor rootMessageType;
        private boolean shouldEmitSilentMarker;
        private final boolean singleLineMode;

        private TextGenerator(Appendable r8, boolean r10, Descriptors.Descriptor r11, Printer.FieldReporterLevel r12, boolean r13) {
            this.indent = new StringBuilder();
            this.atStartOfLine = false;
            this.output = r8;
            this.singleLineMode = r10;
            this.rootMessageType = r11;
            this.fieldReporterLevel = r12;
            this.shouldEmitSilentMarker = r13;
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

        public void maybePrintSilentMarker() {
            if (this.shouldEmitSilentMarker == false) goto L5;
            this.output.append(TextFormat.DEBUG_STRING_SILENT_MARKER);
            this.shouldEmitSilentMarker = false;
            return;
        L5:
            this.output.append(" ");
        }

        public void outdent() {
            int r8 = this.indent.length();
            if (r8 == 0) goto L7;
            this.indent.setLength(r8 - 2);
            return;
        L7:
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void print(CharSequence r8) {
            if (this.atStartOfLine == false) goto L9;
            this.atStartOfLine = false;
            Appendable r10 = this.output;
            if (this.singleLineMode == false) goto L7;
            CharSequence r11 = " ";
        L8:
            r10.append(r11);
            goto L9
        L7:
            r11 = this.indent;
        L9:
            this.output.append(r8);
        }

        public /* synthetic */ TextGenerator(Appendable r8, boolean r10, Descriptors.Descriptor r11, Printer.FieldReporterLevel r12, boolean r13, AnonymousClass1 r14) {
            this(r8, r10, r11, r12, r13);
        }
    }

    public static final class Tokenizer {
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

        private Tokenizer(CharSequence r8) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.lineInfoTrackingPos = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.containsSilentMarkerAfterCurrentToken = false;
            this.containsSilentMarkerAfterPrevToken = false;
            this.text = r8;
            skipWhitespace();
            nextToken();
        }

        public static /* synthetic */ String access$1100(Tokenizer r8) {
            return r8.currentToken;
        }

        private ParseException floatParseException(NumberFormatException r8) {
            return parseException("Couldn't parse number: " + r8.getMessage());
        }

        private ParseException integerParseException(NumberFormatException r8) {
            return parseException("Couldn't parse integer: " + r8.getMessage());
        }

        private static boolean isAlphaUnder(char r8) {
            if ('a' > r8) goto L7;
            if (r8 > 'z') goto L7;
        L12:
            return true;
        L7:
            if ('A' > r8) goto L11;
            if (r8 <= 'Z') goto L12;
        L11:
            if (r8 == '_') goto L12;
            return false;
        }

        private static boolean isDigitPlusMinus(char r8) {
            if ('0' > r8) goto L7;
            if (r8 > '9') goto L7;
        L12:
            return true;
        L7:
            if (r8 == '+') goto L12;
            if (r8 == '-') goto L12;
            return false;
        }

        private static boolean isWhitespace(char r8) {
            if (r8 != ' ') goto L5;
        L14:
            return true;
        L5:
            if (r8 == '\f') goto L14;
            if (r8 == '\n') goto L14;
            if (r8 == '\r') goto L14;
            if (r8 == '\t') goto L14;
            return false;
        }

        private String nextTokenInternal() {
            int r8 = this.text.length();
            int r10 = this.pos;
            char r11 = this.text.charAt(r10);
            int r12 = this.pos;
            if (isAlphaUnder(r11) == false) goto L12;
        L4:
            r12 = r12 + 1;
            if (r12 == r8) goto L54;
            char r13 = this.text.charAt(r12);
            if (isAlphaUnder(r13) == true) goto L4;
            if (isDigitPlusMinus(r13) == true) goto L4;
        L54:
            this.pos = r12;
            return this.text.subSequence(r10, r12).toString();
        L12:
            if (isDigitPlusMinus(r11) == true) goto L38;
            if (r11 == '.') goto L38;
            if (r11 == '\"') goto L22;
            if (r11 == '\'') goto L22;
            return nextTokenSingleChar();
        L22:
            r12 = r12 + 1;
            if (r12 == r8) goto L54;
            char r14 = this.text.charAt(r12);
            if (r14 == r11) goto L26;
            if (r14 == '\n') goto L54;
            if (r14 != '\\') goto L22;
            r12 = r12 + 1;
            if (r12 == r8) goto L54;
            if (this.text.charAt(r12) != '\n') goto L22;
        L26:
            r12 = r12 + 1;
        L38:
            if (r11 != '.') goto L47;
            r12 = r12 + 1;
            if (r12 != r8) goto L44;
            return nextTokenSingleChar();
        L44:
            if (isDigitPlusMinus(this.text.charAt(r12)) == true) goto L47;
            return nextTokenSingleChar();
        L47:
            r12 = r12 + 1;
            if (r12 == r8) goto L54;
            char r15 = this.text.charAt(r12);
            if (isDigitPlusMinus(r15) == true) goto L47;
            if (isAlphaUnder(r15) == true) goto L47;
            if (r15 == '.') goto L47;
            goto L54
        }

        private String nextTokenSingleChar() {
            CharSequence r8 = this.text;
            int r10 = this.pos;
            this.pos = r10 + 1;
            char r11 = r8.charAt(r10);
            if (r11 != ',') goto L5;
            return ",";
        L5:
            if (r11 != ':') goto L7;
            return BdimCategoryConstants.SEPARATOR_COLON;
        L7:
            if (r11 != '<') goto L9;
            return "<";
        L9:
            if (r11 != '>') goto L11;
            return ">";
        L11:
            if (r11 != '[') goto L13;
            return "[";
        L13:
            if (r11 != ']') goto L15;
            return "]";
        L15:
            if (r11 != '{') goto L17;
            return "{";
        L17:
            if (r11 != '}') goto L19;
            return "}";
        L19:
            return String.valueOf(r11);
        }

        private void skipWhitespace() {
            int r8 = this.text.length();
            int r10 = this.pos - 1;
        L3:
            r10 = r10 + 1;
            if (r10 == r8) goto L16;
            char r11 = this.text.charAt(r10);
            if (r11 == '#') goto L7;
            if (isWhitespace(r11) == false) goto L16;
        L7:
            r10 = r10 + 1;
            if (r10 == r8) goto L11;
            if (this.text.charAt(r10) != '\n') goto L7;
        L11:
            if (r10 != r8) goto L3;
        L16:
            this.pos = r10;
        }

        public boolean atEnd() {
            if (this.currentToken.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void consume(String r8) {
            if (tryConsume(r8) == false) goto L6;
            return;
        L6:
            throw parseException(defpackage.b.d("Expected \"", r8, "\"."));
        }

        public boolean consumeBoolean() {
            if (this.currentToken.equals("true") == false) goto L5;
        L24:
            nextToken();
            return true;
        L5:
            if (this.currentToken.equals("True") == true) goto L24;
            if (this.currentToken.equals("t") == true) goto L24;
            if (this.currentToken.equals("1") == true) goto L24;
            if (this.currentToken.equals("false") == false) goto L14;
        L22:
            nextToken();
            return false;
        L14:
            if (this.currentToken.equals("False") == true) goto L22;
            if (this.currentToken.equals("f") == true) goto L22;
            if (this.currentToken.equals("0") == true) goto L22;
            throw parseException(android.aimedia.a.i(new StringBuilder("Expected \"true\" or \"false\". Found \""), this.currentToken, "\"."));
        }

        @CanIgnoreReturnValue
        public ByteString consumeByteString() {
            ArrayList r8 = new ArrayList();
        L3:
            consumeByteString(r8);
            if (this.currentToken.startsWith("'") == true) goto L3;
            if (this.currentToken.startsWith("\"") == true) goto L3;
            return ByteString.copyFrom(r8);
        }

        public double consumeDouble() {
            String r8 = this.currentToken.toLowerCase(Locale.ROOT);
            r8.getClass();
            byte r10 = -1;
            switch(r8.hashCode()) {
                case 104417: goto L22;
                case 108827: goto L18;
                case 1445012: goto L14;
                case 173173288: goto L10;
                case 442101077: goto L6;
                default: goto L25;
            };
        L25:
            switch(r10) {
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
            double r11 = Double.parseDouble(this.currentToken);     // Catch: NumberFormatException -> L28
            nextToken();     // Catch: NumberFormatException -> L28
            return r11;
        L28:
            e = move-exception;
            throw floatParseException(e);
        L6:
            if (r8.equals("-infinity") == false) goto L25;
            r10 = 4;
            goto L25
        L10:
            if (r8.equals("infinity") == false) goto L25;
            r10 = 3;
            goto L25
        L14:
            if (r8.equals("-inf") == false) goto L25;
            r10 = 2;
            goto L25
        L18:
            if (r8.equals("nan") == false) goto L25;
            r10 = 1;
            goto L25
        L22:
            if (r8.equals("inf") == false) goto L25;
            r10 = 0;
            goto L25
        }

        public float consumeFloat() {
            String r8 = this.currentToken.toLowerCase(Locale.ROOT);
            r8.getClass();
            byte r10 = -1;
            switch(r8.hashCode()) {
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
            switch(r10) {
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
            float r11 = Float.parseFloat(this.currentToken);     // Catch: NumberFormatException -> L48
            nextToken();     // Catch: NumberFormatException -> L48
            return r11;
        L48:
            e = move-exception;
            throw floatParseException(e);
        L6:
            if (r8.equals("infinityf") == false) goto L45;
            r10 = 9;
            goto L45
        L10:
            if (r8.equals("-infinityf") == false) goto L45;
            r10 = 8;
            goto L45
        L14:
            if (r8.equals("-infinity") == false) goto L45;
            r10 = 7;
            goto L45
        L18:
            if (r8.equals("infinity") == false) goto L45;
            r10 = 6;
            goto L45
        L22:
            if (r8.equals("-inff") == false) goto L45;
            r10 = 5;
            goto L45
        L26:
            if (r8.equals("nanf") == false) goto L45;
            r10 = 4;
            goto L45
        L30:
            if (r8.equals("inff") == false) goto L45;
            r10 = 3;
            goto L45
        L34:
            if (r8.equals("-inf") == false) goto L45;
            r10 = 2;
            goto L45
        L38:
            if (r8.equals("nan") == false) goto L45;
            r10 = 1;
            goto L45
        L42:
            if (r8.equals("inf") == false) goto L45;
            r10 = 0;
            goto L45
        }

        public String consumeIdentifier() {
            int r8 = 0;
        L4:
            if (r8 >= this.currentToken.length()) goto L17;
            char r10 = this.currentToken.charAt(r8);
            if (isAlphaUnder(r10) == true) goto L16;
            if ('0' > r10) goto L12;
            if (r10 <= '9') goto L16;
        L12:
            if (r10 == '.') goto L16;
            throw parseException(android.aimedia.a.i(new StringBuilder("Expected identifier. Found '"), this.currentToken, "'"));
        L16:
            r8 = r8 + 1;
            goto L4
        L17:
            String r11 = this.currentToken;
            nextToken();
            return r11;
        }

        public int consumeInt32() {
            int r8 = TextFormat.parseInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r8;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public long consumeInt64() {
            long r8 = TextFormat.parseInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r8;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public String consumeString() {
            return consumeByteString().toStringUtf8();
        }

        public int consumeUInt32() {
            int r8 = TextFormat.parseUInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r8;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public long consumeUInt64() {
            long r8 = TextFormat.parseUInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r8;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public int getColumn() {
            return this.column;
        }

        public boolean getContainsSilentMarkerAfterCurrentToken() {
            return this.containsSilentMarkerAfterCurrentToken;
        }

        public boolean getContainsSilentMarkerAfterPrevToken() {
            return this.containsSilentMarkerAfterPrevToken;
        }

        public int getLine() {
            return this.line;
        }

        public int getPreviousColumn() {
            return this.previousColumn;
        }

        public int getPreviousLine() {
            return this.previousLine;
        }

        public boolean lookingAt(String r8) {
            return this.currentToken.equals(r8);
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() != 0) goto L6;
            return false;
        L6:
            return isDigitPlusMinus(this.currentToken.charAt(0));
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
        L3:
            int r8 = this.lineInfoTrackingPos;
            int r10 = this.pos;
            if (r8 >= r10) goto L11;
            if (this.text.charAt(r8) != '\n') goto L8;
            this.line++;
            int r11 = 0;
        L9:
            this.column = r11;
            this.lineInfoTrackingPos++;
            goto L3
        L8:
            r11 = this.column + 1;
            goto L9
        L11:
            if (r10 != this.text.length()) goto L13;
            this.currentToken = "";
            return;
        L13:
            this.currentToken = nextTokenInternal();
            skipWhitespace();
        }

        public ParseException parseException(String r8) {
            return new ParseException(this.line + 1, this.column + 1, r8);
        }

        public ParseException parseExceptionPreviousToken(String r8) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, r8);
        }

        public boolean tryConsume(String r8) {
            if (this.currentToken.equals(r8) == false) goto L6;
            nextToken();
            return true;
        L6:
            return false;
        }

        public boolean tryConsumeByteString() {
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

        public boolean tryConsumeIdentifier() {
            consumeIdentifier();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeInt64() {
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

        public /* synthetic */ Tokenizer(CharSequence r8, AnonymousClass1 r10) {
            this(r8);
        }

        private void consumeByteString(List<ByteString> r8) {
            char r10 = 0;
            if (this.currentToken.length() <= 0) goto L6;
            r10 = this.currentToken.charAt(0);
        L6:
            if (r10 == '\"') goto L13;
            if (r10 == '\'') goto L13;
            throw parseException("Expected string.");
        L13:
            if (this.currentToken.length() < 2) goto L22;
            String r11 = this.currentToken;
            if (r11.charAt(r11.length() - 1) != r10) goto L22;
            String r12 = this.currentToken;     // Catch: InvalidEscapeSequenceException -> L18
            ByteString r13 = TextFormat.unescapeBytes(r12.substring(1, r12.length() - 1));     // Catch: InvalidEscapeSequenceException -> L18
            nextToken();     // Catch: InvalidEscapeSequenceException -> L18
            r8.add(r13);     // Catch: InvalidEscapeSequenceException -> L18
            return;
        L18:
            e = move-exception;
            throw parseException(e.getMessage());
        L22:
            throw parseException("String missing ending quote.");
        }
    }

    @Deprecated
    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public UnknownFieldParseException(int r8, int r10, String r11, String r12) {
            super(r8, r10, r12);
            this.unknownField = r11;
        }

        public String getUnknownField() {
            return this.unknownField;
        }

        public UnknownFieldParseException(String r8) {
            this(-1, -1, "", r8);
        }
    }

    static {
        logger = Logger.getLogger(TextFormat.class.getName());
        ENABLE_INSERT_SILENT_MARKER = System.getenv().getOrDefault(ENABLE_INSERT_SILENT_MARKER_ENV_NAME, "false").equals("true");
        PARSER = Parser.newBuilder().build();
    }

    private TextFormat() {
    }

    public static /* synthetic */ boolean access$400() {
        return ENABLE_INSERT_SILENT_MARKER;
    }

    public static /* synthetic */ TextGenerator access$500(Appendable r8, boolean r10, Descriptors.Descriptor r11, Printer.FieldReporterLevel r12, boolean r13) {
        return setSingleLineOutput(r8, r10, r11, r12, r13);
    }

    public static /* synthetic */ TextGenerator access$600(Appendable r8, boolean r10) {
        return setSingleLineOutput(r8, r10);
    }

    public static /* synthetic */ Logger access$900() {
        return logger;
    }

    public static Printer debugFormatPrinter() {
        return Printer.access$200();
    }

    public static Printer defaultFormatPrinter() {
        return Printer.access$300();
    }

    private static int digitValue(byte r8) {
        if (48 > r8) goto L9;
        if (r8 > 57) goto L9;
        return r8 - BWDLDataStructure.DataLinkParamStructure.NFC;
    L9:
        if (97 <= r8) goto L11;
    L15:
        int r10 = r8 - 65;
    L14:
        return r10 + 10;
    L11:
        if (r8 > 122) goto L15;
        r10 = r8 - 97;
        goto L14
    }

    public static String escapeBytes(ByteString r8) {
        return TextFormatEscaper.escapeBytes(r8);
    }

    public static String escapeDoubleQuotesAndBackslashes(String r8) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(r8);
    }

    public static String escapeText(String r8) {
        return escapeBytes(ByteString.copyFromUtf8(r8));
    }

    public static Parser getParser() {
        return PARSER;
    }

    private static boolean isHex(byte r8) {
        if (48 > r8) goto L7;
        if (r8 > 57) goto L7;
    L14:
        return true;
    L7:
        if (97 > r8) goto L11;
        if (r8 <= 102) goto L14;
    L11:
        if (65 <= r8) goto L13;
    L15:
        return false;
    L13:
        if (r8 > 70) goto L15;
        goto L14
    }

    private static boolean isOctal(byte r8) {
        if (48 <= r8) goto L5;
    L7:
        return false;
    L5:
        if (r8 > 55) goto L7;
        return true;
    }

    public static void merge(CharSequence r8, ExtensionRegistry r10, Message.Builder r11) {
        PARSER.merge(r8, r10, r11);
    }

    public static <T extends Message> T parse(CharSequence r8, ExtensionRegistry r10, Class<T> r11) {
        Message.Builder r12 = ((Message) Internal.getDefaultInstance(r11)).newBuilderForType();
        merge(r8, r10, r12);
        return (T) r12.build();
    }

    public static int parseInt32(String r8) {
        return (int) parseInteger(r8, true, false);
    }

    public static long parseInt64(String r8) {
        return parseInteger(r8, true, true);
    }

    private static long parseInteger(String r8, boolean r10, boolean r11) {
        int r12 = 0;
        if (r8.startsWith("-", 0) == false) goto L8;
        if (r10 == false) goto L7;
        r12 = 1;
        goto L8
    L7:
        throw new NumberFormatException("Number must be positive: ".concat(r8));
    L8:
        int r13 = r12;
        if (r8.startsWith("0x", r12) == false) goto L12;
        r12 = r12 + 2;
        int r14 = 16;
    L15:
        String r15 = r8.substring(r12);
        if (r15.length() >= 16) goto L36;
        long r16 = Long.parseLong(r15, r14);
        if (r13 == 0) goto L20;
        r16 = -r16;
    L20:
        if (r11 == true) goto L63;
        if (r10 == false) goto L30;
        if (r16 > 2147483647L) goto L28;
        if (r16 < (-2147483648L)) goto L28;
        return r16;
    L28:
        throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(r8));
    L30:
        if (r16 >= 4294967296L) goto L35;
        if (r16 < 0) goto L35;
        return r16;
    L35:
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(r8));
    L63:
        return r16;
    L36:
        BigInteger r17 = new BigInteger(r15, r14);
        if (r13 == 0) goto L39;
        r17 = r17.negate();
    L39:
        if (r11 == true) goto L51;
        if (r10 == false) goto L47;
        if (r17.bitLength() <= 31) goto L60;
        throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(r8));
    L60:
        return r17.longValue();
    L47:
        if (r17.bitLength() <= 32) goto L60;
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(r8));
    L51:
        if (r10 == false) goto L58;
        if (r17.bitLength() <= 63) goto L60;
        throw new NumberFormatException("Number out of range for 64-bit signed integer: ".concat(r8));
    L58:
        if (r17.bitLength() <= 64) goto L60;
        throw new NumberFormatException("Number out of range for 64-bit unsigned integer: ".concat(r8));
    L12:
        if (r8.startsWith("0", r12) == false) goto L14;
        r14 = 8;
        goto L15
    L14:
        r14 = 10;
        goto L15
    }

    public static int parseUInt32(String r8) {
        return (int) parseInteger(r8, false, false);
    }

    public static long parseUInt64(String r8) {
        return parseInteger(r8, false, true);
    }

    @InlineMe(imports = {"com.google.protobuf.TextFormat"}, replacement = "TextFormat.printer().print(message, output)")
    @Deprecated
    public static void print(MessageOrBuilder r8, Appendable r10) {
        printer().print(r8, r10);
    }

    @InlineMe(imports = {"com.google.protobuf.TextFormat"}, replacement = "TextFormat.printer().printFieldValue(field, value, output)")
    @Deprecated
    public static void printFieldValue(Descriptors.FieldDescriptor r8, Object r10, Appendable r11) {
        printer().printFieldValue(r8, r10, r11);
    }

    @Deprecated
    public static String printToString(MessageOrBuilder r8) {
        return printer().printToString(r8, Printer.FieldReporterLevel.TEXTFORMAT_PRINT_TO_STRING);
    }

    @Deprecated
    public static String printToUnicodeString(MessageOrBuilder r8) {
        return printer().escapingNonAscii(false).printToString(r8, Printer.FieldReporterLevel.PRINT_UNICODE);
    }

    @Deprecated
    public static void printUnicode(MessageOrBuilder r8, Appendable r10) {
        printer().escapingNonAscii(false).print(r8, r10, Printer.FieldReporterLevel.PRINT_UNICODE);
    }

    private static void printUnknownFieldValue(int r8, Object r10, TextGenerator r11, boolean r12) {
        int r13 = WireFormat.getTagWireType(r8);
        if (r13 != 0) goto L5;
        String r14 = unsignedToString(((Long) r10).longValue());
    L21:
        r11.print(r14);
        return;
    L5:
        if (r13 != 1) goto L7;
        r14 = String.format(null, "0x%016x", new Object[]{(Long) r10});
        goto L21
    L7:
        if (r13 != 2) goto L9;
        UnknownFieldSet r15 = UnknownFieldSet.parseFrom((ByteString) r10);     // Catch: InvalidProtocolBufferException -> L18
        r11.print("{");     // Catch: InvalidProtocolBufferException -> L18
        r11.eol();     // Catch: InvalidProtocolBufferException -> L18
        r11.indent();     // Catch: InvalidProtocolBufferException -> L18
        Printer.access$000(r15, r11, r12);     // Catch: InvalidProtocolBufferException -> L18
        r11.outdent();     // Catch: InvalidProtocolBufferException -> L18
        r11.print("}");     // Catch: InvalidProtocolBufferException -> L18
        return;
    L18:
        r14 = "\"";
        r11.print("\"");
        r11.print(escapeBytes((ByteString) r10));
        goto L21
    L9:
        if (r13 != 3) goto L11;
        Printer.access$000((UnknownFieldSet) r10, r11, r12);
        return;
    L11:
        if (r13 != 5) goto L14;
        r14 = String.format(null, "0x%08x", new Object[]{(Integer) r10});
        goto L21
    L14:
        throw new IllegalArgumentException(defpackage.a.d("Bad tag: ", r8));
    }

    public static Printer printer() {
        return Printer.access$100();
    }

    private static TextGenerator setSingleLineOutput(Appendable r8, boolean r10) {
        return new TextGenerator(r8, r10, null, Printer.FieldReporterLevel.TEXT_GENERATOR, false, null);
    }

    @Deprecated
    public static String shortDebugString(MessageOrBuilder r8) {
        return printer().emittingSingleLine(true).printToString(r8, Printer.FieldReporterLevel.SHORT_DEBUG_STRING);
    }

    public static ByteString unescapeBytes(CharSequence r12) {
        ByteString r13 = ByteString.copyFromUtf8(r12.toString());
        int r8 = r13.size();
        byte[] r10 = new byte[r8];
        int r11 = 0;
        int r14 = 0;
    L4:
        if (r11 >= r13.size()) goto L124;
        byte r15 = r13.byteAt(r11);
        if (r15 != 92) goto L121;
        r11 = r11 + 1;
        if (r11 >= r13.size()) goto L120;
        byte r16 = r13.byteAt(r11);
        if (isOctal(r16) == false) goto L23;
        int r17 = digitValue(r16);
        int r18 = r11 + 1;
        if (r18 < r13.size()) goto L14;
    L16:
        int r19 = r11 + 1;
        if (r19 < r13.size()) goto L19;
    L21:
        int r20 = r14 + 1;
        r10[r14] = (byte) r17;
    L122:
        r14 = r20;
    L123:
        r11 = r11 + 1;
        goto L4
    L19:
        if (isOctal(r13.byteAt(r19)) == false) goto L21;
        r17 = (r17 * 8) + digitValue(r13.byteAt(r19));
        r11 = r19;
        goto L21
    L14:
        if (isOctal(r13.byteAt(r18)) == false) goto L16;
        r17 = (r17 * 8) + digitValue(r13.byteAt(r18));
        r11 = r18;
        goto L16
    L23:
        if (r16 != 34) goto L25;
        int r21 = r14 + 1;
        r10[r14] = 34;
    L118:
        r14 = r21;
        goto L123
    L25:
        if (r16 != 39) goto L27;
        r21 = r14 + 1;
        r10[r14] = 39;
        goto L118
    L27:
        if (r16 != 63) goto L29;
        r21 = r14 + 1;
        r10[r14] = 63;
        goto L118
    L29:
        if (r16 == 85) goto L86;
        if (r16 != 92) goto L32;
        r21 = r14 + 1;
        r10[r14] = 92;
        goto L118
    L32:
        if (r16 != 102) goto L34;
        r21 = r14 + 1;
        r10[r14] = 12;
        goto L118
    L34:
        if (r16 != 110) goto L36;
        r21 = r14 + 1;
        r10[r14] = 10;
        goto L118
    L36:
        if (r16 != 114) goto L38;
        r21 = r14 + 1;
        r10[r14] = 13;
        goto L118
    L38:
        if (r16 != 120) goto L40;
        r11 = r11 + 1;
        if (r11 >= r13.size()) goto L81;
        if (isHex(r13.byteAt(r11)) == false) goto L81;
        int r22 = digitValue(r13.byteAt(r11));
        int r23 = r11 + 1;
        if (r23 < r13.size()) goto L77;
    L79:
        r20 = r14 + 1;
        r10[r14] = (byte) r22;
        goto L122
    L77:
        if (isHex(r13.byteAt(r23)) == false) goto L79;
        r22 = (r22 * 16) + digitValue(r13.byteAt(r23));
        r11 = r23;
    L81:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
    L40:
        if (r16 != 97) goto L42;
        r21 = r14 + 1;
        r10[r14] = 7;
        goto L118
    L42:
        if (r16 == 98) goto L68;
        switch(r16) {
            case 116: goto L67;
            case 117: goto L47;
            case 118: goto L46;
            default: goto L45;
        };
    L46:
        r21 = r14 + 1;
        r10[r14] = 11;
        goto L118
    L47:
        int r24 = r11 + 1;
        int r25 = r24 + 3;
        if (r25 >= r13.size()) goto L66;
        if (isHex(r13.byteAt(r24)) == false) goto L66;
        int r26 = r24 + 1;
        if (isHex(r13.byteAt(r26)) == false) goto L66;
        int r27 = r24 + 2;
        if (isHex(r13.byteAt(r27)) == false) goto L66;
        if (isHex(r13.byteAt(r25)) == false) goto L66;
        char r28 = (char) ((((digitValue(r13.byteAt(r24)) << 12) | (digitValue(r13.byteAt(r26)) << 8)) | (digitValue(r13.byteAt(r27)) << 4)) | digitValue(r13.byteAt(r25)));
        if (r28 >= 55296) goto L60;
    L64:
        byte[] r29 = Character.toString(r28).getBytes(Internal.UTF_8);
        System.arraycopy(r29, 0, r10, r14, r29.length);
        int r30 = r29.length;
    L110:
        r14 = r14 + r30;
        r11 = r25;
        goto L123
    L60:
        if (r28 > 57343) goto L64;
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' refers to a surrogate");
    L66:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\u' with too few hex chars");
    L67:
        r21 = r14 + 1;
        r10[r14] = 9;
        goto L118
    L45:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) r16) + '\'');
    L68:
        r21 = r14 + 1;
        r10[r14] = 8;
        goto L118
    L86:
        int r31 = r11 + 1;
        r25 = r31 + 7;
        if (r25 >= r13.size()) goto L114;
        int r32 = 0;
        int r33 = r31;
    L89:
        int r110 = r31 + 8;
        if (r33 >= r110) goto L97;
        byte r111 = r13.byteAt(r33);
        if (isHex(r111) == false) goto L95;
        r32 = (r32 << 4) | digitValue(r111);
        r33 = r33 + 1;
        goto L89
    L95:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
    L97:
        if (Character.isValidCodePoint(r32) == false) goto L112;
        Character.UnicodeBlock r34 = Character.UnicodeBlock.of(r32);
        if (r34 != null) goto L101;
    L109:
        byte[] r35 = new String(new int[]{r32}, 0, 1).getBytes(Internal.UTF_8);
        System.arraycopy(r35, 0, r10, r14, r35.length);
        r30 = r35.length;
        goto L110
    L101:
        if (r34.equals(Character.UnicodeBlock.LOW_SURROGATES) == true) goto L108;
        if (r34.equals(Character.UnicodeBlock.HIGH_SURROGATES) == true) goto L108;
        if (r34.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES) == false) goto L109;
    L108:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + r13.substring(r31, r110).toStringUtf8() + "' refers to a surrogate code unit");
    L112:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U" + r13.substring(r31, r110).toStringUtf8() + "' is not a valid code point value");
    L114:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\U' with too few hex chars");
    L120:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
    L121:
        r20 = r14 + 1;
        r10[r14] = r15;
        goto L122
    L124:
        if (r8 != r14) goto L127;
        return ByteString.wrap(r10);
    L127:
        return ByteString.copyFrom(r10, 0, r14);
    }

    public static String unescapeText(String r8) {
        return unescapeBytes(r8).toStringUtf8();
    }

    public static String unsignedToString(int r8) {
        if (r8 < 0) goto L6;
        return Integer.toString(r8);
    L6:
        return Long.toString(((long) r8) & QesdkUtils.LIMITS.UINT_32_UPPER);
    }

    public static String escapeBytes(byte[] r8) {
        return TextFormatEscaper.escapeBytes(r8);
    }

    public static void merge(CharSequence r8, Message.Builder r10) {
        PARSER.merge(r8, r10);
    }

    public static <T extends Message> T parse(CharSequence r8, Class<T> r10) {
        Message.Builder r11 = ((Message) Internal.getDefaultInstance(r10)).newBuilderForType();
        merge(r8, r11);
        return (T) r11.build();
    }

    private static TextGenerator setSingleLineOutput(Appendable r8, boolean r10, Descriptors.Descriptor r11, Printer.FieldReporterLevel r12, boolean r13) {
        return new TextGenerator(r8, r10, r11, r12, r13, null);
    }

    public static String unsignedToString(long r8) {
        if (r8 < 0) goto L7;
        return Long.toString(r8);
    L7:
        return BigInteger.valueOf(r8 & Long.MAX_VALUE).setBit(63).toString();
    }

    public static void merge(Readable r8, ExtensionRegistry r10, Message.Builder r11) {
        PARSER.merge(r8, r10, r11);
    }

    public static void merge(Readable r8, Message.Builder r10) {
        PARSER.merge(r8, r10);
    }

    public static void printUnknownFieldValue(int r8, Object r10, Appendable r11) {
        printUnknownFieldValue(r8, r10, setSingleLineOutput(r11, false), false);
    }
}
