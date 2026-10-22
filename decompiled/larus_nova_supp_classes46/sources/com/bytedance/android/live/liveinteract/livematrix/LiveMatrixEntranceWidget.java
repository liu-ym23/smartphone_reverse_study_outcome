package com.bytedance.android.live.liveinteract.livematrix;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.b3;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.rowcontract.RowRecyclableWidget;
import com.bytedance.android.livesdk.config.t51;
import com.bytedance.android.livesdk.message.model.g9;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMatrixData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.Metadata;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import vlc.l;
import vm2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/livematrix/LiveMatrixEntranceWidget;", "Lcom/bytedance/android/live/rowcontract/RowRecyclableWidget;", "Lvlc/l;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveMatrixEntranceWidget extends RowRecyclableWidget implements l {
    public long a;
    public TextView b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LiveMatrixEntranceWidget a;

        public a(LiveMatrixEntranceWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r7) {
            LiveMatrixEntranceWidget r8 = this.a;
            r8.getClass();
            ReadOnlyProperty r0 = d.o3;
            KProperty[] r1 = d.a;
            String r3 = ((t51) r0.getValue(null, r1[220(0xdc, float:3.08E-43)])).c();
            if (r3 != null) goto L5;
            r3 = "sslocal://webcast_webview?type=popup&hide_nav_bar=1&gravity=bottom&width_percent=100&height_percent=73";
        L5:
            u6 r5 = new u6(r3);
            String r2 = ((t51) r0.getValue(null, r1[220(0xdc, float:3.08E-43)])).d();
            if (r2 != null) goto L8;
            r2 = "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/webcast/mono/h5/vertical_basic_h5_douyin/template/pages/live_matrix.html";
        L8:
            r5.b("url", r2 + "?matrix_id=" + r8.a);
            k.n(IBaseLiveActionHandler.class).handle(((Widget) r8).context, r5.c());
        }
    }

    public final int getLayoutId() {
        return 2131566858;
    }

    public final void onUnload() {
    }

    public LiveMatrixEntranceWidget() {
    }

    public final void onInit(Object[] r2) {
        View r3 = ((Widget) this).contentView;
        if (r3 == null) goto L5;
        TextView r4 = (TextView) r3.findViewById(2131378411);
    L6:
        this.b = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final void onLoad(Object[] r7) {
        DataCenter r8 = ((Widget) this).dataCenter;
        String r0 = null;
        if (r8 == null) goto L7;
        vlc.d r9 = (vlc.d) r8.get("data_message_manager", null);
        if (r9 == null) goto L7;
        r9.addMessageListener(MessageType.LIVE_MATRIX_ENTRANCE_MESSAGE.getKey(), this);
    L7:
        m r10 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r10 == null) goto L10;
        IRoom r11 = (IRoom) r10.getValue();
    L11:
        if (r11 == null) goto L31;
        IRoomOthersData r1 = r11.getRoomOthers();
        if (r1 == null) goto L17;
        ILiveMatrixData r2 = r1.getLiveMatrixData();
        if (r2 == null) goto L17;
        long r4 = r2.getId();
    L18:
        this.a = r4;
        DataCenter r3 = ((Widget) this).dataCenter;
        if (r3 == null) goto L21;
        r3.put("live_matrix_id", Long.valueOf(r4));
    L21:
        IRoomOthersData r12 = r11.getRoomOthers();
        if (r12 == null) goto L27;
        ILiveMatrixData r13 = r12.getLiveMatrixData();
        if (r13 == null) goto L27;
        r0 = r13.getName();
    L27:
        if (this.a == 0) goto L29;
        boolean r14 = true;
    L30:
        wq(r14, r0);
        goto L31
    L29:
        r14 = false;
    L17:
        r4 = 0;
    L31:
        View r15 = ((Widget) this).contentView;
        if (r15 == null) goto L35;
        r15.setOnClickListener(new a(this));
        return;
    L35:
        return;
    L10:
        r11 = null;
        goto L11
    }

    public final void onMessage(tlc.d r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if ((r4 instanceof g9) == false) goto L23;
        g9 r5 = (g9) r4;
        b3 r0 = r5.getChangeContent();
        if (r0 == null) goto L8;
        long r1 = r0.getMatrixId();
    L9:
        this.a = r1;
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L12;
        r2.put("live_matrix_id", Long.valueOf(r1));
    L12:
        b3 r3 = r5.getChangeContent();
        if (r3 == null) goto L15;
        boolean r6 = r3.getShow();
    L16:
        b3 r7 = r5.getChangeContent();
        if (r7 == null) goto L19;
        String r8 = r7.getMatrixName();
    L20:
        wq(r6, r8);
        return;
    L19:
        r8 = null;
        goto L20
    L15:
        r6 = false;
        goto L16
    L8:
        r1 = 0;
        goto L9
    }

    public final void wq(boolean r3, String r4) {
        if (r3 == true) goto L4;
    L19:
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r5);
        return;
    L25:
        return;
    L4:
        if (((Boolean) d.h3.getValue(null, d.a[213(0xd5, float:2.98E-43)])).booleanValue() == false) goto L19;
        View r6 = ((Widget) this).contentView;
        if (r6 == null) goto L8;
        UtilityKotlinExtentionsKt.w(r6);
    L8:
        TextView r7 = this.b;
        if (r7 == null) goto L23;
        if (r4 != null) goto L12;
    L15:
        boolean r0 = true;
    L16:
        if (r0 == false) goto L18;
        r4 = "关联直播";
    L18:
        r7.setText(r4);
        return;
    L12:
        if (StringsKt.isBlank(r4) == true) goto L15;
        r0 = false;
        goto L16
    }
}
