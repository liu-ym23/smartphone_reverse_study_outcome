package kotlin.io;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState extends FileTreeWalk$DirectoryState {
    private boolean failed;
    private int fileIndex;
    private File[] fileList;
    private boolean rootVisited;
    final /* synthetic */ FileTreeWalk.FileTreeWalkIterator this$0;

    @Override // kotlin.io.FileTreeWalk$WalkState
    public File step() {
        if (this.failed == false) goto L5;
    L19:
        File[] r0 = this.fileList;
        if (r0 == null) goto L26;
        int r3 = this.fileIndex;
        Intrinsics.checkNotNull(r0);
        if (r3 >= r0.length) goto L26;
        File[] r1 = this.fileList;
        Intrinsics.checkNotNull(r1);
        int r2 = this.fileIndex;
        this.fileIndex = r2 + 1;
        return r1[r2];
    L26:
        if (this.rootVisited == true) goto L29;
        this.rootVisited = true;
        return getRoot();
    L29:
        Function1 r4 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
        if (r4 == null) goto L32;
        r4.invoke(getRoot());
    L32:
        return null;
    L5:
        if (this.fileList != null) goto L19;
        Function1 r5 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
        boolean r6 = false;
        if (r5 != null) goto L9;
    L11:
        if (r6 == false) goto L13;
        return null;
    L13:
        File[] r7 = getRoot().listFiles();
        this.fileList = r7;
        if (r7 != null) goto L19;
        Function2 r8 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
        if (r8 == null) goto L18;
        r8.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
    L18:
        this.failed = true;
        goto L19
    L9:
        if (((Boolean) r5.invoke(getRoot())).booleanValue() == true) goto L11;
        r6 = true;
        goto L11
    }

    public FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState(FileTreeWalk.FileTreeWalkIterator r2, File r3) {
        Intrinsics.checkNotNullParameter(r3, "rootDir");
        this.this$0 = r2;
        super(r3);
    }
}
