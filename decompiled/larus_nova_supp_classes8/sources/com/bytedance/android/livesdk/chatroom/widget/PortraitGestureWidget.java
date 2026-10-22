package com.bytedance.android.livesdk.chatroom.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.livesdk.castscreen.datacontext.CastScreenConnectDataContext;
import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.danmaku.VSDanmakuContext;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.config.hj;
import com.bytedance.android.livesdk.r3;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/widget/PortraitGestureWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitGestureWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public final String a;
    public final Lazy b;
    public com.bytedance.android.livesdk.chatroom.vsplayer.api.c c;
    public long d;
    public boolean e;
    public boolean f;
    public final a g;

    public static final class a implements View.OnTouchListener {
        public float a;
        public float b;
        public final /* synthetic */ PortraitGestureWidget c;

        public a(PortraitGestureWidget r1) {
            this.c = r1;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r7, MotionEvent r8) {
            boolean r0 = false;
            if (r7 == null) goto L61;
            if (r8 == null) goto L61;
            if (this.c.f == true) goto L61;
            int r9 = r8.getAction();
            if (r9 == 0) goto L51;
            if (r9 != 1) goto L61;
            float r2 = 30;
            if (Math.abs(this.a - r8.getX()) >= r2) goto L61;
            if (Math.abs(this.b - r8.getY()) >= r2) goto L61;
            if (this.c.e == false) goto L61;
            long r10 = System.currentTimeMillis();
            PortraitGestureWidget r3 = this.c;
            if ((r10 - r3.d) >= 500) goto L61;
            VSDataContext r11 = VSDataContext.a.c(VSDataContext.Companion, ((Widget) r3).dataCenter);
            com.bytedance.android.livesdk.chatroom.vsplayer.api.c r12 = null;
            if (r11 == null) goto L29;
            com.bytedance.live.datacontext.j r13 = r11.getVsDanmakuContext();
            if (r13 == null) goto L29;
            VSDanmakuContext r14 = (VSDanmakuContext) r13.getValue();
            if (r14 == null) goto L29;
            com.bytedance.live.datacontext.m r15 = r14.isDanmakuHandlePopupShow();
            if (r15 == null) goto L29;
            Boolean r16 = (Boolean) r15.getValue();
        L30:
            PortraitGestureWidget r4 = this.c;
            r4.getClass();
            String r5 = LiveByteCastUIManager.a;
            if (hj.a.getValue().booleanValue() == false) goto L38;
            CastScreenConnectDataContext.a r1 = CastScreenConnectDataContext.Companion;
            DataCenter r6 = ((Widget) r4).dataCenter;
            r1.getClass();
            CastScreenConnectDataContext r17 = CastScreenConnectDataContext.a.a(r6);
            if (r17 == null) goto L36;
            Boolean r18 = Boolean.valueOf(r17.isCastScreenLinking(((Widget) r4).dataCenter));
        L37:
            Logger.d(r4.a, "isCastScreenLinking not ByteMatchCast castScreenLinking=" + r18);
            r0 = Intrinsics.areEqual(r18, Boolean.TRUE);
            goto L38
        L36:
            r18 = null;
        L38:
            if (r0 != true) goto L40;
        L50:
            return true;
        L40:
            if ((!Intrinsics.areEqual(r16, Boolean.TRUE)) == false) goto L50;
            IVSPlayerService r19 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
            if (r19 == null) goto L44;
            r12 = r19.provideVSPlayerViewControlService(((Widget) this.c).dataCenter);
        L44:
            if (r12 == null) goto L46;
            r12.changeVisibilityStatus();
        L46:
            if (r12 == null) goto L50;
            if (r12.getVisibilityStatus() != true) goto L50;
            r12.markVisibilityStatusChangeByUser();
        L29:
            r16 = null;
            goto L30
        L51:
            this.c.e = false;
            this.a = r8.getX();
            this.b = r8.getY();
            WidgetInfo r20 = this.c.getWidgetInfo(ShadowPlayerWidget.class);
            if (r20 != null) goto L54;
        L60:
            this.c.d = System.currentTimeMillis();
            goto L61
        L54:
            if (this.b <= r20.getLocationOnWindow()[1]) goto L60;
            if (this.b >= (r20.getLocationOnWindow()[1] + r20.getContentViewHeight())) goto L60;
            long r21 = System.currentTimeMillis();
            PortraitGestureWidget r22 = this.c;
            if ((r21 - r22.d) <= 300) goto L60;
            r22.e = true;
        L61:
            return false;
        }
    }

    public final int getLayoutId() {
        return 2131566112;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getLiveTouchListenerList();
        if (r1 == null) goto L11;
        List r2 = (List) r1.getValue();
        if (r2 == null) goto L12;
        r2.remove(this.g);
        return;
    L12:
        return;
    L11:
        return;
    }

    public PortraitGestureWidget() {
        this.a = "PortraitGestureWidget";
        this.b = LazyKt.lazy(PortraitGestureWidget$hostAdapter$2.INSTANCE);
        this.g = new a(this);
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (r6 == null) goto L5;
        String r0 = r6.getKey();
    L6:
        if (r0 == null) goto L53;
        int r1 = r0.hashCode();
        if (r1 == (-1122045708)) goto L28;
        if (r1 == 309908432) goto L14;
        return;
    L14:
        if (r0.equals("data_media_introduction_showing") == false) goto L43;
        if (r6 == null) goto L18;
        Boolean r7 = (Boolean) r6.getData(Boolean.FALSE);
        if (r7 == null) goto L18;
    L20:
        if (r7.booleanValue() == false) goto L24;
        View r8 = ((Widget) this).contentView;
        if (r8 == null) goto L44;
        r8.setImportantForAccessibility(4);
        return;
    L44:
        return;
    L24:
        View r9 = ((Widget) this).contentView;
        if (r9 == null) goto L46;
        r9.setImportantForAccessibility(0);
        return;
    L46:
        return;
    L18:
        r7 = Boolean.FALSE;
        goto L20
    L43:
        return;
    L28:
        if (r0.equals("data_hide_screen") == false) goto L48;
        Boolean r10 = (Boolean) r6.getData();
        if (r10 == null) goto L32;
        boolean r11 = r10.booleanValue();
    L33:
        this.f = r11;
        if (r11 == false) goto L49;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r12 = this.c;
        if (r12 != null) goto L38;
        return;
    L38:
        if (r12.getVisibilityStatus() != true) goto L51;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r13 = this.c;
        if (r13 == null) goto L52;
        r13.setVisibilityStatus(false);
        return;
    L52:
        return;
    L51:
        return;
    L49:
        return;
    L32:
        r11 = false;
        goto L33
    L48:
        return;
    L53:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void onLoad(Object[] r5) {
        IVSPlayerService r6 = (IVSPlayerService) jc1.k.f(IVSPlayerService.class);
        if (r6 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r7 = r6.provideVSPlayerViewControlService(((Widget) this).dataCenter);
    L6:
        this.c = r7;
        RoomContext r8 = RoomContext.a.c(RoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r8 == null) goto L13;
        com.bytedance.live.datacontext.m r9 = r8.getLiveTouchListenerList();
        if (r9 == null) goto L13;
        List r10 = (List) r9.getValue();
        if (r10 == null) goto L13;
        r10.add(this.g);
    L13:
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L19;
        DataCenter r12 = r11.observe("data_hide_screen", this);
        if (r12 == null) goto L19;
        r12.observe("data_media_introduction_showing", this);
    L19:
        if (r3.l(((Widget) this).context) == false) goto L25;
        View r13 = ((Widget) this).contentView;
        if (r13 == null) goto L23;
        r13.setFocusable(true);
    L23:
        r3.c(((Widget) this).contentView, com.bytedance.android.live.core.utils.s1.B(2131921595), true);
        return;
    L25:
        return;
    L5:
        r7 = null;
        goto L6
    }
}
