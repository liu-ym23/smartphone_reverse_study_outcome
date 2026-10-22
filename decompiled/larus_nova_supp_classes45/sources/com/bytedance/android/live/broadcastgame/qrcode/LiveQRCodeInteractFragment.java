package com.bytedance.android.live.broadcastgame.qrcode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.broadcastgame.api.opengame.qrcode.IQRCodeService;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ILiveBgBroadcastFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/qrcode/LiveQRCodeInteractFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/ILiveBgBroadcastFragment;", "<init>", "()V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveQRCodeInteractFragment extends BaseFragment implements ILiveBgBroadcastFragment {
    public static final /* synthetic */ int e = 0;
    public IQRCodeService.b d;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ LiveQRCodeInteractFragment a;

        public b(LiveQRCodeInteractFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.onBackPressed();
        }
    }

    static {
    }

    public final void finish() {
    }

    public final boolean onBackPressed() {
        this.d = null;
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        r0.finish();
        return true;
    L7:
        return true;
    }

    public LiveQRCodeInteractFragment() {
    }

    public final Bundle invokeCmdWithBundle(Bundle r6) {
        boolean r1 = false;
        if (r6 == null) goto L22;
        String r2 = r6.getString("cmd");
        if (r2 == null) goto L22;
        int r3 = r2.hashCode();
        if (r3 == 1011794791) goto L18;
        if (r3 != 1879027258) goto L22;
        if (r2.equals("onScanFail") == false) goto L22;
        IQRCodeService.b r4 = this.d;
        if (r4 == null) goto L22;
        r1 = r4.b(r6.getInt("onScanErrorCode"));
        goto L22
    L18:
        if (r2.equals("onScanSuccess") == false) goto L22;
        IQRCodeService.b r5 = this.d;
        if (r5 == null) goto L22;
        r1 = r5.c(r6.getString("onScanResult"));
    L22:
        if (r1 == false) goto L24;
        Bundle r7 = new Bundle();
        r7.putString("cmd", "continueScan");
        return r7;
    L24:
        return null;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment
    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        ((ImageView) r2.findViewById(2131363762)).setOnClickListener(new b(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131567241, r3, false);
    }
}
