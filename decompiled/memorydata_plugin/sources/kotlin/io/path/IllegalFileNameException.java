package kotlin.io.path;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/io/path/IllegalFileNameException;", "Ljava/nio/file/FileSystemException;", "file", "Ljava/nio/file/Path;", "(Ljava/nio/file/Path;)V", "other", "message", "", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/String;)V", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IllegalFileNameException extends FileSystemException {
    public IllegalFileNameException(Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "file");
        this(r4, null, null);
    }

    public IllegalFileNameException(Path r3, Path r4, String r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "file");
        String r8 = r6.toString();
        if (r7 == null) goto L5;
        String r9 = r7.toString();
    L6:
        super(r8, r9, r5);
        return;
    L5:
        r9 = null;
        goto L6
    }
}
