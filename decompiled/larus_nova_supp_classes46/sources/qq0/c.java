package qq0;

import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Observer {
    public final /* synthetic */ AudienceShelfDisplayDialog a;

    public c(AudienceShelfDisplayDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        AudienceShelfDisplayDialog r0 = this.a;
        int r1 = AudienceShelfDisplayDialog.v;
        r0.V90().a = (List) r3;
        this.a.V90().notifyDataSetChanged();
    }
}
