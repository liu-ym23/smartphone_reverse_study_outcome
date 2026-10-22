package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class TerminateException extends FileSystemException {
    public TerminateException(File r10) {
        Intrinsics.checkNotNullParameter(r10, "file");
        super(r10, null, null, 6, null);
    }
}
