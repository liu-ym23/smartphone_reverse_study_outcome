package com.bytedance.android.live.profile.ui.component.view.button;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.profile.ui.component.view.ProfileButtonView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.vh;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import st0.b;
import ut0.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/view/button/ProfileSquareJumpTaRoomButtonView;", "Lcom/bytedance/android/live/profile/ui/component/view/ProfileButtonView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProfileSquareJumpTaRoomButtonView extends ProfileButtonView {
    public ProfileSquareJumpTaRoomButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ProfileSquareJumpTaRoomButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public ProfileSquareJumpTaRoomButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView, com.bytedance.android.live.profile.ui.component.base.e
    public final /* bridge */ /* synthetic */ void a(b r1, NewProfileUser r2, f r3) {
        h(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.profile.ui.component.view.ProfileButtonView
    public final void h(b r6, NewProfileUser r7, f r8) {
        Intrinsics.checkNotNullParameter(r6, Constants.Keys.DATA);
        Intrinsics.checkNotNullParameter(r7, "user");
        Intrinsics.checkNotNullParameter(r8, "logUseCase");
        super.h(r6, r7, r8);
        Map r9 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("anchor_id", r7.baseProfileInfo.getIdStr()), TuplesKt.to("room_id", String.valueOf(r7.getLiveRoomId()))});
        r9.put("pre_enter_from", "square_msg");
        vh r10 = r8.g();
        if (r10 != null) goto L5;
        return;
    L5:
        String r12 = r10.d();
        if (r12 == null) goto L16;
        Uri r13 = UriProtector.parse(r12);
        String r3 = UriProtector.getQueryParameter(r13, "enter_from_merge");
        String r4 = "";
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r9.put("enter_from_merge", r3);
        String r14 = UriProtector.getQueryParameter(r13, "enter_method");
        if (r14 == null) goto L14;
        r4 = r14;
    L14:
        r9.put("enter_method", r4);
    L16:
        if (r10.e() != true) goto L18;
        boolean r15 = true;
    L19:
        if (r15 == false) goto L21;
        String r16 = "audience_c_anchor";
    L22:
        r9.put("profile_card_target_scene", r16);
        j0.l().sendLog("livesdk_live_show", r9, new Object[]{x.class});
        return;
    L21:
        r16 = "audience_c_audience";
        goto L22
    L18:
        r15 = false;
        goto L19
    }

    public /* synthetic */ ProfileSquareJumpTaRoomButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
