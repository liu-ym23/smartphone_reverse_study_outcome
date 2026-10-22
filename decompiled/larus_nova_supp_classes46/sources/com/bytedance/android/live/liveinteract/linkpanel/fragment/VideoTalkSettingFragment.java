package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.ILinkmicAnnounceMessage;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.component.api.linkpanel.ILinkPanelService;
import com.bytedance.android.live.liveinteract.linkpanel.contract.VideoTalkDialogContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.util.OpenPanelSource;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.liveinteract.service.LinkPanelTransitService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.config.bc0;
import com.bytedance.android.livesdk.config.rj1;
import com.bytedance.android.livesdk.config.u01;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.message.MultiLinkMessageMethods;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/VideoTalkSettingFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/VideoTalkDialogContract$View;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoTalkSettingFragment extends VideoTalkDialogContract$View implements Observer<KVData> {
    public static final /* synthetic */ int z = 0;
    public Map<Integer, View> g;
    public View h;
    public ViewGroup i;
    public IRoom j;
    public boolean k;
    public boolean l;
    public int m;
    public DataCenter n;
    public boolean o;
    public boolean p;
    public final CompositeDisposable q;
    public DataContext r;
    public List<? extends com.bytedance.android.livesdk.chatroom.model.k1> s;
    public List<Integer> t;
    public final Map<String, Boolean> u;
    public boolean v;
    public tb6.c w;
    public final Function1<com.bytedance.android.live.liveinteract.api.data.a, Unit> x;
    public final Function1<com.bytedance.android.live.liveinteract.api.data.a, Unit> y;

    public static final class a {
        public static VideoTalkSettingFragment a(yf0.g r1, IRoom r2, boolean r3, boolean r4, int r5, DataCenter r6, boolean r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
            VideoTalkSettingFragment r0 = new VideoTalkSettingFragment();
            r0.d = r1;
            IRoom r9 = jm2.a.d((vh7.c) r2);
            if (r9 == null) goto L9;
            IRoom r10 = r9;
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            r0.j = r10;
            r0.k = r3;
            r0.l = r4;
            r0.m = r5;
            r0.n = r6;
            r0.o = r7;
            r0.p = r8;
            tb6.c r11 = r0.w;
            if (r11 == null) goto L7;
            r11.a();
        L7:
            return r0;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ VideoTalkSettingFragment a;

        public b(VideoTalkSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            VideoTalkSettingFragment r4 = this.a;
            yf0.g r0 = r4.d;
            if (r0 == null) goto L6;
            int r1 = ApplyPermissionSwitchFragment.o;
            r0.Rh(ApplyPermissionSwitchFragment.a.a(r0, r4.getRoom(), 1));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ VideoTalkSettingFragment a;
        public final /* synthetic */ long b;

        public c(VideoTalkSettingFragment r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            Intrinsics.checkNotNullParameter(r9, "response");
            int r0 = nd0.g.a;
            nd0.g.d(this.b, r9);
            List r1 = ((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getInteractItems();
            Long r2 = null;
            if (r1 == null) goto L41;
            Iterator r3 = r1.iterator();
            if (r3 == null) goto L41;
        L7:
            if (r3.hasNext() == false) goto L41;
            com.bytedance.android.livesdk.chatroom.model.k1 r4 = (com.bytedance.android.livesdk.chatroom.model.k1) r3.next();
            if (ArraysKt.contains(com.bytedance.android.livesdk.chatroom.model.e1.CURRENT_VERSION_SUPPORT_TYPE, r4.getType()) == true) goto L25;
            Integer r5 = Integer.valueOf(r4.getGameDataType());
            SimpleDateFormat r6 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
            if (r5 != null) goto L14;
        L16:
            if (r5 != null) goto L19;
        L21:
            boolean r7 = false;
        L22:
            if (r7 == true) goto L25;
            r3.remove();
            goto L7
        L19:
            if (r5.intValue() != 1) goto L21;
        L15:
            r7 = true;
            goto L22
        L14:
            if (r5.intValue() != 2) goto L16;
        L25:
            if (r4.getType() != 1) goto L30;
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.H() == true) goto L30;
            r3.remove();
        L30:
            if (r4.getType() != 7) goto L37;
            xi0.a r10 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
            if (r10 == null) goto L35;
            if (r10.r2() == true) goto L37;
        L35:
            r3.remove();
        L37:
            if (r4.getType() != 10) goto L7;
            if (((Boolean) vm2.d.U0.getValue(null, vm2.d.a[96])).booleanValue() == true) goto L7;
            r3.remove();
        L41:
            VideoTalkSettingFragment r11 = this.a;
            r11.s = ((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getInteractItems();
            VideoTalkSettingFragment r12 = this.a;
            r12.t = ((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getCurInteractType();
            VideoTalkSettingFragment r13 = this.a;
            DataCenter r14 = r13.n;
            IRoom r15 = r13.getRoom();
            if (r15 == null) goto L44;
            r2 = Long.valueOf(r15.getRoomId());
        L44:
            com.bytedance.android.livesdk.chatroom.u r16 = com.bytedance.android.live.liveinteract.api.utils.m.f(r14, r2);
            if (r16 == null) goto L49;
            com.bytedance.live.datacontext.n r17 = r16.l();
            if (r17 == null) goto L49;
            r17.setValue(this.a.s);
        L49:
            VideoTalkSettingFragment r18 = this.a;
            com.bytedance.live.datacontext.n r19 = com.bytedance.android.live.liveinteract.api.utils.m.f(r18.n, Long.valueOf(r18.getRoom().getRoomId())).F();
            if (r19 == null) goto L52;
            r19.setValue(this.a.t);
        L52:
            this.a.ua0();
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;

        public d(long r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.a;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.z(r1, r5);
            ALogger.w("video_talk", r5);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ VideoTalkSettingFragment a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public e(VideoTalkSettingFragment r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
            com.bytedance.android.livesdk.sharedpref.e r5 = b6.d;
            Boolean r0 = Boolean.valueOf(this.b);
            r5.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r5, r0);
            ((Switch) this.a.ja0().findViewById(2131387859)).setEnabled(true);
            if (this.b == true) goto L7;
            DataCenter r6 = this.a.n;
            if (r6 == null) goto L7;
            r6.put("data_video_talk_dot_with_number_show", "");
        L7:
            this.a.oa0(null);
            if (this.c == false) goto L11;
            this.a.d.dismiss();
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VideoTalkSettingFragment a;
        public final /* synthetic */ boolean b;

        public f(VideoTalkSettingFragment r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            f2.c(com.bytedance.android.live.core.utils.s1.B(2131915982), 0);
            ((Switch) this.a.ja0().findViewById(2131387859)).setChecked(((Boolean) b6.d.getValue()).booleanValue());
            ((Switch) this.a.ja0().findViewById(2131387859)).setEnabled(true);
            ALogger.e("err api", ((Throwable) r4).toString());
            if (this.b == false) goto L6;
            this.a.d.dismiss();
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        return 432.0f;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final void Z90() {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public final boolean fa0() {
        DataCenter r0 = this.n;
        int r1 = 0;
        if (r0 == null) goto L8;
        Integer r2 = (Integer) r0.get("data_link_state", 0);
        if (r2 == null) goto L8;
        r1 = r2.intValue();
    L8:
        return gd0.v.a(r1, 32);
    }

    public final void ga0() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        ((TextView) r0.findViewById(2131390849)).setVisibility(8);
        View r1 = this.h;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L8:
        r1.findViewById(2131366871).setVisibility(8);
        View r2 = this.h;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L11:
        ((TextView) r2.findViewById(2131391726)).setVisibility(8);
        View r3 = this.h;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        ((FrameLayout) r3.findViewById(2131372775)).setVisibility(8);
    }

    public final IRoom getRoom() {
        IRoom r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        return r0;
    }

    public final void ha0() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        ((TextView) r0.findViewById(2131390849)).setVisibility(8);
        View r1 = this.h;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L8:
        r1.findViewById(2131366871).setVisibility(8);
        View r2 = this.h;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L11:
        r2.findViewById(2131366873).setVisibility(8);
        View r3 = this.h;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        ((TextView) r3.findViewById(2131391726)).setVisibility(8);
        View r4 = this.h;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        ((FrameLayout) r4.findViewById(2131372775)).setVisibility(8);
    }

    public final View ja0() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        return r0;
    }

    public final void la0() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        boolean r1 = r0.isCanShowLinkmicAnnounce(true);
    L7:
        if (r1 == false) goto L9;
    L15:
        View r2 = this.h;
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L18:
        ((TextView) r2.findViewById(2131390670)).setVisibility(0);
    L19:
        IInteractService r3 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r3 == null) goto L22;
        boolean r4 = r3.isCanShowLinkmicAnnounce(true);
    L23:
        com.bytedance.android.live.liveinteract.revenue.guestlink.i r5 = null;
        if (r4 == false) goto L68;
        View r6 = this.h;
        if (r6 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L28:
        r6.findViewById(2131363026).setVisibility(0);
        View r7 = this.h;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L31:
        ((TextView) r7.findViewById(2131363029)).setFilters(new InputFilter[]{new je0.a(8)});
        DataCenter r8 = this.n;
        if (r8 == null) goto L34;
        vlc.d r9 = (vlc.d) r8.get("data_message_manager");
    L35:
        if (r9 == null) goto L37;
        ILinkmicAnnounceMessage r10 = (ILinkmicAnnounceMessage) bc2.d.a(r9, MultiLinkMessageMethods.INSTANCE.getLINKMIC_ANNOUNCE_METHOD());
    L38:
        if (r10 == null) goto L47;
        ILinkmicAnnounceMessage.b r11 = r10.getShowingAnnounce();
        if (r11 == null) goto L47;
        String r12 = r11.a();
        if (r12 == null) goto L47;
        View r13 = this.h;
        if (r13 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L46:
        ((TextView) r13.findViewById(2131363029)).setText(r12);
    L47:
        IRoom r14 = this.j;
        if (r14 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L51:
        if (Intrinsics.areEqual(r14.getAnchorAbValue("live_chatroom_announce_image_enable"), "true") == false) goto L53;
        Boolean r15 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.k1.getValue();
    L55:
        if (r15.booleanValue() == false) goto L60;
        View r16 = this.h;
        if (r16 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L59:
        UtilityKotlinExtentionsKt.w(r16.findViewById(2131363027));
    L64:
        View r17 = this.h;
        if (r17 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L67:
        r17.findViewById(2131363026).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkSettingFragment$initLinkmicAnnounceSetting$2(this)));
    L73:
        if (pa0() == false) goto L118;
        StringBuilder r18 = new StringBuilder("initGuestLinkSwitch: ");
        com.bytedance.android.livesdk.sharedpref.e r19 = com.bytedance.android.livesdk.sharedpref.c.z1;
        r18.append((Boolean) r19.getValue());
        ALogger.i("VideoTalkSettingFragment", r18.toString());
        tb6.a.c();
        View r20 = this.h;
        if (r20 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L77:
        r20.findViewById(2131374068).setVisibility(0);
        View r21 = this.h;
        if (r21 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L80:
        r21.findViewById(2131374068).setOnClickListener(new t0(this));
        View r22 = this.h;
        if (r22 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L83:
        TextView r23 = (TextView) r22.findViewById(2131390729);
        String r24 = vm2.i.e().getSettingTitle();
        if (r24 != null) goto L87;
        r24 = com.bytedance.android.live.core.utils.s1.B(2131917653);
    L87:
        r23.setText(r24);
        View r25 = this.h;
        if (r25 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L90:
        TextView r26 = (TextView) r25.findViewById(2131390728);
        if (((Boolean) r19.getValue()).booleanValue() == false) goto L93;
        String r27 = com.bytedance.android.live.core.utils.s1.B(2131917651);
    L94:
        r26.setText(r27);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.l1.getValue()).booleanValue() == false) goto L100;
        View r28 = this.h;
        if (r28 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L99:
        UtilityKotlinExtentionsKt.w(r28.findViewById(2131374067));
    L104:
        com.bytedance.android.live.liveinteract.revenue.guestlink.i r29 = com.bytedance.live.datacontext.d.d(com.bytedance.android.live.liveinteract.revenue.guestlink.i.class);
        if ((r29 instanceof com.bytedance.android.live.liveinteract.revenue.guestlink.i) == false) goto L108;
        r5 = r29;
    L108:
        com.bytedance.android.live.liveinteract.revenue.guestlink.i r30 = r5;
        if (r30 == null) goto L119;
        com.bytedance.live.datacontext.m<Boolean> r31 = r30.isOpen();
        if (r31 == null) goto L120;
        Observable r32 = r31.a();
        if (r32 == null) goto L121;
        Disposable r33 = r32.subscribe(new u0(this));
        if (r33 == null) goto L122;
        this.q.add(r33);
        return;
    L122:
        return;
    L121:
        return;
    L120:
        return;
    L119:
        return;
    L100:
        View r34 = this.h;
        if (r34 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L103:
        UtilityKotlinExtentionsKt.t(r34.findViewById(2131374067));
        goto L104
    L93:
        r27 = com.bytedance.android.live.core.utils.s1.B(2131917650);
        goto L94
    L118:
        return;
    L60:
        View r35 = this.h;
        if (r35 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L63:
        UtilityKotlinExtentionsKt.t(r35.findViewById(2131363027));
        goto L64
    L53:
        r15 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.j1.getValue();
        goto L55
    L37:
        r10 = null;
        goto L38
    L34:
        r9 = null;
        goto L35
    L68:
        View r36 = this.h;
        if (r36 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L71:
        r36.findViewById(2131363026).setVisibility(8);
        goto L73
    L22:
        r4 = false;
        goto L23
    L9:
        if (pa0() == true) goto L15;
        View r37 = this.h;
        if (r37 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        ((TextView) r37.findViewById(2131390670)).setVisibility(8);
        goto L19
    L5:
        r1 = false;
        goto L7
    }

    public final boolean pa0() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.m(this.r).isAnchor(), Boolean.TRUE) == true) goto L22;
        boolean r0 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        DataCenter r3 = this.n;
        IBaseUser r4 = null;
        if (r3 == null) goto L7;
        r4 = (IBaseUser) r3.get("data_user_in_room", null);
    L7:
        if (r4 == null) goto L15;
        py.t r5 = r4.getUserAttr();
        if (r5 == null) goto L15;
        List r6 = r5.getAdminPrivileges();
        if (r6 == null) goto L15;
        LiveRoomPermission.D.getClass();
        if (r6.contains(Integer.valueOf(LiveRoomPermission.u.a)) != true) goto L15;
        boolean r7 = true;
    L16:
        if (r0 == false) goto L19;
        if (r7 == false) goto L19;
        boolean r1 = true;
    L20:
        if (r1 == true) goto L22;
        return false;
    L19:
        r1 = false;
    L15:
        r7 = false;
    L22:
        if (vm2.i.e().getEnabled() == true) goto L24;
        return false;
    L24:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.A1.getValue()).booleanValue() == false) goto L29;
        return true;
    L29:
        return false;
    }

    public final void ua0() {
        if (CollectionUtils.isEmpty(this.s) == false) goto L8;
        View r0 = this.h;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L7:
        ((LinearLayout) r0.findViewById(2131378799)).setVisibility(8);
        return;
    L8:
        View r1 = this.h;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L11:
        LinearLayout r2 = (LinearLayout) r1.findViewById(2131391119);
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r3 = this.s;
        Object r4 = null;
        if (r3 == null) goto L14;
        Integer r5 = Integer.valueOf(r3.size());
    L15:
        Intrinsics.checkNotNull(r5);
        if (r5.intValue() <= 2) goto L18;
        int r6 = 0;
    L19:
        r2.setVisibility(r6);
        String r7 = OpenPanelSource.LINK_SETTING_PANEL.getValue();
        ((TalkRoomLogUtils) ((IInteractService) jc1.k.n(IInteractService.class)).getTalkRoomLogUtils()).getClass();
        Intrinsics.checkNotNullParameter(r7, "source");
        TalkRoomLogUtils.o1(r7);
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r8 = this.s;
        if (r8 == null) goto L42;
        com.bytedance.android.livesdk.chatroom.model.k1 r9 = (com.bytedance.android.livesdk.chatroom.model.k1) CollectionsKt.getOrNull(r8, 0);
        if (r9 == null) goto L42;
        View r10 = this.h;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L26:
        ((LinearLayout) r10.findViewById(2131378724)).setVisibility(0);
        View r11 = this.h;
        if (r11 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L29:
        ((TextView) r11.findViewById(2131390831)).setText(r9.getTitle().toString());
        py.k r12 = r9.getIcon();
        if (r12 == null) goto L35;
        View r13 = this.h;
        if (r13 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L34:
        ImageUtil.loadImage((ImageView) r13.findViewById(2131376333), r12, 0);
    L35:
        View r14 = this.h;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L38:
        ((LinearLayout) r14.findViewById(2131378724)).setOnClickListener(new r1(r9, this, r7));
        if (r9.getType() != 1) goto L41;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.u("link_setting_panel");
    L41:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.t(r9.getType(), r7);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.o(r9);
    L42:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r15 = this.s;
        if (r15 == null) goto L65;
        com.bytedance.android.livesdk.chatroom.model.k1 r16 = (com.bytedance.android.livesdk.chatroom.model.k1) CollectionsKt.getOrNull(r15, 1);
        if (r16 == null) goto L65;
        View r17 = this.h;
        if (r17 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L49:
        ((LinearLayout) r17.findViewById(2131378725)).setVisibility(0);
        View r18 = this.h;
        if (r18 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L52:
        ((TextView) r18.findViewById(2131390832)).setText(r16.getTitle().toString());
        py.k r19 = r16.getIcon();
        if (r19 == null) goto L58;
        View r110 = this.h;
        if (r110 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L57:
        ImageUtil.loadImage((ImageView) r110.findViewById(2131376334), r19, 0);
    L58:
        View r20 = this.h;
        if (r20 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L61:
        ((LinearLayout) r20.findViewById(2131378725)).setOnClickListener(new s1(r16, this, r7));
        if (r16.getType() != 1) goto L64;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.u("link_setting_panel");
    L64:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.t(r16.getType(), r7);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.o(r16);
    L65:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r21 = this.s;
        if (r21 == null) goto L80;
        List r22 = CollectionsKt.take(r21, 2);
        if (r22 == null) goto L80;
        Iterator r23 = r22.iterator();
    L71:
        if (r23.hasNext() == false) goto L78;
        Object r24 = r23.next();
        if (((com.bytedance.android.livesdk.chatroom.model.k1) r24).getType() != 2) goto L75;
        boolean r25 = true;
    L76:
        if (r25 == false) goto L71;
    L79:
        com.bytedance.android.livesdk.chatroom.model.k1 r26 = (com.bytedance.android.livesdk.chatroom.model.k1) r24;
    L81:
        if (r26 == null) goto L83;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.x(r7);
    L83:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r27 = this.s;
        if (r27 == null) goto L97;
        List r28 = CollectionsKt.take(r27, 2);
        if (r28 == null) goto L97;
        Iterator r29 = r28.iterator();
    L89:
        if (r29.hasNext() == false) goto L96;
        Object r30 = r29.next();
        if (((com.bytedance.android.livesdk.chatroom.model.k1) r30).getType() != 7) goto L93;
        boolean r31 = true;
    L94:
        if (r31 == false) goto L89;
        r4 = r30;
        goto L96
    L93:
        r31 = false;
    L96:
        r4 = (com.bytedance.android.livesdk.chatroom.model.k1) r4;
    L97:
        if (r4 == null) goto L111;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.w(r7);
        return;
    L111:
        return;
    L75:
        r25 = false;
        goto L76
    L78:
        r24 = null;
    L80:
        r26 = null;
        goto L81
    L18:
        r6 = 4;
        goto L19
    L14:
        r5 = null;
        goto L15
    }

    public final void va0() {
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        boolean r2 = false;
        if (r1 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r3 == null) goto L17;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r3.t();
        if (r4 == null) goto L17;
        Integer r5 = Integer.valueOf(r4.a);
        if (r5.intValue() == 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L15;
        r5 = null;
    L15:
        if (r5 == null) goto L17;
        int r7 = r5.intValue();
    L19:
        if (r7 != 12) goto L36;
        if (this.k == false) goto L36;
        if (((Boolean) vm2.d.s0.getValue(null, vm2.d.a[68])).booleanValue() == false) goto L36;
        View r8 = this.h;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L27:
        FrameLayout r9 = (FrameLayout) r8.findViewById(2131365077);
        if (r9 == null) goto L36;
        r9.setVisibility(0);
        View r10 = this.h;
        if (r10 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L32:
        Switch r11 = (Switch) r10.findViewById(2131387887);
        if (r11 == null) goto L36;
        r11.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.d.u.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[19])).booleanValue());
        r11.setOnClickListener(new s0(this));
    L36:
        if (tc0.c.h().E == false) goto L294;
        if (this.k == false) goto L294;
        ReadOnlyProperty r12 = vm2.d.b1;
        KProperty[] r13 = vm2.d.a;
        if (((Boolean) r12.getValue(null, r13[103(0x67, float:1.44E-43)])).booleanValue() == false) goto L294;
        int r14 = com.bytedance.android.live.liveinteract.linkpanel.util.o.c();
        if (na0() == false) goto L182;
        Integer r15 = Integer.valueOf(r14);
        View r16 = this.h;
        if (r16 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L46:
        r16.findViewById(2131366871).setVisibility(8);
        View r17 = this.h;
        if (r17 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L49:
        r17.findViewById(2131366873).setVisibility(0);
        View r18 = this.h;
        if (r18 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L52:
        ((TextView) r18.findViewById(2131390849)).setText(2131920012);
        if (r15 != null) goto L56;
    L101:
        View r19 = this.h;
        if (r19 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L104:
        ((ImageView) r19.findViewById(2131376483)).setBackgroundColor(0);
        View r20 = this.h;
        if (r20 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L107:
        ((ImageView) r20.findViewById(2131376483)).setImageResource(2131253270);
        View r21 = this.h;
        if (r21 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L110:
        ((TextView) r21.findViewById(2131376484)).setVisibility(8);
        View r22 = this.h;
        if (r22 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L113:
        ((ImageView) r22.findViewById(2131376485)).setBackgroundResource(2131253276);
        View r23 = this.h;
        if (r23 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L116:
        ((ImageView) r23.findViewById(2131376485)).setImageResource(2131253272);
        View r24 = this.h;
        if (r24 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L119:
        ((TextView) r24.findViewById(2131376486)).setVisibility(0);
        View r25 = this.h;
        if (r25 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L122:
        ((ImageView) r25.findViewById(2131376483)).setSelected(false);
        View r26 = this.h;
        if (r26 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L125:
        ((ImageView) r26.findViewById(2131376485)).setSelected(true);
        com.bytedance.live.datacontext.j r27 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.r).getVideoTalkRoomSubScene();
        if (r27 == null) goto L132;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r28 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r27.getValue();
        if (r28 == null) goto L132;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r29 = r28.t();
        if (r29 == null) goto L132;
        ra0(ma0(r29.b));
    L132:
        View r30 = this.h;
        if (r30 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L135:
        ((ImageView) r30.findViewById(2131377482)).setImageResource(2131253278);
        View r31 = this.h;
        if (r31 != null) goto L138;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L138:
        ((ImageView) r31.findViewById(2131377502)).setImageResource(2131253279);
        View r32 = this.h;
        if (r32 != null) goto L141;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L141:
        ((TextView) r32.findViewById(2131391726)).setVisibility(0);
        wa0();
        if (this.k == false) goto L159;
        rj0.k.m2.getClass();
        rj0.k r33 = rj0.k.a.a();
        if (r33 == null) goto L148;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r34 = r33.getLinkUserInfoCenter();
        if (r34 == null) goto L148;
        Integer r35 = Integer.valueOf(r34.P4(this.m));
    L149:
        View r36 = this.h;
        if (r36 != null) goto L152;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L152:
        Switch r37 = (Switch) r36.findViewById(2131387918);
        int r38 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal();
        if (r35 != null) goto L156;
    L158:
        r37.setChecked(r2);
    L175:
        View r39 = this.h;
        if (r39 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L178:
        r3.c(r39.findViewById(2131376483), com.bytedance.android.live.core.utils.s1.B(2131917652), true);
        View r40 = this.h;
        if (r40 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L181:
        r3.c(r40.findViewById(2131376485), com.bytedance.android.live.core.utils.s1.B(2131918039), true);
        return;
    L156:
        if (r35.intValue() != r38) goto L158;
        r2 = true;
    L148:
        r35 = null;
        goto L149
    L159:
        rj0.l.n2.getClass();
        rj0.l r41 = rj0.l.a.a();
        if (r41 == null) goto L164;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r42 = r41.getLinkUserInfoCenter();
        if (r42 == null) goto L164;
        Integer r43 = Integer.valueOf(r42.P4(this.m));
    L165:
        View r44 = this.h;
        if (r44 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L168:
        Switch r45 = (Switch) r44.findViewById(2131387918);
        int r46 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal();
        if (r43 != null) goto L172;
    L174:
        r45.setChecked(r2);
        goto L175
    L172:
        if (r43.intValue() != r46) goto L174;
        r2 = true;
    L164:
        r43 = null;
        goto L165
    L56:
        if (r15.intValue() != 8) goto L101;
        View r47 = this.h;
        if (r47 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L60:
        ((ImageView) r47.findViewById(2131376483)).setBackgroundResource(2131253276);
        View r48 = this.h;
        if (r48 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L63:
        ((ImageView) r48.findViewById(2131376483)).setImageResource(2131253272);
        View r49 = this.h;
        if (r49 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L66:
        ((TextView) r49.findViewById(2131376484)).setVisibility(0);
        View r50 = this.h;
        if (r50 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L69:
        ((ImageView) r50.findViewById(2131376485)).setBackgroundColor(0);
        View r51 = this.h;
        if (r51 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L72:
        ((ImageView) r51.findViewById(2131376485)).setImageResource(2131253270);
        View r52 = this.h;
        if (r52 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L75:
        ((TextView) r52.findViewById(2131376486)).setVisibility(8);
        View r53 = this.h;
        if (r53 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L78:
        ((ImageView) r53.findViewById(2131376483)).setSelected(true);
        View r54 = this.h;
        if (r54 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L81:
        ((ImageView) r54.findViewById(2131376485)).setSelected(false);
        View r55 = this.h;
        if (r55 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L84:
        ((TextView) r55.findViewById(2131391726)).setVisibility(8);
        View r56 = this.h;
        if (r56 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L87:
        ((FrameLayout) r56.findViewById(2131372775)).setVisibility(8);
        com.bytedance.live.datacontext.j r57 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.r).getVideoTalkRoomSubScene();
        if (r57 == null) goto L94;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r58 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r57.getValue();
        if (r58 == null) goto L94;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r59 = r58.t();
        if (r59 == null) goto L94;
        ra0(ma0(r59.b));
    L94:
        View r60 = this.h;
        if (r60 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L97:
        ((ImageView) r60.findViewById(2131377482)).setImageResource(2131253247);
        View r61 = this.h;
        if (r61 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L100:
        ((ImageView) r61.findViewById(2131377502)).setImageResource(2131253248);
        goto L175
    L182:
        Integer r62 = Integer.valueOf(r14);
        View r63 = this.h;
        if (r63 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L185:
        r63.findViewById(2131366873).setVisibility(8);
        if (r62 != null) goto L189;
    L221:
        View r65 = this.h;
        if (r65 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L224:
        ((ImageView) r65.findViewById(2131376219)).setBackgroundResource(2131253276);
        View r66 = this.h;
        if (r66 != null) goto L227;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L227:
        ((ImageView) r66.findViewById(2131376719)).setBackgroundColor(0);
        View r67 = this.h;
        if (r67 != null) goto L230;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L230:
        ((ImageView) r67.findViewById(2131376219)).setSelected(true);
        View r68 = this.h;
        if (r68 != null) goto L233;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L233:
        ((ImageView) r68.findViewById(2131376719)).setSelected(false);
        if (((Boolean) vm2.d.Z0.getValue(null, r13[101(0x65, float:1.42E-43)])).booleanValue() == false) goto L245;
        View r69 = this.h;
        if (r69 != null) goto L238;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L238:
        ((FrameLayout) r69.findViewById(2131372720)).setVisibility(0);
        com.bytedance.live.datacontext.j r70 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r70 == null) goto L249;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r71 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r70.getValue();
        if (r71 == null) goto L249;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r72 = r71.t();
        if (r72 == null) goto L249;
        ka0(r72.b);
    L249:
        View r73 = this.h;
        if (r73 != null) goto L252;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L252:
        ((TextView) r73.findViewById(2131391726)).setVisibility(0);
        wa0();
        if (this.k == false) goto L270;
        rj0.k.m2.getClass();
        rj0.k r74 = rj0.k.a.a();
        if (r74 == null) goto L259;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r75 = r74.getLinkUserInfoCenter();
        if (r75 == null) goto L259;
        Integer r76 = Integer.valueOf(r75.P4(this.m));
    L260:
        View r77 = this.h;
        if (r77 != null) goto L263;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L263:
        Switch r78 = (Switch) r77.findViewById(2131387918);
        int r79 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal();
        if (r76 != null) goto L267;
    L269:
        r78.setChecked(r2);
    L286:
        View r80 = this.h;
        if (r80 != null) goto L289;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L289:
        r3.c(r80.findViewById(2131376719), com.bytedance.android.live.core.utils.s1.B(2131918075), true);
        View r81 = this.h;
        if (r81 != null) goto L292;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L292:
        r3.c(r81.findViewById(2131376219), com.bytedance.android.live.core.utils.s1.B(2131917612), true);
        return;
    L267:
        if (r76.intValue() != r79) goto L269;
        r2 = true;
    L259:
        r76 = null;
        goto L260
    L270:
        rj0.l.n2.getClass();
        rj0.l r82 = rj0.l.a.a();
        if (r82 == null) goto L275;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r83 = r82.getLinkUserInfoCenter();
        if (r83 == null) goto L275;
        Integer r84 = Integer.valueOf(r83.P4(this.m));
    L276:
        View r85 = this.h;
        if (r85 != null) goto L279;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L279:
        Switch r86 = (Switch) r85.findViewById(2131387918);
        int r87 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal();
        if (r84 != null) goto L283;
    L285:
        r86.setChecked(r2);
        goto L286
    L283:
        if (r84.intValue() != r87) goto L285;
        r2 = true;
    L275:
        r84 = null;
        goto L276
    L245:
        View r88 = this.h;
        if (r88 != null) goto L248;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L248:
        ((FrameLayout) r88.findViewById(2131372720)).setVisibility(8);
        goto L249
    L189:
        if (r62.intValue() != 8) goto L221;
        View r89 = this.h;
        if (r89 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L193:
        ((ImageView) r89.findViewById(2131376719)).setBackgroundResource(2131253276);
        View r90 = this.h;
        if (r90 != null) goto L196;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L196:
        ((ImageView) r90.findViewById(2131376219)).setBackgroundColor(0);
        View r91 = this.h;
        if (r91 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L199:
        ((ImageView) r91.findViewById(2131376719)).setSelected(true);
        View r92 = this.h;
        if (r92 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L202:
        ((ImageView) r92.findViewById(2131376219)).setSelected(false);
        View r93 = this.h;
        if (r93 != null) goto L205;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L205:
        ((TextView) r93.findViewById(2131391726)).setVisibility(8);
        View r94 = this.h;
        if (r94 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L208:
        ((FrameLayout) r94.findViewById(2131372775)).setVisibility(8);
        int r95 = us1.g.a;
        if (this.j != null) goto L211;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L211:
        View r96 = this.h;
        if (r96 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L214:
        ((FrameLayout) r96.findViewById(2131372720)).setVisibility(0);
        com.bytedance.live.datacontext.j r97 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.r).getVideoTalkRoomSubScene();
        if (r97 == null) goto L286;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r98 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r97.getValue();
        if (r98 == null) goto L286;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r99 = r98.t();
        if (r99 == null) goto L286;
        ka0(r99.b);
    L294:
        if (tc0.c.h().E == false) goto L323;
        if (this.k == true) goto L323;
        if (r7 == 8) goto L299;
        if (r7 != 12) goto L331;
        View r100 = this.h;
        if (r100 != null) goto L306;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L306:
        ((TextView) r100.findViewById(2131391726)).setVisibility(0);
        wa0();
        rj0.l.n2.getClass();
        rj0.l r101 = rj0.l.a.a();
        if (r101 == null) goto L311;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r102 = r101.getLinkUserInfoCenter();
        if (r102 == null) goto L311;
        Integer r103 = Integer.valueOf(r102.P4(this.m));
    L312:
        View r104 = this.h;
        if (r104 != null) goto L315;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L315:
        Switch r105 = (Switch) r104.findViewById(2131387918);
        int r106 = LinkmicPositionItem.LinkmicPositionStatus.LOCKED.ordinal();
        if (r103 != null) goto L319;
    L321:
        r105.setChecked(r2);
        return;
    L319:
        if (r103.intValue() != r106) goto L321;
        r2 = true;
    L311:
        r103 = null;
        goto L312
    L331:
        return;
    L299:
        if (na0() == false) goto L301;
        ha0();
        return;
    L301:
        ga0();
        return;
    L323:
        if (na0() == false) goto L325;
        ha0();
        return;
    L325:
        ga0();
        return;
    L11:
        r6 = false;
    L17:
        r7 = 8;
        goto L19
    }

    public final void wa0() {
        com.bytedance.live.datacontext.j r0 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.r).getVideoTalkRoomSubScene();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r1 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r0.getValue();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r2 = r1.t();
        if (r2 == null) goto L9;
        boolean r3 = ma0(r2.b);
    L11:
        if (r3 == false) goto L19;
        View r4 = this.h;
        if (r4 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L15:
        UtilityKotlinExtentionsKt.t(r4.findViewById(2131372775));
        View r5 = this.h;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L18:
        UtilityKotlinExtentionsKt.t(r5.findViewById(2131391726));
        return;
    L19:
        View r6 = this.h;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L22:
        UtilityKotlinExtentionsKt.w(r6.findViewById(2131391726));
        View r7 = this.h;
        if (r7 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L25:
        ((FrameLayout) r7.findViewById(2131372775)).setVisibility(0);
        if (this.m == (-1)) goto L31;
        View r8 = this.h;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L30:
        ((TextView) r8.findViewById(2131390908)).setText(com.bytedance.android.live.core.utils.s1.C(2131917763, new Object[]{Integer.valueOf(this.m + 1)}));
        return;
    L31:
        View r9 = this.h;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L34:
        ((TextView) r9.findViewById(2131391726)).setVisibility(8);
        View r10 = this.h;
        if (r10 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L37:
        ((FrameLayout) r10.findViewById(2131372775)).setVisibility(8);
        return;
    L9:
        r3 = false;
        goto L11
    }

    public final void xa0() {
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L12;
        View r0 = this.h;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L7:
        ((TextView) r0.findViewById(2131392392)).setText(2131920011);
        ViewGroup r1 = this.i;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L10:
        ((TextView) r1.findViewById(2131388920)).setText(2131920011);
    L27:
        View r2 = this.h;
        if (r2 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L30:
        UtilityKotlinExtentionsKt.t(r2.findViewById(2131392392));
        return;
    L12:
        if (na0() == false) goto L20;
        View r3 = this.h;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L16:
        ((TextView) r3.findViewById(2131392392)).setText(2131920011);
        ViewGroup r4 = this.i;
        if (r4 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L19:
        ((TextView) r4.findViewById(2131388920)).setText(2131920011);
        goto L27
    L20:
        View r5 = this.h;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L23:
        ((TextView) r5.findViewById(2131392392)).setText(2131918081);
        ViewGroup r6 = this.i;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L26:
        ((TextView) r6.findViewById(2131388920)).setText(2131918081);
        goto L27
    }

    public VideoTalkSettingFragment() {
        this.g = new LinkedHashMap();
        this.q = new CompositeDisposable();
        this.t = new ArrayList();
        this.u = new LinkedHashMap();
        this.w = new tb6.c();
        this.x = new VideoTalkSettingFragment$paidPaymentConfigChangeListener$1(this);
        this.y = new VideoTalkSettingFragment$paidPlayModeConfigChangeListener$1(this);
    }

    public static boolean na0() {
        return vm2.h.X().a();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final void Y90() {
        if (vm2.d.B() == false) goto L27;
        View r0 = this.h;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L7:
        ((FrameLayout) r0.findViewById(2131380917)).setVisibility(8);
        View r1 = this.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L10:
        ((FrameLayout) r1.findViewById(2131380924)).setVisibility(8);
        View r2 = this.h;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L13:
        ((FrameLayout) r2.findViewById(2131372770)).setVisibility(0);
        View r3 = this.h;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L16:
        TextView r4 = (TextView) r3.findViewById(2131390821);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L20;
        String r5 = com.bytedance.android.live.core.utils.s1.B(2131917702);
    L23:
        r4.setText(r5);
        View r6 = this.h;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L26:
        ((FrameLayout) r6.findViewById(2131372770)).setOnClickListener(new b(this));
        return;
    L20:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue() == false) goto L22;
        r5 = com.bytedance.android.live.core.utils.s1.B(2131917699);
        goto L23
    L22:
        r5 = com.bytedance.android.live.core.utils.s1.B(2131917700);
        goto L23
    L27:
        View r7 = this.h;
        if (r7 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L30:
        ((FrameLayout) r7.findViewById(2131380917)).setVisibility(0);
        View r8 = this.h;
        if (r8 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L33:
        ((FrameLayout) r8.findViewById(2131380924)).setVisibility(0);
        View r9 = this.h;
        if (r9 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L36:
        ((FrameLayout) r9.findViewById(2131372770)).setVisibility(8);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        DataCenter r0 = this.n;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.g.clear();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        Iterator r0 = ((LinkedHashMap) this.u).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        Map.Entry r1 = (Map.Entry) r0.next();
        String r2 = (String) r1.getKey();
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.c.q1;
        if (Intrinsics.areEqual(r2, r3.getName()) == false) goto L14;
        if ((!Intrinsics.areEqual((Boolean) r1.getValue(), (Boolean) r3.getValue())) == false) goto L14;
        String r4 = com.bytedance.android.live.core.utils.s1.B(2131923110);
        if (((Boolean) r3.getValue()).booleanValue() == false) goto L12;
        String r5 = "on";
    L13:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.m(r4, r5);
        goto L4
    L12:
        r5 = "off";
    L14:
        ALogger.i("VideoTalkSettingFragment", "no setting change");
        goto L4
    L15:
        ((LinkedHashMap) this.u).clear();
        this.q.clear();
        ILinkPanelService r6 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r6 == null) goto L18;
        r6.Uo(this.x);
    L18:
        ILinkPanelService r7 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r7 == null) goto L21;
        r7.Uo(this.y);
    L21:
        this.d = null;
    }

    public final void onResume() {
        super.onResume();
        tb6.c r0 = this.w;
        if (r0 == null) goto L5;
        i97.a r1 = i97.a.a;
        r0.b = System.currentTimeMillis() - r0.a;
        r0.c("setting_panel_type");
    L5:
        this.w = null;
    }

    public final void qa0() {
        long r0 = System.currentTimeMillis();
        LinkAudienceApi r2 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r3 = this.j;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        Disposable r1 = r2.interactList(r3.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r0), new d(r0));
        this.q.add(r1);
    }

    public final void sa0() {
        u01 r0 = vm2.d.l();
        cj0.b r1 = ((IInteractService) jc1.k.n(IInteractService.class)).paidLinkMicService();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return;
    L10:
        String r3 = r0.paymentConfigSchema;
        if (TextUtils.isEmpty(r3) == true) goto L13;
        LinkedHashMap r4 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        r4.put("paid_count", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.g()));
        r4.put("limit_time", String.valueOf(com.bytedance.android.live.liveinteract.api.data.a.C0017a.f()));
        r4.put("height", "483");
        String r5 = com.bytedance.android.livesdk.chatroom.y0.b(r3, r4);
        ALogger.i("ttlive_link_paid", "setting panel handle=" + jc1.k.n(IBaseLiveActionHandler.class).handle(getContext(), r5) + ' ' + r5);
    L13:
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.c.o1;
        Boolean r7 = Boolean.TRUE;
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r7);
        View r8 = this.h;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L16:
        r8.findViewById(2131382034).setVisibility(8);
        return;
    L5:
        if (r1.needIntercepted() == true) goto L7;
        r2 = true;
        goto L8
    }

    public static final boolean ba0(VideoTalkSettingFragment r1) {
        r1.getClass();
        gd0.m r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (((LinkPanelTransitService) r2).d() != true) goto L7;
        return true;
    }

    public static final void ca0(VideoTalkSettingFragment r2) {
        r2.getClass();
        if (((IInteractService) jc1.k.n(IInteractService.class)).getVideoTalkService().finishVideoTalk("pre_apply") == false) goto L8;
        DataCenter r3 = r2.n;
        if (r3 == null) goto L9;
        r3.put("data_room_video_talk_log_over_for_over_path", "audience_link_setting");
        return;
    L9:
        return;
    }

    public static boolean ma0(List r3) {
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r3) == true) goto L19;
        int r4 = com.bytedance.android.live.liveinteract.linkpanel.util.o.d();
        if (r4 != 7) goto L7;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L20;
        return false;
    L20:
        return true;
    L7:
        if (r4 == 2) goto L14;
        if (r4 == 15) goto L14;
        if (r4 == 113) goto L14;
        r5 = false;
        goto L15
    L19:
        return true;
    }

    public final View aa0(int r3) {
        if (this.g != null) goto L5;
        this.g = new LinkedHashMap();
    L5:
        Map<Integer, View> r0 = this.g;
        LinkedHashMap r1 = (LinkedHashMap) r0;
        View r2 = (View) r1.get(Integer.valueOf(r3));
        if (r2 != null) goto L14;
        View r4 = getView();
        if (r4 == null) goto L12;
        View r5 = r4.findViewById(r3);
        if (r5 == null) goto L12;
        this.g.put(Integer.valueOf(r3), r5);
        return r5;
    L12:
        return null;
    L14:
        return r2;
    }

    public final void ia0(boolean r7) {
        if (na0() == false) goto L6;
    L10:
        boolean r0 = r7;
    L11:
        HashMap r3 = new HashMap();
        r3.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r4 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.r).getVideoTalkRoomSubScene();
        if (r4 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r4.getValue();
        if (r5 == null) goto L18;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r6 = r5.t();
        if (r6 == null) goto L18;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r3, Integer.valueOf(r6.a), 4);
    L18:
        if (r7 == false) goto L20;
        String r8 = "on";
    L21:
        r3.put("button_type", r8);
        if (vm2.d.h0().a() == false) goto L24;
        String r9 = "show_empty";
    L25:
        r3.put("button_name", r9);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_seat_num_fit_click", r3, new Object[]{IRoom.class});
        if (this.k == false) goto L30;
        rj0.k.m2.getClass();
        rj0.k r10 = rj0.k.a.a();
        if (r10 == null) goto L30;
        r10.j6(r0, null);
    L30:
        yf0.g r11 = this.d;
        if (r11 == null) goto L34;
        r11.dismiss();
        return;
    L34:
        return;
    L24:
        r9 = "seat_feat";
        goto L25
    L20:
        r8 = "off";
        goto L21
    L6:
        if (vm2.d.h0().a() == false) goto L10;
        if (r7 == true) goto L9;
        r0 = true;
        goto L11
    L9:
        r0 = false;
        goto L11
    }

    public final void ka0(List<Integer> r5) {
        if (vm2.d.h0().a() == false) goto L11;
        View r0 = this.h;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L7:
        ((TextView) r0.findViewById(2131390544)).setText(com.bytedance.android.live.core.utils.s1.B(2131917606));
        View r1 = this.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L10:
        ((Switch) r1.findViewById(2131387900)).setChecked(!ma0(r5));
        return;
    L11:
        View r2 = this.h;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        ((TextView) r2.findViewById(2131390544)).setText(com.bytedance.android.live.core.utils.s1.B(2131917605));
        View r3 = this.h;
        if (r3 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        ((Switch) r3.findViewById(2131387900)).setChecked(ma0(r5));
    }

    public final void oa0(Boolean r5) {
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L5;
        r0.put("function_type", "new_audience");
        r0.put("function_type2", "new_audience");
    L5:
        if (r5 != null) goto L8;
        r5 = (Boolean) b6.d.getValue();
    L8:
        String r1 = "1";
        if (r5.booleanValue() == false) goto L11;
        Object r6 = "1";
    L12:
        r0.put("is_guest_apply_allowed", r6);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue() == false) goto L15;
        Object r7 = "1";
    L16:
        r0.put("is_fans_only", r7);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L20;
        r1 = "0";
    L20:
        r0.put("is_invite_only", r1);
        DataCenter r8 = this.n;
        if (r8 == null) goto L25;
        Integer r9 = (Integer) r8.get("data_link_state", 0);
        if (r9 == null) goto L25;
        int r10 = r9.intValue();
    L27:
        if (gd0.v.a(r10, 32) == false) goto L38;
        com.bytedance.live.datacontext.j r11 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r11 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r11.getValue();
        if (r12 == null) goto L38;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r13 = r12.t();
        if (r13 == null) goto L38;
        if (ma0(r13.b) == false) goto L37;
        r0.put("seat_fit_status", "on");
        goto L38
    L37:
        r0.put("seat_fit_status", "off");
    L38:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_link_setting_change_success", r0, new Object[]{IRoom.class});
        return;
    L25:
        r10 = 0;
        goto L27
    L15:
        r7 = "0";
        goto L16
    L11:
        r6 = "0";
        goto L12
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals("cmd_finish_video_talk_room_result", r4.getKey()) == false) goto L15;
        Boolean r5 = (Boolean) r4.getData();
        if (r5 != null) goto L10;
        r5 = Boolean.FALSE;
    L10:
        if (r5.booleanValue() == false) goto L12;
        ta0(false, true);
        return;
    L12:
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131915982), 0);
        return;
    }

    public final void ra0(boolean r9) {
        if (r9 == false) goto L20;
        View r7 = this.h;
        if (r7 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L7:
        ((ImageView) r7.findViewById(2131376344)).setBackgroundResource(2131253276);
        View r2 = this.h;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L10:
        ((ImageView) r2.findViewById(2131376344)).setImageResource(2131253272);
        View r0 = this.h;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L13:
        ImageView r1 = (ImageView) r0.findViewById(2131376345);
        if (r1 == null) goto L16;
        r1.setBackground(null);
    L16:
        View r3 = this.h;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L19:
        ((ImageView) r3.findViewById(2131376345)).setImageResource(2131253270);
    L33:
        View r4 = this.h;
        if (r4 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L36:
        ((ImageView) r4.findViewById(2131376344)).setSelected(r9);
        View r5 = this.h;
        if (r5 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L39:
        ((ImageView) r5.findViewById(2131376345)).setSelected(!r9);
        return;
    L20:
        View r8 = this.h;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L23:
        ((ImageView) r8.findViewById(2131376344)).setBackground(null);
        View r6 = this.h;
        if (r6 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L26:
        ((ImageView) r6.findViewById(2131376344)).setImageResource(2131253270);
        View r10 = this.h;
        if (r10 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L29:
        ((ImageView) r10.findViewById(2131376345)).setBackgroundResource(2131253276);
        View r11 = this.h;
        if (r11 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L32:
        ((ImageView) r11.findViewById(2131376345)).setImageResource(2131253272);
        goto L33
    }

    public static final void ea0(VideoTalkSettingFragment r11, int r12) {
        r11.getClass();
        HashMap r0 = new HashMap();
        r0.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.g(r11.r).getVideoTalkRoomSubScene();
        if (r3 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r3.getValue();
        if (r4 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r5 = r4.t();
        if (r5 == null) goto L9;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r0, Integer.valueOf(r5.a), 4);
    L9:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.J(r0);
        if (r12 != 12) goto L12;
        String r6 = "party";
    L13:
        r0.put("selection", r6);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_layout_change", r0, new Object[]{IRoom.class});
        com.bytedance.live.datacontext.j r1 = com.bytedance.android.live.liveinteract.api.utils.m.g(r11.r).getVideoTalkRoomSubScene();
        if (r1 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r1.getValue();
        if (r2 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r7 = r2.t();
        if (r7 == null) goto L28;
        Integer r8 = Integer.valueOf(r7.a);
        if (r8.intValue() != r12) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == true) goto L26;
        r8 = null;
    L26:
        if (r8 == null) goto L28;
        ALogger.d("video_talk", "switchScene refuse. current scene equal toScene : " + r8.intValue());
        return;
    L22:
        r9 = false;
    L28:
        IInteractService r10 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r10 != null) goto L31;
        return;
    L31:
        if (r10.getLinkPanelTransitService() == null) goto L90;
        Context r13 = r11.requireContext();
        Intrinsics.checkNotNullParameter(r13, "context");
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode.a r14 = MultiRevenueDataContext.a.d();
        if (r14 != null) goto L35;
    L37:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L41;
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131914600), 0);
        return;
    L41:
        if (TeamFightContext.Companion.h() == false) goto L44;
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131922795), 0);
        return;
    L44:
        if (LinkRoomFightContext.Companion.c() == false) goto L47;
        f2.b(2131918756, 0);
        return;
    L47:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L49;
        String r15 = com.bytedance.android.live.core.utils.s1.B(2131923169);
    L58:
        Ref.IntRef r16 = new Ref.IntRef();
        r16.element = 0;
        Integer r17 = je0.d.h();
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L67;
        if (r12 != 12) goto L67;
        if (r17 == null) goto L67;
        if (r17.intValue() != 7) goto L67;
        r16.element = 2;
    L67:
        if (((rj1) bc0.a.getValue()).a() == true) goto L69;
    L79:
        com.bytedance.android.livesdk.widget.x0.b r18 = new com.bytedance.android.livesdk.widget.x0.b(r13, 0);
        com.bytedance.android.livesdk.widget.x0.d r19 = r18.a;
        r19.a = 4;
        r19.d = r15;
        r18.setCornerRadius(2.0f);
        r18.i(0, 2131923167, new com.bytedance.android.live.liveinteract.service.o(r12, r16));
        r18.i(1, 2131915442, com.bytedance.android.live.liveinteract.service.p.a);
        r18.a.k = false;
        r18.n();
        HashMap r110 = new HashMap();
        r110.put("live_type", "video_live");
        com.bytedance.live.datacontext.j r111 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r111 == null) goto L86;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r112 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r111.getValue();
        if (r112 == null) goto L86;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r113 = r112.t();
        if (r113 == null) goto L86;
        TalkRoomLogUtils.B0(r110, Integer.valueOf(r113.a), null, 4);
    L86:
        TalkRoomLogUtils.Q0(r110);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_layout_change_popup_show", r110, new Object[]{IRoom.class});
        return;
    L69:
        if (GuestBattleContext.Companion.e() == true) goto L79;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.b.a() == false) goto L75;
        rj0.k.m2.getClass();
        rj0.k r114 = rj0.k.a.a();
        if (r114 == null) goto L76;
        rj0.k.b.e(r114, r12, Integer.valueOf(r16.element), null, 4);
    L76:
        ILinkPanelService r115 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r115 == null) goto L94;
        r115.close();
        return;
    L94:
        return;
    L75:
        f2.b(2131917584, 0);
        goto L76
    L49:
        if (r12 != 12) goto L55;
        if (GuestBattleContext.Companion.e() == false) goto L53;
        r15 = com.bytedance.android.live.core.utils.s1.B(2131917244);
        goto L58
    L53:
        r15 = com.bytedance.android.live.core.utils.s1.B(2131923170);
        goto L58
    L55:
        if (GuestBattleContext.Companion.e() == false) goto L57;
        r15 = com.bytedance.android.live.core.utils.s1.B(2131917237);
        goto L58
    L57:
        r15 = com.bytedance.android.live.core.utils.s1.B(2131923168);
        goto L58
    L35:
        if (r14.b(r12) == true) goto L37;
        return;
    L90:
        return;
    L12:
        r6 = "radio";
        goto L13
    }

    public final void ta0(boolean r6, boolean r7) {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        ((Switch) r0.findViewById(2131387859)).setEnabled(false);
        HashMap r1 = new HashMap();
        r1.put("scene", 4);
        JSONArray r2 = new JSONArray();
        JSONObject r3 = new JSONObject();
        r3.put("key", 62);
        if (r6 == false) goto L8;
        int r4 = 1;
    L9:
        r3.put("value", r4);
        r2.put(r3);
        r1.put("incremental_update", r2);
        LinkApi r5 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r8 = this.j;
        if (r8 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L12:
        if (r8 == null) goto L14;
        Long r9 = Long.valueOf(r8.getId());
    L15:
        Disposable r10 = r5.updateSetting(r9.longValue(), r1).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r6, r7), new f(this, r7));
        this.q.add(r10);
        return;
    L14:
        r9 = null;
        goto L15
    L8:
        r4 = 2;
        goto L9
    }

    public final View onCreateView(LayoutInflater r12, ViewGroup r13, Bundle r14) {
        Intrinsics.checkNotNullParameter(r12, "inflater");
        boolean r0 = false;
        this.h = r12.inflate(2131565557, r13, false);
        Map<String, Boolean> r15 = this.u;
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.c.q1;
        r15.put(r16.getName(), (Boolean) r16.getValue());
        View r17 = LayoutInflater.from(getContext()).inflate(2131565653, null);
        if (r17 == null) goto L470;
        ViewGroup r18 = (ViewGroup) r17;
        this.i = r18;
        ((ImageView) r18.findViewById(2131363802)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkSettingFragment$initTopView$1(this)));
        if (this.p == false) goto L10;
        ViewGroup r19 = this.i;
        if (r19 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L9:
        UtilityKotlinExtentionsKt.w(r19.findViewById(2131363802));
    L14:
        com.bytedance.android.live.liveinteract.utils.q r110 = ((IInteractService) jc1.k.n(IInteractService.class)).getTalkRoomLogUtils();
        String r111 = OpenPanelSource.LINK_SETTING_PANEL.getValue();
        ((TalkRoomLogUtils) r110).getClass();
        Intrinsics.checkNotNullParameter(r111, "source");
        TalkRoomLogUtils.o1(r111);
        int r5 = 8;
        if (vm2.d.B() == false) goto L39;
        View r112 = this.h;
        if (r112 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L19:
        ((FrameLayout) r112.findViewById(2131380917)).setVisibility(8);
        View r113 = this.h;
        if (r113 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L22:
        ((FrameLayout) r113.findViewById(2131380924)).setVisibility(8);
        View r114 = this.h;
        if (r114 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L25:
        ((FrameLayout) r114.findViewById(2131372770)).setVisibility(0);
        View r115 = this.h;
        if (r115 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L28:
        TextView r116 = (TextView) r115.findViewById(2131390821);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L32;
        String r2 = com.bytedance.android.live.core.utils.s1.B(2131917702);
    L35:
        r116.setText(r2);
        View r117 = this.h;
        if (r117 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L38:
        ((FrameLayout) r117.findViewById(2131372770)).setOnClickListener(new h1(this));
    L49:
        this.r = com.bytedance.live.datacontext.d.d(com.bytedance.android.livesdk.chatroom.o.class);
        View r118 = this.h;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L52:
        ((Switch) r118.findViewById(2131387920)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue());
        View r119 = this.h;
        if (r119 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L55:
        ((Switch) r119.findViewById(2131387919)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue());
        View r120 = this.h;
        if (r120 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L58:
        ((Switch) r120.findViewById(2131387922)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.p1.getValue()).booleanValue());
        View r121 = this.h;
        if (r121 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L61:
        Switch r122 = (Switch) r121.findViewById(2131387937);
        if (r122 == null) goto L64;
        r122.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.u1.getValue()).booleanValue());
    L64:
        View r123 = this.h;
        if (r123 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L67:
        ((Switch) r123.findViewById(2131387942)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue());
        IKtvService r124 = jc1.k.f(IKtvService.class);
        if (r124 != null) goto L70;
    L71:
        IKtvService r125 = jc1.k.f(IKtvService.class);
        if (r125 != null) goto L74;
    L90:
        View r126 = this.h;
        if (r126 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L93:
        UtilityKotlinExtentionsKt.t(r126.findViewById(2131373340));
    L94:
        View r127 = this.h;
        if (r127 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L97:
        ((Switch) r127.findViewById(2131387922)).setOnCheckedChangeListener(new j1(this));
        View r128 = this.h;
        if (r128 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L100:
        ((Switch) r128.findViewById(2131387920)).setOnCheckedChangeListener(new k1(this));
        View r129 = this.h;
        if (r129 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L103:
        ((Switch) r129.findViewById(2131387919)).setOnCheckedChangeListener(new l1(this));
        if (vm2.d.x0() == true) goto L106;
    L116:
        View r130 = this.h;
        if (r130 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L119:
        FrameLayout r131 = (FrameLayout) r130.findViewById(2131387741);
        if (r131 == null) goto L122;
        r131.setVisibility(8);
    L122:
        View r132 = this.h;
        if (r132 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L125:
        FrameLayout r133 = (FrameLayout) r132.findViewById(2131392251);
        if (r133 == null) goto L129;
        r133.setOnClickListener(new n1(this));
        Unit r134 = Unit.INSTANCE;
    L129:
        if (vm2.d.V0().allowSendGiftToLinker == true) goto L131;
    L165:
        View r135 = this.h;
        if (r135 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L168:
        RelativeLayout r136 = (RelativeLayout) r135.findViewById(2131362534);
        if (r136 == null) goto L171;
        r136.setVisibility(8);
    L171:
        View r137 = this.h;
        if (r137 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L174:
        ((Switch) r137.findViewById(2131392381)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.d.Z.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[50])).booleanValue());
        if (((Boolean) vm2.d.Q0.getValue(null, vm2.d.a[92])).booleanValue() == false) goto L186;
        View r138 = this.h;
        if (r138 != null) goto L179;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L179:
        Switch r139 = (Switch) r138.findViewById(2131392381);
        if (r139 == null) goto L182;
        r139.setClickable(false);
    L182:
        View r140 = this.h;
        if (r140 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L185:
        ((FrameLayout) r140.findViewById(2131392278)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkSettingFragment$initSettingView$10(this)));
    L193:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.q(this.n) == false) goto L201;
        View r141 = this.h;
        if (r141 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L197:
        ((LinearLayout) r141.findViewById(2131378799)).setVisibility(8);
        View r142 = this.h;
        if (r142 != null) goto L200;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L200:
        ((LinearLayout) r142.findViewById(2131378798)).setVisibility(8);
    L243:
        com.bytedance.live.datacontext.j r143 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r143 == null) goto L252;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r144 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r143.getValue();
        if (r144 == null) goto L252;
        BehaviorSubject r145 = r144.a();
        if (r145 == null) goto L252;
        Disposable r146 = r145.subscribe(new b1(this));
        if (r146 == null) goto L252;
        this.q.add(r146);
    L252:
        va0();
        View r147 = this.h;
        if (r147 != null) goto L255;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L255:
        ((Switch) r147.findViewById(2131387918)).setOnCheckedChangeListener(new c1(this));
        if (na0() == false) goto L293;
        View r148 = this.h;
        if (r148 != null) goto L260;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L260:
        ImageView r149 = (ImageView) r148.findViewById(2131376483);
        if (r149 == null) goto L263;
        r149.setOnClickListener(new v0(this));
    L263:
        View r150 = this.h;
        if (r150 != null) goto L266;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L266:
        ImageView r151 = (ImageView) r150.findViewById(2131376485);
        if (r151 == null) goto L269;
        r151.setOnClickListener(new w0(this));
    L269:
        View r152 = this.h;
        if (r152 != null) goto L272;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L272:
        ImageView r153 = (ImageView) r152.findViewById(2131376344);
        if (r153 == null) goto L275;
        r153.setOnTouchListener(new x0(this));
    L275:
        View r154 = this.h;
        if (r154 != null) goto L278;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L278:
        ImageView r155 = (ImageView) r154.findViewById(2131376345);
        if (r155 == null) goto L281;
        r155.setOnTouchListener(new y0(this));
    L281:
        HashMap r156 = new HashMap();
        r156.put("request_page", "link_setting_click");
        com.bytedance.live.datacontext.j r157 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.r).getVideoTalkRoomSubScene();
        if (r157 == null) goto L292;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r158 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r157.getValue();
        if (r158 == null) goto L292;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r159 = r158.t();
        if (r159 == null) goto L292;
        if (ma0(r159.b) == false) goto L290;
        String r160 = "seat_fit";
    L291:
        r156.put("default_layout_type", r160);
        Unit r161 = Unit.INSTANCE;
        goto L292
    L290:
        r160 = "normal";
    L292:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_link_setting_panel_show", r156, new Object[]{IRoom.class});
    L306:
        View r162 = this.h;
        if (r162 != null) goto L309;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L309:
        ((FrameLayout) r162.findViewById(2131387742)).setOnClickListener(new q0(this));
        com.bytedance.android.live.liveinteract.api.data.a.h.getClass();
        com.bytedance.android.live.liveinteract.api.data.a.C0017a.i();
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.e() == false) goto L339;
        View r163 = this.h;
        if (r163 != null) goto L314;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L314:
        ((LinearLayout) r163.findViewById(2131378799)).getVisibility();
        com.bytedance.android.live.liveinteract.linkpanel.util.o.q(this.n);
        View r164 = this.h;
        if (r164 != null) goto L317;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L317:
        r164.findViewById(2131382041).setVisibility(8);
        View r165 = this.h;
        if (r165 != null) goto L320;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L320:
        r165.findViewById(2131382033).setVisibility(8);
        View r166 = this.h;
        if (r166 != null) goto L323;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L323:
        TextView r167 = (TextView) r166.findViewById(2131382044);
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.j() == false) goto L326;
        int r168 = 2131921172;
    L327:
        r167.setText(com.bytedance.android.live.core.utils.s1.B(r168));
        View r169 = this.h;
        if (r169 != null) goto L330;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L330:
        ((LinearLayout) r169.findViewById(2131382043)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkSettingFragment$initPaidLinkSettingNew$1(this)));
        com.bytedance.android.livesdk.sharedpref.e r170 = com.bytedance.android.livesdk.sharedpref.c.n1;
        Boolean r171 = Boolean.TRUE;
        r170.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r170, r171);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.d1.getValue()).booleanValue() == true) goto L336;
        View r172 = this.h;
        if (r172 != null) goto L335;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L335:
        r172.findViewById(2131382042).setVisibility(0);
    L336:
        ILinkPanelService r173 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r173 == null) goto L371;
        r173.VG(this.y);
    L371:
        ILinkPanelService r174 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r174 == null) goto L375;
        r174.VG(this.x);
        Unit r175 = Unit.INSTANCE;
    L375:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.H() == false) goto L423;
        int r176 = us1.g.a;
        if (this.j != null) goto L379;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L379:
        View r177 = this.h;
        if (r177 != null) goto L382;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L382:
        ((TextView) r177.findViewById(2131391344)).setVisibility(0);
        View r178 = this.h;
        if (r178 != null) goto L385;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L385:
        ((FrameLayout) r178.findViewById(2131392322)).setVisibility(0);
        View r179 = this.h;
        if (r179 != null) goto L388;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L388:
        ((FrameLayout) r179.findViewById(2131392322)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkSettingFragment$initSettingView$20(this)));
        if (jc1.k.n(IKtvService.class).isMultipleKtvEnable(this.n) == true) goto L391;
        com.bytedance.live.datacontext.j r180 = com.bytedance.android.live.liveinteract.api.utils.m.d().getVideoTalkRoomSubScene();
        if (r180 == null) goto L421;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r181 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r180.getValue();
        if (r181 == null) goto L421;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r182 = r181.t();
        if (r182 == null) goto L421;
        Integer r183 = Integer.valueOf(r182.a);
        int r4 = r183.intValue();
        if (r4 != 8) goto L409;
    L412:
        boolean r6 = true;
    L413:
        if (r6 == true) goto L416;
        r183 = null;
    L416:
        if (r183 == null) goto L421;
        r183.intValue();
        View r184 = this.h;
        if (r184 != null) goto L420;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L420:
        ((TextView) r184.findViewById(2131389605)).setText(2131923164);
        Unit r185 = Unit.INSTANCE;
        goto L421
    L409:
        if (r4 == 12) goto L412;
        r6 = false;
    L421:
        HashMap r186 = new HashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r186);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r186, null, 6);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.E(r186);
        r186.put("action_type", "show");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_function_icon", r186, new Object[]{IRoom.class});
        goto L423
    L391:
        if (jc1.k.n(IKtvService.class).currentIsMultipleKtvMode() == false) goto L396;
        View r187 = this.h;
        if (r187 != null) goto L395;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L395:
        ((TextView) r187.findViewById(2131389605)).setText(2131923162);
        goto L421
    L396:
        View r188 = this.h;
        if (r188 != null) goto L399;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L399:
        ((TextView) r188.findViewById(2131389605)).setText(2131923164);
    L423:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.s() == false) goto L447;
        View r189 = this.h;
        if (r189 != null) goto L428;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L428:
        r189.findViewById(2131381838).setVisibility(0);
        View r190 = this.h;
        if (r190 != null) goto L431;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L431:
        View r191 = r190.findViewById(2131381839);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.i1.getValue()).booleanValue() == false) goto L434;
        r5 = 0;
    L434:
        r191.setVisibility(r5);
        View r192 = this.h;
        if (r192 != null) goto L437;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L437:
        Switch r193 = (Switch) r192.findViewById(2131387928);
        Integer r1 = (Integer) com.bytedance.android.livesdk.sharedpref.c.e1.getValue();
        if (r1 != null) goto L441;
    L443:
        r193.setChecked(r0);
        View r194 = this.h;
        if (r194 != null) goto L446;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L446:
        ((Switch) r194.findViewById(2131387928)).setOnCheckedChangeListener(new z0(this));
        goto L447
    L441:
        if (r1.intValue() != 1) goto L443;
        r0 = true;
    L447:
        xa0();
        if (this.o == true) goto L450;
    L452:
        la0();
        if (fa0() == false) goto L455;
        Boolean r195 = Boolean.TRUE;
    L456:
        View r196 = this.h;
        if (r196 != null) goto L459;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L459:
        ((Switch) r196.findViewById(2131387859)).setChecked(r195.booleanValue());
        View r197 = this.h;
        if (r197 != null) goto L462;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L462:
        ((Switch) r197.findViewById(2131387859)).setOnCheckedChangeListener(new r0(this));
        DataCenter r198 = this.n;
        if (r198 == null) goto L465;
        r198.observe("cmd_finish_video_talk_room_result", this);
    L465:
        View r199 = this.h;
        if (r199 != null) goto L468;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L468:
        return r199;
    L455:
        r195 = (Boolean) b6.d.getValue();
        goto L456
    L450:
        if (com.bytedance.android.live.liveinteract.api.data.a.C0017a.i() == false) goto L452;
        sa0();
        goto L452
    L326:
        r168 = 2131921171;
        goto L327
    L339:
        View r1100 = this.h;
        if (r1100 != null) goto L342;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L342:
        r1100.findViewById(2131382033).setVisibility(8);
        View r1101 = this.h;
        if (r1101 != null) goto L345;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L345:
        r1101.findViewById(2131382041).setVisibility(8);
        View r1102 = this.h;
        if (r1102 != null) goto L348;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L348:
        TextView r1103 = (TextView) r1102.findViewById(2131382046);
        IInteractService r1104 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r1104 == null) goto L355;
        rj0.m r1105 = r1104.getVideoTalkService();
        if (r1105 == null) goto L355;
        com.bytedance.android.live.liveinteract.api.data.a r1106 = r1105.j();
        if (r1106 == null) goto L355;
        boolean r1107 = r1106.c;
    L356:
        if (r1107 == false) goto L358;
        String r1108 = com.bytedance.android.live.liveinteract.linkpanel.util.o.j();
    L359:
        r1103.setText(r1108);
        View r1109 = this.h;
        if (r1109 != null) goto L362;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L362:
        ((LinearLayout) r1109.findViewById(2131382040)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkSettingFragment$initPaidLinkSettingOld$1(this)));
        com.bytedance.android.livesdk.sharedpref.e r1110 = com.bytedance.android.livesdk.sharedpref.c.h1;
        Boolean r1111 = Boolean.TRUE;
        r1110.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1110, r1111);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.o1.getValue()).booleanValue() == true) goto L368;
        View r1112 = this.h;
        if (r1112 != null) goto L367;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L367:
        r1112.findViewById(2131382034).setVisibility(0);
    L368:
        ILinkPanelService r1113 = com.bytedance.android.live.liveinteract.component.b.a();
        if (r1113 == null) goto L371;
        r1113.VG(this.x);
        goto L371
    L358:
        r1108 = com.bytedance.android.live.core.utils.s1.B(2131918650);
    L355:
        r1107 = false;
        goto L356
    L293:
        View r1114 = this.h;
        if (r1114 != null) goto L296;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L296:
        ((Switch) r1114.findViewById(2131387900)).setOnTouchListener(new d1(this));
        View r1115 = this.h;
        if (r1115 != null) goto L299;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L299:
        ((Switch) r1115.findViewById(2131387900)).setOnCheckedChangeListener(new e1(this));
        View r1116 = this.h;
        if (r1116 != null) goto L302;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L302:
        ((ImageView) r1116.findViewById(2131376719)).setOnClickListener(new f1(this));
        View r1117 = this.h;
        if (r1117 != null) goto L305;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L305:
        ((ImageView) r1117.findViewById(2131376219)).setOnClickListener(new g1(this));
        goto L306
    L201:
        int r1118 = us1.g.a;
        if (this.j != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L204:
        View r1119 = this.h;
        if (r1119 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L207:
        ((LinearLayout) r1119.findViewById(2131378798)).setVisibility(8);
        View r1120 = this.h;
        if (r1120 != null) goto L210;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L210:
        ((LinearLayout) r1120.findViewById(2131378799)).setVisibility(0);
        View r1121 = this.h;
        if (r1121 != null) goto L213;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L213:
        ((LinearLayout) r1121.findViewById(2131391119)).setOnClickListener(new a1(this));
        com.bytedance.live.datacontext.m r1122 = com.bytedance.android.live.liveinteract.api.utils.m.i().w2();
        if (r1122 != null) goto L216;
    L221:
        DataCenter r1123 = this.n;
        IRoom r3 = this.j;
        if (r3 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L224:
        com.bytedance.live.datacontext.n r1124 = com.bytedance.android.live.liveinteract.api.utils.m.f(r1123, Long.valueOf(r3.getRoomId())).F();
        if (r1124 == null) goto L229;
        List<Integer> r1125 = (List) r1124.getValue();
        if (r1125 == null) goto L229;
        this.t = r1125;
    L229:
        DataCenter r1126 = this.n;
        IRoom r7 = this.j;
        if (r7 != null) goto L232;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L232:
        if (r7 == null) goto L234;
        Long r8 = Long.valueOf(r7.getRoomId());
    L235:
        com.bytedance.android.livesdk.chatroom.u r1127 = com.bytedance.android.live.liveinteract.api.utils.m.f(r1126, r8);
        if (r1127 == null) goto L242;
        com.bytedance.live.datacontext.n r1128 = r1127.l();
        if (r1128 == null) goto L242;
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r1129 = (List) r1128.getValue();
        if (r1129 == null) goto L242;
        this.s = r1129;
        ua0();
    L242:
        qa0();
        goto L243
    L234:
        r8 = null;
        goto L235
    L216:
        if (((Boolean) r1122.getValue()).booleanValue() != true) goto L221;
        com.bytedance.live.datacontext.m r1130 = com.bytedance.android.live.liveinteract.api.utils.m.i().w2();
        if (r1130 == null) goto L220;
        r1130.setValue(Boolean.FALSE);
    L220:
        qa0();
        goto L243
    L186:
        View r1131 = this.h;
        if (r1131 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L189:
        FrameLayout r1132 = (FrameLayout) r1131.findViewById(2131392277);
        if (r1132 == null) goto L193;
        r1132.setVisibility(8);
        goto L193
    L131:
        if (vm2.d.V0().bigPartySwitch == false) goto L165;
        View r1133 = this.h;
        if (r1133 != null) goto L135;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L135:
        RelativeLayout r1134 = (RelativeLayout) r1133.findViewById(2131362534);
        if (r1134 == null) goto L139;
        r1134.setVisibility(0);
    L139:
        if (vm2.d.u0() == false) goto L146;
        Boolean r1135 = com.bytedance.android.live.liveinteract.api.utils.m.m(this.r).isAnchor();
        if (r1135 == null) goto L143;
        boolean r1136 = r1135.booleanValue();
    L144:
        if (r1136 == false) goto L146;
        boolean r1137 = true;
    L147:
        if (r1137 == false) goto L155;
        View r1138 = this.h;
        if (r1138 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L151:
        ((ImageView) r1138.findViewById(2131362535)).setVisibility(0);
        ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        Intrinsics.checkNotNullParameter(PbRequest.SwitchType.GIFT, "requestPage");
        LinkedHashMap r9 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r9, null, 6);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r9);
        r9.put("request_page", PbRequest.SwitchType.GIFT);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_profit_info_show", r9, new Object[]{IRoom.class});
        View r1139 = this.h;
        if (r1139 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L154:
        ((ImageView) r1139.findViewById(2131362535)).setOnClickListener(new o1(this, r9));
    L155:
        View r1140 = this.h;
        if (r1140 != null) goto L158;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L158:
        Switch r1141 = (Switch) r1140.findViewById(2131387937);
        if (r1141 == null) goto L161;
        r1141.setClickable(false);
    L161:
        View r1142 = this.h;
        if (r1142 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L164:
        ((FrameLayout) r1142.findViewById(2131387938)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new VideoTalkSettingFragment$initSettingView$9(this)));
        goto L171
    L143:
        r1136 = false;
    L146:
        r1137 = false;
        goto L147
    L106:
        if (vm2.d.p() == false) goto L116;
        if (RoomPermissionContext.a.c(RoomPermissionContext.Companion) == true) goto L116;
        View r1143 = this.h;
        if (r1143 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L112:
        ((FrameLayout) r1143.findViewById(2131387741)).setVisibility(0);
        View r1144 = this.h;
        if (r1144 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L115:
        ((Switch) r1144.findViewById(2131387942)).setOnCheckedChangeListener(new m1(this));
        goto L122
    L74:
        if (r125.currentIsMultipleKtvModeV2() != true) goto L90;
    L75:
        IRoom r1145 = this.j;
        if (r1145 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L79:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.r(r1145) == false) goto L90;
        View r1146 = this.h;
        if (r1146 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L83:
        UtilityKotlinExtentionsKt.w(r1146.findViewById(2131373340));
        View r1147 = this.h;
        if (r1147 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L86:
        ((Switch) r1147.findViewById(2131387905)).setChecked(((Boolean) r16.getValue()).booleanValue());
        View r1148 = this.h;
        if (r1148 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L89:
        ((Switch) r1148.findViewById(2131387905)).setOnCheckedChangeListener(new i1(this));
        goto L94
    L70:
        if (r124.currentIsMultipleKtvMode() == true) goto L75;
    L32:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.t1.getValue()).booleanValue() == false) goto L34;
        r2 = com.bytedance.android.live.core.utils.s1.B(2131917699);
        goto L35
    L34:
        r2 = com.bytedance.android.live.core.utils.s1.B(2131917700);
        goto L35
    L39:
        View r1149 = this.h;
        if (r1149 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L42:
        ((FrameLayout) r1149.findViewById(2131380917)).setVisibility(0);
        View r1150 = this.h;
        if (r1150 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L45:
        ((FrameLayout) r1150.findViewById(2131380924)).setVisibility(0);
        View r1151 = this.h;
        if (r1151 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L48:
        ((FrameLayout) r1151.findViewById(2131372770)).setVisibility(8);
        goto L49
    L10:
        ViewGroup r1152 = this.i;
        if (r1152 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L13:
        UtilityKotlinExtentionsKt.t(r1152.findViewById(2131363802));
        goto L14
    L470:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final boolean da0(VideoTalkSettingFragment r3, View r4, MotionEvent r5, boolean r6) {
        r3.getClass();
        gd0.m r7 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService();
        if (r7 == null) goto L8;
        if (((LinkPanelTransitService) r7).f(r5) != true) goto L8;
        return true;
    L8:
        if (r5.getAction() != 0) goto L26;
        com.bytedance.android.live.liveinteract.revenue.battle.b0 r8 = ((IInteractService) jc1.k.n(IInteractService.class)).guestBattleContext();
        if (r8 == null) goto L23;
        if (r8.isGameShowing() != true) goto L23;
        com.bytedance.android.livesdk.widget.x0.b r9 = new com.bytedance.android.livesdk.widget.x0.b(r3.getContext(), 0);
        r9.a.a = 4;
        if (r6 == false) goto L16;
        int r1 = 2131917233;
    L17:
        r9.a.d = com.bytedance.android.live.core.utils.s1.B(r1);
        r9.setCornerRadius(2.0f);
        if (r6 == false) goto L20;
        int r2 = 2131923131;
    L21:
        r9.i(0, r2, new p1(r3, r6));
        r9.i(1, 2131915442, new q1(r3));
        r9.a.k = false;
        r9.n();
        return true;
    L20:
        r2 = 2131923130;
        goto L21
    L16:
        r1 = 2131917232;
    L23:
        if (r3.v == false) goto L25;
        r3.v = false;
        return true;
    L25:
        r3.ra0(r6);
        r3.ia0(r6);
        return true;
    L26:
        return false;
    }
}
