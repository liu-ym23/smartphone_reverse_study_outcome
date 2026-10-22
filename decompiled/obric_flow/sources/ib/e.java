package ib;

import com.bytedance.sdk.xbridge.cn.protocol.i;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends b implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.bullet.core.kit.bridge.b f17568b;

    public e(com.bytedance.ies.bullet.core.kit.bridge.b r5) {
        this.f17568b = r5;
        super(r5);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.i
    public final void release() {
        this.f17568b.release();
    }
}
