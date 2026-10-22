package com.ttnet.org.chromium.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes6.dex */
public class ObserverList<E> implements Iterable<E> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int mCount;
    private boolean mEnableThreadAsserts;
    private int mIterationDepth;
    private boolean mNeedsCompact;
    public final List<E> mObservers;
    private final ThreadUtils.ThreadChecker mThreadChecker;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.ObserverList$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ObserverListIterator implements RewindableIterator<E> {
        private int mIndex;
        private boolean mIsExhausted;
        private int mListEndMarker;
        final /* synthetic */ ObserverList this$0;

        private ObserverListIterator(ObserverList r1) {
            this.this$0 = r1;
            ObserverList.access$100(r1);
            this.mListEndMarker = ObserverList.access$200(r1);
        }

        /* synthetic */ ObserverListIterator(ObserverList r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void compactListIfNeeded() {
            if (this.mIsExhausted == true) goto L6;
            this.mIsExhausted = true;
            ObserverList.access$600(this.this$0);
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (ObserverList.access$300(this.this$0) == false) goto L5;
            ObserverList.access$400(this.this$0).assertOnValidThread();
        L5:
            int r0 = this.mIndex;
        L7:
            if (r0 >= this.mListEndMarker) goto L12;
            if (ObserverList.access$500(this.this$0, r0) != null) goto L12;
            r0 = r0 + 1;
        L12:
            if (r0 >= this.mListEndMarker) goto L15;
            return true;
        L15:
            compactListIfNeeded();
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            if (ObserverList.access$300(this.this$0) == false) goto L5;
            ObserverList.access$400(this.this$0).assertOnValidThread();
        L5:
            int r0 = this.mIndex;
            if (r0 >= this.mListEndMarker) goto L10;
            if (ObserverList.access$500(this.this$0, r0) != null) goto L10;
            this.mIndex++;
        L10:
            int r1 = this.mIndex;
            if (r1 >= this.mListEndMarker) goto L14;
            ObserverList r2 = this.this$0;
            this.mIndex = r1 + 1;
            return (E) ObserverList.access$500(r2, r1);
        L14:
            compactListIfNeeded();
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // com.ttnet.org.chromium.base.ObserverList.RewindableIterator
        public void rewind() {
            if (ObserverList.access$300(this.this$0) == false) goto L5;
            ObserverList.access$400(this.this$0).assertOnValidThread();
        L5:
            compactListIfNeeded();
            ObserverList.access$100(this.this$0);
            this.mListEndMarker = ObserverList.access$200(this.this$0);
            this.mIsExhausted = false;
            this.mIndex = 0;
        }
    }

    public interface RewindableIterator<E> extends Iterator<E> {
        void rewind();
    }

    static {
    }

    public ObserverList() {
        this.mObservers = new ArrayList();
        this.mEnableThreadAsserts = true;
        this.mThreadChecker = new ThreadUtils.ThreadChecker();
    }

    static /* synthetic */ void access$100(ObserverList r0) {
        r0.incrementIterationDepth();
    }

    static /* synthetic */ int access$200(ObserverList r0) {
        return r0.capacity();
    }

    static /* synthetic */ boolean access$300(ObserverList r0) {
        return r0.mEnableThreadAsserts;
    }

    static /* synthetic */ ThreadUtils.ThreadChecker access$400(ObserverList r0) {
        return r0.mThreadChecker;
    }

    static /* synthetic */ Object access$500(ObserverList r0, int r1) {
        return r0.getObserverAt(r1);
    }

    static /* synthetic */ void access$600(ObserverList r0) {
        r0.decrementIterationDepthAndCompactIfNeeded();
    }

    private int capacity() {
        return this.mObservers.size();
    }

    private void compact() {
        int r0 = this.mObservers.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (this.mObservers.get(r0) != null) goto L7;
        this.mObservers.remove(r0);
    L7:
        r0 = r0 - 1;
        goto L3
    }

    private void decrementIterationDepthAndCompactIfNeeded() {
        int r0 = this.mIterationDepth - 1;
        this.mIterationDepth = r0;
        if (r0 <= 0) goto L6;
        return;
    L6:
        if (this.mNeedsCompact == true) goto L8;
        return;
    L8:
        this.mNeedsCompact = false;
        compact();
    }

    private E getObserverAt(int r1) {
        return this.mObservers.get(r1);
    }

    private void incrementIterationDepth() {
        this.mIterationDepth++;
    }

    public boolean addObserver(E r2) {
        if (this.mEnableThreadAsserts == false) goto L5;
        this.mThreadChecker.assertOnValidThread();
    L5:
        if (r2 != null) goto L7;
        return false;
    L7:
        if (this.mObservers.contains(r2) == true) goto L13;
        this.mObservers.add(r2);
        this.mCount++;
        return true;
    L13:
        return false;
    }

    public void clear() {
        if (this.mEnableThreadAsserts == false) goto L5;
        this.mThreadChecker.assertOnValidThread();
    L5:
        int r0 = 0;
        this.mCount = 0;
        if (this.mIterationDepth != 0) goto L9;
        this.mObservers.clear();
        return;
    L9:
        int r1 = this.mObservers.size();
        boolean r2 = this.mNeedsCompact;
        if (r1 == 0) goto L12;
        boolean r3 = true;
    L13:
        this.mNeedsCompact = r2 | r3;
    L14:
        if (r0 >= r1) goto L16;
        this.mObservers.set(r0, null);
        r0 = r0 + 1;
        goto L14
    L16:
        return;
    L12:
        r3 = false;
        goto L13
    }

    public void disableThreadAsserts() {
        this.mEnableThreadAsserts = false;
    }

    public boolean hasObserver(E r2) {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        return this.mObservers.contains(r2);
    }

    public boolean isEmpty() {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        if (this.mCount != 0) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        return new ObserverListIterator(this, null);
    }

    public boolean removeObserver(E r4) {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        if (r4 != null) goto L8;
        return false;
    L8:
        int r5 = this.mObservers.indexOf(r4);
        if (r5 != (-1)) goto L12;
        return false;
    L12:
        if (this.mIterationDepth != 0) goto L14;
        this.mObservers.remove(r5);
    L15:
        this.mCount--;
        return true;
    L14:
        this.mNeedsCompact = true;
        this.mObservers.set(r5, null);
        goto L15
    }

    public RewindableIterator<E> rewindableIterator() {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        return new ObserverListIterator(this, null);
    }

    public int size() {
        if (this.mEnableThreadAsserts == false) goto L6;
        this.mThreadChecker.assertOnValidThread();
    L6:
        return this.mCount;
    }
}
