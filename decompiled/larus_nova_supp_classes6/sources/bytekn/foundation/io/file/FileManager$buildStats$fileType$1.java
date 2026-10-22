package bytekn.foundation.io.file;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lbytekn/foundation/io/file/FileType;", "invoke"}, k = 3, mv = {1, 1, 16})
public final class FileManager$buildStats$fileType$1 extends Lambda implements Function0<FileType> {
    final /* synthetic */ File $file;

    public FileManager$buildStats$fileType$1(File r1) {
        this.$file = r1;
        super(0);
    }

    public final FileType invoke() {
        if (this.$file.isDirectory() == false) goto L6;
        return FileType.Directory;
    L6:
        if (this.$file.isFile() == false) goto L9;
        return FileType.Regular;
    L9:
        return FileType.Unknown;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m5invoke() {
        return invoke();
    }
}
