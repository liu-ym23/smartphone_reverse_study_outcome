package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class SingleFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private AbstractMessage.BuilderParent parent;

    public SingleFieldBuilder(MType r3, AbstractMessage.BuilderParent r4, boolean r5) {
        AbstractMessage.BuilderParent r6 = (AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r4, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin");
        this.message = (MType) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3), GeneratedMessage.class, "com.obric.memorydata.plugin");
        this.parent = r6;
        this.isClean = r5;
    }

    private void onChanged() {
        if (this.builder == null) goto L6;
        this.message = null;
    L6:
        if (this.isClean == false) goto L11;
        AbstractMessage.BuilderParent r0 = this.parent;
        if (r0 == null) goto L12;
        r0.markDirty();
        this.isClean = false;
        return;
    L12:
        return;
    }

    public MType build() {
        this.isClean = true;
        return (MType) getMessage();
    }

    public SingleFieldBuilder<MType, BType, IType> clear() {
        MType r0 = this.message;
        if (r0 == null) goto L5;
        Message r1 = r0.getDefaultInstanceForType();
    L6:
        this.message = (MType) ZeusTransformUtils.preCheckCast(r1, GeneratedMessage.class, "com.obric.memorydata.plugin");
        BType r2 = this.builder;
        if (r2 == null) goto L9;
        r2.dispose();
        this.builder = null;
    L9:
        onChanged();
        this.isClean = true;
        return this;
    L5:
        r1 = this.builder.getDefaultInstanceForType();
        goto L6
    }

    public void dispose() {
        this.parent = null;
    }

    public BType getBuilder() {
        BType r0 = this.builder;
        if (r0 != null) goto L6;
        BType r1 = (BType) ZeusTransformUtils.preCheckCast(this.message.newBuilderForType(this), GeneratedMessage.Builder.class, "com.obric.memorydata.plugin");
        this.builder = r1;
        r1.mergeFrom(this.message);
        r1.markClean();
        return r1;
    L6:
        return r0;
    }

    public MType getMessage() {
        if (this.message != null) goto L6;
        this.message = (MType) ZeusTransformUtils.preCheckCast(this.builder.buildPartial(), GeneratedMessage.class, "com.obric.memorydata.plugin");
    L6:
        return this.message;
    }

    public IType getMessageOrBuilder() {
        BType r0 = this.builder;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.message;
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    public SingleFieldBuilder<MType, BType, IType> mergeFrom(MType r3) {
        if (this.builder != null) goto L7;
        Message r0 = this.message;
        if (r0 != r0.getDefaultInstanceForType()) goto L7;
        this.message = r3;
    L8:
        onChanged();
        return this;
    L7:
        getBuilder().mergeFrom(r3);
        goto L8
    }

    public SingleFieldBuilder<MType, BType, IType> setMessage(MType r3) {
        this.message = (MType) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3), GeneratedMessage.class, "com.obric.memorydata.plugin");
        BType r4 = this.builder;
        if (r4 == null) goto L5;
        r4.dispose();
        this.builder = null;
    L5:
        onChanged();
        return this;
    }
}
