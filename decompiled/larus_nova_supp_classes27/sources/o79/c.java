package o79;

import com.larus.drive.biz.api.model.DriveFileType;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public final Lazy a;
    public final Set<DriveFileType> b;
    public final Set<DriveFileType> c;
    public final Lazy d;

    public c() {
        this.a = LazyKt.lazy(new a());
        DriveFileType r2 = DriveFileType.AI_SLIDES;
        DriveFileType r4 = DriveFileType.AI_DOC;
        DriveFileType r6 = DriveFileType.AI_SHEET;
        this.b = SetsKt.setOf(new DriveFileType[]{r2, r4, r6});
        this.c = SetsKt.setOf(new DriveFileType[]{r2, r4, r6});
        this.d = LazyKt.lazy(new b(this));
    }
}
