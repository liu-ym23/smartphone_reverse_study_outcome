package kotlin.io;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class FileTreeWalk$FileTreeWalkIterator$SingleFileState extends FileTreeWalk$WalkState {
    final /* synthetic */ FileTreeWalk.FileTreeWalkIterator this$0;
    private boolean visited;

    @Override // kotlin.io.FileTreeWalk$WalkState
    public File step() {
        if (this.visited == false) goto L6;
        return null;
    L6:
        this.visited = true;
        return getRoot();
    }

    public FileTreeWalk$FileTreeWalkIterator$SingleFileState(FileTreeWalk.FileTreeWalkIterator r2, File r3) {
        Intrinsics.checkNotNullParameter(r3, "rootFile");
        this.this$0 = r2;
        super(r3);
    }
}
