package qh0;

import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements c, b {
    public final OperateType a;
    public final int b;

    @Override // qh0.b
    public final int getLinkType() {
        return this.b;
    }

    @Override // qh0.b
    public final OperateType getOperateType() {
        return this.a;
    }

    @Override // qh0.c
    public final a<rh0.a> a(a<rh0.a> r1) {
        return new com.bytedance.android.live.liveinteract.plantform.permission.checker.p(this);
    }

    public e(OperateType r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "operateType");
        this.a = r2;
        this.b = r3;
    }
}
