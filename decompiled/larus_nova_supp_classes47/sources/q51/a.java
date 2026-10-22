package q51;

import com.bytedance.android.live.revlink.impl.global.c;
import com.bytedance.android.live.revlink.link.biz.service.j;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements j {
    public final b a;

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    public b getContext() {
        return this.a;
    }

    public a(h r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
