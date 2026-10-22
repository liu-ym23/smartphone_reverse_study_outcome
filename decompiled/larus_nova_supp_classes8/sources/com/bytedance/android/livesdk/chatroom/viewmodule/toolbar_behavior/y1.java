package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.vs.model.VSRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class y1 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;

    public static final class a {
    }

    static {
    }

    public y1() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        Intrinsics.checkNotNullParameter(r11, "v");
        DataCenter r0 = this.a;
        if (r0 == null) goto L61;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L62;
        VSRoom r2 = r1.castToOrNull(VSRoom.class);
        if (r2 == null) goto L63;
        EpisodeExtraInfo r3 = r2.getEpisodeExtra();
        if (r3 == null) goto L64;
        String r4 = r3.getSelectionUrl();
        if (r4 == null) goto L67;
        DataCenter r5 = this.a;
        if (r5 == null) goto L65;
        fq1.c r6 = fq1.d.a();
        Context r12 = r11.getContext();
        int r7 = com.bytedance.android.livesdk.chatroom.utils.b5.a;
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        Intrinsics.checkNotNullParameter(r4, "selectionUrl");
        Uri r8 = UriProtector.parse(r4);
        if (Intrinsics.areEqual(r8.getScheme(), "http") == false) goto L18;
    L48:
        Uri.Builder r9 = UriProtector.parse("sslocal://webcast_webview?type=popup&hide_nav_bar=1&hide_status_bar=1&pull_down_close=0&gravity=bottom&radius=0").buildUpon();
        Uri r10 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().E(com.bytedance.android.livesdk.chatroom.utils.b5.b(r5, r8.buildUpon()), r5);
        if (r10 != null) goto L51;
        r10 = Uri.EMPTY;
    L51:
        r9.appendQueryParameter("url", r10.toString());
        r8 = com.bytedance.android.livesdk.chatroom.utils.b5.a(r5, r9);
    L52:
        r6.handleSchema(r12, r8);
        if (this.a == null) goto L66;
        com.bytedance.android.livesdk.log.j0.l().sendLog("episodes_list_click", null, new Object[]{am2.x.class, IRoom.class});
        return;
    L66:
        return;
    L18:
        if (Intrinsics.areEqual(r8.getScheme(), "https") == true) goto L48;
        String r13 = UriProtector.getQueryParameter(r8, "url");
        if (r13 == null) goto L52;
        Uri r14 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.i().E(com.bytedance.android.livesdk.chatroom.utils.b5.b(r5, UriProtector.parse(r13).buildUpon()), r5);
        if (r14 != null) goto L26;
        r14 = Uri.EMPTY;
    L26:
        String r15 = r14.toString();
        Intrinsics.checkNotNullParameter("url", "key");
        Set r16 = UriProtector.getQueryParameterNames(r8);
        if (r16 != null) goto L30;
    L39:
        if (r8 == null) goto L46;
        Uri.Builder r17 = r8.buildUpon();
        if (r17 == null) goto L46;
        Uri.Builder r18 = r17.appendQueryParameter("url", r15);
        if (r18 == null) goto L46;
        Uri r19 = r18.build();
        if (r19 == null) goto L46;
    L47:
        r8 = com.bytedance.android.livesdk.chatroom.utils.b5.a(r5, r19.buildUpon());
    L46:
        r19 = Uri.EMPTY;
        goto L47
    L30:
        if (r16.contains("url") == false) goto L39;
        Uri.Builder r20 = r8.buildUpon().clearQuery();
        Iterator r21 = r16.iterator();
    L34:
        if (r21.hasNext() == false) goto L38;
        String r22 = (String) r21.next();
        if ((!Intrinsics.areEqual(r22, "url")) == false) goto L34;
        r20.appendQueryParameter(r22, UriProtector.getQueryParameter(r8, r22));
        goto L34
    L38:
        r8 = r20.build();
        goto L39
    L65:
        return;
    L67:
        return;
    L64:
        return;
    L63:
        return;
    L62:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "center");
        this.a = r3;
        vr1.o r4 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.l();
        if (r4 == null) goto L8;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.l> r5 = r4.h(r3);
        if (r5 == null) goto L9;
        r5.c(SelectionToolbarBehaviorForVs$logSelectionShown$1.INSTANCE);
        return;
    L9:
        return;
    }
}
