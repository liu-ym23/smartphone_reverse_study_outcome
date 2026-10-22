package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeNetworkInfoWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeNetworkInfoWidget extends LiveRecyclableWidget {
    public final LiveNetworkBroadcastReceiver a;
    public final TokenCert b;
    public TextView c;
    public ImageView d;
    public final a e;

    public static final class a implements LiveNetworkBroadcastReceiver.a {
        public final /* synthetic */ LandscapeNetworkInfoWidget a;

        public a(LandscapeNetworkInfoWidget r1) {
            this.a = r1;
        }

        public final void a(NetworkUtils.NetworkType r1) {
            this.a.wq();
        }
    }

    public final int getLayoutId() {
        return 2131568017;
    }

    public final void onUnload() {
        this.a.d();
        this.a.c(this.e);
    }

    public LandscapeNetworkInfoWidget() {
        this.a = new LiveNetworkBroadcastReceiver();
        this.b = TokenCert.Companion.with("bpea-landscapenetworkinfowidget_get_network_type");
        this.e = new a(this);
    }

    public final void wq() {
        if (NetworkUtils.g(getContext()) == false) goto L5;
        UtilityKotlinExtentionsKt.s(0, false, false, new LandscapeNetworkInfoWidget$showWifiUI$1(this), 7);
        return;
    L5:
        UtilityKotlinExtentionsKt.s(0, false, false, new LandscapeNetworkInfoWidget$showMobileUI$1(this), 7);
    }

    public final void onInit(Object[] r3) {
        this.c = (TextView) ((Widget) this).containerView.findViewById(2131390984);
        this.d = (ImageView) ((Widget) this).containerView.findViewById(2131376430);
        this.a.b(getContext(), this.b);
        this.a.a(this.e, this.b);
    }

    public final void onLoad(Object[] r1) {
        wq();
    }
}
