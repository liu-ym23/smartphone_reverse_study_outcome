package bytekn.foundation.io.file;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lbytekn/foundation/io/file/FileType;", "", "Regular", "Directory", "Unknown", "kn_io_release"}, k = 1, mv = {1, 4, 0})
public final enum FileType extends Enum<FileType> {
    public static final FileType Directory = null;
    public static final FileType Regular = null;
    public static final FileType Unknown = null;
    public static final /* synthetic */ FileType[] a = null;

    static {
        FileType r1 = new FileType("Regular", 0);
        Regular = r1;
        FileType r2 = new FileType("Directory", 1);
        Directory = r2;
        FileType r3 = new FileType("Unknown", 2);
        Unknown = r3;
        a = new FileType[]{r1, r2, r3};
    }

    public static FileType valueOf(String r1) {
        return (FileType) a.a(FileType.class, r1);
    }

    public static FileType[] values() {
        return (FileType[]) a.clone();
    }

    public FileType(String r1, int r2) {
        super(r1, r2);
    }
}
