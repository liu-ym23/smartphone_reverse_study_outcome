package com.google.protobuf.compiler;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class PluginProtos {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_google_protobuf_compiler_Version_descriptor = null;
    private static final GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_compiler_Version_fieldAccessorTable = null;

    /* JADX INFO: renamed from: com.google.protobuf.compiler.PluginProtos$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class CodeGeneratorRequest extends GeneratedMessage implements CodeGeneratorRequestOrBuilder {
        public static final int COMPILER_VERSION_FIELD_NUMBER = 3;
        private static final CodeGeneratorRequest DEFAULT_INSTANCE = null;
        public static final int FILE_TO_GENERATE_FIELD_NUMBER = 1;
        public static final int PARAMETER_FIELD_NUMBER = 2;
        private static final Parser<CodeGeneratorRequest> PARSER = null;
        public static final int PROTO_FILE_FIELD_NUMBER = 15;
        public static final int SOURCE_FILE_DESCRIPTORS_FIELD_NUMBER = 17;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Version compilerVersion_;
        private LazyStringArrayList fileToGenerate_;
        private byte memoizedIsInitialized;
        private volatile Object parameter_;
        private List<DescriptorProtos.FileDescriptorProto> protoFile_;
        private List<DescriptorProtos.FileDescriptorProto> sourceFileDescriptors_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CodeGeneratorRequestOrBuilder {
            private int bitField0_;
            private SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> compilerVersionBuilder_;
            private Version compilerVersion_;
            private LazyStringArrayList fileToGenerate_;
            private Object parameter_;
            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> protoFileBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> protoFile_;
            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> sourceFileDescriptorsBuilder_;
            private List<DescriptorProtos.FileDescriptorProto> sourceFileDescriptors_;

            private Builder() {
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                this.sourceFileDescriptors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private Builder(AbstractMessage.BuilderParent r10) {
                super(r10);
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                this.sourceFileDescriptors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
                this(r10);
            }

            /* synthetic */ Builder(AnonymousClass1 r10) {
                this();
            }

            private void buildPartial0(CodeGeneratorRequest r10) {
                int r11 = this.bitField0_;
                if ((r11 & 1) == 0) goto L5;
                this.fileToGenerate_.makeImmutable();
                CodeGeneratorRequest.access$1802(r10, this.fileToGenerate_);
            L5:
                int r12 = 0;
                if ((r11 & 2) == 0) goto L9;
                CodeGeneratorRequest.access$1902(r10, this.parameter_);
                r12 = 1;
            L9:
                if ((r11 & 16) == 0) goto L15;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r13 = this.compilerVersionBuilder_;
                if (r13 != null) goto L13;
                Version r14 = this.compilerVersion_;
            L14:
                CodeGeneratorRequest.access$2002(r10, r14);
                r12 = r12 | 2;
                goto L15
            L13:
                r14 = (Version) r13.build();
            L15:
                CodeGeneratorRequest.access$2176(r10, r12);
            }

            private void buildPartialRepeatedFields(CodeGeneratorRequest r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 == null) goto L5;
                List r12 = r11.build();
            L9:
                CodeGeneratorRequest.access$1602(r10, r12);
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r13 = this.sourceFileDescriptorsBuilder_;
                if (r13 == null) goto L12;
                List r14 = r13.build();
            L16:
                CodeGeneratorRequest.access$1702(r10, r14);
                return;
            L12:
                if ((this.bitField0_ & 8) == 0) goto L14;
                this.sourceFileDescriptors_ = Collections.unmodifiableList(this.sourceFileDescriptors_);
                this.bitField0_ &= -9;
            L14:
                r14 = this.sourceFileDescriptors_;
                goto L16
            L5:
                if ((this.bitField0_ & 4) == 0) goto L7;
                this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                this.bitField0_ &= -5;
            L7:
                r12 = this.protoFile_;
                goto L9
            }

            private void ensureFileToGenerateIsMutable() {
                if (this.fileToGenerate_.isModifiable() == true) goto L5;
                this.fileToGenerate_ = new LazyStringArrayList(this.fileToGenerate_);
            L5:
                this.bitField0_ |= 1;
            }

            private void ensureProtoFileIsMutable() {
                if ((this.bitField0_ & 4) != 0) goto L6;
                this.protoFile_ = new ArrayList(this.protoFile_);
                this.bitField0_ |= 4;
                return;
            }

            private void ensureSourceFileDescriptorsIsMutable() {
                if ((this.bitField0_ & 8) != 0) goto L6;
                this.sourceFileDescriptors_ = new ArrayList(this.sourceFileDescriptors_);
                this.bitField0_ |= 8;
                return;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.access$1000();
            }

            private SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> internalGetCompilerVersionFieldBuilder() {
                if (this.compilerVersionBuilder_ != null) goto L6;
                this.compilerVersionBuilder_ = new SingleFieldBuilder(getCompilerVersion(), getParentForChildren(), isClean());
                this.compilerVersion_ = null;
            L6:
                return this.compilerVersionBuilder_;
            }

            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> internalGetProtoFileFieldBuilder() {
                if (this.protoFileBuilder_ != null) goto L10;
                List<DescriptorProtos.FileDescriptorProto> r10 = this.protoFile_;
                if ((this.bitField0_ & 4) == 0) goto L7;
                boolean r11 = true;
            L8:
                this.protoFileBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
                this.protoFile_ = null;
                goto L10
            L7:
                r11 = false;
            L10:
                return this.protoFileBuilder_;
            }

            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> internalGetSourceFileDescriptorsFieldBuilder() {
                if (this.sourceFileDescriptorsBuilder_ != null) goto L10;
                List<DescriptorProtos.FileDescriptorProto> r10 = this.sourceFileDescriptors_;
                if ((this.bitField0_ & 8) == 0) goto L7;
                boolean r11 = true;
            L8:
                this.sourceFileDescriptorsBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
                this.sourceFileDescriptors_ = null;
                goto L10
            L7:
                r11 = false;
            L10:
                return this.sourceFileDescriptorsBuilder_;
            }

            private void maybeForceBuilderInitialization() {
                if (CodeGeneratorRequest.access$1400() == false) goto L6;
                internalGetProtoFileFieldBuilder();
                internalGetSourceFileDescriptorsFieldBuilder();
                internalGetCompilerVersionFieldBuilder();
                return;
            }

            public Builder addAllFileToGenerate(Iterable<String> r10) {
                ensureFileToGenerateIsMutable();
                AbstractMessageLite.Builder.addAll(r10, this.fileToGenerate_);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                ensureProtoFileIsMutable();
                AbstractMessageLite.Builder.addAll(r10, this.protoFile_);
                onChanged();
            L6:
                return this;
            L5:
                r11.addAllMessages(r10);
                goto L6
            }

            public Builder addAllSourceFileDescriptors(Iterable<? extends DescriptorProtos.FileDescriptorProto> r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                AbstractMessageLite.Builder.addAll(r10, this.sourceFileDescriptors_);
                onChanged();
            L6:
                return this;
            L5:
                r11.addAllMessages(r10);
                goto L6
            }

            public Builder addFileToGenerate(String r10) {
                Objects.requireNonNull(r10);
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(r10);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addFileToGenerateBytes(ByteString r10) {
                Objects.requireNonNull(r10);
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(r10);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addProtoFile(int r10, DescriptorProtos.FileDescriptorProto.Builder r11) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.protoFileBuilder_;
                if (r12 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.addMessage(r10, r11.build());
                goto L6
            }

            public Builder addProtoFile(int r10, DescriptorProtos.FileDescriptorProto r11) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.protoFileBuilder_;
                if (r12 != null) goto L5;
                Objects.requireNonNull(r11);
                ensureProtoFileIsMutable();
                this.protoFile_.add(r10, r11);
                onChanged();
            L6:
                return this;
            L5:
                r12.addMessage(r10, r11);
                goto L6
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r10.build());
                goto L6
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                Objects.requireNonNull(r10);
                ensureProtoFileIsMutable();
                this.protoFile_.add(r10);
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r10);
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetProtoFileFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int r10) {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetProtoFileFieldBuilder().addBuilder(r10, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public Builder addSourceFileDescriptors(int r10, DescriptorProtos.FileDescriptorProto.Builder r11) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.sourceFileDescriptorsBuilder_;
                if (r12 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.addMessage(r10, r11.build());
                goto L6
            }

            public Builder addSourceFileDescriptors(int r10, DescriptorProtos.FileDescriptorProto r11) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.sourceFileDescriptorsBuilder_;
                if (r12 != null) goto L5;
                Objects.requireNonNull(r11);
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r10, r11);
                onChanged();
            L6:
                return this;
            L5:
                r12.addMessage(r10, r11);
                goto L6
            }

            public Builder addSourceFileDescriptors(DescriptorProtos.FileDescriptorProto.Builder r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r10.build());
                goto L6
            }

            public Builder addSourceFileDescriptors(DescriptorProtos.FileDescriptorProto r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L5;
                Objects.requireNonNull(r10);
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r10);
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r10);
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder addSourceFileDescriptorsBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetSourceFileDescriptorsFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public DescriptorProtos.FileDescriptorProto.Builder addSourceFileDescriptorsBuilder(int r10) {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetSourceFileDescriptorsFieldBuilder().addBuilder(r10, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest build() {
                CodeGeneratorRequest r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r10);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest buildPartial() {
                CodeGeneratorRequest r10 = new CodeGeneratorRequest(this, null);
                buildPartialRepeatedFields(r10);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r10);
            L5:
                onBuilt();
                return r10;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L5;
                this.protoFile_ = Collections.emptyList();
            L6:
                this.bitField0_ &= -5;
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L9;
                this.sourceFileDescriptors_ = Collections.emptyList();
            L10:
                this.bitField0_ &= -9;
                this.compilerVersion_ = null;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r12 = this.compilerVersionBuilder_;
                if (r12 == null) goto L13;
                r12.dispose();
                this.compilerVersionBuilder_ = null;
            L13:
                return this;
            L9:
                this.sourceFileDescriptors_ = null;
                r11.clear();
                goto L10
            L5:
                this.protoFile_ = null;
                r10.clear();
                goto L6
            }

            public Builder clearCompilerVersion() {
                this.bitField0_ &= -17;
                this.compilerVersion_ = null;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r10 = this.compilerVersionBuilder_;
                if (r10 == null) goto L5;
                r10.dispose();
                this.compilerVersionBuilder_ = null;
            L5:
                onChanged();
                return this;
            }

            public Builder clearFileToGenerate() {
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearParameter() {
                this.parameter_ = CodeGeneratorRequest.getDefaultInstance().getParameter();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            public Builder clearProtoFile() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L5;
                this.protoFile_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            L6:
                return this;
            L5:
                r10.clear();
                goto L6
            }

            public Builder clearSourceFileDescriptors() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L5;
                this.sourceFileDescriptors_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
            L6:
                return this;
            L5:
                r10.clear();
                goto L6
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public Version getCompilerVersion() {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r10 = this.compilerVersionBuilder_;
                if (r10 != null) goto L9;
                Version r11 = this.compilerVersion_;
                if (r11 == null) goto L7;
                return r11;
            L7:
                return Version.getDefaultInstance();
            L9:
                return (Version) r10.getMessage();
            }

            public Version.Builder getCompilerVersionBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return (Version.Builder) internalGetCompilerVersionFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public VersionOrBuilder getCompilerVersionOrBuilder() {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r10 = this.compilerVersionBuilder_;
                if (r10 != null) goto L5;
                Version r11 = this.compilerVersion_;
                if (r11 == null) goto L9;
                return r11;
            L9:
                return Version.getDefaultInstance();
            L5:
                return (VersionOrBuilder) r10.getMessageOrBuilder();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodeGeneratorRequest getDefaultInstanceForType() {
                return CodeGeneratorRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.access$1000();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getFileToGenerate(int r10) {
                return this.fileToGenerate_.get(r10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getFileToGenerateBytes(int r10) {
                return this.fileToGenerate_.getByteString(r10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getFileToGenerateCount() {
                return this.fileToGenerate_.size();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ProtocolStringList getFileToGenerateList() {
                this.fileToGenerate_.makeImmutable();
                return this.fileToGenerate_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public /* bridge */ /* synthetic */ List getFileToGenerateList() {
                return getFileToGenerateList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getParameter() {
                Object r10 = this.parameter_;
                if ((r10 instanceof String) == true) goto L9;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L7;
                this.parameter_ = r12;
            L7:
                return r12;
            L9:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getParameterBytes() {
                Object r10 = this.parameter_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.parameter_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getProtoFile(int r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L7;
                MessageLite r12 = this.protoFile_.get(r10);
            L6:
                return (DescriptorProtos.FileDescriptorProto) r12;
            L7:
                r12 = r11.getMessage(r10);
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int r10) {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetProtoFileFieldBuilder().getBuilder(r10);
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
                return internalGetProtoFileFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getProtoFileCount() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L7;
                return this.protoFile_.size();
            L7:
                return r10.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L7;
                return Collections.unmodifiableList(this.protoFile_);
            L7:
                return r10.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L7;
                Object r12 = this.protoFile_.get(r10);
            L6:
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) r12;
            L7:
                r12 = r11.getMessageOrBuilder(r10);
                goto L6
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 == null) goto L7;
                return r10.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.protoFile_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L7;
                MessageLite r12 = this.sourceFileDescriptors_.get(r10);
            L6:
                return (DescriptorProtos.FileDescriptorProto) r12;
            L7:
                r12 = r11.getMessage(r10);
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder getSourceFileDescriptorsBuilder(int r10) {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetSourceFileDescriptorsFieldBuilder().getBuilder(r10);
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getSourceFileDescriptorsBuilderList() {
                return internalGetSourceFileDescriptorsFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getSourceFileDescriptorsCount() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L7;
                return this.sourceFileDescriptors_.size();
            L7:
                return r10.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L7;
                return Collections.unmodifiableList(this.sourceFileDescriptors_);
            L7:
                return r10.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L7;
                Object r12 = this.sourceFileDescriptors_.get(r10);
            L6:
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) r12;
            L7:
                r12 = r11.getMessageOrBuilder(r10);
                goto L6
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 == null) goto L7;
                return r10.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.sourceFileDescriptors_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasCompilerVersion() {
                if ((this.bitField0_ & 16) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public boolean hasParameter() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$1100().ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r10 = 0;
            L4:
                if (r10 >= getProtoFileCount()) goto L9;
                if (getProtoFile(r10).isInitialized() == false) goto L7;
                r10 = r10 + 1;
                goto L4
            L7:
                return false;
            L9:
                int r11 = 0;
            L11:
                if (r11 >= getSourceFileDescriptorsCount()) goto L16;
                if (getSourceFileDescriptors(r11).isInitialized() == false) goto L14;
                r11 = r11 + 1;
                goto L11
            L14:
                return false;
            L16:
                return true;
            }

            public Builder mergeCompilerVersion(Version r10) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r11 = this.compilerVersionBuilder_;
                if (r11 == null) goto L5;
                r11.mergeFrom(r10);
            L14:
                if (this.compilerVersion_ == null) goto L16;
                this.bitField0_ |= 16;
                onChanged();
            L16:
                return this;
            L5:
                if ((this.bitField0_ & 16) == 0) goto L11;
                Version r12 = this.compilerVersion_;
                if (r12 == null) goto L11;
                if (r12 == Version.getDefaultInstance()) goto L11;
                getCompilerVersionBuilder().mergeFrom(r10);
            L11:
                this.compilerVersion_ = r10;
                goto L14
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
                return mergeFrom(r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
                return mergeFrom(r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Objects.requireNonNull(r11);
                boolean r12 = false;
            L3:
                if (r12 == true) goto L39;
                int r13 = r10.readTag();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                if (r13 == 0) goto L31;
                if (r13 != 10) goto L9;
                ByteString r14 = r10.readBytes();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                ensureFileToGenerateIsMutable();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                this.fileToGenerate_.add(r14);     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                goto L3
            L9:
                if (r13 != 18) goto L11;
                this.parameter_ = r10.readBytes();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                this.bitField0_ |= 2;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                goto L3
            L11:
                if (r13 != 26) goto L13;
                r10.readMessage(internalGetCompilerVersionFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                this.bitField0_ |= 16;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                goto L3
            L13:
                if (r13 == 122) goto L24;
                if (r13 != 138) goto L17;
                DescriptorProtos.FileDescriptorProto r15 = (DescriptorProtos.FileDescriptorProto) r10.readMessage(DescriptorProtos.FileDescriptorProto.parser(), r11);     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r16 = this.sourceFileDescriptorsBuilder_;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                if (r16 == null) goto L21;
            L23:
                r16.addMessage(r15);     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                goto L3
            L21:
                ensureSourceFileDescriptorsIsMutable();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                List<DescriptorProtos.FileDescriptorProto> r17 = this.sourceFileDescriptors_;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            L22:
                r17.add(r15);     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                goto L3
            L17:
                if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
            L24:
                r15 = (DescriptorProtos.FileDescriptorProto) r10.readMessage(DescriptorProtos.FileDescriptorProto.parser(), r11);     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                r16 = this.protoFileBuilder_;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                if (r16 != null) goto L23;
                ensureProtoFileIsMutable();     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
                r17 = this.protoFile_;     // Catch: Throwable -> L32 InvalidProtocolBufferException -> L34
            L31:
                r12 = true;
                goto L3
            L34:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L32
            L32:
                th = move-exception;
                onChanged();
                throw th;
            L39:
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r10) {
                if ((r10 instanceof CodeGeneratorRequest) == true) goto L5;
                super.mergeFrom(r10);
                return this;
            L5:
                return mergeFrom((CodeGeneratorRequest) r10);
            }

            public Builder mergeFrom(CodeGeneratorRequest r10) {
                if (r10 != CodeGeneratorRequest.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (CodeGeneratorRequest.access$1800(r10).isEmpty() == true) goto L13;
                if (this.fileToGenerate_.isEmpty() == false) goto L10;
                this.fileToGenerate_ = CodeGeneratorRequest.access$1800(r10);
                this.bitField0_ |= 1;
            L11:
                onChanged();
                goto L13
            L10:
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.addAll(CodeGeneratorRequest.access$1800(r10));
            L13:
                if (r10.hasParameter() == false) goto L15;
                this.parameter_ = CodeGeneratorRequest.access$1900(r10);
                this.bitField0_ |= 2;
                onChanged();
            L15:
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = null;
                if (this.protoFileBuilder_ != null) goto L25;
                if (CodeGeneratorRequest.access$1600(r10).isEmpty() == true) goto L35;
                if (this.protoFile_.isEmpty() == false) goto L22;
                this.protoFile_ = CodeGeneratorRequest.access$1600(r10);
                this.bitField0_ &= -5;
            L23:
                onChanged();
                goto L35
            L22:
                ensureProtoFileIsMutable();
                this.protoFile_.addAll(CodeGeneratorRequest.access$1600(r10));
            L35:
                if (this.sourceFileDescriptorsBuilder_ != null) goto L44;
                if (CodeGeneratorRequest.access$1700(r10).isEmpty() == true) goto L53;
                if (this.sourceFileDescriptors_.isEmpty() == false) goto L41;
                this.sourceFileDescriptors_ = CodeGeneratorRequest.access$1700(r10);
                this.bitField0_ &= -9;
            L42:
                onChanged();
                goto L53
            L41:
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.addAll(CodeGeneratorRequest.access$1700(r10));
            L53:
                if (r10.hasCompilerVersion() == false) goto L55;
                mergeCompilerVersion(r10.getCompilerVersion());
            L55:
                mergeUnknownFields(r10.getUnknownFields());
                onChanged();
                return this;
            L44:
                if (CodeGeneratorRequest.access$1700(r10).isEmpty() == true) goto L53;
                if (this.sourceFileDescriptorsBuilder_.isEmpty() == false) goto L51;
                this.sourceFileDescriptorsBuilder_.dispose();
                this.sourceFileDescriptorsBuilder_ = null;
                this.sourceFileDescriptors_ = CodeGeneratorRequest.access$1700(r10);
                this.bitField0_ &= -9;
                if (CodeGeneratorRequest.access$2300() == false) goto L50;
                r11 = internalGetSourceFileDescriptorsFieldBuilder();
            L50:
                this.sourceFileDescriptorsBuilder_ = r11;
                goto L53
            L51:
                this.sourceFileDescriptorsBuilder_.addAllMessages(CodeGeneratorRequest.access$1700(r10));
                goto L53
            L25:
                if (CodeGeneratorRequest.access$1600(r10).isEmpty() == true) goto L35;
                if (this.protoFileBuilder_.isEmpty() == false) goto L33;
                this.protoFileBuilder_.dispose();
                this.protoFileBuilder_ = null;
                this.protoFile_ = CodeGeneratorRequest.access$1600(r10);
                this.bitField0_ &= -5;
                if (CodeGeneratorRequest.access$2200() == false) goto L31;
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = internalGetProtoFileFieldBuilder();
            L32:
                this.protoFileBuilder_ = r12;
                goto L35
            L31:
                r12 = null;
                goto L32
            L33:
                this.protoFileBuilder_.addAllMessages(CodeGeneratorRequest.access$1600(r10));
                goto L35
            }

            public Builder removeProtoFile(int r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.remove(r10);
                onChanged();
            L6:
                return this;
            L5:
                r11.remove(r10);
                goto L6
            }

            public Builder removeSourceFileDescriptors(int r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.remove(r10);
                onChanged();
            L6:
                return this;
            L5:
                r11.remove(r10);
                goto L6
            }

            public Builder setCompilerVersion(Version.Builder r10) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r11 = this.compilerVersionBuilder_;
                Version r12 = r10.build();
                if (r11 != null) goto L5;
                this.compilerVersion_ = r12;
            L6:
                this.bitField0_ |= 16;
                onChanged();
                return this;
            L5:
                r11.setMessage(r12);
                goto L6
            }

            public Builder setCompilerVersion(Version r10) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r11 = this.compilerVersionBuilder_;
                if (r11 != null) goto L5;
                Objects.requireNonNull(r10);
                this.compilerVersion_ = r10;
            L6:
                this.bitField0_ |= 16;
                onChanged();
                return this;
            L5:
                r11.setMessage(r10);
                goto L6
            }

            public Builder setFileToGenerate(int r10, String r11) {
                Objects.requireNonNull(r11);
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(r10, r11);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setParameter(String r10) {
                Objects.requireNonNull(r10);
                this.parameter_ = r10;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setParameterBytes(ByteString r10) {
                Objects.requireNonNull(r10);
                this.parameter_ = r10;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setProtoFile(int r10, DescriptorProtos.FileDescriptorProto.Builder r11) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.protoFileBuilder_;
                if (r12 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.set(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.setMessage(r10, r11.build());
                goto L6
            }

            public Builder setProtoFile(int r10, DescriptorProtos.FileDescriptorProto r11) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.protoFileBuilder_;
                if (r12 != null) goto L5;
                Objects.requireNonNull(r11);
                ensureProtoFileIsMutable();
                this.protoFile_.set(r10, r11);
                onChanged();
            L6:
                return this;
            L5:
                r12.setMessage(r10, r11);
                goto L6
            }

            public Builder setSourceFileDescriptors(int r10, DescriptorProtos.FileDescriptorProto.Builder r11) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.sourceFileDescriptorsBuilder_;
                if (r12 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.set(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.setMessage(r10, r11.build());
                goto L6
            }

            public Builder setSourceFileDescriptors(int r10, DescriptorProtos.FileDescriptorProto r11) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.sourceFileDescriptorsBuilder_;
                if (r12 != null) goto L5;
                Objects.requireNonNull(r11);
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.set(r10, r11);
                onChanged();
            L6:
                return this;
            L5:
                r12.setMessage(r10, r11);
                goto L6
            }
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CodeGeneratorRequest.class.getName());
            DEFAULT_INSTANCE = new CodeGeneratorRequest();
            PARSER = new AnonymousClass1();
        }

        private CodeGeneratorRequest() {
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = -1;
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.protoFile_ = Collections.emptyList();
            this.sourceFileDescriptors_ = Collections.emptyList();
        }

        private CodeGeneratorRequest(GeneratedMessage.Builder<?> r10) {
            super(r10);
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = -1;
        }

        /* synthetic */ CodeGeneratorRequest(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        static /* synthetic */ boolean access$1400() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        static /* synthetic */ List access$1600(CodeGeneratorRequest r10) {
            return r10.protoFile_;
        }

        static /* synthetic */ List access$1602(CodeGeneratorRequest r10, List r11) {
            r10.protoFile_ = r11;
            return r11;
        }

        static /* synthetic */ List access$1700(CodeGeneratorRequest r10) {
            return r10.sourceFileDescriptors_;
        }

        static /* synthetic */ List access$1702(CodeGeneratorRequest r10, List r11) {
            r10.sourceFileDescriptors_ = r11;
            return r11;
        }

        static /* synthetic */ LazyStringArrayList access$1800(CodeGeneratorRequest r10) {
            return r10.fileToGenerate_;
        }

        static /* synthetic */ LazyStringArrayList access$1802(CodeGeneratorRequest r10, LazyStringArrayList r11) {
            r10.fileToGenerate_ = r11;
            return r11;
        }

        static /* synthetic */ Object access$1900(CodeGeneratorRequest r10) {
            return r10.parameter_;
        }

        static /* synthetic */ Object access$1902(CodeGeneratorRequest r10, Object r11) {
            r10.parameter_ = r11;
            return r11;
        }

        static /* synthetic */ Version access$2002(CodeGeneratorRequest r10, Version r11) {
            r10.compilerVersion_ = r11;
            return r11;
        }

        static /* synthetic */ int access$2176(CodeGeneratorRequest r10, int r11) {
            int r12 = r11 | r10.bitField0_;
            r10.bitField0_ = r12;
            return r12;
        }

        static /* synthetic */ boolean access$2200() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        static /* synthetic */ boolean access$2300() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        public static CodeGeneratorRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.access$1000();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorRequest r10) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream r10) {
            return (CodeGeneratorRequest) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
            return (CodeGeneratorRequest) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorRequest parseFrom(ByteString r10) {
            return PARSER.parseFrom(r10);
        }

        public static CodeGeneratorRequest parseFrom(ByteString r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream r10) {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, r10);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorRequest parseFrom(InputStream r10) {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, r10);
        }

        public static CodeGeneratorRequest parseFrom(InputStream r10, ExtensionRegistryLite r11) {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer r10) {
            return PARSER.parseFrom(r10);
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static CodeGeneratorRequest parseFrom(byte[] r10) {
            return PARSER.parseFrom(r10);
        }

        public static CodeGeneratorRequest parseFrom(byte[] r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof CodeGeneratorRequest) == false) goto L8;
            CodeGeneratorRequest r11 = (CodeGeneratorRequest) r10;
            if (getFileToGenerateList().equals(r11.getFileToGenerateList()) == true) goto L13;
            return false;
        L13:
            if (hasParameter() == r11.hasParameter()) goto L16;
            return false;
        L16:
            if (hasParameter() == false) goto L21;
            if (getParameter().equals(r11.getParameter()) == true) goto L21;
            return false;
        L21:
            if (getProtoFileList().equals(r11.getProtoFileList()) == true) goto L24;
            return false;
        L24:
            if (getSourceFileDescriptorsList().equals(r11.getSourceFileDescriptorsList()) == true) goto L27;
            return false;
        L27:
            if (hasCompilerVersion() == r11.hasCompilerVersion()) goto L30;
            return false;
        L30:
            if (hasCompilerVersion() == false) goto L35;
            if (getCompilerVersion().equals(r11.getCompilerVersion()) == true) goto L35;
            return false;
        L35:
            if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L37;
            return false;
        L37:
            return true;
        L8:
            return super.equals(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public Version getCompilerVersion() {
            Version r10 = this.compilerVersion_;
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Version.getDefaultInstance();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public VersionOrBuilder getCompilerVersionOrBuilder() {
            Version r10 = this.compilerVersion_;
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Version.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getFileToGenerate(int r10) {
            return this.fileToGenerate_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getFileToGenerateBytes(int r10) {
            return this.fileToGenerate_.getByteString(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getFileToGenerateCount() {
            return this.fileToGenerate_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ProtocolStringList getFileToGenerateList() {
            return this.fileToGenerate_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public /* bridge */ /* synthetic */ List getFileToGenerateList() {
            return getFileToGenerateList();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getParameter() {
            Object r10 = this.parameter_;
            if ((r10 instanceof String) == true) goto L5;
            ByteString r11 = (ByteString) r10;
            String r12 = r11.toStringUtf8();
            if (r11.isValidUtf8() == false) goto L9;
            this.parameter_ = r12;
        L9:
            return r12;
        L5:
            return (String) r10;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getParameterBytes() {
            Object r10 = this.parameter_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.parameter_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getProtoFile(int r10) {
            return this.protoFile_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getProtoFileCount() {
            return this.protoFile_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r10) {
            return this.protoFile_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r10 = this.memoizedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            int r12 = 0;
            int r13 = 0;
        L7:
            if (r12 >= this.fileToGenerate_.size()) goto L9;
            r13 = r13 + GeneratedMessage.computeStringSizeNoTag(this.fileToGenerate_.getRaw(r12));
            r12 = r12 + 1;
            goto L7
        L9:
            int r14 = (r13 + 0) + (getFileToGenerateList().size() * 1);
            if ((this.bitField0_ & 1) == 0) goto L13;
            r14 = r14 + GeneratedMessage.computeStringSize(2, this.parameter_);
        L13:
            if ((this.bitField0_ & 2) == 0) goto L15;
            r14 = r14 + CodedOutputStream.computeMessageSize(3, getCompilerVersion());
        L15:
            int r15 = 0;
        L17:
            if (r15 >= this.protoFile_.size()) goto L20;
            r14 = r14 + CodedOutputStream.computeMessageSize(15, this.protoFile_.get(r15));
            r15 = r15 + 1;
        L20:
            if (r11 >= this.sourceFileDescriptors_.size()) goto L22;
            r14 = r14 + CodedOutputStream.computeMessageSize(17, this.sourceFileDescriptors_.get(r11));
            r11 = r11 + 1;
            goto L20
        L22:
            int r16 = r14 + getUnknownFields().getSerializedSize();
            this.memoizedSize = r16;
            return r16;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r10) {
            return this.sourceFileDescriptors_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public int getSourceFileDescriptorsCount() {
            return this.sourceFileDescriptors_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList() {
            return this.sourceFileDescriptors_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r10) {
            return this.sourceFileDescriptors_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList() {
            return this.sourceFileDescriptors_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasCompilerVersion() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public boolean hasParameter() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r10 = this.memoizedHashCode;
            if (r10 == 0) goto L5;
            return r10;
        L5:
            int r11 = 779 + getDescriptor().hashCode();
            if (getFileToGenerateCount() <= 0) goto L9;
            r11 = (((r11 * 37) + 1) * 53) + getFileToGenerateList().hashCode();
        L9:
            if (hasParameter() == false) goto L12;
            r11 = (((r11 * 37) + 2) * 53) + getParameter().hashCode();
        L12:
            if (getProtoFileCount() <= 0) goto L15;
            r11 = (((r11 * 37) + 15) * 53) + getProtoFileList().hashCode();
        L15:
            if (getSourceFileDescriptorsCount() <= 0) goto L18;
            r11 = (((r11 * 37) + 17) * 53) + getSourceFileDescriptorsList().hashCode();
        L18:
            if (hasCompilerVersion() == false) goto L20;
            r11 = (((r11 * 37) + 3) * 53) + getCompilerVersion().hashCode();
        L20:
            int r12 = (r11 * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$1100().ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L6;
            return true;
        L6:
            if (r10 != 0) goto L8;
            return false;
        L8:
            int r11 = 0;
        L10:
            if (r11 >= getProtoFileCount()) goto L16;
            if (getProtoFile(r11).isInitialized() == false) goto L13;
            r11 = r11 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r12 = 0;
        L18:
            if (r12 >= getSourceFileDescriptorsCount()) goto L24;
            if (getSourceFileDescriptors(r12).isInitialized() == false) goto L21;
            r12 = r12 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L24:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.AbstractMessage
        protected /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
            return newBuilderForType(r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.AbstractMessage
        protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
            return new Builder(r10, null);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            AnonymousClass1 r10 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r10);
        L6:
            return new Builder(r10).mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            int r11 = 0;
            int r12 = 0;
        L4:
            if (r12 >= this.fileToGenerate_.size()) goto L7;
            GeneratedMessage.writeString(r10, 1, this.fileToGenerate_.getRaw(r12));
            r12 = r12 + 1;
            goto L4
        L7:
            if ((this.bitField0_ & 1) == 0) goto L10;
            GeneratedMessage.writeString(r10, 2, this.parameter_);
        L10:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10.writeMessage(3, getCompilerVersion());
        L12:
            int r13 = 0;
        L14:
            if (r13 >= this.protoFile_.size()) goto L17;
            r10.writeMessage(15, this.protoFile_.get(r13));
            r13 = r13 + 1;
        L17:
            if (r11 >= this.sourceFileDescriptors_.size()) goto L19;
            r10.writeMessage(17, this.sourceFileDescriptors_.get(r11));
            r11 = r11 + 1;
            goto L17
        L19:
            getUnknownFields().writeTo(r10);
        }
    }

    public interface CodeGeneratorRequestOrBuilder extends MessageOrBuilder {
        Version getCompilerVersion();

        VersionOrBuilder getCompilerVersionOrBuilder();

        String getFileToGenerate(int r10);

        ByteString getFileToGenerateBytes(int r10);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int r10);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r10);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();

        DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r10);

        int getSourceFileDescriptorsCount();

        List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r10);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList();

        boolean hasCompilerVersion();

        boolean hasParameter();
    }

    public static final class CodeGeneratorResponse extends GeneratedMessage implements CodeGeneratorResponseOrBuilder {
        private static final CodeGeneratorResponse DEFAULT_INSTANCE = null;
        public static final int ERROR_FIELD_NUMBER = 1;
        public static final int FILE_FIELD_NUMBER = 15;
        public static final int MAXIMUM_EDITION_FIELD_NUMBER = 4;
        public static final int MINIMUM_EDITION_FIELD_NUMBER = 3;
        private static final Parser<CodeGeneratorResponse> PARSER = null;
        public static final int SUPPORTED_FEATURES_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object error_;
        private List<File> file_;
        private int maximumEdition_;
        private byte memoizedIsInitialized;
        private int minimumEdition_;
        private long supportedFeatures_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements CodeGeneratorResponseOrBuilder {
            private int bitField0_;
            private Object error_;
            private RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> fileBuilder_;
            private List<File> file_;
            private int maximumEdition_;
            private int minimumEdition_;
            private long supportedFeatures_;

            private Builder() {
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            private Builder(AbstractMessage.BuilderParent r10) {
                super(r10);
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
                this(r10);
            }

            /* synthetic */ Builder(AnonymousClass1 r10) {
                this();
            }

            private void buildPartial0(CodeGeneratorResponse r10) {
                int r11 = this.bitField0_;
                if ((r11 & 1) == 0) goto L5;
                CodeGeneratorResponse.access$4102(r10, this.error_);
                int r12 = 1;
            L7:
                if ((r11 & 2) == 0) goto L10;
                CodeGeneratorResponse.access$4202(r10, this.supportedFeatures_);
                r12 = r12 | 2;
            L10:
                if ((r11 & 4) == 0) goto L13;
                CodeGeneratorResponse.access$4302(r10, this.minimumEdition_);
                r12 = r12 | 4;
            L13:
                if ((r11 & 8) == 0) goto L15;
                CodeGeneratorResponse.access$4402(r10, this.maximumEdition_);
                r12 = r12 | 8;
            L15:
                CodeGeneratorResponse.access$4576(r10, r12);
                return;
            L5:
                r12 = 0;
                goto L7
            }

            private void buildPartialRepeatedFields(CodeGeneratorResponse r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 == null) goto L5;
                List r12 = r11.build();
            L9:
                CodeGeneratorResponse.access$4002(r10, r12);
                return;
            L5:
                if ((this.bitField0_ & 16) == 0) goto L7;
                this.file_ = Collections.unmodifiableList(this.file_);
                this.bitField0_ &= -17;
            L7:
                r12 = this.file_;
                goto L9
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & 16) != 0) goto L6;
                this.file_ = new ArrayList(this.file_);
                this.bitField0_ |= 16;
                return;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.access$2400();
            }

            private RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> internalGetFileFieldBuilder() {
                if (this.fileBuilder_ != null) goto L10;
                List<File> r10 = this.file_;
                if ((this.bitField0_ & 16) == 0) goto L7;
                boolean r11 = true;
            L8:
                this.fileBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
                this.file_ = null;
                goto L10
            L7:
                r11 = false;
            L10:
                return this.fileBuilder_;
            }

            public Builder addAllFile(Iterable<? extends File> r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                ensureFileIsMutable();
                AbstractMessageLite.Builder.addAll(r10, this.file_);
                onChanged();
            L6:
                return this;
            L5:
                r11.addAllMessages(r10);
                goto L6
            }

            public Builder addFile(int r10, File.Builder r11) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 != null) goto L5;
                ensureFileIsMutable();
                this.file_.add(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.addMessage(r10, r11.build());
                goto L6
            }

            public Builder addFile(int r10, File r11) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 != null) goto L5;
                Objects.requireNonNull(r11);
                ensureFileIsMutable();
                this.file_.add(r10, r11);
                onChanged();
            L6:
                return this;
            L5:
                r12.addMessage(r10, r11);
                goto L6
            }

            public Builder addFile(File.Builder r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                ensureFileIsMutable();
                this.file_.add(r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r10.build());
                goto L6
            }

            public Builder addFile(File r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                Objects.requireNonNull(r10);
                ensureFileIsMutable();
                this.file_.add(r10);
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r10);
                goto L6
            }

            public File.Builder addFileBuilder() {
                return (File.Builder) internalGetFileFieldBuilder().addBuilder(File.getDefaultInstance());
            }

            public File.Builder addFileBuilder(int r10) {
                return (File.Builder) internalGetFileFieldBuilder().addBuilder(r10, File.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse build() {
                CodeGeneratorResponse r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r10);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse buildPartial() {
                CodeGeneratorResponse r10 = new CodeGeneratorResponse(this, null);
                buildPartialRepeatedFields(r10);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r10);
            L5:
                onBuilt();
                return r10;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.error_ = "";
                this.supportedFeatures_ = 0;
                this.minimumEdition_ = 0;
                this.maximumEdition_ = 0;
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L5;
                this.file_ = Collections.emptyList();
            L6:
                this.bitField0_ &= -17;
                return this;
            L5:
                this.file_ = null;
                r10.clear();
                goto L6
            }

            public Builder clearError() {
                this.error_ = CodeGeneratorResponse.getDefaultInstance().getError();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearFile() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L5;
                this.file_ = Collections.emptyList();
                this.bitField0_ &= -17;
                onChanged();
            L6:
                return this;
            L5:
                r10.clear();
                goto L6
            }

            public Builder clearMaximumEdition() {
                this.bitField0_ &= -9;
                this.maximumEdition_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMinimumEdition() {
                this.bitField0_ &= -5;
                this.minimumEdition_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSupportedFeatures() {
                this.bitField0_ &= -3;
                this.supportedFeatures_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CodeGeneratorResponse getDefaultInstanceForType() {
                return CodeGeneratorResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.access$2400();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public String getError() {
                Object r10 = this.error_;
                if ((r10 instanceof String) == true) goto L9;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L7;
                this.error_ = r12;
            L7:
                return r12;
            L9:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public ByteString getErrorBytes() {
                Object r10 = this.error_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.error_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public File getFile(int r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L7;
                MessageLite r12 = this.file_.get(r10);
            L6:
                return (File) r12;
            L7:
                r12 = r11.getMessage(r10);
                goto L6
            }

            public File.Builder getFileBuilder(int r10) {
                return (File.Builder) internalGetFileFieldBuilder().getBuilder(r10);
            }

            public List<File.Builder> getFileBuilderList() {
                return internalGetFileFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getFileCount() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L7;
                return this.file_.size();
            L7:
                return r10.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<File> getFileList() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L7;
                return Collections.unmodifiableList(this.file_);
            L7:
                return r10.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public FileOrBuilder getFileOrBuilder(int r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L7;
                Object r12 = this.file_.get(r10);
            L6:
                return (FileOrBuilder) r12;
            L7:
                r12 = r11.getMessageOrBuilder(r10);
                goto L6
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<? extends FileOrBuilder> getFileOrBuilderList() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 == null) goto L7;
                return r10.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.file_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getMaximumEdition() {
                return this.maximumEdition_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getMinimumEdition() {
                return this.minimumEdition_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public long getSupportedFeatures() {
                return this.supportedFeatures_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasError() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasMaximumEdition() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasMinimumEdition() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public boolean hasSupportedFeatures() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$2500().ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
                return mergeFrom(r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
                return mergeFrom(r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Objects.requireNonNull(r11);
                boolean r12 = false;
            L3:
                if (r12 == true) goto L36;
                int r13 = r10.readTag();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                if (r13 == 0) goto L28;
                if (r13 != 10) goto L9;
                this.error_ = r10.readBytes();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.bitField0_ |= 1;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L9:
                if (r13 != 16) goto L11;
                this.supportedFeatures_ = r10.readUInt64();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.bitField0_ |= 2;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L11:
                if (r13 != 24) goto L13;
                this.minimumEdition_ = r10.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.bitField0_ |= 4;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L13:
                if (r13 != 32) goto L15;
                this.maximumEdition_ = r10.readInt32();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.bitField0_ |= 8;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L15:
                if (r13 != 122) goto L17;
                File r14 = (File) r10.readMessage(File.parser(), r11);     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r15 = this.fileBuilder_;     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                if (r15 == null) goto L21;
                r15.addMessage(r14);     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L21:
                ensureFileIsMutable();     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                this.file_.add(r14);     // Catch: Throwable -> L29 InvalidProtocolBufferException -> L31
                goto L3
            L17:
                if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
            L28:
                r12 = true;
                goto L3
            L29:
                th = move-exception;
                onChanged();
                throw th;
            L31:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L29
            L36:
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r10) {
                if ((r10 instanceof CodeGeneratorResponse) == true) goto L5;
                super.mergeFrom(r10);
                return this;
            L5:
                return mergeFrom((CodeGeneratorResponse) r10);
            }

            public Builder mergeFrom(CodeGeneratorResponse r10) {
                if (r10 != CodeGeneratorResponse.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasError() == false) goto L9;
                this.error_ = CodeGeneratorResponse.access$4100(r10);
                this.bitField0_ |= 1;
                onChanged();
            L9:
                if (r10.hasSupportedFeatures() == false) goto L12;
                setSupportedFeatures(r10.getSupportedFeatures());
            L12:
                if (r10.hasMinimumEdition() == false) goto L15;
                setMinimumEdition(r10.getMinimumEdition());
            L15:
                if (r10.hasMaximumEdition() == false) goto L18;
                setMaximumEdition(r10.getMaximumEdition());
            L18:
                if (this.fileBuilder_ != null) goto L27;
                if (CodeGeneratorResponse.access$4000(r10).isEmpty() == false) goto L22;
            L35:
                mergeUnknownFields(r10.getUnknownFields());
                onChanged();
                return this;
            L22:
                if (this.file_.isEmpty() == false) goto L24;
                this.file_ = CodeGeneratorResponse.access$4000(r10);
                this.bitField0_ &= -17;
            L25:
                onChanged();
                goto L35
            L24:
                ensureFileIsMutable();
                this.file_.addAll(CodeGeneratorResponse.access$4000(r10));
                goto L25
            L27:
                if (CodeGeneratorResponse.access$4000(r10).isEmpty() == true) goto L35;
                if (this.fileBuilder_.isEmpty() == false) goto L34;
                this.fileBuilder_.dispose();
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = null;
                this.fileBuilder_ = null;
                this.file_ = CodeGeneratorResponse.access$4000(r10);
                this.bitField0_ &= -17;
                if (CodeGeneratorResponse.access$4600() == false) goto L33;
                r11 = internalGetFileFieldBuilder();
            L33:
                this.fileBuilder_ = r11;
                goto L35
            L34:
                this.fileBuilder_.addAllMessages(CodeGeneratorResponse.access$4000(r10));
                goto L35
            }

            public Builder removeFile(int r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                ensureFileIsMutable();
                this.file_.remove(r10);
                onChanged();
            L6:
                return this;
            L5:
                r11.remove(r10);
                goto L6
            }

            public Builder setError(String r10) {
                Objects.requireNonNull(r10);
                this.error_ = r10;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setErrorBytes(ByteString r10) {
                Objects.requireNonNull(r10);
                this.error_ = r10;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setFile(int r10, File.Builder r11) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 != null) goto L5;
                ensureFileIsMutable();
                this.file_.set(r10, r11.build());
                onChanged();
            L6:
                return this;
            L5:
                r12.setMessage(r10, r11.build());
                goto L6
            }

            public Builder setFile(int r10, File r11) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r12 = this.fileBuilder_;
                if (r12 != null) goto L5;
                Objects.requireNonNull(r11);
                ensureFileIsMutable();
                this.file_.set(r10, r11);
                onChanged();
            L6:
                return this;
            L5:
                r12.setMessage(r10, r11);
                goto L6
            }

            public Builder setMaximumEdition(int r10) {
                this.maximumEdition_ = r10;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setMinimumEdition(int r10) {
                this.minimumEdition_ = r10;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setSupportedFeatures(long r10) {
                this.supportedFeatures_ = r10;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }
        }

        public static final enum Feature extends Enum<Feature> implements ProtocolMessageEnum {
            private static final /* synthetic */ Feature[] $VALUES = null;
            public static final Feature FEATURE_NONE = null;
            public static final int FEATURE_NONE_VALUE = 0;
            public static final Feature FEATURE_PROTO3_OPTIONAL = null;
            public static final int FEATURE_PROTO3_OPTIONAL_VALUE = 1;
            public static final Feature FEATURE_SUPPORTS_EDITIONS = null;
            public static final int FEATURE_SUPPORTS_EDITIONS_VALUE = 2;
            private static final Feature[] VALUES = null;
            private static final Internal.EnumLiteMap<Feature> internalValueMap = null;
            private final int value;

            private static /* synthetic */ Feature[] $values() {
                return new Feature[]{FEATURE_NONE, FEATURE_PROTO3_OPTIONAL, FEATURE_SUPPORTS_EDITIONS};
            }

            static {
                FEATURE_NONE = new Feature("FEATURE_NONE", 0, 0);
                FEATURE_PROTO3_OPTIONAL = new Feature("FEATURE_PROTO3_OPTIONAL", 1, 1);
                FEATURE_SUPPORTS_EDITIONS = new Feature("FEATURE_SUPPORTS_EDITIONS", 2, 2);
                $VALUES = $values();
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Feature.class.getName());
                internalValueMap = new AnonymousClass1();
                VALUES = values();
            }

            private Feature(String r10, int r11, int r12) {
                super(r10, r11);
                this.value = r12;
            }

            public static Feature forNumber(int r10) {
                if (r10 == 0) goto L14;
                if (r10 == 1) goto L12;
                if (r10 == 2) goto L10;
                return null;
            L10:
                return FEATURE_SUPPORTS_EDITIONS;
            L12:
                return FEATURE_PROTO3_OPTIONAL;
            L14:
                return FEATURE_NONE;
            }

            public static Descriptors.EnumDescriptor getDescriptor() {
                return CodeGeneratorResponse.getDescriptor().getEnumTypes().get(0);
            }

            public static Internal.EnumLiteMap<Feature> internalGetValueMap() {
                return internalValueMap;
            }

            @Deprecated
            public static Feature valueOf(int r10) {
                return forNumber(r10);
            }

            public static Feature valueOf(Descriptors.EnumValueDescriptor r10) {
                if (r10.getType() != getDescriptor()) goto L7;
                return VALUES[r10.getIndex()];
            L7:
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            public static Feature valueOf(String r10) {
                return (Feature) Enum.valueOf(Feature.class, r10);
            }

            public static Feature[] values() {
                return (Feature[]) $VALUES.clone();
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }
        }

        public static final class File extends GeneratedMessage implements FileOrBuilder {
            public static final int CONTENT_FIELD_NUMBER = 15;
            private static final File DEFAULT_INSTANCE = null;
            public static final int GENERATED_CODE_INFO_FIELD_NUMBER = 16;
            public static final int INSERTION_POINT_FIELD_NUMBER = 2;
            public static final int NAME_FIELD_NUMBER = 1;
            private static final Parser<File> PARSER = null;
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private volatile Object content_;
            private DescriptorProtos.GeneratedCodeInfo generatedCodeInfo_;
            private volatile Object insertionPoint_;
            private byte memoizedIsInitialized;
            private volatile Object name_;

            public static final class Builder extends GeneratedMessage.Builder<Builder> implements FileOrBuilder {
                private int bitField0_;
                private Object content_;
                private SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> generatedCodeInfoBuilder_;
                private DescriptorProtos.GeneratedCodeInfo generatedCodeInfo_;
                private Object insertionPoint_;
                private Object name_;

                private Builder() {
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                private Builder(AbstractMessage.BuilderParent r10) {
                    super(r10);
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
                    this(r10);
                }

                /* synthetic */ Builder(AnonymousClass1 r10) {
                    this();
                }

                private void buildPartial0(File r10) {
                    int r11 = this.bitField0_;
                    if ((r11 & 1) == 0) goto L5;
                    File.access$3202(r10, this.name_);
                    int r12 = 1;
                L7:
                    if ((r11 & 2) == 0) goto L10;
                    File.access$3302(r10, this.insertionPoint_);
                    r12 = r12 | 2;
                L10:
                    if ((r11 & 4) == 0) goto L13;
                    File.access$3402(r10, this.content_);
                    r12 = r12 | 4;
                L13:
                    if ((r11 & 8) == 0) goto L19;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r13 = this.generatedCodeInfoBuilder_;
                    if (r13 != null) goto L17;
                    DescriptorProtos.GeneratedCodeInfo r14 = this.generatedCodeInfo_;
                L18:
                    File.access$3502(r10, r14);
                    r12 = r12 | 8;
                    goto L19
                L17:
                    r14 = (DescriptorProtos.GeneratedCodeInfo) r13.build();
                L19:
                    File.access$3676(r10, r12);
                    return;
                L5:
                    r12 = 0;
                    goto L7
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return PluginProtos.access$2600();
                }

                private SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> internalGetGeneratedCodeInfoFieldBuilder() {
                    if (this.generatedCodeInfoBuilder_ != null) goto L6;
                    this.generatedCodeInfoBuilder_ = new SingleFieldBuilder(getGeneratedCodeInfo(), getParentForChildren(), isClean());
                    this.generatedCodeInfo_ = null;
                L6:
                    return this.generatedCodeInfoBuilder_;
                }

                private void maybeForceBuilderInitialization() {
                    if (File.access$3000() == false) goto L6;
                    internalGetGeneratedCodeInfoFieldBuilder();
                    return;
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File build() {
                    File r10 = buildPartial();
                    if (r10.isInitialized() == false) goto L6;
                    return r10;
                L6:
                    throw AbstractMessage.Builder.newUninitializedMessageException(r10);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message buildPartial() {
                    return buildPartial();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return buildPartial();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File buildPartial() {
                    File r10 = new File(this, null);
                    if (this.bitField0_ == 0) goto L5;
                    buildPartial0(r10);
                L5:
                    onBuilt();
                    return r10;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.bitField0_ = 0;
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r10 = this.generatedCodeInfoBuilder_;
                    if (r10 == null) goto L5;
                    r10.dispose();
                    this.generatedCodeInfoBuilder_ = null;
                L5:
                    return this;
                }

                public Builder clearContent() {
                    this.content_ = File.getDefaultInstance().getContent();
                    this.bitField0_ &= -5;
                    onChanged();
                    return this;
                }

                public Builder clearGeneratedCodeInfo() {
                    this.bitField0_ &= -9;
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r10 = this.generatedCodeInfoBuilder_;
                    if (r10 == null) goto L5;
                    r10.dispose();
                    this.generatedCodeInfoBuilder_ = null;
                L5:
                    onChanged();
                    return this;
                }

                public Builder clearInsertionPoint() {
                    this.insertionPoint_ = File.getDefaultInstance().getInsertionPoint();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }

                public Builder clearName() {
                    this.name_ = File.getDefaultInstance().getName();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getContent() {
                    Object r10 = this.content_;
                    if ((r10 instanceof String) == true) goto L9;
                    ByteString r11 = (ByteString) r10;
                    String r12 = r11.toStringUtf8();
                    if (r11.isValidUtf8() == false) goto L7;
                    this.content_ = r12;
                L7:
                    return r12;
                L9:
                    return (String) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getContentBytes() {
                    Object r10 = this.content_;
                    if ((r10 instanceof String) == false) goto L7;
                    ByteString r11 = ByteString.copyFromUtf8((String) r10);
                    this.content_ = r11;
                    return r11;
                L7:
                    return (ByteString) r10;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public File getDefaultInstanceForType() {
                    return File.getDefaultInstance();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return PluginProtos.access$2600();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r10 = this.generatedCodeInfoBuilder_;
                    if (r10 != null) goto L9;
                    DescriptorProtos.GeneratedCodeInfo r11 = this.generatedCodeInfo_;
                    if (r11 == null) goto L7;
                    return r11;
                L7:
                    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                L9:
                    return (DescriptorProtos.GeneratedCodeInfo) r10.getMessage();
                }

                public DescriptorProtos.GeneratedCodeInfo.Builder getGeneratedCodeInfoBuilder() {
                    this.bitField0_ |= 8;
                    onChanged();
                    return (DescriptorProtos.GeneratedCodeInfo.Builder) internalGetGeneratedCodeInfoFieldBuilder().getBuilder();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r10 = this.generatedCodeInfoBuilder_;
                    if (r10 != null) goto L5;
                    DescriptorProtos.GeneratedCodeInfo r11 = this.generatedCodeInfo_;
                    if (r11 == null) goto L9;
                    return r11;
                L9:
                    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                L5:
                    return (DescriptorProtos.GeneratedCodeInfoOrBuilder) r10.getMessageOrBuilder();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getInsertionPoint() {
                    Object r10 = this.insertionPoint_;
                    if ((r10 instanceof String) == true) goto L9;
                    ByteString r11 = (ByteString) r10;
                    String r12 = r11.toStringUtf8();
                    if (r11.isValidUtf8() == false) goto L7;
                    this.insertionPoint_ = r12;
                L7:
                    return r12;
                L9:
                    return (String) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getInsertionPointBytes() {
                    Object r10 = this.insertionPoint_;
                    if ((r10 instanceof String) == false) goto L7;
                    ByteString r11 = ByteString.copyFromUtf8((String) r10);
                    this.insertionPoint_ = r11;
                    return r11;
                L7:
                    return (ByteString) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getName() {
                    Object r10 = this.name_;
                    if ((r10 instanceof String) == true) goto L9;
                    ByteString r11 = (ByteString) r10;
                    String r12 = r11.toStringUtf8();
                    if (r11.isValidUtf8() == false) goto L7;
                    this.name_ = r12;
                L7:
                    return r12;
                L9:
                    return (String) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getNameBytes() {
                    Object r10 = this.name_;
                    if ((r10 instanceof String) == false) goto L7;
                    ByteString r11 = ByteString.copyFromUtf8((String) r10);
                    this.name_ = r11;
                    return r11;
                L7:
                    return (ByteString) r10;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasContent() {
                    if ((this.bitField0_ & 4) == 0) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasGeneratedCodeInfo() {
                    if ((this.bitField0_ & 8) == 0) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasInsertionPoint() {
                    if ((this.bitField0_ & 2) == 0) goto L5;
                    return true;
                L5:
                    return false;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public boolean hasName() {
                    if ((this.bitField0_ & 1) != 0) goto L7;
                    return false;
                L7:
                    return true;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder
                protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                    return PluginProtos.access$2700().ensureFieldAccessorsInitialized(File.class, Builder.class);
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
                    return mergeFrom(r10);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
                    return mergeFrom(r10);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    return mergeFrom(r10, r11);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                    Objects.requireNonNull(r11);
                    boolean r12 = false;
                L3:
                    if (r12 == true) goto L30;
                    int r13 = r10.readTag();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    if (r13 == 0) goto L22;
                    if (r13 != 10) goto L9;
                    this.name_ = r10.readBytes();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    this.bitField0_ |= 1;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    goto L3
                L9:
                    if (r13 != 18) goto L11;
                    this.insertionPoint_ = r10.readBytes();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    this.bitField0_ |= 2;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    goto L3
                L11:
                    if (r13 != 122) goto L13;
                    this.content_ = r10.readBytes();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    this.bitField0_ |= 4;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    goto L3
                L13:
                    if (r13 != 130) goto L15;
                    r10.readMessage(internalGetGeneratedCodeInfoFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    this.bitField0_ |= 8;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                    goto L3
                L15:
                    if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
                L22:
                    r12 = true;
                    goto L3
                L25:
                    e = move-exception;
                    throw e.unwrapIOException();     // Catch: Throwable -> L23
                L23:
                    th = move-exception;
                    onChanged();
                    throw th;
                L30:
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message r10) {
                    if ((r10 instanceof File) == true) goto L5;
                    super.mergeFrom(r10);
                    return this;
                L5:
                    return mergeFrom((File) r10);
                }

                public Builder mergeFrom(File r10) {
                    if (r10 != File.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r10.hasName() == false) goto L9;
                    this.name_ = File.access$3200(r10);
                    this.bitField0_ |= 1;
                    onChanged();
                L9:
                    if (r10.hasInsertionPoint() == false) goto L12;
                    this.insertionPoint_ = File.access$3300(r10);
                    this.bitField0_ |= 2;
                    onChanged();
                L12:
                    if (r10.hasContent() == false) goto L15;
                    this.content_ = File.access$3400(r10);
                    this.bitField0_ |= 4;
                    onChanged();
                L15:
                    if (r10.hasGeneratedCodeInfo() == false) goto L17;
                    mergeGeneratedCodeInfo(r10.getGeneratedCodeInfo());
                L17:
                    mergeUnknownFields(r10.getUnknownFields());
                    onChanged();
                    return this;
                }

                public Builder mergeGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo r10) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r11 = this.generatedCodeInfoBuilder_;
                    if (r11 == null) goto L5;
                    r11.mergeFrom(r10);
                L14:
                    if (this.generatedCodeInfo_ == null) goto L16;
                    this.bitField0_ |= 8;
                    onChanged();
                L16:
                    return this;
                L5:
                    if ((this.bitField0_ & 8) == 0) goto L11;
                    DescriptorProtos.GeneratedCodeInfo r12 = this.generatedCodeInfo_;
                    if (r12 == null) goto L11;
                    if (r12 == DescriptorProtos.GeneratedCodeInfo.getDefaultInstance()) goto L11;
                    getGeneratedCodeInfoBuilder().mergeFrom(r10);
                L11:
                    this.generatedCodeInfo_ = r10;
                    goto L14
                }

                public Builder setContent(String r10) {
                    Objects.requireNonNull(r10);
                    this.content_ = r10;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                }

                public Builder setContentBytes(ByteString r10) {
                    Objects.requireNonNull(r10);
                    this.content_ = r10;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo.Builder r10) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r11 = this.generatedCodeInfoBuilder_;
                    DescriptorProtos.GeneratedCodeInfo r12 = r10.build();
                    if (r11 != null) goto L5;
                    this.generatedCodeInfo_ = r12;
                L6:
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                L5:
                    r11.setMessage(r12);
                    goto L6
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo r10) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r11 = this.generatedCodeInfoBuilder_;
                    if (r11 != null) goto L5;
                    Objects.requireNonNull(r10);
                    this.generatedCodeInfo_ = r10;
                L6:
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                L5:
                    r11.setMessage(r10);
                    goto L6
                }

                public Builder setInsertionPoint(String r10) {
                    Objects.requireNonNull(r10);
                    this.insertionPoint_ = r10;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                }

                public Builder setInsertionPointBytes(ByteString r10) {
                    Objects.requireNonNull(r10);
                    this.insertionPoint_ = r10;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                }

                public Builder setName(String r10) {
                    Objects.requireNonNull(r10);
                    this.name_ = r10;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                }

                public Builder setNameBytes(ByteString r10) {
                    Objects.requireNonNull(r10);
                    this.name_ = r10;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                }
            }

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", File.class.getName());
                DEFAULT_INSTANCE = new File();
                PARSER = new AnonymousClass1();
            }

            private File() {
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = -1;
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
            }

            private File(GeneratedMessage.Builder<?> r10) {
                super(r10);
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = -1;
            }

            /* synthetic */ File(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
                this(r10);
            }

            static /* synthetic */ boolean access$3000() {
                return GeneratedMessage.alwaysUseFieldBuilders;
            }

            static /* synthetic */ Object access$3200(File r10) {
                return r10.name_;
            }

            static /* synthetic */ Object access$3202(File r10, Object r11) {
                r10.name_ = r11;
                return r11;
            }

            static /* synthetic */ Object access$3300(File r10) {
                return r10.insertionPoint_;
            }

            static /* synthetic */ Object access$3302(File r10, Object r11) {
                r10.insertionPoint_ = r11;
                return r11;
            }

            static /* synthetic */ Object access$3400(File r10) {
                return r10.content_;
            }

            static /* synthetic */ Object access$3402(File r10, Object r11) {
                r10.content_ = r11;
                return r11;
            }

            static /* synthetic */ DescriptorProtos.GeneratedCodeInfo access$3502(File r10, DescriptorProtos.GeneratedCodeInfo r11) {
                r10.generatedCodeInfo_ = r11;
                return r11;
            }

            static /* synthetic */ int access$3676(File r10, int r11) {
                int r12 = r11 | r10.bitField0_;
                r10.bitField0_ = r12;
                return r12;
            }

            public static File getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.access$2600();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(File r10) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
            }

            public static File parseDelimitedFrom(InputStream r10) {
                return (File) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
            }

            public static File parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
                return (File) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
            }

            public static File parseFrom(ByteString r10) {
                return PARSER.parseFrom(r10);
            }

            public static File parseFrom(ByteString r10, ExtensionRegistryLite r11) {
                return PARSER.parseFrom(r10, r11);
            }

            public static File parseFrom(CodedInputStream r10) {
                return (File) GeneratedMessage.parseWithIOException(PARSER, r10);
            }

            public static File parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return (File) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
            }

            public static File parseFrom(InputStream r10) {
                return (File) GeneratedMessage.parseWithIOException(PARSER, r10);
            }

            public static File parseFrom(InputStream r10, ExtensionRegistryLite r11) {
                return (File) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
            }

            public static File parseFrom(ByteBuffer r10) {
                return PARSER.parseFrom(r10);
            }

            public static File parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
                return PARSER.parseFrom(r10, r11);
            }

            public static File parseFrom(byte[] r10) {
                return PARSER.parseFrom(r10);
            }

            public static File parseFrom(byte[] r10, ExtensionRegistryLite r11) {
                return PARSER.parseFrom(r10, r11);
            }

            public static Parser<File> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object r10) {
                if (r10 != this) goto L6;
                return true;
            L6:
                if ((r10 instanceof File) == false) goto L8;
                File r11 = (File) r10;
                if (hasName() == r11.hasName()) goto L13;
                return false;
            L13:
                if (hasName() == false) goto L18;
                if (getName().equals(r11.getName()) == true) goto L18;
                return false;
            L18:
                if (hasInsertionPoint() == r11.hasInsertionPoint()) goto L21;
                return false;
            L21:
                if (hasInsertionPoint() == false) goto L26;
                if (getInsertionPoint().equals(r11.getInsertionPoint()) == true) goto L26;
                return false;
            L26:
                if (hasContent() == r11.hasContent()) goto L29;
                return false;
            L29:
                if (hasContent() == false) goto L34;
                if (getContent().equals(r11.getContent()) == true) goto L34;
                return false;
            L34:
                if (hasGeneratedCodeInfo() == r11.hasGeneratedCodeInfo()) goto L37;
                return false;
            L37:
                if (hasGeneratedCodeInfo() == false) goto L42;
                if (getGeneratedCodeInfo().equals(r11.getGeneratedCodeInfo()) == true) goto L42;
                return false;
            L42:
                if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L44;
                return false;
            L44:
                return true;
            L8:
                return super.equals(r10);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getContent() {
                Object r10 = this.content_;
                if ((r10 instanceof String) == true) goto L5;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L9;
                this.content_ = r12;
            L9:
                return r12;
            L5:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getContentBytes() {
                Object r10 = this.content_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.content_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public File getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                DescriptorProtos.GeneratedCodeInfo r10 = this.generatedCodeInfo_;
                if (r10 == null) goto L5;
                return r10;
            L5:
                return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                DescriptorProtos.GeneratedCodeInfo r10 = this.generatedCodeInfo_;
                if (r10 == null) goto L5;
                return r10;
            L5:
                return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getInsertionPoint() {
                Object r10 = this.insertionPoint_;
                if ((r10 instanceof String) == true) goto L5;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L9;
                this.insertionPoint_ = r12;
            L9:
                return r12;
            L5:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getInsertionPointBytes() {
                Object r10 = this.insertionPoint_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.insertionPoint_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getName() {
                Object r10 = this.name_;
                if ((r10 instanceof String) == true) goto L5;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L9;
                this.name_ = r12;
            L9:
                return r12;
            L5:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getNameBytes() {
                Object r10 = this.name_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.name_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<File> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int r10 = this.memoizedSize;
                if (r10 == (-1)) goto L5;
                return r10;
            L5:
                int r11 = 0;
                if ((this.bitField0_ & 1) == 0) goto L9;
                r11 = 0 + GeneratedMessage.computeStringSize(1, this.name_);
            L9:
                if ((this.bitField0_ & 2) == 0) goto L12;
                r11 = r11 + GeneratedMessage.computeStringSize(2, this.insertionPoint_);
            L12:
                if ((this.bitField0_ & 4) == 0) goto L15;
                r11 = r11 + GeneratedMessage.computeStringSize(15, this.content_);
            L15:
                if ((this.bitField0_ & 8) == 0) goto L17;
                r11 = r11 + CodedOutputStream.computeMessageSize(16, getGeneratedCodeInfo());
            L17:
                int r12 = r11 + getUnknownFields().getSerializedSize();
                this.memoizedSize = r12;
                return r12;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasContent() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasGeneratedCodeInfo() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasInsertionPoint() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public boolean hasName() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                int r10 = this.memoizedHashCode;
                if (r10 == 0) goto L5;
                return r10;
            L5:
                int r11 = 779 + getDescriptor().hashCode();
                if (hasName() == false) goto L9;
                r11 = (((r11 * 37) + 1) * 53) + getName().hashCode();
            L9:
                if (hasInsertionPoint() == false) goto L12;
                r11 = (((r11 * 37) + 2) * 53) + getInsertionPoint().hashCode();
            L12:
                if (hasContent() == false) goto L15;
                r11 = (((r11 * 37) + 15) * 53) + getContent().hashCode();
            L15:
                if (hasGeneratedCodeInfo() == false) goto L17;
                r11 = (((r11 * 37) + 16) * 53) + getGeneratedCodeInfo().hashCode();
            L17:
                int r12 = (r11 * 29) + getUnknownFields().hashCode();
                this.memoizedHashCode = r12;
                return r12;
            }

            @Override // com.google.protobuf.GeneratedMessage
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$2700().ensureFieldAccessorsInitialized(File.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r10 = this.memoizedIsInitialized;
                if (r10 != 1) goto L5;
                return true;
            L5:
                if (r10 != 0) goto L8;
                return false;
            L8:
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // com.google.protobuf.AbstractMessage
            protected /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
                return newBuilderForType(r10);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // com.google.protobuf.AbstractMessage
            protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
                return new Builder(r10, null);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
                return toBuilder();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                AnonymousClass1 r10 = null;
                if (this != DEFAULT_INSTANCE) goto L6;
                return new Builder(r10);
            L6:
                return new Builder(r10).mergeFrom(this);
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream r10) {
                if ((this.bitField0_ & 1) == 0) goto L6;
                GeneratedMessage.writeString(r10, 1, this.name_);
            L6:
                if ((this.bitField0_ & 2) == 0) goto L9;
                GeneratedMessage.writeString(r10, 2, this.insertionPoint_);
            L9:
                if ((this.bitField0_ & 4) == 0) goto L12;
                GeneratedMessage.writeString(r10, 15, this.content_);
            L12:
                if ((this.bitField0_ & 8) == 0) goto L14;
                r10.writeMessage(16, getGeneratedCodeInfo());
            L14:
                getUnknownFields().writeTo(r10);
            }
        }

        public interface FileOrBuilder extends MessageOrBuilder {
            String getContent();

            ByteString getContentBytes();

            DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo();

            DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder();

            String getInsertionPoint();

            ByteString getInsertionPointBytes();

            String getName();

            ByteString getNameBytes();

            boolean hasContent();

            boolean hasGeneratedCodeInfo();

            boolean hasInsertionPoint();

            boolean hasName();
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", CodeGeneratorResponse.class.getName());
            DEFAULT_INSTANCE = new CodeGeneratorResponse();
            PARSER = new AnonymousClass1();
        }

        private CodeGeneratorResponse() {
            this.error_ = "";
            this.supportedFeatures_ = 0;
            this.minimumEdition_ = 0;
            this.maximumEdition_ = 0;
            this.memoizedIsInitialized = -1;
            this.error_ = "";
            this.file_ = Collections.emptyList();
        }

        private CodeGeneratorResponse(GeneratedMessage.Builder<?> r10) {
            super(r10);
            this.error_ = "";
            this.supportedFeatures_ = 0;
            this.minimumEdition_ = 0;
            this.maximumEdition_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* synthetic */ CodeGeneratorResponse(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        static /* synthetic */ List access$4000(CodeGeneratorResponse r10) {
            return r10.file_;
        }

        static /* synthetic */ List access$4002(CodeGeneratorResponse r10, List r11) {
            r10.file_ = r11;
            return r11;
        }

        static /* synthetic */ Object access$4100(CodeGeneratorResponse r10) {
            return r10.error_;
        }

        static /* synthetic */ Object access$4102(CodeGeneratorResponse r10, Object r11) {
            r10.error_ = r11;
            return r11;
        }

        static /* synthetic */ long access$4202(CodeGeneratorResponse r10, long r11) {
            r10.supportedFeatures_ = r11;
            return r11;
        }

        static /* synthetic */ int access$4302(CodeGeneratorResponse r10, int r11) {
            r10.minimumEdition_ = r11;
            return r11;
        }

        static /* synthetic */ int access$4402(CodeGeneratorResponse r10, int r11) {
            r10.maximumEdition_ = r11;
            return r11;
        }

        static /* synthetic */ int access$4576(CodeGeneratorResponse r10, int r11) {
            int r12 = r11 | r10.bitField0_;
            r10.bitField0_ = r12;
            return r12;
        }

        static /* synthetic */ boolean access$4600() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        public static CodeGeneratorResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.access$2400();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CodeGeneratorResponse r10) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream r10) {
            return (CodeGeneratorResponse) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
            return (CodeGeneratorResponse) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorResponse parseFrom(ByteString r10) {
            return PARSER.parseFrom(r10);
        }

        public static CodeGeneratorResponse parseFrom(ByteString r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream r10) {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, r10);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorResponse parseFrom(InputStream r10) {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, r10);
        }

        public static CodeGeneratorResponse parseFrom(InputStream r10, ExtensionRegistryLite r11) {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer r10) {
            return PARSER.parseFrom(r10);
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static CodeGeneratorResponse parseFrom(byte[] r10) {
            return PARSER.parseFrom(r10);
        }

        public static CodeGeneratorResponse parseFrom(byte[] r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof CodeGeneratorResponse) == false) goto L8;
            CodeGeneratorResponse r11 = (CodeGeneratorResponse) r10;
            if (hasError() == r11.hasError()) goto L13;
            return false;
        L13:
            if (hasError() == false) goto L18;
            if (getError().equals(r11.getError()) == true) goto L18;
            return false;
        L18:
            if (hasSupportedFeatures() == r11.hasSupportedFeatures()) goto L21;
            return false;
        L21:
            if (hasSupportedFeatures() == false) goto L26;
            if (getSupportedFeatures() == r11.getSupportedFeatures()) goto L26;
            return false;
        L26:
            if (hasMinimumEdition() == r11.hasMinimumEdition()) goto L29;
            return false;
        L29:
            if (hasMinimumEdition() == false) goto L34;
            if (getMinimumEdition() == r11.getMinimumEdition()) goto L34;
            return false;
        L34:
            if (hasMaximumEdition() == r11.hasMaximumEdition()) goto L37;
            return false;
        L37:
            if (hasMaximumEdition() == false) goto L42;
            if (getMaximumEdition() == r11.getMaximumEdition()) goto L42;
            return false;
        L42:
            if (getFileList().equals(r11.getFileList()) == true) goto L45;
            return false;
        L45:
            if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L47;
            return false;
        L47:
            return true;
        L8:
            return super.equals(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CodeGeneratorResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public String getError() {
            Object r10 = this.error_;
            if ((r10 instanceof String) == true) goto L5;
            ByteString r11 = (ByteString) r10;
            String r12 = r11.toStringUtf8();
            if (r11.isValidUtf8() == false) goto L9;
            this.error_ = r12;
        L9:
            return r12;
        L5:
            return (String) r10;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public ByteString getErrorBytes() {
            Object r10 = this.error_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.error_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public File getFile(int r10) {
            return this.file_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<File> getFileList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public FileOrBuilder getFileOrBuilder(int r10) {
            return this.file_.get(r10);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public List<? extends FileOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getMaximumEdition() {
            return this.maximumEdition_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public int getMinimumEdition() {
            return this.minimumEdition_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorResponse> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r10 = this.memoizedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) == 0) goto L8;
            int r12 = GeneratedMessage.computeStringSize(1, this.error_) + 0;
        L10:
            if ((this.bitField0_ & 2) == 0) goto L13;
            r12 = r12 + CodedOutputStream.computeUInt64Size(2, this.supportedFeatures_);
        L13:
            if ((this.bitField0_ & 4) == 0) goto L16;
            r12 = r12 + CodedOutputStream.computeInt32Size(3, this.minimumEdition_);
        L16:
            if ((this.bitField0_ & 8) == 0) goto L19;
            r12 = r12 + CodedOutputStream.computeInt32Size(4, this.maximumEdition_);
        L19:
            if (r11 >= this.file_.size()) goto L21;
            r12 = r12 + CodedOutputStream.computeMessageSize(15, this.file_.get(r11));
            r11 = r11 + 1;
            goto L19
        L21:
            int r13 = r12 + getUnknownFields().getSerializedSize();
            this.memoizedSize = r13;
            return r13;
        L8:
            r12 = 0;
            goto L10
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public long getSupportedFeatures() {
            return this.supportedFeatures_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasError() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasMaximumEdition() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasMinimumEdition() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public boolean hasSupportedFeatures() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r10 = this.memoizedHashCode;
            if (r10 == 0) goto L5;
            return r10;
        L5:
            int r11 = 779 + getDescriptor().hashCode();
            if (hasError() == false) goto L9;
            r11 = (((r11 * 37) + 1) * 53) + getError().hashCode();
        L9:
            if (hasSupportedFeatures() == false) goto L12;
            r11 = (((r11 * 37) + 2) * 53) + Internal.hashLong(getSupportedFeatures());
        L12:
            if (hasMinimumEdition() == false) goto L15;
            r11 = (((r11 * 37) + 3) * 53) + getMinimumEdition();
        L15:
            if (hasMaximumEdition() == false) goto L18;
            r11 = (((r11 * 37) + 4) * 53) + getMaximumEdition();
        L18:
            if (getFileCount() <= 0) goto L20;
            r11 = (((r11 * 37) + 15) * 53) + getFileList().hashCode();
        L20:
            int r12 = (r11 * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$2500().ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.AbstractMessage
        protected /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
            return newBuilderForType(r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.AbstractMessage
        protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
            return new Builder(r10, null);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            AnonymousClass1 r10 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r10);
        L6:
            return new Builder(r10).mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            GeneratedMessage.writeString(r10, 1, this.error_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r10.writeUInt64(2, this.supportedFeatures_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r10.writeInt32(3, this.minimumEdition_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            r10.writeInt32(4, this.maximumEdition_);
        L14:
            int r11 = 0;
        L16:
            if (r11 >= this.file_.size()) goto L18;
            r10.writeMessage(15, this.file_.get(r11));
            r11 = r11 + 1;
            goto L16
        L18:
            getUnknownFields().writeTo(r10);
        }
    }

    public interface CodeGeneratorResponseOrBuilder extends MessageOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int r10);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int r10);

        List<? extends CodeGeneratorResponse.FileOrBuilder> getFileOrBuilderList();

        int getMaximumEdition();

        int getMinimumEdition();

        long getSupportedFeatures();

        boolean hasError();

        boolean hasMaximumEdition();

        boolean hasMinimumEdition();

        boolean hasSupportedFeatures();
    }

    public static final class Version extends GeneratedMessage implements VersionOrBuilder {
        private static final Version DEFAULT_INSTANCE = null;
        public static final int MAJOR_FIELD_NUMBER = 1;
        public static final int MINOR_FIELD_NUMBER = 2;
        private static final Parser<Version> PARSER = null;
        public static final int PATCH_FIELD_NUMBER = 3;
        public static final int SUFFIX_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int major_;
        private byte memoizedIsInitialized;
        private int minor_;
        private int patch_;
        private volatile Object suffix_;

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements VersionOrBuilder {
            private int bitField0_;
            private int major_;
            private int minor_;
            private int patch_;
            private Object suffix_;

            private Builder() {
                this.suffix_ = "";
            }

            private Builder(AbstractMessage.BuilderParent r10) {
                super(r10);
                this.suffix_ = "";
            }

            /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
                this(r10);
            }

            /* synthetic */ Builder(AnonymousClass1 r10) {
                this();
            }

            private void buildPartial0(Version r10) {
                int r11 = this.bitField0_;
                if ((r11 & 1) == 0) goto L5;
                Version.access$502(r10, this.major_);
                int r12 = 1;
            L7:
                if ((r11 & 2) == 0) goto L10;
                Version.access$602(r10, this.minor_);
                r12 = r12 | 2;
            L10:
                if ((r11 & 4) == 0) goto L13;
                Version.access$702(r10, this.patch_);
                r12 = r12 | 4;
            L13:
                if ((r11 & 8) == 0) goto L15;
                Version.access$802(r10, this.suffix_);
                r12 = r12 | 8;
            L15:
                Version.access$976(r10, r12);
                return;
            L5:
                r12 = 0;
                goto L7
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return PluginProtos.access$000();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version build() {
                Version r10 = buildPartial();
                if (r10.isInitialized() == false) goto L6;
                return r10;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r10);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version buildPartial() {
                Version r10 = new Version(this, null);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r10);
            L5:
                onBuilt();
                return r10;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.major_ = 0;
                this.minor_ = 0;
                this.patch_ = 0;
                this.suffix_ = "";
                return this;
            }

            public Builder clearMajor() {
                this.bitField0_ &= -2;
                this.major_ = 0;
                onChanged();
                return this;
            }

            public Builder clearMinor() {
                this.bitField0_ &= -3;
                this.minor_ = 0;
                onChanged();
                return this;
            }

            public Builder clearPatch() {
                this.bitField0_ &= -5;
                this.patch_ = 0;
                onChanged();
                return this;
            }

            public Builder clearSuffix() {
                this.suffix_ = Version.getDefaultInstance().getSuffix();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Version getDefaultInstanceForType() {
                return Version.getDefaultInstance();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.access$000();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMajor() {
                return this.major_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getMinor() {
                return this.minor_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public int getPatch() {
                return this.patch_;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public String getSuffix() {
                Object r10 = this.suffix_;
                if ((r10 instanceof String) == true) goto L9;
                ByteString r11 = (ByteString) r10;
                String r12 = r11.toStringUtf8();
                if (r11.isValidUtf8() == false) goto L7;
                this.suffix_ = r12;
            L7:
                return r12;
            L9:
                return (String) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public ByteString getSuffixBytes() {
                Object r10 = this.suffix_;
                if ((r10 instanceof String) == false) goto L7;
                ByteString r11 = ByteString.copyFromUtf8((String) r10);
                this.suffix_ = r11;
                return r11;
            L7:
                return (ByteString) r10;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMajor() {
                if ((this.bitField0_ & 1) != 0) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasMinor() {
                if ((this.bitField0_ & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasPatch() {
                if ((this.bitField0_ & 4) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public boolean hasSuffix() {
                if ((this.bitField0_ & 8) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$100().ensureFieldAccessorsInitialized(Version.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r10) {
                return mergeFrom(r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r10) {
                return mergeFrom(r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                return mergeFrom(r10, r11);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
                Objects.requireNonNull(r11);
                boolean r12 = false;
            L3:
                if (r12 == true) goto L30;
                int r13 = r10.readTag();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                if (r13 == 0) goto L22;
                if (r13 != 8) goto L9;
                this.major_ = r10.readInt32();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                this.bitField0_ |= 1;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                goto L3
            L9:
                if (r13 != 16) goto L11;
                this.minor_ = r10.readInt32();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                this.bitField0_ |= 2;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                goto L3
            L11:
                if (r13 != 24) goto L13;
                this.patch_ = r10.readInt32();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                this.bitField0_ |= 4;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                goto L3
            L13:
                if (r13 != 34) goto L15;
                this.suffix_ = r10.readBytes();     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                this.bitField0_ |= 8;     // Catch: Throwable -> L23 InvalidProtocolBufferException -> L25
                goto L3
            L15:
                if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
            L22:
                r12 = true;
                goto L3
            L23:
                th = move-exception;
                onChanged();
                throw th;
            L25:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L23
            L30:
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r10) {
                if ((r10 instanceof Version) == true) goto L5;
                super.mergeFrom(r10);
                return this;
            L5:
                return mergeFrom((Version) r10);
            }

            public Builder mergeFrom(Version r10) {
                if (r10 != Version.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r10.hasMajor() == false) goto L9;
                setMajor(r10.getMajor());
            L9:
                if (r10.hasMinor() == false) goto L12;
                setMinor(r10.getMinor());
            L12:
                if (r10.hasPatch() == false) goto L15;
                setPatch(r10.getPatch());
            L15:
                if (r10.hasSuffix() == false) goto L17;
                this.suffix_ = Version.access$800(r10);
                this.bitField0_ |= 8;
                onChanged();
            L17:
                mergeUnknownFields(r10.getUnknownFields());
                onChanged();
                return this;
            }

            public Builder setMajor(int r10) {
                this.major_ = r10;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMinor(int r10) {
                this.minor_ = r10;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setPatch(int r10) {
                this.patch_ = r10;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setSuffix(String r10) {
                Objects.requireNonNull(r10);
                this.suffix_ = r10;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setSuffixBytes(ByteString r10) {
                Objects.requireNonNull(r10);
                this.suffix_ = r10;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Version.class.getName());
            DEFAULT_INSTANCE = new Version();
            PARSER = new AnonymousClass1();
        }

        private Version() {
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = -1;
            this.suffix_ = "";
        }

        private Version(GeneratedMessage.Builder<?> r10) {
            super(r10);
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = -1;
        }

        /* synthetic */ Version(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
            this(r10);
        }

        static /* synthetic */ int access$502(Version r10, int r11) {
            r10.major_ = r11;
            return r11;
        }

        static /* synthetic */ int access$602(Version r10, int r11) {
            r10.minor_ = r11;
            return r11;
        }

        static /* synthetic */ int access$702(Version r10, int r11) {
            r10.patch_ = r11;
            return r11;
        }

        static /* synthetic */ Object access$800(Version r10) {
            return r10.suffix_;
        }

        static /* synthetic */ Object access$802(Version r10, Object r11) {
            r10.suffix_ = r11;
            return r11;
        }

        static /* synthetic */ int access$976(Version r10, int r11) {
            int r12 = r11 | r10.bitField0_;
            r10.bitField0_ = r12;
            return r12;
        }

        public static Version getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PluginProtos.access$000();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Version r10) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
        }

        public static Version parseDelimitedFrom(InputStream r10) {
            return (Version) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
        }

        public static Version parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
            return (Version) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
        }

        public static Version parseFrom(ByteString r10) {
            return PARSER.parseFrom(r10);
        }

        public static Version parseFrom(ByteString r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static Version parseFrom(CodedInputStream r10) {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, r10);
        }

        public static Version parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
        }

        public static Version parseFrom(InputStream r10) {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, r10);
        }

        public static Version parseFrom(InputStream r10, ExtensionRegistryLite r11) {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
        }

        public static Version parseFrom(ByteBuffer r10) {
            return PARSER.parseFrom(r10);
        }

        public static Version parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static Version parseFrom(byte[] r10) {
            return PARSER.parseFrom(r10);
        }

        public static Version parseFrom(byte[] r10, ExtensionRegistryLite r11) {
            return PARSER.parseFrom(r10, r11);
        }

        public static Parser<Version> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof Version) == false) goto L8;
            Version r11 = (Version) r10;
            if (hasMajor() == r11.hasMajor()) goto L13;
            return false;
        L13:
            if (hasMajor() == false) goto L18;
            if (getMajor() == r11.getMajor()) goto L18;
            return false;
        L18:
            if (hasMinor() == r11.hasMinor()) goto L21;
            return false;
        L21:
            if (hasMinor() == false) goto L26;
            if (getMinor() == r11.getMinor()) goto L26;
            return false;
        L26:
            if (hasPatch() == r11.hasPatch()) goto L29;
            return false;
        L29:
            if (hasPatch() == false) goto L34;
            if (getPatch() == r11.getPatch()) goto L34;
            return false;
        L34:
            if (hasSuffix() == r11.hasSuffix()) goto L37;
            return false;
        L37:
            if (hasSuffix() == false) goto L42;
            if (getSuffix().equals(r11.getSuffix()) == true) goto L42;
            return false;
        L42:
            if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L44;
            return false;
        L44:
            return true;
        L8:
            return super.equals(r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Version getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMajor() {
            return this.major_;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getMinor() {
            return this.minor_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Version> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public int getPatch() {
            return this.patch_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r10 = this.memoizedSize;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            int r11 = 0;
            if ((this.bitField0_ & 1) == 0) goto L9;
            r11 = 0 + CodedOutputStream.computeInt32Size(1, this.major_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r11 = r11 + CodedOutputStream.computeInt32Size(2, this.minor_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r11 = r11 + CodedOutputStream.computeInt32Size(3, this.patch_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L17;
            r11 = r11 + GeneratedMessage.computeStringSize(4, this.suffix_);
        L17:
            int r12 = r11 + getUnknownFields().getSerializedSize();
            this.memoizedSize = r12;
            return r12;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public String getSuffix() {
            Object r10 = this.suffix_;
            if ((r10 instanceof String) == true) goto L5;
            ByteString r11 = (ByteString) r10;
            String r12 = r11.toStringUtf8();
            if (r11.isValidUtf8() == false) goto L9;
            this.suffix_ = r12;
        L9:
            return r12;
        L5:
            return (String) r10;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public ByteString getSuffixBytes() {
            Object r10 = this.suffix_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.suffix_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMajor() {
            if ((this.bitField0_ & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasMinor() {
            if ((this.bitField0_ & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasPatch() {
            if ((this.bitField0_ & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public boolean hasSuffix() {
            if ((this.bitField0_ & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            int r10 = this.memoizedHashCode;
            if (r10 == 0) goto L5;
            return r10;
        L5:
            int r11 = 779 + getDescriptor().hashCode();
            if (hasMajor() == false) goto L9;
            r11 = (((r11 * 37) + 1) * 53) + getMajor();
        L9:
            if (hasMinor() == false) goto L12;
            r11 = (((r11 * 37) + 2) * 53) + getMinor();
        L12:
            if (hasPatch() == false) goto L15;
            r11 = (((r11 * 37) + 3) * 53) + getPatch();
        L15:
            if (hasSuffix() == false) goto L17;
            r11 = (((r11 * 37) + 4) * 53) + getSuffix().hashCode();
        L17:
            int r12 = (r11 * 29) + getUnknownFields().hashCode();
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$100().ensureFieldAccessorsInitialized(Version.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r10 = this.memoizedIsInitialized;
            if (r10 != 1) goto L5;
            return true;
        L5:
            if (r10 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.AbstractMessage
        protected /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
            return newBuilderForType(r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // com.google.protobuf.AbstractMessage
        protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
            return new Builder(r10, null);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            AnonymousClass1 r10 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r10);
        L6:
            return new Builder(r10).mergeFrom(this);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r10.writeInt32(1, this.major_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r10.writeInt32(2, this.minor_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r10.writeInt32(3, this.patch_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            GeneratedMessage.writeString(r10, 4, this.suffix_);
        L14:
            getUnknownFields().writeTo(r10);
        }
    }

    public interface VersionOrBuilder extends MessageOrBuilder {
        int getMajor();

        int getMinor();

        int getPatch();

        String getSuffix();

        ByteString getSuffixBytes();

        boolean hasMajor();

        boolean hasMinor();

        boolean hasPatch();

        boolean hasSuffix();
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", PluginProtos.class.getName());
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"c\n\u0007Version\u0012\u0014\n\u0005major\u0018\u0001 \u0001(\u0005R\u0005major\u0012\u0014\n\u0005minor\u0018\u0002 \u0001(\u0005R\u0005minor\u0012\u0014\n\u0005patch\u0018\u0003 \u0001(\u0005R\u0005patch\u0012\u0016\n\u0006suffix\u0018\u0004 \u0001(\tR\u0006suffix\"Ï\u0002\n\u0014CodeGeneratorRequest\u0012(\n\u0010file_to_generate\u0018\u0001 \u0003(\tR\u000efileToGenerate\u0012\u001c\n\tparameter\u0018\u0002 \u0001(\tR\tparameter\u0012C\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\tprotoFile\u0012\\\n\u0017source_file_descriptors\u0018\u0011 \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\u0015sourceFileDescriptors\u0012L\n\u0010compiler_version\u0018\u0003 \u0001(\u000b2!.google.protobuf.compiler.VersionR\u000fcompilerVersion\"\u0085\u0004\n\u0015CodeGeneratorResponse\u0012\u0014\n\u0005error\u0018\u0001 \u0001(\tR\u0005error\u0012-\n\u0012supported_features\u0018\u0002 \u0001(\u0004R\u0011supportedFeatures\u0012'\n\u000fminimum_edition\u0018\u0003 \u0001(\u0005R\u000eminimumEdition\u0012'\n\u000fmaximum_edition\u0018\u0004 \u0001(\u0005R\u000emaximumEdition\u0012H\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.FileR\u0004file\u001a±\u0001\n\u0004File\u0012\u0012\n\u0004name\u0018\u0001 \u0001(\tR\u0004name\u0012'\n\u000finsertion_point\u0018\u0002 \u0001(\tR\u000einsertionPoint\u0012\u0018\n\u0007content\u0018\u000f \u0001(\tR\u0007content\u0012R\n\u0013generated_code_info\u0018\u0010 \u0001(\u000b2\".google.protobuf.GeneratedCodeInfoR\u0011generatedCodeInfo\"W\n\u0007Feature\u0012\u0010\n\fFEATURE_NONE\u0010\u0000\u0012\u001b\n\u0017FEATURE_PROTO3_OPTIONAL\u0010\u0001\u0012\u001d\n\u0019FEATURE_SUPPORTS_EDITIONS\u0010\u0002Br\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ)google.golang.org/protobuf/types/pluginpbª\u0002\u0018Google.Protobuf.Compiler"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor r10 = getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_compiler_Version_descriptor = r10;
        internal_static_google_protobuf_compiler_Version_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r10, new String[]{"Major", "Minor", "Patch", "Suffix"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageTypes().get(1);
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = r11;
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r11, new String[]{"FileToGenerate", "Parameter", "ProtoFile", "SourceFileDescriptors", "CompilerVersion"});
        Descriptors.Descriptor r12 = getDescriptor().getMessageTypes().get(2);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = r12;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r12, new String[]{"Error", "SupportedFeatures", "MinimumEdition", "MaximumEdition", "File"});
        Descriptors.Descriptor r13 = r12.getNestedTypes().get(0);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = r13;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r13, new String[]{"Name", "InsertionPoint", "Content", "GeneratedCodeInfo"});
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    private PluginProtos() {
    }

    static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_google_protobuf_compiler_Version_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$100() {
        return internal_static_google_protobuf_compiler_Version_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors.Descriptor access$1000() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$1100() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors.Descriptor access$2400() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$2500() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
    }

    static /* synthetic */ Descriptors.Descriptor access$2600() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    }

    static /* synthetic */ GeneratedMessage.FieldAccessorTable access$2700() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r10) {
        registerAllExtensions(r10);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r10) {
    }
}
