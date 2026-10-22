package w20;

import android.content.Intent;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ja implements o60.e {
    public final /* synthetic */ ia a;
    public final /* synthetic */ ha b;
    public final /* synthetic */ CallContext c;

    @Override // o60.e
    public final void onPermissionDenied(String... r3) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        UIUtils.displayToastWithIcon(this.c.getContext(), 2131250233, 2131916011);
        this.a.finishWithFailure();
    }

    @Override // o60.e
    public final void onPermissionGrant(String... r4) {
        Intrinsics.checkNotNullParameter(r4, "permissions");
        if (Intrinsics.areEqual(this.b.d(), "photo") == false) goto L5;
        Intent r5 = new Intent(this.c.getContext(), jc1.k.n(IHostApp.class).getHostActivity(41));
    L6:
        r5.putExtra("commonRecordTips", this.b.a());
        r5.putExtra("customRecordTips", this.b.b());
        r5.putExtra(LiveSlardarConstants.EXTRA_KEY_URL, this.b.e());
        r5.putExtra("params", GsonProtectorUtils.toJson(GsonHelper.get(), this.b.c()));
        this.a.a.startActivityForResult(r5, 10000);
        return;
    L5:
        r5 = new Intent(this.c.getContext(), jc1.k.n(IHostApp.class).getHostActivity(39));
        goto L6
    }

    public ja(ia r1, ha r2, CallContext r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
