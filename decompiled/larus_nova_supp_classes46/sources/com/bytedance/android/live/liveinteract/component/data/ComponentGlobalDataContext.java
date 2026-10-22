package com.bytedance.android.live.liveinteract.component.data;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.Metadata;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0016B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/liveinteract/component/data/ComponentGlobalDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "", "isSelfSinger", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "isLastMatchRoomSilence", "dataCenter", "", "setDataCenter", "mDataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "isAnchor", "()Z", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getMRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "mRoom", "<init>", "()V", "Companion", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ComponentGlobalDataContext extends DataContext {
    public static final a Companion = null;
    public static final String TAG = "ComponentGlobalDataContext";
    private DataCenter mDataCenter;

    public static final class a {
        public static ComponentGlobalDataContext a() {
            DataContext r0 = d.d(ComponentGlobalDataContext.TAG);
            if ((r0 instanceof ComponentGlobalDataContext) == true) goto L6;
            r0 = null;
        L6:
            return (ComponentGlobalDataContext) r0;
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public boolean isLastMatchRoomSilence() {
        IInteractService r0 = (IInteractService) k.f(IInteractService.class);
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.getMultiLinkBridgeService() == null) goto L9;
        if (ChatMatchWidget.p != true) goto L9;
        return true;
    }

    public boolean isSelfSinger() {
        return k.n(IKtvService.class).isCurrentUserIsSinger();
    }

    public final IRoom getMRoom() {
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L7;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return f.c(IRoom.class);
    }

    public final boolean isAnchor() {
        Boolean r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    public ComponentGlobalDataContext() {
    }

    public DataCenter getDataCenter() {
        return this.mDataCenter;
    }

    public final void setDataCenter(DataCenter r1) {
        this.mDataCenter = r1;
    }
}
