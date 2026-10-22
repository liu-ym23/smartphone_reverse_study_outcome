package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.contract.VideoTalkDialogContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.util.OpenPanelSource;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/MultiLinkIntegrationPlayMethodFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/VideoTalkDialogContract$View;", "<init>", "()V", "a", "b", "VideoTalkPlayMethodItemViewHolder", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkIntegrationPlayMethodFragment extends VideoTalkDialogContract$View {
    public static final /* synthetic */ int q = 0;
    public View g;
    public ViewGroup h;
    public IRoom i;
    public DataCenter j;
    public List<? extends com.bytedance.android.livesdk.chatroom.model.k1> k;
    public String l;
    public int m;
    public boolean n;
    public final CompositeDisposable o;
    public final MultiTypeAdapter p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/MultiLinkIntegrationPlayMethodFragment$VideoTalkPlayMethodItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class VideoTalkPlayMethodItemViewHolder extends RecyclerView.ViewHolder {
        public final Lazy a;
        public final Lazy b;
        public final Lazy c;
        public final Lazy d;
        public final Lazy e;
        public com.bytedance.android.livesdk.chatroom.model.k1 f;
        public final /* synthetic */ MultiLinkIntegrationPlayMethodFragment g;

        public VideoTalkPlayMethodItemViewHolder(MultiLinkIntegrationPlayMethodFragment r2, final View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.g = r2;
            super(r3);
            this.a = LazyKt.lazy(new MultiLinkIntegrationPlayMethodFragment$VideoTalkPlayMethodItemViewHolder$clItem$2(r3));
            this.b = LazyKt.lazy(new MultiLinkIntegrationPlayMethodFragment$VideoTalkPlayMethodItemViewHolder$ivIcon$2(r3));
            this.c = LazyKt.lazy(new MultiLinkIntegrationPlayMethodFragment$VideoTalkPlayMethodItemViewHolder$tvName$2(r3));
            this.d = LazyKt.lazy(new MultiLinkIntegrationPlayMethodFragment$VideoTalkPlayMethodItemViewHolder$tvDes$2(r3));
            this.e = LazyKt.lazy(new MultiLinkIntegrationPlayMethodFragment$VideoTalkPlayMethodItemViewHolder$ivRedDot$2(r3));
        }
    }

    public static final class a {
        public static MultiLinkIntegrationPlayMethodFragment a(yf0.g r1, IRoom r2, DataCenter r3, List r4, String r5, int r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            Intrinsics.checkNotNullParameter(r2, PbRequest.SwitchType.ROOM);
            Intrinsics.checkNotNullParameter(r3, "dataCenter");
            MultiLinkIntegrationPlayMethodFragment r0 = new MultiLinkIntegrationPlayMethodFragment();
            r0.d = r1;
            IRoom r8 = jm2.a.d((vh7.c) r2);
            if (r8 == null) goto L10;
            IRoom r9 = r8;
            Intrinsics.checkNotNullParameter(r9, "<set-?>");
            r0.i = r9;
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.j = r3;
            if (r4 != null) goto L7;
            r4 = new ArrayList();
        L7:
            r0.k = r4;
            r0.l = r5;
            r0.m = r6;
            r0.n = r7;
            return r0;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.IRoom");
        }
    }

    public final class b extends me.drakeet.multitype.b<com.bytedance.android.livesdk.chatroom.model.k1, VideoTalkPlayMethodItemViewHolder> {
        public final /* synthetic */ MultiLinkIntegrationPlayMethodFragment b;

        public b(MultiLinkIntegrationPlayMethodFragment r1) {
            this.b = r1;
        }

        public final void e(RecyclerView.ViewHolder r8) {
            VideoTalkPlayMethodItemViewHolder r9 = (VideoTalkPlayMethodItemViewHolder) r8;
            Intrinsics.checkNotNullParameter(r9, "holder");
            com.bytedance.android.livesdk.chatroom.model.k1 r0 = r9.f;
            if (r0 == null) goto L27;
            int r1 = r0.getType();
            String r2 = OpenPanelSource.LINK_INTERACT_PANEL_TAB.getValue();
            com.bytedance.android.live.liveinteract.linkpanel.util.m.t(r1, r2);
            if (r1 != 2) goto L8;
            com.bytedance.android.live.liveinteract.linkpanel.util.m.x(r2);
        L19:
            if (r1 != 1) goto L21;
            com.bytedance.android.live.liveinteract.linkpanel.util.m.u("link_interact_panel_tab");
        L21:
            com.bytedance.android.livesdk.chatroom.model.k1 r3 = r9.f;
            if (r3 != null) goto L24;
        L25:
            com.bytedance.android.livesdk.chatroom.model.k1 r10 = r9.f;
            Intrinsics.checkNotNull(r10);
            com.bytedance.android.live.liveinteract.linkpanel.util.m.o(r10);
            return;
        L24:
            if (r3.getGameDataType() != 0) goto L25;
            return;
        L8:
            if (r1 != 7) goto L11;
            com.bytedance.android.live.liveinteract.linkpanel.util.m.w(r2);
            goto L19
        L11:
            if (r1 != 12) goto L19;
            LinkedHashMap r4 = new LinkedHashMap();
            r4.put("request_page", "link_panel");
            r4.put("function_type", com.bytedance.android.live.liveinteract.linkpanel.util.m.a());
            IMiddlewareUserService r5 = jc1.k.f(IMiddlewareUserService.class);
            if (r5 == null) goto L17;
            com.bytedance.android.livesdk.user.e r6 = r5.user();
            if (r6 == null) goto L17;
            String r7 = r6.n();
        L18:
            r4.put("user_id", String.valueOf(r7));
            r4.put("user_type", "anchor");
            com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_room_meetgame_icon_show", r4, new Object[]{IRoom.class});
        L17:
            r7 = null;
            goto L18
        }

        public final void b(RecyclerView.ViewHolder r5, Object r6) {
            VideoTalkPlayMethodItemViewHolder r7 = (VideoTalkPlayMethodItemViewHolder) r5;
            com.bytedance.android.livesdk.chatroom.model.k1 r8 = (com.bytedance.android.livesdk.chatroom.model.k1) r6;
            Intrinsics.checkNotNullParameter(r7, "holder");
            Intrinsics.checkNotNullParameter(r8, "item");
            r7.getClass();
            Intrinsics.checkNotNullParameter(r8, "item");
            r7.f = r8;
            ((TextView) r7.c.getValue()).setText(r8.getTitle().toString());
            ((TextView) r7.d.getValue()).setText(r8.getDesc().toString());
            View r0 = (View) r7.e.getValue();
            Set<Integer> r1 = com.bytedance.android.live.liveinteract.linkpanel.util.h.a;
            int r2 = r8.getType();
            if (com.bytedance.android.live.liveinteract.linkpanel.util.h.b.contains(Integer.valueOf(r2)) == true) goto L5;
        L7:
            boolean r3 = false;
        L8:
            if (r3 == false) goto L10;
            int r4 = 0;
        L11:
            r0.setVisibility(r4);
            py.k r9 = r8.getIcon();
            if (r9 == null) goto L18;
            List r10 = r9.getUrls();
            if (r10 == null) goto L18;
            String r11 = (String) ListProtector.get(r10, 0);
            if (r11 == null) goto L18;
            FrescoLoader.with(((RecyclerView.ViewHolder) r7).itemView.getContext()).load(r11).into((HSImageView) r7.b.getValue());
        L18:
            ((ViewGroup) r7.a.getValue()).setOnClickListener(new f0(r7, r8));
            return;
        L10:
            r4 = 8;
            goto L11
        L5:
            if (com.bytedance.android.live.liveinteract.linkpanel.util.h.a.contains(Integer.valueOf(r2)) == true) goto L7;
            r3 = true;
            goto L8
        }

        public final RecyclerView.ViewHolder d(LayoutInflater r5, ViewGroup r6) {
            Intrinsics.checkNotNullParameter(r5, "inflater");
            Intrinsics.checkNotNullParameter(r6, "parent");
            return new VideoTalkPlayMethodItemViewHolder(this.b, r5.inflate(2131566314, r6, false));
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
    public final ViewGroup X90() {
        ViewGroup r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L5:
        return r0;
    }

    public MultiLinkIntegrationPlayMethodFragment() {
        this.o = new CompositeDisposable();
        this.p = new MultiTypeAdapter();
    }

    public final void onDetach() {
        super/*androidx.fragment.app.Fragment*/.onDetach();
        this.o.dispose();
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        this.g = r7.inflate(2131565549, r8, false);
        View r10 = LayoutInflater.from(getContext()).inflate(2131565653, null);
        if (r10 == null) goto L40;
        ViewGroup r11 = (ViewGroup) r10;
        this.h = r11;
        ((ImageView) r11.findViewById(2131363802)).setOnClickListener(com.bytedance.android.livesdk.utils.x0.a(new MultiLinkIntegrationPlayMethodFragment$initTopView$1(this)));
        ViewGroup r12 = this.h;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L7:
        ((TextView) r12.findViewById(2131388920)).setText(com.bytedance.android.live.core.utils.s1.B(2131917705));
        View r13 = this.g;
        if (r13 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L10:
        UtilityKotlinExtentionsKt.t(r13.findViewById(2131391413));
        if (this.n == false) goto L16;
        ViewGroup r14 = this.h;
        if (r14 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L15:
        UtilityKotlinExtentionsKt.w(r14.findViewById(2131363802));
    L20:
        View r15 = this.g;
        if (r15 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L23:
        r15.findViewById(2131384988).setLayoutManager(new SSLinearLayoutManager(getContext(), 1));
        this.p.z2(com.bytedance.android.livesdk.chatroom.model.k1.class, new b(this));
        View r16 = this.g;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L26:
        r16.findViewById(2131384988).setAdapter(this.p);
        View r17 = this.g;
        if (r17 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L29:
        r17.findViewById(2131384988).setNestedScrollingEnabled(true);
        MultiTypeAdapter r18 = this.p;
        List<? extends com.bytedance.android.livesdk.chatroom.model.k1> r19 = this.k;
        Intrinsics.checkNotNull(r19);
        r18.a = r19;
        String r20 = this.l;
        if (r20 != null) goto L33;
        r20 = OpenPanelSource.LINK_INTERACT_PANEL_TAB.getValue();
    L33:
        if (((IInteractService) jc1.k.n(IInteractService.class)).getLinkPanelTransitService() == null) goto L35;
        Intrinsics.checkNotNullParameter(r20, "switchSceneSource");
        com.bytedance.android.live.liveinteract.plantform.utils.i0 r21 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.o1(r20);
        Intrinsics.checkNotNullParameter("Link_panel", "requestPage");
        Intrinsics.checkNotNullParameter(r20, "source");
        LinkedHashMap r3 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r3);
        TalkRoomLogUtils.B0(r3, null, null, 6);
        TalkRoomLogUtils.V0(r3);
        r3.put("request_page", "Link_panel");
        r3.put("source", r20);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_link_interact_playmode_panel_show", r3, new Object[]{IRoom.class});
    L35:
        View r22 = this.g;
        if (r22 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
    L38:
        return r22;
    L16:
        ViewGroup r23 = this.h;
        if (r23 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mTopView");
    L19:
        UtilityKotlinExtentionsKt.t(r23.findViewById(2131363802));
        goto L20
    L40:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
