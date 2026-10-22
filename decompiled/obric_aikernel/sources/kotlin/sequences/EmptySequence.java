package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.EmptyIterator;

/* JADX INFO: loaded from: classes3.dex */
final class EmptySequence implements Sequence, DropTakeSequence {
    public static final EmptySequence INSTANCE = null;

    static {
        INSTANCE = new EmptySequence();
    }

    private EmptySequence() {
    }

    @Override // kotlin.sequences.DropTakeSequence
    public EmptySequence drop(int r10) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public /* bridge */ /* synthetic */ Sequence drop(int r10) {
        return drop(r10);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public EmptySequence take(int r10) {
        return INSTANCE;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public /* bridge */ /* synthetic */ Sequence take(int r10) {
        return take(r10);
    }
}
