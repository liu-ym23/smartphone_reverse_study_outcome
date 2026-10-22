package kotlin.io;

import com.bytedance.ai.event.MessageIndication;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FileTreeWalk implements Sequence<File> {
    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$DirectoryState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
    public static abstract class DirectoryState extends WalkState {
        public DirectoryState(File r5) {
            Intrinsics.checkNotNullParameter(r5, "rootDir");
            super(r5);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class FileTreeWalkIterator extends AbstractIterator<File> {
        private final ArrayDeque<WalkState> state;
        final /* synthetic */ FileTreeWalk this$0;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", MessageIndication.STATUS_FAILED, "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class BottomUpDirectoryState extends DirectoryState {
            private boolean failed;
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ FileTreeWalkIterator this$0;

            public BottomUpDirectoryState(FileTreeWalkIterator r5, File r10) {
                Intrinsics.checkNotNullParameter(r10, "rootDir");
                this.this$0 = r5;
                super(r10);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.failed == false) goto L5;
            L17:
                File[] r5 = this.fileList;
                if (r5 == null) goto L24;
                int r10 = this.fileIndex;
                Intrinsics.checkNotNull(r5);
                if (r10 >= r5.length) goto L24;
                File[] r11 = this.fileList;
                Intrinsics.checkNotNull(r11);
                int r12 = this.fileIndex;
                this.fileIndex = r12 + 1;
                return r11[r12];
            L24:
                if (this.rootVisited == true) goto L27;
                this.rootVisited = true;
                return getRoot();
            L27:
                Function1 r13 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r13 == null) goto L30;
                r13.invoke(getRoot());
            L30:
                return null;
            L5:
                if (this.fileList != null) goto L17;
                Function1 r14 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
                if (r14 != null) goto L9;
            L11:
                File[] r15 = getRoot().listFiles();
                this.fileList = r15;
                if (r15 != null) goto L17;
                Function2 r16 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
                if (r16 == null) goto L16;
                r16.mo2invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            L16:
                this.failed = true;
                goto L17
            L9:
                if (((Boolean) r14.invoke(getRoot())).booleanValue() == true) goto L11;
                return null;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @SourceDebugExtension({"SMAP\nFileTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileTreeWalk.kt\nkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,273:1\n1#2:274\n*E\n"})
        public final class SingleFileState extends WalkState {
            final /* synthetic */ FileTreeWalkIterator this$0;
            private boolean visited;

            public SingleFileState(FileTreeWalkIterator r5, File r10) {
                Intrinsics.checkNotNullParameter(r10, "rootFile");
                this.this$0 = r5;
                super(r10);
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

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class TopDownDirectoryState extends DirectoryState {
            private int fileIndex;
            private File[] fileList;
            private boolean rootVisited;
            final /* synthetic */ FileTreeWalkIterator this$0;

            public TopDownDirectoryState(FileTreeWalkIterator r5, File r10) {
                Intrinsics.checkNotNullParameter(r10, "rootDir");
                this.this$0 = r5;
                super(r10);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public File step() {
                if (this.rootVisited == true) goto L11;
                Function1 r5 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
                if (r5 != null) goto L7;
            L9:
                this.rootVisited = true;
                return getRoot();
            L7:
                if (((Boolean) r5.invoke(getRoot())).booleanValue() == true) goto L9;
                return null;
            L11:
                File[] r10 = this.fileList;
                if (r10 == null) goto L21;
                int r11 = this.fileIndex;
                Intrinsics.checkNotNull(r10);
                if (r11 < r10.length) goto L21;
                Function1 r12 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r12 == null) goto L19;
                r12.invoke(getRoot());
            L19:
                return null;
            L21:
                if (this.fileList != null) goto L35;
                File[] r13 = getRoot().listFiles();
                this.fileList = r13;
                if (r13 != null) goto L27;
                Function2 r14 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
                if (r14 == null) goto L27;
                r14.mo2invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
            L27:
                File[] r15 = this.fileList;
                if (r15 == null) goto L31;
                Intrinsics.checkNotNull(r15);
                if (r15.length != 0) goto L35;
            L31:
                Function1 r16 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
                if (r16 == null) goto L34;
                r16.invoke(getRoot());
            L34:
                return null;
            L35:
                File[] r17 = this.fileList;
                Intrinsics.checkNotNull(r17);
                int r18 = this.fileIndex;
                this.fileIndex = r18 + 1;
                return r17[r18];
            }
        }

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r5 = new int[FileWalkDirection.values().length];
                r5[FileWalkDirection.TOP_DOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r5[FileWalkDirection.BOTTOM_UP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r5;
            }
        }

        public FileTreeWalkIterator(FileTreeWalk r5) {
            this.this$0 = r5;
            ArrayDeque<WalkState> r10 = new ArrayDeque();
            this.state = r10;
            if (FileTreeWalk.access$getStart$p(r5).isDirectory() == false) goto L6;
            r10.push(directoryState(FileTreeWalk.access$getStart$p(r5)));
            return;
        L6:
            if (FileTreeWalk.access$getStart$p(r5).isFile() == false) goto L8;
            r10.push(new SingleFileState(this, FileTreeWalk.access$getStart$p(r5)));
            return;
        L8:
            done();
        }

        private final DirectoryState directoryState(File r5) {
            FileWalkDirection r10 = FileTreeWalk.access$getDirection$p(this.this$0);
            int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
            if (r11 == 1) goto L10;
            if (r11 != 2) goto L8;
            return new BottomUpDirectoryState(this, r5);
        L8:
            throw new NoWhenBranchMatchedException();
        L10:
            return new TopDownDirectoryState(this, r5);
        }

        private final File gotoNext() {
        L2:
            WalkState r5 = this.state.peek();
            if (r5 == null) goto L4;
            File r10 = r5.step();
            if (r10 == null) goto L8;
            if (Intrinsics.areEqual(r10, r5.getRoot()) == true) goto L17;
            if (r10.isDirectory() == false) goto L17;
            if (this.state.size() >= FileTreeWalk.access$getMaxDepth$p(this.this$0)) goto L17;
            this.state.push(directoryState(r10));
        L17:
            return r10;
        L8:
            this.state.pop();
            goto L2
        L4:
            return null;
        }

        @Override // kotlin.collections.AbstractIterator
        public void computeNext() {
            File r5 = gotoNext();
            if (r5 == null) goto L5;
            setNext(r5);
            return;
        L5:
            done();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class WalkState {
        private final File root;

        public WalkState(File r5) {
            Intrinsics.checkNotNullParameter(r5, "root");
            this.root = r5;
        }

        public final File getRoot() {
            return this.root;
        }

        public abstract File step();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FileTreeWalk(File r5, FileWalkDirection r10, Function1<? super File, Boolean> r11, Function1<? super File, Unit> r12, Function2<? super File, ? super IOException, Unit> r13, int r14) {
        this.start = r5;
        this.direction = r10;
        this.onEnter = r11;
        this.onLeave = r12;
        this.onFail = r13;
        this.maxDepth = r14;
    }

    public static final /* synthetic */ FileWalkDirection access$getDirection$p(FileTreeWalk r5) {
        return r5.direction;
    }

    public static final /* synthetic */ int access$getMaxDepth$p(FileTreeWalk r5) {
        return r5.maxDepth;
    }

    public static final /* synthetic */ Function1 access$getOnEnter$p(FileTreeWalk r5) {
        return r5.onEnter;
    }

    public static final /* synthetic */ Function2 access$getOnFail$p(FileTreeWalk r5) {
        return r5.onFail;
    }

    public static final /* synthetic */ Function1 access$getOnLeave$p(FileTreeWalk r5) {
        return r5.onLeave;
    }

    public static final /* synthetic */ File access$getStart$p(FileTreeWalk r5) {
        return r5.start;
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

    public /* synthetic */ FileTreeWalk(File r10, FileWalkDirection r11, Function1 r12, Function1 r13, Function2 r14, int r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 2) == 0) goto L5;
        r11 = FileWalkDirection.TOP_DOWN;
    L5:
        FileWalkDirection r5 = r11;
        if ((r16 & 32) == 0) goto L8;
        r15 = Integer.MAX_VALUE;
    L8:
        this(r10, r5, r12, r13, r14, r15);
    }

    public FileTreeWalk(File r11, FileWalkDirection r12) {
        Intrinsics.checkNotNullParameter(r11, "start");
        Intrinsics.checkNotNullParameter(r12, "direction");
        Function1 r5 = null;
        Function1 r10 = null;
        Function2 r13 = null;
        int r14 = 0;
        this(r11, r12, r5, r10, r13, r14, 32, null);
    }

    public /* synthetic */ FileTreeWalk(File r5, FileWalkDirection r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = FileWalkDirection.TOP_DOWN;
    L5:
        this(r5, r10);
    }
}
