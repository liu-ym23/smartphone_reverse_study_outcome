package com.bytedance.android.live.componentsmarket.impl.components;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.componentsmarket.impl.components.anchorinfo.model.MediaAnchorInfoViewModel;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/BaseComponentsWidget;", "Landroidx/lifecycle/ViewModel;", "T", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseComponentsWidget<T extends ViewModel> extends RoomRecyclableWidget {
    public T a;
    public Room b;

    public abstract void Aq();

    public abstract void Bq();

    public void onUnload() {
    }

    public abstract void wq();

    public abstract void xq();

    public abstract void yq();

    public abstract MediaAnchorInfoViewModel zq(FragmentActivity r1);

    public BaseComponentsWidget() {
    }

    public void onInit(Object[] r2) {
        FragmentActivity r3 = ((Widget) this).context;
        if ((r3 instanceof FragmentActivity) == false) goto L8;
        if (r3 == null) goto L7;
        this.a = zq(r3);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public void onLoad(Object[] r1) {
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L5;
        IRoom r3 = z.b(r2).a;
    L6:
        this.b = (Room) r3;
        xq();
        Aq();
        yq();
        wq();
        Bq();
        return;
    L5:
        r3 = null;
        goto L6
    }
}
