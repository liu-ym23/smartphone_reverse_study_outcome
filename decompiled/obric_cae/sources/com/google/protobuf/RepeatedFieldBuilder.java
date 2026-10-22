package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private List<SingleFieldBuilder<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private Internal.ProtobufList<MType> messages;
    private AbstractMessage.BuilderParent parent;

    public static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements RandomAccess {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        public BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> r8) {
            this.builder = r8;
        }

        @Override // java.util.AbstractList, java.util.List
        public BType get(int r8) {
            return (BType) this.builder.getBuilder(r8);
        }

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r8) {
            return get(r8);
        }
    }

    public static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements RandomAccess {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        public MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> r8) {
            this.builder = r8;
        }

        @Override // java.util.AbstractList, java.util.List
        public MType get(int r8) {
            return (MType) this.builder.getMessage(r8);
        }

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r8) {
            return get(r8);
        }
    }

    public static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements RandomAccess {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        public MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> r8) {
            this.builder = r8;
        }

        @Override // java.util.AbstractList, java.util.List
        public IType get(int r8) {
            return (IType) this.builder.getMessageOrBuilder(r8);
        }

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r8) {
            return get(r8);
        }
    }

    public RepeatedFieldBuilder(List<MType> r8, boolean r10, AbstractMessage.BuilderParent r11, boolean r12) {
        this.messages = passthroughOrCopyToProtobufList(r8);
        this.parent = r11;
        this.isClean = r12;
    }

    private void ensureBuilders() {
        if (this.builders != null) goto L8;
        this.builders = new ArrayList(this.messages.size());
        int r8 = 0;
    L6:
        if (r8 >= this.messages.size()) goto L10;
        this.builders.add(null);
        r8 = r8 + 1;
        goto L6
    L10:
        return;
    }

    private void ensureMutableMessageList() {
        if (this.messages.isModifiable() == true) goto L6;
        Internal.ProtobufList<MType> r8 = this.messages;
        this.messages = r8.mutableCopyWithCapacity(r8.size());
        return;
    }

    private void incrementModCounts() {
        MessageExternalList<MType, BType, IType> r8 = this.externalMessageList;
        if (r8 == null) goto L5;
        r8.incrementModCount();
    L5:
        BuilderExternalList<MType, BType, IType> r10 = this.externalBuilderList;
        if (r10 == null) goto L8;
        r10.incrementModCount();
    L8:
        MessageOrBuilderExternalList<MType, BType, IType> r11 = this.externalMessageOrBuilderList;
        if (r11 == null) goto L12;
        r11.incrementModCount();
        return;
    }

    private void onChanged() {
        if (this.isClean == false) goto L8;
        AbstractMessage.BuilderParent r8 = this.parent;
        if (r8 == null) goto L9;
        r8.markDirty();
        this.isClean = false;
        return;
    L9:
        return;
    }

    private static <MsgT extends GeneratedMessage> Internal.ProtobufList<MsgT> passthroughOrCopyToProtobufList(List<MsgT> r8) {
        if ((r8 instanceof Internal.ProtobufList) == true) goto L5;
        ProtobufArrayList r10 = ProtobufArrayList.emptyList().mutableCopyWithCapacity(r8.size());
        r10.addAll(r8);
        return r10;
    L5:
        return (Internal.ProtobufList) r8;
    }

    @CanIgnoreReturnValue
    public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> r8) {
        Iterator<? extends MType> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        Internal.checkNotNull(r10.next());
        goto L4
    L7:
        if ((r8 instanceof Collection) == false) goto L12;
        Collection r11 = (Collection) r8;
        if (r11.isEmpty() == false) goto L11;
        return this;
    L11:
        int r12 = r11.size();
    L13:
        ensureMutableMessageList();
        if (r12 < 0) goto L18;
        Internal.ProtobufList<MType> r13 = this.messages;
        if ((r13 instanceof ArrayList) == false) goto L18;
        ((ArrayList) r13).ensureCapacity(r13.size() + r12);
    L18:
        Iterator<? extends MType> r14 = r8.iterator();
    L20:
        if (r14.hasNext() == false) goto L22;
        addMessage(r14.next());
        goto L20
    L22:
        onChanged();
        incrementModCounts();
        return this;
    L12:
        r12 = -1;
        goto L13
    }

    public BType addBuilder(int r8, MType r10) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r11 = new SingleFieldBuilder(r10, this, this.isClean);
        this.messages.add(r8, null);
        this.builders.add(r8, r11);
        onChanged();
        incrementModCounts();
        return (BType) r11.getBuilder();
    }

    @CanIgnoreReturnValue
    public RepeatedFieldBuilder<MType, BType, IType> addMessage(int r8, MType r10) {
        Internal.checkNotNull(r10);
        ensureMutableMessageList();
        this.messages.add(r8, r10);
        List<SingleFieldBuilder<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L5;
        r11.add(r8, null);
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
        int r8 = 0;
        if (this.messages.isModifiable() == true) goto L23;
        int r10 = 0;
    L12:
        if (r10 >= this.messages.size()) goto L19;
        MType r11 = this.messages.get(r10);
        SingleFieldBuilder<MType, BType, IType> r12 = this.builders.get(r10);
        if (r12 == null) goto L18;
        if (r12.build() == r11) goto L18;
        boolean r13 = false;
    L20:
        if (r13 == false) goto L23;
        return this.messages;
    L18:
        r10 = r10 + 1;
        goto L12
    L19:
        r13 = true;
    L23:
        ensureMutableMessageList();
    L25:
        if (r8 >= this.messages.size()) goto L27;
        this.messages.set(r8, getMessage(r8, true));
        r8 = r8 + 1;
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
        List<SingleFieldBuilder<MType, BType, IType>> r8 = this.builders;
        if (r8 == null) goto L11;
        Iterator<SingleFieldBuilder<MType, BType, IType>> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        SingleFieldBuilder<MType, BType, IType> r11 = r10.next();
        if (r11 == null) goto L6;
        r11.dispose();
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

    public BType getBuilder(int r8) {
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r10 = this.builders.get(r8);
        if (r10 != null) goto L6;
        SingleFieldBuilder<MType, BType, IType> r11 = new SingleFieldBuilder(this.messages.get(r8), this, this.isClean);
        this.builders.set(r8, r11);
        r10 = r11;
    L6:
        return (BType) r10.getBuilder();
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

    public MType getMessage(int r8) {
        return (MType) getMessage(r8, false);
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList != null) goto L6;
        this.externalMessageList = new MessageExternalList(this);
    L6:
        return this.externalMessageList;
    }

    public IType getMessageOrBuilder(int r8) {
        List<SingleFieldBuilder<MType, BType, IType>> r10 = this.builders;
        if (r10 == null) goto L5;
        SingleFieldBuilder<MType, BType, IType> r11 = r10.get(r8);
        if (r11 == null) goto L5;
        return (IType) r11.getMessageOrBuilder();
    L5:
        return this.messages.get(r8);
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

    public void remove(int r8) {
        ensureMutableMessageList();
        this.messages.remove(r8);
        List<SingleFieldBuilder<MType, BType, IType>> r10 = this.builders;
        if (r10 == null) goto L7;
        SingleFieldBuilder<MType, BType, IType> r11 = r10.remove(r8);
        if (r11 == null) goto L7;
        r11.dispose();
    L7:
        onChanged();
        incrementModCounts();
    }

    @CanIgnoreReturnValue
    public RepeatedFieldBuilder<MType, BType, IType> setMessage(int r8, MType r10) {
        Internal.checkNotNull(r10);
        ensureMutableMessageList();
        this.messages.set(r8, r10);
        List<SingleFieldBuilder<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L7;
        SingleFieldBuilder<MType, BType, IType> r12 = r11.set(r8, null);
        if (r12 == null) goto L7;
        r12.dispose();
    L7:
        onChanged();
        incrementModCounts();
        return this;
    }

    private MType getMessage(int r8, boolean r10) {
        List<SingleFieldBuilder<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L5;
        SingleFieldBuilder<MType, BType, IType> r12 = r11.get(r8);
        if (r12 == null) goto L5;
        if (r10 == false) goto L12;
        return (MType) r12.build();
    L12:
        return (MType) r12.getMessage();
    L5:
        return this.messages.get(r8);
    }

    public BType addBuilder(MType r8) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r10 = new SingleFieldBuilder(r8, this, this.isClean);
        this.messages.add(null);
        this.builders.add(r10);
        onChanged();
        incrementModCounts();
        return (BType) r10.getBuilder();
    }

    @CanIgnoreReturnValue
    public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType r8) {
        Internal.checkNotNull(r8);
        ensureMutableMessageList();
        this.messages.add(r8);
        List<SingleFieldBuilder<MType, BType, IType>> r10 = this.builders;
        if (r10 == null) goto L5;
        r10.add(null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }
}
