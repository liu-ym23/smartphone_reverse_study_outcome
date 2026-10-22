package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes3.dex */
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

        private Field.Builder getFieldBuilder(int r4) {
            if (r4 != 0) goto L5;
            return null;
        L5:
            Field.Builder r0 = (Field.Builder) ZeusTransformUtils.preCheckCast(this.fieldBuilders.get(Integer.valueOf(r4)), Field.Builder.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L9;
            Field.Builder r1 = Field.newBuilder();
            this.fieldBuilders.put(Integer.valueOf(r4), r1);
            return r1;
        L9:
            return r0;
        }

        public Builder addField(int r2, Field r3) {
            if (r2 <= 0) goto L6;
            this.fieldBuilders.put(Integer.valueOf(r2), Field.newBuilder(r3));
            return this;
        L6:
            throw new IllegalArgumentException(r2 + " is not a valid field number.");
        }

        public Map<Integer, Field> asMap() {
            if (this.fieldBuilders.isEmpty() == true) goto L5;
            TreeMap r0 = new TreeMap();
            Iterator<Map.Entry<Integer, Field.Builder>> r5 = this.fieldBuilders.entrySet().iterator();
        L8:
            if (r5.hasNext() == false) goto L11;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r0.put((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin"), ((Field.Builder) ZeusTransformUtils.preCheckCast(r1.getValue(), Field.Builder.class, "com.obric.memorydata.plugin")).build());
            goto L8
        L11:
            return Collections.unmodifiableMap(r0);
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
            TreeMap r0 = new TreeMap();
            Iterator<Map.Entry<Integer, Field.Builder>> r5 = this.fieldBuilders.entrySet().iterator();
        L7:
            if (r5.hasNext() == false) goto L10;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            r0.put((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin"), ((Field.Builder) ZeusTransformUtils.preCheckCast(r1.getValue(), Field.Builder.class, "com.obric.memorydata.plugin")).build());
            goto L7
        L10:
            return new UnknownFieldSet(r0, null);
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

        public Builder clearField(int r3) {
            if (r3 <= 0) goto L8;
            if (this.fieldBuilders.containsKey(Integer.valueOf(r3)) == false) goto L6;
            this.fieldBuilders.remove(Integer.valueOf(r3));
        L6:
            return this;
        L8:
            throw new IllegalArgumentException(r3 + " is not a valid field number.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            Builder r0 = UnknownFieldSet.newBuilder();
            Iterator<Map.Entry<Integer, Field.Builder>> r5 = this.fieldBuilders.entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin");
            Field.Builder r3 = (Field.Builder) ZeusTransformUtils.preCheckCast(r1.getValue(), Field.Builder.class, "com.obric.memorydata.plugin");
            r0.fieldBuilders.put(r2, r3.clone());
            goto L4
        L6:
            return r0;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m143clone() {
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

        public boolean hasField(int r1) {
            return this.fieldBuilders.containsKey(Integer.valueOf(r1));
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r3) {
            int r0 = r3.read();
            if (r0 != (-1)) goto L6;
            return false;
        L6:
            mergeFrom(new AbstractMessageLite.Builder.LimitedInputStream(r3, CodedInputStream.readRawVarint32(r0, r3)));
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
            return mergeDelimitedFrom(r1);
        }

        public Builder mergeField(int r2, Field r3) {
            if (r2 <= 0) goto L9;
            if (hasField(r2) == false) goto L6;
            getFieldBuilder(r2).mergeFrom(r3);
        L7:
            return this;
        L6:
            addField(r2, r3);
            goto L7
        L9:
            throw new IllegalArgumentException(r2 + " is not a valid field number.");
        }

        public boolean mergeFieldFrom(int r4, CodedInputStream r5) {
            int r0 = WireFormat.getTagFieldNumber(r4);
            int r6 = WireFormat.getTagWireType(r4);
            if (r6 == 0) goto L25;
            if (r6 != 1) goto L6;
            getFieldBuilder(r0).addFixed64(r5.readFixed64());
            return true;
        L6:
            if (r6 != 2) goto L8;
            getFieldBuilder(r0).addLengthDelimited(r5.readBytes());
            return true;
        L8:
            if (r6 != 3) goto L10;
            Builder r7 = UnknownFieldSet.newBuilder();
            r5.readGroup(r0, r7, ExtensionRegistry.getEmptyRegistry());
            getFieldBuilder(r0).addGroup(r7.build());
            return true;
        L10:
            if (r6 != 4) goto L12;
            r5.checkValidEndTag();
            return false;
        L12:
            if (r6 != 5) goto L16;
            getFieldBuilder(r0).addFixed32(r5.readFixed32());
            return true;
        L16:
            throw InvalidProtocolBufferException.invalidWireType();
        L25:
            getFieldBuilder(r0).addVarint(r5.readInt64());
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public /* synthetic */ MessageLite.Builder mergeFrom(MessageLite r3) {
            return mergeFrom((MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3, r4);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r2) {
            CodedInputStream r3 = r2.newCodedInput();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r3);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r3.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r2) {
        L2:
            int r0 = r2.readTag();
            if (r0 == 0) goto L6;
            if (mergeFieldFrom(r0, r2) == true) goto L2;
        L6:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(MessageLite r3) {
            MessageLite r4 = (MessageLite) ZeusTransformUtils.wrapperContextForParams(r3, MessageLite.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, UnknownFieldSet.class) == false) goto L7;
            return mergeFrom((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r4, UnknownFieldSet.class, "com.obric.memorydata.plugin"));
        L7:
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        public Builder mergeFrom(UnknownFieldSet r5) {
            if (r5 == UnknownFieldSet.getDefaultInstance()) goto L8;
            Iterator r6 = UnknownFieldSet.access$300(r5).entrySet().iterator();
        L6:
            if (r6.hasNext() == false) goto L8;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            mergeField(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), (Field) ZeusTransformUtils.preCheckCast(r0.getValue(), Field.class, "com.obric.memorydata.plugin"));
        L8:
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r2) {
            CodedInputStream r3 = CodedInputStream.newInstance(r2);
            mergeFrom(r3);
            r3.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r2) {
            CodedInputStream r3 = CodedInputStream.newInstance(r2);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r3);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r3.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r1, int r2, int r3) {
            CodedInputStream r4 = CodedInputStream.newInstance(r1, r2, r3);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            mergeFrom(r4);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            r4.checkLastTagWas(0);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return this;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r1, int r2, int r3, ExtensionRegistryLite r4) {
            return mergeFrom(r1, r2, r3);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1);
        }

        public Builder mergeLengthDelimitedField(int r1, ByteString r2) {
            if (r1 <= 0) goto L6;
            getFieldBuilder(r1).addLengthDelimited(r2);
            return this;
        L6:
            throw new IllegalArgumentException(r1 + " is not a valid field number.");
        }

        public Builder mergeVarintField(int r3, int r4) {
            if (r3 <= 0) goto L6;
            getFieldBuilder(r3).addVarint(r4);
            return this;
        L6:
            throw new IllegalArgumentException(r3 + " is not a valid field number.");
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

            public Builder addFixed32(int r3) {
                if (Field.access$700(this.result) != null) goto L5;
                Field.access$702(this.result, new ArrayList());
            L5:
                Field.access$700(this.result).add(Integer.valueOf(r3));
                return this;
            }

            public Builder addFixed64(long r3) {
                if (Field.access$800(this.result) != null) goto L5;
                Field.access$802(this.result, new ArrayList());
            L5:
                Field.access$800(this.result).add(Long.valueOf(r3));
                return this;
            }

            public Builder addGroup(UnknownFieldSet r3) {
                if (Field.access$1000(this.result) != null) goto L5;
                Field.access$1002(this.result, new ArrayList());
            L5:
                Field.access$1000(this.result).add(r3);
                return this;
            }

            public Builder addLengthDelimited(ByteString r3) {
                if (Field.access$900(this.result) != null) goto L5;
                Field.access$902(this.result, new ArrayList());
            L5:
                Field.access$900(this.result).add(r3);
                return this;
            }

            public Builder addVarint(long r3) {
                if (Field.access$600(this.result) != null) goto L5;
                Field.access$602(this.result, new ArrayList());
            L5:
                Field.access$600(this.result).add(Long.valueOf(r3));
                return this;
            }

            public Field build() {
                Field r0 = new Field(null);
                if (Field.access$600(this.result) != null) goto L5;
                List r1 = Collections.emptyList();
            L6:
                Field.access$602(r0, r1);
                if (Field.access$700(this.result) != null) goto L9;
                List r2 = Collections.emptyList();
            L10:
                Field.access$702(r0, r2);
                if (Field.access$800(this.result) != null) goto L13;
                List r3 = Collections.emptyList();
            L14:
                Field.access$802(r0, r3);
                if (Field.access$900(this.result) != null) goto L17;
                List r4 = Collections.emptyList();
            L18:
                Field.access$902(r0, r4);
                if (Field.access$1000(this.result) != null) goto L21;
                List r5 = Collections.emptyList();
            L22:
                Field.access$1002(r0, r5);
                return r0;
            L21:
                r5 = Collections.unmodifiableList(new ArrayList(Field.access$1000(this.result)));
                goto L22
            L17:
                r4 = Collections.unmodifiableList(new ArrayList(Field.access$900(this.result)));
                goto L18
            L13:
                r3 = Collections.unmodifiableList(new ArrayList(Field.access$800(this.result)));
                goto L14
            L9:
                r2 = Collections.unmodifiableList(new ArrayList(Field.access$700(this.result)));
                goto L10
            L5:
                r1 = Collections.unmodifiableList(new ArrayList(Field.access$600(this.result)));
                goto L6
            }

            public Builder clear() {
                this.result = new Field(null);
                return this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public Builder clone() {
                ArrayList r1 = null;
                Field r0 = new Field(0 == true ? 1 : 0);
                if (Field.access$600(this.result) != null) goto L5;
                Field.access$602(r0, null);
            L7:
                if (Field.access$700(this.result) != null) goto L9;
                Field.access$702(r0, null);
            L11:
                if (Field.access$800(this.result) != null) goto L13;
                Field.access$802(r0, null);
            L15:
                if (Field.access$900(this.result) != null) goto L17;
                Field.access$902(r0, null);
            L19:
                if (Field.access$1000(this.result) == null) goto L22;
                r1 = new ArrayList(Field.access$1000(this.result));
            L22:
                Field.access$1002(r0, r1);
                Builder r4 = new Builder();
                r4.result = r0;
                return r4;
            L17:
                Field.access$902(r0, new ArrayList(Field.access$900(this.result)));
                goto L19
            L13:
                Field.access$802(r0, new ArrayList(Field.access$800(this.result)));
                goto L15
            L9:
                Field.access$702(r0, new ArrayList(Field.access$700(this.result)));
                goto L11
            L5:
                Field.access$602(r0, new ArrayList(Field.access$600(this.result)));
                goto L7
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m144clone() {
                return clone();
            }

            public Builder mergeFrom(Field r3) {
                if (Field.access$600(r3).isEmpty() == true) goto L9;
                if (Field.access$600(this.result) != null) goto L7;
                Field.access$602(this.result, new ArrayList());
            L7:
                Field.access$600(this.result).addAll(Field.access$600(r3));
            L9:
                if (Field.access$700(r3).isEmpty() == true) goto L15;
                if (Field.access$700(this.result) != null) goto L13;
                Field.access$702(this.result, new ArrayList());
            L13:
                Field.access$700(this.result).addAll(Field.access$700(r3));
            L15:
                if (Field.access$800(r3).isEmpty() == true) goto L21;
                if (Field.access$800(this.result) != null) goto L19;
                Field.access$802(this.result, new ArrayList());
            L19:
                Field.access$800(this.result).addAll(Field.access$800(r3));
            L21:
                if (Field.access$900(r3).isEmpty() == true) goto L27;
                if (Field.access$900(this.result) != null) goto L25;
                Field.access$902(this.result, new ArrayList());
            L25:
                Field.access$900(this.result).addAll(Field.access$900(r3));
            L27:
                if (Field.access$1000(r3).isEmpty() == false) goto L29;
            L32:
                return this;
            L29:
                if (Field.access$1000(this.result) != null) goto L31;
                Field.access$1002(this.result, new ArrayList());
            L31:
                Field.access$1000(this.result).addAll(Field.access$1000(r3));
                goto L32
            }
        }

        static {
            fieldDefaultInstance = newBuilder().build();
        }

        private Field() {
        }

        /* synthetic */ Field(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ void access$100(Field r2, int r3, Writer r4) {
            r2.writeAsMessageSetExtensionTo(r3, (Writer) ZeusTransformUtils.wrapperContextForParams(r4, Writer.class, "com.obric.memorydata.plugin"));
        }

        static /* synthetic */ List access$1000(Field r0) {
            return r0.group;
        }

        static /* synthetic */ List access$1002(Field r2, List r3) {
            List<UnknownFieldSet> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r2.group = r4;
            return r4;
        }

        static /* synthetic */ List access$600(Field r0) {
            return r0.varint;
        }

        static /* synthetic */ List access$602(Field r2, List r3) {
            List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r2.varint = r4;
            return r4;
        }

        static /* synthetic */ List access$700(Field r0) {
            return r0.fixed32;
        }

        static /* synthetic */ List access$702(Field r2, List r3) {
            List<Integer> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r2.fixed32 = r4;
            return r4;
        }

        static /* synthetic */ List access$800(Field r0) {
            return r0.fixed64;
        }

        static /* synthetic */ List access$802(Field r2, List r3) {
            List<Long> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r2.fixed64 = r4;
            return r4;
        }

        static /* synthetic */ List access$900(Field r0) {
            return r0.lengthDelimited;
        }

        static /* synthetic */ List access$902(Field r2, List r3) {
            List<ByteString> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            r2.lengthDelimited = r4;
            return r4;
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

        public static Builder newBuilder(Field r1) {
            return newBuilder().mergeFrom(r1);
        }

        private void writeAsMessageSetExtensionTo(int r5, Writer r6) {
            Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r6, Writer.class, "com.obric.memorydata.plugin");
            if (r7.fieldOrder() != Writer.FieldOrder.DESCENDING) goto L7;
            int r0 = this.lengthDelimited.size() - 1;
        L5:
            if (r0 < 0) goto L11;
            r7.writeMessageSetItem(r5, (ByteString) ZeusTransformUtils.preCheckCast(this.lengthDelimited.get(r0), ByteString.class, "com.obric.memorydata.plugin"));
            r0 = r0 - 1;
            goto L5
        L11:
            return;
        L7:
            int r1 = 0;
        L9:
            if (r1 >= this.lengthDelimited.size()) goto L14;
            r7.writeMessageSetItem(r5, (ByteString) ZeusTransformUtils.preCheckCast(this.lengthDelimited.get(r1), ByteString.class, "com.obric.memorydata.plugin"));
            r1 = r1 + 1;
            goto L9
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r3, Field.class) == true) goto L11;
            return false;
        L11:
            return Arrays.equals(getIdentityArray(), ((Field) ZeusTransformUtils.preCheckCast(r3, Field.class, "com.obric.memorydata.plugin")).getIdentityArray());
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
            int r0 = 0;
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r1 >= this.varint.size()) goto L6;
            r2 = r2 + CodedOutputStream.computeUInt64Size(r8, ((Long) ZeusTransformUtils.preCheckCast(this.varint.get(r1), Long.class, "com.obric.memorydata.plugin")).longValue());
            r1 = r1 + 1;
            goto L4
        L6:
            int r3 = 0;
        L8:
            if (r3 >= this.fixed32.size()) goto L10;
            r2 = r2 + CodedOutputStream.computeFixed32Size(r8, ((Integer) ZeusTransformUtils.preCheckCast(this.fixed32.get(r3), Integer.class, "com.obric.memorydata.plugin")).intValue());
            r3 = r3 + 1;
            goto L8
        L10:
            int r4 = 0;
        L12:
            if (r4 >= this.fixed64.size()) goto L14;
            r2 = r2 + CodedOutputStream.computeFixed64Size(r8, ((Long) ZeusTransformUtils.preCheckCast(this.fixed64.get(r4), Long.class, "com.obric.memorydata.plugin")).longValue());
            r4 = r4 + 1;
            goto L12
        L14:
            int r5 = 0;
        L16:
            if (r5 >= this.lengthDelimited.size()) goto L19;
            r2 = r2 + CodedOutputStream.computeBytesSize(r8, (ByteString) ZeusTransformUtils.preCheckCast(this.lengthDelimited.get(r5), ByteString.class, "com.obric.memorydata.plugin"));
            r5 = r5 + 1;
        L19:
            if (r0 >= this.group.size()) goto L21;
            r2 = r2 + CodedOutputStream.computeGroupSize(r8, (UnknownFieldSet) ZeusTransformUtils.preCheckCast(this.group.get(r0), UnknownFieldSet.class, "com.obric.memorydata.plugin"));
            r0 = r0 + 1;
            goto L19
        L21:
            return r2;
        }

        public int getSerializedSizeAsMessageSetExtension(int r6) {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= this.lengthDelimited.size()) goto L6;
            r1 = r1 + CodedOutputStream.computeRawMessageSetExtensionSize(r6, (ByteString) ZeusTransformUtils.preCheckCast(this.lengthDelimited.get(r0), ByteString.class, "com.obric.memorydata.plugin"));
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        public List<Long> getVarintList() {
            return this.varint;
        }

        public int hashCode() {
            return Arrays.hashCode(getIdentityArray());
        }

        public ByteString toByteString(int r3) {
            ByteString.CodedBuilder r0 = ByteString.newCodedBuilder(getSerializedSize(r3));     // Catch: IOException -> L4
            writeTo(r3, r0.getCodedOutput());     // Catch: IOException -> L4
            return r0.build();
        L4:
            e = move-exception;
            throw new RuntimeException("Serializing to a ByteString should never fail with an IOException", e);
        }

        public void writeAsMessageSetExtensionTo(int r5, CodedOutputStream r6) {
            int r0 = 0;
        L4:
            if (r0 >= this.lengthDelimited.size()) goto L6;
            r6.writeRawMessageSetExtension(r5, (ByteString) ZeusTransformUtils.preCheckCast(this.lengthDelimited.get(r0), ByteString.class, "com.obric.memorydata.plugin"));
            r0 = r0 + 1;
            goto L4
        }

        public void writeTo(int r7, CodedOutputStream r8) {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r1 >= this.varint.size()) goto L6;
            r8.writeUInt64(r7, ((Long) ZeusTransformUtils.preCheckCast(this.varint.get(r1), Long.class, "com.obric.memorydata.plugin")).longValue());
            r1 = r1 + 1;
            goto L4
        L6:
            int r2 = 0;
        L8:
            if (r2 >= this.fixed32.size()) goto L10;
            r8.writeFixed32(r7, ((Integer) ZeusTransformUtils.preCheckCast(this.fixed32.get(r2), Integer.class, "com.obric.memorydata.plugin")).intValue());
            r2 = r2 + 1;
            goto L8
        L10:
            int r3 = 0;
        L12:
            if (r3 >= this.fixed64.size()) goto L14;
            r8.writeFixed64(r7, ((Long) ZeusTransformUtils.preCheckCast(this.fixed64.get(r3), Long.class, "com.obric.memorydata.plugin")).longValue());
            r3 = r3 + 1;
            goto L12
        L14:
            int r4 = 0;
        L16:
            if (r4 >= this.lengthDelimited.size()) goto L19;
            r8.writeBytes(r7, (ByteString) ZeusTransformUtils.preCheckCast(this.lengthDelimited.get(r4), ByteString.class, "com.obric.memorydata.plugin"));
            r4 = r4 + 1;
        L19:
            if (r0 >= this.group.size()) goto L21;
            r8.writeGroup(r7, (UnknownFieldSet) ZeusTransformUtils.preCheckCast(this.group.get(r0), UnknownFieldSet.class, "com.obric.memorydata.plugin"));
            r0 = r0 + 1;
            goto L19
        }

        void writeTo(int r5, Writer r6) {
            Writer r7 = (Writer) ZeusTransformUtils.wrapperContextForParams(r6, Writer.class, "com.obric.memorydata.plugin");
            int r2 = 0;
            r7.writeInt64List(r5, this.varint, false);
            r7.writeFixed32List(r5, this.fixed32, false);
            r7.writeFixed64List(r5, this.fixed64, false);
            r7.writeBytesList(r5, this.lengthDelimited);
            if (r7.fieldOrder() == Writer.FieldOrder.ASCENDING) goto L5;
            int r0 = this.group.size() - 1;
        L8:
            if (r0 < 0) goto L13;
            r7.writeEndGroup(r5);
            ((UnknownFieldSet) ZeusTransformUtils.preCheckCast(this.group.get(r0), UnknownFieldSet.class, "com.obric.memorydata.plugin")).writeTo(r7);
            r7.writeStartGroup(r5);
            r0 = r0 - 1;
            goto L8
        L13:
            return;
        L5:
            if (r2 >= this.group.size()) goto L10;
            r7.writeStartGroup(r5);
            ((UnknownFieldSet) ZeusTransformUtils.preCheckCast(this.group.get(r2), UnknownFieldSet.class, "com.obric.memorydata.plugin")).writeTo(r7);
            r7.writeEndGroup(r5);
            r2 = r2 + 1;
            goto L5
        }
    }

    public static final class Parser extends AbstractParser<UnknownFieldSet> {
        public Parser() {
        }

        @Override // com.google.protobuf.Parser
        public UnknownFieldSet parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            Builder r0 = UnknownFieldSet.newBuilder();
            r0.mergeFrom(r1);     // Catch: IOException -> L6 InvalidProtocolBufferException -> L9
        L5:
            return r0.buildPartial();
        L9:
            e = move-exception;
            throw e.setUnfinishedMessage(r0.buildPartial());
        L6:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(r0.buildPartial());
        }

        @Override // com.google.protobuf.Parser
        public /* bridge */ /* synthetic */ Object parsePartialFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return parsePartialFrom(r1, r2);
        }
    }

    static {
        defaultInstance = new UnknownFieldSet(new TreeMap());
        PARSER = new Parser();
    }

    private UnknownFieldSet(TreeMap<Integer, Field> r1) {
        this.fields = r1;
    }

    /* synthetic */ UnknownFieldSet(TreeMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ TreeMap access$300(UnknownFieldSet r0) {
        return r0.fields;
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    public static Builder newBuilder() {
        return Builder.access$000();
    }

    public static Builder newBuilder(UnknownFieldSet r1) {
        return newBuilder().mergeFrom(r1);
    }

    public static UnknownFieldSet parseFrom(ByteString r1) {
        return newBuilder().mergeFrom(r1).build();
    }

    public static UnknownFieldSet parseFrom(CodedInputStream r1) {
        return newBuilder().mergeFrom(r1).build();
    }

    public static UnknownFieldSet parseFrom(InputStream r1) {
        return newBuilder().mergeFrom(r1).build();
    }

    public static UnknownFieldSet parseFrom(byte[] r1) {
        return newBuilder().mergeFrom(r1).build();
    }

    public Map<Integer, Field> asMap() {
        if (this.fields.isEmpty() == false) goto L7;
        return Collections.emptyMap();
    L7:
        return (Map) ZeusTransformUtils.preCheckCast(this.fields.clone(), Map.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, UnknownFieldSet.class) == true) goto L8;
    L10:
        return false;
    L8:
        if (this.fields.equals(((UnknownFieldSet) ZeusTransformUtils.preCheckCast(r4, UnknownFieldSet.class, "com.obric.memorydata.plugin")).fields) == false) goto L10;
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

    public Field getField(int r2) {
        Field r1 = (Field) ZeusTransformUtils.preCheckCast(this.fields.get(Integer.valueOf(r2)), Field.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
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
        int r1 = 0;
        if (this.fields.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<Integer, Field>> r5 = this.fields.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r1 = r1 + ((Field) ZeusTransformUtils.preCheckCast(r0.getValue(), Field.class, "com.obric.memorydata.plugin")).getSerializedSize(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L7
    L9:
        return r1;
    }

    public int getSerializedSizeAsMessageSet() {
        int r1 = 0;
        if (this.fields.isEmpty() == false) goto L5;
        return 0;
    L5:
        Iterator<Map.Entry<Integer, Field>> r5 = this.fields.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r1 = r1 + ((Field) ZeusTransformUtils.preCheckCast(r0.getValue(), Field.class, "com.obric.memorydata.plugin")).getSerializedSizeAsMessageSetExtension(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L7
    L9:
        return r1;
    }

    public boolean hasField(int r1) {
        return this.fields.containsKey(Integer.valueOf(r1));
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
        byte[] r0 = new byte[getSerializedSize()];     // Catch: IOException -> L4
        CodedOutputStream r1 = CodedOutputStream.newInstance(r0);     // Catch: IOException -> L4
        writeTo(r1);     // Catch: IOException -> L4
        r1.checkNoSpaceLeft();     // Catch: IOException -> L4
        return r0;
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        ByteString.CodedBuilder r0 = ByteString.newCodedBuilder(getSerializedSize());     // Catch: IOException -> L4
        writeTo(r0.getCodedOutput());     // Catch: IOException -> L4
        return r0.build();
    L4:
        e = move-exception;
        throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
    }

    public String toString() {
        return TextFormat.printer().printToString(this);
    }

    public void writeAsMessageSetTo(CodedOutputStream r5) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, Field>> r4 = this.fields.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ((Field) ZeusTransformUtils.preCheckCast(r0.getValue(), Field.class, "com.obric.memorydata.plugin")).writeAsMessageSetExtensionTo(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r5);
        goto L7
    }

    void writeAsMessageSetTo(Writer r5) {
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Writer.FieldOrder r0 = r6.fieldOrder();
        Writer.FieldOrder r2 = Writer.FieldOrder.DESCENDING;
        TreeMap<Integer, Field> r4 = this.fields;
        if (r0 != r2) goto L11;
        Iterator<Map.Entry<Integer, Field>> r7 = r4.descendingMap().entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Field.access$100((Field) ZeusTransformUtils.preCheckCast(r1.getValue(), Field.class, "com.obric.memorydata.plugin"), ((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r6);
        goto L9
    L15:
        return;
    L11:
        Iterator<Map.Entry<Integer, Field>> r8 = r4.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Field.access$100((Field) ZeusTransformUtils.preCheckCast(r3.getValue(), Field.class, "com.obric.memorydata.plugin"), ((Integer) ZeusTransformUtils.preCheckCast(r3.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r6);
        goto L13
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream r2) {
        CodedOutputStream r3 = CodedOutputStream.newInstance(r2);
        r3.writeUInt32NoTag(getSerializedSize());
        writeTo(r3);
        r3.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r5) {
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<Map.Entry<Integer, Field>> r4 = this.fields.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ((Field) ZeusTransformUtils.preCheckCast(r0.getValue(), Field.class, "com.obric.memorydata.plugin")).writeTo(((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r5);
        goto L7
    }

    void writeTo(Writer r5) {
        Writer r6 = (Writer) ZeusTransformUtils.wrapperContextForParams(r5, Writer.class, "com.obric.memorydata.plugin");
        if (this.fields.isEmpty() == false) goto L5;
        return;
    L5:
        Writer.FieldOrder r0 = r6.fieldOrder();
        Writer.FieldOrder r2 = Writer.FieldOrder.DESCENDING;
        TreeMap<Integer, Field> r4 = this.fields;
        if (r0 != r2) goto L11;
        Iterator<Map.Entry<Integer, Field>> r7 = r4.descendingMap().entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ((Field) ZeusTransformUtils.preCheckCast(r1.getValue(), Field.class, "com.obric.memorydata.plugin")).writeTo(((Integer) ZeusTransformUtils.preCheckCast(r1.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r6);
        goto L9
    L15:
        return;
    L11:
        Iterator<Map.Entry<Integer, Field>> r8 = r4.entrySet().iterator();
    L13:
        if (r8.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ((Field) ZeusTransformUtils.preCheckCast(r3.getValue(), Field.class, "com.obric.memorydata.plugin")).writeTo(((Integer) ZeusTransformUtils.preCheckCast(r3.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), r6);
        goto L13
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream r1) {
        CodedOutputStream r2 = CodedOutputStream.newInstance(r1);
        writeTo(r2);
        r2.flush();
    }
}
