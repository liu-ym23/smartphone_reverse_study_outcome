package com.bytedance.android.live.liveinteract.api;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget;
import com.bytedance.android.live.ui.c;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import gd0.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class BaseLinkMultiControlWidget extends BaseMultiLinkWidget implements ILinkControlWidget, k {

    public interface a {
        void A4();

        View c();

        View j();

        void k(Widget r1);

        c y4();

        Widget z4(int r1, String r2);
    }

    @Override // gd0.k
    public void a(View r1, MotionEvent r2) {
    }

    public abstract void h0(IRoom r1);

    @Override // gd0.k
    public abstract void k(String r1, ye1.a r2);

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public abstract void p3(IRoom r1);

    @Override // gd0.k
    public abstract void pi();

    public String tag() {
        return "BaseLinkMultiControlWidget";
    }

    public abstract void wq();

    public BaseLinkMultiControlWidget() {
    }

    public CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }
}
