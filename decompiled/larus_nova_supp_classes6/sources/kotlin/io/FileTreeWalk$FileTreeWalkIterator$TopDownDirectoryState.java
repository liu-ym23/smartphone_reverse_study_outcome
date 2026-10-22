package kotlin.io;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState extends FileTreeWalk$DirectoryState {
    private int fileIndex;
    private File[] fileList;
    private boolean rootVisited;
    final /* synthetic */ FileTreeWalk.FileTreeWalkIterator this$0;

    @Override // kotlin.io.FileTreeWalk$WalkState
    public File step() {
        if (this.rootVisited == true) goto L13;
        Function1 r0 = FileTreeWalk.access$getOnEnter$p(this.this$0.this$0);
        boolean r2 = false;
        if (r0 != null) goto L7;
    L9:
        if (r2 == false) goto L11;
        return null;
    L11:
        this.rootVisited = true;
        return getRoot();
    L7:
        if (((Boolean) r0.invoke(getRoot())).booleanValue() == true) goto L9;
        r2 = true;
        goto L9
    L13:
        File[] r1 = this.fileList;
        if (r1 == null) goto L23;
        int r3 = this.fileIndex;
        Intrinsics.checkNotNull(r1);
        if (r3 < r1.length) goto L23;
        Function1 r4 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
        if (r4 == null) goto L21;
        r4.invoke(getRoot());
    L21:
        return null;
    L23:
        if (this.fileList != null) goto L37;
        File[] r5 = getRoot().listFiles();
        this.fileList = r5;
        if (r5 != null) goto L29;
        Function2 r6 = FileTreeWalk.access$getOnFail$p(this.this$0.this$0);
        if (r6 == null) goto L29;
        r6.invoke(getRoot(), new AccessDeniedException(getRoot(), null, "Cannot list files in a directory", 2, null));
    L29:
        File[] r7 = this.fileList;
        if (r7 == null) goto L33;
        Intrinsics.checkNotNull(r7);
        if (r7.length != 0) goto L37;
    L33:
        Function1 r8 = FileTreeWalk.access$getOnLeave$p(this.this$0.this$0);
        if (r8 == null) goto L36;
        r8.invoke(getRoot());
    L36:
        return null;
    L37:
        File[] r9 = this.fileList;
        Intrinsics.checkNotNull(r9);
        int r10 = this.fileIndex;
        this.fileIndex = r10 + 1;
        return r9[r10];
    }

    public FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState(FileTreeWalk.FileTreeWalkIterator r2, File r3) {
        Intrinsics.checkNotNullParameter(r3, "rootDir");
        this.this$0 = r2;
        super(r3);
    }
}
