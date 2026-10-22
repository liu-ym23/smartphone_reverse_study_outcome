package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SingleFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private AbstractMessage.BuilderParent parent;

    @Deprecated
    public SingleFieldBuilderV3(MType r8, AbstractMessage.BuilderParent r10, boolean r11) {
        this.message = (MType) Internal.checkNotNull(r8);
        this.parent = r10;
        this.isClean = r11;
    }

    @Deprecated
    private void onChanged() {
        if (this.builder == null) goto L6;
        this.message = null;
    L6:
        if (this.isClean == false) goto L11;
        AbstractMessage.BuilderParent r8 = this.parent;
        if (r8 == null) goto L12;
        r8.markDirty();
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

    @CanIgnoreReturnValue
    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> clear() {
        MessageOrBuilder r8 = this.message;
        if (r8 != null) goto L6;
        r8 = this.builder;
    L6:
        this.message = (MType) r8.getDefaultInstanceForType();
        BType r10 = this.builder;
        if (r10 == null) goto L9;
        r10.dispose();
        this.builder = null;
    L9:
        onChanged();
        this.isClean = true;
        return this;
    }

    @Deprecated
    public void dispose() {
        this.parent = null;
    }

    @Deprecated
    public BType getBuilder() {
        if (this.builder != null) goto L6;
        BType r8 = (BType) this.message.newBuilderForType(this);
        this.builder = r8;
        r8.mergeFrom(this.message);
        this.builder.markClean();
    L6:
        return this.builder;
    }

    @Deprecated
    public MType getMessage() {
        if (this.message != null) goto L6;
        this.message = (MType) this.builder.buildPartial();
    L6:
        return this.message;
    }

    @Deprecated
    public IType getMessageOrBuilder() {
        BType r8 = this.builder;
        if (r8 == null) goto L6;
        return r8;
    L6:
        return this.message;
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    @Deprecated
    public void markDirty() {
        onChanged();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> mergeFrom(MType r8) {
        if (this.builder != null) goto L7;
        Message r10 = this.message;
        if (r10 != r10.getDefaultInstanceForType()) goto L7;
        this.message = r8;
    L8:
        onChanged();
        return this;
    L7:
        getBuilder().mergeFrom(r8);
        goto L8
    }

    @CanIgnoreReturnValue
    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> setMessage(MType r8) {
        this.message = (MType) Internal.checkNotNull(r8);
        BType r10 = this.builder;
        if (r10 == null) goto L5;
        r10.dispose();
        this.builder = null;
    L5:
        onChanged();
        return this;
    }
}
