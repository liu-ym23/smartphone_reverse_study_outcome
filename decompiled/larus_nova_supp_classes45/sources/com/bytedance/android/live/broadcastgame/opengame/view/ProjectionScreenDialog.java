package com.bytedance.android.live.broadcastgame.opengame.view;

import android.os.Bundle;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/view/ProjectionScreenDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProjectionScreenDialog extends CommonBottomDialog {
    public TextView a;
    public HSImageView b;
    public HSImageView c;

    public final int getLayoutId() {
        return 2131565680;
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        this.a = (TextView) findViewById(2131365267);
        this.b = (HSImageView) findViewById(2131362593);
        this.c = (HSImageView) findViewById(2131363376);
        String r6 = LiveCommonConstants.INSTANCE.getObjectTosPath();
        M0(this.b, "https://" + r6 + "/obj/live-android/cast_screen_anchor_view.png");
        M0(this.c, "https://" + r6 + "/obj/live-android/cast_screen_audience_view.png");
        TextView r7 = this.a;
        if (r7 == null) goto L6;
        r7.setOnClickListener(new v(this));
        return;
    }

    public final void M0(HSImageView r3, String r4) {
        if (r3 == null) goto L4;
        r3.setController(Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true).setUri(UriProtector.parse(r4)).build());
    L4:
        if (r3 == null) goto L9;
        GenericDraweeHierarchy r5 = r3.getHierarchy();
        if (r5 == null) goto L10;
        r5.setFailureImage(2131252514);
        return;
    L10:
        return;
    }
}
