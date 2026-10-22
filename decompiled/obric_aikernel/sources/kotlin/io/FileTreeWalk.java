package kotlin.io;

import com.bytedance.apm6.util.constant.CommonConsts;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
public final class FileTreeWalk implements Sequence<File> {
    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$DirectoryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
    private static abstract class DirectoryState extends WalkState {
        public DirectoryState(File r10) {
            Intrinsics.checkNotNullParameter(r10, "rootDir");
            super(r10);
        }
    }

    private final class FileTreeWalkIterator extends AbstractIterator<File> {
        private final ArrayDeque<WalkState> state;
        final /* synthetic */ FileTreeWalk this$0;

        private final class BottomUpDirectoryState extends DirectoryState {
            private boolean failed;
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ FileTreeWalkIterator this$0;

            public BottomUpDirectoryState(FileTreeWalkIterator r10, File r11) {
                Intrinsics.checkNotNullParameter(r11, "rootDir");
                this.this$0 = r10;
                super(r11);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.failed == false) goto L5;
            L19:
                File[] r10 = this.fileList;
                if (r10 == null) goto L26;
                int r11 = this.fileIndex;
                Intrinsics.checkNotNull(r10);
                if (r11 >= r10.length) goto L26;
                File[] r12 = this.fileList;
                Intrinsics.checkNotNull(r12);
                int r13 = this.fileIndex;
                this.fileIndex = r13 + 1;
                return r12[r13];
            L26:
                if (this.rootVisited == true) goto L29;
                this.rootVisited = true;
                return getRoot();
            L29:
                Function1 r14 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r14 == null) goto L32;
                r14.invoke(getRoot());
            L32:
                return null;
            L5:
                if (this.fileList != null) goto L19;
                Function1 r15 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
                boolean r16 = false;
                if (r15 != null) goto L9;
            L11:
                if (r16 == false) goto L13;
                return null;
            L13:
                File[] r17 = getRoot().listFiles();
                this.fileList = r17;
                if (r17 != null) goto L19;
                Function2 r18 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
                if (r18 == null) goto L18;
                r18.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            L18:
                this.failed = true;
                goto L19
            L9:
                if (((Boolean) r15.invoke(getRoot())).booleanValue() == true) goto L11;
                r16 = true;
                goto L11
            }
        }

        @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
        private final class SingleFileState extends WalkState {
            final /* synthetic */ FileTreeWalkIterator this$0;
            private boolean visited;

            public SingleFileState(FileTreeWalkIterator r10, File r11) {
                Intrinsics.checkNotNullParameter(r11, "rootFile");
                this.this$0 = r10;
                super(r11);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.visited == false) goto L6;
                return null;
            L6:
                this.visited = true;
                return getRoot();
            }
        }

        private final class TopDownDirectoryState extends DirectoryState {
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ FileTreeWalkIterator this$0;

            public TopDownDirectoryState(FileTreeWalkIterator r10, File r11) {
                Intrinsics.checkNotNullParameter(r11, "rootDir");
                this.this$0 = r10;
                super(r11);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.rootVisited == true) goto L13;
                Function1 r10 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
                boolean r11 = false;
                if (r10 != null) goto L7;
            L9:
                if (r11 == false) goto L11;
                return null;
            L11:
                this.rootVisited = true;
                return getRoot();
            L7:
                if (((Boolean) r10.invoke(getRoot())).booleanValue() == true) goto L9;
                r11 = true;
                goto L9
            L13:
                File[] r12 = this.fileList;
                if (r12 == null) goto L23;
                int r13 = this.fileIndex;
                Intrinsics.checkNotNull(r12);
                if (r13 < r12.length) goto L23;
                Function1 r14 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r14 == null) goto L21;
                r14.invoke(getRoot());
            L21:
                return null;
            L23:
                if (this.fileList != null) goto L37;
                File[] r15 = getRoot().listFiles();
                this.fileList = r15;
                if (r15 != null) goto L29;
                Function2 r16 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
                if (r16 == null) goto L29;
                r16.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            L29:
                File[] r17 = this.fileList;
                if (r17 == null) goto L33;
                Intrinsics.checkNotNull(r17);
                if (r17.length != 0) goto L37;
            L33:
                Function1 r18 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r18 == null) goto L36;
                r18.invoke(getRoot());
            L36:
                return null;
            L37:
                File[] r19 = this.fileList;
                Intrinsics.checkNotNull(r19);
                int r20 = this.fileIndex;
                this.fileIndex = r20 + 1;
                return r19[r20];
            }
        }

        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r10 = new int[FileWalkDirection.values().length];
                r10[FileWalkDirection.TOP_DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r10[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r10;
            }
        }

        public FileTreeWalkIterator(FileTreeWalk r10) {
            this.this$0 = r10;
            ArrayDeque<WalkState> r11 = new ArrayDeque();
            this.state = r11;
            if (FileTreeWalk.access$getStart$p(r10).isDirectory() == false) goto L6;
            r11.push(directoryState(FileTreeWalk.access$getStart$p(r10)));
            return;
        L6:
            if (FileTreeWalk.access$getStart$p(r10).isFile() == false) goto L8;
            r11.push(new SingleFileState(this, FileTreeWalk.access$getStart$p(r10)));
            return;
        L8:
            done();
        }

        private final DirectoryState directoryState(File r10) {
            FileWalkDirection r11 = FileTreeWalk.access$getDirection$p(this.this$0);
            int r12 = WhenMappings.$EnumSwitchMapping$0[r11.ordinal()];
            if (r12 == 1) goto L10;
            if (r12 != 2) goto L8;
            return new BottomUpDirectoryState(this, r10);
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return new TopDownDirectoryState(this, r10);
        }

        private final File gotoNext() {
        L2:
            WalkState r10 = this.state.peek();
            if (r10 == null) goto L4;
            File r11 = r10.step();
            if (r11 == null) goto L8;
            if (Intrinsics.areEqual(r11, r10.getRoot()) == true) goto L17;
            if (r11.isDirectory() == false) goto L17;
            if (this.state.size() >= FileTreeWalk.access$getMaxDepth$p(this.this$0)) goto L17;
            this.state.push(directoryState(r11));
        L17:
            return r11;
        L8:
            this.state.pop();
            goto L2
        L4:
            return null;
        }

        @Override // kotlin.collections.AbstractIterator
        protected void computeNext() {
            File r10 = gotoNext();
            if (r10 == null) goto L5;
            setNext(r10);
            return;
        L5:
            done();
        }
    }

    private static abstract class WalkState {
        private final File root;

        public WalkState(File r10) {
            Intrinsics.checkNotNullParameter(r10, "root");
            this.root = r10;
        }

        public final File getRoot() {
            return this.root;
        }

        public abstract File step();
    }

    public FileTreeWalk(File r11, FileWalkDirection r12) {
        Intrinsics.checkNotNullParameter(r11, CommonConsts.APM_INNER_EVENT_COST_START);
        Intrinsics.checkNotNullParameter(r12, "direction");
        this(r11, r12, null, null, null, 0, 32, null);
    }

    public /* synthetic */ FileTreeWalk(File r10, FileWalkDirection r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = FileWalkDirection.TOP_DOWN;
    L5:
        this(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FileTreeWalk(File r10, FileWalkDirection r11, Function1<? super File, Boolean> r12, Function1<? super File, Unit> r13, Function2<? super File, ? super IOException, Unit> r14, int r15) {
        this.start = r10;
        this.direction = r11;
        this.onEnter = r12;
        this.onLeave = r13;
        this.onFail = r14;
        this.maxDepth = r15;
    }

    /* synthetic */ FileTreeWalk(File r10, FileWalkDirection r11, Function1 r12, Function1 r13, Function2 r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        r11 = FileWalkDirection.TOP_DOWN;
    L5:
        FileWalkDirection r18 = r11;
        if ((r16 & 32) == 0) goto L8;
        r15 = Integer.MAX_VALUE;
    L8:
        this(r10, r18, r12, r13, r14, r15);
    }

    public static final /* synthetic */ FileWalkDirection access$getDirection$p(FileTreeWalk r10) {
        return r10.direction;
    }

    public static final /* synthetic */ int access$getMaxDepth$p(FileTreeWalk r10) {
        return r10.maxDepth;
    }

    public static final /* synthetic */ Function1 access$getOnEnter$p(FileTreeWalk r10) {
        return r10.onEnter;
    }

    public static final /* synthetic */ Function2 access$getOnFail$p(FileTreeWalk r10) {
        return r10.onFail;
    }

    public static final /* synthetic */ Function1 access$getOnLeave$p(FileTreeWalk r10) {
        return r10.onLeave;
    }

    public static final /* synthetic */ File access$getStart$p(FileTreeWalk r10) {
        return r10.start;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new FileTreeWalkIterator(this);
    }

    public final FileTreeWalk maxDepth(int r10) {
        if (r10 <= 0) goto L6;
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, r10);
    L6:
        throw new IllegalArgumentException("depth must be positive, but was " + r10 + '.');
    }

    public final FileTreeWalk onEnter(Function1<? super File, Boolean> r10) {
        Intrinsics.checkNotNullParameter(r10, "function");
        return new FileTreeWalk(this.start, this.direction, r10, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, r10, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1<? super File, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, r10, this.onFail, this.maxDepth);
    }
}
