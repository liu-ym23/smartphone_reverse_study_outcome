package kotlin.sequences;

/* JADX INFO: loaded from: classes3.dex */
public interface DropTakeSequence<T> extends Sequence<T> {
    Sequence<T> drop(int r10);

    Sequence<T> take(int r10);
}
