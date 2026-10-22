package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"onClick", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {1, 4, 3})
public final class Mp4EnhancedEnterPlayer$playAnim$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnimPlayer.a $animParams;
    final /* synthetic */ k32.a $msg;
    final /* synthetic */ ViewGroup $parentView;

    public Mp4EnhancedEnterPlayer$playAnim$4(AnimPlayer.a r1, ViewGroup r2, k32.a r3) {
        this.$animParams = r1;
        this.$parentView = r2;
        this.$msg = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m660invoke() {
        View.OnClickListener r0 = this.$animParams.c;
        if (r0 == null) goto L5;
        r0.onClick(this.$parentView);
    L5:
        RevenueUtils.b r1 = RevenueUtils.i;
        k32.a r2 = this.$msg;
        r1.getClass();
        RevenueUtils.b.f(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m660invoke();
        return Unit.INSTANCE;
    }
}
