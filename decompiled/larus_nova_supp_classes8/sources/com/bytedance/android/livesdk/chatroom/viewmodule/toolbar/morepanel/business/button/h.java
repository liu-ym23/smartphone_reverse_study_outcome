package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.button;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.b2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import com.bytedance.android.livesdk.config.e81;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.model.CommunityFoldFixConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.utils.ab.MoreMixSharePanelUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h extends e {
    public final void d() {
        WeakReference<b2> r0 = this.d.c();
        if (r0 == null) goto L8;
        b2 r1 = r0.get();
        if (r1 == null) goto L9;
        r1.c();
        return;
    L9:
        return;
    }

    public h(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s
    public final View x(ViewGroup r6, float r7, com.bytedance.android.livesdk.chatroom.e r8) {
        Intrinsics.checkNotNullParameter(r6, "parentView");
        if (r8 == null) goto L8;
        s r9 = r8.getCustomView();
        if (r9 == null) goto L8;
        return r9.x(r6, r7, null);
    L8:
        Context r10 = r6.getContext();
        MoreMixSharePanelUtils r0 = MoreMixSharePanelUtils.INSTANCE;
        boolean r1 = z.e(this.d.getDataCenter(), false);
        DataCenter r3 = this.d.getDataCenter();
        boolean r4 = true;
        if (r3 == null) goto L12;
        r4 = z.m(r3, true);
    L12:
        if (r0.isMoreMixShareMode(r1, r4) == false) goto L14;
        int r11 = UtilityKotlinExtentionsKt.i(76);
    L32:
        View r12 = LayoutInflater.from(r10).inflate(2131567634, r6, false);
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        r13.width = r11;
        r12.setLayoutParams(r13);
        return r12;
    L14:
        DataCenter r2 = this.d.getDataCenter();
        if (r2 == null) goto L19;
        Boolean r5 = (Boolean) r2.get("data_is_morepanel_average_width", Boolean.FALSE);
        if (r5 == null) goto L19;
        boolean r14 = r5.booleanValue();
    L21:
        if (PadConfigUtils.c() == false) goto L23;
    L30:
        float r15 = UIUtils.dip2Px(r10, 369.0f);
    L31:
        r11 = (int) (r15 / r7);
        goto L32
    L23:
        if (FoldScreenUtils.e() == true) goto L25;
    L27:
        if (r14 == false) goto L29;
        r7 = 5.0f;
    L29:
        r15 = s1.y() - UtilityKotlinExtentionsKt.i(6);
        goto L31
    L25:
        if (((CommunityFoldFixConfig) e81.b.getValue()).getEnableExperience() == false) goto L27;
    L19:
        r14 = false;
        goto L21
    }
}
