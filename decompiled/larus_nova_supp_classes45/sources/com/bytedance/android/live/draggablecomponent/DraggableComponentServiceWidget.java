package com.bytedance.android.live.draggablecomponent;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.message.model.InfoBoxMessage;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/draggablecomponent/DraggableComponentServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "Lcom/bytedance/android/live/draggablecomponent/DraggableComponentPresenter$b;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableComponentServiceWidget extends RoomRecyclableWidget implements DraggableComponentPresenter.b {
    public DraggableComponentPresenter a;
    public final Map<c61.c, c61.f> b;

    public final void onLoad(Object[] r1) {
    }

    public final void onUnload() {
        DraggableComponentPresenter r0 = this.a;
        if (r0 == null) goto L5;
        r0.detachView();
    L5:
        ((LinkedHashMap) this.b).clear();
    }

    public DraggableComponentServiceWidget() {
        this.b = new LinkedHashMap();
    }

    @Override // com.bytedance.android.live.draggablecomponent.DraggableComponentPresenter.b
    public final void Qk(f r11) {
        Intrinsics.checkNotNullParameter(r11, "draggableDataChangeParams");
        InfoBoxMessage r1 = r11.b;
        final c61.c r0 = new c61.c(r1.scene, r1.subScene);
        long r2 = r11.a;
        if (r2 != 0) goto L54;
        DraggableWindowContext.b r3 = DraggableWindowContext.Companion;
        r3.getClass();
        c61.g r4 = DraggableWindowContext.b.a();
        if (r4 == null) goto L20;
        c61.e r5 = r4.monitor();
        if (r5 == null) goto L20;
        c61.b r6 = new c61.b("livesdk_draggable_component_show");
        r6.b("type", String.valueOf(r11.b.scene));
        r6.b("scene", String.valueOf(r11.b.subScene));
        r6.b("drag_type", String.valueOf(r11.b.dragType));
        if (this.b.containsKey(r0) == false) goto L17;
        r3.getClass();
        c61.g r7 = DraggableWindowContext.b.a();
        if (r7 == null) goto L17;
        c61.d r8 = r7.windowContainer();
        if (r8 == null) goto L17;
        if (r8.v(r0) != true) goto L17;
        String r9 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L18:
        r6.b("is_content_update", r9);
        Unit r12 = Unit.INSTANCE;
        r5.a(r6.a());
    L17:
        r9 = "0";
    L20:
        if (this.b.containsKey(r0) == false) goto L32;
        r3.getClass();
        c61.g r13 = DraggableWindowContext.b.a();
        if (r13 == null) goto L32;
        c61.d r14 = r13.windowContainer();
        if (r14 == null) goto L32;
        if (r14.v(r0) != true) goto L32;
        if (this.a == null) goto L64;
        DraggableComponentPresenter.c0(r11.b);
        return;
    L64:
        return;
    L32:
        if (this.a == null) goto L47;
        InfoBoxMessage r15 = r11.b;
        Context r16 = ((Widget) this).context;
        Intrinsics.checkNotNullParameter(r15, "infoBoxSyncData");
        Intrinsics.checkNotNullParameter(r16, "context");
        Long r17 = r15.scene;
        if (r17 == null) goto L47;
        if (r17.longValue() != 0) goto L47;
        ALogger.i("DraggableComponentPresenter", "初始化LiveAnchorTeleprompterView");
        LiveAnchorTeleprompterVm.Companion.getClass();
        if (LiveAnchorTeleprompterVm.a.a() != null) goto L41;
        new LiveAnchorTeleprompterVm().initialize();
    L41:
        DraggableComponentPresenter.c0(r15);
        final LiveAnchorTeleprompterView r18 = new LiveAnchorTeleprompterView(r16);
        Long r19 = r15.dragType;
        if (r19 != null) goto L45;
    L48:
        this.b.put(r0, r18);
        r3.getClass();
        c61.g r110 = DraggableWindowContext.b.a();
        if (r110 == null) goto L65;
        c61.d r111 = r110.windowContainer();
        if (r111 == null) goto L66;
        r111.u(r18, new DraggableComponentServiceWidget$notifyCardDataChange$2(this, r18, r0));
        return;
    L66:
        return;
    L65:
        return;
    L45:
        if (r19.longValue() != 0) goto L48;
        r18.setDraggableConfig(new c61.h(5, 0, 126));
    L47:
        r18 = null;
        goto L48
    L54:
        if (r2 != 1) goto L68;
        DraggableWindowContext.Companion.getClass();
        c61.g r112 = DraggableWindowContext.b.a();
        if (r112 == null) goto L60;
        c61.d r113 = r112.windowContainer();
        if (r113 == null) goto L60;
        r113.g(r0, 1, DraggableComponentServiceWidget$notifyCardDataChange$3.INSTANCE);
    L60:
        Map<c61.c, c61.f> r114 = this.b;
        if (r114 == null) goto L69;
        c61.f r115 = r114.remove(r0);
        return;
    L69:
        return;
    }

    public final void onInit(Object[] r4) {
        DraggableComponentPresenter r5 = new DraggableComponentPresenter(((Widget) this).dataCenter);
        ((q46.b) r5).a = this;
        DataCenter r0 = r5.f;
        vlc.d r2 = null;
        if (r0 == null) goto L5;
        r2 = (vlc.d) r0.get("data_message_manager", null);
    L5:
        r5.d = r2;
        if (r2 == null) goto L13;
        Iterator<T> r1 = r5.e.iterator();
    L9:
        if (r1.hasNext() == false) goto L16;
        int r3 = ((Number) r1.next()).intValue();
        vlc.d r6 = r5.d;
        if (r6 == null) goto L9;
        r6.addMessageListener(r3, r5);
    L16:
        Unit r7 = Unit.INSTANCE;
        this.a = r5;
        return;
    L13:
        DataCenter r8 = r5.f;
        if (r8 == null) goto L16;
        r8.observe("data_message_manager", r5);
        goto L16
    }
}
