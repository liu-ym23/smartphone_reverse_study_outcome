package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.ui.RedDotView;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.config.vy;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c3 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public DataCenter a;
    public boolean b;

    public c3() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
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

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        Boolean r1 = Boolean.FALSE;
        return Intrinsics.areEqual((Boolean) new com.bytedance.android.livesdk.sharedpref.e("toolbar_gift_consumer_shown", r1).getValue(), r1);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.v;
    }

    public final Map<String, String> a(DataCenter r13) {
        LinkedHashMap r7 = new LinkedHashMap();
        if (r13 != null) goto L47;
    L45:
        return r7;
    L47:
        JSONObject r8 = new JSONObject((String) r13.get("log_enter_params", ""));     // Catch: Exception -> L46
        String r14 = r8.optString("enter_from_merge", "");     // Catch: Exception -> L46
        boolean r10 = true;
        if (r14.length() <= 0) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == false) goto L10;
        r7.put("enter_from_merge", r14);     // Catch: Exception -> L46
    L10:
        String r15 = r8.optString("enter_method", "");     // Catch: Exception -> L46
        if (r15.length() <= 0) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        r7.put("enter_method", r15);     // Catch: Exception -> L46
    L16:
        String r16 = r8.optString("action_type", "");     // Catch: Exception -> L46
        if (r16.length() <= 0) goto L19;
        boolean r4 = true;
    L20:
        if (r4 == false) goto L22;
        r7.put("action_type", r16);     // Catch: Exception -> L46
    L22:
        String r17 = r8.optString("request_id", "");     // Catch: Exception -> L46
        if (r17.length() <= 0) goto L25;
        boolean r3 = true;
    L26:
        if (r3 == false) goto L28;
        r7.put("request_id", r17);     // Catch: Exception -> L46
    L28:
        String r18 = r8.optString("room_id", "");     // Catch: Exception -> L46
        if (r18.length() <= 0) goto L31;
        boolean r2 = true;
    L32:
        if (r2 == false) goto L34;
        r7.put("room_id", r18);     // Catch: Exception -> L46
    L34:
        String r19 = r8.optString("anchor_id", "");     // Catch: Exception -> L46
        if (r19.length() > 0) goto L38;
        r10 = false;
    L38:
        if (r10 == false) goto L41;
        r7.put("anchor_id", r19);     // Catch: Exception -> L46
    L41:
        if (this.b == false) goto L43;
        String r0 = "是";
    L44:
        r7.put("whether_mark", r0);     // Catch: Exception -> L46
        goto L45
    L43:
        r0 = "否";
        goto L44
    L31:
        r2 = false;
        goto L32
    L25:
        r3 = false;
        goto L26
    L19:
        r4 = false;
        goto L20
    L13:
        r5 = false;
        goto L14
    L7:
        r9 = false;
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (jc1.k.n(IUserService.class).user().isLogin() == true) goto L12;
        IUserService r5 = jc1.k.f(IUserService.class);
        if (r5 == null) goto L28;
        com.bytedance.android.livesdk.user.f r6 = r5.user();
        if (r6 == null) goto L29;
        Activity r0 = com.bytedance.android.live.core.utils.a.d();
        com.bytedance.android.livesdk.user.l.a r1 = new com.bytedance.android.livesdk.user.l.a();
        r1.a = com.bytedance.android.live.core.utils.s1.B(2131915990);
        r1.c = -1;
        r1.e = "live_detail";
        r1.g = "consume_notice";
        r1.d = "popup";
        Observable r7 = r6.login(r0, new com.bytedance.android.livesdk.user.l(r1));
        if (r7 == null) goto L30;
        r7.subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L12:
        com.bytedance.android.livesdk.sharedpref.f.d(new com.bytedance.android.livesdk.sharedpref.e("toolbar_gift_consumer_shown", Boolean.FALSE), Boolean.TRUE);
        u6 r2 = new u6(vy.a.getValue().getLynxSchema());
        if (pm1.f.d(this.a) == null) goto L20;
        if (PadConfigUtils.c() == false) goto L20;
        if (com.bytedance.android.livesdk.utils.e5.n() == false) goto L20;
        Intrinsics.checkNotNullParameter("rate_height", "key");
        r2.a.remove("rate_height");
        r2.b("horizontal_height_percent", String.valueOf(67));
        r2.b("landscape_custom_height", "1");
    L20:
        if (pm1.f.d(this.a) == null) goto L22;
        r2.b("use_anim_in_landscape", "true");
    L22:
        ILiveActionHandler r3 = jc1.k.n(IRoomService.class).actionHandler();
        if (r4 == null) goto L25;
        Context r8 = r4.getContext();
    L26:
        r3.handle(r8, r2.toString());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_consume_limit_button_click", a(this.a), new Object[0]);
        return;
    L25:
        r8 = null;
        goto L26
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.a = null;
        this.b = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.a = r4;
        View r5 = r3.findViewById(2131384095);
        if ((r5 instanceof RedDotView) == false) goto L5;
        boolean r6 = ((RedDotView) r5).j();
    L10:
        this.b = r6;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_consume_limit_button_show", a(r4), new Object[0]);
        return;
    L5:
        if (r5 != 0) goto L7;
    L9:
        r6 = false;
        goto L10
    L7:
        if (r5.getVisibility() != 0) goto L9;
        r6 = true;
        goto L10
    }
}
