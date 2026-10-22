package yr1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.foundation.depend.IHostAppMonitorListener;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface d {
    void a(Bundle r1, DataCenter r2);

    String appId();

    DataCenter c(DataCenter r1, long r2);

    String currentUserId();

    boolean d(DataCenter r1);

    void f(FragmentActivity r1);

    boolean g(Bundle r1);

    List<Class<?>> getAllLiveActivity();

    Activity getTopActivity();

    void h(Bundle r1, Bundle r2);

    void i(long r1);

    boolean isSaas();

    com.bytedance.android.livesdk.chatroom.vs_host.business.e j(Context r1);

    void k(DataCenter r1);

    void n();

    boolean o();

    void q(Context r1, String r2, String r3);

    void registerLiveLifeCycleListener(IHostAppMonitorListener r1);

    void s(FragmentActivity r1);

    void updateAnimatedFrameScheduler(boolean r1);
}
