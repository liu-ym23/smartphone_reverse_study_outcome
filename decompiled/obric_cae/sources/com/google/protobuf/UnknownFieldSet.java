package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class UnknownFieldSet implements MessageLite {
    private static final Parser PARSER = null;
    private static final UnknownFieldSet defaultInstance = null;
    private final TreeMap<Integer, Field> fields;

    /* JADX INFO: renamed from: com.google.protobuf.UnknownFieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder implements MessageLite.Builder {
        private TreeMap<Integer, Field.Builder> fieldBuilders;

        private Builder() {
            this.fieldBuilders = new TreeMap();
        }

        public static /* synthetic */ Builder access$000() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private Field.Builder getFieldBuilder(int r8) {
            if (r8 != 0) goto L5;
            return null;
        L5:
            Field.Builder r10 = this.fieldBuilders.get(Integer.valueOf(r8));
            if (r10 != null) goto L9;
            Field.Builder r11 = Field.newBuilder();
            this.fieldBuilders.put(Integer.valueOf(r8), r11);
            return r11;
        L9:
            return r10;
        }

        public Builder addField(int r8, Field r10) {
            if (r8 <= 0) goto L6;
            this.fieldBuilders.put(Integer.valueOf(r8), Field.newBuilder(r10));
            return this;
        L6:
            throw new IllegalArgumentException(r8 + " is not a valid field number.");
        }

        public Map<Integer, Field> asMap() {
            if (this.fieldBuilders.isEmpty() == true) goto L5;
            TreeMap r8 = new TreeMap();
            Iterator<Map.Entry<Integer, Field.Builder>> r10 = this.fieldBuilders.entrySet().iterator();
        L8:
            if (r10.hasNext() == false) goto L11;
            Map.Entry<Integer, Field.Builder> r11 = r10.next();
            r8.put(r11.getKey(), r11.getValue().build());
            goto L8
        L11:
            return Collections.unmodifiableMap(r8);
        L5:
            return Collections.emptyMap();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        public Builder clearField(int r8) {
            if (r8 <= 0) goto L8;
            if (this.fieldBuilders.containsKey(Integer.valueOf(r8)) == false) goto L6;
            this.fieldBuilders.remove(Integer.valueOf(r8));
        L6:
            return this;
        L8:
            throw new IllegalArgumentException(r8 + " is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        public boolean hasField(int r8) {
            return this.fieldBuilders.containsKey(Integer.valueOf(r8));
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r8) {
            int r10 = r8.read();
            if (r10 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new AbstractMessageLite.Builder.LimitedInputStream(r8, CodedInputStream.readRawVarint32(r10, r8)));
            return true;
        }

        public Builder mergeField(int r8, Field r10) {
            if (r8 <= 0) goto L9;
            if (hasField(r8) == false) goto L6;
            getFieldBuilder(r8).mergeFrom(r10);
        L7:
            return this;
        L6:
            addField(r8, r10);
            goto L7
        L9:
            throw new IllegalArgumentException(r8 + " is not a valid field number.");
        }

        public boolean mergeFieldFrom(int r8, CodedInputStream r10) {
            int r11 = WireFormat.getTagFieldNumber(r8);
            int r12 = WireFormat.getTagWireType(r8);
            if (r12 == 0) goto L25;
            if (r12 != 1) goto L6;
            getFieldBuilder(r11).addFixed64(r10.readFixed64());
            return true;
        L6:
            if (r12 != 2) goto L8;
            getFieldBuilder(r11).addLengthDelimited(r10.readBytes());
            return true;
        L8:
            if (r12 != 3) goto L10;
            Builder r13 = UnknownFieldSet.newBuilder();
            r10.readGroup(r11, r13, ExtensionRegistry.getEmptyRegistry());
            getFieldBuilder(r11).addGroup(r13.build());
            return true;
        L10:
            if (r12 != 4) goto L12;
            r10.checkValidEndTag();
            return false;
        L12:
            if (r12 != 5) goto L16;
            getFieldBuilder(r11).addFixed32(r10.readFixed32());
            return true;
        L16:
            throw InvalidProtocolBufferException.invalidWireType();
        L25:
            getFieldBuilder(r11).addVarint(r10.readInt64());
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r8) {
            return mergeFrom(r8);
        }

        public Builder mergeLengthDelimitedField(int r8, ByteString r10) {
            if (r8 <= 0) goto L6;
            getFieldBuilder(r8).addLengthDelimited(r10);
            return this;
        L6:
            throw new IllegalArgumentException(r8 + " is not a valid field number.");
        }

        public Builder mergeVarintField(int r8, int r10) {
            if (r8 <= 0) goto L6;
            getFieldBuilder(r8).addVarint(r10);
            return this;
        L6:
            throw new IllegalArgumentException(r8 + " is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet build() {
            if (this.fieldBuilders.isEmpty() == true) goto L12;
            TreeMap r8 = new TreeMap();
            Iterator<Map.Entry<Integer, Field.Builder>> r10 = this.fieldBuilders.entrySet().iterator();
        L7:
            if (r10.hasNext() == false) goto L10;
            Map.Entry<Integer, Field.Builder> r11 = r10.next();
            r8.put(r11.getKey(), r11.getValue().build());
            goto L7
        L10:
            return new UnknownFieldSet(r8, null);
        L12:
            return UnknownFieldSet.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet buildPartial() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            this.fieldBuilders = new TreeMap();
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            Builder r8 = UnknownFieldSet.newBuilder();
            Iterator<Map.Entry<Integer, Field.Builder>> r10 = this.fieldBuilders.entrySet().iterator();
        L4:
            if (r10.hasNext() == false) goto L6;
            Map.Entry<Integer, Field.Builder> r11 = r10.next();
            Integer r12 = r11.getKey();
            Field.Builder r13 = r11.getValue();
            r8.fieldBuilders.put(r12, r13.clone());
            goto L4
        L6:
            return r8;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public UnknownFieldSet getDefaultInstanceForType() {
            return UnknownFieldSet.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return mergeDelimitedFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m7clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r8) {
            CodedInputStream r10 = r8.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r10);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r10.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8) {
        L2:
            int r10 = r8.readTag();
            if (r10 == 0) goto L6;
            if (mergeFieldFrom(r10, r8) == true) goto L2;
        L6:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(MessageLite r8) {
            if ((r8 instanceof UnknownFieldSet) == false) goto L7;
            return mergeFrom((UnknownFieldSet) r8);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public Builder mergeFrom(UnknownFieldSet r8) {
            if (r8 == UnknownFieldSet.getDefaultInstance()) goto L8;
            Iterator r10 = UnknownFieldSet.access$300(r8).entrySet().iterator();
        L6:
            if (r10.hasNext() == false) goto L8;
            Map.Entry r11 = (Map.Entry) r10.next();
            mergeField(((Integer) r11.getKey()).intValue(), (Field) r11.getValue());
        L8:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r8) {
            CodedInputStream r10 = CodedInputStream.newInstance(r8);
            mergeFrom(r10);
            r10.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r8) {
            CodedInputStream r10 = CodedInputStream.newInstance(r8);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r10);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r10.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r8, int r10, int r11) {
            CodedInputStream r12 = CodedInputStream.newInstance(r8, r10, r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r12.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r8, int r10, int r11, ExtensionRegistryLite r12) {
            return mergeFrom(r8, r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8);
        }
    }

    public static final class Field {
        private static final Field fieldDefaultInstance = null;
        private IntArrayList fixed32;
        private LongArrayList fixed64;
        private List<UnknownFieldSet> group;
        private List<ByteString> lengthDelimited;
        private LongArrayList varint;

        public static final class Builder {
            private Field result;

            private Builder() {
                this.result = new Field(null);
            }

            public static /* synthetic */ Builder access$400() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder addFixed32(int r8) {
                if (Field.access$700(this.result) != null) goto L5;
                Field.access$702(this.result, new IntArrayList());
            L5:
                Field.access$700(this.result).addInt(r8);
                return this;
            }

            public Builder addFixed64(long r8) {
                if (Field.access$800(this.result) != null) goto L5;
                Field.access$802(this.result, new LongArrayList());
            L5:
                Field.access$800(this.result).addLong(r8);
                return this;
            }

            public Builder addGroup(UnknownFieldSet r8) {
                if (Field.access$1000(this.result) != null) goto L5;
                Field.access$1002(this.result, new ArrayList());
            L5:
                Field.access$1000(this.result).add(r8);
                return this;
            }

            public Builder addLengthDelimited(ByteString r8) {
                if (Field.access$900(this.result) != null) goto L5;
                Field.access$902(this.result, new ArrayList());
            L5:
                Field.access$900(this.result).add(r8);
                return this;
            }

            public Builder addVarint(long r8) {
                if (Field.access$600(this.result) != null) goto L5;
                Field.access$602(this.result, new LongArrayList());
            L5:
                Field.access$600(this.result).addLong(r8);
                return this;
            }

            public Field build() {
                Field r8 = new Field(null);
                if (Field.access$600(this.result) != null) goto L5;
                LongArrayList r10 = LongArrayList.emptyList();
            L6:
                Field.access$602(r8, r10);
                if (Field.access$700(this.result) != null) goto L9;
                IntArrayList r11 = IntArrayList.emptyList();
            L10:
                Field.access$702(r8, r11);
                if (Field.access$800(this.result) != null) goto L13;
                LongArrayList r12 = LongArrayList.emptyList();
            L14:
                Field.access$802(r8, r12);
                if (Field.access$900(this.result) != null) goto L17;
                List r13 = Collections.emptyList();
            L18:
                Field.access$902(r8, r13);
                if (Field.access$1000(this.result) != null) goto L21;
                List r14 = Collections.emptyList();
            L22:
                Field.access$1002(r8, r14);
                return r8;
            L21:
                r14 = Collections.unmodifiableList(new ArrayList(Field.access$1000(this.result)));
                goto L22
            L17:
                r13 = Collections.unmodifiableList(new ArrayList(Field.access$900(this.result)));
                goto L18
            L13:
                r12 = new LongArrayList(Field.access$800(this.result), false);
                goto L14
            L9:
                r11 = new IntArrayList(Field.access$700(this.result), false);
                goto L10
            L5:
                r10 = new LongArrayList(Field.access$600(this.result), false);
                goto L6
            }

            public Builder clear() {
                this.result = new Field(null);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Builder clone() {
                ArrayList r8 = null;
                Field r10 = new Field(0 == true ? 1 : 0);
                if (Field.access$600(this.result) != null) goto L5;
                Field.access$602(r10, null);
            L7:
                if (Field.access$700(this.result) != null) goto L9;
                Field.access$702(r10, null);
            L11:
                if (Field.access$800(this.result) != null) goto L13;
                Field.access$802(r10, null);
            L15:
                if (Field.access$900(this.result) != null) goto L17;
                Field.access$902(r10, null);
            L19:
                if (Field.access$1000(this.result) == null) goto L22;
                r8 = new ArrayList(Field.access$1000(this.result));
            L22:
                Field.access$1002(r10, r8);
                Builder r11 = new Builder();
                r11.result = r10;
                return r11;
            L17:
                Field.access$902(r10, new ArrayList(Field.access$900(this.result)));
                goto L19
            L13:
                Field.access$802(r10, new LongArrayList(Field.access$800(this.result), true));
                goto L15
            L9:
                Field.access$702(r10, new IntArrayList(Field.access$700(this.result), true));
                goto L11
            L5:
                Field.access$602(r10, new LongArrayList(Field.access$600(this.result), true));
                goto L7
            }

            public Builder mergeFrom(Field r8) {
                if (Field.access$600(r8).isEmpty() == true) goto L9;
                if (Field.access$600(this.result) != null) goto L7;
                Field.access$602(this.result, new LongArrayList());
            L7:
                Field.access$600(this.result).addAll(Field.access$600(r8));
            L9:
                if (Field.access$700(r8).isEmpty() == true) goto L15;
                if (Field.access$700(this.result) != null) goto L13;
                Field.access$702(this.result, new IntArrayList());
            L13:
                Field.access$700(this.result).addAll(Field.access$700(r8));
            L15:
                if (Field.access$800(r8).isEmpty() == true) goto L21;
                if (Field.access$800(this.result) != null) goto L19;
                Field.access$802(this.result, new LongArrayList());
            L19:
                Field.access$800(this.result).addAll(Field.access$800(r8));
            L21:
                if (Field.access$900(r8).isEmpty() == true) goto L27;
                if (Field.access$900(this.result) != null) goto L25;
                Field.access$902(this.result, new ArrayList());
            L25:
                Field.access$900(this.result).addAll(Field.access$900(r8));
            L27:
                if (Field.access$1000(r8).isEmpty() == false) goto L29;
            L32:
                return this;
            L29:
                if (Field.access$1000(this.result) != null) goto L31;
                Field.access$1002(this.result, new ArrayList());
            L31:
                Field.access$1000(this.result).addAll(Field.access$1000(r8));
                goto L32
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m8clone() {
                return clone();
            }
        }

        static {
            fieldDefaultInstance = newBuilder().build();
        }

        private Field() {
        }

        public /* synthetic */ Field(AnonymousClass1 r8) {
            this();
        }

        public static /* synthetic */ void access$100(Field r8, int r10, Writer r11) {
            r8.writeAsMessageSetExtensionTo(r10, r11);
        }

        public static /* synthetic */ List access$1000(Field r8) {
            return r8.group;
        }

        public static /* synthetic */ List access$1002(Field r8, List r10) {
            r8.group = r10;
            return r10;
        }

        public static /* synthetic */ LongArrayList access$600(Field r8) {
            return r8.varint;
        }

        public static /* synthetic */ LongArrayList access$602(Field r8, LongArrayList r10) {
            r8.varint = r10;
            return r10;
        }

        public static /* synthetic */ IntArrayList access$700(Field r8) {
            return r8.fixed32;
        }

        public static /* synthetic */ IntArrayList access$702(Field r8, IntArrayList r10) {
            r8.fixed32 = r10;
            return r10;
        }

        public static /* synthetic */ LongArrayList access$800(Field r8) {
            return r8.fixed64;
        }

        public static /* synthetic */ LongArrayList access$802(Field r8, LongArrayList r10) {
            r8.fixed64 = r10;
            return r10;
        }

        public static /* synthetic */ List access$900(Field r8) {
            return r8.lengthDelimited;
        }

        public static /* synthetic */ List access$902(Field r8, List r10) {
            r8.lengthDelimited = r10;
            return r10;
        }

        public static Field getDefaultInstance() {
            return fieldDefaultInstance;
        }

        public static Builder newBuilder() {
            return Builder.access$400();
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Field) == true) goto L8;
            return false;
        L8:
            Field r10 = (Field) r8;
            if (Objects.equals(this.varint, r10.varint) == false) goto L20;
            if (Objects.equals(this.fixed32, r10.fixed32) == false) goto L20;
            if (Objects.equals(this.fixed64, r10.fixed64) == false) goto L20;
            if (Objects.equals(this.lengthDelimited, r10.lengthDelimited) == false) goto L20;
            if (Objects.equals(this.group, r10.group) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public List<Integer> getFixed32List() {
            return this.fixed32;
        }

        public List<Long> getFixed64List() {
            return this.fixed64;
        }

        public List<UnknownFieldSet> getGroupList() {
            return this.group;
        }

        public List<ByteString> getLengthDelimitedList() {
            return this.lengthDelimited;
        }

        public int getSerializedSize(int r8) {
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
        L4:
            if (r11 >= this.varint.size()) goto L6;
            r12 = r12 + CodedOutputStream.computeUInt64Size(r8, this.varint.getLong(r11));
            r11 = r11 + 1;
            goto L4
        L6:
            int r13 = 0;
        L8:
            if (r13 >= this.fixed32.size()) goto L10;
            r12 = r12 + CodedOutputStream.computeFixed32Size(r8, this.fixed32.getInt(r13));
            r13 = r13 + 1;
            goto L8
        L10:
            int r14 = 0;
        L12:
            if (r14 >= this.fixed64.size()) goto L14;
            r12 = r12 + CodedOutputStream.computeFixed64Size(r8, this.fixed64.getLong(r14));
            r14 = r14 + 1;
            goto L12
        L14:
            int r15 = 0;
        L16:
            if (r15 >= this.lengthDelimited.size()) goto L19;
            r12 = r12 + CodedOutputStream.computeBytesSize(r8, this.lengthDelimited.get(r15));
            r15 = r15 + 1;
        L19:
            if (r10 >= this.group.size()) goto L21;
            r12 = r12 + CodedOutputStream.computeGroupSize(r8, this.group.get(r10));
            r10 = r10 + 1;
            goto L19
        L21:
            return r12;
        }

        public int getSerializedSizeAsMessageSetExtension(int r8) {
            int r10 = 0;
            int r11 = 0;
        L4:
            if (r10 >= this.lengthDelimited.size()) goto L6;
            r11 = r11 + CodedOutputStream.computeRawMessageSetExtensionSize(r8, this.lengthDelimited.get(r10));
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        public List<Long> getVarintList() {
            return this.varint;
        }

        public int hashCode() {
            int r8 = (Objects.hashCode(this.varint) + 31) * 31;
            int r10 = (Objects.hashCode(this.fixed32) + r8) * 31;
            int r11 = (Objects.hashCode(this.fixed64) + r10) * 31;
            int r12 = (Objects.hashCode(this.lengthDelimited) + r11) * 31;
            return Objects.hashCode(this.group) + r12;
        }

        public ByteString toByteString(int r8) {
            ByteString.CodedBuilder r10 = ByteString.newCodedBuilder(getSerializedSize(r8));     // Catch: IOException -> L4
            writeTo(r8, r10.getCodedOutput());     // Catch: IOException -> L4
            return r10.build();
        L4:
            e = move-exception;
            throw new RuntimeException("Serializing to a ByteString should never fail with an IOException", e);
        }

        public void writeAsMessageSetExtensionTo(int r8, CodedOutputStream r10) {
            int r11 = 0;
        L4:
            if (r11 >= this.lengthDelimited.size()) goto L6;
            r10.writeRawMessageSetExtension(r8, this.lengthDelimited.get(r11));
            r11 = r11 + 1;
            goto L4
        }

        public void writeTo(int r8, CodedOutputStream r10) {
            int r11 = 0;
            int r12 = 0;
        L4:
            if (r12 >= this.varint.size()) goto L6;
            r10.writeUInt64(r8, this.varint.getLong(r12));
            r12 = r12 + 1;
            goto L4
        L6:
            int r13 = 0;
        L8:
            if (r13 >= this.fixed32.size()) goto L10;
            r10.writeFixed32(r8, this.fixed32.getInt(r13));
            r13 = r13 + 1;
            goto L8
        L10:
            int r14 = 0;
        L12:
            if (r14 >= this.fixed64.size()) goto L14;
            r10.writeFixed64(r8, this.fixed64.getLong(r14));
            r14 = r14 + 1;
            goto L12
        L14:
            int r15 = 0;
        L16:
            if (r15 >= this.lengthDelimited.size()) goto L19;
            r10.writeBytes(r8, this.lengthDelimited.get(r15));
            r15 = r15 + 1;
        L19:
            if (r11 >= this.group.size()) goto L21;
            r10.writeGroup(r8, this.group.get(r11));
            r11 = r11 + 1;
            goto L19
        }

        public static Builder newBuilder(Field r8) {
            return newBuilder().mergeFrom(r8);
        }

        private void writeAsMessageSetExtensionTo(int r8, Writer r10) {
            if (r10.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L7;
            int r11 = this.lengthDelimited.size() - 1;
        L5:
            if (r11 < 0) goto L11;
            r10.writeMessageSetItem(r8, this.lengthDelimited.get(r11));
            r11 = r11 - 1;
            goto L5
        L11:
            return;
        L7:
            int r12 = 0;
        L9:
            if (r12 >= this.lengthDelimited.size()) goto L14;
            r10.writeMessageSetItem(r8, this.lengthDelimited.get(r12));
            r12 = r12 + 1;
            goto L9
        }

        public void writeTo(int r8, Writer r10) {
            int r11 = 0;
            r10.writeInt64List(r8, this.varint, false);
            r10.writeFixed32List(r8, this.fixed32, false);
            r10.writeFixed64List(r8, this.fixed64, false);
            r10.writeBytesList(r8, this.lengthDelimited);
            if (r10.fieldOrder() == Writer.FieldOrder.ASCENDING) goto L5;
            int r12 = this.group.size() - 1;
        L8:
            if (r12 < 0) goto L13;
            r10.writeEndGroup(r8);
            this.group.get(r12).writeTo(r10);
            r10.writeStartGroup(r8);
            r12 = r12 - 1;
            goto L8
        L13:
            return;
        L5:
            if (r11 >= this.group.size()) goto L10;
            r10.writeStartGroup(r8);
            this.group.get(r11).writeTo(r10);
            r10.writeEndGroup(r8);
            r11 = r11 + 1;
            goto L5
        }
    }

    public static final class Parser extends AbstractParser<UnknownFieldSet> {
        public Parser() {
        }

        @Override // com.google.protobuf.Parser
        public UnknownFieldSet parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            Builder r11 = UnknownFieldSet.newBuilder();
            r11.mergeFrom(r8);     // Catch: IOException -> L6 InvalidProtocolBufferException -> L9
        L5:
            return r11.buildPartial();
        L9:
            e = move-exception;
            throw e.setUnfinishedMessage(r11.buildPartial());
        L6:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r11.buildPartial());
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return parsePartialFrom(r8, r10);
        }
    }

    static {
        defaultInstance = new UnknownFieldSet(new TreeMap());
        PARSER = new Parser();
    }

    private UnknownFieldSet(TreeMap<Integer, Field> r8) {
        this.fields = r8;
    }

    public static /* synthetic */ TreeMap access$300(UnknownFieldSet r8) {
        return r8.fields;
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    public static Builder newBuilder() {
        return Builder.access$000();
    }

    public static UnknownFieldSet parseFrom(ByteString r8) {
        return newBuilder().mergeFrom(r8).build();
    }

    public Map<Integer, Field> asMap() {
        if (this.fields.isEmpty() == false) goto L7;
        return Collections.emptyMap();
    L7:
        return (Map) this.fields.clone();
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof UnknownFieldSet) == true) goto L8;
    L10:
        return false;
    L8:
        if (this.fields.equals(((UnknownFieldSet) r8).fields) == false) goto L10;
        return true;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    public Field getField(int r8) {
        Field r10 = this.fields.get(Integer.valueOf(r8));
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Field.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ com.google.protobuf.Parser getParserForType() {
        return getParserForType();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = 0;
        if (this.fields.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<Integer, Field>> r10 = this.fields.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<Integer, Field> r11 = r10.next();
        r8 = r8 + r11.getValue().getSerializedSize(r11.getKey().intValue());
        goto L7
    L9:
        return r8;
    }

    public int getSerializedSizeAsMessageSet() {
        int r8 = 0;
        if (this.fields.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<Integer, Field>> r10 = this.fields.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<Integer, Field> r11 = r10.next();
        r8 = r8 + r11.getValue().getSerializedSizeAsMessageSetExtension(r11.getKey().intValue());
        goto L7
    L9:
        return r8;
    }

    public boolean hasField(int r8) {
        return this.fields.containsKey(Integer.valueOf(r8));
    }

    public int hashCode() {
        if (this.fields.isEmpty() == false) goto L7;
        return 0;
    L7:
        return this.fields.hashCode();
    }

    public boolean isEmpty() {
        return this.fields.isEmpty();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r8 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r10 = CodedOutputStream.newInstance(r8);     // Catch: IOException -> L4
        writeTo(r10);     // Catch: IOException -> L4
        r10.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r8;
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r8 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r8.getCodedOutput());     // Catch: IOException -> L4
        return r8.build();
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
    }

    public String toString() {
        return TextFormat.printer().printToString(this);
    }

    public void writeAsMessageSetTo(CodedOutputStream r8) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, Field>> r10 = this.fields.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<Integer, Field> r11 = r10.next();
        r11.getValue().writeAsMessageSetExtensionTo(r11.getKey().intValue(), r8);
        goto L7
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r8) {
        CodedOutputStream r10 = CodedOutputStream.newInstance(r8);
        r10.writeUInt32NoTag(getSerializedSize());
        writeTo(r10);
        r10.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, Field>> r10 = this.fields.entrySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        Map.Entry<Integer, Field> r11 = r10.next();
        r11.getValue().writeTo(r11.getKey().intValue(), r8);
        goto L7
    }

    public /* synthetic */ UnknownFieldSet(TreeMap r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Builder newBuilder(UnknownFieldSet r8) {
        return newBuilder().mergeFrom(r8);
    }

    public static UnknownFieldSet parseFrom(CodedInputStream r8) {
        return newBuilder().mergeFrom(r8).build();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final Parser getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    public void writeAsMessageSetTo(Writer r8) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Writer.FieldOrder r10 = r8.fieldOrder();
        Writer.FieldOrder r11 = Writer.FieldOrder.DESCENDING;
        TreeMap<Integer, Field> r12 = this.fields;
        if (r10 != r11) goto L11;
        Iterator<Map.Entry<Integer, Field>> r13 = r12.descendingMap().entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        Map.Entry<Integer, Field> r14 = r13.next();
        Field.access$100(r14.getValue(), r14.getKey().intValue(), r8);
        goto L9
    L15:
        return;
    L11:
        Iterator<Map.Entry<Integer, Field>> r15 = r12.entrySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L18;
        Map.Entry<Integer, Field> r16 = r15.next();
        Field.access$100(r16.getValue(), r16.getKey().intValue(), r8);
        goto L13
    }

    public void writeTo(Writer r8) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Writer.FieldOrder r10 = r8.fieldOrder();
        Writer.FieldOrder r11 = Writer.FieldOrder.DESCENDING;
        TreeMap<Integer, Field> r12 = this.fields;
        if (r10 != r11) goto L11;
        Iterator<Map.Entry<Integer, Field>> r13 = r12.descendingMap().entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L15;
        Map.Entry<Integer, Field> r14 = r13.next();
        r14.getValue().writeTo(r14.getKey().intValue(), r8);
        goto L9
    L15:
        return;
    L11:
        Iterator<Map.Entry<Integer, Field>> r15 = r12.entrySet().iterator();
    L13:
        if (r15.hasNext() == false) goto L18;
        Map.Entry<Integer, Field> r16 = r15.next();
        r16.getValue().writeTo(r16.getKey().intValue(), r8);
        goto L13
    }

    public static UnknownFieldSet parseFrom(InputStream r8) {
        return newBuilder().mergeFrom(r8).build();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r8) {
        CodedOutputStream r10 = CodedOutputStream.newInstance(r8);
        writeTo(r10);
        r10.flush();
    }

    public static UnknownFieldSet parseFrom(byte[] r8) {
        return newBuilder().mergeFrom(r8).build();
    }
}
