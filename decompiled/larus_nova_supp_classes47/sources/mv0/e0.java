package mv0;

import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e0 extends qs0.a<VrUtils> implements qs0.x {
    public e0() {
        super(VrUtils.e);
    }

    @Override // qs0.x
    public final String P() {
        VrUtils r0 = (VrUtils) this.a;
        return VrUtils.n();
    }

    @Override // qs0.x
    public final String getVrMachineLogStr(DataCenter r2) {
        VrUtils r0 = (VrUtils) this.a;
        return VrUtils.o(r2);
    }
}
