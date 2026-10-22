package com.bytedance.android.livesdk.chatroom.ui.behavior;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.ui.QuickShotPresenter;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import com.bytedance.android.livesdk.chatroom.ui.j8;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.util.h;
import com.bytedance.android.livesdk.chatroom.vs_base.util.y;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSToolbarConfigData;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ev1.q;
import fq1.t;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vr1.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements c0.b, QuickShotPresenter.b {
    public DataCenter a;
    public boolean b;
    public SharedPrefHelper c;
    public QuickShotPresenter d;
    public View e;
    public final Context f;
    public final IRoom g;
    public final boolean h;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Bh(ToolbarButton r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void Mr(s r1) {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final /* synthetic */ void R9(View r1, DataCenter r2) {
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

    public final boolean a() {
        DataCenter r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("currentDataCenter");
    L6:
        if (h.e(r0).isMergeVSRoom() == true) goto L8;
    L10:
        return false;
    L8:
        if (PadConfigUtils.c() == true) goto L10;
        return true;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void SY(s r5) {
        if (this.h == false) goto L25;
        HSImageView r0 = null;
        if (r5 == null) goto L7;
        k r2 = r5.c;
    L8:
        if (r2 == null) goto L25;
        int r3 = bytekn.foundation.utils.a.a;
        k r4 = r5.c;
        if (r4 == null) goto L12;
        List r6 = r4.getUrls();
    L14:
        if (r6 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L25;
        View r8 = this.e;
        if (r8 == null) goto L24;
        r0 = r8.findViewById(2131387276);
    L24:
        ImageUtil.loadImage(r0, r5.c, 0);
        return;
    L16:
        if (r6.isEmpty() == true) goto L19;
        r7 = false;
        goto L20
    L12:
        r6 = null;
        goto L14
    L7:
        r2 = null;
    L25:
        View r9 = this.e;
        if (r9 == null) goto L36;
        HSImageView r10 = r9.findViewById(2131387276);
        if (r10 != null) goto L30;
        return;
    L30:
        if (this.b == false) goto L32;
        int r1 = 2131252963;
    L33:
        r10.setImageResource(r1);
        return;
    L32:
        r1 = 2131252962;
        goto L33
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        DataCenter r6 = this.a;
        if (r6 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentDataCenter");
    L5:
        if (r6 == null) goto L7;
        o r7 = r.l();
        Map<String, String> r0 = MapsKt.emptyMap();
        x r2 = new x();
        r2.a = "live";
        r2.e = "click";
        r2.b = "live_detail";
        r7.sendLog("livesdk_screen_shot_icon_click", r0, new Object[]{r2, IRoom.class});
    L7:
        QuickShotPresenter r8 = this.d;
        if (r8 == null) goto L11;
        r8.b(System.currentTimeMillis());
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r8, DataCenter r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        Intrinsics.checkNotNullParameter(r9, "dataCenter");
        this.e = r8;
        this.c = SharedPrefHelper.c(s1.getContext(), "douyin_quick_screenshot");
        this.a = r9;
        IRoom r0 = h.a;
        if (r9 == null) goto L7;
        Boolean r1 = (Boolean) r9.get("data_is_anchor", Boolean.FALSE);
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        boolean r3 = !r2;
        this.b = r3;
        if (r3 == false) goto L21;
        View r4 = r8.findViewById(2131387276);
        if (r4 == null) goto L14;
        int r5 = UtilityKotlinExtentionsKt.i(38);
        UIUtils.setLayoutParams(r4, r5, r5);
    L14:
        Intrinsics.checkNotNullParameter(r8, "$this$layoutWidth");
        ViewGroup.LayoutParams r6 = r8.getLayoutParams();
        if (r6 == null) goto L17;
        int r7 = r6.width;
    L19:
        if (r7 != UtilityKotlinExtentionsKt.i(36)) goto L21;
        com.bytedance.android.livesdk.chatroom.vs_base.util.k.f(r8, UtilityKotlinExtentionsKt.i(38));
        goto L21
    L17:
        r7 = 0;
    L21:
        Context r10 = this.f;
        DataCenter r11 = this.a;
        if (r11 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("currentDataCenter");
    L24:
        this.d = new QuickShotPresenter(r10, r11, this.g, this);
        r.l().c(r9);
        IEpisodeExtraInfo r12 = this.g.getEpisodeExtra();
        Object r13 = null;
        if ((r12 instanceof EpisodeExtraInfo) == true) goto L27;
        r12 = null;
    L27:
        EpisodeExtraInfo r14 = (EpisodeExtraInfo) r12;
        if (r14 == null) goto L68;
        List r15 = r14.getPannelToolbarList();
        if (r15 == null) goto L69;
        Iterator r16 = r15.iterator();
    L33:
        if (r16.hasNext() == false) goto L40;
        Object r17 = r16.next();
        if (((VSToolbarConfigData) r17).getToolbarType() != 11) goto L37;
        boolean r18 = true;
    L38:
        if (r18 == false) goto L33;
        r13 = r17;
        goto L40
    L37:
        r18 = false;
    L40:
        VSToolbarConfigData r19 = (VSToolbarConfigData) r13;
        if (r19 != null) goto L43;
        return;
    L43:
        if (this.h == false) goto L45;
        HSImageView r20 = r8.findViewById(2131387276);
        if (r20 != null) goto L55;
        return;
    L55:
        if (this.b == true) goto L57;
        int r21 = 2131252962;
    L61:
        r20.setImageResource(r21);
        return;
    L57:
        if (((Boolean) q.d.getValue()).booleanValue() == false) goto L59;
        r21 = 2131252964;
        goto L61
    L59:
        r21 = 2131252963;
        goto L61
    L45:
        if (r19.getIcon() == null) goto L51;
        k r22 = r19.getIcon();
        Intrinsics.checkNotNull(r22);
        if (r22.getUrls() == null) goto L51;
        k r23 = r19.getIcon();
        Intrinsics.checkNotNull(r23);
        if ((!r23.getUrls().isEmpty()) == false) goto L51;
        ImageUtil.loadImage((ImageView) r8.findViewById(2131387276), r19.getIcon(), 2131252961);
        return;
    L51:
        r8.findViewById(2131387276).setImageResource(2131252961);
        return;
    L69:
        return;
    L68:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public b(Context r2, IRoom r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mRoom");
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.QuickShotPresenter.b
    public final PopupWindow Xc(long r22, Bitmap r24, VideoViewParams r25) {
        Intrinsics.checkNotNullParameter(r24, "bitmap");
        Intrinsics.checkNotNullParameter(r25, "videoParam");
        if (a() == false) goto L9;
        bs1.b r1 = new bs1.b(null, r24, "", r22);
        int r2 = bs1.a.a;
        DataCenter r3 = this.a;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("currentDataCenter");
    L7:
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r1, "param");
        r3.put("data_live_quick_shot_bitmap", r1);
        return null;
    L9:
        String r4 = t.a().getCurrentUserId();
        SharedPrefHelper r5 = this.c;
        if (r5 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("spHelper");
    L13:
        if (r5 == null) goto L15;
        Integer r6 = Integer.valueOf(r5.h(r4, 0));
    L16:
        int r7 = r6.intValue();
        if (r7 >= 3) goto L24;
        y.b("快拍海报保存成功", 0);
        SharedPrefHelper r8 = this.c;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("spHelper");
    L21:
        if (r8 == null) goto L24;
        r8.m(r4, Integer.valueOf(r7 + 1));
    L24:
        if (this.h == false) goto L26;
        int r9 = s1.r();
        float r10 = 28.0f;
    L27:
        int r11 = r9 - s1.f(r10);
        if (this.h == false) goto L30;
        float r12 = 24.0f;
    L31:
        int r13 = s1.f(r12);
        Context r14 = this.f;
        if (r14 == null) goto L61;
        j8 r15 = new j8((Activity) r14, r24, r13, r11, r22, s1.e(175.0f), r25);
        Context r16 = this.f;
        if (r16 == null) goto L59;
        View r17 = ((Activity) r16).getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L40;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r18 = ThreadMethodProxy.currentThread();
        if (r18 == com.larus.home.impl.utils.c.a) goto L40;
        com.larus.home.impl.utils.c.a(r18, "getDecorView");
    L40:
        if (r25 == null) goto L42;
        Integer r19 = Integer.valueOf(r25.c);
    L43:
        int r20 = r19.intValue();
        if (PopupWindowLancet.hasSubWindowToken(r17) == false) goto L47;
    L45:
        j8 r21 = r15;
    L54:
        if (this.a != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("currentDataCenter");
    L56:
        o r23 = r.l();
        Map<String, String> r26 = MapsKt.emptyMap();
        x r27 = new x();
        r27.a = "live";
        r27.e = "show";
        r27.b = "live_detail";
        r23.sendLog("livesdk_screen_shot_photo_show", r26, new Object[]{r27, IRoom.class});
        return r21;
    L47:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r15) == false) goto L49;
        r15.showAtLocation(r17, 0, 0, r20);
        goto L45
    L49:
        OverlaySource r28 = PopupWindowLancet.resolveSource(r17);
        r21 = r15;
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r15, r17, r28, 0, 0, r20) == true) goto L54;
        r21.showAtLocation(r17, 0, 0, r20);
        PopupWindowLancet.trackAfterShow(r21, r28, r17);
        goto L54
    L42:
        r19 = null;
        goto L43
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L61:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L30:
        r12 = 61.0f;
        goto L31
    L26:
        r9 = s1.r();
        r10 = 32.0f;
        goto L27
    L15:
        r6 = null;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.QuickShotPresenter.b
    public final void vp(long r2, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "failReason");
        if (a() == false) goto L5;
        bs1.a.a(r2, r4, r5);
        return;
    L5:
        ALogger.e("ToolbarQuickScreenshotBehavior", "generate ScreenShot Fail:".concat(r5));
    }

    @Override // com.bytedance.android.livesdk.chatroom.ui.QuickShotPresenter.b
    public final void ya(String r7, long r8, Bitmap r10, VideoViewParams r11) {
        Intrinsics.checkNotNullParameter(r7, "path");
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r11, "videoParam");
        if (a() == false) goto L8;
        bs1.b r12 = new bs1.b(null, r10, r7, r8);
        int r9 = bs1.a.a;
        DataCenter r13 = this.a;
        if (r13 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("currentDataCenter");
    L7:
        bs1.a.b(r13, r12);
        return;
    L8:
        ALogger.i("ToolbarQuickScreenshotBehavior", "screenShot saved");
    }
}
