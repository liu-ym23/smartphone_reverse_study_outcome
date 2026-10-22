package q20;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.browser.debug.mock.MappingConfigAdapter;
import com.bytedance.android.live.browser.debug.mock.MappingConfigDetailFragment;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ MappingConfigAdapter a;
    public final /* synthetic */ r20.b b;

    public i(MappingConfigAdapter r1, r20.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Uri r4 = UriProtector.parse(this.b.a);     // Catch: Exception -> L4
        int r0 = MappingConfigDetailFragment.e;     // Catch: Exception -> L4
        MappingConfigAdapter r1 = this.a;     // Catch: Exception -> L4
        MappingConfigDetailFragment.a.a(r1.b, r1.c, r4);     // Catch: Exception -> L4
        return;
    L4:
        int r5 = MappingConfigDetailFragment.e;
        MappingConfigAdapter r6 = this.a;
        MappingConfigDetailFragment.a.a(r6.b, r6.c, null);
    }
}
