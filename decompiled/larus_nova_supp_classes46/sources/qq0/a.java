package qq0;

import com.bytedance.android.live.openplatform.impl.miniappaudience.shelf.view.AudienceShelfDisplayDialog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ AudienceShelfDisplayDialog a;

    public a(AudienceShelfDisplayDialog r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        List r5 = (List) r4;
        if (r5 == null) goto L6;
        AudienceShelfDisplayDialog r0 = this.a;
        int r1 = AudienceShelfDisplayDialog.v;
        r0.T90(2131386216).post(new g(r0, r5));
        return;
    }
}
