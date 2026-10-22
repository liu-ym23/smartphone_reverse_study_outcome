package n79;

import android.view.View;
import android.widget.ImageView;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.drive.biz.impl.search.kmp.KmpRecentDriveCell;
import com.larus.utils.e1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h extends BaseControllerListener<ImageInfo> {
    public final /* synthetic */ KmpRecentDriveCell a;

    public h(KmpRecentDriveCell r1) {
        this.a = r1;
    }

    public final void onFailure(String r1, Throwable r2) {
        View r3 = this.a.c;
        ImageView r4 = null;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("thumbnailView");
        r3 = null;
    L5:
        e1.q(r3);
        ImageView r5 = this.a.b;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("iconView");
    L9:
        e1.x(r4);
        return;
    L8:
        r4 = r5;
        goto L9
    }
}
