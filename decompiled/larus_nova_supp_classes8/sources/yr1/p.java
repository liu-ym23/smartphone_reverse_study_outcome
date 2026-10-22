package yr1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.model.share.VsLiveShareType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface p {
    void a(xr1.a r1, String r2, VsLiveShareType r3, com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.r.c r4);

    View getQuickShotWatermark(Context r1, String r2);

    String publishToStory(Activity r1, String r2, String r3, String r4, String r5, Function1<? super Boolean, Unit> r6);

    void removePublishCallback(String r1);
}
