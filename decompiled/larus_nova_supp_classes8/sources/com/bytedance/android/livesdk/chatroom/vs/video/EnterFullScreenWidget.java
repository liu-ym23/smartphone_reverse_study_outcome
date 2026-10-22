package com.bytedance.android.livesdk.chatroom.vs.video;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.videoshop.context.VideoContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/EnterFullScreenWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EnterFullScreenWidget extends LiveRecyclableWidget {
    public final com.bytedance.android.livesdk.chatroom.vs.video.b a;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ EnterFullScreenWidget a;

        public a(EnterFullScreenWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            int r4 = d.a;
            d.a(((Widget) this.a).dataCenter);
            d.b(((Widget) this.a).dataCenter, "livesdk_vs_right_video_full_play_icon_click", null);
            this.a.a.mn(0);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ EnterFullScreenWidget a;

        public b(EnterFullScreenWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            int r4 = d.a;
            d.a(((Widget) this.a).dataCenter);
            d.b(((Widget) this.a).dataCenter, "livesdk_vs_right_video_full_play_icon_click", null);
            this.a.a.mn(1);
        }
    }

    public final int getLayoutId() {
        return 2131565949;
    }

    public final void onUnload() {
        ALogger.i("EnterFullScreenWidget", "unload");
    }

    public EnterFullScreenWidget(com.bytedance.android.livesdk.chatroom.vs.video.b r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a = r2;
    }

    public final void onInit(Object[] r1) {
        VideoContext.n0(((Widget) this).context);
    }

    public final void onLoad(Object[] r3) {
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 != null) goto L5;
    L12:
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L21;
        ImageView r6 = (ImageView) r5.findViewById(2131371691);
        if (r6 == null) goto L22;
        r6.setBackground(s1.m(2131253241));
        r6.setOnClickListener(new a(this));
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (z.m(r4, true) == true) goto L12;
        View r7 = ((Widget) this).contentView;
        if (r7 == null) goto L18;
        ImageView r8 = (ImageView) r7.findViewById(2131371691);
        if (r8 == null) goto L19;
        r8.setBackground(s1.m(2131253242));
        r8.setOnClickListener(new b(this));
        return;
    L19:
        return;
    }
}
