package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.RectF;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.commonui.LiveSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.ReplayRoomFragmentScopeUtil;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;
import com.bytedance.android.livesdkapi.model.VSFoldFixConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class q extends ir1.c {

    public static final class a implements Runnable {
        public final /* synthetic */ q a;
        public final /* synthetic */ SimpleMediaView b;
        public final /* synthetic */ View c;

        public a(q r1, SimpleMediaView r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            LayerHostMediaLayout r0 = this.b.getLayerHostMediaLayout();
            FragmentActivity r1 = null;
            if (r0 == null) goto L7;
            cjc.c r2 = r0.getTextureContainer();
            if (r2 == null) goto L7;
            com.ss.android.videoshop.mediaview.a r3 = r2.getVideoView();
        L8:
            if (r3 == null) goto L23;
            boolean r4 = MatchRoomLandScapeAnimUtil.a;
            MatchRoomLandScapeAnimUtil.v((View) r3);
            FragmentActivity r5 = this.c.getContext();
            if ((r5 instanceof FragmentActivity) == false) goto L13;
            r1 = r5;
        L13:
            MatchRoomLandScapeAnimUtil.s(r1);
            if (this.a.g() == false) goto L16;
        L20:
            boolean r6 = false;
        L21:
            MatchRoomLandScapeAnimUtil.t(r6);
            return;
        L16:
            if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == true) goto L18;
        L19:
            r6 = true;
            goto L21
        L18:
            if (FoldScreenUtils.e() == true) goto L20;
        L23:
            return;
        L7:
            r3 = null;
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static VideoViewParams r() {
        int r0 = t.a;
        return new VideoViewParams(s1.q(s1.getContext()).widthPixels, (int) (s1.q(s1.getContext()).widthPixels / 1.7777778f), UtilityKotlinExtentionsKt.c(lr1.b.a()), 0.0f);
    }

    public final float p() {
        if (l() == true) goto L5;
    L7:
        return 0.0f;
    L5:
        if (g() == true) goto L7;
        return 74.0f;
    }

    public q() {
    }

    public final VideoViewParams q(Context r6, DataCenter r7) {
        if (a() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
    L12:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r1 = ReplayRoomFragmentScopeUtil.a;
        int r2 = ((n) ReplayRoomFragmentScopeUtil.a(n.class)).p(r6);
        int r3 = s1.f(p());
    L13:
        int r4 = r2 - r3;
        if (d() == true) goto L16;
        int r5 = ((n) ReplayRoomFragmentScopeUtil.a(n.class)).p(r6);
    L18:
        return new VideoViewParams(r5, r4 - ((ReplayStatusBarUIState) ReplayRoomFragmentScopeUtil.a(ReplayStatusBarUIState.class)).r(r6, r7, d()), 0, 0.0f);
    L16:
        r5 = ((n) ReplayRoomFragmentScopeUtil.a(n.class)).o(r6);
        goto L18
    L10:
        if (d() == true) goto L12;
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r8 = ReplayRoomFragmentScopeUtil.a;
        r2 = ((n) ReplayRoomFragmentScopeUtil.a(n.class)).o(r6);
        r3 = s1.f(p());
        goto L13
    L5:
        if (s1.getResources().getConfiguration().orientation != 2) goto L7;
        r0 = true;
        goto L8
    }

    public final VideoViewParams t(Context r7, DataCenter r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "dataCenter");
        SettingKey r0 = LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG;
        if (((VSFoldFixConfig) r0.getValue()).getEnable() == false) goto L10;
        if (a() == false) goto L10;
        if (f() == false) goto L10;
        return r();
    L10:
        if (g() == true) goto L16;
        if (((VSFoldFixConfig) r0.getValue()).getEnable() == false) goto L21;
        if (a() == true) goto L16;
    L21:
        if (b() == false) goto L36;
        if (d() == false) goto L25;
        int r9 = t.j();
    L26:
        VideoContext r10 = VideoContext.n0(r7);
        if (r10 == null) goto L48;
        LayerHostMediaLayout r11 = r10.c;
        if (r11 == null) goto L48;
        RectF r12 = r11.getTextureRealRectF();
        if (r12 == null) goto L48;
        VideoViewParams r1 = new VideoViewParams(MathKt.roundToInt(((double) (r9 * 1.7777778f)) + 0.5d), r9, 0, r12.left);
    L50:
        return r1;
    L48:
        return new VideoViewParams(MathKt.roundToInt(r9 * 1.7777778f), r9, 0, 0.0f);
    L25:
        com.bytedance.android.livesdk.chatroom.vs_base.base.d r13 = ReplayRoomFragmentScopeUtil.a;
        r9 = ((n) ReplayRoomFragmentScopeUtil.a(n.class)).o(r7);
        goto L26
    L36:
        if (l() == false) goto L39;
        return q(r7, r8);
    L39:
        if (f() == false) goto L51;
        if (d() == false) goto L51;
        int r14 = t.a;
        int r15 = s1.q(s1.getContext()).widthPixels - com.bytedance.android.livesdk.chatroom.vs_base.util.o.a;
        r1 = new VideoViewParams(r15, (int) (r15 / 1.7777778f), 0, 0.0f);
    L51:
        return r();
    L16:
        if (l() == true) goto L46;
        if (b() == false) goto L21;
    L46:
        return q(r7, r8);
    }

    public final void o(View r2, SimpleMediaView r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "simpleMediaView");
        if (r4 == true) goto L5;
    L8:
        if (r4 == true) goto L11;
        boolean r5 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.p(0);
        return;
    L11:
        return;
    L5:
        if (h() == false) goto L8;
        if (r2 == null) goto L8;
        r2.post(new a(this, r3, r2));
        goto L8
    }

    public final void s(SimpleMediaView r2, Context r3, boolean r4) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (((VSFoldFixConfig) LiveSettingKeys.LIVE_VS_FOLD_FIX_CONFIG.getValue()).getEnable() == false) goto L15;
        if (l() == false) goto L15;
        if (FoldScreenUtils.e() == false) goto L15;
        LayerHostMediaLayout r5 = r2.getLayerHostMediaLayout();
        if (r5 == null) goto L32;
        r5.setTextureLayout(0);
        return;
    L32:
        return;
    L15:
        if (l() == true) goto L18;
        if (r4 == true) goto L18;
        return;
    L18:
        if (g() == true) goto L34;
        int r6 = com.bytedance.android.livesdk.chatroom.vs_base.util.m.a;
        if (r3 == null) goto L24;
        Resources r7 = r3.getResources();
        if (r7 == null) goto L24;
        Configuration r8 = r7.getConfiguration();
    L26:
        if (com.bytedance.android.livesdk.chatroom.vs_base.util.m.b(r8) == true) goto L36;
        LayerHostMediaLayout r9 = r2.getLayerHostMediaLayout();
        if (r9 == null) goto L35;
        r9.setTextureLayout(2);
        return;
    L35:
        return;
    L36:
        return;
    L24:
        r8 = null;
        goto L26
    }
}
