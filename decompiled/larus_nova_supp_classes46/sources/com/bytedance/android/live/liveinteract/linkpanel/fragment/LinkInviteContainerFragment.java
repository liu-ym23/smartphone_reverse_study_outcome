package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.banner.BannerWidget;
import com.bytedance.android.live.liveinteract.linkpanel.contract.LinkPanelInviteContainerContract$View;
import com.bytedance.android.live.liveinteract.linkpanel.widget.LinkInviteListWidget;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.u61;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/LinkInviteContainerFragment;", "Lcom/bytedance/android/live/liveinteract/linkpanel/contract/LinkPanelInviteContainerContract$View;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkInviteContainerFragment extends LinkPanelInviteContainerContract$View implements Observer<KVData> {
    public static final /* synthetic */ int n = 0;
    public LinkInviteListWidget g;
    public WidgetManager h;
    public DataCenter i;
    public final Handler j;
    public int k;
    public String l;
    public boolean m;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final String W90() {
        return "";
    }

    public LinkInviteContainerFragment() {
        this.j = new Handler();
        this.k = -1;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.contract.InteractDialogFragmentBaseContract$View
    public final float T90() {
        float r0 = UtilityKotlinExtentionsKt.j(t6.c(com.bytedance.android.live.core.utils.s1.getContext()) * 1.2f);
        SimpleDateFormat r1 = com.bytedance.android.live.liveinteract.linkpanel.util.o.a;
        return r0 - 48;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.j.removeCallbacksAndMessages(null);
        DataCenter r0 = this.i;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        t61 r1 = com.bytedance.android.live.liveinteract.linkpanel.util.z.a();
        if (r1 != null) goto L8;
        return;
    L8:
        if (u61.c(r1) != true) goto L18;
        WidgetManager r2 = this.h;
        if (r2 == null) goto L12;
        r2.unload(this.g);
    L12:
        WidgetManager r3 = this.h;
        if (r3 == null) goto L15;
        r3.contentView = null;
    L15:
        this.h = null;
        this.g = null;
        this.d = null;
        return;
    }

    public final void onChanged(Object r3) {
        KVData r4 = (KVData) r3;
        if (r4 == null) goto L23;
        String r5 = r4.getKey();
        if (r5.hashCode() == (-821254260)) goto L9;
        return;
    L9:
        if (r5.equals("data_audio_talk_show_invite_list_or_search") == false) goto L19;
        LinkInviteListWidget r6 = this.g;
        if (r6 == null) goto L20;
        FragmentActivity r0 = getContext();
        if (r0 == null) goto L18;
        WidgetManager r1 = WidgetManager.of(r0, getView());
        this.h = r1;
        if (r1 == null) goto L21;
        r1.load(2131375598, r6);
        return;
    L21:
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L20:
        return;
    L19:
        return;
    }

    public final void setUserVisibleHint(boolean r3) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r3);
        LinkInviteListWidget r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isViewValid() != true) goto L20;
        LinkInviteListWidget r1 = this.g;
        if (r1 == null) goto L21;
        r1.o = r1.o;
        RecyclerView r2 = r1.g;
        if (r2 == null) goto L11;
        r2.setNestedScrollingEnabled(r3);
    L11:
        RecyclerView r4 = r1.g;
        if (r4 == null) goto L14;
        r4.requestLayout();
    L14:
        if (r3 == false) goto L22;
        BannerWidget r5 = r1.F;
        if (r5 == null) goto L23;
        r5.wq();
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        yf0.g r6 = this.d;
        if (r6 != null) goto L6;
        int r7 = com.bytedance.android.live.liveinteract.plantform.utils.x.a;
        Intrinsics.checkNotNullParameter("LinkPanelInviteContainerFragment", "fragment");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("fragment", "LinkPanelInviteContainerFragment");
        com.bytedance.android.live.liveinteract.plantform.utils.x.t0("talk_room_invite_dialog_is_null", r0);
        return;
    L6:
        int r8 = LinkInviteListWidget.R;
        DataCenter r9 = this.i;
        int r1 = this.k;
        String r2 = this.l;
        Intrinsics.checkNotNullParameter(r6, "view");
        LinkInviteListWidget r3 = new LinkInviteListWidget();
        r3.a = r6;
        r3.K = r9;
        r3.L = r1;
        r3.E = true;
        r3.r = r2;
        this.g = r3;
        r3.s = this.m;
        r3.Eq();
        DataCenter r10 = this.i;
        if (r10 == null) goto L9;
        r10.observe("data_audio_talk_show_invite_list_or_search", this);
    L9:
        DataCenter r11 = this.i;
        if (r11 == null) goto L13;
        r11.put("data_audio_talk_show_invite_list_or_search", Boolean.FALSE);
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131565540, r3, false);
    }
}
