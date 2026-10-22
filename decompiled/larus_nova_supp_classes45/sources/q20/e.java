package q20;

import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.debug.mock.HybridHistoryListAdapter;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.config.r8;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ HybridHistoryListAdapter a;
    public final /* synthetic */ r20.a b;

    public e(HybridHistoryListAdapter r1, r20.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        SettingUtil.updateLocal(r8.a, "true");
        Uri r4 = UriProtector.parse(this.b.c.toString());
        FragmentActivity r0 = this.a.getContext();
        if (r0 == null) goto L7;
        ILiveService r1 = TTLiveService.getLiveService();
        if (r1 == null) goto L7;
        r1.handleSchema(r0, r4);
    L7:
        ((Map) com.bytedance.android.livesdk.sharedpref.b.z.getValue()).put(j.a(r4), r4.toString());
    }
}
