package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public final class UnknownFieldSet implements MessageLite {
    private static final Parser PARSER = null;
    private static final UnknownFieldSet defaultInstance = null;
    private final TreeMap<Integer, Field> fields;

    /* JADX INFO: renamed from: com.google.protobuf.UnknownFieldSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder implements MessageLite.Builder {
        private TreeMap<Integer, Field.Builder> fieldBuilders;

        private Builder() {
            this.fieldBuilders = new TreeMap();
        }

        static /* synthetic */ Builder access$000() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private Field.Builder getFieldBuilder(int r10) {
            if (r10 != 0) goto L5;
            return null;
        L5:
            Field.Builder r11 = this.fieldBuilders.get(Integer.valueOf(r10));
            if (r11 != null) goto L9;
            Field.Builder r12 = Field.newBuilder();
            this.fieldBuilders.put(Integer.valueOf(r10), r12);
            return r12;
        L9:
            return r11;
        }

        public Builder addField(int r10, Field r11) {
            if (r10 <= 0) goto L6;
            this.fieldBuilders.put(Integer.valueOf(r10), Field.newBuilder(r11));
            return this;
        L6:
            throw new IllegalArgumentException(r10 + " is not a valid field number.");
        }

        public Map<Integer, Field> asMap() {
            if (this.fieldBuilders.isEmpty() == true) goto L5;
            TreeMap r10 = new TreeMap();
            Iterator<Map.Entry<Integer, Field.Builder>> r11 = this.fieldBuilders.entrySet().iterator();
        L8:
            if (r11.hasNext() == false) goto L11;
            Map.Entry<Integer, Field.Builder> r12 = r11.next();
            r10.put(r12.getKey(), r12.getValue().build());
            goto L8
        L11:
            return Collections.unmodifiableMap(r10);
        L5:
            return Collections.emptyMap();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet build() {
            if (this.fieldBuilders.isEmpty() == true) goto L12;
            TreeMap r10 = new TreeMap();
            Iterator<Map.Entry<Integer, Field.Builder>> r11 = this.fieldBuilders.entrySet().iterator();
        L7:
            if (r11.hasNext() == false) goto L10;
            Map.Entry<Integer, Field.Builder> r12 = r11.next();
            r10.put(r12.getKey(), r12.getValue().build());
            goto L7
        L10:
            return new UnknownFieldSet(r10, null);
        L12:
            return UnknownFieldSet.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet buildPartial() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            this.fieldBuilders = new TreeMap();
            return this;
        }

        public Builder clearField(int r10) {
            if (r10 <= 0) goto L8;
            if (this.fieldBuilders.containsKey(Integer.valueOf(r10)) == false) goto L6;
            this.fieldBuilders.remove(Integer.valueOf(r10));
        L6:
            return this;
        L8:
            throw new IllegalArgumentException(r10 + " is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            Builder r10 = UnknownFieldSet.newBuilder();
            Iterator<Map.Entry<Integer, Field.Builder>> r11 = this.fieldBuilders.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry<Integer, Field.Builder> r12 = r11.next();
            Integer r13 = r12.getKey();
            Field.Builder r14 = r12.getValue();
            r10.fieldBuilders.put(r13, r14.clone());
            goto L4
        L6:
            return r10;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m15clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getDefaultInstanceForType() {
            return UnknownFieldSet.getDefaultInstance();
        }

        public boolean hasField(int r10) {
            return this.fieldBuilders.containsKey(Integer.valueOf(r10));
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r10) {
            int r11 = r10.read();
            if (r11 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new AbstractMessageLite.Builder.LimitedInputStream(r10, CodedInputStream.readRawVarint32(r11, r10)));
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
            return mergeDelimitedFrom(r10);
        }

        public Builder mergeField(int r10, Field r11) {
            if (r10 <= 0) goto L9;
            if (hasField(r10) == false) goto L6;
            getFieldBuilder(r10).mergeFrom(r11);
        L7:
            return this;
        L6:
            addField(r10, r11);
            goto L7
        L9:
            throw new IllegalArgumentException(r10 + " is not a valid field number.");
        }

        public boolean mergeFieldFrom(int r10, CodedInputStream r11) {
            int r12 = WireFormat.getTagFieldNumber(r10);
            int r13 = WireFormat.getTagWireType(r10);
            if (r13 == 0) goto L25;
            if (r13 != 1) goto L6;
            getFieldBuilder(r12).addFixed64(r11.readFixed64());
            return true;
        L6:
            if (r13 != 2) goto L8;
            getFieldBuilder(r12).addLengthDelimited(r11.readBytes());
            return true;
        L8:
            if (r13 != 3) goto L10;
            Builder r14 = UnknownFieldSet.newBuilder();
            r11.readGroup(r12, r14, ExtensionRegistry.getEmptyRegistry());
            getFieldBuilder(r12).addGroup(r14.build());
            return true;
        L10:
            if (r13 != 4) goto L12;
            r11.checkValidEndTag();
            return false;
        L12:
            if (r13 != 5) goto L16;
            getFieldBuilder(r12).addFixed32(r11.readFixed32());
            return true;
        L16:
            throw InvalidProtocolBufferException.invalidWireType();
        L25:
            getFieldBuilder(r12).addVarint(r11.readInt64());
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12) {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return mergeFrom(r10, r11, r12, r13);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10, r11);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r10) {
            CodedInputStream r11 = r10.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r11.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10) {
        L2:
            int r11 = r10.readTag();
            if (r11 == 0) goto L6;
            if (mergeFieldFrom(r11, r10) == true) goto L2;
        L6:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(MessageLite r10) {
            if ((r10 instanceof UnknownFieldSet) == false) goto L7;
            return mergeFrom((UnknownFieldSet) r10);
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public Builder mergeFrom(UnknownFieldSet r10) {
            if (r10 == UnknownFieldSet.getDefaultInstance()) goto L8;
            Iterator r11 = UnknownFieldSet.access$300(r10).entrySet().iterator();
        L6:
            if (r11.hasNext() == false) goto L8;
            Map.Entry r12 = (Map.Entry) r11.next();
            mergeField(((Integer) r12.getKey()).intValue(), (Field) r12.getValue());
        L8:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r10) {
            CodedInputStream r11 = CodedInputStream.newInstance(r10);
            mergeFrom(r11);
            r11.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r10) {
            CodedInputStream r11 = CodedInputStream.newInstance(r10);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r11);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r11.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r10, int r11, int r12) {
            CodedInputStream r13 = CodedInputStream.newInstance(r10, r11, r12);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r13);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r13.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r10, int r11, int r12, ExtensionRegistryLite r13) {
            return mergeFrom(r10, r11, r12);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r10, ExtensionRegistryLite r11) {
            return mergeFrom(r10);
        }

        public Builder mergeLengthDelimitedField(int r10, ByteString r11) {
            if (r10 <= 0) goto L6;
            getFieldBuilder(r10).addLengthDelimited(r11);
            return this;
        L6:
            throw new IllegalArgumentException(r10 + " is not a valid field number.");
        }

        public Builder mergeVarintField(int r10, int r11) {
            if (r10 <= 0) goto L6;
            getFieldBuilder(r10).addVarint(r11);
            return this;
        L6:
            throw new IllegalArgumentException(r10 + " is not a valid field number.");
        }
    }

    public static final class Field {
        private static final Field fieldDefaultInstance = null;
        private List<Integer> fixed32;
        private List<Long> fixed64;
        private List<UnknownFieldSet> group;
        private List<ByteString> lengthDelimited;
        private List<Long> varint;

        public static final class Builder {
            private Field result;

            private Builder() {
                this.result = new Field(null);
            }

            static /* synthetic */ Builder access$400() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            public Builder addFixed32(int r10) {
                if (Field.access$700(this.result) != null) goto L5;
                Field.access$702(this.result, new ArrayList());
            L5:
                Field.access$700(this.result).add(Integer.valueOf(r10));
                return this;
            }

            public Builder addFixed64(long r10) {
                if (Field.access$800(this.result) != null) goto L5;
                Field.access$802(this.result, new ArrayList());
            L5:
                Field.access$800(this.result).add(Long.valueOf(r10));
                return this;
            }

            public Builder addGroup(UnknownFieldSet r10) {
                if (Field.access$1000(this.result) != null) goto L5;
                Field.access$1002(this.result, new ArrayList());
            L5:
                Field.access$1000(this.result).add(r10);
                return this;
            }

            public Builder addLengthDelimited(ByteString r10) {
                if (Field.access$900(this.result) != null) goto L5;
                Field.access$902(this.result, new ArrayList());
            L5:
                Field.access$900(this.result).add(r10);
                return this;
            }

            public Builder addVarint(long r10) {
                if (Field.access$600(this.result) != null) goto L5;
                Field.access$602(this.result, new ArrayList());
            L5:
                Field.access$600(this.result).add(Long.valueOf(r10));
                return this;
            }

            public Field build() {
                Field r10 = new Field(null);
                if (Field.access$600(this.result) != null) goto L5;
                List r11 = Collections.emptyList();
            L6:
                Field.access$602(r10, r11);
                if (Field.access$700(this.result) != null) goto L9;
                List r12 = Collections.emptyList();
            L10:
                Field.access$702(r10, r12);
                if (Field.access$800(this.result) != null) goto L13;
                List r13 = Collections.emptyList();
            L14:
                Field.access$802(r10, r13);
                if (Field.access$900(this.result) != null) goto L17;
                List r14 = Collections.emptyList();
            L18:
                Field.access$902(r10, r14);
                if (Field.access$1000(this.result) != null) goto L21;
                List r15 = Collections.emptyList();
            L22:
                Field.access$1002(r10, r15);
                return r10;
            L21:
                r15 = Collections.unmodifiableList(new ArrayList(Field.access$1000(this.result)));
                goto L22
            L17:
                r14 = Collections.unmodifiableList(new ArrayList(Field.access$900(this.result)));
                goto L18
            L13:
                r13 = Collections.unmodifiableList(new ArrayList(Field.access$800(this.result)));
                goto L14
            L9:
                r12 = Collections.unmodifiableList(new ArrayList(Field.access$700(this.result)));
                goto L10
            L5:
                r11 = Collections.unmodifiableList(new ArrayList(Field.access$600(this.result)));
                goto L6
            }

            public Builder clear() {
                this.result = new Field(null);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Builder clone() {
                ArrayList r10 = null;
                Field r11 = new Field(0 == true ? 1 : 0);
                if (Field.access$600(this.result) != null) goto L5;
                Field.access$602(r11, null);
            L7:
                if (Field.access$700(this.result) != null) goto L9;
                Field.access$702(r11, null);
            L11:
                if (Field.access$800(this.result) != null) goto L13;
                Field.access$802(r11, null);
            L15:
                if (Field.access$900(this.result) != null) goto L17;
                Field.access$902(r11, null);
            L19:
                if (Field.access$1000(this.result) == null) goto L22;
                r10 = new ArrayList(Field.access$1000(this.result));
            L22:
                Field.access$1002(r11, r10);
                Builder r12 = new Builder();
                r12.result = r11;
                return r12;
            L17:
                Field.access$902(r11, new ArrayList(Field.access$900(this.result)));
                goto L19
            L13:
                Field.access$802(r11, new ArrayList(Field.access$800(this.result)));
                goto L15
            L9:
                Field.access$702(r11, new ArrayList(Field.access$700(this.result)));
                goto L11
            L5:
                Field.access$602(r11, new ArrayList(Field.access$600(this.result)));
                goto L7
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m16clone() {
                return clone();
            }

            public Builder mergeFrom(Field r10) {
                if (Field.access$600(r10).isEmpty() == true) goto L9;
                if (Field.access$600(this.result) != null) goto L7;
                Field.access$602(this.result, new ArrayList());
            L7:
                Field.access$600(this.result).addAll(Field.access$600(r10));
            L9:
                if (Field.access$700(r10).isEmpty() == true) goto L15;
                if (Field.access$700(this.result) != null) goto L13;
                Field.access$702(this.result, new ArrayList());
            L13:
                Field.access$700(this.result).addAll(Field.access$700(r10));
            L15:
                if (Field.access$800(r10).isEmpty() == true) goto L21;
                if (Field.access$800(this.result) != null) goto L19;
                Field.access$802(this.result, new ArrayList());
            L19:
                Field.access$800(this.result).addAll(Field.access$800(r10));
            L21:
                if (Field.access$900(r10).isEmpty() == true) goto L27;
                if (Field.access$900(this.result) != null) goto L25;
                Field.access$902(this.result, new ArrayList());
            L25:
                Field.access$900(this.result).addAll(Field.access$900(r10));
            L27:
                if (Field.access$1000(r10).isEmpty() == false) goto L29;
            L32:
                return this;
            L29:
                if (Field.access$1000(this.result) != null) goto L31;
                Field.access$1002(this.result, new ArrayList());
            L31:
                Field.access$1000(this.result).addAll(Field.access$1000(r10));
                goto L32
            }
        }

        static {
            fieldDefaultInstance = newBuilder().build();
        }

        private Field() {
        }

        /* synthetic */ Field(AnonymousClass1 r10) {
            this();
        }

        static /* synthetic */ void access$100(Field r10, int r11, Writer r12) {
            r10.writeAsMessageSetExtensionTo(r11, r12);
        }

        static /* synthetic */ List access$1000(Field r10) {
            return r10.group;
        }

        static /* synthetic */ List access$1002(Field r10, List r11) {
            r10.group = r11;
            return r11;
        }

        static /* synthetic */ List access$600(Field r10) {
            return r10.varint;
        }

        static /* synthetic */ List access$602(Field r10, List r11) {
            r10.varint = r11;
            return r11;
        }

        static /* synthetic */ List access$700(Field r10) {
            return r10.fixed32;
        }

        static /* synthetic */ List access$702(Field r10, List r11) {
            r10.fixed32 = r11;
            return r11;
        }

        static /* synthetic */ List access$800(Field r10) {
            return r10.fixed64;
        }

        static /* synthetic */ List access$802(Field r10, List r11) {
            r10.fixed64 = r11;
            return r11;
        }

        static /* synthetic */ List access$900(Field r10) {
            return r10.lengthDelimited;
        }

        static /* synthetic */ List access$902(Field r10, List r11) {
            r10.lengthDelimited = r11;
            return r11;
        }

        public static Field getDefaultInstance() {
            return fieldDefaultInstance;
        }

        private Object[] getIdentityArray() {
            return new Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
        }

        public static Builder newBuilder() {
            return Builder.access$400();
        }

        public static Builder newBuilder(Field r10) {
            return newBuilder().mergeFrom(r10);
        }

        private void writeAsMessageSetExtensionTo(int r10, Writer r11) {
            if (r11.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L7;
            int r12 = this.lengthDelimited.size() - 1;
        L5:
            if (r12 < 0) goto L11;
            r11.writeMessageSetItem(r10, this.lengthDelimited.get(r12));
            r12 = r12 - 1;
            goto L5
        L11:
            return;
        L7:
            int r13 = 0;
        L9:
            if (r13 >= this.lengthDelimited.size()) goto L14;
            r11.writeMessageSetItem(r10, this.lengthDelimited.get(r13));
            r13 = r13 + 1;
            goto L9
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Field) == true) goto L10;
            return false;
        L10:
            return Arrays.equals(getIdentityArray(), ((Field) r10).getIdentityArray());
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

        public int getSerializedSize(int r10) {
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
        L4:
            if (r12 >= this.varint.size()) goto L6;
            r13 = r13 + CodedOutputStream.computeUInt64Size(r10, this.varint.get(r12).longValue());
            r12 = r12 + 1;
            goto L4
        L6:
            int r14 = 0;
        L8:
            if (r14 >= this.fixed32.size()) goto L10;
            r13 = r13 + CodedOutputStream.computeFixed32Size(r10, this.fixed32.get(r14).intValue());
            r14 = r14 + 1;
            goto L8
        L10:
            int r15 = 0;
        L12:
            if (r15 >= this.fixed64.size()) goto L14;
            r13 = r13 + CodedOutputStream.computeFixed64Size(r10, this.fixed64.get(r15).longValue());
            r15 = r15 + 1;
            goto L12
        L14:
            int r16 = 0;
        L16:
            if (r16 >= this.lengthDelimited.size()) goto L19;
            r13 = r13 + CodedOutputStream.computeBytesSize(r10, this.lengthDelimited.get(r16));
            r16 = r16 + 1;
        L19:
            if (r11 >= this.group.size()) goto L21;
            r13 = r13 + CodedOutputStream.computeGroupSize(r10, this.group.get(r11));
            r11 = r11 + 1;
            goto L19
        L21:
            return r13;
        }

        public int getSerializedSizeAsMessageSetExtension(int r10) {
            int r11 = 0;
            int r12 = 0;
        L4:
            if (r11 >= this.lengthDelimited.size()) goto L6;
            r12 = r12 + CodedOutputStream.computeRawMessageSetExtensionSize(r10, this.lengthDelimited.get(r11));
            r11 = r11 + 1;
            goto L4
        L6:
            return r12;
        }

        public List<Long> getVarintList() {
            return this.varint;
        }

        public int hashCode() {
            return Arrays.hashCode(getIdentityArray());
        }

        public ByteString toByteString(int r10) {
            ByteString.CodedBuilder r11 = ByteString.newCodedBuilder(getSerializedSize(r10));     // Catch: IOException -> L4
            writeTo(r10, r11.getCodedOutput());     // Catch: IOException -> L4
            return r11.build();
        L4:
            e = move-exception;
            throw new RuntimeException("Serializing to a ByteString should never fail with an IOException", e);
        }

        public void writeAsMessageSetExtensionTo(int r10, CodedOutputStream r11) {
            int r12 = 0;
        L4:
            if (r12 >= this.lengthDelimited.size()) goto L6;
            r11.writeRawMessageSetExtension(r10, this.lengthDelimited.get(r12));
            r12 = r12 + 1;
            goto L4
        }

        public void writeTo(int r10, CodedOutputStream r11) {
            int r12 = 0;
            int r13 = 0;
        L4:
            if (r13 >= this.varint.size()) goto L6;
            r11.writeUInt64(r10, this.varint.get(r13).longValue());
            r13 = r13 + 1;
            goto L4
        L6:
            int r14 = 0;
        L8:
            if (r14 >= this.fixed32.size()) goto L10;
            r11.writeFixed32(r10, this.fixed32.get(r14).intValue());
            r14 = r14 + 1;
            goto L8
        L10:
            int r15 = 0;
        L12:
            if (r15 >= this.fixed64.size()) goto L14;
            r11.writeFixed64(r10, this.fixed64.get(r15).longValue());
            r15 = r15 + 1;
            goto L12
        L14:
            int r16 = 0;
        L16:
            if (r16 >= this.lengthDelimited.size()) goto L19;
            r11.writeBytes(r10, this.lengthDelimited.get(r16));
            r16 = r16 + 1;
        L19:
            if (r12 >= this.group.size()) goto L21;
            r11.writeGroup(r10, this.group.get(r12));
            r12 = r12 + 1;
            goto L19
        }

        void writeTo(int r10, Writer r11) {
            int r12 = 0;
            r11.writeInt64List(r10, this.varint, false);
            r11.writeFixed32List(r10, this.fixed32, false);
            r11.writeFixed64List(r10, this.fixed64, false);
            r11.writeBytesList(r10, this.lengthDelimited);
            if (r11.fieldOrder() == Writer.FieldOrder.ASCENDING) goto L5;
            int r13 = this.group.size() - 1;
        L8:
            if (r13 < 0) goto L13;
            r11.writeEndGroup(r10);
            this.group.get(r13).writeTo(r11);
            r11.writeStartGroup(r10);
            r13 = r13 - 1;
            goto L8
        L13:
            return;
        L5:
            if (r12 >= this.group.size()) goto L10;
            r11.writeStartGroup(r10);
            this.group.get(r12).writeTo(r11);
            r11.writeEndGroup(r10);
            r12 = r12 + 1;
            goto L5
        }
    }

    public static final class Parser extends AbstractParser<UnknownFieldSet> {
        public Parser() {
        }

        @Override // com.google.protobuf.Parser
        public UnknownFieldSet parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            Builder r12 = UnknownFieldSet.newBuilder();
            r12.mergeFrom(r10);     // Catch: IOException -> L6 InvalidProtocolBufferException -> L9
        L5:
            return r12.buildPartial();
        L9:
            e = move-exception;
            throw e.setUnfinishedMessage(r12.buildPartial());
        L6:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r12.buildPartial());
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return parsePartialFrom(r10, r11);
        }
    }

    static {
        defaultInstance = new UnknownFieldSet(new TreeMap());
        PARSER = new Parser();
    }

    private UnknownFieldSet(TreeMap<Integer, Field> r10) {
        this.fields = r10;
    }

    /* synthetic */ UnknownFieldSet(TreeMap r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ TreeMap access$300(UnknownFieldSet r10) {
        return r10.fields;
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    public static Builder newBuilder() {
        return Builder.access$000();
    }

    public static Builder newBuilder(UnknownFieldSet r10) {
        return newBuilder().mergeFrom(r10);
    }

    public static UnknownFieldSet parseFrom(ByteString r10) {
        return newBuilder().mergeFrom(r10).build();
    }

    public static UnknownFieldSet parseFrom(CodedInputStream r10) {
        return newBuilder().mergeFrom(r10).build();
    }

    public static UnknownFieldSet parseFrom(InputStream r10) {
        return newBuilder().mergeFrom(r10).build();
    }

    public static UnknownFieldSet parseFrom(byte[] r10) {
        return newBuilder().mergeFrom(r10).build();
    }

    public Map<Integer, Field> asMap() {
        if (this.fields.isEmpty() == false) goto L7;
        return Collections.emptyMap();
    L7:
        return (Map) this.fields.clone();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof UnknownFieldSet) == true) goto L8;
    L10:
        return false;
    L8:
        if (this.fields.equals(((UnknownFieldSet) r10).fields) == false) goto L10;
        return true;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    public Field getField(int r10) {
        Field r11 = this.fields.get(Integer.valueOf(r10));
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Field.getDefaultInstance();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ com.google.protobuf.Parser getParserForType() {
        return getParserForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public final Parser getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r10 = 0;
        if (this.fields.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<Integer, Field>> r11 = this.fields.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<Integer, Field> r12 = r11.next();
        r10 = r10 + r12.getValue().getSerializedSize(r12.getKey().intValue());
        goto L7
    L9:
        return r10;
    }

    public int getSerializedSizeAsMessageSet() {
        int r10 = 0;
        if (this.fields.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<Integer, Field>> r11 = this.fields.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<Integer, Field> r12 = r11.next();
        r10 = r10 + r12.getValue().getSerializedSizeAsMessageSetExtension(r12.getKey().intValue());
        goto L7
    L9:
        return r10;
    }

    public boolean hasField(int r10) {
        return this.fields.containsKey(Integer.valueOf(r10));
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
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        byte[] r10 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10);     // Catch: IOException -> L4
        writeTo(r11);     // Catch: IOException -> L4
        r11.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r10;
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r10 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r10.getCodedOutput());     // Catch: IOException -> L4
        return r10.build();
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
    }

    public String toString() {
        return TextFormat.printer().printToString(this);
    }

    public void writeAsMessageSetTo(CodedOutputStream r10) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, Field>> r11 = this.fields.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<Integer, Field> r12 = r11.next();
        r12.getValue().writeAsMessageSetExtensionTo(r12.getKey().intValue(), r10);
        goto L7
    }

    void writeAsMessageSetTo(Writer r10) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Writer.FieldOrder r11 = r10.fieldOrder();
        Writer.FieldOrder r12 = Writer.FieldOrder.DESCENDING;
        TreeMap<Integer, Field> r13 = this.fields;
        if (r11 != r12) goto L11;
        Iterator<Map.Entry<Integer, Field>> r14 = r13.descendingMap().entrySet().iterator();
    L9:
        if (r14.hasNext() == false) goto L15;
        Map.Entry<Integer, Field> r15 = r14.next();
        Field.access$100(r15.getValue(), r15.getKey().intValue(), r10);
        goto L9
    L15:
        return;
    L11:
        Iterator<Map.Entry<Integer, Field>> r16 = r13.entrySet().iterator();
    L13:
        if (r16.hasNext() == false) goto L18;
        Map.Entry<Integer, Field> r17 = r16.next();
        Field.access$100(r17.getValue(), r17.getKey().intValue(), r10);
        goto L13
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r10) {
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10);
        r11.writeUInt32NoTag(getSerializedSize());
        writeTo(r11);
        r11.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, Field>> r11 = this.fields.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<Integer, Field> r12 = r11.next();
        r12.getValue().writeTo(r12.getKey().intValue(), r10);
        goto L7
    }

    void writeTo(Writer r10) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Writer.FieldOrder r11 = r10.fieldOrder();
        Writer.FieldOrder r12 = Writer.FieldOrder.DESCENDING;
        TreeMap<Integer, Field> r13 = this.fields;
        if (r11 != r12) goto L11;
        Iterator<Map.Entry<Integer, Field>> r14 = r13.descendingMap().entrySet().iterator();
    L9:
        if (r14.hasNext() == false) goto L15;
        Map.Entry<Integer, Field> r15 = r14.next();
        r15.getValue().writeTo(r15.getKey().intValue(), r10);
        goto L9
    L15:
        return;
    L11:
        Iterator<Map.Entry<Integer, Field>> r16 = r13.entrySet().iterator();
    L13:
        if (r16.hasNext() == false) goto L18;
        Map.Entry<Integer, Field> r17 = r16.next();
        r17.getValue().writeTo(r17.getKey().intValue(), r10);
        goto L13
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r10) {
        CodedOutputStream r11 = CodedOutputStream.newInstance(r10);
        writeTo(r11);
        r11.flush();
    }
}
