package com.bytedance.android.live.liveinteract.voicechat.toolbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.broadcast.api.VoiceLiveThemeMiddlewareApi;
import com.bytedance.android.live.broadcast.dialog.theme.VoiceLiveThemeAdapter;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.bgComponent.theme.VoiceLiveThemeManageDialog;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements c0.b, x00.d {
    public x00.b a;
    public FrameLayout b;
    public View c;
    public final CompositeDisposable d;
    public IVoiceLiveTheme e;
    public boolean f;
    public final Context g;
    public final LifecycleOwner h;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            ArrayList r2 = (ArrayList) r1;
            x00.b r3 = this.a.a;
            if (r3 == null) goto L6;
            ((VoiceLiveThemeManageDialog) r3).M0();
            return;
        }
    }

    static {
    }

    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    public final /* synthetic */ void Mr(s r1) {
    }

    public final void R9(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
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

    public final void lj(IVoiceLiveTheme r2, IVoiceLiveTheme r3) {
        Intrinsics.checkNotNullParameter(r2, "previousTheme");
        Intrinsics.checkNotNullParameter(r3, "currentTheme");
    }

    public final /* synthetic */ void onHide(boolean r1) {
    }

    public final /* synthetic */ void setAlpha(float r1) {
    }

    public final /* synthetic */ boolean showRedDot() {
        return false;
    }

    public final Context getContext() {
        return this.g;
    }

    public final void onClick(View r6) {
        ALogger.i("[VideoTalk]ToolbarVideoThemeBehavior", "onClick");
        x00.b r7 = this.a;
        if (r7 != null) goto L5;
    L21:
        IVoiceLiveTheme r8 = this.e;
        if (r8 == null) goto L24;
        com.bytedance.android.live.liveinteract.theme.a.b(3, r8.getImageUri(), 2.0d);
    L24:
        this.f = false;
        return;
    L5:
        if (r7.isShowing() == true) goto L21;
        x00.b r9 = this.a;
        if (r9 == null) goto L11;
        VoiceLiveThemeManageDialog r2 = (VoiceLiveThemeManageDialog) r9;
        r2.h = 3;
        VoiceLiveThemeAdapter r3 = r2.b;
        if (r3 == null) goto L11;
        r3.g = 3;
    L11:
        if (r9 == null) goto L13;
        r9.show();
    L13:
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("anchor_id", k.n(IMiddlewareUserService.class).user().n().toString());
        r10.put("event_page", "live_take_detail");
        r10.put("function_type", TalkRoomLogUtils.g());
        r10.put("live_type", "video_live");
        r10.put("play_mode", u0.b());
        if (this.f == false) goto L16;
        String r4 = "1";
    L17:
        r10.put("if_dot", r4);
        String r5 = ((IInteractService) k.n(IInteractService.class)).getFunctionType2();
        if (r5 != null) goto L20;
        r5 = "";
    L20:
        r10.put("function_type2", r5);
        j0.l().sendLog("livesdk_anchor_theme_entrance_click", r10, new Object[]{IRoom.class});
        goto L21
    L16:
        r4 = "0";
        goto L17
    }

    public f(Context r2, LifecycleOwner r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        this.g = r2;
        this.h = r3;
        this.d = new CompositeDisposable();
    }

    public final void p4(View r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        x00.b r0 = ((IInteractService) k.n(IInteractService.class)).createVoiceLiveThemeDialog(this.g, false, null, 3, r9);
        this.a = r0;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) ((VoiceLiveThemeManageDialog) r0).d).add(this);
    L6:
        if ((r8 instanceof ViewGroup) == false) goto L8;
        this.b = (FrameLayout) r8.findViewById(2131374718);
    L8:
        this.c = r8.findViewById(2131384095);
        Observable r10 = ((VoiceLiveThemeMiddlewareApi) com.bytedance.android.live.network.c.b().e(VoiceLiveThemeMiddlewareApi.class)).getLatestOfficeBg(3);
        if (r10 == null) goto L15;
        Observable r11 = r10.compose(RxUtil.rxSchedulerHelper());
        if (r11 == null) goto L15;
        Disposable r12 = r11.subscribe(new g(this), h.a);
        if (r12 == null) goto L15;
        RxUtilKt.c(r12, this.d);
    L15:
        x00.a r13 = ((IInteractService) k.n(IInteractService.class)).getThemeManager(true, r9);
        if (r13 == null) goto L19;
        r13.p(this.h, new b(this), 3);
        return;
    }
}
