package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class NoSuchFileException extends FileSystemException {
    public NoSuchFileException(File r10, File r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "file");
        super(r10, r11, r12);
    }

    public /* synthetic */ NoSuchFileException(File r10, File r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = null;
    L8:
        this(r10, r11, r12);
    }
}
