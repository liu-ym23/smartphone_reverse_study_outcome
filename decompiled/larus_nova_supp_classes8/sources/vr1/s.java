package vr1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.vs_host.impl.VSPlayerService$createGestureViewManager$manager$1;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface s {
    void a(DataCenter r1);

    String c();

    ILivePlayerClient currentClient();

    void d(IBaseStreamUrl r1);

    void f(long r1, long r3, boolean r5);

    VSPlayerService$createGestureViewManager$manager$1 g(Context r1, View r2, ViewGroup r3, com.bytedance.android.livesdk.chatroom.vs.gesture.g r4);

    Pair<WeakReference<View>, WeakReference<View>> getLivePlayerView();
}
