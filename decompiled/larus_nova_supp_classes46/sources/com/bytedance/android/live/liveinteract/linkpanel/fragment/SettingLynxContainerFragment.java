package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linkpanel.contract.LinkPanelInviteContainerContract$View;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.config.bc0;
import com.bytedance.android.livesdk.config.c50;
import com.bytedance.android.livesdk.config.dc0;
import com.bytedance.android.livesdk.config.fe1;
import com.bytedance.android.livesdk.config.rj1;
import com.bytedance.android.livesdk.config.u20;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/SettingLynxContainerFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/LinkPanelInviteContainerContract$View;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public class SettingLynxContainerFragment extends LinkPanelInviteContainerContract$View implements Observer<KVData> {
    public static final a r = null;
    public View g;
    public ViewGroup h;
    public IRoom i;
    public DataContext j;
    public String k;
    public String l;
    public boolean m;
    public DataCenter n;
    public int o;
    public final CompositeDisposable p;
    public List<? extends com.bytedance.android.livesdk.chatroom.model.k1> q;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static SettingLynxContainerFragment a(yf0.g r2, DataCenter r3, IRoom r4, DataContext r5, String r6, int r7, boolean r8) {
            Intrinsics.checkNotNullParameter(r4, PbRequest.SwitchType.ROOM);
            ALogger.i("SettingLynxContainerFragment", "SettingLynxContainerFragment newInstance call title=null urlFromInit.isNotNullOrEmpty=" + r2.a(null));
            com.bytedance.android.live.liveinteract.linkpanel.util.v.a("setting_panel");
            System.currentTimeMillis();
            SettingLynxContainerFragment r0 = new SettingLynxContainerFragment();
            r0.n = r3;
            r0.d = r2;
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r0.i = r4;
            r0.j = r5;
            r0.o = r7;
            r0.m = r8;
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r0.k = "";
            Intrinsics.checkNotNullParameter("", "<set-?>");
            r0.l = "";
            if (r6 == null) goto L5;
            ih0.c r9 = com.bytedance.android.live.liveinteract.linkpanel.util.u.a;
            Intrinsics.checkNotNullParameter(r6, "requestPage");
            com.bytedance.android.live.liveinteract.linkpanel.util.u.b = r6;
        L6:
            return r0;
        L5:
            ih0.c r10 = com.bytedance.android.live.liveinteract.linkpanel.util.u.a;
            Intrinsics.checkNotNullParameter("link_setting_click", "requestPage");
            com.bytedance.android.live.liveinteract.linkpanel.util.u.b = "link_setting_click";
            goto L6
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SettingLynxContainerFragment a;
        public final /* synthetic */ long b;

        public b(SettingLynxContainerFragment r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
            int r0 = nd0.g.a;
            nd0.g.d(this.b, r9);
            List r1 = ((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getInteractItems();
            int r2 = 0;
            if (r1 == null) goto L43;
            Iterator r3 = r1.iterator();
            if (r3 == null) goto L43;
        L7:
            if (r3.hasNext() == false) goto L43;
            com.bytedance.android.livesdk.chatroom.model.k1 r4 = (com.bytedance.android.livesdk.chatroom.model.k1) r3.next();
            if (r4.getType() != 7) goto L16;
            xi0.a r5 = ((IInteractService) jc1.k.n(IInteractService.class)).linkRoomFightService();
            if (r5 != null) goto L13;
        L14:
            r3.remove();
        L21:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == true) goto L7;
            if (ArraysKt.contains(com.bytedance.android.livesdk.chatroom.model.e1.CURRENT_VERSION_SUPPORT_TYPE, r4.getType()) == true) goto L39;
            Integer r6 = Integer.valueOf(r4.getGameDataType());
            if (r6 != null) goto L28;
        L30:
            if (r6 != null) goto L33;
        L35:
            boolean r7 = false;
        L36:
            if (r7 == true) goto L39;
            r3.remove();
            goto L7
        L33:
            if (r6.intValue() != 1) goto L35;
        L29:
            r7 = true;
            goto L36
        L28:
            if (r6.intValue() != 2) goto L30;
        L39:
            if (r4.getType() != 1) goto L7;
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.H() == true) goto L7;
            r3.remove();
            goto L7
        L13:
            if (r5.r2() != true) goto L14;
        L16:
            if (r4.getType() != 10) goto L21;
            if ((!Intrinsics.areEqual(dc0.a.getValue(), Boolean.TRUE)) == false) goto L21;
            r3.remove();
        L43:
            List r10 = ((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getInteractItems();
            if (r10 == null) goto L46;
            r2 = r10.size();
        L46:
            if (r2 <= 0) goto L81;
            this.a.q = ((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getInteractItems();
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == true) goto L55;
            SettingLynxContainerFragment r11 = this.a;
            com.bytedance.live.datacontext.n r12 = com.bytedance.android.live.liveinteract.api.utils.m.f(r11.n, Long.valueOf(r11.getRoom().getRoomId())).l();
            if (r12 == null) goto L52;
            r12.setValue(this.a.q);
        L52:
            SettingLynxContainerFragment r13 = this.a;
            com.bytedance.live.datacontext.n r14 = com.bytedance.android.live.liveinteract.api.utils.m.f(r13.n, Long.valueOf(r13.getRoom().getRoomId())).F();
            if (r14 == null) goto L82;
            r14.setValue(((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getCurInteractType());
            return;
        L82:
            return;
        L55:
            SettingLynxContainerFragment r15 = this.a;
            com.bytedance.live.datacontext.n r16 = com.bytedance.android.live.liveinteract.api.utils.m.f(r15.n, Long.valueOf(r15.getRoom().getRoomId())).t();
            if (r16 == null) goto L58;
            r16.setValue(this.a.q);
        L58:
            SettingLynxContainerFragment r17 = this.a;
            com.bytedance.live.datacontext.n r18 = com.bytedance.android.live.liveinteract.api.utils.m.f(r17.n, Long.valueOf(r17.getRoom().getRoomId())).r();
            if (r18 == null) goto L61;
            r18.setValue(((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getPlayingList());
        L61:
            SettingLynxContainerFragment r19 = this.a;
            com.bytedance.live.datacontext.n r20 = com.bytedance.android.live.liveinteract.api.utils.m.f(r19.n, Long.valueOf(r19.getRoom().getRoomId())).z();
            if (r20 == null) goto L64;
            r20.setValue(((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getRoomModeItemList());
        L64:
            SettingLynxContainerFragment r21 = this.a;
            com.bytedance.live.datacontext.n r22 = com.bytedance.android.live.liveinteract.api.utils.m.f(r21.n, Long.valueOf(r21.getRoom().getRoomId())).v();
            if (r22 == null) goto L84;
            r22.setValue(((com.bytedance.android.livesdk.chatroom.model.e1) r9.data).getCurInteractType());
            return;
        L84:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;

        public c(long r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
            long r1 = this.a;
            r0.getClass();
            TalkRoomBusinessFullLinkMonitor.z(r1, r5);
            if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == true) goto L5;
            String r2 = "video_talk";
        L6:
            ALogger.w(r2, r5);
            return;
        L5:
            r2 = "voice_chat";
            goto L6
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

    static {
        r = new a();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final ViewGroup X90() {
        ViewGroup r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public void ba0() {
        ih0.c r0 = com.bytedance.android.live.liveinteract.linkpanel.util.u.a;
        ALogger.i("MultiLinkSettingPanelReuseManager", "releaseSettingPanelContainerCard call");
        ih0.c r1 = com.bytedance.android.live.liveinteract.linkpanel.util.u.a;
        if (r1 == null) goto L5;
        r1.J();
    L5:
        ih0.c r2 = com.bytedance.android.live.liveinteract.linkpanel.util.u.a;
        if (r2 == null) goto L8;
        r2.release();
    L8:
        com.bytedance.android.live.liveinteract.linkpanel.util.u.a = null;
    }

    public final IRoom getRoom() {
        IRoom r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        return r0;
    }

    public final void onDestroyView() {
        ALogger.i("SettingLynxContainerFragment", "onDestroy " + hashCode());
        ba0();
        this.p.dispose();
        DataCenter r0 = this.n;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        DataCenter r1 = this.n;
        if (r1 == null) goto L8;
        r1.put("data_multi_link_setting_dialog_show", Boolean.FALSE);
    L8:
        super.onDestroyView();
    }

    public SettingLynxContainerFragment() {
        this.k = "";
        this.l = "";
        this.o = -1;
        this.p = new CompositeDisposable();
    }

    public void aa0() {
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == true) goto L27;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.q(this.n) == true) goto L54;
        int r0 = us1.g.a;
        if (this.i != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L9:
        com.bytedance.live.datacontext.m r1 = com.bytedance.android.live.liveinteract.api.utils.m.i().w2();
        if (r1 != null) goto L12;
    L17:
        DataCenter r2 = this.n;
        IRoom r3 = this.i;
        if (r3 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L20:
        com.bytedance.live.datacontext.n r4 = com.bytedance.android.live.liveinteract.api.utils.m.f(r2, Long.valueOf(r3.getRoomId())).l();
        if (r4 == null) goto L25;
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r5 = (List) r4.getValue();
        if (r5 == null) goto L25;
        this.q = r5;
    L25:
        ca0();
        goto L54
    L12:
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L17;
        com.bytedance.live.datacontext.m r6 = com.bytedance.android.live.liveinteract.api.utils.m.i().w2();
        if (r6 == null) goto L16;
        r6.setValue(Boolean.FALSE);
    L16:
        ca0();
    L54:
        System.currentTimeMillis();
        ih0.c r7 = com.bytedance.android.live.liveinteract.linkpanel.util.u.a;
        com.bytedance.android.live.liveinteract.linkpanel.util.u.a(requireContext(), this.n, this.o);
        View r8 = this.g;
        if (r8 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L57:
        FrameLayout r9 = (FrameLayout) r8.findViewById(2131386007);
        Intrinsics.checkNotNullParameter(r9, "parentView");
        ALogger.i("MultiLinkSettingPanelReuseManager", "addCardToParent call");
        ih0.c r10 = com.bytedance.android.live.liveinteract.linkpanel.util.u.a;
        if (r10 == null) goto L67;
        r10.N(System.currentTimeMillis());
        LinkedHashMap r11 = new LinkedHashMap();
        LinkedHashMap r12 = new LinkedHashMap();
        r12.put("support_camera", Boolean.valueOf(tc0.c.h().E));
        IKtvService r13 = jc1.k.f(IKtvService.class);
        if (r13 == null) goto L62;
        Boolean r14 = Boolean.valueOf(r13.isAudienceSingEnableSwitchOn());
    L63:
        r12.put("is_audience_enable_sing", r14);
        r12.put("function_type", ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentFunctionType());
        r12.put("is_dynamic_from_audience", Boolean.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience()));
        r12.put("request_page", com.bytedance.android.live.liveinteract.linkpanel.util.u.b);
        r11.put("panel_config", r12);
        ih0.c.a.a(r10, r11, null, 4);
        View r15 = r10.getHybridView();
        if (r15 == null) goto L68;
        r10.J();
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-1, -1);
        r16.gravity = 17;
        r15.setLayoutParams(r16);
        r9.addView(r15);
        return;
    L68:
        return;
    L62:
        r14 = null;
        goto L63
    L67:
        return;
    L27:
        if (((Boolean) c50.a.getValue()).booleanValue() == true) goto L29;
    L31:
        boolean r17 = false;
    L33:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 5) goto L35;
    L37:
        com.bytedance.live.datacontext.m r18 = com.bytedance.android.live.liveinteract.api.utils.m.i().w2();
        if (r18 != null) goto L40;
    L45:
        DataCenter r19 = this.n;
        IRoom r20 = this.i;
        if (r20 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L48:
        com.bytedance.live.datacontext.n r21 = com.bytedance.android.live.liveinteract.api.utils.m.f(r19, Long.valueOf(r20.getRoomId())).t();
        if (r21 == null) goto L53;
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r22 = (List) r21.getValue();
        if (r22 == null) goto L53;
        this.q = r22;
    L53:
        ca0();
        goto L54
    L40:
        if (((Boolean) r18.getValue()).booleanValue() != true) goto L45;
        com.bytedance.live.datacontext.m r23 = com.bytedance.android.live.liveinteract.api.utils.m.i().w2();
        if (r23 == null) goto L44;
        r23.setValue(Boolean.FALSE);
    L44:
        ca0();
        goto L54
    L35:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() == 16) goto L37;
        if (r17 == false) goto L54;
    L29:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 9) goto L31;
        r17 = true;
        goto L33
    }

    public final void ca0() {
        long r0 = System.currentTimeMillis();
        LinkAudienceApi r2 = (LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class);
        IRoom r3 = this.i;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L5:
        Disposable r1 = r2.interactList(r3.getId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r0), new c(r0));
        this.p.add(r1);
    }

    public final void onChanged(Object r11) {
        KVData r12 = (KVData) r11;
        if (r12 != null) goto L5;
        return;
    L5:
        if (TextUtils.equals(r12.getKey(), "linkmic_panel_dismiss") == false) goto L10;
        yf0.g r13 = this.d;
        if (r13 == null) goto L81;
        r13.dismiss();
        return;
    L81:
        return;
    L10:
        if (TextUtils.equals(r12.getKey(), "linkmic_panel_open_play_mode_panel") == false) goto L33;
        com.bytedance.android.live.liveinteract.linkpanel.util.o.m();
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == false) goto L14;
    L23:
        DataCenter r4 = this.n;
        if (r4 == null) goto L84;
        yf0.g r14 = this.d;
        int r0 = MultiLinkIntegrationPlayMethodFragment.q;
        IRoom r1 = this.i;
        if (r1 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L28:
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r5 = this.q;
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == true) goto L31;
        int r7 = 1;
    L32:
        r14.Rh(MultiLinkIntegrationPlayMethodFragment.a.a(r14, r1, r4, r5, null, r7, true));
        return;
    L31:
        r7 = 2;
        goto L32
    L84:
        return;
    L14:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.p(this.n) == false) goto L23;
        u20 r15 = u20.a;
        u6 r2 = new u6(((fe1) r15.getValue()).b());
        r2.b("request_page", "link_setting_panel");
        IRoom r3 = this.i;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L19:
        if (r3.isLiveTypeAudio() == false) goto L21;
        String r6 = "1";
    L22:
        r2.b("show_room_item", r6);
        jc1.k.n(IBaseLiveActionHandler.class).handle(getContext(), UriProtector.parse(((fe1) r15.getValue()).a()).buildUpon().appendQueryParameter("url", r2.toString()).build().toString());
        return;
    L21:
        r6 = "0";
        goto L22
    L33:
        int r8 = 0;
        Long r9 = null;
        String r10 = null;
        if (TextUtils.equals(r12.getKey(), "linkmic_panel_sub_panel_push") == false) goto L59;
        DataCenter r16 = this.n;
        String r17 = "";
        if (r16 == null) goto L38;
        Pair r18 = (Pair) r16.get("linkmic_panel_sub_panel_push", new Pair("", ""));
    L39:
        yf0.g r19 = this.d;
        if (r19 == null) goto L86;
        int r20 = SettingLynxContainerSubFragment.t;
        DataCenter r21 = this.n;
        IRoom r22 = this.i;
        if (r22 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L44:
        DataContext r23 = this.j;
        if (r18 == null) goto L47;
        String r24 = (String) r18.getFirst();
    L48:
        if (r18 == null) goto L50;
        r10 = (String) r18.getSecond();
    L50:
        int r110 = this.o;
        Intrinsics.checkNotNullParameter(r22, PbRequest.SwitchType.ROOM);
        SettingLynxContainerSubFragment r25 = new SettingLynxContainerSubFragment(r8);
        r25.n = r21;
        r25.d = r19;
        Intrinsics.checkNotNullParameter(r22, "<set-?>");
        r25.i = r22;
        r25.j = r23;
        r25.o = r110;
        r25.m = true;
        if (r10 != null) goto L53;
        r10 = "";
    L53:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r25.k = r10;
        if (r24 == null) goto L57;
        r17 = r24;
    L57:
        Intrinsics.checkNotNullParameter(r17, "<set-?>");
        r25.l = r17;
        r19.Rh(r25);
        return;
    L47:
        r24 = null;
        goto L48
    L86:
        return;
    L38:
        r18 = null;
        goto L39
    L59:
        if (TextUtils.equals(r12.getKey(), "linkmic_panel_sub_panel_pop") == false) goto L64;
        yf0.g r111 = this.d;
        if (r111 == null) goto L88;
        r111.v0();
        return;
    L88:
        return;
    L64:
        if (TextUtils.equals(r12.getKey(), "cmd_finish_video_talk_room_result") == false) goto L90;
        DataCenter r112 = this.n;
        if (r112 == null) goto L70;
        Boolean r113 = (Boolean) r112.get("cmd_finish_video_talk_room_result", Boolean.FALSE);
        if (r113 == null) goto L70;
        boolean r114 = r113.booleanValue();
    L71:
        if (r114 == false) goto L78;
        HashMap r115 = new HashMap();
        r115.put("scene", 4);
        JSONArray r26 = new JSONArray();
        JSONObject r27 = new JSONObject();
        r27.put("key", 62);
        r27.put("value", 2);
        r26.put(r27);
        r115.put("incremental_update", r26);
        LinkApi r28 = (LinkApi) com.bytedance.android.live.network.c.b().e(LinkApi.class);
        IRoom r29 = this.i;
        if (r29 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException(PbRequest.SwitchType.ROOM);
    L75:
        if (r29 == null) goto L77;
        r9 = Long.valueOf(r29.getId());
    L77:
        this.p.add(r28.updateSetting(r9.longValue(), r115).compose(RxUtil.rxSchedulerHelper()).subscribe(new i0(this), new j0(this)));
        return;
    L78:
        f2.c(com.bytedance.android.live.core.utils.s1.B(2131915982), 0);
        return;
    L70:
        r114 = false;
        goto L71
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        DataCenter r4 = this.n;
        if (r4 == null) goto L5;
        r4.observe("linkmic_panel_dismiss", this);
    L5:
        DataCenter r5 = this.n;
        if (r5 == null) goto L8;
        r5.observe("linkmic_panel_open_play_mode_panel", this);
    L8:
        DataCenter r6 = this.n;
        if (r6 == null) goto L11;
        r6.observe("linkmic_panel_sub_panel_push", this);
    L11:
        DataCenter r7 = this.n;
        if (r7 == null) goto L15;
        r7.observe("linkmic_panel_sub_panel_pop", this);
    L15:
        if (StringsKt.isBlank(this.l) == false) goto L19;
        DataCenter r8 = this.n;
        if (r8 == null) goto L19;
        r8.observe("cmd_finish_video_talk_room_result", this);
    L19:
        DataCenter r9 = this.n;
        if (r9 == null) goto L23;
        r9.put("data_multi_link_setting_dialog_show", Boolean.TRUE);
        return;
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ALogger.i("SettingLynxContainerFragment", "onCreateView " + hashCode());
        this.g = r3.inflate(2131565634, r4, false);
        View r6 = LayoutInflater.from(getContext()).inflate(2131565653, null);
        if (r6 == null) goto L67;
        ViewGroup r7 = (ViewGroup) r6;
        this.h = r7;
        ((ImageView) r7.findViewById(2131363802)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new SettingLynxContainerFragment$initTopView$1(this)));
        if (this.m == false) goto L10;
        ViewGroup r8 = this.h;
        if (r8 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L9:
        UtilityKotlinExtentionsKt.w(r8.findViewById(2131363802));
    L15:
        if (r2.a(this.k) == false) goto L21;
        ViewGroup r9 = this.h;
        if (r9 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L19:
        ((TextView) r9.findViewById(2131388920)).setText(this.k);
    L62:
        aa0();
        View r10 = this.g;
        if (r10 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L65:
        return r10;
    L21:
        if (com.bytedance.android.live.liveinteract.linkpanel.util.o.m() == false) goto L23;
        com.bytedance.live.datacontext.j r11 = com.bytedance.android.live.liveinteract.api.utils.m.g(this.j).s();
        if (r11 == null) goto L49;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r12 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r11.getValue();
        if (r12 == null) goto L49;
        if (com.bytedance.android.livesdk.chatroom.viewmodel.g.b(r12) != true) goto L49;
        ViewGroup r13 = this.h;
        if (r13 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L47:
        ((TextView) r13.findViewById(2131388920)).setText(com.bytedance.android.live.core.utils.s1.B(2131917554));
    L49:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 10) goto L54;
        ViewGroup r14 = this.h;
        if (r14 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L53:
        ((TextView) r14.findViewById(2131388920)).setText(com.bytedance.android.live.core.utils.s1.B(2131918013));
        goto L62
    L54:
        ViewGroup r15 = this.h;
        if (r15 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L57:
        TextView r16 = (TextView) r15.findViewById(2131388920);
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L60;
        String r17 = com.bytedance.android.live.core.utils.s1.B(2131920011);
    L61:
        r16.setText(r17);
        goto L62
    L60:
        r17 = com.bytedance.android.live.core.utils.s1.B(2131917559);
        goto L61
    L23:
        if (((IInteractService) jc1.k.n(IInteractService.class)).dynamicFromAudience() == false) goto L29;
        ViewGroup r18 = this.h;
        if (r18 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L27:
        ((TextView) r18.findViewById(2131388920)).setText(2131920011);
        goto L62
    L29:
        if (((rj1) bc0.a.getValue()).a() != true) goto L34;
        ViewGroup r19 = this.h;
        if (r19 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L33:
        ((TextView) r19.findViewById(2131388920)).setText(2131920011);
        goto L62
    L34:
        ViewGroup r20 = this.h;
        if (r20 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L37:
        ((TextView) r20.findViewById(2131388920)).setText(2131918081);
        goto L62
    L10:
        ViewGroup r21 = this.h;
        if (r21 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L13:
        UtilityKotlinExtentionsKt.t(r21.findViewById(2131363802));
        goto L15
    L67:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
