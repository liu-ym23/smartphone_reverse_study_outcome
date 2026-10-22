package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.audiencerecord.LiveAudienceBacktrackPreviewDialog;
import com.bytedance.android.livesdk.audiencerecord.api.BacktrackState;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.widget.LiveCircleProgressView;
import com.bytedance.android.livesdk.config.cg;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m2 implements com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b, se1.a {
    public ImageView a;
    public View b;
    public View c;
    public View d;
    public LiveCircleProgressView e;
    public se1.c f;
    public se1.b g;
    public final FragmentActivity h;
    public DataCenter i;
    public Room j;
    public final boolean k;
    public Disposable l;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BacktrackState.values().length];
            a = r0;
            r0[BacktrackState.IDLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[BacktrackState.TIMEOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[BacktrackState.ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[BacktrackState.BACKTRACK_DOING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[BacktrackState.PREVIEWING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[BacktrackState.DONE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final void G0(float r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void SY(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r1) {
    }

    public final void UL(BacktrackState r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Y6() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void dv(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void onHide(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final void a() {
        switch(a.a[this.g.a().ordinal()]) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L12;
        };
    L5:
        FragmentActivity r0 = this.h;
        if (r0 == null) goto L12;
        DataCenter r2 = this.i;
        LiveAudienceBacktrackPreviewDialog.p.getClass();
        LiveAudienceBacktrackPreviewDialog.b.b(r0, r2, "", null);
    L12:
        HashMap r1 = new HashMap();
        Room r3 = this.j;
        if (r3 == null) goto L15;
        int r4 = com.bytedance.android.live.core.utils.h1.a;
        r1.put("live_type", com.bytedance.android.live.core.utils.i1.a(r3.getStreamType()));
        r1.put("request_page", "live_room");
    L15:
        String r5 = "0";
        if (this.k == false) goto L18;
        Object r6 = "0";
    L19:
        r1.put("room_orientation", r6);
        if (this.g.a() != BacktrackState.BACKTRACK_DOING) goto L22;
        r5 = "1";
    L22:
        r1.put("is_record_status", r5);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_watched_record_button_click", r1, new Object[]{Room.class, am2.x.class});
        return;
    L18:
        r6 = "1";
        goto L19
    L9:
        if (com.bytedance.android.livesdk.chatroom.record.u.d(this.i) == false) goto L11;
        com.bytedance.android.live.core.utils.f2.b(2131921607, 0);
        goto L12
    L11:
        this.i.put("cmd_save_back_record_preview_info", new Object());
        this.f.startBacktrack();
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        return ((Boolean) com.bytedance.android.livesdk.sharedpref.b.m.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final com.bytedance.android.livesdk.reddot.a h7() {
        return up2.a.q;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.m;
        if (((Boolean) r0.getValue()).booleanValue() == false) goto L5;
        Boolean r1 = Boolean.FALSE;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r1);
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3.m(this.i).b(ToolbarButton.MORE, new pp1.j(false));
    L5:
        UIUtils.setViewVisibility(this.d, 4);
        if (jc1.k.f(IUserService.class).user().isLogin() == true) goto L9;
        this.l = TTLiveSDKContext.getHostService().h().login(r5.getContext(), new com.bytedance.android.livesdk.user.l(new com.bytedance.android.livesdk.user.l.a())).observeOn(AndroidSchedulers.mainThread()).subscribe(new l2(this), new com.bytedance.android.live.multilink.impl.o1());
        return;
    L9:
        a();
    }

    public m2(FragmentActivity r1, boolean r2) {
        this.k = r2;
        this.h = r1;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void R9(View r1, DataCenter r2) {
        ViewGroup r3 = (ViewGroup) r1.findViewById(2131374718);
        if (r3 == null) goto L5;
        r3.removeAllViews();
    L5:
        Disposable r4 = this.l;
        if (r4 == null) goto L9;
        r4.dispose();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r6, DataCenter r7) {
        ViewGroup r0 = (ViewGroup) r6.findViewById(2131374718);
        se1.c r1 = (se1.c) r7.get("data_audience_backtrace_service");
        this.f = r1;
        if (r0 == null) goto L33;
        if (r1 != null) goto L7;
        return;
    L7:
        if (this.k == false) goto L9;
        LayoutInflater.from(r6.getContext()).inflate(2131567854, r0, true);
    L10:
        this.i = r7;
        this.j = (Room) r7.get("data_room");
        this.g = this.f.a();
        this.a = (ImageView) r0.findViewById(2131375297);
        this.b = r0.findViewById(2131383333);
        this.c = r0.findViewById(2131372576);
        this.e = (LiveCircleProgressView) r0.findViewById(2131383286);
        this.d = r6.findViewById(2131384095);
        this.e.setProgressColor(-1291845633);
        this.e.setCircleWidth(com.bytedance.android.live.core.utils.s1.f(2.0f));
        this.e.setBgCircleWidth(com.bytedance.android.live.core.utils.s1.f(2.0f));
        this.e.setBgCircleColor(436207615);
        this.e.setMaxProgress(100);
        this.g.b(this);
        if (this.k == true) goto L16;
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.i) == false) goto L16;
        this.a.setImageResource(2131251570);
    L16:
        if (cg.a.getValue().longValue() != 60) goto L18;
        boolean r8 = true;
    L19:
        if (r8 == true) goto L28;
        ImageView r9 = this.a;
        Context r10 = com.bytedance.android.live.core.utils.s1.getContext();
        if (this.k == false) goto L24;
        int r2 = 2131251563;
    L27:
        r9.setImageDrawable(ContextCompat.getDrawable(r10, r2));
        goto L28
    L24:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(this.i) == false) goto L26;
        r2 = 2131251565;
        goto L27
    L26:
        r2 = 2131251564;
    L28:
        UIUtils.setViewVisibility(this.a, 0);
        UIUtils.setViewVisibility(this.b, 4);
        UIUtils.setViewVisibility(this.c, 4);
        HashMap r11 = new HashMap();
        Room r12 = this.j;
        if (r12 == null) goto L31;
        int r3 = com.bytedance.android.live.core.utils.h1.a;
        r11.put("live_type", com.bytedance.android.live.core.utils.i1.a(r12.getStreamType()));
        r11.put("request_page", "live_room");
    L31:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_watched_record_button_show", r11, new Object[]{Room.class, am2.x.class});
        return;
    L18:
        r8 = false;
        goto L19
    L9:
        LayoutInflater.from(r6.getContext()).inflate(2131567853, r0, true);
        goto L10
    }
}
