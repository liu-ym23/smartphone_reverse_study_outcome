package com.bytedance.android.live.proxy;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.b0;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.log.filter.n0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.l0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.l;
import java.util.HashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mv0.x;
import mv0.y;
import mv0.z;
import ps0.b;
import qs0.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/proxy/SaasAdapterProxy;", "Lqs0/w;", "", "canShowDouYinIM", "Landroidx/fragment/app/Fragment;", "context", "Lcom/bytedance/android/live/base/model/user/b0;", "profileUser", "Lps0/b;", "room", "", "jumpToIM", "enableDiffProfileStyle", "Lmv0/x;", "imUseCase", "Lmv0/x;", "<init>", "()V", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaasAdapterProxy implements w {
    private final x imUseCase;

    @Override // qs0.w
    public boolean canShowDouYinIM() {
        int r0 = x.b;
        IHostDouyinIm r1 = TTLiveSDK.hostService().hostDouyinIm();
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L14:
        if (((Boolean) LiveConfigSettingKeys.SHOW_DOUYIN_IM_ENTRANCE.getValue()).booleanValue() == false) goto L19;
        if (r3 == true) goto L17;
        if (r2 == true) goto L17;
        return false;
    L17:
        return true;
    L19:
        return false;
    L10:
        if (r1.hasImInitFinishedWithoutAuth() != true) goto L12;
        r2 = true;
        goto L14
    L5:
        if (r1.isImSaasPluginInited() != true) goto L7;
        r3 = true;
        goto L8
    }

    @Override // qs0.w
    public boolean enableDiffProfileStyle() {
        return ((Boolean) LiveConfigSettingKeys.ENABLE_DCD_PROFILE_STYLE.getValue()).booleanValue();
    }

    public SaasAdapterProxy() {
        this.imUseCase = new x();
    }

    @Override // qs0.w
    public void jumpToIM(Fragment r12, b0 r13, b r14) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "profileUser");
        Intrinsics.checkNotNullParameter(r14, "room");
        x r3 = this.imUseCase;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r13, "profileUser");
        Intrinsics.checkNotNullParameter(r14, "room");
        IHostDouyinIm r5 = TTLiveSDK.hostService().hostDouyinIm();
        if (r5 != null) goto L5;
        f2.b(2131922977, 0);
        return;
    L5:
        z r9 = new z(r3, r12);
        HashMap r8 = new HashMap();
        IBaseUser r1 = r14.getOwner();
        String r2 = "";
        if (r1 == null) goto L9;
        String r4 = r1.getIdString();
        if (r4 == null) goto L9;
    L10:
        r8.put("anchor_id", r4);
        IBaseUser r15 = r14.getOwner();
        if (r15 == null) goto L16;
        String r16 = String.valueOf(r15.getLiveRoomId());
        if (r16 == null) goto L16;
        r2 = r16;
    L16:
        r8.put("room_id", r2);
        o r17 = u.l().c(am2.x.class);
        if ((r17 instanceof n0) == false) goto L20;
        r8.put("action_type", l0.a("action_type", r17));
        r8.put("enter_from", "room_homepage");
        r8.put("enter_from_merge", l0.a("enter_from_merge", r17));
        r8.put("enter_method", l0.a("enter_method", r17));
    L20:
        if (k.n(IUserService.class).user().isLogin() == true) goto L22;
        f r18 = k.n(IUserService.class).user();
        Context r6 = r12.getContext();
        l.a r7 = new l.a();
        r7.a = LiveResUtil.getString(2131917398);
        r7.d = "douyin_im";
        r7.c = 0;
        ((ObservableSubscribeProxy) r18.login(r6, new l(r7)).as(AutoDispose.bind(r12))).subscribe(new y(r5, r12, r13, r8, r9));
        return;
    L22:
        r5.openDouyinImHomePageToUser(r12.getContext(), r13.getBaseProfileInfo().getIdStr(), r8, r9);
        return;
    L9:
        r4 = "";
        goto L10
    }
}
