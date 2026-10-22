package oca;

import android.os.Bundle;
import com.obric.capabilitykit.entity.app.MusicEntity;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d0 implements pca.b {
    public final /* synthetic */ pca.b a;
    public final /* synthetic */ b0 b;

    public d0(pca.b r1, b0 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // pca.b
    public final void a(List<? extends Object> r2, Object r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "entityGroup");
        Intrinsics.checkNotNullParameter(r3, "entity");
        this.a.a(r2, r3, r4);
        if ((r3 instanceof MusicEntity) == false) goto L5;
        return;
    L5:
        gda.a r5 = gda.a.a;
        Bundle r6 = this.b.getTraceInfo();
        r6.putInt("item_position", r4 + 1);
        r6.putString("click_result", "click_to_redirect");
        gda.b.a(r6);
    }
}
