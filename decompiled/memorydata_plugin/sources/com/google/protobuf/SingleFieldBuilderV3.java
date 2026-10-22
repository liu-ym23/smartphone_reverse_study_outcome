package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class SingleFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private AbstractMessage.BuilderParent parent;

    @Deprecated
    public SingleFieldBuilderV3(MType r3, AbstractMessage.BuilderParent r4, boolean r5) {
        AbstractMessage.BuilderParent r6 = (AbstractMessage.BuilderParent) ZeusTransformUtils.wrapperContextForParams(r4, AbstractMessage.BuilderParent.class, "com.obric.memorydata.plugin");
        this.message = (MType) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3), AbstractMessage.class, "com.obric.memorydata.plugin");
        this.parent = r6;
        this.isClean = r5;
    }

    @Deprecated
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

    @Deprecated
    public MType build() {
        this.isClean = true;
        return (MType) getMessage();
    }

    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> clear() {
        MType r0 = this.message;
        if (r0 == null) goto L5;
        Message r1 = r0.getDefaultInstanceForType();
    L6:
        this.message = (MType) ZeusTransformUtils.preCheckCast(r1, AbstractMessage.class, "com.obric.memorydata.plugin");
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

    @Deprecated
    public void dispose() {
        this.parent = null;
    }

    @Deprecated
    public BType getBuilder() {
        if (this.builder != null) goto L6;
        BType r0 = (BType) ZeusTransformUtils.preCheckCast(this.message.newBuilderForType(this), AbstractMessage.Builder.class, "com.obric.memorydata.plugin");
        this.builder = r0;
        r0.mergeFrom(this.message);
        this.builder.markClean();
    L6:
        return this.builder;
    }

    @Deprecated
    public MType getMessage() {
        if (this.message != null) goto L6;
        this.message = (MType) ZeusTransformUtils.preCheckCast(this.builder.buildPartial(), AbstractMessage.class, "com.obric.memorydata.plugin");
    L6:
        return this.message;
    }

    @Deprecated
    public IType getMessageOrBuilder() {
        BType r0 = this.builder;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.message;
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    @Deprecated
    public void markDirty() {
        onChanged();
    }

    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> mergeFrom(MType r3) {
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

    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> setMessage(MType r3) {
        this.message = (MType) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3), AbstractMessage.class, "com.obric.memorydata.plugin");
        BType r4 = this.builder;
        if (r4 == null) goto L5;
        r4.dispose();
        this.builder = null;
    L5:
        onChanged();
        return this;
    }
}
