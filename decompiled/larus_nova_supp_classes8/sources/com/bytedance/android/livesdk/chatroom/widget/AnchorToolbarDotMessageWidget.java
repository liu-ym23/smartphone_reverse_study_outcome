package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.broadcast.BroadcastPanelDotInfo;
import com.bytedance.android.livesdkapi.depend.model.broadcast.BubbleDotListData;
import com.bytedance.android.livesdkapi.depend.model.broadcast.BubbleDotPanelInfo;
import com.bytedance.ies.sdk.widgets.Widget;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/AnchorToolbarDotMessageWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorToolbarDotMessageWidget extends LiveRecyclableWidget {
    public final b a;

    public static final class a {
    }

    public static final class b implements vlc.l {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void onMessage(tlc.d r10) {
            if ((r10 instanceof com.bytedance.android.livesdk.message.model.n1) == false) goto L85;
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r0 == null) goto L30;
            com.bytedance.live.datacontext.j r1 = r0.getPreviewParameters();
            if (r1 == null) goto L30;
            com.bytedance.android.live.broadcast.api.model.z0 r2 = (com.bytedance.android.live.broadcast.api.model.z0) r1.getValue();
            if (r2 == null) goto L30;
            Map r11 = ((com.bytedance.android.livesdk.message.model.n1) r10).E();
            Intrinsics.checkNotNullParameter(r11, "panelDotInfoMap");
            if (r2.b != null) goto L13;
            r2.b = new BubbleDotListData();
        L13:
            Iterator r12 = r11.entrySet().iterator();
        L15:
            if (r12.hasNext() == false) goto L30;
            Map.Entry r5 = (Map.Entry) r12.next();
            String r6 = (String) r5.getKey();
            BroadcastPanelDotInfo r7 = (BroadcastPanelDotInfo) r5.getValue();
            BubbleDotPanelInfo r8 = new BubbleDotPanelInfo();
            r8.getItemDots().putAll(r7.getItemDots());
            BubbleDotListData r9 = r2.b;
            if (r9 == null) goto L25;
            Map r13 = r9.getListData();
            if (r13 == null) goto L25;
            BubbleDotPanelInfo r14 = (BubbleDotPanelInfo) r13.get(r6);
            if (r14 == null) goto L25;
            Map r15 = r14.getItemBubbles();
            if (r15 == null) goto L25;
            r8.getItemBubbles().putAll(r15);
        L25:
            BubbleDotListData r16 = r2.b;
            if (r16 == null) goto L15;
            Map r17 = r16.getListData();
            if (r17 == null) goto L15;
            BubbleDotPanelInfo r18 = (BubbleDotPanelInfo) r17.put(r6, r8);
        L30:
            RoomContext r19 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r19 == null) goto L36;
            com.bytedance.live.datacontext.i r110 = r19.getNeedUpdateDotBroadcastToolbarBehaviorList();
            if (r110 == null) goto L36;
            List r111 = (List) r110.getValue();
            if (r111 == null) goto L36;
        L38:
            if ((!r111.isEmpty()) == false) goto L65;
            ALogger.i("AnchorToolbarDotMessageWidget", "behaviorList is not empty");
            Iterator r112 = r111.iterator();
        L41:
            if (r112.hasNext() == false) goto L51;
            WeakReference r3 = (WeakReference) r112.next();
            ALogger.i("AnchorToolbarDotMessageWidget", "behavior: " + ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d) r3.get()));
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d r4 = (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d) r3.get();
            if (r4 == null) goto L41;
            WeakReference<View> r20 = r4.a;
            if (r20 == null) goto L41;
            View r21 = r20.get();
            if (r21 == null) goto L41;
            if (r21.findViewById(r4.a()) == null) goto L41;
            r4.showRedDot();
            goto L41
        L51:
            RoomContext.a r113 = RoomContext.Companion;
            RoomContext r22 = RoomContext.a.c(r113, null, 0, 3);
            if (r22 == null) goto L58;
            com.bytedance.live.datacontext.i r23 = r22.getNeedUpdateDotBroadcastToolbarKeyList();
            if (r23 == null) goto L58;
            List r24 = (List) r23.getValue();
            if (r24 == null) goto L58;
            r24.clear();
        L58:
            RoomContext r114 = RoomContext.a.c(r113, null, 0, 3);
            if (r114 == null) goto L86;
            com.bytedance.live.datacontext.i r115 = r114.getNeedUpdateDotBroadcastToolbarBehaviorList();
            if (r115 == null) goto L87;
            List r116 = (List) r115.getValue();
            if (r116 == null) goto L88;
            r116.clear();
            return;
        L88:
            return;
        L87:
            return;
        L86:
            return;
        L65:
            ALogger.i("AnchorToolbarDotMessageWidget", "behaviorList is empty");
            return;
        L36:
            r111 = CollectionsKt.emptyList();
            goto L38
        }
    }

    static {
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        vlc.d r0 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r0 == null) goto L6;
        r0.removeMessageListener(MessageType.BROADCAST_COMMON_DOT_MESSAGE.getIntType(), this.a);
        return;
    }

    public AnchorToolbarDotMessageWidget() {
        this.a = b.a;
    }

    public final void onLoad(Object[] r3) {
        vlc.d r4 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r4 == null) goto L6;
        d4.a(r4, MessageType.BROADCAST_COMMON_DOT_MESSAGE.getIntType(), this.a);
        return;
    }
}
