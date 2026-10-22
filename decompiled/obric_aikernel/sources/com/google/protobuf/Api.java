package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Api extends GeneratedMessage implements ApiOrBuilder {
    private static final Api DEFAULT_INSTANCE = null;
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
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent r10) {
            super(r10);
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* synthetic */ Builder(AnonymousClass1 r10) {
            this();
        }

        private void buildPartial0(Api r10) {
            int r11 = this.bitField0_;
            if ((r11 & 1) == 0) goto L6;
            Api.access$602(r10, this.name_);
        L6:
            if ((r11 & 8) == 0) goto L8;
            Api.access$702(r10, this.version_);
        L8:
            int r12 = 0;
            if ((r11 & 16) == 0) goto L16;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r13 = this.sourceContextBuilder_;
            if (r13 != null) goto L13;
            SourceContext r14 = this.sourceContext_;
        L14:
            Api.access$802(r10, r14);
            r12 = 1;
            goto L16
        L13:
            r14 = (SourceContext) r13.build();
        L16:
            if ((r11 & 64) == 0) goto L18;
            Api.access$902(r10, this.syntax_);
        L18:
            Api.access$1076(r10, r12);
        }

        private void buildPartialRepeatedFields(Api r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 == null) goto L5;
            List r12 = r11.build();
        L9:
            Api.access$302(r10, r12);
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r13 = this.optionsBuilder_;
            if (r13 == null) goto L12;
            List r14 = r13.build();
        L16:
            Api.access$402(r10, r14);
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r15 = this.mixinsBuilder_;
            if (r15 == null) goto L19;
            List r16 = r15.build();
        L23:
            Api.access$502(r10, r16);
            return;
        L19:
            if ((this.bitField0_ & 32) == 0) goto L21;
            this.mixins_ = Collections.unmodifiableList(this.mixins_);
            this.bitField0_ &= -33;
        L21:
            r16 = this.mixins_;
            goto L23
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L14:
            r14 = this.options_;
            goto L16
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.methods_ = Collections.unmodifiableList(this.methods_);
            this.bitField0_ &= -3;
        L7:
            r12 = this.methods_;
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
            List<Method> r10 = this.methods_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.methodsBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.methods_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.methodsBuilder_;
        }

        private RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> internalGetMixinsFieldBuilder() {
            if (this.mixinsBuilder_ != null) goto L10;
            List<Mixin> r10 = this.mixins_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.mixinsBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.mixins_ = null;
            goto L10
        L7:
            r11 = false;
        L10:
            return this.mixinsBuilder_;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r10 = this.options_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r11 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r10, r11, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r11 = false;
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

        public Builder addAllMethods(Iterable<? extends Method> r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            ensureMethodsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.methods_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addAllMixins(Iterable<? extends Mixin> r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            ensureMixinsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.mixins_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addAllOptions(Iterable<? extends Option> r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r10, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r11.addAllMessages(r10);
            goto L6
        }

        public Builder addMethods(int r10, Method.Builder r11) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r12 = this.methodsBuilder_;
            if (r12 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addMethods(int r10, Method r11) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r12 = this.methodsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureMethodsIsMutable();
            this.methods_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addMethods(Method.Builder r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addMethods(Method r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            ensureMethodsIsMutable();
            this.methods_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public Method.Builder addMethodsBuilder() {
            return (Method.Builder) internalGetMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
        }

        public Method.Builder addMethodsBuilder(int r10) {
            return (Method.Builder) internalGetMethodsFieldBuilder().addBuilder(r10, Method.getDefaultInstance());
        }

        public Builder addMixins(int r10, Mixin.Builder r11) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addMixins(int r10, Mixin r11) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureMixinsIsMutable();
            this.mixins_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addMixins(Mixin.Builder r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addMixins(Mixin r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            ensureMixinsIsMutable();
            this.mixins_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public Mixin.Builder addMixinsBuilder() {
            return (Mixin.Builder) internalGetMixinsFieldBuilder().addBuilder(Mixin.getDefaultInstance());
        }

        public Mixin.Builder addMixinsBuilder(int r10) {
            return (Mixin.Builder) internalGetMixinsFieldBuilder().addBuilder(r10, Mixin.getDefaultInstance());
        }

        public Builder addOptions(int r10, Option.Builder r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11.build());
            goto L6
        }

        public Builder addOptions(int r10, Option r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureOptionsIsMutable();
            this.options_.add(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.addMessage(r10, r11);
            goto L6
        }

        public Builder addOptions(Option.Builder r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10.build());
            goto L6
        }

        public Builder addOptions(Option r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            ensureOptionsIsMutable();
            this.options_.add(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r10);
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
        }

        public Option.Builder addOptionsBuilder(int r10) {
            return (Option.Builder) internalGetOptionsFieldBuilder().addBuilder(r10, Option.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api build() {
            Api r10 = buildPartial();
            if (r10.isInitialized() == false) goto L6;
            return r10;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r10);
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
        public Api buildPartial() {
            Api r10 = new Api(this, null);
            buildPartialRepeatedFields(r10);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r10);
        L5:
            onBuilt();
            return r10;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.name_ = "";
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L5;
            this.methods_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -5;
            this.version_ = "";
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r12 = this.sourceContextBuilder_;
            if (r12 == null) goto L13;
            r12.dispose();
            this.sourceContextBuilder_ = null;
        L13:
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r13 = this.mixinsBuilder_;
            if (r13 != null) goto L16;
            this.mixins_ = Collections.emptyList();
        L17:
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            return this;
        L16:
            this.mixins_ = null;
            r13.clear();
            goto L17
        L9:
            this.options_ = null;
            r11.clear();
            goto L10
        L5:
            this.methods_ = null;
            r10.clear();
            goto L6
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

        public Builder clearMethods() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L5;
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearMixins() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L5;
            this.mixins_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Api.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r10.clear();
            goto L6
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -17;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 == null) goto L5;
            r10.dispose();
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

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Api getDefaultInstanceForType() {
            return Api.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return ApiProto.internal_static_google_protobuf_Api_descriptor;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Method getMethods(int r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.methods_.get(r10);
        L6:
            return (Method) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public Method.Builder getMethodsBuilder(int r10) {
            return (Method.Builder) internalGetMethodsFieldBuilder().getBuilder(r10);
        }

        public List<Method.Builder> getMethodsBuilderList() {
            return internalGetMethodsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L7;
            return this.methods_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Method> getMethodsList() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.methods_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MethodOrBuilder getMethodsOrBuilder(int r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.methods_.get(r10);
        L6:
            return (MethodOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r10 = this.methodsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.methods_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Mixin getMixins(int r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.mixins_.get(r10);
        L6:
            return (Mixin) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public Mixin.Builder getMixinsBuilder(int r10) {
            return (Mixin.Builder) internalGetMixinsFieldBuilder().getBuilder(r10);
        }

        public List<Mixin.Builder> getMixinsBuilderList() {
            return internalGetMixinsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L7;
            return this.mixins_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Mixin> getMixinsList() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.mixins_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MixinOrBuilder getMixinsOrBuilder(int r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.mixins_.get(r10);
        L6:
            return (MixinOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r10 = this.mixinsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.mixins_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getName() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.name_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getNameBytes() {
            Object r10 = this.name_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.name_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Option getOptions(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            MessageLite r12 = this.options_.get(r10);
        L6:
            return (Option) r12;
        L7:
            r12 = r11.getMessage(r10);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r10) {
            return (Option.Builder) internalGetOptionsFieldBuilder().getBuilder(r10);
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return this.options_.size();
        L7:
            return r10.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r10.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L7;
            Object r12 = this.options_.get(r10);
        L6:
            return (OptionOrBuilder) r12;
        L7:
            r12 = r11.getMessageOrBuilder(r10);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r10 = this.optionsBuilder_;
            if (r10 == null) goto L7;
            return r10.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 != null) goto L9;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L7;
            return r11;
        L7:
            return SourceContext.getDefaultInstance();
        L9:
            return (SourceContext) r10.getMessage();
        }

        public SourceContext.Builder getSourceContextBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (SourceContext.Builder) internalGetSourceContextFieldBuilder().getBuilder();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r10 = this.sourceContextBuilder_;
            if (r10 != null) goto L5;
            SourceContext r11 = this.sourceContext_;
            if (r11 == null) goto L9;
            return r11;
        L9:
            return SourceContext.getDefaultInstance();
        L5:
            return (SourceContextOrBuilder) r10.getMessageOrBuilder();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Syntax getSyntax() {
            Syntax r10 = Syntax.forNumber(this.syntax_);
            if (r10 == null) goto L5;
            return r10;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getVersion() {
            Object r10 = this.version_;
            if ((r10 instanceof String) == true) goto L7;
            String r11 = ((ByteString) r10).toStringUtf8();
            this.version_ = r11;
            return r11;
        L7:
            return (String) r10;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            Object r10 = this.version_;
            if ((r10 instanceof String) == false) goto L7;
            ByteString r11 = ByteString.copyFromUtf8((String) r10);
            this.version_ = r11;
            return r11;
        L7:
            return (ByteString) r10;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public boolean hasSourceContext() {
            if ((this.bitField0_ & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
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

        public Builder mergeFrom(Api r10) {
            if (r10 != Api.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r10.getName().isEmpty() == true) goto L8;
            this.name_ = Api.access$600(r10);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = null;
            if (this.methodsBuilder_ != null) goto L18;
            if (Api.access$300(r10).isEmpty() == true) goto L28;
            if (this.methods_.isEmpty() == false) goto L15;
            this.methods_ = Api.access$300(r10);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureMethodsIsMutable();
            this.methods_.addAll(Api.access$300(r10));
        L28:
            if (this.optionsBuilder_ != null) goto L37;
            if (Api.access$400(r10).isEmpty() == true) goto L47;
            if (this.options_.isEmpty() == false) goto L34;
            this.options_ = Api.access$400(r10);
            this.bitField0_ &= -5;
        L35:
            onChanged();
            goto L47
        L34:
            ensureOptionsIsMutable();
            this.options_.addAll(Api.access$400(r10));
        L47:
            if (r10.getVersion().isEmpty() == true) goto L50;
            this.version_ = Api.access$700(r10);
            this.bitField0_ |= 8;
            onChanged();
        L50:
            if (r10.hasSourceContext() == false) goto L53;
            mergeSourceContext(r10.getSourceContext());
        L53:
            if (this.mixinsBuilder_ != null) goto L62;
            if (Api.access$500(r10).isEmpty() == true) goto L71;
            if (this.mixins_.isEmpty() == false) goto L59;
            this.mixins_ = Api.access$500(r10);
            this.bitField0_ &= -33;
        L60:
            onChanged();
            goto L71
        L59:
            ensureMixinsIsMutable();
            this.mixins_.addAll(Api.access$500(r10));
        L71:
            if (Api.access$900(r10) == 0) goto L73;
            setSyntaxValue(r10.getSyntaxValue());
        L73:
            mergeUnknownFields(r10.getUnknownFields());
            onChanged();
            return this;
        L62:
            if (Api.access$500(r10).isEmpty() == true) goto L71;
            if (this.mixinsBuilder_.isEmpty() == false) goto L69;
            this.mixinsBuilder_.dispose();
            this.mixinsBuilder_ = null;
            this.mixins_ = Api.access$500(r10);
            this.bitField0_ &= -33;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L68;
            r11 = internalGetMixinsFieldBuilder();
        L68:
            this.mixinsBuilder_ = r11;
            goto L71
        L69:
            this.mixinsBuilder_.addAllMessages(Api.access$500(r10));
            goto L71
        L37:
            if (Api.access$400(r10).isEmpty() == true) goto L47;
            if (this.optionsBuilder_.isEmpty() == false) goto L45;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Api.access$400(r10);
            this.bitField0_ &= -5;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L43;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = internalGetOptionsFieldBuilder();
        L44:
            this.optionsBuilder_ = r12;
            goto L47
        L43:
            r12 = null;
            goto L44
        L45:
            this.optionsBuilder_.addAllMessages(Api.access$400(r10));
            goto L47
        L18:
            if (Api.access$300(r10).isEmpty() == true) goto L28;
            if (this.methodsBuilder_.isEmpty() == false) goto L26;
            this.methodsBuilder_.dispose();
            this.methodsBuilder_ = null;
            this.methods_ = Api.access$300(r10);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r13 = internalGetMethodsFieldBuilder();
        L25:
            this.methodsBuilder_ = r13;
            goto L28
        L24:
            r13 = null;
            goto L25
        L26:
            this.methodsBuilder_.addAllMessages(Api.access$300(r10));
            goto L28
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
            Objects.requireNonNull(r11);
            boolean r12 = false;
        L3:
            if (r12 == true) goto L47;
            int r13 = r10.readTag();     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            if (r13 == 0) goto L39;
            if (r13 != 10) goto L9;
            this.name_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            this.bitField0_ |= 1;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            goto L3
        L9:
            if (r13 == 18) goto L34;
            if (r13 == 26) goto L31;
            if (r13 != 34) goto L15;
            this.version_ = r10.readStringRequireUtf8();     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            this.bitField0_ |= 8;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            goto L3
        L15:
            if (r13 != 42) goto L17;
            r10.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r11);     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            this.bitField0_ |= 16;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            goto L3
        L17:
            if (r13 != 50) goto L19;
            MessageLite r14 = (Mixin) r10.readMessage(Mixin.parser(), r11);     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            RepeatedFieldBuilder r15 = this.mixinsBuilder_;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            if (r15 == null) goto L26;
        L28:
            r15.addMessage(r14);     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            goto L3
        L26:
            ensureMixinsIsMutable();     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            List r16 = this.mixins_;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
        L27:
            r16.add(r14);     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            goto L3
        L19:
            if (r13 != 56) goto L21;
            this.syntax_ = r10.readEnum();     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            this.bitField0_ |= 64;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            goto L3
        L21:
            if (super.parseUnknownField(r10, r11, r13) == true) goto L3;
        L31:
            r14 = (Option) r10.readMessage(Option.parser(), r11);     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            r15 = this.optionsBuilder_;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            if (r15 != null) goto L28;
            ensureOptionsIsMutable();     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            r16 = this.options_;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            goto L27
        L34:
            r14 = (Method) r10.readMessage(Method.parser(), r11);     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            r15 = this.methodsBuilder_;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            if (r15 != null) goto L28;
            ensureMethodsIsMutable();     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
            r16 = this.methods_;     // Catch: Throwable -> L40 InvalidProtocolBufferException -> L42
        L39:
            r12 = true;
            goto L3
        L40:
            th = move-exception;
            onChanged();
            throw th;
        L42:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L40
        L47:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r10) {
            if ((r10 instanceof Api) == true) goto L5;
            super.mergeFrom(r10);
            return this;
        L5:
            return mergeFrom((Api) r10);
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

        public Builder mergeSourceContext(SourceContext r10) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 == null) goto L5;
            r11.mergeFrom(r10);
        L14:
            if (this.sourceContext_ == null) goto L16;
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            SourceContext r12 = this.sourceContext_;
            if (r12 == null) goto L11;
            if (r12 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r10);
        L11:
            this.sourceContext_ = r10;
            goto L14
        }

        public Builder removeMethods(int r10) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r11 = this.methodsBuilder_;
            if (r11 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder removeMixins(int r10) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r11 = this.mixinsBuilder_;
            if (r11 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder removeOptions(int r10) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r11 = this.optionsBuilder_;
            if (r11 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r10);
            onChanged();
        L6:
            return this;
        L5:
            r11.remove(r10);
            goto L6
        }

        public Builder setMethods(int r10, Method.Builder r11) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r12 = this.methodsBuilder_;
            if (r12 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setMethods(int r10, Method r11) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r12 = this.methodsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureMethodsIsMutable();
            this.methods_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
        }

        public Builder setMixins(int r10, Mixin.Builder r11) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setMixins(int r10, Mixin r11) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r12 = this.mixinsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureMixinsIsMutable();
            this.mixins_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
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
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.name_ = r10;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setOptions(int r10, Option.Builder r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r10, r11.build());
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11.build());
            goto L6
        }

        public Builder setOptions(int r10, Option r11) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r12 = this.optionsBuilder_;
            if (r12 != null) goto L5;
            Objects.requireNonNull(r11);
            ensureOptionsIsMutable();
            this.options_.set(r10, r11);
            onChanged();
        L6:
            return this;
        L5:
            r12.setMessage(r10, r11);
            goto L6
        }

        public Builder setSourceContext(SourceContext.Builder r10) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            SourceContext r12 = r10.build();
            if (r11 != null) goto L5;
            this.sourceContext_ = r12;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r11.setMessage(r12);
            goto L6
        }

        public Builder setSourceContext(SourceContext r10) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r11 = this.sourceContextBuilder_;
            if (r11 != null) goto L5;
            Objects.requireNonNull(r10);
            this.sourceContext_ = r10;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r11.setMessage(r10);
            goto L6
        }

        public Builder setSyntax(Syntax r10) {
            Objects.requireNonNull(r10);
            this.bitField0_ |= 64;
            this.syntax_ = r10.getNumber();
            onChanged();
            return this;
        }

        public Builder setSyntaxValue(int r10) {
            this.syntax_ = r10;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setVersion(String r10) {
            Objects.requireNonNull(r10);
            this.version_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setVersionBytes(ByteString r10) {
            Objects.requireNonNull(r10);
            AbstractMessageLite.checkByteStringIsUtf8(r10);
            this.version_ = r10;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 31, 1, "", Api.class.getName());
        DEFAULT_INSTANCE = new Api();
        PARSER = new AnonymousClass1();
    }

    private Api() {
        this.name_ = "";
        this.version_ = "";
        this.syntax_ = 0;
        this.memoizedIsInitialized = -1;
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.mixins_ = Collections.emptyList();
        this.syntax_ = 0;
    }

    private Api(GeneratedMessage.Builder<?> r10) {
        super(r10);
        this.name_ = "";
        this.version_ = "";
        this.syntax_ = 0;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Api(GeneratedMessage.Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    static /* synthetic */ int access$1076(Api r10, int r11) {
        int r12 = r11 | r10.bitField0_;
        r10.bitField0_ = r12;
        return r12;
    }

    static /* synthetic */ List access$300(Api r10) {
        return r10.methods_;
    }

    static /* synthetic */ List access$302(Api r10, List r11) {
        r10.methods_ = r11;
        return r11;
    }

    static /* synthetic */ List access$400(Api r10) {
        return r10.options_;
    }

    static /* synthetic */ List access$402(Api r10, List r11) {
        r10.options_ = r11;
        return r11;
    }

    static /* synthetic */ List access$500(Api r10) {
        return r10.mixins_;
    }

    static /* synthetic */ List access$502(Api r10, List r11) {
        r10.mixins_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$600(Api r10) {
        return r10.name_;
    }

    static /* synthetic */ Object access$602(Api r10, Object r11) {
        r10.name_ = r11;
        return r11;
    }

    static /* synthetic */ Object access$700(Api r10) {
        return r10.version_;
    }

    static /* synthetic */ Object access$702(Api r10, Object r11) {
        r10.version_ = r11;
        return r11;
    }

    static /* synthetic */ SourceContext access$802(Api r10, SourceContext r11) {
        r10.sourceContext_ = r11;
        return r11;
    }

    static /* synthetic */ int access$900(Api r10) {
        return r10.syntax_;
    }

    static /* synthetic */ int access$902(Api r10, int r11) {
        r10.syntax_ = r11;
        return r11;
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

    public static Builder newBuilder(Api r10) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r10);
    }

    public static Api parseDelimitedFrom(InputStream r10) {
        return (Api) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10);
    }

    public static Api parseDelimitedFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Api) GeneratedMessage.parseDelimitedWithIOException(PARSER, r10, r11);
    }

    public static Api parseFrom(ByteString r10) {
        return PARSER.parseFrom(r10);
    }

    public static Api parseFrom(ByteString r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Api parseFrom(CodedInputStream r10) {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Api parseFrom(CodedInputStream r10, ExtensionRegistryLite r11) {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Api parseFrom(InputStream r10) {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, r10);
    }

    public static Api parseFrom(InputStream r10, ExtensionRegistryLite r11) {
        return (Api) GeneratedMessage.parseWithIOException(PARSER, r10, r11);
    }

    public static Api parseFrom(ByteBuffer r10) {
        return PARSER.parseFrom(r10);
    }

    public static Api parseFrom(ByteBuffer r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Api parseFrom(byte[] r10) {
        return PARSER.parseFrom(r10);
    }

    public static Api parseFrom(byte[] r10, ExtensionRegistryLite r11) {
        return PARSER.parseFrom(r10, r11);
    }

    public static Parser<Api> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof Api) == false) goto L8;
        Api r11 = (Api) r10;
        if (getName().equals(r11.getName()) == true) goto L13;
        return false;
    L13:
        if (getMethodsList().equals(r11.getMethodsList()) == true) goto L16;
        return false;
    L16:
        if (getOptionsList().equals(r11.getOptionsList()) == true) goto L19;
        return false;
    L19:
        if (getVersion().equals(r11.getVersion()) == true) goto L22;
        return false;
    L22:
        if (hasSourceContext() == r11.hasSourceContext()) goto L25;
        return false;
    L25:
        if (hasSourceContext() == false) goto L30;
        if (getSourceContext().equals(r11.getSourceContext()) == true) goto L30;
        return false;
    L30:
        if (getMixinsList().equals(r11.getMixinsList()) == true) goto L33;
        return false;
    L33:
        if (this.syntax_ == r11.syntax_) goto L36;
        return false;
    L36:
        if (getUnknownFields().equals(r11.getUnknownFields()) == true) goto L38;
        return false;
    L38:
        return true;
    L8:
        return super.equals(r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Api getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Method getMethods(int r10) {
        return this.methods_.get(r10);
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
    public MethodOrBuilder getMethodsOrBuilder(int r10) {
        return this.methods_.get(r10);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Mixin getMixins(int r10) {
        return this.mixins_.get(r10);
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
    public MixinOrBuilder getMixinsOrBuilder(int r10) {
        return this.mixins_.get(r10);
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getName() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.name_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getNameBytes() {
        Object r10 = this.name_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.name_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Option getOptions(int r10) {
        return this.options_.get(r10);
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
    public OptionOrBuilder getOptionsOrBuilder(int r10) {
        return this.options_.get(r10);
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
        int r10 = this.memoizedSize;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        int r11 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r12 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.methods_.size()) goto L13;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.methods_.get(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        int r14 = 0;
    L15:
        if (r14 >= this.options_.size()) goto L18;
        r12 = r12 + CodedOutputStream.computeMessageSize(3, this.options_.get(r14));
        r14 = r14 + 1;
        goto L15
    L18:
        if (GeneratedMessage.isStringEmpty(this.version_) == true) goto L21;
        r12 = r12 + GeneratedMessage.computeStringSize(4, this.version_);
    L21:
        if ((1 & this.bitField0_) == 0) goto L24;
        r12 = r12 + CodedOutputStream.computeMessageSize(5, getSourceContext());
    L24:
        if (r11 >= this.mixins_.size()) goto L27;
        r12 = r12 + CodedOutputStream.computeMessageSize(6, this.mixins_.get(r11));
        r11 = r11 + 1;
        goto L24
    L27:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L29;
        r12 = r12 + CodedOutputStream.computeEnumSize(7, this.syntax_);
    L29:
        int r15 = r12 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r15;
        return r15;
    L8:
        r12 = 0;
        goto L9
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r10 = this.sourceContext_;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Syntax getSyntax() {
        Syntax r10 = Syntax.forNumber(this.syntax_);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getVersion() {
        Object r10 = this.version_;
        if ((r10 instanceof String) == true) goto L5;
        String r11 = ((ByteString) r10).toStringUtf8();
        this.version_ = r11;
        return r11;
    L5:
        return (String) r10;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        Object r10 = this.version_;
        if ((r10 instanceof String) == false) goto L7;
        ByteString r11 = ByteString.copyFromUtf8((String) r10);
        this.version_ = r11;
        return r11;
    L7:
        return (ByteString) r10;
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
        int r10 = this.memoizedHashCode;
        if (r10 == 0) goto L5;
        return r10;
    L5:
        int r11 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getMethodsCount() <= 0) goto L9;
        r11 = (((r11 * 37) + 2) * 53) + getMethodsList().hashCode();
    L9:
        if (getOptionsCount() <= 0) goto L11;
        r11 = (((r11 * 37) + 3) * 53) + getOptionsList().hashCode();
    L11:
        int r12 = (((r11 * 37) + 4) * 53) + getVersion().hashCode();
        if (hasSourceContext() == false) goto L15;
        r12 = (((r12 * 37) + 5) * 53) + getSourceContext().hashCode();
    L15:
        if (getMixinsCount() <= 0) goto L17;
        r12 = (((r12 * 37) + 6) * 53) + getMixinsList().hashCode();
    L17:
        int r13 = (((((r12 * 37) + 7) * 53) + this.syntax_) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r13;
        return r13;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
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
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.AbstractMessage
    protected Builder newBuilderForType(AbstractMessage.BuilderParent r10) {
        return new Builder(r10, null);
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
    public Builder toBuilder() {
        AnonymousClass1 r10 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r10);
    L6:
        return new Builder(r10).mergeFrom(this);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r10) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r10, 1, this.name_);
    L5:
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r12 >= this.methods_.size()) goto L9;
        r10.writeMessage(2, this.methods_.get(r12));
        r12 = r12 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.options_.size()) goto L14;
        r10.writeMessage(3, this.options_.get(r13));
        r13 = r13 + 1;
        goto L11
    L14:
        if (GeneratedMessage.isStringEmpty(this.version_) == true) goto L17;
        GeneratedMessage.writeString(r10, 4, this.version_);
    L17:
        if ((1 & this.bitField0_) == 0) goto L20;
        r10.writeMessage(5, getSourceContext());
    L20:
        if (r11 >= this.mixins_.size()) goto L23;
        r10.writeMessage(6, this.mixins_.get(r11));
        r11 = r11 + 1;
        goto L20
    L23:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L25;
        r10.writeEnum(7, this.syntax_);
    L25:
        getUnknownFields().writeTo(r10);
    }
}
