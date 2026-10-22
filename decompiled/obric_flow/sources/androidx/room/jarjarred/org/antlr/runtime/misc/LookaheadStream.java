package androidx.room.jarjarred.org.antlr.runtime.misc;

/* JADX INFO: loaded from: classes.dex */
public abstract class LookaheadStream<T> extends FastQueue<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int UNINITIALIZED_EOF_ELEMENT_INDEX = Integer.MAX_VALUE;
    protected int currentElementIndex;
    public T eof;
    protected int lastMarker;
    protected int markDepth;
    protected T prevElement;

    public LookaheadStream() {
        this.currentElementIndex = 0;
        this.eof = null;
        this.markDepth = 0;
    }

    public T LB(int r5) {
        int r10 = this.f631p - r5;
        if (r10 == (-1)) goto L5;
        if (r10 >= 0) goto L8;
        if (r10 >= (-1)) goto L13;
        throw new UnsupportedOperationException("can't look more than one token before the beginning of this stream's buffer");
    L13:
        throw new UnsupportedOperationException("can't look past the end of this stream's buffer using LB(int)");
    L8:
        return this.data.get(r10);
    L5:
        return this.prevElement;
    }

    public T LT(int r5) {
        if (r5 != 0) goto L5;
        return null;
    L5:
        if (r5 < 0) goto L7;
        syncAhead(r5);
        if (((this.f631p + r5) - 1) <= this.data.size()) goto L13;
        return this.eof;
    L13:
        return elementAt(r5 - 1);
    L7:
        return LB(-r5);
    }

    public void consume() {
        syncAhead(1);
        remove();
        this.currentElementIndex++;
    }

    public void fill(int r5) {
        int r10 = 1;
    L3:
        if (r10 > r5) goto L8;
        T r11 = nextElement();
        if (isEOF(r11) == false) goto L7;
        this.eof = r11;
    L7:
        this.data.add(r11);
        r10 = r10 + 1;
        goto L3
    }

    public int index() {
        return this.currentElementIndex;
    }

    public abstract boolean isEOF(T r5);

    public int mark() {
        this.markDepth++;
        int r5 = this.f631p;
        this.lastMarker = r5;
        return r5;
    }

    public abstract T nextElement();

    public void release(int r5) {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.FastQueue
    public T remove() {
        T r5 = elementAt(0);
        int r10 = this.f631p + 1;
        this.f631p = r10;
        if (r10 == this.data.size()) goto L5;
    L7:
        return r5;
    L5:
        if (this.markDepth != 0) goto L7;
        this.prevElement = r5;
        clear();
        goto L7
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.FastQueue
    public void reset() {
        super.reset();
        this.currentElementIndex = 0;
        this.f631p = 0;
        this.prevElement = null;
    }

    public void rewind(int r5) {
        this.markDepth--;
        this.currentElementIndex -= this.f631p - r5;
        this.f631p = r5;
    }

    public void seek(int r5) {
        if (r5 < 0) goto L10;
        int r10 = this.currentElementIndex - r5;
        int r11 = this.f631p;
        if ((r11 - r10) < 0) goto L8;
        this.f631p = r11 - r10;
        this.currentElementIndex = r5;
        return;
    L8:
        throw new UnsupportedOperationException("can't seek before the beginning of this stream's buffer");
    L10:
        throw new IllegalArgumentException("can't seek before the beginning of the input");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.misc.FastQueue
    public int size() {
        throw new UnsupportedOperationException("streams are of unknown size");
    }

    public void syncAhead(int r5) {
        int r10 = (((this.f631p + r5) - 1) - this.data.size()) + 1;
        if (r10 <= 0) goto L6;
        fill(r10);
        return;
    }

    public void rewind() {
        int r5 = this.f631p;
        int r10 = this.lastMarker;
        int r11 = this.currentElementIndex;
        this.currentElementIndex = r11 - (r5 - r10);
        this.f631p = r10;
    }
}
