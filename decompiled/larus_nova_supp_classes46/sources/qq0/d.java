package qq0;

import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.PrivateMsgEntranceItemViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements PrivateMsgEntranceItemViewHolder.a {
    public final /* synthetic */ AudienceShelfDisplayDialog a;

    public d(AudienceShelfDisplayDialog r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.PrivateMsgEntranceItemViewHolder.a
    public final void a(lo0.a r3) {
        Intrinsics.checkNotNullParameter(r3, "privateMsgEntranceInfo");
        AudienceShelfDisplayDialog r0 = this.a;
        int r1 = AudienceShelfDisplayDialog.v;
        r0.W90().reportMpImAuthPushEntryShow(r3);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.PrivateMsgEntranceItemViewHolder.a
    public final void b(lo0.a r4) {
        Intrinsics.checkNotNullParameter(r4, "privateMsgEntranceInfo");
        AudienceShelfDisplayDialog r0 = this.a;
        int r1 = AudienceShelfDisplayDialog.v;
        r0.W90().openSchema(this.a.getContext(), r4.g());
        this.a.W90().reportMpImAuthPushEntryClick(r4);
    }
}
