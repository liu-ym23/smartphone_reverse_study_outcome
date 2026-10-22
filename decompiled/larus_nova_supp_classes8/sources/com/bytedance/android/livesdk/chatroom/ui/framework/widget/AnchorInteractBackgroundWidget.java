package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ability.IAbility;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.config.bg1;
import com.bytedance.android.livesdk.config.yg0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/widget/AnchorInteractBackgroundWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Ljo1/b;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorInteractBackgroundWidget extends MiddlewareRoomWidget implements Observer<KVData>, jo1.b {
    public com.bytedance.android.livesdk.chatroom.ui.framework.d a;
    public com.bytedance.android.livesdk.chatroom.ui.framework.c b;
    public int c;
    public Configuration d;
    public final String e;
    public final String f;
    public final String g;

    public final /* synthetic */ void onAbilityClear() {
        IAbility.-CC.$default$onAbilityClear(this);
    }

    public final HSImageView Tb() {
        com.bytedance.android.livesdk.chatroom.ui.framework.d r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Tb();
    }

    public AnchorInteractBackgroundWidget() {
        this.c = -1;
        this.e = "SAMSUNG";
        this.f = "HUAWEI";
        this.g = "HONOR";
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        this.a = ho1.a.i(getComponentContext());
        this.b = ho1.a.d(getComponentContext());
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.p(r0, jo1.b.class, this);
    L5:
        ((Widget) this).dataCenter.observe("cmd_adjust_video_interact_stream_bottom", this);
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        h70.b r0 = getComponentContext();
        if (r0 == null) goto L5;
        ho1.a.q(r0, jo1.b.class);
    L5:
        DataCenter r1 = ((Widget) this).dataCenter;
        if (r1 == null) goto L8;
        r1.removeObserver(this);
    L8:
        this.b = null;
        this.a = null;
    }

    @Override // jo1.b
    public final void Go(zg1.z0 r5) {
        int r6 = r5.a;
        boolean r0 = true;
        if (r6 == 0) goto L5;
        if (r6 != 1) goto L10;
        UIUtils.setViewVisibility(Tb(), 8);
    L10:
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L21;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L21;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L21;
        if (Tb() == null) goto L21;
        HSImageView r7 = Tb();
        if (r7 == null) goto L21;
        r7.setPadding(-3, -StatusBarUtil.getStatusBarHeight(getContext()), -3, -3);
    L21:
        if (PadConfigUtils.c() == false) goto L38;
        int r8 = this.c;
        if (r8 != (-1)) goto L28;
        if (e5.n() == false) goto L31;
    L30:
        r0 = false;
    L31:
        if (r0 == false) goto L33;
        return;
    L33:
        if (Tb() == null) goto L40;
        HSImageView r9 = Tb();
        if (r9 == null) goto L41;
        r9.setPadding(-3, 0, -3, -3);
        return;
    L41:
        return;
    L40:
        return;
    L28:
        if (e5.o(r8) == true) goto L30;
    L38:
        return;
    L5:
        if (bg1.a() == true) goto L10;
        ImageLoader.bindImage(Tb(), yg0.a.getValue());
        UIUtils.setViewVisibility(Tb(), 0);
        goto L10
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        if (isViewValid() == false) goto L62;
        ViewGroup.LayoutParams r0 = null;
        if (r6 == null) goto L7;
        String r1 = r6.getKey();
    L9:
        if (TextUtils.isEmpty(r1) == true) goto L63;
        if (r6 == null) goto L12;
        Object r2 = r6.getData();
    L13:
        if (r2 == null) goto L69;
        String r3 = r6.getKey();
        if (r3.hashCode() == (-81738768)) goto L19;
        return;
    L19:
        if (r3.equals("cmd_adjust_video_interact_stream_bottom") == false) goto L64;
        Pair r7 = (Pair) r6.getData();
        if (r7 != null) goto L23;
        return;
    L23:
        if (Tb() == null) goto L66;
        HSImageView r4 = Tb();
        if (r4 == null) goto L27;
        r0 = r4.getLayoutParams();
    L27:
        if (r0 == null) goto L61;
        FrameLayout.LayoutParams r8 = (FrameLayout.LayoutParams) r0;
        Object r9 = r7.getFirst();
        Intrinsics.checkNotNull(r9);
        r8.topMargin = ((Number) r9).intValue();
        int r10 = s1.y();
        if (FoldScreenUtils.f() == false) goto L57;
        Configuration r11 = this.d;
        if (r11 == null) goto L57;
        if (FoldScreenUtils.c(r11) != 0) goto L57;
        if (((Number) r7.getSecond()).intValue() < 0) goto L37;
        r10 = ((Number) r7.getSecond()).intValue();
        goto L57
    L37:
        float r12 = s1.w();
        if (StatusBarUtil.STATUS_BAR_ADAPT_ENABLE == false) goto L52;
        if (StatusBarUtil.JUMP_FROM_LIVE_PLAY_ACTIVITY == false) goto L52;
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L52;
        com.bytedance.android.livesdk.chatroom.ui.framework.c r13 = this.b;
        if (r13 == null) goto L46;
        boolean r14 = r13.dg();
    L47:
        if (r14 == true) goto L52;
        if (Intrinsics.areEqual(this.e, FoldScreenUtils.d()) == false) goto L56;
        r12 = r12 + s1.A();
    L56:
        r10 = (int) (r12 * 0.5625f);
        goto L57
    L46:
        r14 = false;
    L52:
        if (Intrinsics.areEqual(this.f, FoldScreenUtils.d()) == false) goto L54;
    L55:
        r12 = r12 - s1.A();
        goto L56
    L54:
        if (Intrinsics.areEqual(this.g, FoldScreenUtils.d()) == false) goto L56;
    L57:
        r8.width = r10;
        r8.gravity |= 1;
        HSImageView r15 = Tb();
        if (r15 == null) goto L67;
        r15.setLayoutParams(r8);
        return;
    L67:
        return;
    L61:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L66:
        return;
    L64:
        return;
    L69:
        return;
    L12:
        r2 = null;
        goto L13
    L63:
        return;
    L7:
        r1 = null;
        goto L9
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r2);
        if (r2 == null) goto L5;
        int r0 = r2.orientation;
    L6:
        this.c = r0;
        this.d = r2;
        return;
    L5:
        r0 = 0;
        goto L6
    }
}
