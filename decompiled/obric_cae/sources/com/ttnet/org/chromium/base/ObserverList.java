package com.ttnet.org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: classes2.dex */
@NotThreadSafe
public class ObserverList<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int mCount;
    private int mIterationDepth;
    private boolean mNeedsCompact;
    public final List<E> mObservers;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.ObserverList$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ObserverListIterator implements RewindableIterator<E> {
        private int mIndex;
        private boolean mIsExhausted;
        private int mListEndMarker;
        final /* synthetic */ ObserverList this$0;

        private ObserverListIterator(ObserverList r8) {
            this.this$0 = r8;
            ObserverList.access$100(r8);
            this.mListEndMarker = ObserverList.access$200(r8);
        }

        private void compactListIfNeeded() {
            if (this.mIsExhausted == true) goto L6;
            this.mIsExhausted = true;
            ObserverList.access$400(this.this$0);
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int r8 = this.mIndex;
        L4:
            if (r8 >= this.mListEndMarker) goto L9;
            if (ObserverList.access$300(this.this$0, r8) != null) goto L9;
            r8 = r8 + 1;
        L9:
            if (r8 >= this.mListEndMarker) goto L12;
            return true;
        L12:
            compactListIfNeeded();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
        L2:
            int r8 = this.mIndex;
            if (r8 >= this.mListEndMarker) goto L7;
            if (ObserverList.access$300(this.this$0, r8) != null) goto L7;
            this.mIndex++;
        L7:
            int r10 = this.mIndex;
            if (r10 >= this.mListEndMarker) goto L11;
            ObserverList r11 = this.this$0;
            this.mIndex = r10 + 1;
            return (E) ObserverList.access$300(r11, r10);
        L11:
            compactListIfNeeded();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // com.ttnet.org.chromium.base.ObserverList.RewindableIterator
        public void rewind() {
            compactListIfNeeded();
            ObserverList.access$100(this.this$0);
            this.mListEndMarker = ObserverList.access$200(this.this$0);
            this.mIsExhausted = false;
            this.mIndex = 0;
        }

        public /* synthetic */ ObserverListIterator(ObserverList r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public interface RewindableIterator<E> extends Iterator<E> {
        void rewind();
    }

    public ObserverList() {
        this.mObservers = new ArrayList();
    }

    public static /* synthetic */ void access$100(ObserverList r8) {
        r8.incrementIterationDepth();
    }

    public static /* synthetic */ int access$200(ObserverList r8) {
        return r8.capacity();
    }

    public static /* synthetic */ Object access$300(ObserverList r8, int r10) {
        return r8.getObserverAt(r10);
    }

    public static /* synthetic */ void access$400(ObserverList r8) {
        r8.decrementIterationDepthAndCompactIfNeeded();
    }

    private int capacity() {
        return this.mObservers.size();
    }

    private void compact() {
        int r8 = this.mObservers.size() - 1;
    L3:
        if (r8 < 0) goto L8;
        if (this.mObservers.get(r8) != null) goto L7;
        this.mObservers.remove(r8);
    L7:
        r8 = r8 - 1;
        goto L3
    }

    private void decrementIterationDepthAndCompactIfNeeded() {
        int r8 = this.mIterationDepth - 1;
        this.mIterationDepth = r8;
        if (r8 <= 0) goto L6;
        return;
    L6:
        if (this.mNeedsCompact == true) goto L8;
        return;
    L8:
        this.mNeedsCompact = false;
        compact();
    }

    private E getObserverAt(int r8) {
        return this.mObservers.get(r8);
    }

    private void incrementIterationDepth() {
        this.mIterationDepth++;
    }

    public boolean addObserver(E r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if (this.mObservers.contains(r8) == true) goto L10;
        this.mObservers.add(r8);
        this.mCount++;
        return true;
    L10:
        return false;
    }

    public void clear() {
        int r8 = 0;
        this.mCount = 0;
        if (this.mIterationDepth != 0) goto L6;
        this.mObservers.clear();
        return;
    L6:
        int r10 = this.mObservers.size();
        boolean r11 = this.mNeedsCompact;
        if (r10 == 0) goto L9;
        boolean r12 = true;
    L10:
        this.mNeedsCompact = r11 | r12;
    L11:
        if (r8 >= r10) goto L13;
        this.mObservers.set(r8, null);
        r8 = r8 + 1;
        goto L11
    L13:
        return;
    L9:
        r12 = false;
        goto L10
    }

    public boolean hasObserver(E r8) {
        return this.mObservers.contains(r8);
    }

    public boolean isEmpty() {
        if (this.mCount != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new ObserverListIterator(this, null);
    }

    public boolean removeObserver(E r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        int r10 = this.mObservers.indexOf(r8);
        if (r10 != (-1)) goto L9;
        return false;
    L9:
        if (this.mIterationDepth != 0) goto L11;
        this.mObservers.remove(r10);
    L12:
        this.mCount--;
        return true;
    L11:
        this.mNeedsCompact = true;
        this.mObservers.set(r10, null);
        goto L12
    }

    public RewindableIterator<E> rewindableIterator() {
        return new ObserverListIterator(this, null);
    }

    public int size() {
        return this.mCount;
    }
}
