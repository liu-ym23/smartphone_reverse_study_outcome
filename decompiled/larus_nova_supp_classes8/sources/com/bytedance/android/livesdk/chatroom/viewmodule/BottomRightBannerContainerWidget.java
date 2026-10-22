package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.banner.InRoomBannerManager;
import com.bytedance.android.livesdk.chatroom.model.BannerInRoomCollection;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.config.ca1;
import com.bytedance.android.livesdk.config.og;
import com.bytedance.android.livesdkapi.banner.BannerData;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006:\u0002\t\nB\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/BottomRightBannerContainerWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/i$b;", "Lvlc/l;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/q2;", "<init>", "()V", "a", "ContentViewHideController", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomRightBannerContainerWidget extends LiveRecyclableWidget implements i.b, vlc.l, Observer<KVData>, q2 {
    public j a;
    public vlc.d b;
    public ViewGroup c;
    public final ContentViewHideController d;
    public final PropertyOwner<Boolean> e;

    public static final class ContentViewHideController {
        public View a;
        public final Set<HideLock> b;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/BottomRightBannerContainerWidget$ContentViewHideController$HideLock;", "", "MiniApp", "TalkRoom", "BlindBox", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum HideLock extends Enum<HideLock> {
            public static final HideLock BlindBox = null;
            public static final HideLock MiniApp = null;
            public static final HideLock TalkRoom = null;
            public static final /* synthetic */ HideLock[] a = null;

            static {
                HideLock r1 = new HideLock("MiniApp", 0);
                MiniApp = r1;
                HideLock r2 = new HideLock("TalkRoom", 1);
                TalkRoom = r2;
                HideLock r3 = new HideLock("BlindBox", 2);
                BlindBox = r3;
                a = new HideLock[]{r1, r2, r3};
            }

            public static HideLock valueOf(String r1) {
                return (HideLock) r27.a.a(HideLock.class, r1);
            }

            public static HideLock[] values() {
                return (HideLock[]) a.clone();
            }

            public HideLock(String r1, int r2) {
                super(r1, r2);
            }
        }

        public ContentViewHideController() {
            this.b = new LinkedHashSet();
        }
    }

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ BottomRightBannerContainerWidget a;

        public b(InRoomBannerManager r1, BottomRightBannerContainerWidget r2) {
            this.a = r2;
        }

        public final void accept(Object r3) {
            BannerInRoomCollection.BannerInfo r4 = ((BannerData) r3).getData().getBottomRightBanner();
            if (r4 == null) goto L8;
            j r1 = this.a.a;
            if (r1 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("bottomRightBannerHolder");
        L7:
            r1.e(r4);
            return;
        L8:
            j r5 = this.a.a;
            if (r5 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("bottomRightBannerHolder");
        L11:
            r5.hide();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ BottomRightBannerContainerWidget a;

        public c(InRoomBannerManager r1, BottomRightBannerContainerWidget r2) {
            this.a = r2;
        }

        public final void accept(Object r3) {
            BannerInRoomCollection.BannerInfo r4 = ((BannerData) r3).getData().getBottomRightBanner();
            if (r4 == null) goto L8;
            j r1 = this.a.a;
            if (r1 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("bottomRightBannerHolder");
        L7:
            r1.e(r4);
            return;
        L8:
            j r5 = this.a.a;
            if (r5 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("bottomRightBannerHolder");
        L11:
            r5.hide();
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.i.b
    public final void He(i<? extends Widget> r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
    }

    public final int getLayoutId() {
        return 2131568005;
    }

    public final void onUnload() {
        this.d.a = null;
        j r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("bottomRightBannerHolder");
    L6:
        if (r0.b == 0) goto L12;
        r0.o.setText("");
        r0.n.setActualImageResource(0);
        r0.n.setBackgroundResource(2131249832);
        WidgetManager r2 = r0.d;
        if (r2 == null) goto L11;
        r2.unload(r0.b);
    L11:
        r0.d = null;
        r0.b = null;
        r0.j.removeView(r0.c());
        r0.hide();
        r0.l.He(r0);
    L12:
        vlc.d r1 = this.b;
        if (r1 == null) goto L15;
        r1.removeMessageListener(this);
    L15:
        ((Widget) this).dataCenter.removeObserver(this);
    }

    public BottomRightBannerContainerWidget() {
        this.d = new ContentViewHideController();
        this.e = new PropertyOwner(Boolean.TRUE, BottomRightBannerContainerWidget$isBannerHidden$1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.q2
    public final PropertyOwner cl() {
        return this.e;
    }

    public static void xq(String r3) {
        HashMap r0 = new HashMap();
        r0.put("event_name", "on_adjust_text_message_widget");
        r0.put("adjust_reason", "bc_container_extend_banner_change");
        r0.put("adjust_param", r3);
        com.bytedance.android.livesdk.log.b0.o().j("ttlive_room", r0);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.i.b
    public final void Oa(i r2) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        boolean r3 = r2 instanceof j;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 == null) goto L57;
        Object r0 = r7.getData();
        if (r0 == null) goto L74;
        String r1 = r7.getKey();
        switch(r1.hashCode()) {
            case -261927283: goto L46;
            case 985679695: goto L35;
            case 1324747558: goto L26;
            case 1446063636: goto L11;
            default: goto L75;
        };
    L75:
        return;
    L11:
        if (r1.equals("data_right_bottom_banner_show") == true) goto L13;
        return;
    L13:
        if ((r7.getData() instanceof zg1.m3) == false) goto L59;
        zg1.m3 r8 = (zg1.m3) r7.getData();
        if (r8 == null) goto L60;
        boolean r9 = r8.a;
        if (r9 != true) goto L21;
        xq("state: 1");
        DataCenter r10 = ((Widget) this).dataCenter;
        if (r10 == null) goto L61;
        r10.put("data_right_bottom_banner_container_show", Boolean.TRUE);
        return;
    L61:
        return;
    L21:
        if (r9 == true) goto L63;
        xq("state: 2");
        DataCenter r11 = ((Widget) this).dataCenter;
        if (r11 == null) goto L64;
        r11.put("data_right_bottom_banner_container_show", Boolean.FALSE);
        return;
    L64:
        return;
    L63:
        return;
    L60:
        return;
    L59:
        return;
    L26:
        if (r1.equals("data_is_blind_box_banner_present") == true) goto L28;
        return;
    L28:
        if ((r0 instanceof Boolean) == true) goto L31;
        r0 = null;
    L31:
        if (Intrinsics.areEqual((Boolean) r0, Boolean.TRUE) == false) goto L33;
        wq(ContentViewHideController.HideLock.BlindBox);
        return;
    L33:
        yq(ContentViewHideController.HideLock.BlindBox);
        return;
    L35:
        if (r1.equals("data_bottom_right_state") == true) goto L37;
        return;
    L37:
        if ((r0 instanceof zg1.f3) == true) goto L39;
        r0 = null;
    L39:
        zg1.f3 r2 = (zg1.f3) r0;
        if (r2 != null) goto L42;
    L44:
        yq(ContentViewHideController.HideLock.MiniApp);
        return;
    L42:
        if (r2.a != true) goto L44;
        wq(ContentViewHideController.HideLock.MiniApp);
        return;
    L46:
        if (r1.equals("cmd_video_talkroom_state_change") == true) goto L48;
        return;
    L48:
        if ((r0 instanceof zg1.l3) == true) goto L50;
        r0 = null;
    L50:
        zg1.l3 r3 = (zg1.l3) r0;
        if (r3 != null) goto L53;
    L55:
        yq(ContentViewHideController.HideLock.TalkRoom);
        return;
    L53:
        if (r3.a != 0) goto L55;
        wq(ContentViewHideController.HideLock.TalkRoom);
        return;
    L74:
        return;
    }

    public final void onInit(Object[] r2) {
        ViewGroup r3 = (ViewGroup) ((Widget) this).contentView.findViewById(2131384185);
        this.c = r3;
        if (r3 == null) goto L6;
        ViewGroup r0 = this.c;
        Intrinsics.checkNotNull(r0);
        this.a = new j(r0, this);
        return;
    }

    public final void onLoad(Object[] r9) {
        if (PerformanceTestSettings.TEST_DISABLE_BANNER.getValue().booleanValue() == false) goto L5;
        return;
    L5:
        this.d.a = ((Widget) this).contentView;
        ca1 r10 = ca1.a;
        if (r10.getValue().booleanValue() == false) goto L14;
        View r0 = ((Widget) this).contentView;
        if (r0 == null) goto L14;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L14;
        r1.width = -1;
        r1.height = UIUtils.getScreenHeight(((Widget) this).context) / 2;
        View r2 = ((Widget) this).contentView;
        if (r2 == null) goto L14;
        r2.setLayoutParams(r1);
    L14:
        long r3 = 0;
        vlc.d r6 = null;
        if (og.a.getValue().booleanValue() == false) goto L22;
        InRoomBannerManager r4 = (InRoomBannerManager) ((Widget) this).dataCenter.get("data_in_room_banner_manager", null);
        if (r4 == null) goto L31;
        IRoom r5 = com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter).a;
        if (r5 == null) goto L21;
        r3 = r5.getId();
    L21:
        ((ObservableSubscribeProxy) r4.d(Long.valueOf(r3), 1).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new b(r4, this));
        Unit r7 = Unit.INSTANCE;
    L31:
        if (com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter).b == false) goto L33;
        ((Widget) this).dataCenter.observeForever("cmd_gift_dialog_switch", this).observe("data_pre_show_keyboard", this).observe("data_keyboard_status", this).observe("data_right_bottom_banner_show", this);
    L33:
        ((Widget) this).dataCenter.observe("data_bottom_right_state", this).observe("cmd_video_talkroom_state_change", this).observe("data_is_blind_box_banner_present", this);
        enableSubWidgetManager();
        j r8 = this.a;
        if (r8 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("bottomRightBannerHolder");
    L36:
        BottomRightBannerWidget r11 = new BottomRightBannerWidget();
        r11.h = true;
        Unit r12 = Unit.INSTANCE;
        WidgetManager r13 = ((Widget) this).subWidgetManager;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r11, "widget");
        Intrinsics.checkNotNullParameter(r13, "widgetManager");
        if (r8.b != 0) goto L52;
        r8.j.addView(r8.c());
        r8.b = r11;
        r13.load(r8.k, r11);
        r8.d = r13;
        BottomRightBannerWidget r14 = r8.b;
        if (r14 == null) goto L43;
        r14.g = r8;
    L43:
        if (j.q == false) goto L45;
        r8.a();
    L47:
        if (r10.getValue().booleanValue() == false) goto L51;
        ViewGroup.LayoutParams r15 = r8.c().findViewById(2131384186).getLayoutParams();
        if (r15 == null) goto L51;
        r15.width = -1;
        r15.height = UIUtils.getScreenHeight(r8.c().getContext()) / 2;
        r8.c().findViewById(2131384186).setLayoutParams(r15);
    L51:
        r8.l.He(r8);
        goto L52
    L45:
        r8.b();
    L52:
        j r16 = this.a;
        if (r16 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("bottomRightBannerHolder");
    L55:
        BottomRightBannerWidget r17 = r16.b;
        if (r17 == null) goto L62;
        PropertyOwner<Boolean> r18 = r17.o;
        if (r18 == null) goto L62;
        ObservableSubscribeProxy r19 = (ObservableSubscribeProxy) r18.as(AutoDispose.bind(this));
        if (r19 == null) goto L62;
        r19.subscribe(this.e);
    L62:
        vlc.d r20 = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager", null);
        if (r20 == null) goto L65;
        r20.addMessageListener(MessageType.BANNER_UPDATE.getIntType(), this);
        r6 = r20;
    L65:
        this.b = r6;
        return;
    L22:
        InRoomBannerManager r21 = (InRoomBannerManager) ((Widget) this).dataCenter.get("data_in_room_banner_manager", null);
        if (r21 == null) goto L28;
        IRoom r22 = com.bytedance.android.live.core.utils.z.b(((Widget) this).dataCenter).a;
        if (r22 == null) goto L27;
        r3 = r22.getId();
    L27:
        ((ObservableSubscribeProxy) r21.d(Long.valueOf(r3), 1).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new c(r21, this));
        Unit r23 = Unit.INSTANCE;
    L29:
        if (r21 != null) goto L31;
        throw new IllegalStateException("Required value was null.".toString());
    L28:
        r21 = null;
        goto L29
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof com.bytedance.android.livesdk.message.model.k0) == true) goto L5;
        return;
    L5:
        BannerInRoomCollection r4 = ((com.bytedance.android.livesdk.message.model.k0) r3).E();
        if (r4 == null) goto L14;
        BannerInRoomCollection.BannerInfo r5 = r4.getBottomRightBanner();
        if (r5 == null) goto L15;
        j r0 = this.a;
        if (r0 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("bottomRightBannerHolder");
    L12:
        r0.e(r5);
        return;
    L15:
        return;
    }

    public final void wq(ContentViewHideController.HideLock r3) {
        ContentViewHideController r0 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "type");
        r0.b.add(r3);
        boolean r4 = r0.b.isEmpty();
        View r1 = r0.a;
        if (r1 == null) goto L9;
        if (r4 == false) goto L6;
        int r5 = 0;
    L7:
        r1.setVisibility(r5);
        return;
    L6:
        r5 = 8;
        goto L7
    }

    public final void yq(ContentViewHideController.HideLock r3) {
        ContentViewHideController r0 = this.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "type");
        r0.b.remove(r3);
        boolean r4 = r0.b.isEmpty();
        View r1 = r0.a;
        if (r1 == null) goto L9;
        if (r4 == false) goto L6;
        int r5 = 0;
    L7:
        r1.setVisibility(r5);
        return;
    L6:
        r5 = 8;
        goto L7
    }
}
