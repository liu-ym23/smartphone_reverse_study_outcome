package yr1;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.livehostapi.business.castscreen.bean.LiveCastOptionResolutionStrategyInfo;
import com.bytedance.android.livesdk.castscreen.datacontext.CastScreenConnectDataContext;
import com.bytedance.android.livesdk.castscreen.datacontext.ReplayCastScreenModelFactory;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface b {
    com.bytedance.live.datacontext.m<Boolean> A(DataCenter r1);

    com.bytedance.live.datacontext.m<Boolean> E(DataCenter r1);

    Boolean F(DataCenter r1);

    void I();

    void J();

    Boolean K(DataCenter r1);

    CastScreenConnectDataContext a();

    com.bytedance.live.datacontext.m<Boolean> c(DataCenter r1);

    com.bytedance.live.datacontext.m<Boolean> castScreenMode(DataCenter r1);

    Boolean d(DataCenter r1);

    com.bytedance.android.livesdk.chatroom.vs_host.business.c f();

    Class<? extends ViewModel> g();

    void h();

    void i(long r1);

    boolean isByteMatchCasting(DataCenter r1);

    boolean j();

    void k(boolean r1);

    LiveCastOptionResolutionStrategyInfo liveClarityStrategy();

    boolean liveIconOpt();

    void n(DataCenter r1, KVData r2);

    com.bytedance.live.datacontext.m<String> o(DataCenter r1);

    void pause();

    boolean q();

    NextLiveData<Boolean> s(DataCenter r1);

    void w(DataCenter r1, boolean r2);

    boolean x(DataCenter r1);

    ReplayCastScreenModelFactory y(DataCenter r1);
}
