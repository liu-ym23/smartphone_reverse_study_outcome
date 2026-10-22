package com.bytedance.android.livesdk.chatroom.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSPremiereToast;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/FirstShowHintWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FirstShowHintWidget extends LiveRecyclableWidget {
    public HSImageView a;
    public TextView b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ FirstShowHintWidget a;
        public final /* synthetic */ String b;

        public a(FirstShowHintWidget r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.x().centerToast(((Widget) this.a).context, this.b, 1);
        }
    }

    public final int getLayoutId() {
        return 2131566013;
    }

    public final void onUnload() {
    }

    public FirstShowHintWidget() {
    }

    public final void onInit(Object[] r1) {
        this.a = findViewById(2131374718);
        this.b = (TextView) findViewById(2131388367);
    }

    public final void onLoad(Object[] r4) {
        IRoom r5 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(((Widget) this).dataCenter);
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L7;
        Drawable r1 = r0.getBackground();
        if (r1 == null) goto L7;
        r1.setAlpha((int) 61.199997f);
    L7:
        VSRoom r6 = r5.castTo(VSRoom.class);
        py.k r2 = null;
        if (r6 == null) goto L12;
        EpisodeExtraInfo r7 = r6.getEpisodeExtra();
        if (r7 == null) goto L12;
        VSPremiereToast r8 = r7.getVsPremiereToast();
    L13:
        if (r8 == null) goto L15;
        r2 = r8.icon;
    L15:
        if (r2 != null) goto L17;
    L19:
        HSImageView r3 = this.a;
        if (r3 == null) goto L22;
        r3.setActualImageResource(2131253365);
    L22:
        TextView r9 = this.b;
        if (r9 == null) goto L30;
        if (r8 == null) goto L28;
        String r10 = r8.playerTopText;
        if (r10 == null) goto L28;
    L29:
        r9.setText(r10);
    L28:
        r10 = "非实时画面";
    L30:
        if (r8 == null) goto L33;
        String r11 = r8.playerToastText;
        if (r11 == null) goto L33;
    L34:
        View r12 = ((Widget) this).contentView;
        if (r12 == null) goto L38;
        r12.setOnClickListener(new a(this, r11));
        return;
    L38:
        return;
    L33:
        r11 = "该内容为提前录制，首次在抖音播出";
        goto L34
    L17:
        if (r2.isValid() != true) goto L19;
        ImageUtil.loadImage(this.a, r2, 0);
    L12:
        r8 = null;
        goto L13
    }
}
