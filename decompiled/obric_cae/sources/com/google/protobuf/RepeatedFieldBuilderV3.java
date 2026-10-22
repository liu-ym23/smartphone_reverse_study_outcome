package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RepeatedFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private List<SingleFieldBuilderV3<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List<MType> messages;
    private AbstractMessage.BuilderParent parent;

    public static class BuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements RandomAccess {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        @Deprecated
        public BuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r8) {
            this.builder = r8;
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public BType get(int r8) {
            return (BType) this.builder.getBuilder(r8);
        }

        @Deprecated
        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public /* bridge */ /* synthetic */ Object get(int r8) {
            return get(r8);
        }
    }

    public static class MessageExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements RandomAccess {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        @Deprecated
        public MessageExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r8) {
            this.builder = r8;
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public MType get(int r8) {
            return (MType) this.builder.getMessage(r8);
        }

        @Deprecated
        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public /* bridge */ /* synthetic */ Object get(int r8) {
            return get(r8);
        }
    }

    public static class MessageOrBuilderExternalList<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements RandomAccess {
        RepeatedFieldBuilderV3<MType, BType, IType> builder;

        public MessageOrBuilderExternalList(RepeatedFieldBuilderV3<MType, BType, IType> r8) {
            this.builder = r8;
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public IType get(int r8) {
            return (IType) this.builder.getMessageOrBuilder(r8);
        }

        @Deprecated
        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        @Deprecated
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        @Deprecated
        public /* bridge */ /* synthetic */ Object get(int r8) {
            return get(r8);
        }
    }

    @Deprecated
    public RepeatedFieldBuilderV3(List<MType> r8, boolean r10, AbstractMessage.BuilderParent r11, boolean r12) {
        this.messages = r8;
        this.isMessagesListMutable = r10;
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
        if (this.isMessagesListMutable == true) goto L6;
        this.messages = new ArrayList(this.messages);
        this.isMessagesListMutable = true;
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

    @CanIgnoreReturnValue
    @Deprecated
    public RepeatedFieldBuilderV3<MType, BType, IType> addAllMessages(Iterable<? extends MType> r8) {
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
        List<MType> r13 = this.messages;
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

    @Deprecated
    public BType addBuilder(int r8, MType r10) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r11 = new SingleFieldBuilderV3(r10, this, this.isClean);
        this.messages.add(r8, null);
        this.builders.add(r8, r11);
        onChanged();
        incrementModCounts();
        return (BType) r11.getBuilder();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(int r8, MType r10) {
        Internal.checkNotNull(r10);
        ensureMutableMessageList();
        this.messages.add(r8, r10);
        List<SingleFieldBuilderV3<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L5;
        r11.add(r8, null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }

    @Deprecated
    public List<MType> build() {
        this.isClean = true;
        boolean r8 = this.isMessagesListMutable;
        if (r8 == true) goto L9;
        if (this.builders != null) goto L9;
        return this.messages;
    L9:
        if (r8 == true) goto L23;
        int r10 = 0;
    L12:
        if (r10 >= this.messages.size()) goto L19;
        MType r11 = this.messages.get(r10);
        SingleFieldBuilderV3<MType, BType, IType> r12 = this.builders.get(r10);
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
        int r14 = 0;
    L25:
        if (r14 >= this.messages.size()) goto L27;
        this.messages.set(r14, (MType) getMessage(r14, true));
        r14 = r14 + 1;
        goto L25
    L27:
        List<MType> r15 = Collections.unmodifiableList(this.messages);
        this.messages = r15;
        this.isMessagesListMutable = false;
        return r15;
    }

    @Deprecated
    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        List<SingleFieldBuilderV3<MType, BType, IType>> r8 = this.builders;
        if (r8 == null) goto L11;
        Iterator<SingleFieldBuilderV3<MType, BType, IType>> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        SingleFieldBuilderV3<MType, BType, IType> r11 = r10.next();
        if (r11 == null) goto L6;
        r11.dispose();
        goto L6
    L10:
        this.builders = null;
    L11:
        onChanged();
        incrementModCounts();
    }

    @Deprecated
    public void dispose() {
        this.parent = null;
    }

    @Deprecated
    public BType getBuilder(int r8) {
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r10 = this.builders.get(r8);
        if (r10 != null) goto L6;
        SingleFieldBuilderV3<MType, BType, IType> r11 = new SingleFieldBuilderV3(this.messages.get(r8), this, this.isClean);
        this.builders.set(r8, r11);
        r10 = r11;
    L6:
        return (BType) r10.getBuilder();
    }

    @Deprecated
    public List<BType> getBuilderList() {
        if (this.externalBuilderList != null) goto L6;
        this.externalBuilderList = new BuilderExternalList(this);
    L6:
        return this.externalBuilderList;
    }

    @Deprecated
    public int getCount() {
        return this.messages.size();
    }

    @Deprecated
    public MType getMessage(int r8) {
        return (MType) getMessage(r8, false);
    }

    @Deprecated
    public List<MType> getMessageList() {
        if (this.externalMessageList != null) goto L6;
        this.externalMessageList = new MessageExternalList(this);
    L6:
        return this.externalMessageList;
    }

    @Deprecated
    public IType getMessageOrBuilder(int r8) {
        List<SingleFieldBuilderV3<MType, BType, IType>> r10 = this.builders;
        if (r10 == null) goto L5;
        SingleFieldBuilderV3<MType, BType, IType> r11 = r10.get(r8);
        if (r11 == null) goto L5;
        return (IType) r11.getMessageOrBuilder();
    L5:
        return this.messages.get(r8);
    }

    @Deprecated
    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList != null) goto L6;
        this.externalMessageOrBuilderList = new MessageOrBuilderExternalList(this);
    L6:
        return this.externalMessageOrBuilderList;
    }

    @Deprecated
    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    @Deprecated
    public void markDirty() {
        onChanged();
    }

    @Deprecated
    public void remove(int r8) {
        ensureMutableMessageList();
        this.messages.remove(r8);
        List<SingleFieldBuilderV3<MType, BType, IType>> r10 = this.builders;
        if (r10 == null) goto L7;
        SingleFieldBuilderV3<MType, BType, IType> r11 = r10.remove(r8);
        if (r11 == null) goto L7;
        r11.dispose();
    L7:
        onChanged();
        incrementModCounts();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public RepeatedFieldBuilderV3<MType, BType, IType> setMessage(int r8, MType r10) {
        Internal.checkNotNull(r10);
        ensureMutableMessageList();
        this.messages.set(r8, r10);
        List<SingleFieldBuilderV3<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L7;
        SingleFieldBuilderV3<MType, BType, IType> r12 = r11.set(r8, null);
        if (r12 == null) goto L7;
        r12.dispose();
    L7:
        onChanged();
        incrementModCounts();
        return this;
    }

    private MType getMessage(int r8, boolean r10) {
        List<SingleFieldBuilderV3<MType, BType, IType>> r11 = this.builders;
        if (r11 == null) goto L5;
        SingleFieldBuilderV3<MType, BType, IType> r12 = r11.get(r8);
        if (r12 == null) goto L5;
        if (r10 == false) goto L12;
        return (MType) r12.build();
    L12:
        return (MType) r12.getMessage();
    L5:
        return this.messages.get(r8);
    }

    @Deprecated
    public BType addBuilder(MType r8) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilderV3<MType, BType, IType> r10 = new SingleFieldBuilderV3(r8, this, this.isClean);
        this.messages.add(null);
        this.builders.add(r10);
        onChanged();
        incrementModCounts();
        return (BType) r10.getBuilder();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public RepeatedFieldBuilderV3<MType, BType, IType> addMessage(MType r8) {
        Internal.checkNotNull(r8);
        ensureMutableMessageList();
        this.messages.add(r8);
        List<SingleFieldBuilderV3<MType, BType, IType>> r10 = this.builders;
        if (r10 == null) goto L5;
        r10.add(null);
    L5:
        onChanged();
        incrementModCounts();
        return this;
    }
}
