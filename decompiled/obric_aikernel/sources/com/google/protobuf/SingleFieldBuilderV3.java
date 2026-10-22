package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class SingleFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private AbstractMessage.BuilderParent parent;

    @Deprecated
    public SingleFieldBuilderV3(MType r10, AbstractMessage.BuilderParent r11, boolean r12) {
        this.message = (MType) Internal.checkNotNull(r10);
        this.parent = r11;
        this.isClean = r12;
    }

    @Deprecated
    private void onChanged() {
        if (this.builder == null) goto L6;
        this.message = null;
    L6:
        if (this.isClean == false) goto L11;
        AbstractMessage.BuilderParent r10 = this.parent;
        if (r10 == null) goto L12;
        r10.markDirty();
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
        MessageOrBuilder r10 = this.message;
        if (r10 != null) goto L6;
        r10 = this.builder;
    L6:
        this.message = (MType) r10.getDefaultInstanceForType();
        BType r11 = this.builder;
        if (r11 == null) goto L9;
        r11.dispose();
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
        BType r10 = (BType) this.message.newBuilderForType(this);
        this.builder = r10;
        r10.mergeFrom(this.message);
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
        BType r10 = this.builder;
        if (r10 == null) goto L6;
        return r10;
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
    public SingleFieldBuilderV3<MType, BType, IType> mergeFrom(MType r10) {
        if (this.builder != null) goto L7;
        Message r11 = this.message;
        if (r11 != r11.getDefaultInstanceForType()) goto L7;
        this.message = r10;
    L8:
        onChanged();
        return this;
    L7:
        getBuilder().mergeFrom(r10);
        goto L8
    }

    @CanIgnoreReturnValue
    @Deprecated
    public SingleFieldBuilderV3<MType, BType, IType> setMessage(MType r10) {
        this.message = (MType) Internal.checkNotNull(r10);
        BType r11 = this.builder;
        if (r11 == null) goto L5;
        r11.dispose();
        this.builder = null;
    L5:
        onChanged();
        return this;
    }
}
