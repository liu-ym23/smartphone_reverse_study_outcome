package gjb;

import android.content.Context;
import com.ss.android.lark.videosend.tools.l;
import ebb.e;
import ebb.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class a implements f {
    @Inject
    public a() {
    }

    public final List<File> a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        ArrayList r0 = new ArrayList();
        Object r1 = e.a;
        e.c(wkb.b.a().getRealPath(), 15);
        e.c(l.a(r4).getRealPath(), 15);
        return r0;
    }

    public final List<File> b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return CollectionsKt.emptyList();
    }
}
