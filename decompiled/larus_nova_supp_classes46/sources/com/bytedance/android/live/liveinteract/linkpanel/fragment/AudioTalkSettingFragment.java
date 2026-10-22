package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;
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
import com.bytedance.android.live.liveinteract.linkpanel.contract.AudioTalkDialogContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.util.OpenPanelSource;
import com.bytedance.android.live.liveinteract.linkpanel.vm.PlayModeListViewModel;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.model.f3;
import com.bytedance.android.livesdk.config.kf;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.depend.message.MultiLinkMessageMethods;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/AudioTalkSettingFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/AudioTalkDialogContract$View;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioTalkSettingFragment extends AudioTalkDialogContract$View implements Observer<KVData> {
    public static final /* synthetic */ int w = 0;
    public Map<Integer, View> g;
    public View h;
    public ViewGroup i;
    public IRoom j;
    public DataContext k;
    public DataCenter l;
    public final CompositeDisposable m;
    public List<? extends f3> n;
    public List<Integer> o;
    public List<? extends com.bytedance.android.livesdk.chatroom.model.k1> p;
    public List<Long> q;
    public final Map<String, Boolean> r;
    public PlayModeListViewModel s;
    public tb6.c t;
    public String u;
    public final Function1<zf0.a, Unit> v;

    public static final class a {
        public static AudioTalkSettingFragment a(yf0.g r1, IRoom r2, DataContext r3, DataCenter r4, String r5) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
            Intrinsics.checkNotNullParameter(r5, "requestPage");
            AudioTalkSettingFragment r0 = new AudioTalkSettingFragment();
            r0.d = r1;
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.j = r2;
            r0.k = r3;
            r0.l = r4;
            tb6.c r6 = r0.t;
            if (r6 == null) goto L5;
            r6.a();
        L5:
            r0.u = r5;
            return r0;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ AudioTalkSettingFragment a;

        public b(AudioTalkSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (((Boolean) vm2.c.e.getValue(null, vm2.c.a[3])).booleanValue() == false) goto L7;
            IMiddlewareLiveService r4 = TTLiveServiceMiddleware.getLiveService();
            if (r4 == null) goto L11;
            r4.showLivePrivilegeManagerDialog(this.a.getContext());
            return;
        L11:
            return;
        L7:
            IMiddlewareLiveService r5 = TTLiveServiceMiddleware.getLiveService();
            if (r5 == null) goto L13;
            r5.showLiveProfileManagerDialog(this.a.getContext());
            return;
        }
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ AudioTalkSettingFragment a;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r2, int r3) {
                ((Switch) this.a.a.fa0().findViewById(2131387859)).setChecked(true);
                r2.dismiss();
            }
        }

        public static final class b implements DialogInterface.OnClickListener {
            public final /* synthetic */ c a;

            public b(c r1) {
                this.a = r1;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r1, int r2) {
                AudioTalkSettingFragment.ba0(this.a.a);
                r1.dismiss();
            }
        }

        public c(AudioTalkSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r4, boolean r5) {
            DataCenter r6 = this.a.l;
            if (r6 == null) goto L7;
            Integer r7 = (Integer) r6.get("data_link_state", 0);
            if (r7 == null) goto L7;
            int r8 = r7.intValue();
        L9:
            if (gd0.v.a(r8, 8) == false) goto L26;
            if (r5 == false) goto L12;
            return;
        L12:
            IInteractService r9 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r9 == null) goto L17;
            com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r10 = r9.getLinkUserInfoCenter();
            if (r10 == null) goto L17;
            int r11 = r10.b();
        L18:
            IInteractService r12 = (IInteractService) jc1.k.f(IInteractService.class);
            if (r12 == null) goto L21;
            int r13 = r12.getOnLineCountFromPk();
        L22:
            if (r11 > 0) goto L25;
            if (r13 > 0) goto L25;
            AudioTalkSettingFragment.ba0(this.a);
            return;
        L25:
            com.bytedance.android.livesdk.widget.x0.b r14 = new com.bytedance.android.livesdk.widget.x0.b(this.a.getContext(), 0);
            com.bytedance.android.livesdk.widget.x0.d r15 = r14.a;
            r15.k = false;
            r15.l = false;
            r14.m(2131914617);
            r14.l(2131914616);
            r14.i(1, 2131915442, new a(this));
            r14.i(0, 2131920806, new b(this));
            r14.n();
            return;
        L21:
            r13 = 0;
        L17:
            r11 = 0;
            goto L18
        L26:
            this.a.ua0(r5, false);
            return;
        L7:
            r8 = 0;
            goto L9
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ AudioTalkSettingFragment a;

        public d(AudioTalkSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            AudioTalkSettingFragment r4 = this.a;
            yf0.g r0 = r4.d;
            int r1 = ApplyPermissionSwitchFragment.o;
            r0.Rh(ApplyPermissionSwitchFragment.a.a(r0, r4.getRoom(), 1));
        }
    }

    public static final class e implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ AudioTalkSettingFragment a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ boolean a;

            public a(boolean r1) {
                this.a = r1;
            }

            public final void accept(Object r2) {
                com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
                com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.J0;
                Boolean r0 = Boolean.valueOf(this.a);
                r4.getClass();
                com.bytedance.android.livesdk.sharedpref.f.d(r4, r0);
            }
        }

        public e(AudioTalkSettingFragment r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r5, boolean r6) {
            HashMap r7 = new HashMap();
            r7.put("scene", 4);
            JSONArray r0 = new JSONArray();
            JSONObject r1 = new JSONObject();
            r1.put("key", 77);
            if (r6 == false) goto L5;
            int r2 = 1;
        L6:
            r1.put("value", r2);
            r0.put(r1);
            r7.put("incremental_update", r0);
            Disposable r8 = ((LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class)).updateSetting(this.a.getRoom().getId(), r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new a(r6));
            this.a.m.add(r8);
            return;
        L5:
            r2 = 2;
            goto L6
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AudioTalkSettingFragment a;
        public final /* synthetic */ long b;

        public f(AudioTalkSettingFragment r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            Intrinsics.checkNotNullParameter(r8, "response");
            int r0 = nd0.g.a;
            nd0.g.d(this.b, r8);
            List r1 = ((com.bytedance.android.livesdk.chatroom.model.e1) r8.data).getInteractItems();
            Long r2 = null;
            if (r1 == null) goto L21;
            Iterator r3 = r1.iterator();
            if (r3 == null) goto L21;
        L7:
            if (r3.hasNext() == false) goto L21;
            com.bytedance.android.livesdk.chatroom.model.k1 r4 = (com.bytedance.android.livesdk.chatroom.model.k1) r3.next();
            if (r4.getType() != 7) goto L16;
            xi0.a r5 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
            if (r5 != null) goto L13;
        L14:
            r3.remove();
            goto L16
        L13:
            if (r5.r2() != true) goto L14;
        L16:
            if (r4.getType() != 10) goto L7;
            if (((Boolean) vm2.d.U0.getValue(null, vm2.d.a[96])).booleanValue() == true) goto L7;
            r3.remove();
        L21:
            if (((Boolean) vm2.d.T0.getValue(null, vm2.d.a[95])).booleanValue() == false) goto L27;
            List r6 = ((com.bytedance.android.livesdk.chatroom.model.e1) r8.data).getInteractItems();
            if (r6 == null) goto L27;
            if (r6.size() != 0) goto L27;
            ((LinearLayout) this.a.fa0().findViewById(2131378799)).setVisibility(8);
            return;
        L27:
            AudioTalkSettingFragment r9 = this.a;
            r9.p = ((com.bytedance.android.livesdk.chatroom.model.e1) r8.data).getInteractItems();
            AudioTalkSettingFragment r10 = this.a;
            r10.n = ((com.bytedance.android.livesdk.chatroom.model.e1) r8.data).getRoomModeItemList();
            AudioTalkSettingFragment r11 = this.a;
            r11.q = ((com.bytedance.android.livesdk.chatroom.model.e1) r8.data).getPlayingList();
            AudioTalkSettingFragment r12 = this.a;
            r12.o = ((com.bytedance.android.livesdk.chatroom.model.e1) r8.data).getCurInteractType();
            AudioTalkSettingFragment r13 = this.a;
            DataCenter r14 = r13.l;
            IRoom r15 = r13.getRoom();
            if (r15 == null) goto L30;
            r2 = Long.valueOf(r15.getRoomId());
        L30:
            com.bytedance.android.livesdk.chatroom.u r16 = com.bytedance.android.live.liveinteract.api.utils.m.f(r14, r2);
            if (r16 == null) goto L35;
            com.bytedance.live.datacontext.n r17 = r16.t();
            if (r17 == null) goto L35;
            r17.setValue(this.a.p);
        L35:
            AudioTalkSettingFragment r18 = this.a;
            com.bytedance.live.datacontext.n r19 = com.bytedance.android.live.liveinteract.api.utils.m.f(r18.l, Long.valueOf(r18.getRoom().getRoomId())).r();
            if (r19 == null) goto L38;
            r19.setValue(this.a.q);
        L38:
            AudioTalkSettingFragment r20 = this.a;
            com.bytedance.live.datacontext.n r21 = com.bytedance.android.live.liveinteract.api.utils.m.f(r20.l, Long.valueOf(r20.getRoom().getRoomId())).z();
            if (r21 == null) goto L41;
            r21.setValue(this.a.n);
        L41:
            AudioTalkSettingFragment r22 = this.a;
            com.bytedance.live.datacontext.n r23 = com.bytedance.android.live.liveinteract.api.utils.m.f(r22.l, Long.valueOf(r22.getRoom().getRoomId())).v();
            if (r23 == null) goto L44;
            r23.setValue(this.a.o);
        L44:
            this.a.va0();
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ long a;

        public g(long r1) {
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

    public static final class h implements DialogInterface.OnClickListener {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class i implements DialogInterface.OnClickListener {
        public final /* synthetic */ AudioTalkSettingFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public i(AudioTalkSettingFragment r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            AudioTalkSettingFragment r6 = this.a;
            int r0 = this.b;
            int r1 = this.c;
            int r2 = AudioTalkSettingFragment.w;
            r6.ta0(r0, r1, 0);
            r4.dismiss();
        }
    }

    public static final class j implements DialogInterface.OnClickListener {
        public static final j a = null;

        static {
            a = new j();
        }

        public j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    public static final class k implements DialogInterface.OnClickListener {
        public final /* synthetic */ AudioTalkSettingFragment a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public k(AudioTalkSettingFragment r1, int r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r4, int r5) {
            AudioTalkSettingFragment r6 = this.a;
            int r0 = this.b;
            int r1 = this.c;
            int r2 = AudioTalkSettingFragment.w;
            r6.ta0(r0, r1, 0);
            r4.dismiss();
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ AudioTalkSettingFragment a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public l(AudioTalkSettingFragment r1, boolean r2, boolean r3) {
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
            ((Switch) this.a.fa0().findViewById(2131387859)).setEnabled(true);
            if (this.b == true) goto L8;
            DataCenter r6 = this.a.l;
            if (r6 == null) goto L8;
            r6.put("data_audio_talk_dot_with_number_show", "");
        L8:
            if (this.c == false) goto L11;
            this.a.d.dismiss();
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ AudioTalkSettingFragment a;
        public final /* synthetic */ boolean b;

        public m(AudioTalkSettingFragment r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            f2.c(com.bytedance.android.live.core.utils.s1.B(2131915982), 0);
            ((Switch) this.a.fa0().findViewById(2131387859)).setChecked(((Boolean) b6.d.getValue()).booleanValue());
            ((Switch) this.a.fa0().findViewById(2131387859)).setEnabled(true);
            ALogger.e("err api", ((Throwable) r4).toString());
            if (this.b == false) goto L6;
            this.a.d.dismiss();
            return;
        }
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

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public final View fa0() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        return r0;
    }

    public final void ga0() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        ((FrameLayout) r0.findViewById(2131387742)).setOnClickListener(new b(this));
    }

    public final IRoom getRoom() {
        IRoom r0 = this.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        return r0;
    }

    public final void ia0() {
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        boolean r1 = true;
        if (r0 == null) goto L5;
        boolean r2 = r0.isCanShowLinkmicAnnounce(true);
    L7:
        if (r2 == false) goto L9;
    L15:
        View r3 = this.h;
        if (r3 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L18:
        ((TextView) r3.findViewById(2131390670)).setVisibility(0);
    L19:
        IInteractService r4 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r4 == null) goto L22;
        boolean r5 = r4.isCanShowLinkmicAnnounce(true);
    L23:
        com.bytedance.android.live.liveinteract.revenue.guestlink.i r6 = null;
        if (r5 == false) goto L68;
        View r7 = this.h;
        if (r7 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L28:
        r7.findViewById(2131363026).setVisibility(0);
        View r8 = this.h;
        if (r8 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L31:
        ((TextView) r8.findViewById(2131363029)).setFilters(new InputFilter[]{new je0.a(8)});
        DataCenter r9 = this.l;
        if (r9 == null) goto L34;
        vlc.d r10 = (vlc.d) r9.get("data_message_manager");
    L35:
        if (r10 == null) goto L37;
        ILinkmicAnnounceMessage r11 = (ILinkmicAnnounceMessage) bc2.d.a(r10, MultiLinkMessageMethods.INSTANCE.getLINKMIC_ANNOUNCE_METHOD());
    L38:
        if (r11 == null) goto L47;
        ILinkmicAnnounceMessage.b r12 = r11.getShowingAnnounce();
        if (r12 == null) goto L47;
        String r13 = r12.a();
        if (r13 == null) goto L47;
        View r14 = this.h;
        if (r14 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L46:
        ((TextView) r14.findViewById(2131363029)).setText(r13);
    L47:
        IRoom r15 = this.j;
        if (r15 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L51:
        if (Intrinsics.areEqual(r15.getAnchorAbValue("live_chatroom_announce_image_enable"), "true") == false) goto L53;
        Boolean r16 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.k1.getValue();
    L55:
        if (r16.booleanValue() == false) goto L60;
        View r17 = this.h;
        if (r17 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L59:
        UtilityKotlinExtentionsKt.w(r17.findViewById(2131363027));
    L64:
        View r18 = this.h;
        if (r18 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L67:
        r18.findViewById(2131363026).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AudioTalkSettingFragment$initLinkmicAnnounceSetting$2(this)));
    L73:
        if (na0() == false) goto L118;
        StringBuilder r19 = new StringBuilder("initGuestLinkSwitch: ");
        com.bytedance.android.livesdk.sharedpref.e r20 = com.bytedance.android.livesdk.sharedpref.c.z1;
        r19.append((Boolean) r20.getValue());
        ALogger.i("AudioTalkSettingFragment", r19.toString());
        tb6.a.c();
        View r21 = this.h;
        if (r21 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L77:
        r21.findViewById(2131374068).setVisibility(0);
        View r22 = this.h;
        if (r22 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L80:
        r22.findViewById(2131374068).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.f(this));
        View r23 = this.h;
        if (r23 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L83:
        TextView r24 = (TextView) r23.findViewById(2131390729);
        String r25 = vm2.i.e().getSettingTitle();
        if (r25 != null) goto L87;
        r25 = com.bytedance.android.live.core.utils.s1.B(2131917653);
    L87:
        r24.setText(r25);
        View r26 = this.h;
        if (r26 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L90:
        TextView r27 = (TextView) r26.findViewById(2131390728);
        if (((Boolean) r20.getValue()).booleanValue() == false) goto L93;
        String r28 = com.bytedance.android.live.core.utils.s1.B(2131917651);
    L94:
        r27.setText(r28);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.l1.getValue()).booleanValue() == false) goto L100;
        View r29 = this.h;
        if (r29 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L99:
        UtilityKotlinExtentionsKt.w(r29.findViewById(2131374067));
    L104:
        com.bytedance.android.live.liveinteract.revenue.guestlink.i r30 = com.bytedance.live.datacontext.d.d(com.bytedance.android.live.liveinteract.revenue.guestlink.i.class);
        if ((r30 instanceof com.bytedance.android.live.liveinteract.revenue.guestlink.i) == false) goto L108;
        r6 = r30;
    L108:
        com.bytedance.android.live.liveinteract.revenue.guestlink.i r31 = r6;
        if (r31 == null) goto L118;
        com.bytedance.live.datacontext.m<Boolean> r32 = r31.isOpen();
        if (r32 == null) goto L118;
        Observable r33 = r32.a();
        if (r33 == null) goto L118;
        Disposable r34 = r33.subscribe(new com.bytedance.android.live.liveinteract.linkpanel.fragment.g(this));
        if (r34 == null) goto L118;
        this.m.add(r34);
        goto L118
    L100:
        View r35 = this.h;
        if (r35 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L103:
        UtilityKotlinExtentionsKt.t(r35.findViewById(2131374067));
        goto L104
    L93:
        r28 = com.bytedance.android.live.core.utils.s1.B(2131917650);
    L118:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L121;
        r1 = false;
    L121:
        if (r1 == false) goto L130;
        View r36 = this.h;
        if (r36 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L125:
        ((ViewGroup) r36.findViewById(2131373386)).setVisibility(8);
        View r37 = this.h;
        if (r37 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L128:
        ((ViewGroup) r37.findViewById(2131377430)).setVisibility(8);
        return;
    L130:
        return;
    L60:
        View r38 = this.h;
        if (r38 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L63:
        UtilityKotlinExtentionsKt.t(r38.findViewById(2131363027));
        goto L64
    L53:
        r16 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.j1.getValue();
        goto L55
    L37:
        r11 = null;
        goto L38
    L34:
        r10 = null;
        goto L35
    L68:
        View r39 = this.h;
        if (r39 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L71:
        r39.findViewById(2131363026).setVisibility(8);
        goto L73
    L22:
        r5 = false;
        goto L23
    L9:
        if (na0() == true) goto L15;
        View r40 = this.h;
        if (r40 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        ((TextView) r40.findViewById(2131390670)).setVisibility(8);
        goto L19
    L5:
        r2 = false;
        goto L7
    }

    public final boolean na0() {
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.m(this.k).isAnchor(), Boolean.TRUE) == true) goto L22;
        boolean r0 = jc1.k.n(IMiddlewareUserService.class).user().isAdmin();
        DataCenter r3 = this.l;
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

    public final void oa0() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L5:
        FrameLayout r1 = (FrameLayout) r0.findViewById(2131374065);
        if (r1 == null) goto L8;
        r1.setVisibility(0);
    L8:
        View r2 = this.h;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L11:
        Switch r3 = (Switch) r2.findViewById(2131387907);
        if (r3 == null) goto L14;
        r3.setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.J0.getValue()).booleanValue());
    L14:
        View r4 = this.h;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        ((Switch) r4.findViewById(2131387907)).setOnCheckedChangeListener(new e(this));
    }

    public final void va0() {
        if (CollectionUtils.isEmpty(this.p) == false) goto L8;
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
        TextView r2 = (TextView) r1.findViewById(2131391119);
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r3 = this.p;
        com.bytedance.android.livesdk.chatroom.model.k1 r4 = null;
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
        ((LinkedHashMap) TalkRoomLogUtils.f).clear();
        ((TalkRoomLogUtils) ((IInteractService) jc1.k.n(IInteractService.class)).getTalkRoomLogUtils()).getClass();
        Intrinsics.checkNotNullParameter(r7, "source");
        TalkRoomLogUtils.o1(r7);
        View r8 = this.h;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L22:
        RecyclerView r9 = r8.findViewById(2131384989);
        if (r9 == null) goto L25;
        UtilityKotlinExtentionsKt.t(r9);
    L25:
        View r10 = this.h;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L28:
        LinearLayout r11 = (LinearLayout) r10.findViewById(2131377830);
        if (r11 == null) goto L31;
        UtilityKotlinExtentionsKt.w(r11);
    L31:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r12 = this.p;
        if (r12 == null) goto L51;
        com.bytedance.android.livesdk.chatroom.model.k1 r13 = (com.bytedance.android.livesdk.chatroom.model.k1) CollectionsKt.getOrNull(r12, 0);
        if (r13 == null) goto L51;
        View r14 = this.h;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L38:
        ((LinearLayout) r14.findViewById(2131378724)).setVisibility(0);
        View r15 = this.h;
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L41:
        ((TextView) r15.findViewById(2131390831)).setText(r13.getTitle().toString());
        py.k r16 = r13.getIcon();
        if (r16 == null) goto L47;
        View r17 = this.h;
        if (r17 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L46:
        ImageUtil.loadImage((ImageView) r17.findViewById(2131376333), r16, 0);
    L47:
        View r18 = this.h;
        if (r18 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L50:
        ((LinearLayout) r18.findViewById(2131378724)).setOnClickListener(new d0(r13, this, r7));
        com.bytedance.android.live.liveinteract.linkpanel.util.m.t(r13.getType(), r7);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.o(r13);
    L51:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r19 = this.p;
        if (r19 == null) goto L71;
        com.bytedance.android.livesdk.chatroom.model.k1 r20 = (com.bytedance.android.livesdk.chatroom.model.k1) CollectionsKt.getOrNull(r19, 1);
        if (r20 == null) goto L71;
        View r21 = this.h;
        if (r21 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L58:
        ((LinearLayout) r21.findViewById(2131378725)).setVisibility(0);
        View r22 = this.h;
        if (r22 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L61:
        ((TextView) r22.findViewById(2131390832)).setText(r20.getTitle().toString());
        py.k r23 = r20.getIcon();
        if (r23 == null) goto L67;
        View r24 = this.h;
        if (r24 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L66:
        ImageUtil.loadImage((ImageView) r24.findViewById(2131376334), r23, 0);
    L67:
        View r25 = this.h;
        if (r25 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L70:
        ((LinearLayout) r25.findViewById(2131378725)).setOnClickListener(new e0(r20, this, r7));
        com.bytedance.android.live.liveinteract.linkpanel.util.m.t(r20.getType(), r7);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.o(r20);
    L71:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r26 = this.p;
        if (r26 == null) goto L86;
        List r27 = CollectionsKt.take(r26, 2);
        if (r27 == null) goto L86;
        Iterator r28 = r27.iterator();
    L77:
        if (r28.hasNext() == false) goto L84;
        Object r29 = r28.next();
        if (((com.bytedance.android.livesdk.chatroom.model.k1) r29).getType() != 2) goto L81;
        boolean r30 = true;
    L82:
        if (r30 == false) goto L77;
    L85:
        com.bytedance.android.livesdk.chatroom.model.k1 r31 = (com.bytedance.android.livesdk.chatroom.model.k1) r29;
        goto L86
    L81:
        r30 = false;
        goto L82
    L84:
        r29 = null;
    L86:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r32 = this.p;
        if (r32 == null) goto L101;
        List r33 = CollectionsKt.take(r32, 2);
        if (r33 == null) goto L101;
        Iterator r34 = r33.iterator();
    L92:
        if (r34.hasNext() == false) goto L99;
        Object r35 = r34.next();
        if (((com.bytedance.android.livesdk.chatroom.model.k1) r35).getType() != 7) goto L96;
        boolean r36 = true;
    L97:
        if (r36 == false) goto L92;
    L100:
        com.bytedance.android.livesdk.chatroom.model.k1 r37 = (com.bytedance.android.livesdk.chatroom.model.k1) r35;
    L102:
        if (r37 == null) goto L104;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.w(r7);
    L104:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r38 = this.p;
        if (r38 == null) goto L107;
        int r39 = r38.size();
    L108:
        if (r39 <= 0) goto L119;
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r40 = this.p;
        if (r40 == null) goto L112;
        com.bytedance.android.livesdk.chatroom.model.k1 r41 = (com.bytedance.android.livesdk.chatroom.model.k1) ListProtector.get(r40, 0);
    L114:
        if (la0(r41) == false) goto L119;
        View r42 = this.h;
        if (r42 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L118:
        r42.findViewById(2131376479).setVisibility(0);
        goto L119
    L112:
        r41 = null;
    L119:
        if (r39 <= 1) goto L141;
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r43 = this.p;
        if (r43 == null) goto L124;
        r4 = (com.bytedance.android.livesdk.chatroom.model.k1) ListProtector.get(r43, 1);
    L124:
        if (la0(r4) == false) goto L142;
        View r44 = this.h;
        if (r44 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L128:
        r44.findViewById(2131376480).setVisibility(0);
        return;
    L142:
        return;
    L141:
        return;
    L107:
        r39 = 0;
        goto L108
    L96:
        r36 = false;
        goto L97
    L99:
        r35 = null;
    L101:
        r37 = null;
        goto L102
    L18:
        r6 = 4;
        goto L19
    L14:
        r5 = null;
        goto L15
    }

    public AudioTalkSettingFragment() {
        this.g = new LinkedHashMap();
        this.m = new CompositeDisposable();
        this.o = new ArrayList();
        this.q = new ArrayList();
        this.r = new LinkedHashMap();
        this.t = new tb6.c();
        this.u = "link_setting_click";
        this.v = new AudioTalkSettingFragment$onClick$1(this);
    }

    public static boolean ka0() {
        if (com.bytedance.android.live.liveinteract.api.utils.m.i() == null) goto L19;
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        Intrinsics.checkNotNull(r0);
        Boolean r1 = r0.isAnchor();
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        if (r2 == false) goto L20;
        com.bytedance.android.livesdk.chatroom.u r3 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        Intrinsics.checkNotNull(r3);
        com.bytedance.live.datacontext.j r4 = r3.s();
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r4.getValue();
        if (r5 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = r5.t();
        if (r6 != null) goto L16;
        return false;
    L16:
        if (r6.a != 5) goto L24;
        return true;
    L24:
        return false;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L7:
        r2 = false;
        goto L8
    L19:
        return false;
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
        ((FrameLayout) r6.findViewById(2131372770)).setOnClickListener(new d(this));
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

    public final void ea0() {
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().w2();
        if (r0 != null) goto L5;
    L11:
        DataCenter r1 = this.l;
        IRoom r2 = this.j;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L14:
        com.bytedance.live.datacontext.n r3 = com.bytedance.android.live.liveinteract.api.utils.m.f(r1, Long.valueOf(r2.getRoomId())).z();
        if (r3 == null) goto L19;
        List<? extends f3> r4 = (List) r3.getValue();
        if (r4 == null) goto L19;
        this.n = r4;
    L19:
        DataCenter r5 = this.l;
        IRoom r6 = this.j;
        if (r6 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L22:
        com.bytedance.live.datacontext.n r7 = com.bytedance.android.live.liveinteract.api.utils.m.f(r5, Long.valueOf(r6.getRoomId())).v();
        if (r7 == null) goto L27;
        List<Integer> r8 = (List) r7.getValue();
        if (r8 == null) goto L27;
        this.o = r8;
    L27:
        DataCenter r9 = this.l;
        IRoom r10 = this.j;
        if (r10 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L30:
        com.bytedance.live.datacontext.n r11 = com.bytedance.android.live.liveinteract.api.utils.m.f(r9, Long.valueOf(r10.getRoomId())).r();
        if (r11 == null) goto L35;
        List<Long> r12 = (List) r11.getValue();
        if (r12 == null) goto L35;
        this.q = r12;
    L35:
        DataCenter r13 = this.l;
        IRoom r14 = this.j;
        if (r14 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L38:
        if (r14 == null) goto L40;
        Long r15 = Long.valueOf(r14.getRoomId());
    L41:
        com.bytedance.android.livesdk.chatroom.u r16 = com.bytedance.android.live.liveinteract.api.utils.m.f(r13, Long.valueOf(r15.longValue()));
        if (r16 == null) goto L48;
        com.bytedance.live.datacontext.n r17 = r16.t();
        if (r17 == null) goto L48;
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r18 = (List) r17.getValue();
        if (r18 == null) goto L48;
        this.p = r18;
        va0();
    L48:
        pa0();
        return;
    L40:
        r15 = null;
        goto L41
    L5:
        if (((Boolean) r0.getValue()).booleanValue() != true) goto L11;
        com.bytedance.live.datacontext.m r19 = com.bytedance.android.live.liveinteract.api.utils.m.i().w2();
        if (r19 == null) goto L9;
        r19.setValue(Boolean.FALSE);
    L9:
        pa0();
    }

    public final void ha0() {
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L5;
    L10:
        View r0 = this.h;
        if (r0 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L13:
        Switch r1 = (Switch) r0.findViewById(2131387859);
        if (r1 == null) goto L16;
        r1.setChecked(((Boolean) b6.d.getValue()).booleanValue());
    L16:
        View r2 = this.h;
        if (r2 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L19:
        ((Switch) r2.findViewById(2131387859)).setOnCheckedChangeListener(new c(this));
        return;
    L5:
        if (((Boolean) kf.a.getValue()).booleanValue() == false) goto L10;
        View r3 = this.h;
        if (r3 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L9:
        ((ViewGroup) r3.findViewById(2131362523)).setVisibility(0);
        goto L10
    }

    public final void ja0() {
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.s() == true) goto L5;
        return;
    L5:
        View r0 = this.h;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L8:
        boolean r2 = false;
        r0.findViewById(2131381838).setVisibility(0);
        View r1 = this.h;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L11:
        View r3 = r1.findViewById(2131381839);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.i1.getValue()).booleanValue() == false) goto L14;
        int r4 = 0;
    L15:
        r3.setVisibility(r4);
        View r5 = this.h;
        if (r5 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L18:
        Switch r6 = (Switch) r5.findViewById(2131387928);
        Integer r7 = (Integer) com.bytedance.android.livesdk.sharedpref.c.e1.getValue();
        if (r7 != null) goto L22;
    L24:
        r6.setChecked(r2);
        View r8 = this.h;
        if (r8 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L27:
        ((Switch) r8.findViewById(2131387928)).setOnCheckedChangeListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.h(this));
        return;
    L22:
        if (r7.intValue() != 1) goto L24;
        r2 = true;
        goto L24
    L14:
        r4 = 8;
        goto L15
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.g.clear();
        DataCenter r0 = this.l;
        if (r0 == null) goto L6;
        r0.put("data_multi_link_setting_dialog_show", Boolean.FALSE);
        return;
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        DataCenter r0 = this.l;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        this.m.dispose();
        Iterator r1 = ((LinkedHashMap) this.r).entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L27;
        Map.Entry r2 = (Map.Entry) r1.next();
        String r3 = (String) r2.getKey();
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.c.J0;
        String r5 = "on";
        if (Intrinsics.areEqual(r3, r4.getName()) == false) goto L17;
        if ((!Intrinsics.areEqual((Boolean) r2.getValue(), (Boolean) r4.getValue())) == false) goto L17;
        String r6 = com.bytedance.android.live.core.utils.s1.B(2131918072);
        if (((Boolean) r4.getValue()).booleanValue() == true) goto L16;
        r5 = "off";
    L16:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.m(r6, r5);
    L17:
        String r7 = (String) r2.getKey();
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.c.q1;
        if (Intrinsics.areEqual(r7, r8.getName()) == false) goto L26;
        if ((!Intrinsics.areEqual((Boolean) r2.getValue(), (Boolean) r8.getValue())) == false) goto L26;
        String r9 = com.bytedance.android.live.core.utils.s1.B(2131923215);
        if (((Boolean) r8.getValue()).booleanValue() == true) goto L25;
        r5 = "off";
    L25:
        com.bytedance.android.live.liveinteract.linkpanel.util.m.m(r9, r5);
    L26:
        ALogger.i("AudioTalkSettingFragment", "no setting change");
        goto L7
    L27:
        ((LinkedHashMap) this.r).clear();
    }

    public final void onResume() {
        super.onResume();
        tb6.c r0 = this.t;
        if (r0 == null) goto L5;
        i97.a r1 = i97.a.a;
        r0.b = System.currentTimeMillis() - r0.a;
        r0.c("setting_panel_type");
    L5:
        this.t = null;
    }

    public final void pa0() {
        long r0 = System.currentTimeMillis();
        LinkAudienceApi r2 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r3 = this.j;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        Disposable r1 = r2.interactList(r3.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new f(this, r0), new g(r0));
        this.m.add(r1);
    }

    public static final void ba0(AudioTalkSettingFragment r2) {
        r2.getClass();
        if (((IInteractService) jc1.k.n(IInteractService.class)).finishAudioTalk("pre_apply") == false) goto L8;
        DataCenter r3 = r2.l;
        if (r3 == null) goto L9;
        r3.put("data_room_video_talk_log_over_for_over_path", "audience_link_setting");
        return;
    L9:
        return;
    }

    public static boolean la0(com.bytedance.android.livesdk.chatroom.model.k1 r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.getType() == 5) goto L8;
        return false;
    L8:
        if (r3.getNewArrival() == true) goto L10;
        return false;
    L10:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 29) goto L12;
        return false;
    L12:
        if (((Boolean) b6.f.getValue()).booleanValue() == false) goto L18;
        return true;
    L18:
        return false;
    }

    public static void ma0(String r4) {
        Intrinsics.checkNotNullParameter("interact_panel", "shootWay");
        Intrinsics.checkNotNullParameter(r4, "functionType");
        LinkedHashMap r1 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r1);
        r1.put("function_type", r4);
        r1.put("shoot_way", "interact_panel");
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_open", r1, new Object[]{IRoom.class});
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

    public final void onChanged(Object r11) {
        KVData r12 = (KVData) r11;
        String r0 = null;
        if (r12 == null) goto L5;
        String r1 = r12.getKey();
    L6:
        int r2 = 0;
        if (Intrinsics.areEqual(r1, "data_room_audio_chat_ui_layout") == false) goto L122;
        if (r12 == null) goto L10;
        Integer r13 = (Integer) r12.getData();
    L12:
        if (((IInteractService) jc1.k.n(IInteractService.class)).enableMultiEnlarge("AudioTalkSettingFragment") == false) goto L81;
        if (r13 != null) goto L17;
    L31:
        if (r13 != null) goto L34;
    L48:
        if (r13 == null) goto L51;
        r2 = r13.intValue();
    L51:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.b(r2) == false) goto L65;
        View r14 = this.h;
        if (r14 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L55:
        ((LinearLayout) r14.findViewById(2131377432)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        View r15 = this.h;
        if (r15 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L58:
        ((LinearLayout) r15.findViewById(2131377435)).setBackground(null);
        View r16 = this.h;
        if (r16 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L61:
        ((LinearLayout) r16.findViewById(2131377433)).setBackground(null);
        View r17 = this.h;
        if (r17 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L64:
        UtilityKotlinExtentionsKt.t(r17.findViewById(2131371615));
        qa0(21);
        return;
    L65:
        View r18 = this.h;
        if (r18 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L68:
        ((LinearLayout) r18.findViewById(2131377435)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        View r19 = this.h;
        if (r19 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L71:
        ((LinearLayout) r19.findViewById(2131377432)).setBackground(null);
        View r110 = this.h;
        if (r110 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L74:
        ((LinearLayout) r110.findViewById(2131377433)).setBackground(null);
        qa0(22);
        if (vm2.d.G0() == false) goto L137;
        View r111 = this.h;
        if (r111 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L79:
        UtilityKotlinExtentionsKt.w(r111.findViewById(2131371615));
        return;
    L137:
        return;
    L34:
        if (r13.intValue() != 26) goto L48;
        View r112 = this.h;
        if (r112 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L38:
        ((LinearLayout) r112.findViewById(2131377433)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        View r113 = this.h;
        if (r113 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L41:
        ((LinearLayout) r113.findViewById(2131377432)).setBackground(null);
        View r114 = this.h;
        if (r114 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L44:
        ((LinearLayout) r114.findViewById(2131377435)).setBackground(null);
        View r115 = this.h;
        if (r115 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L47:
        UtilityKotlinExtentionsKt.t(r115.findViewById(2131371615));
        qa0(26);
        return;
    L17:
        if (r13.intValue() != 24) goto L31;
        View r116 = this.h;
        if (r116 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L21:
        ((LinearLayout) r116.findViewById(2131377432)).setBackground(null);
        View r117 = this.h;
        if (r117 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L24:
        ((LinearLayout) r117.findViewById(2131377435)).setBackground(null);
        View r118 = this.h;
        if (r118 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L27:
        ((LinearLayout) r118.findViewById(2131377433)).setBackground(null);
        View r119 = this.h;
        if (r119 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L30:
        UtilityKotlinExtentionsKt.t(r119.findViewById(2131371615));
        return;
    L81:
        if (r13 != null) goto L84;
    L95:
        if (r13 == null) goto L97;
        int r120 = r13.intValue();
    L99:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.b(r120) == false) goto L110;
        View r121 = this.h;
        if (r121 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L103:
        ((LinearLayout) r121.findViewById(2131377431)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        View r122 = this.h;
        if (r122 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L106:
        ((LinearLayout) r122.findViewById(2131377434)).setBackground(null);
        View r123 = this.h;
        if (r123 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L109:
        UtilityKotlinExtentionsKt.t(r123.findViewById(2131371615));
        ra0(false);
        return;
    L110:
        View r124 = this.h;
        if (r124 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L113:
        ((LinearLayout) r124.findViewById(2131377431)).setBackground(null);
        View r125 = this.h;
        if (r125 != null) goto L116;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L116:
        ((LinearLayout) r125.findViewById(2131377434)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        ra0(true);
        if (vm2.d.G0() == false) goto L141;
        View r126 = this.h;
        if (r126 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L121:
        UtilityKotlinExtentionsKt.w(r126.findViewById(2131371615));
        return;
    L141:
        return;
    L97:
        r120 = 0;
        goto L99
    L84:
        if (r13.intValue() != 24) goto L95;
        View r127 = this.h;
        if (r127 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L88:
        ((LinearLayout) r127.findViewById(2131377431)).setBackground(null);
        View r128 = this.h;
        if (r128 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L91:
        ((LinearLayout) r128.findViewById(2131377434)).setBackground(null);
        View r129 = this.h;
        if (r129 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L94:
        UtilityKotlinExtentionsKt.t(r129.findViewById(2131371615));
        return;
    L10:
        r13 = null;
        goto L12
    L122:
        if (r12 == null) goto L125;
        r0 = r12.getKey();
    L125:
        if (Intrinsics.areEqual(r0, "cmd_finish_voice_talk_room_result") == false) goto L143;
        Boolean r130 = (Boolean) r12.getData();
        if (r130 != null) goto L130;
        r130 = Boolean.FALSE;
    L130:
        if (r130.booleanValue() == false) goto L132;
        ua0(false, true);
        return;
    L132:
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131915982), 0);
        return;
    L143:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void qa0(int r11) {
        if (r11 != 21) goto L5;
    L31:
        View r12 = this.h;
        if (r12 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L34:
        r3.a(r12.findViewById(2131377432), com.bytedance.android.live.core.utils.s1.B(2131915077) + com.bytedance.android.live.core.utils.s1.B(2131919958));
        View r13 = this.h;
        if (r13 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L37:
        r3.a(r13.findViewById(2131377435), com.bytedance.android.live.core.utils.s1.B(2131915079) + com.bytedance.android.live.core.utils.s1.B(2131920028));
        View r14 = this.h;
        if (r14 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L40:
        r3.a(r14.findViewById(2131377433), com.bytedance.android.live.core.utils.s1.B(2131915078) + com.bytedance.android.live.core.utils.s1.B(2131920028));
        return;
    L5:
        if (r11 != 22) goto L7;
        View r15 = this.h;
        if (r15 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L24:
        r3.a(r15.findViewById(2131377435), com.bytedance.android.live.core.utils.s1.B(2131915079) + com.bytedance.android.live.core.utils.s1.B(2131919958));
        View r16 = this.h;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L27:
        r3.a(r16.findViewById(2131377432), com.bytedance.android.live.core.utils.s1.B(2131915077) + com.bytedance.android.live.core.utils.s1.B(2131920028));
        View r17 = this.h;
        if (r17 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L30:
        r3.a(r17.findViewById(2131377433), com.bytedance.android.live.core.utils.s1.B(2131915078) + com.bytedance.android.live.core.utils.s1.B(2131920028));
        return;
    L7:
        if (r11 != 26) goto L9;
        View r18 = this.h;
        if (r18 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        r3.a(r18.findViewById(2131377433), com.bytedance.android.live.core.utils.s1.B(2131915078) + com.bytedance.android.live.core.utils.s1.B(2131919958));
        View r19 = this.h;
        if (r19 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        r3.a(r19.findViewById(2131377432), com.bytedance.android.live.core.utils.s1.B(2131915077) + com.bytedance.android.live.core.utils.s1.B(2131920028));
        View r110 = this.h;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L20:
        r3.a(r110.findViewById(2131377435), com.bytedance.android.live.core.utils.s1.B(2131915079) + com.bytedance.android.live.core.utils.s1.B(2131920028));
        return;
    L9:
        if (r11 == 27) goto L31;
    }

    public final void ra0(boolean r8) {
        if (r8 == false) goto L11;
        View r9 = this.h;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L7:
        r3.a(r9.findViewById(2131377434), com.bytedance.android.live.core.utils.s1.B(2131915083) + com.bytedance.android.live.core.utils.s1.B(2131919958));
        View r10 = this.h;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L10:
        r3.a(r10.findViewById(2131377431), com.bytedance.android.live.core.utils.s1.B(2131915086) + com.bytedance.android.live.core.utils.s1.B(2131920028));
        return;
    L11:
        View r11 = this.h;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L14:
        r3.a(r11.findViewById(2131377434), com.bytedance.android.live.core.utils.s1.B(2131915083) + com.bytedance.android.live.core.utils.s1.B(2131920028));
        View r12 = this.h;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L17:
        r3.a(r12.findViewById(2131377431), com.bytedance.android.live.core.utils.s1.B(2131915086) + com.bytedance.android.live.core.utils.s1.B(2131919958));
    }

    public static final void da0(AudioTalkSettingFragment r6, int r7) {
        r6.getClass();
        IInteractService r0 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r0 == null) goto L9;
        ai0.e r1 = r0.getAdventureService();
        if (r1 == null) goto L9;
        if (((ai0.c) r1).c() != true) goto L9;
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131914600), 0);
        return;
    L9:
        com.bytedance.android.live.liveinteract.revenue.fight.b r2 = ((IInteractService) jc1.k.n(IInteractService.class)).teamFightService();
        if (r2 == null) goto L16;
        com.bytedance.android.live.liveinteract.revenue.fight.a r3 = r2.o3();
        if (r3 == null) goto L16;
        if (r3.isFightShowing() != true) goto L16;
        f2.b(2131922795, 0);
        return;
    L16:
        xi0.a r4 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
        if (r4 != null) goto L19;
    L21:
        com.bytedance.android.live.liveinteract.revenue.battle.b0 r5 = ((IInteractService) jc1.k.n(IInteractService.class)).guestBattleContext();
        if (r5 != null) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == false) goto L30;
        r6.ta0(5, 5, r7);
        return;
    L30:
        if (((IInteractService) jc1.k.n(IInteractService.class)).enableMultiEnlarge("AudioTalkSettingFragment") == false) goto L39;
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.b(r7) == false) goto L35;
        int r9 = 2131915081;
    L42:
        com.bytedance.android.livesdk.widget.x0.b r10 = new com.bytedance.android.livesdk.widget.x0.b(r6.getContext(), 4);
        r10.l(r9);
        r10.i(0, 2131915090, new z(r6, r7));
        r10.i(1, 2131915089, new a0(r6));
        b0 r11 = new b0(r6);
        com.bytedance.android.livesdk.widget.x0.d r12 = r10.a;
        r12.j = r11;
        r12.i = c0.a;
        r10.n();
        return;
    L35:
        if (r7 != 26) goto L37;
        r9 = 2131915082;
        goto L42
    L37:
        r9 = 2131915085;
        goto L42
    L39:
        if (com.bytedance.android.livesdk.chatroom.interact.model.e0.b(r7) == false) goto L41;
        r9 = 2131915087;
        goto L42
    L41:
        r9 = 2131915084;
        goto L42
    L24:
        if (r5.isGameShowing() != true) goto L26;
        r8 = true;
        goto L27
    L19:
        if (r4.isFightShowing() != true) goto L21;
        f2.b(2131918756, 0);
    }

    public final void sa0(int r10, int r11) {
        if (r10 != r11) goto L4;
        return;
    L4:
        SimpleDateFormat r0 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        if (vm2.e.m() == false) goto L8;
    L17:
        boolean r1 = true;
    L18:
        if (r1 == true) goto L20;
        return;
    L20:
        int r7 = 2131915162;
        if (r10 == 5) goto L28;
        if (r10 == 9) goto L24;
        ta0(r10, r11, 0);
        return;
    L24:
        if (r11 == 10) goto L26;
        r7 = 2131915157;
        int r3 = 2131915156;
    L27:
        com.bytedance.android.livesdk.widget.x0.b r4 = new com.bytedance.android.livesdk.widget.x0.b(getContext(), 0);
        r4.a.a = 5;
        r4.m(r7);
        r4.l(r3);
        r4.i(1, 2131915442, h.a);
        r4.i(0, 2131918116, new i(this, r10, r11));
        r4.a.k = false;
        r4.n();
        this.d.dismiss();
        return;
    L26:
        r3 = 2131915161;
        goto L27
    L28:
        com.bytedance.android.live.liveinteract.revenue.battle.b0 r5 = ((IInteractService) jc1.k.n(IInteractService.class)).guestBattleContext();
        if (r5 == null) goto L36;
        if (r5.isGameShowing() != true) goto L36;
        if (r11 == 10) goto L34;
        r7 = 2131915172;
    L34:
        com.bytedance.android.livesdk.widget.x0.b r6 = new com.bytedance.android.livesdk.widget.x0.b(getContext(), 0);
        r6.a.a = 5;
        r6.m(r7);
        r6.l(2131917258);
        r6.i(0, 2131915442, j.a);
        r6.i(1, 2131918116, new k(this, r10, r11));
        r6.a.k = false;
        r6.n();
        return;
    L36:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.B() == false) goto L38;
        f2.b(2131922813, 0);
        return;
    L38:
        xi0.a r2 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
        if (r2 != null) goto L41;
    L43:
        ta0(r10, r11, 0);
        return;
    L41:
        if (r2.isFightShowing() != true) goto L43;
        f2.b(2131918765, 0);
        return;
    L8:
        if (r10 == 5) goto L10;
        if (r10 == 9) goto L10;
    L12:
        if (r10 != 10) goto L17;
        if (r11 == 5) goto L15;
        if (r11 != 9) goto L17;
    L15:
        f2.b(2131915139, 0);
    L16:
        r1 = false;
    L10:
        if (r11 != 10) goto L12;
        f2.b(2131915139, 0);
        goto L16
    }

    public final void ua0(boolean r6, boolean r7) {
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
        Disposable r10 = r5.updateSetting(r9.longValue(), r1).compose(RxUtil.rxSchedulerHelper()).subscribe(new l(this, r6, r7), new m(this, r7));
        this.m.add(r10);
        return;
    L14:
        r9 = null;
        goto L15
    L8:
        r4 = 2;
        goto L9
    }

    public final View onCreateView(LayoutInflater r24, ViewGroup r25, Bundle r26) {
        Intrinsics.checkNotNullParameter(r24, "inflater");
        this.h = r24.inflate(2131565507, r25, false);
        this.s = new PlayModeListViewModel(new WeakReference(getContext()));
        View r1 = LayoutInflater.from(getContext()).inflate(2131565653, null);
        if (r1 == null) goto L482;
        ViewGroup r2 = (ViewGroup) r1;
        this.i = r2;
        ((ImageView) r2.findViewById(2131363802)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AudioTalkSettingFragment$initTopView$1(this)));
        com.bytedance.live.datacontext.j r3 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.k).s();
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r3.getValue();
        if (r4 == null) goto L15;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r4) != true) goto L15;
        ViewGroup r5 = this.i;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L13:
        ((TextView) r5.findViewById(2131388920)).setText(com.bytedance.android.live.core.utils.s1.B(2131917554));
    L28:
        View r6 = this.h;
        if (r6 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L31:
        UtilityKotlinExtentionsKt.t(r6.findViewById(2131384806));
        DataCenter r7 = this.l;
        if (r7 == null) goto L34;
        r7.observe("data_room_audio_chat_ui_layout", this);
    L34:
        DataCenter r8 = this.l;
        if (r8 == null) goto L37;
        r8.observe("cmd_finish_voice_talk_room_result", this);
    L37:
        com.bytedance.android.live.liveinteract.utils.q r9 = ((IInteractService) jc1.k.n(IInteractService.class)).getTalkRoomLogUtils();
        String r12 = OpenPanelSource.LINK_SETTING_PANEL.getValue();
        ((TalkRoomLogUtils) r9).getClass();
        Intrinsics.checkNotNullParameter(r12, "source");
        TalkRoomLogUtils.o1(r12);
        if (((IInteractService) jc1.k.n(IInteractService.class)).enableMultiEnlarge("AudioTalkSettingFragment") == false) goto L46;
        View r10 = this.h;
        if (r10 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L42:
        ((LinearLayout) r10.findViewById(2131377471)).setVisibility(0);
        View r11 = this.h;
        if (r11 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L45:
        ((LinearLayout) r11.findViewById(2131377467)).setVisibility(8);
    L54:
        if (vm2.d.B() == false) goto L75;
        View r13 = this.h;
        if (r13 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L58:
        ((FrameLayout) r13.findViewById(2131380917)).setVisibility(8);
        View r14 = this.h;
        if (r14 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L61:
        ((FrameLayout) r14.findViewById(2131380924)).setVisibility(8);
        View r15 = this.h;
        if (r15 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L64:
        ((FrameLayout) r15.findViewById(2131372770)).setVisibility(0);
        View r16 = this.h;
        if (r16 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L67:
        TextView r17 = (TextView) r16.findViewById(2131390821);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.L0.getValue()).booleanValue() == false) goto L70;
        String r18 = com.bytedance.android.live.core.utils.s1.B(2131917699);
    L71:
        r17.setText(r18);
        View r19 = this.h;
        if (r19 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L74:
        ((FrameLayout) r19.findViewById(2131372770)).setOnClickListener(new s(this));
    L86:
        if (vm2.d.D() == false) goto L116;
        View r20 = this.h;
        if (r20 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L90:
        ((LinearLayout) r20.findViewById(2131384808)).setVisibility(0);
        com.bytedance.live.datacontext.j r21 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.k).s();
        if (r21 == null) goto L103;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r21.getValue();
        if (r22 == null) goto L103;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.a(r22) != true) goto L103;
        View r23 = this.h;
        if (r23 != null) goto L99;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L99:
        ((TextView) r23.findViewById(2131384809)).setText(com.bytedance.android.live.core.utils.s1.B(2131915151));
        View r27 = this.h;
        if (r27 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L102:
        ((LinearLayout) r27.findViewById(2131384808)).setOnClickListener(new t(this));
    L103:
        com.bytedance.live.datacontext.j r28 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.k).s();
        if (r28 == null) goto L116;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r29 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r28.getValue();
        if (r29 == null) goto L116;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r29) != true) goto L116;
        View r30 = this.h;
        if (r30 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L112:
        ((TextView) r30.findViewById(2131384809)).setText(com.bytedance.android.live.core.utils.s1.B(2131915155));
        View r31 = this.h;
        if (r31 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L115:
        ((LinearLayout) r31.findViewById(2131384808)).setOnClickListener(new u(this));
    L116:
        View r32 = this.h;
        if (r32 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L119:
        UtilityKotlinExtentionsKt.t(r32.findViewById(2131371615));
        View r33 = this.h;
        if (r33 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L122:
        ((Switch) r33.findViewById(2131387920)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.L0.getValue()).booleanValue());
        View r34 = this.h;
        if (r34 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L125:
        ((Switch) r34.findViewById(2131387920)).setOnCheckedChangeListener(new v(this));
        View r35 = this.h;
        if (r35 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L128:
        ((Switch) r35.findViewById(2131387922)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.M0.getValue()).booleanValue());
        View r36 = this.h;
        if (r36 != null) goto L131;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L131:
        ((Switch) r36.findViewById(2131387922)).setOnCheckedChangeListener(new w(this));
        ReadOnlyProperty r37 = vm2.d.v0;
        KProperty[] r110 = vm2.d.a;
        if (((Boolean) r37.getValue(null, r110[71])).booleanValue() == false) goto L152;
        com.bytedance.live.datacontext.j r38 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.k).s();
        if (r38 == null) goto L151;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r39 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r38.getValue();
        if (r39 == null) goto L151;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r39) != true) goto L151;
        IRoom r40 = this.j;
        if (r40 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L143:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.l.b(r40) == false) goto L145;
        oa0();
    L158:
        View r41 = this.h;
        if (r41 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L161:
        ((Switch) r41.findViewById(2131387937)).setChecked(com.bytedance.android.livesdk.sharedpref.d.a());
        if (vm2.d.V0().allowSendGiftToLinker == true) goto L164;
    L200:
        View r42 = this.h;
        if (r42 != null) goto L203;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L203:
        RelativeLayout r43 = (RelativeLayout) r42.findViewById(2131362534);
        if (r43 == null) goto L206;
        r43.setVisibility(8);
    L206:
        View r44 = this.h;
        if (r44 != null) goto L209;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L209:
        ((Switch) r44.findViewById(2131363498)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.d.Z.getValue(null, com.bytedance.android.livesdk.sharedpref.d.a[50])).booleanValue());
        if (((Boolean) vm2.d.Q0.getValue(null, r110[92])).booleanValue() == false) goto L221;
        View r45 = this.h;
        if (r45 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L214:
        Switch r46 = (Switch) r45.findViewById(2131363498);
        if (r46 == null) goto L217;
        r46.setClickable(false);
    L217:
        View r47 = this.h;
        if (r47 != null) goto L220;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L220:
        ((FrameLayout) r47.findViewById(2131363420)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AudioTalkSettingFragment$initSettingView$8(this)));
    L227:
        com.bytedance.live.datacontext.j r48 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.k).s();
        if (r48 == null) goto L238;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r49 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r48.getValue();
        if (r49 == null) goto L238;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r49) != true) goto L238;
        View r50 = this.h;
        if (r50 != null) goto L236;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L236:
        ((TextView) r50.findViewById(2131384806)).setText(com.bytedance.android.live.core.utils.s1.B(2131917554));
    L252:
        if (vm2.d.D() == false) goto L261;
        ConstraintSet r51 = new ConstraintSet();
        View r52 = this.h;
        if (r52 != null) goto L256;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L256:
        r51.clone(r52.findViewById(2131384807));
        r51.connect(2131384806, 7, 8, 7);
        r51.connect(2131384806, 6, 0, 6, com.bytedance.android.live.core.utils.s1.f(16.0f));
        View r53 = this.h;
        if (r53 != null) goto L259;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L259:
        r51.applyTo(r53.findViewById(2131384807));
    L261:
        if (vm2.d.x0() == true) goto L263;
    L276:
        View r54 = this.h;
        if (r54 != null) goto L279;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L279:
        ((FrameLayout) r54.findViewById(2131387741)).setVisibility(8);
    L280:
        com.bytedance.live.datacontext.j r55 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.k).s();
        if (r55 == null) goto L287;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r56 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r55.getValue();
        if (r56 == null) goto L287;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r56) != true) goto L287;
        boolean r57 = true;
    L288:
        if (r57 == false) goto L333;
        View r58 = this.h;
        if (r58 != null) goto L292;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L292:
        ((TextView) r58.findViewById(2131362299)).setText(com.bytedance.android.live.core.utils.s1.B(2131917685));
        IRoom r59 = this.j;
        if (r59 != null) goto L296;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L296:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.G(r59) == false) goto L307;
        View r60 = this.h;
        if (r60 != null) goto L300;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L300:
        UtilityKotlinExtentionsKt.w(r60.findViewById(2131387743));
        View r61 = this.h;
        if (r61 != null) goto L303;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L303:
        ((Switch) r61.findViewById(2131387915)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.R0.getValue()).booleanValue());
        View r62 = this.h;
        if (r62 != null) goto L306;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L306:
        ((Switch) r62.findViewById(2131387915)).setOnCheckedChangeListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.i(this));
    L307:
        IRoom r63 = this.j;
        if (r63 != null) goto L311;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L311:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.r(r63) == false) goto L328;
        com.bytedance.live.datacontext.j r65 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.k).s();
        if (r65 == null) goto L328;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r66 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r65.getValue();
        if (r66 == null) goto L328;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r66) != true) goto L328;
        View r67 = this.h;
        if (r67 != null) goto L321;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L321:
        UtilityKotlinExtentionsKt.w(r67.findViewById(2131373340));
        View r68 = this.h;
        if (r68 != null) goto L324;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L324:
        ((Switch) r68.findViewById(2131387905)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.q1.getValue()).booleanValue());
        View r69 = this.h;
        if (r69 != null) goto L327;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L327:
        ((Switch) r69.findViewById(2131387905)).setOnCheckedChangeListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.j(this));
    L328:
        View r70 = this.h;
        if (r70 != null) goto L331;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L331:
        UtilityKotlinExtentionsKt.t(r70.findViewById(2131373340));
    L333:
        if (ka0() == false) goto L444;
        View r71 = this.h;
        if (r71 != null) goto L337;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L337:
        ((LinearLayout) r71.findViewById(2131377430)).setVisibility(0);
        View r72 = this.h;
        if (r72 != null) goto L340;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L340:
        ((TextView) r72.findViewById(2131382169)).setVisibility(0);
        int r73 = ((IInteractService) jc1.k.n(IInteractService.class)).getAnchorManualUiLayout();
        if (((IInteractService) jc1.k.n(IInteractService.class)).enableMultiEnlarge("AudioTalkSettingFragment") == false) goto L370;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() != 28) goto L345;
    L359:
        View r74 = this.h;
        if (r74 != null) goto L362;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L362:
        ((LinearLayout) r74.findViewById(2131377432)).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.k(this, r73));
        View r75 = this.h;
        if (r75 != null) goto L365;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L365:
        ((LinearLayout) r75.findViewById(2131377435)).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.l(this, r73));
        View r76 = this.h;
        if (r76 != null) goto L368;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L368:
        ((LinearLayout) r76.findViewById(2131377433)).setOnClickListener(new com.bytedance.android.live.liveinteract.linkpanel.fragment.m(this, r73));
    L387:
        IInteractService r77 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r77 == null) goto L426;
        IRoom r78 = this.j;
        if (r78 != null) goto L393;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L393:
        if (r77.hitEnlargeStageAb(r78) != true) goto L426;
        if (r73 != 27) goto L397;
    L398:
        com.bytedance.android.livesdk.sharedpref.e r79 = com.bytedance.android.livesdk.sharedpref.c.D0;
        Long r80 = (Long) r79.getValue();
        if (r80 != null) goto L402;
    L404:
        Boolean r81 = (Boolean) com.bytedance.android.livesdk.sharedpref.c.C0.getValue();
        Long r82 = (Long) r79.getValue();
        if (r81.booleanValue() == false) goto L407;
    L409:
        boolean r83 = false;
    L410:
        if (r83 == false) goto L415;
        View r84 = this.h;
        if (r84 != null) goto L414;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L414:
        UtilityKotlinExtentionsKt.w(r84.findViewById(2131387167));
    L415:
        View r85 = this.h;
        if (r85 != null) goto L418;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L418:
        UtilityKotlinExtentionsKt.w(r85.findViewById(2131387168));
        View r86 = this.h;
        if (r86 != null) goto L421;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L421:
        ((Switch) r86.findViewById(2131387169)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.B0.getValue()).booleanValue());
        View r87 = this.h;
        if (r87 != null) goto L424;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L424:
        ((Switch) r87.findViewById(2131387169)).setOnCheckedChangeListener(new p(this));
        goto L426
    L407:
        if ((System.currentTimeMillis() - r82.longValue()) > (-1702967296)) goto L409;
        r83 = true;
        goto L410
    L402:
        if (r80.longValue() != 0) goto L404;
        com.bytedance.android.livesdk.sharedpref.f.d(r79, Long.valueOf(System.currentTimeMillis()));
        goto L404
    L397:
        if (r73 == 30) goto L398;
    L426:
        if (vm2.d.G0() == false) goto L439;
        IRoom r88 = this.j;
        if (r88 != null) goto L431;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L431:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r88) == false) goto L439;
        View r89 = this.h;
        if (r89 != null) goto L435;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L435:
        UtilityKotlinExtentionsKt.w(r89.findViewById(2131371615));
        View r90 = this.h;
        if (r90 != null) goto L438;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L438:
        Switch r91 = (Switch) r90.findViewById(2131371616);
        com.bytedance.android.livesdk.sharedpref.e r92 = com.bytedance.android.livesdk.sharedpref.c.A0;
        r91.setChecked(((Boolean) r92.getValue()).booleanValue());
        com.bytedance.android.live.liveinteract.linkpanel.util.m.q(((Boolean) r92.getValue()).booleanValue());
    L439:
        View r93 = this.h;
        if (r93 != null) goto L442;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L442:
        ((Switch) r93.findViewById(2131371616)).setOnCheckedChangeListener(new q(this));
        goto L444
    L345:
        if (r73 != 26) goto L350;
        View r94 = this.h;
        if (r94 != null) goto L349;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L349:
        ((LinearLayout) r94.findViewById(2131377433)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        qa0(26);
        goto L359
    L350:
        if (r73 != 22) goto L355;
        View r95 = this.h;
        if (r95 != null) goto L354;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L354:
        ((LinearLayout) r95.findViewById(2131377435)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        qa0(22);
        goto L359
    L355:
        View r96 = this.h;
        if (r96 != null) goto L358;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L358:
        ((LinearLayout) r96.findViewById(2131377432)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        qa0(21);
        goto L359
    L370:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.d() == 28) goto L380;
        if (r73 != 22) goto L376;
        View r97 = this.h;
        if (r97 != null) goto L375;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L375:
        ((LinearLayout) r97.findViewById(2131377434)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
        ra0(true);
        goto L380
    L376:
        ra0(false);
        View r98 = this.h;
        if (r98 != null) goto L379;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L379:
        ((LinearLayout) r98.findViewById(2131377431)).setBackground(com.bytedance.android.live.core.utils.s1.m(2131248982));
    L380:
        View r99 = this.h;
        if (r99 != null) goto L383;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L383:
        ((LinearLayout) r99.findViewById(2131377431)).setOnClickListener(new n(this, r73));
        View r100 = this.h;
        if (r100 != null) goto L386;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L386:
        ((LinearLayout) r100.findViewById(2131377434)).setOnClickListener(new o(this, r73));
    L444:
        if (gh0.a.d() == false) goto L452;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.n() == false) goto L452;
        View r101 = this.h;
        if (r101 != null) goto L450;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L450:
        ((TextView) r101.findViewById(2131382169)).setVisibility(0);
    L452:
        if (((Boolean) vm2.d.T0.getValue(null, r110[95])).booleanValue() == true) goto L454;
    L456:
        boolean r102 = false;
    L458:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 5) goto L460;
    L467:
        View r103 = this.h;
        if (r103 != null) goto L470;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L470:
        ((LinearLayout) r103.findViewById(2131378799)).setVisibility(0);
        View r104 = this.h;
        if (r104 != null) goto L473;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L473:
        ((TextView) r104.findViewById(2131391119)).setOnClickListener(new r(this));
        ea0();
    L474:
        ha0();
        ga0();
        ja0();
        ia0();
        Map<String, Boolean> r105 = this.r;
        com.bytedance.android.livesdk.sharedpref.e r106 = com.bytedance.android.livesdk.sharedpref.c.J0;
        r105.put(r106.getName(), (Boolean) r106.getValue());
        Map<String, Boolean> r107 = this.r;
        com.bytedance.android.livesdk.sharedpref.e r108 = com.bytedance.android.livesdk.sharedpref.c.q1;
        r107.put(r108.getName(), (Boolean) r108.getValue());
        DataCenter r109 = this.l;
        if (r109 == null) goto L477;
        r109.put("data_multi_link_setting_dialog_show", Boolean.TRUE);
    L477:
        HashMap r111 = new HashMap();
        r111.put("request_page", this.u);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_link_setting_panel_show", r111, new Object[]{IRoom.class});
        View r112 = this.h;
        if (r112 != null) goto L480;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L480:
        return r112;
    L460:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() == 16) goto L467;
        if (r102 == true) goto L467;
        View r113 = this.h;
        if (r113 != null) goto L466;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L466:
        ((LinearLayout) r113.findViewById(2131378799)).setVisibility(8);
        goto L474
    L454:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 9) goto L456;
        r102 = true;
    L287:
        r57 = false;
        goto L288
    L263:
        if (vm2.d.p() == false) goto L276;
        if (RoomPermissionContext.a.c(RoomPermissionContext.Companion) == true) goto L276;
        View r114 = this.h;
        if (r114 != null) goto L269;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L269:
        ((FrameLayout) r114.findViewById(2131387741)).setVisibility(0);
        View r115 = this.h;
        if (r115 != null) goto L272;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L272:
        ((Switch) r115.findViewById(2131387942)).setChecked(((Boolean) com.bytedance.android.livesdk.sharedpref.c.v1.getValue()).booleanValue());
        View r116 = this.h;
        if (r116 != null) goto L275;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L275:
        ((Switch) r116.findViewById(2131387942)).setOnCheckedChangeListener(new y(this));
    L238:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 10) goto L243;
        View r117 = this.h;
        if (r117 != null) goto L242;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L242:
        ((TextView) r117.findViewById(2131384806)).setText(com.bytedance.android.live.core.utils.s1.B(2131918013));
        goto L252
    L243:
        View r118 = this.h;
        if (r118 != null) goto L246;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L246:
        TextView r119 = (TextView) r118.findViewById(2131384806);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L249;
        String r120 = com.bytedance.android.live.core.utils.s1.B(2131920011);
    L250:
        r119.setText(r120);
        goto L252
    L249:
        r120 = com.bytedance.android.live.core.utils.s1.B(2131917559);
        goto L250
    L221:
        View r121 = this.h;
        if (r121 != null) goto L224;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L224:
        FrameLayout r122 = (FrameLayout) r121.findViewById(2131363419);
        if (r122 == null) goto L227;
        r122.setVisibility(8);
        goto L227
    L164:
        if (vm2.d.V0().audioChatSwitch == false) goto L200;
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() == 10) goto L200;
        View r123 = this.h;
        if (r123 != null) goto L170;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L170:
        RelativeLayout r124 = (RelativeLayout) r123.findViewById(2131362534);
        if (r124 == null) goto L174;
        r124.setVisibility(0);
    L174:
        if (vm2.d.u0() == false) goto L181;
        Boolean r125 = com.bytedance.android.live.liveinteract.api.utils.m.m(this.k).isAnchor();
        if (r125 == null) goto L178;
        boolean r126 = r125.booleanValue();
    L179:
        if (r126 == false) goto L181;
        boolean r127 = true;
    L182:
        if (r127 == false) goto L190;
        View r128 = this.h;
        if (r128 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L186:
        ((ImageView) r128.findViewById(2131362535)).setVisibility(0);
        ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        Intrinsics.checkNotNullParameter(PbRequest.SwitchType.GIFT, "requestPage");
        LinkedHashMap r129 = new LinkedHashMap();
        com.bytedance.android.live.liveinteract.linkpanel.util.m.B(r129, null, 6);
        com.bytedance.android.live.liveinteract.linkpanel.util.m.G(r129);
        r129.put("request_page", PbRequest.SwitchType.GIFT);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_anchor_audience_connection_profit_info_show", r129, new Object[]{IRoom.class});
        View r130 = this.h;
        if (r130 != null) goto L189;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L189:
        ((ImageView) r130.findViewById(2131362535)).setOnClickListener(new x(this, r129));
    L190:
        View r131 = this.h;
        if (r131 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L193:
        Switch r132 = (Switch) r131.findViewById(2131387937);
        if (r132 == null) goto L196;
        r132.setClickable(false);
    L196:
        View r133 = this.h;
        if (r133 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L199:
        ((FrameLayout) r133.findViewById(2131385918)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new AudioTalkSettingFragment$initSettingView$7(this)));
        goto L206
    L178:
        r126 = false;
    L181:
        r127 = false;
        goto L182
    L145:
        View r134 = this.h;
        if (r134 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L148:
        FrameLayout r135 = (FrameLayout) r134.findViewById(2131374065);
        if (r135 == null) goto L158;
        r135.setVisibility(8);
    L151:
        oa0();
        goto L158
    L152:
        View r136 = this.h;
        if (r136 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L155:
        FrameLayout r137 = (FrameLayout) r136.findViewById(2131374065);
        if (r137 == null) goto L158;
        r137.setVisibility(8);
        goto L158
    L70:
        r18 = com.bytedance.android.live.core.utils.s1.B(2131917700);
        goto L71
    L75:
        View r138 = this.h;
        if (r138 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L78:
        ((FrameLayout) r138.findViewById(2131380917)).setVisibility(0);
        View r139 = this.h;
        if (r139 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L81:
        ((FrameLayout) r139.findViewById(2131380924)).setVisibility(0);
        View r140 = this.h;
        if (r140 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L84:
        ((FrameLayout) r140.findViewById(2131372770)).setVisibility(8);
        goto L86
    L46:
        View r141 = this.h;
        if (r141 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L49:
        ((LinearLayout) r141.findViewById(2131377471)).setVisibility(8);
        View r142 = this.h;
        if (r142 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L52:
        ((LinearLayout) r142.findViewById(2131377467)).setVisibility(0);
    L15:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 10) goto L20;
        ViewGroup r143 = this.i;
        if (r143 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L19:
        ((TextView) r143.findViewById(2131388920)).setText(com.bytedance.android.live.core.utils.s1.B(2131918013));
        goto L28
    L20:
        ViewGroup r144 = this.i;
        if (r144 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L23:
        TextView r145 = (TextView) r144.findViewById(2131388920);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L26;
        String r146 = com.bytedance.android.live.core.utils.s1.B(2131920011);
    L27:
        r145.setText(r146);
        goto L28
    L26:
        r146 = com.bytedance.android.live.core.utils.s1.B(2131917559);
        goto L27
    L482:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void ta0(int r4, int r5, int r6) {
        DataCenter r0 = this.l;
        if (r0 == null) goto L6;
        r0.put("data_voice_chat_room_close_page", "interact_panel");
    L6:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L10;
        com.bytedance.android.live.liveinteract.plantform.base.g r1 = com.bytedance.android.live.liveinteract.plantform.base.f.a();
        if (r1 == null) goto L10;
        r1.ld(r4, r5, r6, "");
    L10:
        this.d.dismiss();
    }

    public static final void ca0(AudioTalkSettingFragment r3, HashMap r4, String r5, String r6) {
        r3.getClass();
        r4.put("live_type", "voice_live");
        IRoom r0 = r3.j;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        r4.put("anchor_id", r0.getOwnerUserIdString());
        IRoom r7 = r3.j;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L8:
        r4.put("room_id", r7.getIdStr());
        r4.put("function_type", r5);
        if (r6 == null) goto L12;
        r4.put("selection", r6);
        return;
    }
}
