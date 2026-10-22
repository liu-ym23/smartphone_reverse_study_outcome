package te;

import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import kotlin.jvm.internal.Intrinsics;
import vd.b;
import wd.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements b {
    public final ToolbarMatchInterface a;

    @Override // vd.b
    public final String getComponentExtra() {
        return this.a.getComponentExtra();
    }

    public a(ToolbarMatchInterface r10) {
        Intrinsics.checkNotNullParameter(r10, "realHandler");
        this.a = r10;
    }

    @Override // vd.b
    public final void a(ak2.a r10) {
        if ((r10 instanceof d) == false) goto L5;
        this.a.setExtraDataAfterCheck(com.bytedance.android.ec.adapter.impl.converter.b.a(r10));
        return;
    L5:
        this.a.setExtraDataAfterCheck(r10);
    }
}
