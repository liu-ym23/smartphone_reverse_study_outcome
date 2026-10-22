package com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen;

import android.content.res.Configuration;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.ability.IAbilityCenter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.event.ToolbarClearScreenEvent;
import com.bytedance.android.livesdk.clearscreen.h;
import com.bytedance.android.livesdk.clearscreen.utils.ClearScreenHelper;
import com.bytedance.android.livesdk.config.el;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import jc1.k;
import jo1.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o70.c;
import zg1.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/clearscreen/AudiencePortraitClearScreenCompositeWidget;", "Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/clearscreen/ClearScreenCompositeWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudiencePortraitClearScreenCompositeWidget extends ClearScreenCompositeWidget {
    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void onDestroy() {
        super.onDestroy();
        if (ClearScreenHelper.e(((Widget) this).dataCenter) == false) goto L11;
        RoomContext r0 = zq();
        if (r0 == null) goto L11;
        m r1 = r0.isCleanMode();
        if (r1 == null) goto L11;
        boolean r2 = true;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
    L12:
        gs1.b.b(r2);
        if (gs1.b.a == true) goto L15;
    L17:
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L22;
        r3.put("DATA_IS_HIDE_INTERACTION", Boolean.FALSE);
        ILinkServiceExternal r4 = k.f(ILinkServiceExternal.class);
        if (r4 == null) goto L22;
        r4.updateInteractLayoutShow(false);
    L22:
        Integer r5 = wt2.a.a;
        if (el.a.getValue().booleanValue() == true) goto L25;
        return;
    L25:
        if (wt2.a.e(Boolean.valueOf(isAnchor())) == false) goto L31;
        int r6 = gs1.a.a;
        h r7 = gs1.a.a(a0.p(getDataCenter()));
        if (r7 == null) goto L32;
        r7.l();
        return;
    L32:
        return;
    L31:
        return;
    L15:
        if (ClearScreenHelper.e(((Widget) this).dataCenter) == true) goto L17;
        gs1.b.b(false);
    L11:
        r2 = false;
        goto L12
    }

    public AudiencePortraitClearScreenCompositeWidget() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void Cq(ToolbarClearScreenEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
        super.Cq(r2);
        I4(r2.b, r2.c);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void Eq(Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        Intrinsics.checkNotNullParameter(r3, "newConfig");
        if (ClearScreenHelper.c() == false) goto L5;
        Cq(new ToolbarClearScreenEvent(false, true));
        return;
    L5:
        Cq(new ToolbarClearScreenEvent(false, false));
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget, com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.b
    public final void F5(int r4) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L11;
        LayerEventDispatcher r1 = c.a(Integer.valueOf(r0.hashCode()));
        if (r1 == null) goto L11;
        if (r4 != 8) goto L9;
        boolean r2 = true;
    L10:
        r1.b(new s(r2));
        goto L11
    L9:
        r2 = false;
    L11:
        h70.b r3 = getComponentContext();
        if (r3 == null) goto L16;
        IAbilityCenter r5 = r3.a();
        if (r5 == null) goto L16;
        f r6 = (f) r5.getAbility(f.class);
    L17:
        if (r6 == null) goto L20;
        r6.J5(r4);
        return;
    L20:
        return;
    L16:
        r6 = null;
        goto L17
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void yq(boolean r2) {
        super.yq(r2);
        I4(false, r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.framework.widget.clearscreen.ClearScreenCompositeWidget
    public final void Bq(boolean r1, boolean r2, boolean r3) {
        super.Bq(r1, r2, r3);
        if (g1() == true) goto L6;
        if (r2 == true) goto L6;
        return;
    L6:
        I4(r1, ClearScreenHelper.c());
    }
}
