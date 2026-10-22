package mq1;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayCacheDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface c {
    lm1.a c();

    com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.d d(Context r1, DataCenter r2);

    void deleteCache(String r1);

    ReplayCacheDialog f(Context r1, DataCenter r2, Integer r3);

    void g(Map<String, String> r1, boolean r2);

    String getCachedVideoId(long r1);

    Map<String, Pair<String, String>> getLocalVideoPath(String r1);
}
