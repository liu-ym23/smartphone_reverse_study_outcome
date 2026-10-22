package com.bytedance.android.live.liveinteract.bgComponent.theme.util;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.bgComponent.theme.api.VoiceLiveThemeApi;
import com.bytedance.android.live.liveinteract.utils.a1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements c0.b {
    public boolean a;
    public DataCenter b;
    public FrameLayout c;
    public View d;
    public final CompositeDisposable e;
    public IVoiceLiveTheme f;
    public final a1 g;
    public final a h;

    public interface a {
        int getBgType();
    }

    public static final class b {
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final /* synthetic */ void SY(s r1) {
    }

    public final /* synthetic */ void Y6() {
    }

    public final /* synthetic */ void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    public final /* synthetic */ com.bytedance.android.livesdk.reddot.a h7() {
        return null;
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final void onClick(View r7) {
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("anchor_id", k.n(IMiddlewareUserService.class).user().n());
        r8.put("event_page", "live_take_detail");
        j r0 = m.d().s();
        if (r0 == null) goto L9;
        f r1 = (f) r0.getValue();
        if (r1 == null) goto L9;
        i r2 = r1.t();
        if (r2 == null) goto L9;
        Integer r3 = Integer.valueOf(r2.a);
    L10:
        DataCenter r4 = this.b;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L13:
        IRoom r5 = (IRoom) r4.get("data_room", null);
        int r6 = 5;
        if (r5 == null) goto L37;
        r8.put("room_id", r5.getIdStr());
        if (r3 != null) goto L19;
    L26:
        if (r3 != null) goto L29;
    L31:
        if (r3 == null) goto L37;
        if (r3.intValue() != 0) goto L37;
        r8.put("function_type", "live");
        goto L37
    L29:
        if (r3.intValue() != 9) goto L31;
        r8.put("function_type", "ktv");
        goto L37
    L19:
        if (r3.intValue() != 5) goto L26;
        if (r5.getLinkInitResult() != null) goto L23;
        r8.put("function_type", "live");
        goto L37
    L23:
        r8.put("function_type", "radio");
        if (d0.h(r5) == false) goto L37;
        r8.put("function_type", "party");
    L37:
        if (this.a == false) goto L39;
        String r9 = "1";
    L40:
        r8.put("if_dot", r9);
        a(this, r8);
        j0.l().sendLog("livesdk_anchor_theme_entrance_click", r8, new Object[]{IRoom.class});
        a1 r10 = this.g;
        if (r10 == null) goto L44;
        r10.bq();
    L44:
        if (this.f == null) goto L49;
        a r11 = this.h;
        if (r11 == null) goto L48;
        r6 = r11.getBgType();
    L48:
        IVoiceLiveTheme r12 = this.f;
        Intrinsics.checkNotNull(r12);
        com.bytedance.android.live.liveinteract.theme.a.b(r6, r12.getImageUri(), 1.0d);
    L49:
        this.a = false;
        return;
    L39:
        r9 = "0";
    L9:
        r3 = null;
        goto L10
    }

    public c(a1 r1, a r2) {
        this.g = r1;
        this.h = r2;
        this.e = new CompositeDisposable();
    }

    public static void a(c r4, Map r5) {
        int r0 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "logMap");
        if (r0 != 0) goto L5;
    L17:
        r5.put("live_type", "voice_live");
        return;
    L5:
        if (r0 != 12) goto L7;
        r5.put("live_type", "video_live");
        return;
    L7:
        if (r0 != 4) goto L9;
        r5.put("live_type", "video_live");
        return;
    L9:
        if (r0 == 5) goto L17;
        switch(r0) {
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L24;
        };
    L12:
        r5.put("live_type", "voice_live");
        return;
    L13:
        r5.put("live_type", "voice_live");
        return;
    L14:
        r5.put("live_type", "video_live");
        return;
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.e.clear();
    }

    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        this.b = r3;
        if ((r2 instanceof ViewGroup) == false) goto L5;
        this.c = (FrameLayout) r2.findViewById(2131374718);
    L5:
        this.d = r2.findViewById(2131384095);
        VoiceLiveThemeApi r4 = (VoiceLiveThemeApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeApi.class);
        a r5 = this.h;
        if (r5 == null) goto L8;
        int r6 = r5.getBgType();
    L9:
        RxUtilKt.c(r4.getLatestOfficeBg(r6).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this), e.a), this.e);
        return;
    L8:
        r6 = 5;
        goto L9
    }
}
