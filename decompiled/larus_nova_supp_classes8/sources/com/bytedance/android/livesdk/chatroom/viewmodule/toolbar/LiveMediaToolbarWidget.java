package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livesdk.chatroom.utils.VSMediaUIConfigHelper;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@PlayerViewControl(key = PlayerViewControl.KEY.LandscapeBottomToolBar, needDynamicControl = true, type = PlayerViewControl.Type.BOTTOM)
public class LiveMediaToolbarWidget extends LiveToolbarWidget {
    public final Set<ToolbarButton> a;

    public LiveMediaToolbarWidget() {
        this.a = new HashSet();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget, com.bytedance.android.livesdk.chatroom.vsplayer.model.a
    public final boolean canControlByPlayer(PlayerViewControl.KEY r1) {
        return super.canControlByPlayer(r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final boolean filterUnFoldToolbarButton(ToolbarButton r2) {
        if (isScreenPortrait() == false) goto L7;
        return false;
    L7:
        return ((HashSet) this.a).contains(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void onInit(Object... r2) {
        super.onInit(r2);
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == true) goto L6;
        Set<ToolbarButton> r3 = this.a;
        HashSet r4 = (HashSet) r3;
        r4.add(ToolbarButton.GIFT);
        Set<ToolbarButton> r5 = this.a;
        HashSet r6 = (HashSet) r5;
        r6.add(ToolbarButton.FAST_GIFT);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.LiveToolbarWidget
    public final void onLoad(Object... r4) {
        super.onLoad(r4);
        if (VSMediaUIConfigHelper.b(((Widget) this).dataCenter) == true) goto L5;
        return;
    L5:
        if (isScreenLandscape() == false) goto L9;
        UIUtils.updateLayoutMargin(((Widget) this).containerView, -3, -3, (int) UIUtils.dip2Px(getContext(), 16.0f), (int) UIUtils.dip2Px(getContext(), 16.0f));
        return;
    }
}
