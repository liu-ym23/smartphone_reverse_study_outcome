package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.wm0;
import com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService;
import com.bytedance.android.livesdkapi.business.OnLiveRenQiBaoDialogListener;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q4 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.n {
    public static final /* synthetic */ int e = 0;
    public Dialog a;
    public Disposable b;
    public final Context c;
    public DataCenter d;

    public static final class a {
        public static void b(DataCenter r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(r2).i(ToolbarButton.REN_QI_BAO.extended());
            r2.put("data_ren_qi_bao_button_dismiss", Boolean.TRUE);
        }

        public static void a(int r2, String r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "entranceType");
            Intrinsics.checkNotNullParameter(r4, "errorStatus");
            Intrinsics.checkNotNullParameter(r5, "errorMessage");
            JSONObject r0 = new JSONObject();
            r0.put("entrance_type", r3);     // Catch: Exception -> L7
            if (r2 != 0) goto L9;
            r0.put("error_status", r4);     // Catch: Exception -> L7
            r0.put("error_message", r5);     // Catch: Exception -> L7
        L9:
            jc1.k.n(ILiveRenQiBaoService.class).renQiBaoMonitor("renqibao_live_entry", r2, r0);
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            goto L9
        }
    }

    public static final class b implements OnLiveRenQiBaoDialogListener {
        public final /* synthetic */ q4 a;

        public final void onDismiss() {
            q4 r0 = this.a;
            Disposable r1 = null;
            r0.a = null;
            Disposable r2 = r0.b;
            if (r2 != null) goto L5;
        L9:
            DataCenter r3 = this.a.d;
            if (r3 == null) goto L13;
            r3.put("data_ren_qi_bao_dialog_showing", Boolean.FALSE);
            return;
        L13:
            return;
        L5:
            if ((!r2.isDisposed()) == false) goto L7;
            r1 = r2;
        L7:
            if (r1 == null) goto L9;
            r1.dispose();
            goto L9
        }

        public final void onShow() {
            q4 r0 = this.a;
            r0.getClass();
            r0.b = xs2.b.a().b(zg1.n2.class).subscribe(new r4(r0));
            DataCenter r1 = this.a.d;
            if (r1 == null) goto L6;
            r1.put("data_ren_qi_bao_dialog_showing", Boolean.TRUE);
            return;
        }

        public b(q4 r1) {
            this.a = r1;
        }
    }

    static {
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
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.n
    public final void onShow() {
        a("livesdk_show_popular_treasure");
        DataCenter r0 = this.d;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        int r2 = com.bytedance.android.livesdk.config.setting.t.a;
        if ((!r1) == false) goto L19;
        DataCenter r3 = this.d;
        if (r3 == null) goto L12;
        Boolean r4 = (Boolean) r3.get("data_is_anchor", Boolean.FALSE);
    L14:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L16;
        String r5 = "tool_panel";
    L17:
        a.a(1, r5, "", "");
        return;
    L16:
        r5 = "share_panel";
        goto L17
    L12:
        r4 = null;
        goto L14
    L19:
        return;
    L5:
        if (com.bytedance.android.live.core.utils.z.e(r0, false) != true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        String r0 = com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        int r1 = com.bytedance.android.livesdk.utils.n5.a;
        Intrinsics.checkNotNullParameter(r0, "key");
        return !((Boolean) new com.bytedance.android.livesdk.sharedpref.e("has_enter_ren_qi_bao_entry_" + r0, Boolean.FALSE).getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.f;
    }

    public final void a(String r8) {
        com.bytedance.android.livesdk.log.g r0 = com.bytedance.android.livesdk.log.u.l();
        HashMap r1 = new HashMap();
        if (com.bytedance.android.live.core.utils.z.e(this.d, false) == false) goto L5;
        String r2 = "tool_panel";
    L6:
        r1.put("entrance_type", r2);
        DataCenter r3 = this.d;
        String r4 = "0";
        if (r3 == null) goto L12;
        Room r5 = com.bytedance.android.live.core.utils.z.o(r3);
        if (r5 == null) goto L12;
        String r6 = String.valueOf(r5.id);
        if (r6 == null) goto L12;
    L13:
        r1.put("room_id", r6);
        DataCenter r7 = this.d;
        if (r7 == null) goto L23;
        Room r9 = com.bytedance.android.live.core.utils.z.o(r7);
        if (r9 == null) goto L23;
        IUser r10 = r9.author();
        if (r10 == null) goto L23;
        String r11 = r10.getIdString();
        if (r11 == null) goto L23;
        r4 = r11;
    L23:
        r1.put("anchor_id", r4);
        if (com.bytedance.android.live.core.utils.z.e(this.d, false) == false) goto L26;
        String r12 = "my_group";
    L27:
        r1.put("serving_type", r12);
        r1.put("enter_from", "live");
        r0.sendLog(r8, r1, new Object[0]);
        return;
    L26:
        r12 = "other_group";
    L12:
        r6 = "0";
        goto L13
    L5:
        r2 = "share_panel";
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        String r12 = com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IUserService.class).user().b());
        int r0 = com.bytedance.android.livesdk.utils.n5.a;
        Intrinsics.checkNotNullParameter(r12, "key");
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("has_enter_ren_qi_bao_entry_" + r12, Boolean.FALSE), Boolean.TRUE);
        DataCenter r13 = this.d;
        if (r13 != null) goto L5;
        return;
    L5:
        Boolean r1 = null;
        Room r14 = (Room) r13.get("data_room", null);
        if (r14 != null) goto L8;
        return;
    L8:
        IUser r2 = jc1.k.n(IUserService.class).user().b();
        DataCenter r3 = this.d;
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (r2.getSecret() != 1) goto L19;
        if (r4 == false) goto L19;
        com.bytedance.android.live.core.utils.f2.b(2131915440, 0);
        return;
    L19:
        HashMap r5 = new HashMap();
        r5.put("is_live", "1");
        r5.put("scene", "dou_plus");
        IUser r6 = r14.author();
        if (r6 == null) goto L23;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r7 = r6.getCastSecUid();
        if (r7 == null) goto L23;
    L24:
        r5.put("sec_anchor_id", r7);
        DataCenter r8 = this.d;
        if (r8 == null) goto L27;
        LiveMode r9 = com.bytedance.android.live.core.utils.z.c(r8);
    L28:
        int r10 = com.bytedance.android.live.core.utils.h1.a;
        r5.put("live_type", com.bytedance.android.live.core.utils.i1.a(r9));
        Uri.Builder r15 = UriProtector.parse(wm0.a.getValue().d()).buildUpon();
        if (r4 == false) goto L31;
        String r16 = "tool_panel";
    L32:
        Uri.Builder r17 = r15.appendQueryParameter("entrance_type", r16).appendQueryParameter("enter_from", "live");
        if (r4 == false) goto L35;
        String r18 = "my_group";
    L36:
        Uri.Builder r19 = r17.appendQueryParameter("serving_type", r18).appendQueryParameter("font_scale", String.valueOf(1.0d));
        IUser r20 = r14.author();
        if (r20 == null) goto L39;
        Intrinsics.checkNotNullParameter(r20, "$this$secUidExt");
        String r21 = r20.getCastSecUid();
    L40:
        Uri.Builder r22 = r19.appendQueryParameter("sec_anchor_id", r21).appendQueryParameter("room_id", r14.getIdStr());
        RoomAuthStatus r110 = r14.getRoomAuthStatus();
        if (r110 == null) goto L43;
        r1 = Boolean.valueOf(r110.getEnableUserCard());
    L43:
        r22.appendQueryParameter("encrypt_audience", String.valueOf(!r1.booleanValue()));
        this.a = jc1.k.n(ILiveRenQiBaoService.class).showRenQiBaoDialog(this.c, r5, r15.toString(), new b(this));
        a("livesdk_click_popular_treasure");
        return;
    L39:
        r21 = null;
        goto L40
    L35:
        r18 = "other_group";
        goto L36
    L31:
        r16 = "share_panel";
        goto L32
    L27:
        r9 = null;
    L23:
        r7 = "";
        goto L24
    L11:
        if (com.bytedance.android.live.core.utils.z.e(r3, false) != true) goto L13;
        r4 = true;
        goto L15
    }

    public q4(Context r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.d = r3;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        if (this.d != null) goto L6;
        this.d = r3;
        return;
    }
}
