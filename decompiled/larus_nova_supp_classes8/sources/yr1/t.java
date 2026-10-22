package yr1;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.business.VSInjectWidgetType;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface t {
    c0.b a(Context r1, Episode r2);

    void c(DataCenter r1);

    Class<? extends Widget> getWidgetClass(@VSInjectWidgetType int r1);
}
