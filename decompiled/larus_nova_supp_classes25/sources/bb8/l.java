package bb8;

import com.larus.platform.api.l4;
import com.larus.platform.api.z3;
import com.larus.platform.service.q3;
import com.larus.platform.uimodel.MediaEntity;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements l4 {
    public final /* synthetic */ ArrayList<MediaEntity> a;

    public l(ArrayList<MediaEntity> r1) {
        this.a = r1;
    }

    public final void a(String r8, com.larus.video.impl.sdk.a r9) {
        if (this.a.isEmpty() == false) goto L5;
        return;
    L5:
        MediaEntity r0 = (MediaEntity) CollectionsKt.firstOrNull(this.a);
        if (r0 == null) goto L8;
        String r1 = r0.getVideo_model();
    L10:
        if (Intrinsics.areEqual(r1, r8) == false) goto L15;
        Lazy r10 = q3.a;
        z3 r2 = q3.a();
        if (r2 == null) goto L16;
        z3.a.a(r2, r9, null, 0, null, 30);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r1 = null;
        goto L10
    }
}
