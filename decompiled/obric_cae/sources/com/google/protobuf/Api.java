package com.google.protobuf;

import com.ttnet.org.chromium.net.NetError;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Api extends GeneratedMessage implements ApiOrBuilder {
    private static final Api DEFAULT_INSTANCE = null;
    public static final int EDITION_FIELD_NUMBER = 8;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;
    private static final Parser<Api> PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private static final long serialVersionUID = 0;
    private int bitField0_;
    private volatile Object edition_;
    private byte memoizedIsInitialized;
    private List<Method> methods_;
    private List<Mixin> mixins_;
    private volatile Object name_;
    private List<Option> options_;
    private SourceContext sourceContext_;
    private int syntax_;
    private volatile Object version_;

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements ApiOrBuilder {
        private int bitField0_;
        private Object edition_;
        private RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> methodsBuilder_;
        private List<Method> methods_;
        private RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> mixinsBuilder_;
        private List<Mixin> mixins_;
        private Object name_;
        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> optionsBuilder_;
        private List<Option> options_;
        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> sourceContextBuilder_;
        private SourceContext sourceContext_;
        private int syntax_;
        private Object version_;

        private Builder() {
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        private void buildPartial0(Api r8) {
            int r10 = this.bitField0_;
            if ((r10 & 1) == 0) goto L6;
            Api.access$602(r8, this.name_);
        L6:
            if ((r10 & 8) == 0) goto L9;
            Api.access$702(r8, this.version_);
        L9:
            if ((r10 & 16) == 0) goto L15;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 != null) goto L13;
            SourceContext r12 = this.sourceContext_;
        L14:
            Api.access$802(r8, r12);
            int r13 = 1;
        L17:
            if ((r10 & 64) == 0) goto L20;
            Api.access$902(r8, this.syntax_);
        L20:
            if ((r10 & 128) == 0) goto L22;
            Api.access$1002(r8, this.edition_);
        L22:
            Api.access$1176(r8, r13);
            return;
        L13:
            r12 = (SourceContext) r11.build();
            goto L14
        L15:
            r13 = 0;
            goto L17
        }

        private void buildPartialRepeatedFields(Api r8) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            Api.access$302(r8, r11);
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            Api.access$402(r8, r13);
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r14 = this.mixinsBuilder_;
            if (r14 == null) goto L19;
            List r15 = r14.build();
        L23:
            Api.access$502(r8, r15);
            return;
        L19:
            if ((this.bitField0_ & 32) == 0) goto L21;
            this.mixins_ = Collections.unmodifiableList(this.mixins_);
            this.bitField0_ &= -33;
        L21:
            r15 = this.mixins_;
            goto L23
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L14:
            r13 = this.options_;
            goto L16
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.methods_ = Collections.unmodifiableList(this.methods_);
            this.bitField0_ &= -3;
        L7:
            r11 = this.methods_;
            goto L9
        }

        private void ensureMethodsIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.methods_ = new ArrayList(this.methods_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensureMixinsIsMutable() {
            if ((this.bitField0_ & 32) != 0) goto L6;
            this.mixins_ = new ArrayList(this.mixins_);
            this.bitField0_ |= 32;
            return;
        }

        private void ensureOptionsIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 4;
            return;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        private RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> internalGetMethodsFieldBuilder() {
            if (this.methodsBuilder_ != null) goto L10;
            List<Method> r8 = this.methods_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.methodsBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
            this.methods_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.methodsBuilder_;
        }

        private RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> internalGetMixinsFieldBuilder() {
            if (this.mixinsBuilder_ != null) goto L10;
            List<Mixin> r8 = this.mixins_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.mixinsBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
            this.mixins_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.mixinsBuilder_;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r8 = this.options_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r8, r10, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.optionsBuilder_;
        }

        private SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> internalGetSourceContextFieldBuilder() {
            if (this.sourceContextBuilder_ != null) goto L6;
            this.sourceContextBuilder_ = new SingleFieldBuilder(getSourceContext(), getParentForChildren(), isClean());
            this.sourceContext_ = null;
        L6:
            return this.sourceContextBuilder_;
        }

        private void maybeForceBuilderInitialization() {
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L6;
            internalGetMethodsFieldBuilder();
            internalGetOptionsFieldBuilder();
            internalGetSourceContextFieldBuilder();
            internalGetMixinsFieldBuilder();
            return;
        }

        public Builder addAllMethods(Iterable<? extends Method> r8) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L5;
            ensureMethodsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.methods_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllMixins(Iterable<? extends Mixin> r8) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L5;
            ensureMixinsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.mixins_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllOptions(Iterable<? extends Option> r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addMethods(int r8, Method.Builder r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public Method.Builder addMethodsBuilder() {
            return (Method.Builder) internalGetMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
        }

        public Builder addMixins(int r8, Mixin.Builder r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public Mixin.Builder addMixinsBuilder() {
            return (Mixin.Builder) internalGetMixinsFieldBuilder().addBuilder(Mixin.getDefaultInstance());
        }

        public Builder addOptions(int r8, Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api build() {
            Api r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api buildPartial() {
            Api r8 = new Api(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearEdition() {
            this.edition_ = Api.getDefaultInstance().getEdition();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
            return this;
        }

        public Builder clearMethods() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r8 = this.methodsBuilder_;
            if (r8 != null) goto L5;
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearMixins() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r8 = this.mixinsBuilder_;
            if (r8 != null) goto L5;
            this.mixins_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Api.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -17;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r8 = this.sourceContextBuilder_;
            if (r8 == null) goto L5;
            r8.dispose();
            this.sourceContextBuilder_ = null;
        L5:
            onChanged();
            return this;
        }

        public Builder clearSyntax() {
            this.bitField0_ &= -65;
            this.syntax_ = 0;
            onChanged();
            return this;
        }

        public Builder clearVersion() {
            this.version_ = Api.getDefaultInstance().getVersion();
            this.bitField0_ &= -9;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public Api getDefaultInstanceForType() {
            return Api.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getEdition() {
            Object r8 = this.edition_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.edition_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getEditionBytes() {
            Object r8 = this.edition_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.edition_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Method getMethods(int r8) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.methods_.get(r8);
        L6:
            return (Method) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public Method.Builder getMethodsBuilder(int r8) {
            return (Method.Builder) internalGetMethodsFieldBuilder().getBuilder(r8);
        }

        public List<Method.Builder> getMethodsBuilderList() {
            return internalGetMethodsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r8 = this.methodsBuilder_;
            if (r8 != null) goto L7;
            return this.methods_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Method> getMethodsList() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r8 = this.methodsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.methods_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MethodOrBuilder getMethodsOrBuilder(int r8) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.methods_.get(r8);
        L6:
            return (MethodOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r8 = this.methodsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.methods_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Mixin getMixins(int r8) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.mixins_.get(r8);
        L6:
            return (Mixin) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public Mixin.Builder getMixinsBuilder(int r8) {
            return (Mixin.Builder) internalGetMixinsFieldBuilder().getBuilder(r8);
        }

        public List<Mixin.Builder> getMixinsBuilderList() {
            return internalGetMixinsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r8 = this.mixinsBuilder_;
            if (r8 != null) goto L7;
            return this.mixins_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Mixin> getMixinsList() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r8 = this.mixinsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.mixins_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MixinOrBuilder getMixinsOrBuilder(int r8) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.mixins_.get(r8);
        L6:
            return (MixinOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r8 = this.mixinsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.mixins_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getName() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.name_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getNameBytes() {
            Object r8 = this.name_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.name_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Option getOptions(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.options_.get(r8);
        L6:
            return (Option) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r8) {
            return (Option.Builder) internalGetOptionsFieldBuilder().getBuilder(r8);
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return this.options_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.options_.get(r8);
        L6:
            return (OptionOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r8 = this.optionsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r8 = this.sourceContextBuilder_;
            if (r8 != null) goto L9;
            SourceContext r10 = this.sourceContext_;
            if (r10 == null) goto L7;
            return r10;
        L7:
            return SourceContext.getDefaultInstance();
        L9:
            return (SourceContext) r8.getMessage();
        }

        public SourceContext.Builder getSourceContextBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (SourceContext.Builder) internalGetSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r8 = this.sourceContextBuilder_;
            if (r8 != null) goto L5;
            SourceContext r10 = this.sourceContext_;
            if (r10 == null) goto L9;
            return r10;
        L9:
            return SourceContext.getDefaultInstance();
        L5:
            return (SourceContextOrBuilder) r8.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Syntax getSyntax() {
            Syntax r8 = Syntax.forNumber(this.syntax_);
            if (r8 == null) goto L5;
            return r8;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getVersion() {
            Object r8 = this.version_;
            if ((r8 instanceof String) == true) goto L7;
            String r10 = ((ByteString) r8).toStringUtf8();
            this.version_ = r10;
            return r10;
        L7:
            return (String) r8;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            Object r8 = this.version_;
            if ((r8 instanceof String) == false) goto L7;
            ByteString r10 = ByteString.copyFromUtf8((String) r8);
            this.version_ = r10;
            return r10;
        L7:
            return (ByteString) r8;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public boolean hasSourceContext() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public Builder mergeSourceContext(SourceContext r8) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 == null) goto L5;
            r10.mergeFrom(r8);
        L14:
            if (this.sourceContext_ == null) goto L16;
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L11;
            if (r11 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r8);
        L11:
            this.sourceContext_ = r8;
            goto L14
        }

        public Builder removeMethods(int r8) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeMixins(int r8) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeOptions(int r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setEdition(String r8) {
            if (r8 == null) goto L6;
            this.edition_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setEditionBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.edition_ = r8;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setMethods(int r8, Method.Builder r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setMixins(int r8, Mixin.Builder r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
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
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.name_ = r8;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setOptions(int r8, Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setSourceContext(SourceContext.Builder r8) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            SourceContext r11 = r8.build();
            if (r10 != null) goto L5;
            this.sourceContext_ = r11;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r10.setMessage(r11);
            goto L6
        }

        public Builder setSyntax(Syntax r8) {
            if (r8 == null) goto L6;
            this.bitField0_ |= 64;
            this.syntax_ = r8.getNumber();
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setSyntaxValue(int r8) {
            this.syntax_ = r8;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setVersion(String r8) {
            if (r8 == null) goto L6;
            this.version_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        public Builder setVersionBytes(ByteString r8) {
            if (r8 == null) goto L6;
            AbstractMessageLite.checkByteStringIsUtf8(r8);
            this.version_ = r8;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        L6:
            throw null;
        }

        private Builder(AbstractMessage.BuilderParent r8) {
            super(r8);
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            this.edition_ = "";
            maybeForceBuilderInitialization();
        }

        public Builder addMethods(int r8, Method r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureMethodsIsMutable();
            this.methods_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public Method.Builder addMethodsBuilder(int r8) {
            return (Method.Builder) internalGetMethodsFieldBuilder().addBuilder(r8, Method.getDefaultInstance());
        }

        public Builder addMixins(int r8, Mixin r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureMixinsIsMutable();
            this.mixins_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public Mixin.Builder addMixinsBuilder(int r8) {
            return (Mixin.Builder) internalGetMixinsFieldBuilder().addBuilder(r8, Mixin.getDefaultInstance());
        }

        public Builder addOptions(int r8, Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public Option.Builder addOptionsBuilder(int r8) {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(r8, Option.getDefaultInstance());
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
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r8 = this.methodsBuilder_;
            if (r8 != null) goto L5;
            this.methods_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -5;
            this.version_ = "";
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 == null) goto L13;
            r11.dispose();
            this.sourceContextBuilder_ = null;
        L13:
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L16;
            this.mixins_ = Collections.emptyList();
        L17:
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            this.edition_ = "";
            return this;
        L16:
            this.mixins_ = null;
            r12.clear();
            goto L17
        L9:
            this.options_ = null;
            r10.clear();
            goto L10
        L5:
            this.methods_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        public Builder setMethods(int r8, Method r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureMethodsIsMutable();
            this.methods_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setMixins(int r8, Mixin r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureMixinsIsMutable();
            this.mixins_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setOptions(int r8, Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setSourceContext(SourceContext r8) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            this.sourceContext_ = r8;
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

        public /* synthetic */ Builder(AbstractMessage.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        public Builder addMethods(Method.Builder r8) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addMixins(Mixin.Builder r8) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addOptions(Option.Builder r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
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

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder addMethods(Method r8) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureMethodsIsMutable();
            this.methods_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addMixins(Mixin r8) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureMixinsIsMutable();
            this.mixins_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addOptions(Option r8) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureOptionsIsMutable();
            this.options_.add(r8);
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
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        public Builder mergeFrom(Api r8) {
            if (r8 != Api.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r8.getName().isEmpty() == true) goto L8;
            this.name_ = Api.access$600(r8);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = null;
            if (this.methodsBuilder_ != null) goto L18;
            if (Api.access$300(r8).isEmpty() == true) goto L28;
            if (this.methods_.isEmpty() == false) goto L15;
            this.methods_ = Api.access$300(r8);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureMethodsIsMutable();
            this.methods_.addAll(Api.access$300(r8));
        L28:
            if (this.optionsBuilder_ != null) goto L37;
            if (Api.access$400(r8).isEmpty() == true) goto L47;
            if (this.options_.isEmpty() == false) goto L34;
            this.options_ = Api.access$400(r8);
            this.bitField0_ &= -5;
        L35:
            onChanged();
            goto L47
        L34:
            ensureOptionsIsMutable();
            this.options_.addAll(Api.access$400(r8));
        L47:
            if (r8.getVersion().isEmpty() == true) goto L50;
            this.version_ = Api.access$700(r8);
            this.bitField0_ |= 8;
            onChanged();
        L50:
            if (r8.hasSourceContext() == false) goto L53;
            mergeSourceContext(r8.getSourceContext());
        L53:
            if (this.mixinsBuilder_ != null) goto L62;
            if (Api.access$500(r8).isEmpty() == true) goto L71;
            if (this.mixins_.isEmpty() == false) goto L59;
            this.mixins_ = Api.access$500(r8);
            this.bitField0_ &= -33;
        L60:
            onChanged();
            goto L71
        L59:
            ensureMixinsIsMutable();
            this.mixins_.addAll(Api.access$500(r8));
        L71:
            if (Api.access$900(r8) == 0) goto L74;
            setSyntaxValue(r8.getSyntaxValue());
        L74:
            if (r8.getEdition().isEmpty() == true) goto L76;
            this.edition_ = Api.access$1000(r8);
            this.bitField0_ |= 128;
            onChanged();
        L76:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L62:
            if (Api.access$500(r8).isEmpty() == true) goto L71;
            if (this.mixinsBuilder_.isEmpty() == false) goto L69;
            this.mixinsBuilder_.dispose();
            this.mixinsBuilder_ = null;
            this.mixins_ = Api.access$500(r8);
            this.bitField0_ &= -33;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L68;
            r10 = internalGetMixinsFieldBuilder();
        L68:
            this.mixinsBuilder_ = r10;
            goto L71
        L69:
            this.mixinsBuilder_.addAllMessages(Api.access$500(r8));
            goto L71
        L37:
            if (Api.access$400(r8).isEmpty() == true) goto L47;
            if (this.optionsBuilder_.isEmpty() == false) goto L45;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Api.access$400(r8);
            this.bitField0_ &= -5;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L43;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = internalGetOptionsFieldBuilder();
        L44:
            this.optionsBuilder_ = r11;
            goto L47
        L43:
            r11 = null;
            goto L44
        L45:
            this.optionsBuilder_.addAllMessages(Api.access$400(r8));
            goto L47
        L18:
            if (Api.access$300(r8).isEmpty() == true) goto L28;
            if (this.methodsBuilder_.isEmpty() == false) goto L26;
            this.methodsBuilder_.dispose();
            this.methodsBuilder_ = null;
            this.methods_ = Api.access$300(r8);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r12 = internalGetMethodsFieldBuilder();
        L25:
            this.methodsBuilder_ = r12;
            goto L28
        L24:
            r12 = null;
            goto L25
        L26:
            this.methodsBuilder_.addAllMessages(Api.access$300(r8));
            goto L28
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L54;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L51;
            int r12 = r8.readTag();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r12 == 0) goto L43;
            if (r12 != 10) goto L10;
            this.name_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 1;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L10:
            if (r12 == 18) goto L38;
            if (r12 == 26) goto L35;
            if (r12 != 34) goto L16;
            this.version_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 8;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L16:
            if (r12 != 42) goto L18;
            r8.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 16;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L18:
            if (r12 != 50) goto L20;
            MessageLite r13 = (Mixin) r8.readMessage(Mixin.parser(), r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            RepeatedFieldBuilder r14 = this.mixinsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 == null) goto L30;
        L32:
            r14.addMessage(r13);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L30:
            ensureMixinsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            List r15 = this.mixins_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
        L31:
            r15.add(r13);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L20:
            if (r12 != 56) goto L22;
            this.syntax_ = r8.readEnum();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 64;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L22:
            if (r12 != 66) goto L24;
            this.edition_ = r8.readStringRequireUtf8();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 128;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L24:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L35:
            r13 = (Option) r8.readMessage(Option.parser(), r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.optionsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L32;
            ensureOptionsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.options_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L31
        L38:
            r13 = (Method) r8.readMessage(Method.parser(), r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.methodsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L32;
            ensureMethodsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.methods_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
        L43:
            r11 = true;
            goto L4
        L44:
            th = move-exception;
            onChanged();
            throw th;
        L46:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L44
        L51:
            onChanged();
            return this;
        L54:
            throw null;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof Api) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((Api) r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 33, 4, "", "Api");
        DEFAULT_INSTANCE = new Api();
        PARSER = new AnonymousClass1();
    }

    private Api() {
        this.name_ = "";
        this.version_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.mixins_ = Collections.emptyList();
        this.syntax_ = 0;
        this.edition_ = "";
    }

    public static /* synthetic */ Object access$1000(Api r8) {
        return r8.edition_;
    }

    public static /* synthetic */ Object access$1002(Api r8, Object r10) {
        r8.edition_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$1176(Api r8, int r10) {
        int r11 = r10 | r8.bitField0_;
        r8.bitField0_ = r11;
        return r11;
    }

    public static /* synthetic */ List access$300(Api r8) {
        return r8.methods_;
    }

    public static /* synthetic */ List access$302(Api r8, List r10) {
        r8.methods_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(Api r8) {
        return r8.options_;
    }

    public static /* synthetic */ List access$402(Api r8, List r10) {
        r8.options_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$500(Api r8) {
        return r8.mixins_;
    }

    public static /* synthetic */ List access$502(Api r8, List r10) {
        r8.mixins_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$600(Api r8) {
        return r8.name_;
    }

    public static /* synthetic */ Object access$602(Api r8, Object r10) {
        r8.name_ = r10;
        return r10;
    }

    public static /* synthetic */ Object access$700(Api r8) {
        return r8.version_;
    }

    public static /* synthetic */ Object access$702(Api r8, Object r10) {
        r8.version_ = r10;
        return r10;
    }

    public static /* synthetic */ SourceContext access$802(Api r8, SourceContext r10) {
        r8.sourceContext_ = r10;
        return r10;
    }

    public static /* synthetic */ int access$900(Api r8) {
        return r8.syntax_;
    }

    public static /* synthetic */ int access$902(Api r8, int r10) {
        r8.syntax_ = r10;
        return r10;
    }

    public static Api getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Api parseDelimitedFrom(InputStream r8) {
        return (Api) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static Api parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<Api> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof Api) == false) goto L8;
        Api r10 = (Api) r8;
        if (getName().equals(r10.getName()) == true) goto L13;
        return false;
    L13:
        if (getMethodsList().equals(r10.getMethodsList()) == true) goto L16;
        return false;
    L16:
        if (getOptionsList().equals(r10.getOptionsList()) == true) goto L19;
        return false;
    L19:
        if (getVersion().equals(r10.getVersion()) == true) goto L22;
        return false;
    L22:
        if (hasSourceContext() == r10.hasSourceContext()) goto L25;
        return false;
    L25:
        if (hasSourceContext() == false) goto L30;
        if (getSourceContext().equals(r10.getSourceContext()) == true) goto L30;
        return false;
    L30:
        if (getMixinsList().equals(r10.getMixinsList()) == true) goto L33;
        return false;
    L33:
        if (this.syntax_ == r10.syntax_) goto L36;
        return false;
    L36:
        if (getEdition().equals(r10.getEdition()) == true) goto L39;
        return false;
    L39:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L41;
        return false;
    L41:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getEdition() {
        Object r8 = this.edition_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.edition_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getEditionBytes() {
        Object r8 = this.edition_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.edition_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Method getMethods(int r8) {
        return this.methods_.get(r8);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Method> getMethodsList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public MethodOrBuilder getMethodsOrBuilder(int r8) {
        return this.methods_.get(r8);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Mixin getMixins(int r8) {
        return this.mixins_.get(r8);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getMixinsCount() {
        return this.mixins_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Mixin> getMixinsList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public MixinOrBuilder getMixinsOrBuilder(int r8) {
        return this.mixins_.get(r8);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getName() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.name_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getNameBytes() {
        Object r8 = this.name_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.name_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Option getOptions(int r8) {
        return this.options_.get(r8);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<Option> getOptionsList() {
        return this.options_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public OptionOrBuilder getOptionsOrBuilder(int r8) {
        return this.options_.get(r8);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Api> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r11 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L9:
        int r12 = 0;
    L11:
        if (r12 >= this.methods_.size()) goto L13;
        r11 = r11 + CodedOutputStream.computeMessageSize(2, this.methods_.get(r12));
        r12 = r12 + 1;
        goto L11
    L13:
        int r13 = 0;
    L15:
        if (r13 >= this.options_.size()) goto L18;
        r11 = r11 + CodedOutputStream.computeMessageSize(3, this.options_.get(r13));
        r13 = r13 + 1;
        goto L15
    L18:
        if (GeneratedMessage.isStringEmpty(this.version_) == true) goto L21;
        r11 = r11 + GeneratedMessage.computeStringSize(4, this.version_);
    L21:
        if ((1 & this.bitField0_) == 0) goto L24;
        r11 = r11 + CodedOutputStream.computeMessageSize(5, getSourceContext());
    L24:
        if (r10 >= this.mixins_.size()) goto L27;
        r11 = r11 + CodedOutputStream.computeMessageSize(6, this.mixins_.get(r10));
        r10 = r10 + 1;
        goto L24
    L27:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L30;
        r11 = r11 + CodedOutputStream.computeEnumSize(7, this.syntax_);
    L30:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L32;
        r11 = r11 + GeneratedMessage.computeStringSize(8, this.edition_);
    L32:
        int r14 = getUnknownFields().getSerializedSize() + r11;
        this.memoizedSize = r14;
        return r14;
    L8:
        r11 = 0;
        goto L9
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r8 = this.sourceContext_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r8 = this.sourceContext_;
        if (r8 == null) goto L5;
        return r8;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Syntax getSyntax() {
        Syntax r8 = Syntax.forNumber(this.syntax_);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getVersion() {
        Object r8 = this.version_;
        if ((r8 instanceof String) == true) goto L5;
        String r10 = ((ByteString) r8).toStringUtf8();
        this.version_ = r10;
        return r10;
    L5:
        return (String) r8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        Object r8 = this.version_;
        if ((r8 instanceof String) == false) goto L7;
        ByteString r10 = ByteString.copyFromUtf8((String) r8);
        this.version_ = r10;
        return r10;
    L7:
        return (ByteString) r8;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public boolean hasSourceContext() {
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
        int r10 = (((getDescriptor().hashCode() + 779) * 37) + 1) * 53;
        int r11 = getName().hashCode() + r10;
        if (getMethodsCount() <= 0) goto L9;
        int r12 = defpackage.b.a(r11, 37, 2, 53);
        r11 = getMethodsList().hashCode() + r12;
    L9:
        if (getOptionsCount() <= 0) goto L11;
        int r13 = defpackage.b.a(r11, 37, 3, 53);
        r11 = getOptionsList().hashCode() + r13;
    L11:
        int r14 = defpackage.b.a(r11, 37, 4, 53);
        int r15 = getVersion().hashCode() + r14;
        if (hasSourceContext() == false) goto L15;
        int r16 = defpackage.b.a(r15, 37, 5, 53);
        r15 = getSourceContext().hashCode() + r16;
    L15:
        if (getMixinsCount() <= 0) goto L17;
        int r17 = defpackage.b.a(r15, 37, 6, 53);
        r15 = getMixinsList().hashCode() + r17;
    L17:
        int r18 = (((defpackage.b.a(r15, 37, 7, 53) + this.syntax_) * 37) + 8) * 53;
        int r19 = (getEdition().hashCode() + r18) * 29;
        int r20 = getUnknownFields().hashCode() + r19;
        this.memoizedHashCode = r20;
        return r20;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
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
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r8 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r8);
    L6:
        return new Builder(r8).mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r8, 1, this.name_);
    L5:
        int r10 = 0;
        int r11 = 0;
    L7:
        if (r11 >= this.methods_.size()) goto L9;
        r8.writeMessage(2, this.methods_.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r12 = 0;
    L11:
        if (r12 >= this.options_.size()) goto L14;
        r8.writeMessage(3, this.options_.get(r12));
        r12 = r12 + 1;
        goto L11
    L14:
        if (GeneratedMessage.isStringEmpty(this.version_) == true) goto L17;
        GeneratedMessage.writeString(r8, 4, this.version_);
    L17:
        if ((1 & this.bitField0_) == 0) goto L20;
        r8.writeMessage(5, getSourceContext());
    L20:
        if (r10 >= this.mixins_.size()) goto L23;
        r8.writeMessage(6, this.mixins_.get(r10));
        r10 = r10 + 1;
        goto L20
    L23:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L26;
        r8.writeEnum(7, this.syntax_);
    L26:
        if (GeneratedMessage.isStringEmpty(this.edition_) == true) goto L28;
        GeneratedMessage.writeString(r8, 8, this.edition_);
    L28:
        getUnknownFields().writeTo(r8);
    }

    private Api(GeneratedMessage.Builder<?> r8) {
        super(r8);
        this.name_ = "";
        this.version_ = "";
        this.syntax_ = 0;
        this.edition_ = "";
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(Api r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static Api parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Api) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static Api parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return new Builder(r8, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ Api(GeneratedMessage.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static Api parseFrom(CodedInputStream r8) {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public static Api parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    public static Api parseFrom(InputStream r8) {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    public static Api parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static Api parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static Api parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static Api parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static Api parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
