package xcb;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import kotlin.jvm.internal.Intrinsics;
import t6c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final UrlCardPreviewEntity a;
    public final d b;

    public b(UrlCardPreviewEntity r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "previewEntity");
        Intrinsics.checkNotNullParameter(r3, ChameleonOpenTracker.Stage.RENDER);
        this.a = r2;
        this.b = r3;
    }
}
