package yc2;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.IESUIUtils;
import com.bytedance.android.livesdk.wgamex.gameinvite.AnchorInviteViewModel;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Unit> {
    public final CompositeDisposable a;
    public final AnchorInviteViewModel b;

    public final void onTerminate() {
    }

    public final void onDestroy() {
        super.onDestroy();
        this.a.clear();
    }

    public i(DataCenter r2, AnchorInviteViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        Intrinsics.checkNotNullParameter(r3, "anchorInviteViewModel");
        this.b = r3;
        this.a = new CompositeDisposable();
    }

    public final void invoke(Object r6, CallContext r7) {
        JSONObject r8 = (JSONObject) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        int r9 = r8.optInt("status", 0);
        long r1 = r8.optLong("user_id");
        if (r1 != 0) goto L6;
        return;
    L6:
        if (r9 == 1) goto L12;
        if (r9 != 3) goto L19;
        f2.b(2131923462, 0);
        return;
    L19:
        return;
    L12:
        if (NetworkUtils.isNetworkAvailable(s1.getContext()) == true) goto L14;
        IESUIUtils.displayToast(s1.getContext(), 2131916005);
        return;
    L14:
        Disposable r10 = this.b.profileInvite(r1).observeOn(AndroidSchedulers.mainThread()).subscribe(g.a, h.a);
        this.a.add(r10);
    }
}
