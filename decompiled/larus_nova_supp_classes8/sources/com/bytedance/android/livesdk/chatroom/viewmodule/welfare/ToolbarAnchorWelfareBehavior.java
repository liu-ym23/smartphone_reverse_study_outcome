package com.bytedance.android.livesdk.chatroom.viewmodule.welfare;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.broadcast.api.model.WelfarePermissionInfo;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBroadcastFunction;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.BottomToolbarViewModel;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.p2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.WelfareAppLogger;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/welfare/ToolbarAnchorWelfareBehavior;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/c0$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToolbarAnchorWelfareBehavior implements c0.b, Observer<KVData> {
    public WelfarePermissionInfo a;
    public Context b;
    public RoomContext c;
    public DataCenter d;
    public final boolean e;

    public static final class a implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i {
        public final /* synthetic */ ToolbarAnchorWelfareBehavior a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
        public final /* synthetic */ void a() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
        public final /* synthetic */ void onCancelClick() {
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
        public final void onConfirmClick() {
        }

        public a(ToolbarAnchorWelfareBehavior r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.i
        public final void b(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r2, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "from");
            Intrinsics.checkNotNullParameter(r3, "to");
            if (r4 == false) goto L6;
            ToolbarAnchorWelfareBehavior r5 = this.a;
            r5.b(r5.a);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
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

    public ToolbarAnchorWelfareBehavior(boolean r1) {
        this.e = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
        WelfareAppLogger.h();
    }

    public final void a(p2 r2) {
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L6;
        return;
    L6:
        if (r2.i() == 1) goto L8;
        y3.f(this.d).i(ToolbarButton.WELFARE_FOLD.extended());
        return;
    L8:
        y3.f(this.d).c(ToolbarButton.WELFARE_FOLD.extended());
        WelfareAppLogger.h();
    }

    public final void b(WelfarePermissionInfo r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.available == true) goto L6;
        return;
    L6:
        if (yt2.b.a().booleanValue() == false) goto L60;
        String r0 = r8.settingPageUrl;
        boolean r2 = false;
        if (r0 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == true) goto L61;
        Uri r9 = UriProtector.parse(WelfareAppLogger.b(r8.settingPageUrl));
        String r3 = UriProtector.getQueryParameter(r9, "url");
        if (r3 != null) goto L18;
    L19:
        r2 = true;
    L20:
        if (r2 == true) goto L49;
        Uri.Builder r4 = UriProtector.parse(r3).buildUpon().appendQueryParameter("is_living", "1");
        RoomContext r5 = this.c;
        if (r5 == null) goto L26;
        com.bytedance.live.datacontext.i r6 = r5.getLiveMode();
        if (r6 == null) goto L26;
        LiveMode r7 = (LiveMode) r6.getValue();
    L27:
        if (r7 == null) goto L37;
        int r10 = com.bytedance.android.livesdk.chatroom.viewmodule.welfare.utils.a.a[r7.ordinal()];
        if (r10 != 1) goto L32;
        String r11 = "video_live";
    L42:
        String r12 = r4.appendQueryParameter("live_type", r11).build().toString();
        Uri.Builder r13 = r9.buildUpon().clearQuery();
        Iterator r14 = UriProtector.getQueryParameterNames(r9).iterator();
    L44:
        if (r14.hasNext() == false) goto L48;
        String r15 = (String) r14.next();
        if ((!Intrinsics.areEqual(r15, "url")) == false) goto L44;
        r13.appendQueryParameter(r15, UriProtector.getQueryParameter(r9, r15));
        goto L44
    L48:
        r13.appendQueryParameter("url", r12);
        r9 = r13.build();
        goto L49
    L32:
        if (r10 != 2) goto L34;
        r11 = "media";
        goto L42
    L34:
        if (r10 != 3) goto L36;
        r11 = "voice_live";
        goto L42
    L36:
        if (r10 != 4) goto L37;
        r11 = "game";
    L37:
        r11 = "";
    L26:
        r7 = null;
    L49:
        ILiveActionHandler r16 = jc1.k.f(ILiveActionHandler.class);
        if (r16 == null) goto L62;
        r16.handle(this.b, r9);
        return;
    L62:
        return;
    L18:
        if (r3.length() != 0) goto L20;
    L61:
        return;
    L10:
        if (r0.length() == 0) goto L13;
        r1 = false;
        goto L14
    }

    public final void c(View r9) {
        Context r10 = this.b;
        if (r10 != null) goto L5;
        return;
    L5:
        RoomContext r0 = this.c;
        if (r0 != null) goto L8;
        return;
    L8:
        long r2 = ((Room) r0.getRoom().getValue()).getRoomId();
        final ToolbarBroadcastFunction r5 = ToolbarBroadcastFunction.WELFARE;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L14;
        BottomToolbarViewModel.a r1 = BottomToolbarViewModel.Companion;
        DataCenter r3 = this.d;
        r1.getClass();
        BottomToolbarViewModel r4 = BottomToolbarViewModel.a.a(r3);
        if (r4 == null) goto L46;
        r4.openChangeDialog(r10, r2, r5, new a(this));
        return;
    L46:
        return;
    L14:
        p2 r6 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.d);
        if (r6.h() != 1) goto L18;
        ToolbarBroadcastFunction r7 = ToolbarBroadcastFunction.TRANSFORM_WIDGET;
    L41:
        ToolbarBroadcastFunction r8 = r7;
    L42:
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.e(r10, r6, r2, r8, r5, new ToolbarAnchorWelfareBehavior$showReplaceDialog$2(this), new ToolbarAnchorWelfareBehavior$showReplaceDialog$3(this, r5));
        return;
    L18:
        if (r6.f() != 1) goto L21;
        r7 = ToolbarBroadcastFunction.MINI_APP;
        goto L41
    L21:
        if (r6.b() != 1) goto L24;
        r7 = ToolbarBroadcastFunction.COMMERCE;
        goto L41
    L24:
        if (r6.c() != 1) goto L27;
        r7 = ToolbarBroadcastFunction.GAME_PROMOTE;
        goto L41
    L27:
        if (r6.j() != 1) goto L30;
        r8 = r5;
        goto L42
    L30:
        if (r6.d() != 1) goto L33;
        r7 = ToolbarBroadcastFunction.GROUP_PURCHASE;
        goto L41
    L33:
        if (r6.e() != 1) goto L36;
        r7 = ToolbarBroadcastFunction.MIX_MINI_APP;
        goto L41
    L36:
        if (r6.g() != 1) goto L38;
        r7 = ToolbarBroadcastFunction.MINI_GAME;
        goto L41
    L38:
        boolean r11 = tb1.c.a;
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L45;
        r7 = ToolbarBroadcastFunction.TRANSFORM_WIDGET;
        goto L41
    L45:
        throw new IllegalStateException("cant has other button unfold");
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L16;
        String r0 = r5.getKey();
        if (r0.hashCode() == 919040494) goto L9;
        return;
    L9:
        if (r0.equals("data_live_mini_app_commerce_status") == false) goto L15;
        p2 r6 = (p2) r5.getData();
        if (r6 == null) goto L18;
        a(r6);
        return;
    L18:
        return;
    L15:
        return;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        WelfareAppLogger.g();
        WelfarePermissionInfo r0 = this.a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.available == true) goto L10;
        return;
    L10:
        if (this.e == true) goto L12;
        b(r0);
        return;
    L12:
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L15;
        c(r3);
        return;
    L15:
        boolean r1 = true;
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(this.d).i() == 1) goto L19;
        r1 = false;
    L19:
        if (r1 == false) goto L24;
        c(r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r5, DataCenter r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "dataCenter");
        this.d = r6;
        this.c = RoomContext.a.c(RoomContext.Companion, r6, 0, 2);
        this.b = r5.getContext();
        this.a = (WelfarePermissionInfo) r6.get("data_welfare_permission_info");
        if (this.e == false) goto L5;
        r6.observe("data_live_mini_app_commerce_status", this);
        a(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior.utils.n.a(r6));
    L5:
        yt2.b.b("ToolbarAnchorWelfareBehavior onLoad, fold: " + this.e);
    }
}
