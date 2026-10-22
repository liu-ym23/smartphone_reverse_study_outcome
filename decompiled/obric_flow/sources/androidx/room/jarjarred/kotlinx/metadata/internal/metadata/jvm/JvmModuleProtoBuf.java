package androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.ProtoBuf;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ByteString;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.CodedInputStream;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.CodedOutputStream;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.InvalidProtocolBufferException;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringArrayList;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.LazyStringList;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.Parser;
import androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.ProtocolStringList;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class JvmModuleProtoBuf {

    /* JADX INFO: renamed from: androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Module extends GeneratedMessageLite implements ModuleOrBuilder {
        public static final int ANNOTATION_FIELD_NUMBER = 6;
        public static final int JVM_PACKAGE_NAME_FIELD_NUMBER = 3;
        public static final int METADATA_PARTS_FIELD_NUMBER = 2;
        public static final int OPTIONAL_ANNOTATION_CLASS_FIELD_NUMBER = 16;
        public static final int PACKAGE_PARTS_FIELD_NUMBER = 1;
        public static Parser<Module> PARSER = null;
        public static final int QUALIFIED_NAME_TABLE_FIELD_NUMBER = 5;
        public static final int STRING_TABLE_FIELD_NUMBER = 4;
        private static final Module defaultInstance = null;
        private static final long serialVersionUID = 0;
        private List<ProtoBuf.Annotation> annotation_;
        private int bitField0_;
        private LazyStringList jvmPackageName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<PackageParts> metadataParts_;
        private List<ProtoBuf.Class> optionalAnnotationClass_;
        private List<PackageParts> packageParts_;
        private ProtoBuf.QualifiedNameTable qualifiedNameTable_;
        private ProtoBuf.StringTable stringTable_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Module, Builder> implements ModuleOrBuilder {
            private List<ProtoBuf.Annotation> annotation_;
            private int bitField0_;
            private LazyStringList jvmPackageName_;
            private List<PackageParts> metadataParts_;
            private List<ProtoBuf.Class> optionalAnnotationClass_;
            private List<PackageParts> packageParts_;
            private ProtoBuf.QualifiedNameTable qualifiedNameTable_;
            private ProtoBuf.StringTable stringTable_;

            private Builder() {
                this.packageParts_ = Collections.emptyList();
                this.metadataParts_ = Collections.emptyList();
                this.jvmPackageName_ = LazyStringArrayList.EMPTY;
                this.stringTable_ = ProtoBuf.StringTable.getDefaultInstance();
                this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
                this.annotation_ = Collections.emptyList();
                this.optionalAnnotationClass_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$100() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.annotation_ = new ArrayList(this.annotation_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureJvmPackageNameIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.jvmPackageName_ = new LazyStringArrayList(this.jvmPackageName_);
                this.bitField0_ |= 4;
                return;
            }

            private void ensureMetadataPartsIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.metadataParts_ = new ArrayList(this.metadataParts_);
                this.bitField0_ |= 2;
                return;
            }

            private void ensureOptionalAnnotationClassIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.optionalAnnotationClass_ = new ArrayList(this.optionalAnnotationClass_);
                this.bitField0_ |= 64;
                return;
            }

            private void ensurePackagePartsIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.packageParts_ = new ArrayList(this.packageParts_);
                this.bitField0_ |= 1;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAllAnnotation(Iterable<? extends ProtoBuf.Annotation> r5) {
                ensureAnnotationIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.annotation_);
                return this;
            }

            public Builder addAllJvmPackageName(Iterable<String> r5) {
                ensureJvmPackageNameIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.jvmPackageName_);
                return this;
            }

            public Builder addAllMetadataParts(Iterable<? extends PackageParts> r5) {
                ensureMetadataPartsIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.metadataParts_);
                return this;
            }

            public Builder addAllOptionalAnnotationClass(Iterable<? extends ProtoBuf.Class> r5) {
                ensureOptionalAnnotationClassIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.optionalAnnotationClass_);
                return this;
            }

            public Builder addAllPackageParts(Iterable<? extends PackageParts> r5) {
                ensurePackagePartsIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.packageParts_);
                return this;
            }

            public Builder addAnnotation(ProtoBuf.Annotation r5) {
                r5.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.add(r5);
                return this;
            }

            public Builder addJvmPackageName(String r5) {
                r5.getClass();
                ensureJvmPackageNameIsMutable();
                this.jvmPackageName_.add(r5);
                return this;
            }

            public Builder addJvmPackageNameBytes(ByteString r5) {
                r5.getClass();
                ensureJvmPackageNameIsMutable();
                this.jvmPackageName_.add(r5);
                return this;
            }

            public Builder addMetadataParts(PackageParts r5) {
                r5.getClass();
                ensureMetadataPartsIsMutable();
                this.metadataParts_.add(r5);
                return this;
            }

            public Builder addOptionalAnnotationClass(ProtoBuf.Class r5) {
                r5.getClass();
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.add(r5);
                return this;
            }

            public Builder addPackageParts(PackageParts r5) {
                r5.getClass();
                ensurePackagePartsIsMutable();
                this.packageParts_.add(r5);
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
                return clear();
            }

            public Builder clearAnnotation() {
                this.annotation_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearJvmPackageName() {
                this.jvmPackageName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearMetadataParts() {
                this.metadataParts_ = Collections.emptyList();
                this.bitField0_ &= -3;
                return this;
            }

            public Builder clearOptionalAnnotationClass() {
                this.optionalAnnotationClass_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearPackageParts() {
                this.packageParts_ = Collections.emptyList();
                this.bitField0_ &= -2;
                return this;
            }

            public Builder clearQualifiedNameTable() {
                this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearStringTable() {
                this.stringTable_ = ProtoBuf.StringTable.getDefaultInstance();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtoBuf.Annotation getAnnotation(int r5) {
                return this.annotation_.get(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public List<ProtoBuf.Annotation> getAnnotationList() {
                return Collections.unmodifiableList(this.annotation_);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public String getJvmPackageName(int r5) {
                return this.jvmPackageName_.get(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ByteString getJvmPackageNameBytes(int r5) {
                return this.jvmPackageName_.getByteString(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getJvmPackageNameCount() {
                return this.jvmPackageName_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtocolStringList getJvmPackageNameList() {
                return this.jvmPackageName_.getUnmodifiableView();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public PackageParts getMetadataParts(int r5) {
                return this.metadataParts_.get(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getMetadataPartsCount() {
                return this.metadataParts_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public List<PackageParts> getMetadataPartsList() {
                return Collections.unmodifiableList(this.metadataParts_);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtoBuf.Class getOptionalAnnotationClass(int r5) {
                return this.optionalAnnotationClass_.get(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getOptionalAnnotationClassCount() {
                return this.optionalAnnotationClass_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public List<ProtoBuf.Class> getOptionalAnnotationClassList() {
                return Collections.unmodifiableList(this.optionalAnnotationClass_);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public PackageParts getPackageParts(int r5) {
                return this.packageParts_.get(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public int getPackagePartsCount() {
                return this.packageParts_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public List<PackageParts> getPackagePartsList() {
                return Collections.unmodifiableList(this.packageParts_);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtoBuf.QualifiedNameTable getQualifiedNameTable() {
                return this.qualifiedNameTable_;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public ProtoBuf.StringTable getStringTable() {
                return this.stringTable_;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public boolean hasQualifiedNameTable() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
            public boolean hasStringTable() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r5 = 0;
            L4:
                if (r5 >= getPackagePartsCount()) goto L9;
                if (getPackageParts(r5).isInitialized() == false) goto L7;
                r5 = r5 + 1;
                goto L4
            L7:
                return false;
            L9:
                int r10 = 0;
            L11:
                if (r10 >= getMetadataPartsCount()) goto L17;
                if (getMetadataParts(r10).isInitialized() == false) goto L14;
                r10 = r10 + 1;
                goto L11
            L14:
                return false;
            L17:
                if (hasQualifiedNameTable() == true) goto L19;
            L21:
                int r11 = 0;
            L23:
                if (r11 >= getAnnotationCount()) goto L28;
                if (getAnnotation(r11).isInitialized() == false) goto L26;
                r11 = r11 + 1;
                goto L23
            L26:
                return false;
            L28:
                int r12 = 0;
            L30:
                if (r12 >= getOptionalAnnotationClassCount()) goto L35;
                if (getOptionalAnnotationClass(r12).isInitialized() == false) goto L33;
                r12 = r12 + 1;
                goto L30
            L33:
                return false;
            L35:
                return true;
            L19:
                if (getQualifiedNameTable().isInitialized() == true) goto L21;
                return false;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder mergeQualifiedNameTable(ProtoBuf.QualifiedNameTable r5) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.qualifiedNameTable_ = r5;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.qualifiedNameTable_ == ProtoBuf.QualifiedNameTable.getDefaultInstance()) goto L7;
                this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.newBuilder(this.qualifiedNameTable_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder mergeStringTable(ProtoBuf.StringTable r5) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.stringTable_ = r5;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.stringTable_ == ProtoBuf.StringTable.getDefaultInstance()) goto L7;
                this.stringTable_ = ProtoBuf.StringTable.newBuilder(this.stringTable_).mergeFrom(r5).buildPartial();
                goto L8
            }

            public Builder removeAnnotation(int r5) {
                ensureAnnotationIsMutable();
                this.annotation_.remove(r5);
                return this;
            }

            public Builder removeMetadataParts(int r5) {
                ensureMetadataPartsIsMutable();
                this.metadataParts_.remove(r5);
                return this;
            }

            public Builder removeOptionalAnnotationClass(int r5) {
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.remove(r5);
                return this;
            }

            public Builder removePackageParts(int r5) {
                ensurePackagePartsIsMutable();
                this.packageParts_.remove(r5);
                return this;
            }

            public Builder setAnnotation(int r5, ProtoBuf.Annotation r10) {
                r10.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.set(r5, r10);
                return this;
            }

            public Builder setJvmPackageName(int r5, String r10) {
                r10.getClass();
                ensureJvmPackageNameIsMutable();
                this.jvmPackageName_.set(r5, r10);
                return this;
            }

            public Builder setMetadataParts(int r5, PackageParts r10) {
                r10.getClass();
                ensureMetadataPartsIsMutable();
                this.metadataParts_.set(r5, r10);
                return this;
            }

            public Builder setOptionalAnnotationClass(int r5, ProtoBuf.Class r10) {
                r10.getClass();
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.set(r5, r10);
                return this;
            }

            public Builder setPackageParts(int r5, PackageParts r10) {
                r10.getClass();
                ensurePackagePartsIsMutable();
                this.packageParts_.set(r5, r10);
                return this;
            }

            public Builder setQualifiedNameTable(ProtoBuf.QualifiedNameTable r5) {
                r5.getClass();
                this.qualifiedNameTable_ = r5;
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setStringTable(ProtoBuf.StringTable r5) {
                r5.getClass();
                this.stringTable_ = r5;
                this.bitField0_ |= 8;
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Module build() {
                Module r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Module buildPartial() {
                Module r5 = new Module(this, null);
                int r10 = this.bitField0_;
                int r11 = 1;
                if ((r10 & 1) != 1) goto L5;
                this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
                this.bitField0_ &= -2;
            L5:
                Module.access$302(r5, this.packageParts_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
                this.bitField0_ &= -3;
            L8:
                Module.access$402(r5, this.metadataParts_);
                if ((this.bitField0_ & 4) != 4) goto L11;
                this.jvmPackageName_ = this.jvmPackageName_.getUnmodifiableView();
                this.bitField0_ &= -5;
            L11:
                Module.access$502(r5, this.jvmPackageName_);
                if ((r10 & 8) == 8) goto L15;
                r11 = 0;
            L15:
                Module.access$602(r5, this.stringTable_);
                if ((r10 & 16) != 16) goto L18;
                r11 = r11 | 2;
            L18:
                Module.access$702(r5, this.qualifiedNameTable_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -33;
            L21:
                Module.access$802(r5, this.annotation_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.optionalAnnotationClass_ = Collections.unmodifiableList(this.optionalAnnotationClass_);
                this.bitField0_ &= -65;
            L24:
                Module.access$902(r5, this.optionalAnnotationClass_);
                Module.access$1002(r5, r11);
                return r5;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((Module) r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.packageParts_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.metadataParts_ = Collections.emptyList();
                int r5 = this.bitField0_;
                this.bitField0_ = r5 & (-3);
                this.jvmPackageName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ = r5 & (-7);
                this.stringTable_ = ProtoBuf.StringTable.getDefaultInstance();
                this.bitField0_ &= -9;
                this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
                this.bitField0_ &= -17;
                this.annotation_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.optionalAnnotationClass_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public Module getDefaultInstanceForType() {
                return Module.getDefaultInstance();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder addAnnotation(int r5, ProtoBuf.Annotation r10) {
                r10.getClass();
                ensureAnnotationIsMutable();
                this.annotation_.add(r5, r10);
                return this;
            }

            public Builder addMetadataParts(int r5, PackageParts r10) {
                r10.getClass();
                ensureMetadataPartsIsMutable();
                this.metadataParts_.add(r5, r10);
                return this;
            }

            public Builder addOptionalAnnotationClass(int r5, ProtoBuf.Class r10) {
                r10.getClass();
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.add(r5, r10);
                return this;
            }

            public Builder addPackageParts(int r5, PackageParts r10) {
                r10.getClass();
                ensurePackagePartsIsMutable();
                this.packageParts_.add(r5, r10);
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo76clone() throws CloneNotSupportedException {
                return clone();
            }

            public Builder mergeFrom(Module r5) {
                if (r5 != Module.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Module.access$300(r5).isEmpty() == true) goto L12;
                if (this.packageParts_.isEmpty() == false) goto L10;
                this.packageParts_ = Module.access$300(r5);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensurePackagePartsIsMutable();
                this.packageParts_.addAll(Module.access$300(r5));
            L12:
                if (Module.access$400(r5).isEmpty() == true) goto L18;
                if (this.metadataParts_.isEmpty() == false) goto L16;
                this.metadataParts_ = Module.access$400(r5);
                this.bitField0_ &= -3;
                goto L18
            L16:
                ensureMetadataPartsIsMutable();
                this.metadataParts_.addAll(Module.access$400(r5));
            L18:
                if (Module.access$500(r5).isEmpty() == true) goto L24;
                if (this.jvmPackageName_.isEmpty() == false) goto L22;
                this.jvmPackageName_ = Module.access$500(r5);
                this.bitField0_ &= -5;
                goto L24
            L22:
                ensureJvmPackageNameIsMutable();
                this.jvmPackageName_.addAll(Module.access$500(r5));
            L24:
                if (r5.hasStringTable() == false) goto L27;
                mergeStringTable(r5.getStringTable());
            L27:
                if (r5.hasQualifiedNameTable() == false) goto L30;
                mergeQualifiedNameTable(r5.getQualifiedNameTable());
            L30:
                if (Module.access$800(r5).isEmpty() == true) goto L36;
                if (this.annotation_.isEmpty() == false) goto L34;
                this.annotation_ = Module.access$800(r5);
                this.bitField0_ &= -33;
                goto L36
            L34:
                ensureAnnotationIsMutable();
                this.annotation_.addAll(Module.access$800(r5));
            L36:
                if (Module.access$900(r5).isEmpty() == false) goto L38;
            L41:
                setUnknownFields(getUnknownFields().concat(Module.access$1100(r5)));
                return this;
            L38:
                if (this.optionalAnnotationClass_.isEmpty() == false) goto L40;
                this.optionalAnnotationClass_ = Module.access$900(r5);
                this.bitField0_ &= -65;
                goto L41
            L40:
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.addAll(Module.access$900(r5));
                goto L41
            }

            public Builder setAnnotation(int r5, ProtoBuf.Annotation.Builder r10) {
                ensureAnnotationIsMutable();
                this.annotation_.set(r5, r10.build());
                return this;
            }

            public Builder setMetadataParts(int r5, PackageParts.Builder r10) {
                ensureMetadataPartsIsMutable();
                this.metadataParts_.set(r5, r10.build());
                return this;
            }

            public Builder setOptionalAnnotationClass(int r5, ProtoBuf.Class.Builder r10) {
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.set(r5, r10.build());
                return this;
            }

            public Builder setPackageParts(int r5, PackageParts.Builder r10) {
                ensurePackagePartsIsMutable();
                this.packageParts_.set(r5, r10.build());
                return this;
            }

            public Builder setQualifiedNameTable(ProtoBuf.QualifiedNameTable.Builder r5) {
                this.qualifiedNameTable_ = r5.build();
                this.bitField0_ |= 16;
                return this;
            }

            public Builder setStringTable(ProtoBuf.StringTable.Builder r5) {
                this.stringTable_ = r5.build();
                this.bitField0_ |= 8;
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            public Builder addAnnotation(ProtoBuf.Annotation.Builder r5) {
                ensureAnnotationIsMutable();
                this.annotation_.add(r5.build());
                return this;
            }

            public Builder addMetadataParts(PackageParts.Builder r5) {
                ensureMetadataPartsIsMutable();
                this.metadataParts_.add(r5.build());
                return this;
            }

            public Builder addOptionalAnnotationClass(ProtoBuf.Class.Builder r5) {
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.add(r5.build());
                return this;
            }

            public Builder addPackageParts(PackageParts.Builder r5) {
                ensurePackagePartsIsMutable();
                this.packageParts_.add(r5.build());
                return this;
            }

            public Builder addAnnotation(int r5, ProtoBuf.Annotation.Builder r10) {
                ensureAnnotationIsMutable();
                this.annotation_.add(r5, r10.build());
                return this;
            }

            public Builder addMetadataParts(int r5, PackageParts.Builder r10) {
                ensureMetadataPartsIsMutable();
                this.metadataParts_.add(r5, r10.build());
                return this;
            }

            public Builder addOptionalAnnotationClass(int r5, ProtoBuf.Class.Builder r10) {
                ensureOptionalAnnotationClassIsMutable();
                this.optionalAnnotationClass_.add(r5, r10.build());
                return this;
            }

            public Builder addPackageParts(int r5, PackageParts.Builder r10) {
                ensurePackagePartsIsMutable();
                this.packageParts_.add(r5, r10.build());
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                Module r11 = null;
                Module r12 = Module.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                Module r13 = (Module) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Module r5 = new Module(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ Module(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ int access$1002(Module r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$1100(Module r5) {
            return r5.unknownFields;
        }

        public static /* synthetic */ List access$300(Module r5) {
            return r5.packageParts_;
        }

        public static /* synthetic */ List access$302(Module r5, List r10) {
            r5.packageParts_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$400(Module r5) {
            return r5.metadataParts_;
        }

        public static /* synthetic */ List access$402(Module r5, List r10) {
            r5.metadataParts_ = r10;
            return r10;
        }

        public static /* synthetic */ LazyStringList access$500(Module r5) {
            return r5.jvmPackageName_;
        }

        public static /* synthetic */ LazyStringList access$502(Module r5, LazyStringList r10) {
            r5.jvmPackageName_ = r10;
            return r10;
        }

        public static /* synthetic */ ProtoBuf.StringTable access$602(Module r5, ProtoBuf.StringTable r10) {
            r5.stringTable_ = r10;
            return r10;
        }

        public static /* synthetic */ ProtoBuf.QualifiedNameTable access$702(Module r5, ProtoBuf.QualifiedNameTable r10) {
            r5.qualifiedNameTable_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$800(Module r5) {
            return r5.annotation_;
        }

        public static /* synthetic */ List access$802(Module r5, List r10) {
            r5.annotation_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$900(Module r5) {
            return r5.optionalAnnotationClass_;
        }

        public static /* synthetic */ List access$902(Module r5, List r10) {
            r5.optionalAnnotationClass_ = r10;
            return r10;
        }

        public static Module getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.packageParts_ = Collections.emptyList();
            this.metadataParts_ = Collections.emptyList();
            this.jvmPackageName_ = LazyStringArrayList.EMPTY;
            this.stringTable_ = ProtoBuf.StringTable.getDefaultInstance();
            this.qualifiedNameTable_ = ProtoBuf.QualifiedNameTable.getDefaultInstance();
            this.annotation_ = Collections.emptyList();
            this.optionalAnnotationClass_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$100();
        }

        public static Module parseDelimitedFrom(InputStream r5) throws IOException {
            return PARSER.parseDelimitedFrom(r5);
        }

        public static Module parseFrom(ByteString r5) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtoBuf.Annotation getAnnotation(int r5) {
            return this.annotation_.get(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public List<ProtoBuf.Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public ProtoBuf.AnnotationOrBuilder getAnnotationOrBuilder(int r5) {
            return this.annotation_.get(r5);
        }

        public List<? extends ProtoBuf.AnnotationOrBuilder> getAnnotationOrBuilderList() {
            return this.annotation_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public String getJvmPackageName(int r5) {
            return this.jvmPackageName_.get(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ByteString getJvmPackageNameBytes(int r5) {
            return this.jvmPackageName_.getByteString(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getJvmPackageNameCount() {
            return this.jvmPackageName_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtocolStringList getJvmPackageNameList() {
            return this.jvmPackageName_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public PackageParts getMetadataParts(int r5) {
            return this.metadataParts_.get(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getMetadataPartsCount() {
            return this.metadataParts_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public List<PackageParts> getMetadataPartsList() {
            return this.metadataParts_;
        }

        public PackagePartsOrBuilder getMetadataPartsOrBuilder(int r5) {
            return this.metadataParts_.get(r5);
        }

        public List<? extends PackagePartsOrBuilder> getMetadataPartsOrBuilderList() {
            return this.metadataParts_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtoBuf.Class getOptionalAnnotationClass(int r5) {
            return this.optionalAnnotationClass_.get(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getOptionalAnnotationClassCount() {
            return this.optionalAnnotationClass_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public List<ProtoBuf.Class> getOptionalAnnotationClassList() {
            return this.optionalAnnotationClass_;
        }

        public ProtoBuf.ClassOrBuilder getOptionalAnnotationClassOrBuilder(int r5) {
            return this.optionalAnnotationClass_.get(r5);
        }

        public List<? extends ProtoBuf.ClassOrBuilder> getOptionalAnnotationClassOrBuilderList() {
            return this.optionalAnnotationClass_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public PackageParts getPackageParts(int r5) {
            return this.packageParts_.get(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public int getPackagePartsCount() {
            return this.packageParts_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public List<PackageParts> getPackagePartsList() {
            return this.packageParts_;
        }

        public PackagePartsOrBuilder getPackagePartsOrBuilder(int r5) {
            return this.packageParts_.get(r5);
        }

        public List<? extends PackagePartsOrBuilder> getPackagePartsOrBuilderList() {
            return this.packageParts_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<Module> getParserForType() {
            return PARSER;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtoBuf.QualifiedNameTable getQualifiedNameTable() {
            return this.qualifiedNameTable_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            int r11 = 0;
            int r12 = 0;
        L7:
            if (r11 >= this.packageParts_.size()) goto L9;
            r12 = r12 + CodedOutputStream.computeMessageSize(1, this.packageParts_.get(r11));
            r11 = r11 + 1;
            goto L7
        L9:
            int r13 = 0;
        L11:
            if (r13 >= this.metadataParts_.size()) goto L13;
            r12 = r12 + CodedOutputStream.computeMessageSize(2, this.metadataParts_.get(r13));
            r13 = r13 + 1;
            goto L11
        L13:
            int r14 = 0;
            int r15 = 0;
        L15:
            if (r14 >= this.jvmPackageName_.size()) goto L17;
            r15 = r15 + CodedOutputStream.computeBytesSizeNoTag(this.jvmPackageName_.getByteString(r14));
            r14 = r14 + 1;
            goto L15
        L17:
            int r16 = getJvmPackageNameList().size() + (r12 + r15);
            if ((this.bitField0_ & 1) != 1) goto L21;
            r16 = r16 + CodedOutputStream.computeMessageSize(4, this.stringTable_);
        L21:
            if ((this.bitField0_ & 2) != 2) goto L23;
            r16 = r16 + CodedOutputStream.computeMessageSize(5, this.qualifiedNameTable_);
        L23:
            int r17 = 0;
        L25:
            if (r17 >= this.annotation_.size()) goto L28;
            r16 = r16 + CodedOutputStream.computeMessageSize(6, this.annotation_.get(r17));
            r17 = r17 + 1;
        L28:
            if (r10 >= this.optionalAnnotationClass_.size()) goto L30;
            r16 = r16 + CodedOutputStream.computeMessageSize(16, this.optionalAnnotationClass_.get(r10));
            r10 = r10 + 1;
            goto L28
        L30:
            int r18 = this.unknownFields.size() + r16;
            this.memoizedSerializedSize = r18;
            return r18;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public ProtoBuf.StringTable getStringTable() {
            return this.stringTable_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public boolean hasQualifiedNameTable() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.ModuleOrBuilder
        public boolean hasStringTable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L8;
            return false;
        L8:
            int r10 = 0;
        L10:
            if (r10 >= getPackagePartsCount()) goto L16;
            if (getPackageParts(r10).isInitialized() == false) goto L13;
            r10 = r10 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r11 = 0;
        L18:
            if (r11 >= getMetadataPartsCount()) goto L25;
            if (getMetadataParts(r11).isInitialized() == false) goto L21;
            r11 = r11 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (hasQualifiedNameTable() == true) goto L27;
        L30:
            int r12 = 0;
        L32:
            if (r12 >= getAnnotationCount()) goto L38;
            if (getAnnotation(r12).isInitialized() == false) goto L35;
            r12 = r12 + 1;
            goto L32
        L35:
            this.memoizedIsInitialized = 0;
            return false;
        L38:
            int r13 = 0;
        L40:
            if (r13 >= getOptionalAnnotationClassCount()) goto L46;
            if (getOptionalAnnotationClass(r13).isInitialized() == false) goto L43;
            r13 = r13 + 1;
            goto L40
        L43:
            this.memoizedIsInitialized = 0;
            return false;
        L46:
            this.memoizedIsInitialized = 1;
            return true;
        L27:
            if (getQualifiedNameTable().isInitialized() == true) goto L30;
            this.memoizedIsInitialized = 0;
            return false;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream r10) throws IOException {
            getSerializedSize();
            int r5 = 0;
            int r11 = 0;
        L4:
            if (r11 >= this.packageParts_.size()) goto L6;
            r10.writeMessage(1, this.packageParts_.get(r11));
            r11 = r11 + 1;
            goto L4
        L6:
            int r12 = 0;
        L8:
            if (r12 >= this.metadataParts_.size()) goto L10;
            r10.writeMessage(2, this.metadataParts_.get(r12));
            r12 = r12 + 1;
            goto L8
        L10:
            int r13 = 0;
        L12:
            if (r13 >= this.jvmPackageName_.size()) goto L15;
            r10.writeBytes(3, this.jvmPackageName_.getByteString(r13));
            r13 = r13 + 1;
            goto L12
        L15:
            if ((this.bitField0_ & 1) != 1) goto L18;
            r10.writeMessage(4, this.stringTable_);
        L18:
            if ((this.bitField0_ & 2) != 2) goto L20;
            r10.writeMessage(5, this.qualifiedNameTable_);
        L20:
            int r14 = 0;
        L22:
            if (r14 >= this.annotation_.size()) goto L25;
            r10.writeMessage(6, this.annotation_.get(r14));
            r14 = r14 + 1;
        L25:
            if (r5 >= this.optionalAnnotationClass_.size()) goto L27;
            r10.writeMessage(16, this.optionalAnnotationClass_.get(r5));
            r5 = r5 + 1;
            goto L25
        L27:
            r10.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ Module(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(Module r5) {
            return newBuilder().mergeFrom(r5);
        }

        public static Module parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseDelimitedFrom(r5, r10);
        }

        public static Module parseFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r5, r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public Module getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Module(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        public static Module parseFrom(byte[] r5) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r5);
        }

        public static Module parseFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r5, r10);
        }

        public static Module parseFrom(InputStream r5) throws IOException {
            return PARSER.parseFrom(r5);
        }

        public static Module parseFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseFrom(r5, r10);
        }

        private Module(boolean r5) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        public static Module parseFrom(CodedInputStream r5) throws IOException {
            return PARSER.parseFrom(r5);
        }

        public static Module parseFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseFrom(r5, r10);
        }

        private Module(CodedInputStream r13, ExtensionRegistryLite r14) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            CodedOutputStream r10 = CodedOutputStream.newInstance(r5, 1);
            boolean r11 = false;
            int r12 = 0;
        L4:
            if (r11 == true) goto L92;
            int r15 = r13.readTag();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if (r15 == 0) goto L23;
            if (r15 != 10) goto L10;
            int r16 = (r12 == true ? 1 : 0) & 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = r12;
            if (r16 == 1) goto L63;
            this.packageParts_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = (r12 == true ? 1 : 0) | 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L63:
            this.packageParts_.add((PackageParts) r13.readMessage(PackageParts.PARSER, r14));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L10:
            if (r15 != 18) goto L12;
            int r17 = (r12 == true ? 1 : 0) & 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = r12;
            if (r17 == 2) goto L59;
            this.metadataParts_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = (r12 == true ? 1 : 0) | 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L59:
            this.metadataParts_.add((PackageParts) r13.readMessage(PackageParts.PARSER, r14));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L12:
            if (r15 != 26) goto L13;
            ByteString r18 = r13.readBytes();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            int r19 = (r12 == true ? 1 : 0) & 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = r12;
            if (r19 == 4) goto L55;
            this.jvmPackageName_ = new LazyStringArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = (r12 == true ? 1 : 0) | 4;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L55:
            this.jvmPackageName_.add(r18);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L13:
            ProtoBuf.QualifiedNameTable.Builder r110 = null;
            ProtoBuf.StringTable.Builder r111 = null;
            if (r15 != 34) goto L16;
            if ((this.bitField0_ & 1) != 1) goto L48;
            r111 = this.stringTable_.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L48:
            ProtoBuf.StringTable r20 = (ProtoBuf.StringTable) r13.readMessage(ProtoBuf.StringTable.PARSER, r14);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.stringTable_ = r20;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if (r111 == null) goto L51;
            r111.mergeFrom(r20);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.stringTable_ = r111.buildPartial();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L51:
            this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L16:
            if (r15 != 42) goto L18;
            if ((this.bitField0_ & 2) != 2) goto L41;
            r110 = this.qualifiedNameTable_.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L41:
            ProtoBuf.QualifiedNameTable r21 = (ProtoBuf.QualifiedNameTable) r13.readMessage(ProtoBuf.QualifiedNameTable.PARSER, r14);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.qualifiedNameTable_ = r21;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            if (r110 == null) goto L44;
            r110.mergeFrom(r21);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            this.qualifiedNameTable_ = r110.buildPartial();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L44:
            this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L18:
            if (r15 != 50) goto L20;
            int r22 = (r12 == true ? 1 : 0) & 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = r12;
            if (r22 == 32) goto L37;
            this.annotation_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = (r12 == true ? 1 : 0) | 32;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L37:
            this.annotation_.add((ProtoBuf.Annotation) r13.readMessage(ProtoBuf.Annotation.PARSER, r14));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L20:
            if (r15 != 130) goto L22;
            int r23 = (r12 == true ? 1 : 0) & 64;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = r12;
            if (r23 == 64) goto L33;
            this.optionalAnnotationClass_ = new ArrayList();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            r12 = (r12 == true ? 1 : 0) | 64;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
        L33:
            this.optionalAnnotationClass_.add((ProtoBuf.Class) r13.readMessage(ProtoBuf.Class.PARSER, r14));     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L28
            goto L4
        L22:
            if (parseUnknownField(r13, r10, r14, r15) == true) goto L4;
        L23:
            r11 = true;
            goto L4
        L24:
            th = move-exception;
            if (((r12 == true ? 1 : 0) & 1) != 1) goto L73;
            this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
        L73:
            if (((r12 == true ? 1 : 0) & 2) != 2) goto L76;
            this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
        L76:
            if (((r12 == true ? 1 : 0) & 4) != 4) goto L79;
            this.jvmPackageName_ = this.jvmPackageName_.getUnmodifiableView();
        L79:
            if (((r12 == true ? 1 : 0) & 32) != 32) goto L82;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L82:
            if (((r12 == true ? 1 : 0) & 64) != 64) goto L117;
            this.optionalAnnotationClass_ = Collections.unmodifiableList(this.optionalAnnotationClass_);
        L117:
            r10.flush();     // Catch: IOException -> L114 Throwable -> L86
        L86:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L85:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L28:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
        L26:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
        L92:
            if (((r12 == true ? 1 : 0) & 1) != 1) goto L95;
            this.packageParts_ = Collections.unmodifiableList(this.packageParts_);
        L95:
            if (((r12 == true ? 1 : 0) & 2) != 2) goto L98;
            this.metadataParts_ = Collections.unmodifiableList(this.metadataParts_);
        L98:
            if (((r12 == true ? 1 : 0) & 4) != 4) goto L101;
            this.jvmPackageName_ = this.jvmPackageName_.getUnmodifiableView();
        L101:
            if (((r12 == true ? 1 : 0) & 32) != 32) goto L104;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L104:
            if (((r12 == true ? 1 : 0) & 64) != 64) goto L119;
            this.optionalAnnotationClass_ = Collections.unmodifiableList(this.optionalAnnotationClass_);
        L119:
            r10.flush();     // Catch: IOException -> L113 Throwable -> L108
        L108:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L107:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface ModuleOrBuilder extends MessageLiteOrBuilder {
        ProtoBuf.Annotation getAnnotation(int r5);

        int getAnnotationCount();

        List<ProtoBuf.Annotation> getAnnotationList();

        String getJvmPackageName(int r5);

        ByteString getJvmPackageNameBytes(int r5);

        int getJvmPackageNameCount();

        ProtocolStringList getJvmPackageNameList();

        PackageParts getMetadataParts(int r5);

        int getMetadataPartsCount();

        List<PackageParts> getMetadataPartsList();

        ProtoBuf.Class getOptionalAnnotationClass(int r5);

        int getOptionalAnnotationClassCount();

        List<ProtoBuf.Class> getOptionalAnnotationClassList();

        PackageParts getPackageParts(int r5);

        int getPackagePartsCount();

        List<PackageParts> getPackagePartsList();

        ProtoBuf.QualifiedNameTable getQualifiedNameTable();

        ProtoBuf.StringTable getStringTable();

        boolean hasQualifiedNameTable();

        boolean hasStringTable();
    }

    public static final class PackageParts extends GeneratedMessageLite implements PackagePartsOrBuilder {
        public static final int CLASS_WITH_JVM_PACKAGE_NAME_MULTIFILE_FACADE_SHORT_NAME_ID_FIELD_NUMBER = 7;
        public static final int CLASS_WITH_JVM_PACKAGE_NAME_PACKAGE_ID_FIELD_NUMBER = 6;
        public static final int CLASS_WITH_JVM_PACKAGE_NAME_SHORT_NAME_FIELD_NUMBER = 5;
        public static final int MULTIFILE_FACADE_SHORT_NAME_FIELD_NUMBER = 4;
        public static final int MULTIFILE_FACADE_SHORT_NAME_ID_FIELD_NUMBER = 3;
        public static final int PACKAGE_FQ_NAME_FIELD_NUMBER = 1;
        public static Parser<PackageParts> PARSER = null;
        public static final int SHORT_CLASS_NAME_FIELD_NUMBER = 2;
        private static final PackageParts defaultInstance = null;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private int classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize;
        private List<Integer> classWithJvmPackageNameMultifileFacadeShortNameId_;
        private int classWithJvmPackageNamePackageIdMemoizedSerializedSize;
        private List<Integer> classWithJvmPackageNamePackageId_;
        private LazyStringList classWithJvmPackageNameShortName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multifileFacadeShortNameIdMemoizedSerializedSize;
        private List<Integer> multifileFacadeShortNameId_;
        private LazyStringList multifileFacadeShortName_;
        private Object packageFqName_;
        private LazyStringList shortClassName_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<PackageParts, Builder> implements PackagePartsOrBuilder {
            private int bitField0_;
            private List<Integer> classWithJvmPackageNameMultifileFacadeShortNameId_;
            private List<Integer> classWithJvmPackageNamePackageId_;
            private LazyStringList classWithJvmPackageNameShortName_;
            private List<Integer> multifileFacadeShortNameId_;
            private LazyStringList multifileFacadeShortName_;
            private Object packageFqName_;
            private LazyStringList shortClassName_;

            private Builder() {
                this.packageFqName_ = "";
                LazyStringList r5 = LazyStringArrayList.EMPTY;
                this.shortClassName_ = r5;
                this.multifileFacadeShortNameId_ = Collections.emptyList();
                this.multifileFacadeShortName_ = r5;
                this.classWithJvmPackageNameShortName_ = r5;
                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
                this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$1300() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = new ArrayList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureClassWithJvmPackageNamePackageIdIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.classWithJvmPackageNamePackageId_ = new ArrayList(this.classWithJvmPackageNamePackageId_);
                this.bitField0_ |= 64;
                return;
            }

            private void ensureClassWithJvmPackageNameShortNameIsMutable() {
                if ((this.bitField0_ & 16) == 16) goto L6;
                this.classWithJvmPackageNameShortName_ = new LazyStringArrayList(this.classWithJvmPackageNameShortName_);
                this.bitField0_ |= 16;
                return;
            }

            private void ensureMultifileFacadeShortNameIdIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.multifileFacadeShortNameId_ = new ArrayList(this.multifileFacadeShortNameId_);
                this.bitField0_ |= 4;
                return;
            }

            private void ensureMultifileFacadeShortNameIsMutable() {
                if ((this.bitField0_ & 8) == 8) goto L6;
                this.multifileFacadeShortName_ = new LazyStringArrayList(this.multifileFacadeShortName_);
                this.bitField0_ |= 8;
                return;
            }

            private void ensureShortClassNameIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.shortClassName_ = new LazyStringArrayList(this.shortClassName_);
                this.bitField0_ |= 2;
                return;
            }

            private void maybeForceBuilderInitialization() {
            }

            public Builder addAllClassWithJvmPackageNameMultifileFacadeShortNameId(Iterable<? extends Integer> r5) {
                ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.classWithJvmPackageNameMultifileFacadeShortNameId_);
                return this;
            }

            public Builder addAllClassWithJvmPackageNamePackageId(Iterable<? extends Integer> r5) {
                ensureClassWithJvmPackageNamePackageIdIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.classWithJvmPackageNamePackageId_);
                return this;
            }

            public Builder addAllClassWithJvmPackageNameShortName(Iterable<String> r5) {
                ensureClassWithJvmPackageNameShortNameIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.classWithJvmPackageNameShortName_);
                return this;
            }

            public Builder addAllMultifileFacadeShortName(Iterable<String> r5) {
                ensureMultifileFacadeShortNameIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.multifileFacadeShortName_);
                return this;
            }

            public Builder addAllMultifileFacadeShortNameId(Iterable<? extends Integer> r5) {
                ensureMultifileFacadeShortNameIdIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.multifileFacadeShortNameId_);
                return this;
            }

            public Builder addAllShortClassName(Iterable<String> r5) {
                ensureShortClassNameIsMutable();
                AbstractMessageLite.Builder.addAll(r5, this.shortClassName_);
                return this;
            }

            public Builder addClassWithJvmPackageNameMultifileFacadeShortNameId(int r5) {
                ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable();
                this.classWithJvmPackageNameMultifileFacadeShortNameId_.add(Integer.valueOf(r5));
                return this;
            }

            public Builder addClassWithJvmPackageNamePackageId(int r5) {
                ensureClassWithJvmPackageNamePackageIdIsMutable();
                this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(r5));
                return this;
            }

            public Builder addClassWithJvmPackageNameShortName(String r5) {
                r5.getClass();
                ensureClassWithJvmPackageNameShortNameIsMutable();
                this.classWithJvmPackageNameShortName_.add(r5);
                return this;
            }

            public Builder addClassWithJvmPackageNameShortNameBytes(ByteString r5) {
                r5.getClass();
                ensureClassWithJvmPackageNameShortNameIsMutable();
                this.classWithJvmPackageNameShortName_.add(r5);
                return this;
            }

            public Builder addMultifileFacadeShortName(String r5) {
                r5.getClass();
                ensureMultifileFacadeShortNameIsMutable();
                this.multifileFacadeShortName_.add(r5);
                return this;
            }

            public Builder addMultifileFacadeShortNameBytes(ByteString r5) {
                r5.getClass();
                ensureMultifileFacadeShortNameIsMutable();
                this.multifileFacadeShortName_.add(r5);
                return this;
            }

            public Builder addMultifileFacadeShortNameId(int r5) {
                ensureMultifileFacadeShortNameIdIsMutable();
                this.multifileFacadeShortNameId_.add(Integer.valueOf(r5));
                return this;
            }

            public Builder addShortClassName(String r5) {
                r5.getClass();
                ensureShortClassNameIsMutable();
                this.shortClassName_.add(r5);
                return this;
            }

            public Builder addShortClassNameBytes(ByteString r5) {
                r5.getClass();
                ensureShortClassNameIsMutable();
                this.shortClassName_.add(r5);
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite buildPartial() {
                return buildPartial();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
                return clear();
            }

            public Builder clearClassWithJvmPackageNameMultifileFacadeShortNameId() {
                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
                this.bitField0_ &= -33;
                return this;
            }

            public Builder clearClassWithJvmPackageNamePackageId() {
                this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            public Builder clearClassWithJvmPackageNameShortName() {
                this.classWithJvmPackageNameShortName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -17;
                return this;
            }

            public Builder clearMultifileFacadeShortName() {
                this.multifileFacadeShortName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -9;
                return this;
            }

            public Builder clearMultifileFacadeShortNameId() {
                this.multifileFacadeShortNameId_ = Collections.emptyList();
                this.bitField0_ &= -5;
                return this;
            }

            public Builder clearPackageFqName() {
                this.bitField0_ &= -2;
                this.packageFqName_ = PackageParts.getDefaultInstance().getPackageFqName();
                return this;
            }

            public Builder clearShortClassName() {
                this.shortClassName_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -3;
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
                return clone();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNameMultifileFacadeShortNameId(int r5) {
                return this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(r5).intValue();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNameMultifileFacadeShortNameIdCount() {
                return this.classWithJvmPackageNameMultifileFacadeShortNameId_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public List<Integer> getClassWithJvmPackageNameMultifileFacadeShortNameIdList() {
                return Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNamePackageId(int r5) {
                return this.classWithJvmPackageNamePackageId_.get(r5).intValue();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNamePackageIdCount() {
                return this.classWithJvmPackageNamePackageId_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public List<Integer> getClassWithJvmPackageNamePackageIdList() {
                return Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public String getClassWithJvmPackageNameShortName(int r5) {
                return this.classWithJvmPackageNameShortName_.get(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ByteString getClassWithJvmPackageNameShortNameBytes(int r5) {
                return this.classWithJvmPackageNameShortName_.getByteString(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getClassWithJvmPackageNameShortNameCount() {
                return this.classWithJvmPackageNameShortName_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ProtocolStringList getClassWithJvmPackageNameShortNameList() {
                return this.classWithJvmPackageNameShortName_.getUnmodifiableView();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public String getMultifileFacadeShortName(int r5) {
                return this.multifileFacadeShortName_.get(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ByteString getMultifileFacadeShortNameBytes(int r5) {
                return this.multifileFacadeShortName_.getByteString(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getMultifileFacadeShortNameCount() {
                return this.multifileFacadeShortName_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getMultifileFacadeShortNameId(int r5) {
                return this.multifileFacadeShortNameId_.get(r5).intValue();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getMultifileFacadeShortNameIdCount() {
                return this.multifileFacadeShortNameId_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public List<Integer> getMultifileFacadeShortNameIdList() {
                return Collections.unmodifiableList(this.multifileFacadeShortNameId_);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ProtocolStringList getMultifileFacadeShortNameList() {
                return this.multifileFacadeShortName_.getUnmodifiableView();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public String getPackageFqName() {
                Object r5 = this.packageFqName_;
                if ((r5 instanceof String) == true) goto L9;
                ByteString r10 = (ByteString) r5;
                String r11 = r10.toStringUtf8();
                if (r10.isValidUtf8() == false) goto L7;
                this.packageFqName_ = r11;
            L7:
                return r11;
            L9:
                return (String) r5;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ByteString getPackageFqNameBytes() {
                Object r5 = this.packageFqName_;
                if ((r5 instanceof String) == false) goto L7;
                ByteString r10 = ByteString.copyFromUtf8((String) r5);
                this.packageFqName_ = r10;
                return r10;
            L7:
                return (ByteString) r5;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public String getShortClassName(int r5) {
                return this.shortClassName_.get(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ByteString getShortClassNameBytes(int r5) {
                return this.shortClassName_.getByteString(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public int getShortClassNameCount() {
                return this.shortClassName_.size();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public ProtocolStringList getShortClassNameList() {
                return this.shortClassName_.getUnmodifiableView();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
            public boolean hasPackageFqName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasPackageFqName() == true) goto L6;
                return false;
            L6:
                return true;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            public Builder setClassWithJvmPackageNameMultifileFacadeShortNameId(int r5, int r10) {
                ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable();
                this.classWithJvmPackageNameMultifileFacadeShortNameId_.set(r5, Integer.valueOf(r10));
                return this;
            }

            public Builder setClassWithJvmPackageNamePackageId(int r5, int r10) {
                ensureClassWithJvmPackageNamePackageIdIsMutable();
                this.classWithJvmPackageNamePackageId_.set(r5, Integer.valueOf(r10));
                return this;
            }

            public Builder setClassWithJvmPackageNameShortName(int r5, String r10) {
                r10.getClass();
                ensureClassWithJvmPackageNameShortNameIsMutable();
                this.classWithJvmPackageNameShortName_.set(r5, r10);
                return this;
            }

            public Builder setMultifileFacadeShortName(int r5, String r10) {
                r10.getClass();
                ensureMultifileFacadeShortNameIsMutable();
                this.multifileFacadeShortName_.set(r5, r10);
                return this;
            }

            public Builder setMultifileFacadeShortNameId(int r5, int r10) {
                ensureMultifileFacadeShortNameIdIsMutable();
                this.multifileFacadeShortNameId_.set(r5, Integer.valueOf(r10));
                return this;
            }

            public Builder setPackageFqName(String r5) {
                r5.getClass();
                this.bitField0_ |= 1;
                this.packageFqName_ = r5;
                return this;
            }

            public Builder setPackageFqNameBytes(ByteString r5) {
                r5.getClass();
                this.bitField0_ |= 1;
                this.packageFqName_ = r5;
                return this;
            }

            public Builder setShortClassName(int r5, String r10) {
                r10.getClass();
                ensureShortClassNameIsMutable();
                this.shortClassName_.set(r5, r10);
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public PackageParts build() {
                PackageParts r5 = buildPartial();
                if (r5.isInitialized() == false) goto L6;
                return r5;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public PackageParts buildPartial() {
                PackageParts r5 = new PackageParts(this, null);
                int r10 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r10 = 0;
            L6:
                PackageParts.access$1502(r5, this.packageFqName_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.shortClassName_ = this.shortClassName_.getUnmodifiableView();
                this.bitField0_ &= -3;
            L9:
                PackageParts.access$1602(r5, this.shortClassName_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
                this.bitField0_ &= -5;
            L12:
                PackageParts.access$1702(r5, this.multifileFacadeShortNameId_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.multifileFacadeShortName_ = this.multifileFacadeShortName_.getUnmodifiableView();
                this.bitField0_ &= -9;
            L15:
                PackageParts.access$1802(r5, this.multifileFacadeShortName_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.getUnmodifiableView();
                this.bitField0_ &= -17;
            L18:
                PackageParts.access$1902(r5, this.classWithJvmPackageNameShortName_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
                this.bitField0_ &= -33;
            L21:
                PackageParts.access$2002(r5, this.classWithJvmPackageNameMultifileFacadeShortNameId_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
                this.bitField0_ &= -65;
            L24:
                PackageParts.access$2102(r5, this.classWithJvmPackageNamePackageId_);
                PackageParts.access$2202(r5, r10);
                return r5;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                return clear();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r5) {
                return mergeFrom((PackageParts) r5);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clear() {
                super.clear();
                this.packageFqName_ = "";
                int r5 = this.bitField0_;
                this.bitField0_ = r5 & (-2);
                LazyStringList r10 = LazyStringArrayList.EMPTY;
                this.shortClassName_ = r10;
                this.bitField0_ = r5 & (-4);
                this.multifileFacadeShortNameId_ = Collections.emptyList();
                int r11 = this.bitField0_;
                this.multifileFacadeShortName_ = r10;
                this.classWithJvmPackageNameShortName_ = r10;
                this.bitField0_ = r11 & (-29);
                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
                this.bitField0_ &= -33;
                this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
                this.bitField0_ &= -65;
                return this;
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
                return clone();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
            public PackageParts getDefaultInstanceForType() {
                return PackageParts.getDefaultInstance();
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                return mergeFrom(r5, r10);
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ Object mo76clone() throws CloneNotSupportedException {
                return clone();
            }

            public Builder mergeFrom(PackageParts r5) {
                if (r5 != PackageParts.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r5.hasPackageFqName() == false) goto L9;
                this.bitField0_ |= 1;
                this.packageFqName_ = PackageParts.access$1500(r5);
            L9:
                if (PackageParts.access$1600(r5).isEmpty() == true) goto L15;
                if (this.shortClassName_.isEmpty() == false) goto L13;
                this.shortClassName_ = PackageParts.access$1600(r5);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureShortClassNameIsMutable();
                this.shortClassName_.addAll(PackageParts.access$1600(r5));
            L15:
                if (PackageParts.access$1700(r5).isEmpty() == true) goto L21;
                if (this.multifileFacadeShortNameId_.isEmpty() == false) goto L19;
                this.multifileFacadeShortNameId_ = PackageParts.access$1700(r5);
                this.bitField0_ &= -5;
                goto L21
            L19:
                ensureMultifileFacadeShortNameIdIsMutable();
                this.multifileFacadeShortNameId_.addAll(PackageParts.access$1700(r5));
            L21:
                if (PackageParts.access$1800(r5).isEmpty() == true) goto L27;
                if (this.multifileFacadeShortName_.isEmpty() == false) goto L25;
                this.multifileFacadeShortName_ = PackageParts.access$1800(r5);
                this.bitField0_ &= -9;
                goto L27
            L25:
                ensureMultifileFacadeShortNameIsMutable();
                this.multifileFacadeShortName_.addAll(PackageParts.access$1800(r5));
            L27:
                if (PackageParts.access$1900(r5).isEmpty() == true) goto L33;
                if (this.classWithJvmPackageNameShortName_.isEmpty() == false) goto L31;
                this.classWithJvmPackageNameShortName_ = PackageParts.access$1900(r5);
                this.bitField0_ &= -17;
                goto L33
            L31:
                ensureClassWithJvmPackageNameShortNameIsMutable();
                this.classWithJvmPackageNameShortName_.addAll(PackageParts.access$1900(r5));
            L33:
                if (PackageParts.access$2000(r5).isEmpty() == true) goto L39;
                if (this.classWithJvmPackageNameMultifileFacadeShortNameId_.isEmpty() == false) goto L37;
                this.classWithJvmPackageNameMultifileFacadeShortNameId_ = PackageParts.access$2000(r5);
                this.bitField0_ &= -33;
                goto L39
            L37:
                ensureClassWithJvmPackageNameMultifileFacadeShortNameIdIsMutable();
                this.classWithJvmPackageNameMultifileFacadeShortNameId_.addAll(PackageParts.access$2000(r5));
            L39:
                if (PackageParts.access$2100(r5).isEmpty() == false) goto L41;
            L44:
                setUnknownFields(getUnknownFields().concat(PackageParts.access$2300(r5)));
                return this;
            L41:
                if (this.classWithJvmPackageNamePackageId_.isEmpty() == false) goto L43;
                this.classWithJvmPackageNamePackageId_ = PackageParts.access$2100(r5);
                this.bitField0_ &= -65;
                goto L44
            L43:
                ensureClassWithJvmPackageNamePackageIdIsMutable();
                this.classWithJvmPackageNamePackageId_.addAll(PackageParts.access$2100(r5));
                goto L44
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.AbstractMessageLite.Builder, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
                PackageParts r11 = null;
                PackageParts r12 = PackageParts.PARSER.parsePartialFrom(r5, r10);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r12 == null) goto L6;
                mergeFrom(r12);
            L6:
                return this;
            L9:
                e = move-exception;
                PackageParts r13 = (PackageParts) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r11 = r13;
            L14:
                if (r11 == null) goto L16;
                mergeFrom(r11);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }
        }

        static {
            PARSER = new AnonymousClass1();
            PackageParts r5 = new PackageParts(true);
            defaultInstance = r5;
            r5.initFields();
        }

        public /* synthetic */ PackageParts(CodedInputStream r5, ExtensionRegistryLite r10, AnonymousClass1 r11) throws InvalidProtocolBufferException {
            this(r5, r10);
        }

        public static /* synthetic */ Object access$1500(PackageParts r5) {
            return r5.packageFqName_;
        }

        public static /* synthetic */ Object access$1502(PackageParts r5, Object r10) {
            r5.packageFqName_ = r10;
            return r10;
        }

        public static /* synthetic */ LazyStringList access$1600(PackageParts r5) {
            return r5.shortClassName_;
        }

        public static /* synthetic */ LazyStringList access$1602(PackageParts r5, LazyStringList r10) {
            r5.shortClassName_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$1700(PackageParts r5) {
            return r5.multifileFacadeShortNameId_;
        }

        public static /* synthetic */ List access$1702(PackageParts r5, List r10) {
            r5.multifileFacadeShortNameId_ = r10;
            return r10;
        }

        public static /* synthetic */ LazyStringList access$1800(PackageParts r5) {
            return r5.multifileFacadeShortName_;
        }

        public static /* synthetic */ LazyStringList access$1802(PackageParts r5, LazyStringList r10) {
            r5.multifileFacadeShortName_ = r10;
            return r10;
        }

        public static /* synthetic */ LazyStringList access$1900(PackageParts r5) {
            return r5.classWithJvmPackageNameShortName_;
        }

        public static /* synthetic */ LazyStringList access$1902(PackageParts r5, LazyStringList r10) {
            r5.classWithJvmPackageNameShortName_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$2000(PackageParts r5) {
            return r5.classWithJvmPackageNameMultifileFacadeShortNameId_;
        }

        public static /* synthetic */ List access$2002(PackageParts r5, List r10) {
            r5.classWithJvmPackageNameMultifileFacadeShortNameId_ = r10;
            return r10;
        }

        public static /* synthetic */ List access$2100(PackageParts r5) {
            return r5.classWithJvmPackageNamePackageId_;
        }

        public static /* synthetic */ List access$2102(PackageParts r5, List r10) {
            r5.classWithJvmPackageNamePackageId_ = r10;
            return r10;
        }

        public static /* synthetic */ int access$2202(PackageParts r5, int r10) {
            r5.bitField0_ = r10;
            return r10;
        }

        public static /* synthetic */ ByteString access$2300(PackageParts r5) {
            return r5.unknownFields;
        }

        public static PackageParts getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.packageFqName_ = "";
            LazyStringList r5 = LazyStringArrayList.EMPTY;
            this.shortClassName_ = r5;
            this.multifileFacadeShortNameId_ = Collections.emptyList();
            this.multifileFacadeShortName_ = r5;
            this.classWithJvmPackageNameShortName_ = r5;
            this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.emptyList();
            this.classWithJvmPackageNamePackageId_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$1300();
        }

        public static PackageParts parseDelimitedFrom(InputStream r5) throws IOException {
            return PARSER.parseDelimitedFrom(r5);
        }

        public static PackageParts parseFrom(ByteString r5) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNameMultifileFacadeShortNameId(int r5) {
            return this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(r5).intValue();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNameMultifileFacadeShortNameIdCount() {
            return this.classWithJvmPackageNameMultifileFacadeShortNameId_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public List<Integer> getClassWithJvmPackageNameMultifileFacadeShortNameIdList() {
            return this.classWithJvmPackageNameMultifileFacadeShortNameId_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNamePackageId(int r5) {
            return this.classWithJvmPackageNamePackageId_.get(r5).intValue();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNamePackageIdCount() {
            return this.classWithJvmPackageNamePackageId_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public List<Integer> getClassWithJvmPackageNamePackageIdList() {
            return this.classWithJvmPackageNamePackageId_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public String getClassWithJvmPackageNameShortName(int r5) {
            return this.classWithJvmPackageNameShortName_.get(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ByteString getClassWithJvmPackageNameShortNameBytes(int r5) {
            return this.classWithJvmPackageNameShortName_.getByteString(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getClassWithJvmPackageNameShortNameCount() {
            return this.classWithJvmPackageNameShortName_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ProtocolStringList getClassWithJvmPackageNameShortNameList() {
            return this.classWithJvmPackageNameShortName_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public String getMultifileFacadeShortName(int r5) {
            return this.multifileFacadeShortName_.get(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ByteString getMultifileFacadeShortNameBytes(int r5) {
            return this.multifileFacadeShortName_.getByteString(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getMultifileFacadeShortNameCount() {
            return this.multifileFacadeShortName_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getMultifileFacadeShortNameId(int r5) {
            return this.multifileFacadeShortNameId_.get(r5).intValue();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getMultifileFacadeShortNameIdCount() {
            return this.multifileFacadeShortNameId_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public List<Integer> getMultifileFacadeShortNameIdList() {
            return this.multifileFacadeShortNameId_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ProtocolStringList getMultifileFacadeShortNameList() {
            return this.multifileFacadeShortName_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public String getPackageFqName() {
            Object r5 = this.packageFqName_;
            if ((r5 instanceof String) == true) goto L5;
            ByteString r10 = (ByteString) r5;
            String r11 = r10.toStringUtf8();
            if (r10.isValidUtf8() == false) goto L9;
            this.packageFqName_ = r11;
        L9:
            return r11;
        L5:
            return (String) r5;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ByteString getPackageFqNameBytes() {
            Object r5 = this.packageFqName_;
            if ((r5 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r5);
            this.packageFqName_ = r10;
            return r10;
        L7:
            return (ByteString) r5;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite, androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public Parser<PackageParts> getParserForType() {
            return PARSER;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public int getSerializedSize() {
            int r5 = this.memoizedSerializedSize;
            if (r5 == (-1)) goto L5;
            return r5;
        L5:
            int r10 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r11 = CodedOutputStream.computeBytesSize(1, getPackageFqNameBytes());
        L9:
            int r12 = 0;
            int r13 = 0;
        L11:
            if (r12 >= this.shortClassName_.size()) goto L13;
            r13 = r13 + CodedOutputStream.computeBytesSizeNoTag(this.shortClassName_.getByteString(r12));
            r12 = r12 + 1;
            goto L11
        L13:
            int r14 = getShortClassNameList().size() + (r11 + r13);
            int r15 = 0;
            int r16 = 0;
        L15:
            if (r15 >= this.multifileFacadeShortNameId_.size()) goto L17;
            r16 = a.d(r16, this.multifileFacadeShortNameId_.get(r15));
            r15 = r15 + 1;
            goto L15
        L17:
            int r17 = r14 + r16;
            if (getMultifileFacadeShortNameIdList().isEmpty() == true) goto L20;
            r17 = (r17 + 1) + CodedOutputStream.computeInt32SizeNoTag(r16);
        L20:
            this.multifileFacadeShortNameIdMemoizedSerializedSize = r16;
            int r18 = 0;
            int r19 = 0;
        L22:
            if (r18 >= this.multifileFacadeShortName_.size()) goto L24;
            r19 = r19 + CodedOutputStream.computeBytesSizeNoTag(this.multifileFacadeShortName_.getByteString(r18));
            r18 = r18 + 1;
            goto L22
        L24:
            int r20 = getMultifileFacadeShortNameList().size() + (r17 + r19);
            int r21 = 0;
            int r22 = 0;
        L26:
            if (r21 >= this.classWithJvmPackageNameShortName_.size()) goto L28;
            r22 = r22 + CodedOutputStream.computeBytesSizeNoTag(this.classWithJvmPackageNameShortName_.getByteString(r21));
            r21 = r21 + 1;
            goto L26
        L28:
            int r23 = getClassWithJvmPackageNameShortNameList().size() + (r20 + r22);
            int r24 = 0;
            int r25 = 0;
        L30:
            if (r24 >= this.classWithJvmPackageNamePackageId_.size()) goto L32;
            r25 = a.d(r25, this.classWithJvmPackageNamePackageId_.get(r24));
            r24 = r24 + 1;
            goto L30
        L32:
            int r26 = r23 + r25;
            if (getClassWithJvmPackageNamePackageIdList().isEmpty() == true) goto L35;
            r26 = (r26 + 1) + CodedOutputStream.computeInt32SizeNoTag(r25);
        L35:
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = r25;
            int r27 = 0;
        L37:
            if (r10 >= this.classWithJvmPackageNameMultifileFacadeShortNameId_.size()) goto L39;
            r27 = a.d(r27, this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(r10));
            r10 = r10 + 1;
            goto L37
        L39:
            int r28 = r26 + r27;
            if (getClassWithJvmPackageNameMultifileFacadeShortNameIdList().isEmpty() == true) goto L42;
            r28 = (r28 + 1) + CodedOutputStream.computeInt32SizeNoTag(r27);
        L42:
            this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = r27;
            int r29 = this.unknownFields.size() + r28;
            this.memoizedSerializedSize = r29;
            return r29;
        L8:
            r11 = 0;
            goto L9
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public String getShortClassName(int r5) {
            return this.shortClassName_.get(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ByteString getShortClassNameBytes(int r5) {
            return this.shortClassName_.getByteString(r5);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public int getShortClassNameCount() {
            return this.shortClassName_.size();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public ProtocolStringList getShortClassNameList() {
            return this.shortClassName_;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.JvmModuleProtoBuf.PackagePartsOrBuilder
        public boolean hasPackageFqName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r5 = this.memoizedIsInitialized;
            if (r5 != 1) goto L6;
            return true;
        L6:
            if (r5 != 0) goto L9;
            return false;
        L9:
            if (hasPackageFqName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public void writeTo(CodedOutputStream r5) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r5.writeBytes(1, getPackageFqNameBytes());
        L5:
            int r10 = 0;
            int r11 = 0;
        L7:
            if (r11 >= this.shortClassName_.size()) goto L10;
            r5.writeBytes(2, this.shortClassName_.getByteString(r11));
            r11 = r11 + 1;
            goto L7
        L10:
            if (getMultifileFacadeShortNameIdList().size() <= 0) goto L12;
            r5.writeRawVarint32(26);
            r5.writeRawVarint32(this.multifileFacadeShortNameIdMemoizedSerializedSize);
        L12:
            int r12 = 0;
        L14:
            if (r12 >= this.multifileFacadeShortNameId_.size()) goto L16;
            r5.writeInt32NoTag(this.multifileFacadeShortNameId_.get(r12).intValue());
            r12 = r12 + 1;
            goto L14
        L16:
            int r13 = 0;
        L18:
            if (r13 >= this.multifileFacadeShortName_.size()) goto L20;
            r5.writeBytes(4, this.multifileFacadeShortName_.getByteString(r13));
            r13 = r13 + 1;
            goto L18
        L20:
            int r14 = 0;
        L22:
            if (r14 >= this.classWithJvmPackageNameShortName_.size()) goto L25;
            r5.writeBytes(5, this.classWithJvmPackageNameShortName_.getByteString(r14));
            r14 = r14 + 1;
            goto L22
        L25:
            if (getClassWithJvmPackageNamePackageIdList().size() <= 0) goto L27;
            r5.writeRawVarint32(50);
            r5.writeRawVarint32(this.classWithJvmPackageNamePackageIdMemoizedSerializedSize);
        L27:
            int r15 = 0;
        L29:
            if (r15 >= this.classWithJvmPackageNamePackageId_.size()) goto L32;
            r5.writeInt32NoTag(this.classWithJvmPackageNamePackageId_.get(r15).intValue());
            r15 = r15 + 1;
            goto L29
        L32:
            if (getClassWithJvmPackageNameMultifileFacadeShortNameIdList().size() <= 0) goto L35;
            r5.writeRawVarint32(58);
            r5.writeRawVarint32(this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize);
        L35:
            if (r10 >= this.classWithJvmPackageNameMultifileFacadeShortNameId_.size()) goto L37;
            r5.writeInt32NoTag(this.classWithJvmPackageNameMultifileFacadeShortNameId_.get(r10).intValue());
            r10 = r10 + 1;
            goto L35
        L37:
            r5.writeRawBytes(this.unknownFields);
        }

        public /* synthetic */ PackageParts(GeneratedMessageLite.Builder r5, AnonymousClass1 r10) {
            this(r5);
        }

        public static Builder newBuilder(PackageParts r5) {
            return newBuilder().mergeFrom(r5);
        }

        public static PackageParts parseDelimitedFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseDelimitedFrom(r5, r10);
        }

        public static PackageParts parseFrom(ByteString r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r5, r10);
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLiteOrBuilder
        public PackageParts getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // androidx.room.jarjarred.kotlinx.metadata.internal.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private PackageParts(GeneratedMessageLite.Builder r5) {
            super(r5);
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r5.getUnknownFields();
        }

        public static PackageParts parseFrom(byte[] r5) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r5);
        }

        public static PackageParts parseFrom(byte[] r5, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(r5, r10);
        }

        public static PackageParts parseFrom(InputStream r5) throws IOException {
            return PARSER.parseFrom(r5);
        }

        public static PackageParts parseFrom(InputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseFrom(r5, r10);
        }

        public static PackageParts parseFrom(CodedInputStream r5) throws IOException {
            return PARSER.parseFrom(r5);
        }

        public static PackageParts parseFrom(CodedInputStream r5, ExtensionRegistryLite r10) throws IOException {
            return PARSER.parseFrom(r5, r10);
        }

        private PackageParts(boolean r5) {
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private PackageParts(CodedInputStream r18, ExtensionRegistryLite r19) throws InvalidProtocolBufferException {
            this.multifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNameMultifileFacadeShortNameIdMemoizedSerializedSize = -1;
            this.classWithJvmPackageNamePackageIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r5 = ByteString.newOutput();
            boolean r10 = true;
            CodedOutputStream r11 = CodedOutputStream.newInstance(r5, 1);
            boolean r12 = false;
            int r13 = 0;
        L4:
            if (r12 == true) goto L103;
            int r14 = r18.readTag();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            switch(r14) {
                case 0: goto L71;
                case 10: goto L69;
                case 18: goto L65;
                case 24: goto L62;
                case 26: goto L52;
                case 34: goto L48;
                case 42: goto L44;
                case 48: goto L41;
                case 50: goto L31;
                case 56: goto L28;
                case 58: goto L17;
                default: goto L8;
            };     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L17:
            int r15 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r13 & 32) == 32) goto L23;
            if (r18.getBytesUntilLimit() <= 0) goto L23;
            this.classWithJvmPackageNameMultifileFacadeShortNameId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L23:
            if (r18.getBytesUntilLimit() <= 0) goto L25;
            this.classWithJvmPackageNameMultifileFacadeShortNameId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L23
        L25:
            r18.popLimit(r15);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L26:
            boolean r16 = true;
        L72:
            r10 = r16;
            goto L4
        L31:
            int r17 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r13 & 64) == 64) goto L37;
            if (r18.getBytesUntilLimit() <= 0) goto L37;
            this.classWithJvmPackageNamePackageId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L37:
            if (r18.getBytesUntilLimit() <= 0) goto L39;
            this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L37
        L39:
            r18.popLimit(r17);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L26
        L44:
            ByteString r20 = r18.readBytes();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r13 & 16) == 16) goto L47;
            this.classWithJvmPackageNameShortName_ = new LazyStringArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 16;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L47:
            this.classWithJvmPackageNameShortName_.add(r20);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L26
        L48:
            ByteString r21 = r18.readBytes();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r13 & 8) == 8) goto L51;
            this.multifileFacadeShortName_ = new LazyStringArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 8;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L51:
            this.multifileFacadeShortName_.add(r21);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L26
        L52:
            int r22 = r18.pushLimit(r18.readRawVarint32());     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r13 & 4) == 4) goto L58;
            if (r18.getBytesUntilLimit() <= 0) goto L58;
            this.multifileFacadeShortNameId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 4;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L58:
            if (r18.getBytesUntilLimit() <= 0) goto L60;
            this.multifileFacadeShortNameId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L58
        L60:
            r18.popLimit(r22);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L26
        L65:
            ByteString r23 = r18.readBytes();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            if ((r13 & 2) == 2) goto L68;
            this.shortClassName_ = new LazyStringArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 2;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L68:
            this.shortClassName_.add(r23);     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L26
        L69:
            ByteString r24 = r18.readBytes();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r16 = true;
            this.bitField0_ |= 1;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            this.packageFqName_ = r24;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L72
        L71:
            r16 = r10;
            r12 = r16;
            goto L72
        L8:
            if (parseUnknownField(r18, r11, r19, r14) == true) goto L10;
            r12 = r10;
            r16 = r12;
            goto L72
        L10:
            r16 = r10;
            goto L72
        L28:
            if ((r13 & 32) == 32) goto L30;
            this.classWithJvmPackageNameMultifileFacadeShortNameId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 32;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L30:
            this.classWithJvmPackageNameMultifileFacadeShortNameId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L26
        L41:
            if ((r13 & 64) == 64) goto L43;
            this.classWithJvmPackageNamePackageId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 64;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L43:
            this.classWithJvmPackageNamePackageId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L26
        L62:
            if ((r13 & 4) == 4) goto L64;
            this.multifileFacadeShortNameId_ = new ArrayList();     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            r13 = r13 | 4;     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
        L64:
            this.multifileFacadeShortNameId_.add(Integer.valueOf(r18.readInt32()));     // Catch: Throwable -> L11 IOException -> L13 InvalidProtocolBufferException -> L15
            goto L26
        L11:
            th = move-exception;
            if ((r13 & 2) != 2) goto L81;
            this.shortClassName_ = this.shortClassName_.getUnmodifiableView();
        L81:
            if ((r13 & 4) != 4) goto L84;
            this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
        L84:
            if ((r13 & 8) != 8) goto L87;
            this.multifileFacadeShortName_ = this.multifileFacadeShortName_.getUnmodifiableView();
        L87:
            if ((r13 & 16) != 16) goto L90;
            this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.getUnmodifiableView();
        L90:
            if ((r13 & 64) != 64) goto L93;
            this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
        L93:
            if ((r13 & 32) != 32) goto L133;
            this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
        L133:
            r11.flush();     // Catch: IOException -> L128 Throwable -> L97
        L97:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L96:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
            throw th;
        L13:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L15:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L11
        L103:
            if ((r13 & 2) != 2) goto L106;
            this.shortClassName_ = this.shortClassName_.getUnmodifiableView();
        L106:
            if ((r13 & 4) != 4) goto L109;
            this.multifileFacadeShortNameId_ = Collections.unmodifiableList(this.multifileFacadeShortNameId_);
        L109:
            if ((r13 & 8) != 8) goto L112;
            this.multifileFacadeShortName_ = this.multifileFacadeShortName_.getUnmodifiableView();
        L112:
            if ((r13 & 16) != 16) goto L115;
            this.classWithJvmPackageNameShortName_ = this.classWithJvmPackageNameShortName_.getUnmodifiableView();
        L115:
            if ((r13 & 64) != 64) goto L118;
            this.classWithJvmPackageNamePackageId_ = Collections.unmodifiableList(this.classWithJvmPackageNamePackageId_);
        L118:
            if ((r13 & 32) != 32) goto L131;
            this.classWithJvmPackageNameMultifileFacadeShortNameId_ = Collections.unmodifiableList(this.classWithJvmPackageNameMultifileFacadeShortNameId_);
        L131:
            r11.flush();     // Catch: IOException -> L127 Throwable -> L122
        L122:
            th = move-exception;
            this.unknownFields = r5.toByteString();
            throw th;
        L121:
            this.unknownFields = r5.toByteString();
            makeExtensionsImmutable();
        }
    }

    public interface PackagePartsOrBuilder extends MessageLiteOrBuilder {
        int getClassWithJvmPackageNameMultifileFacadeShortNameId(int r5);

        int getClassWithJvmPackageNameMultifileFacadeShortNameIdCount();

        List<Integer> getClassWithJvmPackageNameMultifileFacadeShortNameIdList();

        int getClassWithJvmPackageNamePackageId(int r5);

        int getClassWithJvmPackageNamePackageIdCount();

        List<Integer> getClassWithJvmPackageNamePackageIdList();

        String getClassWithJvmPackageNameShortName(int r5);

        ByteString getClassWithJvmPackageNameShortNameBytes(int r5);

        int getClassWithJvmPackageNameShortNameCount();

        ProtocolStringList getClassWithJvmPackageNameShortNameList();

        String getMultifileFacadeShortName(int r5);

        ByteString getMultifileFacadeShortNameBytes(int r5);

        int getMultifileFacadeShortNameCount();

        int getMultifileFacadeShortNameId(int r5);

        int getMultifileFacadeShortNameIdCount();

        List<Integer> getMultifileFacadeShortNameIdList();

        ProtocolStringList getMultifileFacadeShortNameList();

        String getPackageFqName();

        ByteString getPackageFqNameBytes();

        String getShortClassName(int r5);

        ByteString getShortClassNameBytes(int r5);

        int getShortClassNameCount();

        ProtocolStringList getShortClassNameList();

        boolean hasPackageFqName();
    }

    private JvmModuleProtoBuf() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r5) {
    }
}
