package kotlin.io;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", DBDefinition.NAME, "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileTreeWalk implements Sequence<File> {
    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FileTreeWalkIterator extends AbstractIterator<File> {
        private final ArrayDeque<WalkState> state;
        final /* synthetic */ FileTreeWalk this$0;

        private final File gotoNext() {
        L2:
            WalkState r0 = this.state.peek();
            if (r0 == null) goto L4;
            File r1 = r0.step();
            if (r1 == null) goto L8;
            if (Intrinsics.areEqual(r1, r0.getRoot()) == true) goto L17;
            if (r1.isDirectory() == false) goto L17;
            if (this.state.size() >= FileTreeWalk.access$getMaxDepth$p(this.this$0)) goto L17;
            this.state.push(directoryState(r1));
        L17:
            return r1;
        L8:
            this.state.pop();
            goto L2
        L4:
            return null;
        }

        @Override // kotlin.collections.AbstractIterator
        public void computeNext() {
            File r0 = gotoNext();
            if (r0 == null) goto L5;
            setNext(r0);
            return;
        L5:
            done();
        }

        public FileTreeWalkIterator(FileTreeWalk r3) {
            this.this$0 = r3;
            ArrayDeque<WalkState> r0 = new ArrayDeque();
            this.state = r0;
            if (FileTreeWalk.access$getStart$p(r3).isDirectory() == false) goto L6;
            r0.push(directoryState(FileTreeWalk.access$getStart$p(r3)));
            return;
        L6:
            if (FileTreeWalk.access$getStart$p(r3).isFile() == false) goto L8;
            r0.push(new SingleFileState(this, FileTreeWalk.access$getStart$p(r3)));
            return;
        L8:
            done();
        }

        private final DirectoryState directoryState(File r3) {
            FileWalkDirection r0 = FileTreeWalk.access$getDirection$p(this.this$0);
            int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L8;
            return new BottomUpDirectoryState(this, r3);
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return new TopDownDirectoryState(this, r3);
        }
    }

    public Iterator<File> iterator() {
        return new FileTreeWalkIterator(this);
    }

    public static final /* synthetic */ FileWalkDirection access$getDirection$p(FileTreeWalk r0) {
        return r0.direction;
    }

    public static final /* synthetic */ int access$getMaxDepth$p(FileTreeWalk r0) {
        return r0.maxDepth;
    }

    public static final /* synthetic */ Function1 access$getOnEnter$p(FileTreeWalk r0) {
        return r0.onEnter;
    }

    public static final /* synthetic */ Function2 access$getOnFail$p(FileTreeWalk r0) {
        return r0.onFail;
    }

    public static final /* synthetic */ Function1 access$getOnLeave$p(FileTreeWalk r0) {
        return r0.onLeave;
    }

    public static final /* synthetic */ File access$getStart$p(FileTreeWalk r0) {
        return r0.start;
    }

    public final FileTreeWalk maxDepth(int r9) {
        if (r9 <= 0) goto L6;
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, r9);
    L6:
        throw new IllegalArgumentException("depth must be positive, but was " + r9 + '.');
    }

    public final FileTreeWalk onEnter(Function1<? super File, Boolean> r9) {
        Intrinsics.checkNotNullParameter(r9, "function");
        return new FileTreeWalk(this.start, this.direction, r9, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, r9, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1<? super File, Unit> r9) {
        Intrinsics.checkNotNullParameter(r9, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, r9, this.onFail, this.maxDepth);
    }

    public FileTreeWalk(File r11, FileWalkDirection r12) {
        Intrinsics.checkNotNullParameter(r11, "start");
        Intrinsics.checkNotNullParameter(r12, "direction");
        this(r11, r12, null, null, null, 0, 32, null);
    }

    public /* synthetic */ FileTreeWalk(File r1, FileWalkDirection r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = FileWalkDirection.TOP_DOWN;
    L5:
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FileTreeWalk(File r1, FileWalkDirection r2, Function1<? super File, Boolean> r3, Function1<? super File, Unit> r4, Function2<? super File, ? super IOException, Unit> r5, int r6) {
        this.start = r1;
        this.direction = r2;
        this.onEnter = r3;
        this.onLeave = r4;
        this.onFail = r5;
        this.maxDepth = r6;
    }

    public /* synthetic */ FileTreeWalk(File r8, FileWalkDirection r9, Function1 r10, Function1 r11, Function2 r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = FileWalkDirection.TOP_DOWN;
    L5:
        FileWalkDirection r2 = r9;
        if ((r14 & 32) == 0) goto L8;
        int r6 = Integer.MAX_VALUE;
    L9:
        this(r8, r2, r10, r11, r12, r6);
        return;
    L8:
        r6 = r13;
        goto L9
    }
}
