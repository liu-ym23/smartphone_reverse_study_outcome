package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private List<SingleFieldBuilder<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private Internal.ProtobufList<MType> messages;
    private AbstractMessage.BuilderParent parent;

    /* JADX WARN: Unexpected interfaces in signature: [java.util.RandomAccess] */
    private static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> r10) {
            this.builder = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public BType get(int r10) {
            return (BType) this.builder.getBuilder(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }
    }

    /* JADX WARN: Unexpected interfaces in signature: [java.util.RandomAccess] */
    private static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> r10) {
            this.builder = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public MType get(int r10) {
            return (MType) this.builder.getMessage(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }
    }

    /* JADX WARN: Unexpected interfaces in signature: [java.util.RandomAccess] */
    private static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> r10) {
            this.builder = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public IType get(int r10) {
            return (IType) this.builder.getMessageOrBuilder(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }
    }

    public RepeatedFieldBuilder(List<MType> r10, boolean r11, AbstractMessage.BuilderParent r12, boolean r13) {
        this.messages = passthroughOrCopyToProtobufList(r10);
        this.parent = r12;
        this.isClean = r13;
    }

    private void ensureBuilders() {
        if (this.builders != null) goto L8;
        this.builders = new ArrayList(this.messages.size());
        int r10 = 0;
    L6:
        if (r10 >= this.messages.size()) goto L10;
        this.builders.add(null);
        r10 = r10 + 1;
        goto L6
    L10:
        return;
    }

    private void ensureMutableMessageList() {
        if (this.messages.isModifiable() == true) goto L6;
        Internal.ProtobufList<MType> r10 = this.messages;
        this.messages = r10.mutableCopyWithCapacity(r10.size());
        return;
    }

    private MType getMessage(int r10, boolean r11) {
        List<SingleFieldBuilder<MType, BType, IType>> r12 = this.builders;
        if (r12 == null) goto L5;
        SingleFieldBuilder<MType, BType, IType> r13 = r12.get(r10);
        if (r13 == null) goto L5;
        if (r11 == false) goto L12;
        return (MType) r13.build();
    L12:
        return (MType) r13.getMessage();
    L5:
        return this.messages.get(r10);
    }

    private void incrementModCounts() {
        MessageExternalList<MType, BType, IType> r10 = this.externalMessageList;
        if (r10 == null) goto L5;
        r10.incrementModCount();
    L5:
        BuilderExternalList<MType, BType, IType> r11 = this.externalBuilderList;
        if (r11 == null) goto L8;
        r11.incrementModCount();
    L8:
        MessageOrBuilderExternalList<MType, BType, IType> r12 = this.externalMessageOrBuilderList;
        if (r12 == null) goto L12;
        r12.incrementModCount();
        return;
    }

    private void onChanged() {
        if (this.isClean == false) goto L8;
        AbstractMessage.BuilderParent r10 = this.parent;
        if (r10 == null) goto L9;
        r10.markDirty();
        this.isClean = false;
        return;
    L9:
        return;
    }

    private static <MsgT extends GeneratedMessage> Internal.ProtobufList<MsgT> passthroughOrCopyToProtobufList(List<MsgT> r10) {
        if ((r10 instanceof Internal.ProtobufList) == true) goto L5;
        ProtobufArrayList r11 = ProtobufArrayList.emptyList().mutableCopyWithCapacity(r10.size());
        r11.addAll(r10);
        return r11;
    L5:
        return (Internal.ProtobufList) r10;
    }

    @CanIgnoreReturnValue
    public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> r10) {
        Iterator<? extends MType> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Internal.checkNotNull(r11.next());
        goto L4
    L6:
        int r12 = -1;
        if ((r10 instanceof Collection) == false) goto L12;
        Collection r13 = (Collection) r10;
        if (r13.isEmpty() == false) goto L11;
        return this;
    L11:
        r12 = r13.size();
    L12:
        ensureMutableMessageList();
        if (r12 < 0) goto L17;
        Internal.ProtobufList<MType> r14 = this.messages;
        if ((r14 instanceof ArrayList) == false) goto L17;
        ((ArrayList) r14).ensureCapacity(r14.size() + r12);
    L17:
        Iterator<? extends MType> r15 = r10.iterator();
    L19:
        if (r15.hasNext() == false) goto L21;
        addMessage(r15.next());
        goto L19
    L21:
        onChanged();
        incrementModCounts();
        return this;
    }

    public BType addBuilder(int r10, MType r11) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r12 = new SingleFieldBuilder(r11, this, this.isClean);
        this.messages.add(r10, null);
        this.builders.add(r10, r12);
        onChanged();
        incrementModCounts();
        return (BType) r12.getBuilder();
    }

    public BType addBuilder(MType r10) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r11 = new SingleFieldBuilder(r10, this, this.isClean);
        this.messages.add(null);
        this.builders.add(r11);
        onChanged();
        incrementModCounts();
        return (BType) r11.getBuilder();
    }

    @CanIgnoreReturnValue
    public RepeatedFieldBuilder<MType, BType, IType> addMessage(int r10, MType r11) {
        Internal.checkNotNull(r11);
        ensureMutableMessageList();
        this.messages.add(r10, r11);
        List<SingleFieldBuilder<MType, BType, IType>> r12 = this.builders;
        if (r12 == null) goto L5;
        r12.add(r10, null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }

    @CanIgnoreReturnValue
    public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType r10) {
        Internal.checkNotNull(r10);
        ensureMutableMessageList();
        this.messages.add(r10);
        List<SingleFieldBuilder<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L5;
        r11.add(null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public List<MType> build() {
        this.isClean = true;
        if (this.messages.isModifiable() == false) goto L5;
    L8:
        int r10 = 0;
        if (this.messages.isModifiable() == true) goto L23;
        int r11 = 0;
    L12:
        if (r11 >= this.messages.size()) goto L19;
        MType r12 = this.messages.get(r11);
        SingleFieldBuilder<MType, BType, IType> r13 = this.builders.get(r11);
        if (r13 == null) goto L18;
        if (r13.build() == r12) goto L18;
        boolean r14 = false;
    L20:
        if (r14 == false) goto L23;
        return this.messages;
    L18:
        r11 = r11 + 1;
        goto L12
    L19:
        r14 = true;
    L23:
        ensureMutableMessageList();
    L25:
        if (r10 >= this.messages.size()) goto L27;
        this.messages.set(r10, getMessage(r10, true));
        r10 = r10 + 1;
        goto L25
    L27:
        this.messages.makeImmutable();
        return this.messages;
    L5:
        if (this.builders != null) goto L8;
        return this.messages;
    }

    public void clear() {
        this.messages = ProtobufArrayList.emptyList();
        List<SingleFieldBuilder<MType, BType, IType>> r10 = this.builders;
        if (r10 == null) goto L11;
        Iterator<SingleFieldBuilder<MType, BType, IType>> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        SingleFieldBuilder<MType, BType, IType> r12 = r11.next();
        if (r12 == null) goto L6;
        r12.dispose();
        goto L6
    L10:
        this.builders = null;
    L11:
        onChanged();
        incrementModCounts();
    }

    public void dispose() {
        this.parent = null;
    }

    public BType getBuilder(int r10) {
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r11 = this.builders.get(r10);
        if (r11 != null) goto L6;
        SingleFieldBuilder<MType, BType, IType> r12 = new SingleFieldBuilder(this.messages.get(r10), this, this.isClean);
        this.builders.set(r10, r12);
        r11 = r12;
    L6:
        return (BType) r11.getBuilder();
    }

    public List<BType> getBuilderList() {
        if (this.externalBuilderList != null) goto L6;
        this.externalBuilderList = new BuilderExternalList(this);
    L6:
        return this.externalBuilderList;
    }

    public int getCount() {
        return this.messages.size();
    }

    public MType getMessage(int r10) {
        return (MType) getMessage(r10, false);
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList != null) goto L6;
        this.externalMessageList = new MessageExternalList(this);
    L6:
        return this.externalMessageList;
    }

    public IType getMessageOrBuilder(int r10) {
        List<SingleFieldBuilder<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L5;
        SingleFieldBuilder<MType, BType, IType> r12 = r11.get(r10);
        if (r12 == null) goto L5;
        return (IType) r12.getMessageOrBuilder();
    L5:
        return this.messages.get(r10);
    }

    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList != null) goto L6;
        this.externalMessageOrBuilderList = new MessageOrBuilderExternalList(this);
    L6:
        return this.externalMessageOrBuilderList;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    public void remove(int r10) {
        ensureMutableMessageList();
        this.messages.remove(r10);
        List<SingleFieldBuilder<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L7;
        SingleFieldBuilder<MType, BType, IType> r12 = r11.remove(r10);
        if (r12 == null) goto L7;
        r12.dispose();
    L7:
        onChanged();
        incrementModCounts();
    }

    @CanIgnoreReturnValue
    public RepeatedFieldBuilder<MType, BType, IType> setMessage(int r10, MType r11) {
        Internal.checkNotNull(r11);
        ensureMutableMessageList();
        this.messages.set(r10, r11);
        List<SingleFieldBuilder<MType, BType, IType>> r12 = this.builders;
        if (r12 == null) goto L7;
        SingleFieldBuilder<MType, BType, IType> r13 = r12.set(r10, null);
        if (r13 == null) goto L7;
        r13.dispose();
    L7:
        onChanged();
        incrementModCounts();
        return this;
    }
}
