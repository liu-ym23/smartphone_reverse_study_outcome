package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.view.LightView;
import com.bytedance.android.livesdk.config.qj1;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/ShadowPlayerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShadowPlayerWidget extends LiveWidget {
    public final int getLayoutId() {
        return 2131567450;
    }

    public final void onCreate() {
        super.onCreate();
        View r0 = ((Widget) this).contentView;
        if ((r0 instanceof LightView) == true) goto L5;
        r0 = null;
    L5:
        LightView r1 = (LightView) r0;
        if (r1 == null) goto L9;
        r1.setNeedDraw(qj1.a.getValue().booleanValue());
        return;
    }

    public ShadowPlayerWidget() {
    }
}
