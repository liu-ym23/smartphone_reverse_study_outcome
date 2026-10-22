package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.adapter.binding.SwitchSettingViewHolder;
import com.bytedance.android.live.broadcast.api.AskExplainSettingApi;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.interfaces.ListDialogAbility;
import kotlin.jvm.internal.Intrinsics;
import nz.a0;
import nz.b0;
import nz.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class AllowAudienceRequestExplainingProducts extends mx.l {
    public final Context p;
    public final ListDialogAbility q;

    public final Context getContext() {
        return this.p;
    }

    public AllowAudienceRequestExplainingProducts(Context r10, ListDialogAbility r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "ability");
        super(s1.B(2131918939), null, false, false, false, null, 126);
        this.p = r10;
        this.q = r11;
        FragmentActivity r12 = ContextUtil.contextToFragmentActivity(r10);
        if (r12 == null) goto L6;
        int r13 = a0.a;
        a0.a(r12, new AnonymousClass1(this), AnonymousClass2.INSTANCE);
        return;
    }

    public final void c(SwitchSettingViewHolder r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r5, "holder");
        ((mx.l) this).l = r6;
        FragmentActivity r7 = ContextUtil.contextToFragmentActivity(this.p);
        if (r7 == null) goto L6;
        int r0 = a0.a;
        AllowAudienceRequestExplainingProducts$onCheckStateChanged$1 r1 = AllowAudienceRequestExplainingProducts$onCheckStateChanged$1.INSTANCE;
        AllowAudienceRequestExplainingProducts$onCheckStateChanged$2 r2 = AllowAudienceRequestExplainingProducts$onCheckStateChanged$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r1, "onSuccess");
        Intrinsics.checkNotNullParameter(r2, "onFailure");
        ((ObservableSubscribeProxy) ((AskExplainSettingApi) com.bytedance.android.live.network.c.b().e(AskExplainSettingApi.class)).updateSetting(1, r6 ? 1 : 0).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r7))).subscribe(new b0(r1, r2), new c0(r2));
        return;
    }
}
