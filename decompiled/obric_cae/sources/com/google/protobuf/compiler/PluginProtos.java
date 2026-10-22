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
import com.google.protobuf.GeneratedFile;
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
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PluginProtos extends GeneratedFile {
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
    public static /* synthetic */ class AnonymousClass1 {
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

            private void buildPartial0(CodeGeneratorRequest r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L6;
                this.fileToGenerate_.makeImmutable();
                CodeGeneratorRequest.access$1802(r8, this.fileToGenerate_);
            L6:
                if ((r10 & 2) == 0) goto L8;
                CodeGeneratorRequest.access$1902(r8, this.parameter_);
                int r11 = 1;
            L10:
                if ((r10 & 16) == 0) goto L16;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r12 = this.compilerVersionBuilder_;
                if (r12 != null) goto L14;
                Version r13 = this.compilerVersion_;
            L15:
                CodeGeneratorRequest.access$2002(r8, r13);
                r11 = r11 | 2;
                goto L16
            L14:
                r13 = (Version) r12.build();
            L16:
                CodeGeneratorRequest.access$2176(r8, r11);
                return;
            L8:
                r11 = 0;
                goto L10
            }

            private void buildPartialRepeatedFields(CodeGeneratorRequest r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 == null) goto L5;
                List r11 = r10.build();
            L9:
                CodeGeneratorRequest.access$1602(r8, r11);
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r12 = this.sourceFileDescriptorsBuilder_;
                if (r12 == null) goto L12;
                List r13 = r12.build();
            L16:
                CodeGeneratorRequest.access$1702(r8, r13);
                return;
            L12:
                if ((this.bitField0_ & 8) == 0) goto L14;
                this.sourceFileDescriptors_ = Collections.unmodifiableList(this.sourceFileDescriptors_);
                this.bitField0_ &= -9;
            L14:
                r13 = this.sourceFileDescriptors_;
                goto L16
            L5:
                if ((this.bitField0_ & 4) == 0) goto L7;
                this.protoFile_ = Collections.unmodifiableList(this.protoFile_);
                this.bitField0_ &= -5;
            L7:
                r11 = this.protoFile_;
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
                List<DescriptorProtos.FileDescriptorProto> r8 = this.protoFile_;
                if ((this.bitField0_ & 4) == 0) goto L7;
                boolean r10 = true;
            L8:
                this.protoFileBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
                this.protoFile_ = null;
                goto L10
            L7:
                r10 = false;
            L10:
                return this.protoFileBuilder_;
            }

            private RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> internalGetSourceFileDescriptorsFieldBuilder() {
                if (this.sourceFileDescriptorsBuilder_ != null) goto L10;
                List<DescriptorProtos.FileDescriptorProto> r8 = this.sourceFileDescriptors_;
                if ((this.bitField0_ & 8) == 0) goto L7;
                boolean r10 = true;
            L8:
                this.sourceFileDescriptorsBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
                this.sourceFileDescriptors_ = null;
                goto L10
            L7:
                r10 = false;
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

            public Builder addAllFileToGenerate(Iterable<String> r8) {
                ensureFileToGenerateIsMutable();
                AbstractMessageLite.Builder.addAll(r8, this.fileToGenerate_);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder addAllProtoFile(Iterable<? extends DescriptorProtos.FileDescriptorProto> r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L5;
                ensureProtoFileIsMutable();
                AbstractMessageLite.Builder.addAll(r8, this.protoFile_);
                onChanged();
            L6:
                return this;
            L5:
                r10.addAllMessages(r8);
                goto L6
            }

            public Builder addAllSourceFileDescriptors(Iterable<? extends DescriptorProtos.FileDescriptorProto> r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                AbstractMessageLite.Builder.addAll(r8, this.sourceFileDescriptors_);
                onChanged();
            L6:
                return this;
            L5:
                r10.addAllMessages(r8);
                goto L6
            }

            public Builder addFileToGenerate(String r8) {
                if (r8 == null) goto L6;
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(r8);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder addFileToGenerateBytes(ByteString r8) {
                if (r8 == null) goto L6;
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.add(r8);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder addProtoFile(int r8, DescriptorProtos.FileDescriptorProto.Builder r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r8, r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r8, r10.build());
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetProtoFileFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public Builder addSourceFileDescriptors(int r8, DescriptorProtos.FileDescriptorProto.Builder r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r8, r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r8, r10.build());
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder addSourceFileDescriptorsBuilder() {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetSourceFileDescriptorsFieldBuilder().addBuilder(DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            public Builder clearCompilerVersion() {
                this.bitField0_ &= -17;
                this.compilerVersion_ = null;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r8 = this.compilerVersionBuilder_;
                if (r8 == null) goto L5;
                r8.dispose();
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
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.protoFileBuilder_;
                if (r8 != null) goto L5;
                this.protoFile_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            L6:
                return this;
            L5:
                r8.clear();
                goto L6
            }

            public Builder clearSourceFileDescriptors() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.sourceFileDescriptorsBuilder_;
                if (r8 != null) goto L5;
                this.sourceFileDescriptors_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
            L6:
                return this;
            L5:
                r8.clear();
                goto L6
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public Version getCompilerVersion() {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r8 = this.compilerVersionBuilder_;
                if (r8 != null) goto L9;
                Version r10 = this.compilerVersion_;
                if (r10 == null) goto L7;
                return r10;
            L7:
                return Version.getDefaultInstance();
            L9:
                return (Version) r8.getMessage();
            }

            public Version.Builder getCompilerVersionBuilder() {
                this.bitField0_ |= 16;
                onChanged();
                return (Version.Builder) internalGetCompilerVersionFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public VersionOrBuilder getCompilerVersionOrBuilder() {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r8 = this.compilerVersionBuilder_;
                if (r8 != null) goto L5;
                Version r10 = this.compilerVersion_;
                if (r10 == null) goto L9;
                return r10;
            L9:
                return Version.getDefaultInstance();
            L5:
                return (VersionOrBuilder) r8.getMessageOrBuilder();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.access$1000();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public String getFileToGenerate(int r8) {
                return this.fileToGenerate_.get(r8);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getFileToGenerateBytes(int r8) {
                return this.fileToGenerate_.getByteString(r8);
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
            public String getParameter() {
                Object r8 = this.parameter_;
                if ((r8 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.parameter_ = r11;
            L7:
                return r11;
            L9:
                return (String) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public ByteString getParameterBytes() {
                Object r8 = this.parameter_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.parameter_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getProtoFile(int r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L7;
                MessageLite r11 = this.protoFile_.get(r8);
            L6:
                return (DescriptorProtos.FileDescriptorProto) r11;
            L7:
                r11 = r10.getMessage(r8);
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder getProtoFileBuilder(int r8) {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetProtoFileFieldBuilder().getBuilder(r8);
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getProtoFileBuilderList() {
                return internalGetProtoFileFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getProtoFileCount() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.protoFileBuilder_;
                if (r8 != null) goto L7;
                return this.protoFile_.size();
            L7:
                return r8.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getProtoFileList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.protoFileBuilder_;
                if (r8 != null) goto L7;
                return Collections.unmodifiableList(this.protoFile_);
            L7:
                return r8.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L7;
                Object r11 = this.protoFile_.get(r8);
            L6:
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) r11;
            L7:
                r11 = r10.getMessageOrBuilder(r8);
                goto L6
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.protoFileBuilder_;
                if (r8 == null) goto L7;
                return r8.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.protoFile_);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L7;
                MessageLite r11 = this.sourceFileDescriptors_.get(r8);
            L6:
                return (DescriptorProtos.FileDescriptorProto) r11;
            L7:
                r11 = r10.getMessage(r8);
                goto L6
            }

            public DescriptorProtos.FileDescriptorProto.Builder getSourceFileDescriptorsBuilder(int r8) {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetSourceFileDescriptorsFieldBuilder().getBuilder(r8);
            }

            public List<DescriptorProtos.FileDescriptorProto.Builder> getSourceFileDescriptorsBuilderList() {
                return internalGetSourceFileDescriptorsFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public int getSourceFileDescriptorsCount() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.sourceFileDescriptorsBuilder_;
                if (r8 != null) goto L7;
                return this.sourceFileDescriptors_.size();
            L7:
                return r8.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.sourceFileDescriptorsBuilder_;
                if (r8 != null) goto L7;
                return Collections.unmodifiableList(this.sourceFileDescriptors_);
            L7:
                return r8.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L7;
                Object r11 = this.sourceFileDescriptors_.get(r8);
            L6:
                return (DescriptorProtos.FileDescriptorProtoOrBuilder) r11;
            L7:
                r11 = r10.getMessageOrBuilder(r8);
                goto L6
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getSourceFileDescriptorsOrBuilderList() {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.sourceFileDescriptorsBuilder_;
                if (r8 == null) goto L7;
                return r8.getMessageOrBuilderList();
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
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$1100().ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r8 = 0;
            L4:
                if (r8 >= getProtoFileCount()) goto L9;
                if (getProtoFile(r8).isInitialized() == false) goto L7;
                r8 = r8 + 1;
                goto L4
            L7:
                return false;
            L9:
                int r10 = 0;
            L11:
                if (r10 >= getSourceFileDescriptorsCount()) goto L16;
                if (getSourceFileDescriptors(r10).isInitialized() == false) goto L14;
                r10 = r10 + 1;
                goto L11
            L14:
                return false;
            L16:
                return true;
            }

            public Builder mergeCompilerVersion(Version r8) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r10 = this.compilerVersionBuilder_;
                if (r10 == null) goto L5;
                r10.mergeFrom(r8);
            L14:
                if (this.compilerVersion_ == null) goto L16;
                this.bitField0_ |= 16;
                onChanged();
            L16:
                return this;
            L5:
                if ((this.bitField0_ & 16) == 0) goto L11;
                Version r11 = this.compilerVersion_;
                if (r11 == null) goto L11;
                if (r11 == Version.getDefaultInstance()) goto L11;
                getCompilerVersionBuilder().mergeFrom(r8);
            L11:
                this.compilerVersion_ = r8;
                goto L14
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public Builder removeProtoFile(int r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.remove(r8);
                onChanged();
            L6:
                return this;
            L5:
                r10.remove(r8);
                goto L6
            }

            public Builder removeSourceFileDescriptors(int r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.remove(r8);
                onChanged();
            L6:
                return this;
            L5:
                r10.remove(r8);
                goto L6
            }

            public Builder setCompilerVersion(Version.Builder r8) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r10 = this.compilerVersionBuilder_;
                Version r11 = r8.build();
                if (r10 != null) goto L5;
                this.compilerVersion_ = r11;
            L6:
                this.bitField0_ |= 16;
                onChanged();
                return this;
            L5:
                r10.setMessage(r11);
                goto L6
            }

            public Builder setFileToGenerate(int r8, String r10) {
                if (r10 == null) goto L6;
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.set(r8, r10);
                this.bitField0_ |= 1;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setParameter(String r8) {
                if (r8 == null) goto L6;
                this.parameter_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setParameterBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.parameter_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setProtoFile(int r8, DescriptorProtos.FileDescriptorProto.Builder r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.set(r8, r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.setMessage(r8, r10.build());
                goto L6
            }

            public Builder setSourceFileDescriptors(int r8, DescriptorProtos.FileDescriptorProto.Builder r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.set(r8, r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.setMessage(r8, r10.build());
                goto L6
            }

            private Builder(AbstractMessage.BuilderParent r8) {
                super(r8);
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                this.protoFile_ = Collections.emptyList();
                this.sourceFileDescriptors_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addProtoFile(int r8, DescriptorProtos.FileDescriptorProto r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L8;
                if (r10 == null) goto L7;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r8, r10);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r11.addMessage(r8, r10);
                goto L9
            }

            public DescriptorProtos.FileDescriptorProto.Builder addProtoFileBuilder(int r8) {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetProtoFileFieldBuilder().addBuilder(r8, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            public Builder addSourceFileDescriptors(int r8, DescriptorProtos.FileDescriptorProto r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L8;
                if (r10 == null) goto L7;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r8, r10);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r11.addMessage(r8, r10);
                goto L9
            }

            public DescriptorProtos.FileDescriptorProto.Builder addSourceFileDescriptorsBuilder(int r8) {
                return (DescriptorProtos.FileDescriptorProto.Builder) internalGetSourceFileDescriptorsFieldBuilder().addBuilder(r8, DescriptorProtos.FileDescriptorProto.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
            public /* bridge */ /* synthetic */ List getFileToGenerateList() {
                return getFileToGenerateList();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            public Builder setCompilerVersion(Version r8) {
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r10 = this.compilerVersionBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                this.compilerVersion_ = r8;
            L9:
                this.bitField0_ |= 16;
                onChanged();
                return this;
            L7:
                throw null;
            L8:
                r10.setMessage(r8);
                goto L9
            }

            public Builder setProtoFile(int r8, DescriptorProtos.FileDescriptorProto r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.protoFileBuilder_;
                if (r11 != null) goto L8;
                if (r10 == null) goto L7;
                ensureProtoFileIsMutable();
                this.protoFile_.set(r8, r10);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r11.setMessage(r8, r10);
                goto L9
            }

            public Builder setSourceFileDescriptors(int r8, DescriptorProtos.FileDescriptorProto r10) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = this.sourceFileDescriptorsBuilder_;
                if (r11 != null) goto L8;
                if (r10 == null) goto L7;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.set(r8, r10);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r11.setMessage(r8, r10);
                goto L9
            }

            public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
                this(r8);
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto.Builder r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L5;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r8.build());
                onChanged();
            L6:
                return this;
            L5:
                r10.addMessage(r8.build());
                goto L6
            }

            public Builder addSourceFileDescriptors(DescriptorProtos.FileDescriptorProto.Builder r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L5;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r8.build());
                onChanged();
            L6:
                return this;
            L5:
                r10.addMessage(r8.build());
                goto L6
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest build() {
                CodeGeneratorRequest r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorRequest buildPartial() {
                CodeGeneratorRequest r8 = new CodeGeneratorRequest(this, null);
                buildPartialRepeatedFields(r8);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r8);
            L5:
                onBuilt();
                return r8;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public CodeGeneratorRequest getDefaultInstanceForType() {
                return CodeGeneratorRequest.getDefaultInstance();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public /* synthetic */ Builder(AnonymousClass1 r8) {
                this();
            }

            public Builder addProtoFile(DescriptorProtos.FileDescriptorProto r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.protoFileBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                ensureProtoFileIsMutable();
                this.protoFile_.add(r8);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r10.addMessage(r8);
                goto L9
            }

            public Builder addSourceFileDescriptors(DescriptorProtos.FileDescriptorProto r8) {
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.add(r8);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r10.addMessage(r8);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.fileToGenerate_ = LazyStringArrayList.emptyList();
                this.parameter_ = "";
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r8 = this.protoFileBuilder_;
                if (r8 != null) goto L5;
                this.protoFile_ = Collections.emptyList();
            L6:
                this.bitField0_ &= -5;
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = this.sourceFileDescriptorsBuilder_;
                if (r10 != null) goto L9;
                this.sourceFileDescriptors_ = Collections.emptyList();
            L10:
                this.bitField0_ &= -9;
                this.compilerVersion_ = null;
                SingleFieldBuilder<Version, Version.Builder, VersionOrBuilder> r11 = this.compilerVersionBuilder_;
                if (r11 == null) goto L13;
                r11.dispose();
                this.compilerVersionBuilder_ = null;
            L13:
                return this;
            L9:
                this.sourceFileDescriptors_ = null;
                r10.clear();
                goto L10
            L5:
                this.protoFile_ = null;
                r8.clear();
                goto L6
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L43;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L40;
                int r12 = r8.readTag();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                if (r12 == 0) goto L32;
                if (r12 != 10) goto L10;
                ByteString r13 = r8.readBytes();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                ensureFileToGenerateIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.fileToGenerate_.add(r13);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L10:
                if (r12 != 18) goto L12;
                this.parameter_ = r8.readBytes();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 2;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L12:
                if (r12 != 26) goto L14;
                r8.readMessage(internalGetCompilerVersionFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                this.bitField0_ |= 16;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L14:
                if (r12 == 122) goto L25;
                if (r12 != 138) goto L18;
                DescriptorProtos.FileDescriptorProto r14 = (DescriptorProtos.FileDescriptorProto) r8.readMessage(DescriptorProtos.FileDescriptorProto.parser(), r10);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r15 = this.sourceFileDescriptorsBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                if (r15 == null) goto L22;
            L24:
                r15.addMessage(r14);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L22:
                ensureSourceFileDescriptorsIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                List<DescriptorProtos.FileDescriptorProto> r16 = this.sourceFileDescriptors_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            L23:
                r16.add(r14);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                goto L4
            L18:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L25:
                r14 = (DescriptorProtos.FileDescriptorProto) r8.readMessage(DescriptorProtos.FileDescriptorProto.parser(), r10);     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                r15 = this.protoFileBuilder_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                if (r15 != null) goto L24;
                ensureProtoFileIsMutable();     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
                r16 = this.protoFile_;     // Catch: Throwable -> L33 InvalidProtocolBufferException -> L35
            L32:
                r11 = true;
                goto L4
            L35:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L33
            L33:
                th = move-exception;
                onChanged();
                throw th;
            L40:
                onChanged();
                return this;
            L43:
                throw null;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof CodeGeneratorRequest) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((CodeGeneratorRequest) r8);
            }

            public Builder mergeFrom(CodeGeneratorRequest r8) {
                if (r8 != CodeGeneratorRequest.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (CodeGeneratorRequest.access$1800(r8).isEmpty() == true) goto L13;
                if (this.fileToGenerate_.isEmpty() == false) goto L10;
                this.fileToGenerate_ = CodeGeneratorRequest.access$1800(r8);
                this.bitField0_ |= 1;
            L11:
                onChanged();
                goto L13
            L10:
                ensureFileToGenerateIsMutable();
                this.fileToGenerate_.addAll(CodeGeneratorRequest.access$1800(r8));
            L13:
                if (r8.hasParameter() == false) goto L15;
                this.parameter_ = CodeGeneratorRequest.access$1900(r8);
                this.bitField0_ |= 2;
                onChanged();
            L15:
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r10 = null;
                if (this.protoFileBuilder_ != null) goto L25;
                if (CodeGeneratorRequest.access$1600(r8).isEmpty() == true) goto L35;
                if (this.protoFile_.isEmpty() == false) goto L22;
                this.protoFile_ = CodeGeneratorRequest.access$1600(r8);
                this.bitField0_ &= -5;
            L23:
                onChanged();
                goto L35
            L22:
                ensureProtoFileIsMutable();
                this.protoFile_.addAll(CodeGeneratorRequest.access$1600(r8));
            L35:
                if (this.sourceFileDescriptorsBuilder_ != null) goto L44;
                if (CodeGeneratorRequest.access$1700(r8).isEmpty() == true) goto L53;
                if (this.sourceFileDescriptors_.isEmpty() == false) goto L41;
                this.sourceFileDescriptors_ = CodeGeneratorRequest.access$1700(r8);
                this.bitField0_ &= -9;
            L42:
                onChanged();
                goto L53
            L41:
                ensureSourceFileDescriptorsIsMutable();
                this.sourceFileDescriptors_.addAll(CodeGeneratorRequest.access$1700(r8));
            L53:
                if (r8.hasCompilerVersion() == false) goto L55;
                mergeCompilerVersion(r8.getCompilerVersion());
            L55:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            L44:
                if (CodeGeneratorRequest.access$1700(r8).isEmpty() == true) goto L53;
                if (this.sourceFileDescriptorsBuilder_.isEmpty() == false) goto L51;
                this.sourceFileDescriptorsBuilder_.dispose();
                this.sourceFileDescriptorsBuilder_ = null;
                this.sourceFileDescriptors_ = CodeGeneratorRequest.access$1700(r8);
                this.bitField0_ &= -9;
                if (CodeGeneratorRequest.access$2300() == false) goto L50;
                r10 = internalGetSourceFileDescriptorsFieldBuilder();
            L50:
                this.sourceFileDescriptorsBuilder_ = r10;
                goto L53
            L51:
                this.sourceFileDescriptorsBuilder_.addAllMessages(CodeGeneratorRequest.access$1700(r8));
                goto L53
            L25:
                if (CodeGeneratorRequest.access$1600(r8).isEmpty() == true) goto L35;
                if (this.protoFileBuilder_.isEmpty() == false) goto L33;
                this.protoFileBuilder_.dispose();
                this.protoFileBuilder_ = null;
                this.protoFile_ = CodeGeneratorRequest.access$1600(r8);
                this.bitField0_ &= -5;
                if (CodeGeneratorRequest.access$2200() == false) goto L31;
                RepeatedFieldBuilder<DescriptorProtos.FileDescriptorProto, DescriptorProtos.FileDescriptorProto.Builder, DescriptorProtos.FileDescriptorProtoOrBuilder> r11 = internalGetProtoFileFieldBuilder();
            L32:
                this.protoFileBuilder_ = r11;
                goto L35
            L31:
                r11 = null;
                goto L32
            L33:
                this.protoFileBuilder_.addAllMessages(CodeGeneratorRequest.access$1600(r8));
                goto L35
            }
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "CodeGeneratorRequest");
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

        public static /* synthetic */ boolean access$1400() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ List access$1600(CodeGeneratorRequest r8) {
            return r8.protoFile_;
        }

        public static /* synthetic */ List access$1602(CodeGeneratorRequest r8, List r10) {
            r8.protoFile_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$1700(CodeGeneratorRequest r8) {
            return r8.sourceFileDescriptors_;
        }

        public static /* synthetic */ List access$1702(CodeGeneratorRequest r8, List r10) {
            r8.sourceFileDescriptors_ = r10;
            return r10;
        }

        public static /* synthetic */ LazyStringArrayList access$1800(CodeGeneratorRequest r8) {
            return r8.fileToGenerate_;
        }

        public static /* synthetic */ LazyStringArrayList access$1802(CodeGeneratorRequest r8, LazyStringArrayList r10) {
            r8.fileToGenerate_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$1900(CodeGeneratorRequest r8) {
            return r8.parameter_;
        }

        public static /* synthetic */ Object access$1902(CodeGeneratorRequest r8, Object r10) {
            r8.parameter_ = r10;
            return r10;
        }

        public static /* synthetic */ Version access$2002(CodeGeneratorRequest r8, Version r10) {
            r8.compilerVersion_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2176(CodeGeneratorRequest r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static /* synthetic */ boolean access$2200() {
            return GeneratedMessage.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$2300() {
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

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream r8) {
            return (CodeGeneratorRequest) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static CodeGeneratorRequest parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<CodeGeneratorRequest> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof CodeGeneratorRequest) == false) goto L8;
            CodeGeneratorRequest r10 = (CodeGeneratorRequest) r8;
            if (getFileToGenerateList().equals(r10.getFileToGenerateList()) == true) goto L13;
            return false;
        L13:
            if (hasParameter() == r10.hasParameter()) goto L16;
            return false;
        L16:
            if (hasParameter() == false) goto L21;
            if (getParameter().equals(r10.getParameter()) == true) goto L21;
            return false;
        L21:
            if (getProtoFileList().equals(r10.getProtoFileList()) == true) goto L24;
            return false;
        L24:
            if (getSourceFileDescriptorsList().equals(r10.getSourceFileDescriptorsList()) == true) goto L27;
            return false;
        L27:
            if (hasCompilerVersion() == r10.hasCompilerVersion()) goto L30;
            return false;
        L30:
            if (hasCompilerVersion() == false) goto L35;
            if (getCompilerVersion().equals(r10.getCompilerVersion()) == true) goto L35;
            return false;
        L35:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L37;
            return false;
        L37:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public Version getCompilerVersion() {
            Version r8 = this.compilerVersion_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Version.getDefaultInstance();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public VersionOrBuilder getCompilerVersionOrBuilder() {
            Version r8 = this.compilerVersion_;
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Version.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public String getFileToGenerate(int r8) {
            return this.fileToGenerate_.get(r8);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getFileToGenerateBytes(int r8) {
            return this.fileToGenerate_.getByteString(r8);
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
        public String getParameter() {
            Object r8 = this.parameter_;
            if ((r8 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.parameter_ = r11;
        L9:
            return r11;
        L5:
            return (String) r8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public ByteString getParameterBytes() {
            Object r8 = this.parameter_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.parameter_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CodeGeneratorRequest> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getProtoFile(int r8) {
            return this.protoFile_.get(r8);
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
        public DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r8) {
            return this.protoFile_.get(r8);
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList() {
            return this.protoFile_;
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int r8 = this.memoizedSize;
            if (r8 == (-1)) goto L5;
            return r8;
        L5:
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.fileToGenerate_.size()) goto L9;
            r12 = r12 + GeneratedMessage.computeStringSizeNoTag(this.fileToGenerate_.getRaw(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            int r13 = (getFileToGenerateList().size() * 1) + (r12 + 0);
            if ((this.bitField0_ & 1) == 0) goto L13;
            r13 = r13 + GeneratedMessage.computeStringSize(2, this.parameter_);
        L13:
            if ((this.bitField0_ & 2) == 0) goto L15;
            r13 = r13 + CodedOutputStream.computeMessageSize(3, getCompilerVersion());
        L15:
            int r14 = 0;
        L17:
            if (r14 >= this.protoFile_.size()) goto L20;
            r13 = r13 + CodedOutputStream.computeMessageSize(15, this.protoFile_.get(r14));
            r14 = r14 + 1;
        L20:
            if (r10 >= this.sourceFileDescriptors_.size()) goto L22;
            r13 = r13 + CodedOutputStream.computeMessageSize(17, this.sourceFileDescriptors_.get(r10));
            r10 = r10 + 1;
            goto L20
        L22:
            int r15 = getUnknownFields().getSerializedSize() + r13;
            this.memoizedSize = r15;
            return r15;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r8) {
            return this.sourceFileDescriptors_.get(r8);
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
        public DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r8) {
            return this.sourceFileDescriptors_.get(r8);
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
            int r8 = this.memoizedHashCode;
            if (r8 == 0) goto L5;
            return r8;
        L5:
            int r10 = getDescriptor().hashCode() + 779;
            if (getFileToGenerateCount() <= 0) goto L9;
            r10 = b.a(r10, 37, 1, 53) + getFileToGenerateList().hashCode();
        L9:
            if (hasParameter() == false) goto L12;
            r10 = b.a(r10, 37, 2, 53) + getParameter().hashCode();
        L12:
            if (getProtoFileCount() <= 0) goto L15;
            r10 = b.a(r10, 37, 15, 53) + getProtoFileList().hashCode();
        L15:
            if (getSourceFileDescriptorsCount() <= 0) goto L18;
            r10 = b.a(r10, 37, 17, 53) + getSourceFileDescriptorsList().hashCode();
        L18:
            if (hasCompilerVersion() == false) goto L20;
            r10 = b.a(r10, 37, 3, 53) + getCompilerVersion().hashCode();
        L20:
            int r11 = getUnknownFields().hashCode();
            int r12 = r11 + (r10 * 29);
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$1100().ensureFieldAccessorsInitialized(CodeGeneratorRequest.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r8 = this.memoizedIsInitialized;
            if (r8 != 1) goto L6;
            return true;
        L6:
            if (r8 != 0) goto L8;
            return false;
        L8:
            int r10 = 0;
        L10:
            if (r10 >= getProtoFileCount()) goto L16;
            if (getProtoFile(r10).isInitialized() == false) goto L13;
            r10 = r10 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r11 = 0;
        L18:
            if (r11 >= getSourceFileDescriptorsCount()) goto L24;
            if (getSourceFileDescriptors(r11).isInitialized() == false) goto L21;
            r11 = r11 + 1;
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

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            int r10 = 0;
            int r11 = 0;
        L4:
            if (r11 >= this.fileToGenerate_.size()) goto L7;
            GeneratedMessage.writeString(r8, 1, this.fileToGenerate_.getRaw(r11));
            r11 = r11 + 1;
            goto L4
        L7:
            if ((this.bitField0_ & 1) == 0) goto L10;
            GeneratedMessage.writeString(r8, 2, this.parameter_);
        L10:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r8.writeMessage(3, getCompilerVersion());
        L12:
            int r12 = 0;
        L14:
            if (r12 >= this.protoFile_.size()) goto L17;
            r8.writeMessage(15, this.protoFile_.get(r12));
            r12 = r12 + 1;
        L17:
            if (r10 >= this.sourceFileDescriptors_.size()) goto L19;
            r8.writeMessage(17, this.sourceFileDescriptors_.get(r10));
            r10 = r10 + 1;
            goto L17
        L19:
            getUnknownFields().writeTo(r8);
        }

        private CodeGeneratorRequest(GeneratedMessage.Builder<?> r8) {
            super(r8);
            this.fileToGenerate_ = LazyStringArrayList.emptyList();
            this.parameter_ = "";
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(CodeGeneratorRequest r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static CodeGeneratorRequest parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (CodeGeneratorRequest) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static CodeGeneratorRequest parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorRequestOrBuilder
        public /* bridge */ /* synthetic */ List getFileToGenerateList() {
            return getFileToGenerateList();
        }

        @Override // com.google.protobuf.AbstractMessage
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ CodeGeneratorRequest(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream r8) {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public CodeGeneratorRequest getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            AnonymousClass1 r8 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r8);
        L6:
            return new Builder(r8).mergeFrom(this);
        }

        public static CodeGeneratorRequest parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static CodeGeneratorRequest parseFrom(InputStream r8) {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static CodeGeneratorRequest parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (CodeGeneratorRequest) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static CodeGeneratorRequest parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static CodeGeneratorRequest parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static CodeGeneratorRequest parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface CodeGeneratorRequestOrBuilder extends MessageOrBuilder {
        Version getCompilerVersion();

        VersionOrBuilder getCompilerVersionOrBuilder();

        String getFileToGenerate(int r8);

        ByteString getFileToGenerateBytes(int r8);

        int getFileToGenerateCount();

        List<String> getFileToGenerateList();

        String getParameter();

        ByteString getParameterBytes();

        DescriptorProtos.FileDescriptorProto getProtoFile(int r8);

        int getProtoFileCount();

        List<DescriptorProtos.FileDescriptorProto> getProtoFileList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getProtoFileOrBuilder(int r8);

        List<? extends DescriptorProtos.FileDescriptorProtoOrBuilder> getProtoFileOrBuilderList();

        DescriptorProtos.FileDescriptorProto getSourceFileDescriptors(int r8);

        int getSourceFileDescriptorsCount();

        List<DescriptorProtos.FileDescriptorProto> getSourceFileDescriptorsList();

        DescriptorProtos.FileDescriptorProtoOrBuilder getSourceFileDescriptorsOrBuilder(int r8);

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

            private void buildPartial0(CodeGeneratorResponse r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                CodeGeneratorResponse.access$4102(r8, this.error_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                CodeGeneratorResponse.access$4202(r8, this.supportedFeatures_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L13;
                CodeGeneratorResponse.access$4302(r8, this.minimumEdition_);
                r11 = r11 | 4;
            L13:
                if ((r10 & 8) == 0) goto L15;
                CodeGeneratorResponse.access$4402(r8, this.maximumEdition_);
                r11 = r11 | 8;
            L15:
                CodeGeneratorResponse.access$4576(r8, r11);
                return;
            L5:
                r11 = 0;
                goto L7
            }

            private void buildPartialRepeatedFields(CodeGeneratorResponse r8) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 == null) goto L5;
                List r11 = r10.build();
            L9:
                CodeGeneratorResponse.access$4002(r8, r11);
                return;
            L5:
                if ((this.bitField0_ & 16) == 0) goto L7;
                this.file_ = Collections.unmodifiableList(this.file_);
                this.bitField0_ &= -17;
            L7:
                r11 = this.file_;
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
                List<File> r8 = this.file_;
                if ((this.bitField0_ & 16) == 0) goto L7;
                boolean r10 = true;
            L8:
                this.fileBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
                this.file_ = null;
                goto L10
            L7:
                r10 = false;
            L10:
                return this.fileBuilder_;
            }

            public Builder addAllFile(Iterable<? extends File> r8) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L5;
                ensureFileIsMutable();
                AbstractMessageLite.Builder.addAll(r8, this.file_);
                onChanged();
            L6:
                return this;
            L5:
                r10.addAllMessages(r8);
                goto L6
            }

            public Builder addFile(int r8, File.Builder r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                ensureFileIsMutable();
                this.file_.add(r8, r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.addMessage(r8, r10.build());
                goto L6
            }

            public File.Builder addFileBuilder() {
                return (File.Builder) internalGetFileFieldBuilder().addBuilder(File.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
            }

            public Builder clearError() {
                this.error_ = CodeGeneratorResponse.getDefaultInstance().getError();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            public Builder clearFile() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r8 = this.fileBuilder_;
                if (r8 != null) goto L5;
                this.file_ = Collections.emptyList();
                this.bitField0_ &= -17;
                onChanged();
            L6:
                return this;
            L5:
                r8.clear();
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PluginProtos.access$2400();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public String getError() {
                Object r8 = this.error_;
                if ((r8 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.error_ = r11;
            L7:
                return r11;
            L9:
                return (String) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public ByteString getErrorBytes() {
                Object r8 = this.error_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.error_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public File getFile(int r8) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L7;
                MessageLite r11 = this.file_.get(r8);
            L6:
                return (File) r11;
            L7:
                r11 = r10.getMessage(r8);
                goto L6
            }

            public File.Builder getFileBuilder(int r8) {
                return (File.Builder) internalGetFileFieldBuilder().getBuilder(r8);
            }

            public List<File.Builder> getFileBuilderList() {
                return internalGetFileFieldBuilder().getBuilderList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public int getFileCount() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r8 = this.fileBuilder_;
                if (r8 != null) goto L7;
                return this.file_.size();
            L7:
                return r8.getCount();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<File> getFileList() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r8 = this.fileBuilder_;
                if (r8 != null) goto L7;
                return Collections.unmodifiableList(this.file_);
            L7:
                return r8.getMessageList();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public FileOrBuilder getFileOrBuilder(int r8) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L7;
                Object r11 = this.file_.get(r8);
            L6:
                return (FileOrBuilder) r11;
            L7:
                r11 = r10.getMessageOrBuilder(r8);
                goto L6
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
            public List<? extends FileOrBuilder> getFileOrBuilderList() {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r8 = this.fileBuilder_;
                if (r8 == null) goto L7;
                return r8.getMessageOrBuilderList();
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
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$2500().ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public Builder removeFile(int r8) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L5;
                ensureFileIsMutable();
                this.file_.remove(r8);
                onChanged();
            L6:
                return this;
            L5:
                r10.remove(r8);
                goto L6
            }

            public Builder setError(String r8) {
                if (r8 == null) goto L6;
                this.error_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setErrorBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.error_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setFile(int r8, File.Builder r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L5;
                ensureFileIsMutable();
                this.file_.set(r8, r10.build());
                onChanged();
            L6:
                return this;
            L5:
                r11.setMessage(r8, r10.build());
                goto L6
            }

            public Builder setMaximumEdition(int r8) {
                this.maximumEdition_ = r8;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            }

            public Builder setMinimumEdition(int r8) {
                this.minimumEdition_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setSupportedFeatures(long r8) {
                this.supportedFeatures_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            private Builder(AbstractMessage.BuilderParent r8) {
                super(r8);
                this.error_ = "";
                this.file_ = Collections.emptyList();
            }

            public Builder addFile(int r8, File r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L8;
                if (r10 == null) goto L7;
                ensureFileIsMutable();
                this.file_.add(r8, r10);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r11.addMessage(r8, r10);
                goto L9
            }

            public File.Builder addFileBuilder(int r8) {
                return (File.Builder) internalGetFileFieldBuilder().addBuilder(r8, File.getDefaultInstance());
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            public Builder setFile(int r8, File r10) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r11 = this.fileBuilder_;
                if (r11 != null) goto L8;
                if (r10 == null) goto L7;
                ensureFileIsMutable();
                this.file_.set(r8, r10);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r11.setMessage(r8, r10);
                goto L9
            }

            public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
                this(r8);
            }

            public Builder addFile(File.Builder r8) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L5;
                ensureFileIsMutable();
                this.file_.add(r8.build());
                onChanged();
            L6:
                return this;
            L5:
                r10.addMessage(r8.build());
                goto L6
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse build() {
                CodeGeneratorResponse r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CodeGeneratorResponse buildPartial() {
                CodeGeneratorResponse r8 = new CodeGeneratorResponse(this, null);
                buildPartialRepeatedFields(r8);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r8);
            L5:
                onBuilt();
                return r8;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public CodeGeneratorResponse getDefaultInstanceForType() {
                return CodeGeneratorResponse.getDefaultInstance();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public /* synthetic */ Builder(AnonymousClass1 r8) {
                this();
            }

            public Builder addFile(File r8) {
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = this.fileBuilder_;
                if (r10 != null) goto L8;
                if (r8 == null) goto L7;
                ensureFileIsMutable();
                this.file_.add(r8);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r10.addMessage(r8);
                goto L9
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.bitField0_ = 0;
                this.error_ = "";
                this.supportedFeatures_ = 0;
                this.minimumEdition_ = 0;
                this.maximumEdition_ = 0;
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r8 = this.fileBuilder_;
                if (r8 != null) goto L5;
                this.file_ = Collections.emptyList();
            L6:
                this.bitField0_ &= -17;
                return this;
            L5:
                this.file_ = null;
                r8.clear();
                goto L6
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L40;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L37;
                int r12 = r8.readTag();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                if (r12 == 0) goto L29;
                if (r12 != 10) goto L10;
                this.error_ = r8.readBytes();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 1;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L10:
                if (r12 != 16) goto L12;
                this.supportedFeatures_ = r8.readUInt64();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 2;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L12:
                if (r12 != 24) goto L14;
                this.minimumEdition_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 4;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L14:
                if (r12 != 32) goto L16;
                this.maximumEdition_ = r8.readInt32();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.bitField0_ |= 8;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L16:
                if (r12 != 122) goto L18;
                File r13 = (File) r8.readMessage(File.parser(), r10);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r14 = this.fileBuilder_;     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                if (r14 == null) goto L22;
                r14.addMessage(r13);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L22:
                ensureFileIsMutable();     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                this.file_.add(r13);     // Catch: Throwable -> L30 InvalidProtocolBufferException -> L32
                goto L4
            L18:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L29:
                r11 = true;
                goto L4
            L30:
                th = move-exception;
                onChanged();
                throw th;
            L32:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L30
            L37:
                onChanged();
                return this;
            L40:
                throw null;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof CodeGeneratorResponse) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((CodeGeneratorResponse) r8);
            }

            public Builder mergeFrom(CodeGeneratorResponse r8) {
                if (r8 != CodeGeneratorResponse.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasError() == false) goto L9;
                this.error_ = CodeGeneratorResponse.access$4100(r8);
                this.bitField0_ |= 1;
                onChanged();
            L9:
                if (r8.hasSupportedFeatures() == false) goto L12;
                setSupportedFeatures(r8.getSupportedFeatures());
            L12:
                if (r8.hasMinimumEdition() == false) goto L15;
                setMinimumEdition(r8.getMinimumEdition());
            L15:
                if (r8.hasMaximumEdition() == false) goto L18;
                setMaximumEdition(r8.getMaximumEdition());
            L18:
                if (this.fileBuilder_ != null) goto L27;
                if (CodeGeneratorResponse.access$4000(r8).isEmpty() == false) goto L22;
            L35:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            L22:
                if (this.file_.isEmpty() == false) goto L24;
                this.file_ = CodeGeneratorResponse.access$4000(r8);
                this.bitField0_ &= -17;
            L25:
                onChanged();
                goto L35
            L24:
                ensureFileIsMutable();
                this.file_.addAll(CodeGeneratorResponse.access$4000(r8));
                goto L25
            L27:
                if (CodeGeneratorResponse.access$4000(r8).isEmpty() == true) goto L35;
                if (this.fileBuilder_.isEmpty() == false) goto L34;
                this.fileBuilder_.dispose();
                RepeatedFieldBuilder<File, File.Builder, FileOrBuilder> r10 = null;
                this.fileBuilder_ = null;
                this.file_ = CodeGeneratorResponse.access$4000(r8);
                this.bitField0_ &= -17;
                if (CodeGeneratorResponse.access$4600() == false) goto L33;
                r10 = internalGetFileFieldBuilder();
            L33:
                this.fileBuilder_ = r10;
                goto L35
            L34:
                this.fileBuilder_.addAllMessages(CodeGeneratorResponse.access$4000(r8));
                goto L35
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
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Feature");
                internalValueMap = new AnonymousClass1();
                VALUES = values();
            }

            private Feature(String r8, int r10, int r11) {
                super(r8, r10);
                this.value = r11;
            }

            public static Feature forNumber(int r8) {
                if (r8 == 0) goto L14;
                if (r8 == 1) goto L12;
                if (r8 == 2) goto L10;
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
            public static Feature valueOf(int r8) {
                return forNumber(r8);
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

            public static Feature valueOf(Descriptors.EnumValueDescriptor r8) {
                if (r8.getType() != getDescriptor()) goto L7;
                return VALUES[r8.getIndex()];
            L7:
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            }

            public static Feature valueOf(String r8) {
                return (Feature) Enum.valueOf(Feature.class, r8);
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

                private void buildPartial0(File r8) {
                    int r10 = this.bitField0_;
                    if ((r10 & 1) == 0) goto L5;
                    File.access$3202(r8, this.name_);
                    int r11 = 1;
                L7:
                    if ((r10 & 2) == 0) goto L10;
                    File.access$3302(r8, this.insertionPoint_);
                    r11 = r11 | 2;
                L10:
                    if ((r10 & 4) == 0) goto L13;
                    File.access$3402(r8, this.content_);
                    r11 = r11 | 4;
                L13:
                    if ((r10 & 8) == 0) goto L19;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r12 = this.generatedCodeInfoBuilder_;
                    if (r12 != null) goto L17;
                    DescriptorProtos.GeneratedCodeInfo r13 = this.generatedCodeInfo_;
                L18:
                    File.access$3502(r8, r13);
                    r11 = r11 | 8;
                    goto L19
                L17:
                    r13 = (DescriptorProtos.GeneratedCodeInfo) r12.build();
                L19:
                    File.access$3676(r8, r11);
                    return;
                L5:
                    r11 = 0;
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
                public /* bridge */ /* synthetic */ Message buildPartial() {
                    return buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                    return clear();
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
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r8 = this.generatedCodeInfoBuilder_;
                    if (r8 == null) goto L5;
                    r8.dispose();
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
                    Object r8 = this.content_;
                    if ((r8 instanceof String) == true) goto L9;
                    ByteString r10 = (ByteString) r8;
                    String r11 = r10.toStringUtf8();
                    if (r10.isValidUtf8() == false) goto L7;
                    this.content_ = r11;
                L7:
                    return r11;
                L9:
                    return (String) r8;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getContentBytes() {
                    Object r8 = this.content_;
                    if ((r8 instanceof String) == false) goto L7;
                    ByteString r10 = ByteString.copyFromUtf8((String) r8);
                    this.content_ = r10;
                    return r10;
                L7:
                    return (ByteString) r8;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
                public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return PluginProtos.access$2600();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r8 = this.generatedCodeInfoBuilder_;
                    if (r8 != null) goto L9;
                    DescriptorProtos.GeneratedCodeInfo r10 = this.generatedCodeInfo_;
                    if (r10 == null) goto L7;
                    return r10;
                L7:
                    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                L9:
                    return (DescriptorProtos.GeneratedCodeInfo) r8.getMessage();
                }

                public DescriptorProtos.GeneratedCodeInfo.Builder getGeneratedCodeInfoBuilder() {
                    this.bitField0_ |= 8;
                    onChanged();
                    return (DescriptorProtos.GeneratedCodeInfo.Builder) internalGetGeneratedCodeInfoFieldBuilder().getBuilder();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r8 = this.generatedCodeInfoBuilder_;
                    if (r8 != null) goto L5;
                    DescriptorProtos.GeneratedCodeInfo r10 = this.generatedCodeInfo_;
                    if (r10 == null) goto L9;
                    return r10;
                L9:
                    return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
                L5:
                    return (DescriptorProtos.GeneratedCodeInfoOrBuilder) r8.getMessageOrBuilder();
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getInsertionPoint() {
                    Object r8 = this.insertionPoint_;
                    if ((r8 instanceof String) == true) goto L9;
                    ByteString r10 = (ByteString) r8;
                    String r11 = r10.toStringUtf8();
                    if (r10.isValidUtf8() == false) goto L7;
                    this.insertionPoint_ = r11;
                L7:
                    return r11;
                L9:
                    return (String) r8;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getInsertionPointBytes() {
                    Object r8 = this.insertionPoint_;
                    if ((r8 instanceof String) == false) goto L7;
                    ByteString r10 = ByteString.copyFromUtf8((String) r8);
                    this.insertionPoint_ = r10;
                    return r10;
                L7:
                    return (ByteString) r8;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public String getName() {
                    Object r8 = this.name_;
                    if ((r8 instanceof String) == true) goto L9;
                    ByteString r10 = (ByteString) r8;
                    String r11 = r10.toStringUtf8();
                    if (r10.isValidUtf8() == false) goto L7;
                    this.name_ = r11;
                L7:
                    return r11;
                L9:
                    return (String) r8;
                }

                @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
                public ByteString getNameBytes() {
                    Object r8 = this.name_;
                    if ((r8 instanceof String) == false) goto L7;
                    ByteString r10 = ByteString.copyFromUtf8((String) r8);
                    this.name_ = r10;
                    return r10;
                L7:
                    return (ByteString) r8;
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
                public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                    return PluginProtos.access$2700().ensureFieldAccessorsInitialized(File.class, Builder.class);
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    return mergeFrom(r8, r10);
                }

                public Builder mergeGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo r8) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r10 = this.generatedCodeInfoBuilder_;
                    if (r10 == null) goto L5;
                    r10.mergeFrom(r8);
                L14:
                    if (this.generatedCodeInfo_ == null) goto L16;
                    this.bitField0_ |= 8;
                    onChanged();
                L16:
                    return this;
                L5:
                    if ((this.bitField0_ & 8) == 0) goto L11;
                    DescriptorProtos.GeneratedCodeInfo r11 = this.generatedCodeInfo_;
                    if (r11 == null) goto L11;
                    if (r11 == DescriptorProtos.GeneratedCodeInfo.getDefaultInstance()) goto L11;
                    getGeneratedCodeInfoBuilder().mergeFrom(r8);
                L11:
                    this.generatedCodeInfo_ = r8;
                    goto L14
                }

                public Builder setContent(String r8) {
                    if (r8 == null) goto L6;
                    this.content_ = r8;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setContentBytes(ByteString r8) {
                    if (r8 == null) goto L6;
                    this.content_ = r8;
                    this.bitField0_ |= 4;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo.Builder r8) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r10 = this.generatedCodeInfoBuilder_;
                    DescriptorProtos.GeneratedCodeInfo r11 = r8.build();
                    if (r10 != null) goto L5;
                    this.generatedCodeInfo_ = r11;
                L6:
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                L5:
                    r10.setMessage(r11);
                    goto L6
                }

                public Builder setInsertionPoint(String r8) {
                    if (r8 == null) goto L6;
                    this.insertionPoint_ = r8;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setInsertionPointBytes(ByteString r8) {
                    if (r8 == null) goto L6;
                    this.insertionPoint_ = r8;
                    this.bitField0_ |= 2;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setName(String r8) {
                    if (r8 == null) goto L6;
                    this.name_ = r8;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                public Builder setNameBytes(ByteString r8) {
                    if (r8 == null) goto L6;
                    this.name_ = r8;
                    this.bitField0_ |= 1;
                    onChanged();
                    return this;
                L6:
                    throw null;
                }

                private Builder(AbstractMessage.BuilderParent r8) {
                    super(r8);
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    maybeForceBuilderInitialization();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                    return buildPartial();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
                    return mergeFrom(r8);
                }

                public Builder setGeneratedCodeInfo(DescriptorProtos.GeneratedCodeInfo r8) {
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r10 = this.generatedCodeInfoBuilder_;
                    if (r10 != null) goto L8;
                    if (r8 == null) goto L7;
                    this.generatedCodeInfo_ = r8;
                L9:
                    this.bitField0_ |= 8;
                    onChanged();
                    return this;
                L7:
                    throw null;
                L8:
                    r10.setMessage(r8);
                    goto L9
                }

                public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
                    this(r8);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File build() {
                    File r8 = buildPartial();
                    if (r8.isInitialized() == false) goto L6;
                    return r8;
                L6:
                    throw AbstractMessage.Builder.newUninitializedMessageException(r8);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public File buildPartial() {
                    File r8 = new File(this, null);
                    if (this.bitField0_ == 0) goto L5;
                    buildPartial0(r8);
                L5:
                    onBuilt();
                    return r8;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
                public File getDefaultInstanceForType() {
                    return File.getDefaultInstance();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    return mergeFrom(r8, r10);
                }

                public /* synthetic */ Builder(AnonymousClass1 r8) {
                    this();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                    return clear();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    return mergeFrom(r8, r10);
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.bitField0_ = 0;
                    this.name_ = "";
                    this.insertionPoint_ = "";
                    this.content_ = "";
                    this.generatedCodeInfo_ = null;
                    SingleFieldBuilder<DescriptorProtos.GeneratedCodeInfo, DescriptorProtos.GeneratedCodeInfo.Builder, DescriptorProtos.GeneratedCodeInfoOrBuilder> r8 = this.generatedCodeInfoBuilder_;
                    if (r8 == null) goto L5;
                    r8.dispose();
                    this.generatedCodeInfoBuilder_ = null;
                L5:
                    return this;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
                    return mergeFrom(r8);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    return mergeFrom(r8, r10);
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                    if (r10 == null) goto L34;
                    boolean r11 = false;
                L4:
                    if (r11 == true) goto L31;
                    int r12 = r8.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    if (r12 == 0) goto L23;
                    if (r12 != 10) goto L10;
                    this.name_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    this.bitField0_ |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    goto L4
                L10:
                    if (r12 != 18) goto L12;
                    this.insertionPoint_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    this.bitField0_ |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    goto L4
                L12:
                    if (r12 != 122) goto L14;
                    this.content_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    this.bitField0_ |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    goto L4
                L14:
                    if (r12 != 130) goto L16;
                    r8.readMessage(internalGetGeneratedCodeInfoFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    this.bitField0_ |= 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                    goto L4
                L16:
                    if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
                L23:
                    r11 = true;
                    goto L4
                L26:
                    e = move-exception;
                    throw e.unwrapIOException();     // Catch: Throwable -> L24
                L24:
                    th = move-exception;
                    onChanged();
                    throw th;
                L31:
                    onChanged();
                    return this;
                L34:
                    throw null;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message r8) {
                    if ((r8 instanceof File) == true) goto L5;
                    super.mergeFrom(r8);
                    return this;
                L5:
                    return mergeFrom((File) r8);
                }

                public Builder mergeFrom(File r8) {
                    if (r8 != File.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r8.hasName() == false) goto L9;
                    this.name_ = File.access$3200(r8);
                    this.bitField0_ |= 1;
                    onChanged();
                L9:
                    if (r8.hasInsertionPoint() == false) goto L12;
                    this.insertionPoint_ = File.access$3300(r8);
                    this.bitField0_ |= 2;
                    onChanged();
                L12:
                    if (r8.hasContent() == false) goto L15;
                    this.content_ = File.access$3400(r8);
                    this.bitField0_ |= 4;
                    onChanged();
                L15:
                    if (r8.hasGeneratedCodeInfo() == false) goto L17;
                    mergeGeneratedCodeInfo(r8.getGeneratedCodeInfo());
                L17:
                    mergeUnknownFields(r8.getUnknownFields());
                    onChanged();
                    return this;
                }
            }

            static {
                RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "File");
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

            public static /* synthetic */ boolean access$3000() {
                return GeneratedMessage.alwaysUseFieldBuilders;
            }

            public static /* synthetic */ Object access$3200(File r8) {
                return r8.name_;
            }

            public static /* synthetic */ Object access$3202(File r8, Object r10) {
                r8.name_ = r10;
                return r10;
            }

            public static /* synthetic */ Object access$3300(File r8) {
                return r8.insertionPoint_;
            }

            public static /* synthetic */ Object access$3302(File r8, Object r10) {
                r8.insertionPoint_ = r10;
                return r10;
            }

            public static /* synthetic */ Object access$3400(File r8) {
                return r8.content_;
            }

            public static /* synthetic */ Object access$3402(File r8, Object r10) {
                r8.content_ = r10;
                return r10;
            }

            public static /* synthetic */ DescriptorProtos.GeneratedCodeInfo access$3502(File r8, DescriptorProtos.GeneratedCodeInfo r10) {
                r8.generatedCodeInfo_ = r10;
                return r10;
            }

            public static /* synthetic */ int access$3676(File r8, int r10) {
                int r11 = r10 | r8.bitField0_;
                r8.bitField0_ = r11;
                return r11;
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

            public static File parseDelimitedFrom(InputStream r8) {
                return (File) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
            }

            public static File parseFrom(ByteString r8) {
                return PARSER.parseFrom(r8);
            }

            public static Parser<File> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public boolean equals(Object r8) {
                if (r8 != this) goto L6;
                return true;
            L6:
                if ((r8 instanceof File) == false) goto L8;
                File r10 = (File) r8;
                if (hasName() == r10.hasName()) goto L13;
                return false;
            L13:
                if (hasName() == false) goto L18;
                if (getName().equals(r10.getName()) == true) goto L18;
                return false;
            L18:
                if (hasInsertionPoint() == r10.hasInsertionPoint()) goto L21;
                return false;
            L21:
                if (hasInsertionPoint() == false) goto L26;
                if (getInsertionPoint().equals(r10.getInsertionPoint()) == true) goto L26;
                return false;
            L26:
                if (hasContent() == r10.hasContent()) goto L29;
                return false;
            L29:
                if (hasContent() == false) goto L34;
                if (getContent().equals(r10.getContent()) == true) goto L34;
                return false;
            L34:
                if (hasGeneratedCodeInfo() == r10.hasGeneratedCodeInfo()) goto L37;
                return false;
            L37:
                if (hasGeneratedCodeInfo() == false) goto L42;
                if (getGeneratedCodeInfo().equals(r10.getGeneratedCodeInfo()) == true) goto L42;
                return false;
            L42:
                if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L44;
                return false;
            L44:
                return true;
            L8:
                return super.equals(r8);
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getContent() {
                Object r8 = this.content_;
                if ((r8 instanceof String) == true) goto L5;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L9;
                this.content_ = r11;
            L9:
                return r11;
            L5:
                return (String) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getContentBytes() {
                Object r8 = this.content_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.content_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfo getGeneratedCodeInfo() {
                DescriptorProtos.GeneratedCodeInfo r8 = this.generatedCodeInfo_;
                if (r8 == null) goto L5;
                return r8;
            L5:
                return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public DescriptorProtos.GeneratedCodeInfoOrBuilder getGeneratedCodeInfoOrBuilder() {
                DescriptorProtos.GeneratedCodeInfo r8 = this.generatedCodeInfo_;
                if (r8 == null) goto L5;
                return r8;
            L5:
                return DescriptorProtos.GeneratedCodeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getInsertionPoint() {
                Object r8 = this.insertionPoint_;
                if ((r8 instanceof String) == true) goto L5;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L9;
                this.insertionPoint_ = r11;
            L9:
                return r11;
            L5:
                return (String) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getInsertionPointBytes() {
                Object r8 = this.insertionPoint_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.insertionPoint_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public String getName() {
                Object r8 = this.name_;
                if ((r8 instanceof String) == true) goto L5;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L9;
                this.name_ = r11;
            L9:
                return r11;
            L5:
                return (String) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.FileOrBuilder
            public ByteString getNameBytes() {
                Object r8 = this.name_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.name_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<File> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int r8 = this.memoizedSize;
                if (r8 == (-1)) goto L5;
                return r8;
            L5:
                int r10 = 0;
                if ((this.bitField0_ & 1) == 0) goto L9;
                r10 = 0 + GeneratedMessage.computeStringSize(1, this.name_);
            L9:
                if ((this.bitField0_ & 2) == 0) goto L12;
                r10 = r10 + GeneratedMessage.computeStringSize(2, this.insertionPoint_);
            L12:
                if ((this.bitField0_ & 4) == 0) goto L15;
                r10 = r10 + GeneratedMessage.computeStringSize(15, this.content_);
            L15:
                if ((this.bitField0_ & 8) == 0) goto L17;
                r10 = r10 + CodedOutputStream.computeMessageSize(16, getGeneratedCodeInfo());
            L17:
                int r11 = getUnknownFields().getSerializedSize() + r10;
                this.memoizedSize = r11;
                return r11;
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
                int r8 = this.memoizedHashCode;
                if (r8 == 0) goto L5;
                return r8;
            L5:
                int r10 = getDescriptor().hashCode() + 779;
                if (hasName() == false) goto L9;
                r10 = b.a(r10, 37, 1, 53) + getName().hashCode();
            L9:
                if (hasInsertionPoint() == false) goto L12;
                r10 = b.a(r10, 37, 2, 53) + getInsertionPoint().hashCode();
            L12:
                if (hasContent() == false) goto L15;
                r10 = b.a(r10, 37, 15, 53) + getContent().hashCode();
            L15:
                if (hasGeneratedCodeInfo() == false) goto L17;
                r10 = b.a(r10, 37, 16, 53) + getGeneratedCodeInfo().hashCode();
            L17:
                int r11 = getUnknownFields().hashCode();
                int r12 = r11 + (r10 * 29);
                this.memoizedHashCode = r12;
                return r12;
            }

            @Override // com.google.protobuf.GeneratedMessage
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$2700().ensureFieldAccessorsInitialized(File.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r8 = this.memoizedIsInitialized;
                if (r8 != 1) goto L5;
                return true;
            L5:
                if (r8 != 0) goto L8;
                return false;
            L8:
                this.memoizedIsInitialized = 1;
                return true;
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
                return toBuilder();
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream r8) {
                if ((this.bitField0_ & 1) == 0) goto L6;
                GeneratedMessage.writeString(r8, 1, this.name_);
            L6:
                if ((this.bitField0_ & 2) == 0) goto L9;
                GeneratedMessage.writeString(r8, 2, this.insertionPoint_);
            L9:
                if ((this.bitField0_ & 4) == 0) goto L12;
                GeneratedMessage.writeString(r8, 15, this.content_);
            L12:
                if ((this.bitField0_ & 8) == 0) goto L14;
                r8.writeMessage(16, getGeneratedCodeInfo());
            L14:
                getUnknownFields().writeTo(r8);
            }

            private File(GeneratedMessage.Builder<?> r8) {
                super(r8);
                this.name_ = "";
                this.insertionPoint_ = "";
                this.content_ = "";
                this.memoizedIsInitialized = -1;
            }

            public static Builder newBuilder(File r8) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
            }

            public static File parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
                return (File) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
            }

            public static File parseFrom(ByteString r8, ExtensionRegistryLite r10) {
                return PARSER.parseFrom(r8, r10);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.AbstractMessage
            public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
                return newBuilderForType(r8);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            public /* synthetic */ File(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
                this(r8);
            }

            public static File parseFrom(CodedInputStream r8) {
                return (File) GeneratedMessage.parseWithIOException(PARSER, r8);
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public File getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                AnonymousClass1 r8 = null;
                if (this != DEFAULT_INSTANCE) goto L6;
                return new Builder(r8);
            L6:
                return new Builder(r8).mergeFrom(this);
            }

            public static File parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return (File) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static File parseFrom(InputStream r8) {
                return (File) GeneratedMessage.parseWithIOException(PARSER, r8);
            }

            @Override // com.google.protobuf.AbstractMessage
            public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
                return new Builder(r8, null);
            }

            public static File parseFrom(InputStream r8, ExtensionRegistryLite r10) {
                return (File) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
            }

            public static File parseFrom(ByteBuffer r8) {
                return PARSER.parseFrom(r8);
            }

            public static File parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
                return PARSER.parseFrom(r8, r10);
            }

            public static File parseFrom(byte[] r8) {
                return PARSER.parseFrom(r8);
            }

            public static File parseFrom(byte[] r8, ExtensionRegistryLite r10) {
                return PARSER.parseFrom(r8, r10);
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
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "CodeGeneratorResponse");
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

        public static /* synthetic */ List access$4000(CodeGeneratorResponse r8) {
            return r8.file_;
        }

        public static /* synthetic */ List access$4002(CodeGeneratorResponse r8, List r10) {
            r8.file_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$4100(CodeGeneratorResponse r8) {
            return r8.error_;
        }

        public static /* synthetic */ Object access$4102(CodeGeneratorResponse r8, Object r10) {
            r8.error_ = r10;
            return r10;
        }

        public static /* synthetic */ long access$4202(CodeGeneratorResponse r8, long r10) {
            r8.supportedFeatures_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4302(CodeGeneratorResponse r8, int r10) {
            r8.minimumEdition_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4402(CodeGeneratorResponse r8, int r10) {
            r8.maximumEdition_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$4576(CodeGeneratorResponse r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
        }

        public static /* synthetic */ boolean access$4600() {
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

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream r8) {
            return (CodeGeneratorResponse) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static CodeGeneratorResponse parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<CodeGeneratorResponse> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof CodeGeneratorResponse) == false) goto L8;
            CodeGeneratorResponse r10 = (CodeGeneratorResponse) r8;
            if (hasError() == r10.hasError()) goto L13;
            return false;
        L13:
            if (hasError() == false) goto L18;
            if (getError().equals(r10.getError()) == true) goto L18;
            return false;
        L18:
            if (hasSupportedFeatures() == r10.hasSupportedFeatures()) goto L21;
            return false;
        L21:
            if (hasSupportedFeatures() == false) goto L26;
            if (getSupportedFeatures() == r10.getSupportedFeatures()) goto L26;
            return false;
        L26:
            if (hasMinimumEdition() == r10.hasMinimumEdition()) goto L29;
            return false;
        L29:
            if (hasMinimumEdition() == false) goto L34;
            if (getMinimumEdition() == r10.getMinimumEdition()) goto L34;
            return false;
        L34:
            if (hasMaximumEdition() == r10.hasMaximumEdition()) goto L37;
            return false;
        L37:
            if (hasMaximumEdition() == false) goto L42;
            if (getMaximumEdition() == r10.getMaximumEdition()) goto L42;
            return false;
        L42:
            if (getFileList().equals(r10.getFileList()) == true) goto L45;
            return false;
        L45:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L47;
            return false;
        L47:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public String getError() {
            Object r8 = this.error_;
            if ((r8 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.error_ = r11;
        L9:
            return r11;
        L5:
            return (String) r8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public ByteString getErrorBytes() {
            Object r8 = this.error_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.error_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponseOrBuilder
        public File getFile(int r8) {
            return this.file_.get(r8);
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
        public FileOrBuilder getFileOrBuilder(int r8) {
            return this.file_.get(r8);
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
            int r8 = this.memoizedSize;
            if (r8 == (-1)) goto L5;
            return r8;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) == 0) goto L8;
            int r11 = GeneratedMessage.computeStringSize(1, this.error_) + 0;
        L10:
            if ((this.bitField0_ & 2) == 0) goto L13;
            r11 = r11 + CodedOutputStream.computeUInt64Size(2, this.supportedFeatures_);
        L13:
            if ((this.bitField0_ & 4) == 0) goto L16;
            r11 = r11 + CodedOutputStream.computeInt32Size(3, this.minimumEdition_);
        L16:
            if ((this.bitField0_ & 8) == 0) goto L19;
            r11 = r11 + CodedOutputStream.computeInt32Size(4, this.maximumEdition_);
        L19:
            if (r10 >= this.file_.size()) goto L21;
            r11 = r11 + CodedOutputStream.computeMessageSize(15, this.file_.get(r10));
            r10 = r10 + 1;
            goto L19
        L21:
            int r12 = getUnknownFields().getSerializedSize() + r11;
            this.memoizedSize = r12;
            return r12;
        L8:
            r11 = 0;
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
            int r8 = this.memoizedHashCode;
            if (r8 == 0) goto L5;
            return r8;
        L5:
            int r10 = getDescriptor().hashCode() + 779;
            if (hasError() == false) goto L9;
            r10 = b.a(r10, 37, 1, 53) + getError().hashCode();
        L9:
            if (hasSupportedFeatures() == false) goto L12;
            r10 = b.a(r10, 37, 2, 53) + Internal.hashLong(getSupportedFeatures());
        L12:
            if (hasMinimumEdition() == false) goto L15;
            r10 = b.a(r10, 37, 3, 53) + getMinimumEdition();
        L15:
            if (hasMaximumEdition() == false) goto L18;
            r10 = b.a(r10, 37, 4, 53) + getMaximumEdition();
        L18:
            if (getFileCount() <= 0) goto L20;
            r10 = b.a(r10, 37, 15, 53) + getFileList().hashCode();
        L20:
            int r11 = getUnknownFields().hashCode();
            int r12 = r11 + (r10 * 29);
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$2500().ensureFieldAccessorsInitialized(CodeGeneratorResponse.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r8 = this.memoizedIsInitialized;
            if (r8 != 1) goto L5;
            return true;
        L5:
            if (r8 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            GeneratedMessage.writeString(r8, 1, this.error_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeUInt64(2, this.supportedFeatures_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r8.writeInt32(3, this.minimumEdition_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            r8.writeInt32(4, this.maximumEdition_);
        L14:
            int r10 = 0;
        L16:
            if (r10 >= this.file_.size()) goto L18;
            r8.writeMessage(15, this.file_.get(r10));
            r10 = r10 + 1;
            goto L16
        L18:
            getUnknownFields().writeTo(r8);
        }

        private CodeGeneratorResponse(GeneratedMessage.Builder<?> r8) {
            super(r8);
            this.error_ = "";
            this.supportedFeatures_ = 0;
            this.minimumEdition_ = 0;
            this.maximumEdition_ = 0;
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(CodeGeneratorResponse r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static CodeGeneratorResponse parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (CodeGeneratorResponse) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static CodeGeneratorResponse parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ CodeGeneratorResponse(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream r8) {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public CodeGeneratorResponse getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            AnonymousClass1 r8 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r8);
        L6:
            return new Builder(r8).mergeFrom(this);
        }

        public static CodeGeneratorResponse parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static CodeGeneratorResponse parseFrom(InputStream r8) {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static CodeGeneratorResponse parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (CodeGeneratorResponse) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static CodeGeneratorResponse parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static CodeGeneratorResponse parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static CodeGeneratorResponse parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }
    }

    public interface CodeGeneratorResponseOrBuilder extends MessageOrBuilder {
        String getError();

        ByteString getErrorBytes();

        CodeGeneratorResponse.File getFile(int r8);

        int getFileCount();

        List<CodeGeneratorResponse.File> getFileList();

        CodeGeneratorResponse.FileOrBuilder getFileOrBuilder(int r8);

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

            private void buildPartial0(Version r8) {
                int r10 = this.bitField0_;
                if ((r10 & 1) == 0) goto L5;
                Version.access$502(r8, this.major_);
                int r11 = 1;
            L7:
                if ((r10 & 2) == 0) goto L10;
                Version.access$602(r8, this.minor_);
                r11 = r11 | 2;
            L10:
                if ((r10 & 4) == 0) goto L13;
                Version.access$702(r8, this.patch_);
                r11 = r11 | 4;
            L13:
                if ((r10 & 8) == 0) goto L15;
                Version.access$802(r8, this.suffix_);
                r11 = r11 | 8;
            L15:
                Version.access$976(r8, r11);
                return;
            L5:
                r11 = 0;
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
            public /* bridge */ /* synthetic */ Message buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return clear();
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

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return getDefaultInstanceForType();
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
                Object r8 = this.suffix_;
                if ((r8 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r8;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.suffix_ = r11;
            L7:
                return r11;
            L9:
                return (String) r8;
            }

            @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
            public ByteString getSuffixBytes() {
                Object r8 = this.suffix_;
                if ((r8 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r8);
                this.suffix_ = r10;
                return r10;
            L7:
                return (ByteString) r8;
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
            public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return PluginProtos.access$100().ensureFieldAccessorsInitialized(Version.class, Builder.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public Builder setMajor(int r8) {
                this.major_ = r8;
                this.bitField0_ |= 1;
                onChanged();
                return this;
            }

            public Builder setMinor(int r8) {
                this.minor_ = r8;
                this.bitField0_ |= 2;
                onChanged();
                return this;
            }

            public Builder setPatch(int r8) {
                this.patch_ = r8;
                this.bitField0_ |= 4;
                onChanged();
                return this;
            }

            public Builder setSuffix(String r8) {
                if (r8 == null) goto L6;
                this.suffix_ = r8;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setSuffixBytes(ByteString r8) {
                if (r8 == null) goto L6;
                this.suffix_ = r8;
                this.bitField0_ |= 8;
                onChanged();
                return this;
            L6:
                throw null;
            }

            private Builder(AbstractMessage.BuilderParent r8) {
                super(r8);
                this.suffix_ = "";
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
                this(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version build() {
                Version r8 = buildPartial();
                if (r8.isInitialized() == false) goto L6;
                return r8;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r8);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Version buildPartial() {
                Version r8 = new Version(this, null);
                if (this.bitField0_ == 0) goto L5;
                buildPartial0(r8);
            L5:
                onBuilt();
                return r8;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
            public Version getDefaultInstanceForType() {
                return Version.getDefaultInstance();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            public /* synthetic */ Builder(AnonymousClass1 r8) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
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

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
                return mergeFrom(r8);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                return mergeFrom(r8, r10);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
                if (r10 == null) goto L34;
                boolean r11 = false;
            L4:
                if (r11 == true) goto L31;
                int r12 = r8.readTag();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                if (r12 == 0) goto L23;
                if (r12 != 8) goto L10;
                this.major_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                this.bitField0_ |= 1;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                goto L4
            L10:
                if (r12 != 16) goto L12;
                this.minor_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                this.bitField0_ |= 2;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                goto L4
            L12:
                if (r12 != 24) goto L14;
                this.patch_ = r8.readInt32();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                this.bitField0_ |= 4;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                goto L4
            L14:
                if (r12 != 34) goto L16;
                this.suffix_ = r8.readBytes();     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                this.bitField0_ |= 8;     // Catch: Throwable -> L24 InvalidProtocolBufferException -> L26
                goto L4
            L16:
                if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
            L23:
                r11 = true;
                goto L4
            L24:
                th = move-exception;
                onChanged();
                throw th;
            L26:
                e = move-exception;
                throw e.unwrapIOException();     // Catch: Throwable -> L24
            L31:
                onChanged();
                return this;
            L34:
                throw null;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message r8) {
                if ((r8 instanceof Version) == true) goto L5;
                super.mergeFrom(r8);
                return this;
            L5:
                return mergeFrom((Version) r8);
            }

            public Builder mergeFrom(Version r8) {
                if (r8 != Version.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r8.hasMajor() == false) goto L9;
                setMajor(r8.getMajor());
            L9:
                if (r8.hasMinor() == false) goto L12;
                setMinor(r8.getMinor());
            L12:
                if (r8.hasPatch() == false) goto L15;
                setPatch(r8.getPatch());
            L15:
                if (r8.hasSuffix() == false) goto L17;
                this.suffix_ = Version.access$800(r8);
                this.bitField0_ |= 8;
                onChanged();
            L17:
                mergeUnknownFields(r8.getUnknownFields());
                onChanged();
                return this;
            }
        }

        static {
            RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Version");
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

        public static /* synthetic */ int access$502(Version r8, int r10) {
            r8.major_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$602(Version r8, int r10) {
            r8.minor_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$702(Version r8, int r10) {
            r8.patch_ = r10;
            return r10;
        }

        public static /* synthetic */ Object access$800(Version r8) {
            return r8.suffix_;
        }

        public static /* synthetic */ Object access$802(Version r8, Object r10) {
            r8.suffix_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$976(Version r8, int r10) {
            int r11 = r10 | r8.bitField0_;
            r8.bitField0_ = r11;
            return r11;
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

        public static Version parseDelimitedFrom(InputStream r8) {
            return (Version) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
        }

        public static Version parseFrom(ByteString r8) {
            return PARSER.parseFrom(r8);
        }

        public static Parser<Version> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof Version) == false) goto L8;
            Version r10 = (Version) r8;
            if (hasMajor() == r10.hasMajor()) goto L13;
            return false;
        L13:
            if (hasMajor() == false) goto L18;
            if (getMajor() == r10.getMajor()) goto L18;
            return false;
        L18:
            if (hasMinor() == r10.hasMinor()) goto L21;
            return false;
        L21:
            if (hasMinor() == false) goto L26;
            if (getMinor() == r10.getMinor()) goto L26;
            return false;
        L26:
            if (hasPatch() == r10.hasPatch()) goto L29;
            return false;
        L29:
            if (hasPatch() == false) goto L34;
            if (getPatch() == r10.getPatch()) goto L34;
            return false;
        L34:
            if (hasSuffix() == r10.hasSuffix()) goto L37;
            return false;
        L37:
            if (hasSuffix() == false) goto L42;
            if (getSuffix().equals(r10.getSuffix()) == true) goto L42;
            return false;
        L42:
            if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L44;
            return false;
        L44:
            return true;
        L8:
            return super.equals(r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
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
            int r8 = this.memoizedSize;
            if (r8 == (-1)) goto L5;
            return r8;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) == 0) goto L9;
            r10 = 0 + CodedOutputStream.computeInt32Size(1, this.major_);
        L9:
            if ((this.bitField0_ & 2) == 0) goto L12;
            r10 = r10 + CodedOutputStream.computeInt32Size(2, this.minor_);
        L12:
            if ((this.bitField0_ & 4) == 0) goto L15;
            r10 = r10 + CodedOutputStream.computeInt32Size(3, this.patch_);
        L15:
            if ((this.bitField0_ & 8) == 0) goto L17;
            r10 = r10 + GeneratedMessage.computeStringSize(4, this.suffix_);
        L17:
            int r11 = getUnknownFields().getSerializedSize() + r10;
            this.memoizedSize = r11;
            return r11;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public String getSuffix() {
            Object r8 = this.suffix_;
            if ((r8 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r8;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.suffix_ = r11;
        L9:
            return r11;
        L5:
            return (String) r8;
        }

        @Override // com.google.protobuf.compiler.PluginProtos.VersionOrBuilder
        public ByteString getSuffixBytes() {
            Object r8 = this.suffix_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.suffix_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
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
            int r8 = this.memoizedHashCode;
            if (r8 == 0) goto L5;
            return r8;
        L5:
            int r10 = getDescriptor().hashCode() + 779;
            if (hasMajor() == false) goto L9;
            r10 = b.a(r10, 37, 1, 53) + getMajor();
        L9:
            if (hasMinor() == false) goto L12;
            r10 = b.a(r10, 37, 2, 53) + getMinor();
        L12:
            if (hasPatch() == false) goto L15;
            r10 = b.a(r10, 37, 3, 53) + getPatch();
        L15:
            if (hasSuffix() == false) goto L17;
            r10 = b.a(r10, 37, 4, 53) + getSuffix().hashCode();
        L17:
            int r11 = getUnknownFields().hashCode();
            int r12 = r11 + (r10 * 29);
            this.memoizedHashCode = r12;
            return r12;
        }

        @Override // com.google.protobuf.GeneratedMessage
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return PluginProtos.access$100().ensureFieldAccessorsInitialized(Version.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r8 = this.memoizedIsInitialized;
            if (r8 != 1) goto L5;
            return true;
        L5:
            if (r8 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return toBuilder();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream r8) {
            if ((this.bitField0_ & 1) == 0) goto L6;
            r8.writeInt32(1, this.major_);
        L6:
            if ((this.bitField0_ & 2) == 0) goto L9;
            r8.writeInt32(2, this.minor_);
        L9:
            if ((this.bitField0_ & 4) == 0) goto L12;
            r8.writeInt32(3, this.patch_);
        L12:
            if ((this.bitField0_ & 8) == 0) goto L14;
            GeneratedMessage.writeString(r8, 4, this.suffix_);
        L14:
            getUnknownFields().writeTo(r8);
        }

        private Version(GeneratedMessage.Builder<?> r8) {
            super(r8);
            this.major_ = 0;
            this.minor_ = 0;
            this.patch_ = 0;
            this.suffix_ = "";
            this.memoizedIsInitialized = -1;
        }

        public static Builder newBuilder(Version r8) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
        }

        public static Version parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (Version) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
        }

        public static Version parseFrom(ByteString r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage
        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
            return newBuilderForType(r8);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        public /* synthetic */ Version(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
            this(r8);
        }

        public static Version parseFrom(CodedInputStream r8) {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public Version getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            AnonymousClass1 r8 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r8);
        L6:
            return new Builder(r8).mergeFrom(this);
        }

        public static Version parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Version parseFrom(InputStream r8) {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, r8);
        }

        @Override // com.google.protobuf.AbstractMessage
        public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
            return new Builder(r8, null);
        }

        public static Version parseFrom(InputStream r8, ExtensionRegistryLite r10) {
            return (Version) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
        }

        public static Version parseFrom(ByteBuffer r8) {
            return PARSER.parseFrom(r8);
        }

        public static Version parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
        }

        public static Version parseFrom(byte[] r8) {
            return PARSER.parseFrom(r8);
        }

        public static Version parseFrom(byte[] r8, ExtensionRegistryLite r10) {
            return PARSER.parseFrom(r8, r10);
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
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "PluginProtos");
        descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%google/protobuf/compiler/plugin.proto\u0012\u0018google.protobuf.compiler\u001a google/protobuf/descriptor.proto\"c\n\u0007Version\u0012\u0014\n\u0005major\u0018\u0001 \u0001(\u0005R\u0005major\u0012\u0014\n\u0005minor\u0018\u0002 \u0001(\u0005R\u0005minor\u0012\u0014\n\u0005patch\u0018\u0003 \u0001(\u0005R\u0005patch\u0012\u0016\n\u0006suffix\u0018\u0004 \u0001(\tR\u0006suffix\"Ï\u0002\n\u0014CodeGeneratorRequest\u0012(\n\u0010file_to_generate\u0018\u0001 \u0003(\tR\u000efileToGenerate\u0012\u001c\n\tparameter\u0018\u0002 \u0001(\tR\tparameter\u0012C\n\nproto_file\u0018\u000f \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\tprotoFile\u0012\\\n\u0017source_file_descriptors\u0018\u0011 \u0003(\u000b2$.google.protobuf.FileDescriptorProtoR\u0015sourceFileDescriptors\u0012L\n\u0010compiler_version\u0018\u0003 \u0001(\u000b2!.google.protobuf.compiler.VersionR\u000fcompilerVersion\"\u0085\u0004\n\u0015CodeGeneratorResponse\u0012\u0014\n\u0005error\u0018\u0001 \u0001(\tR\u0005error\u0012-\n\u0012supported_features\u0018\u0002 \u0001(\u0004R\u0011supportedFeatures\u0012'\n\u000fminimum_edition\u0018\u0003 \u0001(\u0005R\u000eminimumEdition\u0012'\n\u000fmaximum_edition\u0018\u0004 \u0001(\u0005R\u000emaximumEdition\u0012H\n\u0004file\u0018\u000f \u0003(\u000b24.google.protobuf.compiler.CodeGeneratorResponse.FileR\u0004file\u001a±\u0001\n\u0004File\u0012\u0012\n\u0004name\u0018\u0001 \u0001(\tR\u0004name\u0012'\n\u000finsertion_point\u0018\u0002 \u0001(\tR\u000einsertionPoint\u0012\u0018\n\u0007content\u0018\u000f \u0001(\tR\u0007content\u0012R\n\u0013generated_code_info\u0018\u0010 \u0001(\u000b2\".google.protobuf.GeneratedCodeInfoR\u0011generatedCodeInfo\"W\n\u0007Feature\u0012\u0010\n\fFEATURE_NONE\u0010\u0000\u0012\u001b\n\u0017FEATURE_PROTO3_OPTIONAL\u0010\u0001\u0012\u001d\n\u0019FEATURE_SUPPORTS_EDITIONS\u0010\u0002Br\n\u001ccom.google.protobuf.compilerB\fPluginProtosZ)google.golang.org/protobuf/types/pluginpbª\u0002\u0018Google.Protobuf.Compiler"}, new Descriptors.FileDescriptor[]{DescriptorProtos.getDescriptor()});
        Descriptors.Descriptor r8 = getDescriptor().getMessageType(0);
        internal_static_google_protobuf_compiler_Version_descriptor = r8;
        internal_static_google_protobuf_compiler_Version_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r8, new String[]{"Major", "Minor", "Patch", "Suffix"});
        Descriptors.Descriptor r10 = getDescriptor().getMessageType(1);
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor = r10;
        internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r10, new String[]{"FileToGenerate", "Parameter", "ProtoFile", "SourceFileDescriptors", "CompilerVersion"});
        Descriptors.Descriptor r11 = getDescriptor().getMessageType(2);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor = r11;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r11, new String[]{"Error", "SupportedFeatures", "MinimumEdition", "MaximumEdition", "File"});
        Descriptors.Descriptor r12 = r11.getNestedType(0);
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor = r12;
        internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(r12, new String[]{"Name", "InsertionPoint", "Content", "GeneratedCodeInfo"});
        descriptor.resolveAllFeaturesImmutable();
        DescriptorProtos.getDescriptor();
    }

    private PluginProtos() {
    }

    public static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_google_protobuf_compiler_Version_descriptor;
    }

    public static /* synthetic */ GeneratedMessage.FieldAccessorTable access$100() {
        return internal_static_google_protobuf_compiler_Version_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$1000() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_descriptor;
    }

    public static /* synthetic */ GeneratedMessage.FieldAccessorTable access$1100() {
        return internal_static_google_protobuf_compiler_CodeGeneratorRequest_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$2400() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_descriptor;
    }

    public static /* synthetic */ GeneratedMessage.FieldAccessorTable access$2500() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$2600() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_descriptor;
    }

    public static /* synthetic */ GeneratedMessage.FieldAccessorTable access$2700() {
        return internal_static_google_protobuf_compiler_CodeGeneratorResponse_File_fieldAccessorTable;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static void registerAllExtensions(ExtensionRegistry r8) {
        registerAllExtensions(r8);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r8) {
    }
}
