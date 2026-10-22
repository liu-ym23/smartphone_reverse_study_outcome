package com.bytedance.android.livesdk.chatroom.widget.landscape;

import android.widget.TextClock;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/landscape/LandscapeTimeInfoWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeTimeInfoWidget extends LiveRecyclableWidget {
    public TextClock a;

    public final int getLayoutId() {
        return 2131568018;
    }

    public final void onUnload() {
    }

    public LandscapeTimeInfoWidget() {
    }

    public final void onInit(Object[] r2) {
        this.a = (TextClock) ((Widget) this).contentView.findViewById(2131388688);
    }

    public final void onLoad(Object[] r2) {
        TextClock r3 = this.a;
        if (r3 == null) goto L6;
        r3.setFormat12Hour("HH:mm");
        return;
    }
}
