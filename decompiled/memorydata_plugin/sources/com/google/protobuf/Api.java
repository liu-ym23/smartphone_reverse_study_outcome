package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
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

        private Builder(AbstractMessage.BuilderParent r3) {
            super((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
            this.name_ = "";
            this.methods_ = Collections.emptyList();
            this.options_ = Collections.emptyList();
            this.version_ = "";
            this.mixins_ = Collections.emptyList();
            this.syntax_ = 0;
            maybeForceBuilderInitialization();
        }

        /* synthetic */ Builder(AbstractMessage.BuilderParent r2, AnonymousClass1 r3) {
            this((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
        }

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private void buildPartial0(Api r5) {
            int r0 = this.bitField0_;
            if ((r0 & 1) == 0) goto L6;
            Api.access$602(r5, this.name_);
        L6:
            if ((r0 & 8) == 0) goto L8;
            Api.access$702(r5, this.version_);
        L8:
            int r1 = 0;
            if ((r0 & 16) == 0) goto L16;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r2 = this.sourceContextBuilder_;
            if (r2 != null) goto L13;
            SourceContext r3 = this.sourceContext_;
        L14:
            Api.access$802(r5, r3);
            r1 = 1;
            goto L16
        L13:
            r3 = (SourceContext) ZeusTransformUtils.preCheckCast(r2.build(), SourceContext.class, "com.obric.memorydata.plugin");
        L16:
            if ((r0 & 64) == 0) goto L18;
            Api.access$902(r5, this.syntax_);
        L18:
            Api.access$1076(r5, r1);
        }

        private void buildPartialRepeatedFields(Api r2) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 == null) goto L5;
            List r1 = r0.build();
        L9:
            Api.access$302(r2, r1);
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r3 = this.optionsBuilder_;
            if (r3 == null) goto L12;
            List r4 = r3.build();
        L16:
            Api.access$402(r2, r4);
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r5 = this.mixinsBuilder_;
            if (r5 == null) goto L19;
            List r6 = r5.build();
        L23:
            Api.access$502(r2, r6);
            return;
        L19:
            if ((this.bitField0_ & 32) == 0) goto L21;
            this.mixins_ = Collections.unmodifiableList(this.mixins_);
            this.bitField0_ &= -33;
        L21:
            r6 = this.mixins_;
            goto L23
        L12:
            if ((this.bitField0_ & 4) == 0) goto L14;
            this.options_ = Collections.unmodifiableList(this.options_);
            this.bitField0_ &= -5;
        L14:
            r4 = this.options_;
            goto L16
        L5:
            if ((this.bitField0_ & 2) == 0) goto L7;
            this.methods_ = Collections.unmodifiableList(this.methods_);
            this.bitField0_ &= -3;
        L7:
            r1 = this.methods_;
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
            List<Method> r1 = this.methods_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.methodsBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.methods_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.methodsBuilder_;
        }

        private RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> internalGetMixinsFieldBuilder() {
            if (this.mixinsBuilder_ != null) goto L10;
            List<Mixin> r1 = this.mixins_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.mixinsBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.mixins_ = null;
            goto L10
        L7:
            r2 = false;
        L10:
            return this.mixinsBuilder_;
        }

        private RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> internalGetOptionsFieldBuilder() {
            if (this.optionsBuilder_ != null) goto L10;
            List<Option> r1 = this.options_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r2 = true;
        L8:
            this.optionsBuilder_ = new RepeatedFieldBuilder(r1, r2, getParentForChildren(), isClean());
            this.options_ = null;
            goto L10
        L7:
            r2 = false;
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

        public Builder addAllMethods(Iterable<? extends Method> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            ensureMethodsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.methods_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder addAllMixins(Iterable<? extends Mixin> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            ensureMixinsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.mixins_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder addAllOptions(Iterable<? extends Option> r3) {
            Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            AbstractMessageLite.Builder.addAll(r4, this.options_);
            onChanged();
        L6:
            return this;
        L5:
            r0.addAllMessages(r4);
            goto L6
        }

        public Builder addMethods(int r2, Method.Builder r3) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addMethods(int r2, Method r3) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureMethodsIsMutable();
            this.methods_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addMethods(Method.Builder r2) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addMethods(Method r2) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureMethodsIsMutable();
            this.methods_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Method.Builder addMethodsBuilder() {
            return (Method.Builder) ZeusTransformUtils.preCheckCast(internalGetMethodsFieldBuilder().addBuilder(Method.getDefaultInstance()), Method.Builder.class, "com.obric.memorydata.plugin");
        }

        public Method.Builder addMethodsBuilder(int r2) {
            return (Method.Builder) ZeusTransformUtils.preCheckCast(internalGetMethodsFieldBuilder().addBuilder(r2, Method.getDefaultInstance()), Method.Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder addMixins(int r2, Mixin.Builder r3) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addMixins(int r2, Mixin r3) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureMixinsIsMutable();
            this.mixins_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addMixins(Mixin.Builder r2) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addMixins(Mixin r2) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureMixinsIsMutable();
            this.mixins_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Mixin.Builder addMixinsBuilder() {
            return (Mixin.Builder) ZeusTransformUtils.preCheckCast(internalGetMixinsFieldBuilder().addBuilder(Mixin.getDefaultInstance()), Mixin.Builder.class, "com.obric.memorydata.plugin");
        }

        public Mixin.Builder addMixinsBuilder(int r2) {
            return (Mixin.Builder) ZeusTransformUtils.preCheckCast(internalGetMixinsFieldBuilder().addBuilder(r2, Mixin.getDefaultInstance()), Mixin.Builder.class, "com.obric.memorydata.plugin");
        }

        public Builder addOptions(int r2, Option.Builder r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3.build());
            goto L6
        }

        public Builder addOptions(int r2, Option r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureOptionsIsMutable();
            this.options_.add(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2, r3);
            goto L6
        }

        public Builder addOptions(Option.Builder r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.add(r2.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2.build());
            goto L6
        }

        public Builder addOptions(Option r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            ensureOptionsIsMutable();
            this.options_.add(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.addMessage(r2);
            goto L6
        }

        public Option.Builder addOptionsBuilder() {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().addBuilder(Option.getDefaultInstance()), Option.Builder.class, "com.obric.memorydata.plugin");
        }

        public Option.Builder addOptionsBuilder(int r2) {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().addBuilder(r2, Option.getDefaultInstance()), Option.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Api build() {
            Api r1 = buildPartial();
            if (r1.isInitialized() == false) goto L6;
            return r1;
        L6:
            throw newUninitializedMessageException(r1);
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
            Api r0 = new Api(this, null);
            buildPartialRepeatedFields(r0);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r0);
        L5:
            onBuilt();
            return r0;
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
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r2 = this.methodsBuilder_;
            if (r2 != null) goto L5;
            this.methods_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -3;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r3 = this.optionsBuilder_;
            if (r3 != null) goto L9;
            this.options_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -5;
            this.version_ = "";
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r1 = this.sourceContextBuilder_;
            if (r1 == null) goto L13;
            r1.dispose();
            this.sourceContextBuilder_ = null;
        L13:
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r4 = this.mixinsBuilder_;
            if (r4 != null) goto L16;
            this.mixins_ = Collections.emptyList();
        L17:
            this.bitField0_ &= -33;
            this.syntax_ = 0;
            return this;
        L16:
            this.mixins_ = null;
            r4.clear();
            goto L17
        L9:
            this.options_ = null;
            r3.clear();
            goto L10
        L5:
            this.methods_ = null;
            r2.clear();
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
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder clearMixins() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            this.mixins_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder clearName() {
            this.name_ = Api.getDefaultInstance().getName();
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        public Builder clearOptions() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r0.clear();
            goto L6
        }

        public Builder clearSourceContext() {
            this.bitField0_ &= -17;
            this.sourceContext_ = null;
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r1 = this.sourceContextBuilder_;
            if (r1 == null) goto L5;
            r1.dispose();
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
        public Method getMethods(int r3) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.methods_.get(r3);
        L6:
            return (Method) ZeusTransformUtils.preCheckCast(r2, Method.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessage(r3);
            goto L6
        }

        public Method.Builder getMethodsBuilder(int r2) {
            return (Method.Builder) ZeusTransformUtils.preCheckCast(internalGetMethodsFieldBuilder().getBuilder(r2), Method.Builder.class, "com.obric.memorydata.plugin");
        }

        public List<Method.Builder> getMethodsBuilderList() {
            return internalGetMethodsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L7;
            return this.methods_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Method> getMethodsList() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.methods_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MethodOrBuilder getMethodsOrBuilder(int r3) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.methods_.get(r3);
        L6:
            return (MethodOrBuilder) ZeusTransformUtils.preCheckCast(r2, MethodOrBuilder.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessageOrBuilder(r3);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.methods_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Mixin getMixins(int r3) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.mixins_.get(r3);
        L6:
            return (Mixin) ZeusTransformUtils.preCheckCast(r2, Mixin.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessage(r3);
            goto L6
        }

        public Mixin.Builder getMixinsBuilder(int r2) {
            return (Mixin.Builder) ZeusTransformUtils.preCheckCast(internalGetMixinsFieldBuilder().getBuilder(r2), Mixin.Builder.class, "com.obric.memorydata.plugin");
        }

        public List<Mixin.Builder> getMixinsBuilderList() {
            return internalGetMixinsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L7;
            return this.mixins_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Mixin> getMixinsList() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.mixins_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public MixinOrBuilder getMixinsOrBuilder(int r3) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.mixins_.get(r3);
        L6:
            return (MixinOrBuilder) ZeusTransformUtils.preCheckCast(r2, MixinOrBuilder.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessageOrBuilder(r3);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.mixins_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getName() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.name_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getNameBytes() {
            Object r0 = this.name_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.name_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Option getOptions(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.options_.get(r3);
        L6:
            return (Option) ZeusTransformUtils.preCheckCast(r2, Option.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessage(r3);
            goto L6
        }

        public Option.Builder getOptionsBuilder(int r2) {
            return (Option.Builder) ZeusTransformUtils.preCheckCast(internalGetOptionsFieldBuilder().getBuilder(r2), Option.Builder.class, "com.obric.memorydata.plugin");
        }

        public List<Option.Builder> getOptionsBuilderList() {
            return internalGetOptionsFieldBuilder().getBuilderList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return this.options_.size();
        L7:
            return r0.getCount();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<Option> getOptionsList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            return Collections.unmodifiableList(this.options_);
        L7:
            return r0.getMessageList();
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public OptionOrBuilder getOptionsOrBuilder(int r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L7;
            Object r2 = this.options_.get(r3);
        L6:
            return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(r2, OptionOrBuilder.class, "com.obric.memorydata.plugin");
        L7:
            r2 = r0.getMessageOrBuilder(r3);
            goto L6
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 == null) goto L7;
            return r0.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.options_);
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContext getSourceContext() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 != null) goto L9;
            SourceContext r2 = this.sourceContext_;
            if (r2 == null) goto L7;
            return r2;
        L7:
            return SourceContext.getDefaultInstance();
        L9:
            return (SourceContext) ZeusTransformUtils.preCheckCast(r0.getMessage(), SourceContext.class, "com.obric.memorydata.plugin");
        }

        public SourceContext.Builder getSourceContextBuilder() {
            this.bitField0_ |= 16;
            onChanged();
            return (SourceContext.Builder) ZeusTransformUtils.preCheckCast(internalGetSourceContextFieldBuilder().getBuilder(), SourceContext.Builder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public SourceContextOrBuilder getSourceContextOrBuilder() {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 != null) goto L5;
            SourceContext r2 = this.sourceContext_;
            if (r2 == null) goto L9;
            return r2;
        L9:
            return SourceContext.getDefaultInstance();
        L5:
            return (SourceContextOrBuilder) ZeusTransformUtils.preCheckCast(r0.getMessageOrBuilder(), SourceContextOrBuilder.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public Syntax getSyntax() {
            Syntax r0 = Syntax.forNumber(this.syntax_);
            if (r0 == null) goto L5;
            return r0;
        L5:
            return Syntax.UNRECOGNIZED;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return this.syntax_;
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public String getVersion() {
            Object r0 = this.version_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L7;
            String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
            this.version_ = r1;
            return r1;
        L7:
            return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            Object r0 = this.version_;
            if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
            this.version_ = r1;
            return r1;
        L7:
            return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ AbstractMessage.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        public Builder mergeFrom(Api r4) {
            if (r4 != Api.getDefaultInstance()) goto L6;
            return this;
        L6:
            if (r4.getName().isEmpty() == true) goto L8;
            this.name_ = Api.access$600(r4);
            this.bitField0_ |= 1;
            onChanged();
        L8:
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r1 = null;
            if (this.methodsBuilder_ != null) goto L18;
            if (Api.access$300(r4).isEmpty() == true) goto L28;
            if (this.methods_.isEmpty() == false) goto L15;
            this.methods_ = Api.access$300(r4);
            this.bitField0_ &= -3;
        L16:
            onChanged();
            goto L28
        L15:
            ensureMethodsIsMutable();
            this.methods_.addAll(Api.access$300(r4));
        L28:
            if (this.optionsBuilder_ != null) goto L37;
            if (Api.access$400(r4).isEmpty() == true) goto L47;
            if (this.options_.isEmpty() == false) goto L34;
            this.options_ = Api.access$400(r4);
            this.bitField0_ &= -5;
        L35:
            onChanged();
            goto L47
        L34:
            ensureOptionsIsMutable();
            this.options_.addAll(Api.access$400(r4));
        L47:
            if (r4.getVersion().isEmpty() == true) goto L50;
            this.version_ = Api.access$700(r4);
            this.bitField0_ |= 8;
            onChanged();
        L50:
            if (r4.hasSourceContext() == false) goto L53;
            mergeSourceContext(r4.getSourceContext());
        L53:
            if (this.mixinsBuilder_ != null) goto L62;
            if (Api.access$500(r4).isEmpty() == true) goto L71;
            if (this.mixins_.isEmpty() == false) goto L59;
            this.mixins_ = Api.access$500(r4);
            this.bitField0_ &= -33;
        L60:
            onChanged();
            goto L71
        L59:
            ensureMixinsIsMutable();
            this.mixins_.addAll(Api.access$500(r4));
        L71:
            if (Api.access$900(r4) == 0) goto L73;
            setSyntaxValue(r4.getSyntaxValue());
        L73:
            mergeUnknownFields(r4.getUnknownFields());
            onChanged();
            return this;
        L62:
            if (Api.access$500(r4).isEmpty() == true) goto L71;
            if (this.mixinsBuilder_.isEmpty() == false) goto L69;
            this.mixinsBuilder_.dispose();
            this.mixinsBuilder_ = null;
            this.mixins_ = Api.access$500(r4);
            this.bitField0_ &= -33;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L68;
            r1 = internalGetMixinsFieldBuilder();
        L68:
            this.mixinsBuilder_ = r1;
            goto L71
        L69:
            this.mixinsBuilder_.addAllMessages(Api.access$500(r4));
            goto L71
        L37:
            if (Api.access$400(r4).isEmpty() == true) goto L47;
            if (this.optionsBuilder_.isEmpty() == false) goto L45;
            this.optionsBuilder_.dispose();
            this.optionsBuilder_ = null;
            this.options_ = Api.access$400(r4);
            this.bitField0_ &= -5;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L43;
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = internalGetOptionsFieldBuilder();
        L44:
            this.optionsBuilder_ = r0;
            goto L47
        L43:
            r0 = null;
            goto L44
        L45:
            this.optionsBuilder_.addAllMessages(Api.access$400(r4));
            goto L47
        L18:
            if (Api.access$300(r4).isEmpty() == true) goto L28;
            if (this.methodsBuilder_.isEmpty() == false) goto L26;
            this.methodsBuilder_.dispose();
            this.methodsBuilder_ = null;
            this.methods_ = Api.access$300(r4);
            this.bitField0_ &= -3;
            if (GeneratedMessage.alwaysUseFieldBuilders == false) goto L24;
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r2 = internalGetMethodsFieldBuilder();
        L25:
            this.methodsBuilder_ = r2;
            goto L28
        L24:
            r2 = null;
            goto L25
        L26:
            this.methodsBuilder_.addAllMessages(Api.access$300(r4));
            goto L28
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r6, ExtensionRegistryLite r7) {
            Objects.requireNonNull(r7);
            boolean r0 = false;
        L3:
            if (r0 == true) goto L48;
            int r1 = r6.readTag();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
        L6:
            if (r1 == 0) goto L40;
            if (r1 != 10) goto L10;
            this.name_ = r6.readStringRequireUtf8();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 1;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L3
        L10:
            if (r1 == 18) goto L35;
            if (r1 == 26) goto L32;
            if (r1 != 34) goto L16;
            this.version_ = r6.readStringRequireUtf8();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 8;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L3
        L16:
            if (r1 != 42) goto L18;
            r6.readMessage(internalGetSourceContextFieldBuilder().getBuilder(), r7);     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 16;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L3
        L18:
            if (r1 != 50) goto L20;
            MessageLite r2 = (Mixin) ZeusTransformUtils.preCheckCast(r6.readMessage(Mixin.parser(), r7), Mixin.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            RepeatedFieldBuilder r3 = this.mixinsBuilder_;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            if (r3 == null) goto L27;
        L29:
            r3.addMessage(r2);     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L3
        L27:
            ensureMixinsIsMutable();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            List r4 = this.mixins_;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
        L28:
            r4.add(r2);     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L3
        L20:
            if (r1 != 56) goto L22;
            this.syntax_ = r6.readEnum();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            this.bitField0_ |= 64;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L3
        L22:
            if (super.parseUnknownField(r6, r7, r1) == true) goto L3;
        L32:
            r2 = (Option) ZeusTransformUtils.preCheckCast(r6.readMessage(Option.parser(), r7), Option.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.optionsBuilder_;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            if (r3 != null) goto L29;
            ensureOptionsIsMutable();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r4 = this.options_;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            goto L28
        L35:
            r2 = (Method) ZeusTransformUtils.preCheckCast(r6.readMessage(Method.parser(), r7), Method.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r3 = this.methodsBuilder_;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            if (r3 != null) goto L29;
            ensureMethodsIsMutable();     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
            r4 = this.methods_;     // Catch: Throwable -> L41 InvalidProtocolBufferException -> L43
        L40:
            r0 = true;
        L43:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L41
        L41:
            th = move-exception;
            onChanged();
            throw th;
        L48:
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r3) {
            Message r4 = (Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r4, Api.class) == true) goto L5;
            super.mergeFrom(r4);
            return this;
        L5:
            return mergeFrom((Api) ZeusTransformUtils.preCheckCast(r4, Api.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* synthetic */ Message.Builder mergeFrom(Message r3) {
            return mergeFrom((Message) ZeusTransformUtils.wrapperContextForParams(r3, Message.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
            return mergeFrom(r1, r2);
        }

        public Builder mergeSourceContext(SourceContext r3) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 == null) goto L5;
            r0.mergeFrom(r3);
        L14:
            if (this.sourceContext_ == null) goto L16;
            this.bitField0_ |= 16;
            onChanged();
        L16:
            return this;
        L5:
            if ((this.bitField0_ & 16) == 0) goto L11;
            SourceContext r1 = this.sourceContext_;
            if (r1 == null) goto L11;
            if (r1 == SourceContext.getDefaultInstance()) goto L11;
            getSourceContextBuilder().mergeFrom(r3);
        L11:
            this.sourceContext_ = r3;
            goto L14
        }

        public Builder removeMethods(int r2) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Builder removeMixins(int r2) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Builder removeOptions(int r2) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.remove(r2);
            onChanged();
        L6:
            return this;
        L5:
            r0.remove(r2);
            goto L6
        }

        public Builder setMethods(int r2, Method.Builder r3) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            ensureMethodsIsMutable();
            this.methods_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder setMethods(int r2, Method r3) {
            RepeatedFieldBuilder<Method, Method.Builder, MethodOrBuilder> r0 = this.methodsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureMethodsIsMutable();
            this.methods_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setMixins(int r2, Mixin.Builder r3) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            ensureMixinsIsMutable();
            this.mixins_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder setMixins(int r2, Mixin r3) {
            RepeatedFieldBuilder<Mixin, Mixin.Builder, MixinOrBuilder> r0 = this.mixinsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureMixinsIsMutable();
            this.mixins_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setName(String r1) {
            Objects.requireNonNull(r1);
            this.name_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.name_ = r1;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder setOptions(int r2, Option.Builder r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            ensureOptionsIsMutable();
            this.options_.set(r2, r3.build());
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3.build());
            goto L6
        }

        public Builder setOptions(int r2, Option r3) {
            RepeatedFieldBuilder<Option, Option.Builder, OptionOrBuilder> r0 = this.optionsBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r3);
            ensureOptionsIsMutable();
            this.options_.set(r2, r3);
            onChanged();
        L6:
            return this;
        L5:
            r0.setMessage(r2, r3);
            goto L6
        }

        public Builder setSourceContext(SourceContext.Builder r2) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            SourceContext r3 = r2.build();
            if (r0 != null) goto L5;
            this.sourceContext_ = r3;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r0.setMessage(r3);
            goto L6
        }

        public Builder setSourceContext(SourceContext r2) {
            SingleFieldBuilder<SourceContext, SourceContext.Builder, SourceContextOrBuilder> r0 = this.sourceContextBuilder_;
            if (r0 != null) goto L5;
            Objects.requireNonNull(r2);
            this.sourceContext_ = r2;
        L6:
            this.bitField0_ |= 16;
            onChanged();
            return this;
        L5:
            r0.setMessage(r2);
            goto L6
        }

        public Builder setSyntax(Syntax r2) {
            Objects.requireNonNull(r2);
            this.bitField0_ |= 64;
            this.syntax_ = r2.getNumber();
            onChanged();
            return this;
        }

        public Builder setSyntaxValue(int r1) {
            this.syntax_ = r1;
            this.bitField0_ |= 64;
            onChanged();
            return this;
        }

        public Builder setVersion(String r1) {
            Objects.requireNonNull(r1);
            this.version_ = r1;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder setVersionBytes(ByteString r1) {
            Objects.requireNonNull(r1);
            AbstractMessageLite.checkByteStringIsUtf8(r1);
            this.version_ = r1;
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

    private Api(GeneratedMessage.Builder<?> r1) {
        super(r1);
        this.name_ = "";
        this.version_ = "";
        this.syntax_ = 0;
        this.memoizedIsInitialized = -1;
    }

    /* synthetic */ Api(GeneratedMessage.Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ int access$1076(Api r1, int r2) {
        int r3 = r2 | r1.bitField0_;
        r1.bitField0_ = r3;
        return r3;
    }

    static /* synthetic */ List access$300(Api r0) {
        return r0.methods_;
    }

    static /* synthetic */ List access$302(Api r2, List r3) {
        List<Method> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.methods_ = r4;
        return r4;
    }

    static /* synthetic */ List access$400(Api r0) {
        return r0.options_;
    }

    static /* synthetic */ List access$402(Api r2, List r3) {
        List<Option> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.options_ = r4;
        return r4;
    }

    static /* synthetic */ List access$500(Api r0) {
        return r0.mixins_;
    }

    static /* synthetic */ List access$502(Api r2, List r3) {
        List<Mixin> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        r2.mixins_ = r4;
        return r4;
    }

    static /* synthetic */ Object access$600(Api r0) {
        return r0.name_;
    }

    static /* synthetic */ Object access$602(Api r0, Object r1) {
        r0.name_ = r1;
        return r1;
    }

    static /* synthetic */ Object access$700(Api r0) {
        return r0.version_;
    }

    static /* synthetic */ Object access$702(Api r0, Object r1) {
        r0.version_ = r1;
        return r1;
    }

    static /* synthetic */ SourceContext access$802(Api r0, SourceContext r1) {
        r0.sourceContext_ = r1;
        return r1;
    }

    static /* synthetic */ int access$900(Api r0) {
        return r0.syntax_;
    }

    static /* synthetic */ int access$902(Api r0, int r1) {
        r0.syntax_ = r1;
        return r1;
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

    public static Builder newBuilder(Api r1) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r1);
    }

    public static Api parseDelimitedFrom(InputStream r2) {
        return (Api) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Api) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseDelimitedWithIOException(PARSER, r1, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(ByteString r2) {
        return (Api) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(ByteString r1, ExtensionRegistryLite r2) {
        return (Api) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(CodedInputStream r2) {
        return (Api) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) {
        return (Api) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(InputStream r2) {
        return (Api) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(InputStream r1, ExtensionRegistryLite r2) {
        return (Api) ZeusTransformUtils.preCheckCast(GeneratedMessage.parseWithIOException(PARSER, r1, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(ByteBuffer r2) {
        return (Api) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) {
        return (Api) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(byte[] r2) {
        return (Api) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Api parseFrom(byte[] r1, ExtensionRegistryLite r2) {
        return (Api) ZeusTransformUtils.preCheckCast(PARSER.parseFrom(r1, r2), Api.class, "com.obric.memorydata.plugin");
    }

    public static Parser<Api> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Api.class) == false) goto L8;
        Api r6 = (Api) ZeusTransformUtils.preCheckCast(r5, Api.class, "com.obric.memorydata.plugin");
        if (getName().equals(r6.getName()) == true) goto L13;
        return false;
    L13:
        if (getMethodsList().equals(r6.getMethodsList()) == true) goto L16;
        return false;
    L16:
        if (getOptionsList().equals(r6.getOptionsList()) == true) goto L19;
        return false;
    L19:
        if (getVersion().equals(r6.getVersion()) == true) goto L22;
        return false;
    L22:
        if (hasSourceContext() == r6.hasSourceContext()) goto L25;
        return false;
    L25:
        if (hasSourceContext() == false) goto L30;
        if (getSourceContext().equals(r6.getSourceContext()) == true) goto L30;
        return false;
    L30:
        if (getMixinsList().equals(r6.getMixinsList()) == true) goto L33;
        return false;
    L33:
        if (this.syntax_ == r6.syntax_) goto L36;
        return false;
    L36:
        if (getUnknownFields().equals(r6.getUnknownFields()) == true) goto L38;
        return false;
    L38:
        return true;
    L8:
        return super.equals(r5);
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
    public Method getMethods(int r2) {
        return (Method) ZeusTransformUtils.preCheckCast(this.methods_.get(r2), Method.class, "com.obric.memorydata.plugin");
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
    public MethodOrBuilder getMethodsOrBuilder(int r2) {
        return (MethodOrBuilder) ZeusTransformUtils.preCheckCast(this.methods_.get(r2), MethodOrBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Mixin getMixins(int r2) {
        return (Mixin) ZeusTransformUtils.preCheckCast(this.mixins_.get(r2), Mixin.class, "com.obric.memorydata.plugin");
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
    public MixinOrBuilder getMixinsOrBuilder(int r2) {
        return (MixinOrBuilder) ZeusTransformUtils.preCheckCast(this.mixins_.get(r2), MixinOrBuilder.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.mixins_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getName() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.name_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getNameBytes() {
        Object r0 = this.name_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.name_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Option getOptions(int r2) {
        return (Option) ZeusTransformUtils.preCheckCast(this.options_.get(r2), Option.class, "com.obric.memorydata.plugin");
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
    public OptionOrBuilder getOptionsOrBuilder(int r2) {
        return (OptionOrBuilder) ZeusTransformUtils.preCheckCast(this.options_.get(r2), OptionOrBuilder.class, "com.obric.memorydata.plugin");
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
        int r0 = this.memoizedSize;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        int r1 = 0;
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L8;
        int r2 = GeneratedMessage.computeStringSize(1, this.name_) + 0;
    L9:
        int r3 = 0;
    L11:
        if (r3 >= this.methods_.size()) goto L13;
        r2 = r2 + CodedOutputStream.computeMessageSize(2, (MessageLite) ZeusTransformUtils.preCheckCast(this.methods_.get(r3), MessageLite.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L11
    L13:
        int r4 = 0;
    L15:
        if (r4 >= this.options_.size()) goto L18;
        r2 = r2 + CodedOutputStream.computeMessageSize(3, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r4), MessageLite.class, "com.obric.memorydata.plugin"));
        r4 = r4 + 1;
        goto L15
    L18:
        if (GeneratedMessage.isStringEmpty(this.version_) == true) goto L21;
        r2 = r2 + GeneratedMessage.computeStringSize(4, this.version_);
    L21:
        if ((1 & this.bitField0_) == 0) goto L24;
        r2 = r2 + CodedOutputStream.computeMessageSize(5, getSourceContext());
    L24:
        if (r1 >= this.mixins_.size()) goto L27;
        r2 = r2 + CodedOutputStream.computeMessageSize(6, (MessageLite) ZeusTransformUtils.preCheckCast(this.mixins_.get(r1), MessageLite.class, "com.obric.memorydata.plugin"));
        r1 = r1 + 1;
        goto L24
    L27:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L29;
        r2 = r2 + CodedOutputStream.computeEnumSize(7, this.syntax_);
    L29:
        int r5 = r2 + getUnknownFields().getSerializedSize();
        this.memoizedSize = r5;
        return r5;
    L8:
        r2 = 0;
        goto L9
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContext getSourceContext() {
        SourceContext r0 = this.sourceContext_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext r0 = this.sourceContext_;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return SourceContext.getDefaultInstance();
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public Syntax getSyntax() {
        Syntax r0 = Syntax.forNumber(this.syntax_);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Syntax.UNRECOGNIZED;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public String getVersion() {
        Object r0 = this.version_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == true) goto L5;
        String r1 = ((ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin")).toStringUtf8();
        this.version_ = r1;
        return r1;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        Object r0 = this.version_;
        if (ZeusTransformUtils.instanceOf(r0, String.class) == false) goto L7;
        ByteString r1 = ByteString.copyFromUtf8((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin"));
        this.version_ = r1;
        return r1;
    L7:
        return (ByteString) ZeusTransformUtils.preCheckCast(r0, ByteString.class, "com.obric.memorydata.plugin");
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
        if (this.memoizedHashCode != 0) goto L5;
        int r0 = ((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getName().hashCode();
        if (getMethodsCount() <= 0) goto L10;
        r0 = (((r0 * 37) + 2) * 53) + getMethodsList().hashCode();
    L10:
        if (getOptionsCount() <= 0) goto L12;
        r0 = (((r0 * 37) + 3) * 53) + getOptionsList().hashCode();
    L12:
        int r1 = (((r0 * 37) + 4) * 53) + getVersion().hashCode();
        if (hasSourceContext() == false) goto L16;
        r1 = (((r1 * 37) + 5) * 53) + getSourceContext().hashCode();
    L16:
        if (getMixinsCount() <= 0) goto L18;
        r1 = (((r1 * 37) + 6) * 53) + getMixinsList().hashCode();
    L18:
        int r2 = (((((r1 * 37) + 7) * 53) + this.syntax_) * 29) + getUnknownFields().hashCode();
        this.memoizedHashCode = r2;
        return r2;
    L5:
        return this.memoizedHashCode;
    }

    @Override // com.google.protobuf.GeneratedMessage
    public GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r0 = this.memoizedIsInitialized;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 != 0) goto L8;
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
    public Builder newBuilderForType(AbstractMessage.BuilderParent r2) {
        return new Builder((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r2, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.AbstractMessage
    public /* synthetic */ Message.Builder newBuilderForType(AbstractMessage.BuilderParent r3) {
        return newBuilderForType((AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r3, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r1 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r1);
    L6:
        return new Builder(r1).mergeFrom(this);
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
    public void writeTo(CodedOutputStream r8) {
        if (GeneratedMessage.isStringEmpty(this.name_) == true) goto L5;
        GeneratedMessage.writeString(r8, 1, this.name_);
    L5:
        int r0 = 0;
        int r2 = 0;
    L7:
        if (r2 >= this.methods_.size()) goto L9;
        r8.writeMessage(2, (MessageLite) ZeusTransformUtils.preCheckCast(this.methods_.get(r2), MessageLite.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L7
    L9:
        int r3 = 0;
    L11:
        if (r3 >= this.options_.size()) goto L14;
        r8.writeMessage(3, (MessageLite) ZeusTransformUtils.preCheckCast(this.options_.get(r3), MessageLite.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L11
    L14:
        if (GeneratedMessage.isStringEmpty(this.version_) == true) goto L17;
        GeneratedMessage.writeString(r8, 4, this.version_);
    L17:
        if ((1 & this.bitField0_) == 0) goto L20;
        r8.writeMessage(5, getSourceContext());
    L20:
        if (r0 >= this.mixins_.size()) goto L23;
        r8.writeMessage(6, (MessageLite) ZeusTransformUtils.preCheckCast(this.mixins_.get(r0), MessageLite.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L20
    L23:
        if (this.syntax_ == Syntax.SYNTAX_PROTO2.getNumber()) goto L25;
        r8.writeEnum(7, this.syntax_);
    L25:
        getUnknownFields().writeTo(r8);
    }
}
