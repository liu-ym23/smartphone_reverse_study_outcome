package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
final class LinesSequence implements Sequence<String> {
    private final BufferedReader reader;

    /* JADX INFO: renamed from: kotlin.io.LinesSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<String>, KMappedMarker {
        private boolean done;
        private String nextValue;
        final /* synthetic */ LinesSequence this$0;

        AnonymousClass1(LinesSequence r10) {
            this.this$0 = r10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextValue != null) goto L10;
            if (this.done == true) goto L10;
            String r10 = LinesSequence.access$getReader$p(this.this$0).readLine();
            this.nextValue = r10;
            if (r10 != null) goto L10;
            this.done = true;
        L10:
            if (this.nextValue != null) goto L14;
            return false;
        L14:
            return true;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ String next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public String next2() {
            if (hasNext() == false) goto L7;
            String r10 = this.nextValue;
            this.nextValue = null;
            Intrinsics.checkNotNull(r10);
            return r10;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public LinesSequence(BufferedReader r10) {
        Intrinsics.checkNotNullParameter(r10, "reader");
        this.reader = r10;
    }

    public static final /* synthetic */ BufferedReader access$getReader$p(LinesSequence r10) {
        return r10.reader;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<String> iterator() {
        return new AnonymousClass1(this);
    }
}
