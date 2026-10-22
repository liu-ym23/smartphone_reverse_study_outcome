package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.plantform.api.LinkAudienceApi;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.model.LinkmicAudienceSetting;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ToolbarShakeMatchBehavior implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b {
    public boolean a;
    public final CompositeDisposable b;
    public View c;
    public ImageView d;
    public boolean e;
    public DataCenter f;

    public static final class a {
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

    public final void a() {
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.a(this.f) == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L18;
        if (this.e == false) goto L14;
        View r1 = this.c;
        if (r1 == null) goto L26;
        r1.setBackgroundResource(2131251483);
        return;
    L26:
        return;
    L14:
        View r2 = this.c;
        if (r2 == null) goto L28;
        r2.setBackgroundResource(2131251481);
        return;
    L28:
        return;
    L18:
        if (this.e == false) goto L22;
        View r3 = this.c;
        if (r3 == null) goto L30;
        r3.setBackgroundResource(2131251482);
        return;
    L30:
        return;
    L22:
        View r4 = this.c;
        if (r4 == null) goto L32;
        r4.setBackgroundResource(2131251480);
        return;
    L32:
        return;
    L5:
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.u.getValue()).booleanValue();
    }

    public ToolbarShakeMatchBehavior() {
        this.b = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.y;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (this.a == true) goto L25;
        this.a = true;
        com.bytedance.android.livesdk.sharedpref.e r8 = com.bytedance.android.livesdk.sharedpref.b.u;
        Boolean r0 = Boolean.FALSE;
        r8.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r8, r0);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.f).b(ToolbarButton.MORE, new pp1.j(false));
        Function2<Boolean, CustomApiServerException, Unit> r9 = new AnonymousClass1(this);
        JSONArray r1 = new JSONArray();
        JSONObject r2 = new JSONObject();
        JSONObject r3 = new JSONObject();
    L11:
        e = move-exception;
        ALogger.e("ToolbarShakeMatchBehavior", e);
    L13:
        Room r5 = null;
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r4 == null) goto L18;
        com.bytedance.live.datacontext.m r6 = r4.getRoom();
        if (r6 == null) goto L18;
        r5 = (Room) r6.getValue();
    L18:
        if (r5 == null) goto L26;
        CompositeDisposable r10 = this.b;
        if (r10 == null) goto L27;
        RxUtilKt.c(((LinkAudienceApi) com.bytedance.android.live.network.c.b().e(LinkAudienceApi.class)).updateAudienceSettings(r5.id, r1.toString()).compose(RxUtil.rxSchedulerHelper()).subscribe(new u4(r9), new v4(r9)), r10);
        return;
    L27:
        return;
    L26:
        return;
    L6:
        if (this.e == true) goto L8;
        int r11 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.ordinal();     // Catch: JSONException -> L11
    L9:
        r3.put("status", r11);     // Catch: JSONException -> L11
        r2.put("key", LinkmicAudienceSetting.LinkmicAudienceSettingKey.ENABLE_FASTMATCH_SHAKE.getValue());     // Catch: JSONException -> L11
        r2.put("value", r3);     // Catch: JSONException -> L11
        r1.put(r2);     // Catch: JSONException -> L11
        goto L13
    L8:
        r11 = ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.ordinal();     // Catch: JSONException -> L11
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        CompositeDisposable r4 = this.b;
        if (r4 == null) goto L6;
        r4.clear();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.f = r3;
        this.c = r2.findViewById(2131374718);
        this.d = (ImageView) r2.findViewById(2131384095);
        this.e = ((Boolean) com.bytedance.android.livesdk.sharedpref.b.V1.getValue()).booleanValue();
        a();
        com.bytedance.android.livesdk.sharedpref.e r4 = com.bytedance.android.livesdk.sharedpref.b.u;
        if (((Boolean) r4.getValue()).booleanValue() == false) goto L6;
        Boolean r5 = Boolean.FALSE;
        r4.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r4, r5);
        return;
    }
}
