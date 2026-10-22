package kotlin.io;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.BufferedInputStream;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007¨\u0006\u0015"}, d2 = {"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "nextByte", "", "getNextByte", "()I", "setNextByte", "(I)V", "nextPrepared", "getNextPrepared", "setNextPrepared", "hasNext", "", "prepareNext", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ByteStreamsKt$iterator$1 extends ByteIterator {
    final /* synthetic */ BufferedInputStream $this_iterator;
    private boolean finished;
    private int nextByte;
    private boolean nextPrepared;

    private final void prepareNext() {
        if (this.nextPrepared == false) goto L5;
        return;
    L5:
        if (this.finished == true) goto L13;
        int r0 = this.$this_iterator.read();
        this.nextByte = r0;
        boolean r1 = true;
        this.nextPrepared = true;
        if (r0 == (-1)) goto L10;
        r1 = false;
    L10:
        this.finished = r1;
        return;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        prepareNext();
        return !this.finished;
    }

    @Override // kotlin.collections.ByteIterator
    public byte nextByte() {
        prepareNext();
        if (this.finished == true) goto L7;
        byte r0 = (byte) this.nextByte;
        this.nextPrepared = false;
        return r0;
    L7:
        throw new NoSuchElementException("Input stream is over.");
    }

    public final boolean getFinished() {
        return this.finished;
    }

    public final int getNextByte() {
        return this.nextByte;
    }

    public final boolean getNextPrepared() {
        return this.nextPrepared;
    }

    public ByteStreamsKt$iterator$1(BufferedInputStream r1) {
        this.$this_iterator = r1;
        this.nextByte = -1;
    }

    public final void setFinished(boolean r1) {
        this.finished = r1;
    }

    public final void setNextByte(int r1) {
        this.nextByte = r1;
    }

    public final void setNextPrepared(boolean r1) {
        this.nextPrepared = r1;
    }
}
