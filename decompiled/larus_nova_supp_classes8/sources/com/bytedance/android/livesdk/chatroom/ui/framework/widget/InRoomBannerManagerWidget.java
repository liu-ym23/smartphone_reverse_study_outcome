package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.layer.core.event.LayerEventDispatcher;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.banner.InRoomBannerManager;
import com.bytedance.android.livesdk.chatroom.utils.h2;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.os;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import zg1.m3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/InRoomBannerManagerWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Ljo1/g;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InRoomBannerManagerWidget extends MiddlewareRoomWidget implements jo1.g, Observer<KVData> {
    public com.bytedance.android.livesdk.chatroom.ui.framework.c a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.d b;
    public InRoomBannerManager c;
    public final CompositeDisposable d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ InRoomBannerManagerWidget a;

        public a(InRoomBannerManagerWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Boolean r3 = (Boolean) r2;
            InRoomBannerManagerWidget r4 = this.a;
            r4.getClass();
            IBrowserService r0 = jc1.k.f(IBrowserService.class);
            if (r0 == null) goto L10;
            com.bytedance.android.livesdk.chatroom.ui.framework.c r5 = r4.a;
            if (r5 == null) goto L7;
            FragmentActivity r6 = r5.p0();
        L8:
            r0.dismissAllWebDialogs(r6);
            return;
        L7:
            r6 = null;
            goto L8
        }
    }

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    @Override // jo1.g
    public final void fetch() {
        if (this.c == null) goto L16;
        Room r0 = getRoom();
        if (r0 == null) goto L17;
        long r1 = r0.getId();
        InRoomBannerManager r2 = this.c;
        if (r2 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r3 = this.a;
        if (r3 == null) goto L13;
        boolean r4 = true;
        if (r3.dg() != true) goto L13;
    L14:
        InRoomBannerManager.c(r2, r1, r4);
        return;
    L13:
        r4 = false;
        goto L14
    L18:
        return;
    L17:
        return;
    }

    public final Room getRoom() {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoom();
    }

    public InRoomBannerManagerWidget() {
        this.d = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.p(r0, jo1.g.class, this);
    L5:
        this.a = ho1.a.d(getComponentContext());
        this.b = ho1.a.i(getComponentContext());
        InRoomBannerManager r1 = new InRoomBannerManager(this);
        this.c = r1;
        Integer r2 = Integer.valueOf(com.bytedance.android.livesdk.utils.c1.i(((Widget) this).dataCenter));
        if (r2 == null) goto L8;
        int r3 = r2.intValue();
    L9:
        r1.e = r3;
        InRoomBannerManager r4 = this.c;
        if (r4 == null) goto L20;
        Room r5 = getRoom();
        if (r5 == null) goto L14;
        Long r6 = Long.valueOf(r5.getId());
    L15:
        Observable r7 = r4.d(r6, 0);
        if (r7 == null) goto L20;
        ObservableSubscribeProxy r8 = (ObservableSubscribeProxy) r7.as(AutoDispose.bind(this));
        if (r8 == null) goto L20;
        r8.subscribe(new v(this));
        goto L20
    L14:
        r6 = null;
    L20:
        com.bytedance.android.livesdk.chatroom.ui.framework.a r9 = ho1.a.c(getComponentContext());
        if (r9 == null) goto L27;
        PropertyOwner r10 = r9.getLoadState();
        if (r10 == null) goto L27;
        Disposable r11 = com.bytedance.android.livesdk.chatroom.ui.framework.b.d(r10, new InRoomBannerManagerWidget$prepareInRoomBannerManager$2(this));
        if (r11 == null) goto L27;
        RxUtilKt.c(r11, this.d);
    L27:
        ((Widget) this).dataCenter.put("data_in_room_banner_manager", this.c);
        ((Widget) this).dataCenter.observe("data_room_banner_status", this).observe("data_right_bottom_banner_container_show", this).observe("data_right_bottom_banner_show", this);
        com.bytedance.android.livesdk.chatroom.ui.framework.c r12 = this.a;
        if (r12 == null) goto L35;
        PropertyOwner r13 = r12.Ce();
        if (r13 == null) goto L36;
        Disposable r14 = r13.subscribe(new a(this));
        if (r14 == null) goto L37;
        RxUtilKt.c(r14, this.d);
        return;
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L8:
        r3 = 0;
        goto L9
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L6;
        ho1.a.q(r0, jo1.g.class);
    L6:
        if (this.d.isDisposed() == true) goto L8;
        this.d.dispose();
    L8:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L11;
        r1.removeObserver(this);
    L11:
        this.a = null;
        this.b = null;
    }

    public final void onResume() {
        super.onResume();
        InRoomBannerManager r0 = this.c;
        if (r0 == null) goto L10;
        Integer r1 = Integer.valueOf(com.bytedance.android.livesdk.utils.c1.i(((Widget) this).dataCenter));
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        r0.e = r2;
        return;
    L7:
        r2 = 0;
        goto L8
    }

    public static final /* synthetic */ DataContext wq(InRoomBannerManagerWidget r0) {
        return r0.dataContext;
    }

    public final void onChanged(Object r7) {
        KVData r8 = (KVData) r7;
        if (isViewValid() == false) goto L106;
        View r0 = null;
        if (r8 == null) goto L7;
        String r1 = r8.getKey();
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L107;
        if (r8 == null) goto L12;
        Object r2 = r8.getData();
    L13:
        if (r2 == null) goto L120;
        String r3 = r8.getKey();
        int r4 = r3.hashCode();
        if (r4 == 297505362) goto L98;
        if (r4 == 1446063636) goto L84;
        if (r4 == 2085465782) goto L23;
        return;
    L23:
        if (r3.equals("data_room_banner_status") == false) goto L108;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r9 = this.a;
        if (r9 != null) goto L27;
        return;
    L27:
        if (r9.hq() != true) goto L110;
        int r5 = 0;
        if (getRoom() == null) goto L42;
        Room r10 = getRoom();
        if (r10 == null) goto L33;
        RoomAuthStatus r11 = r10.getRoomAuthStatus();
    L34:
        if (r11 == null) goto L42;
        Room r12 = getRoom();
        if (r12 == null) goto L42;
        RoomAuthStatus r13 = r12.getRoomAuthStatus();
        if (r13 == null) goto L42;
        if (r13.enableBanner() != true) goto L42;
        boolean r14 = true;
    L44:
        if (r14 == false) goto L61;
        com.bytedance.android.livesdk.chatroom.ui.framework.d r6 = this.b;
        if (r6 == null) goto L48;
        View r15 = r6.in();
    L50:
        if (xq(true) == false) goto L52;
        int r16 = 0;
    L53:
        UIUtils.setViewVisibility(r15, r16);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r17 = this.b;
        if (r17 == null) goto L57;
        r0 = r17.n6();
    L57:
        if (xq(true) == true) goto L60;
        r5 = 4;
    L60:
        UIUtils.setViewVisibility(r0, r5);
        ((Widget) this).dataCenter.put("cmd_refresh_bottom_right_banner_content", "");
    L77:
        DataCenter r18 = ((Widget) this).dataCenter;
        if (r18 == null) goto L82;
        LayerEventDispatcher r19 = o70.c.a(Integer.valueOf(r18.hashCode()));
        if (r19 == null) goto L82;
        r19.b(new yn1.a(r14));
    L82:
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.b(((Widget) this).dataCenter, "DATA_ROOM_BANNER_STATUS");
        return;
    L52:
        r16 = 4;
        goto L53
    L48:
        r15 = null;
        goto L50
    L61:
        com.bytedance.android.livesdk.chatroom.ui.framework.d r20 = this.b;
        if (r20 == null) goto L64;
        View r21 = r20.in();
    L66:
        if (xq(false) == false) goto L68;
        int r22 = 0;
    L69:
        UIUtils.setViewVisibility(r21, r22);
        com.bytedance.android.livesdk.chatroom.ui.framework.d r23 = this.b;
        if (r23 == null) goto L73;
        r0 = r23.n6();
    L73:
        if (xq(false) == true) goto L76;
        r5 = 4;
    L76:
        UIUtils.setViewVisibility(r0, r5);
        goto L77
    L68:
        r22 = 4;
        goto L69
    L64:
        r21 = null;
        goto L66
    L33:
        r11 = null;
    L42:
        r14 = false;
        goto L44
    L110:
        return;
    L108:
        return;
    L84:
        if (r3.equals("data_right_bottom_banner_show") == false) goto L112;
        Integer r24 = os.a.getValue();
        if (r24 != null) goto L89;
        return;
    L89:
        if (r24.intValue() == 0) goto L91;
        return;
    L91:
        if ((r8.getData() instanceof m3) == false) goto L114;
        m3 r25 = (m3) r8.getData();
        if (r25 != null) goto L95;
        return;
    L95:
        if (r25.b != 0) goto L116;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.c(((Widget) this).dataCenter, "DATA_RIGHT_BOTTOM_BANNER_SHOW");
        return;
    L116:
        return;
    L114:
        return;
    L112:
        return;
    L98:
        if (r3.equals("data_right_bottom_banner_container_show") == false) goto L118;
        Integer r26 = os.a.getValue();
        if (r26 != null) goto L103;
        return;
    L103:
        if (r26.intValue() != 1) goto L119;
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.h.b(((Widget) this).dataCenter, "DATA_RIGHT_BOTTOM_BANNER_CONTAINER_SHOW");
        return;
    L119:
        return;
    L118:
        return;
    L120:
        return;
    L12:
        r2 = null;
        goto L13
    L107:
        return;
    L7:
        r1 = null;
        goto L9
    }

    public final boolean xq(boolean r3) {
        com.bytedance.android.livesdk.chatroom.ui.framework.c r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        if (r3 == true) goto L9;
    L17:
        return false;
    L9:
        if (h2.d(((Widget) this).dataCenter) == false) goto L11;
        return true;
    L11:
        if (getRoom() == null) goto L17;
        Room r4 = getRoom();
        if (r4 == null) goto L17;
        if (r4.isMediaRoom() != true) goto L17;
        return true;
    L5:
        if (r0.dg() != true) goto L7;
        return r3;
    }
}
